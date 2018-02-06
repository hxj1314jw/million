package com.million.server.mapper.user;
import com.million.dto.user.UserAnsHist;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 用户答题记录表
 * 
 * @author hxjian
 * @date 2018-01-30 10:34:48
 */
@Repository
public interface UserAnsHistMapper extends Mapper<UserAnsHist> {
    List<UserAnsHist> selectUserAnswerInfo(UserAnsHist userAnsHist);
}
