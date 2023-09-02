package com.castlebell.lingvo.work.dao.domain.response;

import java.io.Serializable;
public class StatMySiteInfoRegionAllResponse implements Serializable {

    private static final long serialVersionUID = 4L;

    private String siteSubAddr2;
    private String nWork;
    private String nSafeEnd;
    private String nWorkStopRequest;
    private String constCode;
    private String constName;

    public String getSiteSubAddr2() {
        return siteSubAddr2;
    }

    public void setSiteSubAddr2(String siteSubAddr2) {
        this.siteSubAddr2 = siteSubAddr2;
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

    public String getConstCode() {
        return constCode;
    }

    public void setConstCode(String constCode) {
        this.constCode = constCode;
    }

    public String getConstName() {
        return constName;
    }

    public void setConstName(String constName) {
        this.constName = constName;
    }

    @Override
    public String toString() {
        return "StatMySiteInfoRegionAllResponse [siteSubAddr2=" + siteSubAddr2 + ", nWork=" + nWork + ", nSafeEnd="
                + nSafeEnd + ", nWorkStopRequest=" + nWorkStopRequest + ", constCode=" + constCode + ", constName="
                + constName + "]";
    }
}