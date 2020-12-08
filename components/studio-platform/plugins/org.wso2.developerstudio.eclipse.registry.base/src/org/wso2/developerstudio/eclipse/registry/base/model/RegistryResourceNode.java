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

package org.wso2.developerstudio.eclipse.registry.base.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.eclipse.core.resources.IFile;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPerspectiveDescriptor;
import org.eclipse.ui.IPropertyListener;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.wso2.carbon.registry.core.Collection;
import org.wso2.carbon.registry.core.Resource;
import org.wso2.carbon.registry.core.exceptions.RegistryException;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.registry.base.Activator;
import org.wso2.developerstudio.eclipse.registry.base.core.Registry;
import org.wso2.developerstudio.eclipse.registry.base.editor.input.ResourceEditorInput;
import org.wso2.developerstudio.eclipse.registry.core.exception.InvalidRegistryURLException;
import org.wso2.developerstudio.eclipse.registry.core.exception.RegistryContentRetrieveException;
import org.wso2.developerstudio.eclipse.registry.core.exception.UnknownRegistryException;
import org.wso2.developerstudio.eclipse.registry.resource.authorization.ResourceAdmin;


public class RegistryResourceNode implements Cloneable {
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	private RegistryResourceNode registryResourceNodeParent;
	private boolean iterativeRefresh = false;
	private boolean error = false;
	private ArrayList<RegistryResourceNode> resourceNodeList;
	private RegistryNode connectionInfo;
	private String mediaType;
	private boolean allowExapand = true;
	private boolean dirty;
	private List<String> versions;
	private Map<String, VersionContent> retrievedVersionsContent;
	private IEditorPart editor;
	private RegistryResourceType registryResource = RegistryResourceType.UNDEFINED;
	private String resourceName;
	private String oldPath;
	private String newPath;
	private Boolean hasWritePermissions=null;
	private boolean ismodifiyed ;
	private boolean isdeleted;
	private boolean isnew;
	private boolean rename;
	private File newFile;
	private IFile workspaceFile;
	
	public void setRegistryResource(RegistryResourceType registryResource) {
		this.registryResource = registryResource;
	}

	/**
	 * RegistryResourceNode constructor
	 * 
	 * @param registryData
	 * @param registryResourcePath
	 * @param registryResourceNodoParent
	 */
	public RegistryResourceNode(RegistryNode registryData,
			String registryResourcePath,
			RegistryResourceNode registryResourceNodoParent) {
		setConnectionInfo(registryData);
		if (registryResourceNodoParent==null){
			setResourceName(registryResourcePath);
		}else{
			setResourceName(getNameofTheResource(registryResourcePath));
		}
		setRegistryResourceNodeParent(registryResourceNodoParent);
	}

	/**
	 * RegistryResourceNode constructor
	 * 
	 * @param resourcePathList
	 */
	public RegistryResourceNode(ArrayList<RegistryResourceNode> resourcePathList) {
		this.resourceNodeList = resourcePathList;
	}

	/**
	 * add child RegistryResourceNode to resourceNodeList
	 * 
	 * @param child
	 */
	public void addChildResource(RegistryResourceNode child) {
		if (resourceNodeList == null) {
			resourceNodeList = new ArrayList<RegistryResourceNode>();
		}
		
		resourceNodeList.add(child);
	}

	private static String getNameofTheResource(String path) {
		String[] split = path.split("/");
		if (split.length == 0) {
			return path;
		} else {
			return split[split.length - 1];
		}
	}
	
	public boolean rename(){
		if(rename){
			if(newPath!=null && oldPath!=null){
				Registry registry = this.getConnectionInfo().getRegistry();
				try {
					registry.rename(oldPath, newPath);
					//rename = false;
					return true;
				} catch (InvalidRegistryURLException e) {
					log.error("Renaming opertaion failed due to"+e.getMessage(), e);
				} catch (UnknownRegistryException e) {
					log.error("Renaming opertaion failed due to"+e.getMessage(), e);
				}
			}
		}
		return false;
	}
	
