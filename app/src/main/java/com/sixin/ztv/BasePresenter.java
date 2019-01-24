package com.sixin.ztv;

public interface BasePresenter {
    /**
     * 释放Presenter中持有的view，防止发生内存泄漏
     * */
    void release();
}
