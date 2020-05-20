package cn.tedu.db.sys.service.ex;

/**
 * 查询到一个菜单项有子菜单时抛出的异常
 */
public class HasSubMenuException extends ServiceException {

	private static final long serialVersionUID = 1L;

	public HasSubMenuException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HasSubMenuException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public HasSubMenuException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public HasSubMenuException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public HasSubMenuException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
