package org.wso2.integrationstudio.eclipse.gmf.esb.internal.persistence;

import java.util.List;

import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.mediators.Value;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.wso2.integrationstudio.eclipse.gmf.esb.DataMapperMediator;
import org.wso2.integrationstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.integrationstudio.eclipse.gmf.esb.persistence.TransformationInfo;
import org.wso2.integrationstudio.eclipse.gmf.esb.persistence.TransformerException;

public class DataMapperMediatorTransformer extends AbstractEsbNodeTransformer {

    public void transform(TransformationInfo info, EsbNode subject) throws TransformerException {
        info.getParentSequence().addChild(createDataMapperMediator(subject));
        doTransform(info, ((DataMapperMediator) subject).getOutputConnector());

    }

    public void createSynapseObject(TransformationInfo info, EObject subject, List<Endpoint> endPoints)
            throws TransformerException {
        // TODO Auto-generated method stub

    }

    public void transformWithinSequence(TransformationInfo information, EsbNode subject, SequenceMediator sequence)
            throws TransformerException {
        sequence.addChild(createDataMapperMediator(subject));
        doTransformWithinSequence(information, ((DataMapperMediator) subject).getOutputConnector().getOutgoingLink(),
                sequence);

    }

    private org.wso2.carbon.mediator.datamapper.DataMapperMediator createDataMapperMediator(EsbNode subject)
            throws TransformerException {
        Assert.isTrue(subject instanceof DataMapperMediator, "Invalid subject.");
        DataMapperMediator visualDataMapperMediator = (DataMapperMediator) subject;

        org.wso2.carbon.mediator.datamapper.DataMapperMediator carbonDataMapperMediator = new org.wso2.carbon.mediator.datamapper.DataMapperMediator();
        setCommonProperties(carbonDataMapperMediator, visualDataMapperMediator);

        if (setConfigKey(visualDataMapperMediator, carbonDataMapperMediator)) {

            if (setInputSchemaKey(visualDataMapperMediator, carbonDataMapperMediator)) {

                setOutputSchemaKey(visualDataMapperMediator, carbonDataMapperMediator);
                
                setXsltStyleSheetKey(visualDataMapperMediator, carbonDataMapperMediator);
                
            }
        }

        setInputDataType(visualDataMapperMediator, carbonDataMapperMediator);

        setOutputDataType(visualDataMapperMediator, carbonDataMapperMediator);

        return carbonDataMapperMediator;
    }

    private void setOutputSchemaKey(DataMapperMediator visualDataMapperMediator,
            org.wso2.carbon.mediator.datamapper.DataMapperMediator carbonDataMapperMediator)
            throws TransformerException {
        Value outputSchemaKey = null;
        String key = visualDataMapperMediator.getOutputSchema().getKeyValue();
        if (key != null && !key.equals("")) {
            outputSchemaKey = new Value(key);
        }
        if (outputSchemaKey != null) {
            carbonDataMapperMediator.setOutputSchemaKey(outputSchemaKey);
        }
        if ((key == null || key.equals("")) && outputSchemaKey == null) {
            throw new TransformerException("Data Mapper Mediator Input Schema Configuration is empty, "
                    + "\n \n Please double click on the datamapper mediator to create a new configuration or add an existing configuration key before saving the ESB Config.");
        }
    }

    private boolean setInputSchemaKey(DataMapperMediator visualDataMapperMediator,
            org.wso2.carbon.mediator.datamapper.DataMapperMediator carbonDataMapperMediator)
            throws TransformerException {
        Value inputSchemaKey = null;
        String key = visualDataMapperMediator.getInputSchema().getKeyValue();
        if (key != null && !key.equals("")) {
            inputSchemaKey = new Value(key);
        }
        if (inputSchemaKey != null) {
            carbonDataMapperMediator.setInputSchemaKey(inputSchemaKey);
        }
        if ((key == null || key.equals("")) && inputSchemaKey == null) {
            throw new TransformerException("Data Mapper Mediator Output Schema Configuration is empty, "
                    + "\n \n Please double click on the datamapper mediator to create a new configuration or add an existing configuration key before saving the ESB Config.");
        }
        return true;
    }

    private boolean setConfigKey(DataMapperMediator visualDataMapperMediator,
            org.wso2.carbon.mediator.datamapper.DataMapperMediator carbonDataMapperMediator)
            throws TransformerException {
        Value configKey = null;
        String key = visualDataMapperMediator.getConfiguration().getKeyValue();
        if (key != null && !key.equals("")) {
            configKey = new Value(key);
        }
        if (configKey != null) {
            carbonDataMapperMediator.setMappingConfigurationKey(configKey);
        }
        if ((key == null || key.equals("")) && configKey == null) {
            throw new TransformerException("Data Mapper Mediator Configuration is empty, "
                    + "\n \n Please double click on the datamapper mediator to create a new configuration or add an existing configuration key before saving the ESB Config.");
        }
        return true;
    }
    
    private void setXsltStyleSheetKey(DataMapperMediator visualDataMapperMediator,
            org.wso2.carbon.mediator.datamapper.DataMapperMediator carbonDataMapperMediator)
            throws TransformerException {
        Value xsltStyleSheetKey = null;
        String key = visualDataMapperMediator.getXsltStyleSheet().getKeyValue();
        if (key != null && !key.equals("")) {
            xsltStyleSheetKey = new Value(key);
        }
        if (xsltStyleSheetKey != null) {
            carbonDataMapperMediator.setXsltStyleSheetKey(xsltStyleSheetKey);
        }
    }

    private void setInputDataType(DataMapperMediator visualDataMapperMediator,
            org.wso2.carbon.mediator.datamapper.DataMapperMediator carbonDataMapperMediator) {
        String inutDataType = null;
        String value = visualDataMapperMediator.getInputType().toString();
        if (value != null && !value.equals("")) {
            inutDataType = value;
        }
        if (inutDataType != null) {
            carbonDataMapperMediator.setInputType(inutDataType);
        }
    }

    private void setOutputDataType(DataMapperMediator visualDataMapperMediator,
            org.wso2.carbon.mediator.datamapper.DataMapperMediator carbonDataMapperMediator) {
        String outputDataType = null;
        String value = visualDataMapperMediator.getOutputType().toString();
        if (value != null && !value.equals("")) {
            outputDataType = value;
        }
        if (outputDataType != null) {
            carbonDataMapperMediator.setOutputType(outputDataType);
        }
    }

}
