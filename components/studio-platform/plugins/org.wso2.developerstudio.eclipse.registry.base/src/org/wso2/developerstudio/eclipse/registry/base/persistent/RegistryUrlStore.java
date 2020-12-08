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

package org.wso2.developerstudio.eclipse.registry.base.persistent;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.eclipse.core.resources.ResourcesPlugin;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.registry.base.Activator;

public final class RegistryUrlStore {
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);

	private File urlListFile;
	private List<RegistryURLInfo> urlList;
	private static RegistryUrlStore instance;

	/**
	 * RegistryUrlStore constructor
	 */
	private RegistryUrlStore() {
	}

	/**
	 * 
	 */
	private void init() {
		urlList = new ArrayList<RegistryURLInfo>();
		urlListFile = new File(ResourcesPlugin.getWorkspace().getRoot()
								.getLocation().append(".metadata").append(Activator.PLUGIN_ID)
								.append("urls.txt").toOSString());
		readUrlsFromFile();
	}

	/**
	 * get the instance of the RegistryUrlStore
	 * @return
	 */
	public static RegistryUrlStore getInstance() {
		if (instance == null) {
			instance = new RegistryUrlStore();
			instance.init();
		}
		return instance;
	}

	/**
	 * read added regisrty urls from the temperary file which contains urls of added registries
	 */
	private void readUrlsFromFile() {
		urlList.clear();
		synchronized (urlList) {
			if (!urlListFile.exists()){
				return;
			}
			StringBuilder contents = new StringBuilder();

			try {
				BufferedReader input = new BufferedReader(new FileReader(urlListFile));
				try {
					String line = null; // not declared within while loop
					while ((line = input.readLine()) != null) {
						int i = line.indexOf(" ");
						if (i > 0) {
							String url = line.substring(0, i).trim();
							String state_uname_path = line.substring(i).trim();
							i = state_uname_path.indexOf(" ");
							if (i > 0) {
								String state = state_uname_path.substring(0, i).trim();
								String uname_path = state_uname_path.substring(i).trim();
								i = uname_path.indexOf(" ");
								if (i > 0) {
									String uname = uname_path.substring(0, i).trim();
									String path = uname_path.substring(i).trim();
									RegistryURLInfo registryURLInfo = new RegistryURLInfo();
									registryURLInfo.setPersist(false);
									registryURLInfo.setUrl(new URL(url));
									registryURLInfo.setPath(path);
									registryURLInfo.setUsername(uname);
									registryURLInfo.setEnabled(state.equalsIgnoreCase("true"));
									urlList.add(registryURLInfo);
									registryURLInfo.setPersist(true);
								}
							}
						}
						contents.append(line);
						contents.append(System.getProperty("line.separator"));
					}
				} finally {
					input.close();
				}
			} catch (IOException ex) {
				log.error("couldn't read the url from workspace"+ex.getMessage(),ex);
			}
		}
	}

	/**
	 * save newly added registry url to the url file
	 */
	private void saveUrlsToFile() {
		if (urlListFile.exists()){
			urlListFile.delete();
		}
		if (!urlListFile.getParentFile().exists()){
			urlListFile.getParentFile().mkdirs();
		}
		Writer output = null;
		try {
			output = new BufferedWriter(new FileWriter(urlListFile));
			for (RegistryURLInfo registryURLInfo : urlList) {
				try {
					if(!registryURLInfo.isSpecificControl()){// Save Reg Url only connect from registry perspective
					output.write(registryURLInfo.getUrl().toString() +
								" " +
								Boolean.toString(registryURLInfo.isEnabled())+
								" " +
								registryURLInfo.getUsername() + 
								" " +
								registryURLInfo.getPath() + 
								"\n");
					}
				} catch (IOException e) {
					log.error("couldn't save the url in workspace"+e.getMessage(),e);
				}
			}
		} catch (IOException e) {
			log.error("Couldn't read the url list "+e.getMessage(),e);
		} finally {
			if (output != null)
				try {
					output.close();
				} catch (IOException e) {
					log.error("Couldn't close the stream when saving urls into workspace file "+e.getMessage(),e);
				}
		}

	}

	/**
	 * get all registryUrls
	 * @return
	 */
	public List<RegistryURLInfo> getAllRegistryUrls() {
		return urlList;
	}

	/**
	 * add Registry url to url list and save it to the file
	 * @param registryUrl
	 * @param username
	 * @param path
	 * @param isSpecificControl - Call from outside the Registry perspective
	 * @return
	 */
	public RegistryURLInfo addRegistryUrl(URL registryUrl, 
										  String username,
										  String path,boolean isSpecificControl) {
		createRegistryPropertyFile(registryUrl.getHost()+"."+registryUrl.getPort());
		RegistryURLInfo info = new RegistryURLInfo();
		info.setUrl(registryUrl);
		info.setPath(path);
		info.setUsername(username);
		info.setSpecificControl(isSpecificControl);
	    if(!urlList.contains(info)){
	    	urlList.add(info);
	    	if(!isSpecificControl){
	    		saveUrlsToFile();
	    	}
	       }
		return info;
	}
	   
	public void modifyRegistryUrl(String registryUrl, String username,
			String oldUser) {

		Iterator<RegistryURLInfo> iterator = urlList.iterator();
		while (iterator.hasNext()) {
			RegistryURLInfo reginfo = iterator.next();
			if (registryUrl.equals(reginfo.getUrl().toString())
					&& (oldUser==null || oldUser.equals(reginfo.getUsername()))) {
				reginfo.setUsername(username);
			}
		}
		saveUrlsToFile();
	}
	
	

	/**
	 * remove Registry url to url list and update the file
	 * @param info
	 */
	public void removeRegistryUrl(RegistryURLInfo info) {
		if (urlList.contains(info)) {
			urlList.remove(info);
			saveUrlsToFile();
			removeRegistryPropertyFile(info.getUrl().getHost()+"."+info.getUrl().getPort());
		}
	}

	/**
	 * keep track of previously added registries
	 */
	public void persist() {
		saveUrlsToFile();
	}
	
	private void createRegistryPropertyFile(String serverUrl){
		File regiistryNodeFile= new File(ResourcesPlugin.getWorkspace().getRoot()
					.getLocation().append(".tmp").append(Activator.PLUGIN_ID)
					.append(serverUrl.concat(".txt")).toOSString());
		if (regiistryNodeFile.exists()){
			FileUtils.deleteQuietly(regiistryNodeFile);
		}
		if (!regiistryNodeFile.getParentFile().exists()){
			regiistryNodeFile.getParentFile().mkdirs();
		}
		try {
	        regiistryNodeFile.createNewFile();
        } catch (IOException e) {
	       log.error("Registry property file couldn't create "+e.getMessage(), e);
        }
	}
	
	private void removeRegistryPropertyFile(String serverUrl){
		File regiistryNodeFile= new File(ResourcesPlugin.getWorkspace().getRoot()
		             					.getLocation().append(".tmp").append(Activator.PLUGIN_ID)
		             					.append(serverUrl.concat(".txt")).toOSString());
		if (regiistryNodeFile.exists()){
			FileUtils.deleteQuietly(regiistryNodeFile);
		}
	}
}
