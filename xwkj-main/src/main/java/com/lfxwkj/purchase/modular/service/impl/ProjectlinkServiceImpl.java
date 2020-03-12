package com.lfxwkj.purchase.modular.service.impl;

import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lfxwkj.purchase.base.pojo.page.LayuiPageFactory;
import com.lfxwkj.purchase.base.pojo.page.LayuiPageInfo;
import com.lfxwkj.purchase.modular.entity.Projectlink;
import com.lfxwkj.purchase.modular.mapper.ProjectlinkMapper;
import com.lfxwkj.purchase.modular.model.params.ProjectlinkParam;
import com.lfxwkj.purchase.modular.model.result.ProjectlinkResult;
import  com.lfxwkj.purchase.modular.service.ProjectlinkService;
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
        public class ProjectlinkServiceImpl extends ServiceImpl<ProjectlinkMapper, Projectlink>implements ProjectlinkService {

        @Override
        public void add(ProjectlinkParam param){
    Projectlink entity=getEntity(param);
        this.save(entity);
        }

        @Override
        public void delete(ProjectlinkParam param){
        this.removeById(getKey(param));
        }

        @Override
        public void update(ProjectlinkParam param){
    Projectlink oldEntity=getOldEntity(param);
    Projectlink newEntity=getEntity(param);
        ToolUtil.copyProperties(newEntity,oldEntity);
        this.updateById(newEntity);
        }

        @Override
        public ProjectlinkResult findBySpec(ProjectlinkParam param){
        return null;
        }

        @Override
        public List<ProjectlinkResult> findListBySpec(ProjectlinkParam param){
        return null;
        }

        @Override
        public LayuiPageInfo findPageBySpec(ProjectlinkParam param){
        Page pageContext=getPageContext();
        IPage page=this.baseMapper.customPageList(pageContext,param);
        return LayuiPageFactory.createPageInfo(page);
        }

        private Serializable getKey(ProjectlinkParam param){
                return param.getId();
        }

        private Page getPageContext(){
        return LayuiPageFactory.defaultPage();
        }

        private Projectlink getOldEntity(ProjectlinkParam param){
        return this.getById(getKey(param));
        }

        private Projectlink getEntity(ProjectlinkParam param){
    Projectlink entity=new Projectlink();
        ToolUtil.copyProperties(param,entity);
        return entity;
        }

        }
