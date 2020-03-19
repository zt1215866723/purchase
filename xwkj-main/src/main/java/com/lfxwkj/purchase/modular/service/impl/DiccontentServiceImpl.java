package com.lfxwkj.purchase.modular.service.impl;


import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lfxwkj.purchase.base.pojo.page.LayuiPageFactory;
import com.lfxwkj.purchase.base.pojo.page.LayuiPageInfo;
import com.lfxwkj.purchase.modular.entity.Diccontent;
import com.lfxwkj.purchase.modular.mapper.DiccontentMapper;
import com.lfxwkj.purchase.modular.model.params.DiccontentParam;
import com.lfxwkj.purchase.modular.model.result.DiccontentResult;
import com.lfxwkj.purchase.modular.service.DiccontentService;
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
 * @since 2020-03-13
 */
@Service
        public class DiccontentServiceImpl extends ServiceImpl<DiccontentMapper, Diccontent>implements DiccontentService {

        @Override
        public void add(DiccontentParam param){
    Diccontent entity=getEntity(param);
        this.save(entity);
        }

        @Override
        public void delete(DiccontentParam param){
            Diccontent diccontent = new Diccontent();
            diccontent.setId(param.getId());
            diccontent.setState(0);
            this.updateById(diccontent);
        }

        @Override
        public void update(DiccontentParam param){
    Diccontent oldEntity=getOldEntity(param);
    Diccontent newEntity=getEntity(param);
        ToolUtil.copyProperties(newEntity,oldEntity);
        this.updateById(newEntity);
        }

        @Override
        public DiccontentResult findBySpec(DiccontentParam param){
        return null;
        }

        @Override
        public List<DiccontentResult> findListBySpec(DiccontentParam param){
        return null;
        }

        @Override
        public LayuiPageInfo findPageBySpec(DiccontentParam param){
        Page pageContext=getPageContext();
        IPage page=this.baseMapper.customPageList(pageContext,param);
        return LayuiPageFactory.createPageInfo(page);
        }

        private Serializable getKey(DiccontentParam param){
                return param.getId();
        }

        private Page getPageContext(){
        return LayuiPageFactory.defaultPage();
        }

        private Diccontent getOldEntity(DiccontentParam param){
        return this.getById(getKey(param));
        }

        private Diccontent getEntity(DiccontentParam param){
    Diccontent entity=new Diccontent();
        ToolUtil.copyProperties(param,entity);
        return entity;
        }

        }
