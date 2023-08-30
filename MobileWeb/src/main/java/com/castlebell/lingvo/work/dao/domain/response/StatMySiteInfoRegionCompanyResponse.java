package com.castlebell.lingvo.work.dao.domain.response;

import java.io.Serializable;

public class StatMySiteInfoRegionCompanyResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private String siteCode;
    private String companyName;
    private String nWork;
    private String nSafeEnd;
    private String nWorkStopRequest;

    public String getSiteCode() {
        return siteCode;
    }

    public void setSiteCode(String siteCode) {
        this.siteCode = siteCode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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
        return "StatMySiteInfoRegionCompanyResponse{" +
                "siteCode='" + siteCode + '\'' +
                ", companyName='" + companyName + '\'' +
                ", nWork='" + nWork + '\'' +
                ", nSafeEnd='" + nSafeEnd + '\'' +
                ", nWorkStopRequest='" + nWorkStopRequest + '\'' +
                '}';
    }
}