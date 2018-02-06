package com.million.server.mapper.user;


import com.million.dto.user.UserActHist;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 用户参与活动记录表
 * 
 * @author hxjian
 * @date 2018-01-30 09:46:16
 */
@Repository
public interface UserActHistMapper extends Mapper<UserActHist> {
    List<UserActHist> selectUserJoinInfo(UserActHist userActHist);
}
