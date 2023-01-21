package com.pages;

import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dal.UserDALImpl;
import com.pojo.User;
import com.utils.DBUtils;

@WebServlet("Registration")
public class RegistrationServlet extends HttpServlet{
	UserDALImpl userDao;
	public void init(ServletConfig config) {
		System.out.println("inside init");
		try {
			DBUtils.openConnction();
			userDao=new UserDALImpl();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	public void destroy() {
		System.out.println("inside destroy");
		try {
			DBUtils.closeConnection();
			userDao.cleanUp();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) {
		System.out.println("inside post");
		response.setContentType("text/html");
		try(PrintWriter pr=response.getWriter()){
			String username=request.getParameter("username");
			String email=request.getParameter("email");
			String city=request.getParameter("city");
			String password=request.getParameter("password");
			userDao.AddUser(new User(username, email, password, city));
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
