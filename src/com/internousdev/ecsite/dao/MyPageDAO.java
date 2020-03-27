package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.MyPageDTO;
import com.internousdev.ecsite.util.DBConnector;

public class MyPageDAO {

	public ArrayList<MyPageDTO> getMyPageUserInfo(String user_master_id) throws SQLException{

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		ArrayList<MyPageDTO> myPageDTO = new ArrayList<MyPageDTO>();

		String sql = "select item_name, total_price, total_count, pay, insert_date from user_buy_item_transaction where user_master_id = ? order by insert_date desc";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user_master_id);     //session.get("login_user_id") = loginusertransactionのlogin_id
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				MyPageDTO dto = new MyPageDTO();
				dto.setItemName(rs.getString("item_name"));
				dto.setTotalPrice(rs.getString("total_price"));
				dto.setTotalCount(rs.getString("total_count"));
				dto.setPayment(rs.getString("pay"));
				dto.setInsert_date(rs.getString("insert_date"));
				myPageDTO.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return myPageDTO;
	}

	public int buyItemHistoryDelete(String user_master_id) throws SQLException{

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "delete from user_buy_item_transaction where user_master_id=?";

		PreparedStatement ps;
		int result = 0;

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, user_master_id);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		con.close();
		}
		return result;
	}

}
