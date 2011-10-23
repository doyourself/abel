package com.xx.abel.bean;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Rulepoints entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "rulepoints", catalog = "abel2")
public class Rulepoints implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer type;
	private Date createTime;
	private Integer points;

	// Constructors

	/** default constructor */
	public Rulepoints() {
	}

	/** minimal constructor */
	public Rulepoints(Integer type, Date createTime) {
		this.type = type;
		this.createTime = createTime;
	}

	/** full constructor */
	public Rulepoints(Integer type, Date createTime, Integer points) {
		this.type = type;
		this.createTime = createTime;
		this.points = points;
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

	@Column(name = "type", nullable = false)
	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "createTime", nullable = false, length = 10)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "points")
	public Integer getPoints() {
		return this.points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

}