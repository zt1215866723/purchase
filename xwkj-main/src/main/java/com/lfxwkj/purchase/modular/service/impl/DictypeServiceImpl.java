package com.lfxwkj.purchase.modular.service.impl;

import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lfxwkj.purchase.base.pojo.page.LayuiPageFactory;
import com.lfxwkj.purchase.base.pojo.page.LayuiPageInfo;
import com.lfxwkj.purchase.modular.entity.Dictype;
import com.lfxwkj.purchase.modular.mapper.DictypeMapper;
import com.lfxwkj.purchase.modular.model.params.DictypeParam;
import com.lfxwkj.purchase.modular.model.result.DictypeResult;
import  com.lfxwkj.purchase.modular.service.DictypeService;
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
        public class DictypeServiceImpl extends ServiceImpl<DictypeMapper, Dictype>implements DictypeService {

        @Override
        public void add(DictypeParam param){
    Dictype entity=getEntity(param);
        this.save(entity);
        }

        @Override
        public void delete(DictypeParam param){
        this.removeById(getKey(param));
        }

        @Override
        public void update(DictypeParam param){
    Dictype oldEntity=getOldEntity(param);
    Dictype newEntity=getEntity(param);
        ToolUtil.copyProperties(newEntity,oldEntity);
        this.updateById(newEntity);
        }

        @Override
        public DictypeResult findBySpec(DictypeParam param){
        return null;
        }

        @Override
        public List<DictypeResult> findListBySpec(DictypeParam param){
        return null;
        }

        @Override
        public LayuiPageInfo findPageBySpec(DictypeParam param){
        Page pageContext=getPageContext();
        IPage page=this.baseMapper.customPageList(pageContext,param);
        return LayuiPageFactory.createPageInfo(page);
        }

        private Serializable getKey(DictypeParam param){
                return param.getId();
        }

        private Page getPageContext(){
        return LayuiPageFactory.defaultPage();
        }

        private Dictype getOldEntity(DictypeParam param){
        return this.getById(getKey(param));
        }

        private Dictype getEntity(DictypeParam param){
    Dictype entity=new Dictype();
        ToolUtil.copyProperties(param,entity);
        return entity;
        }

        }
