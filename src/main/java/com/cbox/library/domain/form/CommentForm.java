package com.cbox.library.domain.form;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CommentForm implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@NotNull
	private int userId;
	
	@Size(max = 255, min = 3)
	private String comment;
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
