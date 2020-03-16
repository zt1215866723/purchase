package com.lfxwkj.purchase.modular.model.params;

import cn.stylefeng.roses.kernel.model.validator.BaseValidatingParam;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 郭晓东
 * @since 2020-03-13
 */
@Data
public class DiccontentParam implements Serializable, BaseValidatingParam {

    private static final long serialVersionUID = 1L;


        private Long id;

        private Long typeID;

        private String name;

        private Integer orderNum;

        private String memo;

            /**
             * 0 删除
            1正常
             */
        private Integer state;

    @Override
    public String checkParam() {
        return null;
    }

}
