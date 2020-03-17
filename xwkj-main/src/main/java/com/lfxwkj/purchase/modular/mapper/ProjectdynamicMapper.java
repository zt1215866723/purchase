package com.lfxwkj.purchase.modular.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lfxwkj.purchase.modular.entity.Projectdynamic;
import com.lfxwkj.purchase.modular.model.params.ProjectdynamicParam;
import com.lfxwkj.purchase.modular.model.result.ProjectdynamicResult;
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
public interface ProjectdynamicMapper extends BaseMapper<Projectdynamic> {

        /**
         * 获取列表
         *
         * @author 郭晓东
         * @Date 2020-03-12
         */
        List<ProjectdynamicResult> customList(@Param("paramCondition") ProjectdynamicParam paramCondition);

        /**
         * 获取map列表
         *
         * @author 郭晓东
         * @Date 2020-03-12
         */
        List<Map<String, Object>>customMapList(@Param("paramCondition") ProjectdynamicParam paramCondition);

        /**
         * 获取分页实体列表
         *
         * @author 郭晓东
         * @Date 2020-03-12
         */
        Page<ProjectdynamicResult> customPageList(@Param("page") Page page, @Param("paramCondition") ProjectdynamicParam paramCondition);

        /**
         * 获取分页map列表
         *
         * @author 郭晓东
         * @Date 2020-03-12
         */
        Page<Map<String, Object>>customPageMapList(@Param("page") Page page, @Param("paramCondition") ProjectdynamicParam paramCondition);

        /**
         * 查询项目动态
         * @param param 项目主键 必填
         * @return
         */
    List<ProjectdynamicResult> projectDynamicList(@Param("param") ProjectdynamicParam param);
}
