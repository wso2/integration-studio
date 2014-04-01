package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.deserializer;

import org.apache.synapse.mediators.AbstractMediator;
import org.apache.synapse.mediators.Value;
import org.eclipse.core.runtime.Assert;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.DataMapperMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;

import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.*;

public class DataMapperMediatorDeserializer extends
                                     AbstractEsbNodeDeserializer<AbstractMediator, DataMapperMediator> {

	@Override
	public DataMapperMediator createNode(IGraphicalEditPart part,AbstractMediator mediator) {

		Assert.isTrue(mediator instanceof org.wso2.carbon.mediator.datamapper.DataMapperMediator,
		              "Unsupported mediator passed in for deserialization at " + this.getClass());

		org.wso2.carbon.mediator.datamapper.DataMapperMediator carbonDataMapperMediator =
		                                                                   (org.wso2.carbon.mediator.datamapper.DataMapperMediator) mediator;
		
		DataMapperMediator gmfDataMapperMediator = (DataMapperMediator) DeserializerUtils.createNode(part, EsbElementTypes.DataMapperMediator_3761);

		setElementToEdit(gmfDataMapperMediator);
		setCommonProperties(carbonDataMapperMediator, gmfDataMapperMediator);

		setConfigurationKey(carbonDataMapperMediator);
		setInputSchemaKey(carbonDataMapperMediator);
		setOutputSchemaKey(carbonDataMapperMediator);
		
		return gmfDataMapperMediator;
	}

	private void setConfigurationKey(
			org.wso2.carbon.mediator.datamapper.DataMapperMediator carbonDataMapperMediator) {
		if (carbonDataMapperMediator.getCongigurationKey()!= null) {
			Value keyValue = carbonDataMapperMediator.getCongigurationKey();
			if (keyValue.getKeyValue() != null && !keyValue.getKeyValue().equals("")) {
				RegistryKeyProperty regKey = EsbFactory.eINSTANCE.createRegistryKeyProperty();
				regKey.setKeyValue(keyValue.getKeyValue());
				executeSetValueCommand(DATA_MAPPER_MEDIATOR__CONFIGURATION, regKey);
			}
		}
	}
	
	
	private void setInputSchemaKey(
			org.wso2.carbon.mediator.datamapper.DataMapperMediator carbonDataMapperMediator) {
		if (carbonDataMapperMediator.getInputSchemaKey()!= null) {
			Value keyValue = carbonDataMapperMediator.getInputSchemaKey();
			if (keyValue.getKeyValue() != null && !keyValue.getKeyValue().equals("")) {
				RegistryKeyProperty regKey = EsbFactory.eINSTANCE.createRegistryKeyProperty();
				regKey.setKeyValue(keyValue.getKeyValue());
				executeSetValueCommand(DATA_MAPPER_MEDIATOR__INPUT_SCHEMA, regKey);
			}
		}
	}
	
	private void setOutputSchemaKey(
			org.wso2.carbon.mediator.datamapper.DataMapperMediator carbonDataMapperMediator) {
		if (carbonDataMapperMediator.getOutputSchemaKey()!= null) {
			Value keyValue = carbonDataMapperMediator.getOutputSchemaKey();
			if (keyValue.getKeyValue() != null && !keyValue.getKeyValue().equals("")) {
				RegistryKeyProperty regKey = EsbFactory.eINSTANCE.createRegistryKeyProperty();
				regKey.setKeyValue(keyValue.getKeyValue());
				executeSetValueCommand(DATA_MAPPER_MEDIATOR__OUTPUT_SCHEMA, regKey);
			}
		}
	}

}
