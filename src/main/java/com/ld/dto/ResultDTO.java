package com.ld.dto;

import com.ld.enums.exception.ErrorCode;
import com.ld.enums.exception.MyException;

/**
 * @program: material_manage
 * @description: 前端请求返回信息模型
 * @author LD
 * @create: 2020-08-04 13:48
 **/
public class ResultDTO {

    private Integer code;
    private String message;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    //自定义错误
    public static ResultDTO errorOf(Integer code, String message){
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setCode(code);
        resultDTO.setMessage(message);
        return resultDTO;
    }

    //错误
    public static ResultDTO error(MyException ex){
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setCode(ex.getCode());
        resultDTO.setMessage(ex.getMessage());
        return resultDTO;
    }

    public static ResultDTO ok(){
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setCode(200);
        resultDTO.setMessage("success");
        return resultDTO;
    }

    public static ResultDTO okOf(String message){
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setCode(200);
        resultDTO.setMessage(message);
        return resultDTO;
    }
}
