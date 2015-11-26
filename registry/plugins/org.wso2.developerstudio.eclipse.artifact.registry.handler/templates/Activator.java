package org.wso2.custom.internal.registry.handler;

import javax.xml.stream.XMLStreamException;

import org.wso2.carbon.registry.core.jdbc.handlers.HandlerManager;
import org.wso2.carbon.registry.core.exceptions.RegistryException;
import org.wso2.carbon.registry.core.jdbc.handlers.HandlerManager;
import org.wso2.carbon.registry.core.jdbc.handlers.filters.Filter;
import org.wso2.carbon.registry.core.config.RegistryContext;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.apache.axiom.om.util.AXIOMUtil;

import {0};
import {2};

public class Activator implements BundleActivator {6}
	private {1} {8};
	private {3} {9};
	private RegistryContext registryContext;
	private HandlerManager handlerManager;
	
	private String[] applyingFilters;
	 public void start(final BundleContext bundleContext) throws Exception {6}
		registryContext = RegistryContext.getBaseInstance();
		handlerManager = registryContext.getHandlerManager();
		{8} = new {1}();
		{9} = new {3}();
		{5}
		applyingFilters = new String[] {6}{4}{7};
		handlerManager.addHandlerWithPriority(applyingFilters, {9}, {8});
	{7}

	public void stop(BundleContext context) throws Exception {6}
    	handlerManager.removeHandler(applyingFilters, {9}, {8});
	{7}
	
	protected static OMElement getElement(String xmlString) throws XMLStreamException {6}
		return  AXIOMUtil.stringToOM(xmlString);
	{7}
	
{7}