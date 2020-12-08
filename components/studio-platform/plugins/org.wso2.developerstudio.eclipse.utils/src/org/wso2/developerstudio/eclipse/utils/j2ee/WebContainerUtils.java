package org.wso2.developerstudio.eclipse.utils.j2ee;

import java.io.File;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jst.ws.internal.common.J2EEUtils;
import org.eclipse.jst.ws.internal.common.ServerUtils;
import org.eclipse.wst.server.core.IServer;
import org.eclipse.wst.server.core.ServerCore;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;

public class WebContainerUtils {
	public static IPath getWorkspace(){
		return ResourcesPlugin.getWorkspace().getRoot().getLocation();
	}
	
	public static IProject getProjectName(String project){
		String projectString = replaceEscapecharactors(project.toString());
		return ResourcesPlugin.getWorkspace().getRoot().getProject(
				getProjectNameFromFramewokNameString(projectString));
	}
	
	public static IPath getProjectRoot(String project){
		String projectString = replaceEscapecharactors(project.toString());
		return ResourcesPlugin.getWorkspace().getRoot().getProject(
				getProjectNameFromFramewokNameString(projectString)).getLocation();
	}

	public static String  pathToWebProjectContainer(String project) {
		IPath projectRoot = getProjectRoot(project);
		IPath currentDynamicWebProjectDir = J2EEUtils.getWebContentPath(getProjectName(project));
		IPath currentDynamicWebProjectDirWithoutProjectRoot = J2EEUtils.getWebContentPath(
				getProjectName(project)).removeFirstSegments(1).makeAbsolute();
		if(projectRoot.toOSString().contains(getWorkspace().toOSString())){
			return getWorkspace()
						.append(currentDynamicWebProjectDir).toOSString();
		}else{
			return projectRoot
						.append(currentDynamicWebProjectDirWithoutProjectRoot).toOSString();
		}
		
	}
	
	public static String  pathToWebProjectContainerWEBINF(String project) {
		IPath projectRoot = getProjectRoot(project);
		IPath webContainerWEBINFDir = J2EEUtils.getWebInfPath(
				getProjectName(project));
		IPath webContainerWEBINFDirWithoutProjectRoot = J2EEUtils.getWebInfPath(
				getProjectName(project)).removeFirstSegments(1).makeAbsolute();
		if(projectRoot.toOSString().contains(getWorkspace().toOSString())){
			return getWorkspace()
						.append(webContainerWEBINFDir).toOSString();
		}else{
			return projectRoot
						.append(webContainerWEBINFDirWithoutProjectRoot).toOSString();
		}
	}
	
	public static String  pathToWebProjectContainerMETAINF(String project) {
		String containerDirectory = pathToWebProjectContainer(project);
		String webContainerMETAINF = Constants.DIR_META_INF;
		String webContainerMETAINFString = FileUtils.addAnotherNodeToPath(
												containerDirectory,
												webContainerMETAINF);
		return webContainerMETAINFString;
	}
	
	public static String  pathToWebProjectContainerAxis2Web(String project) {
		String containerDirectory = pathToWebProjectContainer(project);
		String webContainerAxis2Web = Constants.DIR_AXIS2_WEB;
		String webContainerAxis2WebString = FileUtils.addAnotherNodeToPath(
				containerDirectory,
												webContainerAxis2Web);
		return webContainerAxis2WebString;
	}
	
	public static String pathToWebProjectContainerLib(String project){
		String webContainerWEBINFString = pathToWebProjectContainerWEBINF(project);
		return  FileUtils.addAnotherNodeToPath(
				webContainerWEBINFString,
				Constants.DIR_LIB);
		
	}
	
	public static String pathToWebProjectContainerWebXML(String project){
		String webContainerWEBINFString = pathToWebProjectContainerWEBINF(project);
		return  FileUtils.addAnotherNodeToPath(
				webContainerWEBINFString,
				"web.xml");
	}
	
	//Fix for the windows build not working
	private static String replaceEscapecharactors(String vulnarableString){
		if (vulnarableString.indexOf("/")!=-1){
			vulnarableString = vulnarableString.replace('/', File.separator.charAt(0));
		}
		return vulnarableString;
	}
	
	
	private static String getProjectNameFromFramewokNameString(String frameworkProjectString){
		if (frameworkProjectString.indexOf(getSplitCharactor())== -1){
			return frameworkProjectString;
		}else{
			return frameworkProjectString.split(getSplitCharactors())[1];
		}
	}
	
	
	private static String getSplitCharactor(){
		//Windows check (because from inside wtp in return I received a hard coded path)
		if (File.separatorChar == '\\'){
			return "\\" ;
		}else{
			return File.separator;
		}
	}
	
	private static String getSplitCharactors(){
		//Windows check (because from inside wtp in return I received a hard coded path)
		if (File.separatorChar == '\\'){
			return "\\" + File.separator;
		}else{
			return File.separator;
		}
	}
	
	
	public static String getDeployedWSDLURL(IProject serverProject, 
											String ServerFactoryId, 
											String ServerInstanceId,
											String serviceName){ 
		// Note that ServerCore.findServer() might return null if the server cannot be found and
		// ServerUtils.getEncodedWebComponentURL() can handle null server properly (by using ServerFactoryId)
		String deployedWSDLURLpath = null;
		IServer server = null;
		if (ServerInstanceId != null) {
			server = ServerCore.findServer(ServerInstanceId);
		}
		deployedWSDLURLpath = ServerUtils.getEncodedWebComponentURL(serverProject, 
				ServerFactoryId, server);
		if (deployedWSDLURLpath == null) {
			deployedWSDLURLpath = Constants.LOCAL_SERVER_PORT;
		}
		String[] deployedWSDLURLParts = {Constants.SERVICES,serviceName};
		return FileUtils.addNodesToURL(deployedWSDLURLpath, deployedWSDLURLParts)+"?wsdl";
	}
	
	public static String getAxis2WebContainerLibPath(IProject project){
		return getAxis2WebContainerLibPath(pathToWebProjectContainer(project.toString()));
	}
	
	public static String getAxis2WebContainerLibPath(String webcontainerPath){
		return FileUtils.addAnotherNodeToPath(getAxis2WebContainerWEB_INFPath(webcontainerPath),
				Constants.DIR_LIB);
	}
	
	public static String getAxis2WebContainerwebinfClassPath(IProject project){
		return getAxis2WebContainerwebinfClassPath(pathToWebProjectContainer(project.toString()));
	}
	
	public static String getAxis2WebContainerwebinfClassPath(String webcontainerPath){
		return FileUtils.addAnotherNodeToPath(getAxis2WebContainerWEB_INFPath(webcontainerPath),
				Constants.DIR_CLASSES);
	}
	
	public static String getAxis2WebContainerRepositoryPath(String webcontainerPath){
		return FileUtils.addAnotherNodeToPath(getAxis2WebContainerWEB_INFPath(webcontainerPath),
				Constants.DIR_SERVICES);
	}
	
	public static String getAxis2WebContainerWEB_INFPath(String webcontainerPath){
		return  FileUtils.addAnotherNodeToPath(webcontainerPath,Constants.DIR_WEB_INF);
	}

}
