package cn.easybuy.dao.user;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import cn.easybuy.dao.BaseDaoImpl;
import cn.easybuy.entity.User;

public class UserDaoImpl extends BaseDaoImpl implements UserDao {

	public UserDaoImpl(Connection connection) {
		super(connection);
	}

	@Override
	public int add(User user) throws Exception {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO easybuy.easybuy_user ( loginName, userName, PASSWORD, sex, identityCode, email, mobile, TYPE)VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Object[] param = { user.getLoginName(), user.getUserName(), user.getPassword(), user.getSex(),
				user.getIdentityCode(), user.getEmail(), user.getMobile(), user.getType() };
		return this.executeInsert(sql, param);
	}

	@Override
	public int update(User user) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteUserById(String id) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<User> getUserList(Integer currentPage, Integer pageSize) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer count() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUser(Integer id, String loginName) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object tableToClass(ResultSet rs) throws Exception {
		User user = new User();
		user.setEmail(rs.getString("email"));
		user.setId(rs.getInt("id"));
		user.setIdentityCode(rs.getString("identitycode"));
		user.setLoginName(rs.getString("loginname"));
		user.setMobile(rs.getString("mobile"));
		user.setPassword(rs.getString("password"));
		user.setSex(rs.getInt("sex"));
		user.setType(rs.getInt("type"));
		user.setUserName(rs.getString("username"));
		return user;
	}

}
