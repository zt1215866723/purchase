package com.lfxwkj.purchase.modular.service;

import com.lfxwkj.purchase.base.pojo.page.LayuiPageInfo;
import com.lfxwkj.purchase.modular.entity.Dictype;
import com.lfxwkj.purchase.modular.model.params.DictypeParam;
import com.lfxwkj.purchase.modular.model.result.DictypeResult;
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
public interface DictypeService extends IService<Dictype> {

        /**
         * 新增
         *
         * @author 郭晓东
         * @Date 2020-03-12
         */
        void add(DictypeParam param);

        /**
         * 删除
         *
         * @author 郭晓东
         * @Date 2020-03-12
         */
        void delete(DictypeParam param);

        /**
         * 更新
         *
         * @author 郭晓东
         * @Date 2020-03-12
         */
        void update(DictypeParam param);

        /**
         * 查询单条数据，Specification模式
         *
         * @author 郭晓东
         * @Date 2020-03-12
         */
    DictypeResult findBySpec(DictypeParam param);

        /**
         * 查询列表，Specification模式
         *
         * @author 郭晓东
         * @Date 2020-03-12
         */
        List<DictypeResult> findListBySpec(DictypeParam param);

        /**
         * 查询分页数据，Specification模式
         *
         * @author 郭晓东
         * @Date 2020-03-12
         */
        LayuiPageInfo findPageBySpec(DictypeParam param);

        }
