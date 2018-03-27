package com.rahul.cignex;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Owner {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String fName;
	private String lName;
	private String address;
	private String email;
	private String password;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="owner")
	private Collection<Worker> worker = new ArrayList<>();
	
	public Owner(){
	}
	
	public Owner(String fName, String lName, String address, String email, String password) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.address = address;
		this.email = email;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public Collection<Worker> getWorker() {
		return worker;
	}

	public void setWorker(Collection<Worker> worker) {
		this.worker = worker;
	}
	
}
