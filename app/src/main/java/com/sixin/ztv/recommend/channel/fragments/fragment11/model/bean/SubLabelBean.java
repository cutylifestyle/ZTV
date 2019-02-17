package com.sixin.ztv.recommend.channel.fragments.fragment11.model.bean;

import java.io.Serializable;

public class SubLabelBean implements Serializable {
        /**
         * id : 168
         * name : 妹纸主播
         */
        private int id;
        private String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    @Override
    public String toString() {
        return "SubLabelBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
