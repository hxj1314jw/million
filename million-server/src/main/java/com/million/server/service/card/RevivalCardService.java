package com.million.server.service.card;

import com.million.dto.card.RevivalCard;
import org.springframework.stereotype.Service;
import com.million.server.mapper.card.RevivalCardMapper;
import com.million.server.common.BaseService;

import java.util.List;

/**
 * 复活卡表
 *
 * @author hxjian
 * @date 2018-01-30 10:57:39
 */
@Service
public class RevivalCardService extends BaseService<RevivalCardMapper,RevivalCard> {
    public List<RevivalCard> selectRevialCardInfoByUserId(RevivalCard revivalCard){
        return mapper.selectRevialCardInfoByUserId(revivalCard);
    }
}