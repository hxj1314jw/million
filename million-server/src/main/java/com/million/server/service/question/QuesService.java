package com.million.server.service.question;

import org.springframework.stereotype.Service;

import com.million.dto.question.Ques;
import com.million.server.mapper.question.QuesMapper;
import com.million.server.common.BaseService;

import java.util.List;

/**
 * 题库表
 *
 * @author hxjian
 * @date 2018-01-29 17:34:19
 */
@Service
public class QuesService extends BaseService<QuesMapper,Ques> {
    public List<Ques> quesList(String act_id){
        return mapper.quesList(act_id);
    }

    public Integer insertQues(Ques ques){
        return mapper.insertQues(ques);
    }
}