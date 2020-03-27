package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.util.DBConnector;

public class ItemSearchCompleteDAO {

	public ArrayList<BuyItemDTO> getBuyItemInfo(int newPriceAbove, int newPriceBelow, String itemName) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		ArrayList<BuyItemDTO> searchItemList = new ArrayList<BuyItemDTO>();


		String sql = "select id,item_name,item_price from item_info_transaction where item_price >= ? and item_price <= ? and item_name = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, newPriceAbove);
			ps.setInt(2, newPriceBelow);
			ps.setString(3, itemName);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				BuyItemDTO buyItemDTO = new BuyItemDTO();
				buyItemDTO.setId(rs.getInt("id"));
				buyItemDTO.setItemName(rs.getString("item_name"));
				buyItemDTO.setItemPrice(rs.getString("item_price"));
				searchItemList.add(buyItemDTO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return searchItemList;
	}

	public ArrayList<BuyItemDTO> getBuyItemInfo(int newPriceAbove, int newPriceBelow) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		ArrayList<BuyItemDTO> searchItemList = new ArrayList<BuyItemDTO>();


		String sql = "select id,item_name,item_price from item_info_transaction where item_price >= ? and item_price <= ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, newPriceAbove);
			ps.setInt(2, newPriceBelow);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				BuyItemDTO buyItemDTO = new BuyItemDTO();
				buyItemDTO.setId(rs.getInt("id"));
				buyItemDTO.setItemName(rs.getString("item_name"));
				buyItemDTO.setItemPrice(rs.getString("item_price"));
				searchItemList.add(buyItemDTO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return searchItemList;
	}


}
