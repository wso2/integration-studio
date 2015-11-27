/*******************************************************************************
 * Copyright (c) 2007, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.ui.util;

import java.util.Collections;
import java.util.List;

import org.eclipse.wst.wsdl.Definition;
import org.eclipse.wst.wsdl.Fault;
import org.eclipse.wst.wsdl.Input;
import org.eclipse.wst.wsdl.Message;
import org.eclipse.wst.wsdl.Operation;
import org.eclipse.wst.wsdl.Output;
import org.eclipse.wst.wsdl.Part;
import org.eclipse.wst.wsdl.PortType;
import org.eclipse.wst.wsdl.util.WSDLConstants;

public class PartMappingUtil {

	public static List<Part> getPartsForPartMapping(Operation operation, int type, String faultName) {

		Definition definition = operation.getEnclosingDefinition();
		PortType portType = (PortType) operation.eContainer();

		// if our operation is a proxy or it does not live in a resource we cannot do anything about
		// it
		if (portType == null || definition == null) {
			return Collections.emptyList();
		}

		Message message = getMessage(operation, type, faultName);

		// if we don't have a message we cannot have parts
		if (message == null) {
			return Collections.emptyList();
		}

		return getPartsForPartMapping(operation, message, type);
	}

	// TODO MI: find better constants for input, output, fault
	private static Message getMessage(Operation operation, int type, String faultName) {

		Message message = null;

		if (type == WSDLConstants.INPUT) {
			Input input = operation.getEInput();
			if (input != null) {
				message = input.getEMessage();
			}
		} else if (type == WSDLConstants.OUTPUT) {
			Output output = operation.getEOutput();
			if (output != null) {
				message = output.getEMessage();
			}
		} else if (type == WSDLConstants.FAULT) {
			Fault fault = (Fault) operation.getFault(faultName);
			if (fault != null) {
				message = fault.getEMessage();
			}
		}

		return message;
	}

	private static List<Part> getPartsForPartMapping(Operation operation, Message message, int type) {

		List<Part> parts = message.getEParts();

		// TODO Do we have any restrictions on the parts we can use for part-mapping? (WSDL
		// style? doc-lit-wrapped? single-part?) If yes - implement them here.

		return parts;
	}

}
