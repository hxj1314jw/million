package com.million.dto.activity;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * 活动信息表
 *
 * @author hxjian
 * @date 2018-01-29 15:26:06
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("活动信息表")
public class Act implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @ApiModelProperty(value = "主键")
    private Integer id;

    @ApiModelProperty(value = "活动时间")
    private String act_time;

    @ApiModelProperty(value = "活动状态(1:未开始, 2:进行中, 3:已结束)")
    private String act_status;

    @ApiModelProperty(value = "普通积分")
    private Integer regu_score;

    @ApiModelProperty(value = "红包积分")
    private Integer red_score;

    @ApiModelProperty(value = "活动总题数")
    private Integer ques_cnt;

    @ApiModelProperty(value = "可参与答题人数")
    private Integer allow_cnt;

    @ApiModelProperty(value = "累计参与答题人数")
    private Integer attend_cnt;

    @ApiModelProperty(value = "中奖人数")
    private Integer bingo_cnt;

    @ApiModelProperty(value = "红包中奖人数")
    private Integer promote_cnt;

    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date created_time;

    @ApiModelProperty(value = "更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modified_time;

    @ApiModelProperty(value = "活动日期")
    private String actionDate;

    @ApiModelProperty(value = "活动时间")
    private String actionTime;

    @ApiModelProperty(value = "红包题数")
    private Integer red_cnt;

    @ApiModelProperty(value = "参与人数")
    private Integer join_cnt;

    @ApiModelProperty(value = "机器人数")
    private Integer robot_cnt;

    @ApiModelProperty(value = "通关人数")
    private Integer comp_cnt;

    @ApiModelProperty(value = "发放普通积分")
    private Integer send_regu_score;

    @ApiModelProperty(value = "发放红包积分")
    private Integer send_red_score;


}
