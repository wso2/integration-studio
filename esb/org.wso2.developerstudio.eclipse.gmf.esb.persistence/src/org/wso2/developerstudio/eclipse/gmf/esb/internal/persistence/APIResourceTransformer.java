/*
 * Copyright 2012-2015 WSO2, Inc. (http://wso2.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence;

import java.util.List;

import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.apache.synapse.rest.Resource;
import org.apache.synapse.rest.dispatch.URITemplateHelper;
import org.apache.synapse.rest.dispatch.URLMappingHelper;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.wso2.developerstudio.eclipse.gmf.esb.AggregateMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.ApiResourceUrlStyle;
import org.wso2.developerstudio.eclipse.gmf.esb.BAMMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.BeanMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.BuilderMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.CacheMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.CallMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.CallTemplateMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.CalloutMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.ClassMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.CloneMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.CommandMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.ConditionalRouterMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.DBLookupMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.DBReportMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.DropMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.EJBMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.EnqueueMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.EnrichMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.EntitlementMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbElement;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.developerstudio.eclipse.gmf.esb.EventMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.FastXSLTMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.FaultMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.FilterMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.ForEachMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.HeaderMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.IterateMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.LogMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.LoopBackMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.OAuthMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.PayloadFactoryMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.PropertyMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.PublishEventMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.RMSequenceMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.RespondMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.ScriptMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.SendMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.Sequence;
import org.wso2.developerstudio.eclipse.gmf.esb.SmooksMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.SpringMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.StoreMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.SwitchMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.ThrottleMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.TransactionMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.URLRewriteMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.ValidateMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.XQueryMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.XSLTMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformationInfo;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformerException;

/**
 * Synapse API resource transformer class
 */
public class APIResourceTransformer extends AbstractEsbNodeTransformer {

	public void transform(TransformationInfo information, EsbNode subject) throws TransformerException {
		// Check subject.
		Assert.isTrue(subject instanceof org.wso2.developerstudio.eclipse.gmf.esb.APIResource, "Invalid subject.");
		org.wso2.developerstudio.eclipse.gmf.esb.APIResource visualResource = (org.wso2.developerstudio.eclipse.gmf.esb.APIResource) subject;

		if (information.getTraversalDirection() == TransformationInfo.TRAVERSAL_DIRECTION_IN) {
			Resource resource = new Resource();

			if (visualResource.getUrlStyle() == ApiResourceUrlStyle.URI_TEMPLATE
					&& visualResource.getUriTemplate() != null) {
				resource.setDispatcherHelper(new URITemplateHelper(visualResource.getUriTemplate()));
			} else if (visualResource.getUrlStyle() == ApiResourceUrlStyle.URL_MAPPING
					&& visualResource.getUrlMapping() != null) {
				resource.setDispatcherHelper(new URLMappingHelper(visualResource.getUrlMapping()));
			}

			if (visualResource.isAllowGet()) {
				resource.addMethod("GET");
			}
			if (visualResource.isAllowPost()) {
				resource.addMethod("POST");
			}
			if (visualResource.isAllowPut()) {
				resource.addMethod("PUT");
			}
			if (visualResource.isAllowDelete()) {
				resource.addMethod("DELETE");
			}
			if (visualResource.isAllowOptions()) {
				resource.addMethod("OPTIONS");
			}
			if (visualResource.isAllowHead()) {
				resource.addMethod("HEAD");
			}
			if (visualResource.isAllowPatch()) {
				resource.addMethod("PATCH");
			}
			resource.setProtocol(visualResource.getProtocol().getValue() + 1);// mapping of protocol in synapse and gmf
																				// model

			information.getCurrentAPI().addResource(resource);

			// In sequence.
			SequenceMediator inSequence = new SequenceMediator();
			switch (visualResource.getInSequenceType()) {
			case ANONYMOUS:
				resource.setInSequence(inSequence);
				break;

			case NAMED_REFERENCE:
				resource.setInSequenceKey(visualResource.getInSequenceName());
				break;

			case REGISTRY_REFERENCE:
				resource.setInSequenceKey(visualResource.getInSequenceKey().getKeyValue());
				break;
			}

			// Out sequence.
			SequenceMediator outSequence = new SequenceMediator();
			switch (visualResource.getOutSequenceType()) {
			case ANONYMOUS:
				resource.setOutSequence(outSequence);
				break;

			case NAMED_REFERENCE:
				resource.setOutSequenceKey(visualResource.getOutSequenceName());
				break;

			case REGISTRY_REFERENCE:
				resource.setOutSequenceKey(visualResource.getOutSequenceKey().getKeyValue());
				break;
			}

			information.setOriginInSequence(inSequence);
			information.setOriginOutSequence(outSequence);
			information.setParentSequence(inSequence);

			// Transform output data flow.
			doTransform(information, visualResource.getOutputConnector());

			// Transform outSequence

			information.setParentSequence(information.getOriginOutSequence());
			information.setTraversalDirection(TransformationInfo.TRAVERSAL_DIRECTION_OUT);
			doTransform(information, visualResource.getOutSequenceOutputConnector());

			// Set Fault Sequence
			SequenceMediator faultSequence = new SequenceMediator();
			switch (visualResource.getFaultSequenceType()) {
			case ANONYMOUS:
				resource.setFaultSequence(faultSequence);
				break;

			case NAMED_REFERENCE:
				resource.setFaultSequenceKey(visualResource.getFaultSequenceName());
				break;

			case REGISTRY_REFERENCE:
				resource.setFaultSequenceKey(visualResource.getFaultSequenceKey().getKeyValue());
				break;
			}

			TransformationInfo faultInfo = new TransformationInfo();
			faultInfo.setParentSequence(faultSequence);
			faultInfo.setSynapseConfiguration(information.getSynapseConfiguration());
			doTransformFaultSequence(faultInfo, getOriginNode(visualResource));
		}
	}

