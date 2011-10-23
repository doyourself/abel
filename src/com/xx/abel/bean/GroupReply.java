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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * GroupReply entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "group_reply", catalog = "abel2")
public class GroupReply implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private GroupTopic groupTopic;
	private Users users;
	private String content;
	private Date createTime;

	// Constructors

	/** default constructor */
	public GroupReply() {
	}

	/** full constructor */
	public GroupReply(GroupTopic groupTopic, Users users, String content,
			Date createTime) {
		this.groupTopic = groupTopic;
		this.users = users;
		this.content = content;
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
	@JoinColumn(name = "gro_id", nullable = false)
	public GroupTopic getGroupTopic() {
		return this.groupTopic;
	}

	public void setGroupTopic(GroupTopic groupTopic) {
		this.groupTopic = groupTopic;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "uid", nullable = false)
	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	@Column(name = "content", nullable = false)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "create_time", nullable = false)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}