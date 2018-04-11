package com.financ.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ColumnDefault;

@MappedSuperclass
public abstract class AbstractBaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", nullable = false)
	public Long id;

	@Column(name = "active", nullable = false)
	@ColumnDefault(value = "true")
	private boolean active;

	/*
	 * @OneToOne
	 * 
	 * @JoinColumn(name = "insert_user", referencedColumnName = "id", nullable =
	 * true)
	 */
	private Long insertUser;

	@Column(name = "insert_date")
	@Temporal(TemporalType.DATE)
	private Date insertDate;

	/*
	 * @OneToOne
	 * 
	 * @JoinColumn(name = "updates_user", referencedColumnName = "id", nullable =
	 * true)
	 */
	private Long updateUser;

	@Column(name = "update_date")
	@Temporal(TemporalType.DATE)
	private Date updateDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Long getInsertUser() {
		return insertUser;
	}

	public void setInsertUser(Long insertUser) {
		this.insertUser = insertUser;
	}

	public Date getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}

	public Long getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(Long updateUser) {
		this.updateUser = updateUser;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

}
