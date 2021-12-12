package com.desafioapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;


@Table(name = "studio")
@Entity
public class Studio {
	
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
    private Long Id;
	
	
	@Column(length = 255 ,nullable = false)
	private String Name;
	
	
	//Getter
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
		return "studio[id=" + this.Id + ",name=" + this.Name + "]";
	}

}
