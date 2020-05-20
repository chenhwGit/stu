package cn.tedu.db.common.pojo;

/**
 * 统一封装服务器返回给浏览器的数据
 * @param <T> 封装的数据的类型
 */
public class JsonResult<T> {
	
	private Integer state;
	private String message;
	private T data;
	
	private static Integer successState=20;
	private static String successMessage="OK";
	
	public static JsonResult<Void> getSuccessJR(){
		return new JsonResult<Void>(successState,successMessage,null);
	}
	
	public static <E> JsonResult<E> getSuccessJR(E data){
		return new JsonResult<E>(successState,successMessage,data);
	}
	
	public JsonResult() {
		super();
	}
	
	public JsonResult(Integer state, String message, T data) {
		super();
		this.state = state;
		this.message = message;
		this.data = data;
	}
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
	@Override
	public String toString() {
		return "JsonResult [state=" + state + ", message=" + message + ", data=" + data + "]";
	}

}
