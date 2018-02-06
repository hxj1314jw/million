package com.million.server.service.question;

import com.million.dto.question.ActQues;
import com.million.dto.question.Ques;
import com.million.server.mapper.question.ActQuesMapper;
import org.springframework.stereotype.Service;

import com.million.server.common.BaseService;

import java.util.List;

/**
 * 活动所选题库表
 *
 * @author hxjian
 * @date 2018-01-30 18:48:39
 */
@Service
public class ActQuesService extends BaseService<ActQuesMapper,ActQues> {
}