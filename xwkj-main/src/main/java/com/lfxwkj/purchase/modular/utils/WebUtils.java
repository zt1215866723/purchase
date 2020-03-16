package com.lfxwkj.purchase.modular.utils;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class WebUtils {
    private static Log log = LogFactory.getLog(WebUtils.class);

    public static void sendJSON(Object object, HttpServletResponse response) {
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setCharacterEncoding("UTF-8");
            response.setContentType("Content-type:text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.write(JsonUtils.toJSON(object));
            out.flush();
        } catch (IOException e) {
            log.info(object);
            log.error("返回JSON数据报错! " + e);
        }
    }

    public static void sendJSON(ResponseApi responseApi, HttpServletResponse response) {
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setCharacterEncoding("UTF-8");
            response.setContentType("Content-type:text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.write(JsonUtils.toJSON(responseApi));
            out.flush();
        } catch (IOException e) {
            log.info(responseApi);
            log.error("返回JSON数据报错! " + e);
        }
    }
}
