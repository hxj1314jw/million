package com.million.server.service.card;

import com.million.dto.card.RevivalCardHist;
import com.million.server.mapper.card.RevivalCardHistMapper;
import org.springframework.stereotype.Service;

import com.million.server.common.BaseService;

import java.util.List;

/**
 * 复活卡使用记录表
 *
 * @author hxjian
 * @date 2018-01-30 11:36:34
 */
@Service
public class RevivalCardHistService extends BaseService<RevivalCardHistMapper,RevivalCardHist> {
    public List<RevivalCardHist> selectRevialCardUsedInfoByUserId(RevivalCardHist revivalCardHist){
        return mapper.selectRevialCardUsedInfoByUserId(revivalCardHist);
    }
}