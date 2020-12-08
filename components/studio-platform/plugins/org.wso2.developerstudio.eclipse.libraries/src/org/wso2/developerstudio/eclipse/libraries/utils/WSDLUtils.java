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

package org.wso2.developerstudio.eclipse.libraries.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.wsdl.Definition;
import javax.wsdl.Operation;
import javax.wsdl.Port;
import javax.wsdl.PortType;
import javax.wsdl.Service;
import javax.wsdl.WSDLException;
import javax.wsdl.factory.WSDLFactory;
import javax.wsdl.xml.WSDLReader;
import javax.wsdl.xml.WSDLWriter;
import javax.xml.namespace.QName;

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
public class WSDLUtils {

	public static Definition readWSDL(URL url) throws Exception {
		WSDLFactory WSDLFactoryObject = WSDLFactory.newInstance();
		WSDLReader WSDLReaderObject = WSDLFactoryObject.newWSDLReader();
		Definition definitionInstance = WSDLReaderObject.readWSDL(null,url.toURI().toString());
		return definitionInstance;
	}
	
	public static Definition readWSDL(String url) throws Exception {
		WSDLFactory wWSDLFactory = WSDLFactory.newInstance();
		WSDLReader wWSDLReader = wWSDLFactory.newWSDLReader();
		Definition definitionInstance = wWSDLReader.readWSDL(url);
		return definitionInstance;
	}
	

	public static void writeWSDL(Definition definition, OutputStream outputStream) throws WSDLException{
		WSDLFactory WSDLFactoryObject = WSDLFactory.newInstance();
		WSDLWriter wsdlWriter = WSDLFactoryObject.newWSDLWriter();
		wsdlWriter.writeWSDL(definition, outputStream);
	}
	
	public static void writeWSDL(Definition definition, Writer writer) throws WSDLException{
		WSDLFactory WSDLFactoryObject = WSDLFactory.newInstance();
		WSDLWriter wsdlWriter = WSDLFactoryObject.newWSDLWriter();
		wsdlWriter.writeWSDL(definition, writer);
	}
	
	public static void writeWSDL(Definition definition, File file) throws WSDLException, FileNotFoundException{
		writeWSDL(definition, new FileOutputStream(file));
	}
	
	/**
	 * Returns a list of service names
	 * the names are QNames
	 * @return
	 */
	public static List<QName> getServiceList(Definition definition){
		List<QName> returnList = new ArrayList<QName>();
		Service serviceInstance;
		Map serviceMap = definition.getServices();
		if(serviceMap!=null && !serviceMap.isEmpty()){
			Iterator serviceIterator = serviceMap.values().iterator();
			while(serviceIterator.hasNext()){
				serviceInstance = (Service)serviceIterator.next();
				returnList.add(serviceInstance.getQName());
			}
		}
		return returnList;
	}

	/**
	 * Returns the namespace map from definition
	 * @return
	 */
	public static Map getDefinitionNamespaceMap(Definition definition){
		return definition.getNamespaces();
	}
	
	/**
	 * Returns a list of ports for a particular service
	 * the names are QNames
	 * @return
	 */
	public static List<String> getPortNameList(Definition definition, QName serviceName){
		List<String> returnList = new ArrayList<String>();
		Service serviceInstance = definition.getService(serviceName);
		Port portInstance = null;
		if(serviceInstance!=null){
			Map portMap = serviceInstance.getPorts();
			if (portMap!=null && !portMap.isEmpty()){
				Iterator portIterator = portMap.values().iterator();
				while(portIterator.hasNext()){
					portInstance = (Port)portIterator.next();
					returnList.add(portInstance.getName()); 
				}
			}

		}
		return returnList;
	}
	
	public static List<String> getOperationNameList(Definition definition, QName serviceName){
		List<String> returnList = new ArrayList<String>();
		Service serviceInstance = definition.getService(serviceName);
		PortType portType = null;
		if(serviceInstance!=null){
			Map portMap = definition.getPortTypes();
			if (portMap!=null && !portMap.isEmpty()){
				Iterator portIterator = portMap.values().iterator();
				while(portIterator.hasNext()){
					try{
					portType = (PortType)portIterator.next();
					List<Operation> opList =  portType.getOperations();
					for (Operation op : opList) {
						returnList.add(op.getName()); 
					}
					return returnList;
					 }catch(Exception e){
						 /*Ignore*/
					}
				}
			}
		}
		return returnList;
	}
	
	
}

