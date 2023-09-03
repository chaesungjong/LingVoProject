package com.castlebell.lingvo.work.dao.domain.request;

import java.io.Serializable;

public class StateMySiteInfoRequest implements Serializable {

    private static final long serialVersionUID = 3L;

    private String gubun;
    private String userid;
    private String grade;
    private String svgCode;
    private String constCode;
    private String siteCode;
    private String regionName;
    private String companyName;
    private String sDate;
    private String eDate;
    private String workUserid;

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

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getSvgCode() {
        return svgCode;
    }

    public void setSvgCode(String svgCode) {
        this.svgCode = svgCode;
    }

    public String getConstCode() {
        return constCode;
    }

    public void setConstCode(String constCode) {
        this.constCode = constCode;
    }

    public String getSiteCode() {
        return siteCode;
    }

    public void setSiteCode(String siteCode) {
        this.siteCode = siteCode;
    }

    public String getRegionName() {
        return this.regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getCompnayName() {
        return this.companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getSdate() {
        return sDate;
    }

    public void setSdate(String sDate) {
        this.sDate = sDate;
    }

    public String getEdate() {
        return eDate;
    }

    public void setEdate(String eDate) {
        this.eDate = eDate;
    }

    public String getWorkUserid() {
        return workUserid;
    }

    public void setWorkUserid(String workUserid) {
        this.workUserid = workUserid;
    }

    @Override
    public String toString(){
        return "StateMySiteInfoRequest [gubun=" + gubun + ", userid=" + userid + ", grade=" + grade + ", svgCode=" + svgCode + ", constCode=" + constCode + ", siteCode=" + siteCode + ", regionName=" + regionName + ", companyName=" + companyName + ", sDate=" + sDate + ", eDate=" + eDate + ", workUserid=" + workUserid + "]";
    }
}