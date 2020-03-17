package com.lfxwkj.purchase.modular.service.impl;

import cn.stylefeng.roses.core.mutidatasource.annotion.DataSource;
import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lfxwkj.purchase.base.pojo.page.LayuiPageFactory;
import com.lfxwkj.purchase.base.pojo.page.LayuiPageInfo;
import com.lfxwkj.purchase.modular.api.result.Moredetail;
import com.lfxwkj.purchase.modular.api.result.Projectdetail;
import com.lfxwkj.purchase.modular.api.result.Projectlist;
import com.lfxwkj.purchase.modular.entity.Projectinfo;
import com.lfxwkj.purchase.modular.mapper.ProjectimgMapper;
import com.lfxwkj.purchase.modular.mapper.ProjectinfoMapper;
import com.lfxwkj.purchase.modular.model.params.ProjectinfoParam;
import com.lfxwkj.purchase.modular.model.result.ProjectinfoResult;
import com.lfxwkj.purchase.modular.service.ProjectinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 郭晓东
 * @since 2020-03-13
 */
@Service
public class ProjectinfoServiceImpl extends ServiceImpl<ProjectinfoMapper, Projectinfo> implements ProjectinfoService {

    @Autowired
    private ProjectimgMapper projectimgMapper;

    /**
     * 更多项目详情
     */
    @DataSource(name="njhxcx")
    public Moredetail moredetail(String id){
        // 查询出来项目的信息
        Moredetail moredetail = this.baseMapper.modetail(id);
        return  moredetail;
    }

    /**
     * 手机端项目的详情
     *
     */
    @DataSource(name="njhxcx")
    public Projectdetail pojectdetail(String id){
        // 查询出来项目的详细
        Projectdetail projectdetail = this.baseMapper.pojectdetail(id);
        // 查询出来项目的图片列表
        List<String> list = projectimgMapper.selectPicListByprojectId(id);
        projectdetail.setPictureUrls(list);
        return projectdetail;
    }

    @DataSource(name="njhxcx")
    public List<Projectlist> projectlist(ProjectinfoParam param) {
        return  this.baseMapper.projectlist(param);
    }

    @Override
    public void add(ProjectinfoParam param) {
        Projectinfo entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(ProjectinfoParam param) {
        this.removeById(getKey(param));
    }

    @Override
    public void update(ProjectinfoParam param) {
        Projectinfo oldEntity = getOldEntity(param);
        Projectinfo newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public ProjectinfoResult findBySpec(ProjectinfoParam param) {
        return null;
    }

    @Override
    public List<ProjectinfoResult> findListBySpec(ProjectinfoParam param) {
        return null;
    }

    @Override
    public LayuiPageInfo findPageBySpec(ProjectinfoParam param) {
        Page pageContext = getPageContext();
        IPage page = this.baseMapper.customPageList(pageContext, param);
        return LayuiPageFactory.createPageInfo(page);
    }

    private Serializable getKey(ProjectinfoParam param) {
        return param.getId();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private Projectinfo getOldEntity(ProjectinfoParam param) {
        return this.getById(getKey(param));
    }

    private Projectinfo getEntity(ProjectinfoParam param) {
        Projectinfo entity = new Projectinfo();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
