package cn.tedu.store.service.ex;

/**
 * @author 作者：chen
 * @email 邮箱：727424623@qq.com
 * @version v.1.0 创建时间：下午5:28:26
 * @description 描述：收货地址数量超出限制的异常
 */
public class AddressSizeLimitException extends ServiceException {

	private static final long serialVersionUID = -1644884131593427996L;

	public AddressSizeLimitException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AddressSizeLimitException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public AddressSizeLimitException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public AddressSizeLimitException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public AddressSizeLimitException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
