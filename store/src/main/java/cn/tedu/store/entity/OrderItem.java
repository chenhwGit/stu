package cn.tedu.store.entity;

/**
 * @author 作者：chen
 * @email 邮箱：727424623@qq.com
 * @version v.1.0 创建时间：上午11:00:50
 * @description 描述：订单商品实体类
 */

//CREATE TABLE t_order_item (
//id INT PRIMARY KEY AUTO_INCREMENT COMMENT '订单商品表id',
//oid BIGINT(16) NOT NULL COMMENT '归属订单id',
//pid INT COMMENT '商品id',
//title VARCHAR(100) COMMENT '商品名/标题',
//image VARCHAR(500) COMMENT '图片路径',
//price BIGINT(20) COMMENT '商品单价',
//num INT COMMENT '购买数量',
//created_user VARCHAR(50) COMMENT '创建人',
//created_time DATETIME COMMENT '创建时间',
//modified_user VARCHAR(50) COMMENT '最后修改人',
//modified_time DATETIME COMMENT '最后修改时间'
//)CHARSET = utf8mb4;
public class OrderItem extends BaseEntity {

	private static final long serialVersionUID = -7295428184219692954L;
	private Integer id; // 订单商品表id
	private Integer oid; // 归属订单id
	private Integer pid; // 商品id
	private String title; // 商品名/标题
	private String image; // 图片路径
	private Integer price; // 商品单价
	private Integer num; // 购买数量

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOid() {
		return oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		OrderItem other = (OrderItem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", oid=" + oid + ", pid=" + pid + ", title=" + title + ", image=" + image
				+ ", price=" + price + ", num=" + num + ", toString()=" + super.toString() + "]";
	}

}
