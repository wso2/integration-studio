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
package org.eclipse.bpel.ui;

import org.eclipse.bpel.model.Process;
import org.eclipse.bpel.ui.uiextensionmodel.EndNode;
import org.eclipse.bpel.ui.uiextensionmodel.StartNode;
import org.eclipse.bpel.ui.uiextensionmodel.UiextensionmodelFactory;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.ui.IEditorPart;


/**
 * The BPELEditDomain provides global access (with respect to the graphical
 * editor) to the start and end nodes. 
 */
public class BPELEditDomain extends DefaultEditDomain {
    StartNode startNode;
    EndNode endNode;
    
    public BPELEditDomain(IEditorPart editorPart) {
        super(editorPart);
        endNode = UiextensionmodelFactory.eINSTANCE.createEndNode();
        startNode = UiextensionmodelFactory.eINSTANCE.createStartNode();
    }
    public StartNode getStartNode() {
    	return startNode;
    }
    public EndNode getEndNode() {
    	return endNode;
    }
    public void setProcess(Process process) {
    	startNode.setProcess(process);
    }
}
