package com.castlebell.lingvo.cmm.session;

import java.io.Serializable;

public class WorkSafetyCheck implements Serializable {

    private static final long serialVersionUID = 1L;

    private String gubun;
    private String userid;
    private String qrCode;
    private String workGubun;
    private String workClass;
    private String state;
    private String ip;
    private String workSeq;
    private String etcParam1;
    private Integer retVal;
    private String errMsg;
    private String errCode;
    private String siteCode;
    private String siteName;
    private String siteAddress;
    private String constName;
    private String companyName;
    private String workType;

    public String getGubun() {
        return gubun;
    }

    public void setGubun(String gubun) {
        this.gubun = gubun;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public String getWorkGubun() {
        return workGubun;
    }

    public void setWorkGubun(String workGubun) {
        this.workGubun = workGubun;
    }

    public String getWorkClass() {
        return workClass;
    }

    public void setWorkClass(String workClass) {
        this.workClass = workClass;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getEtcParam1() {
        return etcParam1;
    }

    public void setEtcParam1(String etcParam1) {
        this.etcParam1 = etcParam1;
    }

    public Integer getRetVal() {
        return retVal;
    }

    public void setRetVal(Integer retVal) {
        this.retVal = retVal;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

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

    public String getSiteAddress() {
        return siteAddress;
    }

    public void setSiteAddress(String siteAddress) {
        this.siteAddress = siteAddress;
    }

    public String getConstName() {
        return constName;
    }

    public void setConstName(String constName) {
        this.constName = constName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
    }

    public String getWorkSeq() {
        return workSeq;
    }

    public void setWorkSeq(String workSeq) {
        this.workSeq = workSeq;
    }

    @Override
    public String toString() {
        return "WorkSafetyCheck [gubun=" + gubun + ", userid=" + userid + ", qrCode=" + qrCode + ", workGubun="
                + workGubun + ", workClass=" + workClass + ", state=" + state + ", ip=" + ip + ", workSeq=" + workSeq
                + ", etcParam1=" + etcParam1 + ", retVal=" + retVal + ", errMsg=" + errMsg + ", errCode=" + errCode
                + ", siteCode=" + siteCode + ", siteName=" + siteName + ", siteAddress=" + siteAddress + ", constName="
                + constName + ", companyName=" + companyName + ", workType=" + workType + ", workSeq=" + workSeq + "]";
    }
}