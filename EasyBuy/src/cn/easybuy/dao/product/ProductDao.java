package cn.easybuy.dao.product;

import java.util.List;

import cn.easybuy.dao.IBaseDao;
import cn.easybuy.entity.Product;

public interface ProductDao extends IBaseDao {
	/* 更新库存 */
	public Integer updateStock(Integer id, Integer quantity) throws Exception;

	/* 添加产品 */
	public Integer add(Product product) throws Exception;

	/* 更新产品 */
	public Integer update(Product product) throws Exception;

	/* 根据ID删除指定产品 */
	public Integer deleteProductById(Integer id) throws Exception;

	/* 显示产品列表 */
	public List<Product> getProductList(Integer currentPageNo, Integer pageSize, String proName, Integer categoryId,
			Integer level) throws Exception;
	/* 查询产品数量 */
	public Integer queryProductCount(String proName, Integer categoryId, Integer level) throws Exception;
}
