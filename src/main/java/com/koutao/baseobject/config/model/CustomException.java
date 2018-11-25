package com.koutao.baseobject.config.model;

import lombok.Data;

@Data
public class CustomException extends RuntimeException {

    private String code;

    private String msg;

    public CustomException(EnumCustomExceptionType exceptionType){
        this.code = exceptionType.getCode();
        this.msg = exceptionType.getMsg();
    }
}
