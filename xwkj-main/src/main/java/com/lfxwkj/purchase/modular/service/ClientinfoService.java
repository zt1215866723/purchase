package com.lfxwkj.purchase.modular.service;

import com.lfxwkj.purchase.base.pojo.page.LayuiPageInfo;
import com.lfxwkj.purchase.modular.entity.Clientinfo;
import com.lfxwkj.purchase.modular.model.params.ClientinfoParam;
import com.lfxwkj.purchase.modular.model.result.ClientinfoResult;
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
public interface ClientinfoService extends IService<Clientinfo> {

    /**
     * 新增
     *
     * @author 郭晓东
     * @Date 2020-03-12
     */
    void add(ClientinfoParam param);

    /**
     * 删除
     *
     * @author 郭晓东
     * @Date 2020-03-12
     */
    void delete(ClientinfoParam param);

    /**
     * 更新
     *
     * @author 郭晓东
     * @Date 2020-03-12
     */
    void update(ClientinfoParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author 郭晓东
     * @Date 2020-03-12
     */
    ClientinfoResult findBySpec(ClientinfoParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author 郭晓东
     * @Date 2020-03-12
     */
    List<ClientinfoResult> findListBySpec(ClientinfoParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author 郭晓东
     * @Date 2020-03-12
     */
    LayuiPageInfo findPageBySpec(ClientinfoParam param);

}
