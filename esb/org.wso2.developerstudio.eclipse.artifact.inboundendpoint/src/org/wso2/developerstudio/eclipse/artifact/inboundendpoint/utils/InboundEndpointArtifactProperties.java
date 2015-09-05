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

package org.wso2.developerstudio.eclipse.artifact.inboundendpoint.utils;

import org.eclipse.osgi.util.NLS;

public final class InboundEndpointArtifactProperties extends NLS {
	public static final String BUNDLE_NAME = "org.wso2.developerstudio.eclipse.artifact.inboundendpoint.utils.inboundendpointartifactconstants";
	public static String ieWizardWindowTitle;
	public static String esbProjectNature;
	public static String typeHTTP;
	public static String typeFile;
	public static String typeJMS;
	public static String typeCustom;
	public static String typeHTTPS;
	public static String typeHL7;
	public static String typeKAFKA;
	public static String typeCXF_WS_RM;
	public static String typeMQTT;
	public static String typeRabbitMq;	
	public static String typeFeed;

	// project wizard page properties
	public static String wizardOptionNewIE;
	public static String wizardOptionIEType;
	public static String wizardOptionSaveLocation;
	public static String wizardOptionImportOption;
	public static String wizardOptionImportFilePath;
	public static String wizardOptionCreateESBProject;
	public static String wizardOptionIEName;
	public static String wizardOptionAvailableIEs;
	public static String wizardOptionImportSourceUrlIEUrl;
	public static String wizardOptionSequence;
	public static String wizardOptionErrorSequence;
	public static String wizardOptionInboundHTTPPort;
	public static String wizardOptionInterval;
	public static String wizardOptionSequential;
	public static String wizardOptionCoordination;
	public static String wizardOptionVFSFileURI;
	public static String wizardOptionVFSContentType;
	public static String wizardOptionVFSFileNamePattern;
	public static String wizardOptionVFSFileProcessInterval;
	public static String wizardOptionVFSFileProcessCount;
	public static String wizardOptionVFSLocking;
	public static String wizardOptionVFSMaxRetryCount;
	public static String wizardOptionVFSReconnectTimeout;
	public static String wizardOptionVFSActionAfterProcess;
	public static String wizardOptionVFSMoveAfterProcess;
	public static String wizardOptionVFSActionAfterErrors;
	public static String wizardOptionVFSMoveAfterErrors;
	public static String wizardOptionVFSActionAfterFailure;
	public static String wizardOptionVFSMoveAfterFailure;
	public static String wizardOptionVFSAutoLockRelease;
	public static String wizardOptionVFSAutoLockReleaseInterval;
	public static String wizardOptionVFSLockReleaseSameNode;
	public static String wizardOptionVFSDistributedLock;
	public static String wizardOptionVFSDistributedTimeout;
	public static String wizardOptionClass;
	public static String wizardOptionProtocol;
	public static String wizardOptionSuspend;
	public static String wizardOptionAvailableInboundEndpoints;
	
	public static String errorNameExists;
	public static String validationReadingFile;
	public static String errorProjectPath;
	public static String errorClass;
	public static String msgOverrideProject;
	public static String errorCoreException;
	public static String errorUnexpectedError;
	public static String errorIOException;
	public static String errorOpenEditor;

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, InboundEndpointArtifactProperties.class);
	}

	private InboundEndpointArtifactProperties() {

	}
}
