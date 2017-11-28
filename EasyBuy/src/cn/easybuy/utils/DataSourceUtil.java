package cn.easybuy.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

public class DataSourceUtil {
	private static DataSource dataSource;
	private static String DRIVER;
	private static String URL;
	private static String USER;
	private static String PASSWORD;
	static {
		init();
	}

	public static void init() {
		Properties params = new Properties();
		String configFile = "database.properties";
		InputStream is = DataSourceUtil.class.getClassLoader().getResourceAsStream(configFile);
		try {
			params.load(is);
		} catch (Exception e) {
			e.printStackTrace();
		}
		DRIVER = params.getProperty("driver");
		URL = params.getProperty("url");
		USER = params.getProperty("user");
		PASSWORD = params.getProperty("password");
		
	}

	/**
	 * 打开连接
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static Connection openConnection() throws SQLException {
		Connection conn = null;
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * 关闭连接
	 * 
	 * @param connection
	 */
	public static void closeConnection(Connection connection) {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
