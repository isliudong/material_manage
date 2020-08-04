package com.ld.enums.exception;

/**
 * @program: material_manage
 * @description:
 * @author: LD
 * @create: 2020-08-04 14:00
 **/
public class MyException extends RuntimeException {

    private String message;
    private Integer code;

    public MyException(ErrorCode errorCode) {
        this.message = errorCode.getMessage();
        this.code = errorCode.getCode();
    }

    @Override
    public String getMessage() {
        return message;
    }

    public Integer getCode() {
        return code;
    }
}
