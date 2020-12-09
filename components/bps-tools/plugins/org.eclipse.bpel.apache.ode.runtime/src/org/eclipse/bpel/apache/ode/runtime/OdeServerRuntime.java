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
package org.eclipse.bpel.apache.ode.runtime;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jst.server.generic.core.internal.GenericServerRuntime;
import org.eclipse.bpel.runtimes.IBPELRuntimeDelegate;

public class OdeServerRuntime extends GenericServerRuntime implements IBPELRuntimeDelegate {

	public OdeServerRuntime() {
	}
	
	public String getServerAddress()
	{
		return "localhost";
	}

	public String getPort()
	{
		Map m = getAttribute("generic_server_attributes", new HashMap());
		return (String)m.get("port");
	}

	public String getDeployDir()
	{
		return "ode/processes";
	}
}
