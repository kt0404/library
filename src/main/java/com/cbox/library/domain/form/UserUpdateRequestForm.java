package com.cbox.library.domain.form;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserUpdateRequestForm implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull
    private int userId;
    
    @NotNull
    @Size(max = 50)
    private String name;
    
    @NotNull
    @Size(max = 50)
    private String furigana;
    
    @NotNull
    private int boardId;
    
    @Size(max = 255)
    private String discription;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFurigana() {
        return furigana;
    }

    public void setFurigana(String furigana) {
        this.furigana = furigana;
    }

    public int getBoardId() {
        return boardId;
    }

    public void setBoardId(int boardId) {
        this.boardId = boardId;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }
}
