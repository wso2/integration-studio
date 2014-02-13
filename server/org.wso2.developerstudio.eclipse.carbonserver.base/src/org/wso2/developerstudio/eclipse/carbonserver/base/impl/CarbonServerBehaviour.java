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

package org.wso2.developerstudio.eclipse.carbonserver.base.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.jdt.launching.IJavaLaunchConfigurationConstants;
import org.eclipse.jdt.launching.IRuntimeClasspathEntry;
import org.eclipse.jdt.launching.IVMInstall;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.jst.server.generic.core.internal.GenericServer;
import org.eclipse.jst.server.generic.core.internal.GenericServerBehaviour;
import org.eclipse.jst.server.generic.core.internal.GenericServerRuntime;
import org.eclipse.jst.server.generic.core.internal.Trace;
import org.eclipse.wst.server.core.IModule;
import org.eclipse.wst.server.core.IServer;
import org.eclipse.wst.server.core.ServerPort;
import org.eclipse.wst.server.core.util.SocketUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.wso2.developerstudio.eclipse.carbonfeatures.Activator;
import org.wso2.developerstudio.eclipse.carbonserver.base.interfaces.ICarbonServerBehavior;
import org.wso2.developerstudio.eclipse.carbonserver.base.monitor.CarbonPingThread;
import org.wso2.developerstudio.eclipse.carbonserver.base.utils.CarbonServerScriptParser;
import org.wso2.developerstudio.eclipse.carbonserver.base.utils.CarbonServerUtils;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;
import org.xml.sax.InputSource;

