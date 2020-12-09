package org.eclipse.bpel.apache.ode.deploy.ui.pages;

/*******************************************************************************
 * Copyright (c) 2008, 2012 IBM Corporation, University of Stuttgart (IAAS) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation, University of Stuttgart (IAAS) - initial API and implementation
 *******************************************************************************/

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.bpel.apache.ode.deploy.model.dd.TService;
import org.eclipse.bpel.apache.ode.deploy.ui.util.DeployUtils;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.Table;
import org.eclipse.wst.wsdl.Definition;
import org.eclipse.wst.wsdl.Port;
import org.eclipse.wst.wsdl.Service;

/**
 * In-place editor for WSDL services in tables. 
 * 
 * @author Simon Moser (IBM)
 */
public class ServiceCellEditor extends ComboBoxCellEditor {
	
	IProject bpelProject = null;
	ResourceSet resourceSet = null;
	List<Port> portList = null;
	
	public ServiceCellEditor(Table parent, IProject bpelProject, ResourceSet resourceSet)
	{
		super(parent, new String[]{}, SWT.READ_ONLY);
		this.bpelProject = bpelProject;	
		if (resourceSet != null) {
			this.resourceSet = resourceSet;
		}
		else {
			this.resourceSet = new ResourceSetImpl();
		}
	}

	@Override
	protected Object doGetValue() {
		
		Integer integer = (Integer) super.doGetValue();
		
		CCombo combo = (CCombo) getControl();
		String string = combo.getItem(integer.intValue());
		
		Port port = findPortByName(string);
		
		return port;
	}
	
	private Port findPortByName(String string) {
		
		for (Iterator<Port> iterator = portList.iterator(); iterator.hasNext();) {
			Port currentPort = iterator.next();
			if (currentPort.getName().equals(string)){
				return currentPort;
			}
		}
		
		return null;
	}

	@SuppressWarnings("unchecked") //$NON-NLS-1$
	@Override
	protected void doSetValue(Object value) {
		
		List<Service> serviceList = new ArrayList<Service>();
		portList = new ArrayList<Port>();
		
		//load WSDL's 
		List<Definition> wsdlDefs = DeployUtils.loadAllWSDLFromProject(this.bpelProject, this.resourceSet);
		//Assemble All Services from WSDL's 
		for (Iterator<Definition> iterator = wsdlDefs.iterator(); iterator.hasNext();) {
			Definition current = (Definition) iterator.next();
			@SuppressWarnings("rawtypes")
			Map services = current.getServices();
			if (!services.isEmpty()){
				@SuppressWarnings("rawtypes")
				Collection values = services.values();	
				for (Iterator<Service> iterator2 = values.iterator(); iterator2.hasNext();) {
					Service name = iterator2.next();
					serviceList.add(name);					
				}
			}
		}
		
		//now we have all services in a List .. get All Ports from these services
		for (Iterator<Service> iterator = serviceList.iterator(); iterator.hasNext();) {
			Service currentService = iterator.next();
			@SuppressWarnings("rawtypes")
			Map portMap = currentService.getPorts();
			Collection<Port> ports = portMap.values();
			portList.addAll(ports);
		}
		
		String[] items = new String[portList.size() + 1];
		items[0] = DeployUtils.NONE_STRING;
		
		for (int i=1; i<portList.size()+1; i++){
			Port currentPort = (Port) portList.get(i-1);
			items[i] = currentPort.getName();
		}
		
		setItems(items);
		
		if (value != null){
			TService service = (TService) value;
			for (int i = 0; i < portList.size(); i++) {
				Port p = portList.get(i);
				if (p.getName().equals(service.getPort()) &&
						((Service)p.getContainer()).getQName().equals(service.getName())) {
					super.doSetValue(i+1);
					return;
				}
			}
		}
		super.doSetValue(0);
	}
}
