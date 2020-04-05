package cn.tedu.store.controller.ex;

/**
 * @author 作者：chen
 * @email 邮箱：727424623@qq.com
 * @version v.1.0 创建时间：下午5:28:26
 * @description 描述：保存上传的文件时读写异常
 */
public class FileUoloadIOException extends FileUploadException {

	private static final long serialVersionUID = -158161326329629223L;

	public FileUoloadIOException() {
		super();
	}

	public FileUoloadIOException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public FileUoloadIOException(String message, Throwable cause) {
		super(message, cause);
	}

	public FileUoloadIOException(String message) {
		super(message);
	}

	public FileUoloadIOException(Throwable cause) {
		super(cause);
	}

}
