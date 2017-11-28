package cn.easybuy.dao.product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.easybuy.dao.BaseDaoImpl;
import cn.easybuy.entity.ProductCategory;
import cn.easybuy.param.ProductCategoryParam;
import cn.easybuy.utils.EmptyUtils;
/**
 * 产品种类
 * @author 王涛
 * 2017年11月28日
 */
public class ProductCategoryDaoImpl extends BaseDaoImpl implements ProductCategoryDao {

	public ProductCategoryDaoImpl(Connection connection) {
		super(connection);
	}

	/**
	 * 根据ID删除
	 */
	@Override
	public void deleteById(Integer parseLong) {
		// TODO Auto-generated method stub
		String sql = "delete from easybuy_product_category where id= ?";
		Object param[] = new Object[] { parseLong };
		this.executeUpdate(sql.toString(), param);
	}

	@Override
	public List<ProductCategory> queryProductCategorylist(ProductCategoryParam param) {
		// TODO Auto-generated method stub
		List<Object> paramList = new ArrayList<Object>();
		List<ProductCategory> productList = new ArrayList<ProductCategory>();
		StringBuffer sql = new StringBuffer(
				"select id,name,parentId,type,iconClass from easybuy_product_category where 1=1 ");
		ResultSet rs = null;
		try {
			if (EmptyUtils.isNotEmpty(param.getName())) {
				sql.append(" and name like ?");
				paramList.add("%" + param.getName() + "%");
			}
			if (EmptyUtils.isNotEmpty(param.getParentId())) {
				sql.append(" and parentid = ? ");
				paramList.add("%" + param.getParentId() + "%");
			}
			if (EmptyUtils.isNotEmpty(param.getType())) {
				sql.append(" and type=? ");
				paramList.add("%" + param.getType() + "%");
			}
			if (param.isPage()) {
				sql.append(" limit " + param.getStartIndex() + "," + param.getPageSize());
			}
			rs = executeQuery(sql.toString(), paramList.toArray());
			while (rs.next()) {
				ProductCategory productCategory = (ProductCategory) this.tableToClass(rs);
				productList.add(productCategory);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeResource();
			this.closeResource(rs);
		}
		return productList;
	}

	@Override
	public List<ProductCategory> queryAllProductCategorylist(ProductCategoryParam param) {
		// TODO Auto-generated method stub
		List<ProductCategory> list = new ArrayList<ProductCategory>();
		List<Object> paramsList = new ArrayList<Object>();
		StringBuffer sql = new StringBuffer(
				"SELECT epc1.*,epc2.name as parentName FROM easybuy_product_category epc1 LEFT JOIN easybuy_product_category epc2 ON epc1.parentId=epc2.id where 1=1 ");
		ResultSet rs = null;
		try {
			if (EmptyUtils.isNotEmpty(param.getName())) {
				sql.append(" and name like ?");
				paramsList.add("%" + param.getName() + "%");
			}
			if (EmptyUtils.isNotEmpty(param.getParentId())) {
				sql.append(" and parentId=?");
				paramsList.add(param.getParentId());
			}
			if (EmptyUtils.isNotEmpty(param.getSort())) {
				sql.append(" order by " + param.getSort() + " ");
			}
			if (param.isPage()) {
				sql.append(" limit " + param.getStartIndex() + "," + param.getPageSize());
			}
			rs = this.executeQuery(sql.toString(), paramsList.toArray());
			ResultSetMetaData md = rs.getMetaData();
			Map<String, Object> rowData = new HashMap<String, Object>();
			int count = md.getColumnCount();
			for (int i = 1; i <= count; i++) {
				rowData.put(md.getColumnLabel(i), rs.getObject(i));
			}
			list.add(mapToClass(rowData));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return null;
	}

	@Override
	public ProductCategory queryProductCategoryById(Integer id) {
		// TODO Auto-generated method stub
		List<Object> paramsList = new ArrayList<Object>();
		ProductCategory productCategory = null;
		StringBuffer sql = new StringBuffer(
				"SELECT id,name,parentId,type,iconClass  FROM easybuy_product_category where id = ? ");
		ResultSet rs = this.executeQuery(sql.toString(), new Object[] { id });
		try {
			while (rs.next()) {
				productCategory = (ProductCategory) this.tableToClass(rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeResource();
			this.closeResource(rs);
		}
		return productCategory;
	}

	@Override
	public Integer save(ProductCategory productCategory) {
		// TODO Auto-generated method stub
		Integer id = 0;
		try {
			String sql = "";
			Object param[] = new Object[] { productCategory.getName(), productCategory.getParentId(),
					productCategory.getType(), productCategory.getIconClass() };
			id = this.executeInsert(sql, param);
			productCategory.setId(id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeResource();
		}
		return id;
	}

	@Override
	public Integer queryProductCategoryCount(ProductCategoryParam param) {
		List<Object> paramsList = new ArrayList<Object>();
		Integer count = 0;
		StringBuffer sql = new StringBuffer("SELECT count(*) count FROM easybuy_product_category where 1=1");
		if (EmptyUtils.isNotEmpty(param.getName())) {
			sql.append(" and name like ?");
			paramsList.add("%" + param.getName() + "%");
		}
		if (EmptyUtils.isNotEmpty(param.getParentId())) {
			sql.append(" and parentid = ? ");
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

	@Override
	public void update(ProductCategory productCategory) {
		try {
			Object[] params = new Object[] { productCategory.getName(), productCategory.getParentId(),
					productCategory.getType(), productCategory.getIconClass(), productCategory.getId() };
			String sql = " UPDATE easybuy_product_category SET name=?,parentId=?,type=?,iconClass=? WHERE id =?  ";
			this.executeUpdate(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeResource();
		}
	}

	/**
	 * 将记录装入实体中
	 */
	@Override
	public Object tableToClass(ResultSet rs) throws Exception {
		ProductCategory productCategory = new ProductCategory();
		productCategory.setId(rs.getInt("id"));
		productCategory.setName(rs.getString("name"));
		productCategory.setParentId(rs.getInt("parentId"));
		productCategory.setType(rs.getInt("type"));
		productCategory.setIconClass(rs.getString("iconClass"));
		return productCategory;
	}

	public ProductCategory mapToClass(Map map) throws Exception {
		ProductCategory productCategory = new ProductCategory();
		Object idObject = map.get("id");
		Object nameObject = map.get("name");
		Object parentIdObject = map.get("parentId");
		Object typeObject = map.get("type");
		Object iconClassObject = map.get("iconClass");
		Object parentNameObject = map.get("parentName");
		productCategory.setId(EmptyUtils.isEmpty(idObject) ? null : (Integer) idObject);
		productCategory.setName(EmptyUtils.isEmpty(nameObject) ? null : (String) nameObject);
		productCategory.setParentId(EmptyUtils.isEmpty(parentIdObject) ? null : (Integer) parentIdObject);
		productCategory.setType(EmptyUtils.isEmpty(typeObject) ? null : (Integer) typeObject);
		productCategory.setIconClass(EmptyUtils.isEmpty(iconClassObject) ? null : (String) iconClassObject);
		productCategory.setParentName(EmptyUtils.isEmpty(parentNameObject) ? null : (String) parentNameObject);
		return productCategory;
	}
}
