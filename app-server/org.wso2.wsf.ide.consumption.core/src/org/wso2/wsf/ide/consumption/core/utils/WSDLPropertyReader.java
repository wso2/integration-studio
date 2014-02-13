/*
 * Copyright 2005,2006 WSO2, Inc. http://www.wso2.org
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

package org.wso2.wsf.ide.consumption.core.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.wsdl.Definition;
import javax.wsdl.Port;
import javax.wsdl.Service;
import javax.wsdl.factory.WSDLFactory;
import javax.wsdl.xml.WSDLReader;
import javax.xml.namespace.QName;

import org.apache.axis2.util.URLProcessor;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.wsf.ide.consumption.core.plugin.WebServiceWSASConsumptionCorePlugin;

/**
 * This class presents a convenient way of reading the 
 * WSDL file(url) and producing a useful set of information
 * It does NOT use any of the standard WSDL classes from 
 * Axis2, rather it uses wsdl4j to read the wsdl and extract 
 * the properties (This is meant as a convenience for the UI
 * only. We may not need the whole conversion the WSDLpump 
 * goes through)
 * One would need to change this to suit a proper WSDL 
 */
public class WSDLPropertyReader {
	private static IDeveloperStudioLog log=Logger.getLog(WebServiceWSASConsumptionCorePlugin.PLUGIN_ID);


	//private Definition wsdlDefinition = null;
//	private Class DefinitionClass = null;
//	private Class ServiceClass = null;


	private Definition DefinitionInstance = null;

	public void readWSDL(String projectName, String filepath) throws Exception {
//		ClassLoadingUtil.setLastWebProjectName(projectName);
//		ClassLoadingUtil.init();
		
//		DefinitionClass = ClassLoadingUtil.loadClassFromAntClassLoader("javax.wsdl.Definition");
		
		//		WSDLReader reader = WSDLFactory.newInstance().newWSDLReader();
		//		wsdlDefinition = reader.readWSDL(filepath); 

//		Class WSDLFactoryClass = ClassLoadingUtil
//				.loadClassFromAntClassLoader("javax.wsdl.factory.WSDLFactory");
//		Method newInstanceMethod = WSDLFactoryClass.getMethod("newInstance", null);
//		Object WSDLFactoryObject = newInstanceMethod.invoke(null, null);
		WSDLFactory WSDLFactoryObject = WSDLFactory.newInstance();
//		Class WSDLFactoryImplClass = ClassLoadingUtil
//				.loadClassFromAntClassLoader(WSDLFactoryObject.getClass().getName());
		
//		Method newWSDLReaderMethod = WSDLFactoryImplClass.getMethod("newWSDLReader", null);
//		Object WSDLReaderObject = newWSDLReaderMethod.invoke(WSDLFactoryObject, null);
		WSDLReader WSDLReaderObject = WSDLFactoryObject.newWSDLReader();
//		Class WSDLReaderClass = ClassLoadingUtil
//				.loadClassFromAntClassLoader(WSDLReaderObject.getClass().getName());
//		Method readWSDLMethod = WSDLReaderClass.getMethod("readWSDL", new Class[]{String.class});
//		DefinitionInstance = readWSDLMethod.invoke(WSDLReaderObject, new Object[]{filepath});
		DefinitionInstance = WSDLReaderObject.readWSDL(filepath);
	}

	/**
	 * Returns the namespace map from definition
	 * @return
	 */
	public Map getDefinitionNamespaceMap(){
		Map map = null;
		try {
//			Method getNamespacesMethod = DefinitionClass.getMethod("getNamespaces", null);
//			map = (Map)getNamespacesMethod.invoke(DefinitionInstance, null);
			map = DefinitionInstance.getNamespaces();
		} catch (SecurityException e) {
			log.error(e);
//		} catch (NoSuchMethodException e) {
//			log.error(e);
//		} catch (IllegalArgumentException e) {
//			log.error(e);
//		} catch (IllegalAccessException e) {
//			log.error(e);
//		} catch (InvocationTargetException e) {
//			log.error(e);
		}
		return map;
	}

