package com.xx.abel.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * News entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "news")
public class News implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Reptile bug;
	private Integer bugid;
	private Integer viewCount;
	private Integer priority;

	// Constructors

	/** default constructor */
	public News() {
	}

	/** minimal constructor */
	public News(Reptile bug, Integer bugid, Integer viewCount) {
		this.bug = bug;
		this.bugid = bugid;
		this.viewCount = viewCount;
	}

	/** full constructor */
	public News(Reptile bug, Integer bugid, Integer viewCount, Integer priority) {
		this.bug = bug;
		this.bugid = bugid;
		this.viewCount = viewCount;
		this.priority = priority;
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
	public Reptile getBug() {
		return this.bug;
	}

	public void setBug(Reptile bug) {
		this.bug = bug;
	}

	@Column(name = "bugid", nullable = false)
	public Integer getBugid() {
		return this.bugid;
	}

	public void setBugid(Integer bugid) {
		this.bugid = bugid;
	}

	@Column(name = "viewCount", nullable = false)
	public Integer getViewCount() {
		return this.viewCount;
	}

	public void setViewCount(Integer viewCount) {
		this.viewCount = viewCount;
	}

	@Column(name = "priority")
	public Integer getPriority() {
		return this.priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

}