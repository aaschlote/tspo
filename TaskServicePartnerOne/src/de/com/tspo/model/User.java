package de.com.tspo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "NM_USER")
	private String nmUser;
	
	@Column(name = "PASSWORD")
	private String password;

	public String getNmUser() {
		return nmUser;
	}

	public String getPassword() {
		return password;
	}
	

}
