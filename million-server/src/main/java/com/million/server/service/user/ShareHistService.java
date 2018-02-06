package com.million.server.service.user;

import com.million.dto.user.ShareHist;
import com.million.server.mapper.user.ShareHistMapper;
import org.springframework.stereotype.Service;


import com.million.server.common.BaseService;

import java.util.List;

/**
 * 分享记录表
 *
 * @author hxjian
 * @date 2018-01-30 14:18:12
 */
@Service
public class ShareHistService extends BaseService<ShareHistMapper,ShareHist> {
    public List<ShareHist> selectShareRecordByUserId(ShareHist shareHist){
        return mapper.selectShareRecordByUserId(shareHist);
    }
}