package com.lfxwkj.purchase.modular.controller;


import com.lfxwkj.purchase.base.pojo.page.LayuiPageInfo;
import com.lfxwkj.purchase.modular.entity.Diccontent;
import com.lfxwkj.purchase.modular.model.params.DiccontentParam;
import com.lfxwkj.purchase.modular.service.DiccontentService;
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
 * @Date 2020-03-13 10:47:26
 */
@Controller
@RequestMapping("/diccontent")
public class DiccontentController extends BaseController {

    private String PREFIX = "/xwkj-main/diccontent";

    @Autowired
    private DiccontentService diccontentService;

    /**
     * 跳转到主页面
     *
     * @author 郭晓东
     * @Date 2020-03-13
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "/diccontent.html";
    }

    /**
     * 新增页面
     *
     * @author 郭晓东
     * @Date 2020-03-13
     */
    @RequestMapping("/add")
    public String add() {
        return PREFIX + "/diccontent_add.html";
    }

    /**
     * 编辑页面
     *
     * @author 郭晓东
     * @Date 2020-03-13
     */
    @RequestMapping("/edit")
    public String edit() {
        return PREFIX + "/diccontent_edit.html";
    }

    /**
     * 新增接口
     *
     * @author 郭晓东
     * @Date 2020-03-13
     */
    @RequestMapping("/addItem")
    @ResponseBody
    public ResponseData addItem(DiccontentParam diccontentParam) {
        this.diccontentService.add(diccontentParam);
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
    public ResponseData editItem(DiccontentParam diccontentParam) {
        this.diccontentService.update(diccontentParam);
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
    public ResponseData delete(DiccontentParam diccontentParam) {
        this.diccontentService.delete(diccontentParam);
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
    public ResponseData detail(DiccontentParam diccontentParam) {
        Diccontent detail = this.diccontentService.getById(diccontentParam.getId());
        return ResponseData.success(detail);
    }

    /**
     * 查询列表
     *
     * @author 郭晓东
     * @Date 2020-03-13
     */
    @ResponseBody
    @RequestMapping("/list")
    public LayuiPageInfo list(DiccontentParam diccontentParam) {
        return this.diccontentService.findPageBySpec(diccontentParam);
    }

}


