package cn.tedu.db.sys.service.ex;

/**
 * 使用菜单id查询不到对应的记录时抛出的异常
 */
public class ParentNodeNotFoundException extends ServiceException {

	private static final long serialVersionUID = 1L;

	public ParentNodeNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ParentNodeNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public ParentNodeNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ParentNodeNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ParentNodeNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
}
