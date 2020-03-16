package com.lfxwkj.purchase.modular.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * 控制器
 *
 * @author 郭晓东
 * @Date 2020-03-12 08:45:35
 */
@Controller
@RequestMapping("/api")
public class ClientinfoApiController {

    /**
     * 跳转到主页面
     *
     * @author 郭晓东
     * @Date 2020-03-12
     */
    @RequestMapping(value="test", method = RequestMethod.GET)
    public String index() {
        return "/clientinfo.html";
    }
}