	/**
	 * get ResourceNodeList which contains selected RegistryResourceNode object
	 * of the tree view
	 * 
	 * @return
	 * @throws UnknownRegistryException
	 * @throws InvalidRegistryURLException
	 */
	private ArrayList<RegistryResourceNode> getRemoteResourceNodeList() throws InvalidRegistryURLException,
			UnknownRegistryException {
		/**
		 * initially setError should be set false. Content provider and label provider is called only when setError is
		 * set to false
		 */
		setError(false);
		if (resourceNodeList == null || iterativeRefresh) {
			Registry registry = getConnectionInfo().getRegistry();
			if (registry == null) {
				setError(true);
				return null;
			}

			Resource resourcesPerCollection = registry.getResourcesPerCollection(getRegistryResourcePath());
			resourceNodeList = new ArrayList<RegistryResourceNode>();
			if (resourcesPerCollection instanceof Collection) {
				Collection collec = (Collection) resourcesPerCollection;
				try {
					String[] children = collec.getChildren();
					for (String childPath : children) {
						resourceNodeList.add(new RegistryResourceNode(getConnectionInfo(), childPath, this));
					}
					setRegistryResource(RegistryResourceType.COLLECTION);
				} catch (RegistryException e) {
					setRegistryResource(RegistryResourceType.UNDEFINED);
					throw new UnknownRegistryException("Error while retrieving registry collection children paths: "
							+ e.getMessage(), e);
				}

			} else {
				setRegistryResource(RegistryResourceType.UNDEFINED);
				getResourceType();
			}

			if (isIterativeRefresh()) {
				Display.getDefault().syncExec(new Runnable() {

					public void run() {
						for (RegistryResourceNode child : resourceNodeList) {
							child.setIterativeRefresh(true);
						}
					}
				});
				Display.getDefault().syncExec(new Runnable() {

					public void run() {
						setIterativeRefresh(false);
					}
				});
			}
		}
		return resourceNodeList;
	}
	
	public ArrayList<RegistryResourceNode> getResourceNodeList()
			throws InvalidRegistryURLException, UnknownRegistryException {		
		 if(resourceNodeList==null){
			 return getRemoteResourceNodeList();
		 }
		return resourceNodeList;
	}
	
	public ArrayList<RegistryResourceNode> getLocalResourceNodeList() {		
		 if(resourceNodeList==null){
			 return new ArrayList<RegistryResourceNode>();
		 } 
		return resourceNodeList;
	}
	
	/**
	 * add new selected tree items to registryResourceNodeList
	 * 
	 * @param nwResourceNodeList
	 */
	public void setResourceNodeList(ArrayList<RegistryResourceNode> nwResourceNodeList) {
		if (resourceNodeList != null) {
			for (int i = 0; i < nwResourceNodeList.size(); i++) {
				if (resourceNodeList.contains(nwResourceNodeList.get(i))) {
				} else {
					resourceNodeList.add(nwResourceNodeList.get(i));
				}
			}
		} else {
			resourceNodeList = nwResourceNodeList;
		}
	}

	/**
	 * get resource path of the selected tree item
	 * 
	 * @return
	 */
	public String getRegistryResourcePath() {
		String parent = getParent();
		String resourceName = getResourceName();
		return appendPath(parent, resourceName);
	}

	private String appendPath(String parent, String resourceName) {
		if (parent==null){
			return resourceName;
		}else{
		return parent + (parent.endsWith("/") ? 
				resourceName : 
				   "/" + resourceName);
		}
	}

	
   public void removeFromVersionContent(){
	   retrievedVersionsContent.remove(getResourceName());
   }
	/**
	 * return the caption for the tree item
	 */
	public String toString() {
		return getCaption();
	}

	/**
	 * if the selected tree item is a resource, return true
	 * 
	 * @return
	 */
	public RegistryResourceType getResourceType() {
		if (registryResource == RegistryResourceType.UNDEFINED) {
			Registry registry = getConnectionInfo().getRegistry();
			if(registry!=null){
			try {
				Resource resourceItem = registry
						.getResourcesPerCollection(getRegistryResourcePath());
				setMediaType(resourceItem.getMediaType());
				if (resourceItem instanceof Collection) {
					registryResource = RegistryResourceType.COLLECTION;
				}
				if (registryResource == RegistryResourceType.UNDEFINED) {
					if ("true".equalsIgnoreCase(resourceItem.getProperty("registry.link"))) {
						if ("true".equalsIgnoreCase(resourceItem.getProperty("registry.mount"))) {
							registryResource = RegistryResourceType.REMOTELINK;
						}else{
							registryResource = RegistryResourceType.SYMLINK;
						}
					} else {
						registryResource = RegistryResourceType.RESOURCE;
					}
				}
		 
			} catch (Exception e) {
				setError(true);
				log.error(e);
			}
		  }
		}
		return registryResource;
	}

