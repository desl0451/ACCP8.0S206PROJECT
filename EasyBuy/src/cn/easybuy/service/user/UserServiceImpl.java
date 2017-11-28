package cn.easybuy.service.user;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import cn.easybuy.dao.user.UserDao;
import cn.easybuy.dao.user.UserDaoImpl;
import cn.easybuy.entity.User;
import cn.easybuy.param.UserParams;
import cn.easybuy.utils.DataSourceUtil;

public class UserServiceImpl implements UserService {

	@Override
	public User getUser(Integer userId, String loginName) {
		// TODO Auto-generated method stub
		Connection connection = null;
		User user = null;
		try {
			connection = DataSourceUtil.openConnection();
			UserDao userDao = new UserDaoImpl(connection);
			user = userDao.getUserById(userId, loginName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	/**
	 * 添加用户信息
	 */
	@Override
	public boolean add(User user){
		Connection connection = null;
		Integer count=0;
		try {
			connection = DataSourceUtil.openConnection();
			UserDao userDao = new UserDaoImpl(connection);
			count=userDao.add(user);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DataSourceUtil.closeConnection(connection);
			return  count>0;
		}
	}


	/**
	 * 更新用户信息
	 */
	@Override
	public int update(User user) throws Exception {
		// TODO Auto-generated method stub
		Connection connection = null;
		int i = 0;
		try {
			connection = DataSourceUtil.openConnection();
			UserDao userDao = new UserDaoImpl(connection);
			i = userDao.update(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	/**
	 * 删除用户信息
	 */
	@Override
	public int deleteUserById(String id) throws Exception {
		// TODO Auto-generated method stub
		Connection connection = null;
		int i = 0;
		try {
			connection = DataSourceUtil.openConnection();
			UserDao userDao = new UserDaoImpl(connection);
			i = userDao.deleteUserById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	/**
	 * 返回用户列表
	 */
	@Override
	public List<User> getUserList(UserParams params) throws Exception {
		// TODO Auto-generated method stub
		Connection connection = null;
		List<User> uList = null;
		int i = 0;
		try {
			connection = DataSourceUtil.openConnection();
			UserDao userDao = new UserDaoImpl(connection);
			uList = userDao.getUserList(params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return uList;
	}

	/**
	 * 返回记录数量
	 */
	@Override
	public Integer getUserCount() throws Exception {
		// TODO Auto-generated method stub
		Connection connection = null;
		Integer id = 0;
		try {
			connection = DataSourceUtil.openConnection();
			UserDao userDao = new UserDaoImpl(connection);
			id = userDao.getUserCount();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return id;
	}

	/**
	 * 返回指定对象
	 */
	@Override
	public User getUserById(Integer id, String loginName) throws Exception {
		// TODO Auto-generated method stub
		Connection connection = null;
		User user = null;
		try {
			connection = DataSourceUtil.openConnection();
			UserDao userDao = new UserDaoImpl(connection);
			user = userDao.getUserById(id, loginName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

}
