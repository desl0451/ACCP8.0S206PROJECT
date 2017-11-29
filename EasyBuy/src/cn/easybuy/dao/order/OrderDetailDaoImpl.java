package cn.easybuy.dao.order;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.easybuy.dao.BaseDaoImpl;
import cn.easybuy.entity.OrderDetail;
import cn.easybuy.param.OrderDetailParam;
import cn.easybuy.utils.EmptyUtils;

public class OrderDetailDaoImpl extends BaseDaoImpl implements OrderDetailDao {

	@Override
	public void add(OrderDetail detail) throws Exception {
		// TODO Auto-generated method stub
		Integer id = 0;
		String sql = " insert into easybuy_order_detail(orderId,productId,quantity,cost) values(?,?,?,?) ";
		try {
			Object param[] = new Object[] { detail.getOrderId(), detail.getProduct().getId(), detail.getQuantity(),
					detail.getCost() };
			id = this.executeInsert(sql, param);
			detail.setId(id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeResource();
		}
	}

	public OrderDetailDaoImpl(Connection connection) {
		super(connection);
	}

	@Override
	public Object tableToClass(ResultSet rs) throws Exception {
		// TODO Auto-generated method stub
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setCost(rs.getFloat("Cost"));
		orderDetail.setId(rs.getInt("Id"));
		orderDetail.setProductId(rs.getInt("ProductId"));
		orderDetail.setQuantity(rs.getInt("Quantity"));
		return orderDetail;
	}

	@Override
	public void deleteById(OrderDetail detail) throws Exception {
		// TODO Auto-generated method stub
		String sql = "delete from easybuy_order_detail where id = ? ";
		Object[] param = new Object[] { detail.getId() };
		try {
			this.executeUpdate(sql, param);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeResource();
		}
	}

	@Override
	public OrderDetail getOrderDetailById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		String sql = " select orderId,productId,quantity,cost from easybuy_order_detail where id = ? ";
		ResultSet rs = null;
		OrderDetail orderDetail = null;
		try {
			Object[] params = new Object[] { id };
			rs = this.executeQuery(sql, params);
			while (rs.next()) {
				orderDetail = (OrderDetail) this.tableToClass(rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeResource();
			this.closeResource(rs);
		}
		return orderDetail;
	}

	@Override
	public List<OrderDetail> getOrderDetailList(Integer orderId) throws Exception {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer(
				" select id,orderId,productId,quantity,cost FROM easybuy_order_detail where 1=1 ");
		List<OrderDetail> orderDetail = new ArrayList<OrderDetail>();
		List<Object> paramsList = new ArrayList<Object>();
		ResultSet rs = null;
		try {
			Object[] params = new Object[] { orderId };
			if (EmptyUtils.isNotEmpty(orderId)) {
				sql.append(" and orderId=?");
				paramsList.add(orderId);
			}
			rs = this.executeQuery(sql.toString(), paramsList.toArray());
			while (rs.next()) {
				OrderDetail order = (OrderDetail) tableToClass(rs);
				orderDetail.add(order);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeResource();
			this.closeResource(rs);
		}
		return orderDetail;
	}

	@Override
	public Integer queryOrderDetailCount(OrderDetailParam params) throws Exception {
		StringBuffer sql = new StringBuffer(" select count(*) count FROM easybuy_order_detail where 1=1 ");
		int count = 0;
		List<OrderDetail> orderDetailList = null;
		ResultSet rs = this.executeQuery(sql.toString(), new Object[] {});
		try {
			orderDetailList = new ArrayList<OrderDetail>();
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
