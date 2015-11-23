package org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence;

import java.util.List;

import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.mediators.Value;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.wso2.developerstudio.eclipse.gmf.esb.DataMapperMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformationInfo;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformerException;

public class DataMapperMediatorTransformer extends AbstractEsbNodeTransformer {

	public void transform(TransformationInfo info, EsbNode subject)
			throws TransformerException {
		info.getParentSequence().addChild(createDataMapperMediator(subject));
		doTransform(info, ((DataMapperMediator) subject).getOutputConnector());

	}

	public void createSynapseObject(TransformationInfo info, EObject subject,
			List<Endpoint> endPoints) throws TransformerException {
		// TODO Auto-generated method stub

	}

	public void transformWithinSequence(TransformationInfo information,
			EsbNode subject, SequenceMediator sequence) throws TransformerException {
		sequence.addChild(createDataMapperMediator(subject));
		doTransformWithinSequence(information, ((DataMapperMediator) subject)
				.getOutputConnector().getOutgoingLink(), sequence);

	}

	private org.wso2.carbon.mediator.datamapper.DataMapperMediator createDataMapperMediator(
			EsbNode subject){
		Assert.isTrue(subject instanceof DataMapperMediator, "Invalid subject.");
		DataMapperMediator visualDataMapperMediator = (DataMapperMediator) subject;

		org.wso2.carbon.mediator.datamapper.DataMapperMediator carbonDataMapperMediator = new org.wso2.carbon.mediator.datamapper.DataMapperMediator();
		setCommonProperties(carbonDataMapperMediator, visualDataMapperMediator);

		setConfigKey(visualDataMapperMediator, carbonDataMapperMediator);

		setInputSchemaKey(visualDataMapperMediator, carbonDataMapperMediator);

		setOutputSchemaKey(visualDataMapperMediator, carbonDataMapperMediator);

		setInputDataType(visualDataMapperMediator, carbonDataMapperMediator);

		setOutputDataType(visualDataMapperMediator, carbonDataMapperMediator);

		return carbonDataMapperMediator;
	}

	private void setOutputSchemaKey(
			DataMapperMediator visualDataMapperMediator,
			org.wso2.carbon.mediator.datamapper.DataMapperMediator carbonDataMapperMediator) {
		Value outputSchemaKey = null;
		String key = visualDataMapperMediator.getOutputSchema().getKeyValue();
		if (key != null && !key.equals("")) {
			outputSchemaKey = new Value(key);
		}
		if (outputSchemaKey != null) {
			carbonDataMapperMediator.setOutputSchemaKey(outputSchemaKey);
		}
	}

	private void setInputSchemaKey(
			DataMapperMediator visualDataMapperMediator,
			org.wso2.carbon.mediator.datamapper.DataMapperMediator carbonDataMapperMediator) {
		Value inputSchemaKey = null;
		String key = visualDataMapperMediator.getInputSchema().getKeyValue();
		if (key != null && !key.equals("")) {
			inputSchemaKey = new Value(key);
		}
		if (inputSchemaKey != null) {
			carbonDataMapperMediator.setInputSchemaKey(inputSchemaKey);
		}
	}

	private void setConfigKey(
			DataMapperMediator visualDataMapperMediator,
			org.wso2.carbon.mediator.datamapper.DataMapperMediator carbonDataMapperMediator) {
		Value configKey = null;
		String key = visualDataMapperMediator.getConfiguration().getKeyValue();
		if (key != null && !key.equals("")) {
			configKey = new Value(key);
		}
		if (configKey != null) {
			carbonDataMapperMediator.setConfigurationKey(configKey);
		}
	}

	private void setInputDataType(
			DataMapperMediator visualDataMapperMediator,
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

	private void setOutputDataType(
			DataMapperMediator visualDataMapperMediator,
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
