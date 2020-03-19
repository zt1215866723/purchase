package com.lfxwkj.purchase.modular.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lfxwkj.purchase.modular.entity.Salefollow;
import com.lfxwkj.purchase.modular.model.params.SalefollowParam;
import com.lfxwkj.purchase.modular.model.result.SalefollowResult;
import com.lfxwkj.purchase.modular.model.result.SalespersonResult;
import com.lfxwkj.purchase.modular.model.vo.SaleFollowVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 郭晓东
 * @since 2020-03-12
 */
public interface SalefollowMapper extends BaseMapper<Salefollow> {

        /**
         * 获取列表
         *
         * @author 郭晓东
         * @Date 2020-03-12
         */
        List<SalefollowResult> customList(@Param("paramCondition") SalefollowParam paramCondition);

        /**
         * 获取map列表
         *
         * @author 郭晓东
         * @Date 2020-03-12
         */
        List<Map<String, Object>>customMapList(@Param("paramCondition") SalefollowParam paramCondition);

        /**
         * 获取分页实体列表
         *
         * @author 郭晓东
         * @Date 2020-03-12
         */
        Page<SalefollowResult> customPageList(@Param("page") Page page, @Param("paramCondition") SalefollowParam paramCondition);

        /**
         * 获取分页map列表
         *
         * @author 郭晓东
         * @Date 2020-03-12
         */
        Page<Map<String, Object>>customPageMapList(@Param("page") Page page, @Param("paramCondition") SalefollowParam paramCondition);

        /**
         * 查询销售记录
         * @param id 销售主键 必填
         * @return
         */
    List<SaleFollowVo> saleFollowBysalesID(Long id);

        /**
         * 根据客户查询销售顾问名片
         */
    List<SalespersonResult> salefollowlist(SalefollowParam param);
}
