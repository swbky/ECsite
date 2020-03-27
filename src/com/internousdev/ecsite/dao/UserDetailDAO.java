package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.UserInfoDTO;
import com.internousdev.ecsite.util.DBConnector;

public class UserDetailDAO {

	public ArrayList<UserInfoDTO> userDetail(String loginId){

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		ArrayList<UserInfoDTO> userList = new ArrayList<UserInfoDTO>();

		String sql = "select * from login_user_transaction where login_id=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginId);
			ResultSet rs = ps.executeQuery();

			if(rs.next()) {
				UserInfoDTO dto = new UserInfoDTO();
				dto.setLoginId(rs.getString("login_id"));
				dto.setLoginPassword(rs.getString("login_pass"));
				dto.setUserName(rs.getString("user_name"));
				dto.setInsertDate(rs.getString("insert_date"));

				if(rs.getString("admin_flg").equals("1")) {
					dto.setAdminFlg("管理者");
				} else {
					dto.setAdminFlg("ユーザー");
				}
				userList.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}

}
