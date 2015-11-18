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

package org.wso2.developerstudio.eclipse.registry.manager.local.utils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.namespace.QName;

import org.apache.axiom.om.OMElement;
import org.eclipse.core.runtime.Path;
import org.wso2.carbon.registry.synchronization.SynchronizationException;
import org.wso2.carbon.registry.synchronization.message.MessageCode;
import org.wso2.registry.checkin.Checkin;
import org.wso2.registry.checkin.Checkout;
import org.wso2.registry.checkin.ClientOptions;
import org.wso2.registry.checkin.ClientOptions.RegistryType;
import org.wso2.registry.checkin.Update;
import org.wso2.registry.checkin.UserInputCode;
import org.wso2.registry.checkin.UserInteractor;
import org.wso2.carbon.registry.synchronization.Utils;
import org.wso2.developerstudio.eclipse.registry.core.exception.InvalidRegistryURLException;
import org.wso2.developerstudio.eclipse.registry.core.exception.RegistryContentRetrieveException;
import org.wso2.developerstudio.eclipse.registry.core.exception.UnknownRegistryException;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.core.registry.util.RegistryResourceUtils;
import org.wso2.developerstudio.eclipse.registry.manager.local.Activator;
import org.wso2.developerstudio.eclipse.registry.manager.local.bean.RemoteRegistryInfo;

