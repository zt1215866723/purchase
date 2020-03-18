package com.lfxwkj.purchase.modular.api;

import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.kernel.model.response.ResponseData;
import com.lfxwkj.purchase.base.pojo.page.LayuiPageInfo;
import com.lfxwkj.purchase.modular.entity.Infolist;
import com.lfxwkj.purchase.modular.model.params.InfolistParam;
import com.lfxwkj.purchase.modular.model.params.ProjectinfoParam;
import com.lfxwkj.purchase.modular.model.result.InfolistResult;
import com.lfxwkj.purchase.modular.model.result.ProjectinfoResult;
import com.lfxwkj.purchase.modular.service.InfolistService;
import com.lfxwkj.purchase.modular.utils.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;


/**
 * 存储新闻、公告等信息控制器
 *
 * @author 郭晓东
 * @Date 2020-03-12 08:45:36
 */
@Controller
@RequestMapping("/api")
public class InfolistApiController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private InfolistService infolistService;
    /**
     * 获取公告列表接口
     *
     * @author 张童
     */
    @RequestMapping(value = "/noticelist", method = RequestMethod.GET)
    public void noticelist(HttpServletResponse response, String data) {
        ResponseApi responseApi = new ResponseApi();
        // 解密,验证token是否失效，验证签名是否正确，拿到请求的数据。
        SignData sign = JsonUtils.getData(data,SignData.class);
       // Map<String, String> map = SignDataTranstor.getData(data);
        // 将请求的参数转换为对象
        InfolistParam param = JsonUtils.getData(JsonUtils.toJSON(sign), InfolistParam.class);
        try {
            log.info("获取首页公告列表的方法");
            List<InfolistResult> list = infolistService.noticeInfoList(param);
            responseApi.success(list);
        } catch (Exception e) {
            log.error(e.toString());
            responseApi.fail();
        }finally {
            WebUtils.sendJSON(responseApi, response);
        }
    }
}


