package com.cbox.library.domain.form;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserUpdateForm implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull
    private int userId;
    
    @Size(max = 255)
    private String discription;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }
}
