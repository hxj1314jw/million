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
 * 用户答题记录表
 * @author hxjian
 * @date 2018-01-30 10:34:48
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("用户答题记录表")
public class UserAnsHist implements Serializable {
	private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    private Integer ID;

    @ApiModelProperty(value = "用户ID")
    private String user_id;

    @ApiModelProperty(value = "活动ID")
    private String act_id;

    @ApiModelProperty(value = "题目ID")
    private Integer ques_id;

    @ApiModelProperty(value = "所填选项")
    private String ans_opt;

    @ApiModelProperty(value = "是否答对(1:正确 0:错误)")
    private Integer is_correct;

    @ApiModelProperty(value = "创建时间")
    private Date created_time;

    @ApiModelProperty(value = "更新时间")
    private Date modified_time;

    @ApiModelProperty(value = "使用复活卡1:是 0:否")
    private String use_revival;


}
