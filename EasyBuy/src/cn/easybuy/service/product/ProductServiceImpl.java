package cn.easybuy.service.product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import cn.easybuy.dao.product.ProductDao;
import cn.easybuy.dao.product.ProductDaoImpl;
import cn.easybuy.entity.Product;
import cn.easybuy.utils.DataSourceUtil;

public class ProductServiceImpl implements ProductService {

	@Override
	public boolean add(Product product) {
		// TODO Auto-generated method stub
		String sql = "";
		Object[] params = new Object[] {};
		int id = 0;
		Connection connection = null;
		try {
			connection = DataSourceUtil.openConnection();
			ProductDao productDao = new ProductDaoImpl(connection);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteProductById(Integer productId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Product getProductById(Integer productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getProductList(Integer currentPageNo, Integer pageSize, String proName, Integer categoryId,
			Integer level) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int count(String proName, Integer categoryId, Integer level) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean updateStock(Integer productId, Integer stock) {
		// TODO Auto-generated method stub
		return false;
	}

}
