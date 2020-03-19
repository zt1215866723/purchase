package com.lfxwkj.purchase.modular.api;

import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.kernel.model.response.ResponseData;
import com.lfxwkj.purchase.base.pojo.page.LayuiPageInfo;
import com.lfxwkj.purchase.modular.entity.Salefollow;
import com.lfxwkj.purchase.modular.model.params.SalefollowParam;
import com.lfxwkj.purchase.modular.model.result.SalespersonResult;
import com.lfxwkj.purchase.modular.service.SalefollowService;
import com.lfxwkj.purchase.modular.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;


/**
 * 控制器
 *
 * @author 郭晓东
 * @Date 2020-03-12 08:45:37
 */
@Controller
@RequestMapping("/api")
public class SalefollowApiController {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SalefollowService salefollowService;

    /**
     * 根据客户查询销售顾问名片
     * @param response
     * @param data
     */
    @RequestMapping(value = "/salefollowlist", method = RequestMethod.GET)
    public void salefollowlist(HttpServletResponse response, String data) {
        ResponseApi responseApi = new ResponseApi();
        // 解密,验证token是否失效，验证签名是否正确，拿到请求的数据。
//        Map<String, String> map = SignDataTranstor.getData(data);
        SignData sign = JsonUtils.getData(data,SignData.class);
        // 将请求的参数转换为对象
        SalefollowParam param = JsonUtils.getData(JsonUtils.toJSON(sign), SalefollowParam.class);
        try {
            log.info("请求了获取客户名片夹接口");
            List<SalespersonResult> list = salefollowService.salefollowlist(param);
            responseApi.success(list);
        } catch (Exception e) {
            log.error(e.toString());
            responseApi.fail();
        }finally {
            WebUtils.sendJSON(responseApi, response);
        }
    }
}


