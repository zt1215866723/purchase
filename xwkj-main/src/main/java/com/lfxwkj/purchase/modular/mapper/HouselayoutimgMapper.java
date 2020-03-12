package com.lfxwkj.purchase.modular.mapper;

import com.lfxwkj.purchase.modular.entity.Houselayoutimg;
import com.lfxwkj.purchase.modular.model.params.HouselayoutimgParam;
import com.lfxwkj.purchase.modular.model.result.HouselayoutimgResult;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
public interface HouselayoutimgMapper extends BaseMapper<Houselayoutimg> {

        /**
         * 获取列表
         *
         * @author 郭晓东
         * @Date 2020-03-12
         */
        List<HouselayoutimgResult> customList(@Param("paramCondition") HouselayoutimgParam paramCondition);

        /**
         * 获取map列表
         *
         * @author 郭晓东
         * @Date 2020-03-12
         */
        List<Map<String, Object>>customMapList(@Param("paramCondition") HouselayoutimgParam paramCondition);

        /**
         * 获取分页实体列表
         *
         * @author 郭晓东
         * @Date 2020-03-12
         */
        Page<HouselayoutimgResult> customPageList(@Param("page") Page page, @Param("paramCondition") HouselayoutimgParam paramCondition);

        /**
         * 获取分页map列表
         *
         * @author 郭晓东
         * @Date 2020-03-12
         */
        Page<Map<String, Object>>customPageMapList(@Param("page") Page page, @Param("paramCondition") HouselayoutimgParam paramCondition);

        }
