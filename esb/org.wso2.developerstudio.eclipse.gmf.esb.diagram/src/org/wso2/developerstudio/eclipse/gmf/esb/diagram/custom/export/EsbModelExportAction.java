/*
 * Copyright 2009-2010 WSO2, Inc. (http://wso2.com)
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
package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.export;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction;
import org.eclipse.gmf.runtime.diagram.ui.requests.EditCommandRequestWrapper;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;

/**
 * Menu action responsible for exporting ESB visual model.
 */
public class EsbModelExportAction extends DiagramAction {
	/**
	 * Action id.
	 */
	public static final String ACTION_ID = "EsbModelExportDiagramActionId";
	
	/**
	 * Command label (TODO: Externalize).
	 */
	private static final String COMMAND_LABEL = "Export (WSO2 ESB)";
	
	/**
	 * Command tooltip (TODO: Externalize).
	 */
	private static final String COMMAND_TOOL_TIP = "Export As a WSO2 ESB Server Configuration";
	
	/**
	 * Creates a new {@link EsbModelExportAction} instance.
	 * 
	 * @param part {@link IWorkbenchPart} instance.
	 */
	public EsbModelExportAction(IWorkbenchPart part) {
		super(part);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void init() {
		super.init();
		setId(ACTION_ID);
		setText(COMMAND_LABEL);
		setToolTipText(COMMAND_TOOL_TIP);
		ISharedImages workbenchImages = PlatformUI.getWorkbench().getSharedImages();
		setHoverImageDescriptor(workbenchImages.getImageDescriptor(ISharedImages.IMG_ETOOL_PRINT_EDIT));
		setImageDescriptor(workbenchImages.getImageDescriptor(ISharedImages.IMG_ETOOL_PRINT_EDIT));
		setDisabledImageDescriptor(workbenchImages.getImageDescriptor(ISharedImages.IMG_ETOOL_PRINT_EDIT_DISABLED));
	}
	
	/**
	 * {@inheritDoc}
	 */
	protected String getCommandLabel() {
		return COMMAND_LABEL;
	}

	/**
	 * {@inheritDoc}
	 */
	protected Request createTargetRequest() {
		return new EditCommandRequestWrapper(new EsbModelExportRequest(getEditingDomain()));
	}

	/**
	 * {@inheritDoc}
	 */
	protected boolean isSelectionListener() {
		return true;
	}
	
	/**
	 * {@inheritDoc}	
	 */
	protected Command getCommand(Request request) {		
		Resource resource = null;
		Iterator<?> editParts = getOperationSet().iterator();		
		while (editParts.hasNext()) {
			EditPart editPart = (EditPart) editParts.next();
			if(editPart.getModel() instanceof Shape){
				continue;
			}
			EObject element = ((View) editPart.getModel()).getElement();
			if(element==null){
				continue;
			}
			resource = element.eResource();
			if (null != resource) break;
		}
		
		if (null != resource) {
			return new EsbModelExportCommand(resource);
		}
		
		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * Utility method for calculating the editing domain.
	 * 
	 * @return editing domain for this action.
	 */
	protected TransactionalEditingDomain getEditingDomain() {        
        // try adapting the workbench part
        IWorkbenchPart part = getWorkbenchPart();

        if (part != null) {
            IEditingDomainProvider edProvider = (IEditingDomainProvider) part
                .getAdapter(IEditingDomainProvider.class);

            if (edProvider != null) {
            	EditingDomain domain = edProvider.getEditingDomain();
            	
            	if (domain instanceof TransactionalEditingDomain) {
            		return (TransactionalEditingDomain) domain;
            	}
            }
        }
        
        return null;
    }
}
