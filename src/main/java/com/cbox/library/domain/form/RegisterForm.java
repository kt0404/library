package com.cbox.library.domain.form;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class RegisterForm implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull
	private String name;

	@NotNull
	private String furigana;

	@NotNull
	private Integer boardId;

	private String discription;

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

}
