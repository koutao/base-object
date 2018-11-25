package com.koutao.baseobject.config.model;

import lombok.Data;

@Data
public class ResultModel<T> {

    private String code;

    private String msg;

    private T data;

    public ResultModel(){
        this.code = "0";
        this.msg = "请求成功！";
    }

    public ResultModel(T data){
        this.data = data;
        this.code = "0";
        this.msg = "请求成功！";
    }

    public ResultModel(String code, String msg){
        this.code = code;
        this.msg = msg;
    }
    public ResultModel(String code, String msg, T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

}
