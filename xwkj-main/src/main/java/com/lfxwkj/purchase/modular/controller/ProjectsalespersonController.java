package com.lfxwkj.purchase.modular.controller;

import cn.stylefeng.roses.core.mutidatasource.annotion.DataSource;
import com.lfxwkj.purchase.base.pojo.page.LayuiPageInfo;
import com.lfxwkj.purchase.modular.entity.Projectsalesperson;
import com.lfxwkj.purchase.modular.model.params.ProjectsalespersonParam;
import com.lfxwkj.purchase.modular.service.ProjectsalespersonService;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.kernel.model.response.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 控制器
 *
 * @author 郭晓东
 * @Date 2020-03-12 08:45:37
 */
@Controller
@RequestMapping("/projectsalesperson")
public class ProjectsalespersonController extends BaseController {

    private String PREFIX = "/modular/projectsalesperson";

    @Autowired
    private ProjectsalespersonService projectsalespersonService;

    /**
     * 跳转到主页面
     *
     * @author 郭晓东
     * @Date 2020-03-12
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "/projectsalesperson.html";
    }

    /**
     * 新增页面
     *
     * @author 郭晓东
     * @Date 2020-03-12
     */
    @RequestMapping("/add")
    public String add() {
        return PREFIX + "/projectsalesperson_add.html";
    }

    /**
     * 编辑页面
     *
     * @author 郭晓东
     * @Date 2020-03-12
     */
    @RequestMapping("/edit")
    public String edit() {
        return PREFIX + "/projectsalesperson_edit.html";
    }

    /**
     * 新增接口
     *
     * @author 郭晓东
     * @Date 2020-03-12
     */
    @RequestMapping("/addItem")
    @ResponseBody
    public ResponseData addItem(ProjectsalespersonParam projectsalespersonParam) {
//        this.projectsalespersonService.add(projectsalespersonParam);
        return ResponseData.success();
    }

    /**
     * 编辑接口
     *
     * @author 郭晓东
     * @Date 2020-03-12
     */
    @RequestMapping("/editItem")
    @DataSource(name = "purchase")
    @ResponseBody
    public ResponseData editItem(ProjectsalespersonParam projectsalespersonParam) {
        if (projectsalespersonParam.getIsMain() == null){
            projectsalespersonParam.setIsMain(0);
        }
        this.projectsalespersonService.update(projectsalespersonParam);
        return ResponseData.success();
    }

    /**
     * 删除接口
     *
     * @author 郭晓东
     * @Date 2020-03-12
     */
    @RequestMapping("/delete")
    @DataSource(name = "purchase")
    @ResponseBody
    public ResponseData delete(ProjectsalespersonParam projectsalespersonParam) {
        this.projectsalespersonService.delete(projectsalespersonParam);
        return ResponseData.success();
    }

    /**
     * 查看详情接口
     *
     * @author 郭晓东
     * @Date 2020-03-12
     */
    @RequestMapping("/detail")
    @DataSource(name = "purchase")
    @ResponseBody
    public ResponseData detail(ProjectsalespersonParam projectsalespersonParam) {
        Projectsalesperson detail = this.projectsalespersonService.getById(projectsalespersonParam.getId());
        return ResponseData.success(detail);
    }

    /**
     * 查询列表
     *
     * @author 郭晓东
     * @Date 2020-03-12
     */
    @ResponseBody
    @DataSource(name = "purchase")
    @RequestMapping("/list")
    public LayuiPageInfo list(ProjectsalespersonParam projectsalespersonParam) {
        return this.projectsalespersonService.findPageBySpec(projectsalespersonParam);
    }

}


