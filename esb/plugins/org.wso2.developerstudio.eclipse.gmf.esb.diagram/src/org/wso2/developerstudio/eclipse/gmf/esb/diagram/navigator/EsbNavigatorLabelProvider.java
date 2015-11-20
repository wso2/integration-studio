package org.wso2.developerstudio.eclipse.gmf.esb.diagram.navigator;

import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.ITreePathLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.ViewerLabel;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonLabelProvider;
import org.wso2.developerstudio.eclipse.gmf.esb.APIResource;
import org.wso2.developerstudio.eclipse.gmf.esb.APIResourceEndpoint;
import org.wso2.developerstudio.eclipse.gmf.esb.AddressingEndpoint;
import org.wso2.developerstudio.eclipse.gmf.esb.BAMMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.BeanMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.BuilderMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.CallMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.CallTemplateMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.CloneMediatorTargetOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.ComplexEndpoints;
import org.wso2.developerstudio.eclipse.gmf.esb.ConditionalRouterMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.DataMapperMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.DropMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.EJBMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.EndpointDiagram;
import org.wso2.developerstudio.eclipse.gmf.esb.EnqueueMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbDiagram;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbServer;
import org.wso2.developerstudio.eclipse.gmf.esb.HTTPEndpoint;
import org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpoint;
import org.wso2.developerstudio.eclipse.gmf.esb.InboundEndpointContainer;
import org.wso2.developerstudio.eclipse.gmf.esb.LocalEntry;
import org.wso2.developerstudio.eclipse.gmf.esb.LoopBackMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.MergeNode;
import org.wso2.developerstudio.eclipse.gmf.esb.MessageMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.MessageProcessor;
import org.wso2.developerstudio.eclipse.gmf.esb.MessageStore;
import org.wso2.developerstudio.eclipse.gmf.esb.NamedEndpoint;
import org.wso2.developerstudio.eclipse.gmf.esb.PayloadFactoryMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.RMSequenceMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.RecipientListEndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.RouterMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.RouterMediatorTargetOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.RouterTargetContainer;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.SendMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.Sequence;
import org.wso2.developerstudio.eclipse.gmf.esb.Sequences;
import org.wso2.developerstudio.eclipse.gmf.esb.SmooksMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.StoreMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.SwitchCaseBranchOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.SwitchMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.SynapseAPI;
import org.wso2.developerstudio.eclipse.gmf.esb.Task;
import org.wso2.developerstudio.eclipse.gmf.esb.Template;
import org.wso2.developerstudio.eclipse.gmf.esb.TemplateEndpoint;
import org.wso2.developerstudio.eclipse.gmf.esb.TransactionMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.URLRewriteMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.ValidateMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.XSLTMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.*;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbDiagramEditorPlugin;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbVisualIDRegistry;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbParserProvider;

/**
 * @generated
 */
public class EsbNavigatorLabelProvider extends LabelProvider implements ICommonLabelProvider, ITreePathLabelProvider {

