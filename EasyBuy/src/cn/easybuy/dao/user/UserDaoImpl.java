package cn.easybuy.dao.user;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import cn.easybuy.utils.Pager;
import cn.easybuy.dao.BaseDaoImpl;
import cn.easybuy.entity.User;

public class UserDaoImpl extends BaseDaoImpl implements UserDao {

	public UserDaoImpl(Connection connection) {
		super(connection);
	}

	@Override
	public int add(User user) throws Exception {
		String sql = " INSERT into easybuy_user(loginName,userName,password,sex,identityCode,email,mobile) values(?,?,?,?,?,?,?) ";
		Object params[] = new Object[] { user.getLoginName(), user.getUserName(), user.getPassword(), user.getSex(),
				user.getIdentityCode(), user.getEmail(), user.getMobile() };
		return this.executeUpdate(sql, params);
	}

	@Override
	public int update(User user) throws Exception {
		Object[] params = new Object[] { user.getLoginName(), user.getUserName(), user.getType(), user.getSex(),
				user.getIdentityCode(), user.getEmail(), user.getMobile(), user.getId() };
		String sql = " UPDATE easybuy_user SET loginName=?,userName =?,type=?,sex =?, identityCode =?, email =?, mobile =? WHERE id =?  ";
		return this.executeUpdate(sql, params);
	}

	@Override
	public int deleteUserById(String id) throws Exception {
		String sql = " delete from easybuy_user where id = ? ";
		Object params[] = new Object[] { id };
		return this.executeUpdate(sql, params);

	}

	@Override
	public List<User> getUserList(Integer currentPageNo, Integer pageSize) throws Exception {
		List<Object> paramsList = new ArrayList<Object>();
		List<User> userList = new ArrayList<User>();
		StringBuffer sql = new StringBuffer(
				"   select id,loginName,password,userName,sex,identityCode,email,mobile,type from easybuy_user where 1=1 ");
		ResultSet rs = null;
		try {
			int total = count();
			Pager pager = new Pager(total, pageSize, currentPageNo);
			sql.append(" limit " + (pager.getCurrentPage() - 1) * pager.getRowPerPage() + "," + pager.getRowPerPage());
			rs = this.executeQuery(sql.toString(), paramsList.toArray());
			while (rs.next()) {
				User user = tableToClass(rs);
				userList.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeResource(rs);
			this.closeResource();
		}
		return userList;
	}

	@Override
	public Integer count() throws Exception {
		List<Object> paramsList = new ArrayList<Object>();
		StringBuffer sql = new StringBuffer(" select count(*) as count from easybuy_user where 1=1 ");
		Integer count = 0;
		ResultSet rs = this.executeQuery(sql.toString(), paramsList.toArray());
		while (rs.next()) {
			count = rs.getInt("count");
		}
		return null;
	}

	@Override
	public User getUser(Integer id, String loginName) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User tableToClass(ResultSet rs) throws Exception {
		User user = new User();
		user.setLoginName(rs.getString("loginName"));
		user.setUserName(rs.getString("userName"));
		user.setPassword(rs.getString("password"));
		user.setSex(rs.getInt("sex"));
		user.setIdentityCode(rs.getString("identityCode"));
		user.setEmail(rs.getString("email"));
		user.setMobile(rs.getString("mobile"));
		user.setType(rs.getInt("type"));
		user.setId(rs.getInt("id"));
		return user;
	}

}
