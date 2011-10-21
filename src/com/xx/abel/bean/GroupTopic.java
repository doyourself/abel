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
 * GroupTopic entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "group_topic")
public class GroupTopic implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Groups groups;
	private Users users;
	private String title;
	private String content;
	private Date createTime;
	private Integer isTop;
	private Integer isAllowedReply;
	private Set<GroupReply> groupReplies = new HashSet<GroupReply>(0);

	// Constructors

	/** default constructor */
	public GroupTopic() {
	}

	/** minimal constructor */
	public GroupTopic(Groups groups, Users users, String title, String content,
			Date createTime) {
		this.groups = groups;
		this.users = users;
		this.title = title;
		this.content = content;
		this.createTime = createTime;
	}

	/** full constructor */
	public GroupTopic(Groups groups, Users users, String title, String content,
			Date createTime, Integer isTop, Integer isAllowedReply,
			Set<GroupReply> groupReplies) {
		this.groups = groups;
		this.users = users;
		this.title = title;
		this.content = content;
		this.createTime = createTime;
		this.isTop = isTop;
		this.isAllowedReply = isAllowedReply;
		this.groupReplies = groupReplies;
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
	public Groups getGroups() {
		return this.groups;
	}

	public void setGroups(Groups groups) {
		this.groups = groups;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "uid", nullable = false)
	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	@Column(name = "title", nullable = false, length = 300)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "content", nullable = false, length = 65535)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "create_time", nullable = false, length = 10)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "is_top")
	public Integer getIsTop() {
		return this.isTop;
	}

	public void setIsTop(Integer isTop) {
		this.isTop = isTop;
	}

	@Column(name = "is_allowed_reply")
	public Integer getIsAllowedReply() {
		return this.isAllowedReply;
	}

	public void setIsAllowedReply(Integer isAllowedReply) {
		this.isAllowedReply = isAllowedReply;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "groupTopic")
	public Set<GroupReply> getGroupReplies() {
		return this.groupReplies;
	}

	public void setGroupReplies(Set<GroupReply> groupReplies) {
		this.groupReplies = groupReplies;
	}

}