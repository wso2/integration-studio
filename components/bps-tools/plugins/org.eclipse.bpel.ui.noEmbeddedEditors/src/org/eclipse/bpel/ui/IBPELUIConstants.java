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

import org.eclipse.bpel.model.terms.BPELTerms;
import org.eclipse.core.runtime.QualifiedName;

@SuppressWarnings({"nls"})

public interface IBPELUIConstants {
	// File extensions
	public final String EXTENSION_BPEL = "bpel"; //$NON-NLS-1$
	public final String EXTENSION_WSDL = "wsdl"; //$NON-NLS-1$
	public final String EXTENSION_WSIL = "wsil"; //$NON-NLS-1$
	public final String EXTENSION_XSD = "xsd"; //$NON-NLS-1$
	
	public final String EXTENSION_MODEL_EXTENSIONS = "bpelex"; //$NON-NLS-1$
	
	public final String EXTENSION_DOT_BPEL = "." + EXTENSION_BPEL; //$NON-NLS-1$
	public final String EXTENSION_DOT_WSDL = "." + EXTENSION_WSDL; //$NON-NLS-1$
	public final String EXTENSION_DOT_WSIL = "." + EXTENSION_WSIL; //$NON-NLS-1$
	public final String EXTENSION_DOT_XSD  = "." + EXTENSION_XSD; //$NON-NLS-1$
	
	public final String EXTENSION_STAR_DOT_XSD  = "*" + EXTENSION_DOT_XSD;
	public final String EXTENSION_STAR_DOT_WSDL = "*" + EXTENSION_DOT_WSDL;
	public final String EXTENSION_STAR_DOT_WSIL = "*" + EXTENSION_DOT_WSIL;
	public final String EXTENSION_STAR_DOT_ANY = "*.*";
	
	public final String EXTENSION_XSD_NAME = "XML Schema Files";
	public final String EXTENSION_WSDL_NAME = "WSDL Definition Files";
	public final String EXTENSION_ANY_NAME = "All";

	// ID of editor
	public final String BPEL_EDITOR_ID = "org.eclipse.bpel.ui.bpeleditor"; //$NON-NLS-1$
	public final String DEFAULT_EDITOR_PAGE = "org.eclipse.bpel.ui.bpeleditor.defaultpage"; //$NON-NLS-1$
	public static final String DESIGN_PAGE = "org.eclipse.bpel.ui.bpeleditor.designpage"; //$NON-NLS-1$
	public static final String SOURCE_PAGE = "org.eclipse.bpel.ui.bpeleditor.sourcepage"; //$NON-NLS-1$

	// Namespace for model extension set
	public final String MODEL_EXTENSIONS_NAMESPACE = "http://org.eclipse.bpel.ui/"; //$NON-NLS-1$

	// Image path
	public final String ICON_PATH = "icons/"; //$NON-NLS-1$

	// Preferences
	public final String PREF_USE_ANIMATION = "pref_use_animation"; //$NON-NLS-1$
	public final String PREF_BPEL_TERMS_PATH = BPELTerms.PREF_BPEL_TERMS_PATH;
	public final String PREF_CREATE_SPEC_COMPLIANT_PROCESS = "pref_create_spec_compliant"; //$NON-NLS-1$
	public final String PREF_WSIL_URL = "pref_wsil_url"; //$NON-NLS-1$
	
	// Eclipse property view ID
	public static final String PROPERTY_VIEW_ID = "org.eclipse.ui.views.PropertySheet"; //$NON-NLS-1$
	
	// Generic icons
	public final String ICON_SEPARATOR_16 = "obj16/separator.gif"; //$NON-NLS-1$
	public final String ICON_COMMAND_16 = "obj16/command.gif"; //$NON-NLS-1$
	
	// Images
		
