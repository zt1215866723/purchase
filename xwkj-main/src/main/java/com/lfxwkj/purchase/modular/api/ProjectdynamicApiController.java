package com.lfxwkj.purchase.modular.api;

import cn.stylefeng.roses.core.mutidatasource.annotion.DataSource;
import com.lfxwkj.purchase.modular.model.params.ProjectdynamicParam;
import com.lfxwkj.purchase.modular.model.result.ProjectdynamicResult;
import com.lfxwkj.purchase.modular.service.ProjectdynamicService;
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
 * @Date 2020-03-12 08:45:37
 */
@Controller
@RequestMapping("/api")
public class ProjectdynamicApiController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ProjectdynamicService projectdynamicService;

    /**
     * 查询项目动态
     * @param response
     * @param data
     * @author wanglei
     */
    @DataSource(name = "purchase")
    @RequestMapping(value = "/projectDynamicList", method = RequestMethod.POST)
    public void projectDynamicList(HttpServletResponse response, String data) {
        ResponseApi responseApi = new ResponseApi();
        // 解密,验证token是否失效，验证签名是否正确，拿到请求的数据。
        Map<String, String> map = SignDataTranstor.getData(data);
        // 将请求的参数转换为对象
        ProjectdynamicParam param = JsonUtils.getData(JsonUtils.toJSON(map), ProjectdynamicParam.class);
        try {
            log.info("请求了获取项目动态的接口");
            List<ProjectdynamicResult> list = projectdynamicService.projectDynamicList(param);
            responseApi.success(list);
        } catch (Exception e) {
            log.error(e.toString());
            responseApi.fail();
        }finally {
            WebUtils.sendJSON(responseApi, response);
        }
    }
}


