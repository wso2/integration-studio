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
package org.eclipse.bpel.ui.preferences;


import java.util.ArrayList;

import org.eclipse.bpel.model.terms.BPELTerms;
import org.eclipse.bpel.ui.BPELUIPlugin;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.bpel.ui.IHelpContextIds;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.PlatformUI;


/**
 * 
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date May 2, 2007
 *
 */

@SuppressWarnings("nls")
public class BPELPreferencePage extends PreferencePage implements IWorkbenchPreferencePage {

	static String PREFERENCE = "preference";
	
	Button fUseAnimation;
	Button fShowFreeFormFlow;
	Button fWarnOnLinks;
	Button fAutoFlowLayout;
	Button fSpecCompliantProcess;

	
	ArrayList<Button> fButtons = new ArrayList<Button>(8);
	
	@Override
	protected Control createContents(Composite parent) {
		Composite result = new Composite(parent, SWT.NONE);	
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		layout.verticalSpacing = 10;
		result.setLayout(layout);
		GridData data = new GridData(GridData.FILL_BOTH);
		result.setLayoutData(data);

		
		fUseAnimation = new Button(result, SWT.CHECK);
		fUseAnimation.setText(Messages.BPELPreferencePage_0); 
		fUseAnimation.setToolTipText(Messages.BPELPreferencePage_0TT); 
		fUseAnimation.setData(PREFERENCE, IBPELUIConstants.PREF_USE_ANIMATION);
		data = new GridData(GridData.FILL_HORIZONTAL);
		data.horizontalSpan = 3;
		fUseAnimation.setLayoutData(data);
		fButtons.add(fUseAnimation);
		
		fShowFreeFormFlow = new Button(result, SWT.CHECK);
		fShowFreeFormFlow.setText(Messages.BPELPreferencePage_1); 
		fShowFreeFormFlow.setData(PREFERENCE,IBPELUIConstants.PREF_SHOW_FREEFORM_FLOW);
		fShowFreeFormFlow.setToolTipText(Messages.BPELPreferencePage_1TT); 	
		data = new GridData(GridData.FILL_HORIZONTAL);
		data.horizontalSpan = 3;
		fShowFreeFormFlow.setLayoutData(data);
		fButtons.add(fShowFreeFormFlow);
		
		fWarnOnLinks = new Button(result, SWT.CHECK);
		fWarnOnLinks.setText(Messages.BPELPreferencePage_2); 
		fWarnOnLinks.setToolTipText(Messages.BPELPreferencePage_2TT);
		fWarnOnLinks.setData(PREFERENCE,IBPELUIConstants.PREF_WARN_LINKS);
		data = new GridData(GridData.FILL_HORIZONTAL);
		data.horizontalSpan = 3;
		fWarnOnLinks.setLayoutData(data);
		fButtons.add(fWarnOnLinks);
		
		fAutoFlowLayout = new Button(result, SWT.CHECK);
		fAutoFlowLayout.setText(Messages.BPELPreferencePage_3); 
		fAutoFlowLayout.setToolTipText(Messages.BPELPreferencePage_3TT);
		fAutoFlowLayout.setData(PREFERENCE,IBPELUIConstants.PREF_AUTO_FLOW_LAYOUT);
		data = new GridData(GridData.FILL_HORIZONTAL);
		data.horizontalSpan = 3;
		fAutoFlowLayout.setLayoutData(data);
		fButtons.add(fAutoFlowLayout);

		fSpecCompliantProcess = new Button(result, SWT.CHECK);
		fSpecCompliantProcess.setText(Messages.BPELPreferencePage_4); 
		fSpecCompliantProcess.setToolTipText(Messages.BPELPreferencePage_4TT);
		fSpecCompliantProcess.setData(PREFERENCE,IBPELUIConstants.PREF_CREATE_SPEC_COMPLIANT_PROCESS);
		data = new GridData(GridData.FILL_HORIZONTAL);
		data.horizontalSpan = 3;
		fSpecCompliantProcess.setLayoutData(data);
		fButtons.add(fSpecCompliantProcess);
		
		
		initializeValues();
		
		PlatformUI.getWorkbench().getHelpSystem().setHelp(
			parent, IHelpContextIds.PREFERENCES_PAGE);
		
		return result;
	}

	/** (non-Javadoc)
	 * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	
	public void init(IWorkbench workbench) {
	}
	
	
	@Override
	protected void performDefaults() {
		super.performDefaults();
		initializeDefaults();
	}

	/**
	 * @see org.eclipse.jface.preference.PreferencePage#performOk()
	 */
	@Override
	public boolean performOk() {
		storeValues();
		return true;
	}

	@Override
	protected void performApply() {
		performOk();
	}
	
	/**
	 * Initializes states of the controls using default values in the preference store.
	 */
	private void initializeDefaults() {
		fUseAnimation.setSelection(BPELUIPlugin.INSTANCE.getPreferenceStore().getDefaultBoolean(IBPELUIConstants.PREF_USE_ANIMATION));
	}

	/**
	 * Initializes states of the controls from the preference store.
	 */
	private void initializeValues() {
		IPreferenceStore store = BPELUIPlugin.INSTANCE.getPreferenceStore();
		
		for(Button b : fButtons) {
			String pref = (String) b.getData(PREFERENCE);
			if (pref != null) {
				b.setSelection( store.getBoolean(pref) );
			}
		}		
	}

	/**
	 * Stores the values of the controls back to the preference store.
	 */
	private void storeValues() {
		IPreferenceStore store = BPELUIPlugin.INSTANCE.getPreferenceStore();

		for(Button b : fButtons) {
			String pref = (String) b.getData(PREFERENCE);
			if (pref != null) {
				store.setValue(pref, b.getSelection() );
			}
		}					

		BPELTerms.getDefault().savePluginPreferences();
	}
}
