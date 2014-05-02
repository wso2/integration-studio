/*******************************************************************************
 * Copyright (c) 2005, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.ui.commands;

import java.util.ArrayList;

import org.eclipse.bpel.ui.BPELEditor;
import org.eclipse.bpel.ui.commands.util.AutoUndoCommand;
import org.eclipse.wst.wsdl.Definition;
import org.eclipse.wst.wsdl.ExtensibilityElement;

/**
 * Creates a new ExtensibilityElement in a WSDL file.
 */
public abstract class CreateWSDLExtensibilityElementCommand extends AutoUndoCommand {

	protected Definition definition;
	protected ExtensibilityElement element;
	
	public abstract String getDefaultLabel();

	public CreateWSDLExtensibilityElementCommand(Definition definition, ExtensibilityElement element) {
		super(new ArrayList());
		this.definition = definition;
		addModelRoot(this.definition);
		this.element = element; 
		setLabel(getDefaultLabel());
	}
	
	// convenience constructor for the artifacts WSDL file
	public CreateWSDLExtensibilityElementCommand(BPELEditor bpelEditor, ExtensibilityElement element) {
		this(bpelEditor.getArtifactsDefinition(), element);
	}

	@Override
	public void doExecute() {
		definition.getEExtensibilityElements().add(element);
		element.setEnclosingDefinition(definition);
	}
}
