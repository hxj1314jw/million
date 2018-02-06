package com.million.server.controller.user;

import com.alibaba.fastjson.JSONObject;
import com.million.dto.user.ShareHist;
import com.million.dto.user.UserActHist;
import com.million.dto.user.UserAnsHist;
import com.million.dto.user.UserTotalInfo;
import com.million.server.common.annotation.InsertLog;
import com.million.server.common.response.BaseResponse;
import com.million.server.service.user.ShareHistService;
import com.million.server.service.user.UserActHistService;
import com.million.server.service.user.UserAnsHistService;
import com.million.server.service.user.UserTotalInfoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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
public class UserController {

    @Autowired
    private UserActHistService userActHistService;
    @Autowired
    private UserAnsHistService userAnsHistService;
    @Autowired
    private ShareHistService shareHistService;
    @Autowired
    private UserTotalInfoService userTotalInfoService;

    @ApiOperation(value = "查询用户活动汇总信息", notes = "查询用户活动汇总信息")
    @RequestMapping(value = "/M100009", method = RequestMethod.POST)
    @ResponseBody
    @InsertLog
    public BaseResponse M100009(HttpServletRequest request){
        String user_id = request.getParameter("user_id");
        String user_mobile = request.getParameter("user_mobile");
        UserTotalInfo userTotalInfo=new UserTotalInfo();
        userTotalInfo.setUser_id(user_id);
        userTotalInfo.setUser_mobile(user_mobile);
        return new BaseResponse(userTotalInfoService.selectUserTotalInfo(userTotalInfo));
    }

    @ApiOperation(value = "用户参与明细信息", notes = "查询用户参与明细信息")
    @RequestMapping(value = "/M100010", method = RequestMethod.POST)
    @ResponseBody
    @InsertLog
    public BaseResponse M000001(HttpServletRequest request){
        String user_id = request.getParameter("user_id");
        String user_mobile = request.getParameter("user_mobile");
        String act_id = request.getParameter("act_id");
        UserActHist userActHist=new UserActHist();
        userActHist.setUser_id(user_id);
        userActHist.setUser_mobile(user_mobile);
        userActHist.setAct_id(act_id);
        return new BaseResponse(userActHistService.selectUserJoinInfo(userActHist));
    }

    @ApiOperation(value = "查询用户答题明细信息", notes = "查询用户答题明细信息")
    @RequestMapping(value = "/M100011", method = RequestMethod.POST)
    @ResponseBody
    @InsertLog
    public BaseResponse M100011(HttpServletRequest request){
        String user_id = request.getParameter("user_id");
        String act_id = request.getParameter("act_id");
        UserAnsHist userAnsHist=new UserAnsHist();
        userAnsHist.setUser_id(user_id);
        userAnsHist.setAct_id(act_id);
        return new BaseResponse(userAnsHistService.selectUserAnswerInfo(userAnsHist));
    }

    @ApiOperation(value = "查询分享明细信息", notes = "查询分享明细信息")
    @RequestMapping(value = "/M100014", method = RequestMethod.POST)
    @ResponseBody
    @InsertLog
    public BaseResponse M100014(HttpServletRequest request){
        String user_id = request.getParameter("user_id");
        ShareHist shareHist=new ShareHist();
        shareHist.setUser_id(user_id);
        return new BaseResponse(shareHistService.selectShareRecordByUserId(shareHist));
    }

}
