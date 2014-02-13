package org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence;

import java.io.ByteArrayOutputStream;
import java.io.File;

import org.apache.axiom.om.OMElement;
import org.apache.synapse.config.SynapseConfiguration;
import org.apache.synapse.config.xml.SynapseXMLConfigurationSerializer;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.resource.Resource;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbLink;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbSequence;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbSequenceInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbServer;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.SequenceModelTransformer;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformationInfo;

public class SequenceModelTranformerImpl implements SequenceModelTransformer {
	
	public void export(Resource resource, File destination) throws Exception {
		// TODO Auto-generated method stub
		
	}
	public String designToSource(EsbSequence sequenceModel) throws Exception {
		SynapseXMLConfigurationSerializer serializer = new SynapseXMLConfigurationSerializer();
		OMElement configOM = serializer
				.serializeConfiguration(transform(sequenceModel));
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DefaultEsbModelExporter.prettify(configOM, baos);
		//String sourceXML = baos.toString("UTF-8");
		return baos.toString("UTF-8");
	}
	
	public EsbSequence sourceToDesign(String source, EsbSequence esbServer)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Transforms the given {@link EsbServer} visual model into a
	 * {@link SynapseConfiguration} object.
	 * 
	 * @param serverModel
	 *            {@link EsbServer} visual model.
	 * @return configured {@link SynapseConfiguration} object.
	 * @throws Exception
	 *             if an error occurs during transformation.
	 */
	private SynapseConfiguration transform(EsbSequence sequenceModel)
			throws Exception {
		SynapseConfiguration configuration = new SynapseConfiguration();
		TransformationInfo info = new TransformationInfo();
		info.setTraversalDirection(TransformationInfo.TRAVERSAL_DIRECTION_IN);
		info.setSynapseConfiguration(configuration);
		
		//message  mediation
		EsbSequenceInputConnector seqIn = sequenceModel.getInput();
		if (seqIn!=null) {
			EsbLink inputLink = seqIn.getOutgoingLink();
			Assert.isNotNull(inputLink,"Make sure you have connected input to a mediator");
			
			//doTransform()
		}
		
		return configuration;
	}
}
