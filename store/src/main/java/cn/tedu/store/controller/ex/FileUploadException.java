package cn.tedu.store.controller.ex;

/**
 * @author 作者：chen
 * @email 邮箱：727424623@qq.com
 * @version v.1.0 创建时间：下午5:28:26
 * @description 描述：上传异常的基类
 */
public class FileUploadException extends RuntimeException {

	private static final long serialVersionUID = -5187037827166791187L;

	public FileUploadException() {
		super();
	}

	public FileUploadException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public FileUploadException(String message, Throwable cause) {
		super(message, cause);
	}

	public FileUploadException(String message) {
		super(message);
	}

	public FileUploadException(Throwable cause) {
		super(cause);
	}

}
