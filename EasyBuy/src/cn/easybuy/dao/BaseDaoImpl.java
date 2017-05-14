package cn.easybuy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public abstract class BaseDaoImpl implements IBaseDao {
	protected Connection connection = null;
	protected PreparedStatement pstmt = null;

	public BaseDaoImpl(Connection connection) {
		this.connection = connection;
	}

	public ResultSet executeQuery(String sql, Object[] param) {
		ResultSet rs = null;
		try {
			pstmt = connection.prepareStatement(sql);
			if (param != null) {
				for (int i = 0; i < param.length; i++) {
					pstmt.setObject(i + 1, param[i]);
				}
			}
			rs = pstmt.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	public int executeUpdate(String sql, Object[] param) {
		int executeUpdate = 0;
		try {
			pstmt = connection.prepareStatement(sql);
			for (int i = 0; i < param.length; i++) {
				pstmt.setObject(i + 1, param[i]);
			}
			executeUpdate = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return executeUpdate;
	}

	public int executeInsert(String sql, Object[] param) {
		Long id = 0L;
		try {
			pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
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
		}
		return id.intValue();
	}

	public void closeResource() {
		try {
			if (pstmt != null) {
				pstmt.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void closeResource(ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public abstract Object tableToClass(ResultSet rs) throws Exception;
}
