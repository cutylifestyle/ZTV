package com.sixin.ztv.recommend.channel.model.bean;

import java.io.Serializable;
import java.util.List;

public class ChannelBannerBean implements Serializable {

        /**
         * rgtype : 2
         * rgval : 1
         * adtype : 0
         * mkurl :
         * linktype : 0
         * showtime : 5
         * ext : {"advertiserUid":0,"clientIp":"223.104.18.224","client_sys":"android","imei":"867951036671598","idfa":"","planId":0,"adId":0}
         * cid :
         * proid : DYGGZXD20181109144300
         * oaid : 612058
         * mid : 66374
         * gid : 11119
         * posid : 2081206
         * srcid : https://sta-op.douyucdn.cn/nggsys/2019/01/10/7de8fbb3dc78c6f7f97369101a1d4a21.jpg
         * link : https://yuba.douyu.com/p/534525691545566396
         * priority : 2
         * adtitle : 《英雄联盟：我的时代》小说连载中
         * c_track_url : []
         * i_track_url : []
         * ec : {"a":"a"}
         * isthird : 0
         * taid :
         * tpid :
         * tmid :
         * tcid : 0
         * bc :
         */

        private int rgtype;
        private String rgval;
        private int adtype;
        private String mkurl;
        private int linktype;
        private int showtime;
        private ExtBean ext;
        private String cid;
        private String proid;
        private int oaid;
        private int mid;
        private int gid;
        private int posid;
        private String srcid;
        private String link;
        private int priority;
        private String adtitle;
        private EcBean ec;
        private int isthird;
        private String taid;
        private String tpid;
        private String tmid;
        private int tcid;
        private String bc;
        private List<String> c_track_url;
        private List<String> i_track_url;

        public int getRgtype() {
            return rgtype;
        }

        public void setRgtype(int rgtype) {
            this.rgtype = rgtype;
        }

        public String getRgval() {
            return rgval;
        }

        public void setRgval(String rgval) {
            this.rgval = rgval;
        }

        public int getAdtype() {
            return adtype;
        }

        public void setAdtype(int adtype) {
            this.adtype = adtype;
        }

        public String getMkurl() {
            return mkurl;
        }

        public void setMkurl(String mkurl) {
            this.mkurl = mkurl;
        }

        public int getLinktype() {
            return linktype;
        }

        public void setLinktype(int linktype) {
            this.linktype = linktype;
        }

        public int getShowtime() {
            return showtime;
        }

        public void setShowtime(int showtime) {
            this.showtime = showtime;
        }

        public ExtBean getExt() {
            return ext;
        }

        public void setExt(ExtBean ext) {
            this.ext = ext;
        }

        public String getCid() {
            return cid;
        }

        public void setCid(String cid) {
            this.cid = cid;
        }

        public String getProid() {
            return proid;
        }

        public void setProid(String proid) {
            this.proid = proid;
        }

        public int getOaid() {
            return oaid;
        }

        public void setOaid(int oaid) {
            this.oaid = oaid;
        }

        public int getMid() {
            return mid;
        }

        public void setMid(int mid) {
            this.mid = mid;
        }

        public int getGid() {
            return gid;
        }

        public void setGid(int gid) {
            this.gid = gid;
        }

        public int getPosid() {
            return posid;
        }

        public void setPosid(int posid) {
            this.posid = posid;
        }

        public String getSrcid() {
            return srcid;
        }

        public void setSrcid(String srcid) {
            this.srcid = srcid;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        public String getAdtitle() {
            return adtitle;
        }

        public void setAdtitle(String adtitle) {
            this.adtitle = adtitle;
        }

        public EcBean getEc() {
            return ec;
        }

        public void setEc(EcBean ec) {
            this.ec = ec;
        }

        public int getIsthird() {
            return isthird;
        }

        public void setIsthird(int isthird) {
            this.isthird = isthird;
        }

        public String getTaid() {
            return taid;
        }

        public void setTaid(String taid) {
            this.taid = taid;
        }

        public String getTpid() {
            return tpid;
        }

        public void setTpid(String tpid) {
            this.tpid = tpid;
        }

        public String getTmid() {
            return tmid;
        }

        public void setTmid(String tmid) {
            this.tmid = tmid;
        }

        public int getTcid() {
            return tcid;
        }

        public void setTcid(int tcid) {
            this.tcid = tcid;
        }

        public String getBc() {
            return bc;
        }

        public void setBc(String bc) {
            this.bc = bc;
        }

        public List<String> getC_track_url() {
            return c_track_url;
        }

        public void setC_track_url(List<String> c_track_url) {
            this.c_track_url = c_track_url;
        }

        public List<String> getI_track_url() {
            return i_track_url;
        }

        public void setI_track_url(List<String> i_track_url) {
            this.i_track_url = i_track_url;
        }

        public static class ExtBean {
            /**
             * advertiserUid : 0
             * clientIp : 223.104.18.224
             * client_sys : android
             * imei : 867951036671598
             * idfa :
             * planId : 0
             * adId : 0
             */

            private int advertiserUid;
            private String clientIp;
            private String client_sys;
            private String imei;
            private String idfa;
            private int planId;
            private int adId;

            public int getAdvertiserUid() {
                return advertiserUid;
            }

            public void setAdvertiserUid(int advertiserUid) {
                this.advertiserUid = advertiserUid;
            }

            public String getClientIp() {
                return clientIp;
            }

            public void setClientIp(String clientIp) {
                this.clientIp = clientIp;
            }

            public String getClient_sys() {
                return client_sys;
            }

            public void setClient_sys(String client_sys) {
                this.client_sys = client_sys;
            }

            public String getImei() {
                return imei;
            }

            public void setImei(String imei) {
                this.imei = imei;
            }

            public String getIdfa() {
                return idfa;
            }

            public void setIdfa(String idfa) {
                this.idfa = idfa;
            }

            public int getPlanId() {
                return planId;
            }

            public void setPlanId(int planId) {
                this.planId = planId;
            }

            public int getAdId() {
                return adId;
            }

            public void setAdId(int adId) {
                this.adId = adId;
            }
        }

        public static class EcBean {
            /**
             * a : a
             */

            private String a;

            public String getA() {
                return a;
            }

            public void setA(String a) {
                this.a = a;
            }
        }

    @Override
    public String toString() {
        return "ChannelBannerBean{" +
                "rgtype=" + rgtype +
                ", rgval='" + rgval + '\'' +
                ", adtype=" + adtype +
                ", mkurl='" + mkurl + '\'' +
                ", linktype=" + linktype +
                ", showtime=" + showtime +
                ", ext=" + ext +
                ", cid='" + cid + '\'' +
                ", proid='" + proid + '\'' +
                ", oaid=" + oaid +
                ", mid=" + mid +
                ", gid=" + gid +
                ", posid=" + posid +
                ", srcid='" + srcid + '\'' +
                ", link='" + link + '\'' +
                ", priority=" + priority +
                ", adtitle='" + adtitle + '\'' +
                ", ec=" + ec +
                ", isthird=" + isthird +
                ", taid='" + taid + '\'' +
                ", tpid='" + tpid + '\'' +
                ", tmid='" + tmid + '\'' +
                ", tcid=" + tcid +
                ", bc='" + bc + '\'' +
                ", c_track_url=" + c_track_url +
                ", i_track_url=" + i_track_url +
                '}';
    }
}




