package cn.easybuy.dao.product;

import java.util.List;

import cn.easybuy.entity.ProductCategory;
import cn.easybuy.param.ProductCategoryParam;

public interface ProductCategoryDao {
	void deleteById(Integer parseLong);// 删除商品分类

	public List<ProductCategory> queryProductCategorylist(ProductCategoryParam param);

	public List<ProductCategory> queryAllProductCategorylist(ProductCategoryParam param);

	public ProductCategory queryProductCategoryById(Integer id);

	public Integer save(ProductCategory productCategory);

	public Integer queryProductCategoryCount(ProductCategoryParam param);

	public void update(ProductCategory productCategory);
}
