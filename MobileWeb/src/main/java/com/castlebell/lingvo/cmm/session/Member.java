package com.castlebell.lingvo.cmm.session;

import java.io.Serializable;

public class Member implements Serializable {

    private static final long serialVersionUID = 1L;

    private String userid;
    private String userkey;
    private String pwd;
    private String name;
    private String hpno;
    private String birthday;
    private String gender;
    private String companyName;
    private String workType;
    private String grade;
    private String state;
    private String appUseYN;
    private String mngUseYN;
    private String systemtime;
    private String siteCode;
    private String siteName;
    private String siteCompanyName;
    private String siteAddress;
    private String siteSubAddr1;
    private String siteSubAddr2;
    private String siteState;
    private String constCode;
    private String constName;
    private String constState;
    private String svgCode;
    private String svgName;
    private String svgRegion;
    private String svgState;
    private String todayWorkYN;
    private String eetVal;
    private String errMsg;

    // Getter and Setter methods
    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUserkey() {
        return userkey;
    }

    public void setUserkey(String userkey) {
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAppUseYN() {
        return appUseYN;
    }

    public void setAppUseYN(String appUseYN) {
        this.appUseYN = appUseYN;
    }

    public String getMngUseYN() {
        return mngUseYN;
    }

    public void setMngUseYN(String mngUseYN) {
        this.mngUseYN = mngUseYN;
    }

    public String getSystemtime() {
        return systemtime;
    }

    public void setSystemtime(String systemtime) {
        this.systemtime = systemtime;
    }

    public String getsiteCode() {
        return siteCode;
    }

    public void setsiteCode(String siteCode) {
        this.siteCode = siteCode;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getSiteCompanyName() {
        return siteCompanyName;
    }

    public void setSiteCompanyName(String siteCompanyName) {
        this.siteCompanyName = siteCompanyName;
    }

    public String getSiteAddress() {
        return siteAddress;
    }

    public void setSiteAddress(String siteAddress) {
        this.siteAddress = siteAddress;
    }

    public String getSiteSubAddr1() {
        return siteSubAddr1;
    }

    public void setSiteSubAddr1(String siteSubAddr1) {
        this.siteSubAddr1 = siteSubAddr1;
    }

    public String getSiteSubAddr2() {
        return siteSubAddr2;
    }

    public void setSiteSubAddr2(String siteSubAddr2) {
        this.siteSubAddr2 = siteSubAddr2;
    }

    public String getSiteState() {
        return siteState;
    }

    public void setSiteState(String siteState) {
        this.siteState = siteState;
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

    public String getConstState() {
        return constState;
    }

    public void setConstState(String constState) {
        this.constState = constState;
    }

    public String getSvgCode() {
        return svgCode;
    }

    public void setSvgCode(String svgCode) {
        this.svgCode = svgCode;
    }

    public String getSvgName() {
        return svgName;
    }

    public void setSvgName(String svgName) {
        this.svgName = svgName;
    }

    public String getSvgRegion() {
        return svgRegion;
    }

    public void setSvgRegion(String svgRegion) {
        this.svgRegion = svgRegion;
    }

    public String getSvgState() {
        return svgState;
    }

    public void setSvgState(String svgState) {
        this.svgState = svgState;
    }

    public String getTodayWorkYN() {
        return todayWorkYN;
    }

    public void setTodayWorkYN(String todayWorkYN) {
        this.todayWorkYN = todayWorkYN;
    }

    public String getEetVal() {
        return eetVal;
    }   

    public void setEetVal(String eetVal) {
        this.eetVal = eetVal;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    @Override
    public String toString() {
        return "Member [" +
                "userid=" + userid +
                ", userkey=" + userkey +
                ", pwd=" + pwd +
                ", name=" + name +
                ", hpno=" + hpno +
                ", birthday=" + birthday +
                ", gender=" + gender +
                ", companyName=" + companyName +
                ", workType=" + workType +
                ", grade=" + grade +
                ", state=" + state +
                ", appUseYN=" + appUseYN +
                ", mngUseYN=" + mngUseYN +
                ", systemtime=" + systemtime +
                ", siteCode=" + siteCode +
                ", siteName=" + siteName +
                ", siteCompanyName=" + siteCompanyName +
                ", siteAddress=" + siteAddress +
                ", siteSubAddr1=" + siteSubAddr1 +
                ", siteSubAddr2=" + siteSubAddr2 +
                ", siteState=" + siteState +
                ", constCode=" + constCode +
                ", constName=" + constName +
                ", constState=" + constState +
                ", svgCode=" + svgCode +
                ", svgName=" + svgName +
                ", svgRegion=" + svgRegion +
                ", svgState=" + svgState +
                ", todayWorkYN=" + todayWorkYN +
                "]";
    }
}