package com.castlebell.lingvo.board.dao.domain.request;

import java.io.Serializable;

public class NewsFilter implements Serializable {
    private static final long serialVersionUID = 1L;

    private String gubun;
    private String pageNo;
    private String pageSize;
    private String sdate;
    private String edate;
    private String searchGubun;
    private String searchVal;

    public String getGubun() {
        return gubun;
    }

    public void setGubun(String gubun) {
        this.gubun = gubun;
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

    public String getSdate() {
        return sdate;
    }

    public void setSdate(String sdate) {
        this.sdate = sdate;
    }

    public String getEdate() {
        return edate;
    }

    public void setEdate(String edate) {
        this.edate = edate;
    }

    public String getSearchGubun() {
        return searchGubun;
    }

    public void setSearchGubun(String searchGubun) {
        this.searchGubun = searchGubun;
    }

    public String getSearchVal() {
        return searchVal;
    }

    public void setSearchVal(String searchVal) {
        this.searchVal = searchVal;
    }

    @Override
    public String toString() {
        return "NewsFilter{" +
                "gubun='" + gubun + '\'' +
                ", pageNo='" + pageNo + '\'' +
                ", pageSize='" + pageSize + '\'' +
                ", sdate='" + sdate + '\'' +
                ", edate='" + edate + '\'' +
                ", searchGubun='" + searchGubun + '\'' +
                ", searchVal='" + searchVal + '\'' +
                '}';
    }

}