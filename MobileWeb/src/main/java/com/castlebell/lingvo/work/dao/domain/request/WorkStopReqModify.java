package com.castlebell.lingvo.work.dao.domain.request;


import java.io.Serializable;

public class WorkStopReqModify implements Serializable {

    private static final long serialVersionUID = 2L;  // 이 값을 변경하여 새로운 버전을 표시합니다.

    // 사용자 식별자
    private String userid;
    // 사이트 코드
    private String siteCode;
    // 구분
    private String gubun;
    // 문제 구분
    private String issueGubun;
    // 위치
    private String location;
    // 요청 이유
    private String reqReason;
    // 이미지 경로
    private String imgPaths;
    // 상태
    private String state;
    // IP 주소
    private String ip;
    // WSR 순번
    private String wsrSeq;
    // 에러 메시지
    private String errMsg;
    // 결과
    private int retVal;

    // 각 필드에 대한 getter 및 setter

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

    public String getGubun() {
        return gubun;
    }

    public void setGubun(String gubun) {
        this.gubun = gubun;
    }

    public String getIssueGubun() {
        return issueGubun;
    }

    public void setIssueGubun(String issueGubun) {
        this.issueGubun = issueGubun;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getReqReason() {
        return reqReason;
    }

    public void setReqReason(String reqReason) {
        this.reqReason = reqReason;
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

    public String getWsrSeq() {
        return wsrSeq;
    }

    public void setWsrSeq(String wsrSeq) {
        this.wsrSeq = wsrSeq;
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
        return "WorkStopReqModify [userid=" + userid + ", siteCode=" + siteCode + ", gubun=" + gubun + ", issueGubun="
                + issueGubun + ", location=" + location + ", reqReason=" + reqReason + ", imgPaths=" + imgPaths
                + ", state=" + state + ", ip=" + ip + ", wsrSeq=" + wsrSeq + ", errMsg=" + errMsg + ", retVal="
                + retVal + "]";
    }
}