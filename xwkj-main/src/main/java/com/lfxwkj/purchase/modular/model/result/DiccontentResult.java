package com.lfxwkj.purchase.modular.model.result;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 
 * </p>
 *
 * @author 郭晓东
 * @since 2020-03-13
 */
@Data
public class DiccontentResult implements Serializable {

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

}
