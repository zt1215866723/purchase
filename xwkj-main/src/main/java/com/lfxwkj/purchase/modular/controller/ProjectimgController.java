package com.lfxwkj.purchase.modular.controller;

import com.lfxwkj.purchase.base.pojo.page.LayuiPageInfo;
import com.lfxwkj.purchase.modular.entity.Projectimg;
import com.lfxwkj.purchase.modular.model.params.ProjectimgParam;
import com.lfxwkj.purchase.modular.service.ProjectimgService;
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
@RequestMapping("/projectimg")
public class ProjectimgController extends BaseController {

    private String PREFIX = "/assets/projectimg";

    @Autowired
    private ProjectimgService projectimgService;

    /**
     * 跳转到主页面
     *
     * @author 郭晓东
     * @Date 2020-03-12
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "/projectimg.html";
    }

    /**
     * 新增页面
     *
     * @author 郭晓东
     * @Date 2020-03-12
     */
    @RequestMapping("/add")
    public String add() {
        return PREFIX + "/projectimg_add.html";
    }

    /**
     * 编辑页面
     *
     * @author 郭晓东
     * @Date 2020-03-12
     */
    @RequestMapping("/edit")
    public String edit() {
        return PREFIX + "/projectimg_edit.html";
    }

    /**
     * 新增接口
     *
     * @author 郭晓东
     * @Date 2020-03-12
     */
    @RequestMapping("/addItem")
    @ResponseBody
    public ResponseData addItem(ProjectimgParam projectimgParam) {
        this.projectimgService.add(projectimgParam);
        return ResponseData.success();
    }

    /**
     * 编辑接口
     *
     * @author 郭晓东
     * @Date 2020-03-12
     */
    @RequestMapping("/editItem")
    @ResponseBody
    public ResponseData editItem(ProjectimgParam projectimgParam) {
        this.projectimgService.update(projectimgParam);
        return ResponseData.success();
    }

    /**
     * 删除接口
     *
     * @author 郭晓东
     * @Date 2020-03-12
     */
    @RequestMapping("/delete")
    @ResponseBody
    public ResponseData delete(ProjectimgParam projectimgParam) {
        this.projectimgService.delete(projectimgParam);
        return ResponseData.success();
    }

    /**
     * 查看详情接口
     *
     * @author 郭晓东
     * @Date 2020-03-12
     */
    @RequestMapping("/detail")
    @ResponseBody
    public ResponseData detail(ProjectimgParam projectimgParam) {
        Projectimg detail = this.projectimgService.getById(projectimgParam.getId());
        return ResponseData.success(detail);
    }

    /**
     * 查询列表
     *
     * @author 郭晓东
     * @Date 2020-03-12
     */
    @ResponseBody
    @RequestMapping("/list")
    public LayuiPageInfo list(ProjectimgParam projectimgParam) {
        return this.projectimgService.findPageBySpec(projectimgParam);
    }

}


