package com.sixin.ztv.Http.Exception;

import android.net.ParseException;

import com.google.gson.JsonParseException;
import org.json.JSONException;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

public class ResponseException extends Exception {

    /**
     * 未知错误
     */
    private static final int UNKNOWN = 9000;

    /**
     * 解析错误
     */
    private static final int PARSE_ERROR = 9001;

    private static final int CONNECT_ERROR = 9002;

    private static final int UNKNOWN_HOST_ERROR = 9003;

    private static final int TIME_OUT_ERROR = 9004;



    private int errorCode;

    public ResponseException(int errorCode,String message,Throwable throwable) {
        super(message, throwable);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }

    //todo 测试500和404  这个部分的异常需要继续细化，以笼统的未知异常打发不行
    public static ResponseException handleException(Throwable e) {
        ResponseException ex;
        if (e instanceof JsonParseException
                || e instanceof JSONException
                || e instanceof ParseException) {
            //解析错误
            ex = new ResponseException(PARSE_ERROR, e.getMessage(),e);
            return ex;
        } else if (e instanceof ConnectException) {
            //网络错误
            ex = new ResponseException(CONNECT_ERROR, e.getMessage(),e);
            return ex;
        } else if (e instanceof UnknownHostException) {
            //连接错误
            ex = new ResponseException(UNKNOWN_HOST_ERROR, e.getMessage(),e);
            return ex;
        } else if(e instanceof SocketTimeoutException){
            ex = new ResponseException(TIME_OUT_ERROR,e.getMessage(),e);
            return ex;
        } else {
            //未知错误
            ex = new ResponseException(UNKNOWN, e.getMessage(),e);
            return ex;
        }
    }
}
