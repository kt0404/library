package com.cbox.library.domain.form;

import java.io.Serializable;

public class UserDeleteRequestForm implements Serializable {
    private static final long serialVersionUID = 1L;

    private int userId;
    
    private String deleteReason;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getDeleteReason() {
        return deleteReason;
    }

    public void setDeleteReason(String deleteReason) {
        this.deleteReason = deleteReason;
    }
}
