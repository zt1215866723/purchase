package com.lfxwkj.purchase.modular.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lfxwkj.purchase.modular.entity.Projectsalesperson;
import com.lfxwkj.purchase.modular.model.params.ProjectsalespersonParam;
import com.lfxwkj.purchase.modular.model.result.ProjectsalespersonResult;
import com.lfxwkj.purchase.modular.model.vo.ProjectsalepersonListVo;
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
public interface ProjectsalespersonMapper extends BaseMapper<Projectsalesperson> {

        /**
         * 获取列表
         *
         * @author 郭晓东
         * @Date 2020-03-12
         */
        List<ProjectsalespersonResult> customList(@Param("paramCondition") ProjectsalespersonParam paramCondition);

        /**
         * 获取map列表
         *
         * @author 郭晓东
         * @Date 2020-03-12
         */
        List<Map<String, Object>>customMapList(@Param("paramCondition") ProjectsalespersonParam paramCondition);

        /**
         * 获取分页实体列表
         *
         * @author 郭晓东
         * @Date 2020-03-12
         */
        Page<ProjectsalespersonResult> customPageList(@Param("page") Page page, @Param("paramCondition") ProjectsalespersonParam paramCondition);

        /**
         * 获取分页map列表
         *
         * @author 郭晓东
         * @Date 2020-03-12
         */
        Page<Map<String, Object>>customPageMapList(@Param("page") Page page, @Param("paramCondition") ProjectsalespersonParam paramCondition);

        /**
         * 查询项目顾问列表
         * @param projectID 项目主键
         * @param nums 请求条数 按照点赞数降序
         * @return
         */
    List<ProjectsalepersonListVo> projectSalespersonList(@Param("projectID") Long projectID,@Param("nums") Long nums);

}
