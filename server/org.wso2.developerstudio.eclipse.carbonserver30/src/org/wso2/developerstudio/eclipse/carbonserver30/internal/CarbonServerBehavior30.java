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

package org.wso2.developerstudio.eclipse.carbonserver30.internal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.jdt.launching.IVMInstall;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.jst.server.generic.core.internal.CorePlugin;
import org.eclipse.jst.server.generic.core.internal.GenericServerCoreMessages;
import org.eclipse.jst.server.generic.core.internal.GenericServerRuntime;
import org.eclipse.jst.server.generic.core.internal.Trace;
import org.eclipse.osgi.util.NLS;
import org.eclipse.wst.server.core.IModule;
import org.eclipse.wst.server.core.IServer;
import org.eclipse.wst.server.core.ServerPort;
import org.eclipse.wst.server.core.internal.DeletedModule;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.wso2.developerstudio.eclipse.carbonserver.base.impl.CarbonServerBehaviour;
import org.wso2.developerstudio.eclipse.carbonserver.base.manager.CarbonServerManager;
import org.wso2.developerstudio.eclipse.carbonserver.base.service.util.CarbonUploadServiceRequestUtil;
import org.wso2.developerstudio.eclipse.carbonserver30.Activator;
import org.wso2.developerstudio.eclipse.carbonserver30.operations.CommonOperations;
import org.wso2.developerstudio.eclipse.carbonserver30.util.CarbonServer30Utils;
import org.wso2.developerstudio.eclipse.carbonserver30.util.CarbonServerConstants;
import org.wso2.developerstudio.eclipse.server.base.core.ServerController;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;
import org.xml.sax.InputSource;

public class CarbonServerBehavior30 extends CarbonServerBehaviour{
    private void checkClosed(IModule[] module) throws CoreException
    {
    	for( int i=0; i < module.length; i++ ){
    		if( module[i] instanceof DeletedModule ){	
                IStatus status = new Status(IStatus.ERROR,CorePlugin.PLUGIN_ID,0, NLS.bind(GenericServerCoreMessages.canNotPublishDeletedModule,module[i].getName()),null);
                throw new CoreException(status);
    		}
    	}
    }
    public void publishModule(int kind, int deltaKind, IModule[] module,
            IProgressMonitor monitor) throws CoreException {
    	IModule m = module[module.length - 1];
    	if(deltaKind == ADDED){
    		checkClosed(module);
    		ServerController.getInstance().getServerManager().publishServiceModule(getServer().getId(), "",m.getName());
    	}else if(deltaKind == REMOVED){
    		ServerController.getInstance().getServerManager().unpublishServiceModule(getServer().getId(), "",m.getName());
        }else{
    		checkClosed(module);
//    		To add any new services
//    		ServerController.getInstance().getServerManager().publishServiceModule(getServer().getId(), "",m.getName());
    		ServerController.getInstance().getServerManager().hotUpdateServiceModule(getServer().getId(), "",m.getName());
    	}
        setModulePublishState( module, null );
    }
    private void setModulePublishState( IModule[] module, IStatus[] status ) throws CoreException {
        if( module==null )
            return;
        for( int i=0; i < module.length; i++)
        {
            if(status == null ||
                    status.length < i ||
                    status[i]==null || 
                    status[i].getSeverity() == IStatus.OK )
            {
            setModulePublishState(module, IServer.PUBLISH_STATE_NONE);    
            }
            else
            {
                if ( IStatus.ERROR == status[i].getSeverity() ){
                    setModulePublishState( module, IServer.PUBLISH_STATE_UNKNOWN );
                    throw new CoreException( status[i] );
                }
            }
        }
    }
    
    protected void doServerStartedTasks(){
    	super.doServerStartedTasks();
 		doBrowserPopup();
    }
    
    protected void doServerStoppedTasks(){
    }
    
