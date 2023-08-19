package com.castlebell.lingvo.cs.dao.domain.responese;


import java.io.Serializable;
import java.util.Date;

public class EmergencyInfo implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String siteCode;
    private String name;
    private String hpno;
    private String companyName;
    private String state;
    private Date systemtime;

    public String getSiteCode() {
        return siteCode;
    }

    public void setSiteCode(String siteCode) {
        this.siteCode = siteCode;
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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getSystemtime() {
        return systemtime;
    }

    public void setSystemtime(Date systemtime) {
        this.systemtime = systemtime;
    }

    @Override
    public String toString() {
        return "EmergencyInfo{" +
                "siteCode='" + siteCode + '\'' +
                ", name='" + name + '\'' +
                ", hpno='" + hpno + '\'' +
                ", companyName='" + companyName + '\'' +
                ", state='" + state + '\'' +
                ", systemtime=" + systemtime +
                '}';
    }
}