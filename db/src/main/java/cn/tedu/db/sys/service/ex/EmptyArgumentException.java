package cn.tedu.db.sys.service.ex;

/**
 * 传入方法的参数值为null，或者关键字段为空时抛出的异常
 * 针对传入方法的sysMenuDO对象为null或者其中关键字段的值为空的情况
 */
public class EmptyArgumentException extends ServiceException {

	private static final long serialVersionUID = 1L;

	public EmptyArgumentException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmptyArgumentException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public EmptyArgumentException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public EmptyArgumentException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public EmptyArgumentException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}
