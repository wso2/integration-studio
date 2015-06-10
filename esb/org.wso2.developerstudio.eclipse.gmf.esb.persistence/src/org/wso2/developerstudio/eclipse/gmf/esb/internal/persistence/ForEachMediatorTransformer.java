package org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence;

import java.util.List;
import java.util.Map;

import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.apache.synapse.util.xpath.SynapseXPath;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.developerstudio.eclipse.gmf.esb.ForEachMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformationInfo;

public class ForEachMediatorTransformer extends AbstractEsbNodeTransformer {

	public void transform(TransformationInfo information, EsbNode subject) throws Exception {
		information.getParentSequence().addChild(createForEachMediator(information, subject));

		// Transform mediator output data flow path.
		doTransform(information, ((ForEachMediator) subject).getOutputConnector());
	}

	public void transformWithinSequence(TransformationInfo information, EsbNode subject, SequenceMediator sequence)
			throws Exception {
		sequence.addChild(createForEachMediator(information, subject));
		doTransformWithinSequence(information, ((ForEachMediator) subject).getOutputConnector().getOutgoingLink(),
				sequence);
	}

	private org.apache.synapse.mediators.builtin.ForEachMediator createForEachMediator(TransformationInfo information,
			EsbNode subject) throws Exception {
		// Check subject.
		Assert.isTrue(subject instanceof ForEachMediator, "Invalid subject.");
		ForEachMediator visualForEach = (ForEachMediator) subject;

		// Configure ForEach mediator.
		org.apache.synapse.mediators.builtin.ForEachMediator forEachMediator = new org.apache.synapse.mediators.builtin.ForEachMediator();
		setCommonProperties(forEachMediator, visualForEach);

		NamespacedProperty ForEachExp = visualForEach.getForEachExpression();
		if (ForEachExp != null && !ForEachExp.getPropertyValue().equals("")) {
			SynapseXPath xpath = new SynapseXPath(ForEachExp.getPropertyValue());
			Map<String, String> nameSpaceMap = ForEachExp.getNamespaces();

			for (String key : nameSpaceMap.keySet()) {
				xpath.addNamespace(key, nameSpaceMap.get(key));
			}
			forEachMediator.setExpression(xpath);
		}

		forEachMediator.setId(visualForEach.getForEachID());

		switch (visualForEach.getSequenceType()) {
		case ANONYMOUS:
			// ListMediator targetList = new AnonymousListMediator();
			SequenceMediator targetSequence = new SequenceMediator();

			TransformationInfo newInfo = new TransformationInfo();
			newInfo.setTraversalDirection(information.getTraversalDirection());
			newInfo.setSynapseConfiguration(information.getSynapseConfiguration());
			newInfo.setOriginInSequence(information.getOriginInSequence());
			newInfo.setOriginOutSequence(information.getOriginOutSequence());
			newInfo.setCurrentProxy(information.getCurrentProxy());
			newInfo.setParentSequence(targetSequence);
			doTransform(newInfo, visualForEach.getTargetOutputConnector());

			// targetSequence.addAll(targetList.getList());
			forEachMediator.setSequence(targetSequence);
			break;

		case REGISTRY_REFERENCE:
			forEachMediator.setSequenceRef(visualForEach.getSequenceKey().getKeyValue());
			break;

		case NAMED_REFERENCE:
			forEachMediator.setSequenceRef(visualForEach.getSequenceName());
			break;
		}
		return forEachMediator;
	}

	public void createSynapseObject(TransformationInfo info, EObject subject, List<Endpoint> endPoints)
			throws Exception {
	}

}
