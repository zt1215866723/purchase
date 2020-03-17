package com.lfxwkj.purchase.modular.service.impl;

import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lfxwkj.purchase.base.pojo.page.LayuiPageFactory;
import com.lfxwkj.purchase.base.pojo.page.LayuiPageInfo;
import com.lfxwkj.purchase.modular.entity.Projectsalesperson;
import com.lfxwkj.purchase.modular.mapper.ProjectsalespersonMapper;
import com.lfxwkj.purchase.modular.model.params.ProjectsalespersonParam;
import com.lfxwkj.purchase.modular.model.result.ProjectsalespersonResult;
import com.lfxwkj.purchase.modular.model.vo.ProjectsalepersonListVo;
import  com.lfxwkj.purchase.modular.service.ProjectsalespersonService;
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
        public class ProjectsalespersonServiceImpl extends ServiceImpl<ProjectsalespersonMapper, Projectsalesperson>implements ProjectsalespersonService {

        @Override
        public void add(ProjectsalespersonParam param){
    Projectsalesperson entity=getEntity(param);
        this.save(entity);
        }

        @Override
        public void delete(ProjectsalespersonParam param){
        this.removeById(getKey(param));
        }

        @Override
        public void update(ProjectsalespersonParam param){
    Projectsalesperson oldEntity=getOldEntity(param);
    Projectsalesperson newEntity=getEntity(param);
        ToolUtil.copyProperties(newEntity,oldEntity);
        this.updateById(newEntity);
        }

        @Override
        public ProjectsalespersonResult findBySpec(ProjectsalespersonParam param){
        return null;
        }

        @Override
        public List<ProjectsalespersonResult> findListBySpec(ProjectsalespersonParam param){
        return null;
        }

        @Override
        public LayuiPageInfo findPageBySpec(ProjectsalespersonParam param){
        Page pageContext=getPageContext();
        IPage page=this.baseMapper.customPageList(pageContext,param);
        return LayuiPageFactory.createPageInfo(page);
        }

    /**
     * 查询项目顾问列表
     * @param projectID 项目主键 必填
     * @param nums 请求条数
     * @return
     */
    @Override
    public List<ProjectsalepersonListVo> projectSalespersonList(Long projectID, Long nums) {
        return this.baseMapper.projectSalespersonList(projectID,nums);
    }

    private Serializable getKey(ProjectsalespersonParam param){
                return param.getId();
        }

        private Page getPageContext(){
        return LayuiPageFactory.defaultPage();
        }

        private Projectsalesperson getOldEntity(ProjectsalespersonParam param){
        return this.getById(getKey(param));
        }

        private Projectsalesperson getEntity(ProjectsalespersonParam param){
    Projectsalesperson entity=new Projectsalesperson();
        ToolUtil.copyProperties(param,entity);
        return entity;
        }

        }
