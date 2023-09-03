package com.castlebell.lingvo.work.dao.domain.response;
import java.io.Serializable;

public class StatMySiteInfoUserWorkStopResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private String regdate;
    private String siteName;
    private String name;
    private String reqReason;

    public String getRegdate() {
        return regdate;
    }

    public void setRegdate(String regdate) {
        this.regdate = regdate;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReqReason() {
        return reqReason;
    }

    public void setReqReason(String reqReason) {
        this.reqReason = reqReason;
    }

    @Override
    public String toString() {
        return "StatMySiteInfoUserWorkStopRequestResponse{" +
                "regdate='" + regdate + '\'' +
                ", siteName='" + siteName + '\'' +
                ", name='" + name + '\'' +
                ", reqReason='" + reqReason + '\'' +
                '}';
    }
}