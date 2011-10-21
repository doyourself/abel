package com.xx.abel.bean;

import java.sql.Timestamp;
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
 * Blogreprint entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "blogreprint")
public class Blogreprint implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Blog blog;
	private Users users;
	private Timestamp createTime;
	private Integer oldUname;

	// Constructors

	/** default constructor */
	public Blogreprint() {
	}

	/** minimal constructor */
	public Blogreprint(Blog blog, Users users) {
		this.blog = blog;
		this.users = users;
	}

	/** full constructor */
	public Blogreprint(Blog blog, Users users, Timestamp createTime,
			Integer oldUname) {
		this.blog = blog;
		this.users = users;
		this.createTime = createTime;
		this.oldUname = oldUname;
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
	@JoinColumn(name = "bolgId", nullable = false)
	public Blog getBlog() {
		return this.blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "uid", nullable = false)
	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	@Column(name = "createTime", length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Column(name = "oldUname")
	public Integer getOldUname() {
		return this.oldUname;
	}

	public void setOldUname(Integer oldUname) {
		this.oldUname = oldUname;
	}

}