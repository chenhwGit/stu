package cn.tedu.db.common.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * 封装分页显示数据的实体类
 * @param <T> 页面数据的类型
 */
public class PageObjectVO<T> implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer rowCount; // 总数据条数
	private Integer pageCount; // 总页数
	private Integer pageCurrent; // 当前页码
	private Integer pageSize; // 每页的数据条数
	private List<T> pageRecord; // 当前页的数据
	
	public PageObjectVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PageObjectVO(Integer rowCount, Integer pageCount, Integer pageCurrent, Integer pageSize,
			List<T> pageRecord) {
		super();
		this.rowCount = rowCount;
		this.pageCount = pageCount;
		this.pageCurrent = pageCurrent;
		this.pageSize = pageSize;
		this.pageRecord = pageRecord;
	}
	public Integer getRowCount() {
		return rowCount;
	}
	public void setRowCount(Integer rowCount) {
		this.rowCount = rowCount;
	}
	public Integer getPageCount() {
		return pageCount;
	}
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	public Integer getPageCurrent() {
		return pageCurrent;
	}
	public void setPageCurrent(Integer pageCurrent) {
		this.pageCurrent = pageCurrent;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public List<T> getPageRecord() {
		return pageRecord;
	}
	public void setPageRecord(List<T> pageRecord) {
		this.pageRecord = pageRecord;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pageCount == null) ? 0 : pageCount.hashCode());
		result = prime * result + ((pageCurrent == null) ? 0 : pageCurrent.hashCode());
		result = prime * result + ((pageRecord == null) ? 0 : pageRecord.hashCode());
		result = prime * result + ((pageSize == null) ? 0 : pageSize.hashCode());
		result = prime * result + ((rowCount == null) ? 0 : rowCount.hashCode());
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
		PageObjectVO other = (PageObjectVO) obj;
		if (pageCount == null) {
			if (other.pageCount != null)
				return false;
		} else if (!pageCount.equals(other.pageCount))
			return false;
		if (pageCurrent == null) {
			if (other.pageCurrent != null)
				return false;
		} else if (!pageCurrent.equals(other.pageCurrent))
			return false;
		if (pageRecord == null) {
			if (other.pageRecord != null)
				return false;
		} else if (!pageRecord.equals(other.pageRecord))
			return false;
		if (pageSize == null) {
			if (other.pageSize != null)
				return false;
		} else if (!pageSize.equals(other.pageSize))
			return false;
		if (rowCount == null) {
			if (other.rowCount != null)
				return false;
		} else if (!rowCount.equals(other.rowCount))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "PageObjectVO [rowCount=" + rowCount + ", pageCount=" + pageCount + ", pageCurrent=" + pageCurrent
				+ ", pageSize=" + pageSize + ", pageRecord=" + pageRecord + "]";
	}
}