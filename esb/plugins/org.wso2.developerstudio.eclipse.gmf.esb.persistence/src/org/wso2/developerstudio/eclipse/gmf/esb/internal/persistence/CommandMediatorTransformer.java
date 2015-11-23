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

import java.util.List;

import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.apache.synapse.mediators.ext.POJOCommandMediator;
import org.apache.synapse.util.xpath.SynapseXPath;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.jaxen.JaxenException;
import org.wso2.developerstudio.eclipse.gmf.esb.CommandMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.CommandProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.CommandPropertyContextAction;
import org.wso2.developerstudio.eclipse.gmf.esb.CommandPropertyMessageAction;
import org.wso2.developerstudio.eclipse.gmf.esb.CommandPropertyValueType;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.custom.DummyPOJOClass;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.custom.POJOCommandMediatorExt;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformationInfo;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformerException;

public class CommandMediatorTransformer extends AbstractEsbNodeTransformer{
	
	public void transform(TransformationInfo information, EsbNode subject)
			throws TransformerException {
		try {
			information.getParentSequence().addChild(createCommandMediator(information,subject));
			// Transform the Command mediator output data flow path.
			doTransform(information,
					((CommandMediator) subject).getOutputConnector());	
		} catch (JaxenException e) {
			throw new TransformerException(e);
		}		
	}

	public void createSynapseObject(TransformationInfo info, EObject subject,
			List<Endpoint> endPoints) {
		
	}

	public void transformWithinSequence(TransformationInfo information,
			EsbNode subject, SequenceMediator sequence) throws TransformerException {
		try {
			sequence.addChild( createCommandMediator(information,subject));
			doTransformWithinSequence(information,((CommandMediator) subject).getOutputConnector().getOutgoingLink(),sequence);	
		} catch (JaxenException e) {
			throw new TransformerException(e);
		}
	}

	private POJOCommandMediator createCommandMediator(TransformationInfo information,EsbNode subject) throws JaxenException{
		// Check subject.
		Assert.isTrue(subject instanceof CommandMediator, "Invalid subject.");
		CommandMediator visualCommand = (CommandMediator) subject;
		String className = visualCommand.getClassName();
		POJOCommandMediatorExt commandMediator =new POJOCommandMediatorExt(className);
		setCommonProperties(commandMediator, visualCommand);
		Class clazz= DummyPOJOClass.class;
		
		for (CommandProperty property : visualCommand.getProperties()) {
			if (property.getValueType().equals(CommandPropertyValueType.MESSAGE_ELEMENT)) {
				SynapseXPath expression = new SynapseXPath(property.getValueMessageElementXpath().getPropertyValue());
				CommandPropertyMessageAction messageAction = property.getMessageAction();
				if (messageAction.equals(CommandPropertyMessageAction.READ_AND_UPDATE_MESSAGE)) {
					commandMediator.addMessageSetterProperty(property.getPropertyName(), expression);
					commandMediator.addMessageGetterProperty(property.getPropertyName(), expression);
				} else if (messageAction.equals(CommandPropertyMessageAction.UPDATE_MESSAGE)) {
					commandMediator.addMessageGetterProperty(property.getPropertyName(), expression);
				} else {
					commandMediator.addMessageSetterProperty(property.getPropertyName(), expression);
				}
			} else if (property.getValueType().equals(CommandPropertyValueType.CONTEXT_PROPERTY)) {
				String contextProperty = property.getValueContextPropertyName();
				CommandPropertyContextAction contextAction = property.getContextAction();
				if (contextAction.equals(CommandPropertyContextAction.READ_AND_UPDATE_CONTEXT)) {
					commandMediator.addContextSetterProperty(property.getPropertyName(),contextProperty);
					commandMediator.addContextGetterProperty(property.getPropertyName(),contextProperty);
				} else if (contextAction.equals(CommandPropertyContextAction.UPDATE_CONTEXT)) {
					commandMediator.addContextGetterProperty(property.getPropertyName(),contextProperty);
				} else {
					commandMediator.addContextSetterProperty(property.getPropertyName(),contextProperty);
				}
			} else {
				commandMediator.addStaticSetterProperty(property.getPropertyName(),
						property.getValueLiteral());
			}
		}
		
		commandMediator.setCommand(clazz);
		return commandMediator;
	}


}
