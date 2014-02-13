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
import java.util.List;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.wso2.developerstudio.appfactory.core.model.AppListModel;
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
		  this.apps = (List<ApplicationInfo>) newInput;
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
      if(app.getappVersionList()!=null){
      return app.getappVersionList().toArray();
      }
    }
    return null;
  }

  @Override
  public Object getParent(Object element) {
    return null;
  }

  @Override
  public boolean hasChildren(Object element) {
    if (element instanceof ApplicationInfo) {
      return true;
    }
    return false;
  }

} 