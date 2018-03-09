package com.pandawork.home.common.exception;

import com.pandawork.core.common.exception.IBizExceptionMes;

/**
 * Created by Taoyongpan on 2017/8/12.
 */
public class OtherException implements IBizExceptionMes {
    private String errMsg;
    private int code;

    public OtherException(String errMsg, int code) {
        this.errMsg = errMsg;
        this.code = code;
    }

    @Override
    public String getMes() {
        return this.errMsg;
    }

    @Override
    public int getCode() {
        return this.code;
    }
}
