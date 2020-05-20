package cn.tedu.db.sys.service.ex;

/**
 * 分页查询中，页码为null或者小于1时抛出的异常
 */
public class IllegalPageNumberException extends ServiceException {

	private static final long serialVersionUID = 1L;

	public IllegalPageNumberException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IllegalPageNumberException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public IllegalPageNumberException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public IllegalPageNumberException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public IllegalPageNumberException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
}
