/*
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
package org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import org.wso2.developerstudio.eclipse.gmf.esb.diagram.Activator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.IESBDebugger;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.IESBDebuggerInterface;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.channel.dispatcher.ChannelEventDispatcher;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.channel.dispatcher.ChannelResponseDispatcher;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.channel.messagefactory.ICommunicationMessageFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.channel.messagefactory.impl.JsonGsonMessageFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.messages.command.CommandMessage;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.messages.command.GetPropertyCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.messages.util.AbstractESBDebugPointMessage;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

/**
 * This class handles the communication between ESB Server and
 * {@link ESBDebugger}
 *
 */
public class ESBDebuggerInterface implements IESBDebuggerInterface {

	private Socket requestSocket;
	private PrintWriter requestWriter;
	private BufferedReader requestReader;

	private Socket eventSocket;
	private BufferedReader eventReader;

	private ChannelEventDispatcher eventDispatcher;
	private ChannelResponseDispatcher responseDispatcher;

	private ICommunicationMessageFactory messageFactory;
	private IESBDebugger esbDebugger;

	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	public ESBDebuggerInterface(int commandPort, int eventPort, String hostName)
			throws IOException {
		setRequestSocket(commandPort, hostName);
		setEventSocket(eventPort, hostName);
		setEventReader();
		setRequestReader();
		setRequestWriter();
		intializeDispatchers();
	}

	private void intializeDispatchers() {

		eventDispatcher = new ChannelEventDispatcher(getEventReader(), this);
		eventDispatcher.start();

		responseDispatcher = new ChannelResponseDispatcher(getRequestReader(),
				this);
		responseDispatcher.start();

		messageFactory = new JsonGsonMessageFactory();
	}

	@Override
	public void setEventDispatcher(ChannelEventDispatcher eventDispatcher) {
		this.eventDispatcher = eventDispatcher;
	}

	@Override
	public ChannelResponseDispatcher getResponseDispatcher() {
		return responseDispatcher;
	}

	@Override
	public void setResponseDispatcher(
			ChannelResponseDispatcher responceDispatcher) {
		this.responseDispatcher = responceDispatcher;
	}

	@Override
	public void sendCommand(CommandMessage command) throws Exception {
		requestWriter.println(messageFactory.createCommand(command));
		requestWriter.flush();
	}

	/**
	 * This method notify ESB Debugger about the event message got from ESB
	 * Server
	 * 
	 * @param eventMessage
	 */
	public void notifyEvent(String eventMessage) {
		try {
			esbDebugger.notifyEvent(messageFactory
					.convertEventToIEventMessage(eventMessage));
			System.out.println(eventMessage);
		} catch (Exception e) {
			log.error(
					"Error while converting Event message from ESB Server to IEventMessage : "
							+ e.getMessage(), e);
		}
	}

	@Override
	public void attachDebugger(IESBDebugger esbDebugger) {
		this.esbDebugger = esbDebugger;
	}

	/**
	 * This method notify ESB Debugger about the response message got from ESB
	 * Server
	 * 
	 * @param responseMessage
	 */
	public void notifyResponce(String responseMessage) {
		try {
			esbDebugger.notifyResponce(messageFactory
					.convertResponseToIResponseMessage(responseMessage));
			System.out.println(responseMessage);
		} catch (Exception e) {
			log.error(
					"Error while converting Response message from ESB Server to IResponseMessage : "
							+ e.getMessage(), e);
		}

	}

	@Override
	public void sendGetPropertiesCommand(GetPropertyCommand getPropertyCommand)
			throws Exception {
		requestWriter.println(messageFactory
				.createGetPropertiesCommand(getPropertyCommand));
		requestWriter.flush();
	}

	@Override
	public void sendBreakpointCommand(AbstractESBDebugPointMessage debugPoint)
			throws Exception {
		System.out.println(messageFactory.createBreakpointCommand(debugPoint));
		requestWriter.println(messageFactory
				.createBreakpointCommand(debugPoint));
		requestWriter.flush();

	}

	@Override
	public void terminate() throws IOException {
		eventDispatcher.stop();
		responseDispatcher.stop();
		requestSocket.close();
		eventSocket.close();
		requestReader.close();
		requestWriter.close();
		eventReader.close();
	}

	@Override
	public void setRequestSocket(int commandPort, String hostName)
			throws IOException {
		this.requestSocket = new Socket(hostName, commandPort);
	}

	@Override
	public void setRequestWriter() throws IOException {
		this.requestWriter = new PrintWriter(requestSocket.getOutputStream());
	}

	@Override
	public void setRequestReader() throws IOException {
		this.requestReader = new BufferedReader(new InputStreamReader(
				requestSocket.getInputStream()));
	}

	@Override
	public void setEventSocket(int eventPort, String hostName)
			throws IOException {
		this.eventSocket = new Socket(hostName, eventPort);
	}

	@Override
	public void setEventReader() throws IOException {
		this.eventReader = new BufferedReader(new InputStreamReader(
				eventSocket.getInputStream()));
	}

	@Override
	public PrintWriter getRequestWriter() {
		return requestWriter;
	}

	@Override
	public BufferedReader getRequestReader() {
		return requestReader;
	}

	@Override
	public BufferedReader getEventReader() {
		return eventReader;
	}

	@Override
	public ChannelEventDispatcher getEventDispatcher() {
		return eventDispatcher;
	}

}
