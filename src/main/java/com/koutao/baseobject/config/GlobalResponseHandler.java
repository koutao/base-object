package com.koutao.baseobject.config;

import com.koutao.baseobject.config.model.ResultModel;
import com.koutao.baseobject.util.JacksonUtil;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.Objects;

@RestControllerAdvice
public class GlobalResponseHandler implements ResponseBodyAdvice<Object>{

    @Override
    public boolean supports(MethodParameter var1, Class<? extends HttpMessageConverter<?>> var2){
        final String returnTypeName = var1.getParameterType().getTypeName();
        return !Objects.equals(ResultModel.class.getTypeName(), returnTypeName);
    }

    @Override
    public Object beforeBodyWrite(@Nullable Object var1, MethodParameter var2, MediaType var3, Class<? extends HttpMessageConverter<?>> var4, ServerHttpRequest var5, ServerHttpResponse var6){
        final String returnTypeName = var2.getParameterType().getTypeName();

        // 为解决 BufferedImageHttpMessageConverter 报错问题
        if (Objects.equals(String.class.getTypeName(), returnTypeName)){
            return JacksonUtil.bean2Json(new ResultModel<>(var1));
        }

        if (Objects.equals("void", returnTypeName)){
            return new ResultModel();
        }

        if (Objects.equals(ResultModel.class.getTypeName(), returnTypeName)){
            return var1;
        }

        return new ResultModel<>(var1);
    }

}
