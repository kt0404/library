package com.cbox.library.domain.form;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class MemberUpdateRequestForm implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull
    private int memberId;
    
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

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
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
