package com.million.dto.question;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.Date;

/**
 * 活动所选题库表
 * @author hxjian
 * @date 2018-01-30 18:48:39
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("活动所选题库表")
public class ActQues implements Serializable {
	private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    private Integer id;

    @ApiModelProperty(value = "活动ID")
    private String act_id;

    @ApiModelProperty(value = "问题ID")
    private Integer ques_id;

    @ApiModelProperty(value = "序号(展示顺序)")
    private Integer sort;

    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date created_time;

    @ApiModelProperty(value = "更新时间")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date modified_time;


}
