/*
 * Copyright (c) 2010-2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.developerstudio.eclipse.platform.ui.utils;

import org.apache.commons.httpclient.params.HttpConnectionParams;
import org.apache.commons.httpclient.protocol.SecureProtocolSocketFactory;

import javax.net.SocketFactory;
import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class CustomSSLProtocolSocketFactory implements SecureProtocolSocketFactory {
	SSLContext ctx;

	public CustomSSLProtocolSocketFactory(SSLContext ctx) {
		this.ctx = ctx;
	}

	public Socket createSocket(final String host, final int port, final InetAddress localAddress, final int localPort,
	                           final HttpConnectionParams params) throws IOException {
		if (params == null) {
			throw new IllegalArgumentException("Parameters may not be null");
		}
		int timeout = params.getConnectionTimeout();
		SocketFactory socketfactory = ctx.getSocketFactory();
		if (timeout == 0) {
			return socketfactory.createSocket(host, port, localAddress, localPort);
		} else {
			Socket socket = socketfactory.createSocket();
			SocketAddress localaddr = new InetSocketAddress(localAddress, localPort);
			SocketAddress remoteaddr = new InetSocketAddress(host, port);
			socket.bind(localaddr);
			socket.connect(remoteaddr, timeout);
			return socket;
		}
	}

	public Socket createSocket(String host, int port, InetAddress clientHost, int clientPort) throws IOException {
		return ctx.getSocketFactory().createSocket(host, port, clientHost, clientPort);
	}

	public Socket createSocket(String host, int port) throws IOException {
		return ctx.getSocketFactory().createSocket(host, port);
	}

	public Socket createSocket(Socket socket, String host, int port, boolean autoClose) throws IOException {
		return ctx.getSocketFactory().createSocket(socket, host, port, autoClose);
	}

}