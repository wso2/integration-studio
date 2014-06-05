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

package org.wso2.developerstudio.eclipse.distribution.project.publisher;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.wst.server.core.IServer;
import org.wso2.developerstudio.eclipse.carbonserver.base.interfaces.ICarbonServerModulePublisher;
import org.wso2.developerstudio.eclipse.carbonserver.base.interfaces.ICredentials;
import org.wso2.developerstudio.eclipse.carbonserver.base.manager.CarbonServerManager;
import org.wso2.developerstudio.eclipse.carbonserver.base.utils.CAppDeployer;
import org.wso2.developerstudio.eclipse.distribution.project.export.CarExportHandler;
import org.wso2.developerstudio.eclipse.utils.data.ITemporaryFileTag;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;

public class CAppProjectPublisher implements ICarbonServerModulePublisher {

	private final class CarPublisher implements Runnable {
	    private final File deployLocation;
	    private final IProject project;
	    private boolean done=false;
	    private Exception exception;
		private IServer server;
	    
	    private CarPublisher(File deployLocation, IProject project, IServer server) {
		    this.deployLocation = deployLocation;
		    this.project = project;
		    this.server=server;
	    }

	    public void run() {
	    	File repoLocation=deployLocation;
	    	String[] repoPath=new String[]{"carbonapps"};
	    	for (String path : repoPath) {
	            repoLocation=new File(repoLocation,path);
	        }
	    	try {
	    		//when server is running inside eclipse, it is on stand-alone mode, since stratosEnabled should be false.
	    		ITemporaryFileTag tag = FileUtils.createNewTempTag();
//	            CAppUtils.generateCAR(repoLocation.toString(), project, false);
//	    		IResource cAppFile = ExportUtil.BuildCAppProject(project);
//	    		File carfile = cAppFile.getLocation().toFile();
//	    		CarExportHandler handler=new CarExportHandler();
//	    		List<IResource> exportArtifact = handler.exportArtifact(project);
//	    		File file = exportArtifact.get(0).getLocation().toFile();
//	    		FileUtils.copy(file, new File(repoLocation+File.separator+file.getName()));
	    		
	    		URL serverURL = CarbonServerManager.getServerURL(server);
	    		ICredentials serverCredentials = CarbonServerManager.getServerCredentials(server);
	    		File tempDir = FileUtils.createTempDirectory();
	    		CAppDeployer cappDeployer = new CAppDeployer();
//	            File carFile = CAppUtils.generateCAR(tempDir.getPath(), project, false);
	    		CarExportHandler handler=new CarExportHandler();
	    		List<IResource> exportArtifact = handler.exportArtifact(project);
	    		cappDeployer.deployCApp(serverCredentials.getUsername(), serverCredentials.getPassword(), serverURL.toString(), ((IFile)exportArtifact.get(0)).getLocation().toFile());
	    		
	            tag.clearAndEnd();
	        } catch (Exception e) {
	        	setException(e);
	        }
	        setDone(true);
	    }

	    private void setDone(boolean done) {
	        this.done = done;
        }

		public boolean isDone() {
	        return done;
        }

		private void setException(Exception exception) {
	        this.exception = exception;
        }

		public Exception getException() {
	        return exception;
        }
    }

	private static Map<IServer,List<IProject>> inQueueList;
    public void publish(final IProject project, IServer server, File serverHome,final File deployLocation) throws Exception {
	    if (project.hasNature("org.wso2.developerstudio.eclipse.distribution.project.nature")){
	    	List<IProject> list;
	    	list = getProjectListForServer(server);
    		synchronized (list) {
    	        if (list.contains(project)){
    	        	return;
    	        }else{
    	        	list.add(project);
    	        }
    		}
	    	final CarPublisher runnable = new CarPublisher(deployLocation, project, server);
	    	runnable.run();
	    	if (runnable.getException()!=null){
	    		Display.getDefault().asyncExec(new Runnable(){
                    public void run() {
                    	MessageDialog.openError(Display.getCurrent().getActiveShell(), "Error while creating CAR", "An error occured while creating or publishing the car for more details view the log. \n"+runnable.getException().getMessage());
                    }
	    			
	    		});
	    	}
    		synchronized (list) {
    	        if (list.contains(project)){
    	        	list.remove(project);
    	        }
    		}
	    }
    }

    public void unpublish(IProject project, IServer server, File serverHome, File deployLocation)throws Exception {
	    if (project.hasNature("org.wso2.developerstudio.eclipse.distribution.project.nature")){
//	    	IFile file = project.getFile("pom.xml");
//	    	
//	    	MavenProject mavenProject = MavenUtils.getMavenProject(file.getLocation().toFile());
//	    	
//	    	String version = mavenProject.getVersion();
//	    	
//	    	File repoLocation=deployLocation;
//	    	String[] repoPath=new String[]{"carbonapps"};
//	    	for (String path : repoPath) {
//	            repoLocation=new File(repoLocation,path);
//            }
//			try {
//				File carFile = new File(repoLocation+File.separator+project.getName()+"_"+version+".car");
//				carFile.delete();
//            } catch (Exception e) {
//            	throw e;
//            }
	    	
			URL serverURL = CarbonServerManager.getServerURL(server);
			ICredentials serverCredentials = CarbonServerManager.getServerCredentials(server);
//			CAppDeployer cappDeployer = new CAppDeployer();
//			Artifact superArtifact = CAppEnvironment.getcAppManager().getSuperArtifact(project);
//			CarExportHandler handler=new CarExportHandler();
//			List<IResource> exportArtifact = handler.exportArtifact(project);
//			File carFile = ((IFile)exportArtifact.get(0)).getLocation().toFile();			
			String cappName =  project.getName();	
			
//			String serverCarbonVersion = CarbonServerManager.getServerCarbonVersion(server);
//			if(serverCarbonVersion==null || "4.0.0".equals(serverCarbonVersion)){
//				cappName = project.getName();
//			}else{
//				cappName = carFile.getName().substring(0, carFile.getName().length()-4);
//			}
			CAppDeployer.unDeployCAR(serverURL.toString(), 
									 serverCredentials.getUsername(), 
									 serverCredentials.getPassword(), 
									 cappName);
	    }
    }

    public void hotUpdate(final IProject project,final IServer server,final File serverHome,final File deployLocation) throws Exception {
		final List<IProject> list=getProjectListForServer(server);
		synchronized (list) {
			if (list.contains(project)){
				return;
			}
        }
		new Thread(new Runnable(){
//    	Display.getDefault().asyncExec(new Runnable(){
            public void run() {
            	try {
            		synchronized (list) {
            			if (list.contains(project)){
            				return;
            			}
//            			unpublish(project, server, serverHome, deployLocation);
            		}
//	            	Thread.sleep(9000);
        			publish(project, server, serverHome, deployLocation);
            	} catch (Exception e) {
                }

            }
		}).start();
//    	});
    }

	public static Map<IServer,List<IProject>> getInQueueList() {
		if (inQueueList==null){
			inQueueList=new HashMap<IServer, List<IProject>>();
		}
	    return inQueueList;
    }
	
	private List<IProject> getProjectListForServer(IServer server) {
        final List<IProject> list;
        Map<IServer,List<IProject>> inQueueList=getInQueueList();
    	synchronized (inQueueList) {
    		if (inQueueList.containsKey(server)){
    			list = inQueueList.get(server);
    		}else{
    			list=new ArrayList<IProject>();
    			inQueueList.put(server, list);
    		}
    	}
        return list;
    }

}
