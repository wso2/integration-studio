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
import org.wso2.developerstudio.eclipse.gmf.esb.CacheMediator;
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
        EsbDiagramEditorPlugin.getInstance().getImageRegistry().put("Navigator?UnknownElement", //$NON-NLS-1$
                ImageDescriptor.getMissingImageDescriptor());
        EsbDiagramEditorPlugin.getInstance().getImageRegistry().put("Navigator?ImageNotFound", //$NON-NLS-1$
                ImageDescriptor.getMissingImageDescriptor());
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
            return getImage("Navigator?Diagram?http:///org/wso2/developerstudio/eclipse/gmf/esb?EsbDiagram", //$NON-NLS-1$
                    EsbElementTypes.EsbDiagram_1000);
        case EsbServerEditPart.VISUAL_ID:
            return getImage("Navigator?TopLevelNode?http:///org/wso2/developerstudio/eclipse/gmf/esb?EsbServer", //$NON-NLS-1$
                    EsbElementTypes.EsbServer_2001);
        case ProxyServiceEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?ProxyService", //$NON-NLS-1$
                    EsbElementTypes.ProxyService_3001);
        case ProxyOutputConnectorEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?ProxyOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.ProxyOutputConnector_3002);
        case ProxyInputConnectorEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?ProxyInputConnector", //$NON-NLS-1$
                    EsbElementTypes.ProxyInputConnector_3003);
        case DropMediatorInputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?DropMediatorInputConnector", //$NON-NLS-1$
                    EsbElementTypes.DropMediatorInputConnector_3008);
        case FilterMediatorInputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?FilterMediatorInputConnector", //$NON-NLS-1$
                    EsbElementTypes.FilterMediatorInputConnector_3010);
        case FilterMediatorPassOutputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?FilterMediatorPassOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.FilterMediatorPassOutputConnector_3011);
        case FilterMediatorFailOutputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?FilterMediatorFailOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.FilterMediatorFailOutputConnector_3012);
        case MergeNodeEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?MergeNode", //$NON-NLS-1$
                    EsbElementTypes.MergeNode_3013);
        case MergeNodeFirstInputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?MergeNodeFirstInputConnector", //$NON-NLS-1$
                    EsbElementTypes.MergeNodeFirstInputConnector_3014);
        case MergeNodeSecondInputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?MergeNodeSecondInputConnector", //$NON-NLS-1$
                    EsbElementTypes.MergeNodeSecondInputConnector_3015);
        case MergeNodeOutputConnectorEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?MergeNodeOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.MergeNodeOutputConnector_3016);
        case LogMediatorInputConnectorEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?LogMediatorInputConnector", //$NON-NLS-1$
                    EsbElementTypes.LogMediatorInputConnector_3018);
        case LogMediatorOutputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?LogMediatorOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.LogMediatorOutputConnector_3019);
        case DefaultEndPointInputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?DefaultEndPointInputConnector", //$NON-NLS-1$
                    EsbElementTypes.DefaultEndPointInputConnector_3021);
        case DefaultEndPointOutputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?DefaultEndPointOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.DefaultEndPointOutputConnector_3022);
        case AddressEndPointInputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?AddressEndPointInputConnector", //$NON-NLS-1$
                    EsbElementTypes.AddressEndPointInputConnector_3030);
        case AddressEndPointOutputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?AddressEndPointOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.AddressEndPointOutputConnector_3031);
        case PropertyMediatorInputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?PropertyMediatorInputConnector", //$NON-NLS-1$
                    EsbElementTypes.PropertyMediatorInputConnector_3033);
        case PropertyMediatorOutputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?PropertyMediatorOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.PropertyMediatorOutputConnector_3034);
        case EnrichMediatorInputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?EnrichMediatorInputConnector", //$NON-NLS-1$
                    EsbElementTypes.EnrichMediatorInputConnector_3036);
        case EnrichMediatorOutputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?EnrichMediatorOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.EnrichMediatorOutputConnector_3037);
        case XSLTMediatorInputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?XSLTMediatorInputConnector", //$NON-NLS-1$
                    EsbElementTypes.XSLTMediatorInputConnector_3039);
        case XSLTMediatorOutputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?XSLTMediatorOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.XSLTMediatorOutputConnector_3040);
        case SwitchMediatorInputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?SwitchMediatorInputConnector", //$NON-NLS-1$
                    EsbElementTypes.SwitchMediatorInputConnector_3042);
        case SwitchCaseBranchOutputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?SwitchCaseBranchOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.SwitchCaseBranchOutputConnector_3043);
        case SwitchDefaultBranchOutputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?SwitchDefaultBranchOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.SwitchDefaultBranchOutputConnector_3044);
        case MessageMediatorEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?MessageMediator", //$NON-NLS-1$
                    EsbElementTypes.MessageMediator_3045);
        case MessageInputConnectorEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?MessageInputConnector", //$NON-NLS-1$
                    EsbElementTypes.MessageInputConnector_3046);
        case MessageOutputConnectorEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?MessageOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.MessageOutputConnector_3047);
        case SequenceInputConnectorEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?SequenceInputConnector", //$NON-NLS-1$
                    EsbElementTypes.SequenceInputConnector_3049);
        case SequenceOutputConnectorEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?SequenceOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.SequenceOutputConnector_3050);
        case EventMediatorInputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?EventMediatorInputConnector", //$NON-NLS-1$
                    EsbElementTypes.EventMediatorInputConnector_3052);
        case EventMediatorOutputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?EventMediatorOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.EventMediatorOutputConnector_3053);
        case EntitlementMediatorInputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?EntitlementMediatorInputConnector", //$NON-NLS-1$
                    EsbElementTypes.EntitlementMediatorInputConnector_3055);
        case EntitlementMediatorOutputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?EntitlementMediatorOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.EntitlementMediatorOutputConnector_3056);
        case ClassMediatorInputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?ClassMediatorInputConnector", //$NON-NLS-1$
                    EsbElementTypes.ClassMediatorInputConnector_3058);
        case ClassMediatorOutputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?ClassMediatorOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.ClassMediatorOutputConnector_3059);
        case SpringMediatorInputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?SpringMediatorInputConnector", //$NON-NLS-1$
                    EsbElementTypes.SpringMediatorInputConnector_3061);
        case SpringMediatorOutputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?SpringMediatorOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.SpringMediatorOutputConnector_3062);
        case ScriptMediatorInputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?ScriptMediatorInputConnector", //$NON-NLS-1$
                    EsbElementTypes.ScriptMediatorInputConnector_3064);
        case ScriptMediatorOutputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?ScriptMediatorOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.ScriptMediatorOutputConnector_3065);
        case FaultMediatorInputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?FaultMediatorInputConnector", //$NON-NLS-1$
                    EsbElementTypes.FaultMediatorInputConnector_3067);
        case FaultMediatorOutputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?FaultMediatorOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.FaultMediatorOutputConnector_3068);
        case XQueryMediatorInputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?XQueryMediatorInputConnector", //$NON-NLS-1$
                    EsbElementTypes.XQueryMediatorInputConnector_3070);
        case XQueryMediatorOutputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?XQueryMediatorOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.XQueryMediatorOutputConnector_3071);
        case CommandMediatorInputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?CommandMediatorInputConnector", //$NON-NLS-1$
                    EsbElementTypes.CommandMediatorInputConnector_3073);
        case CommandMediatorOutputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?CommandMediatorOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.CommandMediatorOutputConnector_3074);
        case DBLookupMediatorInputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?DBLookupMediatorInputConnector", //$NON-NLS-1$
                    EsbElementTypes.DBLookupMediatorInputConnector_3076);
        case DBLookupMediatorOutputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?DBLookupMediatorOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.DBLookupMediatorOutputConnector_3077);
        case DBReportMediatorInputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?DBReportMediatorInputConnector", //$NON-NLS-1$
                    EsbElementTypes.DBReportMediatorInputConnector_3079);
        case DBReportMediatorOutputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?DBReportMediatorOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.DBReportMediatorOutputConnector_3080);
        case SmooksMediatorInputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?SmooksMediatorInputConnector", //$NON-NLS-1$
                    EsbElementTypes.SmooksMediatorInputConnector_3082);
        case SmooksMediatorOutputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?SmooksMediatorOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.SmooksMediatorOutputConnector_3083);
        case SendMediatorInputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?SendMediatorInputConnector", //$NON-NLS-1$
                    EsbElementTypes.SendMediatorInputConnector_3085);
        case SendMediatorOutputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?SendMediatorOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.SendMediatorOutputConnector_3086);
        case FailoverEndPointInputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?FailoverEndPointInputConnector", //$NON-NLS-1$
                    EsbElementTypes.FailoverEndPointInputConnector_3088);
        case FailoverEndPointOutputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?FailoverEndPointOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.FailoverEndPointOutputConnector_3090);
        case WSDLEndPointInputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?WSDLEndPointInputConnector", //$NON-NLS-1$
                    EsbElementTypes.WSDLEndPointInputConnector_3092);
        case WSDLEndPointOutputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?WSDLEndPointOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.WSDLEndPointOutputConnector_3093);
        case LoadBalanceEndPointInputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?LoadBalanceEndPointInputConnector", //$NON-NLS-1$
                    EsbElementTypes.LoadBalanceEndPointInputConnector_3095);
        case LoadBalanceEndPointOutputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?LoadBalanceEndPointOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.LoadBalanceEndPointOutputConnector_3096);
        case FailoverEndPointWestOutputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?FailoverEndPointWestOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.FailoverEndPointWestOutputConnector_3097);
        case LoadBalanceEndPointWestOutputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?LoadBalanceEndPointWestOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.LoadBalanceEndPointWestOutputConnector_3098);
        case HeaderMediatorInputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?HeaderMediatorInputConnector", //$NON-NLS-1$
                    EsbElementTypes.HeaderMediatorInputConnector_3100);
        case HeaderMediatorOutputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?HeaderMediatorOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.HeaderMediatorOutputConnector_3101);
        case CloneMediatorInputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?CloneMediatorInputConnector", //$NON-NLS-1$
                    EsbElementTypes.CloneMediatorInputConnector_3103);
        case CloneMediatorOutputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?CloneMediatorOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.CloneMediatorOutputConnector_3104);
        case CacheMediatorInputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?CacheMediatorInputConnector", //$NON-NLS-1$
                    EsbElementTypes.CacheMediatorInputConnector_3106);
        case CacheMediatorOutputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?CacheMediatorOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.CacheMediatorOutputConnector_3107);
        case IterateMediatorInputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?IterateMediatorInputConnector", //$NON-NLS-1$
                    EsbElementTypes.IterateMediatorInputConnector_3109);
        case IterateMediatorOutputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?IterateMediatorOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.IterateMediatorOutputConnector_3110);
        case AggregateMediatorInputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?AggregateMediatorInputConnector", //$NON-NLS-1$
                    EsbElementTypes.AggregateMediatorInputConnector_3112);
        case AggregateMediatorOutputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?AggregateMediatorOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.AggregateMediatorOutputConnector_3113);
        case CalloutMediatorInputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?CalloutMediatorInputConnector", //$NON-NLS-1$
                    EsbElementTypes.CalloutMediatorInputConnector_3115);
        case CalloutMediatorOutputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?CalloutMediatorOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.CalloutMediatorOutputConnector_3116);
        case TransactionMediatorInputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?TransactionMediatorInputConnector", //$NON-NLS-1$
                    EsbElementTypes.TransactionMediatorInputConnector_3118);
        case TransactionMediatorOutputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?TransactionMediatorOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.TransactionMediatorOutputConnector_3119);
        case ThrottleMediatorInputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?ThrottleMediatorInputConnector", //$NON-NLS-1$
                    EsbElementTypes.ThrottleMediatorInputConnector_3121);
        case ThrottleMediatorOutputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?ThrottleMediatorOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.ThrottleMediatorOutputConnector_3122);
        case RMSequenceMediatorInputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?RMSequenceMediatorInputConnector", //$NON-NLS-1$
                    EsbElementTypes.RMSequenceMediatorInputConnector_3124);
        case RMSequenceMediatorOutputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?RMSequenceMediatorOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.RMSequenceMediatorOutputConnector_3125);
        case RuleMediatorInputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?RuleMediatorInputConnector", //$NON-NLS-1$
                    EsbElementTypes.RuleMediatorInputConnector_3127);
        case RuleMediatorOutputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?RuleMediatorOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.RuleMediatorOutputConnector_3128);
        case OAuthMediatorInputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?OAuthMediatorInputConnector", //$NON-NLS-1$
                    EsbElementTypes.OAuthMediatorInputConnector_3130);
        case OAuthMediatorOutputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?OAuthMediatorOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.OAuthMediatorOutputConnector_3131);
        case AggregateMediatorOnCompleteOutputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?AggregateMediatorOnCompleteOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.AggregateMediatorOnCompleteOutputConnector_3132);
        case CloneMediatorTargetOutputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?CloneMediatorTargetOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.CloneMediatorTargetOutputConnector_3133);
        case ProxyServiceContainerEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?ProxyServiceContainer", //$NON-NLS-1$
                    EsbElementTypes.ProxyServiceContainer_3486);
        case ProxyServiceSequenceAndEndpointContainerEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?ProxyServiceSequenceAndEndpointContainer", //$NON-NLS-1$
                    EsbElementTypes.ProxyServiceSequenceAndEndpointContainer_3487);
        case ProxyServiceFaultContainerEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?ProxyServiceFaultContainer", //$NON-NLS-1$
                    EsbElementTypes.ProxyServiceFaultContainer_3488);
        case ProxyFaultInputConnectorEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?ProxyFaultInputConnector", //$NON-NLS-1$
                    EsbElementTypes.ProxyFaultInputConnector_3489);
        case DropMediatorEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?DropMediator", //$NON-NLS-1$
                    EsbElementTypes.DropMediator_3491);
        case PropertyMediatorEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?PropertyMediator", //$NON-NLS-1$
                    EsbElementTypes.PropertyMediator_3492);
        case ThrottleMediatorEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?ThrottleMediator", //$NON-NLS-1$
                    EsbElementTypes.ThrottleMediator_3493);
        case FilterMediatorEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?FilterMediator", //$NON-NLS-1$
                    EsbElementTypes.FilterMediator_3494);
        case LogMediatorEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?LogMediator", //$NON-NLS-1$
                    EsbElementTypes.LogMediator_3495);
        case EnrichMediatorEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?EnrichMediator", //$NON-NLS-1$
                    EsbElementTypes.EnrichMediator_3496);
        case XSLTMediatorEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?XSLTMediator", //$NON-NLS-1$
                    EsbElementTypes.XSLTMediator_3497);
        case SwitchMediatorEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?SwitchMediator", //$NON-NLS-1$
                    EsbElementTypes.SwitchMediator_3498);
        case SwitchMediatorOutputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?SwitchMediatorOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.SwitchMediatorOutputConnector_3499);
        case SwitchMediatorContainerEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?SwitchMediatorContainer", //$NON-NLS-1$
                    EsbElementTypes.SwitchMediatorContainer_3500);
        case MediatorFlow2EditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?MediatorFlow", //$NON-NLS-1$
                    EsbElementTypes.MediatorFlow_3502);
        case SequenceEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?Sequence", //$NON-NLS-1$
                    EsbElementTypes.Sequence_3503);
        case EventMediatorEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?EventMediator", //$NON-NLS-1$
                    EsbElementTypes.EventMediator_3504);
        case EntitlementMediatorEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?EntitlementMediator", //$NON-NLS-1$
                    EsbElementTypes.EntitlementMediator_3505);
        case ClassMediatorEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?ClassMediator", //$NON-NLS-1$
                    EsbElementTypes.ClassMediator_3506);
        case SpringMediatorEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?SpringMediator", //$NON-NLS-1$
                    EsbElementTypes.SpringMediator_3507);
        case ScriptMediatorEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?ScriptMediator", //$NON-NLS-1$
                    EsbElementTypes.ScriptMediator_3508);
        case FaultMediatorEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?FaultMediator", //$NON-NLS-1$
                    EsbElementTypes.FaultMediator_3509);
        case XQueryMediatorEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?XQueryMediator", //$NON-NLS-1$
                    EsbElementTypes.XQueryMediator_3510);
        case CommandMediatorEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?CommandMediator", //$NON-NLS-1$
                    EsbElementTypes.CommandMediator_3511);
        case DBLookupMediatorEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?DBLookupMediator", //$NON-NLS-1$
                    EsbElementTypes.DBLookupMediator_3512);
        case DBReportMediatorEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?DBReportMediator", //$NON-NLS-1$
                    EsbElementTypes.DBReportMediator_3513);
        case SmooksMediatorEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?SmooksMediator", //$NON-NLS-1$
                    EsbElementTypes.SmooksMediator_3514);
        case SendMediatorEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?SendMediator", //$NON-NLS-1$
                    EsbElementTypes.SendMediator_3515);
        case HeaderMediatorEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?HeaderMediator", //$NON-NLS-1$
                    EsbElementTypes.HeaderMediator_3516);
        case CloneMediatorEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?CloneMediator", //$NON-NLS-1$
                    EsbElementTypes.CloneMediator_3517);
        case CacheMediatorEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?CacheMediator", //$NON-NLS-1$
                    EsbElementTypes.CacheMediator_3518);
        case IterateMediatorEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?IterateMediator", //$NON-NLS-1$
                    EsbElementTypes.IterateMediator_3519);
        case CalloutMediatorEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?CalloutMediator", //$NON-NLS-1$
                    EsbElementTypes.CalloutMediator_3520);
        case TransactionMediatorEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?TransactionMediator", //$NON-NLS-1$
                    EsbElementTypes.TransactionMediator_3521);
        case RMSequenceMediatorEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?RMSequenceMediator", //$NON-NLS-1$
                    EsbElementTypes.RMSequenceMediator_3522);
        case RuleMediatorEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?RuleMediator", //$NON-NLS-1$
                    EsbElementTypes.RuleMediator_3523);
        case OAuthMediatorEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?OAuthMediator", //$NON-NLS-1$
                    EsbElementTypes.OAuthMediator_3524);
        case AggregateMediatorEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?AggregateMediator", //$NON-NLS-1$
                    EsbElementTypes.AggregateMediator_3525);
        case MediatorFlow3EditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?MediatorFlow", //$NON-NLS-1$
                    EsbElementTypes.MediatorFlow_3526);
        case MediatorFlow4EditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?MediatorFlow", //$NON-NLS-1$
                    EsbElementTypes.MediatorFlow_3528);
        case MediatorFlow6EditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?MediatorFlow", //$NON-NLS-1$
                    EsbElementTypes.MediatorFlow_3530);
        case FilterContainerEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?FilterContainer", //$NON-NLS-1$
                    EsbElementTypes.FilterContainer_3531);
        case FilterMediatorOutputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?FilterMediatorOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.FilterMediatorOutputConnector_3534);
        case FilterPassContainerEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?FilterPassContainer", //$NON-NLS-1$
                    EsbElementTypes.FilterPassContainer_3535);
        case MediatorFlow7EditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?MediatorFlow", //$NON-NLS-1$
                    EsbElementTypes.MediatorFlow_3536);
        case FilterFailContainerEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?FilterFailContainer", //$NON-NLS-1$
                    EsbElementTypes.FilterFailContainer_3537);
        case MediatorFlow8EditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?MediatorFlow", //$NON-NLS-1$
                    EsbElementTypes.MediatorFlow_3538);
        case SendMediatorEndpointOutputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?SendMediatorEndpointOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.SendMediatorEndpointOutputConnector_3539);
        case ThrottleMediatorOnAcceptOutputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?ThrottleMediatorOnAcceptOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.ThrottleMediatorOnAcceptOutputConnector_3581);
        case ThrottleMediatorOnRejectOutputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?ThrottleMediatorOnRejectOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.ThrottleMediatorOnRejectOutputConnector_3582);
        case ThrottleContainerEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?ThrottleContainer", //$NON-NLS-1$
                    EsbElementTypes.ThrottleContainer_3583);
        case ThrottleOnAcceptContainerEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?ThrottleOnAcceptContainer", //$NON-NLS-1$
                    EsbElementTypes.ThrottleOnAcceptContainer_3584);
        case MediatorFlow9EditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?MediatorFlow", //$NON-NLS-1$
                    EsbElementTypes.MediatorFlow_3585);
        case ThrottleOnRejectContainerEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?ThrottleOnRejectContainer", //$NON-NLS-1$
                    EsbElementTypes.ThrottleOnRejectContainer_3586);
        case MediatorFlow10EditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?MediatorFlow", //$NON-NLS-1$
                    EsbElementTypes.MediatorFlow_3587);
        case StoreMediatorEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?StoreMediator", //$NON-NLS-1$
                    EsbElementTypes.StoreMediator_3588);
        case StoreMediatorInputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?StoreMediatorInputConnector", //$NON-NLS-1$
                    EsbElementTypes.StoreMediatorInputConnector_3589);
        case StoreMediatorOutputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?StoreMediatorOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.StoreMediatorOutputConnector_3590);
        case BuilderMediatorEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?BuilderMediator", //$NON-NLS-1$
                    EsbElementTypes.BuilderMediator_3591);
        case BuilderMediatorInputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?BuilderMediatorInputConnector", //$NON-NLS-1$
                    EsbElementTypes.BuilderMediatorInputConnector_3592);
        case BuilderMediatorOutputConectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?BuilderMediatorOutputConector", //$NON-NLS-1$
                    EsbElementTypes.BuilderMediatorOutputConector_3593);
        case CallTemplateMediatorEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?CallTemplateMediator", //$NON-NLS-1$
                    EsbElementTypes.CallTemplateMediator_3594);
        case CallTemplateMediatorInputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?CallTemplateMediatorInputConnector", //$NON-NLS-1$
                    EsbElementTypes.CallTemplateMediatorInputConnector_3595);
        case CallTemplateMediatorOutputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?CallTemplateMediatorOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.CallTemplateMediatorOutputConnector_3596);
        case PayloadFactoryMediatorEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?PayloadFactoryMediator", //$NON-NLS-1$
                    EsbElementTypes.PayloadFactoryMediator_3597);
        case PayloadFactoryMediatorInputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?PayloadFactoryMediatorInputConnector", //$NON-NLS-1$
                    EsbElementTypes.PayloadFactoryMediatorInputConnector_3598);
        case PayloadFactoryMediatorOutputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?PayloadFactoryMediatorOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.PayloadFactoryMediatorOutputConnector_3599);
        case EnqueueMediatorEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?EnqueueMediator", //$NON-NLS-1$
                    EsbElementTypes.EnqueueMediator_3600);
        case EnqueueMediatorInputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?EnqueueMediatorInputConnector", //$NON-NLS-1$
                    EsbElementTypes.EnqueueMediatorInputConnector_3601);
        case EnqueueMediatorOutputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?EnqueueMediatorOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.EnqueueMediatorOutputConnector_3602);
        case CloneMediatorContainerEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?CloneMediatorContainer", //$NON-NLS-1$
                    EsbElementTypes.CloneMediatorContainer_3603);
        case CloneTargetContainerEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?CloneTargetContainer", //$NON-NLS-1$
                    EsbElementTypes.CloneTargetContainer_3604);
        case MediatorFlow11EditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?MediatorFlow", //$NON-NLS-1$
                    EsbElementTypes.MediatorFlow_3605);
        case IterateMediatorTargetOutputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?IterateMediatorTargetOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.IterateMediatorTargetOutputConnector_3606);
        case MediatorFlow12EditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?MediatorFlow", //$NON-NLS-1$
                    EsbElementTypes.MediatorFlow_3607);
        case MediatorFlowEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?MediatorFlow", //$NON-NLS-1$
                    EsbElementTypes.MediatorFlow_3608);
        case DefaultEndPointEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?DefaultEndPoint", //$NON-NLS-1$
                    EsbElementTypes.DefaultEndPoint_3609);
        case AddressEndPointEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?AddressEndPoint", //$NON-NLS-1$
                    EsbElementTypes.AddressEndPoint_3610);
        case FailoverEndPointEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?FailoverEndPoint", //$NON-NLS-1$
                    EsbElementTypes.FailoverEndPoint_3611);
        case WSDLEndPointEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?WSDLEndPoint", //$NON-NLS-1$
                    EsbElementTypes.WSDLEndPoint_3612);
        case LoadBalanceEndPointEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?LoadBalanceEndPoint", //$NON-NLS-1$
                    EsbElementTypes.LoadBalanceEndPoint_3613);
        case SequencesEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?Sequences", //$NON-NLS-1$
                    EsbElementTypes.Sequences_3614);
        case MediatorFlow5EditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?MediatorFlow", //$NON-NLS-1$
                    EsbElementTypes.MediatorFlow_3615);
        case SequencesInputConnectorEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?SequencesInputConnector", //$NON-NLS-1$
                    EsbElementTypes.SequencesInputConnector_3616);
        case SequencesOutputConnectorEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?SequencesOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.SequencesOutputConnector_3617);
        case CacheMediatorOnHitOutputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?CacheMediatorOnHitOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.CacheMediatorOnHitOutputConnector_3618);
        case MediatorFlow13EditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?MediatorFlow", //$NON-NLS-1$
                    EsbElementTypes.MediatorFlow_3619);
        case URLRewriteMediatorEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?URLRewriteMediator", //$NON-NLS-1$
                    EsbElementTypes.URLRewriteMediator_3620);
        case URLRewriteMediatorInputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?URLRewriteMediatorInputConnector", //$NON-NLS-1$
                    EsbElementTypes.URLRewriteMediatorInputConnector_3621);
        case URLRewriteMediatorOutputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?URLRewriteMediatorOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.URLRewriteMediatorOutputConnector_3622);
        case ValidateMediatorEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?ValidateMediator", //$NON-NLS-1$
                    EsbElementTypes.ValidateMediator_3623);
        case ValidateMediatorInputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?ValidateMediatorInputConnector", //$NON-NLS-1$
                    EsbElementTypes.ValidateMediatorInputConnector_3624);
        case ValidateMediatorOutputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?ValidateMediatorOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.ValidateMediatorOutputConnector_3625);
        case ValidateMediatorOnFailOutputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?ValidateMediatorOnFailOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.ValidateMediatorOnFailOutputConnector_3626);
        case MediatorFlow14EditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?MediatorFlow", //$NON-NLS-1$
                    EsbElementTypes.MediatorFlow_3627);
        case RouterMediatorEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?RouterMediator", //$NON-NLS-1$
                    EsbElementTypes.RouterMediator_3628);
        case RouterMediatorInputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?RouterMediatorInputConnector", //$NON-NLS-1$
                    EsbElementTypes.RouterMediatorInputConnector_3629);
        case RouterMediatorOutputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?RouterMediatorOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.RouterMediatorOutputConnector_3630);
        case RouterMediatorTargetOutputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?RouterMediatorTargetOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.RouterMediatorTargetOutputConnector_3631);
        case RouterMediatorContainerEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?RouterMediatorContainer", //$NON-NLS-1$
                    EsbElementTypes.RouterMediatorContainer_3632);
        case RouterTargetContainerEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?RouterTargetContainer", //$NON-NLS-1$
                    EsbElementTypes.RouterTargetContainer_3633);
        case MediatorFlow15EditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?MediatorFlow", //$NON-NLS-1$
                    EsbElementTypes.MediatorFlow_3634);
        case ConditionalRouterMediatorEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?ConditionalRouterMediator", //$NON-NLS-1$
                    EsbElementTypes.ConditionalRouterMediator_3635);
        case ConditionalRouterMediatorInputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?ConditionalRouterMediatorInputConnector", //$NON-NLS-1$
                    EsbElementTypes.ConditionalRouterMediatorInputConnector_3636);
        case ConditionalRouterMediatorOutputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?ConditionalRouterMediatorOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.ConditionalRouterMediatorOutputConnector_3637);
        case ConditionalRouterMediatorAdditionalOutputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?ConditionalRouterMediatorAdditionalOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.ConditionalRouterMediatorAdditionalOutputConnector_3638);
        case MediatorFlow16EditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?MediatorFlow", //$NON-NLS-1$
                    EsbElementTypes.MediatorFlow_3639);
        case RuleMediatorChildMediatorsOutputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?RuleMediatorChildMediatorsOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.RuleMediatorChildMediatorsOutputConnector_3640);
        case MediatorFlow17EditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?MediatorFlow", //$NON-NLS-1$
                    EsbElementTypes.MediatorFlow_3641);
        case EndpointDiagramEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?EndpointDiagram", //$NON-NLS-1$
                    EsbElementTypes.EndpointDiagram_3642);
        case DefaultEndPoint2EditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?DefaultEndPoint", //$NON-NLS-1$
                    EsbElementTypes.DefaultEndPoint_3643);
        case DefaultEndPointInputConnector2EditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?DefaultEndPointInputConnector", //$NON-NLS-1$
                    EsbElementTypes.DefaultEndPointInputConnector_3644);
        case DefaultEndPointOutputConnector2EditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?DefaultEndPointOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.DefaultEndPointOutputConnector_3645);
        case AddressEndPoint2EditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?AddressEndPoint", //$NON-NLS-1$
                    EsbElementTypes.AddressEndPoint_3646);
        case AddressEndPointInputConnector2EditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?AddressEndPointInputConnector", //$NON-NLS-1$
                    EsbElementTypes.AddressEndPointInputConnector_3647);
        case AddressEndPointOutputConnector2EditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?AddressEndPointOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.AddressEndPointOutputConnector_3648);
        case FailoverEndPoint2EditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?FailoverEndPoint", //$NON-NLS-1$
                    EsbElementTypes.FailoverEndPoint_3649);
        case FailoverEndPointInputConnector2EditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?FailoverEndPointInputConnector", //$NON-NLS-1$
                    EsbElementTypes.FailoverEndPointInputConnector_3650);
        case FailoverEndPointOutputConnector2EditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?FailoverEndPointOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.FailoverEndPointOutputConnector_3651);
        case FailoverEndPointWestOutputConnector2EditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?FailoverEndPointWestOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.FailoverEndPointWestOutputConnector_3652);
        case WSDLEndPoint2EditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?WSDLEndPoint", //$NON-NLS-1$
                    EsbElementTypes.WSDLEndPoint_3653);
        case WSDLEndPointInputConnector2EditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?WSDLEndPointInputConnector", //$NON-NLS-1$
                    EsbElementTypes.WSDLEndPointInputConnector_3654);
        case WSDLEndPointOutputConnector2EditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?WSDLEndPointOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.WSDLEndPointOutputConnector_3655);
        case LoadBalanceEndPoint2EditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?LoadBalanceEndPoint", //$NON-NLS-1$
                    EsbElementTypes.LoadBalanceEndPoint_3656);
        case LoadBalanceEndPointInputConnector2EditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?LoadBalanceEndPointInputConnector", //$NON-NLS-1$
                    EsbElementTypes.LoadBalanceEndPointInputConnector_3657);
        case LoadBalanceEndPointOutputConnector2EditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?LoadBalanceEndPointOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.LoadBalanceEndPointOutputConnector_3658);
        case LoadBalanceEndPointWestOutputConnector2EditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?LoadBalanceEndPointWestOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.LoadBalanceEndPointWestOutputConnector_3659);
        case NamedEndpointEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?NamedEndpoint", //$NON-NLS-1$
                    EsbElementTypes.NamedEndpoint_3660);
        case NamedEndpointInputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?NamedEndpointInputConnector", //$NON-NLS-1$
                    EsbElementTypes.NamedEndpointInputConnector_3661);
        case NamedEndpointOutputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?NamedEndpointOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.NamedEndpointOutputConnector_3662);
        case LocalEntryEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?LocalEntry", //$NON-NLS-1$
                    EsbElementTypes.LocalEntry_3663);
        case TemplateEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?Template", //$NON-NLS-1$
                    EsbElementTypes.Template_3664);
        case Sequences2EditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?Sequences", //$NON-NLS-1$
                    EsbElementTypes.Sequences_3665);
        case EndpointDiagram2EditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?EndpointDiagram", //$NON-NLS-1$
                    EsbElementTypes.EndpointDiagram_3666);
        case TaskEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?Task", //$NON-NLS-1$
                    EsbElementTypes.Task_3667);
        case SynapseAPIEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?SynapseAPI", //$NON-NLS-1$
                    EsbElementTypes.SynapseAPI_3668);
        case APIResourceEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?APIResource", //$NON-NLS-1$
                    EsbElementTypes.APIResource_3669);
        case APIResourceInputConnectorEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?APIResourceInputConnector", //$NON-NLS-1$
                    EsbElementTypes.APIResourceInputConnector_3670);
        case APIResourceOutputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?APIResourceOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.APIResourceOutputConnector_3671);
        case APIResourceFaultInputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?APIResourceFaultInputConnector", //$NON-NLS-1$
                    EsbElementTypes.APIResourceFaultInputConnector_3672);
        case ProxyServiceContainer2EditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?ProxyServiceContainer", //$NON-NLS-1$
                    EsbElementTypes.ProxyServiceContainer_3673);
        case APIResourceEndpointEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?APIResourceEndpoint", //$NON-NLS-1$
                    EsbElementTypes.APIResourceEndpoint_3674);
        case APIResourceEndpointInputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?APIResourceEndpointInputConnector", //$NON-NLS-1$
                    EsbElementTypes.APIResourceEndpointInputConnector_3675);
        case APIResourceEndpointOutputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?APIResourceEndpointOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.APIResourceEndpointOutputConnector_3676);
        case ComplexEndpointsEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?ComplexEndpoints", //$NON-NLS-1$
                    EsbElementTypes.ComplexEndpoints_3677);
        case MediatorFlow18EditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?MediatorFlow", //$NON-NLS-1$
                    EsbElementTypes.MediatorFlow_3678);
        case ComplexEndpointsOutputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?ComplexEndpointsOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.ComplexEndpointsOutputConnector_3679);
        case BAMMediatorEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?BAMMediator", //$NON-NLS-1$
                    EsbElementTypes.BAMMediator_3680);
        case BAMMediatorInputConnectorEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?BAMMediatorInputConnector", //$NON-NLS-1$
                    EsbElementTypes.BAMMediatorInputConnector_3681);
        case BAMMediatorOutputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?BAMMediatorOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.BAMMediatorOutputConnector_3682);
        case BeanMediatorEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?BeanMediator", //$NON-NLS-1$
                    EsbElementTypes.BeanMediator_3683);
        case BeanMediatorInputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?BeanMediatorInputConnector", //$NON-NLS-1$
                    EsbElementTypes.BeanMediatorInputConnector_3684);
        case BeanMediatorOutputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?BeanMediatorOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.BeanMediatorOutputConnector_3685);
        case EJBMediatorEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?EJBMediator", //$NON-NLS-1$
                    EsbElementTypes.EJBMediator_3686);
        case EJBMediatorInputConnectorEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?EJBMediatorInputConnector", //$NON-NLS-1$
                    EsbElementTypes.EJBMediatorInputConnector_3687);
        case EJBMediatorOutputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?EJBMediatorOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.EJBMediatorOutputConnector_3688);
        case AddressingEndpointEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?AddressingEndpoint", //$NON-NLS-1$
                    EsbElementTypes.AddressingEndpoint_3689);
        case AddressingEndpointInputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?AddressingEndpointInputConnector", //$NON-NLS-1$
                    EsbElementTypes.AddressingEndpointInputConnector_3690);
        case AddressingEndpointOutputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?AddressingEndpointOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.AddressingEndpointOutputConnector_3691);
        case RecipientListEndPointEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?RecipientListEndPoint", //$NON-NLS-1$
                    EsbElementTypes.RecipientListEndPoint_3692);
        case RecipientListEndPointInputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?RecipientListEndPointInputConnector", //$NON-NLS-1$
                    EsbElementTypes.RecipientListEndPointInputConnector_3693);
        case RecipientListEndPointOutputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?RecipientListEndPointOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.RecipientListEndPointOutputConnector_3694);
        case RecipientListEndPointWestOutputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?RecipientListEndPointWestOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.RecipientListEndPointWestOutputConnector_3695);
        case RecipientListEndPoint2EditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?RecipientListEndPoint", //$NON-NLS-1$
                    EsbElementTypes.RecipientListEndPoint_3696);
        case RecipientListEndPointInputConnector2EditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?RecipientListEndPointInputConnector", //$NON-NLS-1$
                    EsbElementTypes.RecipientListEndPointInputConnector_3697);
        case RecipientListEndPointOutputConnector2EditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?RecipientListEndPointOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.RecipientListEndPointOutputConnector_3698);
        case RecipientListEndPointWestOutputConnector2EditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?RecipientListEndPointWestOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.RecipientListEndPointWestOutputConnector_3699);
        case MessageProcessorEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?MessageProcessor", //$NON-NLS-1$
                    EsbElementTypes.MessageProcessor_3701);
        case HTTPEndpointEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?HTTPEndpoint", //$NON-NLS-1$
                    EsbElementTypes.HTTPEndpoint_3709);
        case HTTPEndPointInputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?HTTPEndPointInputConnector", //$NON-NLS-1$
                    EsbElementTypes.HTTPEndPointInputConnector_3710);
        case HTTPEndPointOutputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?HTTPEndPointOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.HTTPEndPointOutputConnector_3711);
        case HTTPEndpoint2EditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?HTTPEndpoint", //$NON-NLS-1$
                    EsbElementTypes.HTTPEndpoint_3712);
        case HTTPEndPointInputConnector2EditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?HTTPEndPointInputConnector", //$NON-NLS-1$
                    EsbElementTypes.HTTPEndPointInputConnector_3713);
        case HTTPEndPointOutputConnector2EditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?HTTPEndPointOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.HTTPEndPointOutputConnector_3714);
        case MessageStoreEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?MessageStore", //$NON-NLS-1$
                    EsbElementTypes.MessageStore_3715);
        case TemplateEndpointEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?TemplateEndpoint", //$NON-NLS-1$
                    EsbElementTypes.TemplateEndpoint_3716);
        case TemplateEndpointInputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?TemplateEndpointInputConnector", //$NON-NLS-1$
                    EsbElementTypes.TemplateEndpointInputConnector_3717);
        case TemplateEndpointOutputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?TemplateEndpointOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.TemplateEndpointOutputConnector_3718);
        case CloudConnectorEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?CloudConnector", //$NON-NLS-1$
                    EsbElementTypes.CloudConnector_3719);
        case CloudConnectorInputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?CloudConnectorInputConnector", //$NON-NLS-1$
                    EsbElementTypes.CloudConnectorInputConnector_3720);
        case CloudConnectorOutputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?CloudConnectorOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.CloudConnectorOutputConnector_3721);
        case CloudConnectorOperationEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?CloudConnectorOperation", //$NON-NLS-1$
                    EsbElementTypes.CloudConnectorOperation_3722);
        case CloudConnectorOperationInputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?CloudConnectorOperationInputConnector", //$NON-NLS-1$
                    EsbElementTypes.CloudConnectorOperationInputConnector_3723);
        case CloudConnectorOperationOutputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?CloudConnectorOperationOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.CloudConnectorOperationOutputConnector_3724);
        case TemplateEndpoint2EditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?TemplateEndpoint", //$NON-NLS-1$
                    EsbElementTypes.TemplateEndpoint_3725);
        case TemplateEndpointInputConnector2EditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?TemplateEndpointInputConnector", //$NON-NLS-1$
                    EsbElementTypes.TemplateEndpointInputConnector_3726);
        case TemplateEndpointOutputConnector2EditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?TemplateEndpointOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.TemplateEndpointOutputConnector_3727);
        case MediatorFlow19EditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?MediatorFlow", //$NON-NLS-1$
                    EsbElementTypes.MediatorFlow_3728);
        case ProxyOutSequenceOutputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?ProxyOutSequenceOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.ProxyOutSequenceOutputConnector_3729);
        case APIResourceOutSequenceOutputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?APIResourceOutSequenceOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.APIResourceOutSequenceOutputConnector_3730);
        case ProxyInSequenceInputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?ProxyInSequenceInputConnector", //$NON-NLS-1$
                    EsbElementTypes.ProxyInSequenceInputConnector_3731);
        case SwitchCaseParentContainerEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?SwitchCaseParentContainer", //$NON-NLS-1$
                    EsbElementTypes.SwitchCaseParentContainer_3732);
        case SwitchCaseContainerEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?SwitchCaseContainer", //$NON-NLS-1$
                    EsbElementTypes.SwitchCaseContainer_3733);
        case SwitchDefaultParentContainerEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?SwitchDefaultParentContainer", //$NON-NLS-1$
                    EsbElementTypes.SwitchDefaultParentContainer_3734);
        case SwitchDefaultContainerEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?SwitchDefaultContainer", //$NON-NLS-1$
                    EsbElementTypes.SwitchDefaultContainer_3735);
        case LoopBackMediatorEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?LoopBackMediator", //$NON-NLS-1$
                    EsbElementTypes.LoopBackMediator_3736);
        case LoopBackMediatorInputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?LoopBackMediatorInputConnector", //$NON-NLS-1$
                    EsbElementTypes.LoopBackMediatorInputConnector_3737);
        case LoopBackMediatorOutputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?LoopBackMediatorOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.LoopBackMediatorOutputConnector_3738);
        case RespondMediatorEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?RespondMediator", //$NON-NLS-1$
                    EsbElementTypes.RespondMediator_3739);
        case RespondMediatorInputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?RespondMediatorInputConnector", //$NON-NLS-1$
                    EsbElementTypes.RespondMediatorInputConnector_3740);
        case RespondMediatorOutputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?RespondMediatorOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.RespondMediatorOutputConnector_3741);
        case CallMediatorEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?CallMediator", //$NON-NLS-1$
                    EsbElementTypes.CallMediator_3742);
        case CallMediatorInputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?CallMediatorInputConnector", //$NON-NLS-1$
                    EsbElementTypes.CallMediatorInputConnector_3743);
        case CallMediatorOutputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?CallMediatorOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.CallMediatorOutputConnector_3744);
        case CallMediatorEndpointOutputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?CallMediatorEndpointOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.CallMediatorEndpointOutputConnector_3745);
        case MediatorFlow20EditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?MediatorFlow", //$NON-NLS-1$
                    EsbElementTypes.MediatorFlow_3746);
        case APIResourceInSequenceInputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?APIResourceInSequenceInputConnector", //$NON-NLS-1$
                    EsbElementTypes.APIResourceInSequenceInputConnector_3747);
        case EntitlementMediatorOnRejectOutputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?EntitlementMediatorOnRejectOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.EntitlementMediatorOnRejectOutputConnector_3748);
        case EntitlementMediatorOnAcceptOutputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?EntitlementMediatorOnAcceptOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.EntitlementMediatorOnAcceptOutputConnector_3749);
        case EntitlementMediatorAdviceOutputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?EntitlementMediatorAdviceOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.EntitlementMediatorAdviceOutputConnector_3750);
        case EntitlementMediatorObligationsOutputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?EntitlementMediatorObligationsOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.EntitlementMediatorObligationsOutputConnector_3751);
        case EntitlementContainerEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?EntitlementContainer", //$NON-NLS-1$
                    EsbElementTypes.EntitlementContainer_3752);
        case EntitlementOnRejectContainerEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?EntitlementOnRejectContainer", //$NON-NLS-1$
                    EsbElementTypes.EntitlementOnRejectContainer_3753);
        case MediatorFlow21EditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?MediatorFlow", //$NON-NLS-1$
                    EsbElementTypes.MediatorFlow_3754);
        case EntitlementOnAcceptContainerEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?EntitlementOnAcceptContainer", //$NON-NLS-1$
                    EsbElementTypes.EntitlementOnAcceptContainer_3755);
        case MediatorFlow22EditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?MediatorFlow", //$NON-NLS-1$
                    EsbElementTypes.MediatorFlow_3756);
        case EntitlementAdviceContainerEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?EntitlementAdviceContainer", //$NON-NLS-1$
                    EsbElementTypes.EntitlementAdviceContainer_3757);
        case MediatorFlow23EditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?MediatorFlow", //$NON-NLS-1$
                    EsbElementTypes.MediatorFlow_3758);
        case EntitlementObligationsContainerEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?EntitlementObligationsContainer", //$NON-NLS-1$
                    EsbElementTypes.EntitlementObligationsContainer_3759);
        case MediatorFlow24EditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?MediatorFlow", //$NON-NLS-1$
                    EsbElementTypes.MediatorFlow_3760);
        case DataMapperMediatorEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?DataMapperMediator", //$NON-NLS-1$
                    EsbElementTypes.DataMapperMediator_3761);
        case DataMapperMediatorInputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?DataMapperMediatorInputConnector", //$NON-NLS-1$
                    EsbElementTypes.DataMapperMediatorInputConnector_3762);
        case DataMapperMediatorOutputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?DataMapperMediatorOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.DataMapperMediatorOutputConnector_3763);
        case FastXSLTMediatorEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?FastXSLTMediator", //$NON-NLS-1$
                    EsbElementTypes.FastXSLTMediator_3764);
        case FastXSLTMediatorInputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?FastXSLTMediatorInputConnector", //$NON-NLS-1$
                    EsbElementTypes.FastXSLTMediatorInputConnector_3765);
        case FastXSLTMediatorOutputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?FastXSLTMediatorOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.FastXSLTMediatorOutputConnector_3766);
        case InboundEndpointEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?InboundEndpoint", //$NON-NLS-1$
                    EsbElementTypes.InboundEndpoint_3767);
        case InboundEndpointSequenceInputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?InboundEndpointSequenceInputConnector", //$NON-NLS-1$
                    EsbElementTypes.InboundEndpointSequenceInputConnector_3768);
        case InboundEndpointSequenceOutputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?InboundEndpointSequenceOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.InboundEndpointSequenceOutputConnector_3769);
        case InboundEndpointOnErrorSequenceInputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?InboundEndpointOnErrorSequenceInputConnector", //$NON-NLS-1$
                    EsbElementTypes.InboundEndpointOnErrorSequenceInputConnector_3770);
        case InboundEndpointOnErrorSequenceOutputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?InboundEndpointOnErrorSequenceOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.InboundEndpointOnErrorSequenceOutputConnector_3771);
        case InboundEndpointContainerEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?InboundEndpointContainer", //$NON-NLS-1$
                    EsbElementTypes.InboundEndpointContainer_3772);
        case InboundEndpointSequenceContainerEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?InboundEndpointSequenceContainer", //$NON-NLS-1$
                    EsbElementTypes.InboundEndpointSequenceContainer_3773);
        case MediatorFlow25EditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?MediatorFlow", //$NON-NLS-1$
                    EsbElementTypes.MediatorFlow_3774);
        case InboundEndpointOnErrorSequenceContainerEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?InboundEndpointOnErrorSequenceContainer", //$NON-NLS-1$
                    EsbElementTypes.InboundEndpointOnErrorSequenceContainer_3775);
        case MediatorFlow26EditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?MediatorFlow", //$NON-NLS-1$
                    EsbElementTypes.MediatorFlow_3776);
        case MediatorFlow27EditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?MediatorFlow", //$NON-NLS-1$
                    EsbElementTypes.MediatorFlow_3777);
        case MediatorFlow28EditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?MediatorFlow", //$NON-NLS-1$
                    EsbElementTypes.MediatorFlow_3778);
        case MediatorFlow29EditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?MediatorFlow", //$NON-NLS-1$
                    EsbElementTypes.MediatorFlow_3779);
        case ForEachMediatorEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?ForEachMediator", //$NON-NLS-1$
                    EsbElementTypes.ForEachMediator_3780);
        case ForEachMediatorInputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?ForEachMediatorInputConnector", //$NON-NLS-1$
                    EsbElementTypes.ForEachMediatorInputConnector_3781);
        case ForEachMediatorOutputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?ForEachMediatorOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.ForEachMediatorOutputConnector_3782);
        case ForEachMediatorTargetOutputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?ForEachMediatorTargetOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.ForEachMediatorTargetOutputConnector_3783);
        case MediatorFlow30EditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?MediatorFlow", //$NON-NLS-1$
                    EsbElementTypes.MediatorFlow_3784);
        case PublishEventMediatorEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?PublishEventMediator", //$NON-NLS-1$
                    EsbElementTypes.PublishEventMediator_3785);
        case PublishEventMediatorInputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?PublishEventMediatorInputConnector", //$NON-NLS-1$
                    EsbElementTypes.PublishEventMediatorInputConnector_3786);
        case PublishEventMediatorOutputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?PublishEventMediatorOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.PublishEventMediatorOutputConnector_3787);
        case PropertyGroupMediatorEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?PropertyGroupMediator", //$NON-NLS-1$
                    EsbElementTypes.PropertyGroupMediator_3788);
        case PropertyGroupMediatorInputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?PropertyGroupMediatorInputConnector", //$NON-NLS-1$
                    EsbElementTypes.PropertyGroupMediatorInputConnector_3789);
        case PropertyGroupMediatorOutputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?PropertyGroupMediatorOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.PropertyGroupMediatorOutputConnector_3790);
        case JsonTransformMediatorEditPart.VISUAL_ID:
            return getImage("Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?JsonTransformMediator", //$NON-NLS-1$
                    EsbElementTypes.JsonTransformMediator_3791);
        case JsonTransformMediatorInputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?JsonTransformMediatorInputConnector", //$NON-NLS-1$
                    EsbElementTypes.JsonTransformMediatorInputConnector_3792);
        case JsonTransformMediatorOutputConnectorEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http:///org/wso2/developerstudio/eclipse/gmf/esb?JsonTransformMediatorOutputConnector", //$NON-NLS-1$
                    EsbElementTypes.JsonTransformMediatorOutputConnector_3793);
        case EsbLinkEditPart.VISUAL_ID:
            return getImage("Navigator?Link?http:///org/wso2/developerstudio/eclipse/gmf/esb?EsbLink", //$NON-NLS-1$
                    EsbElementTypes.EsbLink_4001);
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
        case PropertyGroupMediatorEditPart.VISUAL_ID:
            return getPropertyGroupMediator_3788Text(view);
        case PropertyGroupMediatorInputConnectorEditPart.VISUAL_ID:
            return getPropertyGroupMediatorInputConnector_3789Text(view);
        case PropertyGroupMediatorOutputConnectorEditPart.VISUAL_ID:
            return getPropertyGroupMediatorOutputConnector_3790Text(view);
        case JsonTransformMediatorEditPart.VISUAL_ID:
            return getJsonTransformMediator_3791Text(view);
        case JsonTransformMediatorInputConnectorEditPart.VISUAL_ID:
            return getJsonTransformMediatorInputConnector_3792Text(view);
        case JsonTransformMediatorOutputConnectorEditPart.VISUAL_ID:
            return getJsonTransformMediatorOutputConnector_3793Text(view);
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
    private String getPropertyGroupMediator_3788Text(View view) {
        IParser parser = EsbParserProvider.getParser(EsbElementTypes.PropertyGroupMediator_3788,
                view.getElement() != null ? view.getElement() : view,
                EsbVisualIDRegistry.getType(PropertyGroupMediatorDescriptionEditPart.VISUAL_ID));
        if (parser != null) {
            return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
                    ParserOptions.NONE.intValue());
        } else {
            EsbDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5215); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
    * @generated
    */
    private String getPropertyGroupMediatorInputConnector_3789Text(View view) {
        return ""; //$NON-NLS-1$
    }

    /**
    * @generated
    */
    private String getPropertyGroupMediatorOutputConnector_3790Text(View view) {
        return ""; //$NON-NLS-1$
    }

    /**
    * @generated
    */
    private String getJsonTransformMediator_3791Text(View view) {
        IParser parser = EsbParserProvider.getParser(EsbElementTypes.JsonTransformMediator_3791,
                view.getElement() != null ? view.getElement() : view,
                EsbVisualIDRegistry.getType(JsonTransformMediatorDescriptionEditPart.VISUAL_ID));
        if (parser != null) {
            return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
                    ParserOptions.NONE.intValue());
        } else {
            EsbDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5216); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
    * @generated
    */
    private String getJsonTransformMediatorInputConnector_3792Text(View view) {
        return ""; //$NON-NLS-1$
    }

    /**
    * @generated
    */
    private String getJsonTransformMediatorOutputConnector_3793Text(View view) {
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
        CacheMediator domainModelElement = (CacheMediator) view.getElement();
        if (domainModelElement != null) {
            return domainModelElement.getDescription();
        } else {
            EsbDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3518); //$NON-NLS-1$
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
