package com.lfxwkj.purchase.modular.service;

import com.lfxwkj.purchase.base.pojo.page.LayuiPageInfo;
import com.lfxwkj.purchase.modular.entity.Companyinfo;
import com.lfxwkj.purchase.modular.model.params.CompanyinfoParam;
import com.lfxwkj.purchase.modular.model.result.CompanyinfoResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 企业的简介 服务类
 * </p>
 *
 * @author 郭晓东
 * @since 2020-03-12
 */
public interface CompanyinfoService extends IService<Companyinfo> {

        /**
         * 新增
         *
         * @author 郭晓东
         * @Date 2020-03-12
         */
        void add(CompanyinfoParam param);

        /**
         * 删除
         *
         * @author 郭晓东
         * @Date 2020-03-12
         */
        void delete(CompanyinfoParam param);

        /**
         * 更新
         *
         * @author 郭晓东
         * @Date 2020-03-12
         */
        void update(CompanyinfoParam param);

        /**
         * 查询单条数据，Specification模式
         *
         * @author 郭晓东
         * @Date 2020-03-12
         */
    CompanyinfoResult findBySpec(CompanyinfoParam param);

        /**
         * 查询列表，Specification模式
         *
         * @author 郭晓东
         * @Date 2020-03-12
         */
        List<CompanyinfoResult> findListBySpec(CompanyinfoParam param);

        /**
         * 查询分页数据，Specification模式
         *
         * @author 郭晓东
         * @Date 2020-03-12
         */
        LayuiPageInfo findPageBySpec(CompanyinfoParam param);

        }
