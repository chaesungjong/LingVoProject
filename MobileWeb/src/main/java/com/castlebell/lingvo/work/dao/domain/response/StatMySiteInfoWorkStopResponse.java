package com.castlebell.lingvo.work.dao.domain.response;


import java.io.Serializable;

public class StatMySiteInfoWorkStopResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private String reqReason;

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
        return "StatMySiteInfoWorkStopResponse{" +
                "name='" + name + '\'' +
                ", reqReason='" + reqReason + '\'' +
                '}';
    }
}