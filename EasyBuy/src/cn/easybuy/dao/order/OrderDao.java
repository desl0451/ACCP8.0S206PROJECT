package cn.easybuy.dao.order;

import java.util.List;

import cn.easybuy.entity.Order;

/**
 * 订单处理Dao
 * 
 * @author 王涛 2017年11月28日
 */
public interface OrderDao {

	public void add(Order order);

	public void deleteById(Integer id);

	public Order getOrderById(Integer id);

	public List<Order> getOrderList(Integer userId, Integer currentPageNo, Integer pageSize);

	public Integer count(Integer userId);

}
