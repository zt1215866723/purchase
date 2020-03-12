package com.lfxwkj.purchase.modular.service.impl;

import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lfxwkj.purchase.base.pojo.page.LayuiPageFactory;
import com.lfxwkj.purchase.base.pojo.page.LayuiPageInfo;
import com.lfxwkj.purchase.modular.entity.Salesperson;
import com.lfxwkj.purchase.modular.mapper.SalespersonMapper;
import com.lfxwkj.purchase.modular.model.params.SalespersonParam;
import com.lfxwkj.purchase.modular.model.result.SalespersonResult;
import  com.lfxwkj.purchase.modular.service.SalespersonService;
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
        public class SalespersonServiceImpl extends ServiceImpl<SalespersonMapper, Salesperson>implements SalespersonService {

        @Override
        public void add(SalespersonParam param){
    Salesperson entity=getEntity(param);
        this.save(entity);
        }

        @Override
        public void delete(SalespersonParam param){
        this.removeById(getKey(param));
        }

        @Override
        public void update(SalespersonParam param){
    Salesperson oldEntity=getOldEntity(param);
    Salesperson newEntity=getEntity(param);
        ToolUtil.copyProperties(newEntity,oldEntity);
        this.updateById(newEntity);
        }

        @Override
        public SalespersonResult findBySpec(SalespersonParam param){
        return null;
        }

        @Override
        public List<SalespersonResult> findListBySpec(SalespersonParam param){
        return null;
        }

        @Override
        public LayuiPageInfo findPageBySpec(SalespersonParam param){
        Page pageContext=getPageContext();

        IPage page=this.baseMapper.customPageList(pageContext,param);
        return LayuiPageFactory.createPageInfo(page);
        }

        private Serializable getKey(SalespersonParam param){
                return param.getId();
        }

        private Page getPageContext(){
        return LayuiPageFactory.defaultPage();
        }

        private Salesperson getOldEntity(SalespersonParam param){
        return this.getById(getKey(param));
        }

        private Salesperson getEntity(SalespersonParam param){
    Salesperson entity=new Salesperson();
        ToolUtil.copyProperties(param,entity);
        return entity;
        }

        }
