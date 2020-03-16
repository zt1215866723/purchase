package com.lfxwkj.purchase.modular.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lfxwkj.purchase.modular.entity.Diccontent;
import com.lfxwkj.purchase.modular.model.params.DiccontentParam;
import com.lfxwkj.purchase.modular.model.result.DiccontentResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 郭晓东
 * @since 2020-03-13
 */
public interface DiccontentMapper extends BaseMapper<Diccontent> {

        /**
         * 获取列表
         *
         * @author 郭晓东
         * @Date 2020-03-13
         */
        List<DiccontentResult> customList(@Param("paramCondition") DiccontentParam paramCondition);

        /**
         * 获取map列表
         *
         * @author 郭晓东
         * @Date 2020-03-13
         */
        List<Map<String, Object>>customMapList(@Param("paramCondition") DiccontentParam paramCondition);

        /**
         * 获取分页实体列表
         *
         * @author 郭晓东
         * @Date 2020-03-13
         */
        Page<DiccontentResult> customPageList(@Param("page") Page page, @Param("paramCondition") DiccontentParam paramCondition);

        /**
         * 获取分页map列表
         *
         * @author 郭晓东
         * @Date 2020-03-13
         */
        Page<Map<String, Object>>customPageMapList(@Param("page") Page page, @Param("paramCondition") DiccontentParam paramCondition);

        }
