package com.lfxwkj.purchase.modular.api;

import cn.stylefeng.roses.core.mutidatasource.annotion.DataSource;
import com.lfxwkj.purchase.modular.model.vo.ProjectsalepersonListVo;
import com.lfxwkj.purchase.modular.service.ProjectsalespersonService;
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
public class ProjectsalespersonApiController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ProjectsalespersonService projectsalespersonService;

    /**
     * 查询项目顾问列表
     * @param response
     * @param data
     * @author wanglei
     */
    @DataSource(name = "purchase")
    @RequestMapping(value = "/projectSalespersonList", method = RequestMethod.POST)
    public void projectSalespersonList(HttpServletResponse response, String data) {
        ResponseApi responseApi = new ResponseApi();
        // 解密,验证token是否失效，验证签名是否正确，拿到请求的数据。
        Map<String, String> map = SignDataTranstor.getData(data);
        // 将请求的参数转换为对象
        Long projectID = Long.parseLong(map.get("projectID"));
        Long nums = Long.parseLong(map.get("nums"));
        try {
            log.info("请求了获取项目顾问列表的接口");
            List<ProjectsalepersonListVo> list = projectsalespersonService.projectSalespersonList(projectID,nums);
            responseApi.success(list);
        } catch (Exception e) {
            log.error(e.toString());
            responseApi.fail();
        }finally {
            WebUtils.sendJSON(responseApi, response);
        }
    }
}


