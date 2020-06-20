package com.dbc.utils;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@ApiModel(description = "响应对象")
public class BaseResult<T> implements Serializable {
    private static final long serialVersionUID = -4577255781088498763L;
    private static final int SUCCESS_CODE = 0;
    private static final int FAIL_CODE = 1;
    private static final int UNAUTHORIZED = 2;
    private static final String SUCCESS_MESSAGE = "成功";
    private static final String FAIL_MESSAGE = "失败";
    private static final String UNAUTHORIZED_MESSAGE = "未授权";

    @ApiModelProperty(value = "响应码", name = "code", required = true, example = "" + SUCCESS_CODE)
    private int code;

    @ApiModelProperty(value = "响应消息", name = "msg", required = true, example = SUCCESS_MESSAGE)
    private String msg;

    @ApiModelProperty(value = "响应数据", name = "data")
    private T data;

    @ApiModelProperty(value = "附加响应信息", name = "map")
    private Object map;

    private BaseResult(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.map = null;
    }

    private BaseResult() {
        this(SUCCESS_CODE, SUCCESS_MESSAGE);
    }

    private BaseResult(int code, String msg) {
        this(code, msg, null);
    }

    private BaseResult(T data) {
        this(SUCCESS_CODE, SUCCESS_MESSAGE, data);
    }

    public static <T> BaseResult<T> success() {
        return new BaseResult<>();
    }

    public static <T> BaseResult<T> successWithData(T data) {
        return new BaseResult<>(data);
    }

    public static <T> BaseResult<T> fail() {
        return new BaseResult<>(FAIL_CODE, FAIL_MESSAGE);
    }

    public static <T> BaseResult<T> unauthorized() {
        return new BaseResult<>(UNAUTHORIZED, UNAUTHORIZED_MESSAGE);
    }

    public static <T> BaseResult<T> failWithCodeAndMsg(int code, String msg) {
        return new BaseResult<>(code, msg, null);
    }

    public static <T> BaseResult<T> buildWithParam(ResponseParam param) {
        return new BaseResult<>(param.getCode(), param.getMsg());
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Object getMap() {
        return map;
    }

    public BaseResult<T> setMap(String allCount, Object map) {
        this.map = map;
        return this;
    }

    public static class ResponseParam {
        private int code;
        private String msg;

        private ResponseParam(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public static ResponseParam buildParam(int code, String msg) {
            return new ResponseParam(code, msg);
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
    }
}
