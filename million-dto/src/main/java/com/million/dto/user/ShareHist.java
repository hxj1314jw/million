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
 * 分享记录表
 * @author hxjian
 * @date 2018-01-30 14:18:12
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("分享记录表")
public class ShareHist implements Serializable {
	private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户ID")
    private String user_id;

    @ApiModelProperty(value = "分享方式(1:微信, 2:QQ)")
    private String share_way;

    @ApiModelProperty(value = "创建时间")
    private Date created_time;

    @ApiModelProperty(value = "更新时间")
    private Date modified_time;


}
