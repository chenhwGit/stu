package cn.tedu.store.service.ex;

/**
 * @author 作者：chen
 * @email 邮箱：727424623@qq.com
 * @version v.1.0 创建时间：下午5:28:26
 * @description 描述：收货地址数据归属不当的异常
 */
public class AccessDeniedException extends ServiceException {

	private static final long serialVersionUID = 3849396365637118465L;

	public AccessDeniedException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AccessDeniedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public AccessDeniedException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public AccessDeniedException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public AccessDeniedException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
