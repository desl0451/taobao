package cn.jbit.easybuy.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class BaseDao {
	// 驱动
	private final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	// 连接数据库地址
	private final String URL = "jdbc:sqlserver://localhost:1433;databaseName=easybuy";
	// 用户名
	private final String USERNAME = "sa";
	// 密码
	private final String PASSWORD = "123";
	// 连接对象
	Connection conn = null;

	/**
	 * 获得连接
	 * 
	 * @return
	 */
	public Connection getConnection() {
		try {
			// // 设置驱动
			Class.forName(DRIVER);
			// // 获得连接对象
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			// Context ctx = new InitialContext();
			// DataSource ds = (DataSource) ctx
			// .lookup("java:comp/env/jdbc/easybuy");
			// conn = ds.getConnection();
		} catch (Exception e) {// 异常处理
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * 关闭对象
	 * 
	 * @param conn
	 * @param stmt
	 * @param rs
	 */
	public void closeALL(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (stmt != null) {
				stmt.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 执行添加，修改，删除
	 * 
	 * @param sql
	 * @param param
	 * @return
	 */
	public int executeUpdate(String sql, Object[] param) {
		int num = 0;
		conn = getConnection();// 获得连接
		PreparedStatement pstmt = null; // 创建命令对象
		try {
			// 设置SQL语句
			pstmt = conn.prepareStatement(sql);
			// 如果参数不为空则执行
			if (param != null) {
				// 循环设置参数 (从1开始)
				for (int i = 0; i < param.length; i++) {
					pstmt.setObject(i + 1, param[i]);
				}
			}
			// 执行SQL语句
			num = pstmt.executeUpdate();
		} catch (Exception e) {// 异常处理
			e.printStackTrace();
		} finally {
			closeALL(conn, pstmt, null);
		}
		return num;
	}
}
