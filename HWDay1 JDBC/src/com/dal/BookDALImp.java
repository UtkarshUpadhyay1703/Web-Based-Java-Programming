package com.dal;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pojo.Book;
import com.util.DBUtil;

public class BookDALImp implements BookDAL {
	public Connection con;
	public ResultSet rset;
	public Statement stmt;
	public PreparedStatement pstmt3, pstmt1, pstmt2;

	public BookDALImp() throws SQLException {
		con = DBUtil.getCon();
		stmt = con.createStatement();
		pstmt1 = con.prepareStatement("insert into books values(?,?,?,?)");
		pstmt2 = con.prepareStatement("update books set title=?, author=?, price=? where bookid=?");
		pstmt3 = con.prepareStatement("delete from books where bookid=?");
	}

	@Override
	public List<Book> GetAllbooks() {
		List<Book> books = new ArrayList<Book>();
		try {
			rset = stmt.executeQuery("select * from books");
			while (rset.next()) {
				books.add(new Book(rset.getInt("bookid"), rset.getString("title"), rset.getString("author"),
						rset.getDouble("price")));
			}
			return books;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int Add(Book book) {
		try {
			pstmt1.setInt(1, book.getId());
			pstmt1.setString(2, book.getTitle());
			pstmt1.setString(3, book.getAuthor());
			pstmt1.setDouble(4, book.getPrice());
			int i = pstmt1.executeUpdate();
			return i;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int Update(Book book) {
		try {
			pstmt2.setString(1, book.getTitle());
			pstmt2.setString(2, book.getAuthor());
			pstmt2.setDouble(3, book.getPrice());
			pstmt2.setInt(4, book.getId());
			int i = pstmt2.executeUpdate();
			return i;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int Delete(int id) {
		try {
			pstmt3.setInt(1, id);
			int i = pstmt3.executeUpdate();
			return i;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
