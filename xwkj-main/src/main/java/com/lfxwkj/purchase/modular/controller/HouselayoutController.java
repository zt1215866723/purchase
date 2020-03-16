package com.lfxwkj.purchase.modular.controller;

import cn.stylefeng.roses.core.mutidatasource.annotion.DataSource;
import com.lfxwkj.purchase.base.pojo.page.LayuiPageInfo;
import com.lfxwkj.purchase.modular.entity.Houselayout;
import com.lfxwkj.purchase.modular.model.params.HouselayoutParam;
import com.lfxwkj.purchase.modular.service.HouselayoutService;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.kernel.model.response.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 控制器
 *
 * @author 郭晓东
 * @Date 2020-03-12 08:45:36
 */
@Controller
@RequestMapping("/houselayout")
public class HouselayoutController extends BaseController {

    private String PREFIX = "/modular/houselayout";

    @Autowired
    private HouselayoutService houselayoutService;

    /**
     * 跳转到主页面
     *
     * @author 郭晓东
     * @Date 2020-03-12
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "/houselayout.html";
    }

    /**
     * 新增页面
     *
     * @author 郭晓东
     * @Date 2020-03-12
     */
    @RequestMapping("/add")
    public String add() {
        return PREFIX + "/houselayout_add.html";
    }

    /**
     * 编辑页面
     *
     * @author 郭晓东
     * @Date 2020-03-12
     */
    @RequestMapping("/edit")
    public String edit() {
        return PREFIX + "/houselayout_edit.html";
    }

    /**
     * 上传户型图片页面
     *
     * @author 张童
     * @Date 2020-03-13
     */
    @RequestMapping("/upload")
    public String upload() {
        return PREFIX + "/houselayoutimg.html";
    }

    /**
     * 新增接口
     *
     * @author 郭晓东
     * @Date 2020-03-12
     */
    @RequestMapping("/addItem")
    @ResponseBody
    public ResponseData addItem(HouselayoutParam houselayoutParam) {
        this.houselayoutService.add(houselayoutParam);
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
    public ResponseData editItem(HouselayoutParam houselayoutParam) {
        this.houselayoutService.update(houselayoutParam);
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
    public ResponseData delete(HouselayoutParam houselayoutParam) {
        this.houselayoutService.delete(houselayoutParam);
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
    public ResponseData detail(HouselayoutParam houselayoutParam) {
        Houselayout detail = this.houselayoutService.getById(houselayoutParam.getId());
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
    public LayuiPageInfo list(HouselayoutParam houselayoutParam) {
        return this.houselayoutService.findPageBySpec(houselayoutParam);
    }

}


