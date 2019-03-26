package com.dome.json;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;

@Configuration
public class JsonConfig {

    @Bean
    public HttpMessageConverters fastJsonHttpMessageConverters() {
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();

        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(FEATURES);


        converter.setFastJsonConfig(fastJsonConfig);
        HttpMessageConverter<?> messageConverter = converter;

        return new HttpMessageConverters(messageConverter);
    }


    private static SerializerFeature[] FEATURES = {
            //List字段如果为null,输出为[],而非null
            SerializerFeature.WriteNullListAsEmpty,
            //字符类型字段如果为null,输出为”“,而非null
            SerializerFeature.WriteNullStringAsEmpty,
            //数值字段如果为null,输出为0,而非null
            SerializerFeature.WriteNullNumberAsZero,
            //Boolean字段如果为null,输出为false,而非null
            SerializerFeature.WriteNullBooleanAsFalse,
            //结果是否格式化,默认为false
            SerializerFeature.PrettyFormat,
            //是否输出值为null的字段,默认为false
            SerializerFeature.WriteMapNullValue,
    };
}
