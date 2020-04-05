package cn.tedu.store.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.service.ex.ServiceException;
import cn.tedu.store.vo.CartVO;

/**
 * @author 作者：chen
 * @email 邮箱：727424623@qq.com
 * @version v.1.0 创建时间：下午12:20:26
 * @description 描述：
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class CartServiceTests {

	@Autowired
	private CartService cartService;

	@Test
	public void addToCart() {
		try {
			Integer uid = 3;
			String username = "商品管理员";
			Integer pid = 10000004;
			Integer amount = 1;
			cartService.addToCart(uid, username, pid, amount);
			System.err.println("ok");
		} catch (ServiceException e) {
			System.err.println(e.getClass().getName());
			System.err.println(e.getMessage());
		}
	}

	@Test
	public void delete() {
		try {
			Integer uid = 21;
			Integer[] cids = { 6, 8, };
			cartService.delete(cids, uid);
			System.err.println("ok");
		} catch (ServiceException e) {
			System.err.println(e.getClass().getName());
			System.err.println(e.getMessage());
		}
	}

	@Test
	public void getByUid() {
		try {
			Integer uid = 21;
			cartService.getByUid(uid);
			System.err.println("ok");
		} catch (ServiceException e) {
			System.err.println(e.getClass().getName());
			System.err.println(e.getMessage());
		}
	}

	@Test
	public void addNum() {
		try {
			Integer cid = 5;
			Integer uid = 21;
			String username = "购物车管理员";
			cartService.addNum(cid, uid, username);
			System.err.println("ok");
		} catch (ServiceException e) {
			System.err.println(e.getClass().getName());
			System.err.println(e.getMessage());
		}
	}

	@Test
	public void reduceNum() {
		try {
			Integer cid = 18;
			Integer uid = 21;
			String username = "购物车管理员";
			cartService.reduceNum(cid, uid, username);
			System.err.println("ok");
		} catch (ServiceException e) {
			System.err.println(e.getClass().getName());
			System.err.println(e.getMessage());
		}
	}

	@Test
	public void getByCids() {
		try {
			Integer[] cids = { 10, 8, 2, 3, 14, 12, 6, 15, 16, 18, 20 };
			Integer uid = 21;
			List<CartVO> list = cartService.getByCids(cids, uid);
			System.err.println("count=" + list.size());
			for (CartVO item : list) {
				System.err.println(item);
			}
		} catch (ServiceException e) {
			System.err.println(e.getClass().getName());
			System.err.println(e.getMessage());
		}
	}

}
