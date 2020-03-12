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
 * @since 2020-03-12
 */
@Data
public class ClientinfoResult implements Serializable {

    private static final long serialVersionUID = 1L;


        private Long id;

        private String openID;

            /**
             * 授权的电话
             */
        private String phone;

}
