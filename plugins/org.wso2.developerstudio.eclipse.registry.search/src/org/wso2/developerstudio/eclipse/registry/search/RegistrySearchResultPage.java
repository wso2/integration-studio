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

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.search.internal.ui.text.FileSearchPage;
import org.eclipse.search.ui.ISearchResult;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.wso2.developerstudio.eclipse.registry.base.editor.input.ResourceEditorInput;
import org.wso2.developerstudio.eclipse.registry.base.logger.ExceptionHandler;
import org.wso2.developerstudio.eclipse.registry.base.managers.RemoteContentManager;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryResourceNode;
import org.wso2.developerstudio.eclipse.registry.base.ui.controls.RegistryTreeContentProvider;
import org.wso2.developerstudio.eclipse.registry.base.ui.controls.RegistryTreeLabelProvider;
import org.wso2.developerstudio.eclipse.registry.base.ui.util.ImageUtils;
import org.wso2.developerstudio.eclipse.registry.search.RegistrySearchQuery.RegistrySearchResult;

public class RegistrySearchResultPage extends FileSearchPage {

	public void setInput(ISearchResult newSearch, Object viewState) {
		super.setInput(newSearch, viewState);
	}

	protected TreeViewer createTreeViewer(Composite parent) {
		return super.createTreeViewer(parent);
	}

	protected void fillContextMenu(IMenuManager mgr) {

	}

	protected void configureTreeViewer(TreeViewer viewer) {
		super.configureTreeViewer(viewer);
		viewer.refresh();
		viewer.setContentProvider(new RegistryTreeContentProvider(
				new ExceptionHandler(), getSite().getShell()) {
			public void inputChanged(Viewer viewer, Object arg1, Object arg2) {
				super.inputChanged(viewer, arg1, arg2);
				if (arg2 instanceof SearchResult) {
					SearchResult s = (SearchResult) arg2;
					RegistrySearchQuery t = (RegistrySearchQuery) s.getQuery();
					t.setViewer((TreeViewer) viewer);
				}

			}

			public Object[] getChildren(Object obj) {
				if (obj instanceof SearchResult) {
					SearchResult s = (SearchResult) obj;
					RegistrySearchQuery t = (RegistrySearchQuery) s.getQuery();
					return t.getResults().toArray(new Object[] {});
				} else if (obj instanceof RegistrySearchResult) {
					RegistrySearchResult r = (RegistrySearchResult) obj;
					return r.getResources().toArray();
				} else
					return super.getChildren(obj);
			}

			public boolean hasChildren(Object obj) {
				if (obj instanceof SearchResult)
					return true;
				else if (obj instanceof RegistrySearchResult) {
					RegistrySearchResult r = (RegistrySearchResult) obj;
					return true;
				} else
					return super.hasChildren(obj);
			}

		});

		viewer.setLabelProvider(new RegistryTreeLabelProvider() {
			public Image getImage(Object element) {
				ImageDescriptor descriptor = null;
				if (element instanceof RegistrySearchResult) {
					descriptor = ImageUtils
							.getImageDescriptor(ImageUtils.ICON_REGISTRY_SEARCH);
					return descriptor.createImage();
				} else
					return super.getImage(element);
			}

		});

		viewer.addDoubleClickListener(new IDoubleClickListener() {

			public void doubleClick(DoubleClickEvent evt) {
				if (evt.getSource() instanceof TreeViewer) {
					TreeViewer v = (TreeViewer) evt.getSource();
					if (v.getSelection() instanceof ITreeSelection) {
						ITreeSelection t = (ITreeSelection) v.getSelection();
						if (t.getFirstElement() instanceof RegistryResourceNode) {
							RegistryResourceNode r = (RegistryResourceNode) t
									.getFirstElement();
							ResourceEditorInput ei = RemoteContentManager
									.getEditorInput(r);
							RemoteContentManager.openFormEditor(ei);
						}
					}
				}
			}
		});

	}

}
