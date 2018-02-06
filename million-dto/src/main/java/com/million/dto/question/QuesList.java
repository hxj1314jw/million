package com.million.dto.question;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 题库表
 * @author hxjian
 * @date 2018-01-29 17:34:19
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("题库表")
public class QuesList extends Ques implements Serializable {
	private static final long serialVersionUID = 1L;

    private List<QuestOpt> quest_opt_list;

}
