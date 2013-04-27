/**
 * 
 */
package com.leoj.glitch.utils;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

import org.hibernate.JDBCException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.dialect.Dialect;
import org.hibernate.engine.SessionFactoryImplementor;

/**
 * @author joel.kurian
 * 
 */
public class HibernateUtil {

	public static Configuration configuration = getConfiguration();
	private static final SessionFactory sessionFactory = buildSessionFactory();

	/**
	 * @return SessionFactory
	 */
	private static SessionFactory buildSessionFactory() {
		try {
			return configuration.buildSessionFactory();
		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("Initial SessionFactory creation failed." + ex);
			ex.printStackTrace();
			throw new ExceptionInInitializerError(ex);
		}
	}

	private static Configuration getConfiguration() {
		Configuration configuration = null;
		try {
			Properties prop = new Properties();
			prop.load(new FileReader(new File(UtilConstants.rootPath + "/properties/mysql.properties")));
			configuration = new Configuration();
			configuration.setProperties(prop);
			configuration.addFile(new File(UtilConstants.rootPath + "/WEB-INF/classes/glitch.hbm.xml"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return configuration;
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void closeSessionFactory() {
		try {
			sessionFactory.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param e
	 *            JDBC Exception
	 * @return error Code.
	 */
	public static int handleDatabaseExceptions(JDBCException e) {
		int failureCause = 500;
		int errorCode = e.getErrorCode();
		System.out.println("DB Error code :: " + errorCode);
		final SessionFactoryImplementor sessionFactoryImplementor = (SessionFactoryImplementor) HibernateUtil.getSessionFactory();
		Dialect dialect = sessionFactoryImplementor.getSettings().getDialect();
		String dbDialect = dialect.getClass().getSimpleName();
		File propFile = null;
		Properties prop = new Properties();
		if (dbDialect.equals("CustomMySQLDialect")) {
			propFile = new File(UtilConstants.rootPath + "/properties/dberror/mysql.properties");
		} else if (dbDialect.equals("CustomPostgreSQLDialect")) {
			propFile = new File(UtilConstants.rootPath + "/properties/dberror/postgresql.properties");
		} else if (dbDialect.equals("CustomOracleDialect")) {
			propFile = new File(UtilConstants.rootPath + "/properties/dberror/oracle.properties");
		} else if (dbDialect.equals("CustomSQLServerDialect")) {
			propFile = new File(UtilConstants.rootPath + "/properties/dberror/sqlserver.properties");
		} else if (dbDialect.equals("CustomDB2Dialect")) {
			propFile = new File(UtilConstants.rootPath + "/properties/dberror/db2.properties");
		}
		try {
			prop.load(new FileReader(propFile));
			failureCause = Integer.parseInt(prop.getProperty(Integer.toString(errorCode)));
			System.out.println("General error code :: " + failureCause);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return failureCause;
	}
}
