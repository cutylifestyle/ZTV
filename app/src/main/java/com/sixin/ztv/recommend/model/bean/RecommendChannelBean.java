package com.sixin.ztv.recommend.model.bean;

import java.io.Serializable;

public class RecommendChannelBean implements Serializable {

    private int level;
    private int tab_id;
    private String cate_name;
    private int cate_id;
    private String push_nearby;
    private String short_name;
    private String push_vertical_screen;
    private String push_ios;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getTab_id() {
        return tab_id;
    }

    public void setTab_id(int tab_id) {
        this.tab_id = tab_id;
    }

    public String getCate_name() {
        return cate_name;
    }

    public void setCate_name(String cate_name) {
        this.cate_name = cate_name;
    }

    public int getCate_id() {
        return cate_id;
    }

    public void setCate_id(int cate_id) {
        this.cate_id = cate_id;
    }

    public String getPush_nearby() {
        return push_nearby;
    }

    public void setPush_nearby(String push_nearby) {
        this.push_nearby = push_nearby;
    }

    public String getShort_name() {
        return short_name;
    }

    public void setShort_name(String short_name) {
        this.short_name = short_name;
    }

    public String getPush_vertical_screen() {
        return push_vertical_screen;
    }

    public void setPush_vertical_screen(String push_vertical_screen) {
        this.push_vertical_screen = push_vertical_screen;
    }

    public String getPush_ios() {
        return push_ios;
    }

    public void setPush_ios(String push_ios) {
        this.push_ios = push_ios;
    }

    @Override
    public String toString() {
        return "RecommendChannelBean{" +
                "level=" + level +
                ", tab_id=" + tab_id +
                ", cate_name='" + cate_name + '\'' +
                ", cate_id=" + cate_id +
                ", push_nearby='" + push_nearby + '\'' +
                ", short_name='" + short_name + '\'' +
                ", push_vertical_screen='" + push_vertical_screen + '\'' +
                ", push_ios='" + push_ios + '\'' +
                '}';
    }
}
