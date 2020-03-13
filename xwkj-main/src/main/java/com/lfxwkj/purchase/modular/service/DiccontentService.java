package com.lfxwkj.purchase.modular.service;

import com.lfxwkj.purchase.base.pojo.page.LayuiPageInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lfxwkj.purchase.modular.entity.Diccontent;
import com.lfxwkj.purchase.modular.model.params.DiccontentParam;
import com.lfxwkj.purchase.modular.model.result.DiccontentResult;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 郭晓东
 * @since 2020-03-13
 */
public interface DiccontentService extends IService<Diccontent> {

        /**
         * 新增
         *
         * @author 郭晓东
         * @Date 2020-03-13
         */
        void add(DiccontentParam param);

        /**
         * 删除
         *
         * @author 郭晓东
         * @Date 2020-03-13
         */
        void delete(DiccontentParam param);

        /**
         * 更新
         *
         * @author 郭晓东
         * @Date 2020-03-13
         */
        void update(DiccontentParam param);

        /**
         * 查询单条数据，Specification模式
         *
         * @author 郭晓东
         * @Date 2020-03-13
         */
    DiccontentResult findBySpec(DiccontentParam param);

        /**
         * 查询列表，Specification模式
         *
         * @author 郭晓东
         * @Date 2020-03-13
         */
        List<DiccontentResult> findListBySpec(DiccontentParam param);

        /**
         * 查询分页数据，Specification模式
         *
         * @author 郭晓东
         * @Date 2020-03-13
         */
        LayuiPageInfo findPageBySpec(DiccontentParam param);

        }
