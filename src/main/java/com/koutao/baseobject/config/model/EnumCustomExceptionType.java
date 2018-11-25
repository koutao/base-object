package com.koutao.baseobject.config.model;

import lombok.Data;
import lombok.Getter;

@Getter
public enum EnumCustomExceptionType {

    EXCEPTION_NULL_TYPE("11111", "通用异常"),
    EXCEPTION_NO_CATCH_TYPE("00001", "系统异常，请联系管理员！");

    private String code;

    private String msg;

    private EnumCustomExceptionType(String code, String msg){
        this.code = code;
        this.msg = msg;
    }
}
