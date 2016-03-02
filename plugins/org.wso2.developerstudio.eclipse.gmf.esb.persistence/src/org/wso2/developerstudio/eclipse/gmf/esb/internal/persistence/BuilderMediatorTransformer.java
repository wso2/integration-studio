package org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence;

import java.util.List;

import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.wso2.developerstudio.eclipse.gmf.esb.BuilderMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.custom.BuilderMediatorExt;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformationInfo;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformerException;

public class BuilderMediatorTransformer extends AbstractEsbNodeTransformer {

	public void transform(TransformationInfo information, EsbNode subject)
			throws TransformerException {
		information.getParentSequence().addChild(
				createBuilderMediator(subject, information));

		doTransform(information,
				((BuilderMediator) subject).getOutputConnector());

	}

	public void createSynapseObject(TransformationInfo info, EObject subject,
			List<Endpoint> endPoints) {

	}

	public void transformWithinSequence(TransformationInfo information,
			EsbNode subject, SequenceMediator sequence) throws TransformerException {
		sequence.addChild(createBuilderMediator(subject, information));
		doTransformWithinSequence(information, ((BuilderMediator) subject)
				.getOutputConnector().getOutgoingLink(), sequence);

	}

	private org.wso2.carbon.relay.mediators.builder.BuilderMediator createBuilderMediator(
			EsbNode subject, TransformationInfo information) throws TransformerException {

		/*
		 * Check subject.
		 */
		Assert.isTrue(subject instanceof BuilderMediator, "Invalid subject.");
		BuilderMediator vishualBuilderMediator = (BuilderMediator) subject;

		BuilderMediatorExt builderExt = new BuilderMediatorExt();
		setCommonProperties(builderExt, vishualBuilderMediator);

		if (vishualBuilderMediator.getMessageBuilders() != null
				&& !vishualBuilderMediator.getMessageBuilders().isEmpty()) {

			builderExt.setMessageBuilderList(vishualBuilderMediator
					.getMessageBuilders());

		}
		return builderExt;

	}

}
