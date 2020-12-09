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
/**
 *
 */
package org.eclipse.bpel.ui.wizards;

import org.eclipse.osgi.util.NLS;

/**
 * @author mchmiele
 *
 */
public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.bpel.ui.wizards.messages"; //$NON-NLS-1$


	private Messages() {
	}

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	public static String CreatePartnerLinkTypeWizardNamePage_0;
	public static String CreatePartnerLinkTypeWizardNamePage_1;
	public static String CreatePartnerLinkTypeWizardNamePage_2;
	public static String CreatePartnerLinkTypeWizardNamePage_3;
	public static String CreatePartnerLinkTypeWizardNamePage_4;
	public static String CreatePartnerLinkTypeWizardRolePage_0;
	public static String CreatePartnerLinkTypeWizardRolePage_1;
	public static String CreatePartnerLinkTypeWizardRolePage_2;
	public static String CreatePartnerLinkTypeWizardRolePage_3;
	public static String CreatePartnerLinkTypeWizardRolePage_4;
	public static String CreatePartnerLinkWizard_0;
	public static String CreatePartnerLinkWizard_2;
	public static String CreatePartnerLinkWizard_3;
	public static String CreatePartnerLinkWizard_5;
	public static String CreatePartnerLinkWizard_6;
	public static String CreatePartnerLinkWizard_8;
	public static String CreatePartnerLinkWizard_9;
	public static String NewFileWizard_1;
	public static String BPELCreateOperation_0;
	public static String NewFileWizardPage1_2;
	public static String NewFileWizardPage1_3;
	public static String NewFileWizardPage1_5;
	public static String NewFileWizardPage1_6;
	public static String NewFileWizardPage1_7;
	public static String NewFileWizardPage2_0;
	public static String NewFileWizardPage2_3;
	// https://issues.jboss.org/browse/JBIDE-8591
	public static String NewFileWizard_Not_A_BPELFaceted_Project;

	public static String NewFileWizard_Not_A_BPELContent_Folder;
	public static String NewFileWizard_WSDLCustomPage_Title;
	public static String NewFileWizard_WSDLCustomPage_Description;
	public static String NewFileWizard_WSDLCustomPage_ServiceLable;
	public static String NewFileWizard_WSDLCustomPage_PortLabel;
	public static String NewFileWizard_WSDLCustomPage_AddressLabel;
	public static String NewFileWizard_WSDLCustomPage_BindingLabel;
}
