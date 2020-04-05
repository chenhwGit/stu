package cn.tedu.store.entity;

/**
 * @author 作者：chen
 * @email 邮箱：727424623@qq.com
 * @version v.1.0 创建时间：下午3:39:04
 * @description 描述：购物车数据的实体类
 */
//create table t_cart(
//		cid int auto_increment primary key comment '购物车数据id',
//		uid int comment '归属用户的id',
//		pid int comment '商品的id',
//		num int comment '商品的数量',
//		price bigint(20) comment '加入时的时间',
//		created_user VARCHAR(20) COMMENT '创建人',
//		created_time DATETIME COMMENT '创建时间',
//		modified_user VARCHAR(20) COMMENT '最后修改人',
//		modified_time DATETIME COMMENT '最后修改时间'
//)charset=utf8mb4;
public class Cart extends BaseEntity {

	private static final long serialVersionUID = 3119979107644728638L;

	private int cid;
	private int uid;
	private int pid;
	private int num;
	private int price;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cid;
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
		Cart other = (Cart) obj;
		if (cid != other.cid)
			return false;
		return true;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Cart [cid=" + cid + ", uid=" + uid + ", pid=" + pid + ", num=" + num + ", price=" + price
				+ ", toString()=" + super.toString() + "]";
	}

}