	/**
	 * caption of the resource to display in the registry tree
	 * 
	 * @return
	 */
	public String getCaption() {
		return getLastSegmentInPath();
	}

	/**
	 * return the last part of the resource path when split with "/"
	 * 
	 * @return
	 */
	public String getLastSegmentInPath() {
		String[] split = getRegistryResourcePath().split("/");
		if (split.length == 0) {
			return getRegistryResourcePath();
		} else {
			return split[split.length - 1];
		}
	}
	
	public void putFile(){
		try{
		    Registry registry = getConnectionInfo().getRegistry();
			Resource resource = registry.newResource();
			resource.setDescription("");							
			InputStream is = new FileInputStream(newFile);
			resource.setContentStream(is);
			resource.setMediaType(getMediaType());				
		    registry.put(getRegistryResourcePath(), resource);
		    this.isnew = false;
		}catch(IOException | InvalidRegistryURLException | UnknownRegistryException | RegistryException e){
			log.error("Registry put has failed " +e.getMessage(),e);
		}
		
	}

	public File getNewFile() {
		return newFile;
	}

	public void setNewFile(File newFile) {
		this.newFile = newFile;
	}

	/**
	 * refresh registry tree when a new resource or collection added, updated or
	 * deleted resourceNodeList contains previous registryResourceNodeList
	 * 
	 * @throws UnknownRegistryException
	 * @throws InvalidRegistryURLException
	 */
	
	@SuppressWarnings("unchecked")
	public void refreshChildren() throws InvalidRegistryURLException, UnknownRegistryException {

		if (!isnew) {

			Registry registry = getConnectionInfo().getRegistry();
			Resource resource = registry.getResourcesPerCollection(getRegistryResourcePath());
			if (resource instanceof Collection) {
				Collection collec = (Collection) resource;
				ArrayList<String> newItemsList = new ArrayList<String>();
				ArrayList<RegistryResourceNode> registryResourceNodesClone;
				try {
					String[] children = collec.getChildren();
					registryResourceNodesClone = (ArrayList<RegistryResourceNode>) resourceNodeList.clone();
					for (String childPath : children) {
						boolean found = false;
						for (RegistryResourceNode registryResourceNode : registryResourceNodesClone) {
							String path = registryResourceNode.getRegistryResourcePath();
							if (childPath.equals(path)) {
								found = true;
								registryResourceNodesClone.remove(registryResourceNode);
								break;
							}
						}
						if (!found) {
							newItemsList.add(childPath);
							RegistryResourceNode regResNode = new RegistryResourceNode(connectionInfo, childPath, this);
							regResNode.setNew(true);
							if (!resourceNodeList.contains(regResNode)) {
								resourceNodeList.add(regResNode);
							}
						}
					}
				} catch (RegistryException e) {
					throw new UnknownRegistryException(
							"Error occured while retreiving registry collection children paths: " + e.getMessage(), e);
				}

				/**
				 * if there are items still left in the clone, which means it is deleted resource from registry, it
				 * should be removed from registryResourceNodeList
				 */
				for (int j = 0; j < registryResourceNodesClone.size(); j++) {
					RegistryResourceNode tempData = registryResourceNodesClone.get(j);
					resourceNodeList.remove(tempData);
				}

			}
		}

	}
	
	/**
	 * return RegistryData object
	 * 
	 * @return
	 */
	public RegistryNode getConnectionInfo() {
		return connectionInfo;
	}

	/**
	 * set the current RegistryData object
	 * 
	 * @param connectionInfo
	 */
	public void setConnectionInfo(RegistryNode connectionInfo) {
		this.connectionInfo = connectionInfo;
	}

	/**
	 * get the parent path of the resource
	 * 
	 * @return
	 */
	public String getParent() {
		return (getRegistryResourceNodeParent()==null? null:getRegistryResourceNodeParent().getRegistryResourcePath());
	}

