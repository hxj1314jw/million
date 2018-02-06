package com.million.dto.question;

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
import java.util.List;

/**
 * 题库表
 * @author hxjian
 * @date 2018-01-29 17:34:19
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("题库表")
public class Ques implements Serializable {
	private static final long serialVersionUID = 1L;
    @Id
    @ApiModelProperty(value = "主键")
    private Integer id;

    @ApiModelProperty(value = "问题描述")
    private String ques_desc;

    @ApiModelProperty(value = "问题解读")
    private String ques_analysis;

    @ApiModelProperty(value = "问题答案(即选项标识)")
    private String answer;

    @ApiModelProperty(value = "可用状态(1:可用 0:不可用)")
    private String aval_status;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间")
    private Date created_time;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间")
    private Date modified_time;

    @ApiModelProperty(value = "是否红包题 1：是 0：否")
    private String red_packet;

    @ApiModelProperty(value = "问题类型（1：百科2：财经3：投教)")
    private String ques_type;

    @ApiModelProperty(value = "活动id")
    private String act_id;

    @ApiModelProperty(value = "题库选项答案描述")
    private String opt_desc;
}
