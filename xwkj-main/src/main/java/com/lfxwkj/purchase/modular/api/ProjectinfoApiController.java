package com.lfxwkj.purchase.modular.api;


import com.lfxwkj.purchase.modular.model.params.ProjectinfoParam;
import com.lfxwkj.purchase.modular.model.result.ProjectinfoResult;
import com.lfxwkj.purchase.modular.service.ProjectinfoService;
import com.lfxwkj.purchase.modular.utils.*;
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
 * @Date 2020-03-13 10:47:26
 */
@Controller
@RequestMapping("/api")
public class ProjectinfoApiController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ProjectinfoService projectinfoService;

    /**
     * 查询项目列表的接口
     *
     * @author 郭晓东
     */
    @RequestMapping(value = "projectlist", method = RequestMethod.GET)
    public void projectlist(HttpServletResponse response, String data) {
        ResponseApi responseApi = new ResponseApi();
        // 解密,验证token是否失效，验证签名是否正确，拿到请求的数据。
        Map<String, String> map = SignDataTranstor.getData(data);
        // 将请求的参数转换为对象
        ProjectinfoParam param = JsonUtils.getData(JsonUtils.toJSON(map), ProjectinfoParam.class);
        try {
            log.info("请求了获取项目列表的方法");
            List<ProjectinfoResult> list = projectinfoService.projectlist(param);
            responseApi.success(list);
        } catch (Exception e) {
            log.error(e.toString());
            responseApi.fail();
        }finally {
            WebUtils.sendJSON(responseApi, response);
        }
    }

    /**
     * 查询项目列表的接口
     *
     * @author 郭晓东
     */
    @RequestMapping(value = "pojectdetail", method = RequestMethod.GET)
    public void pojectdetail(HttpServletResponse response, String data) {
        ResponseApi responseApi = new ResponseApi();
        // 解密,验证token是否失效，验证签名是否正确，拿到请求的数据。
        Map<String, String> map = SignDataTranstor.getData(data);
        // 将请求的参数转换为对象
        String id = map.get("id");
        try {
            log.info("请求了获取项目列表的方法");
            ProjectinfoResult projectinfoResult = projectinfoService.pojectdetail(id);
            responseApi.success(projectinfoResult);
        } catch (Exception e) {
            log.error(e.toString());
            responseApi.fail();
        }finally {
            WebUtils.sendJSON(responseApi, response);
        }
    }
}