	public void createSynapseObject(TransformationInfo info, EObject subject, List<Endpoint> endPoints) {

	}

	public void transformWithinSequence(TransformationInfo information, EsbNode subject, SequenceMediator sequence)
			throws TransformerException {

	}

	/*
	 * Should be Reviewed and should be altered.
	 */
	private EsbNode getOriginNode(org.wso2.developerstudio.eclipse.gmf.esb.APIResource visualResource) {
		EList<EsbElement> children = visualResource.getContainer().getFaultContainer().getMediatorFlow().getChildren();
		for (int i = 0; i < children.size(); ++i) {
			if (children.get(i) instanceof AggregateMediator) {
				if (((AggregateMediator) children.get(i)).getInputConnector().getIncomingLinks().size() == 0) {
					return children.get(i);
				}
			} else if (children.get(i) instanceof CacheMediator) {
				if (((CacheMediator) children.get(i)).getInputConnector().getIncomingLinks().size() == 0) {
					return children.get(i);
				}
			} else if (children.get(i) instanceof CalloutMediator) {
				if (((CalloutMediator) children.get(i)).getInputConnector().getIncomingLinks().size() == 0) {
					return children.get(i);
				}
			} else if (children.get(i) instanceof CallTemplateMediator) {
				if (((CallTemplateMediator) children.get(i)).getInputConnector().getIncomingLinks().size() == 0) {
					return children.get(i);
				}
			} else if (children.get(i) instanceof ClassMediator) {
				if (((ClassMediator) children.get(i)).getInputConnector().getIncomingLinks().size() == 0) {
					return children.get(i);
				}
			} else if (children.get(i) instanceof CloneMediator) {
				if (((CloneMediator) children.get(i)).getInputConnector().getIncomingLinks().size() == 0) {
					return children.get(i);
				}
			} else if (children.get(i) instanceof CommandMediator) {
				if (((CommandMediator) children.get(i)).getInputConnector().getIncomingLinks().size() == 0) {
					return children.get(i);
				}
			} else if (children.get(i) instanceof DBLookupMediator) {
				if (((DBLookupMediator) children.get(i)).getInputConnector().getIncomingLinks().size() == 0){
					return children.get(i);
				}
			} else if (children.get(i) instanceof DBReportMediator) {
				if (((DBReportMediator) children.get(i)).getInputConnector().getIncomingLinks().size() == 0) {
					return children.get(i);
				}
			} else if (children.get(i) instanceof DropMediator) {
				if (((DropMediator) children.get(i)).getInputConnector().getIncomingLinks().size() == 0) {
					return children.get(i);
				}
			} else if (children.get(i) instanceof EnqueueMediator) {
				if (((EnqueueMediator) children.get(i)).getInputConnector().getIncomingLinks().size() == 0) {
					return children.get(i);
				}
			} else if (children.get(i) instanceof EnrichMediator) {
				if (((EnrichMediator) children.get(i)).getInputConnector().getIncomingLinks().size() == 0) {
					return children.get(i);
				}
			} else if (children.get(i) instanceof EntitlementMediator) {
				if (((EntitlementMediator) children.get(i)).getInputConnector().getIncomingLinks().size() == 0)
					return children.get(i);
			} else if (children.get(i) instanceof EventMediator) {
				if (((EventMediator) children.get(i)).getInputConnector().getIncomingLinks().size() == 0) {
					return children.get(i);
				}
			} else if (children.get(i) instanceof FaultMediator) {
				if (((FaultMediator) children.get(i)).getInputConnector().getIncomingLinks().size() == 0) {
					return children.get(i);
				}
			} else if (children.get(i) instanceof FilterMediator) {
				if (((FilterMediator) children.get(i)).getInputConnector().getIncomingLinks().size() == 0) {
					return children.get(i);
				}
			} else if (children.get(i) instanceof HeaderMediator) {
				if (((HeaderMediator) children.get(i)).getInputConnector().getIncomingLinks().size() == 0) {
					return children.get(i);
				}
			} else if (children.get(i) instanceof IterateMediator) {
				if (((IterateMediator) children.get(i)).getInputConnector().getIncomingLinks().size() == 0) {
					return children.get(i);
				}
			} else if (children.get(i) instanceof LogMediator) {
				if (((LogMediator) children.get(i)).getInputConnector().getIncomingLinks().size() == 0) {
					return children.get(i);
				}
			} else if (children.get(i) instanceof OAuthMediator) {
				if (((OAuthMediator) children.get(i)).getInputConnector().getIncomingLinks().size() == 0) {
					return children.get(i);
				}
			} else if (children.get(i) instanceof PayloadFactoryMediator) {
				if (((PayloadFactoryMediator) children.get(i)).getInputConnector().getIncomingLinks().size() == 0) {
					return children.get(i);
				}
			} else if (children.get(i) instanceof PropertyMediator) {
				if (((PropertyMediator) children.get(i)).getInputConnector().getIncomingLinks().size() == 0) {
					return children.get(i);
				}
			} else if (children.get(i) instanceof RMSequenceMediator) {
				if (((RMSequenceMediator) children.get(i)).getInputConnector().getIncomingLinks().size() == 0) {
					return children.get(i);
				}
			} else if (children.get(i) instanceof RuleMediator) {
				if (((RuleMediator) children.get(i)).getInputConnector().getIncomingLinks().size() == 0) {
					return children.get(i);
				}
			} else if (children.get(i) instanceof ScriptMediator) {
				if (((ScriptMediator) children.get(i)).getInputConnector().getIncomingLinks().size() == 0) {
					return children.get(i);
				}
			} else if (children.get(i) instanceof SendMediator) {
				if (((SendMediator) children.get(i)).getInputConnector().getIncomingLinks().size() == 0) {
					return children.get(i);
				}
			} else if (children.get(i) instanceof SmooksMediator) {
				if (((SmooksMediator) children.get(i)).getInputConnector().getIncomingLinks().size() == 0) {
					return children.get(i);
				}
			} else if (children.get(i) instanceof SpringMediator) {
				if (((SpringMediator) children.get(i)).getInputConnector().getIncomingLinks().size() == 0) {
					return children.get(i);
				}
			} else if (children.get(i) instanceof StoreMediator) {
				if (((StoreMediator) children.get(i)).getInputConnector().getIncomingLinks().size() == 0) {
					return children.get(i);
				}
			} else if (children.get(i) instanceof SwitchMediator) {
				if (((SwitchMediator) children.get(i)).getInputConnector().getIncomingLinks().size() == 0) {
					return children.get(i);
				}
			} else if (children.get(i) instanceof ThrottleMediator) {
				if (((ThrottleMediator) children.get(i)).getInputConnector().getIncomingLinks().size() == 0) {
					return children.get(i);
				}
			} else if (children.get(i) instanceof XQueryMediator) {
				if (((XQueryMediator) children.get(i)).getInputConnector().getIncomingLinks().size() == 0) {
					return children.get(i);
				}
			} else if (children.get(i) instanceof XSLTMediator) {
				if (((XSLTMediator) children.get(i)).getInputConnector().getIncomingLinks().size() == 0) {
					return children.get(i);
				}
			} else if (children.get(i) instanceof FastXSLTMediator) {
				if (((FastXSLTMediator) children.get(i)).getInputConnector().getIncomingLinks().size() == 0) {
					return children.get(i);
				}
			} else if (children.get(i) instanceof BAMMediator) {
				if (((BAMMediator) children.get(i)).getInputConnector().getIncomingLinks().size() == 0) {
					return children.get(i);
				}
			} else if (children.get(i) instanceof Sequence) {
				if (((Sequence) children.get(i)).getInputConnector().getIncomingLinks().size() == 0) {
					return children.get(i);
				}				
			} else if (children.get(i) instanceof CallMediator) {
				if (((CallMediator) children.get(i)).getInputConnector().getIncomingLinks().size() == 0) {
					return children.get(i);
				}
			}else if (children.get(i) instanceof LoopBackMediator) {
				if (((LoopBackMediator) children.get(i)).getInputConnector().getIncomingLinks().size() == 0) {
					return children.get(i);
				}
			}else if (children.get(i) instanceof RespondMediator) {
				if (((RespondMediator) children.get(i)).getInputConnector().getIncomingLinks().size() == 0) {
					return children.get(i);
				}
			}else if (children.get(i) instanceof ConditionalRouterMediator) {
				if (((ConditionalRouterMediator) children.get(i)).getInputConnector().getIncomingLinks().size() == 0) {
					return children.get(i);
				}
			}else if (children.get(i) instanceof ValidateMediator) {
				if (((ValidateMediator) children.get(i)).getInputConnector().getIncomingLinks().size() == 0) {
					return children.get(i);
				}
			}else if (children.get(i) instanceof BeanMediator) {
				if (((BeanMediator) children.get(i)).getInputConnector().getIncomingLinks().size() == 0) {
					return children.get(i);
				}
			}else if (children.get(i) instanceof EJBMediator) {
				if (((EJBMediator) children.get(i)).getInputConnector().getIncomingLinks().size() == 0) {
					return children.get(i);
				}
			}else if (children.get(i) instanceof URLRewriteMediator) {
				if (((URLRewriteMediator) children.get(i)).getInputConnector().getIncomingLinks().size() == 0) {
					return children.get(i);
				}
			}else if (children.get(i) instanceof TransactionMediator) {
				if (((TransactionMediator) children.get(i)).getInputConnector().getIncomingLinks().size() == 0) {
					return children.get(i);
				}
			}else if (children.get(i) instanceof ForEachMediator) {
				if (((ForEachMediator) children.get(i)).getInputConnector().getIncomingLinks().size() == 0) {
					return children.get(i);
				}
			}else if (children.get(i) instanceof BuilderMediator) {
				if (((BuilderMediator) children.get(i)).getInputConnector().getIncomingLinks().size() == 0) {
					return children.get(i);
				}
			}else if (children.get(i) instanceof PublishEventMediator) {
				if (((PublishEventMediator) children.get(i)).getInputConnector().getIncomingLinks().size() == 0) {
					return children.get(i);
				}
			}
		}
		return null;
	}

}
