package com.koutao.baseobject.util;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringWriter;

public class JacksonUtil {
    private static ObjectMapper mapper = new ObjectMapper();

    public static String bean2Json(Object obj) {
        StringWriter sw = null;
        JsonGenerator gen = null;
        try {
            sw = new StringWriter();
            gen = new JsonFactory().createGenerator(sw);
            mapper.writeValue(gen, obj);
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            try {
                gen.close();
                sw.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        return sw.toString();
    }

    public static <T> T json2Bean(String jsonStr, Class<T> objClass) {
        try {
            return mapper.readValue(jsonStr, objClass);
        } catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
}
