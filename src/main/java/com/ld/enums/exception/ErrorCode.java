package com.ld.enums.exception;

/**
 * @program: material_manage
 * @description: 错误类型
 * @author: LD
 * @create: 2020-08-04 13:51
 **/
public enum ErrorCode {

    //服务器错误
    ERROR(2000,"服务器傻了"),
    //
    REQUEST_ERROR(3000,"请求错误"),
    //
    ERROR_DATE(3001,"日期格式错误");

    private String message;
    private Integer code;

    public String getMessage() {
        return message;
    }

    public Integer getCode() {
        return code;
    }

    ErrorCode(Integer code, String message) {
        this.message = message;
        this.code = code;
    }
}
