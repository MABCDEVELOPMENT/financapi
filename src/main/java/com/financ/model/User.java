package com.financ.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "user")
public class User extends AbstractBaseEntity {

	@Column(name = "user_name", length = 40, nullable = false, unique = true)
	private String userName;

	@Column(name = "full_name", length = 60, nullable = false)
	private String fullName;

	@Column(name = "email", length = 255, nullable = false, unique = true)
	private String email;

	@Column(name = "cell_phone", length = 11, nullable = false, unique = true)
	private String cellPhone;

	@Column(name = "date_brith", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dateBrith;

	@Column(name = "password", length = 100, nullable = false, unique = true)
	private String password;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	public Date getDateBrith() {
		return dateBrith;
	}

	public void setDateBrith(Date dateBrith) {
		this.dateBrith = dateBrith;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
