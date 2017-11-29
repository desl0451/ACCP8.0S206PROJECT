package cn.easybuy.dao.order;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.easybuy.dao.BaseDaoImpl;
import cn.easybuy.entity.UserAddress;
import cn.easybuy.param.UserAddressParam;
import cn.easybuy.utils.EmptyUtils;

public class UserAddressDaoImpl extends BaseDaoImpl implements UserAddressDao {

	public UserAddressDaoImpl(Connection connection) {
		super(connection);
	}

	@Override
	public Object tableToClass(ResultSet rs) throws Exception {
		UserAddress userAddress = new UserAddress();
		userAddress.setAddress(rs.getString("userAddress"));
		userAddress.setCreateTime(rs.getDate("CreateTime"));
		userAddress.setId(rs.getInt("Id"));
		userAddress.setRemark(rs.getString("Remark"));
		userAddress.setUserId(rs.getInt("UserId"));
		return userAddress;
	}

	@Override
	public List<UserAddress> queryUserAddressList(UserAddressParam param) {
		// TODO Auto-generated method stub 
		StringBuffer sql = new StringBuffer(
				" SELECT id, userId, address, createTime, isDefault, remark FROM easybuy.easybuy_user_address ");
		List<Object> params = new ArrayList<Object>();
		List<UserAddress> userAddressList = new ArrayList<UserAddress>();
		try {
			if (EmptyUtils.isNotEmpty(param.getUserId())) {
				sql.append(" and userId=?");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return null;
	}

	@Override
	public Integer saveUserAddress(UserAddress userAddress) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserAddress getUserAddressById(Integer addressId) {
		// TODO Auto-generated method stub
		return null;
	}

}
