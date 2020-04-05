package cn.tedu.store.service.ex;

/**
 * @author 作者：chen
 * @email 邮箱：727424623@qq.com
 * @version v.1.0 创建时间：下午5:28:26
 * @description 描述：仓库商品超出界限的异常
 */
public class ProductOutOfStockException extends ServiceException {

	private static final long serialVersionUID = -3688349481224653582L;

	public ProductOutOfStockException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductOutOfStockException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public ProductOutOfStockException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ProductOutOfStockException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ProductOutOfStockException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
