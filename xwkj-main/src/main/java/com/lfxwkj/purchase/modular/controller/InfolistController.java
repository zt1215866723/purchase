package com.lfxwkj.purchase.modular.controller;

import cn.stylefeng.roses.core.mutidatasource.annotion.DataSource;
import com.lfxwkj.purchase.base.pojo.page.LayuiPageInfo;
import com.lfxwkj.purchase.modular.entity.Infolist;
import com.lfxwkj.purchase.modular.model.params.InfolistParam;
import com.lfxwkj.purchase.modular.service.InfolistService;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.kernel.model.response.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 存储新闻、公告等信息控制器
 *
 * @author 郭晓东
 * @Date 2020-03-12 08:45:36
 */
@Controller
@RequestMapping("/infolist")
public class InfolistController extends BaseController {

    private String PREFIX = "/modular/infolist";

    @Autowired
    private InfolistService infolistService;

    /**
     * 跳转到主页面
     *
     * @author 郭晓东
     * @Date 2020-03-12
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "/infolist.html";
    }

    /**
     * 新增页面
     *
     * @author 郭晓东
     * @Date 2020-03-12
     */
    @RequestMapping("/add")
    public String add() {
        return PREFIX + "/infolist_add.html";
    }

    /**
     * 编辑页面
     *
     * @author 郭晓东
     * @Date 2020-03-12
     */
    @RequestMapping("/edit")
    public String edit() {
        return PREFIX + "/infolist_edit.html";
    }

    /**
     * 新增接口
     *
     * @author 郭晓东
     * @Date 2020-03-12
     */
    @RequestMapping("/addItem")
    @ResponseBody
    public ResponseData addItem(InfolistParam infolistParam) {
        this.infolistService.add(infolistParam);
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
    public ResponseData editItem(InfolistParam infolistParam) {
        this.infolistService.update(infolistParam);
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
    public ResponseData delete(InfolistParam infolistParam) {
        this.infolistService.delete(infolistParam);
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
    public ResponseData detail(InfolistParam infolistParam) {
        Infolist detail = this.infolistService.getById(infolistParam.getId());
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
    public LayuiPageInfo list(InfolistParam infolistParam) {
        return this.infolistService.findPageBySpec(infolistParam);
    }

}


