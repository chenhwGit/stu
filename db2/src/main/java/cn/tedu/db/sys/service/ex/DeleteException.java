package cn.tedu.db.sys.service.ex;

/**
 * 删除操作结果与预期不一致时抛出的异常
 */
public class DeleteException extends ServiceException {

	private static final long serialVersionUID = 1L;

	public DeleteException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DeleteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public DeleteException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public DeleteException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public DeleteException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
