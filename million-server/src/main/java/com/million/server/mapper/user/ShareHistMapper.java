package com.million.server.mapper.user;

import com.million.dto.user.ShareHist;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 分享记录表
 * 
 * @author hxjian
 * @date 2018-01-30 14:18:12
 */
@Repository
public interface ShareHistMapper extends Mapper<ShareHist> {
    List<ShareHist> selectShareRecordByUserId(ShareHist shareHist);
}
