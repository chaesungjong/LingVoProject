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
    private String pageNo;
    private String pageSize;
    private String etcParam;

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
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getCompnayName() {
        return this.companyName;
    }

    public void setCompnayName(String companyName) {
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

    public String getPageNo() {
        return pageNo;
    }

    public void setPageNo(String pageNo) {
        this.pageNo = pageNo;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public String getEtcParam() {
        return etcParam;
    }

    public void setEtcParam(String etcParam) {
        this.etcParam = etcParam;
    }
}