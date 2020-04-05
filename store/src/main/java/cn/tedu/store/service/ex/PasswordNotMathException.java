package cn.tedu.store.service.ex;

/**
 * @author 作者：chen
 * @email 邮箱：727424623@qq.com
 * @version v.1.0 创建时间：下午5:28:26
 * @description 描述：密码不匹配异常
 */
public class PasswordNotMathException extends ServiceException {

	private static final long serialVersionUID = 5156778717593377564L;

	public PasswordNotMathException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PasswordNotMathException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public PasswordNotMathException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public PasswordNotMathException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public PasswordNotMathException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
