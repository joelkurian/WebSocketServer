package com.netiq.websockify;

import static org.jboss.netty.channel.Channels.pipeline;

import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.socket.ClientSocketChannelFactory;

import com.netiq.websockify.WebSocketServer.SSLSetting;

public class WebSocketServerPipelineFactory implements ChannelPipelineFactory {

	private final ClientSocketChannelFactory cf;
	private final SSLSetting sslSetting;
	private final String keystore;
	private final String keystorePassword;
	private final String keystoreKeyPassword;
	private final String webDirectory;

	public WebSocketServerPipelineFactory(ClientSocketChannelFactory cf, SSLSetting sslSetting, String keystore, String keystorePassword, String keystoreKeyPassword, String webDirectory) {
		this.cf = cf;
		this.sslSetting = sslSetting;
		this.keystore = keystore;
		this.keystorePassword = keystorePassword;
		this.keystoreKeyPassword = keystoreKeyPassword;
		this.webDirectory = webDirectory;
	}

	public ChannelPipeline getPipeline() throws Exception {
		ChannelPipeline p = pipeline(); // Note the static import.
		p.addLast("manager", new HandlerManager(cf, sslSetting, keystore, keystorePassword, keystoreKeyPassword, webDirectory));
		return p;

	}

}
