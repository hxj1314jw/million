package com.million.server.config.aop;

import com.alibaba.fastjson.JSONObject;
import com.million.dto.log.InterfaceLog;
import com.million.server.common.CommonUtils;
import com.million.server.common.annotation.InsertLog;
import com.million.server.common.exception.BaseException;
import com.million.server.common.response.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA
 * User: huangxj
 * DATE: 2018/1/29 10:40
 * Description:
 */
@Aspect
@Component
@Slf4j
public class ApiAspect {

    @Autowired
    private CommonUtils commonUtils;
    //用来计算消耗时间
    ThreadLocal<Long> time = new ThreadLocal<Long>();
    //切面
    @Pointcut("execution(* com.million.server.controller.*.*.*(..))")
    public void allMethod() {
    }

    //前置
    @Before("allMethod()")
    public void beforeExec(JoinPoint joinPoint) {
    }

    //环绕
    @Around("allMethod()")
    public Object aroundExec(ProceedingJoinPoint joinPoint){
        time.set(System.currentTimeMillis());
        String ip = commonUtils.getIpAddress();   //IP地址
        System.out.println("服务器IP地址： "+ip);

        MethodSignature ms = (MethodSignature) joinPoint.getSignature();
        Method method = ms.getMethod();
        BaseResponse result = null;
        try {
            result = (BaseResponse) joinPoint.proceed();
        }catch (Throwable e){
            log.error(ExceptionUtils.getFullStackTrace(e));
            if (e instanceof BaseException) {
                BaseException baseException = (BaseException) e;
                result = new BaseResponse(baseException.getBaseResponseCode());
            }
            else result = new BaseResponse(e);
            System.out.println(e.getMessage());;
        }
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        System.out.println("客户端IP地址："+commonUtils.getIp(request));
        String param = JSONObject.toJSONString(request.getParameterMap());  //入参
        String functionId = method.getAnnotation(RequestMapping.class).name(); //功能号
        InsertLog insertLog = method.getAnnotation(InsertLog.class);
        long slot = System.currentTimeMillis();
        String uuid = UUID.randomUUID().toString();
        result.setUuid(uuid);
        InterfaceLog interfaceLog = new InterfaceLog(uuid, ip, functionId, slot, param, JSONObject.toJSONString(result), result.getStatus() + "");
        //if (null != insertLog)
            //asyncTasks.insertLog(interfaceLog);
        return result;
    }

    //后置通知器
    @After("allMethod()")
    public void afterExec(JoinPoint joinPoint) {
    }

}
