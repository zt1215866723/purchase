package com.lfxwkj.purchase.modular.controller;


import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.core.mutidatasource.annotion.DataSource;
import cn.stylefeng.roses.kernel.model.response.ResponseData;
import com.lfxwkj.purchase.base.pojo.page.LayuiPageInfo;
import com.lfxwkj.purchase.modular.entity.Projectinfo;
import com.lfxwkj.purchase.modular.model.params.ProjectinfoParam;
import com.lfxwkj.purchase.modular.service.ProjectinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 控制器
 *
 * @author 郭晓东
 * @Date 2020-03-13 10:47:26
 */
@Controller
@RequestMapping("/projectinfo")
public class ProjectinfoController extends BaseController {

    private String PREFIX = "/xwkj-main/projectinfo";

    @Autowired
    private ProjectinfoService projectinfoService;

    /**
     * 跳转到主页面
     *
     * @author 郭晓东
     * @Date 2020-03-13
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "/projectinfo.html";
    }

    /**
     * 新增页面
     *
     * @author 郭晓东
     * @Date 2020-03-13
     */
    @RequestMapping("/add")
    public String add() {
        return PREFIX + "/projectinfo_add.html";
    }

    /**
     * 编辑页面
     *
     * @author 郭晓东
     * @Date 2020-03-13
     */
    @RequestMapping("/edit")
    public String edit() {
        return PREFIX + "/projectinfo_edit.html";
    }

    /**
     * 新增接口
     *
     * @author 郭晓东
     * @Date 2020-03-13
     */
    @RequestMapping("/addItem")
    @ResponseBody
    public ResponseData addItem(ProjectinfoParam projectinfoParam) {
        this.projectinfoService.add(projectinfoParam);
        return ResponseData.success();
    }

    /**
     * 编辑接口
     *
     * @author 郭晓东
     * @Date 2020-03-13
     */
    @RequestMapping("/editItem")
    @ResponseBody
    public ResponseData editItem(ProjectinfoParam projectinfoParam) {
        this.projectinfoService.update(projectinfoParam);
        return ResponseData.success();
    }

    /**
     * 删除接口
     *
     * @author 郭晓东
     * @Date 2020-03-13
     */
    @RequestMapping("/delete")
    @ResponseBody
    public ResponseData delete(ProjectinfoParam projectinfoParam) {
        this.projectinfoService.delete(projectinfoParam);
        return ResponseData.success();
    }

    /**
     * 查看详情接口
     *
     * @author 郭晓东
     * @Date 2020-03-13
     */
    @RequestMapping("/detail")
    @ResponseBody
    public ResponseData detail(ProjectinfoParam projectinfoParam) {
        Projectinfo detail = this.projectinfoService.getById(projectinfoParam.getId());
        return ResponseData.success(detail);
    }

    /**
     * 查询列表
     *
     * @author 郭晓东
     * @Date 2020-03-13
     */
    @ResponseBody
    @DataSource(name = "purchase")
    @RequestMapping("/list")
    public LayuiPageInfo list(ProjectinfoParam projectinfoParam) {
        return this.projectinfoService.findPageBySpec(projectinfoParam);
    }

}


