package cn.tedu.store.mapper;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.Order;
import cn.tedu.store.entity.OrderItem;

/**
 * @author 作者：chen
 * @email 邮箱：727424623@qq.com
 * @version v.1.0 创建时间：下午6:46:15
 * @description 描述：
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMapperTests {
	@Autowired
	OrderMapper mapper;

	@Test
	public void insertOrder() {
		Order order = new Order();
		order.setUid(21);
		order.setRecvName("root");
		order.setRecvProvince("浙江省");
		order.setRecvCity("杭州");
		order.setRecvArea("萧山");
		order.setRecvAddress("下沙");
		order.setZip("000000");
		order.setPhone("138001138002");
		order.setTel("0512-351453");
		order.setOrderTime(new Date());
		order.setPayTime(new Date());
		order.setTotalPrice(5810);
		order.setStatus(1);
		order.setCreatedUser("订单管理员");
		order.setCreatedTime(new Date());
		order.setModifiedUser("订单管理员");
		order.setModifiedTime(new Date());
		Integer rows = mapper.insertOrder(order);
		System.err.println("rows=" + rows);
		System.err.println(order);
	}

	@Test
	public void insertOrderItem() {
		OrderItem orderItem = new OrderItem();
		orderItem.setOid(1);
		orderItem.setPid(2);
		orderItem.setTitle("笔记本");
		orderItem.setImage("/image..");
		orderItem.setPrice(154);
		orderItem.setNum(5);
		orderItem.setCreatedUser("订单管理员");
		orderItem.setCreatedTime(new Date());
		orderItem.setModifiedUser("订单管理员");
		orderItem.setModifiedTime(new Date());
		Integer rows = mapper.insertOrderItem(orderItem);
		System.err.println("rows=" + rows);
		System.err.println(orderItem);
	}

}
