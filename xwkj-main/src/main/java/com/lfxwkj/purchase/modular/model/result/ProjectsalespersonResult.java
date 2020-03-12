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
public class ProjectsalespersonResult implements Serializable {

    private static final long serialVersionUID = 1L;


        private Long id;

        private Long projectID;

        private Long salespersonID;

            /**
             * 默认为0  值越大靠前
             */
        private Integer orderNum;

}
