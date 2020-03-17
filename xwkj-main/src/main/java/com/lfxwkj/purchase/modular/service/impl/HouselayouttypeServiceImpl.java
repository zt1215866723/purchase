package com.lfxwkj.purchase.modular.service.impl;

import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lfxwkj.purchase.base.pojo.page.LayuiPageFactory;
import com.lfxwkj.purchase.base.pojo.page.LayuiPageInfo;
import com.lfxwkj.purchase.modular.entity.Houselayouttype;
import com.lfxwkj.purchase.modular.mapper.HouselayouttypeMapper;
import com.lfxwkj.purchase.modular.model.params.HouselayouttypeParam;
import com.lfxwkj.purchase.modular.model.result.HouselayouttypeResult;
import com.lfxwkj.purchase.modular.service.HouselayouttypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 郭晓东
 * @since 2020-03-16
 */
@Service
public class HouselayouttypeServiceImpl extends ServiceImpl<HouselayouttypeMapper, Houselayouttype> implements HouselayouttypeService {

    @Override
    public void add(HouselayouttypeParam param) {
        Houselayouttype entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(HouselayouttypeParam param) {
        this.removeById(getKey(param));
    }

    @Override
    public void update(HouselayouttypeParam param) {
        Houselayouttype oldEntity = getOldEntity(param);
        Houselayouttype newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public HouselayouttypeResult findBySpec(HouselayouttypeParam param) {
        return null;
    }

    @Override
    public List<HouselayouttypeResult> findListBySpec(HouselayouttypeParam param) {
        return this.baseMapper.customList(param);
    }

    @Override
    public LayuiPageInfo findPageBySpec(HouselayouttypeParam param) {
        Page pageContext = getPageContext();
        IPage page = this.baseMapper.customPageList(pageContext, param);
        return LayuiPageFactory.createPageInfo(page);
    }

    private Serializable getKey(HouselayouttypeParam param) {
        return param.getId();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private Houselayouttype getOldEntity(HouselayouttypeParam param) {
        return this.getById(getKey(param));
    }

    private Houselayouttype getEntity(HouselayouttypeParam param) {
        Houselayouttype entity = new Houselayouttype();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