	/**
	 * set parent of the registryResourceNode
	 * 
	 * @param registryResourceNodeParent
	 */
	public void setRegistryResourceNodeParent(
			RegistryResourceNode registryResourceNodeParent) {
		this.registryResourceNodeParent = registryResourceNodeParent;
	}

	/**
	 * get parent of the registryResourceNode
	 * 
	 * @return
	 */
	public RegistryResourceNode getRegistryResourceNodeParent() {
		return registryResourceNodeParent;
	}

	/**
	 * 
	 * @param iterativeRefresh
	 */
	public void setIterativeRefresh(boolean iterativeRefresh) {
		if (iterativeRefresh) {
			versions = null;
			if ((getResourceType() == RegistryResourceType.RESOURCE)
					&& retrievedVersionsContent != null
					&& retrievedVersionsContent.containsKey(getLatestVersion())) {
				getVersionContent(getLatestVersion(),
						getFile().getAbsolutePath()).updateChecksum();
			}
//			registryResource = RegistryResourceType.UNDEFINED;
			hasWritePermissions=null;
		}
		this.iterativeRefresh = iterativeRefresh;
	}

	/**
	 * check whether iterativeRefresh is enabled
	 * 
	 * @return
	 */
	public boolean isIterativeRefresh() {
		return iterativeRefresh;
	}

	/**
	 * set the error parameter
	 * 
	 * @param error
	 */
	public void setError(boolean error) {
		this.error = error;
	}

	/**
	 * return the value of the error variable
	 * 
	 * @return
	 */
	public boolean isError() {
		return error;
	}

