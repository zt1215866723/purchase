package com.lfxwkj.purchase.modular.utils;

import com.alibaba.fastjson.JSON;

import java.util.Map;

/**
 * json工具类
 * @author Administrator
 *
 */
public class JsonUtils {
	
	/**
	 * 将json字符串转换成对象
	 * @param jsonString
	 * @param clazz
	 * @return
	 */
	public static <T>T toJavaObject(String jsonString, Class<T> clazz){
		return  JSON.toJavaObject(JSON.parseObject(jsonString) , clazz);
	}
	
	/**
	 * 将对象转换成json字符串
	 * @param obj
	 * @return
	 */
	public static String toJsonString(Object obj) {
		return JSON.toJSONString(obj);
	}
	
	/**
	 * <pre>
	 * 将json字符串转换成Map&lt;String, Object&gt;集合
	 * <pre>
	 * @param jsonString
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, Object> toObjectMap(String jsonString){
		return toJavaObject(jsonString, Map.class);
	}
	
	/**
	 * <pre>
	 * 将json字符串转换成Map&lt;String, String&gt;集合
	 * <pre>
	 * @param jsonString
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, String> toStringMap(String jsonString){
		return toJavaObject(jsonString, Map.class);
	}
}
