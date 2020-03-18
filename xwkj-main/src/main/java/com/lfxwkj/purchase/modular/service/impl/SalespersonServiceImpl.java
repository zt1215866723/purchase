package com.lfxwkj.purchase.modular.service.impl;

import cn.stylefeng.roses.core.mutidatasource.annotion.DataSource;
import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lfxwkj.purchase.base.pojo.page.LayuiPageFactory;
import com.lfxwkj.purchase.base.pojo.page.LayuiPageInfo;
import com.lfxwkj.purchase.modular.entity.Salesperson;
import com.lfxwkj.purchase.modular.mapper.ProjectinfoMapper;
import com.lfxwkj.purchase.modular.mapper.SalefollowMapper;
import com.lfxwkj.purchase.modular.mapper.SalespersonMapper;
import com.lfxwkj.purchase.modular.model.params.SalespersonParam;
import com.lfxwkj.purchase.modular.model.result.ProjectinfoResult;
import com.lfxwkj.purchase.modular.model.result.SalespersonResult;
import com.lfxwkj.purchase.modular.model.vo.SaleFollowVo;
import com.lfxwkj.purchase.modular.model.vo.SalespersonVo;
import com.lfxwkj.purchase.modular.service.SalespersonService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired(required = false)
    private ProjectinfoMapper projectinfoMapper;
    @Autowired(required = false)
    private SalefollowMapper salefollowMapper;
        @Override
        @DataSource(name = "purchase")
        public void add(SalespersonParam param){
    Salesperson entity=getEntity(param);
        this.save(entity);
        }

        @Override
        @DataSource(name = "purchase")
        public void delete(SalespersonParam param){
        this.removeById(getKey(param));
        }

        @Override
        @DataSource(name = "purchase")
        public void update(SalespersonParam param){
    Salesperson oldEntity=getOldEntity(param);
    Salesperson newEntity=getEntity(param);
        ToolUtil.copyProperties(newEntity,oldEntity);
        this.updateById(newEntity);
        }

        @Override
        @DataSource(name = "purchase")
        public SalespersonResult findBySpec(SalespersonParam param){
        return null;
        }

        @Override
        @DataSource(name = "purchase")
        public List<SalespersonResult> findListBySpec(SalespersonParam param){
        return this.baseMapper.customList(param);
        }

        @Override
        @DataSource(name = "purchase")
        public LayuiPageInfo findPageBySpec(SalespersonParam param){
        Page pageContext=getPageContext();

        IPage page=this.baseMapper.customPageList(pageContext,param);
        return LayuiPageFactory.createPageInfo(page);
        }

    @Override
    public SalespersonVo salespersonDetail(Long id) {
        Salesperson salesperson = this.baseMapper.selectById(id);
        SalespersonVo salespersonVo = new SalespersonVo();
        BeanUtils.copyProperties(salesperson,salespersonVo);
        //查询销售顾问所属项目列表
        List<ProjectinfoResult> projectinfoResultList = projectinfoMapper.projectlistBysalesID(id);
        salespersonVo.setProjectInfo(projectinfoResultList);
        //查询销售顾问记录
        List<SaleFollowVo> saleFollowVos = salefollowMapper.saleFollowBysalesID(id);
        salespersonVo.setServiceTrajectory(saleFollowVos);
        return salespersonVo;
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
