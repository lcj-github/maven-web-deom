package com.lcj.datamake.db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class SimuDataMake {

	private static Connection conn = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;

	@BeforeClass
	public static void setUp() {
		String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String username = "";
		String password = "";
		String url = "jdbc:sqlserver://ip;DatabaseName=databasename";
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testMinus() throws SQLException {

		String sql_insert = ""
				+ "insert into PrivatePlacement\n"
				+ "    (saidCode,nName,operstatus,marketCode, activityCode, productCode,accName,mobMD5,mobGUID,createTime,mobileFormat,updateTime)\n"
				+ "values\n" + "    (?, ?, ?, ?,?, ?, ?, ?,?, ?, ?, ?)";

		for (int i = 1; i < 10; i++) {

			String saidCode = null;	
			String sql_getVal = "select * from CustomerInfo where id = ?";
			ps = conn.prepareStatement(sql_getVal);
			ps.setInt(1, i + 100);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				saidCode = rs.getString("saidCode");
				conn.setAutoCommit(false);
				PreparedStatement pstmt = conn.prepareStatement(sql_insert);
				pstmt.setString(1, saidCode);
				pstmt.setString(2, "NNickName_" + i);
				pstmt.setString(3, "1");
				pstmt.setString(4, "3110");
				pstmt.setString(5, "99911");
				pstmt.setString(6, "SM001");
				int t = 9010 + i;
				pstmt.setString(7, "zypertest_" + t);
				pstmt.setString(8, "");
				pstmt.setString(9, "");
				pstmt.setDate(10, new Date(System.currentTimeMillis()));
				pstmt.setString(11, "");
				pstmt.setDate(12, new Date(System.currentTimeMillis()));

				pstmt.executeUpdate();
				conn.commit();
			}
		}
	}

	@AfterClass
	public static void tearDown() {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
