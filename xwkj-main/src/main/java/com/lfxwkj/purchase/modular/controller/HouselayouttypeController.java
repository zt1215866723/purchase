package com.lfxwkj.purchase.modular.controller;

import com.lfxwkj.purchase.base.pojo.page.LayuiPageInfo;
import com.lfxwkj.purchase.modular.entity.Houselayouttype;
import com.lfxwkj.purchase.modular.model.params.HouselayouttypeParam;
import com.lfxwkj.purchase.modular.service.HouselayouttypeService;
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
 * @Date 2020-03-16 23:03:42
 */
@Controller
@RequestMapping("/houselayouttype")
public class HouselayouttypeController extends BaseController {

    private String PREFIX = "/xwkj-main/houselayouttype";

    @Autowired
    private HouselayouttypeService houselayouttypeService;

    /**
     * 跳转到主页面
     *
     * @author 郭晓东
     * @Date 2020-03-16
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "/houselayouttype.html";
    }

    /**
     * 新增页面
     *
     * @author 郭晓东
     * @Date 2020-03-16
     */
    @RequestMapping("/add")
    public String add() {
        return PREFIX + "/houselayouttype_add.html";
    }

    /**
     * 编辑页面
     *
     * @author 郭晓东
     * @Date 2020-03-16
     */
    @RequestMapping("/edit")
    public String edit() {
        return PREFIX + "/houselayouttype_edit.html";
    }

    /**
     * 新增接口
     *
     * @author 郭晓东
     * @Date 2020-03-16
     */
    @RequestMapping("/addItem")
    @ResponseBody
    public ResponseData addItem(HouselayouttypeParam houselayouttypeParam) {
        this.houselayouttypeService.add(houselayouttypeParam);
        return ResponseData.success();
    }

    /**
     * 编辑接口
     *
     * @author 郭晓东
     * @Date 2020-03-16
     */
    @RequestMapping("/editItem")
    @ResponseBody
    public ResponseData editItem(HouselayouttypeParam houselayouttypeParam) {
        this.houselayouttypeService.update(houselayouttypeParam);
        return ResponseData.success();
    }

    /**
     * 删除接口
     *
     * @author 郭晓东
     * @Date 2020-03-16
     */
    @RequestMapping("/delete")
    @ResponseBody
    public ResponseData delete(HouselayouttypeParam houselayouttypeParam) {
        this.houselayouttypeService.delete(houselayouttypeParam);
        return ResponseData.success();
    }

    /**
     * 查看详情接口
     *
     * @author 郭晓东
     * @Date 2020-03-16
     */
    @RequestMapping("/detail")
    @ResponseBody
    public ResponseData detail(HouselayouttypeParam houselayouttypeParam) {
        Houselayouttype detail = this.houselayouttypeService.getById(houselayouttypeParam.getId());
        return ResponseData.success(detail);
    }

    /**
     * 查询列表
     *
     * @author 郭晓东
     * @Date 2020-03-16
     */
    @ResponseBody
    @RequestMapping("/list")
    public LayuiPageInfo list(HouselayouttypeParam houselayouttypeParam) {
        return this.houselayouttypeService.findPageBySpec(houselayouttypeParam);
    }

}


