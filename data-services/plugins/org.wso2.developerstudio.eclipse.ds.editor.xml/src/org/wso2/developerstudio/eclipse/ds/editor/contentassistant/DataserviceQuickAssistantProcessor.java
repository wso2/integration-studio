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

package org.wso2.developerstudio.eclipse.ds.editor.contentassistant;

import java.util.Iterator;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.quickassist.IQuickAssistInvocationContext;
import org.eclipse.jface.text.quickassist.IQuickAssistProcessor;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Display;
import org.eclipse.text.edits.InsertEdit;
import org.eclipse.ui.IEditorPart;
import org.eclipse.wst.sse.core.internal.provisional.text.IStructuredDocumentRegion;
import org.eclipse.wst.sse.ui.internal.contentassist.ContentAssistUtils;
import org.eclipse.wst.xml.core.internal.provisional.document.IDOMNode;
import org.wso2.developerstudio.eclipse.ds.Activator;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

public class DataserviceQuickAssistantProcessor implements IQuickAssistProcessor {

	public static final String PROJECT_NODE = "data";
	public static final String XSI_VALUE =
	                                       " xmlns=\"http://www.wso2.com/DataService/2010/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n"
	                                               + "xsi:noNamespaceSchemaLocation=\"http://www.wso2.com/DataService/2010/XMLSchema\"";
	public static final String NO_SCHEMA_ERR =
	                                           "There is no schema defined for this pom.xml. Code completion will not work without a schema defined.";

	public boolean canAssist(IQuickAssistInvocationContext arg0) {
		return true;
	}

	public boolean canFix(Annotation arg0) {
		return false;
	}

	public ICompletionProposal[] computeQuickAssistProposals(IQuickAssistInvocationContext context) {
		Iterator<Annotation> annotationIterator =
		                                          context.getSourceViewer().getAnnotationModel()
		                                                 .getAnnotationIterator();
		while (annotationIterator.hasNext()) {
			Annotation annotation = annotationIterator.next();
			if (NO_SCHEMA_ERR.equals(annotation.getText())) {
				IDOMNode node =
				                (IDOMNode) ContentAssistUtils.getNodeAt(context.getSourceViewer(),
				                                                        context.getOffset());
				if (node != null && PROJECT_NODE.equals(node.getNodeName())) {
					return new ICompletionProposal[] { new SchemaCompletionProposal(context) };
				}
			}
		}
		return null;
	}

	public String getErrorMessage() {
		return null;
	}
}

class SchemaCompletionProposal implements ICompletionProposal {
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	IQuickAssistInvocationContext context;

	public SchemaCompletionProposal(IQuickAssistInvocationContext context) {
		this.context = context;
	}

	public void apply(IDocument doc) {

		IStructuredDocumentRegion structuredDocumentRegion =
		                                                     ContentAssistUtils.getStructuredDocumentRegion(context.getSourceViewer(),
		                                                                                                    context.getOffset());
		int offset =
		             structuredDocumentRegion.getStartOffset() +
		                     DataserviceQuickAssistantProcessor.PROJECT_NODE.length() + 1;
		if (offset <= 0) {
			return;
		}
		InsertEdit edit = new InsertEdit(offset, DataserviceQuickAssistantProcessor.XSI_VALUE);
		try {
			edit.apply(doc);
			Display.getDefault().asyncExec(new Runnable() {
				public void run() {
					IEditorPart activeEditor =
					                           Activator.getDefault().getWorkbench()
					                                    .getActiveWorkbenchWindow().getActivePage()
					                                    .getActiveEditor();
					Activator.getDefault().getWorkbench().getActiveWorkbenchWindow()
					         .getActivePage().saveEditor(activeEditor, false);
				}
			});
		} catch (Exception e) {
			log.error(e);
		}
	}

	public String getAdditionalProposalInfo() {
		return null;
	}

	public IContextInformation getContextInformation() {
		return null;
	}

	public String getDisplayString() {
		return "Add maven schema definiton to pom.xml";
	}

	public Image getImage() {
		return null;
	}

	public Point getSelection(IDocument arg0) {
		return null;
	}

}
