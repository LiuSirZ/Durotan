package com.durotan.util;

import com.durotan.constant.CommonTipConstant;
import com.durotan.bean.BaseResponseVo;
import com.durotan.bean.CommonResultCode;

public class ResponseUtil {

    /**
     * 返回数据
     *
     * @param code 响应码
     * @param msg  响应信息
     * @param data 响应数据
     * @return BaseResponseVo
     */
    public static BaseResponseVo response(String code, String msg, Object data) {
        BaseResponseVo responseVo = new BaseResponseVo();
        responseVo.setCode(code == null ? CommonResultCode.SUCCESS.getCode() : code);
        responseVo.setMsg(msg);
        if (data != null) {
            responseVo.setData(data);
        }
        return responseVo;
    }

    /**
     * 返回空数据
     *
     * @param resultCode 响应码枚举
     * @return BaseResponseVo
     */
    public static BaseResponseVo responseEmpty(CommonResultCode resultCode) {
        BaseResponseVo responseVo = new BaseResponseVo();
        responseVo.setCodeAndMsg(resultCode);
        return responseVo;
    }

    /**
     * 返回成功
     * code:{@link com.durotan.bean.CommonResultCode#SUCCESS}
     * msg:{@link com.durotan.bean.CommonResultCode#SUCCESS}
     *
     * @param data 响应数据
     * @return BaseResponseVo
     */
    public static BaseResponseVo success(Object data) {
        return response(CommonResultCode.SUCCESS.getCode(), CommonTipConstant.SUCCESS_KEY, data);
    }

    /**
     * 返回成功
     * code:{@link com.durotan.bean.CommonResultCode#SUCCESS}
     * msg:{@link com.durotan.bean.CommonResultCode#SUCCESS}
     *
     * @return BaseResponseVo
     */
    public static BaseResponseVo success() {
        return success(null);
    }

    /**
     * 返回成功
     * code:{@link com.durotan.bean.CommonResultCode#SUCCESS}
     * msg:成功信息(必填)
     *
     * @return BaseResponseVo
     */
    public static BaseResponseVo success(String msg) {
        return response(CommonResultCode.SUCCESS.getCode(), msg == null ? CommonTipConstant.SUCCESS_KEY : msg, null);
    }

    /**
     * 返回失败
     * code:{@link com.durotan.bean.CommonResultCode#FAIL}
     * msg:{@link com.durotan.bean.CommonResultCode#FAIL}
     *
     * @param msg 失败信息(必填)
     * @return
     */
    public static BaseResponseVo faild(String msg) {
        return faild(msg, null);
    }

    /**
     * 返回失败
     * code:{@link com.durotan.bean.CommonResultCode#FAIL}
     * msg:{@link com.durotan.bean.CommonResultCode#FAIL}
     *
     * @param msg  失败信息(必填)
     * @param data 响应数据
     * @return
     */
    public static BaseResponseVo faild(String msg, Object data) {
        return response(CommonResultCode.FAIL.getCode(), msg == null ? CommonTipConstant.FAILED_KEY : msg, data);
    }

    /**
     * 返回系统错误
     * code:{@link com.durotan.bean.CommonResultCode#SYSTEM_INSIDE_ERROR}
     * msg:{@link com.durotan.bean.CommonResultCode#SYSTEM_INSIDE_ERROR}
     *
     * @param data 响应数据
     * @return BaseResponseVo
     */
    public static BaseResponseVo systemError(Object data) {
        return response(CommonResultCode.SYSTEM_INSIDE_ERROR.getCode(), CommonTipConstant.SYSTEM_INSIDE_ERROR_KEY, data);
    }

    /**
     * 返回系统错误
     * code:{@link com.durotan.bean.CommonResultCode#SYSTEM_INSIDE_ERROR}
     * msg:{@link com.durotan.bean.CommonResultCode#SYSTEM_INSIDE_ERROR}
     * data:""
     *
     * @return BaseResponseVo
     */
    public static BaseResponseVo systemError() {
        return systemError(null);
    }

    /**
     * 返回系统异常
     * code:{@link com.durotan.bean.CommonResultCode#UNKNOWN_ERROR}
     * msg:{@link com.durotan.bean.CommonResultCode#UNKNOWN_ERROR}
     *
     * @param data 响应数据
     * @return BaseResponseVo
     */
    public static BaseResponseVo systemException(Object data) {
        return response(CommonResultCode.UNKNOWN_ERROR.getCode(), CommonTipConstant.UNKNOW_ERROR_KEY, data);
    }

}
