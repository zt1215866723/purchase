package com.lfxwkj.purchase.base.auth.exception;

import cn.stylefeng.roses.kernel.model.exception.AbstractBaseExceptionEnum;
import com.lfxwkj.purchase.base.auth.exception.enums.AuthExceptionEnum;
import lombok.Data;

/**
 * 没有访问权限
 *
 * @author fengshuonan
 * @Date 2019/7/18 22:18
 */
@Data
public class PermissionException extends RuntimeException {

    private Integer code;
    private String errorMessage;

    public PermissionException() {
        super(AuthExceptionEnum.NO_PERMISSION.getMessage());
        this.code = AuthExceptionEnum.NO_PERMISSION.getCode();
        this.errorMessage = AuthExceptionEnum.NO_PERMISSION.getMessage();
    }

    public PermissionException(AbstractBaseExceptionEnum exception) {
        super(exception.getMessage());
        this.code = exception.getCode();
        this.errorMessage = exception.getMessage();
    }

}
