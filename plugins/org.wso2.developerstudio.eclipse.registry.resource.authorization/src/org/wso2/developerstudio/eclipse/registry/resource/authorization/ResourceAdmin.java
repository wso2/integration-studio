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

package org.wso2.developerstudio.eclipse.registry.resource.authorization;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Enumeration;

import org.apache.axiom.om.OMElement;
import org.apache.axis2.AxisFault;
import org.apache.axis2.context.ServiceContext;
import org.apache.axis2.transport.http.HTTPConstants;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.preference.IPreferenceStore;
import org.wso2.carbon.core.services.authentication.AuthenticationAdminStub;
import org.wso2.carbon.registry.resource.services.ExceptionException;
import org.wso2.carbon.registry.resource.services.ResourceAdminServiceStub;
import org.wso2.carbon.registry.resource.services.ResourceAdminServiceStub.PermissionBean;
import org.wso2.carbon.registry.resource.services.ResourceAdminServiceStub.PermissionEntry;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.ui.preferences.ClientTrustStorePreferencePage;

public class ResourceAdmin {
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);

	public static final String READ = "Read";
	public static final String WRITE = "Write";
	public static final String DELETE = "Delete";
	public static final String AUTHORIZE = "Authorize";

	private String url;
	private String username;
	private String password;
	private ResourceAdminServiceStub stub;
	private AuthenticationAdminStub authenticationAdminStub;

	public ResourceAdmin(String url, String username, String password) {
		init();
		setUrl(url);
		setUsername(username);
		setPassword(password);
	}

	private static void init() {
		
		if (!loadJKSfromEclipsePrefernaces()){	
			//Then loading the default JKS which is shipping with DevS
		System.setProperty("javax.net.ssl.trustStore", getJKSPath());
		System.setProperty("javax.net.ssl.trustStorePassword", "wso2carbon");
		System.setProperty("javax.net.ssl.trustStoreType", "JKS");
		}
	}
	
	private static boolean loadJKSfromEclipsePrefernaces(){
				
		try{

		IPreferenceStore preferenceStore = org.wso2.developerstudio.eclipse.platform.ui.Activator.getDefault()
					.getPreferenceStore();

		if(preferenceStore.getString(ClientTrustStorePreferencePage.TRUST_STORE_LOCATION).isEmpty()){
			return false;
		}
		if(preferenceStore.getString(ClientTrustStorePreferencePage.TRUST_STORE_PASSWORD).isEmpty()){
			return false;
		}
		if(preferenceStore.getString(ClientTrustStorePreferencePage.TRUST_STORE_TYPE).isEmpty()){
			return false;
		}
		
			System.setProperty("javax.net.ssl.trustStore",
					preferenceStore.getString(ClientTrustStorePreferencePage.TRUST_STORE_LOCATION));
			System.setProperty("javax.net.ssl.trustStorePassword",
					preferenceStore.getString(ClientTrustStorePreferencePage.TRUST_STORE_PASSWORD));
			System.setProperty("javax.net.ssl.trustStoreType",
					preferenceStore.getString(ClientTrustStorePreferencePage.TRUST_STORE_TYPE));		
		return true;
		
		}catch(Exception e){
			log.error("Cannot load values from Eclipse perfernces to read JKS"+e.getMessage(), e);
		}
		
		return false;
	}

	private static String getJKSPath() {
		extractFilesToLocation("resources/security",
				new File(getMetaDataPath()));
		String path = getMetaDataPath() + File.separator + "security"
				+ File.separator + "wso2carbon.jks";
		return path;
	}

	public static void extractFilesToLocation(String resourcePath,
			File destination) {
		URL resource = Activator.getDefault().getBundle().getResource(
				resourcePath);

		if (isResourceFolder(resource)) {
			Enumeration confFolder = Activator.getDefault().getBundle()
					.getEntryPaths(resourcePath);
			String[] filePath = resource.getFile().split("/");
			File newDestinationPath = new File(destination,
					filePath[filePath.length - 1]);
			newDestinationPath.mkdirs();
			while (confFolder != null && confFolder.hasMoreElements()) {
				String newResourcefile = confFolder.nextElement().toString();
				extractFilesToLocation(newResourcefile, newDestinationPath);
			}

		} else {
			copyResourceToDestination(resource, destination);
		}
	}

	private static boolean isResourceFolder(URL url) {
		boolean result = true;
		try {
			InputStream openStream = url.openStream();
			if (openStream.available() > 0)
				result = false;
			openStream.close();
		} catch (IOException e) {
			// error
		}
		return result;
	}

	private static void copyResourceToDestination(URL url, File destination) {
		String[] filePath = url.getFile().split("/");
		File destinationFile = new File(destination,
				filePath[filePath.length - 1]);

		InputStream confOpenStream;
		try {
			confOpenStream = url.openStream();
			BufferedInputStream confBufferedInStream = null;
			confBufferedInStream = new BufferedInputStream(confOpenStream);
			FileOutputStream out = new FileOutputStream(destinationFile);
			byte[] buf = new byte[1024];
			int len;
			while ((len = confBufferedInStream.read(buf)) > 0) {
				out.write(buf, 0, len);
			}

			confOpenStream.close();
			out.close();
		} catch (IOException e) {
			log.error(e);
		}
	}

	public static String getMetaDataPath() {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IWorkspaceRoot root = workspace.getRoot();
		IPath location = root.getLocation();
		String metadataPath = location.toOSString() + File.separator
				+ ".metadata";
		return metadataPath;
	}

	public boolean isUserAuthenticate(String username, String password, URL hostUrl) throws Exception{
		AuthenticationAdminStub authenticationStub;
		boolean loginStatus=false;
		authenticationStub = new AuthenticationAdminStub(getUrl() + "services/AuthenticationAdmin");
		authenticationStub._getServiceClient().getOptions().setManageSession(true);
		loginStatus = authenticationStub.login(getUsername(), getPassword(), hostUrl.getHost());
		setAuthenticationAdminStub(authenticationStub);

		return loginStatus;
	}
	
	
	public String getgetAuthenticatedSessionId(){
		AuthenticationAdminStub authenticationStub = getAuthenticationAdminStub();
		if(authenticationStub!=null){
		ServiceContext serviceContext = authenticationStub
				._getServiceClient().getLastOperationContext()
				.getServiceContext();
		String sessionCookie = (String) serviceContext
				.getProperty(HTTPConstants.COOKIE_STRING);
		String endpont = "https://localhost:9443/services/SequenceAdminService";
		/*SequenceAdminServiceStub stub;
		try {
			stub = new SequenceAdminServiceStub(endpont);
			stub._getServiceClient().getOptions().setManageSession(true);
			stub._getServiceClient().getOptions().setTimeOutInMilliSeconds(
					60000000);
			stub._getServiceClient().getOptions().setProperty(
					HTTPConstants.COOKIE_STRING, sessionCookie);
			
			 int sequencesCount = stub.getSequencesCount();
			 SequenceInfo[] sequences = stub.getSequences(0, 2);
			 
			 for (SequenceInfo sequenceInfo : sequences) {
				OMElement sequence = stub.getSequence(sequenceInfo.getName());
				stub.saveSequence(sequence.getFirstElement());
			}
		} catch (Exception e) {

		}
		*/
		return sessionCookie;
		}
		return null;
	}
	
	private AuthenticationAdminStub getAuthenticationAdminStub() {
		return authenticationAdminStub;
	}

	private void setAuthenticationAdminStub(AuthenticationAdminStub authenticationAdminStub) {
		this.authenticationAdminStub = authenticationAdminStub;
	}

	private ResourceAdminServiceStub getStub() throws RemoteException,
			Exception {
		if (stub!=null){
			try {
				stub.getMediatypeDefinitions()/*getPermissions("/")*/;
			} catch (Exception e) {
				//Assume session time out is the reason for the exception
				stub=null;
			}
		}
		if (stub == null) {
			URL url = null;
			try {
				url = new URL(getUrl());
			} catch (MalformedURLException e) {
				log.error(e);
			}
			AuthenticationAdminStub authenticationStub = new AuthenticationAdminStub(
					getUrl() + "services/AuthenticationAdmin");

			authenticationStub._getServiceClient().getOptions()
					.setManageSession(true);
			boolean loginStatus = authenticationStub.login(getUsername(),
					getPassword(), url.getHost());
			
			
			
			if (!loginStatus) {
			}
			ServiceContext serviceContext = authenticationStub
					._getServiceClient().getLastOperationContext()
					.getServiceContext();
			String sessionCookie = (String) serviceContext
					.getProperty(HTTPConstants.COOKIE_STRING);

			stub = new ResourceAdminServiceStub(getUrl()
					+ "services/ResourceAdminService");
			stub._getServiceClient().getOptions().setManageSession(true);
			stub._getServiceClient().getOptions().setTimeOutInMilliSeconds(
					60000000);
			stub._getServiceClient().getOptions().setProperty(
					HTTPConstants.COOKIE_STRING, sessionCookie);
		}
		return stub;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setPermissionPerResource(String regResPath, String permission,
			String role, String isAccept) throws Exception {
		String permissionType = null;
		if (permission != null) {
			if (permission.equals(READ)) {
				permissionType = "2";
			} else if (permission.equals(WRITE)) {
				permissionType = "3";
			} else if (permission.equals(DELETE)) {
				permissionType = "4";
			} else if (permission.equals(AUTHORIZE)) {
				permissionType = "5";
			}
			getStub().addRolePermission(regResPath, role, permissionType,
					isAccept);
		}

		/*
		 * Action to auth read =2 write = 3 delete =4 autho = 5
		 * 
		 * permission type allow = 1 deny any other no
		 */

	}

	public void denyPermissionPerResource(String regResPath, String permission,
			String role) throws Exception {
		String permissionType = null;
		if (permission != null) {
			if (permission.equals(READ)) {
				permissionType = "2";
			} else if (permission.equals(WRITE)) {
				permissionType = "3";
			} else if (permission.equals(DELETE)) {
				permissionType = "4";
			} else if (permission.equals(AUTHORIZE)) {
				permissionType = "5";
			}
			getStub().addRolePermission(regResPath, role, permissionType, "0");

		}
	}

	public ArrayList<Role> getPermissionPerResource(String resourcePath)
			throws RemoteException, ExceptionException, Exception {
		ArrayList<Role> roleList = new ArrayList<Role>();
		PermissionBean resPer = getStub().getPermissions(resourcePath);
		String[] roles = resPer.getRoleNames();
		
		PermissionEntry[] localRolePermissions = resPer.getRolePermissions();
		for (int i = 0; i < localRolePermissions.length; i++) {
			ArrayList<String> assignedPermissions = new ArrayList<String>();
			String role = localRolePermissions[i].getUserName();
			if (localRolePermissions[i].getAuthorizeAllow()) {
				assignedPermissions.add("Authorize");
			}
			if (localRolePermissions[i].getDeleteAllow()) {
				assignedPermissions.add("Delete");
			}
			if (localRolePermissions[i].getWriteAllow()) {
				assignedPermissions.add("Write");
			}
			if (localRolePermissions[i].getReadAllow()) {
				assignedPermissions.add("Read");
			}

			Role userRole = new Role(role, assignedPermissions);
			if (!roleList.contains(userRole)) {
				roleList.add(userRole);
			}
		}                      
		boolean found=false;
		for(int i=0; i<roleList.size(); i++){
			if(roleList.get(i).role.equals("wso2.anonymous.role")){
				found = true;
				break;
			}
		}
		
		if(!found){
    		ArrayList<String> assignedPermissions = new ArrayList<String>();
//    		assignedPermissions.add("Read");
    
    		Role annonymUser = new Role("wso2.anonymous.role", assignedPermissions);
    		if (!roleList.contains(annonymUser)) {
    			roleList.add(annonymUser);
    		}
		}

		return roleList;

	}

	public class Role {
		String role;

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}

		ArrayList<String> assignedPermission;

		public ArrayList<String> getAssignedPermission() {
			return assignedPermission;
		}

		public void setAssignedPermission(ArrayList<String> assignedPermission) {
			this.assignedPermission = assignedPermission;
		}

		public Role(String role, ArrayList<String> permissions) {
			this.role = role;
			this.assignedPermission = permissions;
		}

	}

	public ArrayList<String> getPermissionListPerResource(String resourcePath,
			String role) throws Exception {
		ArrayList<String> permissionAssigned = new ArrayList<String>();
		PermissionBean resPer = getStub().getPermissions(resourcePath);
		PermissionEntry[] localRolePermissions = resPer.getRolePermissions();
		for (int i = 0; i < localRolePermissions.length; i++) {
			String r = localRolePermissions[i].getUserName();
			if (r.equals(role)) {
				if (localRolePermissions[i].getAuthorizeAllow()) {
					permissionAssigned.add("Authorize");
				}
				if (localRolePermissions[i].getDeleteAllow()) {
					permissionAssigned.add("Delete");
				}
				if (localRolePermissions[i].getWriteAllow()) {
					permissionAssigned.add("Write");
				}
				if (localRolePermissions[i].getReadAllow()) {
					permissionAssigned.add("Read");
				}
			}

		}

		return permissionAssigned;
	}
	
	public boolean checkWritePermissionPerResource(String resourcePath) 
		throws Exception{
		PermissionBean resPer = null;
		try {
			resPer = getStub().getPermissions(resourcePath);
			return resPer.getPutAllowed();
		} catch (Exception e) {
 		log.error("Error occured while trying the get the resource permissions",e);
		}
		return false;
	}
	
	
	
}
