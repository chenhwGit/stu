package cn.tedu.store.entity;

/**
 * @author 作者：chen
 * @email 邮箱：727424623@qq.com
 * @version v.1.0 创建时间：上午9:44:19
 * @description 描述：收货地址的实体类
 */
//create table t_address(
//		aid int auto_increment primary key comment '收货地址id',
//		uid int not null comment '归属用户的id',
//		name varchar(20) comment '收货人姓名',
//		province_name varchar(15) comment '省份名',
//		province_code char(6) comment '省份代号',
//		city_name varchar(15) comment '城市名',
//		city_code char(6) comment '城市代号',
//		area_name varchar(15) comment '区名',
//		area_code char(6) comment '区代号',
//		zip char(6) comment '邮政编码',
//		address varchar(50) comment '详细地址',
//		phone varchar(20) comment '手机',
//		tel varchar(20) comment '固话',
//		tag varchar(10) comment '地址类型',
//		is_default int comment '是否默认：0-非默认，1-默认',
//		created_user varchar(20) comment '创建人',
//		created_time datetime comment '创建时间',
//		modified_user varchar(20) comment '最后修改人',
//		modified_time datetime comment '最后修改时间'
//		)charset=utf8mb4;

public class Address extends BaseEntity {
	private static final long serialVersionUID = -2762508379394992150L;

	private Integer aid;// 收货地址id
	private Integer uid;// 归属用户的id
	private String name;// 收货人姓名
	private String provinceName;// 省份名
	private String provinceCode;// 省份代号
	private String cityName;// 城市名
	private String cityCode;// 城市代号
	private String areaName;// 区名
	private String areaCode;// 区代号
	private String zip;// 邮政编码
	private String address;// 详细地址
	private String phone;// 手机
	private String tel;// 固话
	private String tag;// 地址类型
	private Integer isDefault;// 是否默认：0-非默认，1-默认

	public Integer getAid() {
		return aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Integer getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(Integer isDefault) {
		this.isDefault = isDefault;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aid == null) ? 0 : aid.hashCode());
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
		Address other = (Address) obj;
		if (aid == null) {
			if (other.aid != null)
				return false;
		} else if (!aid.equals(other.aid))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Address [aid=" + aid + ", uid=" + uid + ", name=" + name + ", provinceName=" + provinceName
				+ ", provinceCode=" + provinceCode + ", cityName=" + cityName + ", cityCode=" + cityCode + ", areaName="
				+ areaName + ", areaCode=" + areaCode + ", zip=" + zip + ", address=" + address + ", phone=" + phone
				+ ", tel=" + tel + ", tag=" + tag + ", isDefault=" + isDefault + ", toString()=" + super.toString()
				+ "]";
	}

}
