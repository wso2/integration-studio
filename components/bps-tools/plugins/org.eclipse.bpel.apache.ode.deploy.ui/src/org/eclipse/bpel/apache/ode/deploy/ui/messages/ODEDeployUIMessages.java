/*******************************************************************************
 * Copyright (c) 2008, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.apache.ode.deploy.ui.messages;

import org.eclipse.osgi.util.NLS;

public class ODEDeployUIMessages {
	private static final String BUNDLE_NAME = "org.eclipse.bpel.apache.ode.deploy.ui.messages.ODEDeployUI"; //$NON-NLS-1$

	private ODEDeployUIMessages() {
		// Do not instantiate
	}

	public static String NewODEDeployWizard_Task_Running;
	
	public static String ODEDeployWizardPage_Name;
	public static String ODEDeployWizardPage_Title;
	public static String ODEDeployWizardPage_Description;
	public static String ODEDeployWizardPage_Label_BPELProject;
	public static String ODEDeployWizardPage_Button_Browse;
	public static String ODEDeployWizardPage_Label_DeployFile;
	public static String ODEDeployWizardPage_ContainerSelectionDialog_Message;
	
	public static String ODEDeployWizardPage_Error_Container_IsNULL;
	public static String ODEDeployWizardPage_Error_Container_IsHere;
	public static String ODEDeployWizardPage_Error_Container_IsWritable;
	
	public static String ProcessPage_GeneralStatus_Label;
	public static String ProcessPage_GeneralMemoryButton;
	public static String ProcessPage_GeneralMemoryButton_Tooltip;
	public static String ProcessPage_Service_Description;
	public static String ProcessPage_Invoke_Description;
	public static String ProcessPage_UpdateWarning_Message;
	public static String ODEDeployEditor_NO_PROCESSES_FOUND;
	public static String ODEDeployEditor_No_SaveAs;
	public static String ODEDeployEditor_InvalidInput;

	static {
		NLS.initializeMessages(BUNDLE_NAME, ODEDeployUIMessages.class);
	}
}