public abstract class CarbonServerBehaviour extends GenericServerBehaviour implements
		ICarbonServerBehavior {
	
	String originalWSASServerRepo=null;
	private boolean serverisStillStarting=false;
	
//	protected void shutdown(int state) {
//		GenericServerRuntime runtime = getRuntimeDelegate();
//		try {
//			Trace.trace(Trace.FINEST, "Stopping Server"); //$NON-NLS-1$
//			if (state != IServer.STATE_STOPPED)
//				setServerState(IServer.STATE_STOPPING);
//			String configTypeID = getConfigTypeID(); 
//			ILaunchManager mgr = DebugPlugin.getDefault().getLaunchManager();
//			ILaunchConfigurationType type = mgr.getLaunchConfigurationType(configTypeID);
//			String launchName = getStopLaunchName();
//			String uniqueLaunchName = mgr.generateUniqueLaunchConfigurationNameFrom(launchName);
//			ILaunchConfiguration conf = null;
//			ILaunchConfiguration[] lch = mgr.getLaunchConfigurations(type);
//			for (int i = 0; i < lch.length; i++) {
//				if (launchName.equals(lch[i].getName())) {
//					conf = lch[i];
//					break;
//				}
//			}
//			((org.eclipse.debug.core.model.RuntimeProcess)process.getLaunch().getProcesses()[0])
//			ILaunchConfigurationWorkingCopy wc = null;
//			if (conf != null) {
//				wc = conf.getWorkingCopy();
//			} else {
//				wc = type.newInstance(null, uniqueLaunchName);
//			}
//			
//			// To stop from appearing in history lists
//			wc.setAttribute(IDebugUIConstants.ATTR_PRIVATE, true);		
//			// Set the stop attribute so that we know we are stopping
//			wc.setAttribute(ATTR_STOP, "true"); //$NON-NLS-1$
//			// Set the server ID so that we can distinguish stops
//			wc.setAttribute( ATTR_SERVER_ID, this.getServer().getId());
//			// Setup the launch config for stopping the server
//			setupStopLaunchConfiguration(runtime, wc);
//			
//			// Launch the stop launch config
//			wc.launch(ILaunchManager.RUN_MODE, new NullProgressMonitor());
//
//		} catch (Exception e) {
//			Trace.trace(Trace.SEVERE, "Error stopping Server", e); //$NON-NLS-1$
//		}
//    }
//	
	public void stop(boolean force) {
		//getServer()
		doServerStoppedTasks();
		if (force) {
			terminate();
			return;
		}
		int state = getServer().getServerState();
		if (state == IServer.STATE_STOPPED)
			return;
		else {//if (state == IServer.STATE_STARTING || state == IServer.STATE_STOPPING) {
			terminate();
			return;
		}
//		shutdown(state);
    }
	
//	private void unpublishAllModules(){
//		IModule[] modules = getServer().getModules();
//		for(IModule module:modules){
//			//ServiceModuleOperations serviceModuleOperation = new ServiceModuleOperations(module.getProject(),getServer());
//			//serviceModuleOperation.unpublishServiceModule(null, null);
//		}
//	}
	
    protected List serverClasspath(String cpRef) {
    	List classpathEntries = super.serverClasspath(cpRef);
    	ArrayList newClasspathEntries=new ArrayList(); 
    	for(Object o:classpathEntries){
    		IRuntimeClasspathEntry runtimeClassPathEntry=(IRuntimeClasspathEntry)o;
    		String path = runtimeClassPathEntry.getPath().toOSString();
    		File classPath = new File(path);
    		newClasspathEntries.add(runtimeClassPathEntry);
    		if (classPath.isDirectory()){
    			for(String cpath:classPath.list()){
    				Path newCPath = new Path(FileUtils.addAnotherNodeToPath(path,cpath));
    				String fileExtension = newCPath.getFileExtension();
    				if (fileExtension!=null && fileExtension.equalsIgnoreCase("jar"))
    					newClasspathEntries.add(JavaRuntime.newArchiveRuntimeClasspathEntry(newCPath));
    			}
    		}
    	}
    	return newClasspathEntries;
    }
    
	public static ServerPort[] getServerPorts(IServer server){
		GenericServer gserver=(GenericServer) server.getAdapter(GenericServer.class);
		return gserver.getServerPorts();
	}
    
	protected abstract String[] getPingURLList();
	
    protected void startPingThread()
    {
    	try {
    		setServerisStillStarting(true);
    		String url = "http://"+getServer().getHost();
    		String[] urls=getPingURLList();;
	    	if(urls==null || urls.length==0){
	    		Trace.trace(Trace.SEVERE, "Can't ping for server startup."); 
	    		return;
	    	}
    		ping = new CarbonPingThread(getServer(), urls, this);
    	} catch (Exception e) {
    		Trace.trace(Trace.SEVERE, "Can't ping for server startup."); 
    	}  	
    }

 	public void setServerStarted() {
 		if (isServerisStillStarting()){
 			setServerisStillStarting(false);
 			doServerStartedTasks();
 			super.setServerStarted();
 		}
 	}
 	
	private boolean isRemote(){
		return (getServer().getServerType().supportsRemoteHosts()&& !SocketUtil.isLocalhost(getServer().getHost()) );
	}	
	
    protected List getStartClasspath() {
    	String cpRef = getServerDefinition().getStart().getClasspathReference();
    	return serverClasspath(cpRef);
    }
    
    private String getWorkingDirectory() {
    	return getServerDefinition().getResolver().resolveProperties(getServerDefinition().getStart().getWorkingDirectory());
    }
    
    /**
     * Setup for starting the server. Checks all ports available 
     * and sets server state and mode.
     * 
     * @param launch ILaunch
     * @param launchMode String
     * @param monitor IProgressMonitor
     */
    protected void setupLaunch(ILaunch launch, String launchMode, IProgressMonitor monitor) throws CoreException {
    	if ("true".equals(launch.getLaunchConfiguration().getAttribute(ATTR_STOP, "false")))  //$NON-NLS-1$ //$NON-NLS-2$
    		return;
    	checkPorts();
    	setServerState(IServer.STATE_STARTING);
    	setMode(launchMode);
//    	setServerState(IServer.STATE_STARTED);
    }
    
    protected void checkPorts() throws CoreException{
    	String host = getServer().getHost();
    	Integer[] ports = getAllPortsServerWillUse(getServer());
    	if(SocketUtil.isLocalhost(host)){
    		for (int port : ports) {
    			if (SocketUtil.isPortInUse(port, 5)){
	    			throw new CoreException(new Status(IStatus.ERROR, Activator.PLUGIN_ID, 0, "Server port is in use: "+port,null));
    			}
			}
    	}
    }
    
 	public void setupLaunchConfiguration(ILaunchConfigurationWorkingCopy workingCopy, IProgressMonitor monitor) throws CoreException {
		if(isRemote())// No launch for remote servers.
			return;
    	workingCopy.setAttribute(
                IJavaLaunchConfigurationConstants.ATTR_MAIN_TYPE_NAME,
                getStartClassName());

        GenericServerRuntime runtime = getRuntimeDelegate();

        IVMInstall vmInstall = runtime.getVMInstall();
        workingCopy.setAttribute(
                IJavaLaunchConfigurationConstants.ATTR_VM_INSTALL_TYPE, runtime
                        .getVMInstallTypeId());
        workingCopy.setAttribute(
                IJavaLaunchConfigurationConstants.ATTR_VM_INSTALL_NAME,
                vmInstall.getName());

        setupLaunchClasspath(workingCopy, vmInstall, getStartClasspath());


        workingCopy.setAttribute(
                IJavaLaunchConfigurationConstants.ATTR_WORKING_DIRECTORY,
                getWorkingDirectory());
        

        Map environVars = getEnvironmentVariables(getServerDefinition().getStart());
        environVars.put("JAVA_HOME", "/home/saminda/software/jdk1.6.0_20");
        if(!environVars.isEmpty()){
        	workingCopy.setAttribute(ILaunchManager.ATTR_ENVIRONMENT_VARIABLES,environVars);
        }
        
        String existingProgArgs  = workingCopy.getAttribute(IJavaLaunchConfigurationConstants.ATTR_PROGRAM_ARGUMENTS, (String)null);
        String serverProgArgs =  getProgramArguments();
        if( existingProgArgs==null ) {
            workingCopy.setAttribute(IJavaLaunchConfigurationConstants.ATTR_PROGRAM_ARGUMENTS,serverProgArgs);
        }
        String previousVMArgument = workingCopy.getAttribute("earlier_vmarguments",(String)null);
        String serverVMArgs= getVmArguments();
        String existingVMArgs = null;
        if (serverVMArgs.equals(previousVMArgument)){
        	existingVMArgs = workingCopy.getAttribute(IJavaLaunchConfigurationConstants.ATTR_VM_ARGUMENTS,(String)null);
        }else{
        	workingCopy.setAttribute("earlier_vmarguments", serverVMArgs);	
        }
        if( existingVMArgs==null ) {
            workingCopy.setAttribute(IJavaLaunchConfigurationConstants.ATTR_VM_ARGUMENTS,serverVMArgs);
        }
	}
 	
    protected String getVmArguments() {
    	String defaultVMParameters = getServerDefinition().getResolver().resolveProperties(getServerDefinition().getStart().getVmParametersAsString());
    	String serverLocalWorkspacePath = CarbonServerUtils.getCarbonServerHome(getServer()).toOSString();
    	CarbonServerScriptParser parser=new CarbonServerScriptParser(serverLocalWorkspacePath);
    	Map<String, String> serverVMParamaters = parser.getVMParamaters();
    	String[] array=defaultVMParameters.split(" ");
    	
//    	for (Iterator iterator = serverVMParamaters.entrySet().iterator(); iterator.hasNext();) {
//	        Entry<String, String> type = (Entry<String, String>) iterator.next();
			for (int i = 0; i < array.length; i++) {
                if (array[i].contains(CarbonServerScriptParser.MIN_MEMORY_STRING)) {
                	array[i]=CarbonServerScriptParser.MIN_MEMORY_STRING+serverVMParamaters.get(CarbonServerScriptParser.MIN_MEMORY_STRING);
                }else if (array[i].contains(CarbonServerScriptParser.MAX_MEMORY_STRING)) {
                	array[i]=CarbonServerScriptParser.MAX_MEMORY_STRING+serverVMParamaters.get(CarbonServerScriptParser.MAX_MEMORY_STRING);
                }else if (array[i].contains(CarbonServerScriptParser.MAX_PERM_SIZE_STRING)) {
                	array[i]=CarbonServerScriptParser.MAX_PERM_SIZE_STRING+"="+serverVMParamaters.get(CarbonServerScriptParser.MAX_PERM_SIZE_STRING);
                }
            }
			
			StringBuffer buffer=new StringBuffer();
			for (String string : array) {
	            buffer.append(string).append(" ");
            }
//        }
//    	String serverXmlPathFromLocalWorkspaceRepo = CarbonServerUtils.getServerXmlPathFromLocalWorkspaceRepo(serverLocalWorkspacePath);
//    	String transportsXmlPathFromLocalWorkspaceRepo = CarbonServerUtils.getTransportsXmlPathFromLocalWorkspaceRepo(serverLocalWorkspacePath);
//    	vmParameters=vmParameters+" -Dwso2.carbon.xml=\""+serverXmlPathFromLocalWorkspaceRepo+"\"";
//    	vmParameters=vmParameters+" -Dwso2.transports.xml=\""+transportsXmlPathFromLocalWorkspaceRepo+"\"";
//    	vmParameters=vmParameters+" -Dcomponents.repo=\""+serverLocalWorkspacePath+"/repository/components/plugins\"";
    	return buffer.toString();
//			return defaultVMParameters;
    }
    
//    private void checkClosed(IModule[] module) throws CoreException
//    {
//    	for( int i=0; i < module.length; i++ ){
//    		if( module[i] instanceof DeletedModule ){	
//                IStatus status = new Status(IStatus.ERROR,CorePlugin.PLUGIN_ID,0, NLS.bind(GenericServerCoreMessages.canNotPublishDeletedModule,module[i].getName()),null);
//                throw new CoreException(status);
//    		}
//    	}
//    }
    
    public void publishModule(int kind, int deltaKind, IModule[] module,
            IProgressMonitor monitor) throws CoreException {
//    	IModule m = module[module.length - 1];
//    	if(deltaKind == ADDED){
//    		checkClosed(module);
//    		ServerController.getInstance().getServerManager().publishServiceModule(getServer().getId(), "",m.getName());
//    	}else if(deltaKind == REMOVED){
//    		ServerController.getInstance().getServerManager().unpublishServiceModule(getServer().getId(), "",m.getName());
//        }else{
//    		checkClosed(module);
//    		//To add any new services
//    		ServerController.getInstance().getServerManager().publishServiceModule(getServer().getId(), "",m.getName());
//    		ServerController.getInstance().getServerManager().hotUpdateServiceModule(getServer().getId(), "",m.getName());
//    	}
//        setModulePublishState( module, null );
    }
//    private void setModulePublishState( IModule[] module, IStatus[] status ) throws CoreException {
////        if( module==null )
////            return;
////        for( int i=0; i < module.length; i++)
////        {
////            if(status == null ||
////                    status.length < i ||
////                    status[i]==null || 
////                    status[i].getSeverity() == IStatus.OK )
////            {
////            setModulePublishState(module, IServer.PUBLISH_STATE_NONE);    
////            }
////            else
////            {
////                if ( IStatus.ERROR == status[i].getSeverity() ){
////                    setModulePublishState( module, IServer.PUBLISH_STATE_UNKNOWN );
////                    throw new CoreException( status[i] );
////                }
////            }
////        }
//    }
    
    protected void doServerStartedTasks(){
    }
    
    private void doServerStoppedTasks(){
		//unpublishAllModules();
    }

	public void setServerisStillStarting(boolean serverisStillStarting) {
	    this.serverisStillStarting = serverisStillStarting;
    }

	public boolean isServerisStillStarting() {
	    return serverisStillStarting;
    }
	
	protected Integer[] getAllPortsServerWillUse(IServer server) {
		List<Integer> ports=new ArrayList<Integer>();
    	
    	String axis2FilePath = getAxis2FilePath();
    	String transportsXmlPath = getTransportXmlFilePath();
    	String carbonXmlPath = getCarbonXmlFilePath();
    	
		addServletTransportPorts(ports, transportsXmlPath);
		addAxis2XmlPorts(ports, axis2FilePath);
		
		return ports.toArray(new Integer[]{});
	}
	
	protected abstract String getCarbonXmlFilePath();
	
	/**
	 * Added to support C4 but will keep the Backward compatibility
	 * @return
	 */
	protected String getCatelinaXmlFilePath() {
		return null;
	}
	
	protected abstract String getTransportXmlFilePath();
	
	protected abstract String getAxis2FilePath();
	
	protected void addAxis2XmlPorts(List<Integer> ports, String axis2FilePath) {
		XPathFactory factory = XPathFactory.newInstance();
    	try {
    		File xmlDocument = new File(axis2FilePath);
    		DocumentBuilder builder =
                DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = builder.parse(xmlDocument);
	    	XPath xPath=factory.newXPath();
	    	Node httpNode = (Node)xPath.evaluate("/axisconfig/transportReceiver[@class='org.apache.synapse.transport.nhttp.HttpCoreNIOListener']/parameter[@name='port']", document, XPathConstants.NODE);
	    	Node httpsNode = (Node)xPath.evaluate("/axisconfig/transportReceiver[@class='org.apache.synapse.transport.nhttp.HttpCoreNIOSSLListener']/parameter[@name='port']", document, XPathConstants.NODE);
	    	if (httpNode!=null){
	    		ports.add(Integer.parseInt(httpNode.getTextContent()));
	    	}
	    	if (httpsNode!=null) {
				ports.add(Integer.parseInt(httpsNode.getTextContent()));
			}
    	}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	protected void addServletTransportPorts(List<Integer> ports,
			String transportsXmlPath) {
		XPathFactory factory = XPathFactory.newInstance();
		File xmlDocument = new File(transportsXmlPath);
    	try {
			InputSource inputSource =  new InputSource(new FileInputStream(xmlDocument));
			XPath xPath=factory.newXPath();
			XPathExpression  xPathExpression=xPath.compile("/transports/transport[@name='http']/parameter[@name='port']");
			String evaluate = xPathExpression.evaluate(inputSource);
			int port = Integer.parseInt(evaluate);
//			if(port)
			ports.add(Integer.parseInt(evaluate));
			inputSource =  new InputSource(new FileInputStream(xmlDocument));
			xPathExpression=xPath.compile("/transports/transport[@name='https']/parameter[@name='port']");
			evaluate = xPathExpression.evaluate(inputSource);
			ports.add(Integer.parseInt(evaluate));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void addServletTransportPorts(List<Integer> ports,
			String transportsXmlPath, String catelinaXmlPath) {
		//Empty implementation to support C4 but not to break other versions
	}
	
}
