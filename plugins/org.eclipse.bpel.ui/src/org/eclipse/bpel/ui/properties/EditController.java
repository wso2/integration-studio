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
package org.eclipse.bpel.ui.properties;

import org.eclipse.bpel.common.ui.command.ICommandFramework;
import org.eclipse.bpel.common.ui.details.IOngoingChange;
import org.eclipse.bpel.common.ui.details.IValue;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.bpel.ui.commands.util.UpdateModelCommand;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.commands.Command;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

/**
 * The edit controller listens on both the model object and the UI control that is used to edit it
 * and make sure that the two items are in sync. In addition any pending changes are applied as 
 * an update command and placed on the command stack.
 * 
 * The IValue interface provides for a way to get() and set() and object from/into the receiver. 
 * There is one such proxy for the model side (how to get/set items in the model) and one
 * such proxy for the view side (how to get/set the value of the  model in the view).
 * 
 * The Controller has an input object and when set (or re-set via setInput()) it will register
 * itself as an adapter of the input object. As such it receives all notifications from the 
 * object about changes and can thus update the view from that (look at the notifyChanged()
 * method below).
 * 
 * On the view side, it registers to listen for various control changes on the UI controls and 
 * when such changes occur it notifies the command framework of pending or completed edits. 
 * These edits are wrapped into an update command which uses the target object and the feature 
 * to set the value in the model. 
 * 
 */

public class EditController implements IOngoingChange, Listener , Adapter {

	/** The command framework */
	ICommandFramework fCommandFramework;
	
	/** Updating view */
	boolean fbViewUpdate = false;
	
	/** The input object, that we are controlling */
	EObject fInput;
	
	/** The feature to set/unset (may be unspecified when custom model setter is used) */
	EStructuralFeature fFeature;
	
	/** The label */
	String fLabel;
	
	/** That's how we set/get the value into the view */
	IValue fViewValue;
	
	/** That's how we set/get the values into the model */
	IValue fModelValue ;
		
	/**
	 * 
	 * @param commandFramework
	 */
	public EditController (ICommandFramework commandFramework ) {
		fCommandFramework = commandFramework;
		
	}
	
	/**
	 * @param target 
	 */
	
	public void setInput (EObject target) {
		
		if (fInput != null) {
			fInput.eAdapters().remove(this);
		}
		fInput = target;
		
		if (fInput != null) {
			fInput.eAdapters().add(this);
		}
		
	}
	
	
	/**
	 * @return the current input 
	 */
	
	public EObject getInput () {
		return fInput;
	}
	
	
	/**
	 * @param feature
	 */
	
	public void setFeature ( EStructuralFeature feature ) {
		
		if (fFeature == feature) {
			return ;
		}
		
		fFeature = feature;		
		fModelValue = new IValue () {
			public Object get() {
				return fInput.eGet(fFeature);
			}
			public void set(Object object) {
				fInput.eSet(fFeature,object);
			}		
		};
		
	}
	
	/**
	 * Set the model IValue proxy. This is how data is set/gotten from the model. In most cases, this will
	 * be simply the defined mechanism in this class (using EMF reflection).
	 * @param value
	 */
	public void setModeIValue ( IValue value ) {
		fModelValue = value;
	}
	
	/**
	 * Return the model IValue proxy. This is how data is set/gotten from the model. In most cases, this will
	 * be simply the defined mechanism in this class (using EMF reflection).
	 * 
	 * @return the model IValue proxy
	 */
	
	public IValue getModelIValue() {
		return fModelValue;
	}
	
	/**
	 * Get the IValue proxy for the view side. This is how data is pushed into the view or retrieved from a view.
	 * Any transformation of data from text to model object has to happen in such proxies.
	 * 
	 * @param value
	 */
	public void setViewIValue ( IValue value ) {
		fViewValue = value;
	}
	
	/**
	 * Return the view IValue proxy. This is how data is set/gotten from the view. 
	 * @return the view IValue proxy
	 */
	
	public IValue getViewIValue() {
		return fViewValue;
	}
	
	/**
	 * The label argument.
	 * 
	 * @param label
	 */
	
	public void setLabel ( String label ) {
		fLabel = label;
	}
	
	/**
	 * @see org.eclipse.swt.widgets.Listener#handleEvent(org.eclipse.swt.widgets.Event)
	 */
	public void handleEvent (Event event) {
		if (fbViewUpdate) {
			return ;
		}
		switch (event.type) {
		case SWT.KeyDown:
			if (event.character == SWT.CR) {
				finish();
			}
			break;
		case SWT.FocusOut:
			finish(); 
			break;
		case SWT.Modify:
		case SWT.Selection:
		case SWT.DefaultSelection:
			modify(); 
			break;
		case SWT.Dispose:
			abort();
			setInput(null);
			break;
		}
	}
		
	void finish() {
		fCommandFramework.notifyChangeDone(this);
	}
	
	void modify() {
		fCommandFramework.notifyChangeInProgress(this);		
	}
	
	void abort () {
		fCommandFramework.abortCurrentChange();
	}
	
	
	protected boolean isModifyBasedControl(Control c) {
		if (c instanceof CCombo) {
			return (c.getStyle() & SWT.READ_ONLY) == 0; // if not read only
		}
		return (c instanceof Text);
	}

	protected boolean isSelectionBasedControl(Control c) {
		return !(c instanceof Text);
	}

