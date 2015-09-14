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

import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.*;

import java.util.regex.Pattern;

import org.apache.synapse.config.xml.SynapsePath;
import org.apache.synapse.config.xml.XMLConfigConstants;
import org.apache.synapse.mediators.AbstractMediator;
import org.apache.synapse.util.xpath.SynapseXPath;
import org.eclipse.core.runtime.Assert;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.PropertyAction;
import org.wso2.developerstudio.eclipse.gmf.esb.PropertyDataType;
import org.wso2.developerstudio.eclipse.gmf.esb.PropertyMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.PropertyName;
import org.wso2.developerstudio.eclipse.gmf.esb.PropertyScope;
import org.wso2.developerstudio.eclipse.gmf.esb.PropertyValueType;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;

public class PropertyMediatorDeserializer extends
		AbstractEsbNodeDeserializer<AbstractMediator, PropertyMediator> {

	public PropertyMediator createNode(IGraphicalEditPart part,AbstractMediator mediator) {

		Assert.isTrue(
				mediator instanceof org.apache.synapse.mediators.builtin.PropertyMediator,"Unsupported mediator passed in for deserialization at "
						+ this.getClass());

		org.apache.synapse.mediators.builtin.PropertyMediator propertyMediator = (org.apache.synapse.mediators.builtin.PropertyMediator) mediator;

		org.wso2.developerstudio.eclipse.gmf.esb.PropertyMediator VisualPropertyMediator = (org.wso2.developerstudio.eclipse.gmf.esb.PropertyMediator) DeserializerUtils.createNode(part, EsbElementTypes.PropertyMediator_3492);
		setElementToEdit(VisualPropertyMediator);
		setCommonProperties(propertyMediator, VisualPropertyMediator);
		
		//PropertyMediator vishualProp = EsbFactory.eINSTANCE
				//.createPropertyMediator();

		if (propertyMediator.getName() != null) {

			//vishualProp.setPropertyName(propertyMediator.getName());
			PropertyName propertyName = PropertyName.get(propertyMediator.getName());
			if(propertyName != null){
				executeSetValueCommand(PROPERTY_MEDIATOR__PROPERTY_NAME, PropertyName.get(propertyMediator.getName()));
			}else{
				executeSetValueCommand(PROPERTY_MEDIATOR__PROPERTY_NAME, PropertyName.NEW_PROPERTY_NAME);
				executeSetValueCommand(PROPERTY_MEDIATOR__NEW_PROPERTY_NAME, propertyMediator.getName());
			}
		}
		
		String scope = propertyMediator.getScope();
		if (scope != null) {
			if (scope.equals(XMLConfigConstants.SCOPE_AXIS2)) {
				//vishualProp.setPropertyScope(PropertyScope.AXIS2);
				executeSetValueCommand(PROPERTY_MEDIATOR__PROPERTY_SCOPE, PropertyScope.AXIS2);
			} else if (scope.equals(XMLConfigConstants.SCOPE_CLIENT)) {
				//vishualProp.setPropertyScope(PropertyScope.AXIS2_CLIENT);
				executeSetValueCommand(PROPERTY_MEDIATOR__PROPERTY_SCOPE, PropertyScope.AXIS2_CLIENT);
			} else if (scope.equals(XMLConfigConstants.SCOPE_DEFAULT)) {
				//vishualProp.setPropertyScope(PropertyScope.SYNAPSE);
				executeSetValueCommand(PROPERTY_MEDIATOR__PROPERTY_SCOPE, PropertyScope.SYNAPSE);
			} else if (scope.equals(XMLConfigConstants.SCOPE_TRANSPORT)) {
				//vishualProp.setPropertyScope(PropertyScope.TRANSPORT);
				executeSetValueCommand(PROPERTY_MEDIATOR__PROPERTY_SCOPE, PropertyScope.TRANSPORT);
			} else if (scope.equals(XMLConfigConstants.SCOPE_OPERATION)) {
				executeSetValueCommand(PROPERTY_MEDIATOR__PROPERTY_SCOPE, PropertyScope.OPERATION);
			}
		}
		// For the remove action
		if (propertyMediator.getAction() == org.apache.synapse.mediators.builtin.PropertyMediator.ACTION_REMOVE) {

			//vishualProp.setPropertyAction(PropertyAction.REMOVE);
			executeSetValueCommand(PROPERTY_MEDIATOR__PROPERTY_ACTION, PropertyAction.REMOVE);
			//vishualProp.setValueExpression(null);
			executeSetValueCommand(PROPERTY_MEDIATOR__VALUE_EXPRESSION, null);
			//vishualProp.setValueLiteral(null);
			executeSetValueCommand(PROPERTY_MEDIATOR__VALUE, null);

		} else {
			// For the Set action
			//vishualProp.setPropertyAction(PropertyAction.SET);
			executeSetValueCommand(PROPERTY_MEDIATOR__PROPERTY_ACTION, PropertyAction.SET);
			
			// If it's an Expression
			if (propertyMediator.getExpression() != null) {
				SynapsePath xpath = propertyMediator.getExpression();
				NamespacedProperty namespaceProp = createNamespacedProperty(xpath);
				//vishualProp.setValueExpression(namespaceProp);
				executeSetValueCommand(PROPERTY_MEDIATOR__VALUE_TYPE, PropertyValueType.EXPRESSION);
				executeSetValueCommand(PROPERTY_MEDIATOR__VALUE_EXPRESSION, namespaceProp);

				// If it's an Value
			} else if (propertyMediator.getValue() != null) {

				//vishualProp.setValueLiteral(propertyMediator.getValue()
						//.toString());
				executeSetValueCommand(PROPERTY_MEDIATOR__VALUE, propertyMediator.getValue().toString());

			}
			// Setting common things for both.
			String type = propertyMediator.getType();

			if (type != null) {

				if (type.equals(XMLConfigConstants.DATA_TYPES.STRING.toString())) {

					//vishualProp.setPropertyDataType(PropertyDataType.STRING);
					executeSetValueCommand(PROPERTY_MEDIATOR__PROPERTY_DATA_TYPE, PropertyDataType.STRING);

				} else if (type.equals(XMLConfigConstants.DATA_TYPES.SHORT
						.toString())) {

					//vishualProp.setPropertyDataType(PropertyDataType.SHORT);
					executeSetValueCommand(PROPERTY_MEDIATOR__PROPERTY_DATA_TYPE, PropertyDataType.SHORT);

				}else if (type.equals(XMLConfigConstants.DATA_TYPES.OM
 						.toString())) {
 
 					//vishualProp.setPropertyDataType(PropertyDataType.OM);
 					executeSetValueCommand(PROPERTY_MEDIATOR__PROPERTY_DATA_TYPE, PropertyDataType.OM);
 
  				} else if (type.equals(XMLConfigConstants.DATA_TYPES.LONG
						.toString())) {

					//vishualProp.setPropertyDataType(PropertyDataType.LONG);
					executeSetValueCommand(PROPERTY_MEDIATOR__PROPERTY_DATA_TYPE, PropertyDataType.LONG);

				} else if (type.equals(XMLConfigConstants.DATA_TYPES.INTEGER
						.toString())) {

					//vishualProp.setPropertyDataType(PropertyDataType.INTEGER);
					executeSetValueCommand(PROPERTY_MEDIATOR__PROPERTY_DATA_TYPE, PropertyDataType.INTEGER);

				} else if (type.equals(XMLConfigConstants.DATA_TYPES.DOUBLE
						.toString())) {

					//vishualProp.setPropertyDataType(PropertyDataType.DOUBLE);
					executeSetValueCommand(PROPERTY_MEDIATOR__PROPERTY_DATA_TYPE, PropertyDataType.DOUBLE);

				} else if (type.equals(XMLConfigConstants.DATA_TYPES.FLOAT
						.toString())) {

					//vishualProp.setPropertyDataType(PropertyDataType.FLOAT);
					executeSetValueCommand(PROPERTY_MEDIATOR__PROPERTY_DATA_TYPE, PropertyDataType.FLOAT);

				} else if (type.equals(XMLConfigConstants.DATA_TYPES.BOOLEAN
						.toString())) {

					//vishualProp.setPropertyDataType(PropertyDataType.BOOLEAN);
					executeSetValueCommand(PROPERTY_MEDIATOR__PROPERTY_DATA_TYPE, PropertyDataType.BOOLEAN);
					executeSetValueCommand(PROPERTY_MEDIATOR__BOOLEAN, propertyMediator.getValue());
				}
			} else if (propertyMediator.getValueElement() != null){
				executeSetValueCommand(PROPERTY_MEDIATOR__PROPERTY_DATA_TYPE,PropertyDataType.OM);
				executeSetValueCommand(PROPERTY_MEDIATOR__OM,propertyMediator.getValueElement().toString());				
			}

			Pattern pattern = propertyMediator.getPattern();
			if (pattern != null){
				//vishualProp.setValueStringPattern(pattern.toString());
				executeSetValueCommand(PROPERTY_MEDIATOR__VALUE_STRING_PATTERN, pattern.toString());
			}
			
			int groupValue = propertyMediator.getGroup();
			executeSetValueCommand(PROPERTY_MEDIATOR__VALUE_STRING_CAPTURING_GROUP, groupValue);
		}

		return VisualPropertyMediator;
	}

}
