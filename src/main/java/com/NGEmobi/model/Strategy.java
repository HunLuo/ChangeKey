package com.NGEmobi.model;

public class Strategy {
    private Integer id;

    private String appName;

    private String nBackNewAdxBannerKey;

    private String nBackNewAdxNativeKeyEcpm;

    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName == null ? null : appName.trim();
    }

    public String getnBackNewAdxBannerKey() {
        return nBackNewAdxBannerKey;
    }

    public void setnBackNewAdxBannerKey(String nBackNewAdxBannerKey) {
        this.nBackNewAdxBannerKey = nBackNewAdxBannerKey == null ? null : nBackNewAdxBannerKey.trim();
    }

    public String getnBackNewAdxNativeKeyEcpm() {
        return nBackNewAdxNativeKeyEcpm;
    }

    public void setnBackNewAdxNativeKeyEcpm(String nBackNewAdxNativeKeyEcpm) {
        this.nBackNewAdxNativeKeyEcpm = nBackNewAdxNativeKeyEcpm == null ? null : nBackNewAdxNativeKeyEcpm.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}