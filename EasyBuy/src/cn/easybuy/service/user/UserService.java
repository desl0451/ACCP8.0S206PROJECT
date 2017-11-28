package cn.easybuy.service.user;

import java.util.List;

import cn.easybuy.entity.User;
import cn.easybuy.param.UserParams;

public interface UserService {
	/**
	 * 新闻用户信息
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public boolean add(User user) throws Exception;

	/**
	 * 更改用户信息
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public int update(User user) throws Exception;

	/**
	 * 删除用户信息
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int deleteUserById(String id) throws Exception;

	/**
	 * 获取用户信息
	 * 
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public List<User> getUserList(UserParams params) throws Exception;

	/**
	 * 获得用户数量
	 * 
	 * @return
	 * @throws Exception
	 */
	public Integer getUserCount() throws Exception;

	/**
	 * 根据id和loginName查询用户对象
	 */
	public User getUserById(Integer id, String loginName) throws Exception;

	/**
	 * 根据用户名密码查询对象
	 * 
	 * @param userId
	 * @param loginName
	 * @return
	 */
	public User getUser(Integer userId, String loginName);
}
