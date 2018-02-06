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
 * 复活卡表
 * @author hxjian
 * @date 2018-01-30 10:57:39
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("复活卡表")
public class RevivalCard implements Serializable {
	private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    private Integer ID;

    @ApiModelProperty(value = "用户ID")
    private String user_id;

    @ApiModelProperty(value = "复活卡号")
    private String card_no;

    @ApiModelProperty(value = "0:未使用1：已使用")
    private String status;

    @ApiModelProperty(value = "创建时间")
    private Date created_time;

    @ApiModelProperty(value = "更新时间")
    private Date modified_time;


}
