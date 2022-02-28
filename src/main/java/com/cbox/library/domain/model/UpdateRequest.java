package com.cbox.library.domain.model;

import java.sql.Timestamp;

public class UpdateRequest {
    
    private Integer updateRequestId;
    
    private Integer memberId;
    
    private String name;
    
    private String furigana;
    
    private Integer boardId;
    
    private String discription;
    
    private String userAgent;
    
    private String ipAddress;
    
    private Timestamp createdAt;
    
    private Integer deleteFlag;
    
    private String beforeName;
    
    public Integer getUpdateRequestId() {
        return updateRequestId;
    }
    
    public void setUpdateRequestId(Integer updateRequestId) {
        this.updateRequestId = updateRequestId;
    }
    
    public Integer getMemberId() {
        return memberId;
    }
    
    public void setMemberId(Integer memberId) {
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
    
    public Integer getBoardId() {
        return boardId;
    }
    
    public void setBoardId(Integer boardId) {
        this.boardId = boardId;
    }
    
    public String getDiscription() {
        return discription;
    }
    
    public void setDiscription(String discription) {
        this.discription = discription;
    }
    
    public String getUserAgent() {
        return userAgent;
    }
    
    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }
    
    public String getIpAddress() {
        return ipAddress;
    }
    
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
    
    public Timestamp getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
    
    public Integer getDeleteFlag() {
        return deleteFlag;
    }
    
    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getBeforeName() {
        return beforeName;
    }

    public void setBeforeName(String beforeName) {
        this.beforeName = beforeName;
    }
    
}
