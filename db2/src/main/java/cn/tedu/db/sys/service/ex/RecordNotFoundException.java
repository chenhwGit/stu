package cn.tedu.db.sys.service.ex;

/**
 *    查询到的总数据条数为0时抛出的异常
 * 
 */
public class RecordNotFoundException extends ServiceException {

	private static final long serialVersionUID = 1L;

	public RecordNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RecordNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public RecordNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public RecordNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public RecordNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}
