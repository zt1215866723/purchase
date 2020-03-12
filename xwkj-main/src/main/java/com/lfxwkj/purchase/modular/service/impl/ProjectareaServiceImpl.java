package com.lfxwkj.purchase.modular.service.impl;

import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lfxwkj.purchase.base.pojo.page.LayuiPageFactory;
import com.lfxwkj.purchase.base.pojo.page.LayuiPageInfo;
import com.lfxwkj.purchase.modular.entity.Projectarea;
import com.lfxwkj.purchase.modular.mapper.ProjectareaMapper;
import com.lfxwkj.purchase.modular.model.params.ProjectareaParam;
import com.lfxwkj.purchase.modular.model.result.ProjectareaResult;
import  com.lfxwkj.purchase.modular.service.ProjectareaService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 项目所属区域 服务实现类
 * </p>
 *
 * @author 郭晓东
 * @since 2020-03-12
 */
@Service
        public class ProjectareaServiceImpl extends ServiceImpl<ProjectareaMapper, Projectarea>implements ProjectareaService {

        @Override
        public void add(ProjectareaParam param){
    Projectarea entity=getEntity(param);
        this.save(entity);
        }

        @Override
        public void delete(ProjectareaParam param){
        this.removeById(getKey(param));
        }

        @Override
        public void update(ProjectareaParam param){
    Projectarea oldEntity=getOldEntity(param);
    Projectarea newEntity=getEntity(param);
        ToolUtil.copyProperties(newEntity,oldEntity);
        this.updateById(newEntity);
        }

        @Override
        public ProjectareaResult findBySpec(ProjectareaParam param){
        return null;
        }

        @Override
        public List<ProjectareaResult> findListBySpec(ProjectareaParam param){
        return null;
        }

        @Override
        public LayuiPageInfo findPageBySpec(ProjectareaParam param){
        Page pageContext=getPageContext();
        IPage page=this.baseMapper.customPageList(pageContext,param);
        return LayuiPageFactory.createPageInfo(page);
        }

        private Serializable getKey(ProjectareaParam param){
                return param.getId();
        }

        private Page getPageContext(){
        return LayuiPageFactory.defaultPage();
        }

        private Projectarea getOldEntity(ProjectareaParam param){
        return this.getById(getKey(param));
        }

        private Projectarea getEntity(ProjectareaParam param){
    Projectarea entity=new Projectarea();
        ToolUtil.copyProperties(param,entity);
        return entity;
        }

        }
