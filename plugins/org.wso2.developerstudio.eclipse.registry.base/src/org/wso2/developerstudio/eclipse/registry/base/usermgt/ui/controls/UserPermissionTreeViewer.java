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

package org.wso2.developerstudio.eclipse.registry.base.usermgt.ui.controls;

import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.registry.base.Activator;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryNode;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryResourceNode;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryResourceType;
import org.wso2.developerstudio.eclipse.registry.base.usermgt.model.RegistryUserPermissionContainer;
import org.wso2.developerstudio.eclipse.registry.core.exception.InvalidRegistryURLException;
import org.wso2.developerstudio.eclipse.registry.core.exception.UnknownRegistryException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ConcurrentLinkedQueue;


public class UserPermissionTreeViewer extends CheckboxTreeViewer implements Observer{
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);
	
	private RegistryUserPermissionContainer registryPermissionContainer;
	private List<RegistryResourceNode> selectedRegistryPathCollections;
	private List<RegistryResourceNode> selectedRegistryPathResources;
	private List<IRegistryTreeItemSelectionListener> registryTreeSelectionListeners;
	private int selectionState = SELECTED_NONE;

	private RegistryNode registryData;

	private String registryResourcePath;

//	private RegistryResourceNode registryResourceNodoParent;
	
	public static final int SELECTED_NONE = 1;
	public static final int SELECTED_REGISTRY = 2;
	public static final int SELECTED_REGISTRY_PATH = 4;
	public static final int SELECTED_REGISTRY_RESOURCE = 8;

	public UserPermissionTreeViewer(Composite parent, int style, RegistryNode registryData, String registryResourcePath) {
	    super(parent, style);
	    this.registryData=registryData;
	    this.registryResourcePath=registryResourcePath;
	    init();
	    setUpProviders();
	    setUpListeners();
	    setUpInput();
	}
	
	private void init(){
		getRegistryContentContainer().addRegistryContent(new RegistryResourceNode(registryData, registryResourcePath, null));
	}


    public void update(Observable o, Object arg) {
	    // TODO Auto-generated method stub
	   
    }
	
	private void setUpInput(){
		setInput(getRegistryContentContainer());
		getRegistryContentContainer().addObserver(this);
	}
	
	private void setUpProviders(){
		setContentProvider(new UserPermissionTreeContentProvider(getTree().getShell()));
		setLabelProvider(new UserPermissionTreeLabelProvider());
	}
	
	/**
	 * set up listeners for tree viewer actions
	 */
	private void setUpListeners() {
		addCheckStateListener(new ICheckStateListener() {
			
			public void checkStateChanged(CheckStateChangedEvent event) {
				Object object=event.getElement();
				List<RegistryResourceNode> allChildNodes = null;
				RegistryResourceNode rrpd = null;
				RegistryResourceType resourceType = null;
					if (object instanceof RegistryResourceNode) {
						rrpd= (RegistryResourceNode) object;
						resourceType=rrpd.getResourceType();
						allChildNodes=getAllChildRegistryResourceNodes(rrpd);
					}
				if(event.getChecked()){
					setSubtreeChecked(rrpd, true);
					if(event.getElement() instanceof RegistryResourceNode && rrpd != null && resourceType != null){
						if (resourceType==RegistryResourceType.RESOURCE) {
							addSelectedRegistryPathResources(rrpd);
						} else if(resourceType==RegistryResourceType.COLLECTION){
							addListSelectedRegistryPathCollections(allChildNodes);
						}else if(resourceType==RegistryResourceType.UNDEFINED){
							addSelectedRegistryPathCollections(null);
						}
					}
				}else{
					setSubtreeChecked(event.getElement(), false);
					if(event.getElement() instanceof RegistryResourceNode && rrpd != null && resourceType != null){
						if (resourceType==RegistryResourceType.RESOURCE) {
							removeSelectedRegistryPathResources(rrpd);
						} else if(resourceType==RegistryResourceType.COLLECTION){
							removeListSelectedRegistryPathCollections(allChildNodes);
						}else if(resourceType==RegistryResourceType.UNDEFINED){
							removeSelectedRegistryPathCollections(null);
						}
					}
					
					//If we are unchecking a child, parent also need to be uncheck first
					if(rrpd.getRegistryResourceNodeParent() != null){
						//This is unchecked
//						setChecked(rrpd.getRegistryResourceNodeParent(), false);
						setParentsUnchecked(rrpd);
						List<RegistryResourceNode> parentNodes=new ArrayList<RegistryResourceNode>();
						getAllParentNodes(rrpd,parentNodes);
						removeListSelectedRegistryPathCollections(parentNodes);
					}
					
//					try {
//	                    if(rrpd.getResourceNodeList().size()==0){
//	                    	//This is a leaf.DeSelect the parent as well.
//	                    	setChecked(rrpd.getRegistryResourceNodeParent(), false);
//	                    }else{
//	                    	//This is not a leaf
//	                    }
//	                    
//                    } catch (InvalidRegistryURLException e) {
//	                    e.printStackTrace();
//                    } catch (UnknownRegistryException e) {
//	                    e.printStackTrace();
//                    }
				}
			}
		});
		

	}

	/**
     * @param registryContentContainer the registryContentContainer to set
     */
    public void setRegistryContentContainer(RegistryUserPermissionContainer registryContentContainer) {
	    this.registryPermissionContainer = registryContentContainer;
    }
    
	/**
	 * add RegistryResourceNode to selected resource node  list
	 * @param selectedRegistryPath
	 */
	public void addSelectedRegistryPathResources(RegistryResourceNode selectedRegistryPath) {
		getSelectedRegistryPathResources().add(selectedRegistryPath);
	}
	
	/**
	 * Remove RegistryResourceNode to selected resource node  list
	 * @param selectedRegistryPath
	 */
	public void removeSelectedRegistryPathResources(RegistryResourceNode selectedRegistryPath) {
		if (getSelectedRegistryPathResources().contains(selectedRegistryPath)) {
	        getSelectedRegistryPathResources().remove(selectedRegistryPath);
        }
	}
	
	/**
	 * add RegistryResourceNode to selected collection node  list
	 * @param selectedRegistryPath
	 */
	public void addSelectedRegistryPathCollections(RegistryResourceNode selectedRegistryPath) {
		getSelectedRegistryPathCollections().add(selectedRegistryPath);
	}
	
	/**
	 * Remove RegistryResourceNode to selected collection node  list
	 * @param selectedRegistryPath
	 */
	public void removeSelectedRegistryPathCollections(RegistryResourceNode selectedRegistryPath) {
		if (getSelectedRegistryPathCollections().contains(selectedRegistryPath)) {
	        getSelectedRegistryPathCollections().remove(selectedRegistryPath);
        }
	}
	
	/**
	 * add RegistryResourceNode to selected collection node  list
	 * @param selectedRegistryPath
	 */
	public void addListSelectedRegistryPathCollections(List<RegistryResourceNode> selectedRegistryPath) {
		List<RegistryResourceNode> selectedPathCollectionList=getSelectedRegistryPathCollections();
		for (Iterator<RegistryResourceNode> iterator = selectedRegistryPath.iterator(); iterator.hasNext();) {
	        RegistryResourceNode registryResourceNode = iterator.next();
	        if(!selectedPathCollectionList.contains(registryResourceNode)){
	        	selectedPathCollectionList.add(registryResourceNode);
	        }
        }
//		getSelectedRegistryPathCollections().addAll(selectedRegistryPath);
	}
	
	/**
	 * Remove RegistryResourceNode to selected collection node  list
	 * @param selectedRegistryPath
	 */
	public void removeListSelectedRegistryPathCollections(List<RegistryResourceNode> selectedRegistryPath) {
		List<RegistryResourceNode> selectedPathCollectionList=getSelectedRegistryPathCollections();
		for (Iterator<RegistryResourceNode> iterator = selectedRegistryPath.iterator(); iterator.hasNext();) {
	        RegistryResourceNode registryResourceNode = iterator.next();
	        if(selectedPathCollectionList.contains(registryResourceNode)){
	        	selectedPathCollectionList.remove(registryResourceNode);
	        }
        }
//		getSelectedRegistryPathCollections().addAll(selectedRegistryPath);
	}

	/**
     * @return the registryContentContainer
     */
    public RegistryUserPermissionContainer getRegistryContentContainer() {
    	if(registryPermissionContainer == null){
			registryPermissionContainer = new RegistryUserPermissionContainer();
    	}
	    return registryPermissionContainer;
    }

	/**
     * @param selectedRegistryPathCollections the selectedRegistryPathCollections to set
     */
    public void setSelectedRegistryPathCollections(List<RegistryResourceNode> selectedRegistryPathCollections) {
	    this.selectedRegistryPathCollections = selectedRegistryPathCollections;
    }

	/**
     * @return the selectedRegistryPathCollections
     */
    public List<RegistryResourceNode> getSelectedRegistryPathCollections() {
    	if(selectedRegistryPathCollections == null){
    		selectedRegistryPathCollections = new ArrayList<RegistryResourceNode>();
    	}
	    return selectedRegistryPathCollections;
    }

	/**
     * @param selectedRegistryPathResources the selectedRegistryPathResources to set
     */
    public void setSelectedRegistryPathResources(List<RegistryResourceNode> selectedRegistryPathResources) {
	    this.selectedRegistryPathResources = selectedRegistryPathResources;
    }

	/**
     * @return the selectedRegistryPathResources
     */
    public List<RegistryResourceNode> getSelectedRegistryPathResources() {
    	if(selectedRegistryPathResources == null){
    		selectedRegistryPathResources = new ArrayList<RegistryResourceNode>();
    	}
	    return selectedRegistryPathResources;
    }

	/**
     * @param selectionState the selectionState to set
     */
    public void setSelectionState(int selectionState) {
	    this.selectionState = selectionState;
    }

	/**
     * @return the selectionState
     */
    public int getSelectionState() {
	    return selectionState;
    }
    
	/**
	 * get registry tree listeners
	 * @return
	 */
	public List<IRegistryTreeItemSelectionListener> getRegistryTreeSelectionListeners() {
		if (registryTreeSelectionListeners == null){
			registryTreeSelectionListeners = new ArrayList<IRegistryTreeItemSelectionListener>();
		}
		return registryTreeSelectionListeners;
	}
    
    /**
	 * trigger RegistryTreeSelectionListeners
	 */
