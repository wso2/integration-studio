package org.wso2.developerstudio.eclipse.carbonserver31.util;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

public class Test {

	public static void main(String[] args) throws XPathExpressionException {
		XPathFactory factory = XPathFactory.newInstance();
    	XPath xPath=factory.newXPath();
    	XPathExpression xPathExpression=xPath.compile("/transports/transport[name='http']/parameter[@name='port']");
    	int a=10;
	}
}
