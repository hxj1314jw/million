package com.million.server.mapper.question;

import com.million.dto.question.Ques;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 题库表
 * 
 * @author hxjian
 * @date 2018-01-29 17:34:19
 */
@Repository
public interface QuesMapper extends Mapper<Ques> {
    List<Ques> quesList(@Param("act_id") String act_id);

    Integer insertQues (Ques ques);
}
