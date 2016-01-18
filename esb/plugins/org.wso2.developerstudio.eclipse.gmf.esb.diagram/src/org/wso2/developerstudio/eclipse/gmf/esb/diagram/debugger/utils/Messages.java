/*
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
    private static final String BUNDLE_NAME = "org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.messages"; //$NON-NLS-1$
    public static String ClearPropertyDialog_CancelButtonText;
    public static String ClearPropertyDialog_MessageMediationPropertyClearShellTitle;
    public static String ClearPropertyDialog_OkButtonText;
    public static String ClearPropertyDialog_PropertContextLabel;
    public static String ClearPropertyDialog_PropertyKeyDefaultMessage;
    public static String ClearPropertyDialog_PropertyNameLabel;
    public static String DebuggerConfigTab_CommandPortLabel;
    public static String DebuggerConfigTab_EventPortLabel;
    public static String DebuggerConfigTab_IntegerPortValueValidationErrorMessage;
    public static String DebuggerConfigTab_MainMessage;
    public static String DebuggerConfigTab_MainTitle;
    public static String DebuggerConfigTab_ServerHostName;
    public static String ESBDebugerUtil_ErrorDialogTitle;
    public static String ESBDebugLaunchDelegate_DebuggerInterfaceSocketsCreationErrorDialogMessage;
    public static String ESBDebugLaunchDelegate_HostIPAddressCouldNotFoundErrorDialogMessage;
    public static String ESBDebugLaunchDelegate_LauncherArgumentInvalidErrorDialogMessage;
    public static String ESBDebugProcess_ESBDebugProcessNameTag;
    public static String ESBDebugTarget_ESBDebugTargetNameTag;
    public static String ESBDebugThread_ESBDebugThreadTag;
    public static String ESBStackFrame_Axis2ClientScopePropertyTag;
    public static String ESBStackFrame_Axis2ScopePropertyTag;
    public static String ESBStackFrame_ESBDebuggerStackFrameTag;
    public static String ESBStackFrame_OperationScopePropertyTag;
    public static String ESBStackFrame_SynapseScopePropertyTag;
    public static String ESBStackFrame_TransportScopePropertyTag;
    public static String InjectPropertyDialog_CancelButtonLabel;
    public static String InjectPropertyDialog_OkButtonLabel;
    public static String InjectPropertyDialog_PropertNameLabel;
    public static String InjectPropertyDialog_PropertyContextLabel;
    public static String InjectPropertyDialog_PropertyInjectShellTitle;
    public static String InjectPropertyDialog_PropertyValueLabel;
    static {
        // initialize resource bundle
        NLS.initializeMessages(BUNDLE_NAME, Messages.class);
    }

    private Messages() {
    }
}
