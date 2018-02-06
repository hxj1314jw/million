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
public class UserActHist implements Serializable {
	private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    private Integer id;

    @ApiModelProperty(value = "用户ID")
    private String user_id;

    @ApiModelProperty(value = "用户注册手机号")
    private String user_mobile;

    @ApiModelProperty(value = "活动ID")
    private String act_id;

    @ApiModelProperty(value = "用户状态(1:参与中, 2:已淘汰, 3:围观, 4:退出 5:已结束)")
    private String attend_status;

    @ApiModelProperty(value = "本次活动答对的题数")
    private Integer corrent_cnt;

    @ApiModelProperty(value = "本次活动获得的积分")
    private Integer gained_score;

    @ApiModelProperty(value = "创建时间")
    private Date created_time;

    @ApiModelProperty(value = "更新时间")
    private Date modified_time;


}
