package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;

public class BuyItemCompleteDAO {

	public int buyItemInfo(String item_transaction_id, String item_name, String total_price, String total_count, String user_master_id, String pay) throws SQLException {

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		DateUtil dateUtil = new DateUtil();
		int stock = 0;
		int count = 0;
		int InttotalStock = 1;

		String sql = "select item_stock from item_info_transaction where id=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, item_transaction_id);

			ResultSet rs = ps.executeQuery();

			if(rs.next()) {
				stock = Integer.parseInt(rs.getString("item_stock"));
				count = Integer.parseInt(total_count);
				InttotalStock = stock - count;
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if(InttotalStock >= 0) {

			sql = "update item_info_transaction set item_stock=? where id=?";

			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, InttotalStock);
				ps.setString(2, item_transaction_id);
				ps.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			sql = "insert into user_buy_item_transaction(item_transaction_id, item_name, total_price, total_count, user_master_id, pay, insert_date) values(?,?,?,?,?,?,?)";

			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, item_transaction_id);
				ps.setString(2, item_name);
				ps.setString(3, total_price);
				ps.setString(4, total_count);
				ps.setString(5, user_master_id);
				ps.setString(6, pay);
				ps.setString(7, dateUtil.getDate());
				ps.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return InttotalStock;
	}

}
