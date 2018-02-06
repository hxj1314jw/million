package com.million.server.common.interceptor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.million.common.constants.CommonConstants;
import com.million.server.common.CommonUtils;
import com.million.server.common.exception.BaseException;
import com.million.server.common.response.BaseResponse;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA
 * User: huangxj
 * DATE: 2018/1/31 13:48
 * Description:
 */
public class LoginInterceptor implements HandlerInterceptor {
    private final Logger logger = LoggerFactory.getLogger(HandlerInterceptor.class);

    /**
     * 在请求处理之前进行调用（Controller方法调用之前）
     *
     * @param httpServletRequest  httpServletRequest
     * @param httpServletResponse httpServletResponse
     * @param o
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        logger.info("客户端IP地址：" + CommonUtils.getIp(httpServletRequest));
        logger.info("sessionId："+httpServletRequest.getSession().getId());
        if (!StringUtils.isNotEmpty((String) httpServletRequest.getSession().getAttribute(CommonConstants.SESSION_KEY))) {
            BaseResponse baseResponse = new BaseResponse();
            baseResponse.setCode(100);
            baseResponse.setStatus(0);
            baseResponse.setMessage("未登录");
            String json = JSON.toJSONString(baseResponse);
            httpServletResponse.setCharacterEncoding("UTF-8");
            httpServletResponse.setContentType("application/json; charset=utf-8");
            httpServletResponse.getWriter().write(json);
            httpServletResponse.flushBuffer();
            return false;
        }
        return true;
    }

    /**
     * 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    }

    /**
     * 在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        String pass_word = (String) httpServletRequest.getSession().getAttribute(CommonConstants.SESSION_KEY);
        logger.info("{user=" + pass_word + "}>>>END HTTP REQUEST:" + httpServletRequest.getRequestURL());
    }
}
