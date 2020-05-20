package cn.tedu.db.sys.service.ex;

/**
 * 针对菜单项的parentId与当前id一致的情况
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
