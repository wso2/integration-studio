package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.deserializer;

import org.apache.synapse.mediators.AbstractMediator;
import org.apache.synapse.mediators.Value;
import org.eclipse.core.runtime.Assert;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.wso2.developerstudio.eclipse.gmf.esb.DataMapperMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.DataMapperMediatorDataTypes;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;

import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.*;

public class DataMapperMediatorDeserializer extends AbstractEsbNodeDeserializer<AbstractMediator, DataMapperMediator> {

	private static final String DATA_MAPPER_MEDIATOR_SAVE_ERROR = "Data Mapper Mediator Save Error";

	@Override
	public DataMapperMediator createNode(IGraphicalEditPart part, AbstractMediator mediator) {

		Assert.isTrue(mediator instanceof org.wso2.carbon.mediator.datamapper.DataMapperMediator,
				"Unsupported mediator passed in for deserialization at " + this.getClass());

		org.wso2.carbon.mediator.datamapper.DataMapperMediator carbonDataMapperMediator = (org.wso2.carbon.mediator.datamapper.DataMapperMediator) mediator;

		DataMapperMediator gmfDataMapperMediator = (DataMapperMediator) DeserializerUtils.createNode(part,
				EsbElementTypes.DataMapperMediator_3761);

		setElementToEdit(gmfDataMapperMediator);
		setCommonProperties(carbonDataMapperMediator, gmfDataMapperMediator);

		if (setConfigurationKey(carbonDataMapperMediator)) {
			if (setInputSchemaKey(carbonDataMapperMediator)) {
				setOutputSchemaKey(carbonDataMapperMediator);
			}
		}
		setInputDataType(carbonDataMapperMediator);
		setOutputDataType(carbonDataMapperMediator);

		return gmfDataMapperMediator;
	}

	private boolean setConfigurationKey(
			org.wso2.carbon.mediator.datamapper.DataMapperMediator carbonDataMapperMediator) {
		if (carbonDataMapperMediator.getConfigurationKey() != null) {
			Value keyValue = carbonDataMapperMediator.getConfigurationKey();
			if (keyValue.getKeyValue() != null && !keyValue.getKeyValue().equals("")) {
				RegistryKeyProperty regKey = EsbFactory.eINSTANCE.createRegistryKeyProperty();
				regKey.setKeyValue(keyValue.getKeyValue());
				executeSetValueCommand(DATA_MAPPER_MEDIATOR__CONFIGURATION, regKey);
				return true;
			}
		} else {
			displayUserMessage("Data Mapper Mediator Configuration is empty, "
										+ "\n \n Please double click on the datamapper mediator to create a new configuration to map data before saving the ESB Config.");
		}
		return false;
	}

	private boolean setInputSchemaKey(org.wso2.carbon.mediator.datamapper.DataMapperMediator carbonDataMapperMediator) {
		if (carbonDataMapperMediator.getInputType() != null) {
			Value keyValue = carbonDataMapperMediator.getInputSchemaKey();
			if (keyValue.getKeyValue() != null && !keyValue.getKeyValue().equals("")) {
				RegistryKeyProperty regKey = EsbFactory.eINSTANCE.createRegistryKeyProperty();
				regKey.setKeyValue(keyValue.getKeyValue());
				executeSetValueCommand(DATA_MAPPER_MEDIATOR__INPUT_SCHEMA, regKey);
			}
			return true;
		} else {
			displayUserMessage("Data Mapper Mediator Input Schema Configuration is empty, "
										+ "\n \n Please double click on the datamapper mediator to create a new configuration to map data before saving the ESB Config.");
		}
		return false;
	}

	private void setOutputSchemaKey(
			org.wso2.carbon.mediator.datamapper.DataMapperMediator carbonDataMapperMediator) {
		if (carbonDataMapperMediator.getOutputType() != null) {
			Value keyValue = carbonDataMapperMediator.getOutputSchemaKey();
			if (keyValue.getKeyValue() != null && !keyValue.getKeyValue().equals("")) {
				RegistryKeyProperty regKey = EsbFactory.eINSTANCE.createRegistryKeyProperty();
				regKey.setKeyValue(keyValue.getKeyValue());
				executeSetValueCommand(DATA_MAPPER_MEDIATOR__OUTPUT_SCHEMA, regKey);
			}
		} else {
			displayUserMessage("Data Mapper Mediator Output Schema Configuration is empty, "
					+ "\n \n Please double click on the datamapper to create a new configuration to map data before saving the ESB Config.");
		}
	}

	private void displayUserMessage(final String message) {
		Display.getDefault().syncExec(new Runnable() {
			@Override
			public void run() {
				try {
					MessageDialog dialog = new MessageDialog(Display.getDefault().getActiveShell(),
							DATA_MAPPER_MEDIATOR_SAVE_ERROR, null,
							message,
							MessageDialog.INFORMATION, new String[] { "OK" }, 0);
					dialog.open();
				} catch (Exception e) {
					// need to log the error
				}
			}
			// pop up user message saying an updater job is already
			// running
		});
	}

	private void setInputDataType(org.wso2.carbon.mediator.datamapper.DataMapperMediator carbonDataMapperMediator) {
		if (carbonDataMapperMediator.getInputType() != null) {
			String inputValue = carbonDataMapperMediator.getInputType();
			if (inputValue != null && !inputValue.equals("")) {
				switch (DataMapperMediatorDeserializer.fromString(inputValue)) {
				case CSV:
					executeSetValueCommand(DATA_MAPPER_MEDIATOR__INPUT_TYPE, DataMapperMediatorDataTypes.CSV);
					break;
				case XML:
					executeSetValueCommand(DATA_MAPPER_MEDIATOR__INPUT_TYPE, DataMapperMediatorDataTypes.XML);
					break;
				case JSON:
					executeSetValueCommand(DATA_MAPPER_MEDIATOR__INPUT_TYPE, DataMapperMediatorDataTypes.JSON);
					break;
				default:
					executeSetValueCommand(DATA_MAPPER_MEDIATOR__INPUT_TYPE, DataMapperMediatorDataTypes.JSON);
				}
			}
		}

	}

	private void setOutputDataType(org.wso2.carbon.mediator.datamapper.DataMapperMediator carbonDataMapperMediator) {
		if (carbonDataMapperMediator.getOutputType() != null) {
			String outputValue = carbonDataMapperMediator.getOutputType();
			if (outputValue != null && !outputValue.equals("")) {
				switch (DataMapperMediatorDeserializer.fromString(outputValue)) {
				case CSV:
					executeSetValueCommand(DATA_MAPPER_MEDIATOR__OUTPUT_TYPE, DataMapperMediatorDataTypes.CSV);
					break;
				case XML:
					executeSetValueCommand(DATA_MAPPER_MEDIATOR__OUTPUT_TYPE, DataMapperMediatorDataTypes.XML);
					break;
				case JSON:
					executeSetValueCommand(DATA_MAPPER_MEDIATOR__OUTPUT_TYPE, DataMapperMediatorDataTypes.JSON);
					break;
				default:
					executeSetValueCommand(DATA_MAPPER_MEDIATOR__OUTPUT_TYPE, DataMapperMediatorDataTypes.JSON);
				}
			}
		}

	}

	public static DataMapperMediatorDataTypes fromString(String text) {
		if (text != null) {
			for (DataMapperMediatorDataTypes type : DataMapperMediatorDataTypes.values()) {
				if (text.equalsIgnoreCase(type.toString())) {
					return type;
				}
			}
		}
		return null;
	}

}
