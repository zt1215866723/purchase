package com.lfxwkj.purchase.modular.service;

import com.lfxwkj.purchase.base.pojo.page.LayuiPageInfo;
import com.lfxwkj.purchase.modular.entity.Salefollow;
import com.lfxwkj.purchase.modular.model.params.SalefollowParam;
import com.lfxwkj.purchase.modular.model.result.SalefollowResult;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lfxwkj.purchase.modular.model.result.SalespersonResult;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 郭晓东
 * @since 2020-03-12
 */
public interface SalefollowService extends IService<Salefollow> {

        /**
         * 新增
         *
         * @author 郭晓东
         * @Date 2020-03-12
         */
        void add(SalefollowParam param);

        /**
         * 删除
         *
         * @author 郭晓东
         * @Date 2020-03-12
         */
        void delete(SalefollowParam param);

        /**
         * 更新
         *
         * @author 郭晓东
         * @Date 2020-03-12
         */
        void update(SalefollowParam param);

        /**
         * 查询单条数据，Specification模式
         *
         * @author 郭晓东
         * @Date 2020-03-12
         */
    SalefollowResult findBySpec(SalefollowParam param);

        /**
         * 查询列表，Specification模式
         *
         * @author 郭晓东
         * @Date 2020-03-12
         */
        List<SalefollowResult> findListBySpec(SalefollowParam param);

        /**
         * 查询分页数据，Specification模式
         *
         * @author 郭晓东
         * @Date 2020-03-12
         */
        LayuiPageInfo findPageBySpec(SalefollowParam param);

        /**
         * 根据客户查询销售顾问名片
         *
         * @author 王雷
         */
        List<SalespersonResult> salefollowlist(SalefollowParam param);
        }