	// Activities
	public final String ICON_ASSIGN_16 = "obj16/assign.gif"; //$NON-NLS-1$
	public final String ICON_ASSIGN_32 = "obj20/assign.png"; //$NON-NLS-1$
	public final String ICON_ASSIGNE4X_16 = "obj16/assigne4x.gif"; //$NON-NLS-1$
	public final String ICON_ASSIGNE4X_32 = "obj20/assigne4x.png"; //$NON-NLS-1$
	public final String ICON_EMPTY_16 = "obj16/empty.gif"; //$NON-NLS-1$
	public final String ICON_EMPTY_32 = "obj20/empty.png"; //$NON-NLS-1$
	public final String ICON_FLOW_16 = "obj16/flow.gif"; //$NON-NLS-1$
	public final String ICON_FLOW_32 = "obj20/flow.png"; //$NON-NLS-1$
	public final String ICON_INVOKE_16 = "obj16/invoke.gif"; //$NON-NLS-1$
	public final String ICON_INVOKE_32 = "obj20/invoke.png"; //$NON-NLS-1$
	public final String ICON_OPAQUEACTIVITY_16 = "obj16/opaqueactivity.gif"; //$NON-NLS-1$
	public final String ICON_OPAQUEACTIVITY_32 = "obj20/opaqueactivity.png"; //$NON-NLS-1$
	// Bugzilla 324115
	public final String ICON_EXTENSIONCTIVITY_16 = "obj16/extensionactivity.gif"; //$NON-NLS-1$
	public final String ICON_EXTENSIONACTIVITY_32 = "obj20/extensionactivity.png"; //$NON-NLS-1$
	public final String ICON_PICK_16 = "obj16/pick.gif"; //$NON-NLS-1$
	public final String ICON_PICK_32 = "obj20/pick.png"; //$NON-NLS-1$
	public final String ICON_RECEIVE_16 = "obj16/receive.gif"; //$NON-NLS-1$
	public final String ICON_RECEIVE_32 = "obj20/receive.png"; //$NON-NLS-1$
	public final String ICON_REPLY_16 = "obj16/reply.gif"; //$NON-NLS-1$
	public final String ICON_REPLY_32 = "obj20/reply.png"; //$NON-NLS-1$
	public final String ICON_SCOPE_16 = "obj16/scope.gif"; //$NON-NLS-1$
	public final String ICON_SCOPE_32 = "obj20/scope.png"; //$NON-NLS-1$
	public final String ICON_SEQUENCE_16 = "obj16/sequence.gif"; //$NON-NLS-1$
	public final String ICON_SEQUENCE_32 = "obj20/sequence.png"; //$NON-NLS-1$
	public final String ICON_IF_16 = "obj16/if.gif"; //$NON-NLS-1$
	public final String ICON_IF_32 = "obj20/if.png"; //$NON-NLS-1$
	public final String ICON_EXIT_16 = "obj16/exit.gif"; //$NON-NLS-1$
	public final String ICON_EXIT_32 = "obj20/exit.png"; //$NON-NLS-1$
	public final String ICON_THROW_16 = "obj16/throw.gif"; //$NON-NLS-1$
	public final String ICON_THROW_32 = "obj20/throw.png"; //$NON-NLS-1$
	public final String ICON_RETHROW_16 = "obj16/rethrow.gif"; //$NON-NLS-1$
	public final String ICON_RETHROW_32 = "obj20/rethrow.png"; //$NON-NLS-1$
	public final String ICON_COMPENSATE_16 = "obj16/compensate.gif"; //$NON-NLS-1$  
	public final String ICON_COMPENSATE_32 = "obj20/compensate.png"; //$NON-NLS-1$
	public final String ICON_COMPENSATE_SCOPE_16 = "obj16/compensatescope.gif"; //$NON-NLS-1$  
	public final String ICON_COMPENSATE_SCOPE_32 = "obj20/compensatescope.png"; //$NON-NLS-1$

	public final String ICON_WAIT_16 = "obj16/wait.gif"; //$NON-NLS-1$
	public final String ICON_WAIT_32 = "obj20/wait.png"; //$NON-NLS-1$
	public final String ICON_WHILE_16 = "obj16/while.gif"; //$NON-NLS-1$
	public final String ICON_WHILE_32 = "obj20/while.png"; //$NON-NLS-1$
	public final String ICON_FOREACH_16 = "obj16/foreach.gif"; //$NON-NLS-1$
	public final String ICON_FOREACH_32 = "obj20/foreach.png"; //$NON-NLS-1$
	public final String ICON_REPEAT_UNTIL_16 = "obj16/repeatuntil.gif"; //$NON-NLS-1$
	public final String ICON_REPEAT_UNTIL_32 = "obj20/repeatuntil.png"; //$NON-NLS-1$
	public final String ICON_VALIDATE_16 = "obj16/validate.gif"; //$NON-NLS-1$
	public final String ICON_VALIDATE_32 = "obj20/validate.png"; //$NON-NLS-1$
	
	
	// Other objects that appear on the canvas
	public final String ICON_PROCESS_16 = "obj16/bpel.gif"; //$NON-NLS-1$
	public final String ICON_PROCESS_32 = "obj20/bpel.png"; //$NON-NLS-1$
	public final String ICON_PARTNER_16 = "obj16/partner.gif"; //$NON-NLS-1$
	public final String ICON_PARTNER_32 = "obj20/partner.png"; //$NON-NLS-1$
	public final String ICON_PARTNER_IN_16 = "obj16/partner_in_pal.gif"; //$NON-NLS-1$
	public final String ICON_PARTNER_OUT_16 = "obj16/partner_ref_pal.gif"; //$NON-NLS-1$
	public final String ICON_VARIABLE_16 = "obj16/variable.gif"; //$NON-NLS-1$
	public final String ICON_VARIABLE_32 = "obj20/variable.png"; //$NON-NLS-1$
	public final String ICON_CORRELATIONSET_16 = "obj16/correlationset.gif"; //$NON-NLS-1$
	public final String ICON_CORRELATIONSET_32 = "obj20/correlationset.png"; //$NON-NLS-1$
	public final String ICON_LINK_16 = "obj16/link.gif"; //$NON-NLS-1$
	public final String ICON_LINK_32 = "obj20/link.png"; //$NON-NLS-1$
	public final String ICON_STARTNODE_16_GIF = "dgm/startnode.gif"; //$NON-NLS-1$
	public final String ICON_ENDNODE_16_GIF = "dgm/endnode.gif"; //$NON-NLS-1$	
	public final String ICON_MESSAGEEXCHANGE_16 = "obj16/messageexchange.gif"; //$NON-NLS-1$
	public final String ICON_MESSAGEEXCHANGE_32 = "obj20/messageexchange.png"; //$NON-NLS-1$

