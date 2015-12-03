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
package org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.mediatorlocator.impl;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.APIResource;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbElement;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbLink;
import org.wso2.developerstudio.eclipse.gmf.esb.Mediator;
import org.wso2.developerstudio.eclipse.gmf.esb.OutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.debugpoint.builder.impl.AbstractESBDebugPointBuilder;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.exception.MediatorNotFoundException;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.mediatorlocator.IMediatorLocator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerUtil;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.ProxyServiceImpl;

/**
 * This class should be implemented by all Mediator locator class
 * implementations.
 * <P>
 * Common methods needed by mediator locators are implemented in this class and
 * it implements {@link IMediatorLocator} interface
 *
 */
public abstract class AbstractMediatorLocator implements IMediatorLocator {

	protected static final String MEDIATOR_POSITION_SEPERATOR = " ";
	protected static final int INDEX_OF_FIRST_ELEMENT = 0;
	private static final String EMPTY_STRING = "";

	protected EditPart getMediatorFromMediationFlow(
			OutputConnector tempConnector, List<Integer> mediatorPosition)
			throws MediatorNotFoundException {
		int count = 0;
		while (tempConnector != null) {
			EsbLink outgoingLink = tempConnector.getOutgoingLink();
			if (outgoingLink != null && outgoingLink.getTarget() != null) {
				EObject mediator = outgoingLink.getTarget().eContainer();
				if (count == mediatorPosition.get(INDEX_OF_FIRST_ELEMENT)) {
					return ESBDebuggerUtil.getActiveEditorEditpart(mediator);
				} else {
					count++;
					if (mediator instanceof Mediator) {
						tempConnector = AbstractESBDebugPointBuilder
								.getOutputConnector((Mediator) mediator);
					}
				}
			} else {
				throw new MediatorNotFoundException(
						"Mediation flow diagram error");
			}
		}
		throw new IllegalArgumentException(
				"tempConnector argument can not be null");
	}

	protected EditPart getMediatorInFaultSeq(EList<EsbElement> children,
			List<Integer> positionList) throws MediatorNotFoundException {
		int count = 0;
		int position = positionList.get(INDEX_OF_FIRST_ELEMENT);
		for (EsbElement mediator : children) {
			if (count == position) {
				return ESBDebuggerUtil.getActiveEditorEditpart(mediator);
			} else {
				count++;
			}
		}
		throw new MediatorNotFoundException(
				"Breakpoint position value is invalid : "
						+ "position expected - " + position
						+ " , Last Index in flow : " + (count - 1));
	}

	protected String getFaultSequenceName(EObject element) {
		String faultSeqName = null;
		if (element instanceof ProxyServiceImpl) {
			faultSeqName = ((ProxyServiceImpl) element).getFaultSequenceName();
		} else if (element instanceof APIResource) {
			faultSeqName = ((APIResource) element).getFaultSequenceName();
		}
		if (faultSeqName != null) {
			return faultSeqName;
		} else {
			return EMPTY_STRING;
		}
	}

}