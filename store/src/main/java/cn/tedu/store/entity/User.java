package cn.tedu.store.entity;

/**
 * 用户数据的实体类
 * 
 * @author admin
 *
 */
//CREATE TABLE t_user (
//uid INT AUTO_INCREMENT COMMENT '用户id',
//username VARCHAR(20) UNIQUE NOT NULL COMMENT '用户名',
//password CHAR(32) NOT NULL COMMENT '密码',
//salt CHAR(36) COMMENT '盐值',
//gender INT(1) COMMENT '性别：0-女，1-男',
//phone VARCHAR(20) COMMENT '手机号码',
//email VARCHAR(50) COMMENT '电子邮箱',
//avatar VARCHAR(100) COMMENT '头像',
//is_delete INT(1) COMMENT '是否删除：0-否，1-是',
//created_user VARCHAR(20) COMMENT '创建人',
//created_time DATETIME COMMENT '创建时间',
//modified_user VARCHAR(20) COMMENT '最后修改人',
//modified_time DATETIME COMMENT '最后修改时间',
//PRIMARY KEY (uid)
//) DEFAULT CHARSET=utf8mb4;

public class User extends BaseEntity {
	private static final long serialVersionUID = -3822958702938259479L;

	private Integer uid;
	private String username;
	private String password;
	private String salt;
	private Integer gender;
	private String phone;
	private String email;
	private String avatar;
	private Integer isDelete;

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", password=" + password + ", salt=" + salt + ", gender="
				+ gender + ", phone=" + phone + ", email=" + email + ", avatar=" + avatar + ", isDelete=" + isDelete
				+ ", toString()=" + super.toString() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((uid == null) ? 0 : uid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (uid == null) {
			if (other.uid != null)
				return false;
		} else if (!uid.equals(other.uid))
			return false;
		return true;
	}

}
