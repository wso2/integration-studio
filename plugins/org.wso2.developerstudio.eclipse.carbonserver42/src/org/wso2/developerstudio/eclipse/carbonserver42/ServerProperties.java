package org.wso2.developerstudio.eclipse.carbonserver42;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.wso2.developerstudio.eclipse.carbonserver.base.manager.IProperties;
import org.wso2.developerstudio.eclipse.carbonserver42.util.CarbonServer42Utils;

public class ServerProperties implements IProperties {

	public ServerProperties() {
		// TODO Auto-generated constructor stub
	}

	public Map<String, String> getServerInstanceProperties(String serverPath) {
		Map<String, String> serverInstanceProperties=null;
		
		try {
			serverInstanceProperties = new HashMap<String, String>();
			File file  = new File(CarbonServer42Utils.getCarbonXmlPathFromLocalWorkspaceRepo(serverPath));
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(file);
			XPathFactory xPathfactory = XPathFactory.newInstance();
			XPath xpath = xPathfactory.newXPath();
			XPathExpression expr = xpath.compile("/Server/Ports/Offset");
			String offset = expr.evaluate(doc);
			
		    file  = new File(CarbonServer42Utils.getCatelinaXmlPathFromLocalWorkspaceRepo(serverPath));
			factory = DocumentBuilderFactory.newInstance();
		    builder = factory.newDocumentBuilder();
			doc = builder.parse(file);
			xPathfactory = XPathFactory.newInstance();
			xpath = xPathfactory.newXPath();
		    expr = xpath.compile("/Server/Service/Connector[1]/@port");
			String http = expr.evaluate(doc);
			expr = xpath.compile("/Server/Service/Connector[2]/@port");
			String https = expr.evaluate(doc);
			
			file  = new File(CarbonServer42Utils.getAxis2XmlPathFromLocalWorkspaceRepo(serverPath));
			factory = DocumentBuilderFactory.newInstance();
		    builder = factory.newDocumentBuilder();
			doc = builder.parse(file);
			xPathfactory = XPathFactory.newInstance();
			xpath = xPathfactory.newXPath();
		    expr = xpath.compile("/axisconfig/transportReceiver[@name='http']/parameter[@name='port']");
			String trnhttp = expr.evaluate(doc);
			expr = xpath.compile("/axisconfig/transportReceiver[@name='https']/parameter[@name='port']");
			String trnhttps = expr.evaluate(doc);
			
			serverInstanceProperties.put("carbon.https",https);
			serverInstanceProperties.put("carbon.offset",offset);
			serverInstanceProperties.put("carbon.http",http); 
			serverInstanceProperties.put("synapse.transport.http",trnhttp);
			serverInstanceProperties.put("synapse.transport.https",trnhttps);
			} catch (Exception e) {
					/*Exception ignored*/
			}
		return serverInstanceProperties;
	}

}
