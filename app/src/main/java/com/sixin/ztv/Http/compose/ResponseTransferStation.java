package com.sixin.ztv.Http.compose;

import com.sixin.ztv.Http.Exception.ApiException;
import com.sixin.ztv.Http.Exception.ResponseException;
import com.sixin.ztv.Http.response.Response;
import com.sixin.ztv.utils.LogUtils;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.functions.Function;

/**
 * 响应中转站
 * 对网络请求的结果进行预处理之后在传递给下游
 * */
public class ResponseTransferStation {
    public static<T> ObservableTransformer<Response<T>,T> handleReponse(){
        return new ObservableTransformer<Response<T>, T>() {
            @Override
            public ObservableSource<T> apply(Observable<Response<T>> upstream) {
                return upstream.onErrorResumeNext(new ErrorFunction<T>())
                               .flatMap(new ResponseFunction<T>());
            }
        };
    }

    private static class ErrorFunction<T> implements Function<Throwable,ObservableSource<? extends Response<T>>>{

        @Override
        public ObservableSource<? extends Response<T>> apply(Throwable throwable) throws Exception {
            return Observable.error(ResponseException.handleException(throwable));
        }
    }

    private static class ResponseFunction<T> implements Function<Response<T>, ObservableSource<T>> {

        @Override
        public ObservableSource<T> apply(Response<T> tResponse) throws Exception {
            int code = tResponse.getErrorCode();
            if (code == 0) {
                return Observable.just(tResponse.getData());
            } else {
                return Observable.error(new ApiException(code, null));
            }
        }
    }


}
