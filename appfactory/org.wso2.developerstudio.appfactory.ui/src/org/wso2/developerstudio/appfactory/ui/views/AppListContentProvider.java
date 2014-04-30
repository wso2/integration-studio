/*
 * Copyright (c) 2012, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.appfactory.ui.views;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.wso2.developerstudio.appfactory.core.model.AppListModel;
import org.wso2.developerstudio.appfactory.core.model.AppVersionGroup;
import org.wso2.developerstudio.appfactory.core.model.AppVersionInfo;
import org.wso2.developerstudio.appfactory.core.model.ApplicationInfo;



public class AppListContentProvider implements ITreeContentProvider {

  private AppListModel model;
  List<ApplicationInfo> apps;
  public AppListContentProvider(List<ApplicationInfo> apps) {
	  this.apps = apps;
  }
  @Override
  public void dispose() {
  }

  @Override
  public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
	  if(newInput instanceof AppListModel){
        this.model = (AppListModel) newInput;
	  }else if (newInput instanceof List){
		  @SuppressWarnings("unchecked")
        List<ApplicationInfo> newInput2 = (List<ApplicationInfo>) newInput;
		this.apps = newInput2;
	  }
  }

  @Override
  public Object[] getElements(Object inputElement) {
    return model.getCategories(apps).toArray();
  }

  @Override
  public Object[] getChildren(Object parentElement) {

	  if (parentElement instanceof ApplicationInfo) {
		  ApplicationInfo app = (ApplicationInfo) parentElement;
		  List<AppVersionGroup> versionGroups = new ArrayList<AppVersionGroup>();

		  for (AppVersionInfo mainVersion : app.getappVersionList()) {

			  AppVersionGroup group = new AppVersionGroup(app, mainVersion.getVersion(),
			                                              mainVersion);
			  mainVersion.setVersionGroup(group);
			  for (AppVersionInfo forkedVersion : app.getForkedversions()) {
				  if (forkedVersion.getVersion().equals(mainVersion.getVersion())) {
					  forkedVersion.setVersionGroup(group);
					  group.setForkedVersion(forkedVersion);
				  }
			  }
			  versionGroups.add(group);
		  }
		  return versionGroups.toArray();
	  } else if (parentElement instanceof AppVersionGroup) {

		  AppVersionGroup versionGroup = (AppVersionGroup) parentElement;
		  List<AppVersionInfo> versions = new ArrayList<AppVersionInfo>();
		  versions.add(versionGroup.getMainVersion());

		  if (versionGroup.getForkedVersion() != null) {
			  versions.add(versionGroup.getForkedVersion());
		  }
		  return versions.toArray();
	  }
	  return null;
  }

  @Override
  public Object getParent(Object element) {
	  if (element instanceof AppVersionGroup) {
		  return ((AppVersionGroup) element).getApplication();
	  } else if (element instanceof AppVersionInfo) {
		  return ((AppVersionInfo) element).getVersionGroup();
	  }
	  return null;
  }

  @Override
  public boolean hasChildren(Object element) {
	  if (element instanceof ApplicationInfo) {
		  return !((ApplicationInfo) element).getappVersionList().isEmpty();
	  } else if (element instanceof AppVersionGroup) {
		  return ((AppVersionGroup) element).getMainVersion() != null;
	  }
	  return false;
  }

} 