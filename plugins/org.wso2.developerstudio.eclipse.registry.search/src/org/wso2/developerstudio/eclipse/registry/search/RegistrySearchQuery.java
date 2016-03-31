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

package org.wso2.developerstudio.eclipse.registry.search;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.search.internal.ui.text.FileSearchQuery;
import org.eclipse.search.ui.ISearchResult;
import org.eclipse.search.ui.text.FileTextSearchScope;
import org.eclipse.swt.widgets.Display;
import org.wso2.carbon.registry.core.exceptions.RegistryException;
import org.wso2.developerstudio.eclipse.registry.base.core.Registry;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryNode;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryResourceNode;
import org.wso2.developerstudio.eclipse.registry.base.persistent.RegistryCredentialData;
import org.wso2.developerstudio.eclipse.registry.base.persistent.RegistryURLInfo;
import org.wso2.developerstudio.eclipse.registry.base.persistent.RegistryUrlStore;
import org.wso2.developerstudio.eclipse.registry.base.persistent.RegistryCredentialData.Credentials;
import org.wso2.developerstudio.eclipse.registry.base.ui.util.SWTControlUtils;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

public class RegistrySearchQuery extends FileSearchQuery {
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);

	ISearchResult searchResult;
	private SearchQueryData searchQueryData;
	private List<RegistrySearchResult> results;
	private TreeViewer viewer;

	public RegistrySearchQuery(String searchText, boolean isRegEx,
			boolean isCaseSensitive, FileTextSearchScope scope) {
		super(searchText, isRegEx, isCaseSensitive, scope);
	}

	public ISearchResult getSearchResult() {
		searchResult = new SearchResult(this);
		return searchResult;
	}

	public void setSearchQueryData(SearchQueryData searchQueryData) {
		this.searchQueryData = searchQueryData;
	}

	public SearchQueryData getSearchQueryData() {
		return searchQueryData;
	}

	public IStatus run(IProgressMonitor monitor)
			throws OperationCanceledException {
		Registry.registryInit();
		if (getSearchQueryData().isAllRegistries()) {
			List<RegistryURLInfo> allRegistryUrls = RegistryUrlStore
					.getInstance().getAllRegistryUrls();
			monitor.setTaskName("Starting registry search...");
			for (RegistryURLInfo registryURLInfo : allRegistryUrls) {
				if (registryURLInfo.isEnabled()) {
					monitor.beginTask("Searching "
							+ registryURLInfo.getUrl().toString() + "...", -1);
					RegistrySearchResult result = getMatches(registryURLInfo);
					if (result != null && result.getResults().length > 0) {
						results.add(result);
						refreshViewer();
					}
				}
			}
		}
		return Status.OK_STATUS;
	}

	public RegistrySearchResult getMatches(RegistryURLInfo registryURLInfo) {
		ArrayList<String> matches = new ArrayList<String>();
		Credentials credentials = RegistryCredentialData.getInstance()
				.getCredentials(registryURLInfo.getUrl().toString());
		if (credentials == null) {
			credentials = SWTControlUtils.requestCredentials(Display
					.getDefault().getActiveShell(), registryURLInfo.getUrl()
					.toString(), registryURLInfo.getUsername());
			if (credentials == null)
				return null;
		}
		try {
			String[] results = Utils.getResults(searchQueryData,
					registryURLInfo, credentials, "/");
			List<String> paths = new ArrayList<String>();
			for (String result : results) {
				if (Utils.isProvided(searchQueryData.getResourceName())) {
					String[] split = result.split("/");
					if (split.length > 1) {
						String name = split[split.length - 1];

						Pattern pattern = Pattern.compile(searchQueryData
								.getResourceName().replaceAll(
										Pattern.quote("*"), ".*"));
						Matcher matcher = pattern.matcher(name);
						if (matcher.find())
							paths.add(result);
					}
				} else
					paths.add(result);

			}
			return new RegistrySearchResult(registryURLInfo, credentials
					.getPassword(), paths.toArray(new String[] {}),
					getSearchQueryData());
		} catch (RegistryException e) {
			log.error(e);
		}
		return null;
	}

	public void setResults(List<RegistrySearchResult> results) {
		this.results = results;
	}

	public List<RegistrySearchResult> getResults() {
		if (results == null)
			results = new ArrayList<RegistrySearchResult>();
		return results;
	}

	public void setViewer(TreeViewer viewer) {
		this.viewer = viewer;
	}

	public TreeViewer getViewer() {
		return viewer;
	}

	public void refreshViewer() {
		Display.getDefault().asyncExec(new Runnable() {

			public void run() {
				getViewer().refresh();

			}

		});
	}

	public static class RegistrySearchResult {
		private RegistryURLInfo registryURLInfo;
		private String[] results;
		private SearchQueryData searchQueryData;
		private String password;
		private List<RegistryResourceNode> resources;
		private RegistryNode registryData;

		public RegistrySearchResult(RegistryURLInfo registryURLInfo,
				String password, String[] results,
				SearchQueryData searchQueryData) {
			this.setRegistryURLInfo(registryURLInfo);
			this.setResults(results);
			this.setSearchQueryData(searchQueryData);
			this.setPassword(password);
		}

		public void setSearchQueryData(SearchQueryData searchQueryData) {
			this.searchQueryData = searchQueryData;
		}

		public SearchQueryData getSearchQueryData() {
			return searchQueryData;
		}

		public void setResults(String[] results) {
			this.results = results;
		}

		public String[] getResults() {
			return results;
		}

		public void setRegistryURLInfo(RegistryURLInfo registryURLInfo) {
			this.registryURLInfo = registryURLInfo;
		}

		public RegistryURLInfo getRegistryURLInfo() {
			return registryURLInfo;
		}

		public List<RegistryResourceNode> getResources() {
			if (resources == null)
				initializeRegistryResources();
			return resources;
		}

		private void initializeRegistryResources() {
			registryData = new RegistryNode(getRegistryURLInfo(),
					getPassword(), null);
			resources = new ArrayList<RegistryResourceNode>();
			for (String resultPath : results) {
				RegistryResourceNode r = new RegistryResourceNode(
						registryData, resultPath, null);
				r.setAllowExapand(false);
				resources.add(r);
			}
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getPassword() {
			return password;
		}

		public String toString() {
			getResources();
			return registryData.toString();
		}
	}
}
