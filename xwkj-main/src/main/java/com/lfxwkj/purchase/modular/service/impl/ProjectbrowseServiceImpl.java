package com.lfxwkj.purchase.modular.service.impl;

import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lfxwkj.purchase.base.pojo.page.LayuiPageFactory;
import com.lfxwkj.purchase.base.pojo.page.LayuiPageInfo;
import com.lfxwkj.purchase.modular.entity.Projectbrowse;
import com.lfxwkj.purchase.modular.mapper.ProjectbrowseMapper;
import com.lfxwkj.purchase.modular.model.params.ProjectbrowseParam;
import com.lfxwkj.purchase.modular.model.result.ProjectbrowseResult;
import  com.lfxwkj.purchase.modular.service.ProjectbrowseService;
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
        public class ProjectbrowseServiceImpl extends ServiceImpl<ProjectbrowseMapper, Projectbrowse>implements ProjectbrowseService {

        @Override
        public void add(ProjectbrowseParam param){
    Projectbrowse entity=getEntity(param);
        this.save(entity);
        }

        @Override
        public void delete(ProjectbrowseParam param){
        this.removeById(getKey(param));
        }

        @Override
        public void update(ProjectbrowseParam param){
    Projectbrowse oldEntity=getOldEntity(param);
    Projectbrowse newEntity=getEntity(param);
        ToolUtil.copyProperties(newEntity,oldEntity);
        this.updateById(newEntity);
        }

        @Override
        public ProjectbrowseResult findBySpec(ProjectbrowseParam param){
        return null;
        }

        @Override
        public List<ProjectbrowseResult> findListBySpec(ProjectbrowseParam param){
        return null;
        }

        @Override
        public LayuiPageInfo findPageBySpec(ProjectbrowseParam param){
        Page pageContext=getPageContext();
        IPage page=this.baseMapper.customPageList(pageContext,param);
        return LayuiPageFactory.createPageInfo(page);
        }

        private Serializable getKey(ProjectbrowseParam param){
                return param.getId();
        }

        private Page getPageContext(){
        return LayuiPageFactory.defaultPage();
        }

        private Projectbrowse getOldEntity(ProjectbrowseParam param){
        return this.getById(getKey(param));
        }

        private Projectbrowse getEntity(ProjectbrowseParam param){
    Projectbrowse entity=new Projectbrowse();
        ToolUtil.copyProperties(param,entity);
        return entity;
        }

        }
