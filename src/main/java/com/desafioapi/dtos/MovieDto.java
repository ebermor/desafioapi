package com.desafioapi.dtos;

public class MovieDto {
	private Long id;
	private String title;
	private String winner;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String isWinner() {
		return winner;
	}
	public void setWinner(String winner) {
		this.winner = winner;
	}
	
	@Override
	public String toString() {
		return "MovieDto [id=" + id + ", title=" + title + ", winner=" + winner + "]";
		
	}

}
