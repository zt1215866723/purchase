package com.lfxwkj.purchase.modular.service.impl;

import cn.stylefeng.roses.core.mutidatasource.annotion.DataSource;
import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lfxwkj.purchase.base.pojo.page.LayuiPageFactory;
import com.lfxwkj.purchase.base.pojo.page.LayuiPageInfo;
import com.lfxwkj.purchase.modular.entity.Salefollow;
import com.lfxwkj.purchase.modular.mapper.SalefollowMapper;
import com.lfxwkj.purchase.modular.model.params.SalefollowParam;
import com.lfxwkj.purchase.modular.model.result.SalefollowResult;
import com.lfxwkj.purchase.modular.model.result.SalespersonResult;
import  com.lfxwkj.purchase.modular.service.SalefollowService;
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
        public class SalefollowServiceImpl extends ServiceImpl<SalefollowMapper, Salefollow>implements SalefollowService {

        @Override
        @DataSource(name = "purchase")
        public void add(SalefollowParam param){
    Salefollow entity=getEntity(param);
        this.save(entity);
        }

        @Override
        @DataSource(name = "purchase")
        public void delete(SalefollowParam param){
        this.removeById(getKey(param));
        }

        @Override
        @DataSource(name = "purchase")
        public void update(SalefollowParam param){
    Salefollow oldEntity=getOldEntity(param);
    Salefollow newEntity=getEntity(param);
        ToolUtil.copyProperties(newEntity,oldEntity);
        this.updateById(newEntity);
        }

        @Override
        @DataSource(name = "purchase")
        public SalefollowResult findBySpec(SalefollowParam param){
        return null;
        }

        @Override
        @DataSource(name = "purchase")
        public List<SalefollowResult> findListBySpec(SalefollowParam param){
        return null;
        }

        @Override
        @DataSource(name = "purchase")
        public LayuiPageInfo findPageBySpec(SalefollowParam param){
        Page pageContext=getPageContext();
        IPage page=this.baseMapper.customPageList(pageContext,param);
        return LayuiPageFactory.createPageInfo(page);
        }

    @Override
    @DataSource(name = "purchase")
    public List<SalespersonResult> salefollowlist(SalefollowParam param) {
        return  this.baseMapper.salefollowlist(param);
    }

    private Serializable getKey(SalefollowParam param){
                return param.getId();
        }

        private Page getPageContext(){
        return LayuiPageFactory.defaultPage();
        }

        private Salefollow getOldEntity(SalefollowParam param){
        return this.getById(getKey(param));
        }

        private Salefollow getEntity(SalefollowParam param){
    Salefollow entity=new Salefollow();
        ToolUtil.copyProperties(param,entity);
        return entity;
        }

        }