	/**
	 * @generated
	 */
	static {
		EsbDiagramEditorPlugin.getInstance().getImageRegistry()
				.put("Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
		EsbDiagramEditorPlugin.getInstance().getImageRegistry()
				.put("Navigator?ImageNotFound", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof EsbNavigatorItem && !isOwnView(((EsbNavigatorItem) element).getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	 * @generated
	 */
	public Image getImage(Object element) {
		if (element instanceof EsbNavigatorGroup) {
			EsbNavigatorGroup group = (EsbNavigatorGroup) element;
			return EsbDiagramEditorPlugin.getInstance().getBundledImage(group.getIcon());
		}

		if (element instanceof EsbNavigatorItem) {
			EsbNavigatorItem navigatorItem = (EsbNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return super.getImage(element);
			}
			return getImage(navigatorItem.getView());
		}

		return super.getImage(element);
	}

	/**
	 * @generated
	 */
	public Image getImage(View view) {
		switch (EsbVisualIDRegistry.getVisualID(view)) {
		case EsbDiagramEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Diagram?http:///org/wso2/developerstudio/eclipse/gmf/esb?EsbDiagram", EsbElementTypes.EsbDiagram_1000); //$NON-NLS-1$
		case EsbServerEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http:///org/wso2/developerstudio/eclipse/gmf/esb?EsbServer", EsbElementTypes.EsbServer_2001); //$NON-NLS-1$
		case ProxyServiceEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?ProxyService", EsbElementTypes.ProxyService_3001); //$NON-NLS-1$
		case ProxyOutputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?ProxyOutputConnector", EsbElementTypes.ProxyOutputConnector_3002); //$NON-NLS-1$
		case ProxyInputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?ProxyInputConnector", EsbElementTypes.ProxyInputConnector_3003); //$NON-NLS-1$
		case DropMediatorInputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?DropMediatorInputConnector", EsbElementTypes.DropMediatorInputConnector_3008); //$NON-NLS-1$
		case FilterMediatorInputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?FilterMediatorInputConnector", EsbElementTypes.FilterMediatorInputConnector_3010); //$NON-NLS-1$
		case FilterMediatorPassOutputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?FilterMediatorPassOutputConnector", EsbElementTypes.FilterMediatorPassOutputConnector_3011); //$NON-NLS-1$
		case FilterMediatorFailOutputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?FilterMediatorFailOutputConnector", EsbElementTypes.FilterMediatorFailOutputConnector_3012); //$NON-NLS-1$
		case MergeNodeEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?MergeNode", EsbElementTypes.MergeNode_3013); //$NON-NLS-1$
		case MergeNodeFirstInputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?MergeNodeFirstInputConnector", EsbElementTypes.MergeNodeFirstInputConnector_3014); //$NON-NLS-1$
		case MergeNodeSecondInputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?MergeNodeSecondInputConnector", EsbElementTypes.MergeNodeSecondInputConnector_3015); //$NON-NLS-1$
		case MergeNodeOutputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?MergeNodeOutputConnector", EsbElementTypes.MergeNodeOutputConnector_3016); //$NON-NLS-1$
		case LogMediatorInputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?LogMediatorInputConnector", EsbElementTypes.LogMediatorInputConnector_3018); //$NON-NLS-1$
		case LogMediatorOutputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?LogMediatorOutputConnector", EsbElementTypes.LogMediatorOutputConnector_3019); //$NON-NLS-1$
		case DefaultEndPointInputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?DefaultEndPointInputConnector", EsbElementTypes.DefaultEndPointInputConnector_3021); //$NON-NLS-1$
		case DefaultEndPointOutputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?DefaultEndPointOutputConnector", EsbElementTypes.DefaultEndPointOutputConnector_3022); //$NON-NLS-1$
		case AddressEndPointInputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?AddressEndPointInputConnector", EsbElementTypes.AddressEndPointInputConnector_3030); //$NON-NLS-1$
		case AddressEndPointOutputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?AddressEndPointOutputConnector", EsbElementTypes.AddressEndPointOutputConnector_3031); //$NON-NLS-1$
		case PropertyMediatorInputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?PropertyMediatorInputConnector", EsbElementTypes.PropertyMediatorInputConnector_3033); //$NON-NLS-1$
		case PropertyMediatorOutputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?PropertyMediatorOutputConnector", EsbElementTypes.PropertyMediatorOutputConnector_3034); //$NON-NLS-1$
		case EnrichMediatorInputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?EnrichMediatorInputConnector", EsbElementTypes.EnrichMediatorInputConnector_3036); //$NON-NLS-1$
		case EnrichMediatorOutputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?EnrichMediatorOutputConnector", EsbElementTypes.EnrichMediatorOutputConnector_3037); //$NON-NLS-1$
		case XSLTMediatorInputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?XSLTMediatorInputConnector", EsbElementTypes.XSLTMediatorInputConnector_3039); //$NON-NLS-1$
		case XSLTMediatorOutputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?XSLTMediatorOutputConnector", EsbElementTypes.XSLTMediatorOutputConnector_3040); //$NON-NLS-1$
		case SwitchMediatorInputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?SwitchMediatorInputConnector", EsbElementTypes.SwitchMediatorInputConnector_3042); //$NON-NLS-1$
		case SwitchCaseBranchOutputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?SwitchCaseBranchOutputConnector", EsbElementTypes.SwitchCaseBranchOutputConnector_3043); //$NON-NLS-1$
		case SwitchDefaultBranchOutputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?SwitchDefaultBranchOutputConnector", EsbElementTypes.SwitchDefaultBranchOutputConnector_3044); //$NON-NLS-1$
		case MessageMediatorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?MessageMediator", EsbElementTypes.MessageMediator_3045); //$NON-NLS-1$
		case MessageInputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?MessageInputConnector", EsbElementTypes.MessageInputConnector_3046); //$NON-NLS-1$
		case MessageOutputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?MessageOutputConnector", EsbElementTypes.MessageOutputConnector_3047); //$NON-NLS-1$
		case SequenceInputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?SequenceInputConnector", EsbElementTypes.SequenceInputConnector_3049); //$NON-NLS-1$
		case SequenceOutputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?SequenceOutputConnector", EsbElementTypes.SequenceOutputConnector_3050); //$NON-NLS-1$
		case EventMediatorInputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?EventMediatorInputConnector", EsbElementTypes.EventMediatorInputConnector_3052); //$NON-NLS-1$
		case EventMediatorOutputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?EventMediatorOutputConnector", EsbElementTypes.EventMediatorOutputConnector_3053); //$NON-NLS-1$
		case EntitlementMediatorInputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?EntitlementMediatorInputConnector", EsbElementTypes.EntitlementMediatorInputConnector_3055); //$NON-NLS-1$
		case EntitlementMediatorOutputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?EntitlementMediatorOutputConnector", EsbElementTypes.EntitlementMediatorOutputConnector_3056); //$NON-NLS-1$
		case ClassMediatorInputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?ClassMediatorInputConnector", EsbElementTypes.ClassMediatorInputConnector_3058); //$NON-NLS-1$
		case ClassMediatorOutputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?ClassMediatorOutputConnector", EsbElementTypes.ClassMediatorOutputConnector_3059); //$NON-NLS-1$
		case SpringMediatorInputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?SpringMediatorInputConnector", EsbElementTypes.SpringMediatorInputConnector_3061); //$NON-NLS-1$
		case SpringMediatorOutputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?SpringMediatorOutputConnector", EsbElementTypes.SpringMediatorOutputConnector_3062); //$NON-NLS-1$
		case ScriptMediatorInputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?ScriptMediatorInputConnector", EsbElementTypes.ScriptMediatorInputConnector_3064); //$NON-NLS-1$
		case ScriptMediatorOutputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?ScriptMediatorOutputConnector", EsbElementTypes.ScriptMediatorOutputConnector_3065); //$NON-NLS-1$
		case FaultMediatorInputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?FaultMediatorInputConnector", EsbElementTypes.FaultMediatorInputConnector_3067); //$NON-NLS-1$
		case FaultMediatorOutputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?FaultMediatorOutputConnector", EsbElementTypes.FaultMediatorOutputConnector_3068); //$NON-NLS-1$
		case XQueryMediatorInputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?XQueryMediatorInputConnector", EsbElementTypes.XQueryMediatorInputConnector_3070); //$NON-NLS-1$
		case XQueryMediatorOutputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?XQueryMediatorOutputConnector", EsbElementTypes.XQueryMediatorOutputConnector_3071); //$NON-NLS-1$
		case CommandMediatorInputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?CommandMediatorInputConnector", EsbElementTypes.CommandMediatorInputConnector_3073); //$NON-NLS-1$
		case CommandMediatorOutputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?CommandMediatorOutputConnector", EsbElementTypes.CommandMediatorOutputConnector_3074); //$NON-NLS-1$
		case DBLookupMediatorInputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?DBLookupMediatorInputConnector", EsbElementTypes.DBLookupMediatorInputConnector_3076); //$NON-NLS-1$
		case DBLookupMediatorOutputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?DBLookupMediatorOutputConnector", EsbElementTypes.DBLookupMediatorOutputConnector_3077); //$NON-NLS-1$
		case DBReportMediatorInputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?DBReportMediatorInputConnector", EsbElementTypes.DBReportMediatorInputConnector_3079); //$NON-NLS-1$
		case DBReportMediatorOutputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?DBReportMediatorOutputConnector", EsbElementTypes.DBReportMediatorOutputConnector_3080); //$NON-NLS-1$
		case SmooksMediatorInputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?SmooksMediatorInputConnector", EsbElementTypes.SmooksMediatorInputConnector_3082); //$NON-NLS-1$
		case SmooksMediatorOutputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?SmooksMediatorOutputConnector", EsbElementTypes.SmooksMediatorOutputConnector_3083); //$NON-NLS-1$
		case SendMediatorInputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?SendMediatorInputConnector", EsbElementTypes.SendMediatorInputConnector_3085); //$NON-NLS-1$
		case SendMediatorOutputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?SendMediatorOutputConnector", EsbElementTypes.SendMediatorOutputConnector_3086); //$NON-NLS-1$
		case FailoverEndPointInputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?FailoverEndPointInputConnector", EsbElementTypes.FailoverEndPointInputConnector_3088); //$NON-NLS-1$
		case FailoverEndPointOutputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?FailoverEndPointOutputConnector", EsbElementTypes.FailoverEndPointOutputConnector_3090); //$NON-NLS-1$
		case WSDLEndPointInputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?WSDLEndPointInputConnector", EsbElementTypes.WSDLEndPointInputConnector_3092); //$NON-NLS-1$
		case WSDLEndPointOutputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?WSDLEndPointOutputConnector", EsbElementTypes.WSDLEndPointOutputConnector_3093); //$NON-NLS-1$
		case LoadBalanceEndPointInputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?LoadBalanceEndPointInputConnector", EsbElementTypes.LoadBalanceEndPointInputConnector_3095); //$NON-NLS-1$
		case LoadBalanceEndPointOutputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?LoadBalanceEndPointOutputConnector", EsbElementTypes.LoadBalanceEndPointOutputConnector_3096); //$NON-NLS-1$
		case FailoverEndPointWestOutputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?FailoverEndPointWestOutputConnector", EsbElementTypes.FailoverEndPointWestOutputConnector_3097); //$NON-NLS-1$
		case LoadBalanceEndPointWestOutputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?LoadBalanceEndPointWestOutputConnector", EsbElementTypes.LoadBalanceEndPointWestOutputConnector_3098); //$NON-NLS-1$
		case HeaderMediatorInputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?HeaderMediatorInputConnector", EsbElementTypes.HeaderMediatorInputConnector_3100); //$NON-NLS-1$
		case HeaderMediatorOutputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?HeaderMediatorOutputConnector", EsbElementTypes.HeaderMediatorOutputConnector_3101); //$NON-NLS-1$
		case CloneMediatorInputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?CloneMediatorInputConnector", EsbElementTypes.CloneMediatorInputConnector_3103); //$NON-NLS-1$
		case CloneMediatorOutputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?CloneMediatorOutputConnector", EsbElementTypes.CloneMediatorOutputConnector_3104); //$NON-NLS-1$
		case CacheMediatorInputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?CacheMediatorInputConnector", EsbElementTypes.CacheMediatorInputConnector_3106); //$NON-NLS-1$
		case CacheMediatorOutputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?CacheMediatorOutputConnector", EsbElementTypes.CacheMediatorOutputConnector_3107); //$NON-NLS-1$
		case IterateMediatorInputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?IterateMediatorInputConnector", EsbElementTypes.IterateMediatorInputConnector_3109); //$NON-NLS-1$
		case IterateMediatorOutputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?IterateMediatorOutputConnector", EsbElementTypes.IterateMediatorOutputConnector_3110); //$NON-NLS-1$
		case AggregateMediatorInputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?AggregateMediatorInputConnector", EsbElementTypes.AggregateMediatorInputConnector_3112); //$NON-NLS-1$
		case AggregateMediatorOutputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?AggregateMediatorOutputConnector", EsbElementTypes.AggregateMediatorOutputConnector_3113); //$NON-NLS-1$
		case CalloutMediatorInputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?CalloutMediatorInputConnector", EsbElementTypes.CalloutMediatorInputConnector_3115); //$NON-NLS-1$
		case CalloutMediatorOutputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?CalloutMediatorOutputConnector", EsbElementTypes.CalloutMediatorOutputConnector_3116); //$NON-NLS-1$
		case TransactionMediatorInputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?TransactionMediatorInputConnector", EsbElementTypes.TransactionMediatorInputConnector_3118); //$NON-NLS-1$
		case TransactionMediatorOutputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?TransactionMediatorOutputConnector", EsbElementTypes.TransactionMediatorOutputConnector_3119); //$NON-NLS-1$
		case ThrottleMediatorInputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?ThrottleMediatorInputConnector", EsbElementTypes.ThrottleMediatorInputConnector_3121); //$NON-NLS-1$
		case ThrottleMediatorOutputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?ThrottleMediatorOutputConnector", EsbElementTypes.ThrottleMediatorOutputConnector_3122); //$NON-NLS-1$
		case RMSequenceMediatorInputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?RMSequenceMediatorInputConnector", EsbElementTypes.RMSequenceMediatorInputConnector_3124); //$NON-NLS-1$
		case RMSequenceMediatorOutputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?RMSequenceMediatorOutputConnector", EsbElementTypes.RMSequenceMediatorOutputConnector_3125); //$NON-NLS-1$
		case RuleMediatorInputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?RuleMediatorInputConnector", EsbElementTypes.RuleMediatorInputConnector_3127); //$NON-NLS-1$
		case RuleMediatorOutputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?RuleMediatorOutputConnector", EsbElementTypes.RuleMediatorOutputConnector_3128); //$NON-NLS-1$
		case OAuthMediatorInputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?OAuthMediatorInputConnector", EsbElementTypes.OAuthMediatorInputConnector_3130); //$NON-NLS-1$
		case OAuthMediatorOutputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?OAuthMediatorOutputConnector", EsbElementTypes.OAuthMediatorOutputConnector_3131); //$NON-NLS-1$
		case AggregateMediatorOnCompleteOutputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?AggregateMediatorOnCompleteOutputConnector", EsbElementTypes.AggregateMediatorOnCompleteOutputConnector_3132); //$NON-NLS-1$
		case CloneMediatorTargetOutputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?CloneMediatorTargetOutputConnector", EsbElementTypes.CloneMediatorTargetOutputConnector_3133); //$NON-NLS-1$
		case ProxyServiceContainerEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?ProxyServiceContainer", EsbElementTypes.ProxyServiceContainer_3486); //$NON-NLS-1$
		case ProxyServiceSequenceAndEndpointContainerEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?ProxyServiceSequenceAndEndpointContainer", EsbElementTypes.ProxyServiceSequenceAndEndpointContainer_3487); //$NON-NLS-1$
		case ProxyServiceFaultContainerEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?ProxyServiceFaultContainer", EsbElementTypes.ProxyServiceFaultContainer_3488); //$NON-NLS-1$
		case ProxyFaultInputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?ProxyFaultInputConnector", EsbElementTypes.ProxyFaultInputConnector_3489); //$NON-NLS-1$
		case DropMediatorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?DropMediator", EsbElementTypes.DropMediator_3491); //$NON-NLS-1$
		case PropertyMediatorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?PropertyMediator", EsbElementTypes.PropertyMediator_3492); //$NON-NLS-1$
		case ThrottleMediatorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?ThrottleMediator", EsbElementTypes.ThrottleMediator_3493); //$NON-NLS-1$
		case FilterMediatorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?FilterMediator", EsbElementTypes.FilterMediator_3494); //$NON-NLS-1$
		case LogMediatorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?LogMediator", EsbElementTypes.LogMediator_3495); //$NON-NLS-1$
		case EnrichMediatorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?EnrichMediator", EsbElementTypes.EnrichMediator_3496); //$NON-NLS-1$
		case XSLTMediatorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?XSLTMediator", EsbElementTypes.XSLTMediator_3497); //$NON-NLS-1$
		case SwitchMediatorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?SwitchMediator", EsbElementTypes.SwitchMediator_3498); //$NON-NLS-1$
		case SwitchMediatorOutputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?SwitchMediatorOutputConnector", EsbElementTypes.SwitchMediatorOutputConnector_3499); //$NON-NLS-1$
		case SwitchMediatorContainerEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?SwitchMediatorContainer", EsbElementTypes.SwitchMediatorContainer_3500); //$NON-NLS-1$
		case MediatorFlow2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?MediatorFlow", EsbElementTypes.MediatorFlow_3502); //$NON-NLS-1$
		case SequenceEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?Sequence", EsbElementTypes.Sequence_3503); //$NON-NLS-1$
		case EventMediatorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?EventMediator", EsbElementTypes.EventMediator_3504); //$NON-NLS-1$
		case EntitlementMediatorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?EntitlementMediator", EsbElementTypes.EntitlementMediator_3505); //$NON-NLS-1$
		case ClassMediatorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?ClassMediator", EsbElementTypes.ClassMediator_3506); //$NON-NLS-1$
		case SpringMediatorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?SpringMediator", EsbElementTypes.SpringMediator_3507); //$NON-NLS-1$
		case ScriptMediatorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?ScriptMediator", EsbElementTypes.ScriptMediator_3508); //$NON-NLS-1$
		case FaultMediatorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?FaultMediator", EsbElementTypes.FaultMediator_3509); //$NON-NLS-1$
		case XQueryMediatorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?XQueryMediator", EsbElementTypes.XQueryMediator_3510); //$NON-NLS-1$
		case CommandMediatorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?CommandMediator", EsbElementTypes.CommandMediator_3511); //$NON-NLS-1$
		case DBLookupMediatorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?DBLookupMediator", EsbElementTypes.DBLookupMediator_3512); //$NON-NLS-1$
		case DBReportMediatorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?DBReportMediator", EsbElementTypes.DBReportMediator_3513); //$NON-NLS-1$
		case SmooksMediatorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?SmooksMediator", EsbElementTypes.SmooksMediator_3514); //$NON-NLS-1$
		case SendMediatorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?SendMediator", EsbElementTypes.SendMediator_3515); //$NON-NLS-1$
		case HeaderMediatorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?HeaderMediator", EsbElementTypes.HeaderMediator_3516); //$NON-NLS-1$
		case CloneMediatorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?CloneMediator", EsbElementTypes.CloneMediator_3517); //$NON-NLS-1$
		case CacheMediatorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?CacheMediator", EsbElementTypes.CacheMediator_3518); //$NON-NLS-1$
		case IterateMediatorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?IterateMediator", EsbElementTypes.IterateMediator_3519); //$NON-NLS-1$
		case CalloutMediatorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?CalloutMediator", EsbElementTypes.CalloutMediator_3520); //$NON-NLS-1$
		case TransactionMediatorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?TransactionMediator", EsbElementTypes.TransactionMediator_3521); //$NON-NLS-1$
		case RMSequenceMediatorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?RMSequenceMediator", EsbElementTypes.RMSequenceMediator_3522); //$NON-NLS-1$
		case RuleMediatorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?RuleMediator", EsbElementTypes.RuleMediator_3523); //$NON-NLS-1$
		case OAuthMediatorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?OAuthMediator", EsbElementTypes.OAuthMediator_3524); //$NON-NLS-1$
		case AggregateMediatorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?AggregateMediator", EsbElementTypes.AggregateMediator_3525); //$NON-NLS-1$
		case MediatorFlow3EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?MediatorFlow", EsbElementTypes.MediatorFlow_3526); //$NON-NLS-1$
		case MediatorFlow4EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?MediatorFlow", EsbElementTypes.MediatorFlow_3528); //$NON-NLS-1$
		case MediatorFlow6EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?MediatorFlow", EsbElementTypes.MediatorFlow_3530); //$NON-NLS-1$
		case FilterContainerEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?FilterContainer", EsbElementTypes.FilterContainer_3531); //$NON-NLS-1$
		case FilterMediatorOutputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?FilterMediatorOutputConnector", EsbElementTypes.FilterMediatorOutputConnector_3534); //$NON-NLS-1$
		case FilterPassContainerEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?FilterPassContainer", EsbElementTypes.FilterPassContainer_3535); //$NON-NLS-1$
		case MediatorFlow7EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?MediatorFlow", EsbElementTypes.MediatorFlow_3536); //$NON-NLS-1$
		case FilterFailContainerEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?FilterFailContainer", EsbElementTypes.FilterFailContainer_3537); //$NON-NLS-1$
		case MediatorFlow8EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?MediatorFlow", EsbElementTypes.MediatorFlow_3538); //$NON-NLS-1$
		case SendMediatorEndpointOutputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?SendMediatorEndpointOutputConnector", EsbElementTypes.SendMediatorEndpointOutputConnector_3539); //$NON-NLS-1$
		case ThrottleMediatorOnAcceptOutputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?ThrottleMediatorOnAcceptOutputConnector", EsbElementTypes.ThrottleMediatorOnAcceptOutputConnector_3581); //$NON-NLS-1$
		case ThrottleMediatorOnRejectOutputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?ThrottleMediatorOnRejectOutputConnector", EsbElementTypes.ThrottleMediatorOnRejectOutputConnector_3582); //$NON-NLS-1$
		case ThrottleContainerEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?ThrottleContainer", EsbElementTypes.ThrottleContainer_3583); //$NON-NLS-1$
		case ThrottleOnAcceptContainerEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?ThrottleOnAcceptContainer", EsbElementTypes.ThrottleOnAcceptContainer_3584); //$NON-NLS-1$
		case MediatorFlow9EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?MediatorFlow", EsbElementTypes.MediatorFlow_3585); //$NON-NLS-1$
		case ThrottleOnRejectContainerEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?ThrottleOnRejectContainer", EsbElementTypes.ThrottleOnRejectContainer_3586); //$NON-NLS-1$
		case MediatorFlow10EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?MediatorFlow", EsbElementTypes.MediatorFlow_3587); //$NON-NLS-1$
		case StoreMediatorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?StoreMediator", EsbElementTypes.StoreMediator_3588); //$NON-NLS-1$
		case StoreMediatorInputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?StoreMediatorInputConnector", EsbElementTypes.StoreMediatorInputConnector_3589); //$NON-NLS-1$
		case StoreMediatorOutputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?StoreMediatorOutputConnector", EsbElementTypes.StoreMediatorOutputConnector_3590); //$NON-NLS-1$
		case BuilderMediatorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?BuilderMediator", EsbElementTypes.BuilderMediator_3591); //$NON-NLS-1$
		case BuilderMediatorInputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?BuilderMediatorInputConnector", EsbElementTypes.BuilderMediatorInputConnector_3592); //$NON-NLS-1$
		case BuilderMediatorOutputConectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?BuilderMediatorOutputConector", EsbElementTypes.BuilderMediatorOutputConector_3593); //$NON-NLS-1$
		case CallTemplateMediatorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?CallTemplateMediator", EsbElementTypes.CallTemplateMediator_3594); //$NON-NLS-1$
		case CallTemplateMediatorInputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?CallTemplateMediatorInputConnector", EsbElementTypes.CallTemplateMediatorInputConnector_3595); //$NON-NLS-1$
		case CallTemplateMediatorOutputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?CallTemplateMediatorOutputConnector", EsbElementTypes.CallTemplateMediatorOutputConnector_3596); //$NON-NLS-1$
		case PayloadFactoryMediatorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?PayloadFactoryMediator", EsbElementTypes.PayloadFactoryMediator_3597); //$NON-NLS-1$
		case PayloadFactoryMediatorInputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?PayloadFactoryMediatorInputConnector", EsbElementTypes.PayloadFactoryMediatorInputConnector_3598); //$NON-NLS-1$
		case PayloadFactoryMediatorOutputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?PayloadFactoryMediatorOutputConnector", EsbElementTypes.PayloadFactoryMediatorOutputConnector_3599); //$NON-NLS-1$
		case EnqueueMediatorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?EnqueueMediator", EsbElementTypes.EnqueueMediator_3600); //$NON-NLS-1$
		case EnqueueMediatorInputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?EnqueueMediatorInputConnector", EsbElementTypes.EnqueueMediatorInputConnector_3601); //$NON-NLS-1$
		case EnqueueMediatorOutputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?EnqueueMediatorOutputConnector", EsbElementTypes.EnqueueMediatorOutputConnector_3602); //$NON-NLS-1$
		case CloneMediatorContainerEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?CloneMediatorContainer", EsbElementTypes.CloneMediatorContainer_3603); //$NON-NLS-1$
		case CloneTargetContainerEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?CloneTargetContainer", EsbElementTypes.CloneTargetContainer_3604); //$NON-NLS-1$
		case MediatorFlow11EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?MediatorFlow", EsbElementTypes.MediatorFlow_3605); //$NON-NLS-1$
		case IterateMediatorTargetOutputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?IterateMediatorTargetOutputConnector", EsbElementTypes.IterateMediatorTargetOutputConnector_3606); //$NON-NLS-1$
		case MediatorFlow12EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?MediatorFlow", EsbElementTypes.MediatorFlow_3607); //$NON-NLS-1$
		case MediatorFlowEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?MediatorFlow", EsbElementTypes.MediatorFlow_3608); //$NON-NLS-1$
		case DefaultEndPointEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?DefaultEndPoint", EsbElementTypes.DefaultEndPoint_3609); //$NON-NLS-1$
		case AddressEndPointEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?AddressEndPoint", EsbElementTypes.AddressEndPoint_3610); //$NON-NLS-1$
		case FailoverEndPointEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?FailoverEndPoint", EsbElementTypes.FailoverEndPoint_3611); //$NON-NLS-1$
		case WSDLEndPointEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?WSDLEndPoint", EsbElementTypes.WSDLEndPoint_3612); //$NON-NLS-1$
		case LoadBalanceEndPointEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?LoadBalanceEndPoint", EsbElementTypes.LoadBalanceEndPoint_3613); //$NON-NLS-1$
		case SequencesEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?Sequences", EsbElementTypes.Sequences_3614); //$NON-NLS-1$
		case MediatorFlow5EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?MediatorFlow", EsbElementTypes.MediatorFlow_3615); //$NON-NLS-1$
		case SequencesInputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?SequencesInputConnector", EsbElementTypes.SequencesInputConnector_3616); //$NON-NLS-1$
		case SequencesOutputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?SequencesOutputConnector", EsbElementTypes.SequencesOutputConnector_3617); //$NON-NLS-1$
		case CacheMediatorOnHitOutputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?CacheMediatorOnHitOutputConnector", EsbElementTypes.CacheMediatorOnHitOutputConnector_3618); //$NON-NLS-1$
		case MediatorFlow13EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?MediatorFlow", EsbElementTypes.MediatorFlow_3619); //$NON-NLS-1$
		case URLRewriteMediatorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?URLRewriteMediator", EsbElementTypes.URLRewriteMediator_3620); //$NON-NLS-1$
		case URLRewriteMediatorInputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?URLRewriteMediatorInputConnector", EsbElementTypes.URLRewriteMediatorInputConnector_3621); //$NON-NLS-1$
		case URLRewriteMediatorOutputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?URLRewriteMediatorOutputConnector", EsbElementTypes.URLRewriteMediatorOutputConnector_3622); //$NON-NLS-1$
		case ValidateMediatorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?ValidateMediator", EsbElementTypes.ValidateMediator_3623); //$NON-NLS-1$
		case ValidateMediatorInputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?ValidateMediatorInputConnector", EsbElementTypes.ValidateMediatorInputConnector_3624); //$NON-NLS-1$
		case ValidateMediatorOutputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?ValidateMediatorOutputConnector", EsbElementTypes.ValidateMediatorOutputConnector_3625); //$NON-NLS-1$
		case ValidateMediatorOnFailOutputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?ValidateMediatorOnFailOutputConnector", EsbElementTypes.ValidateMediatorOnFailOutputConnector_3626); //$NON-NLS-1$
		case MediatorFlow14EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?MediatorFlow", EsbElementTypes.MediatorFlow_3627); //$NON-NLS-1$
		case RouterMediatorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?RouterMediator", EsbElementTypes.RouterMediator_3628); //$NON-NLS-1$
		case RouterMediatorInputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?RouterMediatorInputConnector", EsbElementTypes.RouterMediatorInputConnector_3629); //$NON-NLS-1$
		case RouterMediatorOutputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?RouterMediatorOutputConnector", EsbElementTypes.RouterMediatorOutputConnector_3630); //$NON-NLS-1$
		case RouterMediatorTargetOutputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?RouterMediatorTargetOutputConnector", EsbElementTypes.RouterMediatorTargetOutputConnector_3631); //$NON-NLS-1$
		case RouterMediatorContainerEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?RouterMediatorContainer", EsbElementTypes.RouterMediatorContainer_3632); //$NON-NLS-1$
		case RouterTargetContainerEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?RouterTargetContainer", EsbElementTypes.RouterTargetContainer_3633); //$NON-NLS-1$
		case MediatorFlow15EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?MediatorFlow", EsbElementTypes.MediatorFlow_3634); //$NON-NLS-1$
		case ConditionalRouterMediatorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?ConditionalRouterMediator", EsbElementTypes.ConditionalRouterMediator_3635); //$NON-NLS-1$
		case ConditionalRouterMediatorInputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?ConditionalRouterMediatorInputConnector", EsbElementTypes.ConditionalRouterMediatorInputConnector_3636); //$NON-NLS-1$
		case ConditionalRouterMediatorOutputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?ConditionalRouterMediatorOutputConnector", EsbElementTypes.ConditionalRouterMediatorOutputConnector_3637); //$NON-NLS-1$
		case ConditionalRouterMediatorAdditionalOutputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?ConditionalRouterMediatorAdditionalOutputConnector", EsbElementTypes.ConditionalRouterMediatorAdditionalOutputConnector_3638); //$NON-NLS-1$
		case MediatorFlow16EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?MediatorFlow", EsbElementTypes.MediatorFlow_3639); //$NON-NLS-1$
		case RuleMediatorChildMediatorsOutputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?RuleMediatorChildMediatorsOutputConnector", EsbElementTypes.RuleMediatorChildMediatorsOutputConnector_3640); //$NON-NLS-1$
		case MediatorFlow17EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?MediatorFlow", EsbElementTypes.MediatorFlow_3641); //$NON-NLS-1$
		case EndpointDiagramEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?EndpointDiagram", EsbElementTypes.EndpointDiagram_3642); //$NON-NLS-1$
		case DefaultEndPoint2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?DefaultEndPoint", EsbElementTypes.DefaultEndPoint_3643); //$NON-NLS-1$
		case DefaultEndPointInputConnector2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?DefaultEndPointInputConnector", EsbElementTypes.DefaultEndPointInputConnector_3644); //$NON-NLS-1$
		case DefaultEndPointOutputConnector2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?DefaultEndPointOutputConnector", EsbElementTypes.DefaultEndPointOutputConnector_3645); //$NON-NLS-1$
		case AddressEndPoint2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?AddressEndPoint", EsbElementTypes.AddressEndPoint_3646); //$NON-NLS-1$
		case AddressEndPointInputConnector2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?AddressEndPointInputConnector", EsbElementTypes.AddressEndPointInputConnector_3647); //$NON-NLS-1$
		case AddressEndPointOutputConnector2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?AddressEndPointOutputConnector", EsbElementTypes.AddressEndPointOutputConnector_3648); //$NON-NLS-1$
		case FailoverEndPoint2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?FailoverEndPoint", EsbElementTypes.FailoverEndPoint_3649); //$NON-NLS-1$
		case FailoverEndPointInputConnector2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?FailoverEndPointInputConnector", EsbElementTypes.FailoverEndPointInputConnector_3650); //$NON-NLS-1$
		case FailoverEndPointOutputConnector2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?FailoverEndPointOutputConnector", EsbElementTypes.FailoverEndPointOutputConnector_3651); //$NON-NLS-1$
		case FailoverEndPointWestOutputConnector2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?FailoverEndPointWestOutputConnector", EsbElementTypes.FailoverEndPointWestOutputConnector_3652); //$NON-NLS-1$
		case WSDLEndPoint2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?WSDLEndPoint", EsbElementTypes.WSDLEndPoint_3653); //$NON-NLS-1$
		case WSDLEndPointInputConnector2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?WSDLEndPointInputConnector", EsbElementTypes.WSDLEndPointInputConnector_3654); //$NON-NLS-1$
		case WSDLEndPointOutputConnector2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?WSDLEndPointOutputConnector", EsbElementTypes.WSDLEndPointOutputConnector_3655); //$NON-NLS-1$
		case LoadBalanceEndPoint2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?LoadBalanceEndPoint", EsbElementTypes.LoadBalanceEndPoint_3656); //$NON-NLS-1$
		case LoadBalanceEndPointInputConnector2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?LoadBalanceEndPointInputConnector", EsbElementTypes.LoadBalanceEndPointInputConnector_3657); //$NON-NLS-1$
		case LoadBalanceEndPointOutputConnector2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?LoadBalanceEndPointOutputConnector", EsbElementTypes.LoadBalanceEndPointOutputConnector_3658); //$NON-NLS-1$
		case LoadBalanceEndPointWestOutputConnector2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?LoadBalanceEndPointWestOutputConnector", EsbElementTypes.LoadBalanceEndPointWestOutputConnector_3659); //$NON-NLS-1$
		case NamedEndpointEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?NamedEndpoint", EsbElementTypes.NamedEndpoint_3660); //$NON-NLS-1$
		case NamedEndpointInputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?NamedEndpointInputConnector", EsbElementTypes.NamedEndpointInputConnector_3661); //$NON-NLS-1$
		case NamedEndpointOutputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?NamedEndpointOutputConnector", EsbElementTypes.NamedEndpointOutputConnector_3662); //$NON-NLS-1$
		case LocalEntryEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?LocalEntry", EsbElementTypes.LocalEntry_3663); //$NON-NLS-1$
		case TemplateEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?Template", EsbElementTypes.Template_3664); //$NON-NLS-1$
		case Sequences2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?Sequences", EsbElementTypes.Sequences_3665); //$NON-NLS-1$
		case EndpointDiagram2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?EndpointDiagram", EsbElementTypes.EndpointDiagram_3666); //$NON-NLS-1$
		case TaskEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?Task", EsbElementTypes.Task_3667); //$NON-NLS-1$
		case SynapseAPIEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?SynapseAPI", EsbElementTypes.SynapseAPI_3668); //$NON-NLS-1$
		case APIResourceEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?APIResource", EsbElementTypes.APIResource_3669); //$NON-NLS-1$
		case APIResourceInputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?APIResourceInputConnector", EsbElementTypes.APIResourceInputConnector_3670); //$NON-NLS-1$
		case APIResourceOutputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?APIResourceOutputConnector", EsbElementTypes.APIResourceOutputConnector_3671); //$NON-NLS-1$
		case APIResourceFaultInputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?APIResourceFaultInputConnector", EsbElementTypes.APIResourceFaultInputConnector_3672); //$NON-NLS-1$
		case ProxyServiceContainer2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?ProxyServiceContainer", EsbElementTypes.ProxyServiceContainer_3673); //$NON-NLS-1$
		case APIResourceEndpointEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?APIResourceEndpoint", EsbElementTypes.APIResourceEndpoint_3674); //$NON-NLS-1$
		case APIResourceEndpointInputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?APIResourceEndpointInputConnector", EsbElementTypes.APIResourceEndpointInputConnector_3675); //$NON-NLS-1$
		case APIResourceEndpointOutputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?APIResourceEndpointOutputConnector", EsbElementTypes.APIResourceEndpointOutputConnector_3676); //$NON-NLS-1$
		case ComplexEndpointsEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?ComplexEndpoints", EsbElementTypes.ComplexEndpoints_3677); //$NON-NLS-1$
		case MediatorFlow18EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?MediatorFlow", EsbElementTypes.MediatorFlow_3678); //$NON-NLS-1$
		case ComplexEndpointsOutputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?ComplexEndpointsOutputConnector", EsbElementTypes.ComplexEndpointsOutputConnector_3679); //$NON-NLS-1$
		case BAMMediatorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?BAMMediator", EsbElementTypes.BAMMediator_3680); //$NON-NLS-1$
		case BAMMediatorInputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?BAMMediatorInputConnector", EsbElementTypes.BAMMediatorInputConnector_3681); //$NON-NLS-1$
		case BAMMediatorOutputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?BAMMediatorOutputConnector", EsbElementTypes.BAMMediatorOutputConnector_3682); //$NON-NLS-1$
		case BeanMediatorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?BeanMediator", EsbElementTypes.BeanMediator_3683); //$NON-NLS-1$
		case BeanMediatorInputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?BeanMediatorInputConnector", EsbElementTypes.BeanMediatorInputConnector_3684); //$NON-NLS-1$
		case BeanMediatorOutputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?BeanMediatorOutputConnector", EsbElementTypes.BeanMediatorOutputConnector_3685); //$NON-NLS-1$
		case EJBMediatorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?EJBMediator", EsbElementTypes.EJBMediator_3686); //$NON-NLS-1$
		case EJBMediatorInputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?EJBMediatorInputConnector", EsbElementTypes.EJBMediatorInputConnector_3687); //$NON-NLS-1$
		case EJBMediatorOutputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?EJBMediatorOutputConnector", EsbElementTypes.EJBMediatorOutputConnector_3688); //$NON-NLS-1$
		case AddressingEndpointEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?AddressingEndpoint", EsbElementTypes.AddressingEndpoint_3689); //$NON-NLS-1$
		case AddressingEndpointInputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?AddressingEndpointInputConnector", EsbElementTypes.AddressingEndpointInputConnector_3690); //$NON-NLS-1$
		case AddressingEndpointOutputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?AddressingEndpointOutputConnector", EsbElementTypes.AddressingEndpointOutputConnector_3691); //$NON-NLS-1$
		case RecipientListEndPointEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?RecipientListEndPoint", EsbElementTypes.RecipientListEndPoint_3692); //$NON-NLS-1$
		case RecipientListEndPointInputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?RecipientListEndPointInputConnector", EsbElementTypes.RecipientListEndPointInputConnector_3693); //$NON-NLS-1$
		case RecipientListEndPointOutputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?RecipientListEndPointOutputConnector", EsbElementTypes.RecipientListEndPointOutputConnector_3694); //$NON-NLS-1$
		case RecipientListEndPointWestOutputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?RecipientListEndPointWestOutputConnector", EsbElementTypes.RecipientListEndPointWestOutputConnector_3695); //$NON-NLS-1$
		case RecipientListEndPoint2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?RecipientListEndPoint", EsbElementTypes.RecipientListEndPoint_3696); //$NON-NLS-1$
		case RecipientListEndPointInputConnector2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?RecipientListEndPointInputConnector", EsbElementTypes.RecipientListEndPointInputConnector_3697); //$NON-NLS-1$
		case RecipientListEndPointOutputConnector2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?RecipientListEndPointOutputConnector", EsbElementTypes.RecipientListEndPointOutputConnector_3698); //$NON-NLS-1$
		case RecipientListEndPointWestOutputConnector2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?RecipientListEndPointWestOutputConnector", EsbElementTypes.RecipientListEndPointWestOutputConnector_3699); //$NON-NLS-1$
		case MessageProcessorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?MessageProcessor", EsbElementTypes.MessageProcessor_3701); //$NON-NLS-1$
		case HTTPEndpointEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?HTTPEndpoint", EsbElementTypes.HTTPEndpoint_3709); //$NON-NLS-1$
		case HTTPEndPointInputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?HTTPEndPointInputConnector", EsbElementTypes.HTTPEndPointInputConnector_3710); //$NON-NLS-1$
		case HTTPEndPointOutputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?HTTPEndPointOutputConnector", EsbElementTypes.HTTPEndPointOutputConnector_3711); //$NON-NLS-1$
		case HTTPEndpoint2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?HTTPEndpoint", EsbElementTypes.HTTPEndpoint_3712); //$NON-NLS-1$
		case HTTPEndPointInputConnector2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?HTTPEndPointInputConnector", EsbElementTypes.HTTPEndPointInputConnector_3713); //$NON-NLS-1$
		case HTTPEndPointOutputConnector2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?HTTPEndPointOutputConnector", EsbElementTypes.HTTPEndPointOutputConnector_3714); //$NON-NLS-1$
		case MessageStoreEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?MessageStore", EsbElementTypes.MessageStore_3715); //$NON-NLS-1$
		case TemplateEndpointEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?TemplateEndpoint", EsbElementTypes.TemplateEndpoint_3716); //$NON-NLS-1$
		case TemplateEndpointInputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?TemplateEndpointInputConnector", EsbElementTypes.TemplateEndpointInputConnector_3717); //$NON-NLS-1$
		case TemplateEndpointOutputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?TemplateEndpointOutputConnector", EsbElementTypes.TemplateEndpointOutputConnector_3718); //$NON-NLS-1$
		case CloudConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?CloudConnector", EsbElementTypes.CloudConnector_3719); //$NON-NLS-1$
		case CloudConnectorInputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?CloudConnectorInputConnector", EsbElementTypes.CloudConnectorInputConnector_3720); //$NON-NLS-1$
		case CloudConnectorOutputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?CloudConnectorOutputConnector", EsbElementTypes.CloudConnectorOutputConnector_3721); //$NON-NLS-1$
		case CloudConnectorOperationEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?CloudConnectorOperation", EsbElementTypes.CloudConnectorOperation_3722); //$NON-NLS-1$
		case CloudConnectorOperationInputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?CloudConnectorOperationInputConnector", EsbElementTypes.CloudConnectorOperationInputConnector_3723); //$NON-NLS-1$
		case CloudConnectorOperationOutputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?CloudConnectorOperationOutputConnector", EsbElementTypes.CloudConnectorOperationOutputConnector_3724); //$NON-NLS-1$
		case TemplateEndpoint2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?TemplateEndpoint", EsbElementTypes.TemplateEndpoint_3725); //$NON-NLS-1$
		case TemplateEndpointInputConnector2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?TemplateEndpointInputConnector", EsbElementTypes.TemplateEndpointInputConnector_3726); //$NON-NLS-1$
		case TemplateEndpointOutputConnector2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?TemplateEndpointOutputConnector", EsbElementTypes.TemplateEndpointOutputConnector_3727); //$NON-NLS-1$
		case MediatorFlow19EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?MediatorFlow", EsbElementTypes.MediatorFlow_3728); //$NON-NLS-1$
		case ProxyOutSequenceOutputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?ProxyOutSequenceOutputConnector", EsbElementTypes.ProxyOutSequenceOutputConnector_3729); //$NON-NLS-1$
		case APIResourceOutSequenceOutputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?APIResourceOutSequenceOutputConnector", EsbElementTypes.APIResourceOutSequenceOutputConnector_3730); //$NON-NLS-1$
		case ProxyInSequenceInputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?ProxyInSequenceInputConnector", EsbElementTypes.ProxyInSequenceInputConnector_3731); //$NON-NLS-1$
		case SwitchCaseParentContainerEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?SwitchCaseParentContainer", EsbElementTypes.SwitchCaseParentContainer_3732); //$NON-NLS-1$
		case SwitchCaseContainerEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?SwitchCaseContainer", EsbElementTypes.SwitchCaseContainer_3733); //$NON-NLS-1$
		case SwitchDefaultParentContainerEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?SwitchDefaultParentContainer", EsbElementTypes.SwitchDefaultParentContainer_3734); //$NON-NLS-1$
		case SwitchDefaultContainerEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?SwitchDefaultContainer", EsbElementTypes.SwitchDefaultContainer_3735); //$NON-NLS-1$
		case LoopBackMediatorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?LoopBackMediator", EsbElementTypes.LoopBackMediator_3736); //$NON-NLS-1$
		case LoopBackMediatorInputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?LoopBackMediatorInputConnector", EsbElementTypes.LoopBackMediatorInputConnector_3737); //$NON-NLS-1$
		case LoopBackMediatorOutputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?LoopBackMediatorOutputConnector", EsbElementTypes.LoopBackMediatorOutputConnector_3738); //$NON-NLS-1$
		case RespondMediatorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?RespondMediator", EsbElementTypes.RespondMediator_3739); //$NON-NLS-1$
		case RespondMediatorInputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?RespondMediatorInputConnector", EsbElementTypes.RespondMediatorInputConnector_3740); //$NON-NLS-1$
		case RespondMediatorOutputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?RespondMediatorOutputConnector", EsbElementTypes.RespondMediatorOutputConnector_3741); //$NON-NLS-1$
		case CallMediatorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?CallMediator", EsbElementTypes.CallMediator_3742); //$NON-NLS-1$
		case CallMediatorInputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?CallMediatorInputConnector", EsbElementTypes.CallMediatorInputConnector_3743); //$NON-NLS-1$
		case CallMediatorOutputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?CallMediatorOutputConnector", EsbElementTypes.CallMediatorOutputConnector_3744); //$NON-NLS-1$
		case CallMediatorEndpointOutputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?CallMediatorEndpointOutputConnector", EsbElementTypes.CallMediatorEndpointOutputConnector_3745); //$NON-NLS-1$
		case MediatorFlow20EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?MediatorFlow", EsbElementTypes.MediatorFlow_3746); //$NON-NLS-1$
		case APIResourceInSequenceInputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?APIResourceInSequenceInputConnector", EsbElementTypes.APIResourceInSequenceInputConnector_3747); //$NON-NLS-1$
		case EntitlementMediatorOnRejectOutputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?EntitlementMediatorOnRejectOutputConnector", EsbElementTypes.EntitlementMediatorOnRejectOutputConnector_3748); //$NON-NLS-1$
		case EntitlementMediatorOnAcceptOutputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?EntitlementMediatorOnAcceptOutputConnector", EsbElementTypes.EntitlementMediatorOnAcceptOutputConnector_3749); //$NON-NLS-1$
		case EntitlementMediatorAdviceOutputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?EntitlementMediatorAdviceOutputConnector", EsbElementTypes.EntitlementMediatorAdviceOutputConnector_3750); //$NON-NLS-1$
		case EntitlementMediatorObligationsOutputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?EntitlementMediatorObligationsOutputConnector", EsbElementTypes.EntitlementMediatorObligationsOutputConnector_3751); //$NON-NLS-1$
		case EntitlementContainerEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?EntitlementContainer", EsbElementTypes.EntitlementContainer_3752); //$NON-NLS-1$
		case EntitlementOnRejectContainerEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?EntitlementOnRejectContainer", EsbElementTypes.EntitlementOnRejectContainer_3753); //$NON-NLS-1$
		case MediatorFlow21EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?MediatorFlow", EsbElementTypes.MediatorFlow_3754); //$NON-NLS-1$
		case EntitlementOnAcceptContainerEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?EntitlementOnAcceptContainer", EsbElementTypes.EntitlementOnAcceptContainer_3755); //$NON-NLS-1$
		case MediatorFlow22EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?MediatorFlow", EsbElementTypes.MediatorFlow_3756); //$NON-NLS-1$
		case EntitlementAdviceContainerEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?EntitlementAdviceContainer", EsbElementTypes.EntitlementAdviceContainer_3757); //$NON-NLS-1$
		case MediatorFlow23EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?MediatorFlow", EsbElementTypes.MediatorFlow_3758); //$NON-NLS-1$
		case EntitlementObligationsContainerEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?EntitlementObligationsContainer", EsbElementTypes.EntitlementObligationsContainer_3759); //$NON-NLS-1$
		case MediatorFlow24EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?MediatorFlow", EsbElementTypes.MediatorFlow_3760); //$NON-NLS-1$
		case DataMapperMediatorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?DataMapperMediator", EsbElementTypes.DataMapperMediator_3761); //$NON-NLS-1$
		case DataMapperMediatorInputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?DataMapperMediatorInputConnector", EsbElementTypes.DataMapperMediatorInputConnector_3762); //$NON-NLS-1$
		case DataMapperMediatorOutputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?DataMapperMediatorOutputConnector", EsbElementTypes.DataMapperMediatorOutputConnector_3763); //$NON-NLS-1$
		case FastXSLTMediatorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?FastXSLTMediator", EsbElementTypes.FastXSLTMediator_3764); //$NON-NLS-1$
		case FastXSLTMediatorInputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?FastXSLTMediatorInputConnector", EsbElementTypes.FastXSLTMediatorInputConnector_3765); //$NON-NLS-1$
		case FastXSLTMediatorOutputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?FastXSLTMediatorOutputConnector", EsbElementTypes.FastXSLTMediatorOutputConnector_3766); //$NON-NLS-1$
		case InboundEndpointEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?InboundEndpoint", EsbElementTypes.InboundEndpoint_3767); //$NON-NLS-1$
		case InboundEndpointSequenceInputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?InboundEndpointSequenceInputConnector", EsbElementTypes.InboundEndpointSequenceInputConnector_3768); //$NON-NLS-1$
		case InboundEndpointSequenceOutputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?InboundEndpointSequenceOutputConnector", EsbElementTypes.InboundEndpointSequenceOutputConnector_3769); //$NON-NLS-1$
		case InboundEndpointOnErrorSequenceInputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?InboundEndpointOnErrorSequenceInputConnector", EsbElementTypes.InboundEndpointOnErrorSequenceInputConnector_3770); //$NON-NLS-1$
		case InboundEndpointOnErrorSequenceOutputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?InboundEndpointOnErrorSequenceOutputConnector", EsbElementTypes.InboundEndpointOnErrorSequenceOutputConnector_3771); //$NON-NLS-1$
		case InboundEndpointContainerEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?InboundEndpointContainer", EsbElementTypes.InboundEndpointContainer_3772); //$NON-NLS-1$
		case InboundEndpointSequenceContainerEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?InboundEndpointSequenceContainer", EsbElementTypes.InboundEndpointSequenceContainer_3773); //$NON-NLS-1$
		case MediatorFlow25EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?MediatorFlow", EsbElementTypes.MediatorFlow_3774); //$NON-NLS-1$
		case InboundEndpointOnErrorSequenceContainerEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?InboundEndpointOnErrorSequenceContainer", EsbElementTypes.InboundEndpointOnErrorSequenceContainer_3775); //$NON-NLS-1$
		case MediatorFlow26EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?MediatorFlow", EsbElementTypes.MediatorFlow_3776); //$NON-NLS-1$
		case MediatorFlow27EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?MediatorFlow", EsbElementTypes.MediatorFlow_3777); //$NON-NLS-1$
		case MediatorFlow28EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?MediatorFlow", EsbElementTypes.MediatorFlow_3778); //$NON-NLS-1$
		case MediatorFlow29EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?MediatorFlow", EsbElementTypes.MediatorFlow_3779); //$NON-NLS-1$
		case ForEachMediatorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?ForEachMediator", EsbElementTypes.ForEachMediator_3780); //$NON-NLS-1$
		case ForEachMediatorInputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?ForEachMediatorInputConnector", EsbElementTypes.ForEachMediatorInputConnector_3781); //$NON-NLS-1$
		case ForEachMediatorOutputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?ForEachMediatorOutputConnector", EsbElementTypes.ForEachMediatorOutputConnector_3782); //$NON-NLS-1$
		case ForEachMediatorTargetOutputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?ForEachMediatorTargetOutputConnector", EsbElementTypes.ForEachMediatorTargetOutputConnector_3783); //$NON-NLS-1$
		case MediatorFlow30EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?MediatorFlow", EsbElementTypes.MediatorFlow_3784); //$NON-NLS-1$
		case PublishEventMediatorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?PublishEventMediator", EsbElementTypes.PublishEventMediator_3785); //$NON-NLS-1$
		case PublishEventMediatorInputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?PublishEventMediatorInputConnector", EsbElementTypes.PublishEventMediatorInputConnector_3786); //$NON-NLS-1$
		case PublishEventMediatorOutputConnectorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?PublishEventMediatorOutputConnector", EsbElementTypes.PublishEventMediatorOutputConnector_3787); //$NON-NLS-1$
		case EsbLinkEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http:///org/wso2/developerstudio/eclipse/gmf/esb?EsbLink", EsbElementTypes.EsbLink_4001); //$NON-NLS-1$
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = EsbDiagramEditorPlugin.getInstance().getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null && elementType != null && EsbElementTypes.isKnownElementType(elementType)) {
			image = EsbElementTypes.getImage(elementType);
			imageRegistry.put(key, image);
		}

		if (image == null) {
			image = imageRegistry.get("Navigator?ImageNotFound"); //$NON-NLS-1$
			imageRegistry.put(key, image);
		}
		return image;
	}

	/**
	 * @generated
	 */
	public String getText(Object element) {
		if (element instanceof EsbNavigatorGroup) {
			EsbNavigatorGroup group = (EsbNavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof EsbNavigatorItem) {
			EsbNavigatorItem navigatorItem = (EsbNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return null;
			}
			return getText(navigatorItem.getView());
		}

		return super.getText(element);
	}

	/**
	 * @generated
	 */
	public String getText(View view) {
		if (view.getElement() != null && view.getElement().eIsProxy()) {
			return getUnresolvedDomainElementProxyText(view);
		}
		switch (EsbVisualIDRegistry.getVisualID(view)) {
		case EsbDiagramEditPart.VISUAL_ID:
			return getEsbDiagram_1000Text(view);
		case EsbServerEditPart.VISUAL_ID:
			return getEsbServer_2001Text(view);
		case ProxyServiceEditPart.VISUAL_ID:
			return getProxyService_3001Text(view);
		case ProxyOutputConnectorEditPart.VISUAL_ID:
			return getProxyOutputConnector_3002Text(view);
		case ProxyInputConnectorEditPart.VISUAL_ID:
			return getProxyInputConnector_3003Text(view);
		case DropMediatorInputConnectorEditPart.VISUAL_ID:
			return getDropMediatorInputConnector_3008Text(view);
		case FilterMediatorInputConnectorEditPart.VISUAL_ID:
			return getFilterMediatorInputConnector_3010Text(view);
		case FilterMediatorPassOutputConnectorEditPart.VISUAL_ID:
			return getFilterMediatorPassOutputConnector_3011Text(view);
		case FilterMediatorFailOutputConnectorEditPart.VISUAL_ID:
			return getFilterMediatorFailOutputConnector_3012Text(view);
		case MergeNodeEditPart.VISUAL_ID:
			return getMergeNode_3013Text(view);
		case MergeNodeFirstInputConnectorEditPart.VISUAL_ID:
			return getMergeNodeFirstInputConnector_3014Text(view);
		case MergeNodeSecondInputConnectorEditPart.VISUAL_ID:
			return getMergeNodeSecondInputConnector_3015Text(view);
		case MergeNodeOutputConnectorEditPart.VISUAL_ID:
			return getMergeNodeOutputConnector_3016Text(view);
		case LogMediatorInputConnectorEditPart.VISUAL_ID:
			return getLogMediatorInputConnector_3018Text(view);
		case LogMediatorOutputConnectorEditPart.VISUAL_ID:
			return getLogMediatorOutputConnector_3019Text(view);
		case DefaultEndPointInputConnectorEditPart.VISUAL_ID:
			return getDefaultEndPointInputConnector_3021Text(view);
		case DefaultEndPointOutputConnectorEditPart.VISUAL_ID:
			return getDefaultEndPointOutputConnector_3022Text(view);
		case AddressEndPointInputConnectorEditPart.VISUAL_ID:
			return getAddressEndPointInputConnector_3030Text(view);
		case AddressEndPointOutputConnectorEditPart.VISUAL_ID:
			return getAddressEndPointOutputConnector_3031Text(view);
		case PropertyMediatorInputConnectorEditPart.VISUAL_ID:
			return getPropertyMediatorInputConnector_3033Text(view);
		case PropertyMediatorOutputConnectorEditPart.VISUAL_ID:
			return getPropertyMediatorOutputConnector_3034Text(view);
		case EnrichMediatorInputConnectorEditPart.VISUAL_ID:
			return getEnrichMediatorInputConnector_3036Text(view);
		case EnrichMediatorOutputConnectorEditPart.VISUAL_ID:
			return getEnrichMediatorOutputConnector_3037Text(view);
		case XSLTMediatorInputConnectorEditPart.VISUAL_ID:
			return getXSLTMediatorInputConnector_3039Text(view);
		case XSLTMediatorOutputConnectorEditPart.VISUAL_ID:
			return getXSLTMediatorOutputConnector_3040Text(view);
		case SwitchMediatorInputConnectorEditPart.VISUAL_ID:
			return getSwitchMediatorInputConnector_3042Text(view);
		case SwitchCaseBranchOutputConnectorEditPart.VISUAL_ID:
			return getSwitchCaseBranchOutputConnector_3043Text(view);
		case SwitchDefaultBranchOutputConnectorEditPart.VISUAL_ID:
			return getSwitchDefaultBranchOutputConnector_3044Text(view);
		case MessageMediatorEditPart.VISUAL_ID:
			return getMessageMediator_3045Text(view);
		case MessageInputConnectorEditPart.VISUAL_ID:
			return getMessageInputConnector_3046Text(view);
		case MessageOutputConnectorEditPart.VISUAL_ID:
			return getMessageOutputConnector_3047Text(view);
		case SequenceInputConnectorEditPart.VISUAL_ID:
			return getSequenceInputConnector_3049Text(view);
		case SequenceOutputConnectorEditPart.VISUAL_ID:
			return getSequenceOutputConnector_3050Text(view);
		case EventMediatorInputConnectorEditPart.VISUAL_ID:
			return getEventMediatorInputConnector_3052Text(view);
		case EventMediatorOutputConnectorEditPart.VISUAL_ID:
			return getEventMediatorOutputConnector_3053Text(view);
		case EntitlementMediatorInputConnectorEditPart.VISUAL_ID:
			return getEntitlementMediatorInputConnector_3055Text(view);
		case EntitlementMediatorOutputConnectorEditPart.VISUAL_ID:
			return getEntitlementMediatorOutputConnector_3056Text(view);
		case ClassMediatorInputConnectorEditPart.VISUAL_ID:
			return getClassMediatorInputConnector_3058Text(view);
		case ClassMediatorOutputConnectorEditPart.VISUAL_ID:
			return getClassMediatorOutputConnector_3059Text(view);
		case SpringMediatorInputConnectorEditPart.VISUAL_ID:
			return getSpringMediatorInputConnector_3061Text(view);
		case SpringMediatorOutputConnectorEditPart.VISUAL_ID:
			return getSpringMediatorOutputConnector_3062Text(view);
		case ScriptMediatorInputConnectorEditPart.VISUAL_ID:
			return getScriptMediatorInputConnector_3064Text(view);
		case ScriptMediatorOutputConnectorEditPart.VISUAL_ID:
			return getScriptMediatorOutputConnector_3065Text(view);
		case FaultMediatorInputConnectorEditPart.VISUAL_ID:
			return getFaultMediatorInputConnector_3067Text(view);
		case FaultMediatorOutputConnectorEditPart.VISUAL_ID:
			return getFaultMediatorOutputConnector_3068Text(view);
		case XQueryMediatorInputConnectorEditPart.VISUAL_ID:
			return getXQueryMediatorInputConnector_3070Text(view);
		case XQueryMediatorOutputConnectorEditPart.VISUAL_ID:
			return getXQueryMediatorOutputConnector_3071Text(view);
		case CommandMediatorInputConnectorEditPart.VISUAL_ID:
			return getCommandMediatorInputConnector_3073Text(view);
		case CommandMediatorOutputConnectorEditPart.VISUAL_ID:
			return getCommandMediatorOutputConnector_3074Text(view);
		case DBLookupMediatorInputConnectorEditPart.VISUAL_ID:
			return getDBLookupMediatorInputConnector_3076Text(view);
		case DBLookupMediatorOutputConnectorEditPart.VISUAL_ID:
			return getDBLookupMediatorOutputConnector_3077Text(view);
		case DBReportMediatorInputConnectorEditPart.VISUAL_ID:
			return getDBReportMediatorInputConnector_3079Text(view);
		case DBReportMediatorOutputConnectorEditPart.VISUAL_ID:
			return getDBReportMediatorOutputConnector_3080Text(view);
		case SmooksMediatorInputConnectorEditPart.VISUAL_ID:
			return getSmooksMediatorInputConnector_3082Text(view);
		case SmooksMediatorOutputConnectorEditPart.VISUAL_ID:
			return getSmooksMediatorOutputConnector_3083Text(view);
		case SendMediatorInputConnectorEditPart.VISUAL_ID:
			return getSendMediatorInputConnector_3085Text(view);
		case SendMediatorOutputConnectorEditPart.VISUAL_ID:
			return getSendMediatorOutputConnector_3086Text(view);
		case FailoverEndPointInputConnectorEditPart.VISUAL_ID:
			return getFailoverEndPointInputConnector_3088Text(view);
		case FailoverEndPointOutputConnectorEditPart.VISUAL_ID:
			return getFailoverEndPointOutputConnector_3090Text(view);
		case WSDLEndPointInputConnectorEditPart.VISUAL_ID:
			return getWSDLEndPointInputConnector_3092Text(view);
		case WSDLEndPointOutputConnectorEditPart.VISUAL_ID:
			return getWSDLEndPointOutputConnector_3093Text(view);
		case LoadBalanceEndPointInputConnectorEditPart.VISUAL_ID:
			return getLoadBalanceEndPointInputConnector_3095Text(view);
		case LoadBalanceEndPointOutputConnectorEditPart.VISUAL_ID:
			return getLoadBalanceEndPointOutputConnector_3096Text(view);
		case FailoverEndPointWestOutputConnectorEditPart.VISUAL_ID:
			return getFailoverEndPointWestOutputConnector_3097Text(view);
		case LoadBalanceEndPointWestOutputConnectorEditPart.VISUAL_ID:
			return getLoadBalanceEndPointWestOutputConnector_3098Text(view);
		case HeaderMediatorInputConnectorEditPart.VISUAL_ID:
			return getHeaderMediatorInputConnector_3100Text(view);
		case HeaderMediatorOutputConnectorEditPart.VISUAL_ID:
			return getHeaderMediatorOutputConnector_3101Text(view);
		case CloneMediatorInputConnectorEditPart.VISUAL_ID:
			return getCloneMediatorInputConnector_3103Text(view);
		case CloneMediatorOutputConnectorEditPart.VISUAL_ID:
			return getCloneMediatorOutputConnector_3104Text(view);
		case CacheMediatorInputConnectorEditPart.VISUAL_ID:
			return getCacheMediatorInputConnector_3106Text(view);
		case CacheMediatorOutputConnectorEditPart.VISUAL_ID:
			return getCacheMediatorOutputConnector_3107Text(view);
		case IterateMediatorInputConnectorEditPart.VISUAL_ID:
			return getIterateMediatorInputConnector_3109Text(view);
		case IterateMediatorOutputConnectorEditPart.VISUAL_ID:
			return getIterateMediatorOutputConnector_3110Text(view);
		case AggregateMediatorInputConnectorEditPart.VISUAL_ID:
			return getAggregateMediatorInputConnector_3112Text(view);
		case AggregateMediatorOutputConnectorEditPart.VISUAL_ID:
			return getAggregateMediatorOutputConnector_3113Text(view);
		case CalloutMediatorInputConnectorEditPart.VISUAL_ID:
			return getCalloutMediatorInputConnector_3115Text(view);
		case CalloutMediatorOutputConnectorEditPart.VISUAL_ID:
			return getCalloutMediatorOutputConnector_3116Text(view);
		case TransactionMediatorInputConnectorEditPart.VISUAL_ID:
			return getTransactionMediatorInputConnector_3118Text(view);
		case TransactionMediatorOutputConnectorEditPart.VISUAL_ID:
			return getTransactionMediatorOutputConnector_3119Text(view);
		case ThrottleMediatorInputConnectorEditPart.VISUAL_ID:
			return getThrottleMediatorInputConnector_3121Text(view);
		case ThrottleMediatorOutputConnectorEditPart.VISUAL_ID:
			return getThrottleMediatorOutputConnector_3122Text(view);
		case RMSequenceMediatorInputConnectorEditPart.VISUAL_ID:
			return getRMSequenceMediatorInputConnector_3124Text(view);
		case RMSequenceMediatorOutputConnectorEditPart.VISUAL_ID:
			return getRMSequenceMediatorOutputConnector_3125Text(view);
		case RuleMediatorInputConnectorEditPart.VISUAL_ID:
			return getRuleMediatorInputConnector_3127Text(view);
		case RuleMediatorOutputConnectorEditPart.VISUAL_ID:
			return getRuleMediatorOutputConnector_3128Text(view);
		case OAuthMediatorInputConnectorEditPart.VISUAL_ID:
			return getOAuthMediatorInputConnector_3130Text(view);
		case OAuthMediatorOutputConnectorEditPart.VISUAL_ID:
			return getOAuthMediatorOutputConnector_3131Text(view);
		case AggregateMediatorOnCompleteOutputConnectorEditPart.VISUAL_ID:
			return getAggregateMediatorOnCompleteOutputConnector_3132Text(view);
		case CloneMediatorTargetOutputConnectorEditPart.VISUAL_ID:
			return getCloneMediatorTargetOutputConnector_3133Text(view);
		case ProxyServiceContainerEditPart.VISUAL_ID:
			return getProxyServiceContainer_3486Text(view);
		case ProxyServiceSequenceAndEndpointContainerEditPart.VISUAL_ID:
			return getProxyServiceSequenceAndEndpointContainer_3487Text(view);
		case ProxyServiceFaultContainerEditPart.VISUAL_ID:
			return getProxyServiceFaultContainer_3488Text(view);
		case ProxyFaultInputConnectorEditPart.VISUAL_ID:
			return getProxyFaultInputConnector_3489Text(view);
		case DropMediatorEditPart.VISUAL_ID:
			return getDropMediator_3491Text(view);
		case PropertyMediatorEditPart.VISUAL_ID:
			return getPropertyMediator_3492Text(view);
		case ThrottleMediatorEditPart.VISUAL_ID:
			return getThrottleMediator_3493Text(view);
		case FilterMediatorEditPart.VISUAL_ID:
			return getFilterMediator_3494Text(view);
		case LogMediatorEditPart.VISUAL_ID:
			return getLogMediator_3495Text(view);
		case EnrichMediatorEditPart.VISUAL_ID:
			return getEnrichMediator_3496Text(view);
		case XSLTMediatorEditPart.VISUAL_ID:
			return getXSLTMediator_3497Text(view);
		case SwitchMediatorEditPart.VISUAL_ID:
			return getSwitchMediator_3498Text(view);
		case SwitchMediatorOutputConnectorEditPart.VISUAL_ID:
			return getSwitchMediatorOutputConnector_3499Text(view);
		case SwitchMediatorContainerEditPart.VISUAL_ID:
			return getSwitchMediatorContainer_3500Text(view);
		case MediatorFlow2EditPart.VISUAL_ID:
			return getMediatorFlow_3502Text(view);
		case SequenceEditPart.VISUAL_ID:
			return getSequence_3503Text(view);
		case EventMediatorEditPart.VISUAL_ID:
			return getEventMediator_3504Text(view);
		case EntitlementMediatorEditPart.VISUAL_ID:
			return getEntitlementMediator_3505Text(view);
		case ClassMediatorEditPart.VISUAL_ID:
			return getClassMediator_3506Text(view);
		case SpringMediatorEditPart.VISUAL_ID:
			return getSpringMediator_3507Text(view);
		case ScriptMediatorEditPart.VISUAL_ID:
			return getScriptMediator_3508Text(view);
		case FaultMediatorEditPart.VISUAL_ID:
			return getFaultMediator_3509Text(view);
		case XQueryMediatorEditPart.VISUAL_ID:
			return getXQueryMediator_3510Text(view);
		case CommandMediatorEditPart.VISUAL_ID:
			return getCommandMediator_3511Text(view);
		case DBLookupMediatorEditPart.VISUAL_ID:
			return getDBLookupMediator_3512Text(view);
		case DBReportMediatorEditPart.VISUAL_ID:
			return getDBReportMediator_3513Text(view);
		case SmooksMediatorEditPart.VISUAL_ID:
			return getSmooksMediator_3514Text(view);
		case SendMediatorEditPart.VISUAL_ID:
			return getSendMediator_3515Text(view);
		case HeaderMediatorEditPart.VISUAL_ID:
			return getHeaderMediator_3516Text(view);
		case CloneMediatorEditPart.VISUAL_ID:
			return getCloneMediator_3517Text(view);
		case CacheMediatorEditPart.VISUAL_ID:
			return getCacheMediator_3518Text(view);
		case IterateMediatorEditPart.VISUAL_ID:
			return getIterateMediator_3519Text(view);
		case CalloutMediatorEditPart.VISUAL_ID:
			return getCalloutMediator_3520Text(view);
		case TransactionMediatorEditPart.VISUAL_ID:
			return getTransactionMediator_3521Text(view);
		case RMSequenceMediatorEditPart.VISUAL_ID:
			return getRMSequenceMediator_3522Text(view);
		case RuleMediatorEditPart.VISUAL_ID:
			return getRuleMediator_3523Text(view);
		case OAuthMediatorEditPart.VISUAL_ID:
			return getOAuthMediator_3524Text(view);
		case AggregateMediatorEditPart.VISUAL_ID:
			return getAggregateMediator_3525Text(view);
		case MediatorFlow3EditPart.VISUAL_ID:
			return getMediatorFlow_3526Text(view);
		case MediatorFlow4EditPart.VISUAL_ID:
			return getMediatorFlow_3528Text(view);
		case MediatorFlow6EditPart.VISUAL_ID:
			return getMediatorFlow_3530Text(view);
		case FilterContainerEditPart.VISUAL_ID:
			return getFilterContainer_3531Text(view);
		case FilterMediatorOutputConnectorEditPart.VISUAL_ID:
			return getFilterMediatorOutputConnector_3534Text(view);
		case FilterPassContainerEditPart.VISUAL_ID:
			return getFilterPassContainer_3535Text(view);
		case MediatorFlow7EditPart.VISUAL_ID:
			return getMediatorFlow_3536Text(view);
		case FilterFailContainerEditPart.VISUAL_ID:
			return getFilterFailContainer_3537Text(view);
		case MediatorFlow8EditPart.VISUAL_ID:
			return getMediatorFlow_3538Text(view);
		case SendMediatorEndpointOutputConnectorEditPart.VISUAL_ID:
			return getSendMediatorEndpointOutputConnector_3539Text(view);
		case ThrottleMediatorOnAcceptOutputConnectorEditPart.VISUAL_ID:
			return getThrottleMediatorOnAcceptOutputConnector_3581Text(view);
		case ThrottleMediatorOnRejectOutputConnectorEditPart.VISUAL_ID:
			return getThrottleMediatorOnRejectOutputConnector_3582Text(view);
		case ThrottleContainerEditPart.VISUAL_ID:
			return getThrottleContainer_3583Text(view);
		case ThrottleOnAcceptContainerEditPart.VISUAL_ID:
			return getThrottleOnAcceptContainer_3584Text(view);
		case MediatorFlow9EditPart.VISUAL_ID:
			return getMediatorFlow_3585Text(view);
		case ThrottleOnRejectContainerEditPart.VISUAL_ID:
			return getThrottleOnRejectContainer_3586Text(view);
		case MediatorFlow10EditPart.VISUAL_ID:
			return getMediatorFlow_3587Text(view);
		case StoreMediatorEditPart.VISUAL_ID:
			return getStoreMediator_3588Text(view);
		case StoreMediatorInputConnectorEditPart.VISUAL_ID:
			return getStoreMediatorInputConnector_3589Text(view);
		case StoreMediatorOutputConnectorEditPart.VISUAL_ID:
			return getStoreMediatorOutputConnector_3590Text(view);
		case BuilderMediatorEditPart.VISUAL_ID:
			return getBuilderMediator_3591Text(view);
		case BuilderMediatorInputConnectorEditPart.VISUAL_ID:
			return getBuilderMediatorInputConnector_3592Text(view);
		case BuilderMediatorOutputConectorEditPart.VISUAL_ID:
			return getBuilderMediatorOutputConector_3593Text(view);
		case CallTemplateMediatorEditPart.VISUAL_ID:
			return getCallTemplateMediator_3594Text(view);
		case CallTemplateMediatorInputConnectorEditPart.VISUAL_ID:
			return getCallTemplateMediatorInputConnector_3595Text(view);
		case CallTemplateMediatorOutputConnectorEditPart.VISUAL_ID:
			return getCallTemplateMediatorOutputConnector_3596Text(view);
		case PayloadFactoryMediatorEditPart.VISUAL_ID:
			return getPayloadFactoryMediator_3597Text(view);
		case PayloadFactoryMediatorInputConnectorEditPart.VISUAL_ID:
			return getPayloadFactoryMediatorInputConnector_3598Text(view);
		case PayloadFactoryMediatorOutputConnectorEditPart.VISUAL_ID:
			return getPayloadFactoryMediatorOutputConnector_3599Text(view);
		case EnqueueMediatorEditPart.VISUAL_ID:
			return getEnqueueMediator_3600Text(view);
		case EnqueueMediatorInputConnectorEditPart.VISUAL_ID:
			return getEnqueueMediatorInputConnector_3601Text(view);
		case EnqueueMediatorOutputConnectorEditPart.VISUAL_ID:
			return getEnqueueMediatorOutputConnector_3602Text(view);
		case CloneMediatorContainerEditPart.VISUAL_ID:
			return getCloneMediatorContainer_3603Text(view);
		case CloneTargetContainerEditPart.VISUAL_ID:
			return getCloneTargetContainer_3604Text(view);
		case MediatorFlow11EditPart.VISUAL_ID:
			return getMediatorFlow_3605Text(view);
		case IterateMediatorTargetOutputConnectorEditPart.VISUAL_ID:
			return getIterateMediatorTargetOutputConnector_3606Text(view);
		case MediatorFlow12EditPart.VISUAL_ID:
			return getMediatorFlow_3607Text(view);
		case MediatorFlowEditPart.VISUAL_ID:
			return getMediatorFlow_3608Text(view);
		case DefaultEndPointEditPart.VISUAL_ID:
			return getDefaultEndPoint_3609Text(view);
		case AddressEndPointEditPart.VISUAL_ID:
			return getAddressEndPoint_3610Text(view);
		case FailoverEndPointEditPart.VISUAL_ID:
			return getFailoverEndPoint_3611Text(view);
		case WSDLEndPointEditPart.VISUAL_ID:
			return getWSDLEndPoint_3612Text(view);
		case LoadBalanceEndPointEditPart.VISUAL_ID:
			return getLoadBalanceEndPoint_3613Text(view);
		case SequencesEditPart.VISUAL_ID:
			return getSequences_3614Text(view);
		case MediatorFlow5EditPart.VISUAL_ID:
			return getMediatorFlow_3615Text(view);
		case SequencesInputConnectorEditPart.VISUAL_ID:
			return getSequencesInputConnector_3616Text(view);
		case SequencesOutputConnectorEditPart.VISUAL_ID:
			return getSequencesOutputConnector_3617Text(view);
		case CacheMediatorOnHitOutputConnectorEditPart.VISUAL_ID:
			return getCacheMediatorOnHitOutputConnector_3618Text(view);
		case MediatorFlow13EditPart.VISUAL_ID:
			return getMediatorFlow_3619Text(view);
		case URLRewriteMediatorEditPart.VISUAL_ID:
			return getURLRewriteMediator_3620Text(view);
		case URLRewriteMediatorInputConnectorEditPart.VISUAL_ID:
			return getURLRewriteMediatorInputConnector_3621Text(view);
		case URLRewriteMediatorOutputConnectorEditPart.VISUAL_ID:
			return getURLRewriteMediatorOutputConnector_3622Text(view);
		case ValidateMediatorEditPart.VISUAL_ID:
			return getValidateMediator_3623Text(view);
		case ValidateMediatorInputConnectorEditPart.VISUAL_ID:
			return getValidateMediatorInputConnector_3624Text(view);
		case ValidateMediatorOutputConnectorEditPart.VISUAL_ID:
			return getValidateMediatorOutputConnector_3625Text(view);
		case ValidateMediatorOnFailOutputConnectorEditPart.VISUAL_ID:
			return getValidateMediatorOnFailOutputConnector_3626Text(view);
		case MediatorFlow14EditPart.VISUAL_ID:
			return getMediatorFlow_3627Text(view);
		case RouterMediatorEditPart.VISUAL_ID:
			return getRouterMediator_3628Text(view);
		case RouterMediatorInputConnectorEditPart.VISUAL_ID:
			return getRouterMediatorInputConnector_3629Text(view);
		case RouterMediatorOutputConnectorEditPart.VISUAL_ID:
			return getRouterMediatorOutputConnector_3630Text(view);
		case RouterMediatorTargetOutputConnectorEditPart.VISUAL_ID:
			return getRouterMediatorTargetOutputConnector_3631Text(view);
		case RouterMediatorContainerEditPart.VISUAL_ID:
			return getRouterMediatorContainer_3632Text(view);
		case RouterTargetContainerEditPart.VISUAL_ID:
			return getRouterTargetContainer_3633Text(view);
		case MediatorFlow15EditPart.VISUAL_ID:
			return getMediatorFlow_3634Text(view);
		case ConditionalRouterMediatorEditPart.VISUAL_ID:
			return getConditionalRouterMediator_3635Text(view);
		case ConditionalRouterMediatorInputConnectorEditPart.VISUAL_ID:
			return getConditionalRouterMediatorInputConnector_3636Text(view);
		case ConditionalRouterMediatorOutputConnectorEditPart.VISUAL_ID:
			return getConditionalRouterMediatorOutputConnector_3637Text(view);
		case ConditionalRouterMediatorAdditionalOutputConnectorEditPart.VISUAL_ID:
			return getConditionalRouterMediatorAdditionalOutputConnector_3638Text(view);
		case MediatorFlow16EditPart.VISUAL_ID:
			return getMediatorFlow_3639Text(view);
		case RuleMediatorChildMediatorsOutputConnectorEditPart.VISUAL_ID:
			return getRuleMediatorChildMediatorsOutputConnector_3640Text(view);
		case MediatorFlow17EditPart.VISUAL_ID:
			return getMediatorFlow_3641Text(view);
		case EndpointDiagramEditPart.VISUAL_ID:
			return getEndpointDiagram_3642Text(view);
		case DefaultEndPoint2EditPart.VISUAL_ID:
			return getDefaultEndPoint_3643Text(view);
		case DefaultEndPointInputConnector2EditPart.VISUAL_ID:
			return getDefaultEndPointInputConnector_3644Text(view);
		case DefaultEndPointOutputConnector2EditPart.VISUAL_ID:
			return getDefaultEndPointOutputConnector_3645Text(view);
		case AddressEndPoint2EditPart.VISUAL_ID:
			return getAddressEndPoint_3646Text(view);
		case AddressEndPointInputConnector2EditPart.VISUAL_ID:
			return getAddressEndPointInputConnector_3647Text(view);
		case AddressEndPointOutputConnector2EditPart.VISUAL_ID:
			return getAddressEndPointOutputConnector_3648Text(view);
		case FailoverEndPoint2EditPart.VISUAL_ID:
			return getFailoverEndPoint_3649Text(view);
		case FailoverEndPointInputConnector2EditPart.VISUAL_ID:
			return getFailoverEndPointInputConnector_3650Text(view);
		case FailoverEndPointOutputConnector2EditPart.VISUAL_ID:
			return getFailoverEndPointOutputConnector_3651Text(view);
		case FailoverEndPointWestOutputConnector2EditPart.VISUAL_ID:
			return getFailoverEndPointWestOutputConnector_3652Text(view);
		case WSDLEndPoint2EditPart.VISUAL_ID:
			return getWSDLEndPoint_3653Text(view);
		case WSDLEndPointInputConnector2EditPart.VISUAL_ID:
			return getWSDLEndPointInputConnector_3654Text(view);
		case WSDLEndPointOutputConnector2EditPart.VISUAL_ID:
			return getWSDLEndPointOutputConnector_3655Text(view);
		case LoadBalanceEndPoint2EditPart.VISUAL_ID:
			return getLoadBalanceEndPoint_3656Text(view);
		case LoadBalanceEndPointInputConnector2EditPart.VISUAL_ID:
			return getLoadBalanceEndPointInputConnector_3657Text(view);
		case LoadBalanceEndPointOutputConnector2EditPart.VISUAL_ID:
			return getLoadBalanceEndPointOutputConnector_3658Text(view);
		case LoadBalanceEndPointWestOutputConnector2EditPart.VISUAL_ID:
			return getLoadBalanceEndPointWestOutputConnector_3659Text(view);
		case NamedEndpointEditPart.VISUAL_ID:
			return getNamedEndpoint_3660Text(view);
		case NamedEndpointInputConnectorEditPart.VISUAL_ID:
			return getNamedEndpointInputConnector_3661Text(view);
		case NamedEndpointOutputConnectorEditPart.VISUAL_ID:
			return getNamedEndpointOutputConnector_3662Text(view);
		case LocalEntryEditPart.VISUAL_ID:
			return getLocalEntry_3663Text(view);
		case TemplateEditPart.VISUAL_ID:
			return getTemplate_3664Text(view);
		case Sequences2EditPart.VISUAL_ID:
			return getSequences_3665Text(view);
		case EndpointDiagram2EditPart.VISUAL_ID:
			return getEndpointDiagram_3666Text(view);
		case TaskEditPart.VISUAL_ID:
			return getTask_3667Text(view);
		case SynapseAPIEditPart.VISUAL_ID:
			return getSynapseAPI_3668Text(view);
		case APIResourceEditPart.VISUAL_ID:
			return getAPIResource_3669Text(view);
		case APIResourceInputConnectorEditPart.VISUAL_ID:
			return getAPIResourceInputConnector_3670Text(view);
		case APIResourceOutputConnectorEditPart.VISUAL_ID:
			return getAPIResourceOutputConnector_3671Text(view);
		case APIResourceFaultInputConnectorEditPart.VISUAL_ID:
			return getAPIResourceFaultInputConnector_3672Text(view);
		case ProxyServiceContainer2EditPart.VISUAL_ID:
			return getProxyServiceContainer_3673Text(view);
		case APIResourceEndpointEditPart.VISUAL_ID:
			return getAPIResourceEndpoint_3674Text(view);
		case APIResourceEndpointInputConnectorEditPart.VISUAL_ID:
			return getAPIResourceEndpointInputConnector_3675Text(view);
		case APIResourceEndpointOutputConnectorEditPart.VISUAL_ID:
			return getAPIResourceEndpointOutputConnector_3676Text(view);
		case ComplexEndpointsEditPart.VISUAL_ID:
			return getComplexEndpoints_3677Text(view);
		case MediatorFlow18EditPart.VISUAL_ID:
			return getMediatorFlow_3678Text(view);
		case ComplexEndpointsOutputConnectorEditPart.VISUAL_ID:
			return getComplexEndpointsOutputConnector_3679Text(view);
		case BAMMediatorEditPart.VISUAL_ID:
			return getBAMMediator_3680Text(view);
		case BAMMediatorInputConnectorEditPart.VISUAL_ID:
			return getBAMMediatorInputConnector_3681Text(view);
		case BAMMediatorOutputConnectorEditPart.VISUAL_ID:
			return getBAMMediatorOutputConnector_3682Text(view);
		case BeanMediatorEditPart.VISUAL_ID:
			return getBeanMediator_3683Text(view);
		case BeanMediatorInputConnectorEditPart.VISUAL_ID:
			return getBeanMediatorInputConnector_3684Text(view);
		case BeanMediatorOutputConnectorEditPart.VISUAL_ID:
			return getBeanMediatorOutputConnector_3685Text(view);
		case EJBMediatorEditPart.VISUAL_ID:
			return getEJBMediator_3686Text(view);
		case EJBMediatorInputConnectorEditPart.VISUAL_ID:
			return getEJBMediatorInputConnector_3687Text(view);
		case EJBMediatorOutputConnectorEditPart.VISUAL_ID:
			return getEJBMediatorOutputConnector_3688Text(view);
		case AddressingEndpointEditPart.VISUAL_ID:
			return getAddressingEndpoint_3689Text(view);
		case AddressingEndpointInputConnectorEditPart.VISUAL_ID:
			return getAddressingEndpointInputConnector_3690Text(view);
		case AddressingEndpointOutputConnectorEditPart.VISUAL_ID:
			return getAddressingEndpointOutputConnector_3691Text(view);
		case RecipientListEndPointEditPart.VISUAL_ID:
			return getRecipientListEndPoint_3692Text(view);
		case RecipientListEndPointInputConnectorEditPart.VISUAL_ID:
			return getRecipientListEndPointInputConnector_3693Text(view);
		case RecipientListEndPointOutputConnectorEditPart.VISUAL_ID:
			return getRecipientListEndPointOutputConnector_3694Text(view);
		case RecipientListEndPointWestOutputConnectorEditPart.VISUAL_ID:
			return getRecipientListEndPointWestOutputConnector_3695Text(view);
		case RecipientListEndPoint2EditPart.VISUAL_ID:
			return getRecipientListEndPoint_3696Text(view);
		case RecipientListEndPointInputConnector2EditPart.VISUAL_ID:
			return getRecipientListEndPointInputConnector_3697Text(view);
		case RecipientListEndPointOutputConnector2EditPart.VISUAL_ID:
			return getRecipientListEndPointOutputConnector_3698Text(view);
		case RecipientListEndPointWestOutputConnector2EditPart.VISUAL_ID:
			return getRecipientListEndPointWestOutputConnector_3699Text(view);
		case MessageProcessorEditPart.VISUAL_ID:
			return getMessageProcessor_3701Text(view);
		case HTTPEndpointEditPart.VISUAL_ID:
			return getHTTPEndpoint_3709Text(view);
		case HTTPEndPointInputConnectorEditPart.VISUAL_ID:
			return getHTTPEndPointInputConnector_3710Text(view);
		case HTTPEndPointOutputConnectorEditPart.VISUAL_ID:
			return getHTTPEndPointOutputConnector_3711Text(view);
		case HTTPEndpoint2EditPart.VISUAL_ID:
			return getHTTPEndpoint_3712Text(view);
		case HTTPEndPointInputConnector2EditPart.VISUAL_ID:
			return getHTTPEndPointInputConnector_3713Text(view);
		case HTTPEndPointOutputConnector2EditPart.VISUAL_ID:
			return getHTTPEndPointOutputConnector_3714Text(view);
		case MessageStoreEditPart.VISUAL_ID:
			return getMessageStore_3715Text(view);
		case TemplateEndpointEditPart.VISUAL_ID:
			return getTemplateEndpoint_3716Text(view);
		case TemplateEndpointInputConnectorEditPart.VISUAL_ID:
			return getTemplateEndpointInputConnector_3717Text(view);
		case TemplateEndpointOutputConnectorEditPart.VISUAL_ID:
			return getTemplateEndpointOutputConnector_3718Text(view);
		case CloudConnectorEditPart.VISUAL_ID:
			return getCloudConnector_3719Text(view);
		case CloudConnectorInputConnectorEditPart.VISUAL_ID:
			return getCloudConnectorInputConnector_3720Text(view);
		case CloudConnectorOutputConnectorEditPart.VISUAL_ID:
			return getCloudConnectorOutputConnector_3721Text(view);
		case CloudConnectorOperationEditPart.VISUAL_ID:
			return getCloudConnectorOperation_3722Text(view);
		case CloudConnectorOperationInputConnectorEditPart.VISUAL_ID:
			return getCloudConnectorOperationInputConnector_3723Text(view);
		case CloudConnectorOperationOutputConnectorEditPart.VISUAL_ID:
			return getCloudConnectorOperationOutputConnector_3724Text(view);
		case TemplateEndpoint2EditPart.VISUAL_ID:
			return getTemplateEndpoint_3725Text(view);
		case TemplateEndpointInputConnector2EditPart.VISUAL_ID:
			return getTemplateEndpointInputConnector_3726Text(view);
		case TemplateEndpointOutputConnector2EditPart.VISUAL_ID:
			return getTemplateEndpointOutputConnector_3727Text(view);
		case MediatorFlow19EditPart.VISUAL_ID:
			return getMediatorFlow_3728Text(view);
		case ProxyOutSequenceOutputConnectorEditPart.VISUAL_ID:
			return getProxyOutSequenceOutputConnector_3729Text(view);
		case APIResourceOutSequenceOutputConnectorEditPart.VISUAL_ID:
			return getAPIResourceOutSequenceOutputConnector_3730Text(view);
		case ProxyInSequenceInputConnectorEditPart.VISUAL_ID:
			return getProxyInSequenceInputConnector_3731Text(view);
		case SwitchCaseParentContainerEditPart.VISUAL_ID:
			return getSwitchCaseParentContainer_3732Text(view);
		case SwitchCaseContainerEditPart.VISUAL_ID:
			return getSwitchCaseContainer_3733Text(view);
		case SwitchDefaultParentContainerEditPart.VISUAL_ID:
			return getSwitchDefaultParentContainer_3734Text(view);
		case SwitchDefaultContainerEditPart.VISUAL_ID:
			return getSwitchDefaultContainer_3735Text(view);
		case LoopBackMediatorEditPart.VISUAL_ID:
			return getLoopBackMediator_3736Text(view);
		case LoopBackMediatorInputConnectorEditPart.VISUAL_ID:
			return getLoopBackMediatorInputConnector_3737Text(view);
		case LoopBackMediatorOutputConnectorEditPart.VISUAL_ID:
			return getLoopBackMediatorOutputConnector_3738Text(view);
		case RespondMediatorEditPart.VISUAL_ID:
			return getRespondMediator_3739Text(view);
		case RespondMediatorInputConnectorEditPart.VISUAL_ID:
			return getRespondMediatorInputConnector_3740Text(view);
		case RespondMediatorOutputConnectorEditPart.VISUAL_ID:
			return getRespondMediatorOutputConnector_3741Text(view);
		case CallMediatorEditPart.VISUAL_ID:
			return getCallMediator_3742Text(view);
		case CallMediatorInputConnectorEditPart.VISUAL_ID:
			return getCallMediatorInputConnector_3743Text(view);
		case CallMediatorOutputConnectorEditPart.VISUAL_ID:
			return getCallMediatorOutputConnector_3744Text(view);
		case CallMediatorEndpointOutputConnectorEditPart.VISUAL_ID:
			return getCallMediatorEndpointOutputConnector_3745Text(view);
		case MediatorFlow20EditPart.VISUAL_ID:
			return getMediatorFlow_3746Text(view);
		case APIResourceInSequenceInputConnectorEditPart.VISUAL_ID:
			return getAPIResourceInSequenceInputConnector_3747Text(view);
		case EntitlementMediatorOnRejectOutputConnectorEditPart.VISUAL_ID:
			return getEntitlementMediatorOnRejectOutputConnector_3748Text(view);
		case EntitlementMediatorOnAcceptOutputConnectorEditPart.VISUAL_ID:
			return getEntitlementMediatorOnAcceptOutputConnector_3749Text(view);
		case EntitlementMediatorAdviceOutputConnectorEditPart.VISUAL_ID:
			return getEntitlementMediatorAdviceOutputConnector_3750Text(view);
		case EntitlementMediatorObligationsOutputConnectorEditPart.VISUAL_ID:
			return getEntitlementMediatorObligationsOutputConnector_3751Text(view);
		case EntitlementContainerEditPart.VISUAL_ID:
			return getEntitlementContainer_3752Text(view);
		case EntitlementOnRejectContainerEditPart.VISUAL_ID:
			return getEntitlementOnRejectContainer_3753Text(view);
		case MediatorFlow21EditPart.VISUAL_ID:
			return getMediatorFlow_3754Text(view);
		case EntitlementOnAcceptContainerEditPart.VISUAL_ID:
			return getEntitlementOnAcceptContainer_3755Text(view);
		case MediatorFlow22EditPart.VISUAL_ID:
			return getMediatorFlow_3756Text(view);
		case EntitlementAdviceContainerEditPart.VISUAL_ID:
			return getEntitlementAdviceContainer_3757Text(view);
		case MediatorFlow23EditPart.VISUAL_ID:
			return getMediatorFlow_3758Text(view);
		case EntitlementObligationsContainerEditPart.VISUAL_ID:
			return getEntitlementObligationsContainer_3759Text(view);
		case MediatorFlow24EditPart.VISUAL_ID:
			return getMediatorFlow_3760Text(view);
		case DataMapperMediatorEditPart.VISUAL_ID:
			return getDataMapperMediator_3761Text(view);
		case DataMapperMediatorInputConnectorEditPart.VISUAL_ID:
			return getDataMapperMediatorInputConnector_3762Text(view);
		case DataMapperMediatorOutputConnectorEditPart.VISUAL_ID:
			return getDataMapperMediatorOutputConnector_3763Text(view);
		case FastXSLTMediatorEditPart.VISUAL_ID:
			return getFastXSLTMediator_3764Text(view);
		case FastXSLTMediatorInputConnectorEditPart.VISUAL_ID:
			return getFastXSLTMediatorInputConnector_3765Text(view);
		case FastXSLTMediatorOutputConnectorEditPart.VISUAL_ID:
			return getFastXSLTMediatorOutputConnector_3766Text(view);
		case InboundEndpointEditPart.VISUAL_ID:
			return getInboundEndpoint_3767Text(view);
		case InboundEndpointSequenceInputConnectorEditPart.VISUAL_ID:
			return getInboundEndpointSequenceInputConnector_3768Text(view);
		case InboundEndpointSequenceOutputConnectorEditPart.VISUAL_ID:
			return getInboundEndpointSequenceOutputConnector_3769Text(view);
		case InboundEndpointOnErrorSequenceInputConnectorEditPart.VISUAL_ID:
			return getInboundEndpointOnErrorSequenceInputConnector_3770Text(view);
		case InboundEndpointOnErrorSequenceOutputConnectorEditPart.VISUAL_ID:
			return getInboundEndpointOnErrorSequenceOutputConnector_3771Text(view);
		case InboundEndpointContainerEditPart.VISUAL_ID:
			return getInboundEndpointContainer_3772Text(view);
		case InboundEndpointSequenceContainerEditPart.VISUAL_ID:
			return getInboundEndpointSequenceContainer_3773Text(view);
		case MediatorFlow25EditPart.VISUAL_ID:
			return getMediatorFlow_3774Text(view);
		case InboundEndpointOnErrorSequenceContainerEditPart.VISUAL_ID:
			return getInboundEndpointOnErrorSequenceContainer_3775Text(view);
		case MediatorFlow26EditPart.VISUAL_ID:
			return getMediatorFlow_3776Text(view);
		case MediatorFlow27EditPart.VISUAL_ID:
			return getMediatorFlow_3777Text(view);
		case MediatorFlow28EditPart.VISUAL_ID:
			return getMediatorFlow_3778Text(view);
		case MediatorFlow29EditPart.VISUAL_ID:
			return getMediatorFlow_3779Text(view);
		case ForEachMediatorEditPart.VISUAL_ID:
			return getForEachMediator_3780Text(view);
		case ForEachMediatorInputConnectorEditPart.VISUAL_ID:
			return getForEachMediatorInputConnector_3781Text(view);
		case ForEachMediatorOutputConnectorEditPart.VISUAL_ID:
			return getForEachMediatorOutputConnector_3782Text(view);
		case ForEachMediatorTargetOutputConnectorEditPart.VISUAL_ID:
			return getForEachMediatorTargetOutputConnector_3783Text(view);
		case MediatorFlow30EditPart.VISUAL_ID:
			return getMediatorFlow_3784Text(view);
		case PublishEventMediatorEditPart.VISUAL_ID:
			return getPublishEventMediator_3785Text(view);
		case PublishEventMediatorInputConnectorEditPart.VISUAL_ID:
			return getPublishEventMediatorInputConnector_3786Text(view);
		case PublishEventMediatorOutputConnectorEditPart.VISUAL_ID:
			return getPublishEventMediatorOutputConnector_3787Text(view);
		case EsbLinkEditPart.VISUAL_ID:
			return getEsbLink_4001Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	 * @generated
	 */
	private String getEsbDiagram_1000Text(View view) {
		EsbDiagram domainModelElement = (EsbDiagram) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.getTest());
		} else {
			EsbDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 1000); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getIterateMediatorTargetOutputConnector_3606Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getCallMediatorInputConnector_3743Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getMediatorFlow_3639Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getBuilderMediatorOutputConector_3593Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getXQueryMediatorOutputConnector_3071Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getEnrichMediator_3496Text(View view) {
		IParser parser = EsbParserProvider.getParser(EsbElementTypes.EnrichMediator_3496,
				view.getElement() != null ? view.getElement() : view,
				EsbVisualIDRegistry.getType(EnrichMediatorDescriptionEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			EsbDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5169); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getEsbServer_2001Text(View view) {
		EsbServer domainModelElement = (EsbServer) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.getType());
		} else {
			EsbDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 2001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getMessageMediator_3045Text(View view) {
		MessageMediator domainModelElement = (MessageMediator) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getDescription();
		} else {
			EsbDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3045); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getDefaultEndPoint_3643Text(View view) {
		IParser parser = EsbParserProvider.getParser(EsbElementTypes.DefaultEndPoint_3643,
				view.getElement() != null ? view.getElement() : view,
				EsbVisualIDRegistry.getType(DefaultEndPointEndPointName2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			EsbDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5160); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getSwitchCaseContainer_3733Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getProxyService_3001Text(View view) {
		IParser parser = EsbParserProvider.getParser(EsbElementTypes.ProxyService_3001,
				view.getElement() != null ? view.getElement() : view,
				EsbVisualIDRegistry.getType(ProxyServiceNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			EsbDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5003); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getAPIResourceEndpointInputConnector_3675Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getClassMediator_3506Text(View view) {
		IParser parser = EsbParserProvider.getParser(EsbElementTypes.ClassMediator_3506,
				view.getElement() != null ? view.getElement() : view,
				EsbVisualIDRegistry.getType(ClassMediatorDescriptionEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			EsbDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5173); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getWSDLEndPointOutputConnector_3093Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getOAuthMediator_3524Text(View view) {
		IParser parser = EsbParserProvider.getParser(EsbElementTypes.OAuthMediator_3524,
				view.getElement() != null ? view.getElement() : view,
				EsbVisualIDRegistry.getType(OAuthMediatorDescriptionEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			EsbDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5187); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getMediatorFlow_3536Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getProxyServiceSequenceAndEndpointContainer_3487Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getProxyServiceContainer_3486Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getCommandMediatorOutputConnector_3074Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getCloneMediatorInputConnector_3103Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getWSDLEndPointInputConnector_3654Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getCacheMediatorOnHitOutputConnector_3618Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getFailoverEndPointOutputConnector_3090Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getLogMediator_3495Text(View view) {
		IParser parser = EsbParserProvider.getParser(EsbElementTypes.LogMediator_3495,
				view.getElement() != null ? view.getElement() : view,
				EsbVisualIDRegistry.getType(LogMediatorDescriptionEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			EsbDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5168); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getHTTPEndPointOutputConnector_3711Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getDataMapperMediatorInputConnector_3762Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getSpringMediator_3507Text(View view) {
		IParser parser = EsbParserProvider.getParser(EsbElementTypes.SpringMediator_3507,
				view.getElement() != null ? view.getElement() : view,
				EsbVisualIDRegistry.getType(SpringMediatorDescriptionEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			EsbDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5174); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getFaultMediatorInputConnector_3067Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getEntitlementMediatorInputConnector_3055Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getXQueryMediator_3510Text(View view) {
		IParser parser = EsbParserProvider.getParser(EsbElementTypes.XQueryMediator_3510,
				view.getElement() != null ? view.getElement() : view,
				EsbVisualIDRegistry.getType(XQueryMediatorDescriptionEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			EsbDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5177); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getLoadBalanceEndPointWestOutputConnector_3659Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getNamedEndpointInputConnector_3661Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getEntitlementAdviceContainer_3757Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getSequenceInputConnector_3049Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getProxyOutputConnector_3002Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getRuleMediatorChildMediatorsOutputConnector_3640Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getMediatorFlow_3728Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getSequencesInputConnector_3616Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getHTTPEndpoint_3709Text(View view) {
		IParser parser = EsbParserProvider.getParser(EsbElementTypes.HTTPEndpoint_3709,
				view.getElement() != null ? view.getElement() : view,
				EsbVisualIDRegistry.getType(HTTPEndpointDescriptionEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			EsbDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5206); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getRMSequenceMediatorInputConnector_3124Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getMediatorFlow_3746Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getDefaultEndPoint_3609Text(View view) {
		IParser parser = EsbParserProvider.getParser(EsbElementTypes.DefaultEndPoint_3609,
				view.getElement() != null ? view.getElement() : view,
				EsbVisualIDRegistry.getType(DefaultEndPointDescriptionEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			EsbDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5201); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getRecipientListEndPointWestOutputConnector_3695Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getMediatorFlow_3641Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getThrottleMediatorOutputConnector_3122Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getBeanMediatorInputConnector_3684Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getXSLTMediator_3497Text(View view) {
		IParser parser = EsbParserProvider.getParser(EsbElementTypes.XSLTMediator_3497,
				view.getElement() != null ? view.getElement() : view,
				EsbVisualIDRegistry.getType(XSLTMediatorDescriptionEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			EsbDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5170); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getConditionalRouterMediatorInputConnector_3636Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getSendMediatorEndpointOutputConnector_3539Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getDropMediator_3491Text(View view) {
		IParser parser = EsbParserProvider.getParser(EsbElementTypes.DropMediator_3491,
				view.getElement() != null ? view.getElement() : view,
				EsbVisualIDRegistry.getType(DropMediatorDescriptionEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			EsbDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5166); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getSwitchCaseBranchOutputConnector_3043Text(View view) {
		SwitchCaseBranchOutputConnector domainModelElement = (SwitchCaseBranchOutputConnector) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getCaseRegex();
		} else {
			EsbDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3043); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getRMSequenceMediator_3522Text(View view) {
		IParser parser = EsbParserProvider.getParser(EsbElementTypes.RMSequenceMediator_3522,
				view.getElement() != null ? view.getElement() : view,
				EsbVisualIDRegistry.getType(RMSequenceMediatorDescriptionEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			EsbDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5186); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getBAMMediatorOutputConnector_3682Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getRecipientListEndPointWestOutputConnector_3699Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getProxyInputConnector_3003Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getAPIResourceInputConnector_3670Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getConditionalRouterMediatorOutputConnector_3637Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getMediatorFlow_3607Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getDefaultEndPointOutputConnector_3022Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getAddressEndPointOutputConnector_3648Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getRecipientListEndPointOutputConnector_3698Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getDBLookupMediator_3512Text(View view) {
		IParser parser = EsbParserProvider.getParser(EsbElementTypes.DBLookupMediator_3512,
				view.getElement() != null ? view.getElement() : view,
				EsbVisualIDRegistry.getType(DBLookupMediatorDescriptionEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			EsbDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5179); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getThrottleOnRejectContainer_3586Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getLocalEntry_3663Text(View view) {
		LocalEntry domainModelElement = (LocalEntry) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getEntryName();
		} else {
			EsbDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3663); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getTemplateEndpointInputConnector_3726Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getDBLookupMediatorOutputConnector_3077Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getRecipientListEndPointInputConnector_3697Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getSwitchMediator_3498Text(View view) {
		SwitchMediator domainModelElement = (SwitchMediator) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getNamespace();
		} else {
			EsbDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3498); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getLoopBackMediatorInputConnector_3737Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getCloudConnectorOperation_3722Text(View view) {
		IParser parser = EsbParserProvider.getParser(EsbElementTypes.CloudConnectorOperation_3722,
				view.getElement() != null ? view.getElement() : view,
				EsbVisualIDRegistry.getType(CloudConnectorOperationDescriptionEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			EsbDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5198); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getTransactionMediatorOutputConnector_3119Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getLoopBackMediatorOutputConnector_3738Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getFaultMediatorOutputConnector_3068Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getSpringMediatorOutputConnector_3062Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getFailoverEndPoint_3649Text(View view) {
		IParser parser = EsbParserProvider.getParser(EsbElementTypes.FailoverEndPoint_3649,
				view.getElement() != null ? view.getElement() : view,
				EsbVisualIDRegistry.getType(FailoverEndPointEndPointName2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			EsbDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5162); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getLoadBalanceEndPointWestOutputConnector_3098Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getSwitchDefaultContainer_3735Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getCallMediator_3742Text(View view) {
		CallMediator domainModelElement = (CallMediator) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getDescription();
		} else {
			EsbDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3742); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getRouterMediatorTargetOutputConnector_3631Text(View view) {
		RouterMediatorTargetOutputConnector domainModelElement = (RouterMediatorTargetOutputConnector) view
				.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getSoapAction();
		} else {
			EsbDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3631); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getSwitchMediatorContainer_3500Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getDefaultEndPointInputConnector_3021Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getThrottleOnAcceptContainer_3584Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getLoadBalanceEndPoint_3613Text(View view) {
		IParser parser = EsbParserProvider.getParser(EsbElementTypes.LoadBalanceEndPoint_3613,
				view.getElement() != null ? view.getElement() : view,
				EsbVisualIDRegistry.getType(LoadBalanceEndPointDescriptionEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			EsbDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5205); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getThrottleMediatorInputConnector_3121Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getRuleMediatorOutputConnector_3128Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getRecipientListEndPoint_3692Text(View view) {
		IParser parser = EsbParserProvider.getParser(EsbElementTypes.RecipientListEndPoint_3692,
				view.getElement() != null ? view.getElement() : view,
				EsbVisualIDRegistry.getType(RecipientListEndPointDescriptionEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			EsbDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5203); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getMediatorFlow_3754Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getTemplateEndpointOutputConnector_3727Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getHTTPEndPointInputConnector_3713Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getPayloadFactoryMediatorInputConnector_3598Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getTransactionMediatorInputConnector_3118Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getRouterMediator_3628Text(View view) {
		RouterMediator domainModelElement = (RouterMediator) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getDescription();
		} else {
			EsbDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3628); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getCalloutMediatorInputConnector_3115Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getRecipientListEndPoint_3696Text(View view) {
		RecipientListEndPoint domainModelElement = (RecipientListEndPoint) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			EsbDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3696); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getPropertyMediatorOutputConnector_3034Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getProxyOutSequenceOutputConnector_3729Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getEJBMediatorOutputConnector_3688Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getTemplateEndpointOutputConnector_3718Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getEndpointDiagram_3666Text(View view) {
		EndpointDiagram domainModelElement = (EndpointDiagram) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			EsbDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3666); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getSynapseAPI_3668Text(View view) {
		SynapseAPI domainModelElement = (SynapseAPI) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getApiName();
		} else {
			EsbDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3668); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getRuleMediator_3523Text(View view) {
		RuleMediator domainModelElement = (RuleMediator) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getInputWrapperName();
		} else {
			EsbDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3523); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getMessageStore_3715Text(View view) {
		MessageStore domainModelElement = (MessageStore) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getStoreName();
		} else {
			EsbDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3715); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getSmooksMediatorOutputConnector_3083Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getPropertyMediator_3492Text(View view) {
		IParser parser = EsbParserProvider.getParser(EsbElementTypes.PropertyMediator_3492,
				view.getElement() != null ? view.getElement() : view,
				EsbVisualIDRegistry.getType(PropertyMediatorDescriptionEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			EsbDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5167); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getBeanMediatorOutputConnector_3685Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getCallTemplateMediatorInputConnector_3595Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getFailoverEndPointInputConnector_3650Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getIterateMediatorOutputConnector_3110Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getMessageInputConnector_3046Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getAPIResourceInSequenceInputConnector_3747Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getHeaderMediatorInputConnector_3100Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getHTTPEndPointInputConnector_3710Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getDBReportMediatorOutputConnector_3080Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getFilterMediatorOutputConnector_3534Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getStoreMediatorOutputConnector_3590Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getMediatorFlow_3678Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getXSLTMediatorInputConnector_3039Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getSwitchCaseParentContainer_3732Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getCommandMediatorInputConnector_3073Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getSequence_3503Text(View view) {
		IParser parser = EsbParserProvider.getParser(EsbElementTypes.Sequence_3503,
				view.getElement() != null ? view.getElement() : view,
				EsbVisualIDRegistry.getType(SequenceNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			EsbDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5132); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getSpringMediatorInputConnector_3061Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getEntitlementMediatorOnAcceptOutputConnector_3749Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getScriptMediatorInputConnector_3064Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getDropMediatorInputConnector_3008Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getEnrichMediatorInputConnector_3036Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getFilterMediatorInputConnector_3010Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getMediatorFlow_3528Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getCloudConnectorOutputConnector_3721Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getFailoverEndPointWestOutputConnector_3097Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getCloneMediatorTargetOutputConnector_3133Text(View view) {
		CloneMediatorTargetOutputConnector domainModelElement = (CloneMediatorTargetOutputConnector) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getSoapAction();
		} else {
			EsbDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3133); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getConditionalRouterMediator_3635Text(View view) {
		IParser parser = EsbParserProvider.getParser(EsbElementTypes.ConditionalRouterMediator_3635,
				view.getElement() != null ? view.getElement() : view,
				EsbVisualIDRegistry.getType(ConditionalRouterMediatorDescriptionEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			EsbDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5210); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getDataMapperMediatorOutputConnector_3763Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getFastXSLTMediator_3764Text(View view) {
		IParser parser = EsbParserProvider.getParser(EsbElementTypes.FastXSLTMediator_3764,
				view.getElement() != null ? view.getElement() : view,
				EsbVisualIDRegistry.getType(FastXSLTMediatorDescriptionEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			EsbDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5212); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getFastXSLTMediatorInputConnector_3765Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getFastXSLTMediatorOutputConnector_3766Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getInboundEndpoint_3767Text(View view) {
		InboundEndpoint domainModelElement = (InboundEndpoint) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			EsbDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3767); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getInboundEndpointSequenceInputConnector_3768Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getInboundEndpointSequenceOutputConnector_3769Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getInboundEndpointOnErrorSequenceInputConnector_3770Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getInboundEndpointOnErrorSequenceOutputConnector_3771Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getInboundEndpointContainer_3772Text(View view) {
		InboundEndpointContainer domainModelElement = (InboundEndpointContainer) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getDescription();
		} else {
			EsbDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3772); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getInboundEndpointSequenceContainer_3773Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getMediatorFlow_3774Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getInboundEndpointOnErrorSequenceContainer_3775Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getMediatorFlow_3776Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getMediatorFlow_3777Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getMediatorFlow_3778Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getMediatorFlow_3779Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getForEachMediator_3780Text(View view) {
		IParser parser = EsbParserProvider.getParser(EsbElementTypes.ForEachMediator_3780,
				view.getElement() != null ? view.getElement() : view,
				EsbVisualIDRegistry.getType(ForEachMediatorDescriptionEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			EsbDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5213); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getForEachMediatorInputConnector_3781Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getForEachMediatorOutputConnector_3782Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getForEachMediatorTargetOutputConnector_3783Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getMediatorFlow_3784Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getPublishEventMediator_3785Text(View view) {
		IParser parser = EsbParserProvider.getParser(EsbElementTypes.PublishEventMediator_3785,
				view.getElement() != null ? view.getElement() : view,
				EsbVisualIDRegistry.getType(PublishEventMediatorStreamNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			EsbDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5214); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getPublishEventMediatorInputConnector_3786Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getPublishEventMediatorOutputConnector_3787Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getProxyFaultInputConnector_3489Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getDefaultEndPointInputConnector_3644Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getMediatorFlow_3605Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getPayloadFactoryMediatorOutputConnector_3599Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getBeanMediator_3683Text(View view) {
		IParser parser = EsbParserProvider.getParser(EsbElementTypes.BeanMediator_3683,
				view.getElement() != null ? view.getElement() : view,
				EsbVisualIDRegistry.getType(BeanMediatorDescriptionEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			EsbDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5195); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getFilterMediatorPassOutputConnector_3011Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getRouterMediatorContainer_3632Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getLoadBalanceEndPointOutputConnector_3658Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getBuilderMediatorInputConnector_3592Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getClassMediatorInputConnector_3058Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getAddressEndPoint_3646Text(View view) {
		IParser parser = EsbParserProvider.getParser(EsbElementTypes.AddressEndPoint_3646,
				view.getElement() != null ? view.getElement() : view,
				EsbVisualIDRegistry.getType(AddressEndPointEndPointName2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			EsbDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5161); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getStoreMediatorInputConnector_3589Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getSwitchMediatorOutputConnector_3499Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getSequencesOutputConnector_3617Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getEnqueueMediatorOutputConnector_3602Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getFilterMediatorFailOutputConnector_3012Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getWSDLEndPoint_3653Text(View view) {
		IParser parser = EsbParserProvider.getParser(EsbElementTypes.WSDLEndPoint_3653,
				view.getElement() != null ? view.getElement() : view,
				EsbVisualIDRegistry.getType(WSDLEndPointEndPointName2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			EsbDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5163); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getCloudConnectorOperationOutputConnector_3724Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getWSDLEndPoint_3612Text(View view) {
		IParser parser = EsbParserProvider.getParser(EsbElementTypes.WSDLEndPoint_3612,
				view.getElement() != null ? view.getElement() : view,
				EsbVisualIDRegistry.getType(WSDLEndPointDescriptionEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			EsbDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5204); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getAddressingEndpointInputConnector_3690Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getMediatorFlow_3615Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getMediatorFlow_3760Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getAddressingEndpointOutputConnector_3691Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getMediatorFlow_3634Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getEntitlementContainer_3752Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getMediatorFlow_3526Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getRuleMediatorInputConnector_3127Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getScriptMediator_3508Text(View view) {
		IParser parser = EsbParserProvider.getParser(EsbElementTypes.ScriptMediator_3508,
				view.getElement() != null ? view.getElement() : view,
				EsbVisualIDRegistry.getType(ScriptMediatorDescriptionEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			EsbDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5175); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getNamedEndpointOutputConnector_3662Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getCloneMediatorOutputConnector_3104Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getFilterMediator_3494Text(View view) {
		IParser parser = EsbParserProvider.getParser(EsbElementTypes.FilterMediator_3494,
				view.getElement() != null ? view.getElement() : view,
				EsbVisualIDRegistry.getType(FilterMediatorConditionTypeEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			EsbDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5129); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getEventMediator_3504Text(View view) {
		IParser parser = EsbParserProvider.getParser(EsbElementTypes.EventMediator_3504,
				view.getElement() != null ? view.getElement() : view,
				EsbVisualIDRegistry.getType(EventMediatorDescriptionEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			EsbDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5171); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getMergeNode_3013Text(View view) {
		MergeNode domainModelElement = (MergeNode) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getDescription();
		} else {
			EsbDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3013); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getRespondMediator_3739Text(View view) {
		IParser parser = EsbParserProvider.getParser(EsbElementTypes.RespondMediator_3739,
				view.getElement() != null ? view.getElement() : view,
				EsbVisualIDRegistry.getType(RespondMediatorDescriptionEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			EsbDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5209); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getMediatorFlow_3619Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getStoreMediator_3588Text(View view) {
		IParser parser = EsbParserProvider.getParser(EsbElementTypes.StoreMediator_3588,
				view.getElement() != null ? view.getElement() : view,
				EsbVisualIDRegistry.getType(StoreMediatorDescriptionEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			EsbDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5188); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getCloneMediatorContainer_3603Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getAddressEndPointInputConnector_3030Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getBAMMediatorInputConnector_3681Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getPropertyMediatorInputConnector_3033Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getTemplateEndpoint_3725Text(View view) {
		TemplateEndpoint domainModelElement = (TemplateEndpoint) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getEndPointName();
		} else {
			EsbDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3725); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getEntitlementOnRejectContainer_3753Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getCallTemplateMediator_3594Text(View view) {
		IParser parser = EsbParserProvider.getParser(EsbElementTypes.CallTemplateMediator_3594,
				view.getElement() != null ? view.getElement() : view,
				EsbVisualIDRegistry.getType(CallTemplateMediatorDescriptionEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			EsbDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5190); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getEntitlementMediator_3505Text(View view) {
		IParser parser = EsbParserProvider.getParser(EsbElementTypes.EntitlementMediator_3505,
				view.getElement() != null ? view.getElement() : view,
				EsbVisualIDRegistry.getType(EntitlementMediatorServerURLEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			EsbDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5134); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getAPIResourceOutSequenceOutputConnector_3730Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getMediatorFlow_3585Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getFailoverEndPointWestOutputConnector_3652Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getEntitlementMediatorObligationsOutputConnector_3751Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getRouterMediatorOutputConnector_3630Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getThrottleMediatorOnRejectOutputConnector_3582Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getProxyInSequenceInputConnector_3731Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getAddressEndPointOutputConnector_3031Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getDataMapperMediator_3761Text(View view) {
		IParser parser = EsbParserProvider.getParser(EsbElementTypes.DataMapperMediator_3761,
				view.getElement() != null ? view.getElement() : view,
				EsbVisualIDRegistry.getType(DataMapperMediatorDescriptionEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			EsbDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5211); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getXQueryMediatorInputConnector_3070Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getMediatorFlow_3502Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getOAuthMediatorInputConnector_3130Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getLoopBackMediator_3736Text(View view) {
		IParser parser = EsbParserProvider.getParser(EsbElementTypes.LoopBackMediator_3736,
				view.getElement() != null ? view.getElement() : view,
				EsbVisualIDRegistry.getType(LoopBackMediatorDescriptionEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			EsbDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5208); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getComplexEndpointsOutputConnector_3679Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getSmooksMediator_3514Text(View view) {
		IParser parser = EsbParserProvider.getParser(EsbElementTypes.SmooksMediator_3514,
				view.getElement() != null ? view.getElement() : view,
				EsbVisualIDRegistry.getType(SmooksMediatorDescriptionEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			EsbDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5181); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getXSLTMediatorOutputConnector_3040Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getSequences_3665Text(View view) {
		Sequences domainModelElement = (Sequences) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			EsbDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3665); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getAddressingEndpoint_3689Text(View view) {
		IParser parser = EsbParserProvider.getParser(EsbElementTypes.AddressingEndpoint_3689,
				view.getElement() != null ? view.getElement() : view,
				EsbVisualIDRegistry.getType(AddressingEndpointDescriptionEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			EsbDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5200); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getAPIResourceEndpointOutputConnector_3676Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getTemplate_3664Text(View view) {
		Template domainModelElement = (Template) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			EsbDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3664); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getDefaultEndPointOutputConnector_3645Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getOAuthMediatorOutputConnector_3131Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getAggregateMediatorOnCompleteOutputConnector_3132Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getAPIResourceOutputConnector_3671Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getEnrichMediatorOutputConnector_3037Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getRouterTargetContainer_3633Text(View view) {
		RouterTargetContainer domainModelElement = (RouterTargetContainer) view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(domainModelElement.isBreakAfterRoute());
		} else {
			EsbDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3633); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getMediatorFlow_3608Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getCallMediatorOutputConnector_3744Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getRouterMediatorInputConnector_3629Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getMergeNodeFirstInputConnector_3014Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getNamedEndpoint_3660Text(View view) {
		IParser parser = EsbParserProvider.getParser(EsbElementTypes.NamedEndpoint_3660,
				view.getElement() != null ? view.getElement() : view,
				EsbVisualIDRegistry.getType(NamedEndpointNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			EsbDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5165); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getAddressEndPoint_3610Text(View view) {
		IParser parser = EsbParserProvider.getParser(EsbElementTypes.AddressEndPoint_3610,
				view.getElement() != null ? view.getElement() : view,
				EsbVisualIDRegistry.getType(AddressEndPointDescriptionEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			EsbDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5199); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getFailoverEndPointOutputConnector_3651Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getCloneMediator_3517Text(View view) {
		IParser parser = EsbParserProvider.getParser(EsbElementTypes.CloneMediator_3517,
				view.getElement() != null ? view.getElement() : view,
				EsbVisualIDRegistry.getType(CloneMediatorCloneIDEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			EsbDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5144); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getAggregateMediatorOutputConnector_3113Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getMergeNodeSecondInputConnector_3015Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getTemplateEndpoint_3716Text(View view) {
		IParser parser = EsbParserProvider.getParser(EsbElementTypes.TemplateEndpoint_3716,
				view.getElement() != null ? view.getElement() : view,
				EsbVisualIDRegistry.getType(TemplateEndpointDescriptionEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			EsbDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5207); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getBuilderMediator_3591Text(View view) {
		IParser parser = EsbParserProvider.getParser(EsbElementTypes.BuilderMediator_3591,
				view.getElement() != null ? view.getElement() : view,
				EsbVisualIDRegistry.getType(BuilderMediatorDescriptionEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			EsbDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5189); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getURLRewriteMediatorOutputConnector_3622Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getTransactionMediator_3521Text(View view) {
		IParser parser = EsbParserProvider.getParser(EsbElementTypes.TransactionMediator_3521,
				view.getElement() != null ? view.getElement() : view,
				EsbVisualIDRegistry.getType(TransactionMediatorDescriptionEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			EsbDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5185); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getLoadBalanceEndPointInputConnector_3095Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getMergeNodeOutputConnector_3016Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getAggregateMediator_3525Text(View view) {
		IParser parser = EsbParserProvider.getParser(EsbElementTypes.AggregateMediator_3525,
				view.getElement() != null ? view.getElement() : view,
				EsbVisualIDRegistry.getType(AggregateMediatorAggregateIDEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			EsbDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5149); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getHTTPEndPointOutputConnector_3714Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getValidateMediator_3623Text(View view) {
		ValidateMediator domainModelElement = (ValidateMediator) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getDescription();
		} else {
			EsbDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3623); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getAPIResourceFaultInputConnector_3672Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getCallTemplateMediatorOutputConnector_3596Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getSendMediatorOutputConnector_3086Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getHeaderMediatorOutputConnector_3101Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getHeaderMediator_3516Text(View view) {
		IParser parser = EsbParserProvider.getParser(EsbElementTypes.HeaderMediator_3516,
				view.getElement() != null ? view.getElement() : view,
				EsbVisualIDRegistry.getType(HeaderMediatorDescriptionEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			EsbDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5183); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getThrottleContainer_3583Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getEJBMediatorInputConnector_3687Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getProxyServiceContainer_3673Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getCalloutMediatorOutputConnector_3116Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getMediatorFlow_3587Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getWSDLEndPointInputConnector_3092Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getValidateMediatorOnFailOutputConnector_3626Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getLoadBalanceEndPoint_3656Text(View view) {
		IParser parser = EsbParserProvider.getParser(EsbElementTypes.LoadBalanceEndPoint_3656,
				view.getElement() != null ? view.getElement() : view,
				EsbVisualIDRegistry.getType(LoadBalanceEndPointEndPointName2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			EsbDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5164); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getSwitchMediatorInputConnector_3042Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getSwitchDefaultBranchOutputConnector_3044Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getLoadBalanceEndPointInputConnector_3657Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getCallMediatorEndpointOutputConnector_3745Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getFailoverEndPointInputConnector_3088Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getThrottleMediator_3493Text(View view) {
		IParser parser = EsbParserProvider.getParser(EsbElementTypes.ThrottleMediator_3493,
				view.getElement() != null ? view.getElement() : view,
				EsbVisualIDRegistry.getType(ThrottleMediatorGroupIdEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			EsbDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5128); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getBAMMediator_3680Text(View view) {
		IParser parser = EsbParserProvider.getParser(EsbElementTypes.BAMMediator_3680,
				view.getElement() != null ? view.getElement() : view,
				EsbVisualIDRegistry.getType(BAMMediatorDescriptionEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			EsbDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5194); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getPayloadFactoryMediator_3597Text(View view) {
		IParser parser = EsbParserProvider.getParser(EsbElementTypes.PayloadFactoryMediator_3597,
				view.getElement() != null ? view.getElement() : view,
				EsbVisualIDRegistry.getType(PayloadFactoryMediatorDescriptionEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			EsbDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5191); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getEntitlementMediatorOutputConnector_3056Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getLoadBalanceEndPointOutputConnector_3096Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getMessageOutputConnector_3047Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getCloudConnectorInputConnector_3720Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getCacheMediator_3518Text(View view) {
		IParser parser = EsbParserProvider.getParser(EsbElementTypes.CacheMediator_3518,
				view.getElement() != null ? view.getElement() : view,
				EsbVisualIDRegistry.getType(CacheMediatorCacheIdEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			EsbDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5145); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getFilterFailContainer_3537Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getCommandMediator_3511Text(View view) {
		IParser parser = EsbParserProvider.getParser(EsbElementTypes.CommandMediator_3511,
				view.getElement() != null ? view.getElement() : view,
				EsbVisualIDRegistry.getType(CommandMediatorDescriptionEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			EsbDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5178); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getThrottleMediatorOnAcceptOutputConnector_3581Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getSendMediatorInputConnector_3085Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getEntitlementOnAcceptContainer_3755Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getEntitlementObligationsContainer_3759Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getComplexEndpoints_3677Text(View view) {
		ComplexEndpoints domainModelElement = (ComplexEndpoints) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			EsbDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3677); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getMediatorFlow_3758Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getDBReportMediator_3513Text(View view) {
		IParser parser = EsbParserProvider.getParser(EsbElementTypes.DBReportMediator_3513,
				view.getElement() != null ? view.getElement() : view,
				EsbVisualIDRegistry.getType(DBReportMediatorDescriptionEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			EsbDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5180); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getValidateMediatorOutputConnector_3625Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getURLRewriteMediatorInputConnector_3621Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getEntitlementMediatorOnRejectOutputConnector_3748Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getSmooksMediatorInputConnector_3082Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getMessageProcessor_3701Text(View view) {
		MessageProcessor domainModelElement = (MessageProcessor) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getProcessorName();
		} else {
			EsbDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3701); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getFaultMediator_3509Text(View view) {
		IParser parser = EsbParserProvider.getParser(EsbElementTypes.FaultMediator_3509,
				view.getElement() != null ? view.getElement() : view,
				EsbVisualIDRegistry.getType(FaultMediatorDescriptionEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			EsbDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5176); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getLogMediatorInputConnector_3018Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getDBReportMediatorInputConnector_3079Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getTask_3667Text(View view) {
		Task domainModelElement = (Task) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getTaskName();
		} else {
			EsbDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3667); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getEnqueueMediatorInputConnector_3601Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getDBLookupMediatorInputConnector_3076Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getScriptMediatorOutputConnector_3065Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getConditionalRouterMediatorAdditionalOutputConnector_3638Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getRecipientListEndPointOutputConnector_3694Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getEntitlementMediatorAdviceOutputConnector_3750Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getMediatorFlow_3538Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getTemplateEndpointInputConnector_3717Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getHTTPEndpoint_3712Text(View view) {
		HTTPEndpoint domainModelElement = (HTTPEndpoint) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getEndPointName();
		} else {
			EsbDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3712); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getClassMediatorOutputConnector_3059Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getURLRewriteMediator_3620Text(View view) {
		IParser parser = EsbParserProvider.getParser(EsbElementTypes.URLRewriteMediator_3620,
				view.getElement() != null ? view.getElement() : view,
				EsbVisualIDRegistry.getType(URLRewriteMediatorDescriptionEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			EsbDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5193); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getCloneTargetContainer_3604Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getIterateMediator_3519Text(View view) {
		IParser parser = EsbParserProvider.getParser(EsbElementTypes.IterateMediator_3519,
				view.getElement() != null ? view.getElement() : view,
				EsbVisualIDRegistry.getType(IterateMediatorIterateIDEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			EsbDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5146); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getLogMediatorOutputConnector_3019Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getFailoverEndPoint_3611Text(View view) {
		IParser parser = EsbParserProvider.getParser(EsbElementTypes.FailoverEndPoint_3611,
				view.getElement() != null ? view.getElement() : view,
				EsbVisualIDRegistry.getType(FailoverEndPointDescriptionEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			EsbDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5202); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getAddressEndPointInputConnector_3647Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getEventMediatorInputConnector_3052Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getAPIResource_3669Text(View view) {
		APIResource domainModelElement = (APIResource) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getInSequenceName();
		} else {
			EsbDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3669); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getSequences_3614Text(View view) {
		Sequences domainModelElement = (Sequences) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			EsbDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3614); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getSwitchDefaultParentContainer_3734Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getMediatorFlow_3627Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getAPIResourceEndpoint_3674Text(View view) {
		APIResourceEndpoint domainModelElement = (APIResourceEndpoint) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getEndPointName();
		} else {
			EsbDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3674); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getCloudConnectorOperationInputConnector_3723Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getRespondMediatorOutputConnector_3741Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getEndpointDiagram_3642Text(View view) {
		EndpointDiagram domainModelElement = (EndpointDiagram) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			EsbDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3642); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getRespondMediatorInputConnector_3740Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getCacheMediatorInputConnector_3106Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getEJBMediator_3686Text(View view) {
		IParser parser = EsbParserProvider.getParser(EsbElementTypes.EJBMediator_3686,
				view.getElement() != null ? view.getElement() : view,
				EsbVisualIDRegistry.getType(EJBMediatorDescriptionEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			EsbDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5196); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getWSDLEndPointOutputConnector_3655Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getAggregateMediatorInputConnector_3112Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getFilterContainer_3531Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getMediatorFlow_3756Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getFilterPassContainer_3535Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getCalloutMediator_3520Text(View view) {
		IParser parser = EsbParserProvider.getParser(EsbElementTypes.CalloutMediator_3520,
				view.getElement() != null ? view.getElement() : view,
				EsbVisualIDRegistry.getType(CalloutMediatorDescriptionEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			EsbDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5184); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getSendMediator_3515Text(View view) {
		SendMediator domainModelElement = (SendMediator) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getDescription();
		} else {
			EsbDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3515); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getEsbLink_4001Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getCacheMediatorOutputConnector_3107Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getProxyServiceFaultContainer_3488Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getEventMediatorOutputConnector_3053Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getEnqueueMediator_3600Text(View view) {
		IParser parser = EsbParserProvider.getParser(EsbElementTypes.EnqueueMediator_3600,
				view.getElement() != null ? view.getElement() : view,
				EsbVisualIDRegistry.getType(EnqueueMediatorDescriptionEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			EsbDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5192); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getValidateMediatorInputConnector_3624Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getCloudConnector_3719Text(View view) {
		IParser parser = EsbParserProvider.getParser(EsbElementTypes.CloudConnector_3719,
				view.getElement() != null ? view.getElement() : view,
				EsbVisualIDRegistry.getType(CloudConnectorDescriptionEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			EsbDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5197); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getRecipientListEndPointInputConnector_3693Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getIterateMediatorInputConnector_3109Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getSequenceOutputConnector_3050Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getMediatorFlow_3530Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getRMSequenceMediatorOutputConnector_3125Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getUnknownElementText(View view) {
		return "<UnknownElement Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	private String getUnresolvedDomainElementProxyText(View view) {
		return "<Unresolved domain element Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	public void init(ICommonContentExtensionSite aConfig) {
	}

	/**
	 * @generated
	 */
	public void restoreState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public void saveState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public String getDescription(Object anElement) {
		return null;
	}

	/**
	 * @generated
	 */
	private boolean isOwnView(View view) {
		return EsbDiagramEditPart.MODEL_ID.equals(EsbVisualIDRegistry.getModelID(view));
	}

}
