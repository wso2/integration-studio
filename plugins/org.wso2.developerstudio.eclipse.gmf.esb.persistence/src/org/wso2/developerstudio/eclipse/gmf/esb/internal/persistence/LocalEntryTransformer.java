/*
 * Copyright 2012 WSO2, Inc. (http://wso2.com)
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

package org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence;

import java.net.URL;
import java.util.List;

import org.apache.axiom.om.util.AXIOMUtil;
import org.apache.synapse.config.Entry;
import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.eclipse.emf.ecore.EObject;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.developerstudio.eclipse.gmf.esb.LocalEntry;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformationInfo;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformerException;

/**
 * Synapse local-entry transformer class
 */
public class LocalEntryTransformer extends AbstractEsbNodeTransformer{

	public void transform(TransformationInfo information, EsbNode subject)
			throws TransformerException {
		// nothing to do
		
	}

	public void createSynapseObject(TransformationInfo info, EObject subject,
			List<Endpoint> endPoints) {
		// nothing to do
		
	}

	public void transformWithinSequence(TransformationInfo information,
			EsbNode subject, SequenceMediator sequence) throws TransformerException {
		// nothing to do
		
	}
	
	public Entry createEntry(LocalEntry visualLocalEntry) throws Exception{
		Entry localEntry = new Entry(visualLocalEntry.getEntryName());
		switch (visualLocalEntry.getLocalEntryType()) {
		case LITERAL: {
			localEntry.setValue(visualLocalEntry.getValueLiteral());
			localEntry.setType(Entry.INLINE_TEXT);
			break;
		}
		case XML: {
			localEntry.setValue(AXIOMUtil.stringToOM(visualLocalEntry.getValueXML()));
			localEntry.setType(Entry.INLINE_XML);
			break;
		}
		case URL: {
			localEntry.setType(Entry.URL_SRC);
			localEntry.setSrc(new URL(visualLocalEntry.getValueURL()));
			break;
		}
		}
		return localEntry;
	}

}
