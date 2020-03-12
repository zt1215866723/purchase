package com.lfxwkj.purchase.modular.service.impl;

import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lfxwkj.purchase.base.pojo.page.LayuiPageFactory;
import com.lfxwkj.purchase.base.pojo.page.LayuiPageInfo;
import com.lfxwkj.purchase.modular.entity.Infolist;
import com.lfxwkj.purchase.modular.mapper.InfolistMapper;
import com.lfxwkj.purchase.modular.model.params.InfolistParam;
import com.lfxwkj.purchase.modular.model.result.InfolistResult;
import  com.lfxwkj.purchase.modular.service.InfolistService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 存储新闻、公告等信息 
 服务实现类
 * </p>
 *
 * @author 郭晓东
 * @since 2020-03-12
 */
@Service
        public class InfolistServiceImpl extends ServiceImpl<InfolistMapper, Infolist>implements InfolistService {

        @Override
        public void add(InfolistParam param){
    Infolist entity=getEntity(param);
        this.save(entity);
        }

        @Override
        public void delete(InfolistParam param){
        this.removeById(getKey(param));
        }

        @Override
        public void update(InfolistParam param){
    Infolist oldEntity=getOldEntity(param);
    Infolist newEntity=getEntity(param);
        ToolUtil.copyProperties(newEntity,oldEntity);
        this.updateById(newEntity);
        }

        @Override
        public InfolistResult findBySpec(InfolistParam param){
        return null;
        }

        @Override
        public List<InfolistResult> findListBySpec(InfolistParam param){
        return null;
        }

        @Override
        public LayuiPageInfo findPageBySpec(InfolistParam param){
        Page pageContext=getPageContext();
        IPage page=this.baseMapper.customPageList(pageContext,param);
        return LayuiPageFactory.createPageInfo(page);
        }

        private Serializable getKey(InfolistParam param){
                return param.getId();
        }

        private Page getPageContext(){
        return LayuiPageFactory.defaultPage();
        }

        private Infolist getOldEntity(InfolistParam param){
        return this.getById(getKey(param));
        }

        private Infolist getEntity(InfolistParam param){
    Infolist entity=new Infolist();
        ToolUtil.copyProperties(param,entity);
        return entity;
        }

        }
