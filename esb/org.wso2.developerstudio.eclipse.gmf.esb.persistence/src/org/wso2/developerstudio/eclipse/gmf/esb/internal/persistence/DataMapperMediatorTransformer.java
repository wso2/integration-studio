package org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence;

import java.util.List;

import org.apache.synapse.Mediator;
import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.wso2.developerstudio.eclipse.gmf.esb.DataMapperMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.custom.ClassMediatorExt;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.custom.DummyClassMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformationInfo;

public class DataMapperMediatorTransformer extends AbstractEsbNodeTransformer{

	public void transform(TransformationInfo info, EsbNode subject) throws Exception {
		 info.getParentSequence().addChild(createDataMapperMediator(subject));
			
		 // Transform the class mediator output data flow path.
		 doTransform(info, ((DataMapperMediator)subject).getOutputConnector());
		
	}

	public void createSynapseObject(TransformationInfo info, EObject subject,
			List<Endpoint> endPoints) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void transformWithinSequence(TransformationInfo information, EsbNode subject,
			SequenceMediator sequence) throws Exception {
		sequence.addChild(createDataMapperMediator(subject));
		doTransformWithinSequence(information,((DataMapperMediator)subject).getOutputConnector().getOutgoingLink(),sequence);
				
	}
	
	private ClassMediatorExt createDataMapperMediator(EsbNode subject) throws Exception {
		Assert.isTrue(subject instanceof DataMapperMediator, "Invalid subject.");
		DataMapperMediator visualDataMapper = (DataMapperMediator) subject;

		ClassMediatorExt classMediator = new ClassMediatorExt("wso2.datamappermediator.DataMapperMediator");
		setCommonProperties(classMediator, visualDataMapper);
		Mediator m = new DummyClassMediator();

		classMediator.setMediator((Mediator) m);

		// Class properties.
/*		for (ClassProperty visualProperty : visualClass.getProperties()) {
			classMediator.addProperty(visualProperty.getPropertyName(),
					visualProperty.getPropertyValue());
		}*/
		return classMediator;

	}

}
