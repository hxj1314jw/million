package com.million.server.mapper.question;

import com.million.dto.question.QuestOpt;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * 题库选项表
 * 
 * @author hxjian
 * @date 2018-01-29 17:45:35
 */
@Repository
public interface QuestOptMapper extends Mapper<QuestOpt> {
	
}
