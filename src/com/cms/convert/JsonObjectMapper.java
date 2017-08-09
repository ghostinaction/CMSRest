package com.cms.convert;



import java.io.IOException;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializerProvider;

 
/**
 * @description: 转换null对象为空字符串
 */ 
public class JsonObjectMapper extends ObjectMapper { 
    private static final long serialVersionUID = 1L; 
   
    public JsonObjectMapper() { 
        super(); 
        // 空值处理为空串 
        this.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>() { 
            @Override 
            public void serialize(Object value, JsonGenerator jg, SerializerProvider sp) throws IOException, JsonProcessingException { 
                jg.writeString(""); 
            } 
        }); 
    } 
} 
