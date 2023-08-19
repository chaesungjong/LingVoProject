package com.castlebell.lingvo.cmm.session;

import java.io.Serializable;

public class Member implements Serializable {

    private static final long serialVersionUID = 1L;

    private String userid;
    private String userkey;
    private String pwd;
    private String name;
    private String hpno;
    private String emrHpno;
    private String bloodType;
    private String siteCode;
    private String addr;
    private String foreignYn;
    private String idImgUrl;
    private String state;
    private String grade;
    private String requestTime;
    private String approvalTime;
    private String approvaladminId;
    private Integer retVal;
    private String errMsg;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getsiteCode() {
        return siteCode;
    }

    public void setsiteCode(String siteCode) {
        this.siteCode = siteCode;
    }

    public String getuserkey() {
        return userkey;
    }

    public void setuserkey(String userkey) {
        this.userkey = userkey;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHpno() {
        return hpno;
    }

    public void setHpno(String hpno) {
        this.hpno = hpno;
    }

    public String getemrHpno() {
        return emrHpno;
    }

    public void setemrHpno(String emrHpno) {
        this.emrHpno = emrHpno;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getForeignYn() {
        return foreignYn;
    }

    public void setForeignYn(String foreignYn) {
        this.foreignYn = foreignYn;
    }

    public String getIdImgUrl() {
        return idImgUrl;
    }

    public void setIdImgUrl(String idImgUrl) {
        this.idImgUrl = idImgUrl;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(String requestTime) {
        this.requestTime = requestTime;
    }

    public String getApprovalTime() {
        return approvalTime;
    }

    public void setApprovalTime(String approvalTime) {
        this.approvalTime = approvalTime;
    }

    public String getApprovaladminId() {
        return approvaladminId;
    }

    public void setApprovaladminId(String approvaladminId) {
        this.approvaladminId = approvaladminId;
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
    
    @Override
    public String toString() {
        return "Member{" +
                "userid='" + userid + '\'' +
                ", userkey='" + userkey + '\'' +
                ", pwd='" + pwd + '\'' +
                ", name='" + name + '\'' +
                ", hpno='" + hpno + '\'' +
                ", emrHpno='" + emrHpno + '\'' +
                ", bloodType='" + bloodType + '\'' +
                ", addr='" + addr + '\'' +
                ", foreignYn='" + foreignYn + '\'' +
                ", idImgUrl='" + idImgUrl + '\'' +
                ", state='" + state + '\'' +
                ", grade='" + grade + '\'' +
                ", requestTime='" + requestTime + '\'' +
                ", approvalTime='" + approvalTime + '\'' +
                ", approvaladminId='" + approvaladminId + '\'' +
                '}';
    }
}