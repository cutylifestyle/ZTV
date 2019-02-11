package com.sixin.ztv.recommend.channel.model.bean;

import java.io.Serializable;

public class ChannelLevelLableBean implements Serializable {
        /**
         * cate2_id : 270
         * component_id : 9
         * title : 集锦
         * is_tab : 1
         * conf : {"vod_cate_type":2,"vcid1":102,"vcid2":104}
         */

        private int cate2_id;
        private int component_id;
        private String title;
        private int is_tab;
        private ConfBean conf;

        public int getCate2_id() {
            return cate2_id;
        }

        public void setCate2_id(int cate2_id) {
            this.cate2_id = cate2_id;
        }

        public int getComponent_id() {
            return component_id;
        }

        public void setComponent_id(int component_id) {
            this.component_id = component_id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getIs_tab() {
            return is_tab;
        }

        public void setIs_tab(int is_tab) {
            this.is_tab = is_tab;
        }

        public ConfBean getConf() {
            return conf;
        }

        public void setConf(ConfBean conf) {
            this.conf = conf;
        }

    @Override
    public String toString() {
        return "ChannelLevelLableBean{" +
                "cate2_id=" + cate2_id +
                ", component_id=" + component_id +
                ", title='" + title + '\'' +
                ", is_tab=" + is_tab +
                ", conf=" + conf +
                '}';
    }

    public static class ConfBean {
            /**
             * vod_cate_type : 2
             * vcid1 : 102
             * vcid2 : 104
             */

            private int vod_cate_type;
            private int vcid1;
            private int vcid2;

            public int getVod_cate_type() {
                return vod_cate_type;
            }

            public void setVod_cate_type(int vod_cate_type) {
                this.vod_cate_type = vod_cate_type;
            }

            public int getVcid1() {
                return vcid1;
            }

            public void setVcid1(int vcid1) {
                this.vcid1 = vcid1;
            }

            public int getVcid2() {
                return vcid2;
            }

            public void setVcid2(int vcid2) {
                this.vcid2 = vcid2;
            }

        @Override
        public String toString() {
            return "ConfBean{" +
                    "vod_cate_type=" + vod_cate_type +
                    ", vcid1=" + vcid1 +
                    ", vcid2=" + vcid2 +
                    '}';
        }
    }
}
