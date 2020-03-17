package com.lfxwkj.purchase.modular.service;

import com.lfxwkj.purchase.base.pojo.page.LayuiPageInfo;
import com.lfxwkj.purchase.modular.entity.Houselayouttype;
import com.lfxwkj.purchase.modular.model.params.HouselayouttypeParam;
import com.lfxwkj.purchase.modular.model.result.HouselayouttypeResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 郭晓东
 * @since 2020-03-16
 */
public interface HouselayouttypeService extends IService<Houselayouttype> {

    /**
     * 新增
     *
     * @author 郭晓东
     * @Date 2020-03-16
     */
    void add(HouselayouttypeParam param);

    /**
     * 删除
     *
     * @author 郭晓东
     * @Date 2020-03-16
     */
    void delete(HouselayouttypeParam param);

    /**
     * 更新
     *
     * @author 郭晓东
     * @Date 2020-03-16
     */
    void update(HouselayouttypeParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author 郭晓东
     * @Date 2020-03-16
     */
    HouselayouttypeResult findBySpec(HouselayouttypeParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author 郭晓东
     * @Date 2020-03-16
     */
    List<HouselayouttypeResult> findListBySpec(HouselayouttypeParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author 郭晓东
     * @Date 2020-03-16
     */
    LayuiPageInfo findPageBySpec(HouselayouttypeParam param);

}
