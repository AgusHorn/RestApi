package com.restservice.entity;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String email;
	
	private String name;
	
	private String lastName;
	
	private Date birthDate;
	
	private String filePhoto;	
	
	public User() {}
	
	public User(int id, String email, String name, String lastName, String birthDate, String filePhoto) throws ParseException {
		this.id = id;
		this.email = email;
		this.lastName = lastName;
		this.name = name;
		this.filePhoto = filePhoto;
		this.birthDate = new SimpleDateFormat("dd/MM/yyyy").parse(birthDate);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFilePhoto() {
		return this.filePhoto;
	}

	public void setFilePhoto(String filePhoto) {
		this.filePhoto = filePhoto;
	}

	public String getBirthDate() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); 
		if (this.birthDate != null) {
			String strDate = dateFormat.format(this.birthDate);  
			return strDate;
		}
		return null;        
	}

	public void setBirthDate(String birthDate) throws ParseException {
		this.birthDate = new SimpleDateFormat("dd/MM/yyyy").parse(birthDate);
	}

}
