package com.lfxwkj.purchase.modular.api;

import cn.stylefeng.roses.core.base.controller.BaseController;
import com.lfxwkj.purchase.modular.model.params.HouselayouttypeParam;
import com.lfxwkj.purchase.modular.model.result.HouselayouttypeResult;
import com.lfxwkj.purchase.modular.service.HouselayouttypeService;
import com.lfxwkj.purchase.modular.utils.ResponseApi;
import com.lfxwkj.purchase.modular.utils.SignDataTranstor;
import com.lfxwkj.purchase.modular.utils.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;


/**
 * 控制器
 *
 * @author 郭晓东
 * @Date 2020-03-16 23:03:42
 */
@Controller
@RequestMapping("/api")
public class HouselayouttypeApiController extends BaseController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private HouselayouttypeService houselayouttypeService;

    /**
     *  项目户型类型的接口
     *
     * @author 郭晓东
     */
    @RequestMapping(value = "houseLayouttype", method = RequestMethod.POST)
    public void projectlist(HttpServletResponse response, String data) {
        ResponseApi responseApi = new ResponseApi();
        // 解密,验证token是否失效，验证签名是否正确，拿到请求的数据。
        Map<String, String> map = SignDataTranstor.getData(data);
        // 拿到项目的主键
        String id = map.get("id");
        try {
            log.info("请求了获取项目列表的方法");
            HouselayouttypeParam houselayouttypeParam = new HouselayouttypeParam();
            houselayouttypeParam.setProjectID(Long.valueOf(id));
            List<HouselayouttypeResult> list = houselayouttypeService.findListBySpec(houselayouttypeParam);
            responseApi.success(list);
        } catch (Exception e) {
            log.error(e.toString());
            responseApi.fail();
        }finally {
            WebUtils.sendJSON(responseApi, response);
        }
    }
}


