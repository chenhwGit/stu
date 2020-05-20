package cn.tedu.db.sys.pojo;

import java.util.Date;

/**
 * @author 作者：chen
 * @email 邮箱：727424623@qq.com
 * @version v.1.0 创建时间：下午2:39:46
 * @description 描述：用户模块实体类
 */

//CREATE TABLE `sys_users` (
//		  `id` int(11) NOT NULL AUTO_INCREMENT,
//		  `username` varchar(50) NOT NULL COMMENT '用户名',
//		  `password` varchar(100) DEFAULT NULL COMMENT '密码',
//		  `salt` varchar(50) DEFAULT NULL COMMENT '盐  密码加密时前缀，使加密后的值不同',
//		  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
//		  `mobile` varchar(100) DEFAULT NULL COMMENT '手机号',
//		  `valid` tinyint(4) DEFAULT NULL COMMENT '状态  0：禁用   1：正常',
//		  `deptId` int(11) DEFAULT NULL,
//		  `createdTime` datetime DEFAULT NULL COMMENT '创建时间',
//		  `modifiedTime` datetime DEFAULT NULL COMMENT '修改时间',
//		  `createdUser` varchar(20) DEFAULT NULL COMMENT '创建用户',
//		  `modifiedUser` varchar(20) DEFAULT NULL COMMENT '修改用户',
//		  PRIMARY KEY (`id`),
//		  UNIQUE KEY `username` (`username`)
//) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COMMENT='系统用户';
public class SysUserDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String username; // 用户名
	private String password; // 密码
	private String salt; // 盐 密码加密时前缀，使加密后的值不同
	private String email;// 邮箱
	private String mobile;// 手机号
	private Integer valid;// 状态 0：禁用 1：正常
	private Integer deptId;//
	private String deptName;

	public SysUserDO() {
		super();
	}

	public SysUserDO(Date createdTime, Date modifiedTime, String createdUser, String modifiedUser, Integer id,
			String username, String password, String salt, String email, String mobile, Integer valid, Integer deptId,
			String deptName) {
		super(createdTime, modifiedTime, createdUser, modifiedUser);
		this.id = id;
		this.username = username;
		this.password = password;
		this.salt = salt;
		this.email = email;
		this.mobile = mobile;
		this.valid = valid;
		this.deptId = deptId;
		this.deptName = deptName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((deptId == null) ? 0 : deptId.hashCode());
		result = prime * result + ((deptName == null) ? 0 : deptName.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((mobile == null) ? 0 : mobile.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((salt == null) ? 0 : salt.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		result = prime * result + ((valid == null) ? 0 : valid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		SysUserDO other = (SysUserDO) obj;
		if (deptId == null) {
			if (other.deptId != null)
				return false;
		} else if (!deptId.equals(other.deptId))
			return false;
		if (deptName == null) {
			if (other.deptName != null)
				return false;
		} else if (!deptName.equals(other.deptName))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (mobile == null) {
			if (other.mobile != null)
				return false;
		} else if (!mobile.equals(other.mobile))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (salt == null) {
			if (other.salt != null)
				return false;
		} else if (!salt.equals(other.salt))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		if (valid == null) {
			if (other.valid != null)
				return false;
		} else if (!valid.equals(other.valid))
			return false;
		return true;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Integer getValid() {
		return valid;
	}

	public void setValid(Integer valid) {
		this.valid = valid;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Override
	public String toString() {
		return "SysUserDO [id=" + id + ", username=" + username + ", password=" + password + ", salt=" + salt
				+ ", email=" + email + ", mobile=" + mobile + ", valid=" + valid + ", deptId=" + deptId + ", deptName="
				+ deptName + ", toString()=" + super.toString() + "]";
	}

}
