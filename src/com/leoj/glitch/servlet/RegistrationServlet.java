package com.leoj.glitch.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.leoj.glitch.pojo.User;
import com.leoj.glitch.utils.UtilConstants;

@WebServlet({ "/RegistrationServlet", "/Register" })
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegistrationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		UtilConstants.setConstants(getServletContext().getRealPath(""));
		super.init();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Session s = null;
		try {
			SessionFactory sf = UtilConstants.sessionFactory;
			s = sf.openSession();
			s.beginTransaction();
			String email = request.getParameter("email");
			String passwd = request.getParameter("passwd");
			if (email != null && passwd != null) {
				User u = new User();
				u.setEmail(email);
				u.setPasswd(passwd);
				s.save(u);
				response.sendRedirect("index.jsp");
			}
			s.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			s.close();
		}
	}

}
