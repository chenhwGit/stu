package cn.tedu.db.sys.service.ex;

/**
 *  针对当前用户使用的用户名已存在的情况
 */
public class UsernameExistsException extends ServiceException {

	private static final long serialVersionUID = 1L;

	public UsernameExistsException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UsernameExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public UsernameExistsException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public UsernameExistsException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public UsernameExistsException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
