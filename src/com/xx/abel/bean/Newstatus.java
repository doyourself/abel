package com.xx.abel.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Newstatus entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "newstatus", catalog = "abel")
public class Newstatus implements java.io.Serializable {

	// Fields

	private Integer id;
	private Users users;
	private Integer isRead;
	private Integer nmId;
	private Integer status;
	private Date createTime;
	private Set<Newmessage> newmessages = new HashSet<Newmessage>(0);

	// Constructors

	/** default constructor */
	public Newstatus() {
	}

	/** minimal constructor */
	public Newstatus(Users users, Integer isRead, Integer nmId, Date createTime) {
		this.users = users;
		this.isRead = isRead;
		this.nmId = nmId;
		this.createTime = createTime;
	}

	/** full constructor */
	public Newstatus(Users users, Integer isRead, Integer nmId, Integer status,
			Date createTime, Set<Newmessage> newmessages) {
		this.users = users;
		this.isRead = isRead;
		this.nmId = nmId;
		this.status = status;
		this.createTime = createTime;
		this.newmessages = newmessages;
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

	@Column(name = "isRead", nullable = false)
	public Integer getIsRead() {
		return this.isRead;
	}

	public void setIsRead(Integer isRead) {
		this.isRead = isRead;
	}

	@Column(name = "nmID", nullable = false)
	public Integer getNmId() {
		return this.nmId;
	}

	public void setNmId(Integer nmId) {
		this.nmId = nmId;
	}

	@Column(name = "status")
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "createTime", nullable = false, length = 10)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "newstatus")
	public Set<Newmessage> getNewmessages() {
		return this.newmessages;
	}

	public void setNewmessages(Set<Newmessage> newmessages) {
		this.newmessages = newmessages;
	}

}