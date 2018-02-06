package com.million.dto.card;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.Date;

/**
 * 复活卡使用记录表
 * @author hxjian
 * @date 2018-01-30 11:36:34
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("复活卡使用记录表")
public class RevivalCardHist implements Serializable {
	private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    private Integer ID;

    @ApiModelProperty(value = "用户ID")
    private String user_id;

    @ApiModelProperty(value = "复活卡号")
    private String card_no;

    @ApiModelProperty(value = "活动ID")
    private String act_id;

    @ApiModelProperty(value = "题目ID")
    private Integer ques_id;

    @ApiModelProperty(value = "创建时间")
    private Date created_time;

    @ApiModelProperty(value = "更新时间")
    private Date modified_time;


}