	// More model objects that appear in the details area
	public final String ICON_CASE_16 = "obj16/case.gif"; //$NON-NLS-1$
	public final String ICON_CASE_32 = "obj20/case.png"; //$NON-NLS-1$
	public final String ICON_OTHERWISE_16 = "obj16/otherwise.gif"; //$NON-NLS-1$
	public final String ICON_OTHERWISE_32 = "obj20/otherwise.png"; //$NON-NLS-1$
	public final String ICON_ONMESSAGE_16 = "obj16/onmessage.gif"; //$NON-NLS-1$
	public final String ICON_ONMESSAGE_32 = "obj20/onmessage.png"; //$NON-NLS-1$
	public final String ICON_ONALARM_16 = "obj16/onalarm.gif"; //$NON-NLS-1$
	public final String ICON_ONALARM_32 = "obj20/onalarm.png"; //$NON-NLS-1$
	public final String ICON_FAULTHANDLER_16 = "obj16/faulthandler.gif"; //$NON-NLS-1$
	public final String ICON_FAULTHANDLER_32 = "obj20/faulthandler.png"; //$NON-NLS-1$
	public final String ICON_COMPENSATIONHANDLER_16 = "obj16/compensationhandler.gif"; //$NON-NLS-1$
	public final String ICON_COMPENSATIONHANDLER_32 = "obj20/compensationhandler.png"; //$NON-NLS-1$
	public final String ICON_EVENTHANDLER_16 = "obj16/eventhandler.gif"; //$NON-NLS-1$
	public final String ICON_EVENTHANDLER_32 = "obj20/eventhandler.png"; //$NON-NLS-1$
	public final String ICON_CATCH_16 = "obj16/catch.gif"; //$NON-NLS-1$
	public final String ICON_CATCH_32 = "obj20/catch.png"; //$NON-NLS-1$
	public final String ICON_CATCHALL_16 = "obj16/catchall.gif"; //$NON-NLS-1$
	public final String ICON_CATCHALL_32 = "obj20/catchall.png"; //$NON-NLS-1$
	public final String ICON_TERMINATIONHANDLER_16 = "obj16/terminationhandler.gif"; //$NON-NLS-1$
	public final String ICON_TERMINATIONHANDLER_32 = "obj20/terminationhandler.png"; //$NON-NLS-1$

	// Overlays
	public final String ICON_FAULT_INDICATOR = "ovr16/faulthandler.gif"; //$NON-NLS-1$
	public final String ICON_COMPENSATION_INDICATOR = "ovr16/compensationhandler.gif"; //$NON-NLS-1$
	public final String ICON_EVENT_INDICATOR = "ovr16/eventhandler.gif"; //$NON-NLS-1$
	public final String ICON_TERMINATION_INDICATOR = "ovr16/terminationhandler.gif"; //$NON-NLS-1$

	// Wizard banner
	public final String ICON_WIZARD_BANNER = "wizban/new_bpel.gif"; //$NON-NLS-1$

	// Outline view
	public final String ICON_OUTLINE_16 = "elcl16/outline.gif"; //$NON-NLS-1$
	public final String ICON_OVERVIEW_16 = "elcl16/overview.gif"; //$NON-NLS-1$
	
	// Duplicate 
	public final String ICON_DUPLICATE_16_E = "elcl16/duplicate.png";
	public final String ICON_DUPLICATE_16_D = "dlcl16/duplicate.png";	

