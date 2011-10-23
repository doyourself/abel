package com.xx.abel.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Bug entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "bug")
public class Bug implements java.io.Serializable {

	// Fields

	private Integer id;
	private Users users;
	private String compendium;
	private String problem;
	private String reason;
	private String answer;
	private String isAllowedComment;
	private String isReprinted;
	private Date createTime;

	// Constructors

	/** default constructor */
	public Bug() {
	}

	/** minimal constructor */
	public Bug(Date createTime) {
		this.createTime = createTime;
	}

	/** full constructor */
	public Bug(Users users, String compendium, String problem, String reason,
			String answer, String isAllowedComment, String isReprinted,
			Date createTime) {
		this.users = users;
		this.compendium = compendium;
		this.problem = problem;
		this.reason = reason;
		this.answer = answer;
		this.isAllowedComment = isAllowedComment;
		this.isReprinted = isReprinted;
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
	@JoinColumn(name = "uid")
	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	@Column(name = "compendium",columnDefinition="TEXT")
	public String getCompendium() {
		return this.compendium;
	}

	public void setCompendium(String compendium) {
		this.compendium = compendium;
	}

	@Column(name = "problem",columnDefinition="TEXT")
	public String getProblem() {
		return this.problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	@Column(name = "reason",columnDefinition="TEXT")
	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	@Column(name = "answer",columnDefinition="TEXT")
	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Column(name = "isAllowedComment")
	public String getIsAllowedComment() {
		return this.isAllowedComment;
	}

	public void setIsAllowedComment(String isAllowedComment) {
		this.isAllowedComment = isAllowedComment;
	}

	@Column(name = "isReprinted")
	public String getIsReprinted() {
		return this.isReprinted;
	}

	public void setIsReprinted(String isReprinted) {
		this.isReprinted = isReprinted;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createTime", nullable = false)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}