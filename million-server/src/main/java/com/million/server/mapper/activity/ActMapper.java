package com.million.server.mapper.activity;

import com.million.dto.activity.Act;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 活动信息表
 * 
 * @author hxjian
 * @date 2018-01-29 13:36:08
 */
@Repository
public interface ActMapper extends Mapper<Act> {
	List<Act> NextActList(@Param("id") String id);

	List<Act> LastActList(@Param("id") String id);

	List<Act> SelectActList(Act act);
}
