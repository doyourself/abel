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
 * Notepad entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "notepad")
public class Notepad implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Users users;
	private String title;
	private String description;
	private Date createTime;
	private Integer comment;
	private Integer reproduced;
	private Integer orderType;

	// Constructors

	/** default constructor */
	public Notepad() {
	}

	/** minimal constructor */
	public Notepad(Users users, String title, String description,
			Date createTime) {
		this.users = users;
		this.title = title;
		this.description = description;
		this.createTime = createTime;
	}

	/** full constructor */
	public Notepad(Users users, String title, String description,
			Date createTime, Integer comment, Integer reproduced,
			Integer orderType) {
		this.users = users;
		this.title = title;
		this.description = description;
		this.createTime = createTime;
		this.comment = comment;
		this.reproduced = reproduced;
		this.orderType = orderType;
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
	@JoinColumn(name = "uid", nullable = false)
	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	@Column(name = "title", nullable = false, length = 200)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "description", nullable = false,columnDefinition="TEXT")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "createTime", nullable = false, length = 10)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "comment")
	public Integer getComment() {
		return this.comment;
	}

	public void setComment(Integer comment) {
		this.comment = comment;
	}

	@Column(name = "reproduced")
	public Integer getReproduced() {
		return this.reproduced;
	}

	public void setReproduced(Integer reproduced) {
		this.reproduced = reproduced;
	}

	@Column(name = "orderType")
	public Integer getOrderType() {
		return this.orderType;
	}

	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}

}