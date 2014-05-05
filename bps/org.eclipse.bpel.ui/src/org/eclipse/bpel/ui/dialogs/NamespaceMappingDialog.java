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
package org.eclipse.bpel.ui.dialogs;


import java.util.Map;

import org.eclipse.bpel.model.util.BPELUtils;
import org.eclipse.bpel.ui.BPELUIPlugin;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.StatusDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;



/**
 * A simple dialog that helps the user choose the right namespace prefix
 * for the given namespace.
 *  
 */

@SuppressWarnings("nls")

public class NamespaceMappingDialog extends StatusDialog {
				
	protected static final String NS_PREFIX = "ns" ; 
	
	protected EObject modelObject;
	
	protected Text fTargetNamespace;
	protected Text fPrefixName;    		
		
	protected Map<String,String> fNamespaceMappings;

	private String fTargetNamespaceValue = ""; //$NON-NLS-1$

	protected String fPrefixValue = ""; //$NON-NLS-1$
	
	
	
	private NamespaceMappingDialog (Shell parent) {
		super(parent);
		
		int shellStyle = getShellStyle();		
        setShellStyle(shellStyle | SWT.RESIZE);        
	}
	
	/**
	 * The modelObject is the model element that indicates the scope in which the
	 * variable should be visible.
	 * @param parent the parent shell
	 * @param eObject the model object 
	 */
	
	public NamespaceMappingDialog (Shell parent, EObject eObject) {
		this(parent);
		setStatusLineAboveButtons(true);	
		this.modelObject = eObject;		
		setTitle(Messages.NamespaceMappingDialog_3);
		computeNamespacePrefix();
	}
	
	/**
	 * Set the target namespace for which we want to establish the prefix for.
	 * @param namespace
	 */
	
	public void setNamespace ( String namespace ) {
		
		fTargetNamespaceValue = namespace;
		
		if (fTargetNamespace != null && fTargetNamespaceValue != null ) {
			fTargetNamespace.setText( namespace );
		}				
	}
	
	
	/**
	 * Compute the next available namespace prefix. 
	 */
	
	public void computeNamespacePrefix ( ) {
		
		if (fNamespaceMappings == null) {
			fNamespaceMappings = BPELUtils.getAllNamespacesForContext(modelObject);
		}
		
		String key = NS_PREFIX;
		for(int i=1;; i++) {
			key = NS_PREFIX + i;
			if (fNamespaceMappings.containsKey(key) == false) {
				break;
			}
		}
		
		setPrefix ( key );		
	}
	
	
	
	/**
	 * Set the prefix name.
	 * @param value
	 */
	
	public void setPrefix ( String value ) {
		fPrefixValue = value;
		
		if (fPrefixName != null && fPrefixValue != null) {
			fPrefixName.setText(fPrefixValue);
			validatePrefix();
		}		
	}

	
	
	/**
	 * Get the prefix value
	 * 
	 * @return the prefix value
	 */
	
	public String getPrefix () {
		return fPrefixValue;
	}
	
	
	/**
     * @see Dialog#createDialogArea(Composite)
     */
	
    @Override
	public Control createDialogArea(Composite parent) {
    	    	    	
        Composite contents = (Composite) super.createDialogArea(parent);               
        createNamespaceArea (contents);
        
        return contents;
    }

    
	protected void createNamespaceArea (Composite parent) {
		
		Group group = new Group(parent,SWT.SHADOW_ETCHED_IN);
		group.setText(Messages.NamespaceMappingDialog_4);			
		GridLayout layout = new GridLayout(1,true);
		GridData data = new GridData();        
        data.grabExcessVerticalSpace = false;
        data.grabExcessHorizontalSpace = true;
        data.horizontalAlignment = GridData.FILL;
        data.verticalAlignment = GridData.BEGINNING;
        
        group.setLayout( layout );
        group.setLayoutData( data );
		
        Composite container = new Composite(group, SWT.NONE);
        
        layout = new GridLayout();
		layout.makeColumnsEqualWidth = true;		
		layout.numColumns = 2;		
		container.setLayout(layout);
		data = new GridData();        
        data.grabExcessVerticalSpace = false;
        data.grabExcessHorizontalSpace = true;
        data.horizontalAlignment = GridData.FILL;
        data.verticalAlignment = GridData.CENTER;
        container.setLayoutData(data);
        
        		
		// Create Target namespace mappings
        
		Composite namespace  = new Composite(group, SWT.NONE);
		
        layout = new GridLayout();			
		layout.numColumns = 2;		
		namespace.setLayout(layout);
		data = new GridData();        
        data.grabExcessVerticalSpace = true;
        data.grabExcessHorizontalSpace = true;
        data.horizontalAlignment = GridData.FILL;
        data.verticalAlignment = GridData.FILL;
        namespace.setLayoutData(data);
        
        
        Label label = new Label(namespace,SWT.NONE);
        label.setText(Messages.NamespaceMappingDialog_5);
        
        fTargetNamespace = new Text(namespace,SWT.BORDER);               
        fTargetNamespace.setEditable(false);
        setNamespace( fTargetNamespaceValue );
        
		data = new GridData();        
        data.grabExcessVerticalSpace = false;
        data.grabExcessHorizontalSpace = true;
        data.horizontalAlignment = GridData.FILL;
        data.verticalAlignment = GridData.FILL;        
        fTargetNamespace.setLayoutData(data);
             
        
        label = new Label(namespace,SWT.NONE);
        label.setText(Messages.NamespaceMappingDialog_6);
        
        fPrefixName = new Text(namespace,SWT.BORDER);        
        setPrefix( fPrefixValue );
        
        fPrefixName.addModifyListener( new ModifyListener () {

			public void modifyText(ModifyEvent e) {
				validatePrefix();
			}
        	
        });
        
		data = new GridData();        
        data.grabExcessVerticalSpace = false;
        data.grabExcessHorizontalSpace = true;
        data.horizontalAlignment = GridData.FILL;
        data.verticalAlignment = GridData.FILL;        
        fPrefixName.setLayoutData(data);
                        
        // End of target namespace variant.                       
	}

	void validatePrefix ( ) {
		fPrefixValue = fPrefixName.getText();
		
		if (fPrefixValue.length() == 0 || fPrefixValue.startsWith("xml") ) { //$NON-NLS-1$
			// TODO: Prefix validation ?
			updateStatus( new Status(IStatus.ERROR,
					BPELUIPlugin.INSTANCE.getID(),
					0, 
					Messages.NamespaceMappingDialog_8,
					null));		
			return;
		} 
		
		if (fNamespaceMappings.containsKey(fPrefixValue)) {

			updateStatus( new Status(IStatus.ERROR,
					BPELUIPlugin.INSTANCE.getID(),
					0, 
					Messages.NamespaceMappingDialog_9,
					null));					
			return ;
			
		}
		
		for(char ch : fPrefixValue.toCharArray()) {
			if (Character.isWhitespace(ch)) {
				updateStatus( new Status(IStatus.ERROR,
						BPELUIPlugin.INSTANCE.getID(),
						0, 
						Messages.NamespaceMappingDialog_8,
						null));
				return ;
			}
		}
		
		updateStatus(Status.OK_STATUS);					
	}
	
	@Override
	protected void updateStatus (IStatus status) {
		super.updateStatus(status);
	}
	
	
}
