package com.lfxwkj.purchase.modular.controller;

import com.lfxwkj.purchase.base.pojo.page.LayuiPageInfo;
import com.lfxwkj.purchase.modular.entity.Houselayoutimg;
import com.lfxwkj.purchase.modular.model.params.HouselayoutimgParam;
import com.lfxwkj.purchase.modular.service.HouselayoutimgService;
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
 * @Date 2020-03-12 08:45:36
 */
@Controller
@RequestMapping("/houselayoutimg")
public class HouselayoutimgController extends BaseController {

    private String PREFIX = "/assets/houselayoutimg";

    @Autowired
    private HouselayoutimgService houselayoutimgService;

    /**
     * 跳转到主页面
     *
     * @author 郭晓东
     * @Date 2020-03-12
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "/houselayoutimg.html";
    }

    /**
     * 新增页面
     *
     * @author 郭晓东
     * @Date 2020-03-12
     */
    @RequestMapping("/add")
    public String add() {
        return PREFIX + "/houselayoutimg_add.html";
    }

    /**
     * 编辑页面
     *
     * @author 郭晓东
     * @Date 2020-03-12
     */
    @RequestMapping("/edit")
    public String edit() {
        return PREFIX + "/houselayoutimg_edit.html";
    }

    /**
     * 新增接口
     *
     * @author 郭晓东
     * @Date 2020-03-12
     */
    @RequestMapping("/addItem")
    @ResponseBody
    public ResponseData addItem(HouselayoutimgParam houselayoutimgParam) {
        this.houselayoutimgService.add(houselayoutimgParam);
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
    public ResponseData editItem(HouselayoutimgParam houselayoutimgParam) {
        this.houselayoutimgService.update(houselayoutimgParam);
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
    public ResponseData delete(HouselayoutimgParam houselayoutimgParam) {
        this.houselayoutimgService.delete(houselayoutimgParam);
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
    public ResponseData detail(HouselayoutimgParam houselayoutimgParam) {
        Houselayoutimg detail = this.houselayoutimgService.getById(houselayoutimgParam.getId());
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
    public LayuiPageInfo list(HouselayoutimgParam houselayoutimgParam) {
        return this.houselayoutimgService.findPageBySpec(houselayoutimgParam);
    }

}


