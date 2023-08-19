package com.castlebell.lingvo.work.dao.domain.response;

import java.io.Serializable;

public class WorkClassMsgListResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private String step;
    private String stepTotal;
    private String message;


    public void setStep(String step) {
        this.step = step;
    }

    public String getStep() {
        return step;
    }

    public void setStepTotal(String stepTotal) {
        this.stepTotal = stepTotal;
    }   

    public String getStepTotal() {
        return stepTotal;
    }   

    public void setMessage(String message) {
        this.message = message;
    }   

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "WorkClassMsgListResponse [step=" + step + ", stepTotal=" + stepTotal + ", message=" + message + "]";
    }

}