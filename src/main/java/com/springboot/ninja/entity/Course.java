package com.springboot.ninja.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Course {

	@Id
	@GeneratedValue
	@Column(name="idCourse")
	private int idCourse;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@Column(name="price")
	private String price;
	
	@Column(name="hours")
	private int hours;

	public Course() {

	}

	public Course(int idCourse, String name, String description, String price, int hours) {
		super();
		this.idCourse = idCourse;
		this.name = name;
		this.description = description;
		this.price = price;
		this.hours = hours;
	}

	public int getIdCourse() {
		return idCourse;
	}

	public void setIdCourse(int idCourse) {
		this.idCourse = idCourse;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	@Override
	public String toString() {
		return "Course [idCourse=" + idCourse + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", hours=" + hours + "]";
	}

}
