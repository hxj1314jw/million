package com.million.server.controller;

import com.million.server.common.response.BaseResponse;
import com.million.server.config.cache.RedisKeys;
import com.million.server.config.cache.RedisService;
import com.million.server.service.test.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA
 * User: huangxj
 * DATE: 2018/1/26 10:28
 * Description:
 */
@RestController
public class Test {
    @Autowired
    private TestService testService;
    @Autowired
    private RedisService redisService;

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    @ResponseBody
    @Cacheable(value = RedisKeys.tokenExpire,key = "'aaaa'")
    public String mapTest(HttpServletRequest request) {
        System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
        return testService.selectListAll().toString();
    }

    @RequestMapping(value = "/test1", method = RequestMethod.POST)
    @ResponseBody
    public String Test(HttpServletRequest request) {
        if(redisService.get("bbbb")!=null){
            return  redisService.get("bbbb").toString();
        }
        redisService.put("bbbb",testService.selectListAll(),1200l);
        System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
        return testService.selectListAll().toString();
    }

    @RequestMapping(value = "/test2", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse Test2(HttpServletRequest request) {
        if(redisService.get("bbbb")!=null){
            return  new BaseResponse(redisService.get("bbbb").toString());
        }
        redisService.put("bbbb",testService.selectListAll(),1200l);
        System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
        return new BaseResponse(testService.selectListAll().toString());
    }
}
