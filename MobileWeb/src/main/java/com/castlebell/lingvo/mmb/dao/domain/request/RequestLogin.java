package com.castlebell.lingvo.mmb.dao.domain.request;

import java.io.Serializable;

public class RequestLogin implements Serializable {

    private static final long serialVersionUID = 1L;

    private String userid;
    private String userpw;
    private String ip;
    private String clienttype;
    private Integer retVal;
    private String errMsg;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUserpw() {
        return userpw;
    }

    public void setUserpw(String userpw) {
        this.userpw = userpw;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getClienttype() {
        return clienttype;
    }

    public void setClienttype(String clienttype) {
        this.clienttype = clienttype;
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
        return "RequestLogin [userid=" + userid + ", userpw=" + userpw + ", ip=" + ip + ", clienttype=" + clienttype + ", retVal=" + retVal + ", errMsg=" + errMsg + "]";
    }
}