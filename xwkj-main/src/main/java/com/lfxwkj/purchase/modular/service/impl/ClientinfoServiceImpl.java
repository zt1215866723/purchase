package com.lfxwkj.purchase.modular.service.impl;

import cn.stylefeng.roses.core.mutidatasource.annotion.DataSource;
import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lfxwkj.purchase.base.pojo.page.LayuiPageFactory;
import com.lfxwkj.purchase.base.pojo.page.LayuiPageInfo;
import com.lfxwkj.purchase.modular.entity.Clientinfo;
import com.lfxwkj.purchase.modular.mapper.ClientinfoMapper;
import com.lfxwkj.purchase.modular.model.params.ClientinfoParam;
import com.lfxwkj.purchase.modular.model.result.ClientinfoResult;
import com.lfxwkj.purchase.modular.service.ClientinfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 郭晓东
 * @since 2020-03-12
 */
@Service
public class ClientinfoServiceImpl extends ServiceImpl<ClientinfoMapper, Clientinfo> implements ClientinfoService {

    @Override
    public void add(ClientinfoParam param) {
        Clientinfo entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(ClientinfoParam param) {
        this.removeById(getKey(param));
    }

    @Override
    public void update(ClientinfoParam param) {
        Clientinfo oldEntity = getOldEntity(param);
        Clientinfo newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public ClientinfoResult findBySpec(ClientinfoParam param) {
        return null;
    }

    @Override
    public List<ClientinfoResult> findListBySpec(ClientinfoParam param) {
        return null;
    }

    @Override
    @DataSource(name = "purchase")
    public LayuiPageInfo findPageBySpec(ClientinfoParam param) {
        Page pageContext = getPageContext();
        IPage page = this.baseMapper.customPageList(pageContext, param);
        return LayuiPageFactory.createPageInfo(page);
    }

    private Serializable getKey(ClientinfoParam param) {
        return param.getId();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private Clientinfo getOldEntity(ClientinfoParam param) {
        return this.getById(getKey(param));
    }

    private Clientinfo getEntity(ClientinfoParam param) {
        Clientinfo entity = new Clientinfo();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
