package com.lfxwkj.purchase.modular.service;

import com.lfxwkj.purchase.base.pojo.page.LayuiPageInfo;
import com.lfxwkj.purchase.modular.entity.Projectarea;
import com.lfxwkj.purchase.modular.model.params.ProjectareaParam;
import com.lfxwkj.purchase.modular.model.result.ProjectareaResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 项目所属区域 服务类
 * </p>
 *
 * @author 郭晓东
 * @since 2020-03-12
 */
public interface ProjectareaService extends IService<Projectarea> {

        /**
         * 新增
         *
         * @author 郭晓东
         * @Date 2020-03-12
         */
        void add(ProjectareaParam param);

        /**
         * 删除
         *
         * @author 郭晓东
         * @Date 2020-03-12
         */
        void delete(ProjectareaParam param);

        /**
         * 更新
         *
         * @author 郭晓东
         * @Date 2020-03-12
         */
        void update(ProjectareaParam param);

        /**
         * 查询单条数据，Specification模式
         *
         * @author 郭晓东
         * @Date 2020-03-12
         */
    ProjectareaResult findBySpec(ProjectareaParam param);

        /**
         * 查询列表，Specification模式
         *
         * @author 郭晓东
         * @Date 2020-03-12
         */
        List<ProjectareaResult> findListBySpec(ProjectareaParam param);

        /**
         * 查询分页数据，Specification模式
         *
         * @author 郭晓东
         * @Date 2020-03-12
         */
        LayuiPageInfo findPageBySpec(ProjectareaParam param);

        }
