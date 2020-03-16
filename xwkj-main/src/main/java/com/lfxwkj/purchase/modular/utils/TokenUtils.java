package com.lfxwkj.purchase.modular.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * token生成和校验
 * @author lz
 *
 */
public class TokenUtils {
	
	private static Map<String,String> MAP_TOKENS = new HashMap<String,String>();
	private static final int VALID_TIME = 7200; // token有效期(秒)
	public static final String TOKEN_ERROR = "F"; // 非法
	public static final String TOKEN_OVERDUE = "G"; // 过期
	public static final String TOKEN_FAILURE = "S"; // 失效
	
	/**
	 * 生成token,该token长度不一致,如需一致,可自行MD5或者其它方式加密一下
	 * 该方式的token只存在磁盘上,如果项目是分布式,最好用redis存储
	 * @param str: 该字符串可自定义,在校验token时要保持一致
	 * @return
	 */
	public static String getToken(String str) {
		String token = TokenEncryptUtils.encoded(str);
		MAP_TOKENS.put(str, token);
		return token;
	}
	
	/**
	 * 校验token的有效性
	 * @param token
	 * @return
	 */
	public static String checkToken(String token) {
		removeInvalidToken();
		if (token == null) {
			return TOKEN_ERROR;
		}
		try{
			String[] tArr = TokenEncryptUtils.decoded(token).split(",");
			if (tArr.length != 2) {
				return TOKEN_ERROR;
			}
			// token生成时间戳
			int tokenTime = Integer.parseInt(tArr[0]);
			// 当前时间戳
			int currentTime = getCurrentTime();
			if (currentTime-tokenTime < VALID_TIME) {
				String tokenStr = tArr[1];
				String mToken = MAP_TOKENS.get(tokenStr);
				if (mToken == null) {
					return TOKEN_OVERDUE;
				} else if(!mToken.equals(token)) {
					return TOKEN_FAILURE;
				}
				return tokenStr;
			} else {
				return TOKEN_OVERDUE;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return TOKEN_ERROR;
	}
	
	/**获取当前时间戳（10位整数）*/
	public static int getCurrentTime() {
		return (int)(System.currentTimeMillis()/1000);
	}
	
	/**
	 * 移除过期的token
	 */
	public static void removeInvalidToken() {
		int currentTime = getCurrentTime();
		for (Entry<String,String> entry : MAP_TOKENS.entrySet()) {
			String[] tArr = TokenEncryptUtils.decoded(entry.getValue()).split(",");
			int tokenTime = Integer.parseInt(tArr[0]);
			if(currentTime-tokenTime > VALID_TIME){
				MAP_TOKENS.remove(entry.getKey());
			}
		}
	}
	
	//https://blog.csdn.net/p812438109/article/details/86677329
	//https://blog.csdn.net/KenThomas/article/details/94595993
	


}
