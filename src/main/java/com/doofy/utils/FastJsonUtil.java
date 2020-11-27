package com.doofy.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.github.pagehelper.util.StringUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FastJsonUtil {

    /**
     * 判断字符串是否为json格式
     * @param str String
     * @return boolean
     */
    public static boolean isJson(String str) {
        if (StringUtil.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jsonObject = JSONObject.parseObject(str);
            if (jsonObject != null) {
                return true;
            }
        } catch (Exception e) {
            try {
                if (JSONArray.parseArray(str) != null) {
                    return true;
                }
            } catch (Exception e1) {
                return false;
            }
        }
        return false;
    }

    /**
     * 对象转json
     * @param object Object
     * @return String
     */
    public static String obj2json(Object object) {
        return JSONObject.toJSONString(object, SerializerFeature.WriteNullStringAsEmpty);
    }

    /**
     * json转对象
     * @param json String
     * @param tClass Class
     * @param <T> T
     * @return T
     */
    public static <T> T json2obj(String json, Class<T> tClass) {
        return JSON.parseObject(json, tClass);
    }

    /**
     * 对象转map
     */
    @SuppressWarnings("unchecked")
    public static Map<String, Object> object2map(Object object) {
        String jsonStr = JSONObject.toJSONString(object, SerializerFeature.WriteNullStringAsEmpty);
        HashMap<String, Object> map = JSON.parseObject(jsonStr, HashMap.class);
        HashMap<String, Object> result = new HashMap<>();
        for (Map.Entry<String, Object> items : map.entrySet()) {
            result.put(items.getKey(), items.getValue());
        }
        return result;
    }

    /**
     * 将list切割成多个list对象
     * 用偏移量实现
     * @param source    List<T> source
     * @param n         int
     * @param <T>       T
     * @return          List<List<T>>
     */
    public static <T> List<List<T>> averageAssign(List<T> source, int n) {
        List<List<T>> result = new ArrayList<>();
        int remaider = source.size() % n;
        int number = source.size()/n;
        int offset = 0;
        for (int i=0; i<n; i ++) {
            List<T> value;
            if (remaider >0) {
                value = source.subList(i*number + offset, (i+1)*number + offset + 1);
                remaider--;
                offset++;
            } else {
                value = source.subList(i*number + offset, (i+1)*number + offset);
            }
            result.add(value);
        }
        return result;
    }

    /**
     * 对象转jsonobject
     * @param
     * @return String
     */
    public static Object str2json(String str) {
        return JSONObject.parseObject(str);
    }
}
