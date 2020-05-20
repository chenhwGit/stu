package cn.tedu.db.sys.service.ex;

/**
 * 传入方法的ids数组为null或者长度为0时抛出的异常
 * 传入方法的id为null或者值小于1时抛出的异常
 */
public class EmptyIdException extends ServiceException {

	private static final long serialVersionUID = 1L;

	public EmptyIdException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmptyIdException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public EmptyIdException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public EmptyIdException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public EmptyIdException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
