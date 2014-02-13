/*
 * Copyright (c) 2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.maven.capp.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.impl.builder.StAXOMBuilder;
import org.apache.maven.plugin.MojoExecutionException;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;
import org.wso2.maven.core.model.AbstractXMLDoc;

public class BundlesDataInfo extends AbstractXMLDoc {
	private static final String EXPORT_PACKAGES_TAG = "export-packages";
	private static final String EXPORT_PACKAGE_TAG = "export-package";
	
	private List<ProjectMapping> projects;
	private List<LibraryArtifact> libraries;
	private File base;
	
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

	public void loadFromFile(File file) throws FactoryConfigurationError, Exception {
		setBase(file.getParentFile());
		deserialize(new FileInputStream(file));
	}

	public void deserialize(InputStream stream) throws FactoryConfigurationError, Exception {
		XMLStreamReader parser = XMLInputFactory.newInstance()
				.createXMLStreamReader(stream);
		StAXOMBuilder builder = new StAXOMBuilder(parser);
		OMElement documentElement = builder.getDocumentElement();
		deserialize(documentElement);
	}

	protected void deserialize(OMElement documentElement) throws Exception{
		try {
			String fragmentHostAttribute = getAttribute(documentElement, "fragment-host");
			setFragmentHost(fragmentHostAttribute);
			List<OMElement> childElements = getChildElements(documentElement, "jar");
			for (OMElement element : childElements) {
				String jarName = getAttribute(element, "name");
				addJarToList(jarName, element);
			}
			
			childElements = getChildElements(documentElement, "project");
			for (OMElement element : childElements) {
				String projectName = getAttribute(element, "name");
				addProjectToList(projectName, element);
			}
		} catch (IOException e) {
			throw new Exception("Error occured while trying to process libraries in the bundle data info file.",e);
		}
	}

	public void addJarToList(String jarName, OMElement jarElement) {
		String[] jarPath = jarName.split("/");
		File fileLocation=getBase();
		for (String pathSegment : jarPath) {
			fileLocation=new File(fileLocation,pathSegment);
		}
		LibraryArtifact libraryArtifact = new LibraryArtifact("dummy.groupid", jarPath[jarPath.length-1], "1.0.0",fileLocation);
		if (jarElement!=null) {
//			List<OMElement> exportPackagesElements = getChildElements(jarElement, EXPORT_PACKAGES_TAG);
//			for (OMElement exportPackages : exportPackagesElements) {
				List<OMElement> exportPackageElements = getChildElements(jarElement, EXPORT_PACKAGE_TAG);
				for (OMElement packageElement : exportPackageElements) {
					libraryArtifact.getPackages().add(packageElement.getText());
				}
//			}
		}
		if (libraryArtifact.getPackages().size()==0){
			//TODO add packages in the jar to the library artifact
			//addPackagesToLibraryArtifact(libraryArtifact, artifactFile);
		}
		getLibraries().add(libraryArtifact);
	}

	public void addProjectToList(String projectName, OMElement projectElement)
			throws MojoExecutionException, IOException {
		ProjectMapping projectMapping = getProjectMapping(projectName);
		if (projectMapping != null){
			LibraryArtifact libraryArtifact = new LibraryArtifact(projectMapping.getGroupId(), projectMapping.getArtifactId(), projectMapping.getVersion());
			if (projectElement!=null) {
//				List<OMElement> exportPackagesElements = getChildElements(projectElement, EXPORT_PACKAGES_TAG);
//				for (OMElement exportPackages : exportPackagesElements) {
					List<OMElement> exportPackageElements = getChildElements(projectElement, EXPORT_PACKAGE_TAG);
					for (OMElement packageElement : exportPackageElements) {
						libraryArtifact.getPackages().add(packageElement.getText());
					}
//				}
			}
			if (libraryArtifact.getPackages().size()==0) {
				File artifactFile = libraryArtifact.getArtifactFile();
				addPackagesToLibraryArtifact(libraryArtifact, artifactFile);
			}
			getLibraries().add(libraryArtifact);
		}
	}

	private void addPackagesToLibraryArtifact(LibraryArtifact libraryArtifact,
			File artifactFile) throws IOException {
		if (artifactFile!=null) {
			Map<File, ArrayList<String>> processJarList = FileUtils.processJarList(new File[] { artifactFile });
			for (ArrayList<String> packageList : processJarList.values()) {
				libraryArtifact.getPackages().addAll(packageList);
			}
		}
	}

	private ProjectMapping getProjectMapping(String projectName){
		for (ProjectMapping mapping : getProjects()) {
			if (mapping.getProjectName().equals(projectName)){
				return mapping;
			}
		}
		return null;
	}

	protected String serialize() {
		return null;
	}

	public List<LibraryArtifact> getLibraries() {
		if (libraries==null){
			libraries=new ArrayList<LibraryArtifact>();
		}
		return libraries;
	}

	public void setBase(File base) {
		this.base = base;
	}

	public File getBase() {
		return base;
	}

	public List<String> getAllPackages(){
		List<String> allPackages=new ArrayList<String>();
		List<LibraryArtifact> libraries = getLibraries();
		for (LibraryArtifact libraryArtifact : libraries) {
			List<String> packages = libraryArtifact.getPackages();
			for (String packageString : packages) {
				if (!allPackages.contains(packageString)){
					allPackages.add(packageString);
				}
			}
		}
		return allPackages;
	}
	
	public String getAllPackagesString(){
		StringBuffer sb=new StringBuffer();
		List<String> allPackages = getAllPackages();
		for (String packageString : allPackages) {
			if (("".equals(sb.toString()))) {
				sb.append(packageString);
			}else{
				sb.append(",").append(packageString);
			}
		}
		return sb.toString();
	}

	public void setProjects(List<ProjectMapping> projects) {
		this.projects = projects;
	}

	public List<ProjectMapping> getProjects() {
		return projects;
	}
}