	// Action sets
	public final String ICON_ACTION_COMPENSATE    = ICON_COMPENSATE_16;
	public final String ICON_ACTION_CASE          = ICON_CASE_16;
	public final String ICON_ACTION_OTHERWISE     = ICON_OTHERWISE_16;
	public final String ICON_ACTION_INCOMING      = "obj16/incomingvariable.gif"; //$NON-NLS-1$
	public final String ICON_ACTION_INCOMING_GIF  = "obj16/incomingvariable.gif"; //$NON-NLS-1$
	public final String ICON_ACTION_OUTGOING      = "obj16/outgoingvariable.gif"; //$NON-NLS-1$
	public final String ICON_ACTION_OUTGOING_GIF  = "obj16/outgoingvariable.gif"; //$NON-NLS-1$
	public final String ICON_ACTION_PARTNERLINK   = ICON_PARTNER_16;
	public final String ICON_ACTION_ONALARM       = ICON_ONALARM_16;
	public final String ICON_ACTION_ONMESSAGE     = ICON_ONMESSAGE_16;
	public final String ICON_ACTION_FAULTHANDLER  = ICON_FAULTHANDLER_16;
	public final String ICON_ACTION_COMPENSATIONHANDLER  = ICON_COMPENSATIONHANDLER_16;
	public final String ICON_ACTION_TERMINATIONHANDLER   = ICON_TERMINATIONHANDLER_16;
	public final String ICON_ACTION_EVENTHANDLER  = ICON_EVENTHANDLER_16;
	public final String ICON_ACTION_CATCH         = ICON_CATCH_16;
	public final String ICON_ACTION_CATCHALL      = ICON_CATCHALL_16;
	
	// Collapse icons
	public final String ICON_FIGURE_EXPANDED = "obj16/expand.gif"; //$NON-NLS-1$
	public final String ICON_FIGURE_COLLAPSED = "obj16/collapse.gif"; //$NON-NLS-1$

	public final String ICON_MESSAGE_16 = "obj16/message.gif"; //$NON-NLS-1$
	public final String ICON_MESSAGE_32 = "obj20/message.png"; //$NON-NLS-1$
	public final String ICON_OPERATION_16 = "obj16/operation.gif"; //$NON-NLS-1$
	public final String ICON_PART_16 = "obj16/message_part.gif";  //$NON-NLS-1$
	public final String ICON_PART_32 = "obj20/message_part.png"; //$NON-NLS-1$
	public final String ICON_PORTTYPE_16 = "obj16/wsdl_port_type.gif";  //$NON-NLS-1$
	public final String ICON_PORTTYPE_32 = "obj20/wsdl_port_type.png"; //$NON-NLS-1$
	public final String ICON_ROLE_16 = "obj16/role.gif"; //$NON-NLS-1$
	public final String ICON_ROLE_32 = "obj20/role.png"; //$NON-NLS-1$
	public final String ICON_PARTNERLINKTYPE_16 = "obj16/partner_linktype.gif"; //$NON-NLS-1$
	public final String ICON_PARTNERLINKTYPE_32 = "obj20/partner_linktype.png"; //$NON-NLS-1$
	public final String ICON_PROPERTY_16 = "obj16/property.gif"; //$NON-NLS-1$
	public final String ICON_PROPERTY_32 = "obj20/property.png"; //$NON-NLS-1$
	public final String ICON_SERVICE_16 = "obj16/wsdl_service.gif"; //$NON-NLS-1$
	public final String ICON_SERVICE_32 = "obj20/wsdl_service.png"; //$NON-NLS-1$
	public final String ICON_INPUT_16 = "obj16/input.gif"; //$NON-NLS-1$
	public final String ICON_INPUT_32 = "obj20/input.png"; //$NON-NLS-1$
	public final String ICON_OUTPUT_16 = "obj16/output.gif"; //$NON-NLS-1$
	public final String ICON_OUTPUT_32 = "obj20/output.png"; //$NON-NLS-1$
	public final String ICON_FAULT_16 = "obj16/fault.gif"; //$NON-NLS-1$
	public final String ICON_FAULT_32 = "obj20/fault.png"; //$NON-NLS-1$
	
	
	// Schema/types related icons
	public final String ICON_XSD_ATTRIBUTE_DECLARATION_16 = "obj16/XSDAttributeDeclaration.gif"; //$NON-NLS-1$
	public final String ICON_XSD_ELEMENT_DECLARATION_16 = "obj16/XSDElementDeclaration.gif"; //$NON-NLS-1$
	public final String ICON_XSD_COMPLEX_TYPE_DEFINITION_16 = "obj16/XSDComplexTypeDefinition.gif"; //$NON-NLS-1$
	public final String ICON_XSD_SIMPLE_TYPE_DEFINITION_16 = "obj16/XSDSimpleTypeDefinition.gif"; //$NON-NLS-1$
	public final String ICON_XSD_TYPE_DEFINITION_16 = "obj16/XSDTypeDefinition.gif"; //$NON-NLS-1$

