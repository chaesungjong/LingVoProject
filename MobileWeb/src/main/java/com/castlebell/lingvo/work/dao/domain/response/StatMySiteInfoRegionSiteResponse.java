package com.castlebell.lingvo.work.dao.domain.response;

import java.io.Serializable;

public class StatMySiteInfoRegionSiteResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private String siteCode;
    private String siteName;
    private String nWork;
    private String nSafeEnd;
    private String nWorkStopRequest;

    public String getSiteCode() {
        return siteCode;
    }

    public void setSiteCode(String siteCode) {
        this.siteCode = siteCode;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getnWork() {
        return nWork;
    }

    public void setnWork(String nWork) {
        this.nWork = nWork;
    }

    public String getnSafeEnd() {
        return nSafeEnd;
    }

    public void setnSafeEnd(String nSafeEnd) {
        this.nSafeEnd = nSafeEnd;
    }

    public String getnWorkStopRequest() {
        return nWorkStopRequest;
    }

    public void setnWorkStopRequest(String nWorkStopRequest) {
        this.nWorkStopRequest = nWorkStopRequest;
    }

    @Override
    public String toString() {
        return "StatMySiteInfoRegionSiteResponse{" +
                "siteCode='" + siteCode + '\'' +
                ", siteName='" + siteName + '\'' +
                ", nWork='" + nWork + '\'' +
                ", nSafeEnd='" + nSafeEnd + '\'' +
                ", nWorkStopRequest='" + nWorkStopRequest + '\'' +
                '}';
    }
}

