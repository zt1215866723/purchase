package com.lfxwkj.purchase.modular.service;

import com.lfxwkj.purchase.base.pojo.page.LayuiPageInfo;
import com.lfxwkj.purchase.modular.entity.Projectimg;
import com.lfxwkj.purchase.modular.model.params.ProjectimgParam;
import com.lfxwkj.purchase.modular.model.result.ProjectimgResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 郭晓东
 * @since 2020-03-12
 */
public interface ProjectimgService extends IService<Projectimg> {

    /**
     * 项目的图片列表，包含分类
     */
    List<ProjectimgResult> projectimglist(String projectID);

    /**
     * 新增
     *
     * @author 郭晓东
     * @Date 2020-03-12
     */
    void add(ProjectimgParam param);

    /**
     * 删除
     *
     * @author 郭晓东
     * @Date 2020-03-12
     */
    void delete(ProjectimgParam param);

    /**
     * 更新
     *
     * @author 郭晓东
     * @Date 2020-03-12
     */
    void update(ProjectimgParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author 郭晓东
     * @Date 2020-03-12
     */
    ProjectimgResult findBySpec(ProjectimgParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author 郭晓东
     * @Date 2020-03-12
     */
    List<ProjectimgResult> findListBySpec(ProjectimgParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author 郭晓东
     * @Date 2020-03-12
     */
    LayuiPageInfo findPageBySpec(ProjectimgParam param);

}
