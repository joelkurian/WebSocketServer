package org.tomcatnetty;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.jboss.netty.example.http.websocketx.server.WebSocketServer;

import com.netiq.websockify.Websockify;

/**
 * Application Lifecycle Listener implementation class NettyWebSocketServer
 * 
 */
@WebListener
public class NettyWebSocketServer implements ServletContextListener {

	/**
	 * Default constructor.
	 */
	public NettyWebSocketServer() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent arg0) {
		// new WebSocketServer(8000);
		Websockify websockify = new Websockify();
		try {
			websockify.doMain(null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
	}

}
