package com.lfxwkj.purchase.modular.service.impl;

import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lfxwkj.purchase.base.pojo.page.LayuiPageFactory;
import com.lfxwkj.purchase.base.pojo.page.LayuiPageInfo;
import com.lfxwkj.purchase.modular.entity.Projectdynamic;
import com.lfxwkj.purchase.modular.mapper.ProjectdynamicMapper;
import com.lfxwkj.purchase.modular.model.params.ProjectdynamicParam;
import com.lfxwkj.purchase.modular.model.result.ProjectdynamicResult;
import  com.lfxwkj.purchase.modular.service.ProjectdynamicService;
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
        public class ProjectdynamicServiceImpl extends ServiceImpl<ProjectdynamicMapper, Projectdynamic>implements ProjectdynamicService {

        @Override
        public void add(ProjectdynamicParam param){
    Projectdynamic entity=getEntity(param);
        this.save(entity);
        }

        @Override
        public void delete(ProjectdynamicParam param){
        this.removeById(getKey(param));
        }

        @Override
        public void update(ProjectdynamicParam param){
    Projectdynamic oldEntity=getOldEntity(param);
    Projectdynamic newEntity=getEntity(param);
        ToolUtil.copyProperties(newEntity,oldEntity);
        this.updateById(newEntity);
        }

        @Override
        public ProjectdynamicResult findBySpec(ProjectdynamicParam param){
        return null;
        }

        @Override
        public List<ProjectdynamicResult> findListBySpec(ProjectdynamicParam param){
        return null;
        }

        @Override
        public LayuiPageInfo findPageBySpec(ProjectdynamicParam param){
        Page pageContext=getPageContext();
        IPage page=this.baseMapper.customPageList(pageContext,param);
        return LayuiPageFactory.createPageInfo(page);
        }

        private Serializable getKey(ProjectdynamicParam param){
                return param.getId();
        }

        private Page getPageContext(){
        return LayuiPageFactory.defaultPage();
        }

        private Projectdynamic getOldEntity(ProjectdynamicParam param){
        return this.getById(getKey(param));
        }

        private Projectdynamic getEntity(ProjectdynamicParam param){
    Projectdynamic entity=new Projectdynamic();
        ToolUtil.copyProperties(param,entity);
        return entity;
        }

        }
