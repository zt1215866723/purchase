package com.lfxwkj.purchase.modular.controller;

import com.lfxwkj.purchase.base.pojo.page.LayuiPageInfo;
import com.lfxwkj.purchase.modular.entity.Companyinfo;
import com.lfxwkj.purchase.modular.model.params.CompanyinfoParam;
import com.lfxwkj.purchase.modular.service.CompanyinfoService;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.kernel.model.response.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 企业的简介控制器
 *
 * @author 郭晓东
 * @Date 2020-03-12 08:45:36
 */
@Controller
@RequestMapping("/companyinfo")
public class CompanyinfoController extends BaseController {

    private String PREFIX = "/assets/companyinfo";

    @Autowired
    private CompanyinfoService companyinfoService;

    /**
     * 跳转到主页面
     *
     * @author 郭晓东
     * @Date 2020-03-12
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "/companyinfo.html";
    }

    /**
     * 新增页面
     *
     * @author 郭晓东
     * @Date 2020-03-12
     */
    @RequestMapping("/add")
    public String add() {
        return PREFIX + "/companyinfo_add.html";
    }

    /**
     * 编辑页面
     *
     * @author 郭晓东
     * @Date 2020-03-12
     */
    @RequestMapping("/edit")
    public String edit() {
        return PREFIX + "/companyinfo_edit.html";
    }

    /**
     * 新增接口
     *
     * @author 郭晓东
     * @Date 2020-03-12
     */
    @RequestMapping("/addItem")
    @ResponseBody
    public ResponseData addItem(CompanyinfoParam companyinfoParam) {
        this.companyinfoService.add(companyinfoParam);
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
    public ResponseData editItem(CompanyinfoParam companyinfoParam) {
        this.companyinfoService.update(companyinfoParam);
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
    public ResponseData delete(CompanyinfoParam companyinfoParam) {
        this.companyinfoService.delete(companyinfoParam);
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
    public ResponseData detail(CompanyinfoParam companyinfoParam) {
        Companyinfo detail = this.companyinfoService.getById(companyinfoParam.getId());
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
    public LayuiPageInfo list(CompanyinfoParam companyinfoParam) {
        return this.companyinfoService.findPageBySpec(companyinfoParam);
    }

}


