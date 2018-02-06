package com.million.server.controller.login;

import com.alibaba.fastjson.JSONObject;
import com.million.common.constants.CommonConstants;
import com.million.server.common.annotation.InsertLog;
import com.million.server.common.exception.BaseException;
import com.million.server.common.response.BaseResponse;
import com.million.server.common.response.BaseResponseCode;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA
 * User: huangxj
 * DATE: 2018/1/29 11:29
 * Description:
 */
@RestController
public class LoginController {

    @ApiOperation(value = "登录", notes = "root用户登录直接返回成功")
    @RequestMapping(value = "/M000001", method = RequestMethod.POST)
    @ResponseBody
    @InsertLog
    public BaseResponse M000001(HttpServletRequest request) throws Exception {
        JSONObject jsonObject = new JSONObject();
        String user_name = request.getParameter("user_name");
        String pass_word = request.getParameter("pass_word");
        if ("root".equals(user_name) && "root".equals(pass_word)) {
            jsonObject.put("status", "1");
            jsonObject.put("message", "登录成功");
            //设置session
            request.getSession().setAttribute(CommonConstants.SESSION_KEY, user_name);
            System.out.println("登录之后sessionID："+request.getSession().getId());
            System.out.println("********** " + request.getSession().getAttribute(CommonConstants.SESSION_KEY));
            return new BaseResponse(jsonObject);
        } else {
            throw new BaseException(BaseResponseCode.TOKEN_FAIL_CREATE);
        }
    }

}
