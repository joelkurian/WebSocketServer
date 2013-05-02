package com.leoj.glitch.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.leoj.glitch.pojo.User;
import com.leoj.glitch.utils.UtilConstants;

public class SignInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SignInServlet() {
		super();

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

		String email = request.getParameter("email");
		String passwd = request.getParameter("passwd");

		PrintWriter writer = response.getWriter();

		if (email != null && passwd != null) {
			Session s = UtilConstants.sessionFactory.openSession();
			s.beginTransaction();
			Criteria c = s.createCriteria(User.class);
			c.add(Restrictions.eq("email", email)).add(Restrictions.eq("passwd", passwd)).setProjection(Projections.rowCount());
			long count = (long) c.uniqueResult();
			if (count > 0) {
				HttpSession httpSession = request.getSession();
				response.sendRedirect("devices.jsp");
			} else {
				writer.write("invalid username/password");
			}
		}

	}
}
