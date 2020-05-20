package cn.tedu.db.sys.service.ex;

/**
 *  更新菜单时，菜单id和parentId一致时抛出的异常
 */
public class IllegalOperationException extends ServiceException {

	private static final long serialVersionUID = 1L;

	public IllegalOperationException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IllegalOperationException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public IllegalOperationException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public IllegalOperationException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public IllegalOperationException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
