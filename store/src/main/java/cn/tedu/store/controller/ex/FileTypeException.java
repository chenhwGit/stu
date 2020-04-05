package cn.tedu.store.controller.ex;

/**
 * @author 作者：chen
 * @email 邮箱：727424623@qq.com
 * @version v.1.0 创建时间：下午5:28:26
 * @description 描述：上传文件类型异常
 */
public class FileTypeException extends FileUploadException {

	private static final long serialVersionUID = -2954625341334072887L;

	public FileTypeException() {
		super();
	}

	public FileTypeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public FileTypeException(String message, Throwable cause) {
		super(message, cause);
	}

	public FileTypeException(String message) {
		super(message);
	}

	public FileTypeException(Throwable cause) {
		super(cause);
	}

}
