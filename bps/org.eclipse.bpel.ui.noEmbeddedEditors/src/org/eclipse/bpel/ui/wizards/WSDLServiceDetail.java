/*******************************************************************************
 * Copyright (c) 2008, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.ui.wizards;

public class WSDLServiceDetail {

	// https://bugs.eclipse.org/bugs/show_bug.cgi?id=330813
	// https://jira.jboss.org/browse/JBIDE-7165
	// reformatted because the extremely long line lengths were causing eclipse editor to crash!
	public static final String Sync_SOAPDetail = "\n"+
		"<!-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"+
		"     BINDING DEFINITION - Defines the message format and protocol details\n"+
		"     for a web service.\n"+
		"     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->\n"+
		"    <binding name=\"${processName}Binding\" type=\"tns:${processName}\">\n"+
		"    	<soap:binding style=\"document\"\n"+
		"    		transport=\"http://schemas.xmlsoap.org/soap/http\" />\n"+
		"    	<operation name=\"process\">\n"+
		"    		<soap:operation\n"+
		"    			soapAction=\"${namespace}/process\" />\n"+
		"    		<input>\n"+
		"    			<soap:body use=\"literal\" />\n"+
		"    		</input>\n"+
		"    		<output>\n"+
		"    			<soap:body use=\"literal\" />\n"+
		"    		</output>\n"+
		"    	</operation>\n"+
		"    </binding>\n"+
		"\n"+
		"<!-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"+
		"     SERVICE DEFINITION - A service groups a set of ports into\n"+
		"     a service unit.\n"+
		"     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->\n"+
		"    <service name=\"${serviceName}\">\n"+
		"    	<port name=\"${portName}\" binding=\"tns:${processName}Binding\">\n"+
		"    		<soap:address location=\"${address}\" />\n"+
		"    	</port>\n"+
		"    </service>\n";
	public static final String Sync_HTTPDetail = "\n"+
		"<!-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"+
		"     BINDING DEFINITION - Defines the message format and protocol details\n"+
		"     for a web service.\n"+
		"     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->\n"+
		"    <binding name=\"${processName}Binding\" type=\"tns:${processName}\" xmlns:mime=\"http://schemas.xmlsoap.org/wsdl/mime/\">\n"+
		"    	<http:binding verb=\"POST\" />\n"+
		"    	<operation name=\"process\">\n"+
		"    		<http:operation location=\"/process\" />\n"+
		"    		<input>\n"+
		"    			<mime:content type=\"text/xml\"  part=\"payload\"/>\n"+
		"    		</input>\n"+
		"    		<output>\n"+
		"    			<mime:content type=\"text/xml\"  part=\"payload\"/>\n"+
		"    		</output>\n"+
		"    	</operation>\n"+
		"    </binding>\n"+
		"\n"+
		"<!-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"+
		"     SERVICE DEFINITION - A service groups a set of ports into\n"+
		"     a service unit.\n"+
		"     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->\n"+
		"    <service name=\"${serviceName}\">\n"+
		"    	<port name=\"${portName}\" binding=\"tns:${processName}Binding\">\n"+
		"            <http:address location=\"${address}\"/>\n"+
		"        </port>\n"+
		"    </service>\n";

	public static final String Async_SOAPDetail = "\n"+
		"<!-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"+
		"     BINDING DEFINITION - Defines the message format and protocol details\n"+
		"     for a web service.\n"+
		"     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->\n"+
		"    <binding name=\"${processName}Binding\" type=\"tns:${processName}\">\n"+
		"        <soap:binding style=\"document\"\n"+
		"    		transport=\"http://schemas.xmlsoap.org/soap/http\"/>\n"+
		"        <operation name=\"initiate\">\n"+
		"            <soap:operation\n"+
		"    			soapAction=\"${namespace}/initiate\"/>\n"+
		"            <input>\n"+
		"                <soap:body use=\"literal\"/>\n"+
		"            </input>\n"+
		"        </operation>\n"+
		"    </binding>\n"+
		"\n"+
		"    <binding name=\"${processName}CallbackBinding\" type=\"tns:${processName}Callback\">\n"+
		"        <soap:binding style=\"document\" transport=\"http://schemas.xmlsoap.org/soap/http\"/>\n"+
		"        <operation name=\"onResult\">\n"+
		"            <soap:operation\n"+
		"    			soapAction=\"${namespace}/onResult\"/>\n"+
		"            <input>\n"+
		"                <soap:body use=\"literal\"/>\n"+
		"            </input>\n"+
		"        </operation>\n"+
		"    </binding>\n"+
		"\n"+
		"<!-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"+
		"     SERVICE DEFINITION - A service groups a set of ports into\n"+
		"     a service unit.\n"+
		"     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->\n"+
		"    <service name=\"${serviceName}\">\n"+
		"        <port name=\"${portName}\" binding=\"tns:${processName}Binding\">\n"+
		"    		<soap:address location=\"${address}\"/>\n"+
		"        </port>\n"+
		"    </service>\n"+
		"\n"+
		"    <service name=\"${serviceName}Callback\">\n"+
		"        <port name=\"${portName}CallbackPort\" binding=\"tns:${processName}CallbackBinding\">\n"+
		"    		<soap:address location=\"${address}Callback\"/>\n"+
		"        </port>\n"+
		"    </service>\n";

	public static final String Async_HTTPDetail = "\n"+
		"<!-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"+
		"     BINDING DEFINITION - Defines the message format and protocol details\n"+
		"     for a web service.\n"+
		"     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->\n"+
		"    <binding name=\"${processName}Binding\" type=\"tns:${processName}\" xmlns:mime=\"http://schemas.xmlsoap.org/wsdl/mime/\">\n"+
		"    	<http:binding verb=\"POST\" />\n"+
		"    	<operation name=\"initiate\">\n"+
		"    		<http:operation location=\"/initiate\" />\n"+
		"    		<input>\n"+
		"    			<mime:content type=\"text/xml\"  part=\"payload\"/>\n"+
		"    		</input>\n"+
		"    	</operation>\n"+
		"    </binding>\n"+
		"\n"+
		"    <binding name=\"${processName}CallbackBinding\" type=\"tns:${processName}Callback\" xmlns:mime=\"http://schemas.xmlsoap.org/wsdl/mime/\">\n"+
		"    	<http:binding verb=\"POST\" />\n"+
		"    	<operation name=\"onResult\">\n"+
		"    		<http:operation location=\"/onResult\" />\n"+
		"    		<input>\n"+
		"    			<mime:content type=\"text/xml\" part=\"payload\"/>\n"+
		"    		</input>\n"+
		"    	</operation>\n"+
		"    </binding>\n"+
		"\n"+
		"<!-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"+
		"     SERVICE DEFINITION - A service groups a set of ports into\n"+
		"     a service unit.\n"+
		"     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->\n"+
		"    <service name=\"${serviceName}\">\n"+
		"        <port name=\"${portName}\" binding=\"tns:${processName}Binding\">\n"+
		"    		<http:address location=\"${address}\"/>\n"+
		"        </port>\n"+
		"    </service>\n"+
		"\n"+
		"    <service name=\"${serviceName}Callback\">\n"+
		"        <port name=\"${portName}CallbackPort\" binding=\"tns:${processName}CallbackBinding\">\n"+
		"    		<http:address location=\"${address}Callback\"/>\n"+
		"        </port>\n"+
		"    </service>\n";
	
	public static final String Empty_Detail = "\n"+
		"<!-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"+
		"     SERVICE DEFINITION - A service groups a set of ports into\n"+
		"     a service unit.\n"+
		"     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->\n"+
		"    <service name=\"${serviceName}\">\n"+
		"    </service>\n";
	 
}
