package com.sixin.ztv.Http.Exception;

public class ApiException extends Exception {

    private int errorCode;

    public ApiException(int errorCode,String errorMsg) {
        super(errorMsg);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
}
