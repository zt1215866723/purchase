package com.lfxwkj.purchase.modular.mapper;

import com.lfxwkj.purchase.modular.entity.Companyinfo;
import com.lfxwkj.purchase.modular.model.params.CompanyinfoParam;
import com.lfxwkj.purchase.modular.model.result.CompanyinfoResult;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 企业的简介 Mapper 接口
 * </p>
 *
 * @author 郭晓东
 * @since 2020-03-12
 */
public interface CompanyinfoMapper extends BaseMapper<Companyinfo> {

        /**
         * 获取列表
         *
         * @author 郭晓东
         * @Date 2020-03-12
         */
        List<CompanyinfoResult> customList(@Param("paramCondition") CompanyinfoParam paramCondition);

        /**
         * 获取map列表
         *
         * @author 郭晓东
         * @Date 2020-03-12
         */
        List<Map<String, Object>>customMapList(@Param("paramCondition") CompanyinfoParam paramCondition);

        /**
         * 获取分页实体列表
         *
         * @author 郭晓东
         * @Date 2020-03-12
         */
        Page<CompanyinfoResult> customPageList(@Param("page") Page page, @Param("paramCondition") CompanyinfoParam paramCondition);

        /**
         * 获取分页map列表
         *
         * @author 郭晓东
         * @Date 2020-03-12
         */
        Page<Map<String, Object>>customPageMapList(@Param("page") Page page, @Param("paramCondition") CompanyinfoParam paramCondition);

        }
