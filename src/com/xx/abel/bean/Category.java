package com.xx.abel.bean;

import java.sql.Timestamp;
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

/**
 * Blogcategory entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "category")
public class Category implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Users users;
	private String name;
	private Date createTime;
	private Integer type;

	/**
	 * 1、博客 2、日志 3、Bug
	 * @return
	 */
	@Column(name = "type", nullable = false)
	public Integer getType() {
		return type;
	}
	/**
	 * 1、博客 2、日志 3、Bug
	 * @return
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	/** default constructor */
	public Category() {
	}

	/** full constructor */
	public Category(Users users, String name, Timestamp createTime) {
		this.users = users;
		this.name = name;
		this.createTime = createTime;
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

	@Column(name = "name", length = 200)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "createTime", length = 19)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}