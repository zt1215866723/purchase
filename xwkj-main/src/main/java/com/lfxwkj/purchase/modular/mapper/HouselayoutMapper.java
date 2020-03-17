package com.lfxwkj.purchase.modular.mapper;

import com.lfxwkj.purchase.modular.api.result.HouselayoutVo;
import com.lfxwkj.purchase.modular.entity.Houselayout;
import com.lfxwkj.purchase.modular.model.params.HouselayoutParam;
import com.lfxwkj.purchase.modular.model.params.ProjectinfoParam;
import com.lfxwkj.purchase.modular.model.result.HouselayoutResult;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lfxwkj.purchase.modular.model.result.ProjectinfoResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 郭晓东
 * @since 2020-03-12
 */
public interface HouselayoutMapper extends BaseMapper<Houselayout> {

        /**
         * 获取列表
         *
         * @author 郭晓东
         * @Date 2020-03-12
         */
        List<HouselayoutResult> customList(@Param("paramCondition") HouselayoutParam paramCondition);

        /**
         * 获取map列表
         *
         * @author 郭晓东
         * @Date 2020-03-12
         */
        List<Map<String, Object>>customMapList(@Param("paramCondition") HouselayoutParam paramCondition);

        /**
         * 获取分页实体列表
         *
         * @author 郭晓东
         * @Date 2020-03-12
         */
        Page<HouselayoutResult> customPageList(@Param("page") Page page, @Param("paramCondition") HouselayoutParam paramCondition);

        /**
         * 获取分页map列表
         *
         * @author 郭晓东
         * @Date 2020-03-12
         */
        Page<Map<String, Object>>customPageMapList(@Param("page") Page page, @Param("paramCondition") HouselayoutParam paramCondition);

        /**
         * 手机端主力户型接口， 户型列表的方法
         * 张童
         */
        List<HouselayoutVo> houselayoutList(HouselayoutParam paramCondition);

        /**
         * 手机端户型详情方法
         * 张童
         */
        HouselayoutVo houselayoutDetails(HouselayoutParam paramCondition);
        }
