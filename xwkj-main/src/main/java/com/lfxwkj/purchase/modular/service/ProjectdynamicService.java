package com.lfxwkj.purchase.modular.service;

import com.lfxwkj.purchase.base.pojo.page.LayuiPageInfo;
import com.lfxwkj.purchase.modular.entity.Projectdynamic;
import com.lfxwkj.purchase.modular.model.params.ProjectdynamicParam;
import com.lfxwkj.purchase.modular.model.result.ProjectdynamicResult;
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
public interface ProjectdynamicService extends IService<Projectdynamic> {

        /**
         * 新增
         *
         * @author 郭晓东
         * @Date 2020-03-12
         */
        void add(ProjectdynamicParam param);

        /**
         * 删除
         *
         * @author 郭晓东
         * @Date 2020-03-12
         */
        void delete(ProjectdynamicParam param);

        /**
         * 更新
         *
         * @author 郭晓东
         * @Date 2020-03-12
         */
        void update(ProjectdynamicParam param);

        /**
         * 查询单条数据，Specification模式
         *
         * @author 郭晓东
         * @Date 2020-03-12
         */
    ProjectdynamicResult findBySpec(ProjectdynamicParam param);

        /**
         * 查询列表，Specification模式
         *
         * @author 郭晓东
         * @Date 2020-03-12
         */
        List<ProjectdynamicResult> findListBySpec(ProjectdynamicParam param);

        /**
         * 查询分页数据，Specification模式
         *
         * @author 郭晓东
         * @Date 2020-03-12
         */
        LayuiPageInfo findPageBySpec(ProjectdynamicParam param);

        }
