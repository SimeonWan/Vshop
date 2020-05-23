package com.Ace.Vshop.common.exception;

import com.Ace.Vshop.common.api.CommonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/***
 * 全局异常处理类
 */
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = ApiException.class)
    public CommonResult handle(ApiException e) {
        if (e.getErrorCode() != null) {
            return CommonResult.faild(e.getErrorCode());
        }

        return CommonResult.faild(e.getMessage());
    }
}
