package com.million.server.service.activity;

import com.million.dto.activity.Act;
import com.million.server.common.BaseService;
import com.million.server.mapper.activity.ActMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 活动信息表
 * @author hxjian
 * @date 2018-01-29 13:36:08
 */
@Service
public class ActService extends BaseService<ActMapper,Act> {

   public List<Act> NextActList(String id){
       return mapper.NextActList(id);
   }

    public List<Act> LastActList(String id){
        return mapper.LastActList(id);
    }

    public List<Act> SelectActList(Act act){
        return mapper.SelectActList(act);
    }
}