package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;

public class UserCreateCompleteDAO {

	public int searchUser(String loginUserId) {

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		int i = 0;

		String sql = "select login_id from login_user_transaction where login_id=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginUserId);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				if( loginUserId.equals(rs.getString("login_id")) ) {
					i = 1;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return i;

	}

	public void createUser(String loginUserId, String loginUserPassword, String userName, String adminFlg) {

		DateUtil dateUtil = new DateUtil();
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "insert into login_user_transaction(login_id,login_pass,user_name,insert_date,admin_flg) values(?,?,?,?,?)";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginUserId);
			ps.setString(2, loginUserPassword);
			ps.setString(3, userName);
			ps.setString(4, dateUtil.getDate());
			if(adminFlg.equals("ユーザー")) {
				ps.setString(5, "0");
			} else if(adminFlg.equals("管理者")) {
				ps.setString(5, "1");
			}

			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}


}
