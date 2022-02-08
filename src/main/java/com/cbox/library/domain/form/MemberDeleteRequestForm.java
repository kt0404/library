package com.cbox.library.domain.form;

import java.io.Serializable;

public class MemberDeleteRequestForm implements Serializable {
    private static final long serialVersionUID = 1L;

    private int memberId;
    
    private String deleteReason;

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getDeleteReason() {
        return deleteReason;
    }

    public void setDeleteReason(String deleteReason) {
        this.deleteReason = deleteReason;
    }
}
