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

package org.wso2.developerstudio.eclipse.platform.core.bundle;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.apache.axiom.om.OMDocument;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.impl.builder.StAXOMBuilder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.core.Activator;
import org.wso2.developerstudio.eclipse.platform.core.manifest.AbstractXMLDoc;

public class BundlesDataInfo extends AbstractXMLDoc {
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	private Map<String, List<String>> exportedPackageListsFromJar = new HashMap<String, List<String>>();
	private Map<IProject, List<String>> exportedPackageListsFromProject = new HashMap<IProject, List<String>>();
	private String fragmentHost = null;

	public String getFragmentHost() {
		return fragmentHost;
	}

	public void setFragmentHost(String fragmentHost) {
		this.fragmentHost = fragmentHost;
	}

	protected String getDefaultName() {
		return null;
	}

	public void createJarElement(String jarFileName, ArrayList<String> exportedPackagesList) throws Exception {
		getExportedPackageListsFromJar().put(jarFileName, exportedPackagesList);
	}

	public void createProjectElement(IProject project, ArrayList<String> exportedPackagesList) throws Exception {
		getExportedPackageListsFromProject().put(project, exportedPackagesList);
	}

	public void loadFromFile(File file) throws FactoryConfigurationError, Exception {
		deserialize(new FileInputStream(file));
	}

	public void deserialize(InputStream stream) throws XMLStreamException, FactoryConfigurationError {
		XMLStreamReader parser = XMLInputFactory.newInstance().createXMLStreamReader(stream);
		StAXOMBuilder builder = new StAXOMBuilder(parser);
		OMElement documentElement = builder.getDocumentElement();
		deserialize(documentElement);
	}

	protected void deserialize(OMElement documentElement) {
		String fragmentHostAttribute = getAttribute(documentElement, "fragment-host");
		setFragmentHost(fragmentHostAttribute);
		List<OMElement> childElements = getChildElements(documentElement, "jar");
		for (OMElement element : childElements) {
			String jarName = getAttribute(element, "name");
			List<String> packages = new ArrayList<String>();
			List<OMElement> exportPackagesElements = getChildElements(element, "export-packages");
			for (OMElement exportPackages : exportPackagesElements) {
				List<OMElement> exportPackageElements = getChildElements(exportPackages, "export-package");
				for (OMElement packageElement : exportPackageElements) {
					packages.add(packageElement.getText());
				}
			}
			getExportedPackageListsFromJar().put(jarName, packages);
		}
		childElements = getChildElements(documentElement, "project");
		for (OMElement element : childElements) {
			String projectName = getAttribute(element, "name");
			List<String> packages = new ArrayList<String>();
			List<OMElement> exportPackagesElements = getChildElements(element, "export-packages");
			for (OMElement exportPackages : exportPackagesElements) {
				List<OMElement> exportPackageElements = getChildElements(exportPackages, "export-package");
				for (OMElement packageElement : exportPackageElements) {
					packages.add(packageElement.getText());
				}
			}
			IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
			if (project != null) {
				getExportedPackageListsFromProject().put(project, packages);
			}
		}
	}

	public Map<String, List<String>> getExportedPackageListsFromJar() {
		return exportedPackageListsFromJar;
	}

	public void setExportedPackageListsFromProject(Map<IProject, List<String>> exportedPackageListsFromProject) {
		this.exportedPackageListsFromProject = exportedPackageListsFromProject;
	}

	public Map<IProject, List<String>> getExportedPackageListsFromProject() {
		return exportedPackageListsFromProject;
	}

	protected String serialize() {
		String result = null;
		OMDocument document = factory.createOMDocument();
		OMElement documentElement = getDocumentElement();
		document.addChild(documentElement);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		try {
			prettify(documentElement, outputStream);
		} catch (XMLStreamException e) {
			log.error(e.getMessage(), e);
			return null;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return null;
		}
		result = outputStream.toString();
		return result;
	}

	private OMElement getDocumentElement() {
		OMElement documentElement = getElement("libraries", "");
		if (getFragmentHost() != null && !getFragmentHost().trim().equals("")) {
			addAttribute(documentElement, "fragment-host", getFragmentHost().trim());
		}
		for (String jarFileName : getExportedPackageListsFromJar().keySet()) {
			OMElement jarElement = getElement("jar", "");
			addAttribute(jarElement, "name", jarFileName);
			OMElement exportPac = getElement("export-packages", "");
			jarElement.addChild(exportPac);
			List<String> exportedPackagesList = getExportedPackageListsFromJar().get(jarFileName);
			for (String p : exportedPackagesList) {
				exportPac.addChild(getElement("export-package", p));
			}
			documentElement.addChild(jarElement);
		}

		for (IProject project : getExportedPackageListsFromProject().keySet()) {
			OMElement projectElement = getElement("project", "");
			addAttribute(projectElement, "name", project.getName());
			OMElement exportPac = getElement("export-packages", "");
			projectElement.addChild(exportPac);
			List<String> exportedPackagesList = getExportedPackageListsFromProject().get(project);
			for (String p : exportedPackagesList) {
				exportPac.addChild(getElement("export-package", p));
			}
			documentElement.addChild(projectElement);
		}
		return documentElement;
	}

}
