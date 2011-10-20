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
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * GroupUser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "group_user", catalog = "abel")
public class GroupUser implements java.io.Serializable {

	// Fields

	private Integer id;
	private Groups groups;
	private Users users;
	private Date createTime;
	private Integer role;
	private Integer groupid;

	// Constructors

	/** default constructor */
	public GroupUser() {
	}

	/** minimal constructor */
	public GroupUser(Groups groups, Users users, Date createTime,
			Integer groupid) {
		this.groups = groups;
		this.users = users;
		this.createTime = createTime;
		this.groupid = groupid;
	}

	/** full constructor */
	public GroupUser(Groups groups, Users users, Date createTime, Integer role,
			Integer groupid) {
		this.groups = groups;
		this.users = users;
		this.createTime = createTime;
		this.role = role;
		this.groupid = groupid;
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

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public Groups getGroups() {
		return this.groups;
	}

	public void setGroups(Groups groups) {
		this.groups = groups;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId", nullable = false)
	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "create_time", nullable = false, length = 10)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "role")
	public Integer getRole() {
		return this.role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	@Column(name = "groupid", nullable = false)
	public Integer getGroupid() {
		return this.groupid;
	}

	public void setGroupid(Integer groupid) {
		this.groupid = groupid;
	}

}