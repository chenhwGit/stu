package cn.tedu.store.util;

/**
 * @author 作者：chen
 * @email 邮箱：727424623@qq.com
 * @version v.1.0 创建时间：下午2:18:51
 * @description 描述：封装响应JSON对象的属性的类
 * @param <T> 响应给客户端的数据的类型
 */
public class JsonResult<T> {

	// 响应的表示，例如：使用1表示登录成功，使用2表示用户名不存在导致的登录失败
	private Integer state;
	// 操作失败/操作出错是的描述文字，例如：“登录时报错，用户名不存在”
	private String message;
	// 操作成功时需要响应给客户端的数据
	private T data;

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public JsonResult(Throwable e) {
		super();
		this.message = e.getMessage();
	}

	public JsonResult(Integer state) {
		super();
		this.state = state;
	}

	public JsonResult() {
		super();
	}

	public JsonResult(Integer state, T data) {
		super();
		this.state = state;
		this.data = data;
	}

}
