package com.lfxwkj.purchase.modular.mapper;

import com.lfxwkj.purchase.modular.entity.Clientinfo;
import com.lfxwkj.purchase.modular.model.params.ClientinfoParam;
import com.lfxwkj.purchase.modular.model.result.ClientinfoResult;
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
public interface ClientinfoMapper extends BaseMapper<Clientinfo> {

        /**
         * 获取列表
         *
         * @author 郭晓东
         * @Date 2020-03-12
         */
        List<ClientinfoResult> customList(@Param("paramCondition") ClientinfoParam paramCondition);

        /**
         * 获取map列表
         *
         * @author 郭晓东
         * @Date 2020-03-12
         */
        List<Map<String, Object>>customMapList(@Param("paramCondition") ClientinfoParam paramCondition);

        /**
         * 获取分页实体列表
         *
         * @author 郭晓东
         * @Date 2020-03-12
         */
        Page<ClientinfoResult> customPageList(@Param("page") Page page, @Param("paramCondition") ClientinfoParam paramCondition);

        /**
         * 获取分页map列表
         *
         * @author 郭晓东
         * @Date 2020-03-12
         */
        Page<Map<String, Object>>customPageMapList(@Param("page") Page page, @Param("paramCondition") ClientinfoParam paramCondition);

        }
