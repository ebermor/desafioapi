package com.desafioapi.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Table(name = "producer")
@Entity

public class Producer {
	
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
	
	@Column(length = 255)
	private String Name;
	
	//getter
	public Long getId() {
		return this.Id;
	}
	
	public String getName() {
		return this.Name;
	}
	
	//setter
	public void setName(String name) {
		this.Name = name;
	}
	
	public String toString() {
		return "producer[id=" + this.Id + ",name=" + this.Name + "]";
	}
	
	
	
}
