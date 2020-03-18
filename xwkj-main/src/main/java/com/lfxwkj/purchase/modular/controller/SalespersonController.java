package com.lfxwkj.purchase.modular.controller;

import com.lfxwkj.purchase.base.pojo.page.LayuiPageInfo;
import com.lfxwkj.purchase.modular.entity.Salesperson;
import com.lfxwkj.purchase.modular.model.params.SalespersonParam;
import com.lfxwkj.purchase.modular.model.result.SalespersonResult;
import com.lfxwkj.purchase.modular.service.SalespersonService;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.kernel.model.response.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * 控制器
 *
 * @author 郭晓东
 * @Date 2020-03-12 08:45:37
 */
@Controller
@RequestMapping("/salesperson")
public class SalespersonController extends BaseController {

    private String PREFIX = "/assets/salesperson";

    @Autowired
    private SalespersonService salespersonService;

    /**
     * 跳转到主页面
     *
     * @author 郭晓东
     * @Date 2020-03-12
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "/salesperson.html";
    }

    /**
     * 新增页面
     *
     * @author 郭晓东
     * @Date 2020-03-12
     */
    @RequestMapping("/add")
    public String add() {
        return PREFIX + "/salesperson_add.html";
    }

    /**
     * 编辑页面
     *
     * @author 郭晓东
     * @Date 2020-03-12
     */
    @RequestMapping("/edit")
    public String edit() {
        return PREFIX + "/salesperson_edit.html";
    }

    /**
     * 新增接口
     *
     * @author 郭晓东
     * @Date 2020-03-12
     */
    @RequestMapping("/addItem")
    @ResponseBody
    public ResponseData addItem(SalespersonParam salespersonParam) {
        this.salespersonService.add(salespersonParam);
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
    public ResponseData editItem(SalespersonParam salespersonParam) {
        this.salespersonService.update(salespersonParam);
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
    public ResponseData delete(SalespersonParam salespersonParam) {
        this.salespersonService.delete(salespersonParam);
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
    public ResponseData detail(SalespersonParam salespersonParam) {
        Salesperson detail = this.salespersonService.getById(salespersonParam.getId());
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
    public LayuiPageInfo list(SalespersonParam salespersonParam) {
        return this.salespersonService.findPageBySpec(salespersonParam);
    }

    /**
     * 查询列表
     *
     * @author 郭晓东
     * @Date 2020-03-12
     */
    @ResponseBody
    @RequestMapping("/personlist")
    public List<SalespersonResult> personList(SalespersonParam salespersonParam) {
        return this.salespersonService.findListBySpec(salespersonParam);
    }
}


