package cn.tedu.store.vo;

/**
 * @author 作者：chen
 * @email 邮箱：727424623@qq.com
 * @version v.1.0 创建时间：上午10:47:43
 * @description 描述：
 */
public class CartVO {
	private Integer cid;
	private Integer uid;
	private Integer pid;
	private Integer num;
	private Integer price;
	private String title;
	private Integer realPrice;
	private String image;

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getRealPrice() {
		return realPrice;
	}

	public void setRealPrice(Integer realPrice) {
		this.realPrice = realPrice;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cid == null) ? 0 : cid.hashCode());
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
		CartVO other = (CartVO) obj;
		if (cid == null) {
			if (other.cid != null)
				return false;
		} else if (!cid.equals(other.cid))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CartVO [cid=" + cid + ", uid=" + uid + ", pid=" + pid + ", num=" + num + ", price=" + price + ", title="
				+ title + ", realPrice=" + realPrice + ", image=" + image + "]";
	}
	
	
	

}
