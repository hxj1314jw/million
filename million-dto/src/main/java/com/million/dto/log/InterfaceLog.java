package com.million.dto.log;

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
 * Created with IntelliJ IDEA
 * User: huangxj
 * DATE: 2018/1/29 10:40
 * Description:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("接口调用日志")
public class InterfaceLog implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @ApiModelProperty(value = "流水号")
    private String uuid;

    @ApiModelProperty(value = "IP地址")
    private String ipAddress;

    @ApiModelProperty(value = "区块链地址")
    private String blockChainAddress;

    @ApiModelProperty(value = "手机号码")
    private String phoneNum;

    @ApiModelProperty(value = "功能号")
    private String functionId;

    @ApiModelProperty(value = "调用时间")
    private Date invokeTime;

    @ApiModelProperty(value = "消耗时长")
    private Long consumeTime;

    @ApiModelProperty(value = "入参")
    private String param;

    @ApiModelProperty(value = "出参")
    private String result;

    @ApiModelProperty(value = "1：成功 0：失败")
    private String status;

    public InterfaceLog(String uuid, String ipAddress, String functionId, long consumeTime, String param, String result, String status) {
        this.uuid = uuid;
        this.ipAddress = ipAddress;
        this.functionId = functionId;
        this.invokeTime = new Date();
        this.consumeTime = consumeTime;
        this.param = param;
        this.result = result;
        this.status = status;
    }
}
