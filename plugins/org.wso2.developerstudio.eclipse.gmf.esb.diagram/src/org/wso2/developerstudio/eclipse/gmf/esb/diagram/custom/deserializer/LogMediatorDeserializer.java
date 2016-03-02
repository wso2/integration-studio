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
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.synapse.config.xml.SynapsePath;
import org.apache.synapse.mediators.AbstractMediator;
import org.apache.synapse.mediators.MediatorProperty;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.LogCategory;
import org.wso2.developerstudio.eclipse.gmf.esb.LogLevel;
import org.wso2.developerstudio.eclipse.gmf.esb.LogMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.LogProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.PropertyValueType;
import org.wso2.developerstudio.eclipse.gmf.esb.ValidateFeature;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.*;

public class LogMediatorDeserializer extends AbstractEsbNodeDeserializer<AbstractMediator,LogMediator> {

	
	public LogMediator createNode(IGraphicalEditPart part, AbstractMediator mediator) {
		
		Assert.isTrue(mediator instanceof org.apache.synapse.mediators.builtin.LogMediator, "Unsupported mediator passed in for deserialization at "+ this.getClass());
		
		org.apache.synapse.mediators.builtin.LogMediator logMediator = (org.apache.synapse.mediators.builtin.LogMediator)mediator;
		
		LogMediator visualLog = (LogMediator) DeserializerUtils.createNode(part, EsbElementTypes.LogMediator_3495); //EsbFactory.eINSTANCE.createLogMediator();
		setElementToEdit(visualLog);
		setCommonProperties(logMediator, visualLog);
		
		switch (logMediator.getCategory()) {
		
		case org.apache.synapse.mediators.builtin.LogMediator.CATEGORY_DEBUG:
			//visualLog.setLogCategory(LogCategory.DEBUG);
			executeSetValueCommand(LOG_MEDIATOR__LOG_CATEGORY, LogCategory.DEBUG);
			break;

		case org.apache.synapse.mediators.builtin.LogMediator.CATEGORY_ERROR:
			//visualLog.setLogCategory(LogCategory.ERROR);
			executeSetValueCommand(LOG_MEDIATOR__LOG_CATEGORY, LogCategory.ERROR);
			break;

		case org.apache.synapse.mediators.builtin.LogMediator.CATEGORY_FATAL:
			//visualLog.setLogCategory(LogCategory.FATAL);
			executeSetValueCommand(LOG_MEDIATOR__LOG_CATEGORY, LogCategory.FATAL);
			break;

		case org.apache.synapse.mediators.builtin.LogMediator.CATEGORY_INFO:
			//visualLog.setLogCategory(LogCategory.INFO);
			executeSetValueCommand(LOG_MEDIATOR__LOG_CATEGORY, LogCategory.INFO);
			break;
		case org.apache.synapse.mediators.builtin.LogMediator.CATEGORY_TRACE:
			//visualLog.setLogCategory(LogCategory.TRACE);
			executeSetValueCommand(LOG_MEDIATOR__LOG_CATEGORY, LogCategory.TRACE);
			break;

		case org.apache.synapse.mediators.builtin.LogMediator.CATEGORY_WARN:
			//visualLog.setLogCategory(LogCategory.WARN);
			executeSetValueCommand(LOG_MEDIATOR__LOG_CATEGORY, LogCategory.WARN);
			break;
		}
		
		
		switch(logMediator.getLogLevel()){
		
		case org.apache.synapse.mediators.builtin.LogMediator.CUSTOM:
			//visualLog.setLogLevel(LogLevel.CUSTOM);
			executeSetValueCommand(LOG_MEDIATOR__LOG_LEVEL, LogLevel.CUSTOM);
			break;
			
		case org.apache.synapse.mediators.builtin.LogMediator.FULL:
			//visualLog.setLogLevel(LogLevel.FULL);
			executeSetValueCommand(LOG_MEDIATOR__LOG_LEVEL, LogLevel.FULL);
			break;
		
		case org.apache.synapse.mediators.builtin.LogMediator.HEADERS:
			//visualLog.setLogLevel(LogLevel.HEADERS);
			executeSetValueCommand(LOG_MEDIATOR__LOG_LEVEL, LogLevel.HEADERS);
			break;
		
		case org.apache.synapse.mediators.builtin.LogMediator.SIMPLE:
			//visualLog.setLogLevel(LogLevel.SIMPLE);
			executeSetValueCommand(LOG_MEDIATOR__LOG_LEVEL, LogLevel.SIMPLE);
			
		}
		
		
		if (!StringUtils.isBlank(logMediator.getSeparator())) {
			
			//visualLog.setLogSeparator(logMediator.getSeparator());
			executeSetValueCommand(LOG_MEDIATOR__LOG_SEPARATOR, logMediator.getSeparator());
		}
		
		
		EList<LogProperty> logPropertyList = new BasicEList<LogProperty>();
		for(MediatorProperty mediatorProprety : logMediator.getProperties()){
			
			LogProperty logProperty = EsbFactory.eINSTANCE.createLogProperty();
			
			logProperty.setPropertyName(mediatorProprety.getName());
			
			if(mediatorProprety.getValue() != null){
				
				logProperty.setPropertyValueType(PropertyValueType.LITERAL);
				logProperty.setPropertyValue(mediatorProprety.getValue());
				
			}else if(mediatorProprety.getExpression() != null){
				
				logProperty.setPropertyValueType(PropertyValueType.EXPRESSION);
				SynapsePath xpath = mediatorProprety.getExpression();
				NamespacedProperty namespaceProp = createNamespacedProperty(xpath);

				logProperty.setPropertyExpression(namespaceProp);
				
			}
			
			logPropertyList.add(logProperty);
			//visualLog.getProperties().add(logProperty);
		}
		executeSetValueCommand(LOG_MEDIATOR__PROPERTIES, logPropertyList);
		
		
		return visualLog;
	}

  
	
}
