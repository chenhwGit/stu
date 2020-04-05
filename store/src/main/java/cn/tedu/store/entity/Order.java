package cn.tedu.store.entity;

import java.util.Date;

/**
 * @author 作者：chen
 * @email 邮箱：727424623@qq.com
 * @version v.1.0 创建时间：上午10:49:49
 * @description 描述：订单实体类
 */
//CREATE TABLE t_order (
//		oid BIGINT(16) PRIMARY KEY AUTO_INCREMENT COMMENT '订单id',
//		uid INT NOT NULL COMMENT '归属的用户id',
//		recv_name VARCHAR(50) COMMENT '收货人姓名',
//		recv_province VARCHAR(20) COMMENT '省份名',
//		recv_city VARCHAR(20) COMMENT '城市名',
//		recv_area VARCHAR(20) COMMENT '区/县名',
//		recv_address VARCHAR(100) COMMENT '详细地址',
//		zip CHAR(6) COMMENT '邮政编码',
//		phone VARCHAR(20) COMMENT '电话',
//		tel VARCHAR(30) COMMENT '固定电话',
//		order_time DATETIME COMMENT '下单时间',
//		pay_time DATETIME COMMENT '支付时间',
//		total_price BIGINT(20) COMMENT '支付金额',
//		status INT(1) COMMENT '订单状态 0待支付 1已支付 2已取消 3已超时关闭',
//		created_user VARCHAR(50) COMMENT '创建人',
//		created_time DATETIME COMMENT '创建时间',
//		modified_user VARCHAR(50) COMMENT '最后修改人',
//		modified_time DATETIME COMMENT '最后修改时间'
//	)CHARSET = utf8mb4;

public class Order extends BaseEntity {
	private static final long serialVersionUID = -8202586971001690638L;

	private Integer oid; // 订单id
	private Integer uid; // 归属的用户id
	private String recvName; // 收货人姓名recv_name
	private String recvProvince; // 省份名recv_province
	private String recvCity; // 城市名recv_city
	private String recvArea; // 区/县名recv_area
	private String recvAddress; // 详细地址recv_address
	private String zip; // 邮政编码
	private String phone; // 电话
	private String tel; // 固定电话
	private Date orderTime; // 下单时间order_time
	private Date payTime;// 支付时间pay_time
	private Integer totalPrice; // 支付金额total_price
	private Integer status;// 订单状态 0待支付 1已支付 2已取消 3已超时关闭

	public Integer getOid() {
		return oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getRecvName() {
		return recvName;
	}

	public void setRecvName(String recvName) {
		this.recvName = recvName;
	}

	public String getRecvProvince() {
		return recvProvince;
	}

	public void setRecvProvince(String recvProvince) {
		this.recvProvince = recvProvince;
	}

	public String getRecvCity() {
		return recvCity;
	}

	public void setRecvCity(String recvCity) {
		this.recvCity = recvCity;
	}

	public String getRecvArea() {
		return recvArea;
	}

	public void setRecvArea(String recvArea) {
		this.recvArea = recvArea;
	}

	public String getRecvAddress() {
		return recvAddress;
	}

	public void setRecvAddress(String recvAddress) {
		this.recvAddress = recvAddress;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
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

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public Date getPayTime() {
		return payTime;
	}

	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}

	public Integer getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((oid == null) ? 0 : oid.hashCode());
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
		Order other = (Order) obj;
		if (oid == null) {
			if (other.oid != null)
				return false;
		} else if (!oid.equals(other.oid))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Order [oid=" + oid + ", uid=" + uid + ", recvName=" + recvName + ", recvProvince=" + recvProvince
				+ ", recvCity=" + recvCity + ", recvArea=" + recvArea + ", recvAddress=" + recvAddress + ", zip=" + zip
				+ ", phone=" + phone + ", tel=" + tel + ", orderTime=" + orderTime + ", payTime=" + payTime
				+ ", totalPrice=" + totalPrice + ", status=" + status + ", toString()=" + super.toString() + "]";
	}

}
