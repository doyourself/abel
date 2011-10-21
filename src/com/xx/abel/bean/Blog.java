package com.xx.abel.bean;

import java.sql.Timestamp;
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

/**
 * Blog entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "blog")
public class Blog implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Users users;
	private String title;
	private String content;
	private Integer isAllowedComment;
	private Integer isReprinted;
	private Integer clickCount;
	private Date createTime;
	private Category category;
	private Set<Blogreprint> blogreprints = new HashSet<Blogreprint>(0);

	// Constructors

	/** default constructor */
	public Blog() {
	}

	/** full constructor */
	public Blog(Users users, String title, String content,
			Integer isAllowedComment, Integer isReprinted, Integer clickCount,
			Timestamp createTime, Set<Blogreprint> blogreprints) {
		this.users = users;
		this.title = title;
		this.content = content;
		this.isAllowedComment = isAllowedComment;
		this.isReprinted = isReprinted;
		this.clickCount = clickCount;
		this.createTime = createTime;
		this.blogreprints = blogreprints;
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

	@Column(name = "title", length = 100)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "content", length = 65535)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "isAllowedComment")
	public Integer getIsAllowedComment() {
		return this.isAllowedComment;
	}

	public void setIsAllowedComment(Integer isAllowedComment) {
		this.isAllowedComment = isAllowedComment;
	}

	@Column(name = "isReprinted")
	public Integer getIsReprinted() {
		return this.isReprinted;
	}

	public void setIsReprinted(Integer isReprinted) {
		this.isReprinted = isReprinted;
	}

	@Column(name = "clickCount")
	public Integer getClickCount() {
		return this.clickCount;
	}

	public void setClickCount(Integer clickCount) {
		this.clickCount = clickCount;
	}

	@Column(name = "createTime", length = 19)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "blog")
	public Set<Blogreprint> getBlogreprints() {
		return this.blogreprints;
	}

	public void setBlogreprints(Set<Blogreprint> blogreprints) {
		this.blogreprints = blogreprints;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "categoryId")
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}