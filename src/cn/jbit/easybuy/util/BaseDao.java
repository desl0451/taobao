package cn.jbit.easybuy.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class BaseDao {
	// ����
	private final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	// �������ݿ��ַ
	private final String URL = "jdbc:sqlserver://localhost:1433;databaseName=easybuy";
	// �û���
	private final String USERNAME = "sa";
	// ����
	private final String PASSWORD = "123";
	// ���Ӷ���
	Connection conn = null;

	/**
	 * �������
	 * 
	 * @return
	 */
	public Connection getConnection() {
		try {
			// // ��������
			Class.forName(DRIVER);
			// // ������Ӷ���
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			// Context ctx = new InitialContext();
			// DataSource ds = (DataSource) ctx
			// .lookup("java:comp/env/jdbc/easybuy");
			// conn = ds.getConnection();
		} catch (Exception e) {// �쳣����
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * �رն���
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
	 * ִ����ӣ��޸ģ�ɾ��
	 * 
	 * @param sql
	 * @param param
	 * @return
	 */
	public int executeUpdate(String sql, Object[] param) {
		int num = 0;
		conn = getConnection();// �������
		PreparedStatement pstmt = null; // �����������
		try {
			// ����SQL���
			pstmt = conn.prepareStatement(sql);
			// ���������Ϊ����ִ��
			if (param != null) {
				// ѭ�����ò��� (��1��ʼ)
				for (int i = 0; i < param.length; i++) {
					pstmt.setObject(i + 1, param[i]);
				}
			}
			// ִ��SQL���
			num = pstmt.executeUpdate();
		} catch (Exception e) {// �쳣����
			e.printStackTrace();
		} finally {
			closeALL(conn, pstmt, null);
		}
		return num;
	}
}
