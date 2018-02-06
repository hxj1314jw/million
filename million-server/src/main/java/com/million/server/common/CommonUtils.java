package com.million.server.common;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;

/**
 * Created with IntelliJ IDEA
 * User: huangxj
 * DATE: 2018/1/29 10:40
 * Description:
 */
@Component
public class CommonUtils {

    @Autowired
    private Environment env;


    /**
     * 获取本地IP
     *
     * @return IP地址
     */
    public String getIpAddress() {
        String host = null;
        try {
            host = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            host = "0.0.0.0";
        }
        return host +":"+ env.getProperty("server.port");
    }

    /**
     * bean to map
     *
     * @param bean
     * @param <T>
     * @return
     */
    public <T> Map<String, Object> beanToMap(T bean) {
        Map<String, Object> map = Maps.newHashMap();
        if (bean != null) {
            BeanMap beanMap = BeanMap.create(bean);
            for (Object key : beanMap.keySet()) {
                map.put(key + "", beanMap.get(key));
            }
        }
        return map;
    }

    /**
     * 判断入参是否缺少
     *
     * @param jsonObject
     * @param args
     * @return
     */
    public String validateParams(JSONObject jsonObject, String... args) {
        for (String arg : args) {
            if (!jsonObject.containsKey(arg))
                return arg + "is not present";
        }
        return null;
    }

    /**
     * 参数完整性检验
     *
     * @param
     * @param args
     * @throws
     */
    public static void checkParamComplete(HttpServletRequest request,String... args) throws Exception{
        for (String arg :args) {
            if (null == request.getParameter(arg) || "".equals(request.getParameter(arg)))
            throw new Exception("参数错误:" + arg + "字段不能为空");
        }
    }

    /**
     * 获取客户端IP
     *
     * @param request
     * @return
     */
    public static String getIp(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
            //多次反向代理后会有多个ip值，第一个ip才是真实ip
            int index = ip.indexOf(",");
            if (index != -1) {
                return ip.substring(0, index);
            } else {
                return ip;
            }
        }
        ip = request.getHeader("X-Real-IP");
        if (StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
            return ip;
        }
        return request.getRemoteAddr();
    }
}
