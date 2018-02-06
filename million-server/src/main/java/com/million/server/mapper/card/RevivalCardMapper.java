package com.million.server.mapper.card;


import com.million.dto.card.RevivalCard;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 复活卡表
 * 
 * @author hxjian
 * @date 2018-01-30 10:57:39
 */
@Repository
public interface RevivalCardMapper extends Mapper<RevivalCard> {
	List<RevivalCard> selectRevialCardInfoByUserId(RevivalCard revivalCard);
}