//	private void triggerRegistryTreeSelectionListeners() {
//		for (IRegistryTreeItemSelectionListener r : getRegistryTreeSelectionListeners()) {
//			try {
//				if ((getSelectionState() & SELECTED_NONE) == SELECTED_NONE){
//					r.selectionLost();
//				}else if ((getSelectionState() & SELECTED_REGISTRY_PATH) == SELECTED_REGISTRY_PATH){
//					r.registryPathSelected(getSelectedRegistryPathCollections()
//														.toArray(new RegistryResourceNode[] {}));
//				}else if((getSelectionState() & SELECTED_REGISTRY_RESOURCE) == SELECTED_REGISTRY_RESOURCE){
//					r.registryResourceSelected(getSelectedRegistryPathCollections()
//															.toArray(new RegistryResourceNode[] {}));
//				}
//			} catch (Exception e) {
//				log.error(e);
//			}
//		}
//	}
	
	/**
	 * add registryTreeItem selection listener
	 * @param registryTreeItemSelectionListener
	 */
	public void addRegistryTreeSelectionListener(
							IRegistryTreeItemSelectionListener registryTreeItemSelectionListener) {
		if (registryTreeItemSelectionListener != null){
			getRegistryTreeSelectionListeners().add(registryTreeItemSelectionListener);
		}
	}
	
	/**
	 * 
	 * interface IRegistryTreeItemSelectionListener
	 *
	 */
	public static interface IRegistryTreeItemSelectionListener {
		public void registrySelected(RegistryNode[] registryNode);

		public void registryPathSelected(RegistryResourceNode[] registryResourceNode);

		public void registryResourceSelected(RegistryResourceNode[] registryResourceNode);

		public void selectionLost();
	}
	
	private void setParentsUnchecked(RegistryResourceNode regResourceNode){
		RegistryResourceNode registryResourceNodeParent = regResourceNode.getRegistryResourceNodeParent();
		if(registryResourceNodeParent != null){
			setChecked(registryResourceNodeParent, false);
			setParentsUnchecked(registryResourceNodeParent);
		}
	}
	
	private void getAllParentNodes(RegistryResourceNode regResourceNode, List<RegistryResourceNode> items){
		RegistryResourceNode registryResourceNodeParent = regResourceNode.getRegistryResourceNodeParent();
		if(registryResourceNodeParent != null){
			items.add(registryResourceNodeParent);
			getAllParentNodes(registryResourceNodeParent,items);
		}
	}


	private List<RegistryResourceNode> getAllChildRegistryResourceNodes(RegistryResourceNode parent){
		List<RegistryResourceNode> list=new ArrayList<RegistryResourceNode>();
		ConcurrentLinkedQueue<RegistryResourceNode> queue=new ConcurrentLinkedQueue<RegistryResourceNode>();
		queue.add(parent);
		list.add(parent);
		List<RegistryResourceNode> items = new ArrayList<RegistryResourceNode>();
		while (queue.peek() != null) {
			RegistryResourceNode node = queue.poll();
			try {
				items = node.getResourceNodeList();
			} catch (InvalidRegistryURLException e) {
				e.printStackTrace();
			} catch (UnknownRegistryException e) {
				e.printStackTrace();
			}
			list.addAll(items);
			queue.addAll(items);
		}	
		return list;
	}
	
//	private void setParentsGray(RegistryResourceNode regResourceNode, boolean state){
//		RegistryResourceNode registryResourceNodeParent = regResourceNode.getRegistryResourceNodeParent();
//		if(registryResourceNodeParent != null && !regResourceNode.getCaption().equals("permission")){
//			if(getChecked(registryResourceNodeParent)){
//				setGrayChecked(registryResourceNodeParent,state);
//			}else{
//				setGrayed(registryResourceNodeParent, state);
//			}
//			setParentsGray(registryResourceNodeParent,state);
//		}
//	}
	
//	private void setChildrenGrayed(RegistryResourceNode regResourceNode,boolean state){
//		for (RegistryResourceNode item : getAllChildRegistryResourceNodes(regResourceNode)) {
//	        setGrayed(item, state);
//        }
//	}
}
