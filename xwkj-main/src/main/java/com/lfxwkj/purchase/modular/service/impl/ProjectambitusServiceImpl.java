package com.lfxwkj.purchase.modular.service.impl;

import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lfxwkj.purchase.base.pojo.page.LayuiPageFactory;
import com.lfxwkj.purchase.base.pojo.page.LayuiPageInfo;
import com.lfxwkj.purchase.modular.entity.Projectambitus;
import com.lfxwkj.purchase.modular.mapper.ProjectambitusMapper;
import com.lfxwkj.purchase.modular.model.params.ProjectambitusParam;
import com.lfxwkj.purchase.modular.model.result.ProjectambitusResult;
import  com.lfxwkj.purchase.modular.service.ProjectambitusService;
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
        public class ProjectambitusServiceImpl extends ServiceImpl<ProjectambitusMapper, Projectambitus>implements ProjectambitusService {

        @Override
        public void add(ProjectambitusParam param){
    Projectambitus entity=getEntity(param);
        this.save(entity);
        }

        @Override
        public void delete(ProjectambitusParam param){
        this.removeById(getKey(param));
        }

        @Override
        public void update(ProjectambitusParam param){
    Projectambitus oldEntity=getOldEntity(param);
    Projectambitus newEntity=getEntity(param);
        ToolUtil.copyProperties(newEntity,oldEntity);
        this.updateById(newEntity);
        }

        @Override
        public ProjectambitusResult findBySpec(ProjectambitusParam param){
        return null;
        }

        @Override
        public List<ProjectambitusResult> findListBySpec(ProjectambitusParam param){
        return null;
        }

        @Override
        public LayuiPageInfo findPageBySpec(ProjectambitusParam param){
        Page pageContext=getPageContext();
        IPage page=this.baseMapper.customPageList(pageContext,param);
        return LayuiPageFactory.createPageInfo(page);
        }

        private Serializable getKey(ProjectambitusParam param){
                return param.getId();
        }

        private Page getPageContext(){
        return LayuiPageFactory.defaultPage();
        }

        private Projectambitus getOldEntity(ProjectambitusParam param){
        return this.getById(getKey(param));
        }

        private Projectambitus getEntity(ProjectambitusParam param){
    Projectambitus entity=new Projectambitus();
        ToolUtil.copyProperties(param,entity);
        return entity;
        }

        }
