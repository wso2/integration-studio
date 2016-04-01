/*******************************************************************************
 * Copyright (c) 2006, 2012 Oracle Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Oracle Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.ui.dialogs;

import java.util.Arrays;
import java.util.List;

import org.eclipse.bpel.ui.BPELUIPlugin;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.AbstractElementListSelectionDialog;
import org.eclipse.ui.dialogs.SelectionStatusDialog;

/**
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Jun 19, 2006
 *
 */
public class ListAndViewDialog extends AbstractElementListSelectionDialog {

		private String fUpperListLabel;

	    private String fLowerViewLabel;	    

	    private Object[] fElements = new Object[0];

	    private Object[] fQualifierElements;

	    protected IDialogSettings fSettings;
	    
	    /**
	     * Creates the two pane element selector.
	     * 
	     * @param parent
	     *            the parent shell.
	     * @param elementRenderer
	     *            the element renderer.
	     * @param qualifierRenderer
	     *            the qualifier renderer.
	     */
	    public ListAndViewDialog(Shell parent, ILabelProvider elementRenderer ) {
	        super(parent, elementRenderer);
	        setSize(75, 15);
	        setAllowDuplicates(true);
	        
	        fSettings = BPELUIPlugin.INSTANCE.getDialogSettingsFor(this);	        
	        setDialogBoundsSettings ( fSettings, getDialogBoundsStrategy()  );
	    }

	    /**
	     * @return Return the dialog settings for this dialog.
	     */
	    
	    public IDialogSettings getDialogSettings () {
	    	return fSettings;
	    }
	    
	    
	    
	    @Override
		public boolean close () {
	    	saveSettings ();	    
	    	return super.close();
	    }
	    
	    
	    protected void saveSettings () {
	    	
	    }
	    
	    /**
	     * Sets the upper list label. If the label is <code>null</code> (default),
	     * no label is created.
	     * 
	     * @param label
	     */
	    public void setUpperListLabel (String label) {
	        fUpperListLabel = label;
	    }

	    /**
	     * Sets the lower list label.
	     * 
	     * @param label
	     *            String or <code>null</code>. If the label is
	     *            <code>null</code> (default), no label is created.
	     */
	    public void setLowerViewLabel(String label) {
	        fLowerViewLabel = label;
	    }

	    /**
	     * Sets the elements to be displayed.
	     * 
	     * @param elements
	     *            the elements to be displayed.
	     */
	    public void setElements(Object[] elements) {
	        fElements = elements;
	    }

	    /*
	     * @see Dialog#createDialogArea(Composite)
	     */
	    @Override
		public Control createDialogArea(Composite parent) {
	    	
	        Composite contents = (Composite) super.createDialogArea(parent);
	        createMessageArea(contents);
	        createFilterText(contents);
	        createLabel(contents, fUpperListLabel);
	        createFilteredList(contents);
	        createLabel(contents, fLowerViewLabel);
	        createLowerView(contents);
	        setListElements(fElements);
	        
	        List initialSelections = getInitialElementSelections();
	        if (!initialSelections.isEmpty()) {
	            Object element = initialSelections.get(0);
	            setSelection(new Object[] { element });	            
	        }
	        return contents;
	    }

	    /**
	     * Creates a label if name was not <code>null</code>.
	     * 
	     * @param parent
	     *            the parent composite.
	     * @param name
	     *            the name of the label.
	     * @return returns a label if a name was given, <code>null</code>
	     *         otherwise.
	     */
	    protected Label createLabel(Composite parent, String name) {
	        if (name == null) {
				return null;
			}
	        Label label = new Label(parent, SWT.NONE);
	        label.setText(name);
	        label.setFont(parent.getFont());
	        return label;
	    }

	    /**
	     * Creates the list widget and sets layout data.
	     * 
	     * @param parent
	     *            the parent composite.
	     * @return returns the list table widget.
	     */
	    protected Object createLowerView (Composite parent) {	    		    	
	        return null;
	    }

	    /**
	     * @see SelectionStatusDialog#computeResult()
	     */
	    @Override
		protected void computeResult() {
	    	setResult(Arrays.asList(getSelectedElements()));
	    }

	    /**
	     * @see AbstractElementListSelectionDialog#handleDefaultSelected()
	     */
	    @Override
		protected void handleDefaultSelected() {
	        if ( validateCurrentSelection() ) {
				buttonPressed(IDialogConstants.OK_ID);
			}
	    }

	    /**
	     * @see AbstractElementListSelectionDialog#handleSelectionChanged()
	     */
	    @Override
		protected void handleSelectionChanged() {
	        handleUpperSelectionChanged();
	        // https://bugs.eclipse.org/bugs/show_bug.cgi?id=330813
	        // https://jira.jboss.org/browse/JBIDE-7107
	        updateOkState();
	    }

	    private void handleUpperSelectionChanged() {
	        int index = getSelectionIndex();

	        if (index >= 0) {
		        fQualifierElements = getFoldedElements(index);
		        if (fQualifierElements == null) {
					updateLowerViewWidget(new Object[] {});
				} else {
					updateLowerViewWidget(fQualifierElements);
				}
	        } else {
	        	updateLowerViewWidget(new Object[] {});
	        }
	        
	        validateCurrentSelection();
	        // https://bugs.eclipse.org/bugs/show_bug.cgi?id=330813
	        // https://jira.jboss.org/browse/JBIDE-7107
	        updateOkState();
	    }


	    protected void updateLowerViewWidget(Object[] elements) {
	    	
	    }

	}	
