/*
 * Copyright (c) 2013, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.inject.Inject;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.apache.maven.shared.invoker.DefaultInvocationRequest;
import org.apache.maven.shared.invoker.DefaultInvoker;
import org.apache.maven.shared.invoker.InvocationRequest;
import org.apache.maven.shared.invoker.InvocationResult;
import org.apache.maven.shared.invoker.Invoker;
import org.apache.maven.shared.invoker.MavenInvocationException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.di.UISynchronize;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jgit.api.errors.CheckoutConflictException;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidRefNameException;
import org.eclipse.jgit.api.errors.InvalidRemoteException;
import org.eclipse.jgit.api.errors.RefAlreadyExistsException;
import org.eclipse.jgit.api.errors.RefNotFoundException;
import org.eclipse.jgit.api.errors.TransportException;
import org.eclipse.m2e.core.MavenPlugin;
import org.eclipse.m2e.core.embedder.MavenModelManager;
import org.eclipse.m2e.core.project.IMavenProjectImportResult;
import org.eclipse.m2e.core.project.IProjectConfigurationManager;
import org.eclipse.m2e.core.project.LocalProjectScanner;
import org.eclipse.m2e.core.project.MavenProjectInfo;
import org.eclipse.m2e.core.project.ProjectImportConfiguration;
import org.eclipse.m2e.core.project.ResolverConfiguration;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.console.MessageConsoleStream;
import org.eclipse.ui.part.ViewPart;
import org.osgi.framework.Bundle;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventHandler;
import org.wso2.developerstudio.appfactory.core.authentication.Authenticator;
import org.wso2.developerstudio.appfactory.core.authentication.UserPasswordCredentials;
import org.wso2.developerstudio.appfactory.core.client.HttpsJaggeryClient;
import org.wso2.developerstudio.appfactory.core.client.HttpsJenkinsClient;
import org.wso2.developerstudio.appfactory.core.jag.api.JagApiProperties;
import org.wso2.developerstudio.appfactory.core.model.AppListModel;
import org.wso2.developerstudio.appfactory.core.model.AppVersionGroup;
import org.wso2.developerstudio.appfactory.core.model.AppVersionInfo;
import org.wso2.developerstudio.appfactory.core.model.ApplicationInfo;
import org.wso2.developerstudio.appfactory.core.repository.JgitRepoManager;
import org.wso2.developerstudio.appfactory.ui.Activator;
import org.wso2.developerstudio.appfactory.ui.actions.LoginAction;
import org.wso2.developerstudio.appfactory.ui.utils.Messages;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.core.utils.SWTResourceManager;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

public class AppfactoryApplicationListView extends ViewPart {
	
	public static final String ID = "org.wso2.developerstudio.appfactory.ui.views.AppfactoryView"; //$NON-NLS-1$
	public static final String REPO_WIZARD_ID = "org.eclipse.egit.ui.internal.clone.GitCloneWizard"; //$NON-NLS-1$
	public static final String FORKED_REPO_SUFFIX = "_forked";
	public static final String MAIN_REPO_SUFFIX = "_main";
	private static final String MAVEN_CMD_INSTALL = "install";
	private static final String MAVEN_CMD_CLEAN = "clean";
	private static final String MAVEN_CMD_ECLIPSE = "eclipse:eclipse";
	private static final String PROJECT_DESCRIPTOR = ".project";
	

	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);
	
	private static AppfactoryApplicationDetailsView appDetailView;
	
	@Inject UISynchronize uISync;
	
	private TreeViewer viewer;
	//private Composite parent; 
	private AppListModel model;
	private AppListLabelProvider labelProvider;
	private AppListContentProvider contentProvider;
	private UserPasswordCredentials credentials;
	private List<ApplicationInfo> appLists;
	private MenuManager menuMgr;
	private IEventBroker broker;
	private EventHandler buildhandler;
	private EventHandler ErrorLoghandler;
	private EventHandler infoLoghandler;
	private EventHandler apphandler;
	private EventHandler appVersionhandler;
	private EventHandler projectOpenhandler;
	private AppfactoryConsoleView console;
	private MessageConsoleStream infoOut;
	private MessageConsoleStream errorOut;
	private MessageConsoleStream buildOut;
	private IToolBarManager toolBarmgr;
	@SuppressWarnings("restriction")
	@Override
	public void init(IViewSite site) throws PartInitException {

		super.init(site);
		appLists = new ArrayList<ApplicationInfo>();
		console = new AppfactoryConsoleView();
		infoOut = console.getOut();
		errorOut = console.getNewMsgStream();
		buildOut = console.getNewMsgStream();
		Bundle bundle = Platform.getBundle(Activator.PLUGIN_ID);
		 
		IEclipseContext eclipseContext = EclipseContextFactory
				.getServiceContext(bundle.getBundleContext());
		eclipseContext.set(org.eclipse.e4.core.services.log.Logger.class, null);
		broker = eclipseContext.get(IEventBroker.class);
		doSubscribe();/*Subscribe UIhandler with EventBroker*/
		Authenticator.getInstance().setLoaded(true);
	}

	@Override
	public void dispose() {
	   	doUnSubscribe();
	   	Authenticator.getInstance().setLoaded(false);
		super.dispose();
	}
	
	

	public void createPartControl(Composite parent) {
      //  this.parent = parent;
        contentProvider = new AppListContentProvider(appLists);
        labelProvider = new AppListLabelProvider();
        createToolbar();
        model =new AppListModel();
		  viewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		  viewer.setContentProvider(contentProvider);
		  viewer.setLabelProvider(labelProvider);
		  viewer.setInput(model);
		  viewer.addSelectionChangedListener(new ISelectionChangedListener() {
			
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
			try {
					final IStructuredSelection selection = (IStructuredSelection) viewer
							.getSelection();
					Object selectedNode = selection.getFirstElement();
					ApplicationInfo appInfo = null;
					
					if (selectedNode instanceof ApplicationInfo) {
						appInfo = (ApplicationInfo) selection
								.getFirstElement();						
					}
					else if(selectedNode instanceof AppVersionGroup)					
					{
						appInfo = ((AppVersionGroup)selection.getFirstElement()).getApplication();
					}
					else if(selectedNode instanceof AppVersionInfo)					
					{
						appInfo = ((AppVersionInfo)selection.getFirstElement()).getVersionGroup().getApplication();
					}
					appDetailView.clear();
					if (!appInfo.getappVersionList().isEmpty()) {
						appDetailView.updateView(appInfo);
					}
				} catch (Throwable e) {
				  /*safe to ignore*/
				} 
			}
			 
		});
		  viewer.addDoubleClickListener(new IDoubleClickListener() {

		      @Override
		      public void doubleClick(DoubleClickEvent event) {
				try {
					TreeViewer viewer = (TreeViewer) event.getViewer();
					IStructuredSelection thisSelection = (IStructuredSelection) event
							.getSelection();
					Object selectedNode = thisSelection.getFirstElement();
					if (selectedNode instanceof AppVersionInfo) {
						viewer.setExpandedState(selectedNode,
								!viewer.getExpandedState(selectedNode));
					}else if (selectedNode instanceof AppVersionGroup) {
						viewer.setExpandedState(selectedNode,
								!viewer.getExpandedState(selectedNode));
                    } else if (selectedNode instanceof ApplicationInfo) {
                        ApplicationInfo appInfo = (ApplicationInfo) selectedNode;
                        if (appInfo.isLoaded()) {
                            viewer.setExpandedState(selectedNode, !viewer.getExpandedState(selectedNode));
                        } else {
                            getAppVersions(appInfo);
                            getDataSources(appInfo);
                        }
                    }
				} catch (Throwable e) {
					  /*safe to ignore*/
				 } 
		      }
		    });
		    
		    menuMgr = new MenuManager();
	        Menu menu = menuMgr.createContextMenu(viewer.getControl());
	        menu.setVisible(true);
	        menuMgr.addMenuListener(new IMenuListener() {
	            @Override
	            public void menuAboutToShow(final IMenuManager manager) {
	                try {
						if (viewer.getSelection().isEmpty()) {
						    return;
						}

						if (viewer.getSelection() instanceof IStructuredSelection) {
						    IStructuredSelection selection = (IStructuredSelection) viewer.getSelection();
						    if(selection.getFirstElement() instanceof AppVersionInfo){
						       final AppVersionInfo appVersionInfo = (AppVersionInfo) selection.getFirstElement();
						        
						        manager.add(checkOutAndImportAction(appVersionInfo));
						        manager.add(importAction(appVersionInfo));
						    	manager.add(checkOutAction(appVersionInfo));
						    	manager.add(buildAction(appVersionInfo));
						    	if(!appVersionInfo.isForkedVersion()){
						    		manager.add(repoDeployAction(appVersionInfo));
						    	}
						    	manager.add(buildInfoAction(appVersionInfo)); 
						    	
						    	
						    	
						    }else if (selection.getFirstElement() instanceof ApplicationInfo){
						    	ApplicationInfo appInfo = (ApplicationInfo) selection.getFirstElement();
						    	String title =""; //$NON-NLS-1$
						    	
						        if(appInfo.getappVersionList().isEmpty()){
						        	title = "Open  "; //$NON-NLS-1$
						        }else{
						        	title = "Update"; //$NON-NLS-1$
						        }
						        
						      
						    	manager.add(appOpenAction(appInfo,title));
						        manager.add(mainRepoSettingsAction(appInfo));
						        manager.add(forkedRepoSettingsAction(appInfo));
						    }else if (selection.getFirstElement() instanceof AppVersionGroup){
						    	
						    //	AppVersionGroup group = (AppVersionGroup) selection.getFirstElement();
						    	// TODO     	
						    }
						}
					} catch (Throwable e) {
						 /*safe to ignore*/
					}
	            }

			
	        });
	        menuMgr.setRemoveAllWhenShown(true);
	        viewer.getControl().setMenu(menu);
	        updateApplicationView();
	}

	public static AppfactoryApplicationDetailsView getAppDetailView() {
	    return appDetailView;
    }

	public static void setAppDetailView(AppfactoryApplicationDetailsView appDetailView) {
	    AppfactoryApplicationListView.appDetailView = appDetailView;
    }
	
	@Override
	public void setFocus() {
	
	}
	

	
	private void doSubscribe() {
		 
		buildhandler = getBuildLogEventHandler();
		broker.subscribe("update", buildhandler); //$NON-NLS-1$
			
		apphandler = getAppListHandler();
		broker.subscribe("Appupdate", apphandler); //$NON-NLS-1$
 
		appVersionhandler = getAppVersionEventHandler();
		broker.subscribe("Appversionupdate", appVersionhandler); //$NON-NLS-1$
		
		ErrorLoghandler = getErrorLogEventHandler();
		broker.subscribe("Errorupdate",ErrorLoghandler); //$NON-NLS-1$
		
		infoLoghandler = getInfoLogEventHandler();
		broker.subscribe("Infoupdate",infoLoghandler); //$NON-NLS-1$
		
		projectOpenhandler = getPorjectcheckedOUtHandler();
		broker.subscribe("Projectupdate",projectOpenhandler); //$NON-NLS-1$
	}
	
	private void doUnSubscribe() {
		broker.unsubscribe(buildhandler); //$NON-NLS-1$
		broker.unsubscribe(apphandler); //$NON-NLS-1$
		broker.unsubscribe(appVersionhandler); //$NON-NLS-1$
		broker.unsubscribe(ErrorLoghandler); //$NON-NLS-1$
		broker.unsubscribe(infoLoghandler); //$NON-NLS-1$
		broker.unsubscribe(projectOpenhandler); //$NON-NLS-1$
	}
	private void printErrorLog(String msg){
		 broker.send("Errorupdate", "\n"+"["+new Timestamp(new Date().getTime()) +"] : "+msg); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
	}
	
	private void printInfoLog(String msg){
		 broker.send("Infoupdate", "\n"+"["+new Timestamp(new Date().getTime()) +"] : "+msg); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
	}

	private EventHandler getAppListHandler() {
		return new EventHandler() {
			public void handleEvent(final Event event) {
 
				Display.getDefault().asyncExec(new Runnable() {
					@SuppressWarnings({ "unchecked" })
					@Override
					public void run() {
            			List<ApplicationInfo> oldappLists = appLists;
						appLists =  (List<ApplicationInfo>) event.getProperty(IEventBroker.DATA);
            			contentProvider.inputChanged(viewer, oldappLists, appLists);
            			viewer.refresh();
            		 
					}
				});
			}
		};
	}
	
	private EventHandler getPorjectcheckedOUtHandler() {
		return new EventHandler() {
			public void handleEvent(final Event event) {
 
				Display.getDefault().asyncExec(new Runnable() {
					@Override
					public void run() {
						try {
							contentProvider.inputChanged(viewer, model, model);
							viewer.refresh();				
						} catch (Exception e) {
							 log.error("checkedoutError", e); //$NON-NLS-1$
						}

					}
				});
			}
		};
	}

	private EventHandler getAppVersionEventHandler() {
		return new EventHandler() {
			public void handleEvent(final Event event) {
 
				Display.getDefault().asyncExec(new Runnable() {

					@Override
					public void run() {
						AppListModel refModel = (AppListModel) event.getProperty(IEventBroker.DATA);
						contentProvider.inputChanged(viewer, model, refModel);
						viewer.refresh();
					}
				});
			}
		};
	}
	
	private EventHandler getBuildLogEventHandler() {
		return new EventHandler() {
			public void handleEvent(final Event event) {
				@SuppressWarnings("unused")
				final Display display = Display.getDefault();
				Display.getDefault().asyncExec(new Runnable() {

					@Override
					public void run() {
						buildOut.setColor(SWTResourceManager.getColor(SWT.COLOR_DARK_CYAN));
						buildOut.println(""+event.getProperty(IEventBroker.DATA)); //$NON-NLS-1$
					}
				});
			}
		};
	}
	
	private EventHandler getErrorLogEventHandler() {
		return new EventHandler() {
			public void handleEvent(final Event event) {
				
				Display.getDefault().asyncExec(new Runnable() {

					@Override
					public void run() {
						errorOut.setColor(SWTResourceManager.getColor(SWT.COLOR_RED));
						errorOut.println("\n\n**********[ERROR]**********" + event.getProperty(IEventBroker.DATA)); //$NON-NLS-1$
					}
				});
			}
		};
	}
	
	private EventHandler getInfoLogEventHandler() {
		return new EventHandler() {
			public void handleEvent(final Event event) {
				Display.getDefault().asyncExec(new Runnable() {

					@Override
					public void run() {
						infoOut.setColor(SWTResourceManager.getColor(SWT.COLOR_BLACK));
						infoOut.println("\n\n**********[INFO]**********" + event.getProperty(IEventBroker.DATA)); //$NON-NLS-1$
					}
				});
			}
		};
	}
	
	private void ShowLoginDialog(){
		 credentials = Authenticator.getInstance().getCredentials();
		 try{
		 if(credentials==null){
			 printErrorLog(Messages.AppfactoryApplicationListView_ShowLoginDialog_plog_msg_1);
			 LoginAction loginAction = new LoginAction();
			 printInfoLog(Messages.AppfactoryApplicationListView_ShowLoginDialog_plog_msg_2);
			 if(loginAction.login(false,false)){
				 printInfoLog(Messages.AppfactoryApplicationListView_ShowLoginDialog_plog_msg_3);
				 credentials = Authenticator.getInstance().getCredentials();
			 }
		 } 
		 }catch(Exception e){
			 /*safe to ignore*/
		 } 
	}
	
    private List<ApplicationInfo> getApplist() {
        if (Authenticator.getInstance().getCredentials() != null) {
            Map<String, String> params = new HashMap<String, String>();
            params.put("action", JagApiProperties.USER_APP_LIST__ACTION); //$NON-NLS-1$
            params.put("userName", Authenticator.getInstance().getCredentials().getUser()); //$NON-NLS-1$
            printInfoLog(Messages.AppfactoryApplicationListView_getApplist_plog_msg_001);
            String respond = HttpsJaggeryClient.httpPost(JagApiProperties.getAppInfoUrl(), params);
            if ("false".equals(respond)) { //$NON-NLS-1$
                printErrorLog(Messages.AppfactoryApplicationListView_getApplist_plog_msg_01);
                boolean loginSuccessful = Authenticator.getInstance().reLogin();
                if (loginSuccessful) {
                    printInfoLog(Messages.AppfactoryApplicationListView_getApplist_plog_msg_0);
                    respond = HttpsJaggeryClient.httpPost(JagApiProperties.getAppInfoUrl(), params);
                } else {
                    printErrorLog(Messages.AppfactoryApplicationListView_getApplist_plog_msg_1
                            + Messages.AppfactoryApplicationListView_getApplist_plog_msg_2);
                }
            }
            if (!"false".equals(respond)) { //$NON-NLS-1$
                printInfoLog(Messages.AppfactoryApplicationListView_getApplist_plog_msg_3);
                Gson gson = new Gson();
                Type collectionType = new TypeToken<java.util.List<ApplicationInfo>>() {
                }.getType();
                List<ApplicationInfo> appList = gson.fromJson(respond, collectionType);
                List<ApplicationInfo> filteredAppList = new ArrayList<>();
                for (ApplicationInfo applicationInfo : appList) {
                    /*
                     * filter out following Uploaded app types from the list -
                     * Uploaded-App-Jax-RS
                     * Uploaded-binary-App-war
                     * Uploaded-App-Jax-WS
                     * Uploaded-App-Jaggery
                     */
                    if (applicationInfo.getType().startsWith("Uploaded-")) { //$NON-NLS-1$
                        continue;
                    } else {
                        filteredAppList.add(applicationInfo);
                    }
                }
                return filteredAppList;
            }
        }
        return new ArrayList<ApplicationInfo>();
    }
 
    private void createToolbar() {
    	toolBarmgr = getViewSite().getActionBars().getToolBarManager();
             
    	toolBarmgr.add(new Action() {
              	 @Override
              	public void run() {
        			 LoginAction loginAction;
					try {
						 loginAction = new LoginAction();
	        			 if(loginAction.login(false,true)){
	        				 printInfoLog(Messages.AppfactoryApplicationListView_ShowLoginDialog_plog_msg_3);
	        				 credentials = Authenticator.getInstance().getCredentials();
	        				 updateApplicationView();
	        				 setText(credentials.getUser());
	        			 }
					} catch (Exception e) {
						 /*safe to ignore*/
					}
              	}
              	 
              	 public String getText() {
       				return "Re-login";
       			}
              	 
             	@Override
    			public ImageDescriptor getImageDescriptor() {
    				ImageDescriptor imageDescriptorFromPlugin = Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID,
    						 "/icons/users.gif"); //$NON-NLS-1$
    				return  imageDescriptorFromPlugin;
    			}
             	
             	@Override
             	public String getToolTipText() {
             		    if(Authenticator.getInstance().getCredentials()!=null){
             		return Authenticator.getInstance().getCredentials().getUser();
             		    }else{
             		    	return "Login";
             		    }
             	}
             	
             	
   			});
    	toolBarmgr.add(new Action() {
           	 @Override
           	public void run() {
           		updateApplicationView();
           	}
 
           	public ImageDescriptor getImageDescriptor() {
				ImageDescriptor imageDescriptorFromPlugin = Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID,
						 "/icons/refresh.gif"); //$NON-NLS-1$
				return  imageDescriptorFromPlugin;
			}
         	
         	@Override
         	public String getToolTipText() {
         		return Messages.AppfactoryApplicationListView_createToolbar_refresh_menu;
         	}
           	 
           	 
			});
            
            
    }
	
	private void  updateApplicationView(){
		Job job = new Job(Messages.AppfactoryApplicationListView_updateApplicationView_job_title) {
		   @Override
			  protected IStatus run(final IProgressMonitor monitor) {
				monitor.beginTask(Messages.AppfactoryApplicationListView_updateApplicationView_monitor_text_0, 100);
				  UISynchronize uiSynchronize = new UISynchronize() {
						@Override
						public void syncExec(Runnable runnable) {
							
						}
						
						@Override
						public void asyncExec(Runnable runnable) {
							   monitor.subTask(Messages.AppfactoryApplicationListView_updateApplicationView_monitor_text_1);
							   monitor.worked(10);
							   List<ApplicationInfo> applist = getApplist();
							   monitor.worked(40);
							   if(applist!=null){
								monitor.subTask(Messages.AppfactoryApplicationListView_updateApplicationView_monitor_text_2);
								monitor.worked(60);	   
							   broker.send("Appupdate", applist); //$NON-NLS-1$
							   monitor.worked(90);	
							   }else{
							     monitor.subTask(Messages.AppfactoryApplicationListView_updateApplicationView_monitor_text_3);
							     monitor.worked(30);
								 monitor.worked(0);	      
							   }
						}
					};
					uiSynchronize.asyncExec(new Runnable() {
						@Override
						public void run() {
						
						}
					});
					
			    return Status.OK_STATUS;
			  }
			};
		job.schedule();
	}
	
	
	private void updateUI(final ApplicationInfo appInfo){
		Display.getDefault().asyncExec(new Runnable() {
		      public void run() {
		         viewer.refresh();
		         appDetailView.updateView(appInfo);
		         viewer.setExpandedState(appInfo, !viewer.getExpandedState(appInfo));
		      }
		});
			
	}
	
	private void  getAppVersions(final ApplicationInfo appInfo){
		
		Job job = new Job(Messages.AppfactoryApplicationListView_getAppVersions_job_title) {
			  @Override
			  protected IStatus run(final IProgressMonitor monitor) {
				monitor.beginTask(Messages.AppfactoryApplicationListView_getAppVersions_monitor_text_1, 100);

				appInfo.setLableState(1);
				broker.send("Appversionupdate", model); //$NON-NLS-1$
				if(getVersionInfo(appInfo, new SubProgressMonitor(monitor, 33))){
					getForkedVersionsInfo(appInfo, new SubProgressMonitor(monitor, 33));
					getTeamInfo(appInfo, new SubProgressMonitor(monitor, 34));
					//getDbInfo(appInfo, monitor);/*currently not supporting*/
					appInfo.setLableState(2);
					appInfo.setLoaded(true);
                } else {
                    appInfo.setLableState(0);
                }
				updateUI(appInfo);
				monitor.done();
				
			    return Status.OK_STATUS;
			  }
			  
			  private boolean getVersionInfo(
						final ApplicationInfo appInfo,
						final IProgressMonitor monitor) {
					monitor.beginTask(Messages.AppfactoryApplicationListView_getVersionInfo_monitor_text_2, 100);
					monitor.worked(20);	   
					boolean result = model.setversionInfo(appInfo);
					if(!result){
						boolean reLogin = Authenticator.getInstance().reLogin();
						if(reLogin){
							result = model.setversionInfo(appInfo);
						}
					}
					if(result){
					monitor.subTask(Messages.AppfactoryApplicationListView_getVersionInfo_monitor_text_3);
					monitor.worked(60);	 
					broker.send("Appversionupdate", model); //$NON-NLS-1$
					monitor.worked(20);
					monitor.done();
					return true;
					}else{
					    monitor.worked(80);
	                    monitor.done();
						return false;
					}
				}
				
				private boolean getForkedVersionsInfo(
						final ApplicationInfo appInfo,
						final IProgressMonitor monitor) {
					monitor.beginTask(Messages.AppfactoryApplicationListView_getForkedAppVersions_monitor_text_1, 100);
					monitor.worked(20);	   
					boolean result = model.setForkedRepoInfo(appInfo);
					if(!result){
						boolean reLogin = Authenticator.getInstance().reLogin();
						if(reLogin){
							result = model.setForkedRepoInfo(appInfo);
						}
					}
					if(result){
					monitor.subTask(Messages.AppfactoryApplicationListView_getVersionInfo_monitor_text_3);
					monitor.worked(60);	 
					broker.send("Appversionupdate", model); //$NON-NLS-1$
					monitor.worked(20);
					return true;
					}else{
					    monitor.worked(80);
                        monitor.done();
						return false;
					}
				}
				
				private boolean getTeamInfo(final ApplicationInfo appInfo,
						final IProgressMonitor monitor) {
					monitor.beginTask(Messages.AppfactoryApplicationListView_getTeamInfo_monitor_text_1, 100);
					monitor.worked(20);	   
					boolean result = model.setRoleInfomation(appInfo);
					if(!result){
						boolean reLogin = Authenticator.getInstance().reLogin();
						if(reLogin){
							result = model.setRoleInfomation(appInfo);
						}
					}
					if(result){
					monitor.subTask(Messages.AppfactoryApplicationListView_getTeamInfo_monitor_text_2);
					monitor.worked(60);	 
					broker.send("Appversionupdate", model); //$NON-NLS-1$
					monitor.worked(20);
					monitor.done();
					return true;
					}else{
					    monitor.worked(80);
                        monitor.done();
						return false;
					}
				}
				/*Currently not supporting*/
				@SuppressWarnings("unused")
				private boolean getDbInfo(final ApplicationInfo appInfo,
						final IProgressMonitor monitor) {
					monitor.beginTask(Messages.AppfactoryApplicationListView_getDbInfo_monitor_text_1, 100);
					monitor.worked(20);	   
					boolean result = model.setDBInfomation(appInfo);
					if(!result){
						boolean reLogin = Authenticator.getInstance().reLogin();
						if(reLogin){
							result = model.setDBInfomation(appInfo);
						}
					}
					if(result){
					monitor.subTask(Messages.AppfactoryApplicationListView_getDbInfo_monitor_text_2);
					monitor.worked(60);	 
					broker.send("Appversionupdate", model); //$NON-NLS-1$
					monitor.worked(20);
					monitor.done();
					return true;
					}else{
					    monitor.worked(80);
                        monitor.done();
						return false;
					}
				}				
			};
		job.schedule();
	}
	
    private void getDataSources(final ApplicationInfo appInfo) {
        Job job = new Job("Loading datasources") {
            @Override
            protected IStatus run(IProgressMonitor monitor) {
                monitor.beginTask("Loading datasources", 100);
                getDSInfo(appInfo, new SubProgressMonitor(monitor, 80));
                updateUI(appInfo);
                monitor.done();
                return Status.OK_STATUS;
            }

            private boolean getDSInfo(final ApplicationInfo appInfo, final IProgressMonitor monitor) {
                monitor.beginTask(Messages.AppfactoryApplicationListView_getDSInfo_monitor_text_2, 100);
                monitor.worked(20);
                boolean result = model.setDSInfomation(appInfo);
                if (!result) {
                    boolean reLogin = Authenticator.getInstance().reLogin();
                    if (reLogin) {
                        result = model.setDSInfomation(appInfo);
                    }
                }
                if (result) {
                    monitor.subTask(Messages.AppfactoryApplicationListView_getDSInfo_monitor_text_3);
                    monitor.worked(60);
                    broker.send("Appversionupdate", model); //$NON-NLS-1$
                    monitor.worked(20);
                    monitor.done();
                    return true;
                } else {
                    monitor.worked(80);
                    monitor.done();
                    return false;
                }
            }
        };
        job.schedule();
    }
 
	private void getbuildLogsJob(final AppVersionInfo appInfo,final boolean deploy) { 
		Job job = new Job(Messages.AppfactoryApplicationListView_getbuildLogsJob_title) { 
			@Override
			protected IStatus run(final IProgressMonitor monitor) {
				UISynchronize uiSynchronize = new UISynchronize() {
					@Override
					public void syncExec(Runnable runnable) {

					}
					@Override
					public void asyncExec(Runnable runnable) {
						try {
							/*Getting last build ID*/
						    int buildId = getLastBuildId(appInfo);
						    // get logs of the last build and print in console view
							printJenkinsBuildLogs(appInfo, buildId, monitor);
						} catch (Exception e) {
							printErrorLog(Messages.AppfactoryApplicationListView_getbuildLogsJob_pError_1+e.getMessage());	 
							log.error("BuildLogs Error :",e); //$NON-NLS-1$
						}
					}		
			   };
				uiSynchronize.asyncExec(new Runnable() {
					@Override
					public void run() {

					}
				});
				return Status.OK_STATUS;
			}
		};			
		job.schedule();
	}

    private void getBuildJob(final AppVersionInfo appInfo) {
        Job job = new Job("Invoking a build") {
            @Override
            protected IStatus run(final IProgressMonitor monitor) {
                UISynchronize uiSynchronize = new UISynchronize() {
                    @Override
                    public void syncExec(Runnable runnable) {

                    }

                    @Override
                    public void asyncExec(Runnable runnable) {
                        try {
                            // deploy
                            build(appInfo);
                        } catch (Exception e) {
                            printErrorLog("Error while invoking build" + e.getMessage());
                            log.error("Error while invoking build. :", e); //$NON-NLS-1$
                        }
                    }
                };
                uiSynchronize.asyncExec(new Runnable() {
                    @Override
                    public void run() {

                    }
                });
                return Status.OK_STATUS;
            }
        };
        job.schedule();
    }
 
    private void getDeployJob(final AppVersionInfo appInfo) {
        Job job = new Job("Deploying last build") {
            @Override
            protected IStatus run(final IProgressMonitor monitor) {
                UISynchronize uiSynchronize = new UISynchronize() {
                    @Override
                    public void syncExec(Runnable runnable) {

                    }

                    @Override
                    public void asyncExec(Runnable runnable) {
                        try {
                            // deploy
                            deploy(appInfo);
                        } catch (Exception e) {
                            printErrorLog("Error while invoking deploy" + e.getMessage());
                            log.error("Error while invoking deploy. :", e); //$NON-NLS-1$
                        }
                    }
                };
                uiSynchronize.asyncExec(new Runnable() {
                    @Override
                    public void run() {

                    }
                });
                return Status.OK_STATUS;
            }
        };
        job.schedule();
    }
	
	private Action appOpenAction(final ApplicationInfo appInfo,final String title) {
		Action reposettings = new Action() {
			public void run() {
				try {
					getAppVersions(appInfo);
					getDataSources(appInfo);
				} catch (Exception e) {
					appInfo.setLableState(0);
					log.error(e);
				}
			}
			public String getText() {
				return title;
			}

			public ImageDescriptor getImageDescriptor() {
				ImageDescriptor imageDescriptorFromPlugin = Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID,
						 "/icons/open.gif"); //$NON-NLS-1$
				return  imageDescriptorFromPlugin;
			}
		};
		return reposettings;
	}
 
	private Action buildInfoAction(final AppVersionInfo appInfo) {

		Action reposetetings = new Action() {
			@Override
			public void run() {
				getbuildLogsJob(appInfo,false);
			}

			public String getText() {
				return Messages.AppfactoryApplicationListView_buildInfoAction_BuildLogs_menu_name;
			}
			public ImageDescriptor getImageDescriptor() {
				ImageDescriptor imageDescriptorFromPlugin = Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID,
						 "/icons/buildLog.gif"); //$NON-NLS-1$
				return  imageDescriptorFromPlugin;
			}
		};

		return reposetetings;
	}

    private Action buildAction(final AppVersionInfo appInfo) {
        Action buildAction = new Action() {
            @Override
            public void run() {
                getBuildJob(appInfo);
            }

            public String getText() {
                return "build";
            }

            public ImageDescriptor getImageDescriptor() {
                ImageDescriptor imageDescriptorFromPlugin = Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID,
                        "/icons/buildLog.gif"); //$NON-NLS-1$
                return imageDescriptorFromPlugin;
            }
        };
        return buildAction;
    }
	
	private Action mainRepoSettingsAction(final ApplicationInfo appInfo) {
		Action mainRepoSettings = new Action() {
			public void run() {
				try {
					    DirectoryDialog dialog = new DirectoryDialog(Display.getCurrent()
								.getActiveShell());
					   dialog.setText(Messages.AppfactoryApplicationListView_repoSettingsAction_DirectoryDialog_title);
					    if(dialog.open()!=null){
					    	appInfo.setLocalrepoLocation(dialog.getFilterPath());
					    	appInfo.updateVersions();
					    }
				} catch (Exception e) {
					log.error("", e); //$NON-NLS-1$
				}
			};
       
			public String getText() {
				return Messages.AppfactoryApplicationListView_mainRepoSettingsAction_changeRepoLocation_menu_name;
			}
			@Override
			public ImageDescriptor getImageDescriptor() {
				ImageDescriptor imageDescriptorFromPlugin = Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID,
						 "/icons/repoLocation.gif"); //$NON-NLS-1$
				return  imageDescriptorFromPlugin;
			}
		};
		return mainRepoSettings;
	}
	
	private Action forkedRepoSettingsAction(final ApplicationInfo appInfo) {
        Action forkedRepoSettings = new Action() {
            public void run() {
                try {
                        DirectoryDialog dialog = new DirectoryDialog(Display.getCurrent()
                                .getActiveShell());
                       dialog.setText(Messages.AppfactoryApplicationListView_repoSettingsAction_DirectoryDialog_title);
                        if(dialog.open()!=null){
                            appInfo.setLocalForkRepoLocation(dialog.getFilterPath());
                            appInfo.updateVersions();
                        }
                } catch (Exception e) {
                    log.error("", e); //$NON-NLS-1$
                }
            };
       
            public String getText() {
                return Messages.AppfactoryApplicationListView_forkedRepoSettingsAction_changeRepoLocation_menu_name;
            }
            @Override
            public ImageDescriptor getImageDescriptor() {
                ImageDescriptor imageDescriptorFromPlugin = Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID,
                         "/icons/repoLocation.gif"); //$NON-NLS-1$
                return  imageDescriptorFromPlugin;
            }
        };
        return forkedRepoSettings;
    }
	private Action repoBuildAction(final AppVersionInfo info) {
        Action buildAction = new Action() {
            public void run() {
                try {
                    getbuildLogsJob(info,true);
                } catch (Exception e) {
                    log.error("Error occurred while invoking build.", e); //$NON-NLS-1$
                }
            };
            public String getText() {
                return "build";
            }
            @Override
            public ImageDescriptor getImageDescriptor() {
                ImageDescriptor imageDescriptorFromPlugin = Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID,
                         "/icons/deploy.gif"); //$NON-NLS-1$
                return  imageDescriptorFromPlugin;
            }
        };
        return buildAction;
    }
 
	private Action repoDeployAction(final AppVersionInfo info) {
		Action reposettings = new Action() {
			public void run() {
				try {
					getDeployJob(info);
				} catch (Exception e) {
					log.error("Deploying Error", e); //$NON-NLS-1$
				}
			};
			public String getText() {
				return Messages.AppfactoryApplicationListView_repoDeployAction_menu_name;
			}
			@Override
			public ImageDescriptor getImageDescriptor() {
				ImageDescriptor imageDescriptorFromPlugin = Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID,
						 "/icons/deploy.gif"); //$NON-NLS-1$
				return  imageDescriptorFromPlugin;
			}
		};
		return reposettings;
	}
	
	private Action checkOutAction(final AppVersionInfo info) {
		Action reposettings = new Action() {
			public void run() {				
				getcheckoutJob(info);
			};

			public String getText() {
				return Messages.AppfactoryApplicationListView_checkOutAction_menu_name;
			}
			@Override
			public ImageDescriptor getImageDescriptor() {
				ImageDescriptor imageDescriptorFromPlugin = Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID,
						 "/icons/checkout.gif"); //$NON-NLS-1$
				return  imageDescriptorFromPlugin;
			}
		};
		return reposettings;
	}
	
	private Action importAction(final AppVersionInfo info) {
		Action reposettings = new Action() {
			public void run() {	
			    ProgressMonitorDialog progressMonitorDialog = new ProgressMonitorDialog(Display.getDefault().getActiveShell());
				progressMonitorDialog.create();
				progressMonitorDialog.open();
				try {
					progressMonitorDialog.run(true, false, new AppImportJobJob(info));
				} catch (InvocationTargetException e) {
					 log.error("project open", e); //$NON-NLS-1$
				} catch (InterruptedException e) {
					log.error("project open", e); //$NON-NLS-1$
				}
			};

			public String getText() {
				return Messages.AppfactoryApplicationListView_importAction_menu_name;
			}
			@Override
			public ImageDescriptor getImageDescriptor() {
				ImageDescriptor imageDescriptorFromPlugin = Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID,
						 "/icons/import.gif"); //$NON-NLS-1$
				return  imageDescriptorFromPlugin;
			}
			
			@Override
			public boolean isEnabled() {
				// TODO Auto-generated method stub
				return info.isCheckedout();
			}
		};
		return reposettings;
	}
	
	private Action checkOutAndImportAction(final AppVersionInfo info) {
		Action reposettings = new Action() {
			public void run() {		
				try {
			    ProgressMonitorDialog progressMonitorDialog = new ProgressMonitorDialog(Display.getDefault().getActiveShell());
				progressMonitorDialog.create();
				progressMonitorDialog.open();
				progressMonitorDialog.run(true, true, new AppCheckoutAndImportJobJob(info));
				} catch (InvocationTargetException e) {
					 log.error("project open", e); //$NON-NLS-1$
					 
				} catch (InterruptedException e) {
					log.error("project open", e); //$NON-NLS-1$
					printErrorLog(e.getMessage());
				}
				
			};

			public String getText() {
				return Messages.AppfactoryApplicationListView_checkOutAndImportAction_menu_name;
			}
			@Override
			public ImageDescriptor getImageDescriptor() {
				ImageDescriptor imageDescriptorFromPlugin = Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID,
						 "/icons/checkout.gif"); //$NON-NLS-1$
				return  imageDescriptorFromPlugin;
			}
		};
		return reposettings;
	}

	private int getLastBuildId(final AppVersionInfo appInfo) {
        credentials = Authenticator.getInstance().getCredentials();
        Map<String, String> params = new HashMap<String, String>();
        if (appInfo.isForkedVersion()) {
            params.put("action", JagApiProperties.FORKED_REPO_INFO_ACTION); //$NON-NLS-1$
        } else {
            params.put("action", JagApiProperties.App_BUILD_INFO_ACTION); //$NON-NLS-1$
        }
        params.put("stage", "Development"); //$NON-NLS-1$ //$NON-NLS-2$
        params.put("applicationKey",appInfo.getAppName()); //$NON-NLS-1$
        params.put("version", appInfo.getVersion()); //$NON-NLS-1$
        params.put("buildable", "true"); //$NON-NLS-1$ //$NON-NLS-2$
        params.put("isRoleBasedPermissionAllowed","false"); //$NON-NLS-1$ //$NON-NLS-2$
        params.put("metaDataNeed", "false"); //$NON-NLS-1$ //$NON-NLS-2$
        params.put("userName",credentials.getUser()); //$NON-NLS-1$
        printInfoLog(Messages.AppfactoryApplicationListView_getLastBuildId_printInfoLog_0);  
        String respond = HttpsJaggeryClient.httpPost(JagApiProperties.getBuildLastSucessfullBuildUrl(),params);
        if("false".equals(respond)){ //$NON-NLS-1$
        printErrorLog(Messages.AppfactoryApplicationListView_getLastBuildId_printErrorLog_0);    
        boolean val = Authenticator.getInstance().reLogin();
          if(val){
              printInfoLog(Messages.AppfactoryApplicationListView_getLastBuildId_printInfoLog_1);     
              respond =HttpsJaggeryClient.httpPost(JagApiProperties.getBuildLastSucessfullBuildUrl(),params);
          }else{
            printErrorLog(Messages.AppfactoryApplicationListView_getLastBuildId_printErrorLog_1 +
                    Messages.AppfactoryApplicationListView_getLastBuildId_printErrorLog_2);  
          }
        }
        if (!"false".equals(respond)) { //$NON-NLS-1$
            JsonElement jelement = new JsonParser().parse(respond);
            int buildId = 0;
            JsonObject build = null;
            //JSON response structure is different for forked versions
            if (appInfo.isForkedVersion()) {
                Set<Entry<String, JsonElement>> entrySet = jelement
                        .getAsJsonObject().entrySet();

                for (Entry<String, JsonElement> entry : entrySet) {
                    JsonObject root = entry.getValue()
                            .getAsJsonObject();
                    JsonObject version = root.get("version")
                            .getAsJsonObject();
                    if (appInfo.getVersion().equals(
                            version.get("current")
                                    .getAsString())) {
                        build = root.get("build")
                                .getAsJsonObject();
                    }
                }

            } else {
                JsonArray buildInfoArray = jelement
                        .getAsJsonArray();
                for (JsonElement jsonElement : buildInfoArray) {
                    JsonObject asJsonObject = jsonElement
                            .getAsJsonObject();
                    JsonElement jsonElement2 = asJsonObject
                            .get("version"); //$NON-NLS-1$
                    JsonObject asJsonObject2 = jsonElement2
                            .getAsJsonObject();
                    String asString = asJsonObject2.get(
                            "current") //$NON-NLS-1$
                            .getAsString();
                    if (asString.equals(appInfo.getVersion())) {
                        build = asJsonObject
                                .get("build")
                                .getAsJsonObject();
                        break;
                    }
                }
            }
            // NOTE : when lastBuildId is not available, it comes as String "null"
            // not as primitive null, hence isJsonNull() method cannot be used to null check
            if (build != null && build.get("lastBuildId").getAsString().equals("null")) {
                buildId = -1;
                printInfoLog(Messages.AppfactoryApplicationListView_getLastBuildId_NotAvailable);
            } else {
                buildId = build.get("lastBuildId").getAsInt();
            }
            printInfoLog(Messages.AppfactoryApplicationListView_getLastBuildId_plog_Lastbuild
                    + buildId);
            return buildId;
        }
        return 0;
    }
	

    private void printJenkinsBuildLogs(AppVersionInfo appInfo,
            int buildId, IProgressMonitor monitor) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("action", JagApiProperties.PRINT_BUILD_LOGS);
        params.put("applicationKey", appInfo.getAppName());
        params.put("applicationVersion", appInfo.getVersion());
        params.put("forkedRepository",
                String.valueOf(appInfo.isForkedVersion()));
        params.put("lastBuildId", String.valueOf(buildId));
        params.put("tenantDomain", Authenticator.getInstance().getSelectedTenant());
        BufferedReader rd = HttpsJaggeryClient.getPostResponseBuffer(
                JagApiProperties.getBuildLogsUrl(), params);

        String line = "";
        try {
            while ((line = rd.readLine()) != null) {
                broker.send("update", line.toString()); 
                Thread.sleep(100);
            }
        } catch (IOException | InterruptedException e) {
            printErrorLog(e.getMessage());
        } finally {
            try {
                rd.close();
            } catch (IOException e) {
                printErrorLog(e.getMessage());
            }
        }
    }

    private void deploy(final AppVersionInfo appInfo) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("action", //$NON-NLS-1$
                JagApiProperties.App_DEPLOY_ACTION);
        params.put("stage", "Development"); //$NON-NLS-1$ //$NON-NLS-2$
        params.put("applicationKey", appInfo.getAppName()); //$NON-NLS-1$
        params.put("version", appInfo.getVersion()); //$NON-NLS-1$
        params.put("deployAction", "deploy"); //$NON-NLS-1$
        printInfoLog("Deploying application");   //$NON-NLS-1$
        String httpPostrespond = HttpsJaggeryClient.httpPost(
                JagApiProperties.getDeployArtifactUrl(),
                params); 
        if (!"false".equals(httpPostrespond)) { //$NON-NLS-1$  
            printInfoLog(Messages.AppfactoryApplicationListView_deploy_printInfoLog_2);
        } else {
            boolean reLoginSuccessful = Authenticator.getInstance().reLogin();
            if (reLoginSuccessful) {
                httpPostrespond = HttpsJaggeryClient.httpPost(JagApiProperties.getDeployArtifactUrl(), params);
                if (!"false".equals(httpPostrespond)) { //$NON-NLS-1$  
                    printInfoLog(Messages.AppfactoryApplicationListView_deploy_printInfoLog_2);
                } 
            } else {
                printErrorLog(Messages.AppfactoryApplicationListView_deploy_printErrorLog_3);
                printInfoLog(Messages.AppfactoryApplicationListView_deploy_printInfoLog_3);
            }
        }
    }

    private void build(final AppVersionInfo appInfo) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("action", //$NON-NLS-1$
                JagApiProperties.App_BUILD_ACTION);
        params.put("stage", "Development"); //$NON-NLS-1$ //$NON-NLS-2$
        params.put("applicationKey", appInfo.getAppName()); //$NON-NLS-1$
        params.put("version", appInfo.getVersion()); //$NON-NLS-1$
        params.put("doDeploy", "false"); //$NON-NLS-1$
        if(appInfo.isForkedVersion()){
            params.put("repoFrom", "fork"); //$NON-NLS-1$
        } else {
            params.put("repoFrom", "original"); //$NON-NLS-1$
        }
        printInfoLog("Building application");   //$NON-NLS-1$
        String httpPostrespond = HttpsJaggeryClient.httpPost(
                JagApiProperties.getCreateArtifactUrl(),
                params); 
        if (!"false".equals(httpPostrespond)) { //$NON-NLS-1$
            printInfoLog("Build invoked successfully.");
        } else {
            boolean reLoginSuccessful = Authenticator.getInstance().reLogin();
            if (reLoginSuccessful) {
                httpPostrespond = HttpsJaggeryClient.httpPost(JagApiProperties.getDeployArtifactUrl(), params);
                if (!"false".equals(httpPostrespond)) { //$NON-NLS-1$
                    printInfoLog("Build invoked successfully.");
                }
            } else {
                printErrorLog("Failed invoking build.");
            }
        }
    }

	private void getcheckoutJob(final AppVersionInfo info){
		Job job = new Job(Messages.AppfactoryApplicationListView_getcheckoutJob_title) {
		   @Override
			  protected IStatus run(final IProgressMonitor monitor) {
				monitor.beginTask(Messages.AppfactoryApplicationListView_getcheckoutJob_monitor_msg_1, 100);
				  UISynchronize uiSynchronize = new UISynchronize() {
						@Override
						public void syncExec(Runnable runnable) {
						}
						
						@Override
						public void asyncExec(Runnable runnable) {
						 try{
							 checkout(info, monitor);
							 }catch(Exception e){
								 monitor.worked(0);
								 monitor.subTask(Messages.AppfactoryApplicationListView_getcheckoutJob_monitor_msg_2);
								 printErrorLog(Messages.AppfactoryApplicationListView_getcheckoutJob_plog_msg_2+e.getMessage()); 
								 log.error("Cloning :", e); //$NON-NLS-1$
						   }
						}
					};
					uiSynchronize.asyncExec(new Runnable() {
						@Override
						public void run() {
						
						}
					});
					
			    return Status.OK_STATUS;
			  }
			};
		job.schedule();
	}	
	
	private void checkout(final AppVersionInfo info,
			final IProgressMonitor monitor)
			throws IOException, InvalidRemoteException,
			TransportException, GitAPIException,
			RefAlreadyExistsException,
			RefNotFoundException, InvalidRefNameException,
			CheckoutConflictException {
		monitor.beginTask(Messages.AppfactoryApplicationListView_checkout_moniter_msg_1, 100);
		printInfoLog(Messages.AppfactoryApplicationListView_checkout_plog_msg_1);
		monitor.worked(5);	 
		 
		if (info.getLocalRepo() == null || info.getLocalRepo().equals("")) { //$NON-NLS-1$
			String workspace = ResourcesPlugin.getWorkspace().getRoot().getLocation().toOSString();
			String localRepo = workspace + File.separator + info.getAppName();
			// Add relevant suffix to repo location
			localRepo += (info.isForkedVersion()) ? FORKED_REPO_SUFFIX : MAIN_REPO_SUFFIX;
			info.setLocalRepo(localRepo);
		}
        monitor.worked(5);	
		JgitRepoManager manager = new JgitRepoManager(info);
		
		if(!manager.isCloned()){
		    File localRepoDir = new File(info.getLocalRepo());
	        if (localRepoDir.exists() && localRepoDir.isDirectory()) {
	            if (localRepoDir.list().length > 0) {
	                printErrorLog(localRepoDir.getPath()
	                        + Messages.AppfactoryApplicationListView_checkout_Folder_exists_error);
	                return;
	            } else if (localRepoDir.isDirectory() && localRepoDir.list().length == 0) {
	                try {
	                    localRepoDir.delete();
	                } catch (Exception e) {
	                    printErrorLog(localRepoDir.getPath()
	                            + Messages.AppfactoryApplicationListView_checkout_Folder_exists_error);
	                    return;
	                }
	            }
	        }
	        monitor.worked(5);    
			manager.gitClone();
			monitor.worked(65); 
            if (!"trunk".equals(info.getVersion()) || !"master".equals(info.getVersion())) { //$NON-NLS-1$
                manager.checkout(info.getVersion());
                monitor.worked(10);
                monitor.subTask(Messages.AppfactoryApplicationListView_checkout_moniter_msg_2);
                printInfoLog(Messages.AppfactoryApplicationListView_checkout_plog_msg_2);
            }
		}else {
			manager.checkout(info.getVersion());
			monitor.worked(10);
			monitor.subTask(Messages.AppfactoryApplicationListView_checkout_moniter_msg_3);
			printInfoLog(Messages.AppfactoryApplicationListView_checkout_plog_msg_3);
		}
        info.setCheckedout(true);
        try {
            ResourcesPlugin.getWorkspace().getRoot()
                    .refreshLocal(IResource.DEPTH_INFINITE, new SubProgressMonitor(monitor, 10));
        } catch (CoreException e) {
            log.error("Error refreshing workspace", e);
        }
        monitor.done();
        broker.send("Projectupdate", null); //$NON-NLS-1$
	}

	private class AppImportJobJob implements IRunnableWithProgress {
		
	AppVersionInfo appInfo;
	 public AppImportJobJob(AppVersionInfo appInfo) {
		    this.appInfo = appInfo;
    	}
	  
		@Override
		public void run(IProgressMonitor monitor) {
			String operationText = Messages.AppfactoryApplicationListView_AppImportJob_opMSG_1;
			monitor.beginTask(operationText, 100);
			try {
				importProject(appInfo, new SubProgressMonitor(monitor, 100));
			} catch (Throwable e) {
				operationText = Messages.AppfactoryApplicationListView_AppImportJob_opMSG_4;
				monitor.subTask(operationText);
				log.error("importing failed", e); //$NON-NLS-1$
			}
			monitor.done();
		}
	}  

	private class AppCheckoutAndImportJobJob implements IRunnableWithProgress {
	
	AppVersionInfo appInfo;
	 public AppCheckoutAndImportJobJob(AppVersionInfo appInfo) {
		    this.appInfo = appInfo;
    	}
	  
		@Override
		public void run(IProgressMonitor monitor) {
			String operationText=Messages.AppfactoryApplicationListView_AppCheckoutAndImportJob_opMSG_1;
			monitor.beginTask(operationText, 100);
			try {
				checkout(appInfo, new SubProgressMonitor(monitor, 50));
				importProject(appInfo, new SubProgressMonitor(monitor, 50));
				
			}catch(Throwable e){
				 operationText=Messages.AppfactoryApplicationListView_AppCheckoutAndImportJob_Faild;
				 monitor.subTask(operationText);
				 monitor.worked(60); 
				 printErrorLog(e.getMessage());
				 log.error("importing failed", e); //$NON-NLS-1$
			}
			monitor.done();
		}
	}  

	@Deprecated
    private boolean isMavenHomeFound() {
        return getMavenHome() != null;
    }
	@Deprecated
    private String getMavenHome() {
        String mavenHome = null;
        try {
            if (System.getenv("M2_HOME") != null) {
                mavenHome = System.getenv("M2_HOME");
            } else if (System.getenv("MAVEN_HOME") != null) {
                mavenHome = System.getenv("MAVEN_HOME");
            } else if (System.getenv("M3_HOME") != null) {
                mavenHome = System.getenv("M3_HOME");
            } else if (System.getProperty("maven.home") != null) {
                mavenHome = System.getProperty("maven.home");
            }
        } catch (Exception e) {
            log.error("Error while reading maven home.", e);
        }
        return mavenHome;
    }
	@Deprecated
	public boolean executeMavenCommands(File pomFile, IProgressMonitor monitor) throws InterruptedException{
		
		monitor.worked(10);
		try {
			String operationText = Messages.AppfactoryApplicationListView_executeMavenCommands_text;
			monitor.subTask(operationText);
			printInfoLog(operationText);
			InvocationResult result = mavenInstall(pomFile, monitor);
			if (result.getExitCode() != 0) {
				printErrorLog(Messages.AppfactoryApplicationListView_executeMavenCommands_errorlog_text);
			}
			monitor.worked(30);
		} catch (MavenInvocationException e) {

		}
		if (monitor.isCanceled()) {
			throw new InterruptedException(Messages.ImportingCancelled_Error);
		}
		try {
			String operationText = Messages.AppfactoryApplicationListView_executeMavenCommands_text2;
			monitor.subTask(operationText);
			printInfoLog(operationText);
			InvocationResult result = mavenEclipse(pomFile, monitor);
			if (result.getExitCode() != 0) {
				printErrorLog(Messages.AppfactoryApplicationListView_executeMavenCommands_errorlog_text2);
			}
			monitor.worked(20);
		} catch (MavenInvocationException e) {
			monitor.worked(50);
		}
		return true;
	}
	@Deprecated
	private InvocationResult mavenInstall(File pomFile, IProgressMonitor monitor) throws MavenInvocationException{
		
		InvocationRequest request = new DefaultInvocationRequest();
		request.setPomFile(pomFile);		
		request.setGoals(Arrays.asList(MAVEN_CMD_CLEAN, MAVEN_CMD_INSTALL));
		Invoker invoker = new DefaultInvoker();
		invoker.setMavenHome(new File(getMavenHome()));
		InvocationResult result = invoker.execute(request);
		
		return result;
	}
	@Deprecated
	private InvocationResult mavenEclipse(File pomFile, IProgressMonitor monitor) throws MavenInvocationException{
		
		InvocationRequest request = new DefaultInvocationRequest();
		request.setPomFile(pomFile);
		request.setGoals(Collections.singletonList(MAVEN_CMD_ECLIPSE));
		Invoker invoker = new DefaultInvoker();
		invoker.setMavenHome(new File(getMavenHome()));
		return invoker.execute(request);
	}

    protected void importProject(AppVersionInfo appInfo, IProgressMonitor monitor) throws CoreException, InterruptedException {
        String operationText = "Start importing project to workspace.";
        monitor.beginTask(operationText, 100);
        IProjectDescription description = ResourcesPlugin.getWorkspace().loadProjectDescription(
                new Path(appInfo.getLocalRepo() + File.separator + PROJECT_DESCRIPTOR));

        String projectName = description.getName()
                + ((appInfo.isForkedVersion()) ? FORKED_REPO_SUFFIX : MAIN_REPO_SUFFIX);
        description.setName(projectName);

        operationText = "Preparing project " + projectName + " to import";
        monitor.subTask(operationText);
        monitor.worked(15);

        final IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(description.getName());
        if (!project.exists()) {
            File pomFile = new File(appInfo.getLocalRepo() + File.separator + "pom.xml");
            // If this is a maven project, import it using m2e API
            if (pomFile.exists()) {
                try {
                    IProjectConfigurationManager configurationManager = MavenPlugin.getProjectConfigurationManager();
                    MavenModelManager mavenModelManager = MavenPlugin.getMavenModelManager();
                    LocalProjectScanner scanner = new LocalProjectScanner(ResourcesPlugin.getWorkspace().getRoot()
                            .getLocation().toFile(), //
                            appInfo.getLocalRepo(), false, mavenModelManager);
                    operationText = "Scanning maven project.";
                    monitor.subTask(operationText);
                    scanner.run(new SubProgressMonitor(monitor, 15));

                    Set<MavenProjectInfo> projectSet = configurationManager.collectProjects(scanner.getProjects());

                    ProjectImportConfiguration configuration = new ProjectImportConfiguration();
                    operationText = "importing maven project.";
                    monitor.subTask(operationText);
                    List<IMavenProjectImportResult> importResults = configurationManager.importProjects(projectSet,
                            configuration, new SubProgressMonitor(monitor, 60));
                } catch (Exception e) {
                    log.error("Failed to import project using m2e. Now attempting a normal import.", e);
                    operationText = "Creating a new project.";
                    monitor.subTask(operationText);
                    project.create(new SubProgressMonitor(monitor, 30));
                    operationText = "Opening new project.";
                    monitor.subTask(operationText);
                    project.open(new SubProgressMonitor(monitor, 30));
                }
            } else {
                operationText = "Creating a new project.";
                monitor.subTask(operationText);
                project.create(new SubProgressMonitor(monitor, 30));
                operationText = "Opening new project.";
                monitor.subTask(operationText);
                project.open(new SubProgressMonitor(monitor, 30));
            }

        } else {
            printInfoLog("Skipped creating a new project since a project named \"" + projectName
                    + "\" already exists in workspace.");
        }
        operationText = "Refreshing workspace.";
        monitor.subTask(operationText);
        ResourcesPlugin.getWorkspace().getRoot()
                .refreshLocal(IResource.DEPTH_INFINITE, new SubProgressMonitor(monitor, 10));
        monitor.done();
    }
	
}
