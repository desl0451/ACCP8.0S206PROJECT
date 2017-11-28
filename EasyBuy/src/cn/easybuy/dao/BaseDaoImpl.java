package cn.easybuy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.log4j.Logger;

/**
 * 实现Dao的实现类,实现最基本的增删改查的方法
 * 
 * @author 王涛 2017年5月22日
 */
public abstract class BaseDaoImpl {
	protected Connection connection;
	protected PreparedStatement pstmt;
	static Logger logger = Logger.getLogger(BaseDaoImpl.class);

	public BaseDaoImpl(Connection connection) {
		this.connection = connection;
	}

	/**
	 * 查询信秘
	 * 
	 * @param sql
	 * @param param
	 * @return
	 */
	public ResultSet executeQuery(String sql, Object[] param) {
		ResultSet rs = null;
		try {
			pstmt = connection.prepareStatement(sql);
			for (int i = 0; i < param.length; i++) {
				pstmt.setObject(i + 1, param[i]);
			}
			rs = pstmt.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	/**
	 * 增删改操作
	 * 
	 * @param sql
	 * @param param
	 * @return
	 */
	public int executeUpdate(String sql, Object[] param) {
		int updateRows = 0;
		try {
			pstmt = connection.prepareStatement(sql);
			for (int i = 0; i < param.length; i++) {
				pstmt.setObject(i + 1, param[i]);
			}
			updateRows = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return updateRows;
	}

	public int executeInsert(String sql, Object[] param) {
		Long id = 0L;
		try {
			pstmt = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			for (int i = 0; i < param.length; i++) {
				pstmt.setObject(i + 1, param[i]);
			}
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				id = rs.getLong(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
			id = null;
		}
		return id.intValue();
	}

	/**
	 * 关闭资源
	 * 
	 * @return
	 */
	public boolean closeResource() {
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}

	public boolean closeResource(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}

	public abstract Object tableToClass(ResultSet rs) throws Exception;
}
