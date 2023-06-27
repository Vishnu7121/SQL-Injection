package com.app.login;

import java.sql.*;

import com.app.user.User;


public class LoginService {

	

	public boolean isUserValid(String name, String password, User user,Connection conn) {
		try {

			if (conn != null && !conn.isClosed()) {
				ResultSet rs = null;

				Statement stmt = conn.createStatement();
				String sql = "select * from login where username= '"+name+"' and password= '"+password+"'";

				//String sql = "select * from login where username= ? and password= ?";
				//PreparedStatement pstmt = conn.prepareStatement(sql);
				//pstmt.setString(1, name);
				//pstmt.setString(2, password);
				System.out.println(stmt);
				rs = stmt.executeQuery(sql);

				if (rs != null && rs.next()) {
					user.setUser_id(rs.getInt("user_id"));
					return true;

				}

			}

		} catch (SQLException e) {
			// log(e.getMessage(), e);
			e.printStackTrace();
		}
		return false;
	}

}
