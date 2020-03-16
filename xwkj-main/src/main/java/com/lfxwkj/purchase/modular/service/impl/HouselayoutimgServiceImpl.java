package com.lfxwkj.purchase.modular.service.impl;

import cn.stylefeng.roses.core.mutidatasource.annotion.DataSource;
import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lfxwkj.purchase.base.pojo.page.LayuiPageFactory;
import com.lfxwkj.purchase.base.pojo.page.LayuiPageInfo;
import com.lfxwkj.purchase.modular.entity.Houselayoutimg;
import com.lfxwkj.purchase.modular.mapper.HouselayoutimgMapper;
import com.lfxwkj.purchase.modular.model.params.HouselayoutimgParam;
import com.lfxwkj.purchase.modular.model.result.HouselayoutimgResult;
import  com.lfxwkj.purchase.modular.service.HouselayoutimgService;
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
        public class HouselayoutimgServiceImpl extends ServiceImpl<HouselayoutimgMapper, Houselayoutimg>implements HouselayoutimgService {

        @Override
        @DataSource(name = "purchase")
        public void add(HouselayoutimgParam param){
    Houselayoutimg entity=getEntity(param);
        this.save(entity);
        }

        @Override
        @DataSource(name = "purchase")
        public void delete(HouselayoutimgParam param){
        this.removeById(getKey(param));
        }

        @Override
        @DataSource(name = "purchase")
        public void update(HouselayoutimgParam param){
    Houselayoutimg oldEntity=getOldEntity(param);
    Houselayoutimg newEntity=getEntity(param);
        ToolUtil.copyProperties(newEntity,oldEntity);
        this.updateById(newEntity);
        }

        @Override
        @DataSource(name = "purchase")
        public HouselayoutimgResult findBySpec(HouselayoutimgParam param){
        return null;
        }

        @Override
        @DataSource(name = "purchase")
        public List<HouselayoutimgResult> findListBySpec(HouselayoutimgParam param){
        return null;
        }

        @Override
        @DataSource(name = "purchase")
        public LayuiPageInfo findPageBySpec(HouselayoutimgParam param){
        Page pageContext=getPageContext();
        IPage page=this.baseMapper.customPageList(pageContext,param);
        return LayuiPageFactory.createPageInfo(page);
        }

        private Serializable getKey(HouselayoutimgParam param){
                return param.getId();
        }

        private Page getPageContext(){
        return LayuiPageFactory.defaultPage();
        }

        private Houselayoutimg getOldEntity(HouselayoutimgParam param){
        return this.getById(getKey(param));
        }

        private Houselayoutimg getEntity(HouselayoutimgParam param){
    Houselayoutimg entity=new Houselayoutimg();
        ToolUtil.copyProperties(param,entity);
        return entity;
        }

        }
