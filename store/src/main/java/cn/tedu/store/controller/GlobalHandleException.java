package cn.tedu.store.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import cn.tedu.store.controller.ex.FileEmptyException;
import cn.tedu.store.controller.ex.FileSizeException;
import cn.tedu.store.controller.ex.FileStateException;
import cn.tedu.store.controller.ex.FileTypeException;
import cn.tedu.store.controller.ex.FileUoloadIOException;
import cn.tedu.store.controller.ex.FileUploadException;
import cn.tedu.store.service.ex.AccessDeniedException;
import cn.tedu.store.service.ex.AddressNotFoundException;
import cn.tedu.store.service.ex.AddressSizeLimitException;
import cn.tedu.store.service.ex.CartNotFoundException;
import cn.tedu.store.service.ex.DeleteException;
import cn.tedu.store.service.ex.InsertException;
import cn.tedu.store.service.ex.PasswordNotMathException;
import cn.tedu.store.service.ex.ProductNotFoundException;
import cn.tedu.store.service.ex.ProductOutOfStockException;
import cn.tedu.store.service.ex.ServiceException;
import cn.tedu.store.service.ex.UpdateException;
import cn.tedu.store.service.ex.UserNotFoundException;
import cn.tedu.store.service.ex.UsernameDuplicateException;
import cn.tedu.store.util.JsonResult;

/**
 * @author 作者：chen
 * @email 邮箱：727424623@qq.com
 * @version v.1.0 创建时间：下午2:11:40
 * @description 描述：
 */
@RestControllerAdvice
public class GlobalHandleException {

	@ExceptionHandler({ ServiceException.class, FileUploadException.class })
	public JsonResult<Void> handleException(Throwable e) {
		JsonResult<Void> result = new JsonResult<>(e);

		if (e instanceof UsernameDuplicateException) {
			result.setState(4000);// 用户名冲突的异常
		} else if (e instanceof AddressSizeLimitException) {
			result.setState(4003);// 收货地址数量超出限制的异常
		} else if (e instanceof PasswordNotMathException) {
			result.setState(4004);// 密码不匹配异常
		} else if (e instanceof PasswordNotMathException) {
			result.setState(4005);// 密码不匹配异常
		} else if (e instanceof AddressNotFoundException) {
			result.setState(4006);// 收货地址数据归属不当的异常
		} else if (e instanceof AccessDeniedException) {
			result.setState(4007);// 收货地址数据在异常
		} else if (e instanceof ProductNotFoundException) {
			result.setState(4008);// 商品不存在异常
		} else if (e instanceof CartNotFoundException) {
			result.setState(4009);// 购物车数据不存在异常
		}else if (e instanceof ProductOutOfStockException) {
			result.setState(4010);// 超出库存界限的异常
		} else if (e instanceof InsertException) {
			result.setState(5000);// 插入数据异常
		} else if (e instanceof UpdateException) {
			result.setState(5001);// 更新数据异常
		} else if (e instanceof DeleteException) {
			result.setState(5220);// 删除数据异常
		} else if (e instanceof FileEmptyException) {
			result.setState(6000);// 上传文件为空的异常
		} else if (e instanceof FileSizeException) {
			result.setState(6001);// 上传文件大小异常
		} else if (e instanceof FileTypeException) {
			result.setState(6002);// 上传文件类型异常
		} else if (e instanceof FileStateException) {
			result.setState(6003);// 上传文件的状态的异常
		} else if (e instanceof FileUoloadIOException) {
			result.setState(6004);// 保存上传的文件时读写异常
		}

		return result;
	}

}
