package com.caiocesar.workshopmongo.dto;

import java.io.Serializable;
import java.time.Instant;

public class CommentDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String name;
	private Instant date;
	
	private AuthorDTO authorDTO;
	
	public CommentDTO() {}

	public CommentDTO(String name, Instant date, AuthorDTO authorDTO) {
		this.name = name;
		this.date = date;
		this.authorDTO = authorDTO;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Instant getDate() {
		return date;
	}

	public void setDate(Instant date) {
		this.date = date;
	}

	public AuthorDTO getAuthorDTO() {
		return authorDTO;
	}

	public void setAuthorDTO(AuthorDTO authorDTO) {
		this.authorDTO = authorDTO;
	}

}
