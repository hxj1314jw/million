package com.million.server.service.user;

import com.million.dto.user.UserAnsHist;
import com.million.server.mapper.user.UserAnsHistMapper;
import org.springframework.stereotype.Service;

import com.million.server.common.BaseService;

import java.util.List;

/**
 * 用户答题记录表
 *
 * @author hxjian
 * @date 2018-01-30 10:34:48
 */
@Service
public class UserAnsHistService extends BaseService<UserAnsHistMapper,UserAnsHist> {
    public List<UserAnsHist> selectUserAnswerInfo(UserAnsHist userAnsHist){
        return mapper.selectUserAnswerInfo(userAnsHist);
    }
}