package cn.easybuy.dao.user;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.easybuy.dao.BaseDaoImpl;
import cn.easybuy.entity.News;
import cn.easybuy.entity.User;
import cn.easybuy.param.UserParams;
import cn.easybuy.utils.EmptyUtils;

public class UserDaoImpl extends BaseDaoImpl implements UserDao {

	public UserDaoImpl(Connection connection) {
		super(connection);
	}

	@Override
	public Object tableToClass(ResultSet rs) throws Exception {
		// TODO Auto-generated method stub
		User user = new User();
		user.setId(rs.getInt("id"));
		user.setIdentityCode(rs.getString("identityCode"));
		user.setLoginName(rs.getString("loginName"));
		user.setMobile(rs.getString("mobile"));
		user.setPassword(rs.getString("password"));
		user.setSex(rs.getInt("sex"));
		user.setType(rs.getInt("type"));
		user.setUserName(rs.getString("username"));
		user.setEmail(rs.getString("email"));
		return user;
	}

	@Override
	public int add(User user) throws Exception {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO easybuy.easybuy_user (loginName, 	userName, 	PASSWORD, 	sex, 	identityCode,	email, 	mobile)	VALUES	(?,?,?,?,?,?,?);";
		Object[] param = { user.getLoginName(), user.getUserName(), user.getPassword(), user.getSex(),
				user.getIdentityCode(), user.getEmail(), user.getMobile() };
		return this.executeInsert(sql, param);
	}

	@Override
	public int update(User user) throws Exception {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO easybuy.easybuy_user (loginName, 	userName, 	PASSWORD, 	sex, 	identityCode,	email, 	mobile)	VALUES	(?,?,?,?,?,?,?);";
		Object[] param = { user.getLoginName(), user.getUserName(), user.getPassword(), user.getSex(),
				user.getIdentityCode(), user.getEmail(), user.getMobile() };
		return this.executeInsert(sql, param);
	}

	@Override
	public int deleteUserById(String id) throws Exception {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO easybuy.easybuy_user (loginName, 	userName, 	PASSWORD, 	sex, 	identityCode,	email, 	mobile)	VALUES	(?,?,?,?,?,?,?);";
		Object[] param = { id };
		return this.executeInsert(sql, param);
	}

	@Override
	public List<User> getUserList(UserParams params) throws Exception {
		// TODO Auto-generated method stub
		List<Object> paramsList = new ArrayList<Object>();
		List<User> userList = new ArrayList<User>();
		StringBuffer sql = new StringBuffer(
				" select id,loginName, 	userName, 	PASSWORD, 	sex, 	identityCode,	email, 	mobile, 	TYPE from easybuy_user where 1=1 ");
		if (EmptyUtils.isNotEmpty(params.getUserName())) {
			sql.append(" and userName like ?");
			paramsList.add(params.getUserName());
		}

		if (EmptyUtils.isNotEmpty(params.getSort())) {
			sql.append(" order by " + params.getSort());
		}
		if (params.isPage()) {
			sql.append(" limit " + params.getStartIndex() + "," + params.getPageSize());
		}
		ResultSet rs = this.executeQuery(sql.toString(), paramsList.toArray());
		try {
			while (rs.next()) {
				User user = (User) this.tableToClass(rs);
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
	public Integer getUserCount() throws Exception {
		// TODO Auto-generated method stub
		List<Object> paramsList = new ArrayList<Object>();
		StringBuffer sql = new StringBuffer("select count(1) count from easybuy_user where 1=1");
		Integer count = 0;
		ResultSet resultSet = this.executeQuery(sql.toString(), paramsList.toArray());
		try {
			while (resultSet.next()) {
				count = resultSet.getInt("count");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeResource();
			this.closeResource(resultSet);
		}
		return count;
	}

	@Override
	public User getUserById(Integer id, String loginName) throws Exception {
		// TODO Auto-generated method stub
		List<Object> paramsList = new ArrayList<Object>();
		List<User> userList = new ArrayList<User>();
		StringBuffer sql = new StringBuffer(
				"  select id,loginName,userName,password,sex,identityCode,email,mobile,type from easybuy_user where 1=1  ");
		if (EmptyUtils.isNotEmpty(id)) {
			sql.append(" and id=? ");
			paramsList.add(id);
		}
		if (EmptyUtils.isNotEmpty(loginName)) {
			sql.append(" and loginName=? ");
			paramsList.add(loginName);
		}
		ResultSet resultSet = this.executeQuery(sql.toString(), paramsList.toArray());
		User user = null;
		try {
			while (resultSet.next()) {
				user = (User)this.tableToClass(resultSet);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeResource();
			this.closeResource(resultSet);
		}
		return user;
	}

}
