package com.Ace.Vshop.common.api;

/***
 * 通用返回对象
 */
public class CommonResult<T> {
    private long code;
    private String message;
    private T data;

    /***
     * 构造函数
     */
    protected CommonResult() {

    }

    protected CommonResult(long code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /***
     * 成功返回结果
     * @return
     */
    public static <T> CommonResult<T> success(T data) {
        return new CommonResult<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }

    /***
     * 成功返回结果
     * @return
     */
    public static <T> CommonResult<T> success(T data, String message) {
        return new CommonResult<T>(ResultCode.SUCCESS.getCode(), message, data);
    }

    /***
     * 失败返回结果
     * @return
     */
    public static <T> CommonResult<T> faild(IErrorCode errorCode) {
        return new CommonResult<T>(errorCode.getCode(), errorCode.getMessage(), null);
    }

    /***
     * 失败返回结果
     * @return
     */
    public static <T> CommonResult<T> faild(IErrorCode errorCode, String message) {
        return new CommonResult<T>(errorCode.getCode(), message, null);
    }

    /***
     * 失败返回结果
     * @return
     */
    public static <T> CommonResult<T> faild(String message) {
        return new CommonResult<T>(ResultCode.FAILED.getCode(), message, null);
    }

    /***
     * 失败返回结果
     * @return
     */
    public static <T> CommonResult<T> faild() {
        return faild(ResultCode.FAILED);
    }

    /***
     * 参数检验失败返回结果
     * @return
     */
    public static <T> CommonResult<T> validateFailed() {
        return faild(ResultCode.VALIDATE_FAILED);
    }

    /***
     * 参数校验失败返回结果
     * @return
     */
    public static <T> CommonResult<T> validateFailed(String message) {
        return new CommonResult<>(ResultCode.VALIDATE_FAILED.getCode(), message, null);
    }

    /***
     * 未登录返回结果
     * @return
     */
    public static <T> CommonResult<T> unauthorized(T data) {
        return new CommonResult<>(ResultCode.UNAUTHORIZED.getCode(), ResultCode.UNAUTHORIZED.getMessage(), data);
    }

    /***
     * 未授权返回结果
     * @return
     */
    public static <T> CommonResult<T> forbidden(T data) {
        return new CommonResult<>(ResultCode.FORBIDDEN.getCode(), ResultCode.FORBIDDEN.getMessage(), data);
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
