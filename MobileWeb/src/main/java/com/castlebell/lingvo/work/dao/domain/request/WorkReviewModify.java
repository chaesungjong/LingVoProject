package com.castlebell.lingvo.work.dao.domain.request;

import java.io.Serializable;

public class WorkReviewModify implements Serializable {

    private static final long serialVersionUID = 2L;

    private String gubun;
    private String userid;
    private String siteCode;
    private String reviewClass;
    private String reviewGubun;
    private String location;
    private String content;
    private String imgPaths;
    private String state;
    private String ip;
    private String wrSeq;
    private String errMsg;
    private int retVal;

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

    public String getSiteCode() {
        return siteCode;
    }

    public void setSiteCode(String siteCode) {
        this.siteCode = siteCode;
    }

    public String getReviewClass() {
        return reviewClass;
    }

    public void setReviewClass(String reviewClass) {
        this.reviewClass = reviewClass;
    }

    public String getReviewGubun() {
        return reviewGubun;
    }

    public void setReviewGubun(String reviewGubun) {
        this.reviewGubun = reviewGubun;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImgPaths() {
        return imgPaths;
    }

    public void setImgPaths(String imgPaths) {
        this.imgPaths = imgPaths;
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

    public String getWrSeq() {
        return wrSeq;
    }

    public void setWrSeq(String wrSeq) {
        this.wrSeq = wrSeq;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
    
    public int getRetVal() {
        return retVal;
    }

    public void setRetVal(int retVal) {
        this.retVal = retVal;
    }

    @Override
    public String toString() {
        return "WorkReviewModify{" +
                "gubun='" + gubun + '\'' +
                ", userid='" + userid + '\'' +
                ", siteCode='" + siteCode + '\'' +
                ", reviewClass='" + reviewClass + '\'' +
                ", reviewGubun='" + reviewGubun + '\'' +
                ", location='" + location + '\'' +
                ", content='" + content + '\'' +
                ", imgPaths='" + imgPaths + '\'' +
                ", state='" + state + '\'' +
                ", ip='" + ip + '\'' +
                ", wrSeq=" + wrSeq +
                ", errMsg='" + errMsg + '\'' +
                ", retVal='" + retVal + '\'' +
                '}';
    }
}