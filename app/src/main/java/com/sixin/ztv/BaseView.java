package com.sixin.ztv;

public interface BaseView {
    /**
     * 视图是否被销毁
     * @return true 视图已经被销毁  false 视图未被销毁
     * */
    boolean isActive();
}
