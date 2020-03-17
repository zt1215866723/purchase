package com.lfxwkj.purchase.modular.api;

import cn.stylefeng.roses.core.mutidatasource.annotion.DataSource;
import com.lfxwkj.purchase.modular.model.vo.SalespersonVo;
import com.lfxwkj.purchase.modular.service.SalespersonService;
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
import java.util.Map;


/**
 * 控制器
 *
 * @author 郭晓东
 * @Date 2020-03-12 08:45:37
 */
@Controller
@RequestMapping("/api")
public class SalespersonApiController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SalespersonService salespersonService;

    /**
     * 查询销售顾问名片
     * @param response
     * @param data
     * @author wanglei
     */
    @DataSource(name = "purchase")
    @RequestMapping(value = "/salespersonDetail", method = RequestMethod.POST)
    public void salespersonDetail(HttpServletResponse response, String data) {
        ResponseApi responseApi = new ResponseApi();
        // 解密,验证token是否失效，验证签名是否正确，拿到请求的数据。
        Map<String, String> map = SignDataTranstor.getData(data);
        // 将请求的参数转换为对象
        Long id = Long.parseLong(map.get("id"));
        try {
            log.info("请求了获取销售顾问名片的接口");
            SalespersonVo salespersonVo = salespersonService.salespersonDetail(id);
            responseApi.success(salespersonVo);
        } catch (Exception e) {
            log.error(e.toString());
            responseApi.fail();
        }finally {
            WebUtils.sendJSON(responseApi, response);
        }
    }
}


