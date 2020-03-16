package com.lfxwkj.purchase.modular.utils;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import com.google.gson.reflect.TypeToken;

public class Transtor {

	public static SignData getSignData(String signData){
		String sign = AesUtil.aesDecrypt(signData);
		return JsonUtils.getData(sign, SignData.class);
	}
	
	public static Map<String , String> getMapData(String postData){
		Type type = new TypeToken<HashMap<String,String>>(){}.getType();
		return JsonUtils.getData(postData, type);
	}

}