public class RegistryCheckInClientUtils {
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);

	private static final QName LAST_MODIFIED_Q_NAME = new QName("lastModified");
	private static final QName LAST_UPDATER_Q_NAME = new QName("lastUpdater");
	private static final QName CREATED_TIME_Q_NAME = new QName("createdTime");
	private static final QName CREATOR_Q_NAME = new QName("creator");
	private static final QName IS_COLLECTION_Q_NAME = new QName("isCollection");
	private static final QName PATH_Q_NAME = new QName("path");
	private static final QName REGISTRY_URL_Q_NAME = new QName("registryUrl");
	private static final QName MD5_Q_NAME = new QName("md5");
	private static final QName STATUS_Q_NAME = new QName("status");
	
	private static final String META_PREFIX = "~";
	private static final String CONFLICT_SERVER_EXTENSION = ".server";
	private static final String CONFLICT_MINE_EXTENSION = ".mine";
	private static final String FOLDER_META_FILE = "~.xml";
	private static final String XML_EXTENSION = ".xml";
	private static final String META_EXTENSION = ".meta";
	
	public static final int RESOURCE_STATE_NOT_CONFLICT = -2;
	public static final int RESOURCE_STATE_NOT_RESOURCE = -1;
	public static final int RESOURCE_STATE_NORMAL = 0;
	public static final int RESOURCE_STATE_MODIFIED = 1;
	public static final int RESOURCE_STATE_DELETED = 2;
	public static final int RESOURCE_STATE_NEW = 3;
	public static final int RESOURCE_STATE_CONFLICT = 4;
	public static final int RESOURCE_STATE_CONFLICT_SERVER = 5;
	public static final int RESOURCE_STATE_CONFLICT_MINE = 6;
	public static final int RESOURCE_STATE_ERROR = 7;
	public static final int RESOURCE_STATE_ADDED = 8;

	/**
	 * Return the path to the metadata folder for a registry resource folder
	 * @param path Path to the registry resource folder
	 * @return metadata folder path
	 */
	private static File getMetadataFolderForFolder(String path) {
		File file = new File(path);
		return new File(file, META_EXTENSION);
	}

	/**
	 * Return the path to the metadata folder for a registry resource file
	 * @param path Path to the registry resource file
	 * @return metadata folder path
	 */
	private static File getMetadataFolderForFile(String path) {
		File file = new File(path);
		return new File(file.getParentFile(), META_EXTENSION);
	}

	/**
	 * Return the path to the metadata file relating the registry resource
	 * @param path Path to the registry resource file/folder
	 * @return Path to the registry resource metadata file
	 */
	public static File getMetadataFile(String path) {
		boolean folder = (new File(path)).isDirectory();
		if (folder)
			return getMetadataFileForFolder(path);
		else
			return getMetadataFileForFile(path);
	}

	/**
	 * Return the path for the metadata file for a registry resource folder
	 * @param directoryPath Path to the registry resource folder
	 * @return Path to the registry resource folder metadata file
	 */
	private static File getMetadataFileForFolder(String directoryPath) {
		File metaFolder = getMetadataFolderForFolder(directoryPath);
		return new File(metaFolder, FOLDER_META_FILE);
	}

	/**
	 * Return the path for the metadata file for a registry resource file
	 * @param path Path to the registry resource file
	 * @return Path to the registry resource file metadata file
	 */
	private static File getMetadataFileForFile(String path) {
		File metaFolder = getMetadataFolderForFile(path);
		Path resource = new Path(path);
		return new File(metaFolder, META_PREFIX
				+ resource.segment(resource.segmentCount() - 1) + XML_EXTENSION);
	}

	/**
	 * Checks to see if the folder or file is an existing registry resource 
	 * @param filePath Path to the file or folder
	 * @return true if it is a existing registry resource, false if it isn't or a new registry resource
	 */
	public static boolean isRegistryResource(String filePath) {
		File metaData = getMetadataFile(filePath);
		return metaData.exists();
	}

	/**
	 * Check to see if the file is mine/server version of a conflicted registry resource file
	 * @param path Path to the file
	 * @return return whether it is a mine/server conflict version or not. 
	 */
	public static int getConflictVersionState(String path) {
		File resourceC = new File(path);
		//Default is that the file is not part of any conflicted resource
		int resourceType = RESOURCE_STATE_NOT_CONFLICT;
		
		//If is a mine/server version of a conflicted resource
		//  1. It should be a file
		//  2. Its extension should end with <code>CONFLICT_MINE_EXTENSION</code> or 
		//     <code>CONFLICT_SERVER_EXTENSION</code>
		//  3. The file shouldn't have a metadata file --> not checked currently
		//  4. There should exist a file with the name having without the extension of this file and
		//     that file should be a registry resource file
		//  5. There should exist server/mine extension file for this file 
		if (resourceC.isFile()) {
			
			//Check extension of the file
			if (path.endsWith(CONFLICT_MINE_EXTENSION) || path.endsWith(CONFLICT_SERVER_EXTENSION)) {
				
				//Get the extension
				String extension = path.endsWith(CONFLICT_MINE_EXTENSION) ? 
						CONFLICT_MINE_EXTENSION : CONFLICT_SERVER_EXTENSION;
				
				//Assume it is one of the conflict versions of a registry resource file
				resourceType=(extension.equals(CONFLICT_MINE_EXTENSION) ? 
						RESOURCE_STATE_CONFLICT_MINE: RESOURCE_STATE_CONFLICT_SERVER);
				
				//Get the file path of the possible registry resource file for the conflict version
				String proposedRegistryResourceFile = path.substring(0,path.length() - extension.length());
				File resourceFile = new File(proposedRegistryResourceFile);
				
				//Get the possible counter part file path of the other conflict version file 
				String otherConflictFilename = proposedRegistryResourceFile	
											+ (resourceType==RESOURCE_STATE_CONFLICT_MINE ? 
													CONFLICT_SERVER_EXTENSION : CONFLICT_MINE_EXTENSION);
				File otherConflictFile = new File(otherConflictFilename);
				
				//Check to see if at least one of above criteria is not satisfied
				if (!resourceFile.exists()
						|| resourceFile.isDirectory()
						|| !otherConflictFile.exists()
						|| !otherConflictFile.isDirectory()
						|| (getResourceState(resourceFile.getAbsolutePath()) 
								== RESOURCE_STATE_NOT_RESOURCE)) {
					resourceType=RESOURCE_STATE_NOT_CONFLICT;
				}
				
			}
		}
		return resourceType;
	}

	/**
	 * Return the metadata folder for the file/folder
	 * @param path Path to file/folder
	 * @return Path to the metadata folder
	 */
	private static File getMetadataFolder(String path){
		File resource = new File(path);
		if (resource.isDirectory()) {
			return getMetadataFolderForFolder(path);
		} else
			return getMetadataFolderForFile(path);
	}
	
	/**
	 * Return the state of a file/folder.
	 * @param filePath Path to the file/folder
	 * @return Returns the state. state can be one of the following
	 *		{@link #RESOURCE_STATE_NOT_RESOURCE},
	 *		{@link #RESOURCE_STATE_NORMAL},
	 *		{@link #RESOURCE_STATE_MODIFIED},
	 *		{@link #RESOURCE_STATE_DELETED},
	 *		{@link #RESOURCE_STATE_NEW},
	 *		{@link #RESOURCE_STATE_CONFLICT},
	 *		{@link #RESOURCE_STATE_CONFLICT_SERVER},
	 *		{@link #RESOURCE_STATE_CONFLICT_MINE},
	 *		{@link #RESOURCE_STATE_ERROR}
	 */
	public static int getResourceState(String filePath) {
		//Assume that it is not a registry resource
		int state = RESOURCE_STATE_NOT_RESOURCE;
		
		//Check to see if it is a conflict version of a conflicted resource
		int conflictDataState = getConflictVersionState(filePath);
		if (conflictDataState != RESOURCE_STATE_NOT_CONFLICT)
			return conflictDataState;
		
		File metadataFolder = null;
		File resource = new File(filePath);

		//If the path is a folder and its the metadata containing folder it is not a registry resource
		if (resource.isDirectory() && META_EXTENSION.equals(resource.getName())){
			return state;
		}
	
		//get the path to the possible metadata folder for the file/folder
		metadataFolder = getMetadataFolder(filePath);
		
		//If such a metadata folder exists
		if (metadataFolder.exists()) {
			//Get the possible metadata file path to the file/folder
			File metadataFile = getMetadataFile(filePath);
			
			if (metadataFile.exists()) {
				//metadata file exists => this is definitely a registry resource
				
				//Assume the registry resource is in unmodified/undeleted/non-conflicted state
				state = RESOURCE_STATE_NORMAL;
				
				if (!resource.exists()){
					//If resource doesn't exist assume that the resource was deleted
					state = RESOURCE_STATE_DELETED;
				}else if (resource.isFile()) {
					//If the resource is a file, determine the state of the resource
					state = getFileResourceState(state, resource,metadataFile);
				} else {
					//determine reasonable state through the states of its file/folders contained.	
					state = getFolderResourceState(state, metadataFolder, resource);
				}
				
				if (state == RESOURCE_STATE_NORMAL) {
					if (RegistryResourceUtils.getRegistryState(filePath) == RegistryResourceUtils.RegistryState.ADDED) {
						state = RESOURCE_STATE_NEW;
					}
				}
				
			} else if (resource.exists()){
				// metadata file doesn't exist && metadata folder exist => new resource
				state = RESOURCE_STATE_NEW;
			}
		} else if (resource.exists()) {
			String parent = resource.getParent();
			
			//parent is a registry resource or a new registry resource => new resource
			if (parent != null && 
					(isRegistryResource(parent) || getResourceState(parent) == RESOURCE_STATE_NEW)){
				state = RESOURCE_STATE_NEW;
			}
			
		}
		
		return state;
	}

	/**
	 * Determine the states of each file/folder inside the folder and decide on a appropriate state 
	 * for the folder.
	 * @param currentState Current prevailing state for the folder
	 * @param metadataFolder Path to the metadata folder
	 * @param folder File object to the registry resource directory
	 * @return the state of the directory
	 */
	private static int getFolderResourceState(int currentState, File metadataFolder, File folder) {
		
		//Assume the children state is the current state of the folder
		int directoryState = currentState;
		
		File[] files = folder.listFiles();
		for (File file : files) {
			
			//If the child is a file or it is not the metadata folder
			if (file.isFile() || !file.getName().equals(META_EXTENSION)) {
				
				//get the resource state of the child file/folder
				int childState = getResourceState(file.getAbsolutePath());
				
				if (childState == RESOURCE_STATE_CONFLICT) {
					//the final state for the folder is conflict. ignore other children states
					return RESOURCE_STATE_CONFLICT;
				} else if (childState == RESOURCE_STATE_MODIFIED || childState == RESOURCE_STATE_NEW){
					directoryState = RESOURCE_STATE_MODIFIED;
				} else if (childState == RESOURCE_STATE_ADDED){
					directoryState = RESOURCE_STATE_ADDED;
				}
			}
		}

		if (directoryState == RESOURCE_STATE_NORMAL) {
			//If there are deleted resources among the child files/folders then the modified state
			directoryState = isResourcesMissing(folder)? 
					RESOURCE_STATE_MODIFIED : directoryState;
		}
		
		return directoryState;
	}

	/**
	 * Checks to see if the metadata files in the metadata folder matches with files in the folder
	 * @param folder
	 * @return
	 */
	private static boolean isResourcesMissing(File folder) {
		return getDeletedResourcesInPath(folder.getAbsolutePath()).length>0;
	}

	/**
	 * Determine the state of the file
	 * @param currentState Current determined state
	 * @param resource File object for the 
	 * @param metaFile File object to the metadata file
	 * @return the state of the file
	 */
	private static int getFileResourceState(int currentState, File resource, File metaFile) {
		int state=currentState;
		OMElement metaFileElement = null;
		try {
			//get the OM element containing the meta information about the registry resource 
			metaFileElement = Utils.getOMElementFromMetaFile(metaFile.getAbsolutePath());
		} catch (SynchronizationException e) {
			log.error(e);
		}
		

		if (isResourceConflict(resource.getAbsolutePath())){
			state = RESOURCE_STATE_CONFLICT;
		} else if(metaFileElement.getAttributeValue(STATUS_Q_NAME) != null){
			String statusValue = metaFileElement.getAttributeValue(STATUS_Q_NAME);
			if("added".equals(statusValue)){
				state = RESOURCE_STATE_ADDED;
			} else if ("deleted".equals(statusValue)){
				state = RESOURCE_STATE_DELETED;
			}
		} else{
			try {
				//Retrieve the checksum of the original file when checkedout
				String checksum = metaFileElement.getAttributeValue(MD5_Q_NAME);
				
				//Checksum of the working copy
				String workingCopyChecksum = Utils.getMD5(Utils.getBytesFromFile(resource));
				
				if (workingCopyChecksum==null){
					//Couldn't determine the checksum of the local copy => file couldn't be read
					state = RESOURCE_STATE_ERROR;
				}else if (!workingCopyChecksum.equals(checksum)) {
					//The checksums exists and differ => modified
					state = RESOURCE_STATE_MODIFIED;
				} 
			} catch (SynchronizationException e) {
				log.error(e);
			}
		}
		
		return state;
	}

	/**
	 * Checks to see if the resource is in conflicted state
	 * @param path
	 * @return true if it is in conflict state
	 */
	private static boolean isResourceConflict(String path) {
		File resource = new File(path);
		
		//if conflict mine/server version files exist then its in conflict state
		return (resource.isFile() && (new File(resource.toString() + CONFLICT_SERVER_EXTENSION)).exists()
					&& (new File(resource.toString() + CONFLICT_MINE_EXTENSION)).exists());
	}

	/**
	 * Determine if the given path is valid to be checked out. 
	 * @param path Path to be checked out
	 * @return True if the path is valid for checkout
	 * @throws Exception
	 */
	public static boolean isCheckoutPathValid(String path) throws Exception {
		File file = new File(path);
		String chkoutFolder = file.getName();
		
		//If the path is already a registry resource then the path is invalid for checkout
		boolean invalid = (file.exists() && isRegistryResource(path));
		if (invalid) {
			throw new Exception(
					"The selected location already contains a registry resource checkout path as '"
							+ chkoutFolder
							+ "'. Please select a different folder.");
		} else {
			
			//If the path is not a registry resource (including not a new resource) then the path is valid
			invalid = (RegistryCheckInClientUtils.getResourceState(file.getParent()) != RegistryCheckInClientUtils.RESOURCE_STATE_NOT_RESOURCE);
			if (invalid)
				throw new Exception(
						"Selected location is already a checkedout location. Please select another location.");
		}
		return true;
	}

	/**
	 * Sync with the registry for the new changes from server side given the registry url
	 * @param registryUrl
	 * @param path
	 * @param username
	 * @param password
	 * @throws SynchronizationException 
	 * @throws CheckinClientException
	 */
	public static void update(String registryUrl,String checkoutPath, String path, String username, String password) 
							throws SynchronizationException{
		ClientOptions clientOptions = new ClientOptions();
		clientOptions.setUsername(username);
		clientOptions.setPassword(password);
		clientOptions.setWorkingLocation(path);
		clientOptions.setUserUrl(registryUrl + checkoutPath);
		clientOptions.setTesting(true);
		clientOptions.setUserInteractor(new UserInteractor() {
			
			public String showMessage(MessageCode arg0, String[] arg1) {
				return null;
			}
			
			public UserInputCode getInput(MessageCode arg0, String[] arg1, String arg2) {
				return null;
			}
		});
		new Update(clientOptions).execute();
	}

	/**
	 * Sync with the registry for the new changes from server side
	 * @param path
	 * @param username
	 * @param password
	 * @throws Exception
	 */
	public static void update(String path, String username, String password)throws Exception {
		RemoteRegistryInfo resourceRemoteRegistryUrlInfo = getResourceRemoteRegistryUrlInfo(path);
		
		update(resourceRemoteRegistryUrlInfo.getUrl().toString(),resourceRemoteRegistryUrlInfo.getPath(), path,
				username, password);
	}

	/**
	 * Do a checkin of the changes or new files/folders to the registry given by the registry url
	 * @param registryUrl
	 * @param checkoutPath
	 * @param path
	 * @param username
	 * @param password
	 * @throws SynchronizationException 
	 */
	public static void checkin(String registryUrl, String checkoutPath,	String path, String username,
			String password) throws SynchronizationException{
	
		ClientOptions clientOptions = new ClientOptions();
		clientOptions.setUsername(username);
		clientOptions.setPassword(password);
		clientOptions.setType(RegistryType.ATOM);
		clientOptions.setWorkingLocation(path);
		
		clientOptions.setUserUrl(registryUrl + checkoutPath);
		clientOptions.setTesting(true);
		clientOptions.setUserInteractor(new UserInteractor() {
			public UserInputCode getInput(
					org.wso2.carbon.registry.synchronization.message.MessageCode arg0,
					String[] arg1, String arg2) {
				// TODO Auto-generated method stub
				return null;
			}

			public String showMessage(
					org.wso2.carbon.registry.synchronization.message.MessageCode arg0,
					String[] arg1) {
				// TODO Auto-generated method stub
				return null;
			}
		});
		new Checkin(clientOptions).execute();
	}

	/**
	 * Commit changes made in the local copy of the registry resources to the registry
	 * @param path
	 * @param username
	 * @param password
	 * @throws Exception
	 */
	public static void commit(String path, String username, String password)throws Exception {
		RemoteRegistryInfo resourceRemoteRegistryUrlInfo = 
			getResourceRemoteRegistryUrlInfo(path);
		checkin(resourceRemoteRegistryUrlInfo.getUrl().toString(),
				resourceRemoteRegistryUrlInfo.getPath(), path,
				username, password);
	}

	/**
	 * Do a fresh checkout from the registry to the local path
	 * @param username
	 * @param password
	 * @param workingDirectory
	 * @param registryUrl
	 * @param checkoutPath
	 * @throws SynchronizationException 
	 * @throws CheckinClientException
	 */
	public static void checkout(String username, String password,String workingDirectory, 
			String registryUrl, String checkoutPath) throws SynchronizationException {
		String userUrl = registryUrl.replaceAll("/$","") + "/registry" + checkoutPath;
		ClientOptions clientOptions = new ClientOptions();
		clientOptions.setUsername(username);
		clientOptions.setPassword(password);
		clientOptions.setWorkingLocation(workingDirectory);
		clientOptions.setUserUrl(userUrl);
//		clientOptions.setType(RegistryType.WS);
		clientOptions.setUserInteractor(new UserInteractor() {

			public UserInputCode getInput(MessageCode arg0, String[] arg1,
					String arg2) {
				// TODO Auto-generated method stub
				return null;
			}

			public String showMessage(MessageCode arg0, String[] arg1) {
				// TODO Auto-generated method stub
				return null;
			}
			
		});
		new Checkout(clientOptions).execute();
	}

	/**
	 * Retrieve the metadata information object of the registry resource file/folder
	 * @param path
	 * @return
	 * @throws Exception
	 */
	public static RemoteRegistryInfo getResourceRemoteRegistryUrlInfo(String path) throws Exception {
		if (isRegistryResource(path)) {
			
			//Locate the metadata file and obtain the omelement which contains all the meta info
			File metaFile = getMetadataFile(path);
			OMElement metaFileElement = Utils.getOMElementFromMetaFile(metaFile
					.getAbsolutePath());
			String registryUrl = metaFileElement.getAttributeValue(REGISTRY_URL_Q_NAME);
			String relativePath = metaFileElement.getAttributeValue(PATH_Q_NAME);
			boolean isCollection = metaFileElement.getAttributeValue(IS_COLLECTION_Q_NAME)
				.equalsIgnoreCase("true");
			OMElement creatorEle = metaFileElement.getFirstChildWithName(CREATOR_Q_NAME);
			String creator = (creatorEle!=null)?creatorEle.getText():null;
			
			OMElement createdTimeEle = metaFileElement.getFirstChildWithName(
					CREATED_TIME_Q_NAME);
			long createdTime = Long.parseLong((createdTimeEle!=null)?createdTimeEle.getText():"0");
			OMElement lastUpdaterEle = metaFileElement.getFirstChildWithName(LAST_UPDATER_Q_NAME);
			String lastUpdater = (lastUpdaterEle!=null)?lastUpdaterEle.getText():"";
			OMElement lastModifiedEle = metaFileElement.getFirstChildWithName(
					LAST_MODIFIED_Q_NAME);
			long lastModified = (lastModifiedEle!=null)?Long.parseLong(lastModifiedEle.getText()):metaFile.lastModified();
			
			RemoteRegistryInfo remoteRegistryInfo = new RemoteRegistryInfo();
			try {
				remoteRegistryInfo.setUrl(new URL(registryUrl));
			} catch (MalformedURLException e) {
				throw new Exception("Invalid Registry url: " + registryUrl);
			}
			remoteRegistryInfo.setPath(relativePath);
			remoteRegistryInfo.setCollection(isCollection);
			remoteRegistryInfo.setResourceCreationUser(creator);
			remoteRegistryInfo.setResourceCreationTime(createdTime);
			remoteRegistryInfo.setResourceLastUpdateUser(lastUpdater);
			remoteRegistryInfo.setResourceLastUpdateTime(lastModified);
			return remoteRegistryInfo;

		}
		return null;
	}

	/**
	 * Retrieve registry resource file/folders in the path
	 * @param path
	 * @return
	 */
	public static String[] getRegistryResourcesInPath(String path) {
		ArrayList<String> fileList = new ArrayList<String>();
		File resource = new File(path);
		if (isRegistryResource(path)
				|| (getResourceState(path) == RESOURCE_STATE_NEW)) {
			File[] listFiles = resource.listFiles();
			for (File file : listFiles) {
				if (!file.getName().equals(META_EXTENSION)) {
					fileList.add(file.getName());
				}
			}
		}
		return (String[]) fileList.toArray(new String[] {});
	}

	/**
	 * List of registry resources that is deleted from the path
	 * @param path
	 * @return
	 */
	public static String[] getDeletedResourcesInPath(String path) {
		ArrayList<String> deletedList = new ArrayList<String>();
		if (isRegistryResource(path)) {
			File metaFolder = getMetadataFolder(path);
			
			//list of metadata files and remove the metadata file for the folder
			ArrayList<String> metaList = new ArrayList<String>();
			List<String> list = Arrays.asList(metaFolder.list());
//			ArrayList<String> metaList=(ArrayList<String>) Arrays.asList(metaFolder.list());
			for (String filepath : list) {
	            metaList.add(filepath);
            }
			metaList.remove(FOLDER_META_FILE);
			
			String[] registryResourcesInPath = getRegistryResourcesInPath(path);
			for (String resource : registryResourcesInPath) {
				//If the resource file is found for metadata file then remove that from the list
				if (metaList.contains(META_PREFIX + resource + XML_EXTENSION))
					metaList.remove(META_PREFIX + resource + XML_EXTENSION);
			}
			
			//metaList contains list of metadata files which did not have a match for a resource file
			deletedList = new ArrayList<String>();
			for (String meta : metaList) {
				//generate the resource file missing file name and save the it in to the new list
				deletedList.add(meta.substring(1, meta.length() - 4));
			}
		}
		return (String[]) deletedList.toArray(new String[] {});
	}

	/**
	 * Get the local version of the conflicted resource
	 * @param path
	 * @return
	 */
	public static String getConflictResourceLocalCopy(String path) {
		return getConflictResourceConflictCopy(path,
				RegistryCheckInClientUtils.RESOURCE_STATE_CONFLICT_MINE).getAbsolutePath();
	}

	/**
	 * Get the server version of the conflicted resource
	 * @param path
	 * @return
	 */
	public static String getConflictResourceServerCopy(String path) {
		return getConflictResourceConflictCopy(path,
				RegistryCheckInClientUtils.RESOURCE_STATE_CONFLICT_SERVER).getAbsolutePath();
	}

	/**
	 * Get the mine/server version of the resource
	 * @param path
	 * @param type
	 * @return
	 */
	public static File getConflictResourceConflictCopy(String path, int type) {
		File file = new File(path);
		return new File(file.getParent(),
				file.getName() + (type == RegistryCheckInClientUtils.RESOURCE_STATE_CONFLICT_MINE ? 
								CONFLICT_MINE_EXTENSION	: CONFLICT_SERVER_EXTENSION));
	}
	
	public static void download(String username, String password,String filePath, 
	                			String registryUrl, String registryPath) throws InvalidRegistryURLException, UnknownRegistryException, RegistryContentRetrieveException, IOException{
		org.wso2.developerstudio.eclipse.registry.base.core.Registry registry = new org.wso2.developerstudio.eclipse.registry.base.core.Registry(username,password,registryUrl);
		File file = new File(filePath);
		try {
			if (!file.exists()){
				file.createNewFile();
			}
			registry.getContent(registryPath, filePath);
		} catch (IOException e) {
			throw new UnknownRegistryException("Error occured while creating a new file: "+e.getMessage(),e);
		}
	}
	
}
