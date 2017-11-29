package cn.easybuy.dao.product;

import java.util.List;

import cn.easybuy.entity.Product;
/**
 * 查询商品Dao
 * @author 王涛
 * 2017年11月29日
 */
public interface ProductDao {
	Integer updateStock(Integer id, Integer quantity) throws Exception;
	
	public Integer add(Product product) throws Exception;

	public Integer update(Product product) throws Exception;
	
	public Integer deleteProductById(Integer id) throws Exception;
	
	public Product getProductById(Integer id)throws Exception;
	
	public List<Product> getProductList(Integer currentPageNo,Integer pageSize,String proName,Integer categoryId,Integer level)throws Exception;
	
	public Integer queryProductCount(String proName,Integer categoryId,Integer level)throws Exception;

}
