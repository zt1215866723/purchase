package com.lfxwkj.purchase.modular.api;

import com.lfxwkj.purchase.modular.api.result.Projectdetail;
import com.lfxwkj.purchase.modular.entity.Projectimg;
import com.lfxwkj.purchase.modular.model.result.ProjectimgResult;
import com.lfxwkj.purchase.modular.service.ProjectimgService;
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
public class ProjectimgApiController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ProjectimgService projectimgService;

    /**
     * 项目的图片
     *
     * @author 郭晓东
     */
    @RequestMapping(value = "projectimglist", method = {RequestMethod.GET, RequestMethod.POST} )
    public void projectimglist(HttpServletResponse response, String data) {
        ResponseApi responseApi = new ResponseApi();
        // 解密,验证token是否失效，验证签名是否正确，拿到请求的数据。
        Map<String, String> map = SignDataTranstor.getData(data);
        // 将请求的参数转换为对象
        String projectID = map.get("projectID");
        try {
            log.info("请求了获取项目详情的方法");
            List<ProjectimgResult> projectdetail = projectimgService.projectimglist(projectID);
            responseApi.success(projectdetail);
        } catch (Exception e) {
            log.error(e.toString());
            responseApi.fail();
        } finally {
            WebUtils.sendJSON(responseApi, response);
        }
    }

}


