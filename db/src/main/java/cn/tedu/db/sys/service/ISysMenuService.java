package cn.tedu.db.sys.service;

/**
 * 日志模块的业务层父接口
 */

import java.util.List;

import cn.tedu.db.sys.pojo.MenuNodeVO;
import cn.tedu.db.sys.pojo.SysMenuDO;
import cn.tedu.db.sys.service.ex.DeleteException;
import cn.tedu.db.sys.service.ex.EmptyArgumentException;
import cn.tedu.db.sys.service.ex.EmptyIdException;
import cn.tedu.db.sys.service.ex.HasSubMenuException;
import cn.tedu.db.sys.service.ex.IllegalOperationException;
import cn.tedu.db.sys.service.ex.InsertException;
import cn.tedu.db.sys.service.ex.ParentNodeNotFoundException;
import cn.tedu.db.sys.service.ex.RecordNotFoundException;
import cn.tedu.db.sys.service.ex.UpdateException;

public interface ISysMenuService {

	/**
	 * 查询所有菜单节点信息
	 * 
	 * @return 菜单节点信息的集合
	 * @throws RecordNotFoundException
	 */
	List<MenuNodeVO> findMenuNode() throws RecordNotFoundException;

	/**
	 * 添加菜单信息
	 * 
	 * @param sysMenuDO 新的菜单信息
	 * @throws EmptyArgumentException
	 * @throws ParentNodeNotFoundException
	 * @throws InsertException
	 */
	void saveSysMenu(SysMenuDO sysMenuDO) throws EmptyArgumentException, ParentNodeNotFoundException, InsertException;

	/**
	 * 基于菜单id 删除菜单记录及角色菜单表中关联记录
	 * 
	 * @param id 菜单id
	 * @throws EmptyIdException
	 * @throws HasSubMenuException
	 * @throws DeleteException
	 */
	void removeSysMenu(Integer id) throws EmptyIdException, HasSubMenuException, DeleteException;

	/**
	 * 查询所有菜单信息
	 * 
	 * @return 菜单信息的集合
	 * @throws RecordNotFoundException
	 */
	List<SysMenuDO> findSysMenu() throws RecordNotFoundException;

	/**
	 * 基于id查询菜单记录和父类菜单名称
	 * 
	 * @param id
	 * @return 菜单记录
	 * @throws EmptyIdException        针对传入方法的id为null或者小于1的情况
	 * @throws RecordNotFoundException 针对基于id查询到的菜单信息为null的情况
	 */
	SysMenuDO findSysMenuById(Integer id) throws EmptyIdException, RecordNotFoundException;

	/**
	 * 更新菜单记录
	 * 
	 * @param sysMenuDO 新的菜单记录
	 * @throws EmptyIdException            针对传入方法的id为null或者小于1的情况
	 * @throws EmptyArgumentException      针对传入方法的sysMenuDO对象为null或者其中关键字段的值为空的情况
	 * @throws ParentNodeNotFoundException 针对使用父菜单id查询不到父菜单记录的情况
	 * @throws IllegalOperationException   针对菜单项的parentId与当前id一致的情况
	 * @throws UpdateException             针对更新操作返回值为0的情况
	 */
	void modifySysMenu(SysMenuDO sysMenuDO) throws EmptyIdException, EmptyArgumentException,
			ParentNodeNotFoundException, IllegalOperationException, UpdateException;

	/**
	 * 基于菜单id查询菜单记录数量
	 * 
	 * @param menuIds 菜单id数组
	 * @return 实际存在的菜单记录数量
	 * @throws EmptyIdException 针对menuIds为null或者长度为0的异常
	 */
	Integer findMenuCount(Integer[] menuIds) throws EmptyIdException;

}
