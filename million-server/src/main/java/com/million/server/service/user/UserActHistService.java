package com.million.server.service.user;

import com.million.dto.user.UserActHist;
import com.million.server.mapper.user.UserActHistMapper;
import org.springframework.stereotype.Service;

import com.million.server.common.BaseService;

import java.util.List;

/**
 * 用户参与活动记录表
 *
 * @author hxjian
 * @date 2018-01-30 09:46:16
 */
@Service
public class UserActHistService extends BaseService<UserActHistMapper,UserActHist> {

    public List<UserActHist> selectUserJoinInfo(UserActHist userActHist){
        return mapper.selectUserJoinInfo(userActHist);
    }

}