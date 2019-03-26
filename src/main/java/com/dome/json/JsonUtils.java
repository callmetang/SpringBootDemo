package com.dome.json;

import com.alibaba.fastjson.JSON;

public class JsonUtils {

    public static String toJSONString(Object obj) {
        if (obj == null)
            return "";
        return JSON.toJSONString(obj);
    }
}
