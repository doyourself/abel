package com.xx.abel.bean;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Bug entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "reptile", catalog = "abel2")
public class Reptile implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer title;
	private String description;
	private Date createDate;
	private Integer type;
	private Integer status;
	private News news;

	// Constructors

	/** default constructor */
	public Reptile() {
	}

	/** minimal constructor */
	public Reptile(Integer title, Date createDate, Integer type, Integer status) {
		this.title = title;
		this.createDate = createDate;
		this.type = type;
		this.status = status;
	}

	/** full constructor */
	public Reptile(Integer title, String description, Date createDate,
			Integer type, Integer status, News news) {
		this.title = title;
		this.description = description;
		this.createDate = createDate;
		this.type = type;
		this.status = status;
		this.news = news;
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

	@Column(name = "title", nullable = false)
	public Integer getTitle() {
		return this.title;
	}

	public void setTitle(Integer title) {
		this.title = title;
	}

	@Column(name = "description", length = 15535)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "createDate", nullable = false, length = 10)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Column(name = "type", nullable = false)
	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@Column(name = "status", nullable = false)
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "bug")
	public News getNews() {
		return this.news;
	}

	public void setNews(News news) {
		this.news = news;
	}

}