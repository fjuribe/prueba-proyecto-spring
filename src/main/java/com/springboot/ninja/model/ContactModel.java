package com.springboot.ninja.model;
//import javax.persistence.Column;


public class ContactModel {

	private int id;
	private String firstname;
	private String lastname;
	private String telephon;
	private String city;

	public ContactModel() {
	}

	public ContactModel(int id, String firstname, String lastname, String telephon, String city) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.telephon = telephon;
		this.city = city;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getTelephon() {
		return telephon;
	}

	public void setTelephon(String telephon) {
		this.telephon = telephon;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "ContactModel [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", telephon="
				+ telephon + ", city=" + city + "]";
	}

}
