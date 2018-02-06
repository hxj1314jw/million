package com.million.server.controller.card;

import com.million.dto.card.RevivalCard;
import com.million.dto.card.RevivalCardHist;
import com.million.server.common.annotation.InsertLog;
import com.million.server.common.response.BaseResponse;
import com.million.server.service.card.RevivalCardHistService;
import com.million.server.service.card.RevivalCardService;
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
public class CardController {

    @Autowired
    private RevivalCardService revivalCardService;
    @Autowired
    private RevivalCardHistService revivalCardHistService;


    @ApiOperation(value = "查询复活卡使用明细信息", notes = "查询复活卡使用明细信息")
    @RequestMapping(value = "/M100012", method = RequestMethod.POST)
    @ResponseBody
    @InsertLog
    public BaseResponse M100012(HttpServletRequest request){
        String user_id = request.getParameter("user_id");
        RevivalCardHist revivalCardHist=new RevivalCardHist();
        revivalCardHist.setUser_id(user_id);
        return new BaseResponse(revivalCardHistService.selectRevialCardUsedInfoByUserId(revivalCardHist));
    }

    @ApiOperation(value = "查询用户复活卡信息", notes = "查询用户复活卡信息")
    @RequestMapping(value = "/M100013", method = RequestMethod.POST)
    @ResponseBody
    @InsertLog
    public BaseResponse M100013(HttpServletRequest request){
        String user_id = request.getParameter("user_id");
        RevivalCard revivalCard=new RevivalCard();
        revivalCard.setUser_id(user_id);
        return new BaseResponse(revivalCardService.selectRevialCardInfoByUserId(revivalCard));
    }

}
