package com.million.server.mapper.card;

import com.million.dto.card.RevivalCardHist;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 复活卡使用记录表
 * 
 * @author hxjian
 * @date 2018-01-30 11:36:34
 */
@Repository
public interface RevivalCardHistMapper extends Mapper<RevivalCardHist> {
    //查询复活卡使用明细信息
    List<RevivalCardHist> selectRevialCardUsedInfoByUserId(RevivalCardHist revivalCardHist);

}
