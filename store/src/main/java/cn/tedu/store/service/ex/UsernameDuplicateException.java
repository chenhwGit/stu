package cn.tedu.store.service.ex;

/**
 * @author 作者：chen
 * @email 邮箱：727424623@qq.com
 * @version v.1.0 创建时间：下午5:28:26
 * @description 描述：用户名冲突的异常
 */
public class UsernameDuplicateException extends ServiceException {

	private static final long serialVersionUID = -1224474172375139228L;

	public UsernameDuplicateException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UsernameDuplicateException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public UsernameDuplicateException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public UsernameDuplicateException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public UsernameDuplicateException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
