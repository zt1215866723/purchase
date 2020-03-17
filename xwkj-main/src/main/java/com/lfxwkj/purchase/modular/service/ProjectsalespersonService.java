package com.lfxwkj.purchase.modular.service;

import com.lfxwkj.purchase.base.pojo.page.LayuiPageInfo;
import com.lfxwkj.purchase.modular.entity.Projectsalesperson;
import com.lfxwkj.purchase.modular.model.params.ProjectsalespersonParam;
import com.lfxwkj.purchase.modular.model.result.ProjectsalespersonResult;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lfxwkj.purchase.modular.model.vo.ProjectsalepersonListVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 郭晓东
 * @since 2020-03-12
 */
public interface ProjectsalespersonService extends IService<Projectsalesperson> {

        /**
         * 新增
         *
         * @author 郭晓东
         * @Date 2020-03-12
         */
        void add(ProjectsalespersonParam param);

        /**
         * 删除
         *
         * @author 郭晓东
         * @Date 2020-03-12
         */
        void delete(ProjectsalespersonParam param);

        /**
         * 更新
         *
         * @author 郭晓东
         * @Date 2020-03-12
         */
        void update(ProjectsalespersonParam param);

        /**
         * 查询单条数据，Specification模式
         *
         * @author 郭晓东
         * @Date 2020-03-12
         */
    ProjectsalespersonResult findBySpec(ProjectsalespersonParam param);

        /**
         * 查询列表，Specification模式
         *
         * @author 郭晓东
         * @Date 2020-03-12
         */
        List<ProjectsalespersonResult> findListBySpec(ProjectsalespersonParam param);

        /**
         * 查询分页数据，Specification模式
         *
         * @author 郭晓东
         * @Date 2020-03-12
         */
        LayuiPageInfo findPageBySpec(ProjectsalespersonParam param);

    /**
     * 查询项目顾问列表
     * @param projectID 项目主键 必填
     * @param nums 请求条数
     * @return
     */
    List<ProjectsalepersonListVo> projectSalespersonList(Long projectID, Long nums);
}
