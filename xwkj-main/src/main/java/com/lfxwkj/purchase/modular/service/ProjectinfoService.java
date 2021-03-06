package com.lfxwkj.purchase.modular.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lfxwkj.purchase.base.pojo.page.LayuiPageInfo;
import com.lfxwkj.purchase.modular.api.result.Moredetail;
import com.lfxwkj.purchase.modular.api.result.Projectdetail;
import com.lfxwkj.purchase.modular.api.result.Projectlist;
import com.lfxwkj.purchase.modular.entity.Projectinfo;
import com.lfxwkj.purchase.modular.model.params.ProjectinfoParam;
import com.lfxwkj.purchase.modular.model.result.ProjectinfoResult;
import com.sun.jna.WString;

import java.util.List;


/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 郭晓东
 * @since 2020-03-13
 */
public interface ProjectinfoService extends IService<Projectinfo> {
    /**
     * 更多项目详情
     */
    Moredetail moredetail(String id);

    /**
     * 手机端项目的详情
     *
     */
    Projectdetail pojectdetail(String id);

    /**
     * 手机端查询项目的列表
     */
    List<Projectlist> projectlist(ProjectinfoParam param);

    /**
     * 新增
     *
     * @author 郭晓东
     * @Date 2020-03-13
     */
    void add(ProjectinfoParam param);

    /**
     * 删除
     *
     * @author 郭晓东
     * @Date 2020-03-13
     */
    void delete(ProjectinfoParam param);

    /**
     * 更新
     *
     * @author 郭晓东
     * @Date 2020-03-13
     */
    void update(ProjectinfoParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author 郭晓东
     * @Date 2020-03-13
     */
    ProjectinfoResult findBySpec(ProjectinfoParam param);

    /**
     * 查询列表，Specification模式
     * <p>
     * 注意 ： 手机端接口用了它返回了数据，
     *
     * @author 郭晓东
     * @Date 2020-03-13
     */
    List<ProjectinfoResult> findListBySpec(ProjectinfoParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author 郭晓东
     * @Date 2020-03-13
     */
    LayuiPageInfo findPageBySpec(ProjectinfoParam param);

}