    private void doBrowserPopup(){
    	Boolean popupBrowser = CarbonServer30Utils.isServerStartBrowserPopup(getServer());
    	if (popupBrowser!=null && popupBrowser){
    		CarbonUploadServiceRequestUtil uploadServiceRequestUtil = CarbonUploadServiceRequestUtil.getInstance();
    		uploadServiceRequestUtil.popupExternalBrowser(CommonOperations.getLocalServerPort(getServer()) + CarbonServer30Utils.getWebContextRoot(getServer()) +"/carbon");
    		//uoloadServiceRequestUtil.popupInternalBrowser(CommonOperations.getLocalServerPort(getServer())+"/carbon");
    	}
    		
    }
    
    protected String getVmArguments() {
    	String vmArguments = super.getVmArguments();
    	Boolean enableOSGIConsole=CarbonServer30Utils.isServerStartWithOSGiConsole(getServer());
//    	String serverLocalWorkspacePath = WSASServerManager.getServerLocalWorkspacePath(getServer());
//    	IPath serverHome = WSASServerManager.getServerHome(getServer());
//    	vmArguments=vmArguments+" -Dcarbon.home=\""+serverHome.toOSString()+"\"";
    	if (enableOSGIConsole!=null && enableOSGIConsole){
    		vmArguments=vmArguments+" -DosgiConsole";
    	}
        return vmArguments;
    }
    
    protected String[] getPingURLList(){
    	try {
    		setServerisStillStarting(true);
    		String url = "http://"+getServer().getHost();
    		List<String> urls=new ArrayList<String>();
    	  	ServerPort[] ports=getServerPorts(getServer());
        	ServerPort sp = null;
    	    for(int i=0;i<ports.length;i++){
    	    	int j = CarbonServerConstants.PORT_CAPTIONS.indexOf(ports[i].getName());
    	    	if(j!=-1 && CarbonServerConstants.PORT_IDS.get(j).equals("carbon.http")){
    	    		sp=ports[i];
    	        	int port = sp.getPort();
    	        	String newUrl = url;
    	    		if (port != 80)
    	    			newUrl = newUrl + ":" + port; //$NON-NLS-1$
    	    		newUrl=newUrl + CarbonServer30Utils.getWebContextRoot(getServer()) + "/carbon";
    	    		urls.add(newUrl);
    	    	}
    	    }
    		return urls.toArray(new String[]{});
    	} catch (Exception e) {
    		Trace.trace(Trace.SEVERE, "Can't ping for server startup."); 
    	}  	
    	return null;
    }
    
    protected List getStartClasspath() {
    	List startClasspath = super.getStartClasspath();
        GenericServerRuntime runtime = getRuntimeDelegate();

        IVMInstall vmInstall = runtime.getVMInstall();
    	File jdkLib = new File(vmInstall.getInstallLocation(),"lib");
    	
    	if (jdkLib.exists() && jdkLib.isDirectory()) {
	        for (String cpath : jdkLib.list()) {
		        Path newCPath = new Path(new File(jdkLib, cpath).toString());
		        String fileExtension = newCPath.getFileExtension();
		        if (fileExtension != null && fileExtension.equalsIgnoreCase("jar"))
			        startClasspath.add(JavaRuntime.newArchiveRuntimeClasspathEntry(newCPath));
	        }
        }
		return startClasspath;
    }
    
	protected String getCarbonXmlFilePath() {
		IPath serverHome = CarbonServerManager.getServerHome(getServer());
    	return CarbonServer30Utils.getServerXmlPathFromLocalWorkspaceRepo(serverHome.toOSString());
	}
	protected String getTransportXmlFilePath() {
		IPath serverHome = CarbonServerManager.getServerHome(getServer());
    	String transportsXmlPath = CarbonServer30Utils.getTransportsXmlPathFromLocalWorkspaceRepo(serverHome.toOSString());
		return transportsXmlPath;
	}
	protected String getAxis2FilePath() {
		return CarbonServer30Utils.getAxis2FilePath(getServer());
	}
    
}
