package com.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;
import com.pojo.User;
import com.utils.DBUtils;

public class UserDALImpl implements UserDAL {
	public PreparedStatement pstmt;
	public Connection con;
	public Resultset rset;

	public UserDALImpl() throws SQLException {
		con = DBUtils.getCon();
		pstmt = con.prepareStatement("insert into user values(?,?,?,?)");

	}

	public int AddUser(User user) {
		try {
			pstmt.setString(1, user.getUser_name());
			pstmt.setString(2, user.getEmail());
			pstmt.setString(3, user.getPassword());
			pstmt.setString(4, user.getCity());
			int i = pstmt.executeUpdate();
			return i;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public User validateUser(String email, String password) {
		return null;
	}

	public void cleanUp() throws SQLException {
		if (pstmt != null)
			pstmt.close();
	}
}
