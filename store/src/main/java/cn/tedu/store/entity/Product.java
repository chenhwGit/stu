package cn.tedu.store.entity;

/**
 * @author 作者：chen
 * @email 邮箱：727424623@qq.com
 * @version v.1.0 创建时间：下午5:30:41
 * @description 描述：商品数据的实体类
 */
//t_product | CREATE TABLE `t_product` (
//`id` int(20) NOT NULL COMMENT '商品id',
//`category_id` int(20) DEFAULT NULL COMMENT '分类id',
//`item_type` varchar(100) DEFAULT NULL COMMENT '商品系列',
//`title` varchar(100) DEFAULT NULL COMMENT '商品标题',
//`sell_point` varchar(150) DEFAULT NULL COMMENT '商品卖点',
//`price` bigint(20) DEFAULT NULL COMMENT '商品单价',
//`num` int(10) DEFAULT NULL COMMENT '库存数量',
//`image` varchar(500) DEFAULT NULL COMMENT '图片路径',
//`status` int(1) DEFAULT '1' COMMENT '商品状态  1：上架   2：下架   3：删除',
//`priority` int(10) DEFAULT NULL COMMENT '显示优先级',
//`created_time` datetime DEFAULT NULL COMMENT '创建时间',
//`modified_time` datetime DEFAULT NULL COMMENT '最后修改时间',
//`created_user` varchar(50) DEFAULT NULL COMMENT '创建人',
//`modified_user` varchar(50) DEFAULT NULL COMMENT '最后修改人',
//PRIMARY KEY (`id`)
//ENGINE=InnoDB DEFAULT CHARSET=utf8 |
public class Product extends BaseEntity {
	private static final long serialVersionUID = -1492928521260622362L;

	private Integer id;
	private Integer categoryId;
	private String itemType;
	private String title;
	private String sellPoint;
	private Integer price;
	private Integer num;
	private String image;
	private Integer status;
	private Integer priority;

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
		Product other = (Product) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSellPoint() {
		return sellPoint;
	}

	public void setSellPoint(String sellPoint) {
		this.sellPoint = sellPoint;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", categoryId=" + categoryId + ", itemType=" + itemType + ", title=" + title
				+ ", sellPoint=" + sellPoint + ", price=" + price + ", num=" + num + ", image=" + image + ", status="
				+ status + ", priority=" + priority + ", toString()=" + super.toString() + "]";
	}

}