	public final String ICON_EXCEPTION_16 = "obj16/exception.gif";
	
	// WSIL related icons
	
	public final String ICON_WSIL = "obj16/wsil.gif"; //$NON-NLS-1$
	public final String ICON_WSIL_SERVICE = "obj16/service.gif"; //$NON-NLS-1$
	public final String ICON_WSIL_LINK = "obj16/wsil_link.gif"; //$NON-NLS-1$
	
	// Link images
	public final String ICON_LINK_BOTTOMLEFT = "ovr16/link_bottomleft.png"; //$NON-NLS-1$
	public final String ICON_LINK_BOTTOMRIGHT = "ovr16/link_bottomright.png"; //$NON-NLS-1$
	public final String ICON_LINK_TOPLEFT = "ovr16/link_topleft.png"; //$NON-NLS-1$
	public final String ICON_LINK_TOPRIGHT = "ovr16/link_topright.png"; //$NON-NLS-1$
	public final String ICON_LINK_ARROWDOWN = "ovr16/link_arrowdown.png"; //$NON-NLS-1$
	public final String ICON_LINK_ARROWRIGHT = "ovr16/link_arrowright.png"; //$NON-NLS-1$
	public final String ICON_LINK_CONDITIONAL = "obj16/condlnk_dgm16.gif"; //$NON-NLS-1$
	
	// Expressions
	public final String ICON_EXPR_FUNCTION = "obj16/function.gif";
	
	// Cursors
	public final String CURSOR_ZOOM_MASK = "point/zoom_mask.bmp"; //$NON-NLS-1$
	public final String CURSOR_ZOOM_IN = "point/zoomin_source.bmp"; //$NON-NLS-1$
	public final String CURSOR_ZOOM_OUT = "point/zoomout_source.bmp"; //$NON-NLS-1$
	
	public final String CMD_ADD_LINK = Messages.IBPELUIConstants_Add_Link_5; 
	public final String CMD_ADD_CORRELATION = Messages.IBPELUIConstants_Add_Correlation_6; 
	public final String CMD_ADD_PARTNERLINK = Messages.IBPELUIConstants_Add_Partner_7; 
	public final String CMD_ADD_VARIABLE = Messages.IBPELUIConstants_Add_Variable_8; 
	public final String CMD_ADD_MESSAGEEXCHANGE = Messages.IBPELUIConstants_Add_MessageExchange; 
	public final String CMD_ADD_PROPERTY = Messages.IBPELUIConstants_Add_Property_9; 
	public final String CMD_ADD_PROPERTY_ALIAS = Messages.IBPELUIConstants_Add_Property_Alias_10; 
	public final String CMD_ADD_FAULTHANDLER = Messages.IBPELUIConstants_Add_Fault_Handler_11; 
	public final String CMD_ADD_COMPENSATIONHANDLER = Messages.IBPELUIConstants_Add_Compensation_Handler_11; 
	public final String CMD_ADD_TERMINATIONHANDLER = Messages.IBPELUIConstants_Add_Termination_Handler_11;
	public final String CMD_ADD_EVENTHANDLER = Messages.IBPELUIConstants_Add_Event_Handler_11; 
	public final String CMD_ADD_ROLE = Messages.IBPELUIConstants_Add_Role_12; 
	public final String CMD_ADD_CUSTOM_SETTING = Messages.IBPELUIConstants_Add_Custom_Setting_13; 
	public final String CMD_ADD_CUSTOM_PROPERTY = Messages.IBPELUIConstants_Add_Custom_Property_14; 
	public final String CMD_ADD_COPY = Messages.IBPELUIConstants_Add_Copy_12b; 
	public final String CMD_ADD_VALIDATE_VARIABLE = Messages.IBPELUIConstants_Add_VALIDATE_VARIABLE_15;
	public final String CMD_ADD_IMPORT = Messages.IBPELUIConstants_Add_Import;
	
	public final String CMD_INSERT_COPY = Messages.IBPELUIConstants_Insert_Copy;
	public final String CMD_SWAP_COPY = Messages.IBPELUIConstants_Swap_Copy;
	public final String CMD_DELETE_LINK = Messages.IBPELUIConstants_Delete_Link_17; 
	public final String CMD_DELETE_CORRELATION = Messages.IBPELUIConstants_Delete_Correlation_18;
	public final String CMD_DELETE_VALIDATE_VARIABLE = Messages.IBPELUIConstants_Delete_Validate_Variable_26;
	public final String CMD_DELETE_PROPERTY = Messages.IBPELUIConstants_Delete_Property_19; 
	public final String CMD_DELETE_PROPERTY_ALIAS = Messages.IBPELUIConstants_Delete_Property_Alias_20; 
	public final String CMD_REMOVE_CLIENT_SETTINGS = Messages.IBPELUIConstants_Remove_Client_Settings_21; 
	public final String CMD_REMOVE_CUSTOM_SETTINGS = Messages.IBPELUIConstants_Remove_Custom_Settings_22; 
	public final String CMD_REMOVE_PROPERTY = Messages.IBPELUIConstants_Remove_Property_23; 
	public final String CMD_DELETE_ROLE = Messages.IBPELUIConstants_Delete_Role_24; 
	public final String CMD_REMOVE_CUSTOM_PROPERTY = Messages.IBPELUIConstants_Remove_Custom_Property_25; 
	public final String CMD_DELETE_COPY = Messages.IBPELUIConstants_Delete_Copy_24b;
	public final String CMD_REMOVE_IMPORT = Messages.IBPELUIConstants_Remove_Import;
	
