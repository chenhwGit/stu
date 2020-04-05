package cn.tedu.store.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import cn.tedu.store.controller.ex.FileEmptyException;
import cn.tedu.store.controller.ex.FileSizeException;
import cn.tedu.store.controller.ex.FileStateException;
import cn.tedu.store.controller.ex.FileTypeException;
import cn.tedu.store.controller.ex.FileUoloadIOException;
import cn.tedu.store.entity.User;
import cn.tedu.store.service.UserService;
import cn.tedu.store.util.JsonResult;

/**
 * @author 作者：chen
 * @email 邮箱：727424623@qq.com
 * @version v.1.0 创建时间：下午2:11:40
 * @description 描述：
 */
@RequestMapping("users")
@RestController
public class UserController extends BaseController {
	@Autowired
	private UserService userService;

	// http://localhost:8089/users/reg?username=controller&password=1234
	@RequestMapping("reg")
	public JsonResult<Void> reg(User user) {
		// 调用业务对象实现注册
		userService.reg(user);
		// 返回成功
		return new JsonResult<>(OK);
	}

	// http://localhost:8089/users/login?username=lucy&password=abc123
	@RequestMapping("login")
	public JsonResult<User> login(String username, String password, HttpSession session) {
		// 调用userService.login()方法执行登录，并获取返回结果(成功登录的用户)
		User data = userService.login(username, password);
		// 将返回结果中 的uid和username存入到Session
		session.setAttribute("uid", data.getUid());
		session.setAttribute("username", data.getUsername());
		// 讲解稿响应给客户端
		return new JsonResult<>(OK, data);
	}

	// http://localhost:8089/users/password/change?oldPassword=123456&newPassword=abc123
	@RequestMapping("password/change")
	public JsonResult<Void> updateByUid(String oldPassword, String newPassword, HttpSession session) {
		// 日志
		System.out.println("UserController.updateByUid()");
		System.err.println("\toldpassword=" + oldPassword);
		System.err.println("\tnewpassword=" + newPassword);
		// 从session中获取uid和username
		Integer uid = Integer.valueOf(session.getAttribute("uid").toString());
		String username = session.getAttribute("username").toString();
		// 调用业务对象实现修改密码
		userService.changePassword(uid, username, oldPassword, newPassword);
		// 返回成功
		return new JsonResult<>(OK);
	}

	// http://localhost:8089/users/info/show
	@GetMapping("info/show")
	public JsonResult<User> showInfo(HttpSession session) {
		// 从Session中获取uid
		Integer uid = Integer.valueOf(session.getAttribute("uid").toString());
		String username = session.getAttribute("username").toString();
		// 调用userService.getInfo()获取数据
		User data = userService.getInfo(uid);
		// 响应成功及数据
		return new JsonResult<>(OK, data);

	}

	// http:localhost:8089/users/info/change?phone=18092515211&email=lily@163.com&gender=0
	@RequestMapping("info/change")
	public JsonResult<Void> changeInfo(User user, HttpSession session) {
		// 从Session中获取uid和username
		Integer uid = Integer.valueOf(session.getAttribute("uid").toString());
		String username = session.getAttribute("username").toString();
		// 调用userService.changeInfo()修改个人资料
		userService.changeInfo(uid, username, user);
		// 响应成功
		return new JsonResult<>(OK);
	}

	/** 上传头像时允许使用的文件的最大大小 */
	@Value("${project.avatar-max-size}")
	private int avatarMaxSize;
	/** 上传头像时，允许使用的头像文件的MIME类型 */
	@Value("${project.avatar-types}")
	private List<String> avatarTypes;

	// http:localhost:8089/users/avatar/change
	@PostMapping("avatar/change")
	public JsonResult<String> changeAvatar(MultipartFile file, HttpSession session) {
		// 日志
		System.out.println("UserController.changeAvatar()");
		// 判断上传的问件是否为空
		boolean isEmpty = file.isEmpty();
		System.err.println("\tisEmpty=" + isEmpty);
		// 如果文件为空
		if (isEmpty) {
			throw new FileEmptyException("上传头像失败，请选择有效图片文件后再上传！");
		}

		// 获取上传的上传的文件的大小，以字节为单位
		long size = file.getSize();
		System.err.println("\tsize=" + size);
		if (size > avatarMaxSize) {
			throw new FileSizeException("上传头像失败！不允许上传超过" + (avatarMaxSize / 1024) + "KB的文件");
		}

		// 获取客户端上传的文件的类型String contentType = file.getContentType();
		// 判断上传 的文件类型
		String contentType = file.getContentType();
		System.err.println("\tcontentType=" + contentType);
		// 判断文件类型是否不规范
		if (!avatarTypes.contains(contentType)) {
			throw new FileTypeException("上传头像失败！只允许上传以下类型的图片文件：\n\n" + avatarTypes);
		}

		// ServletContext().getRealPath()用于获取某个文件夹下的真实路径
		String parentPath = session.getServletContext().getRealPath("upload");
		System.err.println("\tparent path=" + parentPath);
		// 上传的文件保存到哪个文件夹
		File parent = new File(parentPath);
		// 如果文件夹不存在
		if (!parent.exists()) {
			// 创建该文件夹
			parent.mkdir();
		}
		// 上传的文件保存到的文件夹的名称
		String dirName = "upload";
		// 上传的文件保存时使用什么文件名,只要保证后上传的文件不覆盖之前上传的文件即可，则文件名不可重复
		String filename = "" + System.currentTimeMillis() + System.nanoTime();
		// 上传的文件保存时使用什么扩展名
		// file.getOriginalFilename():获取原始文件全名
		String originalFilename = file.getOriginalFilename();
		System.err.println("\toriginalFilename=" + originalFilename);
		// 获取后缀名(.后面的内容)
		// 如果不存在则返回-1,在这种情况下调用substring()，会出现越界异常
		// 如果原文件名只有一个小数点，且是文件名的第一个字符，这样的命名方式其实是表示Linux系统中的
		// 可能需要进行if(beginIndex>0)的判断
		int beginIndex = originalFilename.lastIndexOf(".");
		String suffix = originalFilename.substring(beginIndex);
		// 上传的文件保存时使用什么文件全名
		String child = filename + suffix;
		// 上传的文件保存到哪里去
		File dest = new File(parent, child);
		// 执行保存文件
		try {
			file.transferTo(dest);
		} catch (IllegalStateException e) {
			// 抛出自定义异常FileStateException
			throw new FileStateException("上传头像失败，原文件可能已被删除，无法访问到原文件！");
		} catch (IOException e) {
			// 抛出自定义异常FileUoloadIOException
			throw new FileUoloadIOException("上传头像失败！上传处理文件时出现读写错误!请稍后再次尝试! ");
		}

		// 将上传文件的路径记录在数据库中
		Integer uid = Integer.valueOf(session.getAttribute("uid").toString());
		String username = session.getAttribute("username").toString();
		String avatar = "/" + dirName + "/" + child;
		System.err.println("\tavatar=" + avatar);
		userService.changeAvatar(uid, username, avatar);
		// 响应成功
		return new JsonResult<>(OK, avatar);
	}

}