	/**
	 * set media type for the resource
	 * 
	 * @param mediaType
	 */
	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}

	/**
	 * get media type for the resource
	 * 
	 * @return
	 */
	public String getMediaType() {
		return mediaType;
	}

	/**
	 * set the editor input for the latest version
	 * 
	 * @param editorInput
	 */
	public void setEditorInput(ResourceEditorInput editorInput) {
		setEditorInput(getLatestVersion(), editorInput);
	}

	/**
	 * get the editor input for the latest version
	 * 
	 * @return
	 */
	public ResourceEditorInput getEditorInput() {
		return getEditorInput(getLatestVersion());
	}

	/**
	 * set editor input for the given version
	 * 
	 * @param version
	 * @param editorInput
	 */
	public void setEditorInput(String version, ResourceEditorInput editorInput) {
		getVersionContent(version).setEditorInput(editorInput);
	}

	/**
	 * get editor input for the given version
	 * 
	 * @param version
	 * @return
	 */
	public ResourceEditorInput getEditorInput(String version) {
		VersionContent versionContent = getVersionContent(version);
		return (versionContent == null ? null : versionContent.getEditorInput());
	}

	/**
	 * set allowExapand variable to allow to be expanded
	 * 
	 * @param allowExapand
	 */
	public void setAllowExapand(boolean allowExapand) {
		this.allowExapand = allowExapand;
	}

	/**
	 * return allowExapand value
	 * 
	 * @return
	 */
	public boolean isAllowExapand() {
		return allowExapand;
	}

	/**
	 * get the versions of the resource
	 * 
	 * @return
	 * @throws UnknownRegistryException
	 * @throws InvalidRegistryURLException
	 */
	public List<String> getVersions() throws InvalidRegistryURLException,
			UnknownRegistryException {
		if (versions == null) {
			versions = new ArrayList<String>();
			String[] allVersions = getConnectionInfo().getRegistry()
					.getVersions(getRegistryResourcePath());
			if(null!=allVersions){
				for (String version : allVersions) {
					versions.add(version);
				}
			}
		}
		return versions;
	}

	/**
	 * return the versionContent of the given version
	 * 
	 * @param version
	 * @return
	 */
	public VersionContent getVersionContent(String version) {
		return getVersionContent(version, null);
	}

	/**
	 * get the content of the given version
	 * 
	 * @param version
	 * @param filePath
	 * @return
	 */
	public VersionContent getVersionContent(String version, String filePath) {
		
		VersionContent vc = null;
		if(!isnew && !rename){
		String versionName=getNameofTheResource(version);
		version=appendPath(getParent(), versionName);
		if (retrievedVersionsContent == null) {
			retrievedVersionsContent = new HashMap<String, VersionContent>();
		}
		 vc = null;
		if (!retrievedVersionsContent.containsKey(versionName)) {
			try {
				File content = null;
				if (getResourceType() == RegistryResourceType.RESOURCE) {
					content = getConnectionInfo()
							.getRegistry()
							.getContent(
									(getLatestVersion().equals(version)) ? getRegistryResourcePath()
											: version, filePath);
					if (!getLatestVersion().equals(version)) {
						content.setReadOnly();
					}
				}
				retrievedVersionsContent.put(versionName, new VersionContent(
						content, this, versionName));
			} catch (InvalidRegistryURLException e) {
				e.printStackTrace();
			} catch (UnknownRegistryException e) {
				e.printStackTrace();
			} catch (RegistryContentRetrieveException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (filePath != null) {
			vc = retrievedVersionsContent.get(versionName);
			try {
				vc.setFile(getConnectionInfo()
						.getRegistry()
						.getContent(
								(getLatestVersion().equals(version)) ? getRegistryResourcePath()
										: version, filePath));
			} catch (IOException e) {
				log.error(e);
			} catch (InvalidRegistryURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnknownRegistryException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RegistryContentRetrieveException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (vc == null){
			vc = retrievedVersionsContent.get(versionName);
			}
		} 
		return vc;
		
	}

	/**
	 * check whether the file has been changed locally
	 * 
	 * @return
	 */
	public boolean isFileLocallyModified() {
		if(isnew || rename){
			return true;
		}else{
			  VersionContent versionContent = getVersionContent(getLatestVersion());
			return versionContent.isFileChanged();
		}
	}

	/**
	 * return the file of the given version
	 * 
	 * @param version
	 * @return
	 */
	public File getFile(String version) {
		
		VersionContent versionContent = getVersionContent(version);
		if(versionContent!=null){
			return versionContent.getFile();
		}
		return null;
	}

	/**
	 * return the file of the given version and filepath
	 * 
	 * @param version
	 * @param filePath
	 * @return
	 */
	public File getFile(String version, String filePath) {
		return getVersionContent(version).getFile();
	}

	/**
	 * return the file of latest version
	 * 
	 * @return
	 */
	public File getFile() {
		if(this.isnew ||this.rename){
			return this.getNewFile();
		}
		return getFile(getLatestVersion());
	}
	
	public File getLocalFile() {
		
		 return getFile();
	}
	
	

	/**
	 * get the latest version
	 * 
	 * @return
	 */
	public String getLatestVersion() {
		return getRegistryResourcePath();
	}

	/**
	 * check whether the selected item is the latest version
	 * 
	 * @param version
	 * @return
	 */
	public boolean isLatestVersion(String version) {
		return getLatestVersion().equals(version);
	}
	
	/**
	 * checks if logged user has write permission to this resource node
	 * @return true if user has write permission, false if not
	 */
	public boolean hasWritePermissions() {
		if(hasWritePermissions!=null){
			return hasWritePermissions;
		}
		
		try {
				ResourceAdmin rsAd = this.getConnectionInfo().getResourceAdmin();
				hasWritePermissions=rsAd.checkWritePermissionPerResource(this.getRegistryResourcePath());
				return hasWritePermissions;
		} catch (Exception e) {
			log.error("Error occured while trying to get the permissions", e);
		}
		return false;
	}

	
	public boolean removeLocalContent(){
		InputStream contentStream=null;
		try {
		    contentStream = getConnectionInfo().getRegistry().get(getRegistryResourcePath()).getContentStream();		  
		    Files.copy(contentStream, getFile().toPath(),StandardCopyOption.REPLACE_EXISTING);
			return true;
		} catch (InvalidRegistryURLException e) {
			 log.error("Error while Connecting to registry due to "+e.getMessage(), e);
		} catch (UnknownRegistryException e) {
			 log.error("Error while Connecting to registry due to "+e.getMessage(), e);
		} catch (RegistryException e) {
			 log.error("Error while Connecting to registry due to "+e.getMessage(), e);
		} catch (IOException e) {
			 log.error("Error while Copying contents due to "+e.getMessage(), e);
		}finally{
			 if(contentStream!=null){
				 try {
					contentStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			 }
		}
		return false;
	}
	/**
	 * save the changes of the latest version to the registry
	 * 
	 * @throws UnknownRegistryException
	 * @throws InvalidRegistryURLException
	 */
	public void saveChangesToRegistry() throws InvalidRegistryURLException,
			UnknownRegistryException {
		File file = getFile();
		Resource resource;
		try {
			resource = getConnectionInfo().getRegistry()
					.get(getRegistryResourcePath());						
			resource.setContentStream(new FileInputStream(file));
		
			getConnectionInfo().getRegistry().put(getRegistryResourcePath(), resource);
			getVersionContent(getLatestVersion()).updateChecksum();
			versions = null;
		} catch (RegistryException e) {
			throw new UnknownRegistryException(
					"Error occured while setting content from file to the registry resource: "
							+ e.getMessage(), e);
		} catch (FileNotFoundException e) {
			throw new UnknownRegistryException(
					"Error occured while setting content from file to the registry resource: "
							+ e.getMessage(), e);
		}
	}

	/**
	 * restore the latest version to the given version
	 * 
	 * @param versionPath
	 * @throws UnknownRegistryException
	 * @throws InvalidRegistryURLException
	 * @throws MalformedURLException
	 * @throws RegistryException
	 */
	public void restoreToVersion(String versionPath)
			throws InvalidRegistryURLException, UnknownRegistryException {
		getConnectionInfo().getRegistry().restoreVersion(versionPath);
		versions = null;
		if (retrievedVersionsContent != null
				&& retrievedVersionsContent.containsKey(getLatestVersion())) {
			getVersionContent(getLatestVersion(), getFile().getAbsolutePath())
					.updateChecksum();
		}
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	/**
	 * 
	 * VersionContent class
	 * 
	 */
	public class VersionContent implements Cloneable{
		private File file;
		private long checksum;
		private ResourceEditorInput editorInput;
		private RegistryResourceNode registryResourceNode;
		private String versionName;

		/**
		 * VersionContent constructor
		 * 
		 * @param file
		 * @param registryResourcePathData
		 */
		public VersionContent(File file,
				RegistryResourceNode registryResourcePathData, String versionName) {
			setFile(file);
			setRegistryResourceNode(registryResourcePathData);
			if (getRegistryResourceNode().getResourceType() == RegistryResourceType.RESOURCE) {
				updateChecksum();
			}
			setVersionName(versionName);
		}

		@Override
		public Object clone() throws CloneNotSupportedException {
			// TODO Auto-generated method stub
			return super.clone();
		}
		/**
		 * calculate the checksum for the file
		 * 
		 * @return
		 */
		private long calculateCheckSum() {
			try {
				if (getRegistryResourceNode().getResourceType() == RegistryResourceType.COLLECTION) {
					return -1;
				}
				return FileUtils.checksumCRC32(getFile());
			} catch (IOException e) {
				log.error(e);
			}
			return 0;
		}

		/**
		 * check whether the file has been changed
		 * 
		 * @return
		 */
		public boolean isFileChanged() {
			return (calculateCheckSum() != getChecksum());
		}

		/**
		 * update the checksum of the file
		 */
		public void updateChecksum() {
			setChecksum(calculateCheckSum());
		}

		/**
		 * set the content file
		 * 
		 * @param file
		 */
		public void setFile(File file) {
			this.file = file;
		}

		/**
		 * 
		 * @return
		 */
		public File getFile() {
			if (file==null || !file.exists()){
				try {
					String version = appendPath(getParent(), getVersionName());
					file=getConnectionInfo()
					.getRegistry()
					.getContent(
							(getLatestVersion().equals(version)) ? getRegistryResourcePath()
									: version, null);
				} catch (InvalidRegistryURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UnknownRegistryException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (RegistryContentRetrieveException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return file;
		}
		
		
	

		/**
		 * set the checksum for the latest version
		 * 
		 * @param checksum
		 */
		public void setChecksum(long checksum) {
			this.checksum = checksum;
		}

		/**
		 * get the checksum of the latest version
		 * 
		 * @return
		 */
		public long getChecksum() {
			return checksum;
		}

		/**
		 * set editor input
		 * 
		 * @param editorInput
		 */
		public void setEditorInput(ResourceEditorInput editorInput) {
			this.editorInput = editorInput;
		}

		/**
		 * get editor input
		 * 
		 * @return
		 */
		public ResourceEditorInput getEditorInput() {
			return editorInput;
		}

		/**
		 * set RegistryResourceNode
		 * 
		 * @param registryResourceNode
		 */
		public void setRegistryResourceNode(
				RegistryResourceNode registryResourceNode) {
			this.registryResourceNode = registryResourceNode;
		}

		/**
		 * get the registryResourceNode of the current selected tree item
		 * 
		 * @return
		 */
		public RegistryResourceNode getRegistryResourceNode() {
			return registryResourceNode;
		}

		public void setVersionName(String versionName) {
			this.versionName = versionName;
		}

		public String getVersionName() {
			return versionName;
		}

	}

	/**
	 * set file editor
	 * 
	 * @param editor
	 */
	public void setFileEditor(IEditorPart editor) {

	  if(!isAPIMperspective()){		  
		if (editor != null && this.editor != editor) {
			this.editor = editor;
			editor.addPropertyListener(new IPropertyListener() {
				public void propertyChanged(Object arg0, int prop) {
					if (prop == IEditorPart.PROP_DIRTY
							&& isFileLocallyModified())
						try {
							saveChangesToRegistry();
						} catch (Exception e) {
							log.error(e);
						}
				}
			});
		}
		
	  }else{
		  this.editor = editor;
		  getFile();
	  }
		  
	}

	private boolean isAPIMperspective(){
		
		 IWorkbenchWindow workbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		 IPerspectiveDescriptor perspective = workbenchWindow.getActivePage().getPerspective();		
		if ("org.wso2.developerstudio.registry.remote.registry.apim.pespective".equals(perspective.getId())){
			return true;
		}
		return false;
	}
	
	public boolean isIsmodifiyed() {
		return ismodifiyed;
	}

	public void setIsmodifiyed(boolean ismodifiyed) {
		this.ismodifiyed = ismodifiyed;
	}

	/**
	 * get file editor
	 * 
	 * @return
	 */
	public IEditorPart getFileEditor() {
		return editor;
	}

	public void setResourceName(String resourceName) {
		if (retrievedVersionsContent!=null){
			Map<String, VersionContent> newRetrievedVersionsContent=new HashMap<String, VersionContent>();
			for (String resourceVersionKey : retrievedVersionsContent.keySet()) {
				VersionContent versionContent = retrievedVersionsContent.get(resourceVersionKey);
				String newVersionName = resourceVersionKey.replaceAll(Pattern.quote(this.resourceName), resourceName);
				versionContent.setVersionName(newVersionName);
				newRetrievedVersionsContent.put(newVersionName,versionContent);
			}
			retrievedVersionsContent=newRetrievedVersionsContent;
		}
		this.resourceName = resourceName;
	}

	public String getResourceName() {
		return resourceName;
	}

	public RegistryResourceNode getRegistryResourceNode(String path) throws InvalidRegistryURLException, UnknownRegistryException{
		if (getRegistryResourcePath().equals(path)){
			return this;
		}else if (path.startsWith(getRegistryResourcePath()+"/")){
			ArrayList<RegistryResourceNode> resourceNodeList2 = getResourceNodeList();
			for (RegistryResourceNode node : resourceNodeList2) {
				RegistryResourceNode path2 = node.getRegistryResourceNode(path);
				if (path2!=null){
					return path2;
				}
			}
		}
		return null;
	}

	public boolean isIsdeleted() {
		return isdeleted;
	}

	public void setIsdeleted(boolean isdeleted) {
		this.isdeleted = isdeleted;
	}

	public boolean isIsnew() {
		return isnew;
	}

	public String getNewPath() {
		return newPath;
	}

	public void setNewPath(String newPath) {
		this.newPath = newPath;
	}

	public String getOldPath() {
		return oldPath;
	}

	public void setOldPath(String oldPath) {
		this.oldPath = oldPath;
	}

	public void setNew(boolean nNew) {
		this.isnew = nNew;
	}

	public boolean isRename() {
		return rename;
	}

	public void setRename(boolean rename) {
		this.rename = rename;
	}

	public boolean isDirty() {
		return dirty;
	}

	public void setDirty(boolean dirty) {
		this.dirty = dirty;
	}

	public IFile getWorkspaceFile() {
		return workspaceFile;
	}

	public void setWorkspaceFile(IFile workspaceFile) {
		this.workspaceFile = workspaceFile;
	}


	
}
