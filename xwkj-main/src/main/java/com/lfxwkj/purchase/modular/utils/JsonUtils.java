package com.lfxwkj.purchase.modular.utils;

import com.google.gson.Gson;

import java.lang.reflect.Type;

/**
 * json工具类
 * @author Administrator
 *
 */
public class JsonUtils {

	private static Gson gson = new Gson();

	public static <T>T getData(String json, Type typeOfT){
		return gson.fromJson(json, typeOfT);
	}
	/**
	 * JOSN数据转换成java对象
	 * @param json
	 * @return
	 */
	public static <T>T getData(String json, Class<T> classz){
		return (T) gson.fromJson(json, classz);
	}

	/**
	 * 对象转换成JSON数据
	 * @param object
	 * @return
	 */
	public static String toJSON(Object object){
		return gson.toJson(object);
	}

}
