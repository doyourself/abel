package com.xx.abel.bean;

import static javax.persistence.GenerationType.IDENTITY;

import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Comment entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "comment")
public class Comment implements java.io.Serializable {

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
	private Integer sortId;
	private Integer level;
	private Integer support;
	private Integer opposition;
	private Integer report;
	private Integer parentId;

	// Constructors
	@Column(name = "parentId")
	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	/** default constructor */
	public Comment() {
	}

	/** minimal constructor */
	public Comment(Users users, Integer support, Integer opposition,
			Integer report) {
		this.users = users;
		this.support = support;
		this.opposition = opposition;
		this.report = report;
	}

	/** full constructor */
	public Comment(Users users, String description, Timestamp createTime,
			Integer status, Integer type, Integer sortId, Integer level,
			Integer support, Integer opposition, Integer report) {
		this.users = users;
		this.description = description;
		this.createTime = createTime;
		this.status = status;
		this.type = type;
		this.sortId = sortId;
		this.level = level;
		this.support = support;
		this.opposition = opposition;
		this.report = report;
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

	@Column(name = "description",columnDefinition="TEXT")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "createTime")
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

	@Column(name = "sortId")
	public Integer getSortId() {
		return this.sortId;
	}

	public void setSortId(Integer sortId) {
		this.sortId = sortId;
	}

	@Column(name = "level")
	public Integer getLevel() {
		return this.level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	@Column(name = "support",columnDefinition="int default 0")
	public Integer getSupport() {
		return this.support;
	}

	public void setSupport(Integer support) {
		this.support = support;
	}

	@Column(name = "opposition",columnDefinition="int default 0")
	public Integer getOpposition() {
		return this.opposition;
	}

	public void setOpposition(Integer opposition) {
		this.opposition = opposition;
	}

	@Column(name = "report",columnDefinition="int default 0")
	public Integer getReport() {
		return this.report;
	}

	public void setReport(Integer report) {
		this.report = report;
	}

}