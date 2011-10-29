package com.xx.abel.bean;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Dynamic entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "dynamic")
public class Dynamic implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String title;
	private String description;
	private Users users;
	private Integer type;
	private Date createTime;
	private Integer clickCount;
	private String href;
	private Integer viewCount;
	private Integer resoureId;
	// Constructors

	/** default constructor */
	public Dynamic() {
	}

	/** minimal constructor */
	public Dynamic(Integer type, Date createTime,
			Integer clickCount, Integer viewCount) {
		this.type = type;
		this.createTime = createTime;
		this.clickCount = clickCount;
		this.viewCount = viewCount;
	}

	/** full constructor */
	public Dynamic(String title, String description, Integer uid,
			Integer type, Date createTime,
			Integer clickCount, String href, Integer viewCount,
			Integer resoureId) {
		this.title = title;
		this.description = description;
		this.type = type;
		this.createTime = createTime;
		this.clickCount = clickCount;
		this.href = href;
		this.viewCount = viewCount;
		this.resoureId = resoureId;
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

	@Column(name = "title", length = 200)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "description",columnDefinition="TEXT")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * 1、心情 2、日志
	 * @return
	 */
	@Column(name = "type", nullable = false)
	public Integer getType() {
		return this.type;
	}
	/**
	 * 
	 * @param type 1、心情 2、日志
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createTime", nullable = false, length = 19)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "clickCount", nullable = false)
	public Integer getClickCount() {
		return this.clickCount;
	}

	public void setClickCount(Integer clickCount) {
		this.clickCount = clickCount;
	}

	@Column(name = "href", length = 100)
	public String getHref() {
		return this.href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	@Column(name = "viewCount", columnDefinition="int default 0")
	public Integer getViewCount() {
		return this.viewCount;
	}

	public void setViewCount(Integer viewCount) {
		this.viewCount = viewCount;
	}

	@Column(name = "resoureId",columnDefinition="int default 0")
	public Integer getResoureId() {
		return this.resoureId;
	}

	public void setResoureId(Integer resoureId) {
		this.resoureId = resoureId;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "uid")
	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

}