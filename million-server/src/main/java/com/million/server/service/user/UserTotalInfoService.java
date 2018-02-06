package com.million.server.service.user;

import com.million.dto.user.UserAnsHist;
import com.million.dto.user.UserTotalInfo;
import com.million.server.common.BaseService;
import com.million.server.mapper.user.UserAnsHistMapper;
import com.million.server.mapper.user.UserTotalInfoMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 查询用户活动汇总信息
 *
 * @author hxjian
 * @date 2018-01-30 10:34:48
 */
@Service
public class UserTotalInfoService extends BaseService<UserTotalInfoMapper,UserTotalInfo> {
    public List<UserTotalInfo> selectUserTotalInfo(UserTotalInfo userTotalInfo){
        return mapper.selectUserTotalInfo(userTotalInfo);
    }
}