	void registerListener ( Control control, int eventType ) {		
		control.addListener(eventType, this);
	}
	/**
	 * Registers this ChangeHelper with the given control to listen for events
	 * which indicate that a change is in progress (or done).
	 * 
	 * @param controls 
	 */
	
	public void startListeningTo (Control ... controls ) {
		
		for (Control control : controls) {	
			registerListener ( control, SWT.FocusOut );			
			registerListener ( control, SWT.Dispose );
			
			if (isModifyBasedControl(control)) {
				registerListener ( control, SWT.Modify );				
			}
			if (isSelectionBasedControl(control)) {
				registerListener ( control, SWT.Selection );				
				registerListener ( control, SWT.DefaultSelection );				
			}
		}
	}
	
	/**
	 * Registers this ChangeHelper with the given control to listen for the
	 * Enter key.  When Enter is pressed, the change is considered done (this
	 * is appropriate for single-line Text widgets).
	 * @param controls 
	 */
	public void startListeningForEnter (Control ... controls) {
		// NOTE: KeyDown rather than KeyUp, because of similar usage in CCombo.
		for(Control control : controls) {
			registerListener ( control, SWT.KeyDown );			
		}
	}
	
	/**
	 * Unregisters this ChangeHelper from a control previously passed to
	 * startListeningTo() and/or startListeningForEnter().
	 * @param controls 
	 */
	public void stopListeningTo (Control ...controls ) {
		
		for(Control control : controls) {		
			
			control.removeListener(SWT.FocusOut, this);
			if (isModifyBasedControl(control)) {
				control.removeListener(SWT.Modify, this);
			}
			if (isSelectionBasedControl(control)) {
				control.removeListener(SWT.Selection, this);
				control.removeListener(SWT.DefaultSelection, this);
			}
			control.removeListener(SWT.KeyDown, this);
			
		}
		
	}

	/**
	 * The apply command is a generic UpdateModelCommand which sets the value of the model
	 * from the view. Because this is an AutoUndoRedoCommand, everything that is mutated
	 * is recorded and so it can be undone at some point. 
	 * 
	 * @see org.eclipse.bpel.common.ui.details.IOngoingChange#createApplyCommand()
	 */
	public Command createApplyCommand() {
		return new UpdateModelCommand(fInput,getLabel()) {
			@Override
			public void doExecute() {
				fModelValue.set ( fViewValue.get() );
			}			
		};
	}

	/**
	 * @see org.eclipse.bpel.common.ui.details.IOngoingChange#getLabel()
	 */
	@SuppressWarnings("nls")
	public String getLabel() {	
		
		if (fLabel != null) {
			return NLS.bind(Messages.SetCommand_Change_2, fLabel );
		}
		
		if (fFeature != null) {
			return NLS.bind(Messages.SetCommand_Change_2, fFeature.getName() );
		}
		
		return NLS.bind(Messages.SetCommand_Change_2, "...");
	}

	/**
	 * @see org.eclipse.bpel.common.ui.details.IOngoingChange#restoreOldState()
	 */
	public void restoreOldState() {		
		
	}

	/**
	 * @see org.eclipse.emf.common.notify.Adapter#getTarget()
	 */
	public Notifier getTarget() {
		return fInput;
	}

	/**
	 * @see org.eclipse.emf.common.notify.Adapter#isAdapterForType(java.lang.Object)
	 */
	public boolean isAdapterForType (Object type) {
		Class<?> clazz = null;
		// what is type ? (an interface)
		if (type instanceof Class) {
			clazz = (Class<?>) type;
			return clazz.isInstance(this);
		}
		// what else could it be ?
		return false;		
	}

	/**
	 * The model is notifying us that something has happened.  
	 * 
	 * @see org.eclipse.emf.common.notify.Adapter#notifyChanged(org.eclipse.emf.common.notify.Notification)
	 */
	public void notifyChanged (Notification notification) {

		// System.out.println(this + ".notifyChanged(): " + notification);
		
		if (notification.getEventType() == Notification.SET || notification.getEventType() == Notification.UNSET) {
			if ( notification.getFeature() == fFeature || checkNotification(notification)) { 
				updateView ( fModelValue.get () );
			} 			
		} else if (notification.getEventType() == Notification.REMOVING_ADAPTER) {
			// If we were removed, then we set the view to "null"
			if (notification.getOldValue() == this) {
				updateView (null);
			}
		} 
		
	}

	/**
	 * Check if the notification is one that we should be concerned about.
	 * 
	 * This method may be overridden by a subclass if no feature is known or a method 
	 * other then "EMF reflection" is used to set/get values from the model.
	 * 
	 * @param notification
	 * @return true if yes, false if no
	 */
	
	public boolean checkNotification ( Notification notification ) {
		return false;
	}
	
	
	
	/**
	 * Update the view using the value given 
	 * 
	 * @param value
	 */
	
	void updateView (Object value) {
		fbViewUpdate = true;
		try {
			fViewValue.set( value );
		} finally {
			fbViewUpdate = false;
		}
	}
	
	
	
	/**
	 * Target has changed, which for us just means to update the view from the model
	 * 
	 * @see org.eclipse.emf.common.notify.Adapter#setTarget(org.eclipse.emf.common.notify.Notifier)
	 */
	
	public void setTarget (Notifier newTarget) {		
		if (newTarget == null) {
			updateView(null);
		} else {
			updateView ( fModelValue.get() );
		}
	}

	
	
}