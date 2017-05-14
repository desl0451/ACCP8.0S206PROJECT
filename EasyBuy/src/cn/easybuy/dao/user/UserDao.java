package cn.easybuy.dao.user;

import java.util.List;

import cn.easybuy.entity.User;

public interface UserDao {
	public int add(User user) throws Exception;

	public int update(User user) throws Exception;

	public int deleteUserById(String id) throws Exception;

	public List<User> getUserList(Integer currentPage, Integer pageSize) throws Exception;

	public Integer count() throws Exception;

	public User getUser(Integer id, String loginName) throws Exception;
}
