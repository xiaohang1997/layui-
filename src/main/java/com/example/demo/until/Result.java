package com.example.demo.until;

import com.alibaba.fastjson.JSONObject;

public class Result {

    public static JSONObject success(String key, String value){
        JSONObject json = new JSONObject();
        json.put(key, value);
        return json;
    }
    public static JSONObject error(String key, String value){
        JSONObject json = new JSONObject();
        json.put(key, value);
        return json;
    }
}
