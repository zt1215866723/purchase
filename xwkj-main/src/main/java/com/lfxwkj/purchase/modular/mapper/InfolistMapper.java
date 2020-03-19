package com.lfxwkj.purchase.modular.mapper;

import com.lfxwkj.purchase.modular.entity.Infolist;
import com.lfxwkj.purchase.modular.model.params.InfolistParam;
import com.lfxwkj.purchase.modular.model.params.ProjectinfoParam;
import com.lfxwkj.purchase.modular.model.result.InfolistResult;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lfxwkj.purchase.modular.model.result.ProjectinfoResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 存储新闻、公告等信息 
 Mapper 接口
 * </p>
 *
 * @author 郭晓东
 * @since 2020-03-12
 */
public interface InfolistMapper extends BaseMapper<Infolist> {

        /**
         * 获取列表
         *
         * @author 郭晓东
         * @Date 2020-03-12
         */
        List<InfolistResult> customList(@Param("paramCondition") InfolistParam paramCondition);

        /**
         * 获取map列表
         *
         * @author 郭晓东
         * @Date 2020-03-12
         */
        List<Map<String, Object>>customMapList(@Param("paramCondition") InfolistParam paramCondition);

        /**
         * 获取分页实体列表
         *
         * @author 郭晓东
         * @Date 2020-03-12
         */
        Page<InfolistResult> customPageList(@Param("page") Page page, @Param("paramCondition") InfolistParam paramCondition);

        /**
         * 获取分页map列表
         *
         * @author 郭晓东
         * @Date 2020-03-12
         */
        Page<Map<String, Object>>customPageMapList(@Param("page") Page page, @Param("paramCondition") InfolistParam paramCondition);

        /**
         * 获取公告列表
         * @author : 张童
         */

        List<InfolistResult> noticeInfoList(@Param("paramCondition") InfolistParam paramCondition);

        /**
         * 获取新闻详情列表
         * @author : 张童
         */

        InfolistResult noticeDetails(@Param("paramCondition") InfolistParam paramCondition);

}
