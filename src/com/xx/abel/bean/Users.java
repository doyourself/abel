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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Users entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "users", catalog = "abel2")
public class Users implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String nickName;
	private String password;
	private Date createTime;
	private Date lastLogin;
	private Integer homeStyle;
	private String homeName;
	private String domain;
	private String mobile;
	private String mobileCheck;
	private String phone;
	private String email;
	private String emailCheck;
	private int sex;
	private String card;
	private String avatar;
	private Integer priority;
	private Integer status;
	private Integer type;
	private String address;
	private String work;
	private String qq;
	private Integer points;
	private Set<GroupUser> groupUsers = new HashSet<GroupUser>(0);
	private Set<Friends> friendses = new HashSet<Friends>(0);
	private Set<Publiccomment> publiccomments = new HashSet<Publiccomment>(0);
	private Set<GroupTopic> groupTopics = new HashSet<GroupTopic>(0);
	private Set<Newstatus> newstatuses = new HashSet<Newstatus>(0);
	private Set<Notepad> notepads = new HashSet<Notepad>(0);
	private Set<Priority> priorities = new HashSet<Priority>(0);
	private Set<GroupReply> groupReplies = new HashSet<GroupReply>(0);
	private Set<Tag> tags = new HashSet<Tag>(0);
	private Set<Blog> blogs = new HashSet<Blog>(0);
	private Set<Category> blogcategories = new HashSet<Category>(0);
	private Set<Blogreprint> blogreprints = new HashSet<Blogreprint>(0);
	private Set<Bug> bugs = new HashSet<Bug>(0);
	// Constructors

	/** default constructor */
	public Users() {
	}

	/** minimal constructor */
	public Users(String name, String password, Date createTime, Date lastLogin,String address,String work,
			String email) {
		this.work= work;
		this.name = name;
		this.password = password;
		this.createTime = createTime;
		this.lastLogin = lastLogin;
		this.email = email;
		this.address=address;
	}

	/** full constructor */
	public Users(String name, String nickName, String password,
			Date createTime, Date lastLogin, Integer homeStyle,String address,String work,
			String homeName, String domain, String mobile, String mobileCheck,
			String phone, String email, String emailCheck, String card,
			String avatar, Integer priority, Integer status, Integer type,
			Set<GroupUser> groupUsers, Set<Friends> friendses,Set<Publiccomment> publiccomments,
			Set<GroupTopic> groupTopics, Set<Newstatus> newstatuses,
			Set<Notepad> notepads, 
			Set<GroupReply> groupReplies, Set<Tag> tags) {
		this.name = name;		this.work= work;this.address=address;
		this.nickName = nickName;
		this.password = password;
		this.createTime = createTime;
		this.lastLogin = lastLogin;
		this.homeStyle = homeStyle;
		this.homeName = homeName;
		this.domain = domain;
		this.mobile = mobile;
		this.mobileCheck = mobileCheck;
		this.phone = phone;
		this.email = email;
		this.emailCheck = emailCheck;
		this.card = card;
		this.avatar = avatar;
		this.priority = priority;
		this.status = status;
		this.type = type;
		this.groupUsers = groupUsers;
		this.friendses = friendses;
		this.publiccomments = publiccomments;
		this.groupTopics = groupTopics;
		this.newstatuses = newstatuses;
		this.notepads = notepads;
		this.groupReplies = groupReplies;
		this.tags = tags;
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

	@Column(name = "nick_name", length = 20)
	public String getNickName() {
		return this.nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@Column(name = "password", nullable = false, length = 50)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_time", nullable = false, length = 10)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_login", nullable = false, length = 10)
	public Date getLastLogin() {
		return this.lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	@Column(name = "home_style")
	public Integer getHomeStyle() {
		return this.homeStyle;
	}

	public void setHomeStyle(Integer homeStyle) {
		this.homeStyle = homeStyle;
	}

	@Column(name = "home_name", length = 30)
	public String getHomeName() {
		return this.homeName;
	}

	public void setHomeName(String homeName) {
		this.homeName = homeName;
	}

	@Column(name = "domain", length = 20)
	public String getDomain() {
		return this.domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	@Column(name = "mobile", length = 11)
	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column(name = "mobile_check", length = 11)
	public String getMobileCheck() {
		return this.mobileCheck;
	}

	public void setMobileCheck(String mobileCheck) {
		this.mobileCheck = mobileCheck;
	}

	@Column(name = "phone", length = 20)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "email", nullable = false, length = 50)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "email_check", length = 11)
	public String getEmailCheck() {
		return this.emailCheck;
	}

	public void setEmailCheck(String emailCheck) {
		this.emailCheck = emailCheck;
	}

	@Column(name = "card", length = 18)
	public String getCard() {
		return this.card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	@Column(name = "avatar", length = 100)
	public String getAvatar() {
		return this.avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	@Column(name = "priority")
	public Integer getPriority() {
		return this.priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "users")
	public Set<GroupUser> getGroupUsers() {
		return this.groupUsers;
	}

	public void setGroupUsers(Set<GroupUser> groupUsers) {
		this.groupUsers = groupUsers;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "users")
	public Set<Friends> getFriendses() {
		return this.friendses;
	}

	public void setFriendses(Set<Friends> friendses) {
		this.friendses = friendses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "users")
	public Set<Publiccomment> getPubliccomments() {
		return this.publiccomments;
	}

	public void setPubliccomments(Set<Publiccomment> publiccomments) {
		this.publiccomments = publiccomments;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "users")
	public Set<GroupTopic> getGroupTopics() {
		return this.groupTopics;
	}

	public void setGroupTopics(Set<GroupTopic> groupTopics) {
		this.groupTopics = groupTopics;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "users")
	public Set<Newstatus> getNewstatuses() {
		return this.newstatuses;
	}

	public void setNewstatuses(Set<Newstatus> newstatuses) {
		this.newstatuses = newstatuses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "users")
	public Set<Notepad> getNotepads() {
		return this.notepads;
	}

	public void setNotepads(Set<Notepad> notepads) {
		this.notepads = notepads;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "users")
	public Set<Priority> getPriorities() {
		return this.priorities;
	}

	public void setPriorities(Set<Priority> priorities) {
		this.priorities = priorities;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "users")
	public Set<GroupReply> getGroupReplies() {
		return this.groupReplies;
	}

	public void setGroupReplies(Set<GroupReply> groupReplies) {
		this.groupReplies = groupReplies;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "users")
	public Set<Tag> getTags() {
		return this.tags;
	}

	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}
	@Column(name = "sex")
	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}
	@Column(name = "address",length=100)
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	@Column(name = "work",length=60)
	public String getWork() {
		return work;
	}

	public void setWork(String work) {
		this.work = work;
	}
	@Column(name = "qq")
	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public Integer getPoints() {
		return points;
	}
	@Column(name = "points")
	public void setPoints(Integer points) {
		this.points = points;
	}
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "users")
	public Set<Blog> getBlogs() {
		return this.blogs;
	}

	public void setBlogs(Set<Blog> blogs) {
		this.blogs = blogs;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "users")
	public Set<Category> getBlogcategories() {
		return this.blogcategories;
	}

	public void setBlogcategories(Set<Category> blogcategories) {
		this.blogcategories = blogcategories;
	}
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "users")
	public Set<Blogreprint> getBlogreprints() {
		return this.blogreprints;
	}

	public void setBlogreprints(Set<Blogreprint> blogreprints) {
		this.blogreprints = blogreprints;
	}
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "users")
	public Set<Bug> getBugs() {
		return this.bugs;
	}

	public void setBugs(Set<Bug> bugs) {
		this.bugs = bugs;
	}
}