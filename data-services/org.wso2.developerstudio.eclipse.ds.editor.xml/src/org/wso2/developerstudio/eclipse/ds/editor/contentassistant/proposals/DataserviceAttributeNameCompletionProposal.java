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

package org.wso2.developerstudio.eclipse.ds.editor.contentassistant.proposals;

import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IInformationControlCreator;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.ICompletionProposalExtension;
import org.eclipse.jface.text.contentassist.ICompletionProposalExtension2;
import org.eclipse.jface.text.contentassist.ICompletionProposalExtension3;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.wso2.developerstudio.eclipse.ds.model.DataserviceAttributeElement;

public class DataserviceAttributeNameCompletionProposal implements ICompletionProposal,
                                                       ICompletionProposalExtension,
                                                       ICompletionProposalExtension2,
                                                       ICompletionProposalExtension3 {
	private DataserviceAttributeElement element;
	private Point selectedRange;

	public DataserviceAttributeNameCompletionProposal(DataserviceAttributeElement element) {
		setElement(element);
	}

	public void setElement(DataserviceAttributeElement element) {
		this.element = element;
	}

	public DataserviceAttributeElement getElement() {
		return element;
	}

	public IInformationControlCreator getInformationControlCreator() {
		return null;
	}

	public int getPrefixCompletionStart(IDocument arg0, int arg1) {
		return 0;
	}

	public CharSequence getPrefixCompletionText(IDocument arg0, int arg1) {
		return null;
	}

	public void apply(ITextViewer viewer, char trigger, int stateMask, int offset) {
		String s = viewer.getDocument().get();
		selectedRange = viewer.getSelectedRange();
		String key = getElement().getAttributeName();
		String seperator = getElement().getAttributeNameValueSeparator();
		String valueStart = getElement().getAttributeValueStart();
		String valueStr = getElement().getAttributeValueString();
		String valueEnd = getElement().getAttributeValueEnd();
		if (trigger == '<') {
			key = getElement().getName() + ">";
		}
		viewer.getDocument().set(s.substring(0, offset) + key + seperator + valueStart + valueStr +
		                                 valueEnd + s.substring(offset));
		selectedRange.x =
		                  selectedRange.x + key.length() + seperator.length() +
		                          valueStart.length() + valueStr.length();
	}

	public void selected(ITextViewer arg0, boolean arg1) {

	}

	public void unselected(ITextViewer arg0) {

	}

	public boolean validate(IDocument arg0, int arg1, DocumentEvent arg2) {
		return false;
	}

	public void apply(IDocument arg0, char arg1, int arg2) {

	}

	public int getContextInformationPosition() {
		return 0;
	}

	public char[] getTriggerCharacters() {
		return new char[] { '<' };
	}

	public boolean isValidFor(IDocument arg0, int arg1) {
		return false;
	}

	public void apply(IDocument arg0) {
	}

	public String getAdditionalProposalInfo() {
		return null;
	}

	public IContextInformation getContextInformation() {
		return null;
	}

	public String getDisplayString() {
		return getElement().getName();
	}

	public Image getImage() {
		return null;
	}

	public Point getSelection(IDocument arg0) {
		return selectedRange;
	}

}
