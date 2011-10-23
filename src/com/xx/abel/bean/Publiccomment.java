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
 * Publiccomment entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "publiccomment", catalog = "abel2")
public class Publiccomment implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Users users;
	private String description;
	private Date createTime;
	private Integer status;
	private Integer type;
	private Integer resourcesId;

	// Constructors

	/** default constructor */
	public Publiccomment() {
	}

	/** minimal constructor */
	public Publiccomment(Users users, String description, Date createTime,
			Integer resourcesId) {
		this.users = users;
		this.description = description;
		this.createTime = createTime;
		this.resourcesId = resourcesId;
	}

	/** full constructor */
	public Publiccomment(Users users, String description, Date createTime,
			Integer status, Integer type, Integer resourcesId) {
		this.users = users;
		this.description = description;
		this.createTime = createTime;
		this.status = status;
		this.type = type;
		this.resourcesId = resourcesId;
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

	@Column(name = "description", nullable = false, length = 10535)
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

	@Column(name = "status")
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Column(name = "type")
	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@Column(name = "resourcesID", nullable = false)
	public Integer getResourcesId() {
		return this.resourcesId;
	}

	public void setResourcesId(Integer resourcesId) {
		this.resourcesId = resourcesId;
	}

}