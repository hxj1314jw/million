package com.million.server.mapper.question;

import com.million.dto.question.ActQues;
import com.million.dto.question.Ques;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 活动所选题库表
 * 
 * @author hxjian
 * @date 2018-01-30 18:48:39
 */
@Repository
public interface ActQuesMapper extends Mapper<ActQues> {
}
