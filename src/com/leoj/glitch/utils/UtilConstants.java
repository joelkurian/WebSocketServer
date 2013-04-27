package com.leoj.glitch.utils;

import org.hibernate.SessionFactory;

public class UtilConstants {
	public static String rootPath;
	public static SessionFactory sessionFactory;

	public static void setConstants(String realPath) {
		rootPath = realPath.replace("\\", "/");
		sessionFactory = HibernateUtil.getSessionFactory();
	}
}
