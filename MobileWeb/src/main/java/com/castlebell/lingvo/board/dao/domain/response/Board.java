package com.castlebell.lingvo.board.dao.domain.response;

import java.io.Serializable;

public class Board implements Serializable {

    private String userid;
    private String category;
    private String title;
    private String content;
    private String userId;
    private String url;
    private String state;
    private String mainViewYN;
    private String importantYN;
    private int hit;
    private String regdate;
    private String seq;
    private String imgPaths;

    public String getUserid() {
        return this.userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getMainViewYN() {
        return this.mainViewYN;
    }

    public String getImgPaths() {
        return this.imgPaths;
    }

    public void setImgPaths(String imgPaths) {
        this.imgPaths = imgPaths;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public String getuserid() {
        return userid;
    }

    public void setuserid(String userid) {
        this.userid = userid;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String isMainViewYN() {
        return mainViewYN;
    }

    public void setMainViewYN(String mainViewYN) {
        this.mainViewYN = mainViewYN;
    }

    public String getImportantYN() {
        return importantYN;
    }

    public void setImportantYN(String importantYN) {
        this.importantYN = importantYN;
    }

    public int getHit() {
        return hit;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }

    public String getRegdate() {
        return regdate;
    }

    public void setRegdate(String regdate) {
        this.regdate = regdate;
    }

    

    @Override
    public String toString(){
        return "Board [userid=" + userid + ", category=" + category + ", title=" + title + ", content=" + content + ", userId=" + userId + ", url=" + url + ", state=" + state + ", mainViewYN=" + mainViewYN + ", importantYN=" + importantYN + ", hit=" + hit + ", regdate=" + regdate + ", imgPaths=" + imgPaths + "]";
    }
}