package com.desafioapi.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name = "movie")
@Entity
public class Movie {
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
	
	@Column(length = 255, nullable = false)
	private String title;
	
	@Column
	private String winner;

	@Column(nullable = false) 
	private int year;	
	
	
	@OneToMany
	@JoinTable(name = "STUDIO", joinColumns = @JoinColumn(name = "MOVIE_ID"), inverseJoinColumns = @JoinColumn(name = "ID"))
	public List<Studio> studios ;
	
	@OneToMany
	@JoinTable(name = "PRODUCER", joinColumns = @JoinColumn(name = "MOVIE_ID"), inverseJoinColumns = @JoinColumn(name = "ID"))
	public List<Producer> producers;

    //Getter
	public Long getId() {
		return this.Id;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public String getWinner() {
		return this.winner;
	}
	public int getYear() {
		return this.year;
	}
	
	//Setter
	public void setTitle(String title) {
		this.title = title;
	}
	public void setWinner(String winner) {
		this.winner = winner;
		
	}
	public void setYear(int year) {
		this.year = year;
		
	}
	
	public String toString() {
		return "movie[id=" + this.Id + ",title= " + this.title + ",year=" + this.year + "]";
	}
}
