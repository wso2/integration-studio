package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.deserializer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;
import org.apache.synapse.config.xml.SynapsePath;
import org.apache.synapse.mediators.AbstractMediator;
import org.apache.synapse.mediators.MediatorProperty;
import org.apache.synapse.mediators.Value;
import org.apache.synapse.util.xpath.SynapseXPath;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.KeyType;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.PropertyValueType;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.XSLTFeature;
import org.wso2.developerstudio.eclipse.gmf.esb.XSLTMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.XSLTProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.XSLTResource;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;

import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.*;

public class XSLTMediatorDeserializer extends
                                     AbstractEsbNodeDeserializer<AbstractMediator, XSLTMediator> {

	@Override
	public XSLTMediator createNode(IGraphicalEditPart part,AbstractMediator mediator) {

		Assert.isTrue(mediator instanceof org.apache.synapse.mediators.transform.XSLTMediator,
		              "Unsupported mediator passed in for deserialization at " + this.getClass());

		org.apache.synapse.mediators.transform.XSLTMediator xsltMediator =
		                                                                   (org.apache.synapse.mediators.transform.XSLTMediator) mediator;
		
		org.wso2.developerstudio.eclipse.gmf.esb.XSLTMediator VisualXsltMediator = (org.wso2.developerstudio.eclipse.gmf.esb.XSLTMediator) DeserializerUtils.createNode(part, EsbElementTypes.XSLTMediator_3497);

		setElementToEdit(VisualXsltMediator);
		setCommonProperties(xsltMediator, VisualXsltMediator);
		
		//XSLTMediator vishualXslt = EsbFactory.eINSTANCE.createXSLTMediator();

		if (xsltMediator.getXsltKey() != null) {

			Value keyValue = xsltMediator.getXsltKey();

			if (keyValue.getKeyValue() != null && !keyValue.getKeyValue().equals("")) {

				//vishualXslt.setXsltSchemaKeyType(KeyType.STATIC);
				executeSetValueCommand(XSLT_MEDIATOR__XSLT_SCHEMA_KEY_TYPE,KeyType.STATIC);

				RegistryKeyProperty regKey = EsbFactory.eINSTANCE.createRegistryKeyProperty();

				regKey.setKeyValue(keyValue.getKeyValue());

				//vishualXslt.setXsltStaticSchemaKey(regKey);
				executeSetValueCommand(XSLT_MEDIATOR__XSLT_STATIC_SCHEMA_KEY,regKey);
				
			} else if (keyValue.getExpression() != null) {

				//vishualXslt.setXsltSchemaKeyType(KeyType.DYNAMIC);
				executeSetValueCommand(XSLT_MEDIATOR__XSLT_SCHEMA_KEY_TYPE,KeyType.DYNAMIC);

				SynapsePath xpath = keyValue.getExpression();

				NamespacedProperty nsp = EsbFactory.eINSTANCE.createNamespacedProperty();

				nsp.setPropertyValue(xpath.toString());

				if (xpath.getNamespaces() != null) {

					@SuppressWarnings("unchecked")
					Map<String, String> map = xpath.getNamespaces();

					nsp.setNamespaces(map);
				}

				//vishualXslt.setXsltDynamicSchemaKey(nsp);
				executeSetValueCommand(XSLT_MEDIATOR__XSLT_DYNAMIC_SCHEMA_KEY,nsp);
			}
		}

		if (xsltMediator.getSource() != null) {

			SynapseXPath SourceXpath = xsltMediator.getSource();

			NamespacedProperty nsp = EsbFactory.eINSTANCE.createNamespacedProperty();

			nsp.setPropertyValue(SourceXpath.toString());

			if (SourceXpath.getNamespaces() != null) {

				@SuppressWarnings("unchecked")
				Map<String, String> map = SourceXpath.getNamespaces();

				nsp.setNamespaces(map);
			}

			//vishualXslt.setSourceXPath(nsp);
			executeSetValueCommand(XSLT_MEDIATOR__SOURCE_XPATH,nsp);
		}

		if (xsltMediator.getFeatures() != null && !xsltMediator.getFeatures().isEmpty()) {

			List<XSLTFeature> vishualFeatureList = new ArrayList<XSLTFeature>();

			for (MediatorProperty featureMediatorProperty : xsltMediator.getFeatures()) {

				XSLTFeature visualFeature = EsbFactory.eINSTANCE.createXSLTFeature();

				if (featureMediatorProperty.getName() != null &&
				    !featureMediatorProperty.getName().equals("")) {

					visualFeature.setFeatureName(featureMediatorProperty.getName());
				}

				//if (Boolean.parseBoolean(featureMediatorProperty.getValue())) {

					visualFeature.setFeatureEnabled(Boolean.parseBoolean(featureMediatorProperty.getValue()));
				//}

				vishualFeatureList.add(visualFeature);

			}

			//vishualXslt.getFeatures().addAll(vishualFeatureList);
			executeSetValueCommand(XSLT_MEDIATOR__FEATURES, vishualFeatureList);
		}

		if (xsltMediator.getProperties() != null && !xsltMediator.getProperties().isEmpty()) {

			EList<XSLTProperty> visualPropertyList = new BasicEList<XSLTProperty>();

			for (MediatorProperty propertyMediatorProperty : xsltMediator.getProperties()) {

				XSLTProperty visualProperty = EsbFactory.eINSTANCE.createXSLTProperty();

				if (StringUtils.isNotBlank(propertyMediatorProperty.getName())) {
					visualProperty.setPropertyName(propertyMediatorProperty.getName());
				}

				if (StringUtils.isNotBlank(propertyMediatorProperty.getValue())) {
					visualProperty.setPropertyValue(propertyMediatorProperty.getValue());
					visualProperty.setPropertyValueType(PropertyValueType.LITERAL);
				} else if (propertyMediatorProperty != null) {
					visualProperty.setPropertyExpression(createNamespacedProperty(propertyMediatorProperty
									.getExpression()));
					visualProperty.setPropertyValueType(PropertyValueType.EXPRESSION);
				}

				visualPropertyList.add(visualProperty);
			}

			//vishualXslt.getProperties().addAll(visualPropertyList);
			executeSetValueCommand(XSLT_MEDIATOR__PROPERTIES, visualPropertyList);
		}

		if (xsltMediator.getResourceMap() != null &&
		    xsltMediator.getResourceMap().getResources() != null) {

			Map<String, String> resourceMap = xsltMediator.getResourceMap().getResources();

			EList<XSLTResource> visualResourceList = new BasicEList<XSLTResource>();

			for (Entry<String, String> entry : resourceMap.entrySet()) {

				XSLTResource resource = EsbFactory.eINSTANCE.createXSLTResource();

				resource.setLocation(entry.getKey());

				RegistryKeyProperty regkey = EsbFactory.eINSTANCE.createRegistryKeyProperty();

				regkey.setKeyValue(entry.getValue());

				resource.setKey(regkey);

				visualResourceList.add(resource);
			}

			//vishualXslt.getResources().addAll(visualResourceList);
			executeSetValueCommand(XSLT_MEDIATOR__RESOURCES, visualResourceList);

		}

		return VisualXsltMediator;
	}

}
