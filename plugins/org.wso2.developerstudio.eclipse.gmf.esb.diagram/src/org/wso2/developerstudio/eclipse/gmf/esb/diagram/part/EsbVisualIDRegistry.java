package org.wso2.developerstudio.eclipse.gmf.esb.diagram.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.structure.DiagramStructure;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbDiagram;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.*;

/**
 * This registry is used to determine which type of visual object should be
 * created for the corresponding Diagram, Node, ChildNode or Link represented
 * by a domain model object.
 * 
 * @generated
 */
public class EsbVisualIDRegistry {

	/**
	 * @generated
	 */
	private static final String DEBUG_KEY = "org.wso2.developerstudio.eclipse.gmf.esb.diagram/debug/visualID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (EsbDiagramEditPart.MODEL_ID.equals(view.getType())) {
				return EsbDiagramEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbVisualIDRegistry.getVisualID(view.getType());
	}

	/**
	 * @generated
	 */
	public static String getModelID(View view) {
		View diagram = view.getDiagram();
		while (view != diagram) {
			EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
			if (annotation != null) {
				return (String) annotation.getDetails().get("modelID"); //$NON-NLS-1$
			}
			view = (View) view.eContainer();
		}
		return diagram != null ? diagram.getType() : null;
	}

	/**
	 * @generated
	 */
	public static int getVisualID(String type) {
		try {
			return Integer.parseInt(type);
		} catch (NumberFormatException e) {
			if (Boolean.TRUE.toString().equalsIgnoreCase(Platform.getDebugOption(DEBUG_KEY))) {
				EsbDiagramEditorPlugin.getInstance()
						.logError("Unable to parse view type as a visualID number: " + type);
			}
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static String getType(int visualID) {
		return Integer.toString(visualID);
	}

	/**
	 * @generated
	 */
	public static int getDiagramVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		if (EsbPackage.eINSTANCE.getEsbDiagram().isSuperTypeOf(domainElement.eClass())
				&& isDiagram((EsbDiagram) domainElement)) {
			return EsbDiagramEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static int getNodeVisualID(View containerView, EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		String containerModelID = org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbVisualIDRegistry
				.getModelID(containerView);
		if (!EsbDiagramEditPart.MODEL_ID.equals(containerModelID)) {
			return -1;
		}
		int containerVisualID;
		if (EsbDiagramEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = EsbDiagramEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch (containerVisualID) {
		case EsbDiagramEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getEsbServer().isSuperTypeOf(domainElement.eClass())) {
				return EsbServerEditPart.VISUAL_ID;
			}
			break;
		case EsbServerEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getMessageMediator().isSuperTypeOf(domainElement.eClass())) {
				return MessageMediatorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getEndpointDiagram().isSuperTypeOf(domainElement.eClass())) {
				return EndpointDiagramEditPart.VISUAL_ID;
			}
			break;
		case ProxyServiceEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getProxyOutputConnector().isSuperTypeOf(domainElement.eClass())) {
				return ProxyOutputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getProxyInputConnector().isSuperTypeOf(domainElement.eClass())) {
				return ProxyInputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getProxyOutSequenceOutputConnector().isSuperTypeOf(domainElement.eClass())) {
				return ProxyOutSequenceOutputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getProxyFaultInputConnector().isSuperTypeOf(domainElement.eClass())) {
				return ProxyFaultInputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getProxyServiceContainer().isSuperTypeOf(domainElement.eClass())) {
				return ProxyServiceContainerEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getProxyInSequenceInputConnector().isSuperTypeOf(domainElement.eClass())) {
				return ProxyInSequenceInputConnectorEditPart.VISUAL_ID;
			}
			break;
		case ProxyServiceContainerEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getProxyServiceSequenceAndEndpointContainer()
					.isSuperTypeOf(domainElement.eClass())) {
				return ProxyServiceSequenceAndEndpointContainerEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getProxyServiceFaultContainer().isSuperTypeOf(domainElement.eClass())) {
				return ProxyServiceFaultContainerEditPart.VISUAL_ID;
			}
			break;
		case ProxyServiceSequenceAndEndpointContainerEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getMediatorFlow().isSuperTypeOf(domainElement.eClass())) {
				return MediatorFlowEditPart.VISUAL_ID;
			}
			break;
		case DropMediatorEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getDropMediatorInputConnector().isSuperTypeOf(domainElement.eClass())) {
				return DropMediatorInputConnectorEditPart.VISUAL_ID;
			}
			break;
		case PropertyMediatorEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getPropertyMediatorInputConnector().isSuperTypeOf(domainElement.eClass())) {
				return PropertyMediatorInputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getPropertyMediatorOutputConnector().isSuperTypeOf(domainElement.eClass())) {
				return PropertyMediatorOutputConnectorEditPart.VISUAL_ID;
			}
			break;
		case ThrottleMediatorEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getThrottleMediatorInputConnector().isSuperTypeOf(domainElement.eClass())) {
				return ThrottleMediatorInputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getThrottleMediatorOutputConnector().isSuperTypeOf(domainElement.eClass())) {
				return ThrottleMediatorOutputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getThrottleMediatorOnAcceptOutputConnector().isSuperTypeOf(domainElement.eClass())) {
				return ThrottleMediatorOnAcceptOutputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getThrottleMediatorOnRejectOutputConnector().isSuperTypeOf(domainElement.eClass())) {
				return ThrottleMediatorOnRejectOutputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getThrottleContainer().isSuperTypeOf(domainElement.eClass())) {
				return ThrottleContainerEditPart.VISUAL_ID;
			}
			break;
		case ThrottleContainerEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getThrottleOnAcceptContainer().isSuperTypeOf(domainElement.eClass())) {
				return ThrottleOnAcceptContainerEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getThrottleOnRejectContainer().isSuperTypeOf(domainElement.eClass())) {
				return ThrottleOnRejectContainerEditPart.VISUAL_ID;
			}
			break;
		case ThrottleOnAcceptContainerEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getMediatorFlow().isSuperTypeOf(domainElement.eClass())) {
				return MediatorFlow9EditPart.VISUAL_ID;
			}
			break;
		case FilterMediatorEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getFilterMediatorInputConnector().isSuperTypeOf(domainElement.eClass())) {
				return FilterMediatorInputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getFilterMediatorOutputConnector().isSuperTypeOf(domainElement.eClass())) {
				return FilterMediatorOutputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getFilterMediatorPassOutputConnector().isSuperTypeOf(domainElement.eClass())) {
				return FilterMediatorPassOutputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getFilterMediatorFailOutputConnector().isSuperTypeOf(domainElement.eClass())) {
				return FilterMediatorFailOutputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getFilterContainer().isSuperTypeOf(domainElement.eClass())) {
				return FilterContainerEditPart.VISUAL_ID;
			}
			break;
		case FilterContainerEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getFilterPassContainer().isSuperTypeOf(domainElement.eClass())) {
				return FilterPassContainerEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getFilterFailContainer().isSuperTypeOf(domainElement.eClass())) {
				return FilterFailContainerEditPart.VISUAL_ID;
			}
			break;
		case FilterPassContainerEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getMediatorFlow().isSuperTypeOf(domainElement.eClass())) {
				return MediatorFlow7EditPart.VISUAL_ID;
			}
			break;
		case LogMediatorEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getLogMediatorInputConnector().isSuperTypeOf(domainElement.eClass())) {
				return LogMediatorInputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getLogMediatorOutputConnector().isSuperTypeOf(domainElement.eClass())) {
				return LogMediatorOutputConnectorEditPart.VISUAL_ID;
			}
			break;
		case EnrichMediatorEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getEnrichMediatorInputConnector().isSuperTypeOf(domainElement.eClass())) {
				return EnrichMediatorInputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getEnrichMediatorOutputConnector().isSuperTypeOf(domainElement.eClass())) {
				return EnrichMediatorOutputConnectorEditPart.VISUAL_ID;
			}
			break;
		case XSLTMediatorEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getXSLTMediatorInputConnector().isSuperTypeOf(domainElement.eClass())) {
				return XSLTMediatorInputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getXSLTMediatorOutputConnector().isSuperTypeOf(domainElement.eClass())) {
				return XSLTMediatorOutputConnectorEditPart.VISUAL_ID;
			}
			break;
		case SwitchMediatorEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getSwitchMediatorInputConnector().isSuperTypeOf(domainElement.eClass())) {
				return SwitchMediatorInputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getSwitchMediatorOutputConnector().isSuperTypeOf(domainElement.eClass())) {
				return SwitchMediatorOutputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getSwitchCaseBranchOutputConnector().isSuperTypeOf(domainElement.eClass())) {
				return SwitchCaseBranchOutputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getSwitchDefaultBranchOutputConnector().isSuperTypeOf(domainElement.eClass())) {
				return SwitchDefaultBranchOutputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getSwitchMediatorContainer().isSuperTypeOf(domainElement.eClass())) {
				return SwitchMediatorContainerEditPart.VISUAL_ID;
			}
			break;
		case SwitchMediatorContainerEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getSwitchCaseParentContainer().isSuperTypeOf(domainElement.eClass())) {
				return SwitchCaseParentContainerEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getSwitchDefaultParentContainer().isSuperTypeOf(domainElement.eClass())) {
				return SwitchDefaultParentContainerEditPart.VISUAL_ID;
			}
			break;
		case SwitchCaseParentContainerEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getSwitchCaseContainer().isSuperTypeOf(domainElement.eClass())) {
				return SwitchCaseContainerEditPart.VISUAL_ID;
			}
			break;
		case SwitchCaseContainerEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getMediatorFlow().isSuperTypeOf(domainElement.eClass())) {
				return MediatorFlow2EditPart.VISUAL_ID;
			}
			break;
		case SequenceEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getSequenceInputConnector().isSuperTypeOf(domainElement.eClass())) {
				return SequenceInputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getSequenceOutputConnector().isSuperTypeOf(domainElement.eClass())) {
				return SequenceOutputConnectorEditPart.VISUAL_ID;
			}
			break;
		case EventMediatorEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getEventMediatorInputConnector().isSuperTypeOf(domainElement.eClass())) {
				return EventMediatorInputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getEventMediatorOutputConnector().isSuperTypeOf(domainElement.eClass())) {
				return EventMediatorOutputConnectorEditPart.VISUAL_ID;
			}
			break;
		case EntitlementMediatorEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getEntitlementMediatorInputConnector().isSuperTypeOf(domainElement.eClass())) {
				return EntitlementMediatorInputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getEntitlementMediatorOutputConnector().isSuperTypeOf(domainElement.eClass())) {
				return EntitlementMediatorOutputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getEntitlementMediatorOnRejectOutputConnector().isSuperTypeOf(
					domainElement.eClass())) {
				return EntitlementMediatorOnRejectOutputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getEntitlementMediatorOnAcceptOutputConnector().isSuperTypeOf(
					domainElement.eClass())) {
				return EntitlementMediatorOnAcceptOutputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getEntitlementMediatorAdviceOutputConnector()
					.isSuperTypeOf(domainElement.eClass())) {
				return EntitlementMediatorAdviceOutputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getEntitlementMediatorObligationsOutputConnector().isSuperTypeOf(
					domainElement.eClass())) {
				return EntitlementMediatorObligationsOutputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getEntitlementContainer().isSuperTypeOf(domainElement.eClass())) {
				return EntitlementContainerEditPart.VISUAL_ID;
			}
			break;
		case EntitlementContainerEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getEntitlementOnRejectContainer().isSuperTypeOf(domainElement.eClass())) {
				return EntitlementOnRejectContainerEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getEntitlementOnAcceptContainer().isSuperTypeOf(domainElement.eClass())) {
				return EntitlementOnAcceptContainerEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getEntitlementAdviceContainer().isSuperTypeOf(domainElement.eClass())) {
				return EntitlementAdviceContainerEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getEntitlementObligationsContainer().isSuperTypeOf(domainElement.eClass())) {
				return EntitlementObligationsContainerEditPart.VISUAL_ID;
			}
			break;
		case EntitlementOnRejectContainerEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getMediatorFlow().isSuperTypeOf(domainElement.eClass())) {
				return MediatorFlow21EditPart.VISUAL_ID;
			}
			break;
		case ClassMediatorEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getClassMediatorInputConnector().isSuperTypeOf(domainElement.eClass())) {
				return ClassMediatorInputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getClassMediatorOutputConnector().isSuperTypeOf(domainElement.eClass())) {
				return ClassMediatorOutputConnectorEditPart.VISUAL_ID;
			}
			break;
		case SpringMediatorEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getSpringMediatorInputConnector().isSuperTypeOf(domainElement.eClass())) {
				return SpringMediatorInputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getSpringMediatorOutputConnector().isSuperTypeOf(domainElement.eClass())) {
				return SpringMediatorOutputConnectorEditPart.VISUAL_ID;
			}
			break;
		case ScriptMediatorEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getScriptMediatorInputConnector().isSuperTypeOf(domainElement.eClass())) {
				return ScriptMediatorInputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getScriptMediatorOutputConnector().isSuperTypeOf(domainElement.eClass())) {
				return ScriptMediatorOutputConnectorEditPart.VISUAL_ID;
			}
			break;
		case FaultMediatorEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getFaultMediatorInputConnector().isSuperTypeOf(domainElement.eClass())) {
				return FaultMediatorInputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getFaultMediatorOutputConnector().isSuperTypeOf(domainElement.eClass())) {
				return FaultMediatorOutputConnectorEditPart.VISUAL_ID;
			}
			break;
		case XQueryMediatorEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getXQueryMediatorInputConnector().isSuperTypeOf(domainElement.eClass())) {
				return XQueryMediatorInputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getXQueryMediatorOutputConnector().isSuperTypeOf(domainElement.eClass())) {
				return XQueryMediatorOutputConnectorEditPart.VISUAL_ID;
			}
			break;
		case CommandMediatorEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getCommandMediatorInputConnector().isSuperTypeOf(domainElement.eClass())) {
				return CommandMediatorInputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getCommandMediatorOutputConnector().isSuperTypeOf(domainElement.eClass())) {
				return CommandMediatorOutputConnectorEditPart.VISUAL_ID;
			}
			break;
		case DBLookupMediatorEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getDBLookupMediatorInputConnector().isSuperTypeOf(domainElement.eClass())) {
				return DBLookupMediatorInputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getDBLookupMediatorOutputConnector().isSuperTypeOf(domainElement.eClass())) {
				return DBLookupMediatorOutputConnectorEditPart.VISUAL_ID;
			}
			break;
		case DBReportMediatorEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getDBReportMediatorInputConnector().isSuperTypeOf(domainElement.eClass())) {
				return DBReportMediatorInputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getDBReportMediatorOutputConnector().isSuperTypeOf(domainElement.eClass())) {
				return DBReportMediatorOutputConnectorEditPart.VISUAL_ID;
			}
			break;
		case SmooksMediatorEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getSmooksMediatorInputConnector().isSuperTypeOf(domainElement.eClass())) {
				return SmooksMediatorInputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getSmooksMediatorOutputConnector().isSuperTypeOf(domainElement.eClass())) {
				return SmooksMediatorOutputConnectorEditPart.VISUAL_ID;
			}
			break;
		case SendMediatorEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getSendMediatorInputConnector().isSuperTypeOf(domainElement.eClass())) {
				return SendMediatorInputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getSendMediatorOutputConnector().isSuperTypeOf(domainElement.eClass())) {
				return SendMediatorOutputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getSendMediatorEndpointOutputConnector().isSuperTypeOf(domainElement.eClass())) {
				return SendMediatorEndpointOutputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getMediatorFlow().isSuperTypeOf(domainElement.eClass())) {
				return MediatorFlow19EditPart.VISUAL_ID;
			}
			break;
		case HeaderMediatorEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getHeaderMediatorInputConnector().isSuperTypeOf(domainElement.eClass())) {
				return HeaderMediatorInputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getHeaderMediatorOutputConnector().isSuperTypeOf(domainElement.eClass())) {
				return HeaderMediatorOutputConnectorEditPart.VISUAL_ID;
			}
			break;
		case CloneMediatorEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getCloneMediatorInputConnector().isSuperTypeOf(domainElement.eClass())) {
				return CloneMediatorInputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getCloneMediatorOutputConnector().isSuperTypeOf(domainElement.eClass())) {
				return CloneMediatorOutputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getCloneMediatorTargetOutputConnector().isSuperTypeOf(domainElement.eClass())) {
				return CloneMediatorTargetOutputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getCloneMediatorContainer().isSuperTypeOf(domainElement.eClass())) {
				return CloneMediatorContainerEditPart.VISUAL_ID;
			}
			break;
		case CloneMediatorContainerEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getCloneTargetContainer().isSuperTypeOf(domainElement.eClass())) {
				return CloneTargetContainerEditPart.VISUAL_ID;
			}
			break;
		case CloneTargetContainerEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getMediatorFlow().isSuperTypeOf(domainElement.eClass())) {
				return MediatorFlow11EditPart.VISUAL_ID;
			}
			break;
		case CacheMediatorEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getCacheMediatorInputConnector().isSuperTypeOf(domainElement.eClass())) {
				return CacheMediatorInputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getCacheMediatorOutputConnector().isSuperTypeOf(domainElement.eClass())) {
				return CacheMediatorOutputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getCacheMediatorOnHitOutputConnector().isSuperTypeOf(domainElement.eClass())) {
				return CacheMediatorOnHitOutputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getMediatorFlow().isSuperTypeOf(domainElement.eClass())) {
				return MediatorFlow13EditPart.VISUAL_ID;
			}
			break;
		case IterateMediatorEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getIterateMediatorInputConnector().isSuperTypeOf(domainElement.eClass())) {
				return IterateMediatorInputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getIterateMediatorOutputConnector().isSuperTypeOf(domainElement.eClass())) {
				return IterateMediatorOutputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getIterateMediatorTargetOutputConnector().isSuperTypeOf(domainElement.eClass())) {
				return IterateMediatorTargetOutputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getMediatorFlow().isSuperTypeOf(domainElement.eClass())) {
				return MediatorFlow12EditPart.VISUAL_ID;
			}
			break;
		case CalloutMediatorEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getCalloutMediatorInputConnector().isSuperTypeOf(domainElement.eClass())) {
				return CalloutMediatorInputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getCalloutMediatorOutputConnector().isSuperTypeOf(domainElement.eClass())) {
				return CalloutMediatorOutputConnectorEditPart.VISUAL_ID;
			}
			break;
		case TransactionMediatorEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getTransactionMediatorInputConnector().isSuperTypeOf(domainElement.eClass())) {
				return TransactionMediatorInputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getTransactionMediatorOutputConnector().isSuperTypeOf(domainElement.eClass())) {
				return TransactionMediatorOutputConnectorEditPart.VISUAL_ID;
			}
			break;
		case RMSequenceMediatorEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getRMSequenceMediatorInputConnector().isSuperTypeOf(domainElement.eClass())) {
				return RMSequenceMediatorInputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getRMSequenceMediatorOutputConnector().isSuperTypeOf(domainElement.eClass())) {
				return RMSequenceMediatorOutputConnectorEditPart.VISUAL_ID;
			}
			break;
		case RuleMediatorEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getRuleMediatorInputConnector().isSuperTypeOf(domainElement.eClass())) {
				return RuleMediatorInputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getRuleMediatorOutputConnector().isSuperTypeOf(domainElement.eClass())) {
				return RuleMediatorOutputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getRuleMediatorChildMediatorsOutputConnector().isSuperTypeOf(
					domainElement.eClass())) {
				return RuleMediatorChildMediatorsOutputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getMediatorFlow().isSuperTypeOf(domainElement.eClass())) {
				return MediatorFlow17EditPart.VISUAL_ID;
			}
			break;
		case OAuthMediatorEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getOAuthMediatorInputConnector().isSuperTypeOf(domainElement.eClass())) {
				return OAuthMediatorInputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getOAuthMediatorOutputConnector().isSuperTypeOf(domainElement.eClass())) {
				return OAuthMediatorOutputConnectorEditPart.VISUAL_ID;
			}
			break;
		case AggregateMediatorEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getAggregateMediatorInputConnector().isSuperTypeOf(domainElement.eClass())) {
				return AggregateMediatorInputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getAggregateMediatorOutputConnector().isSuperTypeOf(domainElement.eClass())) {
				return AggregateMediatorOutputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getAggregateMediatorOnCompleteOutputConnector().isSuperTypeOf(
					domainElement.eClass())) {
				return AggregateMediatorOnCompleteOutputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getMediatorFlow().isSuperTypeOf(domainElement.eClass())) {
				return MediatorFlow3EditPart.VISUAL_ID;
			}
			break;
		case StoreMediatorEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getStoreMediatorInputConnector().isSuperTypeOf(domainElement.eClass())) {
				return StoreMediatorInputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getStoreMediatorOutputConnector().isSuperTypeOf(domainElement.eClass())) {
				return StoreMediatorOutputConnectorEditPart.VISUAL_ID;
			}
			break;
		case BuilderMediatorEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getBuilderMediatorInputConnector().isSuperTypeOf(domainElement.eClass())) {
				return BuilderMediatorInputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getBuilderMediatorOutputConector().isSuperTypeOf(domainElement.eClass())) {
				return BuilderMediatorOutputConectorEditPart.VISUAL_ID;
			}
			break;
		case CallTemplateMediatorEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getCallTemplateMediatorInputConnector().isSuperTypeOf(domainElement.eClass())) {
				return CallTemplateMediatorInputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getCallTemplateMediatorOutputConnector().isSuperTypeOf(domainElement.eClass())) {
				return CallTemplateMediatorOutputConnectorEditPart.VISUAL_ID;
			}
			break;
		case PayloadFactoryMediatorEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getPayloadFactoryMediatorInputConnector().isSuperTypeOf(domainElement.eClass())) {
				return PayloadFactoryMediatorInputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getPayloadFactoryMediatorOutputConnector().isSuperTypeOf(domainElement.eClass())) {
				return PayloadFactoryMediatorOutputConnectorEditPart.VISUAL_ID;
			}
			break;
		case EnqueueMediatorEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getEnqueueMediatorInputConnector().isSuperTypeOf(domainElement.eClass())) {
				return EnqueueMediatorInputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getEnqueueMediatorOutputConnector().isSuperTypeOf(domainElement.eClass())) {
				return EnqueueMediatorOutputConnectorEditPart.VISUAL_ID;
			}
			break;
		case URLRewriteMediatorEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getURLRewriteMediatorInputConnector().isSuperTypeOf(domainElement.eClass())) {
				return URLRewriteMediatorInputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getURLRewriteMediatorOutputConnector().isSuperTypeOf(domainElement.eClass())) {
				return URLRewriteMediatorOutputConnectorEditPart.VISUAL_ID;
			}
			break;
		case ValidateMediatorEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getValidateMediatorInputConnector().isSuperTypeOf(domainElement.eClass())) {
				return ValidateMediatorInputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getValidateMediatorOutputConnector().isSuperTypeOf(domainElement.eClass())) {
				return ValidateMediatorOutputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getValidateMediatorOnFailOutputConnector().isSuperTypeOf(domainElement.eClass())) {
				return ValidateMediatorOnFailOutputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getMediatorFlow().isSuperTypeOf(domainElement.eClass())) {
				return MediatorFlow14EditPart.VISUAL_ID;
			}
			break;
		case RouterMediatorEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getRouterMediatorInputConnector().isSuperTypeOf(domainElement.eClass())) {
				return RouterMediatorInputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getRouterMediatorOutputConnector().isSuperTypeOf(domainElement.eClass())) {
				return RouterMediatorOutputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getRouterMediatorTargetOutputConnector().isSuperTypeOf(domainElement.eClass())) {
				return RouterMediatorTargetOutputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getRouterMediatorContainer().isSuperTypeOf(domainElement.eClass())) {
				return RouterMediatorContainerEditPart.VISUAL_ID;
			}
			break;
		case RouterMediatorContainerEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getRouterTargetContainer().isSuperTypeOf(domainElement.eClass())) {
				return RouterTargetContainerEditPart.VISUAL_ID;
			}
			break;
		case RouterTargetContainerEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getMediatorFlow().isSuperTypeOf(domainElement.eClass())) {
				return MediatorFlow15EditPart.VISUAL_ID;
			}
			break;
		case ConditionalRouterMediatorEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getConditionalRouterMediatorInputConnector().isSuperTypeOf(domainElement.eClass())) {
				return ConditionalRouterMediatorInputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getConditionalRouterMediatorOutputConnector()
					.isSuperTypeOf(domainElement.eClass())) {
				return ConditionalRouterMediatorOutputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getConditionalRouterMediatorAdditionalOutputConnector().isSuperTypeOf(
					domainElement.eClass())) {
				return ConditionalRouterMediatorAdditionalOutputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getMediatorFlow().isSuperTypeOf(domainElement.eClass())) {
				return MediatorFlow16EditPart.VISUAL_ID;
			}
			break;
		case BAMMediatorEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getBAMMediatorInputConnector().isSuperTypeOf(domainElement.eClass())) {
				return BAMMediatorInputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getBAMMediatorOutputConnector().isSuperTypeOf(domainElement.eClass())) {
				return BAMMediatorOutputConnectorEditPart.VISUAL_ID;
			}
			break;
		case BeanMediatorEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getBeanMediatorInputConnector().isSuperTypeOf(domainElement.eClass())) {
				return BeanMediatorInputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getBeanMediatorOutputConnector().isSuperTypeOf(domainElement.eClass())) {
				return BeanMediatorOutputConnectorEditPart.VISUAL_ID;
			}
			break;
		case EJBMediatorEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getEJBMediatorInputConnector().isSuperTypeOf(domainElement.eClass())) {
				return EJBMediatorInputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getEJBMediatorOutputConnector().isSuperTypeOf(domainElement.eClass())) {
				return EJBMediatorOutputConnectorEditPart.VISUAL_ID;
			}
			break;
		case DefaultEndPointEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getDefaultEndPointInputConnector().isSuperTypeOf(domainElement.eClass())) {
				return DefaultEndPointInputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getDefaultEndPointOutputConnector().isSuperTypeOf(domainElement.eClass())) {
				return DefaultEndPointOutputConnectorEditPart.VISUAL_ID;
			}
			break;
		case AddressEndPointEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getAddressEndPointInputConnector().isSuperTypeOf(domainElement.eClass())) {
				return AddressEndPointInputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getAddressEndPointOutputConnector().isSuperTypeOf(domainElement.eClass())) {
				return AddressEndPointOutputConnectorEditPart.VISUAL_ID;
			}
			break;
		case FailoverEndPointEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getFailoverEndPointInputConnector().isSuperTypeOf(domainElement.eClass())) {
				return FailoverEndPointInputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getFailoverEndPointOutputConnector().isSuperTypeOf(domainElement.eClass())) {
				return FailoverEndPointOutputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getFailoverEndPointWestOutputConnector().isSuperTypeOf(domainElement.eClass())) {
				return FailoverEndPointWestOutputConnectorEditPart.VISUAL_ID;
			}
			break;
		case RecipientListEndPointEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getRecipientListEndPointInputConnector().isSuperTypeOf(domainElement.eClass())) {
				return RecipientListEndPointInputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getRecipientListEndPointOutputConnector().isSuperTypeOf(domainElement.eClass())) {
				return RecipientListEndPointOutputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getRecipientListEndPointWestOutputConnector()
					.isSuperTypeOf(domainElement.eClass())) {
				return RecipientListEndPointWestOutputConnectorEditPart.VISUAL_ID;
			}
			break;
		case WSDLEndPointEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getWSDLEndPointInputConnector().isSuperTypeOf(domainElement.eClass())) {
				return WSDLEndPointInputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getWSDLEndPointOutputConnector().isSuperTypeOf(domainElement.eClass())) {
				return WSDLEndPointOutputConnectorEditPart.VISUAL_ID;
			}
			break;
		case NamedEndpointEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getNamedEndpointInputConnector().isSuperTypeOf(domainElement.eClass())) {
				return NamedEndpointInputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getNamedEndpointOutputConnector().isSuperTypeOf(domainElement.eClass())) {
				return NamedEndpointOutputConnectorEditPart.VISUAL_ID;
			}
			break;
		case LoadBalanceEndPointEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getLoadBalanceEndPointInputConnector().isSuperTypeOf(domainElement.eClass())) {
				return LoadBalanceEndPointInputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getLoadBalanceEndPointOutputConnector().isSuperTypeOf(domainElement.eClass())) {
				return LoadBalanceEndPointOutputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getLoadBalanceEndPointWestOutputConnector().isSuperTypeOf(domainElement.eClass())) {
				return LoadBalanceEndPointWestOutputConnectorEditPart.VISUAL_ID;
			}
			break;
		case APIResourceEndpointEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getAPIResourceEndpointInputConnector().isSuperTypeOf(domainElement.eClass())) {
				return APIResourceEndpointInputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getAPIResourceEndpointOutputConnector().isSuperTypeOf(domainElement.eClass())) {
				return APIResourceEndpointOutputConnectorEditPart.VISUAL_ID;
			}
			break;
		case AddressingEndpointEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getAddressingEndpointInputConnector().isSuperTypeOf(domainElement.eClass())) {
				return AddressingEndpointInputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getAddressingEndpointOutputConnector().isSuperTypeOf(domainElement.eClass())) {
				return AddressingEndpointOutputConnectorEditPart.VISUAL_ID;
			}
			break;
		case HTTPEndpointEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getHTTPEndPointInputConnector().isSuperTypeOf(domainElement.eClass())) {
				return HTTPEndPointInputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getHTTPEndPointOutputConnector().isSuperTypeOf(domainElement.eClass())) {
				return HTTPEndPointOutputConnectorEditPart.VISUAL_ID;
			}
			break;
		case TemplateEndpointEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getTemplateEndpointInputConnector().isSuperTypeOf(domainElement.eClass())) {
				return TemplateEndpointInputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getTemplateEndpointOutputConnector().isSuperTypeOf(domainElement.eClass())) {
				return TemplateEndpointOutputConnectorEditPart.VISUAL_ID;
			}
			break;
		case CloudConnectorEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getCloudConnectorInputConnector().isSuperTypeOf(domainElement.eClass())) {
				return CloudConnectorInputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getCloudConnectorOutputConnector().isSuperTypeOf(domainElement.eClass())) {
				return CloudConnectorOutputConnectorEditPart.VISUAL_ID;
			}
			break;
		case CloudConnectorOperationEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getCloudConnectorOperationInputConnector().isSuperTypeOf(domainElement.eClass())) {
				return CloudConnectorOperationInputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getCloudConnectorOperationOutputConnector().isSuperTypeOf(domainElement.eClass())) {
				return CloudConnectorOperationOutputConnectorEditPart.VISUAL_ID;
			}
			break;
		case LoopBackMediatorEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getLoopBackMediatorInputConnector().isSuperTypeOf(domainElement.eClass())) {
				return LoopBackMediatorInputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getLoopBackMediatorOutputConnector().isSuperTypeOf(domainElement.eClass())) {
				return LoopBackMediatorOutputConnectorEditPart.VISUAL_ID;
			}
			break;
		case RespondMediatorEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getRespondMediatorInputConnector().isSuperTypeOf(domainElement.eClass())) {
				return RespondMediatorInputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getRespondMediatorOutputConnector().isSuperTypeOf(domainElement.eClass())) {
				return RespondMediatorOutputConnectorEditPart.VISUAL_ID;
			}
			break;
		case CallMediatorEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getCallMediatorInputConnector().isSuperTypeOf(domainElement.eClass())) {
				return CallMediatorInputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getCallMediatorOutputConnector().isSuperTypeOf(domainElement.eClass())) {
				return CallMediatorOutputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getCallMediatorEndpointOutputConnector().isSuperTypeOf(domainElement.eClass())) {
				return CallMediatorEndpointOutputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getMediatorFlow().isSuperTypeOf(domainElement.eClass())) {
				return MediatorFlow20EditPart.VISUAL_ID;
			}
			break;
		case DataMapperMediatorEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getDataMapperMediatorInputConnector().isSuperTypeOf(domainElement.eClass())) {
				return DataMapperMediatorInputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getDataMapperMediatorOutputConnector().isSuperTypeOf(domainElement.eClass())) {
				return DataMapperMediatorOutputConnectorEditPart.VISUAL_ID;
			}
			break;
		case FastXSLTMediatorEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getFastXSLTMediatorInputConnector().isSuperTypeOf(domainElement.eClass())) {
				return FastXSLTMediatorInputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getFastXSLTMediatorOutputConnector().isSuperTypeOf(domainElement.eClass())) {
				return FastXSLTMediatorOutputConnectorEditPart.VISUAL_ID;
			}
			break;
		case ForEachMediatorEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getForEachMediatorInputConnector().isSuperTypeOf(domainElement.eClass())) {
				return ForEachMediatorInputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getForEachMediatorOutputConnector().isSuperTypeOf(domainElement.eClass())) {
				return ForEachMediatorOutputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getForEachMediatorTargetOutputConnector().isSuperTypeOf(domainElement.eClass())) {
				return ForEachMediatorTargetOutputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getMediatorFlow().isSuperTypeOf(domainElement.eClass())) {
				return MediatorFlow30EditPart.VISUAL_ID;
			}
			break;
		case PublishEventMediatorEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getPublishEventMediatorInputConnector().isSuperTypeOf(domainElement.eClass())) {
				return PublishEventMediatorInputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getPublishEventMediatorOutputConnector().isSuperTypeOf(domainElement.eClass())) {
				return PublishEventMediatorOutputConnectorEditPart.VISUAL_ID;
			}
			break;
		case EntitlementOnAcceptContainerEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getMediatorFlow().isSuperTypeOf(domainElement.eClass())) {
				return MediatorFlow22EditPart.VISUAL_ID;
			}
			break;
		case EntitlementAdviceContainerEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getMediatorFlow().isSuperTypeOf(domainElement.eClass())) {
				return MediatorFlow23EditPart.VISUAL_ID;
			}
			break;
		case EntitlementObligationsContainerEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getMediatorFlow().isSuperTypeOf(domainElement.eClass())) {
				return MediatorFlow24EditPart.VISUAL_ID;
			}
			break;
		case SwitchDefaultParentContainerEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getSwitchDefaultContainer().isSuperTypeOf(domainElement.eClass())) {
				return SwitchDefaultContainerEditPart.VISUAL_ID;
			}
			break;
		case SwitchDefaultContainerEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getMediatorFlow().isSuperTypeOf(domainElement.eClass())) {
				return MediatorFlow4EditPart.VISUAL_ID;
			}
			break;
		case FilterFailContainerEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getMediatorFlow().isSuperTypeOf(domainElement.eClass())) {
				return MediatorFlow8EditPart.VISUAL_ID;
			}
			break;
		case ThrottleOnRejectContainerEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getMediatorFlow().isSuperTypeOf(domainElement.eClass())) {
				return MediatorFlow10EditPart.VISUAL_ID;
			}
			break;
		case ProxyServiceFaultContainerEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getMediatorFlow().isSuperTypeOf(domainElement.eClass())) {
				return MediatorFlow6EditPart.VISUAL_ID;
			}
			break;
		case MessageMediatorEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getMessageInputConnector().isSuperTypeOf(domainElement.eClass())) {
				return MessageInputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getMessageOutputConnector().isSuperTypeOf(domainElement.eClass())) {
				return MessageOutputConnectorEditPart.VISUAL_ID;
			}
			break;
		case MergeNodeEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getMergeNodeFirstInputConnector().isSuperTypeOf(domainElement.eClass())) {
				return MergeNodeFirstInputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getMergeNodeSecondInputConnector().isSuperTypeOf(domainElement.eClass())) {
				return MergeNodeSecondInputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getMergeNodeOutputConnector().isSuperTypeOf(domainElement.eClass())) {
				return MergeNodeOutputConnectorEditPart.VISUAL_ID;
			}
			break;
		case SequencesEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getMediatorFlow().isSuperTypeOf(domainElement.eClass())) {
				return MediatorFlow5EditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getSequencesInputConnector().isSuperTypeOf(domainElement.eClass())) {
				return SequencesInputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getSequencesOutputConnector().isSuperTypeOf(domainElement.eClass())) {
				return SequencesOutputConnectorEditPart.VISUAL_ID;
			}
			break;
		case DefaultEndPoint2EditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getDefaultEndPointInputConnector().isSuperTypeOf(domainElement.eClass())) {
				return DefaultEndPointInputConnector2EditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getDefaultEndPointOutputConnector().isSuperTypeOf(domainElement.eClass())) {
				return DefaultEndPointOutputConnector2EditPart.VISUAL_ID;
			}
			break;
		case AddressEndPoint2EditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getAddressEndPointInputConnector().isSuperTypeOf(domainElement.eClass())) {
				return AddressEndPointInputConnector2EditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getAddressEndPointOutputConnector().isSuperTypeOf(domainElement.eClass())) {
				return AddressEndPointOutputConnector2EditPart.VISUAL_ID;
			}
			break;
		case FailoverEndPoint2EditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getFailoverEndPointInputConnector().isSuperTypeOf(domainElement.eClass())) {
				return FailoverEndPointInputConnector2EditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getFailoverEndPointOutputConnector().isSuperTypeOf(domainElement.eClass())) {
				return FailoverEndPointOutputConnector2EditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getFailoverEndPointWestOutputConnector().isSuperTypeOf(domainElement.eClass())) {
				return FailoverEndPointWestOutputConnector2EditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getMediatorFlow().isSuperTypeOf(domainElement.eClass())) {
				return MediatorFlow27EditPart.VISUAL_ID;
			}
			break;
		case RecipientListEndPoint2EditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getRecipientListEndPointInputConnector().isSuperTypeOf(domainElement.eClass())) {
				return RecipientListEndPointInputConnector2EditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getRecipientListEndPointOutputConnector().isSuperTypeOf(domainElement.eClass())) {
				return RecipientListEndPointOutputConnector2EditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getRecipientListEndPointWestOutputConnector()
					.isSuperTypeOf(domainElement.eClass())) {
				return RecipientListEndPointWestOutputConnector2EditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getMediatorFlow().isSuperTypeOf(domainElement.eClass())) {
				return MediatorFlow28EditPart.VISUAL_ID;
			}
			break;
		case WSDLEndPoint2EditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getWSDLEndPointInputConnector().isSuperTypeOf(domainElement.eClass())) {
				return WSDLEndPointInputConnector2EditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getWSDLEndPointOutputConnector().isSuperTypeOf(domainElement.eClass())) {
				return WSDLEndPointOutputConnector2EditPart.VISUAL_ID;
			}
			break;
		case LoadBalanceEndPoint2EditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getLoadBalanceEndPointInputConnector().isSuperTypeOf(domainElement.eClass())) {
				return LoadBalanceEndPointInputConnector2EditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getLoadBalanceEndPointOutputConnector().isSuperTypeOf(domainElement.eClass())) {
				return LoadBalanceEndPointOutputConnector2EditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getLoadBalanceEndPointWestOutputConnector().isSuperTypeOf(domainElement.eClass())) {
				return LoadBalanceEndPointWestOutputConnector2EditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getMediatorFlow().isSuperTypeOf(domainElement.eClass())) {
				return MediatorFlow29EditPart.VISUAL_ID;
			}
			break;
		case HTTPEndpoint2EditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getHTTPEndPointInputConnector().isSuperTypeOf(domainElement.eClass())) {
				return HTTPEndPointInputConnector2EditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getHTTPEndPointOutputConnector().isSuperTypeOf(domainElement.eClass())) {
				return HTTPEndPointOutputConnector2EditPart.VISUAL_ID;
			}
			break;
		case TemplateEndpoint2EditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getTemplateEndpointInputConnector().isSuperTypeOf(domainElement.eClass())) {
				return TemplateEndpointInputConnector2EditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getTemplateEndpointOutputConnector().isSuperTypeOf(domainElement.eClass())) {
				return TemplateEndpointOutputConnector2EditPart.VISUAL_ID;
			}
			break;
		case Sequences2EditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getMediatorFlow().isSuperTypeOf(domainElement.eClass())) {
				return MediatorFlow5EditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getSequencesInputConnector().isSuperTypeOf(domainElement.eClass())) {
				return SequencesInputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getSequencesOutputConnector().isSuperTypeOf(domainElement.eClass())) {
				return SequencesOutputConnectorEditPart.VISUAL_ID;
			}
			break;
		case APIResourceEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getAPIResourceInputConnector().isSuperTypeOf(domainElement.eClass())) {
				return APIResourceInputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getAPIResourceOutputConnector().isSuperTypeOf(domainElement.eClass())) {
				return APIResourceOutputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getAPIResourceOutSequenceOutputConnector().isSuperTypeOf(domainElement.eClass())) {
				return APIResourceOutSequenceOutputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getAPIResourceFaultInputConnector().isSuperTypeOf(domainElement.eClass())) {
				return APIResourceFaultInputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getProxyServiceContainer().isSuperTypeOf(domainElement.eClass())) {
				return ProxyServiceContainer2EditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getAPIResourceInSequenceInputConnector().isSuperTypeOf(domainElement.eClass())) {
				return APIResourceInSequenceInputConnectorEditPart.VISUAL_ID;
			}
			break;
		case ProxyServiceContainer2EditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getProxyServiceSequenceAndEndpointContainer()
					.isSuperTypeOf(domainElement.eClass())) {
				return ProxyServiceSequenceAndEndpointContainerEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getProxyServiceFaultContainer().isSuperTypeOf(domainElement.eClass())) {
				return ProxyServiceFaultContainerEditPart.VISUAL_ID;
			}
			break;
		case ComplexEndpointsEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getMediatorFlow().isSuperTypeOf(domainElement.eClass())) {
				return MediatorFlow18EditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getComplexEndpointsOutputConnector().isSuperTypeOf(domainElement.eClass())) {
				return ComplexEndpointsOutputConnectorEditPart.VISUAL_ID;
			}
			break;
		case InboundEndpointEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getInboundEndpointSequenceInputConnector().isSuperTypeOf(domainElement.eClass())) {
				return InboundEndpointSequenceInputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getInboundEndpointSequenceOutputConnector().isSuperTypeOf(domainElement.eClass())) {
				return InboundEndpointSequenceOutputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getInboundEndpointOnErrorSequenceInputConnector().isSuperTypeOf(
					domainElement.eClass())) {
				return InboundEndpointOnErrorSequenceInputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getInboundEndpointOnErrorSequenceOutputConnector().isSuperTypeOf(
					domainElement.eClass())) {
				return InboundEndpointOnErrorSequenceOutputConnectorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getInboundEndpointContainer().isSuperTypeOf(domainElement.eClass())) {
				return InboundEndpointContainerEditPart.VISUAL_ID;
			}
			break;
		case InboundEndpointContainerEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getInboundEndpointSequenceContainer().isSuperTypeOf(domainElement.eClass())) {
				return InboundEndpointSequenceContainerEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getInboundEndpointOnErrorSequenceContainer().isSuperTypeOf(domainElement.eClass())) {
				return InboundEndpointOnErrorSequenceContainerEditPart.VISUAL_ID;
			}
			break;
		case InboundEndpointSequenceContainerEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getMediatorFlow().isSuperTypeOf(domainElement.eClass())) {
				return MediatorFlow25EditPart.VISUAL_ID;
			}
			break;
		case InboundEndpointOnErrorSequenceContainerEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getMediatorFlow().isSuperTypeOf(domainElement.eClass())) {
				return MediatorFlow26EditPart.VISUAL_ID;
			}
			break;
		case EsbServerContentsCompartmentEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getProxyService().isSuperTypeOf(domainElement.eClass())) {
				return ProxyServiceEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getMergeNode().isSuperTypeOf(domainElement.eClass())) {
				return MergeNodeEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getSequences().isSuperTypeOf(domainElement.eClass())) {
				return SequencesEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getLocalEntry().isSuperTypeOf(domainElement.eClass())) {
				return LocalEntryEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getTemplate().isSuperTypeOf(domainElement.eClass())) {
				return TemplateEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getTask().isSuperTypeOf(domainElement.eClass())) {
				return TaskEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getSynapseAPI().isSuperTypeOf(domainElement.eClass())) {
				return SynapseAPIEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getComplexEndpoints().isSuperTypeOf(domainElement.eClass())) {
				return ComplexEndpointsEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getMessageStore().isSuperTypeOf(domainElement.eClass())) {
				return MessageStoreEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getMessageProcessor().isSuperTypeOf(domainElement.eClass())) {
				return MessageProcessorEditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getInboundEndpoint().isSuperTypeOf(domainElement.eClass())) {
				return InboundEndpointEditPart.VISUAL_ID;
			}
			break;
		case MediatorFlowMediatorFlowCompartmentEditPart.VISUAL_ID:
			return mediatorFlowMediatorFlowCompartment26EditPart(domainElement);
		case MediatorFlowMediatorFlowCompartment9EditPart.VISUAL_ID:
			return mediatorFlowMediatorFlowCompartment26EditPart(domainElement);
		case MediatorFlowMediatorFlowCompartment7EditPart.VISUAL_ID:
			return mediatorFlowMediatorFlowCompartment26EditPart(domainElement);
		case MediatorFlowMediatorFlowCompartment2EditPart.VISUAL_ID:
			return mediatorFlowMediatorFlowCompartment26EditPart(domainElement);
		case MediatorFlowMediatorFlowCompartment21EditPart.VISUAL_ID:
			return mediatorFlowMediatorFlowCompartment26EditPart(domainElement);
		case MediatorFlowMediatorFlowCompartment19EditPart.VISUAL_ID:
			return mediatorFlowMediatorFlowCompartment26EditPart(domainElement);
		case MediatorFlowMediatorFlowCompartment11EditPart.VISUAL_ID:
			return mediatorFlowMediatorFlowCompartment26EditPart(domainElement);
		case MediatorFlowMediatorFlowCompartment13EditPart.VISUAL_ID:
			return mediatorFlowMediatorFlowCompartment26EditPart(domainElement);
		case MediatorFlowMediatorFlowCompartment12EditPart.VISUAL_ID:
			return mediatorFlowMediatorFlowCompartment26EditPart(domainElement);
		case MediatorFlowMediatorFlowCompartment17EditPart.VISUAL_ID:
			return mediatorFlowMediatorFlowCompartment26EditPart(domainElement);
		case MediatorFlowMediatorFlowCompartment3EditPart.VISUAL_ID:
			return mediatorFlowMediatorFlowCompartment26EditPart(domainElement);
		case MediatorFlowMediatorFlowCompartment14EditPart.VISUAL_ID:
			return mediatorFlowMediatorFlowCompartment26EditPart(domainElement);
		case MediatorFlowMediatorFlowCompartment15EditPart.VISUAL_ID:
			return mediatorFlowMediatorFlowCompartment26EditPart(domainElement);
		case MediatorFlowMediatorFlowCompartment16EditPart.VISUAL_ID:
			return mediatorFlowMediatorFlowCompartment26EditPart(domainElement);
		case MediatorFlowMediatorFlowCompartment20EditPart.VISUAL_ID:
			return mediatorFlowMediatorFlowCompartment26EditPart(domainElement);
		case MediatorFlowMediatorFlowCompartment30EditPart.VISUAL_ID:
			return mediatorFlowMediatorFlowCompartment26EditPart(domainElement);
		case MediatorFlowMediatorFlowCompartment22EditPart.VISUAL_ID:
			return mediatorFlowMediatorFlowCompartment26EditPart(domainElement);
		case MediatorFlowMediatorFlowCompartment23EditPart.VISUAL_ID:
			return mediatorFlowMediatorFlowCompartment26EditPart(domainElement);
		case MediatorFlowMediatorFlowCompartment24EditPart.VISUAL_ID:
			return mediatorFlowMediatorFlowCompartment26EditPart(domainElement);
		case MediatorFlowMediatorFlowCompartment4EditPart.VISUAL_ID:
			return mediatorFlowMediatorFlowCompartment26EditPart(domainElement);
		case MediatorFlowMediatorFlowCompartment8EditPart.VISUAL_ID:
			return mediatorFlowMediatorFlowCompartment26EditPart(domainElement);
		case MediatorFlowMediatorFlowCompartment10EditPart.VISUAL_ID:
			return mediatorFlowMediatorFlowCompartment26EditPart(domainElement);
		case MediatorFlowMediatorFlowCompartment6EditPart.VISUAL_ID:
			return mediatorFlowMediatorFlowCompartment26EditPart(domainElement);
		case MediatorFlowMediatorFlowCompartment5EditPart.VISUAL_ID:
			return mediatorFlowMediatorFlowCompartment26EditPart(domainElement);
		case EndpointDiagramEndpointCompartmentEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getDefaultEndPoint().isSuperTypeOf(domainElement.eClass())) {
				return DefaultEndPoint2EditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getAddressEndPoint().isSuperTypeOf(domainElement.eClass())) {
				return AddressEndPoint2EditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getFailoverEndPoint().isSuperTypeOf(domainElement.eClass())) {
				return FailoverEndPoint2EditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getRecipientListEndPoint().isSuperTypeOf(domainElement.eClass())) {
				return RecipientListEndPoint2EditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getWSDLEndPoint().isSuperTypeOf(domainElement.eClass())) {
				return WSDLEndPoint2EditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getLoadBalanceEndPoint().isSuperTypeOf(domainElement.eClass())) {
				return LoadBalanceEndPoint2EditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getHTTPEndpoint().isSuperTypeOf(domainElement.eClass())) {
				return HTTPEndpoint2EditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getTemplateEndpoint().isSuperTypeOf(domainElement.eClass())) {
				return TemplateEndpoint2EditPart.VISUAL_ID;
			}
			break;
		case MediatorFlowMediatorFlowCompartment27EditPart.VISUAL_ID:
			return mediatorFlowMediatorFlowCompartment26EditPart(domainElement);
		case MediatorFlowMediatorFlowCompartment28EditPart.VISUAL_ID:
			return mediatorFlowMediatorFlowCompartment26EditPart(domainElement);
		case MediatorFlowMediatorFlowCompartment29EditPart.VISUAL_ID:
			return mediatorFlowMediatorFlowCompartment26EditPart(domainElement);
		case TemplateTemplateCompartmentEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getSequences().isSuperTypeOf(domainElement.eClass())) {
				return Sequences2EditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getEndpointDiagram().isSuperTypeOf(domainElement.eClass())) {
				return EndpointDiagram2EditPart.VISUAL_ID;
			}
			break;
		case EndpointDiagramEndpointCompartment2EditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getDefaultEndPoint().isSuperTypeOf(domainElement.eClass())) {
				return DefaultEndPoint2EditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getAddressEndPoint().isSuperTypeOf(domainElement.eClass())) {
				return AddressEndPoint2EditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getFailoverEndPoint().isSuperTypeOf(domainElement.eClass())) {
				return FailoverEndPoint2EditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getRecipientListEndPoint().isSuperTypeOf(domainElement.eClass())) {
				return RecipientListEndPoint2EditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getWSDLEndPoint().isSuperTypeOf(domainElement.eClass())) {
				return WSDLEndPoint2EditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getLoadBalanceEndPoint().isSuperTypeOf(domainElement.eClass())) {
				return LoadBalanceEndPoint2EditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getHTTPEndpoint().isSuperTypeOf(domainElement.eClass())) {
				return HTTPEndpoint2EditPart.VISUAL_ID;
			}
			if (EsbPackage.eINSTANCE.getTemplateEndpoint().isSuperTypeOf(domainElement.eClass())) {
				return TemplateEndpoint2EditPart.VISUAL_ID;
			}
			break;
		case SynapseAPIAPICompartmentEditPart.VISUAL_ID:
			if (EsbPackage.eINSTANCE.getAPIResource().isSuperTypeOf(domainElement.eClass())) {
				return APIResourceEditPart.VISUAL_ID;
			}
			break;
		case MediatorFlowMediatorFlowCompartment18EditPart.VISUAL_ID:
			return mediatorFlowMediatorFlowCompartment26EditPart(domainElement);
		case MediatorFlowMediatorFlowCompartment25EditPart.VISUAL_ID:
			return mediatorFlowMediatorFlowCompartment26EditPart(domainElement);
		case MediatorFlowMediatorFlowCompartment26EditPart.VISUAL_ID:
			return mediatorFlowMediatorFlowCompartment26EditPart(domainElement);
		}
		return -1;
	}

	private static int mediatorFlowMediatorFlowCompartment26EditPart(EObject domainElement) {
		if (EsbPackage.eINSTANCE.getDropMediator().isSuperTypeOf(domainElement.eClass())) {
			return DropMediatorEditPart.VISUAL_ID;
		}
		if (EsbPackage.eINSTANCE.getPropertyMediator().isSuperTypeOf(domainElement.eClass())) {
			return PropertyMediatorEditPart.VISUAL_ID;
		}
		if (EsbPackage.eINSTANCE.getThrottleMediator().isSuperTypeOf(domainElement.eClass())) {
			return ThrottleMediatorEditPart.VISUAL_ID;
		}
		if (EsbPackage.eINSTANCE.getFilterMediator().isSuperTypeOf(domainElement.eClass())) {
			return FilterMediatorEditPart.VISUAL_ID;
		}
		if (EsbPackage.eINSTANCE.getLogMediator().isSuperTypeOf(domainElement.eClass())) {
			return LogMediatorEditPart.VISUAL_ID;
		}
		if (EsbPackage.eINSTANCE.getEnrichMediator().isSuperTypeOf(domainElement.eClass())) {
			return EnrichMediatorEditPart.VISUAL_ID;
		}
		if (EsbPackage.eINSTANCE.getXSLTMediator().isSuperTypeOf(domainElement.eClass())) {
			return XSLTMediatorEditPart.VISUAL_ID;
		}
		if (EsbPackage.eINSTANCE.getSwitchMediator().isSuperTypeOf(domainElement.eClass())) {
			return SwitchMediatorEditPart.VISUAL_ID;
		}
		if (EsbPackage.eINSTANCE.getSequence().isSuperTypeOf(domainElement.eClass())) {
			return SequenceEditPart.VISUAL_ID;
		}
		if (EsbPackage.eINSTANCE.getEventMediator().isSuperTypeOf(domainElement.eClass())) {
			return EventMediatorEditPart.VISUAL_ID;
		}
		if (EsbPackage.eINSTANCE.getEntitlementMediator().isSuperTypeOf(domainElement.eClass())) {
			return EntitlementMediatorEditPart.VISUAL_ID;
		}
		if (EsbPackage.eINSTANCE.getClassMediator().isSuperTypeOf(domainElement.eClass())) {
			return ClassMediatorEditPart.VISUAL_ID;
		}
		if (EsbPackage.eINSTANCE.getSpringMediator().isSuperTypeOf(domainElement.eClass())) {
			return SpringMediatorEditPart.VISUAL_ID;
		}
		if (EsbPackage.eINSTANCE.getScriptMediator().isSuperTypeOf(domainElement.eClass())) {
			return ScriptMediatorEditPart.VISUAL_ID;
		}
		if (EsbPackage.eINSTANCE.getFaultMediator().isSuperTypeOf(domainElement.eClass())) {
			return FaultMediatorEditPart.VISUAL_ID;
		}
		if (EsbPackage.eINSTANCE.getXQueryMediator().isSuperTypeOf(domainElement.eClass())) {
			return XQueryMediatorEditPart.VISUAL_ID;
		}
		if (EsbPackage.eINSTANCE.getCommandMediator().isSuperTypeOf(domainElement.eClass())) {
			return CommandMediatorEditPart.VISUAL_ID;
		}
		if (EsbPackage.eINSTANCE.getDBLookupMediator().isSuperTypeOf(domainElement.eClass())) {
			return DBLookupMediatorEditPart.VISUAL_ID;
		}
		if (EsbPackage.eINSTANCE.getDBReportMediator().isSuperTypeOf(domainElement.eClass())) {
			return DBReportMediatorEditPart.VISUAL_ID;
		}
		if (EsbPackage.eINSTANCE.getSmooksMediator().isSuperTypeOf(domainElement.eClass())) {
			return SmooksMediatorEditPart.VISUAL_ID;
		}
		if (EsbPackage.eINSTANCE.getSendMediator().isSuperTypeOf(domainElement.eClass())) {
			return SendMediatorEditPart.VISUAL_ID;
		}
		if (EsbPackage.eINSTANCE.getHeaderMediator().isSuperTypeOf(domainElement.eClass())) {
			return HeaderMediatorEditPart.VISUAL_ID;
		}
		if (EsbPackage.eINSTANCE.getCloneMediator().isSuperTypeOf(domainElement.eClass())) {
			return CloneMediatorEditPart.VISUAL_ID;
		}
		if (EsbPackage.eINSTANCE.getCacheMediator().isSuperTypeOf(domainElement.eClass())) {
			return CacheMediatorEditPart.VISUAL_ID;
		}
		if (EsbPackage.eINSTANCE.getIterateMediator().isSuperTypeOf(domainElement.eClass())) {
			return IterateMediatorEditPart.VISUAL_ID;
		}
		if (EsbPackage.eINSTANCE.getCalloutMediator().isSuperTypeOf(domainElement.eClass())) {
			return CalloutMediatorEditPart.VISUAL_ID;
		}
		if (EsbPackage.eINSTANCE.getTransactionMediator().isSuperTypeOf(domainElement.eClass())) {
			return TransactionMediatorEditPart.VISUAL_ID;
		}
		if (EsbPackage.eINSTANCE.getRMSequenceMediator().isSuperTypeOf(domainElement.eClass())) {
			return RMSequenceMediatorEditPart.VISUAL_ID;
		}
		if (EsbPackage.eINSTANCE.getRuleMediator().isSuperTypeOf(domainElement.eClass())) {
			return RuleMediatorEditPart.VISUAL_ID;
		}
		if (EsbPackage.eINSTANCE.getOAuthMediator().isSuperTypeOf(domainElement.eClass())) {
			return OAuthMediatorEditPart.VISUAL_ID;
		}
		if (EsbPackage.eINSTANCE.getAggregateMediator().isSuperTypeOf(domainElement.eClass())) {
			return AggregateMediatorEditPart.VISUAL_ID;
		}
		if (EsbPackage.eINSTANCE.getStoreMediator().isSuperTypeOf(domainElement.eClass())) {
			return StoreMediatorEditPart.VISUAL_ID;
		}
		if (EsbPackage.eINSTANCE.getBuilderMediator().isSuperTypeOf(domainElement.eClass())) {
			return BuilderMediatorEditPart.VISUAL_ID;
		}
		if (EsbPackage.eINSTANCE.getCallTemplateMediator().isSuperTypeOf(domainElement.eClass())) {
			return CallTemplateMediatorEditPart.VISUAL_ID;
		}
		if (EsbPackage.eINSTANCE.getPayloadFactoryMediator().isSuperTypeOf(domainElement.eClass())) {
			return PayloadFactoryMediatorEditPart.VISUAL_ID;
		}
		if (EsbPackage.eINSTANCE.getEnqueueMediator().isSuperTypeOf(domainElement.eClass())) {
			return EnqueueMediatorEditPart.VISUAL_ID;
		}
		if (EsbPackage.eINSTANCE.getURLRewriteMediator().isSuperTypeOf(domainElement.eClass())) {
			return URLRewriteMediatorEditPart.VISUAL_ID;
		}
		if (EsbPackage.eINSTANCE.getValidateMediator().isSuperTypeOf(domainElement.eClass())) {
			return ValidateMediatorEditPart.VISUAL_ID;
		}
		if (EsbPackage.eINSTANCE.getRouterMediator().isSuperTypeOf(domainElement.eClass())) {
			return RouterMediatorEditPart.VISUAL_ID;
		}
		if (EsbPackage.eINSTANCE.getConditionalRouterMediator().isSuperTypeOf(domainElement.eClass())) {
			return ConditionalRouterMediatorEditPart.VISUAL_ID;
		}
		if (EsbPackage.eINSTANCE.getBAMMediator().isSuperTypeOf(domainElement.eClass())) {
			return BAMMediatorEditPart.VISUAL_ID;
		}
		if (EsbPackage.eINSTANCE.getBeanMediator().isSuperTypeOf(domainElement.eClass())) {
			return BeanMediatorEditPart.VISUAL_ID;
		}
		if (EsbPackage.eINSTANCE.getEJBMediator().isSuperTypeOf(domainElement.eClass())) {
			return EJBMediatorEditPart.VISUAL_ID;
		}
		if (EsbPackage.eINSTANCE.getDefaultEndPoint().isSuperTypeOf(domainElement.eClass())) {
			return DefaultEndPointEditPart.VISUAL_ID;
		}
		if (EsbPackage.eINSTANCE.getAddressEndPoint().isSuperTypeOf(domainElement.eClass())) {
			return AddressEndPointEditPart.VISUAL_ID;
		}
		if (EsbPackage.eINSTANCE.getFailoverEndPoint().isSuperTypeOf(domainElement.eClass())) {
			return FailoverEndPointEditPart.VISUAL_ID;
		}
		if (EsbPackage.eINSTANCE.getRecipientListEndPoint().isSuperTypeOf(domainElement.eClass())) {
			return RecipientListEndPointEditPart.VISUAL_ID;
		}
		if (EsbPackage.eINSTANCE.getWSDLEndPoint().isSuperTypeOf(domainElement.eClass())) {
			return WSDLEndPointEditPart.VISUAL_ID;
		}
		if (EsbPackage.eINSTANCE.getNamedEndpoint().isSuperTypeOf(domainElement.eClass())) {
			return NamedEndpointEditPart.VISUAL_ID;
		}
		if (EsbPackage.eINSTANCE.getLoadBalanceEndPoint().isSuperTypeOf(domainElement.eClass())) {
			return LoadBalanceEndPointEditPart.VISUAL_ID;
		}
		if (EsbPackage.eINSTANCE.getAPIResourceEndpoint().isSuperTypeOf(domainElement.eClass())) {
			return APIResourceEndpointEditPart.VISUAL_ID;
		}
		if (EsbPackage.eINSTANCE.getAddressingEndpoint().isSuperTypeOf(domainElement.eClass())) {
			return AddressingEndpointEditPart.VISUAL_ID;
		}
		if (EsbPackage.eINSTANCE.getHTTPEndpoint().isSuperTypeOf(domainElement.eClass())) {
			return HTTPEndpointEditPart.VISUAL_ID;
		}
		if (EsbPackage.eINSTANCE.getTemplateEndpoint().isSuperTypeOf(domainElement.eClass())) {
			return TemplateEndpointEditPart.VISUAL_ID;
		}
		if (EsbPackage.eINSTANCE.getCloudConnector().isSuperTypeOf(domainElement.eClass())) {
			return CloudConnectorEditPart.VISUAL_ID;
		}
		if (EsbPackage.eINSTANCE.getCloudConnectorOperation().isSuperTypeOf(domainElement.eClass())) {
			return CloudConnectorOperationEditPart.VISUAL_ID;
		}
		if (EsbPackage.eINSTANCE.getLoopBackMediator().isSuperTypeOf(domainElement.eClass())) {
			return LoopBackMediatorEditPart.VISUAL_ID;
		}
		if (EsbPackage.eINSTANCE.getRespondMediator().isSuperTypeOf(domainElement.eClass())) {
			return RespondMediatorEditPart.VISUAL_ID;
		}
		if (EsbPackage.eINSTANCE.getCallMediator().isSuperTypeOf(domainElement.eClass())) {
			return CallMediatorEditPart.VISUAL_ID;
		}
		if (EsbPackage.eINSTANCE.getDataMapperMediator().isSuperTypeOf(domainElement.eClass())) {
			return DataMapperMediatorEditPart.VISUAL_ID;
		}
		if (EsbPackage.eINSTANCE.getFastXSLTMediator().isSuperTypeOf(domainElement.eClass())) {
			return FastXSLTMediatorEditPart.VISUAL_ID;
		}
		if (EsbPackage.eINSTANCE.getForEachMediator().isSuperTypeOf(domainElement.eClass())) {
			return ForEachMediatorEditPart.VISUAL_ID;
		}
		if (EsbPackage.eINSTANCE.getPublishEventMediator().isSuperTypeOf(domainElement.eClass())) {
			return PublishEventMediatorEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbVisualIDRegistry
				.getModelID(containerView);
		if (!EsbDiagramEditPart.MODEL_ID.equals(containerModelID)) {
			return false;
		}
		int containerVisualID;
		if (EsbDiagramEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = EsbDiagramEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch (containerVisualID) {
		case EsbDiagramEditPart.VISUAL_ID:
			if (EsbServerEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case EsbServerEditPart.VISUAL_ID:
			if (EsbServerContentsCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (MessageMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EndpointDiagramEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ProxyServiceEditPart.VISUAL_ID:
			if (ProxyServiceNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ProxyOutputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ProxyInputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ProxyOutSequenceOutputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ProxyFaultInputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ProxyServiceContainerEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ProxyInSequenceInputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ProxyServiceContainerEditPart.VISUAL_ID:
			if (ProxyServiceSequenceAndEndpointContainerEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ProxyServiceFaultContainerEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ProxyServiceSequenceAndEndpointContainerEditPart.VISUAL_ID:
			if (MediatorFlowEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case MediatorFlowEditPart.VISUAL_ID:
			if (MediatorFlowMediatorFlowCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DropMediatorEditPart.VISUAL_ID:
			if (DropMediatorDescriptionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DropMediatorInputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PropertyMediatorEditPart.VISUAL_ID:
			if (PropertyMediatorDescriptionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PropertyMediatorInputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PropertyMediatorOutputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ThrottleMediatorEditPart.VISUAL_ID:
			if (ThrottleMediatorGroupIdEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ThrottleMediatorInputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ThrottleMediatorOutputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ThrottleMediatorOnAcceptOutputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ThrottleMediatorOnRejectOutputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ThrottleContainerEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ThrottleContainerEditPart.VISUAL_ID:
			if (ThrottleOnAcceptContainerEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ThrottleOnRejectContainerEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ThrottleOnAcceptContainerEditPart.VISUAL_ID:
			if (MediatorFlow9EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case MediatorFlow9EditPart.VISUAL_ID:
			if (MediatorFlowMediatorFlowCompartment9EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case FilterMediatorEditPart.VISUAL_ID:
			if (FilterMediatorConditionTypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FilterMediatorInputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FilterMediatorOutputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FilterMediatorPassOutputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FilterMediatorFailOutputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FilterContainerEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case FilterContainerEditPart.VISUAL_ID:
			if (FilterPassContainerEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FilterFailContainerEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case FilterPassContainerEditPart.VISUAL_ID:
			if (MediatorFlow7EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case MediatorFlow7EditPart.VISUAL_ID:
			if (MediatorFlowMediatorFlowCompartment7EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case LogMediatorEditPart.VISUAL_ID:
			if (LogMediatorDescriptionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LogMediatorInputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LogMediatorOutputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case EnrichMediatorEditPart.VISUAL_ID:
			if (EnrichMediatorDescriptionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EnrichMediatorInputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EnrichMediatorOutputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case XSLTMediatorEditPart.VISUAL_ID:
			if (XSLTMediatorDescriptionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (XSLTMediatorInputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (XSLTMediatorOutputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case SwitchMediatorEditPart.VISUAL_ID:
			if (SwitchMediatorInputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SwitchMediatorOutputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SwitchCaseBranchOutputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SwitchDefaultBranchOutputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SwitchMediatorContainerEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case SwitchMediatorContainerEditPart.VISUAL_ID:
			if (SwitchCaseParentContainerEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SwitchDefaultParentContainerEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case SwitchCaseParentContainerEditPart.VISUAL_ID:
			if (SwitchCaseContainerEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case SwitchCaseContainerEditPart.VISUAL_ID:
			if (MediatorFlow2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case MediatorFlow2EditPart.VISUAL_ID:
			if (MediatorFlowMediatorFlowCompartment2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case SequenceEditPart.VISUAL_ID:
			if (SequenceNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SequenceInputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SequenceOutputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case EventMediatorEditPart.VISUAL_ID:
			if (EventMediatorDescriptionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EventMediatorInputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EventMediatorOutputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case EntitlementMediatorEditPart.VISUAL_ID:
			if (EntitlementMediatorServerURLEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EntitlementMediatorInputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EntitlementMediatorOutputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EntitlementMediatorOnRejectOutputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EntitlementMediatorOnAcceptOutputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EntitlementMediatorAdviceOutputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EntitlementMediatorObligationsOutputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EntitlementContainerEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case EntitlementContainerEditPart.VISUAL_ID:
			if (EntitlementOnRejectContainerEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EntitlementOnAcceptContainerEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EntitlementAdviceContainerEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EntitlementObligationsContainerEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case EntitlementOnRejectContainerEditPart.VISUAL_ID:
			if (MediatorFlow21EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case MediatorFlow21EditPart.VISUAL_ID:
			if (MediatorFlowMediatorFlowCompartment21EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ClassMediatorEditPart.VISUAL_ID:
			if (ClassMediatorDescriptionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ClassMediatorInputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ClassMediatorOutputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case SpringMediatorEditPart.VISUAL_ID:
			if (SpringMediatorDescriptionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SpringMediatorInputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SpringMediatorOutputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ScriptMediatorEditPart.VISUAL_ID:
			if (ScriptMediatorDescriptionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ScriptMediatorInputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ScriptMediatorOutputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case FaultMediatorEditPart.VISUAL_ID:
			if (FaultMediatorDescriptionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FaultMediatorInputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FaultMediatorOutputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case XQueryMediatorEditPart.VISUAL_ID:
			if (XQueryMediatorDescriptionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (XQueryMediatorInputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (XQueryMediatorOutputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case CommandMediatorEditPart.VISUAL_ID:
			if (CommandMediatorDescriptionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CommandMediatorInputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CommandMediatorOutputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DBLookupMediatorEditPart.VISUAL_ID:
			if (DBLookupMediatorDescriptionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DBLookupMediatorInputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DBLookupMediatorOutputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DBReportMediatorEditPart.VISUAL_ID:
			if (DBReportMediatorDescriptionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DBReportMediatorInputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DBReportMediatorOutputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case SmooksMediatorEditPart.VISUAL_ID:
			if (SmooksMediatorDescriptionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SmooksMediatorInputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SmooksMediatorOutputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case SendMediatorEditPart.VISUAL_ID:
			if (SendMediatorInputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SendMediatorOutputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SendMediatorEndpointOutputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (MediatorFlow19EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case MediatorFlow19EditPart.VISUAL_ID:
			if (MediatorFlowMediatorFlowCompartment19EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case HeaderMediatorEditPart.VISUAL_ID:
			if (HeaderMediatorDescriptionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (HeaderMediatorInputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (HeaderMediatorOutputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case CloneMediatorEditPart.VISUAL_ID:
			if (CloneMediatorCloneIDEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloneMediatorInputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloneMediatorOutputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloneMediatorTargetOutputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloneMediatorContainerEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case CloneMediatorContainerEditPart.VISUAL_ID:
			if (CloneTargetContainerEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case CloneTargetContainerEditPart.VISUAL_ID:
			if (MediatorFlow11EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case MediatorFlow11EditPart.VISUAL_ID:
			if (MediatorFlowMediatorFlowCompartment11EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case CacheMediatorEditPart.VISUAL_ID:
			if (CacheMediatorCacheIdEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CacheMediatorInputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CacheMediatorOutputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CacheMediatorOnHitOutputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (MediatorFlow13EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case MediatorFlow13EditPart.VISUAL_ID:
			if (MediatorFlowMediatorFlowCompartment13EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case IterateMediatorEditPart.VISUAL_ID:
			if (IterateMediatorIterateIDEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (IterateMediatorInputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (IterateMediatorOutputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (IterateMediatorTargetOutputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (MediatorFlow12EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case MediatorFlow12EditPart.VISUAL_ID:
			if (MediatorFlowMediatorFlowCompartment12EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case CalloutMediatorEditPart.VISUAL_ID:
			if (CalloutMediatorDescriptionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CalloutMediatorInputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CalloutMediatorOutputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case TransactionMediatorEditPart.VISUAL_ID:
			if (TransactionMediatorDescriptionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TransactionMediatorInputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TransactionMediatorOutputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case RMSequenceMediatorEditPart.VISUAL_ID:
			if (RMSequenceMediatorDescriptionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RMSequenceMediatorInputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RMSequenceMediatorOutputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case RuleMediatorEditPart.VISUAL_ID:
			if (RuleMediatorInputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RuleMediatorOutputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RuleMediatorChildMediatorsOutputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (MediatorFlow17EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case MediatorFlow17EditPart.VISUAL_ID:
			if (MediatorFlowMediatorFlowCompartment17EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case OAuthMediatorEditPart.VISUAL_ID:
			if (OAuthMediatorDescriptionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (OAuthMediatorInputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (OAuthMediatorOutputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case AggregateMediatorEditPart.VISUAL_ID:
			if (AggregateMediatorAggregateIDEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AggregateMediatorInputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AggregateMediatorOutputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AggregateMediatorOnCompleteOutputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (MediatorFlow3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case MediatorFlow3EditPart.VISUAL_ID:
			if (MediatorFlowMediatorFlowCompartment3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case StoreMediatorEditPart.VISUAL_ID:
			if (StoreMediatorDescriptionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (StoreMediatorInputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (StoreMediatorOutputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case BuilderMediatorEditPart.VISUAL_ID:
			if (BuilderMediatorDescriptionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BuilderMediatorInputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BuilderMediatorOutputConectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case CallTemplateMediatorEditPart.VISUAL_ID:
			if (CallTemplateMediatorDescriptionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CallTemplateMediatorInputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CallTemplateMediatorOutputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PayloadFactoryMediatorEditPart.VISUAL_ID:
			if (PayloadFactoryMediatorDescriptionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PayloadFactoryMediatorInputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PayloadFactoryMediatorOutputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case EnqueueMediatorEditPart.VISUAL_ID:
			if (EnqueueMediatorDescriptionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EnqueueMediatorInputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EnqueueMediatorOutputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case URLRewriteMediatorEditPart.VISUAL_ID:
			if (URLRewriteMediatorDescriptionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (URLRewriteMediatorInputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (URLRewriteMediatorOutputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ValidateMediatorEditPart.VISUAL_ID:
			if (ValidateMediatorInputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ValidateMediatorOutputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ValidateMediatorOnFailOutputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (MediatorFlow14EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case MediatorFlow14EditPart.VISUAL_ID:
			if (MediatorFlowMediatorFlowCompartment14EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case RouterMediatorEditPart.VISUAL_ID:
			if (RouterMediatorInputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RouterMediatorOutputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RouterMediatorTargetOutputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RouterMediatorContainerEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case RouterMediatorContainerEditPart.VISUAL_ID:
			if (RouterTargetContainerEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case RouterTargetContainerEditPart.VISUAL_ID:
			if (MediatorFlow15EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case MediatorFlow15EditPart.VISUAL_ID:
			if (MediatorFlowMediatorFlowCompartment15EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ConditionalRouterMediatorEditPart.VISUAL_ID:
			if (ConditionalRouterMediatorDescriptionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ConditionalRouterMediatorInputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ConditionalRouterMediatorOutputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ConditionalRouterMediatorAdditionalOutputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (MediatorFlow16EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case MediatorFlow16EditPart.VISUAL_ID:
			if (MediatorFlowMediatorFlowCompartment16EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case BAMMediatorEditPart.VISUAL_ID:
			if (BAMMediatorDescriptionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BAMMediatorInputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BAMMediatorOutputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case BeanMediatorEditPart.VISUAL_ID:
			if (BeanMediatorDescriptionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BeanMediatorInputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BeanMediatorOutputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case EJBMediatorEditPart.VISUAL_ID:
			if (EJBMediatorDescriptionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EJBMediatorInputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EJBMediatorOutputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DefaultEndPointEditPart.VISUAL_ID:
			if (DefaultEndPointDescriptionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DefaultEndPointInputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DefaultEndPointOutputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case AddressEndPointEditPart.VISUAL_ID:
			if (AddressEndPointDescriptionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AddressEndPointInputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AddressEndPointOutputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case FailoverEndPointEditPart.VISUAL_ID:
			if (FailoverEndPointDescriptionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FailoverEndPointInputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FailoverEndPointOutputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FailoverEndPointWestOutputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case RecipientListEndPointEditPart.VISUAL_ID:
			if (RecipientListEndPointDescriptionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RecipientListEndPointInputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RecipientListEndPointOutputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RecipientListEndPointWestOutputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case WSDLEndPointEditPart.VISUAL_ID:
			if (WSDLEndPointDescriptionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (WSDLEndPointInputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (WSDLEndPointOutputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case NamedEndpointEditPart.VISUAL_ID:
			if (NamedEndpointNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (NamedEndpointInputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (NamedEndpointOutputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case LoadBalanceEndPointEditPart.VISUAL_ID:
			if (LoadBalanceEndPointDescriptionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LoadBalanceEndPointInputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LoadBalanceEndPointOutputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LoadBalanceEndPointWestOutputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case APIResourceEndpointEditPart.VISUAL_ID:
			if (APIResourceEndpointInputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (APIResourceEndpointOutputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case AddressingEndpointEditPart.VISUAL_ID:
			if (AddressingEndpointDescriptionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AddressingEndpointInputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AddressingEndpointOutputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case HTTPEndpointEditPart.VISUAL_ID:
			if (HTTPEndpointDescriptionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (HTTPEndPointInputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (HTTPEndPointOutputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case TemplateEndpointEditPart.VISUAL_ID:
			if (TemplateEndpointDescriptionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TemplateEndpointInputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TemplateEndpointOutputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case CloudConnectorEditPart.VISUAL_ID:
			if (CloudConnectorDescriptionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloudConnectorInputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloudConnectorOutputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case CloudConnectorOperationEditPart.VISUAL_ID:
			if (CloudConnectorOperationDescriptionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloudConnectorOperationInputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloudConnectorOperationOutputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case LoopBackMediatorEditPart.VISUAL_ID:
			if (LoopBackMediatorDescriptionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LoopBackMediatorInputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LoopBackMediatorOutputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case RespondMediatorEditPart.VISUAL_ID:
			if (RespondMediatorDescriptionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RespondMediatorInputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RespondMediatorOutputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case CallMediatorEditPart.VISUAL_ID:
			if (CallMediatorInputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CallMediatorOutputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CallMediatorEndpointOutputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (MediatorFlow20EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case MediatorFlow20EditPart.VISUAL_ID:
			if (MediatorFlowMediatorFlowCompartment20EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DataMapperMediatorEditPart.VISUAL_ID:
			if (DataMapperMediatorDescriptionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DataMapperMediatorInputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DataMapperMediatorOutputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case FastXSLTMediatorEditPart.VISUAL_ID:
			if (FastXSLTMediatorDescriptionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FastXSLTMediatorInputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FastXSLTMediatorOutputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ForEachMediatorEditPart.VISUAL_ID:
			if (ForEachMediatorDescriptionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ForEachMediatorInputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ForEachMediatorOutputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ForEachMediatorTargetOutputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (MediatorFlow30EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case MediatorFlow30EditPart.VISUAL_ID:
			if (MediatorFlowMediatorFlowCompartment30EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PublishEventMediatorEditPart.VISUAL_ID:
			if (PublishEventMediatorStreamNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PublishEventMediatorInputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PublishEventMediatorOutputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case EntitlementOnAcceptContainerEditPart.VISUAL_ID:
			if (MediatorFlow22EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case MediatorFlow22EditPart.VISUAL_ID:
			if (MediatorFlowMediatorFlowCompartment22EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case EntitlementAdviceContainerEditPart.VISUAL_ID:
			if (MediatorFlow23EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case MediatorFlow23EditPart.VISUAL_ID:
			if (MediatorFlowMediatorFlowCompartment23EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case EntitlementObligationsContainerEditPart.VISUAL_ID:
			if (MediatorFlow24EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case MediatorFlow24EditPart.VISUAL_ID:
			if (MediatorFlowMediatorFlowCompartment24EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case SwitchDefaultParentContainerEditPart.VISUAL_ID:
			if (SwitchDefaultContainerEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case SwitchDefaultContainerEditPart.VISUAL_ID:
			if (MediatorFlow4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case MediatorFlow4EditPart.VISUAL_ID:
			if (MediatorFlowMediatorFlowCompartment4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case FilterFailContainerEditPart.VISUAL_ID:
			if (MediatorFlow8EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case MediatorFlow8EditPart.VISUAL_ID:
			if (MediatorFlowMediatorFlowCompartment8EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ThrottleOnRejectContainerEditPart.VISUAL_ID:
			if (MediatorFlow10EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case MediatorFlow10EditPart.VISUAL_ID:
			if (MediatorFlowMediatorFlowCompartment10EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ProxyServiceFaultContainerEditPart.VISUAL_ID:
			if (MediatorFlow6EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case MediatorFlow6EditPart.VISUAL_ID:
			if (MediatorFlowMediatorFlowCompartment6EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case MessageMediatorEditPart.VISUAL_ID:
			if (MessageInputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (MessageOutputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case MergeNodeEditPart.VISUAL_ID:
			if (MergeNodeFirstInputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (MergeNodeSecondInputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (MergeNodeOutputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case SequencesEditPart.VISUAL_ID:
			if (MediatorFlow5EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SequencesInputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SequencesOutputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case MediatorFlow5EditPart.VISUAL_ID:
			if (MediatorFlowMediatorFlowCompartment5EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case EndpointDiagramEditPart.VISUAL_ID:
			if (EndpointDiagramEndpointCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DefaultEndPoint2EditPart.VISUAL_ID:
			if (DefaultEndPointEndPointName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DefaultEndPointInputConnector2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DefaultEndPointOutputConnector2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case AddressEndPoint2EditPart.VISUAL_ID:
			if (AddressEndPointEndPointName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AddressEndPointInputConnector2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AddressEndPointOutputConnector2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case FailoverEndPoint2EditPart.VISUAL_ID:
			if (FailoverEndPointEndPointName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FailoverEndPointInputConnector2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FailoverEndPointOutputConnector2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FailoverEndPointWestOutputConnector2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (MediatorFlow27EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case MediatorFlow27EditPart.VISUAL_ID:
			if (MediatorFlowMediatorFlowCompartment27EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case RecipientListEndPoint2EditPart.VISUAL_ID:
			if (RecipientListEndPointInputConnector2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RecipientListEndPointOutputConnector2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RecipientListEndPointWestOutputConnector2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (MediatorFlow28EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case MediatorFlow28EditPart.VISUAL_ID:
			if (MediatorFlowMediatorFlowCompartment28EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case WSDLEndPoint2EditPart.VISUAL_ID:
			if (WSDLEndPointEndPointName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (WSDLEndPointInputConnector2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (WSDLEndPointOutputConnector2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case LoadBalanceEndPoint2EditPart.VISUAL_ID:
			if (LoadBalanceEndPointEndPointName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LoadBalanceEndPointInputConnector2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LoadBalanceEndPointOutputConnector2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LoadBalanceEndPointWestOutputConnector2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (MediatorFlow29EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case MediatorFlow29EditPart.VISUAL_ID:
			if (MediatorFlowMediatorFlowCompartment29EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case HTTPEndpoint2EditPart.VISUAL_ID:
			if (HTTPEndPointInputConnector2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (HTTPEndPointOutputConnector2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case TemplateEndpoint2EditPart.VISUAL_ID:
			if (TemplateEndpointInputConnector2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TemplateEndpointOutputConnector2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case TemplateEditPart.VISUAL_ID:
			if (TemplateTemplateCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Sequences2EditPart.VISUAL_ID:
			if (MediatorFlow5EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SequencesInputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SequencesOutputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case EndpointDiagram2EditPart.VISUAL_ID:
			if (EndpointDiagramEndpointCompartment2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case SynapseAPIEditPart.VISUAL_ID:
			if (SynapseAPIAPICompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case APIResourceEditPart.VISUAL_ID:
			if (APIResourceInputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (APIResourceOutputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (APIResourceOutSequenceOutputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (APIResourceFaultInputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ProxyServiceContainer2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (APIResourceInSequenceInputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ProxyServiceContainer2EditPart.VISUAL_ID:
			if (ProxyServiceSequenceAndEndpointContainerEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ProxyServiceFaultContainerEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ComplexEndpointsEditPart.VISUAL_ID:
			if (MediatorFlow18EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ComplexEndpointsOutputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case MediatorFlow18EditPart.VISUAL_ID:
			if (MediatorFlowMediatorFlowCompartment18EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InboundEndpointEditPart.VISUAL_ID:
			if (InboundEndpointSequenceInputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InboundEndpointSequenceOutputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InboundEndpointOnErrorSequenceInputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InboundEndpointOnErrorSequenceOutputConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InboundEndpointContainerEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InboundEndpointContainerEditPart.VISUAL_ID:
			if (InboundEndpointSequenceContainerEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InboundEndpointOnErrorSequenceContainerEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InboundEndpointSequenceContainerEditPart.VISUAL_ID:
			if (MediatorFlow25EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case MediatorFlow25EditPart.VISUAL_ID:
			if (MediatorFlowMediatorFlowCompartment25EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InboundEndpointOnErrorSequenceContainerEditPart.VISUAL_ID:
			if (MediatorFlow26EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case MediatorFlow26EditPart.VISUAL_ID:
			if (MediatorFlowMediatorFlowCompartment26EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case EsbServerContentsCompartmentEditPart.VISUAL_ID:
			if (ProxyServiceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (MergeNodeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SequencesEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LocalEntryEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TemplateEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TaskEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SynapseAPIEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ComplexEndpointsEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (MessageStoreEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (MessageProcessorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InboundEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case MediatorFlowMediatorFlowCompartmentEditPart.VISUAL_ID:
			if (DropMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PropertyMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ThrottleMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FilterMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LogMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EnrichMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (XSLTMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SwitchMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SequenceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EventMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EntitlementMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ClassMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SpringMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ScriptMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FaultMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (XQueryMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CommandMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DBLookupMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DBReportMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SmooksMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SendMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (HeaderMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloneMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CacheMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (IterateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CalloutMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TransactionMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RMSequenceMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RuleMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (OAuthMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AggregateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (StoreMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BuilderMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CallTemplateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PayloadFactoryMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EnqueueMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (URLRewriteMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ValidateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RouterMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ConditionalRouterMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BAMMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BeanMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EJBMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DefaultEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AddressEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FailoverEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RecipientListEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (WSDLEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (NamedEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LoadBalanceEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (APIResourceEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AddressingEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (HTTPEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TemplateEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloudConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloudConnectorOperationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LoopBackMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RespondMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CallMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DataMapperMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FastXSLTMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ForEachMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PublishEventMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case MediatorFlowMediatorFlowCompartment9EditPart.VISUAL_ID:
			if (DropMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PropertyMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ThrottleMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FilterMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LogMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EnrichMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (XSLTMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SwitchMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SequenceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EventMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EntitlementMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ClassMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SpringMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ScriptMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FaultMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (XQueryMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CommandMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DBLookupMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DBReportMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SmooksMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SendMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (HeaderMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloneMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CacheMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (IterateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CalloutMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TransactionMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RMSequenceMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RuleMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (OAuthMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AggregateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (StoreMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BuilderMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CallTemplateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PayloadFactoryMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EnqueueMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (URLRewriteMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ValidateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RouterMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ConditionalRouterMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BAMMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BeanMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EJBMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DefaultEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AddressEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FailoverEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RecipientListEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (WSDLEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (NamedEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LoadBalanceEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (APIResourceEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AddressingEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (HTTPEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TemplateEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloudConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloudConnectorOperationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LoopBackMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RespondMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CallMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DataMapperMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FastXSLTMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ForEachMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PublishEventMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case MediatorFlowMediatorFlowCompartment7EditPart.VISUAL_ID:
			if (DropMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PropertyMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ThrottleMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FilterMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LogMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EnrichMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (XSLTMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SwitchMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SequenceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EventMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EntitlementMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ClassMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SpringMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ScriptMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FaultMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (XQueryMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CommandMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DBLookupMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DBReportMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SmooksMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SendMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (HeaderMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloneMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CacheMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (IterateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CalloutMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TransactionMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RMSequenceMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RuleMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (OAuthMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AggregateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (StoreMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BuilderMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CallTemplateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PayloadFactoryMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EnqueueMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (URLRewriteMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ValidateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RouterMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ConditionalRouterMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BAMMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BeanMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EJBMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DefaultEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AddressEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FailoverEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RecipientListEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (WSDLEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (NamedEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LoadBalanceEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (APIResourceEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AddressingEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (HTTPEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TemplateEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloudConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloudConnectorOperationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LoopBackMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RespondMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CallMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DataMapperMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FastXSLTMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ForEachMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PublishEventMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case MediatorFlowMediatorFlowCompartment2EditPart.VISUAL_ID:
			if (DropMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PropertyMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ThrottleMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FilterMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LogMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EnrichMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (XSLTMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SwitchMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SequenceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EventMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EntitlementMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ClassMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SpringMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ScriptMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FaultMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (XQueryMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CommandMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DBLookupMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DBReportMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SmooksMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SendMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (HeaderMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloneMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CacheMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (IterateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CalloutMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TransactionMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RMSequenceMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RuleMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (OAuthMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AggregateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (StoreMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BuilderMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CallTemplateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PayloadFactoryMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EnqueueMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (URLRewriteMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ValidateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RouterMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ConditionalRouterMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BAMMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BeanMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EJBMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DefaultEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AddressEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FailoverEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RecipientListEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (WSDLEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (NamedEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LoadBalanceEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (APIResourceEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AddressingEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (HTTPEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TemplateEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloudConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloudConnectorOperationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LoopBackMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RespondMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CallMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DataMapperMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FastXSLTMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ForEachMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PublishEventMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case MediatorFlowMediatorFlowCompartment21EditPart.VISUAL_ID:
			if (DropMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PropertyMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ThrottleMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FilterMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LogMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EnrichMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (XSLTMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SwitchMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SequenceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EventMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EntitlementMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ClassMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SpringMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ScriptMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FaultMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (XQueryMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CommandMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DBLookupMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DBReportMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SmooksMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SendMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (HeaderMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloneMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CacheMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (IterateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CalloutMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TransactionMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RMSequenceMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RuleMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (OAuthMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AggregateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (StoreMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BuilderMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CallTemplateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PayloadFactoryMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EnqueueMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (URLRewriteMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ValidateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RouterMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ConditionalRouterMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BAMMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BeanMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EJBMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DefaultEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AddressEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FailoverEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RecipientListEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (WSDLEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (NamedEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LoadBalanceEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (APIResourceEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AddressingEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (HTTPEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TemplateEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloudConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloudConnectorOperationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LoopBackMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RespondMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CallMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DataMapperMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FastXSLTMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ForEachMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PublishEventMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case MediatorFlowMediatorFlowCompartment19EditPart.VISUAL_ID:
			if (DropMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PropertyMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ThrottleMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FilterMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LogMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EnrichMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (XSLTMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SwitchMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SequenceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EventMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EntitlementMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ClassMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SpringMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ScriptMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FaultMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (XQueryMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CommandMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DBLookupMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DBReportMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SmooksMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SendMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (HeaderMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloneMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CacheMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (IterateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CalloutMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TransactionMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RMSequenceMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RuleMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (OAuthMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AggregateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (StoreMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BuilderMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CallTemplateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PayloadFactoryMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EnqueueMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (URLRewriteMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ValidateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RouterMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ConditionalRouterMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BAMMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BeanMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EJBMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DefaultEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AddressEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FailoverEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RecipientListEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (WSDLEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (NamedEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LoadBalanceEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (APIResourceEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AddressingEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (HTTPEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TemplateEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloudConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloudConnectorOperationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LoopBackMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RespondMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CallMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DataMapperMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FastXSLTMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ForEachMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PublishEventMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case MediatorFlowMediatorFlowCompartment11EditPart.VISUAL_ID:
			if (DropMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PropertyMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ThrottleMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FilterMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LogMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EnrichMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (XSLTMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SwitchMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SequenceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EventMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EntitlementMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ClassMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SpringMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ScriptMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FaultMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (XQueryMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CommandMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DBLookupMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DBReportMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SmooksMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SendMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (HeaderMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloneMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CacheMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (IterateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CalloutMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TransactionMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RMSequenceMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RuleMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (OAuthMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AggregateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (StoreMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BuilderMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CallTemplateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PayloadFactoryMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EnqueueMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (URLRewriteMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ValidateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RouterMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ConditionalRouterMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BAMMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BeanMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EJBMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DefaultEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AddressEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FailoverEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RecipientListEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (WSDLEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (NamedEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LoadBalanceEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (APIResourceEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AddressingEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (HTTPEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TemplateEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloudConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloudConnectorOperationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LoopBackMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RespondMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CallMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DataMapperMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FastXSLTMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ForEachMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PublishEventMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case MediatorFlowMediatorFlowCompartment13EditPart.VISUAL_ID:
			if (DropMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PropertyMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ThrottleMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FilterMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LogMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EnrichMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (XSLTMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SwitchMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SequenceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EventMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EntitlementMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ClassMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SpringMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ScriptMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FaultMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (XQueryMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CommandMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DBLookupMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DBReportMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SmooksMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SendMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (HeaderMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloneMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CacheMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (IterateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CalloutMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TransactionMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RMSequenceMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RuleMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (OAuthMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AggregateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (StoreMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BuilderMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CallTemplateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PayloadFactoryMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EnqueueMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (URLRewriteMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ValidateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RouterMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ConditionalRouterMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BAMMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BeanMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EJBMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DefaultEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AddressEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FailoverEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RecipientListEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (WSDLEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (NamedEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LoadBalanceEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (APIResourceEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AddressingEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (HTTPEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TemplateEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloudConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloudConnectorOperationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LoopBackMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RespondMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CallMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DataMapperMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FastXSLTMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ForEachMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PublishEventMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case MediatorFlowMediatorFlowCompartment12EditPart.VISUAL_ID:
			if (DropMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PropertyMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ThrottleMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FilterMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LogMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EnrichMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (XSLTMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SwitchMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SequenceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EventMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EntitlementMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ClassMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SpringMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ScriptMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FaultMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (XQueryMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CommandMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DBLookupMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DBReportMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SmooksMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SendMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (HeaderMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloneMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CacheMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (IterateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CalloutMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TransactionMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RMSequenceMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RuleMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (OAuthMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AggregateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (StoreMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BuilderMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CallTemplateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PayloadFactoryMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EnqueueMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (URLRewriteMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ValidateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RouterMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ConditionalRouterMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BAMMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BeanMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EJBMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DefaultEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AddressEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FailoverEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RecipientListEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (WSDLEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (NamedEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LoadBalanceEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (APIResourceEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AddressingEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (HTTPEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TemplateEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloudConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloudConnectorOperationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LoopBackMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RespondMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CallMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DataMapperMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FastXSLTMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ForEachMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PublishEventMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case MediatorFlowMediatorFlowCompartment17EditPart.VISUAL_ID:
			if (DropMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PropertyMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ThrottleMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FilterMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LogMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EnrichMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (XSLTMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SwitchMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SequenceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EventMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EntitlementMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ClassMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SpringMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ScriptMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FaultMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (XQueryMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CommandMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DBLookupMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DBReportMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SmooksMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SendMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (HeaderMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloneMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CacheMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (IterateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CalloutMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TransactionMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RMSequenceMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RuleMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (OAuthMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AggregateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (StoreMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BuilderMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CallTemplateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PayloadFactoryMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EnqueueMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (URLRewriteMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ValidateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RouterMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ConditionalRouterMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BAMMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BeanMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EJBMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DefaultEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AddressEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FailoverEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RecipientListEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (WSDLEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (NamedEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LoadBalanceEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (APIResourceEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AddressingEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (HTTPEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TemplateEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloudConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloudConnectorOperationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LoopBackMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RespondMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CallMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DataMapperMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FastXSLTMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ForEachMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PublishEventMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case MediatorFlowMediatorFlowCompartment3EditPart.VISUAL_ID:
			if (DropMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PropertyMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ThrottleMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FilterMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LogMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EnrichMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (XSLTMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SwitchMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SequenceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EventMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EntitlementMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ClassMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SpringMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ScriptMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FaultMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (XQueryMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CommandMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DBLookupMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DBReportMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SmooksMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SendMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (HeaderMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloneMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CacheMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (IterateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CalloutMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TransactionMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RMSequenceMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RuleMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (OAuthMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AggregateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (StoreMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BuilderMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CallTemplateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PayloadFactoryMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EnqueueMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (URLRewriteMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ValidateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RouterMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ConditionalRouterMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BAMMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BeanMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EJBMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DefaultEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AddressEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FailoverEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RecipientListEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (WSDLEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (NamedEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LoadBalanceEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (APIResourceEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AddressingEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (HTTPEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TemplateEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloudConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloudConnectorOperationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LoopBackMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RespondMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CallMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DataMapperMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FastXSLTMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ForEachMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PublishEventMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case MediatorFlowMediatorFlowCompartment14EditPart.VISUAL_ID:
			if (DropMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PropertyMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ThrottleMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FilterMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LogMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EnrichMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (XSLTMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SwitchMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SequenceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EventMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EntitlementMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ClassMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SpringMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ScriptMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FaultMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (XQueryMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CommandMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DBLookupMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DBReportMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SmooksMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SendMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (HeaderMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloneMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CacheMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (IterateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CalloutMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TransactionMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RMSequenceMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RuleMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (OAuthMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AggregateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (StoreMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BuilderMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CallTemplateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PayloadFactoryMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EnqueueMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (URLRewriteMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ValidateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RouterMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ConditionalRouterMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BAMMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BeanMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EJBMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DefaultEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AddressEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FailoverEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RecipientListEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (WSDLEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (NamedEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LoadBalanceEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (APIResourceEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AddressingEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (HTTPEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TemplateEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloudConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloudConnectorOperationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LoopBackMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RespondMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CallMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DataMapperMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FastXSLTMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ForEachMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PublishEventMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case MediatorFlowMediatorFlowCompartment15EditPart.VISUAL_ID:
			if (DropMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PropertyMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ThrottleMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FilterMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LogMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EnrichMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (XSLTMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SwitchMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SequenceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EventMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EntitlementMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ClassMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SpringMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ScriptMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FaultMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (XQueryMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CommandMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DBLookupMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DBReportMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SmooksMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SendMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (HeaderMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloneMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CacheMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (IterateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CalloutMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TransactionMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RMSequenceMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RuleMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (OAuthMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AggregateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (StoreMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BuilderMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CallTemplateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PayloadFactoryMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EnqueueMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (URLRewriteMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ValidateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RouterMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ConditionalRouterMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BAMMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BeanMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EJBMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DefaultEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AddressEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FailoverEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RecipientListEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (WSDLEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (NamedEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LoadBalanceEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (APIResourceEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AddressingEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (HTTPEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TemplateEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloudConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloudConnectorOperationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LoopBackMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RespondMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CallMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DataMapperMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FastXSLTMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ForEachMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PublishEventMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case MediatorFlowMediatorFlowCompartment16EditPart.VISUAL_ID:
			if (DropMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PropertyMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ThrottleMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FilterMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LogMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EnrichMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (XSLTMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SwitchMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SequenceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EventMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EntitlementMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ClassMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SpringMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ScriptMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FaultMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (XQueryMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CommandMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DBLookupMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DBReportMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SmooksMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SendMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (HeaderMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloneMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CacheMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (IterateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CalloutMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TransactionMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RMSequenceMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RuleMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (OAuthMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AggregateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (StoreMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BuilderMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CallTemplateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PayloadFactoryMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EnqueueMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (URLRewriteMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ValidateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RouterMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ConditionalRouterMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BAMMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BeanMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EJBMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DefaultEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AddressEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FailoverEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RecipientListEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (WSDLEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (NamedEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LoadBalanceEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (APIResourceEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AddressingEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (HTTPEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TemplateEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloudConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloudConnectorOperationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LoopBackMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RespondMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CallMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DataMapperMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FastXSLTMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ForEachMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PublishEventMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case MediatorFlowMediatorFlowCompartment20EditPart.VISUAL_ID:
			if (DropMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PropertyMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ThrottleMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FilterMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LogMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EnrichMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (XSLTMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SwitchMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SequenceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EventMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EntitlementMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ClassMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SpringMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ScriptMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FaultMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (XQueryMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CommandMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DBLookupMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DBReportMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SmooksMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SendMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (HeaderMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloneMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CacheMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (IterateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CalloutMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TransactionMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RMSequenceMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RuleMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (OAuthMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AggregateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (StoreMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BuilderMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CallTemplateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PayloadFactoryMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EnqueueMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (URLRewriteMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ValidateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RouterMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ConditionalRouterMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BAMMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BeanMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EJBMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DefaultEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AddressEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FailoverEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RecipientListEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (WSDLEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (NamedEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LoadBalanceEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (APIResourceEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AddressingEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (HTTPEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TemplateEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloudConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloudConnectorOperationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LoopBackMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RespondMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CallMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DataMapperMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FastXSLTMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ForEachMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PublishEventMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case MediatorFlowMediatorFlowCompartment30EditPart.VISUAL_ID:
			if (DropMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PropertyMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ThrottleMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FilterMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LogMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EnrichMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (XSLTMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SwitchMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SequenceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EventMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EntitlementMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ClassMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SpringMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ScriptMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FaultMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (XQueryMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CommandMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DBLookupMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DBReportMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SmooksMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SendMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (HeaderMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloneMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CacheMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (IterateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CalloutMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TransactionMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RMSequenceMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RuleMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (OAuthMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AggregateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (StoreMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BuilderMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CallTemplateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PayloadFactoryMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EnqueueMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (URLRewriteMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ValidateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RouterMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ConditionalRouterMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BAMMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BeanMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EJBMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DefaultEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AddressEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FailoverEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RecipientListEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (WSDLEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (NamedEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LoadBalanceEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (APIResourceEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AddressingEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (HTTPEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TemplateEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloudConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloudConnectorOperationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LoopBackMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RespondMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CallMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DataMapperMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FastXSLTMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ForEachMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PublishEventMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case MediatorFlowMediatorFlowCompartment22EditPart.VISUAL_ID:
			if (DropMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PropertyMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ThrottleMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FilterMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LogMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EnrichMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (XSLTMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SwitchMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SequenceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EventMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EntitlementMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ClassMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SpringMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ScriptMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FaultMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (XQueryMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CommandMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DBLookupMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DBReportMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SmooksMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SendMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (HeaderMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloneMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CacheMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (IterateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CalloutMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TransactionMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RMSequenceMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RuleMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (OAuthMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AggregateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (StoreMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BuilderMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CallTemplateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PayloadFactoryMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EnqueueMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (URLRewriteMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ValidateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RouterMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ConditionalRouterMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BAMMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BeanMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EJBMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DefaultEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AddressEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FailoverEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RecipientListEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (WSDLEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (NamedEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LoadBalanceEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (APIResourceEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AddressingEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (HTTPEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TemplateEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloudConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloudConnectorOperationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LoopBackMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RespondMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CallMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DataMapperMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FastXSLTMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ForEachMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PublishEventMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case MediatorFlowMediatorFlowCompartment23EditPart.VISUAL_ID:
			if (DropMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PropertyMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ThrottleMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FilterMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LogMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EnrichMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (XSLTMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SwitchMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SequenceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EventMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EntitlementMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ClassMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SpringMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ScriptMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FaultMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (XQueryMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CommandMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DBLookupMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DBReportMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SmooksMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SendMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (HeaderMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloneMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CacheMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (IterateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CalloutMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TransactionMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RMSequenceMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RuleMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (OAuthMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AggregateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (StoreMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BuilderMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CallTemplateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PayloadFactoryMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EnqueueMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (URLRewriteMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ValidateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RouterMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ConditionalRouterMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BAMMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BeanMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EJBMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DefaultEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AddressEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FailoverEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RecipientListEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (WSDLEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (NamedEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LoadBalanceEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (APIResourceEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AddressingEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (HTTPEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TemplateEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloudConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloudConnectorOperationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LoopBackMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RespondMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CallMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DataMapperMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FastXSLTMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ForEachMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PublishEventMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case MediatorFlowMediatorFlowCompartment24EditPart.VISUAL_ID:
			if (DropMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PropertyMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ThrottleMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FilterMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LogMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EnrichMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (XSLTMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SwitchMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SequenceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EventMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EntitlementMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ClassMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SpringMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ScriptMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FaultMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (XQueryMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CommandMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DBLookupMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DBReportMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SmooksMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SendMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (HeaderMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloneMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CacheMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (IterateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CalloutMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TransactionMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RMSequenceMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RuleMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (OAuthMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AggregateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (StoreMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BuilderMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CallTemplateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PayloadFactoryMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EnqueueMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (URLRewriteMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ValidateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RouterMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ConditionalRouterMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BAMMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BeanMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EJBMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DefaultEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AddressEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FailoverEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RecipientListEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (WSDLEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (NamedEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LoadBalanceEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (APIResourceEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AddressingEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (HTTPEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TemplateEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloudConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloudConnectorOperationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LoopBackMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RespondMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CallMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DataMapperMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FastXSLTMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ForEachMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PublishEventMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case MediatorFlowMediatorFlowCompartment4EditPart.VISUAL_ID:
			if (DropMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PropertyMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ThrottleMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FilterMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LogMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EnrichMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (XSLTMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SwitchMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SequenceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EventMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EntitlementMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ClassMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SpringMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ScriptMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FaultMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (XQueryMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CommandMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DBLookupMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DBReportMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SmooksMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SendMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (HeaderMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloneMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CacheMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (IterateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CalloutMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TransactionMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RMSequenceMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RuleMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (OAuthMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AggregateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (StoreMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BuilderMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CallTemplateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PayloadFactoryMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EnqueueMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (URLRewriteMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ValidateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RouterMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ConditionalRouterMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BAMMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BeanMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EJBMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DefaultEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AddressEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FailoverEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RecipientListEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (WSDLEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (NamedEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LoadBalanceEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (APIResourceEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AddressingEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (HTTPEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TemplateEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloudConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloudConnectorOperationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LoopBackMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RespondMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CallMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DataMapperMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FastXSLTMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ForEachMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PublishEventMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case MediatorFlowMediatorFlowCompartment8EditPart.VISUAL_ID:
			if (DropMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PropertyMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ThrottleMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FilterMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LogMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EnrichMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (XSLTMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SwitchMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SequenceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EventMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EntitlementMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ClassMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SpringMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ScriptMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FaultMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (XQueryMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CommandMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DBLookupMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DBReportMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SmooksMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SendMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (HeaderMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloneMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CacheMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (IterateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CalloutMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TransactionMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RMSequenceMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RuleMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (OAuthMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AggregateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (StoreMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BuilderMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CallTemplateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PayloadFactoryMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EnqueueMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (URLRewriteMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ValidateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RouterMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ConditionalRouterMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BAMMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BeanMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EJBMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DefaultEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AddressEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FailoverEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RecipientListEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (WSDLEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (NamedEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LoadBalanceEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (APIResourceEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AddressingEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (HTTPEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TemplateEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloudConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloudConnectorOperationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LoopBackMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RespondMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CallMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DataMapperMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FastXSLTMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ForEachMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PublishEventMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case MediatorFlowMediatorFlowCompartment10EditPart.VISUAL_ID:
			if (DropMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PropertyMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ThrottleMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FilterMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LogMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EnrichMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (XSLTMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SwitchMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SequenceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EventMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EntitlementMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ClassMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SpringMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ScriptMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FaultMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (XQueryMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CommandMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DBLookupMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DBReportMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SmooksMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SendMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (HeaderMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloneMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CacheMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (IterateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CalloutMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TransactionMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RMSequenceMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RuleMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (OAuthMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AggregateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (StoreMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BuilderMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CallTemplateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PayloadFactoryMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EnqueueMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (URLRewriteMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ValidateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RouterMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ConditionalRouterMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BAMMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BeanMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EJBMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DefaultEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AddressEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FailoverEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RecipientListEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (WSDLEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (NamedEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LoadBalanceEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (APIResourceEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AddressingEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (HTTPEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TemplateEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloudConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloudConnectorOperationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LoopBackMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RespondMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CallMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DataMapperMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FastXSLTMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ForEachMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PublishEventMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case MediatorFlowMediatorFlowCompartment6EditPart.VISUAL_ID:
			if (DropMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PropertyMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ThrottleMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FilterMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LogMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EnrichMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (XSLTMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SwitchMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SequenceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EventMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EntitlementMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ClassMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SpringMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ScriptMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FaultMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (XQueryMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CommandMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DBLookupMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DBReportMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SmooksMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SendMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (HeaderMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloneMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CacheMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (IterateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CalloutMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TransactionMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RMSequenceMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RuleMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (OAuthMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AggregateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (StoreMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BuilderMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CallTemplateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PayloadFactoryMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EnqueueMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (URLRewriteMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ValidateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RouterMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ConditionalRouterMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BAMMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BeanMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EJBMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DefaultEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AddressEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FailoverEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RecipientListEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (WSDLEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (NamedEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LoadBalanceEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (APIResourceEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AddressingEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (HTTPEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TemplateEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloudConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloudConnectorOperationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LoopBackMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RespondMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CallMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DataMapperMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FastXSLTMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ForEachMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PublishEventMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case MediatorFlowMediatorFlowCompartment5EditPart.VISUAL_ID:
			if (DropMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PropertyMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ThrottleMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FilterMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LogMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EnrichMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (XSLTMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SwitchMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SequenceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EventMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EntitlementMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ClassMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SpringMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ScriptMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FaultMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (XQueryMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CommandMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DBLookupMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DBReportMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SmooksMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SendMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (HeaderMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloneMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CacheMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (IterateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CalloutMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TransactionMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RMSequenceMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RuleMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (OAuthMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AggregateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (StoreMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BuilderMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CallTemplateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PayloadFactoryMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EnqueueMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (URLRewriteMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ValidateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RouterMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ConditionalRouterMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BAMMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BeanMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EJBMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DefaultEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AddressEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FailoverEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RecipientListEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (WSDLEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (NamedEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LoadBalanceEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (APIResourceEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AddressingEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (HTTPEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TemplateEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloudConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloudConnectorOperationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LoopBackMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RespondMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CallMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DataMapperMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FastXSLTMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ForEachMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PublishEventMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case EndpointDiagramEndpointCompartmentEditPart.VISUAL_ID:
			if (DefaultEndPoint2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AddressEndPoint2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FailoverEndPoint2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RecipientListEndPoint2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (WSDLEndPoint2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LoadBalanceEndPoint2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (HTTPEndpoint2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TemplateEndpoint2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case MediatorFlowMediatorFlowCompartment27EditPart.VISUAL_ID:
			if (DropMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PropertyMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ThrottleMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FilterMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LogMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EnrichMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (XSLTMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SwitchMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SequenceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EventMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EntitlementMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ClassMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SpringMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ScriptMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FaultMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (XQueryMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CommandMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DBLookupMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DBReportMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SmooksMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SendMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (HeaderMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloneMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CacheMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (IterateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CalloutMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TransactionMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RMSequenceMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RuleMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (OAuthMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AggregateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (StoreMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BuilderMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CallTemplateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PayloadFactoryMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EnqueueMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (URLRewriteMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ValidateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RouterMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ConditionalRouterMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BAMMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BeanMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EJBMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DefaultEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AddressEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FailoverEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RecipientListEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (WSDLEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (NamedEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LoadBalanceEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (APIResourceEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AddressingEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (HTTPEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TemplateEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloudConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloudConnectorOperationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LoopBackMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RespondMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CallMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DataMapperMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FastXSLTMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ForEachMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PublishEventMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case MediatorFlowMediatorFlowCompartment28EditPart.VISUAL_ID:
			if (DropMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PropertyMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ThrottleMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FilterMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LogMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EnrichMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (XSLTMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SwitchMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SequenceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EventMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EntitlementMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ClassMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SpringMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ScriptMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FaultMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (XQueryMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CommandMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DBLookupMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DBReportMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SmooksMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SendMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (HeaderMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloneMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CacheMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (IterateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CalloutMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TransactionMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RMSequenceMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RuleMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (OAuthMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AggregateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (StoreMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BuilderMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CallTemplateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PayloadFactoryMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EnqueueMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (URLRewriteMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ValidateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RouterMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ConditionalRouterMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BAMMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BeanMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EJBMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DefaultEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AddressEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FailoverEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RecipientListEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (WSDLEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (NamedEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LoadBalanceEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (APIResourceEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AddressingEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (HTTPEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TemplateEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloudConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloudConnectorOperationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LoopBackMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RespondMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CallMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DataMapperMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FastXSLTMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ForEachMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PublishEventMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case MediatorFlowMediatorFlowCompartment29EditPart.VISUAL_ID:
			if (DropMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PropertyMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ThrottleMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FilterMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LogMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EnrichMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (XSLTMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SwitchMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SequenceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EventMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EntitlementMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ClassMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SpringMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ScriptMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FaultMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (XQueryMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CommandMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DBLookupMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DBReportMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SmooksMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SendMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (HeaderMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloneMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CacheMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (IterateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CalloutMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TransactionMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RMSequenceMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RuleMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (OAuthMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AggregateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (StoreMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BuilderMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CallTemplateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PayloadFactoryMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EnqueueMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (URLRewriteMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ValidateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RouterMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ConditionalRouterMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BAMMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BeanMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EJBMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DefaultEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AddressEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FailoverEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RecipientListEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (WSDLEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (NamedEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LoadBalanceEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (APIResourceEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AddressingEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (HTTPEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TemplateEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloudConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloudConnectorOperationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LoopBackMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RespondMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CallMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DataMapperMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FastXSLTMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ForEachMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PublishEventMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case TemplateTemplateCompartmentEditPart.VISUAL_ID:
			if (Sequences2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EndpointDiagram2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case EndpointDiagramEndpointCompartment2EditPart.VISUAL_ID:
			if (DefaultEndPoint2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AddressEndPoint2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FailoverEndPoint2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RecipientListEndPoint2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (WSDLEndPoint2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LoadBalanceEndPoint2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (HTTPEndpoint2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TemplateEndpoint2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case SynapseAPIAPICompartmentEditPart.VISUAL_ID:
			if (APIResourceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case MediatorFlowMediatorFlowCompartment18EditPart.VISUAL_ID:
			if (DropMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PropertyMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ThrottleMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FilterMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LogMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EnrichMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (XSLTMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SwitchMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SequenceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EventMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EntitlementMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ClassMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SpringMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ScriptMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FaultMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (XQueryMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CommandMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DBLookupMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DBReportMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SmooksMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SendMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (HeaderMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloneMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CacheMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (IterateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CalloutMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TransactionMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RMSequenceMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RuleMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (OAuthMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AggregateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (StoreMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BuilderMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CallTemplateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PayloadFactoryMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EnqueueMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (URLRewriteMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ValidateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RouterMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ConditionalRouterMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BAMMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BeanMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EJBMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DefaultEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AddressEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FailoverEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RecipientListEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (WSDLEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (NamedEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LoadBalanceEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (APIResourceEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AddressingEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (HTTPEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TemplateEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloudConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloudConnectorOperationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LoopBackMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RespondMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CallMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DataMapperMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FastXSLTMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ForEachMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PublishEventMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case MediatorFlowMediatorFlowCompartment25EditPart.VISUAL_ID:
			if (DropMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PropertyMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ThrottleMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FilterMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LogMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EnrichMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (XSLTMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SwitchMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SequenceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EventMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EntitlementMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ClassMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SpringMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ScriptMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FaultMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (XQueryMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CommandMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DBLookupMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DBReportMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SmooksMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SendMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (HeaderMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloneMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CacheMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (IterateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CalloutMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TransactionMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RMSequenceMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RuleMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (OAuthMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AggregateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (StoreMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BuilderMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CallTemplateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PayloadFactoryMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EnqueueMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (URLRewriteMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ValidateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RouterMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ConditionalRouterMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BAMMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BeanMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EJBMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DefaultEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AddressEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FailoverEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RecipientListEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (WSDLEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (NamedEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LoadBalanceEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (APIResourceEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AddressingEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (HTTPEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TemplateEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloudConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloudConnectorOperationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LoopBackMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RespondMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CallMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DataMapperMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FastXSLTMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ForEachMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PublishEventMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case MediatorFlowMediatorFlowCompartment26EditPart.VISUAL_ID:
			if (DropMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PropertyMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ThrottleMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FilterMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LogMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EnrichMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (XSLTMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SwitchMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SequenceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EventMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EntitlementMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ClassMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SpringMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ScriptMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FaultMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (XQueryMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CommandMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DBLookupMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DBReportMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SmooksMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SendMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (HeaderMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloneMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CacheMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (IterateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CalloutMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TransactionMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RMSequenceMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RuleMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (OAuthMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AggregateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (StoreMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BuilderMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CallTemplateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PayloadFactoryMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EnqueueMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (URLRewriteMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ValidateMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RouterMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ConditionalRouterMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BAMMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BeanMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EJBMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DefaultEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AddressEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FailoverEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RecipientListEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (WSDLEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (NamedEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LoadBalanceEndPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (APIResourceEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AddressingEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (HTTPEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TemplateEndpointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloudConnectorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CloudConnectorOperationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LoopBackMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RespondMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CallMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DataMapperMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FastXSLTMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ForEachMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PublishEventMediatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static int getLinkWithClassVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		if (EsbPackage.eINSTANCE.getEsbLink().isSuperTypeOf(domainElement.eClass())) {
			return EsbLinkEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static boolean isDiagram(EsbDiagram element) {
		return true;
	}

	/**
	 * @generated
	 */
	public static boolean checkNodeVisualID(View containerView, EObject domainElement, int candidate) {
		if (candidate == -1) {
			//unrecognized id is always bad
			return false;
		}
		int basic = getNodeVisualID(containerView, domainElement);
		return basic == candidate;
	}

	/**
	 * @generated
	 */
	public static boolean isCompartmentVisualID(int visualID) {
		switch (visualID) {
		case EsbServerContentsCompartmentEditPart.VISUAL_ID:
		case MediatorFlowMediatorFlowCompartmentEditPart.VISUAL_ID:
		case MediatorFlowMediatorFlowCompartment9EditPart.VISUAL_ID:
		case MediatorFlowMediatorFlowCompartment7EditPart.VISUAL_ID:
		case MediatorFlowMediatorFlowCompartment2EditPart.VISUAL_ID:
		case MediatorFlowMediatorFlowCompartment21EditPart.VISUAL_ID:
		case MediatorFlowMediatorFlowCompartment19EditPart.VISUAL_ID:
		case MediatorFlowMediatorFlowCompartment11EditPart.VISUAL_ID:
		case MediatorFlowMediatorFlowCompartment13EditPart.VISUAL_ID:
		case MediatorFlowMediatorFlowCompartment12EditPart.VISUAL_ID:
		case MediatorFlowMediatorFlowCompartment17EditPart.VISUAL_ID:
		case MediatorFlowMediatorFlowCompartment3EditPart.VISUAL_ID:
		case MediatorFlowMediatorFlowCompartment14EditPart.VISUAL_ID:
		case MediatorFlowMediatorFlowCompartment15EditPart.VISUAL_ID:
		case MediatorFlowMediatorFlowCompartment16EditPart.VISUAL_ID:
		case MediatorFlowMediatorFlowCompartment20EditPart.VISUAL_ID:
		case MediatorFlowMediatorFlowCompartment30EditPart.VISUAL_ID:
		case MediatorFlowMediatorFlowCompartment22EditPart.VISUAL_ID:
		case MediatorFlowMediatorFlowCompartment23EditPart.VISUAL_ID:
		case MediatorFlowMediatorFlowCompartment24EditPart.VISUAL_ID:
		case MediatorFlowMediatorFlowCompartment4EditPart.VISUAL_ID:
		case MediatorFlowMediatorFlowCompartment8EditPart.VISUAL_ID:
		case MediatorFlowMediatorFlowCompartment10EditPart.VISUAL_ID:
		case MediatorFlowMediatorFlowCompartment6EditPart.VISUAL_ID:
		case MediatorFlowMediatorFlowCompartment5EditPart.VISUAL_ID:
		case EndpointDiagramEndpointCompartmentEditPart.VISUAL_ID:
		case MediatorFlowMediatorFlowCompartment27EditPart.VISUAL_ID:
		case MediatorFlowMediatorFlowCompartment28EditPart.VISUAL_ID:
		case MediatorFlowMediatorFlowCompartment29EditPart.VISUAL_ID:
		case TemplateTemplateCompartmentEditPart.VISUAL_ID:
		case EndpointDiagramEndpointCompartment2EditPart.VISUAL_ID:
		case SynapseAPIAPICompartmentEditPart.VISUAL_ID:
		case MediatorFlowMediatorFlowCompartment18EditPart.VISUAL_ID:
		case MediatorFlowMediatorFlowCompartment25EditPart.VISUAL_ID:
		case MediatorFlowMediatorFlowCompartment26EditPart.VISUAL_ID:
			return true;
		default:
			break;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static boolean isSemanticLeafVisualID(int visualID) {
		switch (visualID) {
		case EsbDiagramEditPart.VISUAL_ID:
			return false;
		case ProxyOutputConnectorEditPart.VISUAL_ID:
		case ProxyInputConnectorEditPart.VISUAL_ID:
		case DropMediatorInputConnectorEditPart.VISUAL_ID:
		case FilterMediatorInputConnectorEditPart.VISUAL_ID:
		case FilterMediatorPassOutputConnectorEditPart.VISUAL_ID:
		case FilterMediatorFailOutputConnectorEditPart.VISUAL_ID:
		case MergeNodeFirstInputConnectorEditPart.VISUAL_ID:
		case MergeNodeSecondInputConnectorEditPart.VISUAL_ID:
		case MergeNodeOutputConnectorEditPart.VISUAL_ID:
		case LogMediatorInputConnectorEditPart.VISUAL_ID:
		case LogMediatorOutputConnectorEditPart.VISUAL_ID:
		case DefaultEndPointInputConnectorEditPart.VISUAL_ID:
		case DefaultEndPointOutputConnectorEditPart.VISUAL_ID:
		case AddressEndPointInputConnectorEditPart.VISUAL_ID:
		case AddressEndPointOutputConnectorEditPart.VISUAL_ID:
		case PropertyMediatorInputConnectorEditPart.VISUAL_ID:
		case PropertyMediatorOutputConnectorEditPart.VISUAL_ID:
		case EnrichMediatorInputConnectorEditPart.VISUAL_ID:
		case EnrichMediatorOutputConnectorEditPart.VISUAL_ID:
		case XSLTMediatorInputConnectorEditPart.VISUAL_ID:
		case XSLTMediatorOutputConnectorEditPart.VISUAL_ID:
		case SwitchMediatorInputConnectorEditPart.VISUAL_ID:
		case SwitchCaseBranchOutputConnectorEditPart.VISUAL_ID:
		case SwitchDefaultBranchOutputConnectorEditPart.VISUAL_ID:
		case MessageInputConnectorEditPart.VISUAL_ID:
		case MessageOutputConnectorEditPart.VISUAL_ID:
		case SequenceInputConnectorEditPart.VISUAL_ID:
		case SequenceOutputConnectorEditPart.VISUAL_ID:
		case EventMediatorInputConnectorEditPart.VISUAL_ID:
		case EventMediatorOutputConnectorEditPart.VISUAL_ID:
		case EntitlementMediatorInputConnectorEditPart.VISUAL_ID:
		case EntitlementMediatorOutputConnectorEditPart.VISUAL_ID:
		case ClassMediatorInputConnectorEditPart.VISUAL_ID:
		case ClassMediatorOutputConnectorEditPart.VISUAL_ID:
		case SpringMediatorInputConnectorEditPart.VISUAL_ID:
		case SpringMediatorOutputConnectorEditPart.VISUAL_ID:
		case ScriptMediatorInputConnectorEditPart.VISUAL_ID:
		case ScriptMediatorOutputConnectorEditPart.VISUAL_ID:
		case FaultMediatorInputConnectorEditPart.VISUAL_ID:
		case FaultMediatorOutputConnectorEditPart.VISUAL_ID:
		case XQueryMediatorInputConnectorEditPart.VISUAL_ID:
		case XQueryMediatorOutputConnectorEditPart.VISUAL_ID:
		case CommandMediatorInputConnectorEditPart.VISUAL_ID:
		case CommandMediatorOutputConnectorEditPart.VISUAL_ID:
		case DBLookupMediatorInputConnectorEditPart.VISUAL_ID:
		case DBLookupMediatorOutputConnectorEditPart.VISUAL_ID:
		case DBReportMediatorInputConnectorEditPart.VISUAL_ID:
		case DBReportMediatorOutputConnectorEditPart.VISUAL_ID:
		case SmooksMediatorInputConnectorEditPart.VISUAL_ID:
		case SmooksMediatorOutputConnectorEditPart.VISUAL_ID:
		case SendMediatorInputConnectorEditPart.VISUAL_ID:
		case SendMediatorOutputConnectorEditPart.VISUAL_ID:
		case FailoverEndPointInputConnectorEditPart.VISUAL_ID:
		case FailoverEndPointOutputConnectorEditPart.VISUAL_ID:
		case WSDLEndPointInputConnectorEditPart.VISUAL_ID:
		case WSDLEndPointOutputConnectorEditPart.VISUAL_ID:
		case LoadBalanceEndPointInputConnectorEditPart.VISUAL_ID:
		case LoadBalanceEndPointOutputConnectorEditPart.VISUAL_ID:
		case FailoverEndPointWestOutputConnectorEditPart.VISUAL_ID:
		case LoadBalanceEndPointWestOutputConnectorEditPart.VISUAL_ID:
		case HeaderMediatorInputConnectorEditPart.VISUAL_ID:
		case HeaderMediatorOutputConnectorEditPart.VISUAL_ID:
		case CloneMediatorInputConnectorEditPart.VISUAL_ID:
		case CloneMediatorOutputConnectorEditPart.VISUAL_ID:
		case CacheMediatorInputConnectorEditPart.VISUAL_ID:
		case CacheMediatorOutputConnectorEditPart.VISUAL_ID:
		case IterateMediatorInputConnectorEditPart.VISUAL_ID:
		case IterateMediatorOutputConnectorEditPart.VISUAL_ID:
		case AggregateMediatorInputConnectorEditPart.VISUAL_ID:
		case AggregateMediatorOutputConnectorEditPart.VISUAL_ID:
		case CalloutMediatorInputConnectorEditPart.VISUAL_ID:
		case CalloutMediatorOutputConnectorEditPart.VISUAL_ID:
		case TransactionMediatorInputConnectorEditPart.VISUAL_ID:
		case TransactionMediatorOutputConnectorEditPart.VISUAL_ID:
		case ThrottleMediatorInputConnectorEditPart.VISUAL_ID:
		case ThrottleMediatorOutputConnectorEditPart.VISUAL_ID:
		case RMSequenceMediatorInputConnectorEditPart.VISUAL_ID:
		case RMSequenceMediatorOutputConnectorEditPart.VISUAL_ID:
		case RuleMediatorInputConnectorEditPart.VISUAL_ID:
		case RuleMediatorOutputConnectorEditPart.VISUAL_ID:
		case OAuthMediatorInputConnectorEditPart.VISUAL_ID:
		case OAuthMediatorOutputConnectorEditPart.VISUAL_ID:
		case AggregateMediatorOnCompleteOutputConnectorEditPart.VISUAL_ID:
		case CloneMediatorTargetOutputConnectorEditPart.VISUAL_ID:
		case ProxyFaultInputConnectorEditPart.VISUAL_ID:
		case SwitchMediatorOutputConnectorEditPart.VISUAL_ID:
		case FilterMediatorOutputConnectorEditPart.VISUAL_ID:
		case SendMediatorEndpointOutputConnectorEditPart.VISUAL_ID:
		case ThrottleMediatorOnAcceptOutputConnectorEditPart.VISUAL_ID:
		case ThrottleMediatorOnRejectOutputConnectorEditPart.VISUAL_ID:
		case StoreMediatorInputConnectorEditPart.VISUAL_ID:
		case StoreMediatorOutputConnectorEditPart.VISUAL_ID:
		case BuilderMediatorInputConnectorEditPart.VISUAL_ID:
		case BuilderMediatorOutputConectorEditPart.VISUAL_ID:
		case CallTemplateMediatorInputConnectorEditPart.VISUAL_ID:
		case CallTemplateMediatorOutputConnectorEditPart.VISUAL_ID:
		case PayloadFactoryMediatorInputConnectorEditPart.VISUAL_ID:
		case PayloadFactoryMediatorOutputConnectorEditPart.VISUAL_ID:
		case EnqueueMediatorInputConnectorEditPart.VISUAL_ID:
		case EnqueueMediatorOutputConnectorEditPart.VISUAL_ID:
		case IterateMediatorTargetOutputConnectorEditPart.VISUAL_ID:
		case SequencesInputConnectorEditPart.VISUAL_ID:
		case SequencesOutputConnectorEditPart.VISUAL_ID:
		case CacheMediatorOnHitOutputConnectorEditPart.VISUAL_ID:
		case URLRewriteMediatorInputConnectorEditPart.VISUAL_ID:
		case URLRewriteMediatorOutputConnectorEditPart.VISUAL_ID:
		case ValidateMediatorInputConnectorEditPart.VISUAL_ID:
		case ValidateMediatorOutputConnectorEditPart.VISUAL_ID:
		case ValidateMediatorOnFailOutputConnectorEditPart.VISUAL_ID:
		case RouterMediatorInputConnectorEditPart.VISUAL_ID:
		case RouterMediatorOutputConnectorEditPart.VISUAL_ID:
		case RouterMediatorTargetOutputConnectorEditPart.VISUAL_ID:
		case ConditionalRouterMediatorInputConnectorEditPart.VISUAL_ID:
		case ConditionalRouterMediatorOutputConnectorEditPart.VISUAL_ID:
		case ConditionalRouterMediatorAdditionalOutputConnectorEditPart.VISUAL_ID:
		case RuleMediatorChildMediatorsOutputConnectorEditPart.VISUAL_ID:
		case DefaultEndPointInputConnector2EditPart.VISUAL_ID:
		case DefaultEndPointOutputConnector2EditPart.VISUAL_ID:
		case AddressEndPointInputConnector2EditPart.VISUAL_ID:
		case AddressEndPointOutputConnector2EditPart.VISUAL_ID:
		case FailoverEndPointInputConnector2EditPart.VISUAL_ID:
		case FailoverEndPointOutputConnector2EditPart.VISUAL_ID:
		case FailoverEndPointWestOutputConnector2EditPart.VISUAL_ID:
		case WSDLEndPointInputConnector2EditPart.VISUAL_ID:
		case WSDLEndPointOutputConnector2EditPart.VISUAL_ID:
		case LoadBalanceEndPointInputConnector2EditPart.VISUAL_ID:
		case LoadBalanceEndPointOutputConnector2EditPart.VISUAL_ID:
		case LoadBalanceEndPointWestOutputConnector2EditPart.VISUAL_ID:
		case NamedEndpointInputConnectorEditPart.VISUAL_ID:
		case NamedEndpointOutputConnectorEditPart.VISUAL_ID:
		case LocalEntryEditPart.VISUAL_ID:
		case TaskEditPart.VISUAL_ID:
		case APIResourceInputConnectorEditPart.VISUAL_ID:
		case APIResourceOutputConnectorEditPart.VISUAL_ID:
		case APIResourceFaultInputConnectorEditPart.VISUAL_ID:
		case APIResourceEndpointInputConnectorEditPart.VISUAL_ID:
		case APIResourceEndpointOutputConnectorEditPart.VISUAL_ID:
		case ComplexEndpointsOutputConnectorEditPart.VISUAL_ID:
		case BAMMediatorInputConnectorEditPart.VISUAL_ID:
		case BAMMediatorOutputConnectorEditPart.VISUAL_ID:
		case BeanMediatorInputConnectorEditPart.VISUAL_ID:
		case BeanMediatorOutputConnectorEditPart.VISUAL_ID:
		case EJBMediatorInputConnectorEditPart.VISUAL_ID:
		case EJBMediatorOutputConnectorEditPart.VISUAL_ID:
		case AddressingEndpointInputConnectorEditPart.VISUAL_ID:
		case AddressingEndpointOutputConnectorEditPart.VISUAL_ID:
		case RecipientListEndPointInputConnectorEditPart.VISUAL_ID:
		case RecipientListEndPointOutputConnectorEditPart.VISUAL_ID:
		case RecipientListEndPointWestOutputConnectorEditPart.VISUAL_ID:
		case RecipientListEndPointInputConnector2EditPart.VISUAL_ID:
		case RecipientListEndPointOutputConnector2EditPart.VISUAL_ID:
		case RecipientListEndPointWestOutputConnector2EditPart.VISUAL_ID:
		case MessageProcessorEditPart.VISUAL_ID:
		case HTTPEndPointInputConnectorEditPart.VISUAL_ID:
		case HTTPEndPointOutputConnectorEditPart.VISUAL_ID:
		case HTTPEndPointInputConnector2EditPart.VISUAL_ID:
		case HTTPEndPointOutputConnector2EditPart.VISUAL_ID:
		case MessageStoreEditPart.VISUAL_ID:
		case TemplateEndpointInputConnectorEditPart.VISUAL_ID:
		case TemplateEndpointOutputConnectorEditPart.VISUAL_ID:
		case CloudConnectorInputConnectorEditPart.VISUAL_ID:
		case CloudConnectorOutputConnectorEditPart.VISUAL_ID:
		case CloudConnectorOperationInputConnectorEditPart.VISUAL_ID:
		case CloudConnectorOperationOutputConnectorEditPart.VISUAL_ID:
		case TemplateEndpointInputConnector2EditPart.VISUAL_ID:
		case TemplateEndpointOutputConnector2EditPart.VISUAL_ID:
		case ProxyOutSequenceOutputConnectorEditPart.VISUAL_ID:
		case APIResourceOutSequenceOutputConnectorEditPart.VISUAL_ID:
		case ProxyInSequenceInputConnectorEditPart.VISUAL_ID:
		case LoopBackMediatorInputConnectorEditPart.VISUAL_ID:
		case LoopBackMediatorOutputConnectorEditPart.VISUAL_ID:
		case RespondMediatorInputConnectorEditPart.VISUAL_ID:
		case RespondMediatorOutputConnectorEditPart.VISUAL_ID:
		case CallMediatorInputConnectorEditPart.VISUAL_ID:
		case CallMediatorOutputConnectorEditPart.VISUAL_ID:
		case CallMediatorEndpointOutputConnectorEditPart.VISUAL_ID:
		case APIResourceInSequenceInputConnectorEditPart.VISUAL_ID:
		case EntitlementMediatorOnRejectOutputConnectorEditPart.VISUAL_ID:
		case EntitlementMediatorOnAcceptOutputConnectorEditPart.VISUAL_ID:
		case EntitlementMediatorAdviceOutputConnectorEditPart.VISUAL_ID:
		case EntitlementMediatorObligationsOutputConnectorEditPart.VISUAL_ID:
		case DataMapperMediatorInputConnectorEditPart.VISUAL_ID:
		case DataMapperMediatorOutputConnectorEditPart.VISUAL_ID:
		case FastXSLTMediatorInputConnectorEditPart.VISUAL_ID:
		case FastXSLTMediatorOutputConnectorEditPart.VISUAL_ID:
		case InboundEndpointSequenceInputConnectorEditPart.VISUAL_ID:
		case InboundEndpointSequenceOutputConnectorEditPart.VISUAL_ID:
		case InboundEndpointOnErrorSequenceInputConnectorEditPart.VISUAL_ID:
		case InboundEndpointOnErrorSequenceOutputConnectorEditPart.VISUAL_ID:
		case ForEachMediatorInputConnectorEditPart.VISUAL_ID:
		case ForEachMediatorOutputConnectorEditPart.VISUAL_ID:
		case ForEachMediatorTargetOutputConnectorEditPart.VISUAL_ID:
		case PublishEventMediatorInputConnectorEditPart.VISUAL_ID:
		case PublishEventMediatorOutputConnectorEditPart.VISUAL_ID:
			return true;
		default:
			break;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static final DiagramStructure TYPED_INSTANCE = new DiagramStructure() {
		/**
		 * @generated
		 */

		public int getVisualID(View view) {
			return org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbVisualIDRegistry.getVisualID(view);
		}

		/**
		 * @generated
		 */

		public String getModelID(View view) {
			return org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbVisualIDRegistry.getModelID(view);
		}

		/**
		 * @generated
		 */

		public int getNodeVisualID(View containerView, EObject domainElement) {
			return org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbVisualIDRegistry.getNodeVisualID(
					containerView, domainElement);
		}

		/**
		 * @generated
		 */

		public boolean checkNodeVisualID(View containerView, EObject domainElement, int candidate) {
			return org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbVisualIDRegistry.checkNodeVisualID(
					containerView, domainElement, candidate);
		}

		/**
		 * @generated
		 */

		public boolean isCompartmentVisualID(int visualID) {
			return org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbVisualIDRegistry
					.isCompartmentVisualID(visualID);
		}

		/**
		 * @generated
		 */

		public boolean isSemanticLeafVisualID(int visualID) {
			return org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbVisualIDRegistry
					.isSemanticLeafVisualID(visualID);
		}
	};

}
