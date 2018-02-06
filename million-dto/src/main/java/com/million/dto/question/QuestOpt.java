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

/**
 * 题库选项表
 * @author hxjian
 * @date 2018-01-29 17:45:35
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("题库选项表")
public class QuestOpt implements Serializable {
	private static final long serialVersionUID = 1L;
    @Id
    @ApiModelProperty(value = "主键")
    private Integer id;

    @ApiModelProperty(value = "问题ID")
    private Integer ques_id;

    @ApiModelProperty(value = "选项标识")
    private String opt_id;

    @ApiModelProperty(value = "选项描述")
    private String opt_desc;

    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date created_time;

    @ApiModelProperty(value = "更新时间")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date modified_time;


}
