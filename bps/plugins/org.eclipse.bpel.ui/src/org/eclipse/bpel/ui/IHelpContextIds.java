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

import org.eclipse.bpel.ui.dialogs.*;
import org.eclipse.bpel.ui.expressions.XPathExpressionEditor;
import org.eclipse.bpel.ui.preferences.*;
import org.eclipse.bpel.ui.properties.*;

/**
 * This class contains context IDs that are used by different sections 
 * of the BPEL designer and may be used by a help plugin.
 */
public interface IHelpContextIds {
  
  /** The prefix for all context IDs in this class. */
	public static final String PREFIX = BPELUIPlugin.PLUGIN_ID + '.';

	// Preferences
	
	/** Context ID for the {@link BPELPreferencePage} and {@link WSILPreferencePage}. */
	public static final String PREFERENCES_PAGE = PREFIX + "preferences_page"; //$NON-NLS-1$
	
	// Editor
	
	/** Context ID for the {@link BPELEditor}. */
	public static final String EDITOR_CANVAS = PREFIX + "editor_canvas"; //$NON-NLS-1$
	/** Context ID for the palette of the {@link BPELEditor}. */
	public static final String EDITOR_PALETTE = PREFIX + "editor_palette"; //$NON-NLS-1$
  /** Context ID for the tray of the {@link BPELEditor}. */
  public static final String TRAY_DESCRIPTION = PREFIX + "editor_tray"; //$NON-NLS-1$
  
	// Dialogs
	
	/** Context ID for the {@link EditMessagePropertyDialog}. */
	public static final String PROPERTY_DIALOG = PREFIX + "property_dialog"; //$NON-NLS-1$
	
	/** Context ID for the {@link EditPropertyAliasDialog}. */
	public static final String PROPERTY_ALIAS_DIALOG = PREFIX + "property_alias_dialog"; //$NON-NLS-1$
	
	// Property Pages
	/** Context ID for the {@link FaultCatchNameSection} and {@link FaultThrowNameSection}. */
	public static final String PROPERTY_PAGE_FAULT = PREFIX + "property_fault"; //$NON-NLS-1$
  /** Context ID for the {@link PartnerLinkImplSection}. */
	public static final String PROPERTY_PAGE_PARTNER_LINK = PREFIX + "property_partner_link"; //$NON-NLS-1$
  /** Context ID for the {@link ActionImplementationSection}. */
	public static final String PROPERTY_PAGE_EMPTY_IMPLEMENTATION = PREFIX + "property_action"; //$NON-NLS-1$
  /** Context ID for the {@link ScopeImplSection}. */
	public static final String PROPERTY_PAGE_SCOPE_IMPLEMENTATION = PREFIX + "property_scope"; //$NON-NLS-1$
	/** Context ID for the {@link CreateInstanceSection}. */
	public static final String PROPERTY_PAGE_PICK_IMPLEMENTATION = PREFIX + "property_instance"; //$NON-NLS-1$
	/** Context ID for the {@link InvokeImplSection}. */
	public static final String PROPERTY_PAGE_INVOKE_IMPLEMENTATION = PREFIX + "property_invoke"; //$NON-NLS-1$
  /** Context ID for the {@link CompensateScopeSection}. */
	public static final String PROPERTY_PAGE_COMPENSATE_IMPLEMENTATION = PREFIX + "property_compensate"; //$NON-NLS-1$
	/** Context ID for the {@link ImportsSection}. */
	public static final String PROPERTY_PAGE_IMPORTS = PREFIX + "property_imports"; //$NON-NLS-1$
	/** Context ID for the {@link NamespacePrefixesSection}. */
	public static final String PROPERTY_PAGE_NAMESPACE_PREFIXES = PREFIX + "property_namespace_prefix"; //$NON-NLS-1$
  /** Context ID for the {@link NamespaceSection}. */
  public static final String PROPERTY_PAGE_NAMESPACE = PREFIX + "property_namespace"; //$NON-NLS-1$
	/** Context ID for the {@link RepeatingAlarmConditionSection}. */
	public static final String PROPERTY_PAGE_REPEAT_ALARM = PREFIX + "property_repeat_alarm"; //$NON-NLS-1$
	/** Context ID for the {@link AttributesSection}. */
	public static final String PROPERTY_PAGE_ATTRIBUTES = PREFIX + "property_attributes"; //$NON-NLS-1$
	/** Context ID for the {@link ValidateSection} and {@link ValidateVariablesSection}. */
	public static final String PROPERTY_PAGE_VALIDATE_DETAILS = PREFIX + "property_validate"; //$NON-NLS-1$
  /** Context ID for the {@link DocumentationSection}. */
  public static final String PROPERTY_PAGE_DOCUMENTATION = PREFIX + "property_documentation"; //$NON-NLS-1$
  /** Context ID for the {@link MessageExchangeSection}. */
  public static final String PROPERTY_PAGE_MESSAGE_EXCHANGE = PREFIX + "property_message_exchange"; //$NON-NLS-1$
  /** Context ID for the {@link NameSection}. */
	public static final String PROPERTY_PAGE_NAME = PREFIX + "property_name";
	/** Context ID for the {@link WaitConditionSection}. */
	public static final String PROPERTY_PAGE_WAIT = PREFIX + "property_wait";
  /** Context ID for the {@link CorrelationSection}. */
	public static final String PROPERTY_PAGE_CORRELATION = PREFIX + "property_correlation";
	/** Context ID for the {@link CorrSetImplSection}. */
	public static final String PROPERTY_PAGE_CORRELATION_SET = PREFIX + "property_correlation_set";
  /** Context ID for the {@link ExitOnStandardFaultSection}. */
  public static final String PROPERTY_PAGE_EXIT_ON_FAULT = PREFIX + "property_exit_on_fault";
  /** Context ID for the {@link ForEachSection}. */
  public static final String PROPERTY_PAGE_FOR_EACH = PREFIX + "property_for_each";
  /** Context ID for the {@link JoinFailureSection}. */
  public static final String PROPERTY_PAGE_JOIN_FAILURE = PREFIX + "property_join_failure";
  /** Context ID for the {@link AssignImplSection}. */
  public static final String PROPERTY_PAGE_ASSIGN = PREFIX + "property_assign";
  /** Context ID for the {@link ForEachSuccessfulBranchesOnlySection}. */
  public static final String PROPERTY_PAGE_FOR_EACH_SUCCESSFUL = PREFIX + "property_for_each_successful";
  
	// XPATH Expression editor
	
  /** Context ID for the date time editor in the {@link XPathExpressionEditor}. */
  public static final String XPATH_DATE = PREFIX + "xpath_date"; //$NON-NLS-1$
  /** Context ID for the duration editor in the {@link XPathExpressionEditor}. */
  public static final String XPATH_DURATION = PREFIX + "xpath_duration"; //$NON-NLS-1$

}
