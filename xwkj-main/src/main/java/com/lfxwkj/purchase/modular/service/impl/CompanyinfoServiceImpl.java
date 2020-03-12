package com.lfxwkj.purchase.modular.service.impl;

import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lfxwkj.purchase.base.pojo.page.LayuiPageFactory;
import com.lfxwkj.purchase.base.pojo.page.LayuiPageInfo;
import com.lfxwkj.purchase.modular.entity.Companyinfo;
import com.lfxwkj.purchase.modular.mapper.CompanyinfoMapper;
import com.lfxwkj.purchase.modular.model.params.CompanyinfoParam;
import com.lfxwkj.purchase.modular.model.result.CompanyinfoResult;
import  com.lfxwkj.purchase.modular.service.CompanyinfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 企业的简介 服务实现类
 * </p>
 *
 * @author 郭晓东
 * @since 2020-03-12
 */
@Service
        public class CompanyinfoServiceImpl extends ServiceImpl<CompanyinfoMapper, Companyinfo>implements CompanyinfoService {

        @Override
        public void add(CompanyinfoParam param){
    Companyinfo entity=getEntity(param);
        this.save(entity);
        }

        @Override
        public void delete(CompanyinfoParam param){
        this.removeById(getKey(param));
        }

        @Override
        public void update(CompanyinfoParam param){
    Companyinfo oldEntity=getOldEntity(param);
    Companyinfo newEntity=getEntity(param);
        ToolUtil.copyProperties(newEntity,oldEntity);
        this.updateById(newEntity);
        }

        @Override
        public CompanyinfoResult findBySpec(CompanyinfoParam param){
        return null;
        }

        @Override
        public List<CompanyinfoResult> findListBySpec(CompanyinfoParam param){
        return null;
        }

        @Override
        public LayuiPageInfo findPageBySpec(CompanyinfoParam param){
        Page pageContext=getPageContext();
        IPage page=this.baseMapper.customPageList(pageContext,param);
        return LayuiPageFactory.createPageInfo(page);
        }

        private Serializable getKey(CompanyinfoParam param){
                return param.getId();
        }

        private Page getPageContext(){
        return LayuiPageFactory.defaultPage();
        }

        private Companyinfo getOldEntity(CompanyinfoParam param){
        return this.getById(getKey(param));
        }

        private Companyinfo getEntity(CompanyinfoParam param){
    Companyinfo entity=new Companyinfo();
        ToolUtil.copyProperties(param,entity);
        return entity;
        }

        }
