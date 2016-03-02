package org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts;

import org.eclipse.draw2d.FigureUtilities;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.directedit.locator.CellEditorLocatorAccess;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbVisualIDRegistry;

/**
 * @generated
 */
public class EsbEditPartFactory implements EditPartFactory {

	/**
	 * @generated
	 */
	public EditPart createEditPart(EditPart context, Object model) {
		if (model instanceof View) {
			View view = (View) model;
			switch (EsbVisualIDRegistry.getVisualID(view)) {

			case EsbDiagramEditPart.VISUAL_ID:
				return new EsbDiagramEditPart(view);

			case EsbServerEditPart.VISUAL_ID:
				return new EsbServerEditPart(view);

			case ProxyServiceEditPart.VISUAL_ID:
				return new ProxyServiceEditPart(view);

			case ProxyServiceNameEditPart.VISUAL_ID:
				return new ProxyServiceNameEditPart(view);

			case ProxyOutputConnectorEditPart.VISUAL_ID:
				return new ProxyOutputConnectorEditPart(view);

			case ProxyInputConnectorEditPart.VISUAL_ID:
				return new ProxyInputConnectorEditPart(view);

			case ProxyOutSequenceOutputConnectorEditPart.VISUAL_ID:
				return new ProxyOutSequenceOutputConnectorEditPart(view);

			case ProxyFaultInputConnectorEditPart.VISUAL_ID:
				return new ProxyFaultInputConnectorEditPart(view);

			case ProxyServiceContainerEditPart.VISUAL_ID:
				return new ProxyServiceContainerEditPart(view);

			case ProxyServiceSequenceAndEndpointContainerEditPart.VISUAL_ID:
				return new ProxyServiceSequenceAndEndpointContainerEditPart(view);

			case MediatorFlowEditPart.VISUAL_ID:
				return new MediatorFlowEditPart(view);

			case DropMediatorEditPart.VISUAL_ID:
				return new DropMediatorEditPart(view);

			case DropMediatorDescriptionEditPart.VISUAL_ID:
				return new DropMediatorDescriptionEditPart(view);

			case DropMediatorInputConnectorEditPart.VISUAL_ID:
				return new DropMediatorInputConnectorEditPart(view);

			case PropertyMediatorEditPart.VISUAL_ID:
				return new PropertyMediatorEditPart(view);

			case PropertyMediatorDescriptionEditPart.VISUAL_ID:
				return new PropertyMediatorDescriptionEditPart(view);

			case PropertyMediatorInputConnectorEditPart.VISUAL_ID:
				return new PropertyMediatorInputConnectorEditPart(view);

			case PropertyMediatorOutputConnectorEditPart.VISUAL_ID:
				return new PropertyMediatorOutputConnectorEditPart(view);

			case ThrottleMediatorEditPart.VISUAL_ID:
				return new ThrottleMediatorEditPart(view);

			case ThrottleMediatorGroupIdEditPart.VISUAL_ID:
				return new ThrottleMediatorGroupIdEditPart(view);

			case ThrottleMediatorInputConnectorEditPart.VISUAL_ID:
				return new ThrottleMediatorInputConnectorEditPart(view);

			case ThrottleMediatorOutputConnectorEditPart.VISUAL_ID:
				return new ThrottleMediatorOutputConnectorEditPart(view);

			case ThrottleMediatorOnAcceptOutputConnectorEditPart.VISUAL_ID:
				return new ThrottleMediatorOnAcceptOutputConnectorEditPart(view);

			case ThrottleMediatorOnRejectOutputConnectorEditPart.VISUAL_ID:
				return new ThrottleMediatorOnRejectOutputConnectorEditPart(view);

			case ThrottleContainerEditPart.VISUAL_ID:
				return new ThrottleContainerEditPart(view);

			case ThrottleOnAcceptContainerEditPart.VISUAL_ID:
				return new ThrottleOnAcceptContainerEditPart(view);

			case MediatorFlow9EditPart.VISUAL_ID:
				return new MediatorFlow9EditPart(view);

			case FilterMediatorEditPart.VISUAL_ID:
				return new FilterMediatorEditPart(view);

			case FilterMediatorConditionTypeEditPart.VISUAL_ID:
				return new FilterMediatorConditionTypeEditPart(view);

			case FilterMediatorInputConnectorEditPart.VISUAL_ID:
				return new FilterMediatorInputConnectorEditPart(view);

			case FilterMediatorOutputConnectorEditPart.VISUAL_ID:
				return new FilterMediatorOutputConnectorEditPart(view);

			case FilterMediatorPassOutputConnectorEditPart.VISUAL_ID:
				return new FilterMediatorPassOutputConnectorEditPart(view);

			case FilterMediatorFailOutputConnectorEditPart.VISUAL_ID:
				return new FilterMediatorFailOutputConnectorEditPart(view);

			case FilterContainerEditPart.VISUAL_ID:
				return new FilterContainerEditPart(view);

			case FilterPassContainerEditPart.VISUAL_ID:
				return new FilterPassContainerEditPart(view);

			case MediatorFlow7EditPart.VISUAL_ID:
				return new MediatorFlow7EditPart(view);

			case LogMediatorEditPart.VISUAL_ID:
				return new LogMediatorEditPart(view);

			case LogMediatorDescriptionEditPart.VISUAL_ID:
				return new LogMediatorDescriptionEditPart(view);

			case LogMediatorInputConnectorEditPart.VISUAL_ID:
				return new LogMediatorInputConnectorEditPart(view);

			case LogMediatorOutputConnectorEditPart.VISUAL_ID:
				return new LogMediatorOutputConnectorEditPart(view);

			case EnrichMediatorEditPart.VISUAL_ID:
				return new EnrichMediatorEditPart(view);

			case EnrichMediatorDescriptionEditPart.VISUAL_ID:
				return new EnrichMediatorDescriptionEditPart(view);

			case EnrichMediatorInputConnectorEditPart.VISUAL_ID:
				return new EnrichMediatorInputConnectorEditPart(view);

			case EnrichMediatorOutputConnectorEditPart.VISUAL_ID:
				return new EnrichMediatorOutputConnectorEditPart(view);

			case XSLTMediatorEditPart.VISUAL_ID:
				return new XSLTMediatorEditPart(view);

			case XSLTMediatorDescriptionEditPart.VISUAL_ID:
				return new XSLTMediatorDescriptionEditPart(view);

			case XSLTMediatorInputConnectorEditPart.VISUAL_ID:
				return new XSLTMediatorInputConnectorEditPart(view);

			case XSLTMediatorOutputConnectorEditPart.VISUAL_ID:
				return new XSLTMediatorOutputConnectorEditPart(view);

			case SwitchMediatorEditPart.VISUAL_ID:
				return new SwitchMediatorEditPart(view);

			case SwitchMediatorInputConnectorEditPart.VISUAL_ID:
				return new SwitchMediatorInputConnectorEditPart(view);

			case SwitchMediatorOutputConnectorEditPart.VISUAL_ID:
				return new SwitchMediatorOutputConnectorEditPart(view);

			case SwitchCaseBranchOutputConnectorEditPart.VISUAL_ID:
				return new SwitchCaseBranchOutputConnectorEditPart(view);

			case SwitchDefaultBranchOutputConnectorEditPart.VISUAL_ID:
				return new SwitchDefaultBranchOutputConnectorEditPart(view);

			case SwitchMediatorContainerEditPart.VISUAL_ID:
				return new SwitchMediatorContainerEditPart(view);

			case SwitchCaseParentContainerEditPart.VISUAL_ID:
				return new SwitchCaseParentContainerEditPart(view);

			case SwitchCaseContainerEditPart.VISUAL_ID:
				return new SwitchCaseContainerEditPart(view);

			case MediatorFlow2EditPart.VISUAL_ID:
				return new MediatorFlow2EditPart(view);

			case SequenceEditPart.VISUAL_ID:
				return new SequenceEditPart(view);

			case SequenceNameEditPart.VISUAL_ID:
				return new SequenceNameEditPart(view);

			case SequenceInputConnectorEditPart.VISUAL_ID:
				return new SequenceInputConnectorEditPart(view);

			case SequenceOutputConnectorEditPart.VISUAL_ID:
				return new SequenceOutputConnectorEditPart(view);

			case EventMediatorEditPart.VISUAL_ID:
				return new EventMediatorEditPart(view);

			case EventMediatorDescriptionEditPart.VISUAL_ID:
				return new EventMediatorDescriptionEditPart(view);

			case EventMediatorInputConnectorEditPart.VISUAL_ID:
				return new EventMediatorInputConnectorEditPart(view);

			case EventMediatorOutputConnectorEditPart.VISUAL_ID:
				return new EventMediatorOutputConnectorEditPart(view);

			case EntitlementMediatorEditPart.VISUAL_ID:
				return new EntitlementMediatorEditPart(view);

			case EntitlementMediatorServerURLEditPart.VISUAL_ID:
				return new EntitlementMediatorServerURLEditPart(view);

			case EntitlementMediatorInputConnectorEditPart.VISUAL_ID:
				return new EntitlementMediatorInputConnectorEditPart(view);

			case EntitlementMediatorOutputConnectorEditPart.VISUAL_ID:
				return new EntitlementMediatorOutputConnectorEditPart(view);

			case EntitlementMediatorOnRejectOutputConnectorEditPart.VISUAL_ID:
				return new EntitlementMediatorOnRejectOutputConnectorEditPart(view);

			case EntitlementMediatorOnAcceptOutputConnectorEditPart.VISUAL_ID:
				return new EntitlementMediatorOnAcceptOutputConnectorEditPart(view);

			case EntitlementMediatorAdviceOutputConnectorEditPart.VISUAL_ID:
				return new EntitlementMediatorAdviceOutputConnectorEditPart(view);

			case EntitlementMediatorObligationsOutputConnectorEditPart.VISUAL_ID:
				return new EntitlementMediatorObligationsOutputConnectorEditPart(view);

			case EntitlementContainerEditPart.VISUAL_ID:
				return new EntitlementContainerEditPart(view);

			case EntitlementOnRejectContainerEditPart.VISUAL_ID:
				return new EntitlementOnRejectContainerEditPart(view);

			case MediatorFlow21EditPart.VISUAL_ID:
				return new MediatorFlow21EditPart(view);

			case ClassMediatorEditPart.VISUAL_ID:
				return new ClassMediatorEditPart(view);

			case ClassMediatorDescriptionEditPart.VISUAL_ID:
				return new ClassMediatorDescriptionEditPart(view);

			case ClassMediatorInputConnectorEditPart.VISUAL_ID:
				return new ClassMediatorInputConnectorEditPart(view);

			case ClassMediatorOutputConnectorEditPart.VISUAL_ID:
				return new ClassMediatorOutputConnectorEditPart(view);

			case SpringMediatorEditPart.VISUAL_ID:
				return new SpringMediatorEditPart(view);

			case SpringMediatorDescriptionEditPart.VISUAL_ID:
				return new SpringMediatorDescriptionEditPart(view);

			case SpringMediatorInputConnectorEditPart.VISUAL_ID:
				return new SpringMediatorInputConnectorEditPart(view);

			case SpringMediatorOutputConnectorEditPart.VISUAL_ID:
				return new SpringMediatorOutputConnectorEditPart(view);

			case ScriptMediatorEditPart.VISUAL_ID:
				return new ScriptMediatorEditPart(view);

			case ScriptMediatorDescriptionEditPart.VISUAL_ID:
				return new ScriptMediatorDescriptionEditPart(view);

			case ScriptMediatorInputConnectorEditPart.VISUAL_ID:
				return new ScriptMediatorInputConnectorEditPart(view);

			case ScriptMediatorOutputConnectorEditPart.VISUAL_ID:
				return new ScriptMediatorOutputConnectorEditPart(view);

			case FaultMediatorEditPart.VISUAL_ID:
				return new FaultMediatorEditPart(view);

			case FaultMediatorDescriptionEditPart.VISUAL_ID:
				return new FaultMediatorDescriptionEditPart(view);

			case FaultMediatorInputConnectorEditPart.VISUAL_ID:
				return new FaultMediatorInputConnectorEditPart(view);

			case FaultMediatorOutputConnectorEditPart.VISUAL_ID:
				return new FaultMediatorOutputConnectorEditPart(view);

			case XQueryMediatorEditPart.VISUAL_ID:
				return new XQueryMediatorEditPart(view);

			case XQueryMediatorDescriptionEditPart.VISUAL_ID:
				return new XQueryMediatorDescriptionEditPart(view);

			case XQueryMediatorInputConnectorEditPart.VISUAL_ID:
				return new XQueryMediatorInputConnectorEditPart(view);

			case XQueryMediatorOutputConnectorEditPart.VISUAL_ID:
				return new XQueryMediatorOutputConnectorEditPart(view);

			case CommandMediatorEditPart.VISUAL_ID:
				return new CommandMediatorEditPart(view);

			case CommandMediatorDescriptionEditPart.VISUAL_ID:
				return new CommandMediatorDescriptionEditPart(view);

			case CommandMediatorInputConnectorEditPart.VISUAL_ID:
				return new CommandMediatorInputConnectorEditPart(view);

			case CommandMediatorOutputConnectorEditPart.VISUAL_ID:
				return new CommandMediatorOutputConnectorEditPart(view);

			case DBLookupMediatorEditPart.VISUAL_ID:
				return new DBLookupMediatorEditPart(view);

			case DBLookupMediatorDescriptionEditPart.VISUAL_ID:
				return new DBLookupMediatorDescriptionEditPart(view);

			case DBLookupMediatorInputConnectorEditPart.VISUAL_ID:
				return new DBLookupMediatorInputConnectorEditPart(view);

			case DBLookupMediatorOutputConnectorEditPart.VISUAL_ID:
				return new DBLookupMediatorOutputConnectorEditPart(view);

			case DBReportMediatorEditPart.VISUAL_ID:
				return new DBReportMediatorEditPart(view);

			case DBReportMediatorDescriptionEditPart.VISUAL_ID:
				return new DBReportMediatorDescriptionEditPart(view);

			case DBReportMediatorInputConnectorEditPart.VISUAL_ID:
				return new DBReportMediatorInputConnectorEditPart(view);

			case DBReportMediatorOutputConnectorEditPart.VISUAL_ID:
				return new DBReportMediatorOutputConnectorEditPart(view);

			case SmooksMediatorEditPart.VISUAL_ID:
				return new SmooksMediatorEditPart(view);

			case SmooksMediatorDescriptionEditPart.VISUAL_ID:
				return new SmooksMediatorDescriptionEditPart(view);

			case SmooksMediatorInputConnectorEditPart.VISUAL_ID:
				return new SmooksMediatorInputConnectorEditPart(view);

			case SmooksMediatorOutputConnectorEditPart.VISUAL_ID:
				return new SmooksMediatorOutputConnectorEditPart(view);

			case SendMediatorEditPart.VISUAL_ID:
				return new SendMediatorEditPart(view);

			case SendMediatorInputConnectorEditPart.VISUAL_ID:
				return new SendMediatorInputConnectorEditPart(view);

			case SendMediatorOutputConnectorEditPart.VISUAL_ID:
				return new SendMediatorOutputConnectorEditPart(view);

			case SendMediatorEndpointOutputConnectorEditPart.VISUAL_ID:
				return new SendMediatorEndpointOutputConnectorEditPart(view);

			case MediatorFlow19EditPart.VISUAL_ID:
				return new MediatorFlow19EditPart(view);

			case HeaderMediatorEditPart.VISUAL_ID:
				return new HeaderMediatorEditPart(view);

			case HeaderMediatorDescriptionEditPart.VISUAL_ID:
				return new HeaderMediatorDescriptionEditPart(view);

			case HeaderMediatorInputConnectorEditPart.VISUAL_ID:
				return new HeaderMediatorInputConnectorEditPart(view);

			case HeaderMediatorOutputConnectorEditPart.VISUAL_ID:
				return new HeaderMediatorOutputConnectorEditPart(view);

			case CloneMediatorEditPart.VISUAL_ID:
				return new CloneMediatorEditPart(view);

			case CloneMediatorCloneIDEditPart.VISUAL_ID:
				return new CloneMediatorCloneIDEditPart(view);

			case CloneMediatorInputConnectorEditPart.VISUAL_ID:
				return new CloneMediatorInputConnectorEditPart(view);

			case CloneMediatorOutputConnectorEditPart.VISUAL_ID:
				return new CloneMediatorOutputConnectorEditPart(view);

			case CloneMediatorTargetOutputConnectorEditPart.VISUAL_ID:
				return new CloneMediatorTargetOutputConnectorEditPart(view);

			case CloneMediatorContainerEditPart.VISUAL_ID:
				return new CloneMediatorContainerEditPart(view);

			case CloneTargetContainerEditPart.VISUAL_ID:
				return new CloneTargetContainerEditPart(view);

			case MediatorFlow11EditPart.VISUAL_ID:
				return new MediatorFlow11EditPart(view);

			case CacheMediatorEditPart.VISUAL_ID:
				return new CacheMediatorEditPart(view);

			case CacheMediatorCacheIdEditPart.VISUAL_ID:
				return new CacheMediatorCacheIdEditPart(view);

			case CacheMediatorInputConnectorEditPart.VISUAL_ID:
				return new CacheMediatorInputConnectorEditPart(view);

			case CacheMediatorOutputConnectorEditPart.VISUAL_ID:
				return new CacheMediatorOutputConnectorEditPart(view);

			case CacheMediatorOnHitOutputConnectorEditPart.VISUAL_ID:
				return new CacheMediatorOnHitOutputConnectorEditPart(view);

			case MediatorFlow13EditPart.VISUAL_ID:
				return new MediatorFlow13EditPart(view);

			case IterateMediatorEditPart.VISUAL_ID:
				return new IterateMediatorEditPart(view);

			case IterateMediatorIterateIDEditPart.VISUAL_ID:
				return new IterateMediatorIterateIDEditPart(view);

			case IterateMediatorInputConnectorEditPart.VISUAL_ID:
				return new IterateMediatorInputConnectorEditPart(view);

			case IterateMediatorOutputConnectorEditPart.VISUAL_ID:
				return new IterateMediatorOutputConnectorEditPart(view);

			case IterateMediatorTargetOutputConnectorEditPart.VISUAL_ID:
				return new IterateMediatorTargetOutputConnectorEditPart(view);

			case MediatorFlow12EditPart.VISUAL_ID:
				return new MediatorFlow12EditPart(view);

			case CalloutMediatorEditPart.VISUAL_ID:
				return new CalloutMediatorEditPart(view);

			case CalloutMediatorDescriptionEditPart.VISUAL_ID:
				return new CalloutMediatorDescriptionEditPart(view);

			case CalloutMediatorInputConnectorEditPart.VISUAL_ID:
				return new CalloutMediatorInputConnectorEditPart(view);

			case CalloutMediatorOutputConnectorEditPart.VISUAL_ID:
				return new CalloutMediatorOutputConnectorEditPart(view);

			case TransactionMediatorEditPart.VISUAL_ID:
				return new TransactionMediatorEditPart(view);

			case TransactionMediatorDescriptionEditPart.VISUAL_ID:
				return new TransactionMediatorDescriptionEditPart(view);

			case TransactionMediatorInputConnectorEditPart.VISUAL_ID:
				return new TransactionMediatorInputConnectorEditPart(view);

			case TransactionMediatorOutputConnectorEditPart.VISUAL_ID:
				return new TransactionMediatorOutputConnectorEditPart(view);

			case RMSequenceMediatorEditPart.VISUAL_ID:
				return new RMSequenceMediatorEditPart(view);

			case RMSequenceMediatorDescriptionEditPart.VISUAL_ID:
				return new RMSequenceMediatorDescriptionEditPart(view);

			case RMSequenceMediatorInputConnectorEditPart.VISUAL_ID:
				return new RMSequenceMediatorInputConnectorEditPart(view);

			case RMSequenceMediatorOutputConnectorEditPart.VISUAL_ID:
				return new RMSequenceMediatorOutputConnectorEditPart(view);

			case RuleMediatorEditPart.VISUAL_ID:
				return new RuleMediatorEditPart(view);

			case RuleMediatorInputConnectorEditPart.VISUAL_ID:
				return new RuleMediatorInputConnectorEditPart(view);

			case RuleMediatorOutputConnectorEditPart.VISUAL_ID:
				return new RuleMediatorOutputConnectorEditPart(view);

			case RuleMediatorChildMediatorsOutputConnectorEditPart.VISUAL_ID:
				return new RuleMediatorChildMediatorsOutputConnectorEditPart(view);

			case MediatorFlow17EditPart.VISUAL_ID:
				return new MediatorFlow17EditPart(view);

			case OAuthMediatorEditPart.VISUAL_ID:
				return new OAuthMediatorEditPart(view);

			case OAuthMediatorDescriptionEditPart.VISUAL_ID:
				return new OAuthMediatorDescriptionEditPart(view);

			case OAuthMediatorInputConnectorEditPart.VISUAL_ID:
				return new OAuthMediatorInputConnectorEditPart(view);

			case OAuthMediatorOutputConnectorEditPart.VISUAL_ID:
				return new OAuthMediatorOutputConnectorEditPart(view);

			case AggregateMediatorEditPart.VISUAL_ID:
				return new AggregateMediatorEditPart(view);

			case AggregateMediatorAggregateIDEditPart.VISUAL_ID:
				return new AggregateMediatorAggregateIDEditPart(view);

			case AggregateMediatorInputConnectorEditPart.VISUAL_ID:
				return new AggregateMediatorInputConnectorEditPart(view);

			case AggregateMediatorOutputConnectorEditPart.VISUAL_ID:
				return new AggregateMediatorOutputConnectorEditPart(view);

			case AggregateMediatorOnCompleteOutputConnectorEditPart.VISUAL_ID:
				return new AggregateMediatorOnCompleteOutputConnectorEditPart(view);

			case MediatorFlow3EditPart.VISUAL_ID:
				return new MediatorFlow3EditPart(view);

			case StoreMediatorEditPart.VISUAL_ID:
				return new StoreMediatorEditPart(view);

			case StoreMediatorDescriptionEditPart.VISUAL_ID:
				return new StoreMediatorDescriptionEditPart(view);

			case StoreMediatorInputConnectorEditPart.VISUAL_ID:
				return new StoreMediatorInputConnectorEditPart(view);

			case StoreMediatorOutputConnectorEditPart.VISUAL_ID:
				return new StoreMediatorOutputConnectorEditPart(view);

			case BuilderMediatorEditPart.VISUAL_ID:
				return new BuilderMediatorEditPart(view);

			case BuilderMediatorDescriptionEditPart.VISUAL_ID:
				return new BuilderMediatorDescriptionEditPart(view);

			case BuilderMediatorInputConnectorEditPart.VISUAL_ID:
				return new BuilderMediatorInputConnectorEditPart(view);

			case BuilderMediatorOutputConectorEditPart.VISUAL_ID:
				return new BuilderMediatorOutputConectorEditPart(view);

			case CallTemplateMediatorEditPart.VISUAL_ID:
				return new CallTemplateMediatorEditPart(view);

			case CallTemplateMediatorDescriptionEditPart.VISUAL_ID:
				return new CallTemplateMediatorDescriptionEditPart(view);

			case CallTemplateMediatorInputConnectorEditPart.VISUAL_ID:
				return new CallTemplateMediatorInputConnectorEditPart(view);

			case CallTemplateMediatorOutputConnectorEditPart.VISUAL_ID:
				return new CallTemplateMediatorOutputConnectorEditPart(view);

			case PayloadFactoryMediatorEditPart.VISUAL_ID:
				return new PayloadFactoryMediatorEditPart(view);

			case PayloadFactoryMediatorDescriptionEditPart.VISUAL_ID:
				return new PayloadFactoryMediatorDescriptionEditPart(view);

			case PayloadFactoryMediatorInputConnectorEditPart.VISUAL_ID:
				return new PayloadFactoryMediatorInputConnectorEditPart(view);

			case PayloadFactoryMediatorOutputConnectorEditPart.VISUAL_ID:
				return new PayloadFactoryMediatorOutputConnectorEditPart(view);

			case EnqueueMediatorEditPart.VISUAL_ID:
				return new EnqueueMediatorEditPart(view);

			case EnqueueMediatorDescriptionEditPart.VISUAL_ID:
				return new EnqueueMediatorDescriptionEditPart(view);

			case EnqueueMediatorInputConnectorEditPart.VISUAL_ID:
				return new EnqueueMediatorInputConnectorEditPart(view);

			case EnqueueMediatorOutputConnectorEditPart.VISUAL_ID:
				return new EnqueueMediatorOutputConnectorEditPart(view);

			case URLRewriteMediatorEditPart.VISUAL_ID:
				return new URLRewriteMediatorEditPart(view);

			case URLRewriteMediatorDescriptionEditPart.VISUAL_ID:
				return new URLRewriteMediatorDescriptionEditPart(view);

			case URLRewriteMediatorInputConnectorEditPart.VISUAL_ID:
				return new URLRewriteMediatorInputConnectorEditPart(view);

			case URLRewriteMediatorOutputConnectorEditPart.VISUAL_ID:
				return new URLRewriteMediatorOutputConnectorEditPart(view);

			case ValidateMediatorEditPart.VISUAL_ID:
				return new ValidateMediatorEditPart(view);

			case ValidateMediatorInputConnectorEditPart.VISUAL_ID:
				return new ValidateMediatorInputConnectorEditPart(view);

			case ValidateMediatorOutputConnectorEditPart.VISUAL_ID:
				return new ValidateMediatorOutputConnectorEditPart(view);

			case ValidateMediatorOnFailOutputConnectorEditPart.VISUAL_ID:
				return new ValidateMediatorOnFailOutputConnectorEditPart(view);

			case MediatorFlow14EditPart.VISUAL_ID:
				return new MediatorFlow14EditPart(view);

			case RouterMediatorEditPart.VISUAL_ID:
				return new RouterMediatorEditPart(view);

			case RouterMediatorInputConnectorEditPart.VISUAL_ID:
				return new RouterMediatorInputConnectorEditPart(view);

			case RouterMediatorOutputConnectorEditPart.VISUAL_ID:
				return new RouterMediatorOutputConnectorEditPart(view);

			case RouterMediatorTargetOutputConnectorEditPart.VISUAL_ID:
				return new RouterMediatorTargetOutputConnectorEditPart(view);

			case RouterMediatorContainerEditPart.VISUAL_ID:
				return new RouterMediatorContainerEditPart(view);

			case RouterTargetContainerEditPart.VISUAL_ID:
				return new RouterTargetContainerEditPart(view);

			case MediatorFlow15EditPart.VISUAL_ID:
				return new MediatorFlow15EditPart(view);

			case ConditionalRouterMediatorEditPart.VISUAL_ID:
				return new ConditionalRouterMediatorEditPart(view);

			case ConditionalRouterMediatorDescriptionEditPart.VISUAL_ID:
				return new ConditionalRouterMediatorDescriptionEditPart(view);

			case ConditionalRouterMediatorInputConnectorEditPart.VISUAL_ID:
				return new ConditionalRouterMediatorInputConnectorEditPart(view);

			case ConditionalRouterMediatorOutputConnectorEditPart.VISUAL_ID:
				return new ConditionalRouterMediatorOutputConnectorEditPart(view);

			case ConditionalRouterMediatorAdditionalOutputConnectorEditPart.VISUAL_ID:
				return new ConditionalRouterMediatorAdditionalOutputConnectorEditPart(view);

			case MediatorFlow16EditPart.VISUAL_ID:
				return new MediatorFlow16EditPart(view);

			case BAMMediatorEditPart.VISUAL_ID:
				return new BAMMediatorEditPart(view);

			case BAMMediatorDescriptionEditPart.VISUAL_ID:
				return new BAMMediatorDescriptionEditPart(view);

			case BAMMediatorInputConnectorEditPart.VISUAL_ID:
				return new BAMMediatorInputConnectorEditPart(view);

			case BAMMediatorOutputConnectorEditPart.VISUAL_ID:
				return new BAMMediatorOutputConnectorEditPart(view);

			case BeanMediatorEditPart.VISUAL_ID:
				return new BeanMediatorEditPart(view);

			case BeanMediatorDescriptionEditPart.VISUAL_ID:
				return new BeanMediatorDescriptionEditPart(view);

			case BeanMediatorInputConnectorEditPart.VISUAL_ID:
				return new BeanMediatorInputConnectorEditPart(view);

			case BeanMediatorOutputConnectorEditPart.VISUAL_ID:
				return new BeanMediatorOutputConnectorEditPart(view);

			case EJBMediatorEditPart.VISUAL_ID:
				return new EJBMediatorEditPart(view);

			case EJBMediatorDescriptionEditPart.VISUAL_ID:
				return new EJBMediatorDescriptionEditPart(view);

			case EJBMediatorInputConnectorEditPart.VISUAL_ID:
				return new EJBMediatorInputConnectorEditPart(view);

			case EJBMediatorOutputConnectorEditPart.VISUAL_ID:
				return new EJBMediatorOutputConnectorEditPart(view);

			case DefaultEndPointEditPart.VISUAL_ID:
				return new DefaultEndPointEditPart(view);

			case DefaultEndPointDescriptionEditPart.VISUAL_ID:
				return new DefaultEndPointDescriptionEditPart(view);

			case DefaultEndPointInputConnectorEditPart.VISUAL_ID:
				return new DefaultEndPointInputConnectorEditPart(view);

			case DefaultEndPointOutputConnectorEditPart.VISUAL_ID:
				return new DefaultEndPointOutputConnectorEditPart(view);

			case AddressEndPointEditPart.VISUAL_ID:
				return new AddressEndPointEditPart(view);

			case AddressEndPointDescriptionEditPart.VISUAL_ID:
				return new AddressEndPointDescriptionEditPart(view);

			case AddressEndPointInputConnectorEditPart.VISUAL_ID:
				return new AddressEndPointInputConnectorEditPart(view);

			case AddressEndPointOutputConnectorEditPart.VISUAL_ID:
				return new AddressEndPointOutputConnectorEditPart(view);

			case FailoverEndPointEditPart.VISUAL_ID:
				return new FailoverEndPointEditPart(view);

			case FailoverEndPointDescriptionEditPart.VISUAL_ID:
				return new FailoverEndPointDescriptionEditPart(view);

			case FailoverEndPointInputConnectorEditPart.VISUAL_ID:
				return new FailoverEndPointInputConnectorEditPart(view);

			case FailoverEndPointOutputConnectorEditPart.VISUAL_ID:
				return new FailoverEndPointOutputConnectorEditPart(view);

			case FailoverEndPointWestOutputConnectorEditPart.VISUAL_ID:
				return new FailoverEndPointWestOutputConnectorEditPart(view);

			case RecipientListEndPointEditPart.VISUAL_ID:
				return new RecipientListEndPointEditPart(view);

			case RecipientListEndPointDescriptionEditPart.VISUAL_ID:
				return new RecipientListEndPointDescriptionEditPart(view);

			case RecipientListEndPointInputConnectorEditPart.VISUAL_ID:
				return new RecipientListEndPointInputConnectorEditPart(view);

			case RecipientListEndPointOutputConnectorEditPart.VISUAL_ID:
				return new RecipientListEndPointOutputConnectorEditPart(view);

			case RecipientListEndPointWestOutputConnectorEditPart.VISUAL_ID:
				return new RecipientListEndPointWestOutputConnectorEditPart(view);

			case WSDLEndPointEditPart.VISUAL_ID:
				return new WSDLEndPointEditPart(view);

			case WSDLEndPointDescriptionEditPart.VISUAL_ID:
				return new WSDLEndPointDescriptionEditPart(view);

			case WSDLEndPointInputConnectorEditPart.VISUAL_ID:
				return new WSDLEndPointInputConnectorEditPart(view);

			case WSDLEndPointOutputConnectorEditPart.VISUAL_ID:
				return new WSDLEndPointOutputConnectorEditPart(view);

			case NamedEndpointEditPart.VISUAL_ID:
				return new NamedEndpointEditPart(view);

			case NamedEndpointNameEditPart.VISUAL_ID:
				return new NamedEndpointNameEditPart(view);

			case NamedEndpointInputConnectorEditPart.VISUAL_ID:
				return new NamedEndpointInputConnectorEditPart(view);

			case NamedEndpointOutputConnectorEditPart.VISUAL_ID:
				return new NamedEndpointOutputConnectorEditPart(view);

			case LoadBalanceEndPointEditPart.VISUAL_ID:
				return new LoadBalanceEndPointEditPart(view);

			case LoadBalanceEndPointDescriptionEditPart.VISUAL_ID:
				return new LoadBalanceEndPointDescriptionEditPart(view);

			case LoadBalanceEndPointInputConnectorEditPart.VISUAL_ID:
				return new LoadBalanceEndPointInputConnectorEditPart(view);

			case LoadBalanceEndPointOutputConnectorEditPart.VISUAL_ID:
				return new LoadBalanceEndPointOutputConnectorEditPart(view);

			case LoadBalanceEndPointWestOutputConnectorEditPart.VISUAL_ID:
				return new LoadBalanceEndPointWestOutputConnectorEditPart(view);

			case APIResourceEndpointEditPart.VISUAL_ID:
				return new APIResourceEndpointEditPart(view);

			case APIResourceEndpointInputConnectorEditPart.VISUAL_ID:
				return new APIResourceEndpointInputConnectorEditPart(view);

			case APIResourceEndpointOutputConnectorEditPart.VISUAL_ID:
				return new APIResourceEndpointOutputConnectorEditPart(view);

			case AddressingEndpointEditPart.VISUAL_ID:
				return new AddressingEndpointEditPart(view);

			case AddressingEndpointDescriptionEditPart.VISUAL_ID:
				return new AddressingEndpointDescriptionEditPart(view);

			case AddressingEndpointInputConnectorEditPart.VISUAL_ID:
				return new AddressingEndpointInputConnectorEditPart(view);

			case AddressingEndpointOutputConnectorEditPart.VISUAL_ID:
				return new AddressingEndpointOutputConnectorEditPart(view);

			case HTTPEndpointEditPart.VISUAL_ID:
				return new HTTPEndpointEditPart(view);

			case HTTPEndpointDescriptionEditPart.VISUAL_ID:
				return new HTTPEndpointDescriptionEditPart(view);

			case HTTPEndPointInputConnectorEditPart.VISUAL_ID:
				return new HTTPEndPointInputConnectorEditPart(view);

			case HTTPEndPointOutputConnectorEditPart.VISUAL_ID:
				return new HTTPEndPointOutputConnectorEditPart(view);

			case TemplateEndpointEditPart.VISUAL_ID:
				return new TemplateEndpointEditPart(view);

			case TemplateEndpointDescriptionEditPart.VISUAL_ID:
				return new TemplateEndpointDescriptionEditPart(view);

			case TemplateEndpointInputConnectorEditPart.VISUAL_ID:
				return new TemplateEndpointInputConnectorEditPart(view);

			case TemplateEndpointOutputConnectorEditPart.VISUAL_ID:
				return new TemplateEndpointOutputConnectorEditPart(view);

			case CloudConnectorEditPart.VISUAL_ID:
				return new CloudConnectorEditPart(view);

			case CloudConnectorDescriptionEditPart.VISUAL_ID:
				return new CloudConnectorDescriptionEditPart(view);

			case CloudConnectorInputConnectorEditPart.VISUAL_ID:
				return new CloudConnectorInputConnectorEditPart(view);

			case CloudConnectorOutputConnectorEditPart.VISUAL_ID:
				return new CloudConnectorOutputConnectorEditPart(view);

			case CloudConnectorOperationEditPart.VISUAL_ID:
				return new CloudConnectorOperationEditPart(view);

			case CloudConnectorOperationDescriptionEditPart.VISUAL_ID:
				return new CloudConnectorOperationDescriptionEditPart(view);

			case CloudConnectorOperationInputConnectorEditPart.VISUAL_ID:
				return new CloudConnectorOperationInputConnectorEditPart(view);

			case CloudConnectorOperationOutputConnectorEditPart.VISUAL_ID:
				return new CloudConnectorOperationOutputConnectorEditPart(view);

			case LoopBackMediatorEditPart.VISUAL_ID:
				return new LoopBackMediatorEditPart(view);

			case LoopBackMediatorDescriptionEditPart.VISUAL_ID:
				return new LoopBackMediatorDescriptionEditPart(view);

			case LoopBackMediatorInputConnectorEditPart.VISUAL_ID:
				return new LoopBackMediatorInputConnectorEditPart(view);

			case LoopBackMediatorOutputConnectorEditPart.VISUAL_ID:
				return new LoopBackMediatorOutputConnectorEditPart(view);

			case RespondMediatorEditPart.VISUAL_ID:
				return new RespondMediatorEditPart(view);

			case RespondMediatorDescriptionEditPart.VISUAL_ID:
				return new RespondMediatorDescriptionEditPart(view);

			case RespondMediatorInputConnectorEditPart.VISUAL_ID:
				return new RespondMediatorInputConnectorEditPart(view);

			case RespondMediatorOutputConnectorEditPart.VISUAL_ID:
				return new RespondMediatorOutputConnectorEditPart(view);

			case CallMediatorEditPart.VISUAL_ID:
				return new CallMediatorEditPart(view);

			case CallMediatorInputConnectorEditPart.VISUAL_ID:
				return new CallMediatorInputConnectorEditPart(view);

			case CallMediatorOutputConnectorEditPart.VISUAL_ID:
				return new CallMediatorOutputConnectorEditPart(view);

			case CallMediatorEndpointOutputConnectorEditPart.VISUAL_ID:
				return new CallMediatorEndpointOutputConnectorEditPart(view);

			case MediatorFlow20EditPart.VISUAL_ID:
				return new MediatorFlow20EditPart(view);

			case DataMapperMediatorEditPart.VISUAL_ID:
				return new DataMapperMediatorEditPart(view);

			case DataMapperMediatorDescriptionEditPart.VISUAL_ID:
				return new DataMapperMediatorDescriptionEditPart(view);

			case DataMapperMediatorInputConnectorEditPart.VISUAL_ID:
				return new DataMapperMediatorInputConnectorEditPart(view);

			case DataMapperMediatorOutputConnectorEditPart.VISUAL_ID:
				return new DataMapperMediatorOutputConnectorEditPart(view);

			case FastXSLTMediatorEditPart.VISUAL_ID:
				return new FastXSLTMediatorEditPart(view);

			case FastXSLTMediatorDescriptionEditPart.VISUAL_ID:
				return new FastXSLTMediatorDescriptionEditPart(view);

			case FastXSLTMediatorInputConnectorEditPart.VISUAL_ID:
				return new FastXSLTMediatorInputConnectorEditPart(view);

			case FastXSLTMediatorOutputConnectorEditPart.VISUAL_ID:
				return new FastXSLTMediatorOutputConnectorEditPart(view);

			case ForEachMediatorEditPart.VISUAL_ID:
				return new ForEachMediatorEditPart(view);

			case ForEachMediatorDescriptionEditPart.VISUAL_ID:
				return new ForEachMediatorDescriptionEditPart(view);

			case ForEachMediatorInputConnectorEditPart.VISUAL_ID:
				return new ForEachMediatorInputConnectorEditPart(view);

			case ForEachMediatorOutputConnectorEditPart.VISUAL_ID:
				return new ForEachMediatorOutputConnectorEditPart(view);

			case ForEachMediatorTargetOutputConnectorEditPart.VISUAL_ID:
				return new ForEachMediatorTargetOutputConnectorEditPart(view);

			case MediatorFlow30EditPart.VISUAL_ID:
				return new MediatorFlow30EditPart(view);

			case PublishEventMediatorEditPart.VISUAL_ID:
				return new PublishEventMediatorEditPart(view);

			case PublishEventMediatorStreamNameEditPart.VISUAL_ID:
				return new PublishEventMediatorStreamNameEditPart(view);

			case PublishEventMediatorInputConnectorEditPart.VISUAL_ID:
				return new PublishEventMediatorInputConnectorEditPart(view);

			case PublishEventMediatorOutputConnectorEditPart.VISUAL_ID:
				return new PublishEventMediatorOutputConnectorEditPart(view);

			case EntitlementOnAcceptContainerEditPart.VISUAL_ID:
				return new EntitlementOnAcceptContainerEditPart(view);

			case MediatorFlow22EditPart.VISUAL_ID:
				return new MediatorFlow22EditPart(view);

			case EntitlementAdviceContainerEditPart.VISUAL_ID:
				return new EntitlementAdviceContainerEditPart(view);

			case MediatorFlow23EditPart.VISUAL_ID:
				return new MediatorFlow23EditPart(view);

			case EntitlementObligationsContainerEditPart.VISUAL_ID:
				return new EntitlementObligationsContainerEditPart(view);

			case MediatorFlow24EditPart.VISUAL_ID:
				return new MediatorFlow24EditPart(view);

			case SwitchDefaultParentContainerEditPart.VISUAL_ID:
				return new SwitchDefaultParentContainerEditPart(view);

			case SwitchDefaultContainerEditPart.VISUAL_ID:
				return new SwitchDefaultContainerEditPart(view);

			case MediatorFlow4EditPart.VISUAL_ID:
				return new MediatorFlow4EditPart(view);

			case FilterFailContainerEditPart.VISUAL_ID:
				return new FilterFailContainerEditPart(view);

			case MediatorFlow8EditPart.VISUAL_ID:
				return new MediatorFlow8EditPart(view);

			case ThrottleOnRejectContainerEditPart.VISUAL_ID:
				return new ThrottleOnRejectContainerEditPart(view);

			case MediatorFlow10EditPart.VISUAL_ID:
				return new MediatorFlow10EditPart(view);

			case ProxyServiceFaultContainerEditPart.VISUAL_ID:
				return new ProxyServiceFaultContainerEditPart(view);

			case MediatorFlow6EditPart.VISUAL_ID:
				return new MediatorFlow6EditPart(view);

			case ProxyInSequenceInputConnectorEditPart.VISUAL_ID:
				return new ProxyInSequenceInputConnectorEditPart(view);

			case MessageMediatorEditPart.VISUAL_ID:
				return new MessageMediatorEditPart(view);

			case MessageInputConnectorEditPart.VISUAL_ID:
				return new MessageInputConnectorEditPart(view);

			case MessageOutputConnectorEditPart.VISUAL_ID:
				return new MessageOutputConnectorEditPart(view);

			case MergeNodeEditPart.VISUAL_ID:
				return new MergeNodeEditPart(view);

			case MergeNodeFirstInputConnectorEditPart.VISUAL_ID:
				return new MergeNodeFirstInputConnectorEditPart(view);

			case MergeNodeSecondInputConnectorEditPart.VISUAL_ID:
				return new MergeNodeSecondInputConnectorEditPart(view);

			case MergeNodeOutputConnectorEditPart.VISUAL_ID:
				return new MergeNodeOutputConnectorEditPart(view);

			case SequencesEditPart.VISUAL_ID:
				return new SequencesEditPart(view);

			case MediatorFlow5EditPart.VISUAL_ID:
				return new MediatorFlow5EditPart(view);

			case SequencesInputConnectorEditPart.VISUAL_ID:
				return new SequencesInputConnectorEditPart(view);

			case SequencesOutputConnectorEditPart.VISUAL_ID:
				return new SequencesOutputConnectorEditPart(view);

			case EndpointDiagramEditPart.VISUAL_ID:
				return new EndpointDiagramEditPart(view);

			case DefaultEndPoint2EditPart.VISUAL_ID:
				return new DefaultEndPoint2EditPart(view);

			case DefaultEndPointEndPointName2EditPart.VISUAL_ID:
				return new DefaultEndPointEndPointName2EditPart(view);

			case DefaultEndPointInputConnector2EditPart.VISUAL_ID:
				return new DefaultEndPointInputConnector2EditPart(view);

			case DefaultEndPointOutputConnector2EditPart.VISUAL_ID:
				return new DefaultEndPointOutputConnector2EditPart(view);

			case AddressEndPoint2EditPart.VISUAL_ID:
				return new AddressEndPoint2EditPart(view);

			case AddressEndPointEndPointName2EditPart.VISUAL_ID:
				return new AddressEndPointEndPointName2EditPart(view);

			case AddressEndPointInputConnector2EditPart.VISUAL_ID:
				return new AddressEndPointInputConnector2EditPart(view);

			case AddressEndPointOutputConnector2EditPart.VISUAL_ID:
				return new AddressEndPointOutputConnector2EditPart(view);

			case FailoverEndPoint2EditPart.VISUAL_ID:
				return new FailoverEndPoint2EditPart(view);

			case FailoverEndPointEndPointName2EditPart.VISUAL_ID:
				return new FailoverEndPointEndPointName2EditPart(view);

			case FailoverEndPointInputConnector2EditPart.VISUAL_ID:
				return new FailoverEndPointInputConnector2EditPart(view);

			case FailoverEndPointOutputConnector2EditPart.VISUAL_ID:
				return new FailoverEndPointOutputConnector2EditPart(view);

			case FailoverEndPointWestOutputConnector2EditPart.VISUAL_ID:
				return new FailoverEndPointWestOutputConnector2EditPart(view);

			case MediatorFlow27EditPart.VISUAL_ID:
				return new MediatorFlow27EditPart(view);

			case RecipientListEndPoint2EditPart.VISUAL_ID:
				return new RecipientListEndPoint2EditPart(view);

			case RecipientListEndPointInputConnector2EditPart.VISUAL_ID:
				return new RecipientListEndPointInputConnector2EditPart(view);

			case RecipientListEndPointOutputConnector2EditPart.VISUAL_ID:
				return new RecipientListEndPointOutputConnector2EditPart(view);

			case RecipientListEndPointWestOutputConnector2EditPart.VISUAL_ID:
				return new RecipientListEndPointWestOutputConnector2EditPart(view);

			case MediatorFlow28EditPart.VISUAL_ID:
				return new MediatorFlow28EditPart(view);

			case WSDLEndPoint2EditPart.VISUAL_ID:
				return new WSDLEndPoint2EditPart(view);

			case WSDLEndPointEndPointName2EditPart.VISUAL_ID:
				return new WSDLEndPointEndPointName2EditPart(view);

			case WSDLEndPointInputConnector2EditPart.VISUAL_ID:
				return new WSDLEndPointInputConnector2EditPart(view);

			case WSDLEndPointOutputConnector2EditPart.VISUAL_ID:
				return new WSDLEndPointOutputConnector2EditPart(view);

			case LoadBalanceEndPoint2EditPart.VISUAL_ID:
				return new LoadBalanceEndPoint2EditPart(view);

			case LoadBalanceEndPointEndPointName2EditPart.VISUAL_ID:
				return new LoadBalanceEndPointEndPointName2EditPart(view);

			case LoadBalanceEndPointInputConnector2EditPart.VISUAL_ID:
				return new LoadBalanceEndPointInputConnector2EditPart(view);

			case LoadBalanceEndPointOutputConnector2EditPart.VISUAL_ID:
				return new LoadBalanceEndPointOutputConnector2EditPart(view);

			case LoadBalanceEndPointWestOutputConnector2EditPart.VISUAL_ID:
				return new LoadBalanceEndPointWestOutputConnector2EditPart(view);

			case MediatorFlow29EditPart.VISUAL_ID:
				return new MediatorFlow29EditPart(view);

			case HTTPEndpoint2EditPart.VISUAL_ID:
				return new HTTPEndpoint2EditPart(view);

			case HTTPEndPointInputConnector2EditPart.VISUAL_ID:
				return new HTTPEndPointInputConnector2EditPart(view);

			case HTTPEndPointOutputConnector2EditPart.VISUAL_ID:
				return new HTTPEndPointOutputConnector2EditPart(view);

			case TemplateEndpoint2EditPart.VISUAL_ID:
				return new TemplateEndpoint2EditPart(view);

			case TemplateEndpointInputConnector2EditPart.VISUAL_ID:
				return new TemplateEndpointInputConnector2EditPart(view);

			case TemplateEndpointOutputConnector2EditPart.VISUAL_ID:
				return new TemplateEndpointOutputConnector2EditPart(view);

			case LocalEntryEditPart.VISUAL_ID:
				return new LocalEntryEditPart(view);

			case TemplateEditPart.VISUAL_ID:
				return new TemplateEditPart(view);

			case Sequences2EditPart.VISUAL_ID:
				return new Sequences2EditPart(view);

			case EndpointDiagram2EditPart.VISUAL_ID:
				return new EndpointDiagram2EditPart(view);

			case TaskEditPart.VISUAL_ID:
				return new TaskEditPart(view);

			case SynapseAPIEditPart.VISUAL_ID:
				return new SynapseAPIEditPart(view);

			case APIResourceEditPart.VISUAL_ID:
				return new APIResourceEditPart(view);

			case APIResourceInputConnectorEditPart.VISUAL_ID:
				return new APIResourceInputConnectorEditPart(view);

			case APIResourceOutputConnectorEditPart.VISUAL_ID:
				return new APIResourceOutputConnectorEditPart(view);

			case APIResourceOutSequenceOutputConnectorEditPart.VISUAL_ID:
				return new APIResourceOutSequenceOutputConnectorEditPart(view);

			case APIResourceFaultInputConnectorEditPart.VISUAL_ID:
				return new APIResourceFaultInputConnectorEditPart(view);

			case ProxyServiceContainer2EditPart.VISUAL_ID:
				return new ProxyServiceContainer2EditPart(view);

			case APIResourceInSequenceInputConnectorEditPart.VISUAL_ID:
				return new APIResourceInSequenceInputConnectorEditPart(view);

			case ComplexEndpointsEditPart.VISUAL_ID:
				return new ComplexEndpointsEditPart(view);

			case MediatorFlow18EditPart.VISUAL_ID:
				return new MediatorFlow18EditPart(view);

			case ComplexEndpointsOutputConnectorEditPart.VISUAL_ID:
				return new ComplexEndpointsOutputConnectorEditPart(view);

			case MessageStoreEditPart.VISUAL_ID:
				return new MessageStoreEditPart(view);

			case MessageProcessorEditPart.VISUAL_ID:
				return new MessageProcessorEditPart(view);

			case InboundEndpointEditPart.VISUAL_ID:
				return new InboundEndpointEditPart(view);

			case InboundEndpointSequenceInputConnectorEditPart.VISUAL_ID:
				return new InboundEndpointSequenceInputConnectorEditPart(view);

			case InboundEndpointSequenceOutputConnectorEditPart.VISUAL_ID:
				return new InboundEndpointSequenceOutputConnectorEditPart(view);

			case InboundEndpointOnErrorSequenceInputConnectorEditPart.VISUAL_ID:
				return new InboundEndpointOnErrorSequenceInputConnectorEditPart(view);

			case InboundEndpointOnErrorSequenceOutputConnectorEditPart.VISUAL_ID:
				return new InboundEndpointOnErrorSequenceOutputConnectorEditPart(view);

			case InboundEndpointContainerEditPart.VISUAL_ID:
				return new InboundEndpointContainerEditPart(view);

			case InboundEndpointSequenceContainerEditPart.VISUAL_ID:
				return new InboundEndpointSequenceContainerEditPart(view);

			case MediatorFlow25EditPart.VISUAL_ID:
				return new MediatorFlow25EditPart(view);

			case InboundEndpointOnErrorSequenceContainerEditPart.VISUAL_ID:
				return new InboundEndpointOnErrorSequenceContainerEditPart(view);

			case MediatorFlow26EditPart.VISUAL_ID:
				return new MediatorFlow26EditPart(view);

			case EsbServerContentsCompartmentEditPart.VISUAL_ID:
				return new EsbServerContentsCompartmentEditPart(view);

			case MediatorFlowMediatorFlowCompartmentEditPart.VISUAL_ID:
				return new MediatorFlowMediatorFlowCompartmentEditPart(view);

			case MediatorFlowMediatorFlowCompartment9EditPart.VISUAL_ID:
				return new MediatorFlowMediatorFlowCompartment9EditPart(view);

			case MediatorFlowMediatorFlowCompartment7EditPart.VISUAL_ID:
				return new MediatorFlowMediatorFlowCompartment7EditPart(view);

			case MediatorFlowMediatorFlowCompartment2EditPart.VISUAL_ID:
				return new MediatorFlowMediatorFlowCompartment2EditPart(view);

			case MediatorFlowMediatorFlowCompartment21EditPart.VISUAL_ID:
				return new MediatorFlowMediatorFlowCompartment21EditPart(view);

			case MediatorFlowMediatorFlowCompartment19EditPart.VISUAL_ID:
				return new MediatorFlowMediatorFlowCompartment19EditPart(view);

			case MediatorFlowMediatorFlowCompartment11EditPart.VISUAL_ID:
				return new MediatorFlowMediatorFlowCompartment11EditPart(view);

			case MediatorFlowMediatorFlowCompartment13EditPart.VISUAL_ID:
				return new MediatorFlowMediatorFlowCompartment13EditPart(view);

			case MediatorFlowMediatorFlowCompartment12EditPart.VISUAL_ID:
				return new MediatorFlowMediatorFlowCompartment12EditPart(view);

			case MediatorFlowMediatorFlowCompartment17EditPart.VISUAL_ID:
				return new MediatorFlowMediatorFlowCompartment17EditPart(view);

			case MediatorFlowMediatorFlowCompartment3EditPart.VISUAL_ID:
				return new MediatorFlowMediatorFlowCompartment3EditPart(view);

			case MediatorFlowMediatorFlowCompartment14EditPart.VISUAL_ID:
				return new MediatorFlowMediatorFlowCompartment14EditPart(view);

			case MediatorFlowMediatorFlowCompartment15EditPart.VISUAL_ID:
				return new MediatorFlowMediatorFlowCompartment15EditPart(view);

			case MediatorFlowMediatorFlowCompartment16EditPart.VISUAL_ID:
				return new MediatorFlowMediatorFlowCompartment16EditPart(view);

			case MediatorFlowMediatorFlowCompartment20EditPart.VISUAL_ID:
				return new MediatorFlowMediatorFlowCompartment20EditPart(view);

			case MediatorFlowMediatorFlowCompartment30EditPart.VISUAL_ID:
				return new MediatorFlowMediatorFlowCompartment30EditPart(view);

			case MediatorFlowMediatorFlowCompartment22EditPart.VISUAL_ID:
				return new MediatorFlowMediatorFlowCompartment22EditPart(view);

			case MediatorFlowMediatorFlowCompartment23EditPart.VISUAL_ID:
				return new MediatorFlowMediatorFlowCompartment23EditPart(view);

			case MediatorFlowMediatorFlowCompartment24EditPart.VISUAL_ID:
				return new MediatorFlowMediatorFlowCompartment24EditPart(view);

			case MediatorFlowMediatorFlowCompartment4EditPart.VISUAL_ID:
				return new MediatorFlowMediatorFlowCompartment4EditPart(view);

			case MediatorFlowMediatorFlowCompartment8EditPart.VISUAL_ID:
				return new MediatorFlowMediatorFlowCompartment8EditPart(view);

			case MediatorFlowMediatorFlowCompartment10EditPart.VISUAL_ID:
				return new MediatorFlowMediatorFlowCompartment10EditPart(view);

			case MediatorFlowMediatorFlowCompartment6EditPart.VISUAL_ID:
				return new MediatorFlowMediatorFlowCompartment6EditPart(view);

			case MediatorFlowMediatorFlowCompartment5EditPart.VISUAL_ID:
				return new MediatorFlowMediatorFlowCompartment5EditPart(view);

			case EndpointDiagramEndpointCompartmentEditPart.VISUAL_ID:
				return new EndpointDiagramEndpointCompartmentEditPart(view);

			case MediatorFlowMediatorFlowCompartment27EditPart.VISUAL_ID:
				return new MediatorFlowMediatorFlowCompartment27EditPart(view);

			case MediatorFlowMediatorFlowCompartment28EditPart.VISUAL_ID:
				return new MediatorFlowMediatorFlowCompartment28EditPart(view);

			case MediatorFlowMediatorFlowCompartment29EditPart.VISUAL_ID:
				return new MediatorFlowMediatorFlowCompartment29EditPart(view);

			case TemplateTemplateCompartmentEditPart.VISUAL_ID:
				return new TemplateTemplateCompartmentEditPart(view);

			case EndpointDiagramEndpointCompartment2EditPart.VISUAL_ID:
				return new EndpointDiagramEndpointCompartment2EditPart(view);

			case SynapseAPIAPICompartmentEditPart.VISUAL_ID:
				return new SynapseAPIAPICompartmentEditPart(view);

			case MediatorFlowMediatorFlowCompartment18EditPart.VISUAL_ID:
				return new MediatorFlowMediatorFlowCompartment18EditPart(view);

			case MediatorFlowMediatorFlowCompartment25EditPart.VISUAL_ID:
				return new MediatorFlowMediatorFlowCompartment25EditPart(view);

			case MediatorFlowMediatorFlowCompartment26EditPart.VISUAL_ID:
				return new MediatorFlowMediatorFlowCompartment26EditPart(view);

			case EsbLinkEditPart.VISUAL_ID:
				return new EsbLinkEditPart(view);

			}
		}
		return createUnrecognizedEditPart(context, model);
	}

	/**
	 * @generated
	 */
	private EditPart createUnrecognizedEditPart(EditPart context, Object model) {
		// Handle creation of unrecognized child node EditParts here
		return null;
	}

	/**
	 * @generated
	 */
	public static CellEditorLocator getTextCellEditorLocator(ITextAwareEditPart source) {
		return CellEditorLocatorAccess.INSTANCE.getTextCellEditorLocator(source);
	}
}
