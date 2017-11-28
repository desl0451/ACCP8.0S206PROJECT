package cn.easybuy.dao.order;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.easybuy.dao.BaseDaoImpl;
import cn.easybuy.entity.Order;
import cn.easybuy.utils.EmptyUtils;
import cn.easybuy.utils.Pager;

public class OrderDaoImpl extends BaseDaoImpl implements OrderDao {

	public OrderDaoImpl(Connection connection) {
		super(connection);
	}

	@Override
	public Object tableToClass(ResultSet rs) throws Exception {
		// TODO Auto-generated method stub
		Order order = new Order();
		order.setCost(rs.getFloat("Cost"));
		order.setCreateTime(rs.getDate("CreateTime"));
		order.setId(rs.getInt("id"));
		order.setLoginName(rs.getString("LoginName"));
		order.setSerialNumber(rs.getString("SerialNumber"));
		order.setUserAddress(rs.getString("UserAddress"));
		order.setUserId(rs.getInt("UserId"));
		return order;
	}

	@Override
	public void add(Order order) {
		// TODO 添加操作
		String sql = "insert into easybuy_order(userId,loginName,userAddress,createTime,cost,serialNumber) values(?,?,?,?,?,?) ";
		Object[] param = new Object[] { order.getUserId(), order.getLoginName(), order.getUserAddress(), new Date(),
				order.getCost(), order.getSerialNumber() };
		int id = 0;
		try {
			id = this.executeInsert(sql, param);
			order.setId(new Integer(id).intValue());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeResource();
		}
	}

	@Override
	public void deleteById(Integer id) {
		// TODO 删除操作
		String sql = " delete from easybuy_order where id = ? ";
		Object[] param = new Object[] { id };
		try {
			this.executeUpdate(sql, param);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeResource();
		}
	}

	@Override
	public Order getOrderById(Integer id) {
		// TODO Auto-generated method stub
		String sql = "select * from easybuy_order where id=?";
		Object[] param = new Object[] { id };
		Order order = new Order();
		try {
			ResultSet rs = this.executeQuery(sql, param);
			while (rs.next()) {
				order = (Order) tableToClass(rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeResource();
		}
		return order;
	}

	/**
	 * 返回指定页数记录
	 */
	@Override
	public List<Order> getOrderList(Integer userId, Integer currentPageNo, Integer pageSize) {
		// TODO Auto-generated method stub
		List<Object> paramsList = new ArrayList<Object>();
		List<Order> orderList = new ArrayList<Order>();
		StringBuffer sql = new StringBuffer(
				" select id,userId,loginName,userAddress,createTime,cost,serialNumber from easybuy_order  where 1=1 ");
		if (EmptyUtils.isNotEmpty(userId)) {
			sql.append(" and userId=?");
			paramsList.add(userId);
		}
		int total = count(userId);
		Pager pager = new Pager(total, pageSize, currentPageNo);
		sql.append(" limit " + (pager.getCurrentPage() - 1) * pager.getRowPerPage() + "," + pager.getRowPerPage());
		ResultSet rs = this.executeQuery(sql.toString(), paramsList.toArray());
		try {
			while (rs.next()) {
				Order order = (Order) this.tableToClass(rs);
				orderList.add(order);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeResource();
			this.closeResource(rs);
		}
		return orderList;
	}

	@Override
	public Integer count(Integer userId) {
		// TODO Auto-generated method stub
		List<Object> paramsList = new ArrayList<Object>();
		Integer count = 0;
		StringBuffer sql = new StringBuffer(" select count(id) count from easybuy_order where 1-1 ");
		if (EmptyUtils.isNotEmpty(userId)) {
			sql.append(" and userId=?");
			paramsList.add(userId);
		}
		ResultSet rs = this.executeQuery(sql.toString(), paramsList.toArray());
		try {
			while (rs.next()) {
				count = rs.getInt("count");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeResource();
			this.closeResource(rs);
		}
		return count;
	}

}
