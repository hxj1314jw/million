package com.million.dto.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户参与活动记录表
 * @author hxjian
 * @date 2018-01-30 09:46:16
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("用户参与活动记录表")
public class UserTotalInfo implements Serializable {
	private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户ID")
    private String user_id;

    @ApiModelProperty(value = "用户注册手机号")
    private String user_mobile;

    @ApiModelProperty(value = "参与总场次")
    private Integer join_cnt;

    @ApiModelProperty(value = "通过场次")
    private Integer succ_cnt;

    @ApiModelProperty(value = "失败场次")
    private Integer fail_cnt;

    @ApiModelProperty(value = "获得普通积分总数")
    private Integer rev_regu_total;

    @ApiModelProperty(value = "获得红包积分总数")
    private Integer rev_red_total;

    @ApiModelProperty(value = "复活卡总数")
    private Integer revival_total;

    @ApiModelProperty(value = "复活卡使用次数")
    private Integer use_revival;

    @ApiModelProperty(value = "复活卡剩余次数")
    private Integer res_revival;


}
