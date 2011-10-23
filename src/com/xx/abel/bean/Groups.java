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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Groups entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "groups", catalog = "abel2")
public class Groups implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String avatar;
	private String description;
	private Integer addPermission;
	private Integer publishPermission;
	private Date createTime;
	private Integer status;
	private Set<GroupTopic> groupTopics = new HashSet<GroupTopic>(0);
	private GroupUser groupUser;

	// Constructors

	/** default constructor */
	public Groups() {
	}

	/** minimal constructor */
	public Groups(String name, String avatar, String description,
			Integer addPermission, Integer publishPermission, Date createTime) {
		this.name = name;
		this.avatar = avatar;
		this.description = description;
		this.addPermission = addPermission;
		this.publishPermission = publishPermission;
		this.createTime = createTime;
	}

	/** full constructor */
	public Groups(String name, String avatar, String description,
			Integer addPermission, Integer publishPermission, Date createTime,
			Integer status, Set<GroupTopic> groupTopics, GroupUser groupUser) {
		this.name = name;
		this.avatar = avatar;
		this.description = description;
		this.addPermission = addPermission;
		this.publishPermission = publishPermission;
		this.createTime = createTime;
		this.status = status;
		this.groupTopics = groupTopics;
		this.groupUser = groupUser;
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

	@Column(name = "name", nullable = false, length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "avatar", nullable = false, length = 100)
	public String getAvatar() {
		return this.avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	@Column(name = "description", nullable = false, length = 3050)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "add_permission", nullable = false)
	public Integer getAddPermission() {
		return this.addPermission;
	}

	public void setAddPermission(Integer addPermission) {
		this.addPermission = addPermission;
	}

	@Column(name = "publish_permission", nullable = false)
	public Integer getPublishPermission() {
		return this.publishPermission;
	}

	public void setPublishPermission(Integer publishPermission) {
		this.publishPermission = publishPermission;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "create_time", nullable = false, length = 10)
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "groups")
	public Set<GroupTopic> getGroupTopics() {
		return this.groupTopics;
	}

	public void setGroupTopics(Set<GroupTopic> groupTopics) {
		this.groupTopics = groupTopics;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "groups")
	public GroupUser getGroupUser() {
		return this.groupUser;
	}

	public void setGroupUser(GroupUser groupUser) {
		this.groupUser = groupUser;
	}

}