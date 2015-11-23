package org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers;

import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.tooling.runtime.providers.DiagramElementTypeImages;
import org.eclipse.gmf.tooling.runtime.providers.DiagramElementTypes;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.*;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbDiagramEditorPlugin;

/**
 * @generated
 */
public class EsbElementTypes {

	/**
	 * @generated
	 */
	private EsbElementTypes() {
	}

	/**
	 * @generated
	 */
	private static Map<IElementType, ENamedElement> elements;

	/**
	 * @generated
	 */
	private static DiagramElementTypeImages elementTypeImages = new DiagramElementTypeImages(EsbDiagramEditorPlugin
			.getInstance().getItemProvidersAdapterFactory());

	/**
	 * @generated
	 */
	private static Set<IElementType> KNOWN_ELEMENT_TYPES;

	/**
	 * @generated
	 */
	public static final IElementType EsbDiagram_1000 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.EsbDiagram_1000"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType EsbServer_2001 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.EsbServer_2001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType ProxyService_3001 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.ProxyService_3001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ProxyOutputConnector_3002 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.ProxyOutputConnector_3002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ProxyInputConnector_3003 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.ProxyInputConnector_3003"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ProxyFaultInputConnector_3489 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.ProxyFaultInputConnector_3489"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ProxyInSequenceInputConnector_3731 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.ProxyInSequenceInputConnector_3731"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ProxyServiceContainer_3486 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.ProxyServiceContainer_3486"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ProxyServiceSequenceAndEndpointContainer_3487 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.ProxyServiceSequenceAndEndpointContainer_3487"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType MediatorFlow_3608 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.MediatorFlow_3608"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType DropMediator_3491 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.DropMediator_3491"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType MessageMediator_3045 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.MessageMediator_3045"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType MessageInputConnector_3046 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.MessageInputConnector_3046"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType MessageOutputConnector_3047 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.MessageOutputConnector_3047"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType DropMediatorInputConnector_3008 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.DropMediatorInputConnector_3008"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType PropertyMediator_3492 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.PropertyMediator_3492"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType FilterMediatorInputConnector_3010 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.FilterMediatorInputConnector_3010"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType FilterMediatorOutputConnector_3534 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.FilterMediatorOutputConnector_3534"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType FilterMediatorPassOutputConnector_3011 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.FilterMediatorPassOutputConnector_3011"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType FilterMediatorFailOutputConnector_3012 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.FilterMediatorFailOutputConnector_3012"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType FilterContainer_3531 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.FilterContainer_3531"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType FilterPassContainer_3535 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.FilterPassContainer_3535"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType MediatorFlow_3536 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.MediatorFlow_3536"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType LogMediator_3495 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.LogMediator_3495"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType MergeNode_3013 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.MergeNode_3013"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType MergeNodeFirstInputConnector_3014 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.MergeNodeFirstInputConnector_3014"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType MergeNodeSecondInputConnector_3015 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.MergeNodeSecondInputConnector_3015"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType MergeNodeOutputConnector_3016 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.MergeNodeOutputConnector_3016"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Sequences_3614 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.Sequences_3614"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType MediatorFlow_3615 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.MediatorFlow_3615"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType SequencesInputConnector_3616 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.SequencesInputConnector_3616"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType SequencesOutputConnector_3617 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.SequencesOutputConnector_3617"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType EndpointDiagram_3642 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.EndpointDiagram_3642"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType DefaultEndPoint_3643 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.DefaultEndPoint_3643"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType DefaultEndPointInputConnector_3644 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.DefaultEndPointInputConnector_3644"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType DefaultEndPointOutputConnector_3645 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.DefaultEndPointOutputConnector_3645"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType AddressEndPoint_3646 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.AddressEndPoint_3646"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType AddressEndPointInputConnector_3647 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.AddressEndPointInputConnector_3647"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType AddressEndPointOutputConnector_3648 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.AddressEndPointOutputConnector_3648"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType FailoverEndPoint_3649 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.FailoverEndPoint_3649"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType FailoverEndPointInputConnector_3650 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.FailoverEndPointInputConnector_3650"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType FailoverEndPointOutputConnector_3651 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.FailoverEndPointOutputConnector_3651"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType FailoverEndPointWestOutputConnector_3652 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.FailoverEndPointWestOutputConnector_3652"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType MediatorFlow_3777 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.MediatorFlow_3777"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType RecipientListEndPoint_3696 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.RecipientListEndPoint_3696"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType RecipientListEndPointInputConnector_3697 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.RecipientListEndPointInputConnector_3697"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType RecipientListEndPointOutputConnector_3698 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.RecipientListEndPointOutputConnector_3698"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType RecipientListEndPointWestOutputConnector_3699 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.RecipientListEndPointWestOutputConnector_3699"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType MediatorFlow_3778 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.MediatorFlow_3778"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType WSDLEndPoint_3653 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.WSDLEndPoint_3653"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType WSDLEndPointInputConnector_3654 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.WSDLEndPointInputConnector_3654"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType WSDLEndPointOutputConnector_3655 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.WSDLEndPointOutputConnector_3655"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType LoadBalanceEndPoint_3656 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.LoadBalanceEndPoint_3656"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType LoadBalanceEndPointInputConnector_3657 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.LoadBalanceEndPointInputConnector_3657"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType LoadBalanceEndPointOutputConnector_3658 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.LoadBalanceEndPointOutputConnector_3658"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType LoadBalanceEndPointWestOutputConnector_3659 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.LoadBalanceEndPointWestOutputConnector_3659"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType MediatorFlow_3779 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.MediatorFlow_3779"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType HTTPEndpoint_3712 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.HTTPEndpoint_3712"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType HTTPEndPointInputConnector_3713 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.HTTPEndPointInputConnector_3713"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType HTTPEndPointOutputConnector_3714 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.HTTPEndPointOutputConnector_3714"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType TemplateEndpoint_3725 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.TemplateEndpoint_3725"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType TemplateEndpointInputConnector_3726 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.TemplateEndpointInputConnector_3726"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType TemplateEndpointOutputConnector_3727 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.TemplateEndpointOutputConnector_3727"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType LocalEntry_3663 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.LocalEntry_3663"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Template_3664 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.Template_3664"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Sequences_3665 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.Sequences_3665"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType EndpointDiagram_3666 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.EndpointDiagram_3666"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Task_3667 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.Task_3667"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType SynapseAPI_3668 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.SynapseAPI_3668"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType APIResource_3669 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.APIResource_3669"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType APIResourceInputConnector_3670 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.APIResourceInputConnector_3670"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType APIResourceOutputConnector_3671 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.APIResourceOutputConnector_3671"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType APIResourceOutSequenceOutputConnector_3730 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.APIResourceOutSequenceOutputConnector_3730"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType APIResourceFaultInputConnector_3672 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.APIResourceFaultInputConnector_3672"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ProxyServiceContainer_3673 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.ProxyServiceContainer_3673"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType APIResourceInSequenceInputConnector_3747 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.APIResourceInSequenceInputConnector_3747"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ComplexEndpoints_3677 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.ComplexEndpoints_3677"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType MediatorFlow_3678 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.MediatorFlow_3678"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ComplexEndpointsOutputConnector_3679 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.ComplexEndpointsOutputConnector_3679"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType MessageStore_3715 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.MessageStore_3715"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType MessageProcessor_3701 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.MessageProcessor_3701"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType InboundEndpoint_3767 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.InboundEndpoint_3767"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType InboundEndpointSequenceInputConnector_3768 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.InboundEndpointSequenceInputConnector_3768"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType InboundEndpointSequenceOutputConnector_3769 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.InboundEndpointSequenceOutputConnector_3769"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType InboundEndpointOnErrorSequenceInputConnector_3770 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.InboundEndpointOnErrorSequenceInputConnector_3770"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType InboundEndpointOnErrorSequenceOutputConnector_3771 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.InboundEndpointOnErrorSequenceOutputConnector_3771"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType InboundEndpointContainer_3772 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.InboundEndpointContainer_3772"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType InboundEndpointSequenceContainer_3773 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.InboundEndpointSequenceContainer_3773"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType MediatorFlow_3774 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.MediatorFlow_3774"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType InboundEndpointOnErrorSequenceContainer_3775 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.InboundEndpointOnErrorSequenceContainer_3775"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType MediatorFlow_3776 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.MediatorFlow_3776"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType LogMediatorInputConnector_3018 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.LogMediatorInputConnector_3018"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType LogMediatorOutputConnector_3019 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.LogMediatorOutputConnector_3019"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType EnrichMediator_3496 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.EnrichMediator_3496"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType PropertyMediatorInputConnector_3033 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.PropertyMediatorInputConnector_3033"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType PropertyMediatorOutputConnector_3034 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.PropertyMediatorOutputConnector_3034"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ThrottleMediator_3493 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.ThrottleMediator_3493"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType EnrichMediatorInputConnector_3036 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.EnrichMediatorInputConnector_3036"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType EnrichMediatorOutputConnector_3037 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.EnrichMediatorOutputConnector_3037"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType XSLTMediator_3497 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.XSLTMediator_3497"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType XSLTMediatorInputConnector_3039 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.XSLTMediatorInputConnector_3039"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType XSLTMediatorOutputConnector_3040 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.XSLTMediatorOutputConnector_3040"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType SwitchMediator_3498 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.SwitchMediator_3498"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType SwitchMediatorInputConnector_3042 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.SwitchMediatorInputConnector_3042"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType SwitchCaseBranchOutputConnector_3043 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.SwitchCaseBranchOutputConnector_3043"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType SwitchDefaultBranchOutputConnector_3044 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.SwitchDefaultBranchOutputConnector_3044"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType SwitchMediatorOutputConnector_3499 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.SwitchMediatorOutputConnector_3499"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType SwitchMediatorContainer_3500 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.SwitchMediatorContainer_3500"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType SwitchCaseParentContainer_3732 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.SwitchCaseParentContainer_3732"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType SwitchCaseContainer_3733 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.SwitchCaseContainer_3733"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType MediatorFlow_3502 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.MediatorFlow_3502"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Sequence_3503 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.Sequence_3503"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType SequenceInputConnector_3049 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.SequenceInputConnector_3049"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType SequenceOutputConnector_3050 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.SequenceOutputConnector_3050"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType EventMediator_3504 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.EventMediator_3504"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType EventMediatorInputConnector_3052 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.EventMediatorInputConnector_3052"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType EventMediatorOutputConnector_3053 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.EventMediatorOutputConnector_3053"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType EntitlementMediator_3505 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.EntitlementMediator_3505"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType EntitlementMediatorInputConnector_3055 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.EntitlementMediatorInputConnector_3055"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType EntitlementMediatorOutputConnector_3056 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.EntitlementMediatorOutputConnector_3056"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType EntitlementMediatorOnRejectOutputConnector_3748 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.EntitlementMediatorOnRejectOutputConnector_3748"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType EntitlementMediatorOnAcceptOutputConnector_3749 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.EntitlementMediatorOnAcceptOutputConnector_3749"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType EntitlementMediatorAdviceOutputConnector_3750 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.EntitlementMediatorAdviceOutputConnector_3750"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType EntitlementMediatorObligationsOutputConnector_3751 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.EntitlementMediatorObligationsOutputConnector_3751"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType EntitlementContainer_3752 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.EntitlementContainer_3752"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType EntitlementOnRejectContainer_3753 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.EntitlementOnRejectContainer_3753"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType MediatorFlow_3754 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.MediatorFlow_3754"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ClassMediator_3506 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.ClassMediator_3506"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ClassMediatorInputConnector_3058 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.ClassMediatorInputConnector_3058"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ClassMediatorOutputConnector_3059 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.ClassMediatorOutputConnector_3059"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType SpringMediator_3507 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.SpringMediator_3507"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType SpringMediatorInputConnector_3061 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.SpringMediatorInputConnector_3061"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType SpringMediatorOutputConnector_3062 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.SpringMediatorOutputConnector_3062"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ScriptMediator_3508 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.ScriptMediator_3508"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ScriptMediatorInputConnector_3064 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.ScriptMediatorInputConnector_3064"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ScriptMediatorOutputConnector_3065 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.ScriptMediatorOutputConnector_3065"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType FaultMediator_3509 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.FaultMediator_3509"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType FaultMediatorInputConnector_3067 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.FaultMediatorInputConnector_3067"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType FaultMediatorOutputConnector_3068 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.FaultMediatorOutputConnector_3068"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType XQueryMediator_3510 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.XQueryMediator_3510"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType XQueryMediatorInputConnector_3070 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.XQueryMediatorInputConnector_3070"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType XQueryMediatorOutputConnector_3071 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.XQueryMediatorOutputConnector_3071"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType CommandMediator_3511 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.CommandMediator_3511"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType CommandMediatorInputConnector_3073 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.CommandMediatorInputConnector_3073"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType CommandMediatorOutputConnector_3074 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.CommandMediatorOutputConnector_3074"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType DBLookupMediator_3512 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.DBLookupMediator_3512"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType DBLookupMediatorInputConnector_3076 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.DBLookupMediatorInputConnector_3076"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType DBLookupMediatorOutputConnector_3077 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.DBLookupMediatorOutputConnector_3077"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType DBReportMediator_3513 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.DBReportMediator_3513"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType DBReportMediatorInputConnector_3079 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.DBReportMediatorInputConnector_3079"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType DBReportMediatorOutputConnector_3080 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.DBReportMediatorOutputConnector_3080"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType SmooksMediator_3514 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.SmooksMediator_3514"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType SmooksMediatorInputConnector_3082 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.SmooksMediatorInputConnector_3082"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType SmooksMediatorOutputConnector_3083 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.SmooksMediatorOutputConnector_3083"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType SendMediator_3515 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.SendMediator_3515"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType SendMediatorInputConnector_3085 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.SendMediatorInputConnector_3085"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType SendMediatorOutputConnector_3086 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.SendMediatorOutputConnector_3086"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType SendMediatorEndpointOutputConnector_3539 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.SendMediatorEndpointOutputConnector_3539"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType MediatorFlow_3728 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.MediatorFlow_3728"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType HeaderMediator_3516 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.HeaderMediator_3516"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType FailoverEndPointInputConnector_3088 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.FailoverEndPointInputConnector_3088"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType FailoverEndPointOutputConnector_3090 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.FailoverEndPointOutputConnector_3090"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType FailoverEndPointWestOutputConnector_3097 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.FailoverEndPointWestOutputConnector_3097"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType RecipientListEndPoint_3692 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.RecipientListEndPoint_3692"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType RecipientListEndPointInputConnector_3693 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.RecipientListEndPointInputConnector_3693"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType RecipientListEndPointOutputConnector_3694 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.RecipientListEndPointOutputConnector_3694"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType RecipientListEndPointWestOutputConnector_3695 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.RecipientListEndPointWestOutputConnector_3695"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType WSDLEndPoint_3612 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.WSDLEndPoint_3612"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType WSDLEndPointInputConnector_3092 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.WSDLEndPointInputConnector_3092"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType WSDLEndPointOutputConnector_3093 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.WSDLEndPointOutputConnector_3093"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType NamedEndpoint_3660 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.NamedEndpoint_3660"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType NamedEndpointInputConnector_3661 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.NamedEndpointInputConnector_3661"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType NamedEndpointOutputConnector_3662 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.NamedEndpointOutputConnector_3662"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType LoadBalanceEndPoint_3613 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.LoadBalanceEndPoint_3613"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType LoadBalanceEndPointInputConnector_3095 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.LoadBalanceEndPointInputConnector_3095"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType LoadBalanceEndPointOutputConnector_3096 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.LoadBalanceEndPointOutputConnector_3096"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType LoadBalanceEndPointWestOutputConnector_3098 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.LoadBalanceEndPointWestOutputConnector_3098"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType APIResourceEndpoint_3674 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.APIResourceEndpoint_3674"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType APIResourceEndpointInputConnector_3675 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.APIResourceEndpointInputConnector_3675"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType APIResourceEndpointOutputConnector_3676 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.APIResourceEndpointOutputConnector_3676"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType AddressingEndpoint_3689 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.AddressingEndpoint_3689"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType AddressingEndpointInputConnector_3690 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.AddressingEndpointInputConnector_3690"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType AddressingEndpointOutputConnector_3691 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.AddressingEndpointOutputConnector_3691"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType HTTPEndpoint_3709 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.HTTPEndpoint_3709"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType HTTPEndPointInputConnector_3710 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.HTTPEndPointInputConnector_3710"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType HTTPEndPointOutputConnector_3711 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.HTTPEndPointOutputConnector_3711"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType TemplateEndpoint_3716 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.TemplateEndpoint_3716"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType TemplateEndpointInputConnector_3717 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.TemplateEndpointInputConnector_3717"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType TemplateEndpointOutputConnector_3718 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.TemplateEndpointOutputConnector_3718"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType CloudConnector_3719 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.CloudConnector_3719"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType CloudConnectorInputConnector_3720 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.CloudConnectorInputConnector_3720"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType CloudConnectorOutputConnector_3721 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.CloudConnectorOutputConnector_3721"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType CloudConnectorOperation_3722 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.CloudConnectorOperation_3722"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType CloudConnectorOperationInputConnector_3723 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.CloudConnectorOperationInputConnector_3723"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType CloudConnectorOperationOutputConnector_3724 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.CloudConnectorOperationOutputConnector_3724"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType LoopBackMediator_3736 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.LoopBackMediator_3736"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType LoopBackMediatorInputConnector_3737 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.LoopBackMediatorInputConnector_3737"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType LoopBackMediatorOutputConnector_3738 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.LoopBackMediatorOutputConnector_3738"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType RespondMediator_3739 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.RespondMediator_3739"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType RespondMediatorInputConnector_3740 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.RespondMediatorInputConnector_3740"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType RespondMediatorOutputConnector_3741 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.RespondMediatorOutputConnector_3741"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType CallMediator_3742 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.CallMediator_3742"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType CallMediatorInputConnector_3743 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.CallMediatorInputConnector_3743"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType CallMediatorOutputConnector_3744 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.CallMediatorOutputConnector_3744"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType CallMediatorEndpointOutputConnector_3745 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.CallMediatorEndpointOutputConnector_3745"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType MediatorFlow_3746 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.MediatorFlow_3746"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType DataMapperMediator_3761 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.DataMapperMediator_3761"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType DataMapperMediatorInputConnector_3762 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.DataMapperMediatorInputConnector_3762"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType DataMapperMediatorOutputConnector_3763 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.DataMapperMediatorOutputConnector_3763"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType FastXSLTMediator_3764 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.FastXSLTMediator_3764"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType FastXSLTMediatorInputConnector_3765 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.FastXSLTMediatorInputConnector_3765"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType FastXSLTMediatorOutputConnector_3766 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.FastXSLTMediatorOutputConnector_3766"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ForEachMediator_3780 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.ForEachMediator_3780"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ForEachMediatorInputConnector_3781 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.ForEachMediatorInputConnector_3781"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ForEachMediatorOutputConnector_3782 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.ForEachMediatorOutputConnector_3782"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ForEachMediatorTargetOutputConnector_3783 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.ForEachMediatorTargetOutputConnector_3783"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType MediatorFlow_3784 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.MediatorFlow_3784"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType PublishEventMediator_3785 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.PublishEventMediator_3785"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType PublishEventMediatorInputConnector_3786 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.PublishEventMediatorInputConnector_3786"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType PublishEventMediatorOutputConnector_3787 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.PublishEventMediatorOutputConnector_3787"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType EntitlementOnAcceptContainer_3755 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.EntitlementOnAcceptContainer_3755"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType MediatorFlow_3756 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.MediatorFlow_3756"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType EntitlementAdviceContainer_3757 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.EntitlementAdviceContainer_3757"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType MediatorFlow_3758 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.MediatorFlow_3758"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType EntitlementObligationsContainer_3759 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.EntitlementObligationsContainer_3759"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType MediatorFlow_3760 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.MediatorFlow_3760"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType SwitchDefaultParentContainer_3734 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.SwitchDefaultParentContainer_3734"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType SwitchDefaultContainer_3735 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.SwitchDefaultContainer_3735"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ProxyServiceFaultContainer_3488 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.ProxyServiceFaultContainer_3488"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType MediatorFlow_3530 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.MediatorFlow_3530"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ProxyOutSequenceOutputConnector_3729 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.ProxyOutSequenceOutputConnector_3729"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType HeaderMediatorInputConnector_3100 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.HeaderMediatorInputConnector_3100"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType HeaderMediatorOutputConnector_3101 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.HeaderMediatorOutputConnector_3101"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType CloneMediator_3517 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.CloneMediator_3517"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType CloneMediatorInputConnector_3103 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.CloneMediatorInputConnector_3103"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType CloneMediatorOutputConnector_3104 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.CloneMediatorOutputConnector_3104"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType CloneMediatorTargetOutputConnector_3133 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.CloneMediatorTargetOutputConnector_3133"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType CloneMediatorContainer_3603 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.CloneMediatorContainer_3603"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType CloneTargetContainer_3604 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.CloneTargetContainer_3604"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType MediatorFlow_3605 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.MediatorFlow_3605"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType CacheMediator_3518 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.CacheMediator_3518"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType CacheMediatorInputConnector_3106 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.CacheMediatorInputConnector_3106"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType CacheMediatorOutputConnector_3107 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.CacheMediatorOutputConnector_3107"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType CacheMediatorOnHitOutputConnector_3618 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.CacheMediatorOnHitOutputConnector_3618"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType MediatorFlow_3619 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.MediatorFlow_3619"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType IterateMediator_3519 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.IterateMediator_3519"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType IterateMediatorInputConnector_3109 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.IterateMediatorInputConnector_3109"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType IterateMediatorOutputConnector_3110 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.IterateMediatorOutputConnector_3110"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType IterateMediatorTargetOutputConnector_3606 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.IterateMediatorTargetOutputConnector_3606"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType MediatorFlow_3607 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.MediatorFlow_3607"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType CalloutMediator_3520 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.CalloutMediator_3520"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType AggregateMediatorInputConnector_3112 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.AggregateMediatorInputConnector_3112"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType AggregateMediatorOutputConnector_3113 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.AggregateMediatorOutputConnector_3113"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType AggregateMediatorOnCompleteOutputConnector_3132 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.AggregateMediatorOnCompleteOutputConnector_3132"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType MediatorFlow_3526 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.MediatorFlow_3526"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType StoreMediator_3588 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.StoreMediator_3588"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType StoreMediatorInputConnector_3589 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.StoreMediatorInputConnector_3589"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType StoreMediatorOutputConnector_3590 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.StoreMediatorOutputConnector_3590"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType BuilderMediator_3591 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.BuilderMediator_3591"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType BuilderMediatorInputConnector_3592 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.BuilderMediatorInputConnector_3592"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType BuilderMediatorOutputConector_3593 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.BuilderMediatorOutputConector_3593"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType CallTemplateMediator_3594 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.CallTemplateMediator_3594"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType CallTemplateMediatorInputConnector_3595 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.CallTemplateMediatorInputConnector_3595"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType CallTemplateMediatorOutputConnector_3596 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.CallTemplateMediatorOutputConnector_3596"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType PayloadFactoryMediator_3597 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.PayloadFactoryMediator_3597"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType PayloadFactoryMediatorInputConnector_3598 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.PayloadFactoryMediatorInputConnector_3598"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType PayloadFactoryMediatorOutputConnector_3599 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.PayloadFactoryMediatorOutputConnector_3599"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType EnqueueMediator_3600 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.EnqueueMediator_3600"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType EnqueueMediatorInputConnector_3601 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.EnqueueMediatorInputConnector_3601"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType EnqueueMediatorOutputConnector_3602 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.EnqueueMediatorOutputConnector_3602"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType URLRewriteMediator_3620 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.URLRewriteMediator_3620"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType URLRewriteMediatorInputConnector_3621 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.URLRewriteMediatorInputConnector_3621"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType URLRewriteMediatorOutputConnector_3622 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.URLRewriteMediatorOutputConnector_3622"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ValidateMediator_3623 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.ValidateMediator_3623"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ValidateMediatorInputConnector_3624 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.ValidateMediatorInputConnector_3624"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ValidateMediatorOutputConnector_3625 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.ValidateMediatorOutputConnector_3625"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ValidateMediatorOnFailOutputConnector_3626 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.ValidateMediatorOnFailOutputConnector_3626"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType MediatorFlow_3627 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.MediatorFlow_3627"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType RouterMediator_3628 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.RouterMediator_3628"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType RouterMediatorInputConnector_3629 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.RouterMediatorInputConnector_3629"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType RouterMediatorOutputConnector_3630 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.RouterMediatorOutputConnector_3630"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType RouterMediatorTargetOutputConnector_3631 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.RouterMediatorTargetOutputConnector_3631"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType RouterMediatorContainer_3632 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.RouterMediatorContainer_3632"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType RouterTargetContainer_3633 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.RouterTargetContainer_3633"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType MediatorFlow_3634 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.MediatorFlow_3634"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ConditionalRouterMediator_3635 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.ConditionalRouterMediator_3635"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ConditionalRouterMediatorInputConnector_3636 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.ConditionalRouterMediatorInputConnector_3636"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ConditionalRouterMediatorOutputConnector_3637 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.ConditionalRouterMediatorOutputConnector_3637"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ConditionalRouterMediatorAdditionalOutputConnector_3638 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.ConditionalRouterMediatorAdditionalOutputConnector_3638"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType MediatorFlow_3639 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.MediatorFlow_3639"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType BAMMediator_3680 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.BAMMediator_3680"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType BAMMediatorInputConnector_3681 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.BAMMediatorInputConnector_3681"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType BAMMediatorOutputConnector_3682 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.BAMMediatorOutputConnector_3682"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType BeanMediator_3683 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.BeanMediator_3683"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType BeanMediatorInputConnector_3684 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.BeanMediatorInputConnector_3684"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType BeanMediatorOutputConnector_3685 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.BeanMediatorOutputConnector_3685"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType EJBMediator_3686 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.EJBMediator_3686"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType EJBMediatorInputConnector_3687 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.EJBMediatorInputConnector_3687"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType EJBMediatorOutputConnector_3688 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.EJBMediatorOutputConnector_3688"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType DefaultEndPoint_3609 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.DefaultEndPoint_3609"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType MediatorFlow_3528 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.MediatorFlow_3528"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType FilterFailContainer_3537 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.FilterFailContainer_3537"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType MediatorFlow_3538 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.MediatorFlow_3538"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ThrottleOnRejectContainer_3586 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.ThrottleOnRejectContainer_3586"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType MediatorFlow_3587 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.MediatorFlow_3587"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType CalloutMediatorInputConnector_3115 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.CalloutMediatorInputConnector_3115"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType CalloutMediatorOutputConnector_3116 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.CalloutMediatorOutputConnector_3116"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType TransactionMediator_3521 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.TransactionMediator_3521"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType TransactionMediatorInputConnector_3118 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.TransactionMediatorInputConnector_3118"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType TransactionMediatorOutputConnector_3119 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.TransactionMediatorOutputConnector_3119"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType RMSequenceMediator_3522 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.RMSequenceMediator_3522"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ThrottleMediatorInputConnector_3121 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.ThrottleMediatorInputConnector_3121"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ThrottleMediatorOutputConnector_3122 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.ThrottleMediatorOutputConnector_3122"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ThrottleMediatorOnAcceptOutputConnector_3581 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.ThrottleMediatorOnAcceptOutputConnector_3581"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ThrottleMediatorOnRejectOutputConnector_3582 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.ThrottleMediatorOnRejectOutputConnector_3582"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ThrottleContainer_3583 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.ThrottleContainer_3583"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ThrottleOnAcceptContainer_3584 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.ThrottleOnAcceptContainer_3584"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType MediatorFlow_3585 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.MediatorFlow_3585"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType FilterMediator_3494 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.FilterMediator_3494"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType RMSequenceMediatorInputConnector_3124 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.RMSequenceMediatorInputConnector_3124"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType RMSequenceMediatorOutputConnector_3125 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.RMSequenceMediatorOutputConnector_3125"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType RuleMediator_3523 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.RuleMediator_3523"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType RuleMediatorInputConnector_3127 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.RuleMediatorInputConnector_3127"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType RuleMediatorOutputConnector_3128 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.RuleMediatorOutputConnector_3128"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType RuleMediatorChildMediatorsOutputConnector_3640 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.RuleMediatorChildMediatorsOutputConnector_3640"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType MediatorFlow_3641 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.MediatorFlow_3641"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType OAuthMediator_3524 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.OAuthMediator_3524"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType OAuthMediatorInputConnector_3130 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.OAuthMediatorInputConnector_3130"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType OAuthMediatorOutputConnector_3131 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.OAuthMediatorOutputConnector_3131"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType AggregateMediator_3525 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.AggregateMediator_3525"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType DefaultEndPointInputConnector_3021 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.DefaultEndPointInputConnector_3021"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType DefaultEndPointOutputConnector_3022 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.DefaultEndPointOutputConnector_3022"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType AddressEndPoint_3610 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.AddressEndPoint_3610"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType AddressEndPointInputConnector_3030 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.AddressEndPointInputConnector_3030"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType AddressEndPointOutputConnector_3031 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.AddressEndPointOutputConnector_3031"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType FailoverEndPoint_3611 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.FailoverEndPoint_3611"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType EsbLink_4001 = getElementType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.EsbLink_4001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(ENamedElement element) {
		return elementTypeImages.getImageDescriptor(element);
	}

	/**
	 * @generated
	 */
	public static Image getImage(ENamedElement element) {
		return elementTypeImages.getImage(element);
	}

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(IAdaptable hint) {
		return getImageDescriptor(getElement(hint));
	}

	/**
	 * @generated
	 */
	public static Image getImage(IAdaptable hint) {
		return getImage(getElement(hint));
	}

	/**
	 * Returns 'type' of the ecore object associated with the hint.
	 * 
	 * @generated
	 */
	public static ENamedElement getElement(IAdaptable hint) {
		Object type = hint.getAdapter(IElementType.class);
		if (elements == null) {
			elements = new IdentityHashMap<IElementType, ENamedElement>();

			elements.put(EsbDiagram_1000, EsbPackage.eINSTANCE.getEsbDiagram());

			elements.put(EsbServer_2001, EsbPackage.eINSTANCE.getEsbServer());

			elements.put(ProxyService_3001, EsbPackage.eINSTANCE.getProxyService());

			elements.put(ProxyOutputConnector_3002, EsbPackage.eINSTANCE.getProxyOutputConnector());

			elements.put(ProxyInputConnector_3003, EsbPackage.eINSTANCE.getProxyInputConnector());

			elements.put(ProxyOutSequenceOutputConnector_3729,
					EsbPackage.eINSTANCE.getProxyOutSequenceOutputConnector());

			elements.put(ProxyFaultInputConnector_3489, EsbPackage.eINSTANCE.getProxyFaultInputConnector());

			elements.put(ProxyServiceContainer_3486, EsbPackage.eINSTANCE.getProxyServiceContainer());

			elements.put(ProxyServiceSequenceAndEndpointContainer_3487,
					EsbPackage.eINSTANCE.getProxyServiceSequenceAndEndpointContainer());

			elements.put(MediatorFlow_3608, EsbPackage.eINSTANCE.getMediatorFlow());

			elements.put(DropMediator_3491, EsbPackage.eINSTANCE.getDropMediator());

			elements.put(DropMediatorInputConnector_3008, EsbPackage.eINSTANCE.getDropMediatorInputConnector());

			elements.put(PropertyMediator_3492, EsbPackage.eINSTANCE.getPropertyMediator());

			elements.put(PropertyMediatorInputConnector_3033, EsbPackage.eINSTANCE.getPropertyMediatorInputConnector());

			elements.put(PropertyMediatorOutputConnector_3034,
					EsbPackage.eINSTANCE.getPropertyMediatorOutputConnector());

			elements.put(ThrottleMediator_3493, EsbPackage.eINSTANCE.getThrottleMediator());

			elements.put(ThrottleMediatorInputConnector_3121, EsbPackage.eINSTANCE.getThrottleMediatorInputConnector());

			elements.put(ThrottleMediatorOutputConnector_3122,
					EsbPackage.eINSTANCE.getThrottleMediatorOutputConnector());

			elements.put(ThrottleMediatorOnAcceptOutputConnector_3581,
					EsbPackage.eINSTANCE.getThrottleMediatorOnAcceptOutputConnector());

			elements.put(ThrottleMediatorOnRejectOutputConnector_3582,
					EsbPackage.eINSTANCE.getThrottleMediatorOnRejectOutputConnector());

			elements.put(ThrottleContainer_3583, EsbPackage.eINSTANCE.getThrottleContainer());

			elements.put(ThrottleOnAcceptContainer_3584, EsbPackage.eINSTANCE.getThrottleOnAcceptContainer());

			elements.put(MediatorFlow_3585, EsbPackage.eINSTANCE.getMediatorFlow());

			elements.put(FilterMediator_3494, EsbPackage.eINSTANCE.getFilterMediator());

			elements.put(FilterMediatorInputConnector_3010, EsbPackage.eINSTANCE.getFilterMediatorInputConnector());

			elements.put(FilterMediatorOutputConnector_3534, EsbPackage.eINSTANCE.getFilterMediatorOutputConnector());

			elements.put(FilterMediatorPassOutputConnector_3011,
					EsbPackage.eINSTANCE.getFilterMediatorPassOutputConnector());

			elements.put(FilterMediatorFailOutputConnector_3012,
					EsbPackage.eINSTANCE.getFilterMediatorFailOutputConnector());

			elements.put(FilterContainer_3531, EsbPackage.eINSTANCE.getFilterContainer());

			elements.put(FilterPassContainer_3535, EsbPackage.eINSTANCE.getFilterPassContainer());

			elements.put(MediatorFlow_3536, EsbPackage.eINSTANCE.getMediatorFlow());

			elements.put(LogMediator_3495, EsbPackage.eINSTANCE.getLogMediator());

			elements.put(LogMediatorInputConnector_3018, EsbPackage.eINSTANCE.getLogMediatorInputConnector());

			elements.put(LogMediatorOutputConnector_3019, EsbPackage.eINSTANCE.getLogMediatorOutputConnector());

			elements.put(EnrichMediator_3496, EsbPackage.eINSTANCE.getEnrichMediator());

			elements.put(EnrichMediatorInputConnector_3036, EsbPackage.eINSTANCE.getEnrichMediatorInputConnector());

			elements.put(EnrichMediatorOutputConnector_3037, EsbPackage.eINSTANCE.getEnrichMediatorOutputConnector());

			elements.put(XSLTMediator_3497, EsbPackage.eINSTANCE.getXSLTMediator());

			elements.put(XSLTMediatorInputConnector_3039, EsbPackage.eINSTANCE.getXSLTMediatorInputConnector());

			elements.put(XSLTMediatorOutputConnector_3040, EsbPackage.eINSTANCE.getXSLTMediatorOutputConnector());

			elements.put(SwitchMediator_3498, EsbPackage.eINSTANCE.getSwitchMediator());

			elements.put(SwitchMediatorInputConnector_3042, EsbPackage.eINSTANCE.getSwitchMediatorInputConnector());

			elements.put(SwitchMediatorOutputConnector_3499, EsbPackage.eINSTANCE.getSwitchMediatorOutputConnector());

			elements.put(SwitchCaseBranchOutputConnector_3043,
					EsbPackage.eINSTANCE.getSwitchCaseBranchOutputConnector());

			elements.put(SwitchDefaultBranchOutputConnector_3044,
					EsbPackage.eINSTANCE.getSwitchDefaultBranchOutputConnector());

			elements.put(SwitchMediatorContainer_3500, EsbPackage.eINSTANCE.getSwitchMediatorContainer());

			elements.put(SwitchCaseParentContainer_3732, EsbPackage.eINSTANCE.getSwitchCaseParentContainer());

			elements.put(SwitchCaseContainer_3733, EsbPackage.eINSTANCE.getSwitchCaseContainer());

			elements.put(MediatorFlow_3502, EsbPackage.eINSTANCE.getMediatorFlow());

			elements.put(Sequence_3503, EsbPackage.eINSTANCE.getSequence());

			elements.put(SequenceInputConnector_3049, EsbPackage.eINSTANCE.getSequenceInputConnector());

			elements.put(SequenceOutputConnector_3050, EsbPackage.eINSTANCE.getSequenceOutputConnector());

			elements.put(EventMediator_3504, EsbPackage.eINSTANCE.getEventMediator());

			elements.put(EventMediatorInputConnector_3052, EsbPackage.eINSTANCE.getEventMediatorInputConnector());

			elements.put(EventMediatorOutputConnector_3053, EsbPackage.eINSTANCE.getEventMediatorOutputConnector());

			elements.put(EntitlementMediator_3505, EsbPackage.eINSTANCE.getEntitlementMediator());

			elements.put(EntitlementMediatorInputConnector_3055,
					EsbPackage.eINSTANCE.getEntitlementMediatorInputConnector());

			elements.put(EntitlementMediatorOutputConnector_3056,
					EsbPackage.eINSTANCE.getEntitlementMediatorOutputConnector());

			elements.put(EntitlementMediatorOnRejectOutputConnector_3748,
					EsbPackage.eINSTANCE.getEntitlementMediatorOnRejectOutputConnector());

			elements.put(EntitlementMediatorOnAcceptOutputConnector_3749,
					EsbPackage.eINSTANCE.getEntitlementMediatorOnAcceptOutputConnector());

			elements.put(EntitlementMediatorAdviceOutputConnector_3750,
					EsbPackage.eINSTANCE.getEntitlementMediatorAdviceOutputConnector());

			elements.put(EntitlementMediatorObligationsOutputConnector_3751,
					EsbPackage.eINSTANCE.getEntitlementMediatorObligationsOutputConnector());

			elements.put(EntitlementContainer_3752, EsbPackage.eINSTANCE.getEntitlementContainer());

			elements.put(EntitlementOnRejectContainer_3753, EsbPackage.eINSTANCE.getEntitlementOnRejectContainer());

			elements.put(MediatorFlow_3754, EsbPackage.eINSTANCE.getMediatorFlow());

			elements.put(ClassMediator_3506, EsbPackage.eINSTANCE.getClassMediator());

			elements.put(ClassMediatorInputConnector_3058, EsbPackage.eINSTANCE.getClassMediatorInputConnector());

			elements.put(ClassMediatorOutputConnector_3059, EsbPackage.eINSTANCE.getClassMediatorOutputConnector());

			elements.put(SpringMediator_3507, EsbPackage.eINSTANCE.getSpringMediator());

			elements.put(SpringMediatorInputConnector_3061, EsbPackage.eINSTANCE.getSpringMediatorInputConnector());

			elements.put(SpringMediatorOutputConnector_3062, EsbPackage.eINSTANCE.getSpringMediatorOutputConnector());

			elements.put(ScriptMediator_3508, EsbPackage.eINSTANCE.getScriptMediator());

			elements.put(ScriptMediatorInputConnector_3064, EsbPackage.eINSTANCE.getScriptMediatorInputConnector());

			elements.put(ScriptMediatorOutputConnector_3065, EsbPackage.eINSTANCE.getScriptMediatorOutputConnector());

			elements.put(FaultMediator_3509, EsbPackage.eINSTANCE.getFaultMediator());

			elements.put(FaultMediatorInputConnector_3067, EsbPackage.eINSTANCE.getFaultMediatorInputConnector());

			elements.put(FaultMediatorOutputConnector_3068, EsbPackage.eINSTANCE.getFaultMediatorOutputConnector());

			elements.put(XQueryMediator_3510, EsbPackage.eINSTANCE.getXQueryMediator());

			elements.put(XQueryMediatorInputConnector_3070, EsbPackage.eINSTANCE.getXQueryMediatorInputConnector());

			elements.put(XQueryMediatorOutputConnector_3071, EsbPackage.eINSTANCE.getXQueryMediatorOutputConnector());

			elements.put(CommandMediator_3511, EsbPackage.eINSTANCE.getCommandMediator());

			elements.put(CommandMediatorInputConnector_3073, EsbPackage.eINSTANCE.getCommandMediatorInputConnector());

			elements.put(CommandMediatorOutputConnector_3074, EsbPackage.eINSTANCE.getCommandMediatorOutputConnector());

			elements.put(DBLookupMediator_3512, EsbPackage.eINSTANCE.getDBLookupMediator());

			elements.put(DBLookupMediatorInputConnector_3076, EsbPackage.eINSTANCE.getDBLookupMediatorInputConnector());

			elements.put(DBLookupMediatorOutputConnector_3077,
					EsbPackage.eINSTANCE.getDBLookupMediatorOutputConnector());

			elements.put(DBReportMediator_3513, EsbPackage.eINSTANCE.getDBReportMediator());

			elements.put(DBReportMediatorInputConnector_3079, EsbPackage.eINSTANCE.getDBReportMediatorInputConnector());

			elements.put(DBReportMediatorOutputConnector_3080,
					EsbPackage.eINSTANCE.getDBReportMediatorOutputConnector());

			elements.put(SmooksMediator_3514, EsbPackage.eINSTANCE.getSmooksMediator());

			elements.put(SmooksMediatorInputConnector_3082, EsbPackage.eINSTANCE.getSmooksMediatorInputConnector());

			elements.put(SmooksMediatorOutputConnector_3083, EsbPackage.eINSTANCE.getSmooksMediatorOutputConnector());

			elements.put(SendMediator_3515, EsbPackage.eINSTANCE.getSendMediator());

			elements.put(SendMediatorInputConnector_3085, EsbPackage.eINSTANCE.getSendMediatorInputConnector());

			elements.put(SendMediatorOutputConnector_3086, EsbPackage.eINSTANCE.getSendMediatorOutputConnector());

			elements.put(SendMediatorEndpointOutputConnector_3539,
					EsbPackage.eINSTANCE.getSendMediatorEndpointOutputConnector());

			elements.put(MediatorFlow_3728, EsbPackage.eINSTANCE.getMediatorFlow());

			elements.put(HeaderMediator_3516, EsbPackage.eINSTANCE.getHeaderMediator());

			elements.put(HeaderMediatorInputConnector_3100, EsbPackage.eINSTANCE.getHeaderMediatorInputConnector());

			elements.put(HeaderMediatorOutputConnector_3101, EsbPackage.eINSTANCE.getHeaderMediatorOutputConnector());

			elements.put(CloneMediator_3517, EsbPackage.eINSTANCE.getCloneMediator());

			elements.put(CloneMediatorInputConnector_3103, EsbPackage.eINSTANCE.getCloneMediatorInputConnector());

			elements.put(CloneMediatorOutputConnector_3104, EsbPackage.eINSTANCE.getCloneMediatorOutputConnector());

			elements.put(CloneMediatorTargetOutputConnector_3133,
					EsbPackage.eINSTANCE.getCloneMediatorTargetOutputConnector());

			elements.put(CloneMediatorContainer_3603, EsbPackage.eINSTANCE.getCloneMediatorContainer());

			elements.put(CloneTargetContainer_3604, EsbPackage.eINSTANCE.getCloneTargetContainer());

			elements.put(MediatorFlow_3605, EsbPackage.eINSTANCE.getMediatorFlow());

			elements.put(CacheMediator_3518, EsbPackage.eINSTANCE.getCacheMediator());

			elements.put(CacheMediatorInputConnector_3106, EsbPackage.eINSTANCE.getCacheMediatorInputConnector());

			elements.put(CacheMediatorOutputConnector_3107, EsbPackage.eINSTANCE.getCacheMediatorOutputConnector());

			elements.put(CacheMediatorOnHitOutputConnector_3618,
					EsbPackage.eINSTANCE.getCacheMediatorOnHitOutputConnector());

			elements.put(MediatorFlow_3619, EsbPackage.eINSTANCE.getMediatorFlow());

			elements.put(IterateMediator_3519, EsbPackage.eINSTANCE.getIterateMediator());

			elements.put(IterateMediatorInputConnector_3109, EsbPackage.eINSTANCE.getIterateMediatorInputConnector());

			elements.put(IterateMediatorOutputConnector_3110, EsbPackage.eINSTANCE.getIterateMediatorOutputConnector());

			elements.put(IterateMediatorTargetOutputConnector_3606,
					EsbPackage.eINSTANCE.getIterateMediatorTargetOutputConnector());

			elements.put(MediatorFlow_3607, EsbPackage.eINSTANCE.getMediatorFlow());

			elements.put(CalloutMediator_3520, EsbPackage.eINSTANCE.getCalloutMediator());

			elements.put(CalloutMediatorInputConnector_3115, EsbPackage.eINSTANCE.getCalloutMediatorInputConnector());

			elements.put(CalloutMediatorOutputConnector_3116, EsbPackage.eINSTANCE.getCalloutMediatorOutputConnector());

			elements.put(TransactionMediator_3521, EsbPackage.eINSTANCE.getTransactionMediator());

			elements.put(TransactionMediatorInputConnector_3118,
					EsbPackage.eINSTANCE.getTransactionMediatorInputConnector());

			elements.put(TransactionMediatorOutputConnector_3119,
					EsbPackage.eINSTANCE.getTransactionMediatorOutputConnector());

			elements.put(RMSequenceMediator_3522, EsbPackage.eINSTANCE.getRMSequenceMediator());

			elements.put(RMSequenceMediatorInputConnector_3124,
					EsbPackage.eINSTANCE.getRMSequenceMediatorInputConnector());

			elements.put(RMSequenceMediatorOutputConnector_3125,
					EsbPackage.eINSTANCE.getRMSequenceMediatorOutputConnector());

			elements.put(RuleMediator_3523, EsbPackage.eINSTANCE.getRuleMediator());

			elements.put(RuleMediatorInputConnector_3127, EsbPackage.eINSTANCE.getRuleMediatorInputConnector());

			elements.put(RuleMediatorOutputConnector_3128, EsbPackage.eINSTANCE.getRuleMediatorOutputConnector());

			elements.put(RuleMediatorChildMediatorsOutputConnector_3640,
					EsbPackage.eINSTANCE.getRuleMediatorChildMediatorsOutputConnector());

			elements.put(MediatorFlow_3641, EsbPackage.eINSTANCE.getMediatorFlow());

			elements.put(OAuthMediator_3524, EsbPackage.eINSTANCE.getOAuthMediator());

			elements.put(OAuthMediatorInputConnector_3130, EsbPackage.eINSTANCE.getOAuthMediatorInputConnector());

			elements.put(OAuthMediatorOutputConnector_3131, EsbPackage.eINSTANCE.getOAuthMediatorOutputConnector());

			elements.put(AggregateMediator_3525, EsbPackage.eINSTANCE.getAggregateMediator());

			elements.put(AggregateMediatorInputConnector_3112,
					EsbPackage.eINSTANCE.getAggregateMediatorInputConnector());

			elements.put(AggregateMediatorOutputConnector_3113,
					EsbPackage.eINSTANCE.getAggregateMediatorOutputConnector());

			elements.put(AggregateMediatorOnCompleteOutputConnector_3132,
					EsbPackage.eINSTANCE.getAggregateMediatorOnCompleteOutputConnector());

			elements.put(MediatorFlow_3526, EsbPackage.eINSTANCE.getMediatorFlow());

			elements.put(StoreMediator_3588, EsbPackage.eINSTANCE.getStoreMediator());

			elements.put(StoreMediatorInputConnector_3589, EsbPackage.eINSTANCE.getStoreMediatorInputConnector());

			elements.put(StoreMediatorOutputConnector_3590, EsbPackage.eINSTANCE.getStoreMediatorOutputConnector());

			elements.put(BuilderMediator_3591, EsbPackage.eINSTANCE.getBuilderMediator());

			elements.put(BuilderMediatorInputConnector_3592, EsbPackage.eINSTANCE.getBuilderMediatorInputConnector());

			elements.put(BuilderMediatorOutputConector_3593, EsbPackage.eINSTANCE.getBuilderMediatorOutputConector());

			elements.put(CallTemplateMediator_3594, EsbPackage.eINSTANCE.getCallTemplateMediator());

			elements.put(CallTemplateMediatorInputConnector_3595,
					EsbPackage.eINSTANCE.getCallTemplateMediatorInputConnector());

			elements.put(CallTemplateMediatorOutputConnector_3596,
					EsbPackage.eINSTANCE.getCallTemplateMediatorOutputConnector());

			elements.put(PayloadFactoryMediator_3597, EsbPackage.eINSTANCE.getPayloadFactoryMediator());

			elements.put(PayloadFactoryMediatorInputConnector_3598,
					EsbPackage.eINSTANCE.getPayloadFactoryMediatorInputConnector());

			elements.put(PayloadFactoryMediatorOutputConnector_3599,
					EsbPackage.eINSTANCE.getPayloadFactoryMediatorOutputConnector());

			elements.put(EnqueueMediator_3600, EsbPackage.eINSTANCE.getEnqueueMediator());

			elements.put(EnqueueMediatorInputConnector_3601, EsbPackage.eINSTANCE.getEnqueueMediatorInputConnector());

			elements.put(EnqueueMediatorOutputConnector_3602, EsbPackage.eINSTANCE.getEnqueueMediatorOutputConnector());

			elements.put(URLRewriteMediator_3620, EsbPackage.eINSTANCE.getURLRewriteMediator());

			elements.put(URLRewriteMediatorInputConnector_3621,
					EsbPackage.eINSTANCE.getURLRewriteMediatorInputConnector());

			elements.put(URLRewriteMediatorOutputConnector_3622,
					EsbPackage.eINSTANCE.getURLRewriteMediatorOutputConnector());

			elements.put(ValidateMediator_3623, EsbPackage.eINSTANCE.getValidateMediator());

			elements.put(ValidateMediatorInputConnector_3624, EsbPackage.eINSTANCE.getValidateMediatorInputConnector());

			elements.put(ValidateMediatorOutputConnector_3625,
					EsbPackage.eINSTANCE.getValidateMediatorOutputConnector());

			elements.put(ValidateMediatorOnFailOutputConnector_3626,
					EsbPackage.eINSTANCE.getValidateMediatorOnFailOutputConnector());

			elements.put(MediatorFlow_3627, EsbPackage.eINSTANCE.getMediatorFlow());

			elements.put(RouterMediator_3628, EsbPackage.eINSTANCE.getRouterMediator());

			elements.put(RouterMediatorInputConnector_3629, EsbPackage.eINSTANCE.getRouterMediatorInputConnector());

			elements.put(RouterMediatorOutputConnector_3630, EsbPackage.eINSTANCE.getRouterMediatorOutputConnector());

			elements.put(RouterMediatorTargetOutputConnector_3631,
					EsbPackage.eINSTANCE.getRouterMediatorTargetOutputConnector());

			elements.put(RouterMediatorContainer_3632, EsbPackage.eINSTANCE.getRouterMediatorContainer());

			elements.put(RouterTargetContainer_3633, EsbPackage.eINSTANCE.getRouterTargetContainer());

			elements.put(MediatorFlow_3634, EsbPackage.eINSTANCE.getMediatorFlow());

			elements.put(ConditionalRouterMediator_3635, EsbPackage.eINSTANCE.getConditionalRouterMediator());

			elements.put(ConditionalRouterMediatorInputConnector_3636,
					EsbPackage.eINSTANCE.getConditionalRouterMediatorInputConnector());

			elements.put(ConditionalRouterMediatorOutputConnector_3637,
					EsbPackage.eINSTANCE.getConditionalRouterMediatorOutputConnector());

			elements.put(ConditionalRouterMediatorAdditionalOutputConnector_3638,
					EsbPackage.eINSTANCE.getConditionalRouterMediatorAdditionalOutputConnector());

			elements.put(MediatorFlow_3639, EsbPackage.eINSTANCE.getMediatorFlow());

			elements.put(BAMMediator_3680, EsbPackage.eINSTANCE.getBAMMediator());

			elements.put(BAMMediatorInputConnector_3681, EsbPackage.eINSTANCE.getBAMMediatorInputConnector());

			elements.put(BAMMediatorOutputConnector_3682, EsbPackage.eINSTANCE.getBAMMediatorOutputConnector());

			elements.put(BeanMediator_3683, EsbPackage.eINSTANCE.getBeanMediator());

			elements.put(BeanMediatorInputConnector_3684, EsbPackage.eINSTANCE.getBeanMediatorInputConnector());

			elements.put(BeanMediatorOutputConnector_3685, EsbPackage.eINSTANCE.getBeanMediatorOutputConnector());

			elements.put(EJBMediator_3686, EsbPackage.eINSTANCE.getEJBMediator());

			elements.put(EJBMediatorInputConnector_3687, EsbPackage.eINSTANCE.getEJBMediatorInputConnector());

			elements.put(EJBMediatorOutputConnector_3688, EsbPackage.eINSTANCE.getEJBMediatorOutputConnector());

			elements.put(DefaultEndPoint_3609, EsbPackage.eINSTANCE.getDefaultEndPoint());

			elements.put(DefaultEndPointInputConnector_3021, EsbPackage.eINSTANCE.getDefaultEndPointInputConnector());

			elements.put(DefaultEndPointOutputConnector_3022, EsbPackage.eINSTANCE.getDefaultEndPointOutputConnector());

			elements.put(AddressEndPoint_3610, EsbPackage.eINSTANCE.getAddressEndPoint());

			elements.put(AddressEndPointInputConnector_3030, EsbPackage.eINSTANCE.getAddressEndPointInputConnector());

			elements.put(AddressEndPointOutputConnector_3031, EsbPackage.eINSTANCE.getAddressEndPointOutputConnector());

			elements.put(FailoverEndPoint_3611, EsbPackage.eINSTANCE.getFailoverEndPoint());

			elements.put(FailoverEndPointInputConnector_3088, EsbPackage.eINSTANCE.getFailoverEndPointInputConnector());

			elements.put(FailoverEndPointOutputConnector_3090,
					EsbPackage.eINSTANCE.getFailoverEndPointOutputConnector());

			elements.put(FailoverEndPointWestOutputConnector_3097,
					EsbPackage.eINSTANCE.getFailoverEndPointWestOutputConnector());

			elements.put(RecipientListEndPoint_3692, EsbPackage.eINSTANCE.getRecipientListEndPoint());

			elements.put(RecipientListEndPointInputConnector_3693,
					EsbPackage.eINSTANCE.getRecipientListEndPointInputConnector());

			elements.put(RecipientListEndPointOutputConnector_3694,
					EsbPackage.eINSTANCE.getRecipientListEndPointOutputConnector());

			elements.put(RecipientListEndPointWestOutputConnector_3695,
					EsbPackage.eINSTANCE.getRecipientListEndPointWestOutputConnector());

			elements.put(WSDLEndPoint_3612, EsbPackage.eINSTANCE.getWSDLEndPoint());

			elements.put(WSDLEndPointInputConnector_3092, EsbPackage.eINSTANCE.getWSDLEndPointInputConnector());

			elements.put(WSDLEndPointOutputConnector_3093, EsbPackage.eINSTANCE.getWSDLEndPointOutputConnector());

			elements.put(NamedEndpoint_3660, EsbPackage.eINSTANCE.getNamedEndpoint());

			elements.put(NamedEndpointInputConnector_3661, EsbPackage.eINSTANCE.getNamedEndpointInputConnector());

			elements.put(NamedEndpointOutputConnector_3662, EsbPackage.eINSTANCE.getNamedEndpointOutputConnector());

			elements.put(LoadBalanceEndPoint_3613, EsbPackage.eINSTANCE.getLoadBalanceEndPoint());

			elements.put(LoadBalanceEndPointInputConnector_3095,
					EsbPackage.eINSTANCE.getLoadBalanceEndPointInputConnector());

			elements.put(LoadBalanceEndPointOutputConnector_3096,
					EsbPackage.eINSTANCE.getLoadBalanceEndPointOutputConnector());

			elements.put(LoadBalanceEndPointWestOutputConnector_3098,
					EsbPackage.eINSTANCE.getLoadBalanceEndPointWestOutputConnector());

			elements.put(APIResourceEndpoint_3674, EsbPackage.eINSTANCE.getAPIResourceEndpoint());

			elements.put(APIResourceEndpointInputConnector_3675,
					EsbPackage.eINSTANCE.getAPIResourceEndpointInputConnector());

			elements.put(APIResourceEndpointOutputConnector_3676,
					EsbPackage.eINSTANCE.getAPIResourceEndpointOutputConnector());

			elements.put(AddressingEndpoint_3689, EsbPackage.eINSTANCE.getAddressingEndpoint());

			elements.put(AddressingEndpointInputConnector_3690,
					EsbPackage.eINSTANCE.getAddressingEndpointInputConnector());

			elements.put(AddressingEndpointOutputConnector_3691,
					EsbPackage.eINSTANCE.getAddressingEndpointOutputConnector());

			elements.put(HTTPEndpoint_3709, EsbPackage.eINSTANCE.getHTTPEndpoint());

			elements.put(HTTPEndPointInputConnector_3710, EsbPackage.eINSTANCE.getHTTPEndPointInputConnector());

			elements.put(HTTPEndPointOutputConnector_3711, EsbPackage.eINSTANCE.getHTTPEndPointOutputConnector());

			elements.put(TemplateEndpoint_3716, EsbPackage.eINSTANCE.getTemplateEndpoint());

			elements.put(TemplateEndpointInputConnector_3717, EsbPackage.eINSTANCE.getTemplateEndpointInputConnector());

			elements.put(TemplateEndpointOutputConnector_3718,
					EsbPackage.eINSTANCE.getTemplateEndpointOutputConnector());

			elements.put(CloudConnector_3719, EsbPackage.eINSTANCE.getCloudConnector());

			elements.put(CloudConnectorInputConnector_3720, EsbPackage.eINSTANCE.getCloudConnectorInputConnector());

			elements.put(CloudConnectorOutputConnector_3721, EsbPackage.eINSTANCE.getCloudConnectorOutputConnector());

			elements.put(CloudConnectorOperation_3722, EsbPackage.eINSTANCE.getCloudConnectorOperation());

			elements.put(CloudConnectorOperationInputConnector_3723,
					EsbPackage.eINSTANCE.getCloudConnectorOperationInputConnector());

			elements.put(CloudConnectorOperationOutputConnector_3724,
					EsbPackage.eINSTANCE.getCloudConnectorOperationOutputConnector());

			elements.put(LoopBackMediator_3736, EsbPackage.eINSTANCE.getLoopBackMediator());

			elements.put(LoopBackMediatorInputConnector_3737, EsbPackage.eINSTANCE.getLoopBackMediatorInputConnector());

			elements.put(LoopBackMediatorOutputConnector_3738,
					EsbPackage.eINSTANCE.getLoopBackMediatorOutputConnector());

			elements.put(RespondMediator_3739, EsbPackage.eINSTANCE.getRespondMediator());

			elements.put(RespondMediatorInputConnector_3740, EsbPackage.eINSTANCE.getRespondMediatorInputConnector());

			elements.put(RespondMediatorOutputConnector_3741, EsbPackage.eINSTANCE.getRespondMediatorOutputConnector());

			elements.put(CallMediator_3742, EsbPackage.eINSTANCE.getCallMediator());

			elements.put(CallMediatorInputConnector_3743, EsbPackage.eINSTANCE.getCallMediatorInputConnector());

			elements.put(CallMediatorOutputConnector_3744, EsbPackage.eINSTANCE.getCallMediatorOutputConnector());

			elements.put(CallMediatorEndpointOutputConnector_3745,
					EsbPackage.eINSTANCE.getCallMediatorEndpointOutputConnector());

			elements.put(MediatorFlow_3746, EsbPackage.eINSTANCE.getMediatorFlow());

			elements.put(DataMapperMediator_3761, EsbPackage.eINSTANCE.getDataMapperMediator());

			elements.put(DataMapperMediatorInputConnector_3762,
					EsbPackage.eINSTANCE.getDataMapperMediatorInputConnector());

			elements.put(DataMapperMediatorOutputConnector_3763,
					EsbPackage.eINSTANCE.getDataMapperMediatorOutputConnector());

			elements.put(FastXSLTMediator_3764, EsbPackage.eINSTANCE.getFastXSLTMediator());

			elements.put(FastXSLTMediatorInputConnector_3765, EsbPackage.eINSTANCE.getFastXSLTMediatorInputConnector());

			elements.put(FastXSLTMediatorOutputConnector_3766,
					EsbPackage.eINSTANCE.getFastXSLTMediatorOutputConnector());

			elements.put(ForEachMediator_3780, EsbPackage.eINSTANCE.getForEachMediator());

			elements.put(ForEachMediatorInputConnector_3781, EsbPackage.eINSTANCE.getForEachMediatorInputConnector());

			elements.put(ForEachMediatorOutputConnector_3782, EsbPackage.eINSTANCE.getForEachMediatorOutputConnector());

			elements.put(ForEachMediatorTargetOutputConnector_3783,
					EsbPackage.eINSTANCE.getForEachMediatorTargetOutputConnector());

			elements.put(MediatorFlow_3784, EsbPackage.eINSTANCE.getMediatorFlow());

			elements.put(PublishEventMediator_3785, EsbPackage.eINSTANCE.getPublishEventMediator());

			elements.put(PublishEventMediatorInputConnector_3786,
					EsbPackage.eINSTANCE.getPublishEventMediatorInputConnector());

			elements.put(PublishEventMediatorOutputConnector_3787,
					EsbPackage.eINSTANCE.getPublishEventMediatorOutputConnector());

			elements.put(EntitlementOnAcceptContainer_3755, EsbPackage.eINSTANCE.getEntitlementOnAcceptContainer());

			elements.put(MediatorFlow_3756, EsbPackage.eINSTANCE.getMediatorFlow());

			elements.put(EntitlementAdviceContainer_3757, EsbPackage.eINSTANCE.getEntitlementAdviceContainer());

			elements.put(MediatorFlow_3758, EsbPackage.eINSTANCE.getMediatorFlow());

			elements.put(EntitlementObligationsContainer_3759,
					EsbPackage.eINSTANCE.getEntitlementObligationsContainer());

			elements.put(MediatorFlow_3760, EsbPackage.eINSTANCE.getMediatorFlow());

			elements.put(SwitchDefaultParentContainer_3734, EsbPackage.eINSTANCE.getSwitchDefaultParentContainer());

			elements.put(SwitchDefaultContainer_3735, EsbPackage.eINSTANCE.getSwitchDefaultContainer());

			elements.put(MediatorFlow_3528, EsbPackage.eINSTANCE.getMediatorFlow());

			elements.put(FilterFailContainer_3537, EsbPackage.eINSTANCE.getFilterFailContainer());

			elements.put(MediatorFlow_3538, EsbPackage.eINSTANCE.getMediatorFlow());

			elements.put(ThrottleOnRejectContainer_3586, EsbPackage.eINSTANCE.getThrottleOnRejectContainer());

			elements.put(MediatorFlow_3587, EsbPackage.eINSTANCE.getMediatorFlow());

			elements.put(ProxyServiceFaultContainer_3488, EsbPackage.eINSTANCE.getProxyServiceFaultContainer());

			elements.put(MediatorFlow_3530, EsbPackage.eINSTANCE.getMediatorFlow());

			elements.put(ProxyInSequenceInputConnector_3731, EsbPackage.eINSTANCE.getProxyInSequenceInputConnector());

			elements.put(MessageMediator_3045, EsbPackage.eINSTANCE.getMessageMediator());

			elements.put(MessageInputConnector_3046, EsbPackage.eINSTANCE.getMessageInputConnector());

			elements.put(MessageOutputConnector_3047, EsbPackage.eINSTANCE.getMessageOutputConnector());

			elements.put(MergeNode_3013, EsbPackage.eINSTANCE.getMergeNode());

			elements.put(MergeNodeFirstInputConnector_3014, EsbPackage.eINSTANCE.getMergeNodeFirstInputConnector());

			elements.put(MergeNodeSecondInputConnector_3015, EsbPackage.eINSTANCE.getMergeNodeSecondInputConnector());

			elements.put(MergeNodeOutputConnector_3016, EsbPackage.eINSTANCE.getMergeNodeOutputConnector());

			elements.put(Sequences_3614, EsbPackage.eINSTANCE.getSequences());

			elements.put(MediatorFlow_3615, EsbPackage.eINSTANCE.getMediatorFlow());

			elements.put(SequencesInputConnector_3616, EsbPackage.eINSTANCE.getSequencesInputConnector());

			elements.put(SequencesOutputConnector_3617, EsbPackage.eINSTANCE.getSequencesOutputConnector());

			elements.put(EndpointDiagram_3642, EsbPackage.eINSTANCE.getEndpointDiagram());

			elements.put(DefaultEndPoint_3643, EsbPackage.eINSTANCE.getDefaultEndPoint());

			elements.put(DefaultEndPointInputConnector_3644, EsbPackage.eINSTANCE.getDefaultEndPointInputConnector());

			elements.put(DefaultEndPointOutputConnector_3645, EsbPackage.eINSTANCE.getDefaultEndPointOutputConnector());

			elements.put(AddressEndPoint_3646, EsbPackage.eINSTANCE.getAddressEndPoint());

			elements.put(AddressEndPointInputConnector_3647, EsbPackage.eINSTANCE.getAddressEndPointInputConnector());

			elements.put(AddressEndPointOutputConnector_3648, EsbPackage.eINSTANCE.getAddressEndPointOutputConnector());

			elements.put(FailoverEndPoint_3649, EsbPackage.eINSTANCE.getFailoverEndPoint());

			elements.put(FailoverEndPointInputConnector_3650, EsbPackage.eINSTANCE.getFailoverEndPointInputConnector());

			elements.put(FailoverEndPointOutputConnector_3651,
					EsbPackage.eINSTANCE.getFailoverEndPointOutputConnector());

			elements.put(FailoverEndPointWestOutputConnector_3652,
					EsbPackage.eINSTANCE.getFailoverEndPointWestOutputConnector());

			elements.put(MediatorFlow_3777, EsbPackage.eINSTANCE.getMediatorFlow());

			elements.put(RecipientListEndPoint_3696, EsbPackage.eINSTANCE.getRecipientListEndPoint());

			elements.put(RecipientListEndPointInputConnector_3697,
					EsbPackage.eINSTANCE.getRecipientListEndPointInputConnector());

			elements.put(RecipientListEndPointOutputConnector_3698,
					EsbPackage.eINSTANCE.getRecipientListEndPointOutputConnector());

			elements.put(RecipientListEndPointWestOutputConnector_3699,
					EsbPackage.eINSTANCE.getRecipientListEndPointWestOutputConnector());

			elements.put(MediatorFlow_3778, EsbPackage.eINSTANCE.getMediatorFlow());

			elements.put(WSDLEndPoint_3653, EsbPackage.eINSTANCE.getWSDLEndPoint());

			elements.put(WSDLEndPointInputConnector_3654, EsbPackage.eINSTANCE.getWSDLEndPointInputConnector());

			elements.put(WSDLEndPointOutputConnector_3655, EsbPackage.eINSTANCE.getWSDLEndPointOutputConnector());

			elements.put(LoadBalanceEndPoint_3656, EsbPackage.eINSTANCE.getLoadBalanceEndPoint());

			elements.put(LoadBalanceEndPointInputConnector_3657,
					EsbPackage.eINSTANCE.getLoadBalanceEndPointInputConnector());

			elements.put(LoadBalanceEndPointOutputConnector_3658,
					EsbPackage.eINSTANCE.getLoadBalanceEndPointOutputConnector());

			elements.put(LoadBalanceEndPointWestOutputConnector_3659,
					EsbPackage.eINSTANCE.getLoadBalanceEndPointWestOutputConnector());

			elements.put(MediatorFlow_3779, EsbPackage.eINSTANCE.getMediatorFlow());

			elements.put(HTTPEndpoint_3712, EsbPackage.eINSTANCE.getHTTPEndpoint());

			elements.put(HTTPEndPointInputConnector_3713, EsbPackage.eINSTANCE.getHTTPEndPointInputConnector());

			elements.put(HTTPEndPointOutputConnector_3714, EsbPackage.eINSTANCE.getHTTPEndPointOutputConnector());

			elements.put(TemplateEndpoint_3725, EsbPackage.eINSTANCE.getTemplateEndpoint());

			elements.put(TemplateEndpointInputConnector_3726, EsbPackage.eINSTANCE.getTemplateEndpointInputConnector());

			elements.put(TemplateEndpointOutputConnector_3727,
					EsbPackage.eINSTANCE.getTemplateEndpointOutputConnector());

			elements.put(LocalEntry_3663, EsbPackage.eINSTANCE.getLocalEntry());

			elements.put(Template_3664, EsbPackage.eINSTANCE.getTemplate());

			elements.put(Sequences_3665, EsbPackage.eINSTANCE.getSequences());

			elements.put(EndpointDiagram_3666, EsbPackage.eINSTANCE.getEndpointDiagram());

			elements.put(Task_3667, EsbPackage.eINSTANCE.getTask());

			elements.put(SynapseAPI_3668, EsbPackage.eINSTANCE.getSynapseAPI());

			elements.put(APIResource_3669, EsbPackage.eINSTANCE.getAPIResource());

			elements.put(APIResourceInputConnector_3670, EsbPackage.eINSTANCE.getAPIResourceInputConnector());

			elements.put(APIResourceOutputConnector_3671, EsbPackage.eINSTANCE.getAPIResourceOutputConnector());

			elements.put(APIResourceOutSequenceOutputConnector_3730,
					EsbPackage.eINSTANCE.getAPIResourceOutSequenceOutputConnector());

			elements.put(APIResourceFaultInputConnector_3672, EsbPackage.eINSTANCE.getAPIResourceFaultInputConnector());

			elements.put(ProxyServiceContainer_3673, EsbPackage.eINSTANCE.getProxyServiceContainer());

			elements.put(APIResourceInSequenceInputConnector_3747,
					EsbPackage.eINSTANCE.getAPIResourceInSequenceInputConnector());

			elements.put(ComplexEndpoints_3677, EsbPackage.eINSTANCE.getComplexEndpoints());

			elements.put(MediatorFlow_3678, EsbPackage.eINSTANCE.getMediatorFlow());

			elements.put(ComplexEndpointsOutputConnector_3679,
					EsbPackage.eINSTANCE.getComplexEndpointsOutputConnector());

			elements.put(MessageStore_3715, EsbPackage.eINSTANCE.getMessageStore());

			elements.put(MessageProcessor_3701, EsbPackage.eINSTANCE.getMessageProcessor());

			elements.put(InboundEndpoint_3767, EsbPackage.eINSTANCE.getInboundEndpoint());

			elements.put(InboundEndpointSequenceInputConnector_3768,
					EsbPackage.eINSTANCE.getInboundEndpointSequenceInputConnector());

			elements.put(InboundEndpointSequenceOutputConnector_3769,
					EsbPackage.eINSTANCE.getInboundEndpointSequenceOutputConnector());

			elements.put(InboundEndpointOnErrorSequenceInputConnector_3770,
					EsbPackage.eINSTANCE.getInboundEndpointOnErrorSequenceInputConnector());

			elements.put(InboundEndpointOnErrorSequenceOutputConnector_3771,
					EsbPackage.eINSTANCE.getInboundEndpointOnErrorSequenceOutputConnector());

			elements.put(InboundEndpointContainer_3772, EsbPackage.eINSTANCE.getInboundEndpointContainer());

			elements.put(InboundEndpointSequenceContainer_3773,
					EsbPackage.eINSTANCE.getInboundEndpointSequenceContainer());

			elements.put(MediatorFlow_3774, EsbPackage.eINSTANCE.getMediatorFlow());

			elements.put(InboundEndpointOnErrorSequenceContainer_3775,
					EsbPackage.eINSTANCE.getInboundEndpointOnErrorSequenceContainer());

			elements.put(MediatorFlow_3776, EsbPackage.eINSTANCE.getMediatorFlow());

			elements.put(EsbLink_4001, EsbPackage.eINSTANCE.getEsbLink());
		}
		return (ENamedElement) elements.get(type);
	}

	/**
	 * @generated
	 */
	private static IElementType getElementType(String id) {
		return ElementTypeRegistry.getInstance().getType(id);
	}

	/**
	 * @generated
	 */
	public static boolean isKnownElementType(IElementType elementType) {
		if (KNOWN_ELEMENT_TYPES == null) {
			KNOWN_ELEMENT_TYPES = new HashSet<IElementType>();
			KNOWN_ELEMENT_TYPES.add(EsbDiagram_1000);
			KNOWN_ELEMENT_TYPES.add(EsbServer_2001);
			KNOWN_ELEMENT_TYPES.add(ProxyService_3001);
			KNOWN_ELEMENT_TYPES.add(ProxyOutputConnector_3002);
			KNOWN_ELEMENT_TYPES.add(ProxyInputConnector_3003);
			KNOWN_ELEMENT_TYPES.add(ProxyOutSequenceOutputConnector_3729);
			KNOWN_ELEMENT_TYPES.add(ProxyFaultInputConnector_3489);
			KNOWN_ELEMENT_TYPES.add(ProxyServiceContainer_3486);
			KNOWN_ELEMENT_TYPES.add(ProxyServiceSequenceAndEndpointContainer_3487);
			KNOWN_ELEMENT_TYPES.add(MediatorFlow_3608);
			KNOWN_ELEMENT_TYPES.add(DropMediator_3491);
			KNOWN_ELEMENT_TYPES.add(DropMediatorInputConnector_3008);
			KNOWN_ELEMENT_TYPES.add(PropertyMediator_3492);
			KNOWN_ELEMENT_TYPES.add(PropertyMediatorInputConnector_3033);
			KNOWN_ELEMENT_TYPES.add(PropertyMediatorOutputConnector_3034);
			KNOWN_ELEMENT_TYPES.add(ThrottleMediator_3493);
			KNOWN_ELEMENT_TYPES.add(ThrottleMediatorInputConnector_3121);
			KNOWN_ELEMENT_TYPES.add(ThrottleMediatorOutputConnector_3122);
			KNOWN_ELEMENT_TYPES.add(ThrottleMediatorOnAcceptOutputConnector_3581);
			KNOWN_ELEMENT_TYPES.add(ThrottleMediatorOnRejectOutputConnector_3582);
			KNOWN_ELEMENT_TYPES.add(ThrottleContainer_3583);
			KNOWN_ELEMENT_TYPES.add(ThrottleOnAcceptContainer_3584);
			KNOWN_ELEMENT_TYPES.add(MediatorFlow_3585);
			KNOWN_ELEMENT_TYPES.add(FilterMediator_3494);
			KNOWN_ELEMENT_TYPES.add(FilterMediatorInputConnector_3010);
			KNOWN_ELEMENT_TYPES.add(FilterMediatorOutputConnector_3534);
			KNOWN_ELEMENT_TYPES.add(FilterMediatorPassOutputConnector_3011);
			KNOWN_ELEMENT_TYPES.add(FilterMediatorFailOutputConnector_3012);
			KNOWN_ELEMENT_TYPES.add(FilterContainer_3531);
			KNOWN_ELEMENT_TYPES.add(FilterPassContainer_3535);
			KNOWN_ELEMENT_TYPES.add(MediatorFlow_3536);
			KNOWN_ELEMENT_TYPES.add(LogMediator_3495);
			KNOWN_ELEMENT_TYPES.add(LogMediatorInputConnector_3018);
			KNOWN_ELEMENT_TYPES.add(LogMediatorOutputConnector_3019);
			KNOWN_ELEMENT_TYPES.add(EnrichMediator_3496);
			KNOWN_ELEMENT_TYPES.add(EnrichMediatorInputConnector_3036);
			KNOWN_ELEMENT_TYPES.add(EnrichMediatorOutputConnector_3037);
			KNOWN_ELEMENT_TYPES.add(XSLTMediator_3497);
			KNOWN_ELEMENT_TYPES.add(XSLTMediatorInputConnector_3039);
			KNOWN_ELEMENT_TYPES.add(XSLTMediatorOutputConnector_3040);
			KNOWN_ELEMENT_TYPES.add(SwitchMediator_3498);
			KNOWN_ELEMENT_TYPES.add(SwitchMediatorInputConnector_3042);
			KNOWN_ELEMENT_TYPES.add(SwitchMediatorOutputConnector_3499);
			KNOWN_ELEMENT_TYPES.add(SwitchCaseBranchOutputConnector_3043);
			KNOWN_ELEMENT_TYPES.add(SwitchDefaultBranchOutputConnector_3044);
			KNOWN_ELEMENT_TYPES.add(SwitchMediatorContainer_3500);
			KNOWN_ELEMENT_TYPES.add(SwitchCaseParentContainer_3732);
			KNOWN_ELEMENT_TYPES.add(SwitchCaseContainer_3733);
			KNOWN_ELEMENT_TYPES.add(MediatorFlow_3502);
			KNOWN_ELEMENT_TYPES.add(Sequence_3503);
			KNOWN_ELEMENT_TYPES.add(SequenceInputConnector_3049);
			KNOWN_ELEMENT_TYPES.add(SequenceOutputConnector_3050);
			KNOWN_ELEMENT_TYPES.add(EventMediator_3504);
			KNOWN_ELEMENT_TYPES.add(EventMediatorInputConnector_3052);
			KNOWN_ELEMENT_TYPES.add(EventMediatorOutputConnector_3053);
			KNOWN_ELEMENT_TYPES.add(EntitlementMediator_3505);
			KNOWN_ELEMENT_TYPES.add(EntitlementMediatorInputConnector_3055);
			KNOWN_ELEMENT_TYPES.add(EntitlementMediatorOutputConnector_3056);
			KNOWN_ELEMENT_TYPES.add(EntitlementMediatorOnRejectOutputConnector_3748);
			KNOWN_ELEMENT_TYPES.add(EntitlementMediatorOnAcceptOutputConnector_3749);
			KNOWN_ELEMENT_TYPES.add(EntitlementMediatorAdviceOutputConnector_3750);
			KNOWN_ELEMENT_TYPES.add(EntitlementMediatorObligationsOutputConnector_3751);
			KNOWN_ELEMENT_TYPES.add(EntitlementContainer_3752);
			KNOWN_ELEMENT_TYPES.add(EntitlementOnRejectContainer_3753);
			KNOWN_ELEMENT_TYPES.add(MediatorFlow_3754);
			KNOWN_ELEMENT_TYPES.add(ClassMediator_3506);
			KNOWN_ELEMENT_TYPES.add(ClassMediatorInputConnector_3058);
			KNOWN_ELEMENT_TYPES.add(ClassMediatorOutputConnector_3059);
			KNOWN_ELEMENT_TYPES.add(SpringMediator_3507);
			KNOWN_ELEMENT_TYPES.add(SpringMediatorInputConnector_3061);
			KNOWN_ELEMENT_TYPES.add(SpringMediatorOutputConnector_3062);
			KNOWN_ELEMENT_TYPES.add(ScriptMediator_3508);
			KNOWN_ELEMENT_TYPES.add(ScriptMediatorInputConnector_3064);
			KNOWN_ELEMENT_TYPES.add(ScriptMediatorOutputConnector_3065);
			KNOWN_ELEMENT_TYPES.add(FaultMediator_3509);
			KNOWN_ELEMENT_TYPES.add(FaultMediatorInputConnector_3067);
			KNOWN_ELEMENT_TYPES.add(FaultMediatorOutputConnector_3068);
			KNOWN_ELEMENT_TYPES.add(XQueryMediator_3510);
			KNOWN_ELEMENT_TYPES.add(XQueryMediatorInputConnector_3070);
			KNOWN_ELEMENT_TYPES.add(XQueryMediatorOutputConnector_3071);
			KNOWN_ELEMENT_TYPES.add(CommandMediator_3511);
			KNOWN_ELEMENT_TYPES.add(CommandMediatorInputConnector_3073);
			KNOWN_ELEMENT_TYPES.add(CommandMediatorOutputConnector_3074);
			KNOWN_ELEMENT_TYPES.add(DBLookupMediator_3512);
			KNOWN_ELEMENT_TYPES.add(DBLookupMediatorInputConnector_3076);
			KNOWN_ELEMENT_TYPES.add(DBLookupMediatorOutputConnector_3077);
			KNOWN_ELEMENT_TYPES.add(DBReportMediator_3513);
			KNOWN_ELEMENT_TYPES.add(DBReportMediatorInputConnector_3079);
			KNOWN_ELEMENT_TYPES.add(DBReportMediatorOutputConnector_3080);
			KNOWN_ELEMENT_TYPES.add(SmooksMediator_3514);
			KNOWN_ELEMENT_TYPES.add(SmooksMediatorInputConnector_3082);
			KNOWN_ELEMENT_TYPES.add(SmooksMediatorOutputConnector_3083);
			KNOWN_ELEMENT_TYPES.add(SendMediator_3515);
			KNOWN_ELEMENT_TYPES.add(SendMediatorInputConnector_3085);
			KNOWN_ELEMENT_TYPES.add(SendMediatorOutputConnector_3086);
			KNOWN_ELEMENT_TYPES.add(SendMediatorEndpointOutputConnector_3539);
			KNOWN_ELEMENT_TYPES.add(MediatorFlow_3728);
			KNOWN_ELEMENT_TYPES.add(HeaderMediator_3516);
			KNOWN_ELEMENT_TYPES.add(HeaderMediatorInputConnector_3100);
			KNOWN_ELEMENT_TYPES.add(HeaderMediatorOutputConnector_3101);
			KNOWN_ELEMENT_TYPES.add(CloneMediator_3517);
			KNOWN_ELEMENT_TYPES.add(CloneMediatorInputConnector_3103);
			KNOWN_ELEMENT_TYPES.add(CloneMediatorOutputConnector_3104);
			KNOWN_ELEMENT_TYPES.add(CloneMediatorTargetOutputConnector_3133);
			KNOWN_ELEMENT_TYPES.add(CloneMediatorContainer_3603);
			KNOWN_ELEMENT_TYPES.add(CloneTargetContainer_3604);
			KNOWN_ELEMENT_TYPES.add(MediatorFlow_3605);
			KNOWN_ELEMENT_TYPES.add(CacheMediator_3518);
			KNOWN_ELEMENT_TYPES.add(CacheMediatorInputConnector_3106);
			KNOWN_ELEMENT_TYPES.add(CacheMediatorOutputConnector_3107);
			KNOWN_ELEMENT_TYPES.add(CacheMediatorOnHitOutputConnector_3618);
			KNOWN_ELEMENT_TYPES.add(MediatorFlow_3619);
			KNOWN_ELEMENT_TYPES.add(IterateMediator_3519);
			KNOWN_ELEMENT_TYPES.add(IterateMediatorInputConnector_3109);
			KNOWN_ELEMENT_TYPES.add(IterateMediatorOutputConnector_3110);
			KNOWN_ELEMENT_TYPES.add(IterateMediatorTargetOutputConnector_3606);
			KNOWN_ELEMENT_TYPES.add(MediatorFlow_3607);
			KNOWN_ELEMENT_TYPES.add(CalloutMediator_3520);
			KNOWN_ELEMENT_TYPES.add(CalloutMediatorInputConnector_3115);
			KNOWN_ELEMENT_TYPES.add(CalloutMediatorOutputConnector_3116);
			KNOWN_ELEMENT_TYPES.add(TransactionMediator_3521);
			KNOWN_ELEMENT_TYPES.add(TransactionMediatorInputConnector_3118);
			KNOWN_ELEMENT_TYPES.add(TransactionMediatorOutputConnector_3119);
			KNOWN_ELEMENT_TYPES.add(RMSequenceMediator_3522);
			KNOWN_ELEMENT_TYPES.add(RMSequenceMediatorInputConnector_3124);
			KNOWN_ELEMENT_TYPES.add(RMSequenceMediatorOutputConnector_3125);
			KNOWN_ELEMENT_TYPES.add(RuleMediator_3523);
			KNOWN_ELEMENT_TYPES.add(RuleMediatorInputConnector_3127);
			KNOWN_ELEMENT_TYPES.add(RuleMediatorOutputConnector_3128);
			KNOWN_ELEMENT_TYPES.add(RuleMediatorChildMediatorsOutputConnector_3640);
			KNOWN_ELEMENT_TYPES.add(MediatorFlow_3641);
			KNOWN_ELEMENT_TYPES.add(OAuthMediator_3524);
			KNOWN_ELEMENT_TYPES.add(OAuthMediatorInputConnector_3130);
			KNOWN_ELEMENT_TYPES.add(OAuthMediatorOutputConnector_3131);
			KNOWN_ELEMENT_TYPES.add(AggregateMediator_3525);
			KNOWN_ELEMENT_TYPES.add(AggregateMediatorInputConnector_3112);
			KNOWN_ELEMENT_TYPES.add(AggregateMediatorOutputConnector_3113);
			KNOWN_ELEMENT_TYPES.add(AggregateMediatorOnCompleteOutputConnector_3132);
			KNOWN_ELEMENT_TYPES.add(MediatorFlow_3526);
			KNOWN_ELEMENT_TYPES.add(StoreMediator_3588);
			KNOWN_ELEMENT_TYPES.add(StoreMediatorInputConnector_3589);
			KNOWN_ELEMENT_TYPES.add(StoreMediatorOutputConnector_3590);
			KNOWN_ELEMENT_TYPES.add(BuilderMediator_3591);
			KNOWN_ELEMENT_TYPES.add(BuilderMediatorInputConnector_3592);
			KNOWN_ELEMENT_TYPES.add(BuilderMediatorOutputConector_3593);
			KNOWN_ELEMENT_TYPES.add(CallTemplateMediator_3594);
			KNOWN_ELEMENT_TYPES.add(CallTemplateMediatorInputConnector_3595);
			KNOWN_ELEMENT_TYPES.add(CallTemplateMediatorOutputConnector_3596);
			KNOWN_ELEMENT_TYPES.add(PayloadFactoryMediator_3597);
			KNOWN_ELEMENT_TYPES.add(PayloadFactoryMediatorInputConnector_3598);
			KNOWN_ELEMENT_TYPES.add(PayloadFactoryMediatorOutputConnector_3599);
			KNOWN_ELEMENT_TYPES.add(EnqueueMediator_3600);
			KNOWN_ELEMENT_TYPES.add(EnqueueMediatorInputConnector_3601);
			KNOWN_ELEMENT_TYPES.add(EnqueueMediatorOutputConnector_3602);
			KNOWN_ELEMENT_TYPES.add(URLRewriteMediator_3620);
			KNOWN_ELEMENT_TYPES.add(URLRewriteMediatorInputConnector_3621);
			KNOWN_ELEMENT_TYPES.add(URLRewriteMediatorOutputConnector_3622);
			KNOWN_ELEMENT_TYPES.add(ValidateMediator_3623);
			KNOWN_ELEMENT_TYPES.add(ValidateMediatorInputConnector_3624);
			KNOWN_ELEMENT_TYPES.add(ValidateMediatorOutputConnector_3625);
			KNOWN_ELEMENT_TYPES.add(ValidateMediatorOnFailOutputConnector_3626);
			KNOWN_ELEMENT_TYPES.add(MediatorFlow_3627);
			KNOWN_ELEMENT_TYPES.add(RouterMediator_3628);
			KNOWN_ELEMENT_TYPES.add(RouterMediatorInputConnector_3629);
			KNOWN_ELEMENT_TYPES.add(RouterMediatorOutputConnector_3630);
			KNOWN_ELEMENT_TYPES.add(RouterMediatorTargetOutputConnector_3631);
			KNOWN_ELEMENT_TYPES.add(RouterMediatorContainer_3632);
			KNOWN_ELEMENT_TYPES.add(RouterTargetContainer_3633);
			KNOWN_ELEMENT_TYPES.add(MediatorFlow_3634);
			KNOWN_ELEMENT_TYPES.add(ConditionalRouterMediator_3635);
			KNOWN_ELEMENT_TYPES.add(ConditionalRouterMediatorInputConnector_3636);
			KNOWN_ELEMENT_TYPES.add(ConditionalRouterMediatorOutputConnector_3637);
			KNOWN_ELEMENT_TYPES.add(ConditionalRouterMediatorAdditionalOutputConnector_3638);
			KNOWN_ELEMENT_TYPES.add(MediatorFlow_3639);
			KNOWN_ELEMENT_TYPES.add(BAMMediator_3680);
			KNOWN_ELEMENT_TYPES.add(BAMMediatorInputConnector_3681);
			KNOWN_ELEMENT_TYPES.add(BAMMediatorOutputConnector_3682);
			KNOWN_ELEMENT_TYPES.add(BeanMediator_3683);
			KNOWN_ELEMENT_TYPES.add(BeanMediatorInputConnector_3684);
			KNOWN_ELEMENT_TYPES.add(BeanMediatorOutputConnector_3685);
			KNOWN_ELEMENT_TYPES.add(EJBMediator_3686);
			KNOWN_ELEMENT_TYPES.add(EJBMediatorInputConnector_3687);
			KNOWN_ELEMENT_TYPES.add(EJBMediatorOutputConnector_3688);
			KNOWN_ELEMENT_TYPES.add(DefaultEndPoint_3609);
			KNOWN_ELEMENT_TYPES.add(DefaultEndPointInputConnector_3021);
			KNOWN_ELEMENT_TYPES.add(DefaultEndPointOutputConnector_3022);
			KNOWN_ELEMENT_TYPES.add(AddressEndPoint_3610);
			KNOWN_ELEMENT_TYPES.add(AddressEndPointInputConnector_3030);
			KNOWN_ELEMENT_TYPES.add(AddressEndPointOutputConnector_3031);
			KNOWN_ELEMENT_TYPES.add(FailoverEndPoint_3611);
			KNOWN_ELEMENT_TYPES.add(FailoverEndPointInputConnector_3088);
			KNOWN_ELEMENT_TYPES.add(FailoverEndPointOutputConnector_3090);
			KNOWN_ELEMENT_TYPES.add(FailoverEndPointWestOutputConnector_3097);
			KNOWN_ELEMENT_TYPES.add(RecipientListEndPoint_3692);
			KNOWN_ELEMENT_TYPES.add(RecipientListEndPointInputConnector_3693);
			KNOWN_ELEMENT_TYPES.add(RecipientListEndPointOutputConnector_3694);
			KNOWN_ELEMENT_TYPES.add(RecipientListEndPointWestOutputConnector_3695);
			KNOWN_ELEMENT_TYPES.add(WSDLEndPoint_3612);
			KNOWN_ELEMENT_TYPES.add(WSDLEndPointInputConnector_3092);
			KNOWN_ELEMENT_TYPES.add(WSDLEndPointOutputConnector_3093);
			KNOWN_ELEMENT_TYPES.add(NamedEndpoint_3660);
			KNOWN_ELEMENT_TYPES.add(NamedEndpointInputConnector_3661);
			KNOWN_ELEMENT_TYPES.add(NamedEndpointOutputConnector_3662);
			KNOWN_ELEMENT_TYPES.add(LoadBalanceEndPoint_3613);
			KNOWN_ELEMENT_TYPES.add(LoadBalanceEndPointInputConnector_3095);
			KNOWN_ELEMENT_TYPES.add(LoadBalanceEndPointOutputConnector_3096);
			KNOWN_ELEMENT_TYPES.add(LoadBalanceEndPointWestOutputConnector_3098);
			KNOWN_ELEMENT_TYPES.add(APIResourceEndpoint_3674);
			KNOWN_ELEMENT_TYPES.add(APIResourceEndpointInputConnector_3675);
			KNOWN_ELEMENT_TYPES.add(APIResourceEndpointOutputConnector_3676);
			KNOWN_ELEMENT_TYPES.add(AddressingEndpoint_3689);
			KNOWN_ELEMENT_TYPES.add(AddressingEndpointInputConnector_3690);
			KNOWN_ELEMENT_TYPES.add(AddressingEndpointOutputConnector_3691);
			KNOWN_ELEMENT_TYPES.add(HTTPEndpoint_3709);
			KNOWN_ELEMENT_TYPES.add(HTTPEndPointInputConnector_3710);
			KNOWN_ELEMENT_TYPES.add(HTTPEndPointOutputConnector_3711);
			KNOWN_ELEMENT_TYPES.add(TemplateEndpoint_3716);
			KNOWN_ELEMENT_TYPES.add(TemplateEndpointInputConnector_3717);
			KNOWN_ELEMENT_TYPES.add(TemplateEndpointOutputConnector_3718);
			KNOWN_ELEMENT_TYPES.add(CloudConnector_3719);
			KNOWN_ELEMENT_TYPES.add(CloudConnectorInputConnector_3720);
			KNOWN_ELEMENT_TYPES.add(CloudConnectorOutputConnector_3721);
			KNOWN_ELEMENT_TYPES.add(CloudConnectorOperation_3722);
			KNOWN_ELEMENT_TYPES.add(CloudConnectorOperationInputConnector_3723);
			KNOWN_ELEMENT_TYPES.add(CloudConnectorOperationOutputConnector_3724);
			KNOWN_ELEMENT_TYPES.add(LoopBackMediator_3736);
			KNOWN_ELEMENT_TYPES.add(LoopBackMediatorInputConnector_3737);
			KNOWN_ELEMENT_TYPES.add(LoopBackMediatorOutputConnector_3738);
			KNOWN_ELEMENT_TYPES.add(RespondMediator_3739);
			KNOWN_ELEMENT_TYPES.add(RespondMediatorInputConnector_3740);
			KNOWN_ELEMENT_TYPES.add(RespondMediatorOutputConnector_3741);
			KNOWN_ELEMENT_TYPES.add(CallMediator_3742);
			KNOWN_ELEMENT_TYPES.add(CallMediatorInputConnector_3743);
			KNOWN_ELEMENT_TYPES.add(CallMediatorOutputConnector_3744);
			KNOWN_ELEMENT_TYPES.add(CallMediatorEndpointOutputConnector_3745);
			KNOWN_ELEMENT_TYPES.add(MediatorFlow_3746);
			KNOWN_ELEMENT_TYPES.add(DataMapperMediator_3761);
			KNOWN_ELEMENT_TYPES.add(DataMapperMediatorInputConnector_3762);
			KNOWN_ELEMENT_TYPES.add(DataMapperMediatorOutputConnector_3763);
			KNOWN_ELEMENT_TYPES.add(FastXSLTMediator_3764);
			KNOWN_ELEMENT_TYPES.add(FastXSLTMediatorInputConnector_3765);
			KNOWN_ELEMENT_TYPES.add(FastXSLTMediatorOutputConnector_3766);
			KNOWN_ELEMENT_TYPES.add(ForEachMediator_3780);
			KNOWN_ELEMENT_TYPES.add(ForEachMediatorInputConnector_3781);
			KNOWN_ELEMENT_TYPES.add(ForEachMediatorOutputConnector_3782);
			KNOWN_ELEMENT_TYPES.add(ForEachMediatorTargetOutputConnector_3783);
			KNOWN_ELEMENT_TYPES.add(MediatorFlow_3784);
			KNOWN_ELEMENT_TYPES.add(PublishEventMediator_3785);
			KNOWN_ELEMENT_TYPES.add(PublishEventMediatorInputConnector_3786);
			KNOWN_ELEMENT_TYPES.add(PublishEventMediatorOutputConnector_3787);
			KNOWN_ELEMENT_TYPES.add(EntitlementOnAcceptContainer_3755);
			KNOWN_ELEMENT_TYPES.add(MediatorFlow_3756);
			KNOWN_ELEMENT_TYPES.add(EntitlementAdviceContainer_3757);
			KNOWN_ELEMENT_TYPES.add(MediatorFlow_3758);
			KNOWN_ELEMENT_TYPES.add(EntitlementObligationsContainer_3759);
			KNOWN_ELEMENT_TYPES.add(MediatorFlow_3760);
			KNOWN_ELEMENT_TYPES.add(SwitchDefaultParentContainer_3734);
			KNOWN_ELEMENT_TYPES.add(SwitchDefaultContainer_3735);
			KNOWN_ELEMENT_TYPES.add(MediatorFlow_3528);
			KNOWN_ELEMENT_TYPES.add(FilterFailContainer_3537);
			KNOWN_ELEMENT_TYPES.add(MediatorFlow_3538);
			KNOWN_ELEMENT_TYPES.add(ThrottleOnRejectContainer_3586);
			KNOWN_ELEMENT_TYPES.add(MediatorFlow_3587);
			KNOWN_ELEMENT_TYPES.add(ProxyServiceFaultContainer_3488);
			KNOWN_ELEMENT_TYPES.add(MediatorFlow_3530);
			KNOWN_ELEMENT_TYPES.add(ProxyInSequenceInputConnector_3731);
			KNOWN_ELEMENT_TYPES.add(MessageMediator_3045);
			KNOWN_ELEMENT_TYPES.add(MessageInputConnector_3046);
			KNOWN_ELEMENT_TYPES.add(MessageOutputConnector_3047);
			KNOWN_ELEMENT_TYPES.add(MergeNode_3013);
			KNOWN_ELEMENT_TYPES.add(MergeNodeFirstInputConnector_3014);
			KNOWN_ELEMENT_TYPES.add(MergeNodeSecondInputConnector_3015);
			KNOWN_ELEMENT_TYPES.add(MergeNodeOutputConnector_3016);
			KNOWN_ELEMENT_TYPES.add(Sequences_3614);
			KNOWN_ELEMENT_TYPES.add(MediatorFlow_3615);
			KNOWN_ELEMENT_TYPES.add(SequencesInputConnector_3616);
			KNOWN_ELEMENT_TYPES.add(SequencesOutputConnector_3617);
			KNOWN_ELEMENT_TYPES.add(EndpointDiagram_3642);
			KNOWN_ELEMENT_TYPES.add(DefaultEndPoint_3643);
			KNOWN_ELEMENT_TYPES.add(DefaultEndPointInputConnector_3644);
			KNOWN_ELEMENT_TYPES.add(DefaultEndPointOutputConnector_3645);
			KNOWN_ELEMENT_TYPES.add(AddressEndPoint_3646);
			KNOWN_ELEMENT_TYPES.add(AddressEndPointInputConnector_3647);
			KNOWN_ELEMENT_TYPES.add(AddressEndPointOutputConnector_3648);
			KNOWN_ELEMENT_TYPES.add(FailoverEndPoint_3649);
			KNOWN_ELEMENT_TYPES.add(FailoverEndPointInputConnector_3650);
			KNOWN_ELEMENT_TYPES.add(FailoverEndPointOutputConnector_3651);
			KNOWN_ELEMENT_TYPES.add(FailoverEndPointWestOutputConnector_3652);
			KNOWN_ELEMENT_TYPES.add(MediatorFlow_3777);
			KNOWN_ELEMENT_TYPES.add(RecipientListEndPoint_3696);
			KNOWN_ELEMENT_TYPES.add(RecipientListEndPointInputConnector_3697);
			KNOWN_ELEMENT_TYPES.add(RecipientListEndPointOutputConnector_3698);
			KNOWN_ELEMENT_TYPES.add(RecipientListEndPointWestOutputConnector_3699);
			KNOWN_ELEMENT_TYPES.add(MediatorFlow_3778);
			KNOWN_ELEMENT_TYPES.add(WSDLEndPoint_3653);
			KNOWN_ELEMENT_TYPES.add(WSDLEndPointInputConnector_3654);
			KNOWN_ELEMENT_TYPES.add(WSDLEndPointOutputConnector_3655);
			KNOWN_ELEMENT_TYPES.add(LoadBalanceEndPoint_3656);
			KNOWN_ELEMENT_TYPES.add(LoadBalanceEndPointInputConnector_3657);
			KNOWN_ELEMENT_TYPES.add(LoadBalanceEndPointOutputConnector_3658);
			KNOWN_ELEMENT_TYPES.add(LoadBalanceEndPointWestOutputConnector_3659);
			KNOWN_ELEMENT_TYPES.add(MediatorFlow_3779);
			KNOWN_ELEMENT_TYPES.add(HTTPEndpoint_3712);
			KNOWN_ELEMENT_TYPES.add(HTTPEndPointInputConnector_3713);
			KNOWN_ELEMENT_TYPES.add(HTTPEndPointOutputConnector_3714);
			KNOWN_ELEMENT_TYPES.add(TemplateEndpoint_3725);
			KNOWN_ELEMENT_TYPES.add(TemplateEndpointInputConnector_3726);
			KNOWN_ELEMENT_TYPES.add(TemplateEndpointOutputConnector_3727);
			KNOWN_ELEMENT_TYPES.add(LocalEntry_3663);
			KNOWN_ELEMENT_TYPES.add(Template_3664);
			KNOWN_ELEMENT_TYPES.add(Sequences_3665);
			KNOWN_ELEMENT_TYPES.add(EndpointDiagram_3666);
			KNOWN_ELEMENT_TYPES.add(Task_3667);
			KNOWN_ELEMENT_TYPES.add(SynapseAPI_3668);
			KNOWN_ELEMENT_TYPES.add(APIResource_3669);
			KNOWN_ELEMENT_TYPES.add(APIResourceInputConnector_3670);
			KNOWN_ELEMENT_TYPES.add(APIResourceOutputConnector_3671);
			KNOWN_ELEMENT_TYPES.add(APIResourceOutSequenceOutputConnector_3730);
			KNOWN_ELEMENT_TYPES.add(APIResourceFaultInputConnector_3672);
			KNOWN_ELEMENT_TYPES.add(ProxyServiceContainer_3673);
			KNOWN_ELEMENT_TYPES.add(APIResourceInSequenceInputConnector_3747);
			KNOWN_ELEMENT_TYPES.add(ComplexEndpoints_3677);
			KNOWN_ELEMENT_TYPES.add(MediatorFlow_3678);
			KNOWN_ELEMENT_TYPES.add(ComplexEndpointsOutputConnector_3679);
			KNOWN_ELEMENT_TYPES.add(MessageStore_3715);
			KNOWN_ELEMENT_TYPES.add(MessageProcessor_3701);
			KNOWN_ELEMENT_TYPES.add(InboundEndpoint_3767);
			KNOWN_ELEMENT_TYPES.add(InboundEndpointSequenceInputConnector_3768);
			KNOWN_ELEMENT_TYPES.add(InboundEndpointSequenceOutputConnector_3769);
			KNOWN_ELEMENT_TYPES.add(InboundEndpointOnErrorSequenceInputConnector_3770);
			KNOWN_ELEMENT_TYPES.add(InboundEndpointOnErrorSequenceOutputConnector_3771);
			KNOWN_ELEMENT_TYPES.add(InboundEndpointContainer_3772);
			KNOWN_ELEMENT_TYPES.add(InboundEndpointSequenceContainer_3773);
			KNOWN_ELEMENT_TYPES.add(MediatorFlow_3774);
			KNOWN_ELEMENT_TYPES.add(InboundEndpointOnErrorSequenceContainer_3775);
			KNOWN_ELEMENT_TYPES.add(MediatorFlow_3776);
			KNOWN_ELEMENT_TYPES.add(EsbLink_4001);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	 * @generated
	 */
	public static IElementType getElementType(int visualID) {
		switch (visualID) {
		case EsbDiagramEditPart.VISUAL_ID:
			return EsbDiagram_1000;
		case EsbServerEditPart.VISUAL_ID:
			return EsbServer_2001;
		case ProxyServiceEditPart.VISUAL_ID:
			return ProxyService_3001;
		case ProxyOutputConnectorEditPart.VISUAL_ID:
			return ProxyOutputConnector_3002;
		case ProxyInputConnectorEditPart.VISUAL_ID:
			return ProxyInputConnector_3003;
		case ProxyOutSequenceOutputConnectorEditPart.VISUAL_ID:
			return ProxyOutSequenceOutputConnector_3729;
		case ProxyFaultInputConnectorEditPart.VISUAL_ID:
			return ProxyFaultInputConnector_3489;
		case ProxyServiceContainerEditPart.VISUAL_ID:
			return ProxyServiceContainer_3486;
		case ProxyServiceSequenceAndEndpointContainerEditPart.VISUAL_ID:
			return ProxyServiceSequenceAndEndpointContainer_3487;
		case MediatorFlowEditPart.VISUAL_ID:
			return MediatorFlow_3608;
		case DropMediatorEditPart.VISUAL_ID:
			return DropMediator_3491;
		case DropMediatorInputConnectorEditPart.VISUAL_ID:
			return DropMediatorInputConnector_3008;
		case PropertyMediatorEditPart.VISUAL_ID:
			return PropertyMediator_3492;
		case PropertyMediatorInputConnectorEditPart.VISUAL_ID:
			return PropertyMediatorInputConnector_3033;
		case PropertyMediatorOutputConnectorEditPart.VISUAL_ID:
			return PropertyMediatorOutputConnector_3034;
		case ThrottleMediatorEditPart.VISUAL_ID:
			return ThrottleMediator_3493;
		case ThrottleMediatorInputConnectorEditPart.VISUAL_ID:
			return ThrottleMediatorInputConnector_3121;
		case ThrottleMediatorOutputConnectorEditPart.VISUAL_ID:
			return ThrottleMediatorOutputConnector_3122;
		case ThrottleMediatorOnAcceptOutputConnectorEditPart.VISUAL_ID:
			return ThrottleMediatorOnAcceptOutputConnector_3581;
		case ThrottleMediatorOnRejectOutputConnectorEditPart.VISUAL_ID:
			return ThrottleMediatorOnRejectOutputConnector_3582;
		case ThrottleContainerEditPart.VISUAL_ID:
			return ThrottleContainer_3583;
		case ThrottleOnAcceptContainerEditPart.VISUAL_ID:
			return ThrottleOnAcceptContainer_3584;
		case MediatorFlow9EditPart.VISUAL_ID:
			return MediatorFlow_3585;
		case FilterMediatorEditPart.VISUAL_ID:
			return FilterMediator_3494;
		case FilterMediatorInputConnectorEditPart.VISUAL_ID:
			return FilterMediatorInputConnector_3010;
		case FilterMediatorOutputConnectorEditPart.VISUAL_ID:
			return FilterMediatorOutputConnector_3534;
		case FilterMediatorPassOutputConnectorEditPart.VISUAL_ID:
			return FilterMediatorPassOutputConnector_3011;
		case FilterMediatorFailOutputConnectorEditPart.VISUAL_ID:
			return FilterMediatorFailOutputConnector_3012;
		case FilterContainerEditPart.VISUAL_ID:
			return FilterContainer_3531;
		case FilterPassContainerEditPart.VISUAL_ID:
			return FilterPassContainer_3535;
		case MediatorFlow7EditPart.VISUAL_ID:
			return MediatorFlow_3536;
		case LogMediatorEditPart.VISUAL_ID:
			return LogMediator_3495;
		case LogMediatorInputConnectorEditPart.VISUAL_ID:
			return LogMediatorInputConnector_3018;
		case LogMediatorOutputConnectorEditPart.VISUAL_ID:
			return LogMediatorOutputConnector_3019;
		case EnrichMediatorEditPart.VISUAL_ID:
			return EnrichMediator_3496;
		case EnrichMediatorInputConnectorEditPart.VISUAL_ID:
			return EnrichMediatorInputConnector_3036;
		case EnrichMediatorOutputConnectorEditPart.VISUAL_ID:
			return EnrichMediatorOutputConnector_3037;
		case XSLTMediatorEditPart.VISUAL_ID:
			return XSLTMediator_3497;
		case XSLTMediatorInputConnectorEditPart.VISUAL_ID:
			return XSLTMediatorInputConnector_3039;
		case XSLTMediatorOutputConnectorEditPart.VISUAL_ID:
			return XSLTMediatorOutputConnector_3040;
		case SwitchMediatorEditPart.VISUAL_ID:
			return SwitchMediator_3498;
		case SwitchMediatorInputConnectorEditPart.VISUAL_ID:
			return SwitchMediatorInputConnector_3042;
		case SwitchMediatorOutputConnectorEditPart.VISUAL_ID:
			return SwitchMediatorOutputConnector_3499;
		case SwitchCaseBranchOutputConnectorEditPart.VISUAL_ID:
			return SwitchCaseBranchOutputConnector_3043;
		case SwitchDefaultBranchOutputConnectorEditPart.VISUAL_ID:
			return SwitchDefaultBranchOutputConnector_3044;
		case SwitchMediatorContainerEditPart.VISUAL_ID:
			return SwitchMediatorContainer_3500;
		case SwitchCaseParentContainerEditPart.VISUAL_ID:
			return SwitchCaseParentContainer_3732;
		case SwitchCaseContainerEditPart.VISUAL_ID:
			return SwitchCaseContainer_3733;
		case MediatorFlow2EditPart.VISUAL_ID:
			return MediatorFlow_3502;
		case SequenceEditPart.VISUAL_ID:
			return Sequence_3503;
		case SequenceInputConnectorEditPart.VISUAL_ID:
			return SequenceInputConnector_3049;
		case SequenceOutputConnectorEditPart.VISUAL_ID:
			return SequenceOutputConnector_3050;
		case EventMediatorEditPart.VISUAL_ID:
			return EventMediator_3504;
		case EventMediatorInputConnectorEditPart.VISUAL_ID:
			return EventMediatorInputConnector_3052;
		case EventMediatorOutputConnectorEditPart.VISUAL_ID:
			return EventMediatorOutputConnector_3053;
		case EntitlementMediatorEditPart.VISUAL_ID:
			return EntitlementMediator_3505;
		case EntitlementMediatorInputConnectorEditPart.VISUAL_ID:
			return EntitlementMediatorInputConnector_3055;
		case EntitlementMediatorOutputConnectorEditPart.VISUAL_ID:
			return EntitlementMediatorOutputConnector_3056;
		case EntitlementMediatorOnRejectOutputConnectorEditPart.VISUAL_ID:
			return EntitlementMediatorOnRejectOutputConnector_3748;
		case EntitlementMediatorOnAcceptOutputConnectorEditPart.VISUAL_ID:
			return EntitlementMediatorOnAcceptOutputConnector_3749;
		case EntitlementMediatorAdviceOutputConnectorEditPart.VISUAL_ID:
			return EntitlementMediatorAdviceOutputConnector_3750;
		case EntitlementMediatorObligationsOutputConnectorEditPart.VISUAL_ID:
			return EntitlementMediatorObligationsOutputConnector_3751;
		case EntitlementContainerEditPart.VISUAL_ID:
			return EntitlementContainer_3752;
		case EntitlementOnRejectContainerEditPart.VISUAL_ID:
			return EntitlementOnRejectContainer_3753;
		case MediatorFlow21EditPart.VISUAL_ID:
			return MediatorFlow_3754;
		case ClassMediatorEditPart.VISUAL_ID:
			return ClassMediator_3506;
		case ClassMediatorInputConnectorEditPart.VISUAL_ID:
			return ClassMediatorInputConnector_3058;
		case ClassMediatorOutputConnectorEditPart.VISUAL_ID:
			return ClassMediatorOutputConnector_3059;
		case SpringMediatorEditPart.VISUAL_ID:
			return SpringMediator_3507;
		case SpringMediatorInputConnectorEditPart.VISUAL_ID:
			return SpringMediatorInputConnector_3061;
		case SpringMediatorOutputConnectorEditPart.VISUAL_ID:
			return SpringMediatorOutputConnector_3062;
		case ScriptMediatorEditPart.VISUAL_ID:
			return ScriptMediator_3508;
		case ScriptMediatorInputConnectorEditPart.VISUAL_ID:
			return ScriptMediatorInputConnector_3064;
		case ScriptMediatorOutputConnectorEditPart.VISUAL_ID:
			return ScriptMediatorOutputConnector_3065;
		case FaultMediatorEditPart.VISUAL_ID:
			return FaultMediator_3509;
		case FaultMediatorInputConnectorEditPart.VISUAL_ID:
			return FaultMediatorInputConnector_3067;
		case FaultMediatorOutputConnectorEditPart.VISUAL_ID:
			return FaultMediatorOutputConnector_3068;
		case XQueryMediatorEditPart.VISUAL_ID:
			return XQueryMediator_3510;
		case XQueryMediatorInputConnectorEditPart.VISUAL_ID:
			return XQueryMediatorInputConnector_3070;
		case XQueryMediatorOutputConnectorEditPart.VISUAL_ID:
			return XQueryMediatorOutputConnector_3071;
		case CommandMediatorEditPart.VISUAL_ID:
			return CommandMediator_3511;
		case CommandMediatorInputConnectorEditPart.VISUAL_ID:
			return CommandMediatorInputConnector_3073;
		case CommandMediatorOutputConnectorEditPart.VISUAL_ID:
			return CommandMediatorOutputConnector_3074;
		case DBLookupMediatorEditPart.VISUAL_ID:
			return DBLookupMediator_3512;
		case DBLookupMediatorInputConnectorEditPart.VISUAL_ID:
			return DBLookupMediatorInputConnector_3076;
		case DBLookupMediatorOutputConnectorEditPart.VISUAL_ID:
			return DBLookupMediatorOutputConnector_3077;
		case DBReportMediatorEditPart.VISUAL_ID:
			return DBReportMediator_3513;
		case DBReportMediatorInputConnectorEditPart.VISUAL_ID:
			return DBReportMediatorInputConnector_3079;
		case DBReportMediatorOutputConnectorEditPart.VISUAL_ID:
			return DBReportMediatorOutputConnector_3080;
		case SmooksMediatorEditPart.VISUAL_ID:
			return SmooksMediator_3514;
		case SmooksMediatorInputConnectorEditPart.VISUAL_ID:
			return SmooksMediatorInputConnector_3082;
		case SmooksMediatorOutputConnectorEditPart.VISUAL_ID:
			return SmooksMediatorOutputConnector_3083;
		case SendMediatorEditPart.VISUAL_ID:
			return SendMediator_3515;
		case SendMediatorInputConnectorEditPart.VISUAL_ID:
			return SendMediatorInputConnector_3085;
		case SendMediatorOutputConnectorEditPart.VISUAL_ID:
			return SendMediatorOutputConnector_3086;
		case SendMediatorEndpointOutputConnectorEditPart.VISUAL_ID:
			return SendMediatorEndpointOutputConnector_3539;
		case MediatorFlow19EditPart.VISUAL_ID:
			return MediatorFlow_3728;
		case HeaderMediatorEditPart.VISUAL_ID:
			return HeaderMediator_3516;
		case HeaderMediatorInputConnectorEditPart.VISUAL_ID:
			return HeaderMediatorInputConnector_3100;
		case HeaderMediatorOutputConnectorEditPart.VISUAL_ID:
			return HeaderMediatorOutputConnector_3101;
		case CloneMediatorEditPart.VISUAL_ID:
			return CloneMediator_3517;
		case CloneMediatorInputConnectorEditPart.VISUAL_ID:
			return CloneMediatorInputConnector_3103;
		case CloneMediatorOutputConnectorEditPart.VISUAL_ID:
			return CloneMediatorOutputConnector_3104;
		case CloneMediatorTargetOutputConnectorEditPart.VISUAL_ID:
			return CloneMediatorTargetOutputConnector_3133;
		case CloneMediatorContainerEditPart.VISUAL_ID:
			return CloneMediatorContainer_3603;
		case CloneTargetContainerEditPart.VISUAL_ID:
			return CloneTargetContainer_3604;
		case MediatorFlow11EditPart.VISUAL_ID:
			return MediatorFlow_3605;
		case CacheMediatorEditPart.VISUAL_ID:
			return CacheMediator_3518;
		case CacheMediatorInputConnectorEditPart.VISUAL_ID:
			return CacheMediatorInputConnector_3106;
		case CacheMediatorOutputConnectorEditPart.VISUAL_ID:
			return CacheMediatorOutputConnector_3107;
		case CacheMediatorOnHitOutputConnectorEditPart.VISUAL_ID:
			return CacheMediatorOnHitOutputConnector_3618;
		case MediatorFlow13EditPart.VISUAL_ID:
			return MediatorFlow_3619;
		case IterateMediatorEditPart.VISUAL_ID:
			return IterateMediator_3519;
		case IterateMediatorInputConnectorEditPart.VISUAL_ID:
			return IterateMediatorInputConnector_3109;
		case IterateMediatorOutputConnectorEditPart.VISUAL_ID:
			return IterateMediatorOutputConnector_3110;
		case IterateMediatorTargetOutputConnectorEditPart.VISUAL_ID:
			return IterateMediatorTargetOutputConnector_3606;
		case MediatorFlow12EditPart.VISUAL_ID:
			return MediatorFlow_3607;
		case CalloutMediatorEditPart.VISUAL_ID:
			return CalloutMediator_3520;
		case CalloutMediatorInputConnectorEditPart.VISUAL_ID:
			return CalloutMediatorInputConnector_3115;
		case CalloutMediatorOutputConnectorEditPart.VISUAL_ID:
			return CalloutMediatorOutputConnector_3116;
		case TransactionMediatorEditPart.VISUAL_ID:
			return TransactionMediator_3521;
		case TransactionMediatorInputConnectorEditPart.VISUAL_ID:
			return TransactionMediatorInputConnector_3118;
		case TransactionMediatorOutputConnectorEditPart.VISUAL_ID:
			return TransactionMediatorOutputConnector_3119;
		case RMSequenceMediatorEditPart.VISUAL_ID:
			return RMSequenceMediator_3522;
		case RMSequenceMediatorInputConnectorEditPart.VISUAL_ID:
			return RMSequenceMediatorInputConnector_3124;
		case RMSequenceMediatorOutputConnectorEditPart.VISUAL_ID:
			return RMSequenceMediatorOutputConnector_3125;
		case RuleMediatorEditPart.VISUAL_ID:
			return RuleMediator_3523;
		case RuleMediatorInputConnectorEditPart.VISUAL_ID:
			return RuleMediatorInputConnector_3127;
		case RuleMediatorOutputConnectorEditPart.VISUAL_ID:
			return RuleMediatorOutputConnector_3128;
		case RuleMediatorChildMediatorsOutputConnectorEditPart.VISUAL_ID:
			return RuleMediatorChildMediatorsOutputConnector_3640;
		case MediatorFlow17EditPart.VISUAL_ID:
			return MediatorFlow_3641;
		case OAuthMediatorEditPart.VISUAL_ID:
			return OAuthMediator_3524;
		case OAuthMediatorInputConnectorEditPart.VISUAL_ID:
			return OAuthMediatorInputConnector_3130;
		case OAuthMediatorOutputConnectorEditPart.VISUAL_ID:
			return OAuthMediatorOutputConnector_3131;
		case AggregateMediatorEditPart.VISUAL_ID:
			return AggregateMediator_3525;
		case AggregateMediatorInputConnectorEditPart.VISUAL_ID:
			return AggregateMediatorInputConnector_3112;
		case AggregateMediatorOutputConnectorEditPart.VISUAL_ID:
			return AggregateMediatorOutputConnector_3113;
		case AggregateMediatorOnCompleteOutputConnectorEditPart.VISUAL_ID:
			return AggregateMediatorOnCompleteOutputConnector_3132;
		case MediatorFlow3EditPart.VISUAL_ID:
			return MediatorFlow_3526;
		case StoreMediatorEditPart.VISUAL_ID:
			return StoreMediator_3588;
		case StoreMediatorInputConnectorEditPart.VISUAL_ID:
			return StoreMediatorInputConnector_3589;
		case StoreMediatorOutputConnectorEditPart.VISUAL_ID:
			return StoreMediatorOutputConnector_3590;
		case BuilderMediatorEditPart.VISUAL_ID:
			return BuilderMediator_3591;
		case BuilderMediatorInputConnectorEditPart.VISUAL_ID:
			return BuilderMediatorInputConnector_3592;
		case BuilderMediatorOutputConectorEditPart.VISUAL_ID:
			return BuilderMediatorOutputConector_3593;
		case CallTemplateMediatorEditPart.VISUAL_ID:
			return CallTemplateMediator_3594;
		case CallTemplateMediatorInputConnectorEditPart.VISUAL_ID:
			return CallTemplateMediatorInputConnector_3595;
		case CallTemplateMediatorOutputConnectorEditPart.VISUAL_ID:
			return CallTemplateMediatorOutputConnector_3596;
		case PayloadFactoryMediatorEditPart.VISUAL_ID:
			return PayloadFactoryMediator_3597;
		case PayloadFactoryMediatorInputConnectorEditPart.VISUAL_ID:
			return PayloadFactoryMediatorInputConnector_3598;
		case PayloadFactoryMediatorOutputConnectorEditPart.VISUAL_ID:
			return PayloadFactoryMediatorOutputConnector_3599;
		case EnqueueMediatorEditPart.VISUAL_ID:
			return EnqueueMediator_3600;
		case EnqueueMediatorInputConnectorEditPart.VISUAL_ID:
			return EnqueueMediatorInputConnector_3601;
		case EnqueueMediatorOutputConnectorEditPart.VISUAL_ID:
			return EnqueueMediatorOutputConnector_3602;
		case URLRewriteMediatorEditPart.VISUAL_ID:
			return URLRewriteMediator_3620;
		case URLRewriteMediatorInputConnectorEditPart.VISUAL_ID:
			return URLRewriteMediatorInputConnector_3621;
		case URLRewriteMediatorOutputConnectorEditPart.VISUAL_ID:
			return URLRewriteMediatorOutputConnector_3622;
		case ValidateMediatorEditPart.VISUAL_ID:
			return ValidateMediator_3623;
		case ValidateMediatorInputConnectorEditPart.VISUAL_ID:
			return ValidateMediatorInputConnector_3624;
		case ValidateMediatorOutputConnectorEditPart.VISUAL_ID:
			return ValidateMediatorOutputConnector_3625;
		case ValidateMediatorOnFailOutputConnectorEditPart.VISUAL_ID:
			return ValidateMediatorOnFailOutputConnector_3626;
		case MediatorFlow14EditPart.VISUAL_ID:
			return MediatorFlow_3627;
		case RouterMediatorEditPart.VISUAL_ID:
			return RouterMediator_3628;
		case RouterMediatorInputConnectorEditPart.VISUAL_ID:
			return RouterMediatorInputConnector_3629;
		case RouterMediatorOutputConnectorEditPart.VISUAL_ID:
			return RouterMediatorOutputConnector_3630;
		case RouterMediatorTargetOutputConnectorEditPart.VISUAL_ID:
			return RouterMediatorTargetOutputConnector_3631;
		case RouterMediatorContainerEditPart.VISUAL_ID:
			return RouterMediatorContainer_3632;
		case RouterTargetContainerEditPart.VISUAL_ID:
			return RouterTargetContainer_3633;
		case MediatorFlow15EditPart.VISUAL_ID:
			return MediatorFlow_3634;
		case ConditionalRouterMediatorEditPart.VISUAL_ID:
			return ConditionalRouterMediator_3635;
		case ConditionalRouterMediatorInputConnectorEditPart.VISUAL_ID:
			return ConditionalRouterMediatorInputConnector_3636;
		case ConditionalRouterMediatorOutputConnectorEditPart.VISUAL_ID:
			return ConditionalRouterMediatorOutputConnector_3637;
		case ConditionalRouterMediatorAdditionalOutputConnectorEditPart.VISUAL_ID:
			return ConditionalRouterMediatorAdditionalOutputConnector_3638;
		case MediatorFlow16EditPart.VISUAL_ID:
			return MediatorFlow_3639;
		case BAMMediatorEditPart.VISUAL_ID:
			return BAMMediator_3680;
		case BAMMediatorInputConnectorEditPart.VISUAL_ID:
			return BAMMediatorInputConnector_3681;
		case BAMMediatorOutputConnectorEditPart.VISUAL_ID:
			return BAMMediatorOutputConnector_3682;
		case BeanMediatorEditPart.VISUAL_ID:
			return BeanMediator_3683;
		case BeanMediatorInputConnectorEditPart.VISUAL_ID:
			return BeanMediatorInputConnector_3684;
		case BeanMediatorOutputConnectorEditPart.VISUAL_ID:
			return BeanMediatorOutputConnector_3685;
		case EJBMediatorEditPart.VISUAL_ID:
			return EJBMediator_3686;
		case EJBMediatorInputConnectorEditPart.VISUAL_ID:
			return EJBMediatorInputConnector_3687;
		case EJBMediatorOutputConnectorEditPart.VISUAL_ID:
			return EJBMediatorOutputConnector_3688;
		case DefaultEndPointEditPart.VISUAL_ID:
			return DefaultEndPoint_3609;
		case DefaultEndPointInputConnectorEditPart.VISUAL_ID:
			return DefaultEndPointInputConnector_3021;
		case DefaultEndPointOutputConnectorEditPart.VISUAL_ID:
			return DefaultEndPointOutputConnector_3022;
		case AddressEndPointEditPart.VISUAL_ID:
			return AddressEndPoint_3610;
		case AddressEndPointInputConnectorEditPart.VISUAL_ID:
			return AddressEndPointInputConnector_3030;
		case AddressEndPointOutputConnectorEditPart.VISUAL_ID:
			return AddressEndPointOutputConnector_3031;
		case FailoverEndPointEditPart.VISUAL_ID:
			return FailoverEndPoint_3611;
		case FailoverEndPointInputConnectorEditPart.VISUAL_ID:
			return FailoverEndPointInputConnector_3088;
		case FailoverEndPointOutputConnectorEditPart.VISUAL_ID:
			return FailoverEndPointOutputConnector_3090;
		case FailoverEndPointWestOutputConnectorEditPart.VISUAL_ID:
			return FailoverEndPointWestOutputConnector_3097;
		case RecipientListEndPointEditPart.VISUAL_ID:
			return RecipientListEndPoint_3692;
		case RecipientListEndPointInputConnectorEditPart.VISUAL_ID:
			return RecipientListEndPointInputConnector_3693;
		case RecipientListEndPointOutputConnectorEditPart.VISUAL_ID:
			return RecipientListEndPointOutputConnector_3694;
		case RecipientListEndPointWestOutputConnectorEditPart.VISUAL_ID:
			return RecipientListEndPointWestOutputConnector_3695;
		case WSDLEndPointEditPart.VISUAL_ID:
			return WSDLEndPoint_3612;
		case WSDLEndPointInputConnectorEditPart.VISUAL_ID:
			return WSDLEndPointInputConnector_3092;
		case WSDLEndPointOutputConnectorEditPart.VISUAL_ID:
			return WSDLEndPointOutputConnector_3093;
		case NamedEndpointEditPart.VISUAL_ID:
			return NamedEndpoint_3660;
		case NamedEndpointInputConnectorEditPart.VISUAL_ID:
			return NamedEndpointInputConnector_3661;
		case NamedEndpointOutputConnectorEditPart.VISUAL_ID:
			return NamedEndpointOutputConnector_3662;
		case LoadBalanceEndPointEditPart.VISUAL_ID:
			return LoadBalanceEndPoint_3613;
		case LoadBalanceEndPointInputConnectorEditPart.VISUAL_ID:
			return LoadBalanceEndPointInputConnector_3095;
		case LoadBalanceEndPointOutputConnectorEditPart.VISUAL_ID:
			return LoadBalanceEndPointOutputConnector_3096;
		case LoadBalanceEndPointWestOutputConnectorEditPart.VISUAL_ID:
			return LoadBalanceEndPointWestOutputConnector_3098;
		case APIResourceEndpointEditPart.VISUAL_ID:
			return APIResourceEndpoint_3674;
		case APIResourceEndpointInputConnectorEditPart.VISUAL_ID:
			return APIResourceEndpointInputConnector_3675;
		case APIResourceEndpointOutputConnectorEditPart.VISUAL_ID:
			return APIResourceEndpointOutputConnector_3676;
		case AddressingEndpointEditPart.VISUAL_ID:
			return AddressingEndpoint_3689;
		case AddressingEndpointInputConnectorEditPart.VISUAL_ID:
			return AddressingEndpointInputConnector_3690;
		case AddressingEndpointOutputConnectorEditPart.VISUAL_ID:
			return AddressingEndpointOutputConnector_3691;
		case HTTPEndpointEditPart.VISUAL_ID:
			return HTTPEndpoint_3709;
		case HTTPEndPointInputConnectorEditPart.VISUAL_ID:
			return HTTPEndPointInputConnector_3710;
		case HTTPEndPointOutputConnectorEditPart.VISUAL_ID:
			return HTTPEndPointOutputConnector_3711;
		case TemplateEndpointEditPart.VISUAL_ID:
			return TemplateEndpoint_3716;
		case TemplateEndpointInputConnectorEditPart.VISUAL_ID:
			return TemplateEndpointInputConnector_3717;
		case TemplateEndpointOutputConnectorEditPart.VISUAL_ID:
			return TemplateEndpointOutputConnector_3718;
		case CloudConnectorEditPart.VISUAL_ID:
			return CloudConnector_3719;
		case CloudConnectorInputConnectorEditPart.VISUAL_ID:
			return CloudConnectorInputConnector_3720;
		case CloudConnectorOutputConnectorEditPart.VISUAL_ID:
			return CloudConnectorOutputConnector_3721;
		case CloudConnectorOperationEditPart.VISUAL_ID:
			return CloudConnectorOperation_3722;
		case CloudConnectorOperationInputConnectorEditPart.VISUAL_ID:
			return CloudConnectorOperationInputConnector_3723;
		case CloudConnectorOperationOutputConnectorEditPart.VISUAL_ID:
			return CloudConnectorOperationOutputConnector_3724;
		case LoopBackMediatorEditPart.VISUAL_ID:
			return LoopBackMediator_3736;
		case LoopBackMediatorInputConnectorEditPart.VISUAL_ID:
			return LoopBackMediatorInputConnector_3737;
		case LoopBackMediatorOutputConnectorEditPart.VISUAL_ID:
			return LoopBackMediatorOutputConnector_3738;
		case RespondMediatorEditPart.VISUAL_ID:
			return RespondMediator_3739;
		case RespondMediatorInputConnectorEditPart.VISUAL_ID:
			return RespondMediatorInputConnector_3740;
		case RespondMediatorOutputConnectorEditPart.VISUAL_ID:
			return RespondMediatorOutputConnector_3741;
		case CallMediatorEditPart.VISUAL_ID:
			return CallMediator_3742;
		case CallMediatorInputConnectorEditPart.VISUAL_ID:
			return CallMediatorInputConnector_3743;
		case CallMediatorOutputConnectorEditPart.VISUAL_ID:
			return CallMediatorOutputConnector_3744;
		case CallMediatorEndpointOutputConnectorEditPart.VISUAL_ID:
			return CallMediatorEndpointOutputConnector_3745;
		case MediatorFlow20EditPart.VISUAL_ID:
			return MediatorFlow_3746;
		case DataMapperMediatorEditPart.VISUAL_ID:
			return DataMapperMediator_3761;
		case DataMapperMediatorInputConnectorEditPart.VISUAL_ID:
			return DataMapperMediatorInputConnector_3762;
		case DataMapperMediatorOutputConnectorEditPart.VISUAL_ID:
			return DataMapperMediatorOutputConnector_3763;
		case FastXSLTMediatorEditPart.VISUAL_ID:
			return FastXSLTMediator_3764;
		case FastXSLTMediatorInputConnectorEditPart.VISUAL_ID:
			return FastXSLTMediatorInputConnector_3765;
		case FastXSLTMediatorOutputConnectorEditPart.VISUAL_ID:
			return FastXSLTMediatorOutputConnector_3766;
		case ForEachMediatorEditPart.VISUAL_ID:
			return ForEachMediator_3780;
		case ForEachMediatorInputConnectorEditPart.VISUAL_ID:
			return ForEachMediatorInputConnector_3781;
		case ForEachMediatorOutputConnectorEditPart.VISUAL_ID:
			return ForEachMediatorOutputConnector_3782;
		case ForEachMediatorTargetOutputConnectorEditPart.VISUAL_ID:
			return ForEachMediatorTargetOutputConnector_3783;
		case MediatorFlow30EditPart.VISUAL_ID:
			return MediatorFlow_3784;
		case PublishEventMediatorEditPart.VISUAL_ID:
			return PublishEventMediator_3785;
		case PublishEventMediatorInputConnectorEditPart.VISUAL_ID:
			return PublishEventMediatorInputConnector_3786;
		case PublishEventMediatorOutputConnectorEditPart.VISUAL_ID:
			return PublishEventMediatorOutputConnector_3787;
		case EntitlementOnAcceptContainerEditPart.VISUAL_ID:
			return EntitlementOnAcceptContainer_3755;
		case MediatorFlow22EditPart.VISUAL_ID:
			return MediatorFlow_3756;
		case EntitlementAdviceContainerEditPart.VISUAL_ID:
			return EntitlementAdviceContainer_3757;
		case MediatorFlow23EditPart.VISUAL_ID:
			return MediatorFlow_3758;
		case EntitlementObligationsContainerEditPart.VISUAL_ID:
			return EntitlementObligationsContainer_3759;
		case MediatorFlow24EditPart.VISUAL_ID:
			return MediatorFlow_3760;
		case SwitchDefaultParentContainerEditPart.VISUAL_ID:
			return SwitchDefaultParentContainer_3734;
		case SwitchDefaultContainerEditPart.VISUAL_ID:
			return SwitchDefaultContainer_3735;
		case MediatorFlow4EditPart.VISUAL_ID:
			return MediatorFlow_3528;
		case FilterFailContainerEditPart.VISUAL_ID:
			return FilterFailContainer_3537;
		case MediatorFlow8EditPart.VISUAL_ID:
			return MediatorFlow_3538;
		case ThrottleOnRejectContainerEditPart.VISUAL_ID:
			return ThrottleOnRejectContainer_3586;
		case MediatorFlow10EditPart.VISUAL_ID:
			return MediatorFlow_3587;
		case ProxyServiceFaultContainerEditPart.VISUAL_ID:
			return ProxyServiceFaultContainer_3488;
		case MediatorFlow6EditPart.VISUAL_ID:
			return MediatorFlow_3530;
		case ProxyInSequenceInputConnectorEditPart.VISUAL_ID:
			return ProxyInSequenceInputConnector_3731;
		case MessageMediatorEditPart.VISUAL_ID:
			return MessageMediator_3045;
		case MessageInputConnectorEditPart.VISUAL_ID:
			return MessageInputConnector_3046;
		case MessageOutputConnectorEditPart.VISUAL_ID:
			return MessageOutputConnector_3047;
		case MergeNodeEditPart.VISUAL_ID:
			return MergeNode_3013;
		case MergeNodeFirstInputConnectorEditPart.VISUAL_ID:
			return MergeNodeFirstInputConnector_3014;
		case MergeNodeSecondInputConnectorEditPart.VISUAL_ID:
			return MergeNodeSecondInputConnector_3015;
		case MergeNodeOutputConnectorEditPart.VISUAL_ID:
			return MergeNodeOutputConnector_3016;
		case SequencesEditPart.VISUAL_ID:
			return Sequences_3614;
		case MediatorFlow5EditPart.VISUAL_ID:
			return MediatorFlow_3615;
		case SequencesInputConnectorEditPart.VISUAL_ID:
			return SequencesInputConnector_3616;
		case SequencesOutputConnectorEditPart.VISUAL_ID:
			return SequencesOutputConnector_3617;
		case EndpointDiagramEditPart.VISUAL_ID:
			return EndpointDiagram_3642;
		case DefaultEndPoint2EditPart.VISUAL_ID:
			return DefaultEndPoint_3643;
		case DefaultEndPointInputConnector2EditPart.VISUAL_ID:
			return DefaultEndPointInputConnector_3644;
		case DefaultEndPointOutputConnector2EditPart.VISUAL_ID:
			return DefaultEndPointOutputConnector_3645;
		case AddressEndPoint2EditPart.VISUAL_ID:
			return AddressEndPoint_3646;
		case AddressEndPointInputConnector2EditPart.VISUAL_ID:
			return AddressEndPointInputConnector_3647;
		case AddressEndPointOutputConnector2EditPart.VISUAL_ID:
			return AddressEndPointOutputConnector_3648;
		case FailoverEndPoint2EditPart.VISUAL_ID:
			return FailoverEndPoint_3649;
		case FailoverEndPointInputConnector2EditPart.VISUAL_ID:
			return FailoverEndPointInputConnector_3650;
		case FailoverEndPointOutputConnector2EditPart.VISUAL_ID:
			return FailoverEndPointOutputConnector_3651;
		case FailoverEndPointWestOutputConnector2EditPart.VISUAL_ID:
			return FailoverEndPointWestOutputConnector_3652;
		case MediatorFlow27EditPart.VISUAL_ID:
			return MediatorFlow_3777;
		case RecipientListEndPoint2EditPart.VISUAL_ID:
			return RecipientListEndPoint_3696;
		case RecipientListEndPointInputConnector2EditPart.VISUAL_ID:
			return RecipientListEndPointInputConnector_3697;
		case RecipientListEndPointOutputConnector2EditPart.VISUAL_ID:
			return RecipientListEndPointOutputConnector_3698;
		case RecipientListEndPointWestOutputConnector2EditPart.VISUAL_ID:
			return RecipientListEndPointWestOutputConnector_3699;
		case MediatorFlow28EditPart.VISUAL_ID:
			return MediatorFlow_3778;
		case WSDLEndPoint2EditPart.VISUAL_ID:
			return WSDLEndPoint_3653;
		case WSDLEndPointInputConnector2EditPart.VISUAL_ID:
			return WSDLEndPointInputConnector_3654;
		case WSDLEndPointOutputConnector2EditPart.VISUAL_ID:
			return WSDLEndPointOutputConnector_3655;
		case LoadBalanceEndPoint2EditPart.VISUAL_ID:
			return LoadBalanceEndPoint_3656;
		case LoadBalanceEndPointInputConnector2EditPart.VISUAL_ID:
			return LoadBalanceEndPointInputConnector_3657;
		case LoadBalanceEndPointOutputConnector2EditPart.VISUAL_ID:
			return LoadBalanceEndPointOutputConnector_3658;
		case LoadBalanceEndPointWestOutputConnector2EditPart.VISUAL_ID:
			return LoadBalanceEndPointWestOutputConnector_3659;
		case MediatorFlow29EditPart.VISUAL_ID:
			return MediatorFlow_3779;
		case HTTPEndpoint2EditPart.VISUAL_ID:
			return HTTPEndpoint_3712;
		case HTTPEndPointInputConnector2EditPart.VISUAL_ID:
			return HTTPEndPointInputConnector_3713;
		case HTTPEndPointOutputConnector2EditPart.VISUAL_ID:
			return HTTPEndPointOutputConnector_3714;
		case TemplateEndpoint2EditPart.VISUAL_ID:
			return TemplateEndpoint_3725;
		case TemplateEndpointInputConnector2EditPart.VISUAL_ID:
			return TemplateEndpointInputConnector_3726;
		case TemplateEndpointOutputConnector2EditPart.VISUAL_ID:
			return TemplateEndpointOutputConnector_3727;
		case LocalEntryEditPart.VISUAL_ID:
			return LocalEntry_3663;
		case TemplateEditPart.VISUAL_ID:
			return Template_3664;
		case Sequences2EditPart.VISUAL_ID:
			return Sequences_3665;
		case EndpointDiagram2EditPart.VISUAL_ID:
			return EndpointDiagram_3666;
		case TaskEditPart.VISUAL_ID:
			return Task_3667;
		case SynapseAPIEditPart.VISUAL_ID:
			return SynapseAPI_3668;
		case APIResourceEditPart.VISUAL_ID:
			return APIResource_3669;
		case APIResourceInputConnectorEditPart.VISUAL_ID:
			return APIResourceInputConnector_3670;
		case APIResourceOutputConnectorEditPart.VISUAL_ID:
			return APIResourceOutputConnector_3671;
		case APIResourceOutSequenceOutputConnectorEditPart.VISUAL_ID:
			return APIResourceOutSequenceOutputConnector_3730;
		case APIResourceFaultInputConnectorEditPart.VISUAL_ID:
			return APIResourceFaultInputConnector_3672;
		case ProxyServiceContainer2EditPart.VISUAL_ID:
			return ProxyServiceContainer_3673;
		case APIResourceInSequenceInputConnectorEditPart.VISUAL_ID:
			return APIResourceInSequenceInputConnector_3747;
		case ComplexEndpointsEditPart.VISUAL_ID:
			return ComplexEndpoints_3677;
		case MediatorFlow18EditPart.VISUAL_ID:
			return MediatorFlow_3678;
		case ComplexEndpointsOutputConnectorEditPart.VISUAL_ID:
			return ComplexEndpointsOutputConnector_3679;
		case MessageStoreEditPart.VISUAL_ID:
			return MessageStore_3715;
		case MessageProcessorEditPart.VISUAL_ID:
			return MessageProcessor_3701;
		case InboundEndpointEditPart.VISUAL_ID:
			return InboundEndpoint_3767;
		case InboundEndpointSequenceInputConnectorEditPart.VISUAL_ID:
			return InboundEndpointSequenceInputConnector_3768;
		case InboundEndpointSequenceOutputConnectorEditPart.VISUAL_ID:
			return InboundEndpointSequenceOutputConnector_3769;
		case InboundEndpointOnErrorSequenceInputConnectorEditPart.VISUAL_ID:
			return InboundEndpointOnErrorSequenceInputConnector_3770;
		case InboundEndpointOnErrorSequenceOutputConnectorEditPart.VISUAL_ID:
			return InboundEndpointOnErrorSequenceOutputConnector_3771;
		case InboundEndpointContainerEditPart.VISUAL_ID:
			return InboundEndpointContainer_3772;
		case InboundEndpointSequenceContainerEditPart.VISUAL_ID:
			return InboundEndpointSequenceContainer_3773;
		case MediatorFlow25EditPart.VISUAL_ID:
			return MediatorFlow_3774;
		case InboundEndpointOnErrorSequenceContainerEditPart.VISUAL_ID:
			return InboundEndpointOnErrorSequenceContainer_3775;
		case MediatorFlow26EditPart.VISUAL_ID:
			return MediatorFlow_3776;
		case EsbLinkEditPart.VISUAL_ID:
			return EsbLink_4001;
		}
		return null;
	}

	/**
	 * @generated
	 */
	public static final DiagramElementTypes TYPED_INSTANCE = new DiagramElementTypes(elementTypeImages) {

		/**
		 * @generated
		 */
		@Override
		public boolean isKnownElementType(IElementType elementType) {
			return org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes
					.isKnownElementType(elementType);
		}

		/**
		 * @generated
		 */
		@Override
		public IElementType getElementTypeForVisualId(int visualID) {
			return org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes.getElementType(visualID);
		}

		/**
		 * @generated
		 */
		@Override
		public ENamedElement getDefiningNamedElement(IAdaptable elementTypeAdapter) {
			return org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes
					.getElement(elementTypeAdapter);
		}
	};

}
