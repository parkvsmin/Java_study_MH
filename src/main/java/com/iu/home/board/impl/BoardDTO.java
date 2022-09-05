package com.iu.home.board.impl;

import java.sql.Date;
import java.util.List;

public class BoardDTO extends CommentDTO {
	
	
	private String title;
	
	
	private Long hit;
	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getHit() {
		return hit;
	}

	public void setHit(Long hit) {
		this.hit = hit;
	}

	
	//dto의 기본생성자//
	
	

	
	

}