	/**
	 * get the default package derived by the targetNamespace
	 */
	public String packageFromTargetNamespace(){
		//return  URLProcessor.makePackageName(wsdlDefinition.getTargetNamespace());
		String returnString = null;
		try{
//			Method getTargetNamespaceMethod = DefinitionClass.getMethod("getTargetNamespace", null);
//			String packageName = (String)getTargetNamespaceMethod.invoke(DefinitionInstance, null);
//			Class URLProcessorClass = ClassLoadingUtil
//					.loadClassFromAntClassLoader("org.apache.axis2.util.URLProcessor");
//			Method makePackageNameMethod = URLProcessorClass
//					.getMethod("makePackageName", new Class[]{String.class});
//			returnString = (String)makePackageNameMethod.invoke(null, new Object[]{packageName});
			returnString = URLProcessor.makePackageName(DefinitionInstance.getTargetNamespace());
		} catch (SecurityException e) {
			log.error(e);
//		} catch (NoSuchMethodException e) {
//			log.error(e);
//		} catch (IllegalArgumentException e) {
//			log.error(e);
//		} catch (IllegalAccessException e) {
//			log.error(e);
//		} catch (InvocationTargetException e) {
//			log.error(e);
		}

		return returnString;
	}

	/**
	 * Returns a list of service names
	 * the names are QNames
	 * @return
	 */
	public List<QName> getServiceList(){
		//Service service = null;
		//Map serviceMap = wsdlDefinition.getServices();
		//service = (Service)serviceIterator.next();
		//returnList.add(service.getQName());
		List returnList = new ArrayList();
		try{
			Service serviceInstance;
//			Method getServicesMethod = DefinitionClass.getMethod("getServices", null);
//			Map serviceMap = (Map)getServicesMethod.invoke(DefinitionInstance, null);
			Map serviceMap = DefinitionInstance.getServices();
			if(serviceMap!=null && !serviceMap.isEmpty()){
				Iterator serviceIterator = serviceMap.values().iterator();
				while(serviceIterator.hasNext()){
//					ServiceClass = ClassLoadingUtil
//							.loadClassFromAntClassLoader("javax.wsdl.Service");
//					Method getQNameMethod = ServiceClass.getMethod("getQName", null);
					serviceInstance = (Service)serviceIterator.next();
//					returnList.add(getQNameMethod.invoke(serviceInstance, null));  
					returnList.add(serviceInstance.getQName());
				}
			}
		} catch (SecurityException e) {
			log.error(e);
//		} catch (NoSuchMethodException e) {
//			log.error(e);
//		} catch (IllegalArgumentException e) {
//			log.error(e);
//		} catch (IllegalAccessException e) {
//			log.error(e);
//		} catch (InvocationTargetException e) {
//			log.error(e);
		}
		return returnList;
	}

	/**
	 * Returns a list of ports for a particular service
	 * the names are QNames
	 * @return
	 */
	public List getPortNameList(QName serviceName){
		//List returnList = new ArrayList();
		//Service service = wsdlDefinition.getService(serviceName);
		//Port port = null; 
		//if(service!=null){
		//	Map portMap = service.getPorts();
		//	if (portMap!=null && !portMap.isEmpty()){
		//		Iterator portIterator = portMap.values().iterator();
		//		while(portIterator.hasNext()){
		//			port = (Port)portIterator.next();
		//			returnList.add(port.getName());
		//		}
		//	}
		//}
		//return returnList;

		List returnList = new ArrayList();
		try{	
//			Method getServiceMethod = DefinitionClass
//						.getMethod("getService", new Class[]{serviceName.getClass()});
//			Object serviceInstance = getServiceMethod
//						.invoke(DefinitionInstance, new Object[]{serviceName});
			Service serviceInstance = DefinitionInstance.getService(serviceName);
			Port portInstance = null;
			if(serviceInstance!=null){
//				Method getPortsMethod = ServiceClass.getMethod("getPorts", null);
//				Map portMap = (Map)getPortsMethod.invoke(serviceInstance, null);
				Map portMap = serviceInstance.getPorts();
				if (portMap!=null && !portMap.isEmpty()){
					Iterator portIterator = portMap.values().iterator();
					while(portIterator.hasNext()){
						portInstance = (Port)portIterator.next();
//						Class PortClass = ClassLoadingUtil
//								.loadClassFromAntClassLoader("javax.wsdl.Port");
//						Method getNameMethod = PortClass.getMethod("getName", null);
						returnList.add(portInstance.getName()); 
					}
				}

			}
		} catch (SecurityException e) {
			log.error(e);
//		} catch (NoSuchMethodException e) {
//			log.error(e);
//		} catch (IllegalArgumentException e) {
//			log.error(e);
//		} catch (IllegalAccessException e) {
//			log.error(e);
//		} catch (InvocationTargetException e) {
//			log.error(e);
		}
		return returnList;
	}
	
    /**
     * public method to get loaded wsdl Definition Instance
     * @return
     */
    public Definition getWsdlDefinitionInstance() {
            return DefinitionInstance;
    }
    
}

