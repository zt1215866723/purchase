package com.lfxwkj.purchase.modular.service;

import com.lfxwkj.purchase.base.pojo.page.LayuiPageInfo;
import com.lfxwkj.purchase.modular.entity.Projectbrowse;
import com.lfxwkj.purchase.modular.model.params.ProjectbrowseParam;
import com.lfxwkj.purchase.modular.model.result.ProjectbrowseResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 郭晓东
 * @since 2020-03-12
 */
public interface ProjectbrowseService extends IService<Projectbrowse> {

        /**
         * 新增
         *
         * @author 郭晓东
         * @Date 2020-03-12
         */
        void add(ProjectbrowseParam param);

        /**
         * 删除
         *
         * @author 郭晓东
         * @Date 2020-03-12
         */
        void delete(ProjectbrowseParam param);

        /**
         * 更新
         *
         * @author 郭晓东
         * @Date 2020-03-12
         */
        void update(ProjectbrowseParam param);

        /**
         * 查询单条数据，Specification模式
         *
         * @author 郭晓东
         * @Date 2020-03-12
         */
    ProjectbrowseResult findBySpec(ProjectbrowseParam param);

        /**
         * 查询列表，Specification模式
         *
         * @author 郭晓东
         * @Date 2020-03-12
         */
        List<ProjectbrowseResult> findListBySpec(ProjectbrowseParam param);

        /**
         * 查询分页数据，Specification模式
         *
         * @author 郭晓东
         * @Date 2020-03-12
         */
        LayuiPageInfo findPageBySpec(ProjectbrowseParam param);

        }
