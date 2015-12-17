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
 * This class manages the event communication between {@link ESBDebugger} and {@link ESBDebuggerInterface}
 *
 */
public class ChannelEventDispatcher implements Runnable {

    private BufferedReader eventReader;
    private ESBDebuggerInterface esbDebuggerInterface;
    private volatile Thread eventDispatcherThread;
    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

    public ChannelEventDispatcher(BufferedReader eventReader, ESBDebuggerInterface esbDebuggerInterface) {
        this.eventReader = eventReader;
        this.esbDebuggerInterface = esbDebuggerInterface;
    }

    @Override
    public void run() {
        Thread currentThread = Thread.currentThread();
        try {
            while (currentThread == eventDispatcherThread) {
                String buffer = null;
                synchronized (eventReader) {
                    buffer = eventReader.readLine();
                }
                esbDebuggerInterface.notifyEvent(buffer);
            }
        } catch (IOException ex) {
            log.error("Error occured during reading event message sent from ESB Server Debugger", ex);
        }
    }

    public void start() {
        eventDispatcherThread = new Thread(this);
        eventDispatcherThread.start();
    }

    public void stop() {
        eventDispatcherThread = null;
        synchronized (this) {
            notifyAll();
        }
    }

}
