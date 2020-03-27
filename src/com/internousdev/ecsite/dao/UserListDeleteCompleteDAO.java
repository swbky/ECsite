package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;

public class UserListDeleteCompleteDAO {

	public void DeleteUser() {

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "delete from login_user_transaction where admin_flg='0'";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void DeleteUserDetail(String loginId) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "delete from login_user_transaction where login_id=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,loginId);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
