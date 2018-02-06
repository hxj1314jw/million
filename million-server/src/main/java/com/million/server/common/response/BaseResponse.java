package com.million.server.common.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA
 * User: huangxj
 * DATE: 2018/1/29 10:40
 * Description:
 */
@Data
@ApiModel("基础消息返回对象")
public class BaseResponse implements Serializable {

    @ApiModelProperty(value = "返回码")
    private int code;
    @ApiModelProperty(value = "返回状态，1为成功 0为失败")
    private int status;
    @ApiModelProperty(value = "返回消息，如请求异常此处会包含异常信息")
    private String message;
    @ApiModelProperty(value = "数据体")
    private Object data;
    @ApiModelProperty(value = "流水号")
    private String uuid;

    public BaseResponse(Throwable throwable) {
        super();
        this.code = BaseResponseCode.NO.getCode();
        this.status = BaseResponseStatus.NO.getCode();
        this.message = throwable.getMessage();
    }

    public BaseResponse(BaseResponseCode baseResponseCode, Throwable throwable) {
        super();
        this.code = baseResponseCode.getCode();
        this.status = BaseResponseStatus.NO.getCode();
        this.message = throwable.getMessage();
    }

    public BaseResponse(BaseResponseCode baseResponseCode) {
        super();
        this.code = baseResponseCode.getCode();
        this.status = BaseResponseStatus.NO.getCode();
        this.message = baseResponseCode.getMessage();
    }

    /**
     * 默认构造函数 默认操作为成功
     */
    public BaseResponse() {
        this.code = BaseResponseCode.OK.getCode();
        this.status = BaseResponseStatus.OK.getCode();
    }

    /**
     * 默认构造函数 默认操作为成功
     *
     * @param data 数据
     */
    public BaseResponse(Object data) {
        this.code = BaseResponseCode.OK.getCode();
        this.status = BaseResponseStatus.OK.getCode();
        this.data = data;
    }

    /**
     * 默认构造函数 默认操作为成功
     *
     * @param code   返回代码
     * @param status 状态
     * @param data   数据
     */
    public BaseResponse(int code, int status, Object data) {
        this.code = code;
        this.status = status;
        this.data = data;
    }

    /**
     * 默认构造函数 默认操作为成功
     *
     * @param code 返回代码
     * @param data 数据
     */
    public BaseResponse(int code, Object data) {
        this.code = code;
        this.data = data;
        this.status = BaseResponseStatus.OK.getCode();
    }
}
