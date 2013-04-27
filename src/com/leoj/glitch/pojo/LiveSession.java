/**
 * 
 */
package com.leoj.glitch.pojo;

import org.jboss.netty.channel.Channel;

/**
 * @author joel
 * 
 */
public class LiveSession {

	public static int sessionCount = 0;

	private int id = 0;
	private Channel serverChannel = null;
	private Channel clientChannel = null;

	public LiveSession() {
		this.id = sessionCount++;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Channel getServerChannel() {
		return serverChannel;
	}

	public void setServerChannel(Channel serverChannel) {
		this.serverChannel = serverChannel;
	}

	public Channel getClientChannel() {
		return clientChannel;
	}

	public void setClientChannel(Channel clientChannel) {
		this.clientChannel = clientChannel;
	}

}
