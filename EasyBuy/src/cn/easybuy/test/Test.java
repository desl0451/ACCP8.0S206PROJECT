package cn.easybuy.test;

import java.sql.Connection;
import java.util.List;

import cn.easybuy.dao.product.ProductDao;
import cn.easybuy.dao.product.ProductDaoImpl;
import cn.easybuy.dao.user.UserDaoImpl;
import cn.easybuy.entity.Product;
import cn.easybuy.entity.User;
import cn.easybuy.utils.DataSourceUtil;

public class Test {
	public static void main(String[] args) {
//		tianjia();
		chaxun() ;
	}

	public static void tianjia() {
//		Connection connection = null;
//		try {
//			connection = DataSourceUtil.openConnection();
//			User user = new User();
//			user.setEmail("desl@126.com");
//			user.setIdentityCode("123123123");
//			user.setLoginName("xiaobao");
//			user.setMobile("139421347812");
//			user.setPassword("123456");
//			user.setSex(1);
//			user.setType(1);
//			user.setUserName("小宝");
//			UserDaoImpl dao = new UserDaoImpl(connection);
//			int id = dao.add(user);
//			if (id > 0) {
//				System.out.println("添加成功!");
//			} else {
//				System.out.println("添加失败!");
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			DataSourceUtil.closeConnection(connection);
//		}
	}

	public static void chaxun() {
		Connection connection = null;
		List<Product> productList = null;
		try {

			connection = DataSourceUtil.openConnection();
			ProductDao productDao = new ProductDaoImpl(connection);
			int currentPageNo = 1;
			int pageSize = 5;
			productList = productDao.getProductList(currentPageNo, pageSize, null, null, null);
			for (Product product : productList) {
				System.out.println(product.getName() + "" + product.getFileName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataSourceUtil.closeConnection(connection);
		}
	}
}