	public final String CMD_REPOSITION_NODE = Messages.IBPELUIConstants_Reposition_26; 
	public final String CMD_RESIZE_NODE = Messages.IBPELUIConstants_Resize_27; 
	public final String CMD_CHANGE_BPEL_FILE_NAME = Messages.IBPELUIConstants_Change_BPEL_File_30; 
	public final String CMD_AUTO_ARRANGE = Messages.IBPELUIConstants_Auto_Arrange_33; 

	// Strings used by a Command or IOngoingChange.
	// TODO: try out different prefixes/suffixes: edit, change, select, etc.
	// try and find something consistent and readable.
	public final String FORMAT_CMD_EDIT = Messages.IBPELUIConstants_Change_4; 
	public final String FORMAT_CMD_SELECT = Messages.IBPELUIConstants_Change_5; 

	public final String CMD_SELECT_ACTIVITY = Messages.IBPELUIConstants_Activity_Change_36; 
	public final String CMD_SELECT_COMPENSATE = Messages.IBPELUIConstants_Compensate_Change_40; 
	public final String CMD_SELECT_MESSAGETYPE = Messages.IBPELUIConstants_Message_Type_Change_37; 
	public final String CMD_SELECT_VARIABLE = Messages.IBPELUIConstants_Variable_Change_38; 
	public final String CMD_SELECT_ISOLATED = Messages.IBPELUIConstants_Scope_Serialization_Change_38; 
	public final String CMD_SELECT_COMPENSABLE = Messages.IBPELUIConstants_Scope_Compensable_Change_38; 
	public final String CMD_SELECT_OPERATION = Messages.IBPELUIConstants_Operation_Change_39; 
	public final String CMD_SELECT_PORTTYPE = Messages.IBPELUIConstants_Port_Type_Change_41; 
	public final String CMD_SELECT_MYROLE = Messages.IBPELUIConstants_My_Role_Change_42; 
	public final String CMD_SELECT_PARTNERLINK = Messages.IBPELUIConstants_Partner_Link_Change_43; 
	public final String CMD_SELECT_PARTNERROLE = Messages.IBPELUIConstants_Partner_Role_Change_44; 
	public final String CMD_SELECT_INTERFACE = Messages.IBPELUIConstants_Interface_Change_45; 
	public final String CMD_SELECT_METHOD = Messages.IBPELUIConstants_Method_Change_46; 
	public final String CMD_SELECT_VARIABLE_TYPE = Messages.IBPELUIConstants_Variable_Type_Change_1; 
	public final String CMD_SELECT_STANDARD_FAULT = Messages.IBPELUIConstants_Exit_On_Standard_Fault_1;
	public final String CMD_SELECT_JOINFAILURE = Messages.IBPELUIConstants_Join_Failure_Change_50; 
	public final String CMD_SELECT_CREATEINSTANCE = Messages.IBPELUIConstants_Create_Instance_Change_51; 
	public final String CMD_VALIDATE_XML = Messages.IBPELUIConstants_Assign_Validate_XML_52;
	public final String CMD_SELECT_SPECCOMPLIANT = Messages.IBPELUIConstants_Spec_Compliance_Change_2; 
	public final String CMD_SELECT_MESSAGE_EXCHANGE=Messages.IBPELUIConstants_Message_Exchange_Change;

	public final String CMD_SELECT_TARGETNAMESPACE = Messages.IBPELUIConstants_Target_namespace_Change_61; 

