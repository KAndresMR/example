package ec.edu.ups.ejemplo.model;

import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Table(name = "Users")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)


	@Column(name = "u_id", columnDefinition = "NUMBER(4)")
	private int id;


	@Column(name = "u_username", length = 30)
	private String username;

	@Column(name = "u_password", length = 30)
	private String password;


	@Column(name = "u_name", length = 30)
	private String name;


	@Column(name = "u_lastname", length = 30)
	private String lastname;


	@Column(name = "u_email", length = 30)
	private String email;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	
	

	
}
