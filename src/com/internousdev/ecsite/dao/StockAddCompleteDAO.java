package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;

public class StockAddCompleteDAO {

	public int stockAdd(String stock, String id) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		int result = 0;

		String sql = "update item_info_transaction set item_stock=? where id=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, stock);
			ps.setString(2, id);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return result;
	}
}