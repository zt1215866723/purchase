package com.lfxwkj.purchase.modular.service;

import com.lfxwkj.purchase.base.pojo.page.LayuiPageInfo;
import com.lfxwkj.purchase.modular.entity.Houselayout;
import com.lfxwkj.purchase.modular.model.params.HouselayoutParam;
import com.lfxwkj.purchase.modular.model.result.HouselayoutResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 郭晓东
 * @since 2020-03-12
 */
public interface HouselayoutService extends IService<Houselayout> {

        /**
         * 新增
         *
         * @author 郭晓东
         * @Date 2020-03-12
         */
        void add(HouselayoutParam param);

        /**
         * 删除
         *
         * @author 郭晓东
         * @Date 2020-03-12
         */
        void delete(HouselayoutParam param);

        /**
         * 更新
         *
         * @author 郭晓东
         * @Date 2020-03-12
         */
        void update(HouselayoutParam param);

        /**
         * 查询单条数据，Specification模式
         *
         * @author 郭晓东
         * @Date 2020-03-12
         */
    HouselayoutResult findBySpec(HouselayoutParam param);

        /**
         * 查询列表，Specification模式
         *
         * @author 郭晓东
         * @Date 2020-03-12
         */
        List<HouselayoutResult> findListBySpec(HouselayoutParam param);

        /**
         * 查询分页数据，Specification模式
         *
         * @author 郭晓东
         * @Date 2020-03-12
         */
        LayuiPageInfo findPageBySpec(HouselayoutParam param);

        }
