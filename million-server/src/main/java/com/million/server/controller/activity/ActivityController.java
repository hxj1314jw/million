package com.million.server.controller.activity;

import com.alibaba.fastjson.JSONObject;
import com.million.dto.activity.Act;
import com.million.server.common.CommonUtils;
import com.million.server.common.Utils.DateUtil;
import com.million.server.common.annotation.InsertLog;
import com.million.server.common.exception.BaseException;
import com.million.server.common.response.BaseResponse;
import com.million.server.common.response.BaseResponseCode;
import com.million.server.service.activity.ActService;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Id;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created with IntelliJ IDEA
 * User: huangxj
 * DATE: 2018/1/29 13:19
 * Description:
 */
@RestController
public class ActivityController {
    @Autowired
    private  ActService actService;

    @ApiOperation(value = "查询下一场活动信息", notes = "根据当前日期和时间，活动状态来判断下一场次")
    @RequestMapping(value = "/M100001", method = RequestMethod.POST)
    @ResponseBody
    @InsertLog //此注解加上则插日志
    public BaseResponse M100001(HttpServletRequest request)throws Exception{
        String id = request.getParameter("id");//活动id
        return new BaseResponse(actService.NextActList(id));
    }

    @ApiOperation(value = "查询上一场活动信息", notes = "根据当前日期和时间，活动状态来判断上一场次")
    @RequestMapping(value = "/M100002", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse M100002(HttpServletRequest request)throws Exception{
        String id = request.getParameter("id");//活动id
        return new BaseResponse(actService.LastActList(id));
    }

    @ApiOperation(value = "查询活动场次信息", notes = "查询活动场次信息,按时间倒序")
    @RequestMapping(value = "/M100003", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse M100003(HttpServletRequest request)throws Exception{
        String act_time = request.getParameter("act_time");
        String act_status = request.getParameter("act_status");
        Act act = new Act();
        act.setAct_status(act_status);
        act.setAct_time(act_time);
        return new BaseResponse(actService.SelectActList(act));
    }

    @ApiOperation(value = "新增活动", notes = "新增加活动场次信息")
    @RequestMapping(value = "/M100004", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse M100004(HttpServletRequest request) throws Exception{
        JSONObject jsonObject = new JSONObject();
        String act_time = request.getParameter("act_time");//活动时间
        String act_status = request.getParameter("act_status");//活动状态
        String regu_score = request.getParameter("regu_score");//普通积分
        String red_score = request.getParameter("red_score");//红包积分
        String allow_cnt = request.getParameter("allow_cnt");//可参与答题人数
        Act act = new Act();
        act.setAct_status(act_status);
        act.setAct_time(act_time);
        act.setRegu_score(Integer.parseInt(regu_score));
        act.setRed_score(Integer.parseInt(red_score));
        act.setAllow_cnt(Integer.parseInt(allow_cnt));
        act.setModified_time(new Date());
        act.setCreated_time(new Date());
        actService.insertSelective(act);
        jsonObject.put("status","1");
        jsonObject.put("message","");
        return new BaseResponse(jsonObject);
    }

    @ApiOperation(value = "修改活动信息", notes = "修改活动信息（积分设置、日期设置）")
    @RequestMapping(value = "/M100005", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse M100005(HttpServletRequest request) throws Exception{
        JSONObject jsonObject = new JSONObject();
        String id = request.getParameter("id");//活动主键
        String op_type = request.getParameter("op_type");//活动类型  1：积分设置  2：日期设置  3：题库设置
        //参数校验
        CommonUtils.checkParamComplete(request,"id","op_type");
        String act_time = request.getParameter("act_time");//活动时间
        String act_status = request.getParameter("act_status");//活动状态
        String regu_score = request.getParameter("regu_score");//普通积分
        String red_score = request.getParameter("red_score");//红包积分
        Act act = new Act();
        act.setId(Integer.parseInt(id));
        if(op_type.equals("2")){
            act.setAct_time(act_time);
        }
        if(op_type.equals("1")){
            act.setAct_time(null);
            act.setRegu_score(Integer.parseInt(regu_score));
            act.setRed_score(Integer.parseInt(red_score));
        }
        act.setModified_time(new Date());
        actService.updateSelectiveById(act);
        jsonObject.put("status","1");
        jsonObject.put("message","");
        return new BaseResponse(jsonObject);
    }

}
