package cn.tedu.store.mapper;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.Cart;
import cn.tedu.store.vo.CartVO;

/**
 * @author 作者：chen
 * @email 邮箱：727424623@qq.com
 * @version v.1.0 创建时间：下午6:46:15
 * @description 描述：
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class CartMapperTests {
	@Autowired
	CartMapper mapper;

	@Test
	public void insert() {
		Cart cart = new Cart();
		cart.setCid(1);
		cart.setUid(2);
		cart.setPid(3);
		cart.setNum(4);
		cart.setPrice(5);
		cart.setCreatedTime(new Date());
		cart.setCreatedUser("商品管理员");
		cart.setModifiedTime(new Date());
		cart.setModifiedUser("商品管理员");
		Integer rows = mapper.insert(cart);
		System.err.println("rows=" + rows);
		System.err.println(cart);
	}

	@Test
	public void deleteBycids() {
		Integer[] cids = {5,7,9};
		Integer uid = 21;
		Integer rows = mapper.deleteBycids(cids, uid);
		System.err.println("rows=" + rows);
	}

	@Test
	public void updateNumByCid() {
		Integer cid = 1;
		Integer num = 2;
		String modifiedUser = "货品管理员";
		Integer rows = mapper.updateNumByCid(cid, num, modifiedUser, new Date());
		System.err.println("rows=" + rows);
	}

	@Test
	public void findByUidAndPid() {
		Integer uid = 21;
		Integer pid = 10000001;
		Cart cart = mapper.findByUidAndPid(uid, pid);
		System.err.println(cart);
	}

	@Test
	public void findByUid() {
		Integer uid = 21;
		List<CartVO> list = mapper.findByUid(uid);
		for (CartVO cartVO : list) {
			System.err.println(cartVO);
		}
	}

	@Test
	public void findByCid() {
		Integer uid = 10;
		Cart cart = mapper.findByCid(uid);
		System.err.println(cart);
	}

	@Test
	public void findByCids() {
		Integer[] cids = { 10, 8, 2, 3, 14, 12, 6, 15, 16, 18, 20 };
		List<CartVO> list = mapper.findByCids(cids);
		System.err.println("count=" + list.size());
		for (CartVO item : list) {
			System.err.println(item);
		}
	}

}
