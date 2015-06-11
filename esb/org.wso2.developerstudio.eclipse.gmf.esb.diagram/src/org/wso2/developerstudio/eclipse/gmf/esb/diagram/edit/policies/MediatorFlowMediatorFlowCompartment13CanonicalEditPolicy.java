package org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.policies;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.DeferredLayoutCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetViewMutabilityCommand;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.APIResourceEndpointEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.AddressEndPointEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.AddressingEndpointEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.AggregateMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.BAMMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.BeanMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.BuilderMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.CacheMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.CallMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.CallTemplateMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.CalloutMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.ClassMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.CloneMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.CloudConnectorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.CloudConnectorOperationEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.CommandMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.ConditionalRouterMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.DBLookupMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.DBReportMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.DataMapperMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.DefaultEndPointEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.DropMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.EJBMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.EnqueueMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.EnrichMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.EntitlementMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.EventMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.FailoverEndPointEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.FastXSLTMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.FaultMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.FilterMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.ForEachMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.HTTPEndpointEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.HeaderMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.IterateMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.LoadBalanceEndPointEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.LogMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.LoopBackMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.NamedEndpointEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.OAuthMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.PayloadFactoryMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.PropertyMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.PublishEventMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.RMSequenceMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.RecipientListEndPointEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.RespondMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.RouterMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.RuleMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.ScriptMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.SendMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.SequenceEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.SmooksMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.SpringMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.StoreMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.SwitchMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.TemplateEndpointEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.ThrottleMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.TransactionMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.URLRewriteMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.ValidateMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.WSDLEndPointEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.XQueryMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.XSLTMediatorEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbDiagramUpdater;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbNodeDescriptor;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbVisualIDRegistry;

/**
 * @generated
 */
public class MediatorFlowMediatorFlowCompartment13CanonicalEditPolicy extends CanonicalEditPolicy {

	/**
	 * @generated
	 */
	protected void refreshOnActivate() {
		// Need to activate editpart children before invoking the canonical refresh for EditParts to add event listeners
		List<?> c = getHost().getChildren();
		for (int i = 0; i < c.size(); i++) {
			((EditPart) c.get(i)).activate();
		}
		super.refreshOnActivate();
	}

	/**
	 * @generated
	 */
	protected EStructuralFeature getFeatureToSynchronize() {
		return EsbPackage.eINSTANCE.getMediatorFlow_Children();
	}

	/**
	 * @generated
	 */
	@SuppressWarnings("rawtypes")
	protected List getSemanticChildrenList() {
		View viewObject = (View) getHost().getModel();
		LinkedList<EObject> result = new LinkedList<EObject>();
		List<EsbNodeDescriptor> childDescriptors = EsbDiagramUpdater
				.getMediatorFlowMediatorFlowCompartment_7036SemanticChildren(viewObject);
		for (EsbNodeDescriptor d : childDescriptors) {
			result.add(d.getModelElement());
		}
		return result;
	}

	/**
	 * @generated
	 */
	protected boolean isOrphaned(Collection<EObject> semanticChildren, final View view) {
		return isMyDiagramElement(view) && !semanticChildren.contains(view.getElement());
	}

