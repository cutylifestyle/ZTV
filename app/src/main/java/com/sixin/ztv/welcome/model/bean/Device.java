package com.sixin.ztv.welcome.model.bean;

public class Device {
    /**
     * addid : 16b4c2381ee392ee
     * devtype : 0
     * h : 2160
     * idfa :
     * imei : 867951036671598
     * mac : 34:D7:12:95:E1:58
     * mfrs : SMARTISAN
     * model : OC105
     * nt : 1
     * op : 1
     * os : Android
     * osv : 7.1.2
     * ua : Douyu_Android
     * w : 1080
     */

    private String addid;
    private String devtype;
    private String h;
    private String idfa;
    private String imei;
    private String mac;
    private String mfrs;
    private String model;
    private String nt;
    private String op;
    private String os;
    private String osv;
    private String ua;
    private String w;

    public String getAddid() {
        return addid;
    }

    public void setAddid(String addid) {
        this.addid = addid;
    }

    public String getDevtype() {
        return devtype;
    }

    public void setDevtype(String devtype) {
        this.devtype = devtype;
    }

    public String getH() {
        return h;
    }

    public void setH(String h) {
        this.h = h;
    }

    public String getIdfa() {
        return idfa;
    }

    public void setIdfa(String idfa) {
        this.idfa = idfa;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getMfrs() {
        return mfrs;
    }

    public void setMfrs(String mfrs) {
        this.mfrs = mfrs;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNt() {
        return nt;
    }

    public void setNt(String nt) {
        this.nt = nt;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getOsv() {
        return osv;
    }

    public void setOsv(String osv) {
        this.osv = osv;
    }

    public String getUa() {
        return ua;
    }

    public void setUa(String ua) {
        this.ua = ua;
    }

    public String getW() {
        return w;
    }

    public void setW(String w) {
        this.w = w;
    }

    @Override
    public String toString() {
        return "Device{" +
                "addid='" + addid + '\'' +
                ", devtype='" + devtype + '\'' +
                ", h='" + h + '\'' +
                ", idfa='" + idfa + '\'' +
                ", imei='" + imei + '\'' +
                ", mac='" + mac + '\'' +
                ", mfrs='" + mfrs + '\'' +
                ", model='" + model + '\'' +
                ", nt='" + nt + '\'' +
                ", op='" + op + '\'' +
                ", os='" + os + '\'' +
                ", osv='" + osv + '\'' +
                ", ua='" + ua + '\'' +
                ", w='" + w + '\'' +
                '}';
    }
}
