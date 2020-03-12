package com.lfxwkj.purchase.modular.service.impl;

import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lfxwkj.purchase.base.pojo.page.LayuiPageFactory;
import com.lfxwkj.purchase.base.pojo.page.LayuiPageInfo;
import com.lfxwkj.purchase.modular.entity.Projectimg;
import com.lfxwkj.purchase.modular.mapper.ProjectimgMapper;
import com.lfxwkj.purchase.modular.model.params.ProjectimgParam;
import com.lfxwkj.purchase.modular.model.result.ProjectimgResult;
import  com.lfxwkj.purchase.modular.service.ProjectimgService;
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
        public class ProjectimgServiceImpl extends ServiceImpl<ProjectimgMapper, Projectimg>implements ProjectimgService {

        @Override
        public void add(ProjectimgParam param){
    Projectimg entity=getEntity(param);
        this.save(entity);
        }

        @Override
        public void delete(ProjectimgParam param){
        this.removeById(getKey(param));
        }

        @Override
        public void update(ProjectimgParam param){
    Projectimg oldEntity=getOldEntity(param);
    Projectimg newEntity=getEntity(param);
        ToolUtil.copyProperties(newEntity,oldEntity);
        this.updateById(newEntity);
        }

        @Override
        public ProjectimgResult findBySpec(ProjectimgParam param){
        return null;
        }

        @Override
        public List<ProjectimgResult> findListBySpec(ProjectimgParam param){
        return null;
        }

        @Override
        public LayuiPageInfo findPageBySpec(ProjectimgParam param){
        Page pageContext=getPageContext();
        IPage page=this.baseMapper.customPageList(pageContext,param);
        return LayuiPageFactory.createPageInfo(page);
        }

        private Serializable getKey(ProjectimgParam param){
                return param.getId();
        }

        private Page getPageContext(){
        return LayuiPageFactory.defaultPage();
        }

        private Projectimg getOldEntity(ProjectimgParam param){
        return this.getById(getKey(param));
        }

        private Projectimg getEntity(ProjectimgParam param){
    Projectimg entity=new Projectimg();
        ToolUtil.copyProperties(param,entity);
        return entity;
        }

        }
