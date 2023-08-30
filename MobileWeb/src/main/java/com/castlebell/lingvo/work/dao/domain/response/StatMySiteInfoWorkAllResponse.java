package com.castlebell.lingvo.work.dao.domain.response;

import java.io.Serializable;

public class StatMySiteInfoWorkAllResponse implements Serializable {

    private static final long serialVersionUID = 4L;

    private int nWork;
    private int nSafeEnd;
    private int nWorkStopRequest;

    public int getnWork() {
        return nWork;
    }

    public void setnWork(int nWork) {
        this.nWork = nWork;
    }

    public int getnSafeEnd() {
        return nSafeEnd;
    }

    public void setnSafeEnd(int nSafeEnd) {
        this.nSafeEnd = nSafeEnd;
    }

    public int getnWorkStopRequest() {
        return nWorkStopRequest;
    }

    public void setnWorkStopRequest(int nWorkStopRequest) {
        this.nWorkStopRequest = nWorkStopRequest;
    }

    @Override
    public String toString() {
        return "WorkSummary{" +
                "nWork=" + nWork +
                ", nSafeEnd=" + nSafeEnd +
                ", nWorkStopRequest=" + nWorkStopRequest +
                '}';
    }
}