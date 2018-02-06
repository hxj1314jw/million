package com.million.server.mapper.user;

import com.million.dto.user.UserTotalInfo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 *  查询用户活动汇总信息
 * 
 * @author hxjian
 * @date 2018-01-30 09:46:16
 */
@Repository
public interface UserTotalInfoMapper extends Mapper<UserTotalInfo> {
    List<UserTotalInfo> selectUserTotalInfo(UserTotalInfo userTotalInfo);
}
