package org.wso2.integrationstudio.eclipse.gmf.esb.diagram.custom.deserializer;

import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.DATA_MAPPER_MEDIATOR__CONFIGURATION;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.DATA_MAPPER_MEDIATOR__INPUT_SCHEMA;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.DATA_MAPPER_MEDIATOR__INPUT_TYPE;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.DATA_MAPPER_MEDIATOR__OUTPUT_SCHEMA;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.DATA_MAPPER_MEDIATOR__OUTPUT_TYPE;
import static org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage.Literals.DATA_MAPPER_MEDIATOR__XSLT_STYLE_SHEET;

import org.apache.synapse.mediators.AbstractMediator;
import org.apache.synapse.mediators.Value;
import org.eclipse.core.runtime.Assert;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.wso2.integrationstudio.eclipse.gmf.esb.DataMapperMediator;
import org.wso2.integrationstudio.eclipse.gmf.esb.DataMapperMediatorDataTypes;
import org.wso2.integrationstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.integrationstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;

public class DataMapperMediatorDeserializer extends AbstractEsbNodeDeserializer<AbstractMediator, DataMapperMediator> {

    @Override
    public DataMapperMediator createNode(IGraphicalEditPart part, AbstractMediator mediator)
            throws DeserializerException {

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
                setXSLTStyleSheetKey(carbonDataMapperMediator);
            }
        }
        setInputDataType(carbonDataMapperMediator);
        setOutputDataType(carbonDataMapperMediator);

        return gmfDataMapperMediator;
    }

    private boolean setConfigurationKey(org.wso2.carbon.mediator.datamapper.DataMapperMediator carbonDataMapperMediator)
            throws DeserializerException {
        if (carbonDataMapperMediator.getMappingConfigurationKey() != null) {
            Value keyValue = carbonDataMapperMediator.getMappingConfigurationKey();
            if (keyValue.getKeyValue() != null && !keyValue.getKeyValue().equals("")) {
                RegistryKeyProperty regKey = EsbFactory.eINSTANCE.createRegistryKeyProperty();
                regKey.setKeyValue(keyValue.getKeyValue());
                executeSetValueCommand(DATA_MAPPER_MEDIATOR__CONFIGURATION, regKey);
                return true;
            }
        } else {
            throw new DeserializerException("Data Mapper Mediator Configuration is empty, "
                    + "\n \n Please double click on the datamapper mediator to create a new configuration or add an existing configuration key before saving the ESB Config.");

        }
        return false;
    }

    private boolean setInputSchemaKey(org.wso2.carbon.mediator.datamapper.DataMapperMediator carbonDataMapperMediator)
            throws DeserializerException {
        if (carbonDataMapperMediator.getInputType() != null) {
            Value keyValue = carbonDataMapperMediator.getInputSchemaKey();
            if (keyValue.getKeyValue() != null && !keyValue.getKeyValue().equals("")) {
                RegistryKeyProperty regKey = EsbFactory.eINSTANCE.createRegistryKeyProperty();
                regKey.setKeyValue(keyValue.getKeyValue());
                executeSetValueCommand(DATA_MAPPER_MEDIATOR__INPUT_SCHEMA, regKey);
            }
            return true;
        } else {
            throw new DeserializerException("Data Mapper Mediator Input Schema Configuration is empty, "
                    + "\n \n Please double click on the datamapper mediator to create a new configuration or add an existing configuration key before saving the ESB Config.");
        }
    }

    private void setOutputSchemaKey(org.wso2.carbon.mediator.datamapper.DataMapperMediator carbonDataMapperMediator)
            throws DeserializerException {
        if (carbonDataMapperMediator.getOutputType() != null) {
            Value keyValue = carbonDataMapperMediator.getOutputSchemaKey();
            if (keyValue.getKeyValue() != null && !keyValue.getKeyValue().equals("")) {
                RegistryKeyProperty regKey = EsbFactory.eINSTANCE.createRegistryKeyProperty();
                regKey.setKeyValue(keyValue.getKeyValue());
                executeSetValueCommand(DATA_MAPPER_MEDIATOR__OUTPUT_SCHEMA, regKey);
            }
        } else {
            throw new DeserializerException("Data Mapper Mediator Output Schema Configuration is empty, "
                    + "\n \n Please double click on the datamapper to create a new configuration or add an existing configuration key before saving the ESB Config.");
        }
    }
    
    private void setXSLTStyleSheetKey(org.wso2.carbon.mediator.datamapper.DataMapperMediator carbonDataMapperMediator)
            throws DeserializerException {
        if (carbonDataMapperMediator.getXsltStyleSheetKey() != null) {
            Value keyValue = carbonDataMapperMediator.getXsltStyleSheetKey();
            if (keyValue.getKeyValue() != null && !keyValue.getKeyValue().equals("")) {
                RegistryKeyProperty regKey = EsbFactory.eINSTANCE.createRegistryKeyProperty();
                regKey.setKeyValue(keyValue.getKeyValue());
                executeSetValueCommand(DATA_MAPPER_MEDIATOR__XSLT_STYLE_SHEET, regKey);
            }
        }
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
