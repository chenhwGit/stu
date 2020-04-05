package cn.tedu.store.service.impl;

import java.util.Date;
import java.util.UUID;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.store.entity.User;
import cn.tedu.store.mapper.UserMapper;
import cn.tedu.store.service.UserService;
import cn.tedu.store.service.ex.InsertException;
import cn.tedu.store.service.ex.PasswordNotMathException;
import cn.tedu.store.service.ex.UpdateException;
import cn.tedu.store.service.ex.UserNotFoundException;
import cn.tedu.store.service.ex.UsernameDuplicateException;

/**
 * @author 作者：chen
 * @email 邮箱：727424623@qq.com
 * @version v.1.0 创建时间：下午5:43:02
 * @description 描述：处理用户数据的业务实现层
 */

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserMapper userMapper;

	@Override
	public void reg(User user) {
		// 日志
		System.out.println("UserServiceImpl.reg()");
		// 通过参数user获取尝试注册的用户名
		String username = user.getUsername();
		// 调用userMapper.findByUsername()方法执行查询
		User userResult = userMapper.findByUsername(username);
		// 判断查询结果是否不为null
		if (userResult != null) {
			// 是：查询到了数据，表示用户名已经被占用，则抛出UsernaneDuplicationException
			throw new UsernameDuplicateException("注册失败，用户名已经被占用！");
		}

		// 如果代码能注销到这一行，则表示没有查询到数据,表示用户名未被注册，则允许注册
		// 创建当前时间对象：Date now = new Date();
		Date now = new Date();
		// 向参数user补全数据：salt,password,涉及加密处理，暂不处理
		String salt = UUID.randomUUID().toString();
		user.setSalt(salt);

		String md5Password = getMd5Password(user.getPassword(), salt);
		user.setPassword(md5Password);
		// 向参数user补全数据：is_delete(0)
		user.setIsDelete(0);
		// 向参数user补全数据：4项日志(now,user.getUsername())
		user.setCreatedUser(username);
		user.setCreatedTime(now);
		user.setModifiedUser(username);
		user.setModifiedTime(now);
		// 调用 userMapper.inert()执行插入数据，并获取返回的受影响行数
		Integer rows = userMapper.insert(user);
		// 判断受影响的行数是否不为1
		if (rows != 1) {
			// 是：插入数据失败，则跑出InsertException
			throw new InsertException("注册失败，保存注册数据时出现未知错误，请联系系统管理员！");
		}
	}

	@Override
	public void changePassword(Integer uid, String username, String oldPassword, String newPassword) {
		// 日志
		System.err.println("UserServiceImpl.changePassword()");
		// 调用userMapper.findByUid()查询用户数据
		User result = userMapper.findByUid(uid);
		// 判断查询结果(result)是否为null
		if (result == null) {
			// 是：抛出UserNotFoundExcrption
			throw new UserNotFoundException("你尝试修改密码的用户不存在！");
		}

		// 判断查询结果(result)中的isDelete属性是否为1
		if (result.getIsDelete() == 1) {
			// 是：抛出UserNotFoundExcrption
			throw new UserNotFoundException("你尝试修改密码的用户已删除！");
		}

		// 日志
		System.err.println("\t验证原密码");
		System.err.println("\t数据库中的原密码：" + result.getPassword());
		// 从查询结果(result)中取出盐值(salt)
		String salt = result.getSalt();
		// 基于参数oldPassword和盐值执行加密
		String oldMd5Password = getMd5Password(oldPassword, salt);
		// 判断以上加密结果与查询结果(result)中的密码是否不匹配
		if (!oldMd5Password.equals(result.getPassword())) {
			// 是：抛出PasswordNotFoundException
			throw new PasswordNotMathException("原密码输入错误！请核对后再次尝试！");
		}

		// 日志
		System.err.println("\t验证通过，更新密码:");
		// 基于参数newPassword和盐值执行加密
		String newMd5Password = getMd5Password(newPassword, salt);
		// 调用userMapper.updatePasswordByUid()执行更新密码(最后修改人是参数username)，并获取返回值
		Integer rows = userMapper.updatePasswordByUid(uid, newMd5Password, username, new Date());
		// 判断返回值结果是否不为1
		if (rows != 1) {
			// 是：抛出UpdateException
			throw new UpdateException("出现未知原因，密码修改失败！请联系管理员！");
		}
	}

	@Override
	public void changeInfo(Integer uid, String username, User user) {
		// 日志
		System.out.println("UserServiceImpl.changeInfo()");
		// 调用userMapper.findByUid()查询用户数据
		User result = userMapper.findByUid(uid);
		// 判断查询结果(result)是否为null
		if (result == null) {
			// 是：抛出UserNotFoundExcrption
			throw new UserNotFoundException("修改用户资料失败，尝试访问的用户数据不存在！");
		}

		// 判断查询结果(result)中的isDelete属性是否为1
		if (result.getIsDelete() == 1) {
			// 是：抛出UserNotFoundExcrption
			throw new UserNotFoundException("修改用户资料失败！用户数据已删除！");
		}

		// 向参数user中补充数据：uid > 参数uid
		user.setUid(uid);
		// 向参数user中补充数据：modifiedUser > 参数username
		user.setModifiedUser(username);
		// 向参数user中补充数据：modifiedTime > 参数new Date()
		user.setModifiedTime(new Date());
		// 调用userMapper.updateInfoByUid()执行更新，并获取返回值
		Integer rows = userMapper.updateInfoByUid(user);
		// 判断返回值是否不为1
		if (rows != 1) {
			// 是：抛出UpdateException
			throw new UpdateException("出现未知原因，修改用户资料失败！请联系管理员！");
		}
	}

	@Override
	public void changeAvatar(Integer uid, String username, String avatar) {
		// 日志
		System.out.println("UserServiceImpl.changeAvatar()");
		// 调用userMapper.findByUid()查询用户数据
		User result = userMapper.findByUid(uid);
		// 判断查询结果(result)是否为null
		if (result == null) {
			// 是：抛出UserNotFoundExcrption
			throw new UserNotFoundException("修改用户头像失败！尝试访问的用户数据不存在！");
		}

		// 判断查询结果(result)中的isDelete属性是否为1
		if (result.getIsDelete() == 1) {
			// 是：抛出UserNotFoundExcrption
			throw new UserNotFoundException("修改用户头像失败！用户数据已删除！");
		}

		// 调用userMapper.updateAvatarByUid()执行更新，并获取返回值
		Integer rows = userMapper.updateAvatarByUid(uid, avatar, username, new Date());
		// 判断返回值是否不为1
		if (rows != 1) {
			// 是：抛出UpdateException
			throw new UpdateException("出现未知原因，修改用户头像失败！请联系管理员！");
		}
	}

	@Override
	public User login(String username, String password) {
		// 日志
		System.out.println("UserServiceImpl.login()");
		// 基于参数username调用userMapper.findByUsername()查询用户数据
		User result = userMapper.findByUsername(username);
		// 判断查询结果(result)是否为null
		if (result == null) {
			// 是：抛出UserNotFoundException
			throw new UserNotFoundException("登录失败！您尝试登录的用户名不存在！");
		}

		// 判断查询结果(result)中的isDelete是否为1
		if (result.getIsDelete() == 1) {
			// 是：抛出UserNotFoundException
			throw new UserNotFoundException("登录失败！您尝试登录的用户名已删除！");
		}
		// 从查询结果(result)中获取盐值
		String salt = result.getSalt();
		// 基于参数password和盐值、调用getMd5Password()执行加密
		String md5Password = getMd5Password(password, salt);
		// 判断查询结果(result)中的密码和以上加密结果是否不一致
		if (!md5Password.equals(result.getPassword())) {
			// 是：抛出PasswordNotFoundException
			throw new PasswordNotMathException("登录失败！您输入的密码有误！请核对后再次登录！");
		}

		// 创建新的User对象
		User user = new User();
		// 将查询结果中的uid、username、avtar设置到新的User对象的对应的属性中
		user.setUid(result.getUid());
		user.setUsername(result.getUsername());
		user.setAvatar(result.getAvatar());
		// 返回新创建的User对象
		return user;
	}

	@Override
	public User getInfo(Integer uid) {
		// 日志
		System.out.println("UserServiceImpl.getInfo()");
		// 调用userMapper.findByUid()查询用户数据
		User result = userMapper.findByUid(uid);
		// 判断查询结果(result)是否为null
		if (result == null) {
			// 是：抛出UserNotFoundExcrption
			throw new UserNotFoundException("你尝试获取用户的数据不存在！");
		}

		// 判断查询结果(result)中的isDelete属性是否为1
		if (result.getIsDelete() == 1) {
			// 是：抛出UserNotFoundExcrption
			throw new UserNotFoundException("你尝试获取用户的数据已删除！");
		}

		// 创建新的User对象
		User user = new User();
		// 通过查询结果向新User对象中 封装属性：username，phone，email，gender
		user.setUsername(result.getUsername());
		user.setPhone(result.getPhone());
		user.setEmail(result.getEmail());
		user.setGender(result.getGender());
		// 返回新的user对象
		return user;
	}

	/**
	 * 执行密码加密，获取加密后的结果
	 * 
	 * @param password 原始密码
	 * @param salt     盐值
	 * @return 加密后的结果
	 */
	private String getMd5Password(String password, String salt) {
		// 加密标准，使用salt+password+salt作为被运算诗句，循环3次
		String result = salt + password + salt;
		for (int i = 0; i < 3; i++) {
			result = DigestUtils.md5Hex(result);
		}
		System.err.println("\tpossword=" + password);
		System.err.println("\tsalt=" + salt);
		System.err.println("\tresult=" + result);
		return result;
	}

}
