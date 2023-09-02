package com.castlebell.lingvo.work.dao.domain.request;


import java.io.Serializable;

public class IllegalInfoModify implements Serializable {

    private static final long serialVersionUID = 3L;

    private String gubun;
    private String userid;
    private String siteCode;
    private String illegalClass;
    private String illegalGubun;
    private String illegalUserid;
    private String location;
    private String content;
    private String imgPaths;
    private String state;
    private String ip;
    private String ilgSeq;
    private int RETVAL;
    private String errMsg;

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

    public String getsiteCode() {
        return siteCode;
    }

    public void setsiteCode(String siteCode) {
        this.siteCode = siteCode;
    }   

    public String getillegalClass() {
        return illegalClass;
    }   

    public void setillegalClass(String illegalClass) {
        this.illegalClass = illegalClass;
    }   

    public String getillegalGubun() {
        return illegalGubun;
    }   

    public void setillegalGubun(String illegalGubun) {
        this.illegalGubun = illegalGubun;
    }   

    public String getillegalUserid() {
        return illegalUserid;
    }   

    public void setillegalUserid(String illegalUserid) {
        this.illegalUserid = illegalUserid;
    }   

    public String getlocation() {
        return location;
    }   

    public void setlocation(String location) {
        this.location = location;
    }   

    public String getcontent() {
        return content;
    }   

    public void setcontent(String content) {
        this.content = content;
    }   

    public String getimgPaths() {
        return imgPaths;
    }   

    public void setimgPaths(String imgPaths) {
        this.imgPaths = imgPaths;
    }   

    public String getstate() {
        return state;
    }   

    public void setstate(String state) {
        this.state = state;
    }   

    public String getip() {
        return ip;
    }   

    public void setip(String ip) {
        this.ip = ip;
    }   

    public String getilgSeq() {
        return ilgSeq;
    }   

    public void setilgSeq(String ilgSeq) {
        this.ilgSeq = ilgSeq;
    }   

    public String geterrMsg() {
        return errMsg;
    }   

    public void seterrMsg(String errMsg) {
        this.errMsg = errMsg;
    }   

    public int getRETVAL() {
        return RETVAL;
    }

    public void setRETVAL(int rETVAL) {
        RETVAL = rETVAL;
    }

    @Override
    public String toString() {
        return "IllegalInfoModify [gubun=" + gubun + ", userid=" + userid + ", siteCode=" + siteCode + ", illegalClass="
                + illegalClass + ", illegalGubun=" + illegalGubun + ", illegalUserid=" + illegalUserid + ", location="
                + location + ", content=" + content + ", imgPaths=" + imgPaths + ", state=" + state + ", ip=" + ip
                + ", ilgSeq=" + ilgSeq + ", RETVAL=" + RETVAL + ", errMsg=" + errMsg + "]";
    }
    
}