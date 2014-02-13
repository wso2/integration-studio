package org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence;

import java.util.List;
import java.util.regex.Pattern;

import org.apache.synapse.SynapseArtifact;
import org.apache.synapse.config.xml.AnonymousListMediator;
import org.apache.synapse.config.xml.SwitchCase;
import org.apache.synapse.config.xml.SynapsePath;
import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.apache.synapse.util.xpath.SynapseJsonPath;
import org.apache.synapse.util.xpath.SynapseXPath;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.wso2.developerstudio.eclipse.gmf.esb.CloneMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.SwitchCaseBranchOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.SwitchMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.custom.CustomSynapsePathFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformationInfo;

public class SwitchMediatorTransformer extends AbstractEsbNodeTransformer {

	public void transform(TransformationInfo info,
			EsbNode subject) throws Exception {

		info.getParentSequence().addChild(createSwitchMediator(info,subject));		
		doTransform(info,
					((SwitchMediator) subject).getOutputConnector());
		
	}

	public void createSynapseObject(TransformationInfo info, EObject subject,
			List<Endpoint> endPoints) {
		// TODO Auto-generated method stub
		
	}


	public void transformWithinSequence(TransformationInfo information,
			EsbNode subject, SequenceMediator sequence) throws Exception {
		sequence.addChild(createSwitchMediator(information, subject));
		doTransformWithinSequence(information, ((SwitchMediator) subject)
				.getOutputConnector().getOutgoingLink(), sequence);
		
	}
	
	
	private org.apache.synapse.mediators.filters.SwitchMediator createSwitchMediator(
			TransformationInfo info, EsbNode subject) throws Exception {
		
		Assert.isTrue(subject instanceof SwitchMediator, "Invalid subject.");
		SwitchMediator visualSwitch = (SwitchMediator) subject;

		org.apache.synapse.mediators.filters.SwitchMediator switchMediator = new org.apache.synapse.mediators.filters.SwitchMediator();
		setCommonProperties(switchMediator, visualSwitch);
		
		/* NamespacedProperty sourceXPath = visualSwitch.getSourceXpath();
		 if(null!=sourceXPath.getPropertyValue()){
		 switchMediator.setSource(new
		 SynapseXPath(sourceXPath.getPropertyValue()));
		 }*/
		
		if (visualSwitch.getSourceXpath() != null
				&& !visualSwitch.getSourceXpath().getPropertyValue().equals("")) {
			SynapsePath XPath = CustomSynapsePathFactory.getSynapsePath(visualSwitch
					.getSourceXpath().getPropertyValue());
			if (visualSwitch.getSourceXpath().getNamespaces() != null
					&& !(XPath instanceof SynapseJsonPath)) {
				for (int i = 0; i < visualSwitch.getSourceXpath().getNamespaces().keySet().size(); ++i) {
					String prefix = (String) visualSwitch.getSourceXpath().getNamespaces().keySet()
							.toArray()[i];
					String namespaceUri = visualSwitch.getSourceXpath().getNamespaces().get(prefix);
					XPath.addNamespace(prefix, namespaceUri);
				}
			}

			switchMediator.setSource(XPath);
		} else {
			switchMediator.setSource(new SynapseXPath("Default:"));
		}
		

		
		

//		SwitchCase defaultCase = new SwitchCase();
//		AnonymousListMediator defaultMediator = new AnonymousListMediator();
//		defaultCase.setCaseMediator(defaultMediator);
//		// defaultCase.setRegex(Pattern.compile(""));
//		switchMediator.setDefaultCase(defaultCase);
//		doTransform(info,
//				visualSwitch.getDefaultBranch());

		for (SwitchCaseBranchOutputConnector outputConnector : visualSwitch
				.getCaseBranches()) {
			SwitchCase switchCase = new SwitchCase();
			AnonymousListMediator caseMediator = new AnonymousListMediator();
			switchCase
					.setRegex(Pattern.compile(outputConnector.getCaseRegex()));
			switchCase.setCaseMediator(caseMediator);
			switchMediator.addCase(switchCase);
			TransformationInfo newInfo = new TransformationInfo();
			//newInfo.setTraversalDirection(TransformationInfo.TRAVERSAL_DIRECTION_IN);
			newInfo.setCurrentProxy(info.getCurrentProxy());
			newInfo.setTraversalDirection(info.getTraversalDirection());
			newInfo.setSynapseConfiguration(info.getSynapseConfiguration());
			newInfo.setOriginInSequence(info.getOriginInSequence());
			newInfo.setOriginOutSequence(info.getOriginOutSequence());
			newInfo.setParentSequence(caseMediator);
			doTransform(newInfo, outputConnector);
		}
		
		SwitchCase switchCase = new SwitchCase();
		AnonymousListMediator caseMediator = new AnonymousListMediator();
		switchCase.setCaseMediator(caseMediator);
		switchMediator.setDefaultCase(switchCase);
		TransformationInfo newInfo = new TransformationInfo();
		//newInfo.setTraversalDirection(TransformationInfo.TRAVERSAL_DIRECTION_IN);
		newInfo.setCurrentProxy(info.getCurrentProxy());
		newInfo.setTraversalDirection(info.getTraversalDirection());
		newInfo.setSynapseConfiguration(info.getSynapseConfiguration());
		newInfo.setOriginInSequence(info.getOriginInSequence());
		newInfo.setOriginOutSequence(info.getOriginOutSequence());
		newInfo.setParentSequence(caseMediator);
		doTransform(newInfo, visualSwitch.getDefaultBranch());
		
		return switchMediator;
	}
}
