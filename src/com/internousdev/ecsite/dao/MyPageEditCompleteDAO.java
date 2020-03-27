package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;

public class MyPageEditCompleteDAO {

	public int myPageEdit(String newLoginId, String loginPass, String userName, String id, String oldLoginId) {

		DateUtil dateUtil = new DateUtil();
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		int result = 0;

		String sql = "update login_user_transaction set login_id=?, login_pass=?, user_name=?, update_date=? where id=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, newLoginId);
			ps.setString(2, loginPass);
			ps.setString(3, userName);
			ps.setString(4, dateUtil.getDate());
			ps.setString(5, id);

			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if(result > 0) {

			sql = "update user_buy_item_transaction set user_master_id=?, update_date=? where user_master_id=?";

			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, newLoginId);
				ps.setString(2, dateUtil.getDate());
				ps.setString(3, oldLoginId);

				result = ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public int searchUser(String newLoginId, String oldLoginId) {

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		int i = 0;

		String sql = "select login_id from login_user_transaction where login_id=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, newLoginId);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				if( newLoginId.equals(rs.getString("login_id")) && !(oldLoginId.equals(newLoginId))) {
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

}
