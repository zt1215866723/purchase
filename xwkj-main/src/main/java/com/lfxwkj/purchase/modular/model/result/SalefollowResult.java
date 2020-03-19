package com.lfxwkj.purchase.modular.model.result;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author 郭晓东
 * @since 2020-03-12
 */
@Data
public class SalefollowResult implements Serializable {

    private static final long serialVersionUID = 1L;


        private Long id;

        private Long salesID;

        private Long clientID;

        private Date followTime;

}
