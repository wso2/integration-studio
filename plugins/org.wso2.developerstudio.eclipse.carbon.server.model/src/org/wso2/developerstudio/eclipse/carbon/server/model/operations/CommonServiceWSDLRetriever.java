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

package org.wso2.developerstudio.eclipse.carbon.server.model.operations;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.w3c.dom.Document;
import org.wso2.developerstudio.eclipse.carbon.server.model.Activator;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.xml.sax.SAXException;

public class CommonServiceWSDLRetriever implements Runnable {
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	private int MAX_RUN_TIME = 300000;
	private int SLEEP_STEP = 2000;
	private IPath path;
	private URL url;
	private boolean stop = false;
	private static Map<String, IProject> serviceWSDLRetrievers = new HashMap<String, IProject>();
	private int delayRetrive = 0;

	protected CommonServiceWSDLRetriever(IPath path, URL url, int delay) {
		this.setPath(path);
		this.setUrl(url);
		this.setDelayRetrive(delay);
	}

	public void run() {
		int total = 0;
		boolean found = false;
		try {
			Thread.sleep(getDelayRetrive() * 1000);
		} catch (InterruptedException e1) {
			log.error(e1);
		}
		while (total < MAX_RUN_TIME) {
			try {
				Thread.sleep(SLEEP_STEP);
			} catch (InterruptedException e) {
				log.error(e);
			}
			if (isStop())
				break;
			try {
				URLConnection openConnection = getUrl().openConnection();
				DocumentBuilder parser = DocumentBuilderFactory.newInstance().newDocumentBuilder();
				Document document = parser.parse(openConnection.getInputStream());
				if (document.getDocumentElement().getTagName().equals("wsdl:definitions")) {
					found = true;
					openConnection.getInputStream().close();
					break;
				}
				openConnection.getInputStream().close();
			} catch (IOException e) {
				log.error(e);
			} catch (SAXException e) {
				log.error(e);
			} catch (ParserConfigurationException e) {
				log.error(e);
			}
			total += SLEEP_STEP;
		}
		if (found) {
			try {
				URLConnection openConnection = getUrl().openConnection();
				DocumentBuilder parser = DocumentBuilderFactory.newInstance().newDocumentBuilder();
				Document document = parser.parse(openConnection.getInputStream());
				new File(getPath().toOSString()).getParentFile().mkdirs();
				Result result = new StreamResult(new File(getPath().toOSString()));
				Source source = new DOMSource(document);
				Transformer t = TransformerFactory.newInstance().newTransformer();
				t.transform(source, result);
				openConnection.getInputStream().close();
			} catch (Exception e) {
				log.error(e);
			}
		}
		done(this);

	}

	public void setStop(boolean stop) {
		this.stop = stop;
	}

	public boolean isStop() {
		return stop;
	}

	public static void startWSDLRetriever(IPath path, URL url, IProject project) {
		startWSDLRetriever(path, url, project, 0);
	}

	public static void startWSDLRetriever(IPath path, URL url, IProject project, int delay) {
		if (!serviceWSDLRetrievers.containsKey(path.toOSString())) {
			CommonServiceWSDLRetriever thread;
			serviceWSDLRetrievers.put(path.toOSString(), project);
			thread = new CommonServiceWSDLRetriever(path, url, delay);
			new Thread(thread).start();
		}
	}

	private static void done(CommonServiceWSDLRetriever serviceWSDLRetriever) {
		if (serviceWSDLRetrievers.containsKey(serviceWSDLRetriever.getPath().toOSString())) {
			IProject project = serviceWSDLRetrievers.get(serviceWSDLRetriever.getPath().toOSString());
			serviceWSDLRetrievers.remove(serviceWSDLRetriever.getPath().toOSString());
			try {
				project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
			} catch (CoreException e) {
				log.error(e);
			}
		}
	}

	public void setPath(IPath path) {
		this.path = path;
	}

	public IPath getPath() {
		return path;
	}

	public void setUrl(URL url) {
		this.url = url;
	}

	public URL getUrl() {
		return url;
	}

	public void setDelayRetrive(int delayRetrive) {
		this.delayRetrive = delayRetrive;
	}

	public int getDelayRetrive() {
		return delayRetrive;
	}
}
