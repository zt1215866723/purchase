package com.lfxwkj.purchase.modular.service.impl;

import cn.stylefeng.roses.core.mutidatasource.annotion.DataSource;
import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lfxwkj.purchase.base.pojo.page.LayuiPageFactory;
import com.lfxwkj.purchase.base.pojo.page.LayuiPageInfo;
import com.lfxwkj.purchase.modular.entity.Houselayout;
import com.lfxwkj.purchase.modular.mapper.HouselayoutMapper;
import com.lfxwkj.purchase.modular.model.params.HouselayoutParam;
import com.lfxwkj.purchase.modular.model.result.HouselayoutResult;
import  com.lfxwkj.purchase.modular.service.HouselayoutService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 郭晓东
 * @since 2020-03-12
 */
@Service
        public class HouselayoutServiceImpl extends ServiceImpl<HouselayoutMapper, Houselayout>implements HouselayoutService {

        @Override
        @DataSource(name = "purchase")
        public void add(HouselayoutParam param){
    Houselayout entity=getEntity(param);
        this.save(entity);
        }

        @Override
        @DataSource(name = "purchase")
        public void delete(HouselayoutParam param){
        this.removeById(getKey(param));
        }

        @Override
        @DataSource(name = "purchase")
        public void update(HouselayoutParam param){
    Houselayout oldEntity=getOldEntity(param);
    Houselayout newEntity=getEntity(param);
        ToolUtil.copyProperties(newEntity,oldEntity);
        this.updateById(newEntity);
        }

        @Override
        @DataSource(name = "purchase")
        public HouselayoutResult findBySpec(HouselayoutParam param){
        return null;
        }

        @Override
        @DataSource(name = "purchase")
        public List<HouselayoutResult> findListBySpec(HouselayoutParam param){
        return null;
        }

        @Override
        @DataSource(name = "purchase")
        public LayuiPageInfo findPageBySpec(HouselayoutParam param){
        Page pageContext=getPageContext();
        IPage page=this.baseMapper.customPageList(pageContext,param);
        return LayuiPageFactory.createPageInfo(page);
        }

        private Serializable getKey(HouselayoutParam param){
                return param.getId();
        }

        private Page getPageContext(){
        return LayuiPageFactory.defaultPage();
        }

        private Houselayout getOldEntity(HouselayoutParam param){
        return this.getById(getKey(param));
        }

        private Houselayout getEntity(HouselayoutParam param){
    Houselayout entity=new Houselayout();
        ToolUtil.copyProperties(param,entity);
        return entity;
        }

        }
