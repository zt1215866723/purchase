package com.lfxwkj.purchase.modular.api;

import com.lfxwkj.purchase.modular.api.result.HouselayoutVo;
import com.lfxwkj.purchase.modular.model.params.HouselayoutParam;
import com.lfxwkj.purchase.modular.model.result.HouselayoutResult;
import com.lfxwkj.purchase.modular.service.HouselayoutService;
import com.lfxwkj.purchase.modular.utils.JsonUtils;
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
 * @Date 2020-03-12 08:45:36
 */
@Controller
@RequestMapping("/api")
public class HouselayoutApiController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private HouselayoutService houselayoutService;
    /**
     * 获取主力户型接口， 户型列表接口
     *
     * @author 张童
     */
    @RequestMapping(value = "/houseLayoutlist", method = RequestMethod.GET)
    public void houseLayoutlist(HttpServletResponse response, String data) {
        ResponseApi responseApi = new ResponseApi();
        // 解密,验证token是否失效，验证签名是否正确，拿到请求的数据。
        Map<String, String> map = SignDataTranstor.getData(data);
        // 将请求的参数转换为对象
        HouselayoutParam param = JsonUtils.getData(JsonUtils.toJSON(map), HouselayoutParam.class);
        try {
            log.info("获取主力户型接口， 户型列表的方法");
            List<HouselayoutVo> list = houselayoutService.houselayoutList(param);
            responseApi.success(list);
        } catch (Exception e) {
            log.error(e.toString());
            responseApi.fail();
        }finally {
            WebUtils.sendJSON(responseApi, response);
        }
    }

    /**
     * 获取户型详情接口
     *
     * @author 张童
     */
    @RequestMapping(value = "/houseLayoutdetail", method = RequestMethod.GET)
    public void houseLayoutdetail(HttpServletResponse response, String data) {
        ResponseApi responseApi = new ResponseApi();
        // 解密,验证token是否失效，验证签名是否正确，拿到请求的数据。
        Map<String, String> map = SignDataTranstor.getData(data);
        // 将请求的参数转换为对象
        HouselayoutParam param = JsonUtils.getData(JsonUtils.toJSON(map), HouselayoutParam.class);
//        HouselayoutParam param = new HouselayoutParam();
//        param.setId(houseLayID);
        try {
            log.info("获取户型详情的方法");
            HouselayoutVo houselayoutVo = houselayoutService.houselayoutDetails(param);
            responseApi.success(houselayoutVo);
        } catch (Exception e) {
            log.error(e.toString());
            responseApi.fail();
        }finally {
            WebUtils.sendJSON(responseApi, response);
        }
    }
}