	public final String CMD_EDIT_EXPRESSION = Messages.IBPELUIConstants_Expression_Change_63; 
	public final String CMD_EDIT_EXPRESSION_BODY = Messages.IBPELUIConstants_Expression_Body_Change_63; 
	public final String CMD_EDIT_ASSIGNCOPY = Messages.IBPELUIConstants_Assign_Copy_Change_64; 
	public final String CMD_EDIT_CORRELATION = Messages.IBPELUIConstants_Correlation_Change_65; 
	public final String CMD_EDIT_NAME = Messages.IBPELUIConstants_Name_Change_66; 
	public final String CMD_EDIT_EXPRESSIONLANGUAGE = Messages.IBPELUIConstants_Expression_Language_Change_67; 
	public final String CMD_EDIT_QUERYLANGUAGE = Messages.IBPELUIConstants_Query_Language_Change_67; 
	public final String CMD_EDIT_PROCESSTYPE = Messages.IBPELUIConstants_Process_Type_Change_67; 
	public final String CMD_EDIT_FAULTNAME = Messages.IBPELUIConstants_Fault_Name_Change_68; 
	public final String CMD_EDIT_FAULTNAMESPACE = Messages.IBPELUIConstants_Fault_Namespace_Change_69; 
	public final String CMD_EDIT_FAULT_VARIABLE_NAME = Messages.IBPELUIConstants_Fault_Variable_Name_Change_70; 
	public final String CMD_EDIT_PROPERTY = Messages.IBPELUIConstants_Property_Change_71; 
	public final String CMD_EDIT_VARIABLE_TYPE = Messages.IBPELUIConstants_Variable_Type_Change_73; 
	public final String CMD_EDIT_DISPLAYNAME = Messages.IBPELUIConstants_Name_Change_80; 

	public final String CMD_EDIT_PARTNERLINK = Messages.IBPELUIConstants_Partner_Change_79; 

	public final String CMD_SET_PARALLEL_EXECUTION = Messages.IBELUIConstants_SET_PARALLEL_EXECUTION;
	public final String CMD_SET_COUNTER_VARIABLE_NAME = Messages.IBELUIConstants_COUNTER_VARIABLE_NAME_CHANGE;
	public final String CMD_SET_SUCCESSFUL_BRANCHES_ONLY = Messages.IBELUIConstants_SET_SUCCESSFUL_BRANCHES_ONLY;
	
	// error messages
	public final int MISSING_ATTRIBUTE = 0;

	// Preferences
	public final String PREF_SHOW_FREEFORM_FLOW = "pref_show_freeform_flow"; //$NON-NLS-1$
	public final String PREF_AUTO_FLOW_LAYOUT = "pref_auto_flow_layout"; //$NON-NLS-1$
	public final String PREF_WARN_LINKS = "pref_warn_links"; //$NON-NLS-1$
	
	// Marker attributes
	public final String MARKER_TYPE_EXPRESSION = "org.eclipse.bpel.ui.uiExpressionProblemMarker"; //$NON-NLS-1$
	public final String MARKER_ATT_FROM = "org.eclipse.bpel.model.From"; //$NON-NLS-1$

	public final String MARKER_ANCHORPOINT_DRAWER_TOP = "DRAWER_TOP"; //$NON-NLS-1$
	public final String MARKER_ANCHORPOINT_DRAWER_BOTTOM = "DRAWER_BOTTOM"; //$NON-NLS-1$
	
	public final String USE_TYPE_CODE = "code"; //$NON-NLS-1$
	public final String USE_TYPE_CONDITION = "condition"; //$NON-NLS-1$
	public final String USE_TYPE_TRANSITION_CONDITION = "transitionCondition"; //$NON-NLS-1$
	public final String USE_TYPE_JOIN_CONDITION = "joinCondition"; //$NON-NLS-1$
	public final String USE_TYPE_DURATION_CONDITION = "durationCondition"; //$NON-NLS-1$
	public final String USE_TYPE_DEADLINE_CONDITION = "deadlineCondition"; //$NON-NLS-1$
	public final String USE_TYPE_ASSIGN_EXPRESSION = "assignExpression"; //$NON-NLS-1$
	public final String USE_TYPE_UNKNOWN = "unknown"; //$NON-NLS-1$
	
	public final String MARKER_OVERLAYIMAGETOPLEFT = "overlayImageTopLeft"; //$NON-NLS-1$
	public final String MARKER_OVERLAYIMAGETOPRIGHT = "overlayImageTopRight"; //$NON-NLS-1$
	public final String MARKER_OVERLAYIMAGEBOTTOMLEFT = "overlayImageBottomLeft"; //$NON-NLS-1$
	public final String MARKER_OVERLAYIMAGEBOTTOMRIGHT = "overlayImageBottomRight"; //$NON-NLS-1$

	// Arc width constant
	public final int ARC_WIDTH = 7;

	// Color constants

