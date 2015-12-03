/*
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
package org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils;

import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.API_METHOD_DELETE;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.API_METHOD_GET;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.API_METHOD_HEAD;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.API_METHOD_OPTIONS;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.API_METHOD_PATCH;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.API_METHOD_POST;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.API_METHOD_PUT;

import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.swt.widgets.Display;
import org.wso2.developerstudio.eclipse.gmf.esb.APIResource;
import org.wso2.developerstudio.eclipse.gmf.esb.ArtifactType;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.Activator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.messages.util.AbstractESBDebugPointMessage;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.messages.util.ESBAPIDebugPointMessage;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.messages.util.ESBProxyDebugPointMessage;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.messages.util.ESBSequenceDebugPointMessage;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.messages.util.ESBTemplateDebugPointMessage;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.model.ESBDebugModelPresentation;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

import com.google.gson.JsonElement;

/**
 * This class consists exclusively of reusable static methods used by ESB
 * Mediation Debugger implementation.
 *
 */
public class ESBDebugerUtil {

	private static final int NUM_OF_ENTRIES_IN_COMPLEX_SEQ_TYPE = 1;
	private static final String SPACE_STRING = " ";
	private static final String ATTRIBUTE_SEPERATOR = ",";
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	/**
	 * This method will handle an error occurred in the application. The thrown
	 * exception will be logged using {@link IDeveloperStudioLog} and also pop
	 * up an error Dialog of {@link ErrorDialog} mentioning the given message
	 * and occurred exception.
	 * 
	 * @param ex
	 * @param message
	 * @see ErrorDialog
	 * @see IStatus
	 */
	public static void popUpErrorDialogAndLogException(Exception ex,
			final String message) {
		log.error(message, ex);
		String simpleMessage = ex.getMessage();
		final IStatus editorStatus = new Status(IStatus.ERROR,
				Activator.PLUGIN_ID, simpleMessage);
		Display.getDefault().syncExec(new Runnable() {
			@Override
			public void run() {
				ErrorDialog.openError(Display.getDefault().getActiveShell(),
						Messages.ESBDebugerUtil_ErrorDialogTitle, message,
						editorStatus);

			}
		});
	}

	/**
	 * This method remove quotation marks of the entry value of JsonElement and
	 * return only the string value component
	 * 
	 * @param entry
	 * @return
	 */
	public static String convertEntryValueToString(
			Entry<String, JsonElement> entry) {
		return entry.getValue().getAsString();
	}

	public static AbstractESBDebugPointMessage getESBDebugPoint(
			ArtifactType debugPointType, EventMessageType event,
			JsonElement recievedArtifactInfo) {
		switch (debugPointType) {
		case TEMPLATE:
			return getTemplateDebugPoint(event, recievedArtifactInfo);
		case SEQUENCE:
			return getSequenceTypeDebugPoint(event, recievedArtifactInfo);
		default:
			throw new IllegalArgumentException(
					"Illegal Artifacr type for create debug point "
							+ debugPointType);
		}

	}

	private static AbstractESBDebugPointMessage getSequenceTypeDebugPoint(
			EventMessageType event, JsonElement recievedArtifactInfo) {
		Set<Entry<String, JsonElement>> entrySet = recievedArtifactInfo
				.getAsJsonObject().entrySet();
		if (entrySet.size() == NUM_OF_ENTRIES_IN_COMPLEX_SEQ_TYPE) {
			for (Entry<String, JsonElement> entry : entrySet) {
				if (ESBDebuggerConstants.PROXY_LABEL.equalsIgnoreCase(entry
						.getKey())) {
					return new ESBProxyDebugPointMessage(event,
							recievedArtifactInfo);
				} else if (ESBDebuggerConstants.API_LABEL
						.equalsIgnoreCase(entry.getKey())) {
					return new ESBAPIDebugPointMessage(event,
							recievedArtifactInfo);
				}
			}
		} else {
			return new ESBSequenceDebugPointMessage(event, recievedArtifactInfo);
		}
		throw new IllegalArgumentException(
				"Illegal sequence artifact type recived.Artifact should be sequence, proxy or api : "
						+ recievedArtifactInfo.toString());
	}

	private static ESBTemplateDebugPointMessage getTemplateDebugPoint(
			EventMessageType event, JsonElement recievedArtifactInfo) {
		return new ESBTemplateDebugPointMessage(event, recievedArtifactInfo);
	}

	/**
	 * Remove Debug Point from Breakpoint Manager
	 * 
	 * @param breakpoint
	 */
	public static void removeESBDebugPointFromBreakpointManager(
			IBreakpoint breakpoint) {
		try {
			DebugPlugin.getDefault().getBreakpointManager()
					.removeBreakpoint(breakpoint, true);
		} catch (CoreException e1) {
			log.error("Error while removing debug point : " + breakpoint, e1);
		}
	}

	/**
	 * Remove all registered Debug Points from Breakpoint Manager
	 * 
	 * @param breakpoint
	 */
	public static void removeAllESBDebugPointsFromBreakpointManager() {
		IBreakpoint[] breakpoints = DebugPlugin.getDefault()
				.getBreakpointManager()
				.getBreakpoints(ESBDebugModelPresentation.ID);
		for (IBreakpoint breakpoint : breakpoints) {
			removeESBDebugPointFromBreakpointManager(breakpoint);
		}
	}

	/**
	 * This method will list all methods activated from the api resource into a
	 * string
	 * 
	 * @param apiResource
	 * @return
	 */
	public static String getMethodValuesFromResource(APIResource apiResource) {
		StringBuilder methodValuesBuilder = new StringBuilder();
		if (apiResource.isAllowGet()) {
			methodValuesBuilder.append(API_METHOD_GET).append(SPACE_STRING);
		}
		if (apiResource.isAllowPost()) {
			methodValuesBuilder.append(API_METHOD_POST).append(SPACE_STRING);
		}
		if (apiResource.isAllowPut()) {
			methodValuesBuilder.append(API_METHOD_PUT).append(SPACE_STRING);
		}
		if (apiResource.isAllowDelete()) {
			methodValuesBuilder.append(API_METHOD_DELETE).append(SPACE_STRING);
		}
		if (apiResource.isAllowOptions()) {
			methodValuesBuilder.append(API_METHOD_OPTIONS).append(SPACE_STRING);
		}
		if (apiResource.isAllowHead()) {
			methodValuesBuilder.append(API_METHOD_HEAD).append(SPACE_STRING);
		}
		if (apiResource.isAllowPatch()) {
			methodValuesBuilder.append(API_METHOD_PATCH).append(SPACE_STRING);
		}
		return methodValuesBuilder.toString().trim()
				.replace(SPACE_STRING, ATTRIBUTE_SEPERATOR);
	}

}
