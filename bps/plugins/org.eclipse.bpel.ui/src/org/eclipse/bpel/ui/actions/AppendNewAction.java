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
package org.eclipse.bpel.ui.actions;

import java.util.List;

import org.eclipse.bpel.model.BPELExtensibleElement;
import org.eclipse.bpel.ui.BPELEditor;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.bpel.ui.adapters.IContainer;
import org.eclipse.bpel.ui.commands.CompoundCommand;
import org.eclipse.bpel.ui.commands.InsertInContainerCommand;
import org.eclipse.bpel.ui.commands.SetNameAndDirectEditCommand;
import org.eclipse.bpel.ui.commands.SetSelectionCommand;
import org.eclipse.bpel.ui.factories.AbstractUIObjectFactory;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.osgi.util.NLS;
import org.eclipse.ui.IWorkbenchPart;



/**
 * This action appends a new object to the container object that is currently <b>selected</b>.
 * 
 * The selection must be of type BPELExtensibleElement and it must allow an addition of such an object
 * to the list of children (via the IContainer interface).
 * 
 * 
 * @author IBM Original contribution.
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date May 31, 2007
 *
 */


public class AppendNewAction extends SelectionAction {
	
	protected AbstractUIObjectFactory factory;
	protected Object cachedInstance;  // used for IContainer.canAddObject()
	
	/** the computed selection */
	protected BPELExtensibleElement fSelection;
	
	
	/**
	 * Brand new AppendNewAction action object.
	 * 
	 * @param editor the editor
	 * @param aFactory the factory
	 */
	public AppendNewAction(IWorkbenchPart editor, AbstractUIObjectFactory aFactory) {
		this(editor, aFactory, aFactory.getTypeLabel());
	}
	
	/**
	 * Brand new AppendNewAction action object.
	 * 
	 * @param editor
	 * @param aFactory
	 * @param label 
	 */
	
	public AppendNewAction(IWorkbenchPart editor, AbstractUIObjectFactory aFactory, String label) {
		super(editor);
		this.factory = aFactory;
		
		cachedInstance = factory.getNewObject();
		setId(calculateID());
		setText(label);
		setToolTipText(NLS.bind(Messages.AppendNewAction_Add_a_1, (new Object[] { getText() }))); 
		setImageDescriptor(factory.getSmallImageDescriptor());
	}

	@Override
	protected void init() {
		super.init();
		setEnabled(false);
	}

	
	protected String calculateID() {
		return "appendNew."+factory.getUniqueIdString(); //$NON-NLS-1$
	}
	
	
	/**
	 * Return the create command.
	 * 
	 * @return the create command for add the new activity.
	 */
	
	public Command getCreateCommand () {
		
		if (fSelection == null) {
			return null;
		}
		
		CompoundCommand compoundCmd = new CompoundCommand();
		
		BPELEditor bpelEditor = (BPELEditor) getWorkbenchPart();
		EditPartViewer viewer = bpelEditor.getGraphicalViewer();
		
		EObject model = (EObject) factory.getNewObject();
		
		compoundCmd.add( new InsertInContainerCommand( fSelection,model,null ) );
		compoundCmd.add( new SetSelectionCommand ( fSelection, true ) );
		compoundCmd.add( new SetSelectionCommand ( model, false ) );
		compoundCmd.add( new SetNameAndDirectEditCommand (model, viewer) );
		
		return compoundCmd;
	}
	
	
	
	@Override
	protected boolean calculateEnabled() {
			
		List<?> objects = getSelectedObjects();
		
		if ( objects.size() != 1 ) {
			
			fSelection = null;
			return false;
		}

		Object sel = objects.get(0);		
		
		if (sel instanceof EditPart) {
			EditPart part = (EditPart) sel;
			sel = part.getModel();
		} 
		
		if (sel instanceof BPELExtensibleElement) {
			fSelection = (BPELExtensibleElement) sel;
		} 
		
		if (fSelection == null) {
			fSelection = null;
			return false;
		}
		
		IContainer container = BPELUtil.adapt(fSelection, IContainer.class);
		if (container == null) {
			fSelection = null;
			return false;
		}
		// make sure it can contain something of this type
		if ( container.canAddObject(fSelection, cachedInstance, null) == false ) {
			fSelection = null; 
			return false;
		}
		
		return true;
	}

	
	/**
	 * @see org.eclipse.jface.action.Action#run()
	 */
	@Override
	public void run() {		
		execute( getCreateCommand() );
	}
	
}
