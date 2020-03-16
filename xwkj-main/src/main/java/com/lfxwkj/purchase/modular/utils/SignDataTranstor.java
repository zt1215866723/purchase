package com.lfxwkj.purchase.modular.utils;

import java.util.Map;
import java.util.Map.Entry;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 这个方法用于 校验手机端发来的签名，校验token 是否失效
 *
 * @author 郭晓东
 */
public class SignDataTranstor {

	private static Log log = LogFactory.getLog(SignDataTranstor.class);

	public static Map<String, String> getData(String data) {
		SignData signData = Transtor.getSignData(data);

		if (!checkSign(signData.getSign(), signData.getData())) {
			
		}

		Map<String, String> postData = Transtor.getMapData(signData.getData());
		log.info("收到的参数：");

		if (postData == null || postData.size() <= 0) {
			log.info("参数为空");
		} else {
			log.info("收到请求的参数为空");
			for (Entry<String, String> obj : postData.entrySet()) {
				log.info(obj.getKey() + " = " + obj.getValue());
			}
		}
		if (postData != null) {
			postData.get("token");
		}
		return postData;
	}




	public static boolean checkSign(String serversSign, String clientSign) {

		return true;
	}

	public static boolean checkToken(String serversToken, String clientToken) {

		return true;
	}
}
