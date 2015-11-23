/*
 * Copyright (c) 2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.ds.editor.configuration;

import org.eclipse.wst.xml.ui.StructuredTextViewerConfigurationXML;
import org.eclipse.wst.sse.ui.StructuredTextViewerConfiguration;
import org.eclipse.ui.editors.text.TextSourceViewerConfiguration;
import org.eclipse.jface.text.source.SourceViewerConfiguration;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.hyperlink.IHyperlinkDetector;
import org.eclipse.jface.text.quickassist.IQuickAssistAssistant;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.wst.sse.core.text.IStructuredPartitions;
import org.eclipse.wst.xml.core.text.IXMLPartitions;
import org.wso2.developerstudio.eclipse.ds.editor.contentassistant.DataServiceContentAssistantProcessor;
import org.wso2.developerstudio.eclipse.ds.editor.contentassistant.DataserviceQuickAssistantProcessor;

public class DataServiceStructuredTextViewerConfigurationXML extends
                                                            StructuredTextViewerConfigurationXML {
	public IContentAssistProcessor[] getContentAssistProcessors(ISourceViewer sourceViewer,
	                                                            String partitionType) {
		// if(partitionType == IStructuredPartitions.DEFAULT_PARTITION ||
		// partitionType == IXMLPartitions.XML_DEFAULT) {
		return new IContentAssistProcessor[] { new DataServiceContentAssistantProcessor(
		                                                                                sourceViewer) };
		// }
		// return super.getContentAssistProcessors(sourceViewer, partitionType);
	}

	//
	// public IHyperlinkDetector[] getHyperlinkDetectors(ISourceViewer
	// sourceViewer) {
	// IHyperlinkDetector[] detectors =
	// super.getHyperlinkDetectors(sourceViewer);
	// if(detectors==null) {
	// detectors = new IHyperlinkDetector[0];
	// }
	//
	// IHyperlinkDetector[] pomDetectors = new
	// IHyperlinkDetector[detectors.length + 1];
	// pomDetectors[0] = new PomHyperlinkDetector();
	// System.arraycopy(detectors, 0, pomDetectors, 1, detectors.length);
	//
	// return pomDetectors;
	// }

	public IQuickAssistAssistant getQuickAssistAssistant(ISourceViewer sourceViewer) {
		// TODO Auto-generated method stub
		IQuickAssistAssistant quickAssistAssistant = super.getQuickAssistAssistant(sourceViewer);
		quickAssistAssistant.setQuickAssistProcessor(new DataserviceQuickAssistantProcessor());
		return quickAssistAssistant;
	}

}
