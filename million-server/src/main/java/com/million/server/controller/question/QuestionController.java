package com.million.server.controller.question;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.million.dto.question.ActQues;
import com.million.dto.question.Ques;
import com.million.dto.question.QuesList;
import com.million.dto.question.QuestOpt;
import com.million.server.common.CommonUtils;
import com.million.server.common.response.BaseResponse;
import com.million.server.service.question.ActQuesService;
import com.million.server.service.question.QuesService;
import com.million.server.service.question.QuestOptService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 * User: huangxj
 * DATE: 2018/1/29 17:25
 * Description:
 */
@Slf4j
@RestController
public class QuestionController {
    @Autowired
    private QuesService quesService;
    @Autowired
    private QuestOptService questOptService;
    @Autowired
    private ActQuesService actQuesService;

    @ApiOperation(value = "题库一览", notes = "题库一览一个问题只能用于一个活动")
    @RequestMapping(value = "/M100006", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse M100006(HttpServletRequest request) {
        String act_id =request.getParameter("act_id");//活动id
        List<QuesList> list = new ArrayList<>();
        List<Ques> quesList = quesService.quesList(act_id);
        List<QuestOpt> questOpts = questOptService.selectListAll();
        if (quesList.size() > 0) {
            for (Ques ques : quesList) {
                QuesList quesList1 = new QuesList();
                List<QuestOpt> questOpts1 = new ArrayList<>();
                if (questOpts.size() > 0) {
                    for (QuestOpt questOpt : questOpts) {
                        if (ques.getId().equals(questOpt.getQues_id())) {
                            questOpts1.add(questOpt);
                        }
                    }
                }
                quesList1.setModified_time(ques.getModified_time());
                quesList1.setId(ques.getId());
                quesList1.setCreated_time(ques.getCreated_time());
                quesList1.setQues_type(ques.getQues_type());
                quesList1.setAnswer(ques.getAnswer());
                quesList1.setQues_analysis(ques.getQues_analysis());
                quesList1.setAval_status(ques.getAval_status());
                quesList1.setQues_desc(ques.getQues_desc());
                quesList1.setRed_packet(ques.getRed_packet());
                quesList1.setAct_id(ques.getAct_id());
                quesList1.setQuest_opt_list(questOpts1);
                quesList1.setOpt_desc(ques.getOpt_desc());
                list.add(quesList1);
            }
        }
        return new BaseResponse(list);
    }

    @ApiOperation(value = "修改题目", notes = "修改题目")
    @RequestMapping(value = "/M100007", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse M100007(HttpServletRequest request){
        String id = request.getParameter("id");//题库表id
        String ques_desc = request.getParameter("ques_desc");//问题描述
        String ques_analysis = request.getParameter("ques_analysis");//问题解读
        String answer = request.getParameter("answer");//问题答案(即选项标识)
        String aval_status = request.getParameter("aval_status");//可用状态(1:可用 0:不可用)
        String red_packet = request.getParameter("red_packet");//是否红包题 1：是 0：否
        String ques_type = request.getParameter("ques_type");//问题类型（1：百科2：财经3：投教）
        String opt_id = request.getParameter("opt_id");//题库选项表问题ID
        String opt_desc = request.getParameter("opt_desc");//题库选项表 选项描述
        String ques_id = request.getParameter("quest_opt_id");//题库选项表 主键
        Ques ques = new Ques();
        ques.setId(Integer.parseInt(id));
        ques.setQues_desc(ques_desc);
        ques.setAnswer(answer);
        ques.setQues_analysis(ques_analysis);
        ques.setAval_status(aval_status);
        ques.setRed_packet(red_packet);
        ques.setQues_type(ques_type);
        ques.setModified_time(new Date());
        quesService.updateSelectiveById(ques);
        //如果没有传题库选项表主键id则不更新
        if(ques_id!=null&!"".equals(ques_id)){
            QuestOpt questOpt = new QuestOpt();
            questOpt.setId(Integer.parseInt(ques_id));
            questOpt.setOpt_id(opt_id);
            questOpt.setOpt_desc(opt_desc);
            questOpt.setModified_time(new Date());
            questOptService.updateSelectiveById(questOpt);
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status","1");
        jsonObject.put("message","");
        return new BaseResponse(jsonObject);
    }

    @ApiOperation(value = "删除题目", notes = "删除所选题目，题目选项表也删除")
    @RequestMapping(value = "/M100008", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse M100008(HttpServletRequest request){
        String id = request.getParameter("id");//题库表id
        quesService.deleteById(Integer.parseInt(id));
        QuestOpt questOpt = new QuestOpt();
        questOpt.setQues_id(Integer.parseInt(id));
        questOptService.delete(questOpt);
        ActQues actQues = new ActQues();
        actQues.setQues_id(Integer.parseInt(id));
        actQuesService.delete(actQues);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status","1");
        jsonObject.put("message","");
        return new BaseResponse(jsonObject);
    }

    @ApiOperation(value = "活动题库选择", notes = "活动题库选择")
    @RequestMapping(value = "/M100016", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse M100016(HttpServletRequest request)throws Exception{
        String act_id = request.getParameter("act_id");//活动id
        String ques_id = request.getParameter("ques_id");//题库表id
        String sort = request.getParameter("sort");//题库顺序
        ActQues actQues = new ActQues();
        //校验参数不能为空
        CommonUtils.checkParamComplete(request,"act_id","ques_id","sort");
        actQues.setAct_id(act_id);
        actQues.setQues_id(Integer.parseInt(ques_id));
        actQues.setSort(Integer.parseInt(sort));
        actQuesService.insertSelective(actQues);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status","1");
        jsonObject.put("message","");
        return new BaseResponse(jsonObject);
    }

    @ApiOperation(value = "新增题库", notes = "新增题库")
    @RequestMapping(value = "/M100017", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse M100017(HttpServletRequest request)throws Exception{
        // 题库表(ques)
        System.out.println("******* " + request.getParameter("quest_opt_list"));
        CommonUtils.checkParamComplete(request,"quest_opt_list");
        String ques_desc = request.getParameter("ques_desc");//问题描述
        String ques_analysis = request.getParameter("ques_analysis");//问题解读
        String answer = request.getParameter("answer");//问题答案(即选项标识)
        String aval_status = request.getParameter("aval_status");//可用状态(1:可用 0:不可用)
        String red_packet = request.getParameter("red_packet");//是否红包题 1：是 0：否
        String ques_type = request.getParameter("ques_type");//问题类型（1：百科2：财经3：投教）
        Ques ques = new Ques();
        ques.setRed_packet(red_packet);
        ques.setQues_desc(ques_desc);
        ques.setQues_analysis(ques_analysis);
        ques.setAnswer(answer);
        ques.setAval_status(aval_status);
        ques.setQues_type(ques_type);
        quesService.insertQues(ques);
        // 题库选项表(quest_opt)
        List<QuestOpt> questOptList = new ArrayList<>();
        try{
            String quest_opt_list = request.getParameter("quest_opt_list");
            questOptList = JSONObject.parseArray(quest_opt_list, QuestOpt.class);
            //循环插入时间
            for(QuestOpt questOpt:questOptList){
                questOpt.setQues_id(ques.getId());
                questOpt.setModified_time(new Date());
                questOpt.setCreated_time(new Date());
                questOptService.insertSelective(questOpt);
            }
        }catch (Exception e){
            //有异常则将此次操作数据删除
            QuestOpt questOpt = new QuestOpt();
            questOpt.setQues_id(ques.getId());
            quesService.deleteById(ques.getId());
            questOptService.delete(questOpt);
            log.error(e.getMessage());
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status","1");
        jsonObject.put("message","");
        return new BaseResponse(jsonObject);
    }
}
