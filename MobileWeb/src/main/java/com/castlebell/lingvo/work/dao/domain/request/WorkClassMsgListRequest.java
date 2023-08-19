package com.castlebell.lingvo.work.dao.domain.request;

import java.io.Serializable;

public class WorkClassMsgListRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private String workGubun;
    private String workType;

    public String getWorkGubun() {
        return workGubun;
    }

    public void setWorkGubun(String workGubun) {
        this.workGubun = workGubun;
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
    }

    @Override
    public String toString() {
        return "WorkClassMsgList [workGubun=" + workGubun + ", workType=" + workType + "]";
    }


}