	// The grey used for the round rectangle surrounding the image and
	// activity name on the canvas
	public final String COLOR_ACTIVITY_BORDER = "activityBorder"; //$NON-NLS-1$
	// The grey used for the round rectangle surround the contents of a composite
	// activity such as a sequence or switch
	public final String COLOR_COMPOSITE_ACTIVITY_BORDER = "compositeActivityBorder"; //$NON-NLS-1$
	// The grey used for the round rectangle surround the contents of a scope
	public final String COLOR_SCOPE_BORDER = "scopeActivityBorder"; //$NON-NLS-1$
	// The blue used as the top and bottom bars for flows
	public final String COLOR_FLOW_BORDER = "flowBorder"; //$NON-NLS-1$
	// The beginning of the grey gradient
	public final String COLOR_GRADIENT_FROM = "gradientFrom"; //$NON-NLS-1$
	// The end of the grey gradient
	public final String COLOR_GRADIENT_TO = "gradientTo"; //$NON-NLS-1$
	// The color of the implicit link
	public final String COLOR_IMPLICIT_LINK = "implicitLink"; //$NON-NLS-1$
	// The color of the implicit link
	public final String COLOR_HILIGHT_NODE = "hilightNode"; //$NON-NLS-1$
	// The background color of the variables area
	public final String COLOR_VARIABLE_BACKGROUND = "variableBackground"; //$NON-NLS-1$
	// The outline color the lines between each variable
	public final String COLOR_VARIABLE_SEPARATOR = "variableSeparator"; //$NON-NLS-1$
	// The color of the variable reference rectangle
	public final String COLOR_VARIABLE_REFERENCE = "variableReference"; //$NON-NLS-1$
	// The color of the selection handle
	public final String COLOR_SELECTION_HANDLE = "selectionHandler"; //$NON-NLS-1$
	
	public final String COLOR_WHITE = "COLOR_WHITE";  //$NON-NLS-1$
	public final String COLOR_BLACK = "COLOR_BLACK"; //$NON-NLS-1$
	public final String COLOR_RED = "COLOR_RED"; //$NON-NLS-1$
	public final String COLOR_DARK_RED = "COLOR_DARK_RED"; //$NON-NLS-1$
	public final String COLOR_GREEN = "COLOR_GREEN"; //$NON-NLS-1$
	public final String COLOR_DARK_GREEN = "COLOR_DARK_GREEN"; //$NON-NLS-1$
	public final String COLOR_YELLOW = "COLOR_YELLOW"; //$NON-NLS-1$
	public final String COLOR_DARK_YELLOW = "COLOR_DARK_YELLOW"; //$NON-NLS-1$
	public final String COLOR_BLUE = "COLOR_BLUE"; //$NON-NLS-1$
	public final String COLOR_DARK_BLUE = "COLOR_DARK_BLUE"; //$NON-NLS-1$
	public final String COLOR_MAGENTA = "COLOR_MAGENTA"; //$NON-NLS-1$
	public final String COLOR_DARK_MAGENTA = "COLOR_DARK_MAGENTA"; //$NON-NLS-1$
	public final String COLOR_CYAN = "COLOR_CYAN"; //$NON-NLS-1$
	public final String COLOR_DARK_CYAN = "COLOR_DARK_CYAN"; //$NON-NLS-1$
	public final String COLOR_GRAY = "COLOR_GRAY"; //$NON-NLS-1$
	public final String COLOR_DARK_GRAY = "COLOR_DARK_GRAY"; //$NON-NLS-1$
	
	// The colors of the flow links
	public final String COLOR_LINK_ONE = "linkOne"; //$NON-NLS-1$
	public final String COLOR_LINK_TWO = "linkTwo"; //$NON-NLS-1$
	public final String COLOR_LINK_THREE = "linkThree"; //$NON-NLS-1$
	
	// The colors of the handlerlinks
	public final String COLOR_HANDLER_LINK_FH = "handlerLinkOne"; //$NON-NLS-1$
	public final String COLOR_HANDLER_LINK_CH = "handlerLinkTwo"; //$NON-NLS-1$
	public final String COLOR_HANDLER_LINK_EH = "handlerLinkThree"; //$NON-NLS-1$
	public final String COLOR_HANDLER_LINK_TH = "handlerLinkFour"; //$NON-NLS-1$
	
	
	/**
     * Common prefix for properties defined in this interface.
     */
	public static final String PROPERTY_PREFIX = BPEL_EDITOR_ID; //$NON-NLS-1$
	
    // Layout orientation
	public static final QualifiedName HORIZONTAL_LAYOUT_PROPERTY = new QualifiedName(
            PROPERTY_PREFIX, "horizontalLayout"); //$NON-NLS-1$
	
	
	
	
	// some general constants
	public static final String LINE_SEPARATOR = System.getProperty("line.separator", "\n"); //$NON-NLS-1$ //$NON-NLS-2$

	// TODO: perhaps we could externalize these, but what are the character restrictions?
	public static final String ROLE_NAME_MYROLE = "myRole"; //$NON-NLS-1$
	public static final String ROLE_NAME_PARTNERROLE = "partnerRole"; //$NON-NLS-1$
}