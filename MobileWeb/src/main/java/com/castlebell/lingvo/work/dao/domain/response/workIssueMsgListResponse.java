package com.castlebell.lingvo.work.dao.domain.response;

import java.io.Serializable;

public class workIssueMsgListResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private String issueGubun;
    private String issueTitle;
    private String issueDetail;
    private String choice1;
    private String choice2;

    public String getIssueGubun() {
        return issueGubun;
    }

    public void setIssueGubun(String issueGubun) {
        this.issueGubun = issueGubun;
    }

    public String getIssueTitle() {
        return issueTitle;
    }

    public void setIssueTitle(String issueTitle) {
        this.issueTitle = issueTitle;
    }

    public String getIssueDetail() {
        return issueDetail;
    }

    public void setIssueDetail(String issueDetail) {
        this.issueDetail = issueDetail;
    }

    public String getChoice1() {
        return choice1;
    }

    public void setChoice1(String choice1) {
        this.choice1 = choice1;
    }

    public String getChoice2() {
        return choice2;
    }

    public void setChoice2(String choice2) {
        this.choice2 = choice2;
    }

    @Override
    public String toString() {
        return "workIssueMsgList{" +
                "issueGubun='" + issueGubun + '\'' +
                ", issueTitle='" + issueTitle + '\'' +
                ", issueDetail='" + issueDetail + '\'' +
                ", choice1='" + choice1 + '\'' +
                ", choice2='" + choice2 + '\'' +
                '}';
    }
}