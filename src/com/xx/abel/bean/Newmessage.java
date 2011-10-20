package com.xx.abel.bean;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Newmessage entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "newmessage", catalog = "abel")
public class Newmessage implements java.io.Serializable {

	// Fields

	private Integer id;
	private Newstatus newstatus;
	private Integer newStatus;
	private String message;
	private Date createTime;
	private Integer status;

	// Constructors

	/** default constructor */
	public Newmessage() {
	}

	/** full constructor */
	public Newmessage(Newstatus newstatus, Integer newStatus, String message,
			Date createTime, Integer status) {
		this.newstatus = newstatus;
		this.newStatus = newStatus;
		this.message = message;
		this.createTime = createTime;
		this.status = status;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "new_id", nullable = false)
	public Newstatus getNewstatus() {
		return this.newstatus;
	}

	public void setNewstatus(Newstatus newstatus) {
		this.newstatus = newstatus;
	}

	@Column(name = "newStatus", nullable = false)
	public Integer getNewStatus() {
		return this.newStatus;
	}

	public void setNewStatus(Integer newStatus) {
		this.newStatus = newStatus;
	}

	@Column(name = "message", nullable = false, length = 500)
	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "createTime", nullable = false, length = 10)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "status", nullable = false)
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}