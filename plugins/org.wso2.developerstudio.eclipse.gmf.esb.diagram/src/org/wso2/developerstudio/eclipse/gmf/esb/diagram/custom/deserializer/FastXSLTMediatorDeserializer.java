/**
 * Copyright 2009-2012 WSO2, Inc. (http://wso2.com)
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

import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.FAST_XSLT_MEDIATOR__FAST_XSLT_DYNAMIC_SCHEMA_KEY;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.FAST_XSLT_MEDIATOR__FAST_XSLT_SCHEMA_KEY_TYPE;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.FAST_XSLT_MEDIATOR__FAST_XSLT_STATIC_SCHEMA_KEY;

import java.util.Map;

import org.apache.synapse.config.xml.SynapsePath;
import org.apache.synapse.mediators.AbstractMediator;
import org.apache.synapse.mediators.Value;
import org.apache.synapse.util.xpath.SynapseXPath;
import org.eclipse.core.runtime.Assert;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.FastXSLTMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.KeyType;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.Activator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

/**
 *
 * @author WSO2
 * Deserialize the Fast XSLT mediator - from the source view to the diagram view
 */
public class FastXSLTMediatorDeserializer extends
                AbstractEsbNodeDeserializer<AbstractMediator, FastXSLTMediator> {

	private static final String UNSUPPORTED_MEDIATOR_PASSED =
	             "Unsupported mediator passed in for deserialization at ";	
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
	
	@Override
	public FastXSLTMediator createNode(IGraphicalEditPart part, AbstractMediator mediator) {

		Assert.isTrue(mediator instanceof org.wso2.carbon.mediator.fastXSLT.FastXSLTMediator,
		              UNSUPPORTED_MEDIATOR_PASSED + this.getClass());
		org.wso2.carbon.mediator.fastXSLT.FastXSLTMediator fastXSLTMediator =
		              (org.wso2.carbon.mediator.fastXSLT.FastXSLTMediator) mediator;

		org.wso2.developerstudio.eclipse.gmf.esb.FastXSLTMediator visualFastXSLTMediator =
		              (org.wso2.developerstudio.eclipse.gmf.esb.FastXSLTMediator) DeserializerUtils.createNode(part,EsbElementTypes.FastXSLTMediator_3764);

		setElementToEdit(visualFastXSLTMediator);
		setCommonProperties(fastXSLTMediator, visualFastXSLTMediator);
		
		Value keyValue = fastXSLTMediator.getXsltKey();  
		if (keyValue != null) {
			
			//If key is a registry key i.e static 
			if (keyValue.getKeyValue() != null && !keyValue.getKeyValue().equals("")) {
				
				if (!executeSetValueCommand(FAST_XSLT_MEDIATOR__FAST_XSLT_SCHEMA_KEY_TYPE, KeyType.STATIC)) {
					log.warn("executeSetValueCommand returned false in Fast XSLT mediator Deserializer for Schema key type");
				}
				
				RegistryKeyProperty regKey = EsbFactory.eINSTANCE.createRegistryKeyProperty();
				regKey.setKeyValue(keyValue.getKeyValue());
				
				if (!executeSetValueCommand(FAST_XSLT_MEDIATOR__FAST_XSLT_STATIC_SCHEMA_KEY, regKey)) {
					log.warn("executeSetValueCommand returned false in Fast XSLT mediator Deserializer for Static Schema Key");
                }	                
			
			//If key is a dynamic key i.e XpathExpression
			} else if (keyValue.getExpression() != null) {
				
				if (!executeSetValueCommand(FAST_XSLT_MEDIATOR__FAST_XSLT_SCHEMA_KEY_TYPE, KeyType.DYNAMIC)) {
					log.warn("executeSetValueCommand returned false in Fast XSLT mediator Deserializer for Schema key type");
                }
				
				SynapsePath xpath = keyValue.getExpression();
				NamespacedProperty nsp = EsbFactory.eINSTANCE.createNamespacedProperty();
				nsp.setPropertyValue(xpath.toString());
				
				@SuppressWarnings("unchecked")
				Map<String, String> map = xpath.getNamespaces();
				if (map != null) {
					nsp.setNamespaces(map);
				}
				if (!executeSetValueCommand(FAST_XSLT_MEDIATOR__FAST_XSLT_DYNAMIC_SCHEMA_KEY, nsp)) {
					log.warn("executeSetValueCommand returned false in Fast XSLT mediator Deserializer for Dynamic schema key");
                }
			}
		}
		return visualFastXSLTMediator;
	}

}
