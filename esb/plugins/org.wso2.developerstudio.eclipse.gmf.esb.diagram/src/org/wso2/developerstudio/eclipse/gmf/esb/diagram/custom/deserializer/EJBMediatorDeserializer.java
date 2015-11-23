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

package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.deserializer;

import java.util.Map;

import org.apache.synapse.mediators.MediatorProperty;
import org.apache.synapse.mediators.Value;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.EJBMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.LogProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.MethodArgument;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.PropertyValueType;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.custom.EJBMediatorExt;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.*;

public class EJBMediatorDeserializer extends
		AbstractEsbNodeDeserializer<EJBMediatorExt, EJBMediator> {

	@Override
	public EJBMediator createNode(IGraphicalEditPart part, EJBMediatorExt mediator) {
		EJBMediator mediatorModel = (EJBMediator) DeserializerUtils.createNode(part,
				EsbElementTypes.EJBMediator_3686);
		setElementToEdit(mediatorModel);
		setCommonProperties(mediator, mediatorModel);

		executeSetValueCommand(EJB_MEDIATOR__BEANSTALK, mediator.getBeanstalkName());
		executeSetValueCommand(EJB_MEDIATOR__CLASS, mediator.getClassName());
		executeSetValueCommand(EJB_MEDIATOR__JNDI_NAME, mediator.getJndiName());
		executeSetValueCommand(EJB_MEDIATOR__METHOD, mediator.getMethodName());
		executeSetValueCommand(EJB_MEDIATOR__REMOVE, mediator.isRemove());
		executeSetValueCommand(EJB_MEDIATOR__TARGET, mediator.getTargetValue());

		Value beanId = mediator.getBeanId();
		if (beanId != null) {
			if (beanId.getExpression() != null) {
				executeSetValueCommand(EJB_MEDIATOR__SESSION_ID_TYPE, PropertyValueType.EXPRESSION);
				executeSetValueCommand(EJB_MEDIATOR__SESSION_ID_EXPRESSION,
						createNamespacedProperty(beanId.getExpression()));
			} else {
				executeSetValueCommand(EJB_MEDIATOR__SESSION_ID_TYPE, PropertyValueType.LITERAL);
				executeSetValueCommand(EJB_MEDIATOR__SESSION_ID_LITERAL, beanId.getKeyValue());
			}
		}

		// Method Arguments
		EList<MethodArgument> methodArgumentList = new BasicEList<MethodArgument>();

		for (Value methodArgument : mediator.getArgumentList()) {

			MethodArgument argument = EsbFactory.eINSTANCE.createMethodArgument();

			if (methodArgument.getKeyValue() != null) {
				argument.setPropertyValueType(PropertyValueType.LITERAL);
				argument.setPropertyValue(methodArgument.getKeyValue());

			} else if (methodArgument.getExpression() != null) {
				argument.setPropertyValueType(PropertyValueType.EXPRESSION);
				NamespacedProperty namespaceProperty = EsbFactory.eINSTANCE
						.createNamespacedProperty();
				namespaceProperty.setPropertyValue(methodArgument.getExpression().toString());
				Map namespaces = methodArgument.getExpression().getNamespaces();
				Object[] namespacesKeys = namespaces.keySet().toArray();
				for (int i = 0; i < namespacesKeys.length; ++i) {
					namespaceProperty.getNamespaces().put((String) namespacesKeys[i],
							(String) namespaces.get(namespacesKeys[i]));
				}
				argument.setPropertyExpression(namespaceProperty);

			}

			methodArgumentList.add(argument);
		}
		executeSetValueCommand(EJB_MEDIATOR__METHOD_ARGUMENTS, methodArgumentList);

		return mediatorModel;
	}

}
