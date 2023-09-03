package com.castlebell.lingvo.work.dao.domain.response;

import java.io.Serializable;

public class StatMySiteInfoSiteWorkAllCompResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private String userid;
    private String name;
    private String hpno;
    private String nSafeEnd;
    private String nWorkStopRequest;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
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
        return "StatMySiteInfoSiteWorkAllCompResponse{" +
                "userid='" + userid + '\'' +
                ", name='" + name + '\'' +
                ", hpno='" + hpno + '\'' +
                ", nSafeEnd='" + nSafeEnd + '\'' +
                ", nWorkStopRequest='" + nWorkStopRequest + '\'' +
                '}';
    }
}