	/**
	 * @generated
	 */
	private boolean isMyDiagramElement(View view) {
		int visualID = EsbVisualIDRegistry.getVisualID(view);
		switch (visualID) {
		case DropMediatorEditPart.VISUAL_ID:
		case PropertyMediatorEditPart.VISUAL_ID:
		case ThrottleMediatorEditPart.VISUAL_ID:
		case FilterMediatorEditPart.VISUAL_ID:
		case LogMediatorEditPart.VISUAL_ID:
		case EnrichMediatorEditPart.VISUAL_ID:
		case XSLTMediatorEditPart.VISUAL_ID:
		case SwitchMediatorEditPart.VISUAL_ID:
		case SequenceEditPart.VISUAL_ID:
		case EventMediatorEditPart.VISUAL_ID:
		case EntitlementMediatorEditPart.VISUAL_ID:
		case ClassMediatorEditPart.VISUAL_ID:
		case SpringMediatorEditPart.VISUAL_ID:
		case ScriptMediatorEditPart.VISUAL_ID:
		case FaultMediatorEditPart.VISUAL_ID:
		case XQueryMediatorEditPart.VISUAL_ID:
		case CommandMediatorEditPart.VISUAL_ID:
		case DBLookupMediatorEditPart.VISUAL_ID:
		case DBReportMediatorEditPart.VISUAL_ID:
		case SmooksMediatorEditPart.VISUAL_ID:
		case SendMediatorEditPart.VISUAL_ID:
		case HeaderMediatorEditPart.VISUAL_ID:
		case CloneMediatorEditPart.VISUAL_ID:
		case CacheMediatorEditPart.VISUAL_ID:
		case IterateMediatorEditPart.VISUAL_ID:
		case CalloutMediatorEditPart.VISUAL_ID:
		case TransactionMediatorEditPart.VISUAL_ID:
		case RMSequenceMediatorEditPart.VISUAL_ID:
		case RuleMediatorEditPart.VISUAL_ID:
		case OAuthMediatorEditPart.VISUAL_ID:
		case AggregateMediatorEditPart.VISUAL_ID:
		case StoreMediatorEditPart.VISUAL_ID:
		case BuilderMediatorEditPart.VISUAL_ID:
		case CallTemplateMediatorEditPart.VISUAL_ID:
		case PayloadFactoryMediatorEditPart.VISUAL_ID:
		case EnqueueMediatorEditPart.VISUAL_ID:
		case URLRewriteMediatorEditPart.VISUAL_ID:
		case ValidateMediatorEditPart.VISUAL_ID:
		case RouterMediatorEditPart.VISUAL_ID:
		case ConditionalRouterMediatorEditPart.VISUAL_ID:
		case BAMMediatorEditPart.VISUAL_ID:
		case BeanMediatorEditPart.VISUAL_ID:
		case EJBMediatorEditPart.VISUAL_ID:
		case DefaultEndPointEditPart.VISUAL_ID:
		case AddressEndPointEditPart.VISUAL_ID:
		case FailoverEndPointEditPart.VISUAL_ID:
		case RecipientListEndPointEditPart.VISUAL_ID:
		case WSDLEndPointEditPart.VISUAL_ID:
		case NamedEndpointEditPart.VISUAL_ID:
		case LoadBalanceEndPointEditPart.VISUAL_ID:
		case APIResourceEndpointEditPart.VISUAL_ID:
		case AddressingEndpointEditPart.VISUAL_ID:
		case HTTPEndpointEditPart.VISUAL_ID:
		case TemplateEndpointEditPart.VISUAL_ID:
		case CloudConnectorEditPart.VISUAL_ID:
		case CloudConnectorOperationEditPart.VISUAL_ID:
		case LoopBackMediatorEditPart.VISUAL_ID:
		case RespondMediatorEditPart.VISUAL_ID:
		case CallMediatorEditPart.VISUAL_ID:
		case DataMapperMediatorEditPart.VISUAL_ID:
		case FastXSLTMediatorEditPart.VISUAL_ID:
		case ForEachMediatorEditPart.VISUAL_ID:
		case PublishEventMediatorEditPart.VISUAL_ID:
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected void refreshSemantic() {
		if (resolveSemanticElement() == null) {
			return;
		}
		LinkedList<IAdaptable> createdViews = new LinkedList<IAdaptable>();
		List<EsbNodeDescriptor> childDescriptors = EsbDiagramUpdater
				.getMediatorFlowMediatorFlowCompartment_7036SemanticChildren((View) getHost().getModel());
		LinkedList<View> orphaned = new LinkedList<View>();
		// we care to check only views we recognize as ours
		LinkedList<View> knownViewChildren = new LinkedList<View>();
		for (View v : getViewChildren()) {
			if (isMyDiagramElement(v)) {
				knownViewChildren.add(v);
			}
		}
		// alternative to #cleanCanonicalSemanticChildren(getViewChildren(), semanticChildren)
		//
		// iteration happens over list of desired semantic elements, trying to find best matching View, while original CEP
		// iterates views, potentially losing view (size/bounds) information - i.e. if there are few views to reference same EObject, only last one 
		// to answer isOrphaned == true will be used for the domain element representation, see #cleanCanonicalSemanticChildren()
		for (Iterator<EsbNodeDescriptor> descriptorsIterator = childDescriptors.iterator(); descriptorsIterator
				.hasNext();) {
			EsbNodeDescriptor next = descriptorsIterator.next();
			String hint = EsbVisualIDRegistry.getType(next.getVisualID());
			LinkedList<View> perfectMatch = new LinkedList<View>(); // both semanticElement and hint match that of NodeDescriptor
			for (View childView : getViewChildren()) {
				EObject semanticElement = childView.getElement();
				if (next.getModelElement().equals(semanticElement)) {
					if (hint.equals(childView.getType())) {
						perfectMatch.add(childView);
						// actually, can stop iteration over view children here, but
						// may want to use not the first view but last one as a 'real' match (the way original CEP does
						// with its trick with viewToSemanticMap inside #cleanCanonicalSemanticChildren
					}
				}
			}
			if (perfectMatch.size() > 0) {
				descriptorsIterator.remove(); // precise match found no need to create anything for the NodeDescriptor
				// use only one view (first or last?), keep rest as orphaned for further consideration
				knownViewChildren.remove(perfectMatch.getFirst());
			}
		}
		// those left in knownViewChildren are subject to removal - they are our diagram elements we didn't find match to,
		// or those we have potential matches to, and thus need to be recreated, preserving size/location information.
		orphaned.addAll(knownViewChildren);
		//
		ArrayList<CreateViewRequest.ViewDescriptor> viewDescriptors = new ArrayList<CreateViewRequest.ViewDescriptor>(
				childDescriptors.size());
		for (EsbNodeDescriptor next : childDescriptors) {
			String hint = EsbVisualIDRegistry.getType(next.getVisualID());
			IAdaptable elementAdapter = new CanonicalElementAdapter(next.getModelElement(), hint);
			CreateViewRequest.ViewDescriptor descriptor = new CreateViewRequest.ViewDescriptor(elementAdapter,
					Node.class, hint, ViewUtil.APPEND, false, host().getDiagramPreferencesHint());
			viewDescriptors.add(descriptor);
		}

		boolean changed = deleteViews(orphaned.iterator());
		//
		CreateViewRequest request = getCreateViewRequest(viewDescriptors);
		Command cmd = getCreateViewCommand(request);
		if (cmd != null && cmd.canExecute()) {
			SetViewMutabilityCommand.makeMutable(new EObjectAdapter(host().getNotationView())).execute();
			executeCommand(cmd);
			@SuppressWarnings("unchecked")
			List<IAdaptable> nl = (List<IAdaptable>) request.getNewObject();
			createdViews.addAll(nl);
		}
		if (changed || createdViews.size() > 0) {
			postProcessRefreshSemantic(createdViews);
		}
		if (createdViews.size() > 1) {
			// perform a layout of the container
			DeferredLayoutCommand layoutCmd = new DeferredLayoutCommand(host().getEditingDomain(), createdViews, host());
			executeCommand(new ICommandProxy(layoutCmd));
		}

		makeViewsImmutable(createdViews);
	}
}
