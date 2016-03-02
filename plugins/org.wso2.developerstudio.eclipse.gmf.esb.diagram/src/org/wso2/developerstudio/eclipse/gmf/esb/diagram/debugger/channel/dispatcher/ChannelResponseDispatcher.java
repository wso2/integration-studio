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
package org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.channel.dispatcher;

import java.io.BufferedReader;
import java.io.IOException;

import org.wso2.developerstudio.eclipse.gmf.esb.diagram.Activator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.impl.ESBDebuggerInterface;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

/**
 * This class manages the responses communication between {@link ESBDebugger} and {@link ESBDebuggerInterface}
 *
 */
public class ChannelResponseDispatcher implements Runnable {

    private BufferedReader requestReader;
    private ESBDebuggerInterface esbDebuggerInterface;
    private volatile Thread responseDispatcherThread;

    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

    public ChannelResponseDispatcher(BufferedReader requestReader, ESBDebuggerInterface esbDebuggerInterface) {
        this.requestReader = requestReader;
        this.esbDebuggerInterface = esbDebuggerInterface;
    }

    @Override
    public void run() {
        Thread currentThread = Thread.currentThread();
        try {
            while (currentThread == responseDispatcherThread) {
                String buffer = null;
                synchronized (requestReader) {
                    buffer = requestReader.readLine();
                }
                esbDebuggerInterface.notifyResponce(buffer);
            }
        } catch (IOException ex) {
            log.error("Error occured during reading response message sent from ESB Server Debugger", ex);
        }
    }

    public void start() {
        responseDispatcherThread = new Thread(this);
        responseDispatcherThread.start();
    }

    public void stop() {
        responseDispatcherThread = null;
        synchronized (this) {
            notifyAll();
        }
    }
}
