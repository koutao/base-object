package com.koutao.baseobject.config;

import com.koutao.baseobject.config.model.CustomException;
import com.koutao.baseobject.config.model.EnumCustomExceptionType;
import com.koutao.baseobject.config.model.ResultModel;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionAdvice {

    @ExceptionHandler(CustomException.class)
    public ResultModel<String> customExceptionHandle(CustomException e){
        return new ResultModel<>(e.getCode(), e.getMsg());
    }

    @ExceptionHandler(Exception.class)
    public ResultModel<String> exceptionHandle(Exception e){
        e.printStackTrace();
        return new ResultModel<>(EnumCustomExceptionType.EXCEPTION_NO_CATCH_TYPE.getCode(),
                EnumCustomExceptionType.EXCEPTION_NO_CATCH_TYPE.getMsg(),
                e.getMessage());
    }
}
