package com.lfxwkj.purchase.modular.service;

import com.lfxwkj.purchase.base.pojo.page.LayuiPageInfo;
import com.lfxwkj.purchase.modular.entity.Infolist;
import com.lfxwkj.purchase.modular.model.params.InfolistParam;
import com.lfxwkj.purchase.modular.model.result.InfolistResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 存储新闻、公告等信息 
 服务类
 * </p>
 *
 * @author 郭晓东
 * @since 2020-03-12
 */
public interface InfolistService extends IService<Infolist> {

        /**
         * 新增
         *
         * @author 郭晓东
         * @Date 2020-03-12
         */
        void add(InfolistParam param);

        /**
         * 删除
         *
         * @author 郭晓东
         * @Date 2020-03-12
         */
        void delete(InfolistParam param);

        /**
         * 更新
         *
         * @author 郭晓东
         * @Date 2020-03-12
         */
        void update(InfolistParam param);

        /**
         * 查询单条数据，Specification模式
         *
         * @author 郭晓东
         * @Date 2020-03-12
         */
    InfolistResult findBySpec(InfolistParam param);

        /**
         * 查询列表，Specification模式
         *
         * @author 郭晓东
         * @Date 2020-03-12
         */
        List<InfolistResult> findListBySpec(InfolistParam param);

        /**
         * 查询分页数据，Specification模式
         *
         * @author 郭晓东
         * @Date 2020-03-12
         */
        LayuiPageInfo findPageBySpec(InfolistParam param);

        /**
         * @Description  ：
         * @methodName   : 小程序获取公告列表
         * @param        : * @param null :
         * @return       :
         * @exception    :
         * @author       : 张童
         */
        List<InfolistResult> noticeInfoList(InfolistParam param);
        }
