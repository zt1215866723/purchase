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
public class ProjectdynamicResult implements Serializable {

    private static final long serialVersionUID = 1L;


        private Long id;

        private Long projectId;

            /**
             * 预售证、开盘、交房等
            
             */
        private Long dynamicType;

        private String title;

        private Date dynamicDate;

        private String content;

        private String dynamicName;

        private String projectName;

        private String dynamicTypeName;
}
