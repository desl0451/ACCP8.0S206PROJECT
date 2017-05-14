package cn.easybuy.dao.product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.easybuy.dao.BaseDaoImpl;
import cn.easybuy.entity.Product;
import cn.easybuy.utils.EmptyUtils;
import cn.easybuy.utils.Pager;

public class ProductDaoImpl extends BaseDaoImpl implements ProductDao {

	public ProductDaoImpl(Connection connection) {
		super(connection);
	}

	@Override
	public Integer updateStock(Integer id, Integer quantity) throws Exception {
		// TODO Auto-generated method stub
		String sql = "";
		return null;
	}

	@Override
	public Integer add(Product product) throws Exception {
		// TODO Auto-generated method stub
		String sql = " insert into easybuy_product(name,description,price,stock,categoryLevel1Id,categoryLevel2Id,categoryLevel3Id,fileName,isDelete) values(?,?,?,?,?,?,?,?,?) ";
		Object[] params = { product.getName(), product.getDescription(), product.getPrice(), product.getStock(),
				product.getCategoryLevel1Id(), product.getCategoryLevel2Id(), product.getCategoryLevel3Id(),
				product.getFileName(), 0 };
		return this.executeInsert(sql, params);
	}

	@Override
	public Integer update(Product product) throws Exception {
		// TODO Auto-generated method stub
		String sql = " update easybuy_product set name=?,fileName=?,categoryLevel1Id=?,categoryLevel3Id=?,categoryLevel3Id=? where id=? ";
		Object[] params = new Object[] { product.getName(), product.getFileName(), product.getCategoryLevel1Id(),
				product.getCategoryLevel2Id(), product.getCategoryLevel3Id(), product.getId() };
		return this.executeUpdate(sql, params);
	}

	@Override
	public Integer deleteProductById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		String sql = " delete from easybuy_product where id = ? ";
		Object params[] = new Object[] { id };
		return this.executeUpdate(sql, params);
	}

	@Override
	public List<Product> getProductList(Integer currentPageNo, Integer pageSize, String proName, Integer categoryId,
			Integer level) throws Exception {
		// TODO Auto-generated method stub

		List<Object> paramsList = new ArrayList<Object>();

		List<Product> productList = new ArrayList<Product>();
		ResultSet rs = null;
		StringBuffer sql = new StringBuffer(
				" select id,name,description,price,stock,categoryLevel1Id,categoryLevel2Id,categoryLevel3Id,fileName,isDelete from easybuy_product  where 1=1 ");
		try {
			if (EmptyUtils.isNotEmpty(proName)) {
				sql.append(" and name like ?");
				paramsList.add("%" + proName + "%");
			}
			if (EmptyUtils.isNotEmpty(categoryId)) {
				sql.append(" and categoryLevel1Id=? or categoryLevel2Id=? or categoryLevel3Id=? ");
				paramsList.add(categoryId);
				paramsList.add(categoryId);
				paramsList.add(categoryId);
			}
			int total = queryProductCount(proName, categoryId, level);
			Pager pager = new Pager(total, pageSize, currentPageNo);
			sql.append(" limit " + (pager.getCurrentPage() - 1) * pager.getRowPerPage() + "," + pager.getRowPerPage());
			rs = this.executeQuery(sql.toString(), paramsList.toArray());
			while (rs.next()) {
				Product product = this.tableToClass(rs);
				productList.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeResource(rs);
			this.closeResource();
		}
		return productList;
	}

	@Override
	public Integer queryProductCount(String proName, Integer categoryId, Integer level) throws Exception {
		// TODO Auto-generated method stub
		List<Object> paramsList = new ArrayList<Object>();
		Integer count = 0;
		StringBuffer sql = new StringBuffer("  select count(*) count from easybuy_product where 1=1 ");
		if (EmptyUtils.isNotEmpty(proName)) {
			sql.append(" and name like ? ");
			paramsList.add("%" + proName + "%");
		}

		if (EmptyUtils.isNotEmpty(categoryId)) {
			sql.append(" and (categoryLevel1Id = ? or categoryLevel2Id=? or categoryLevel3Id=? ) ");
			paramsList.add(categoryId);
			paramsList.add(categoryId);
			paramsList.add(categoryId);
		}
		ResultSet resultSet = this.executeQuery(sql.toString(), paramsList.toArray());
		try {
			while (resultSet.next()) {
				count = resultSet.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeResource(resultSet);
			this.closeResource();
		}
		return count;
	}

	@Override
	public Product tableToClass(ResultSet rs) throws Exception {
		// TODO Auto-generated method stub
		Product product = new Product();
		product.setId(rs.getInt("id"));
		product.setName(rs.getString("name"));
		product.setDescription(rs.getString("description"));
		product.setPrice(rs.getFloat("price"));
		product.setStock(rs.getInt("stock"));
		product.setCategoryLevel1Id(rs.getInt("categoryLevel1Id"));
		product.setCategoryLevel2Id(rs.getInt("categoryLevel2Id"));
		product.setCategoryLevel3Id(rs.getInt("categoryLevel3Id"));
		product.setFileName(rs.getString("fileName"));
		return product;
	}

}
