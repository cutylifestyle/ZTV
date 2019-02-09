package com.sixin.ztv.welcome.model.bean;

public class Platform {


    /**
     * aname : 斗鱼直播
     * pname : air.tv.douyu.android
     */

    private String aname;
    private String pname;

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    @Override
    public String toString() {
        return "Platform{" +
                "aname='" + aname + '\'' +
                ", pname='" + pname + '\'' +
                '}';
    }
}
