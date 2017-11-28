package cn.easybuy.dao.order;

import java.util.List;

import cn.easybuy.entity.OrderDetail;
import cn.easybuy.param.OrderDetailParam;

/**
 * 订单详情
 * 
 * @author 王涛 2017年11月28日
 */
public interface OrderDetailDao {

	public void add(OrderDetail detail) throws Exception;

	public void deleteById(OrderDetail detail) throws Exception;

	public OrderDetail getOrderDetailById(Integer id) throws Exception;

	public List<OrderDetail> getOrderDetailList(Integer orderId) throws Exception;

	public Integer queryOrderDetailCount(OrderDetailParam params) throws Exception;
}
