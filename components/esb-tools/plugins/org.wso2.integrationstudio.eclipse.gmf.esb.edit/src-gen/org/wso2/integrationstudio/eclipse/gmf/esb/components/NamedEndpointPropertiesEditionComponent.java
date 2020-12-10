/**
 * Generated with Acceleo
 */
package org.wso2.integrationstudio.eclipse.gmf.esb.components;

// Start of user code for imports
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.WrappedException;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.resource.ResourceSet;

import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.emf.eef.runtime.api.notify.EStructuralFeatureNotificationFilter;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.notify.NotificationFilter;

import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;

import org.eclipse.emf.eef.runtime.context.impl.EObjectPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.context.impl.EReferencePropertiesEditionContext;

import org.eclipse.emf.eef.runtime.impl.components.SinglePartPropertiesEditingComponent;

import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;
import org.eclipse.emf.eef.runtime.impl.utils.EEFUtils;

import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy;

import org.eclipse.emf.eef.runtime.policies.impl.CreateEditingPolicy;

import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

import org.wso2.integrationstudio.eclipse.gmf.esb.EndPointAddressingVersion;
import org.wso2.integrationstudio.eclipse.gmf.esb.EndPointAttachmentOptimization;
import org.wso2.integrationstudio.eclipse.gmf.esb.EndPointMessageFormat;
import org.wso2.integrationstudio.eclipse.gmf.esb.EndPointProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.EndPointTimeOutAction;
import org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.integrationstudio.eclipse.gmf.esb.KeyType;
import org.wso2.integrationstudio.eclipse.gmf.esb.NamedEndpoint;
import org.wso2.integrationstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.TemplateParameter;
import org.wso2.integrationstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.NamedEndpointPropertiesEditionPart;
import org.wso2.integrationstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;


// End of user code

/**
 * 
 * 
 */
public class NamedEndpointPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	/**
	 * Settings for properties ReferencesTable
	 */
	protected ReferencesTableSettings propertiesSettings;
	
	/**
	 * Settings for templateParameters ReferencesTable
	 */
	protected ReferencesTableSettings templateParametersSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public NamedEndpointPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject namedEndpoint, String editing_mode) {
		super(editingContext, namedEndpoint, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EsbViewsRepository.class;
		partKey = EsbViewsRepository.NamedEndpoint.class;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#initPart(java.lang.Object, int, org.eclipse.emf.ecore.EObject, 
	 *      org.eclipse.emf.ecore.resource.ResourceSet)
	 * 
	 */
	public void initPart(Object key, int kind, EObject elt, ResourceSet allResource) {
		setInitializing(true);
		if (editingPart != null && key == partKey) {
			editingPart.setContext(elt, allResource);
			
			final NamedEndpoint namedEndpoint = (NamedEndpoint)elt;
			final NamedEndpointPropertiesEditionPart basePart = (NamedEndpointPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EsbViewsRepository.NamedEndpoint.Properties.description))
				basePart.setDescription(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, namedEndpoint.getDescription()));
			
			if (isAccessible(EsbViewsRepository.NamedEndpoint.Properties.commentsList))
				basePart.setCommentsList(namedEndpoint.getCommentsList());
			
			if (isAccessible(EsbViewsRepository.NamedEndpoint.Properties.endPointName))
				basePart.setEndPointName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, namedEndpoint.getEndPointName()));
			
			if (isAccessible(EsbViewsRepository.NamedEndpoint.Properties.anonymous)) {
				basePart.setAnonymous(namedEndpoint.isAnonymous());
			}
			if (isAccessible(EsbViewsRepository.NamedEndpoint.Properties.inLine)) {
				basePart.setInLine(namedEndpoint.isInLine());
			}
			if (isAccessible(EsbViewsRepository.NamedEndpoint.Properties.duplicate)) {
				basePart.setDuplicate(namedEndpoint.isDuplicate());
			}
			if (isAccessible(EsbViewsRepository.NamedEndpoint.Properties.properties_)) {
				propertiesSettings = new ReferencesTableSettings(namedEndpoint, EsbPackage.eINSTANCE.getEndPoint_Properties());
				basePart.initProperties(propertiesSettings);
			}
			if (isAccessible(EsbViewsRepository.NamedEndpoint.Properties.reversed)) {
				basePart.setReversed(namedEndpoint.isReversed());
			}
			if (isAccessible(EsbViewsRepository.NamedEndpoint.Properties.reliableMessagingEnabled)) {
				basePart.setReliableMessagingEnabled(namedEndpoint.isReliableMessagingEnabled());
			}
			if (isAccessible(EsbViewsRepository.NamedEndpoint.Properties.securityEnabled)) {
				basePart.setSecurityEnabled(namedEndpoint.isSecurityEnabled());
			}
			if (isAccessible(EsbViewsRepository.NamedEndpoint.Properties.addressingEnabled)) {
				basePart.setAddressingEnabled(namedEndpoint.isAddressingEnabled());
			}
			if (isAccessible(EsbViewsRepository.NamedEndpoint.Properties.addressingVersion)) {
				basePart.initAddressingVersion(EEFUtils.choiceOfValues(namedEndpoint, EsbPackage.eINSTANCE.getAbstractEndPoint_AddressingVersion()), namedEndpoint.getAddressingVersion());
			}
			if (isAccessible(EsbViewsRepository.NamedEndpoint.Properties.addressingSeparateListener)) {
				basePart.setAddressingSeparateListener(namedEndpoint.isAddressingSeparateListener());
			}
			if (isAccessible(EsbViewsRepository.NamedEndpoint.Properties.timeOutDuration))
				basePart.setTimeOutDuration(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, namedEndpoint.getTimeOutDuration()));
			
			if (isAccessible(EsbViewsRepository.NamedEndpoint.Properties.timeOutAction)) {
				basePart.initTimeOutAction(EEFUtils.choiceOfValues(namedEndpoint, EsbPackage.eINSTANCE.getAbstractEndPoint_TimeOutAction()), namedEndpoint.getTimeOutAction());
			}
			if (isAccessible(EsbViewsRepository.NamedEndpoint.Properties.retryErrorCodes))
				basePart.setRetryErrorCodes(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, namedEndpoint.getRetryErrorCodes()));
			
			if (isAccessible(EsbViewsRepository.NamedEndpoint.Properties.retryCount)) {
				basePart.setRetryCount(EEFConverterUtil.convertToString(EcorePackage.Literals.EINT, namedEndpoint.getRetryCount()));
			}
			
			if (isAccessible(EsbViewsRepository.NamedEndpoint.Properties.retryDelay)) {
				basePart.setRetryDelay(EEFConverterUtil.convertToString(EcorePackage.Literals.ELONG, namedEndpoint.getRetryDelay()));
			}
			
			if (isAccessible(EsbViewsRepository.NamedEndpoint.Properties.suspendErrorCodes))
				basePart.setSuspendErrorCodes(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, namedEndpoint.getSuspendErrorCodes()));
			
			if (isAccessible(EsbViewsRepository.NamedEndpoint.Properties.suspendInitialDuration)) {
				basePart.setSuspendInitialDuration(EEFConverterUtil.convertToString(EcorePackage.Literals.ELONG, namedEndpoint.getSuspendInitialDuration()));
			}
			
			if (isAccessible(EsbViewsRepository.NamedEndpoint.Properties.suspendMaximumDuration)) {
				basePart.setSuspendMaximumDuration(EEFConverterUtil.convertToString(EcorePackage.Literals.ELONG, namedEndpoint.getSuspendMaximumDuration()));
			}
			
			if (isAccessible(EsbViewsRepository.NamedEndpoint.Properties.suspendProgressionFactor)) {
				basePart.setSuspendProgressionFactor(EEFConverterUtil.convertToString(EcorePackage.Literals.EFLOAT, namedEndpoint.getSuspendProgressionFactor()));
			}
			
			if (isAccessible(EsbViewsRepository.NamedEndpoint.Properties.format)) {
				basePart.initFormat(EEFUtils.choiceOfValues(namedEndpoint, EsbPackage.eINSTANCE.getAbstractEndPoint_Format()), namedEndpoint.getFormat());
			}
			if (isAccessible(EsbViewsRepository.NamedEndpoint.Properties.optimize)) {
				basePart.initOptimize(EEFUtils.choiceOfValues(namedEndpoint, EsbPackage.eINSTANCE.getAbstractEndPoint_Optimize()), namedEndpoint.getOptimize());
			}
			if (isAccessible(EsbViewsRepository.NamedEndpoint.Properties.templateParameters)) {
				templateParametersSettings = new ReferencesTableSettings(namedEndpoint, EsbPackage.eINSTANCE.getAbstractEndPoint_TemplateParameters());
				basePart.initTemplateParameters(templateParametersSettings);
			}
			if (isAccessible(EsbViewsRepository.NamedEndpoint.Properties.statisticsEnabled)) {
				basePart.setStatisticsEnabled(namedEndpoint.isStatisticsEnabled());
			}
			if (isAccessible(EsbViewsRepository.NamedEndpoint.Properties.traceEnabled)) {
				basePart.setTraceEnabled(namedEndpoint.isTraceEnabled());
			}
			if (isAccessible(EsbViewsRepository.NamedEndpoint.Properties.name))
				basePart.setName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, namedEndpoint.getName()));
			
			if (isAccessible(EsbViewsRepository.NamedEndpoint.Properties.referringEndpointType)) {
				basePart.initReferringEndpointType(EEFUtils.choiceOfValues(namedEndpoint, EsbPackage.eINSTANCE.getNamedEndpoint_ReferringEndpointType()), namedEndpoint.getReferringEndpointType());
			}
			// Start of user code  for staticReferenceKey command update
            if (isAccessible(EsbViewsRepository.NamedEndpoint.Properties.staticReferenceKey)) {
                basePart.setStaticReferenceKey(namedEndpoint.getStaticReferenceKey());
            }
			// End of user code
			
			// Start of user code  for dynamicReferenceKey command update
            if (isAccessible(EsbViewsRepository.NamedEndpoint.Properties.dynamicReferenceKey)) {
                basePart.setDynamicReferenceKey(namedEndpoint.getDynamicReferenceKey());
            }
            // End of user code
			
			// init filters
			
			
			
			
			
			
			if (isAccessible(EsbViewsRepository.NamedEndpoint.Properties.properties_)) {
				basePart.addFilterToProperties(new ViewerFilter() {
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof EndPointProperty); //$NON-NLS-1$ 
					}
			
				});
				// Start of user code for additional businessfilters for properties
				// End of user code
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			if (isAccessible(EsbViewsRepository.NamedEndpoint.Properties.templateParameters)) {
				basePart.addFilterToTemplateParameters(new ViewerFilter() {
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof TemplateParameter); //$NON-NLS-1$ 
					}
			
				});
				// Start of user code for additional businessfilters for templateParameters
				// End of user code
			}
			
			
			
			
			// Start of user code  for staticReferenceKey filter update
			// End of user code
			
			// Start of user code  for dynamicReferenceKey filter update
			// End of user code
			
			// init values for referenced views
			
			// init filters for referenced views
			
		}
		setInitializing(false);
	}


































	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#associatedFeature(java.lang.Object)
	 */
	public EStructuralFeature associatedFeature(Object editorKey) {
		if (editorKey == EsbViewsRepository.NamedEndpoint.Properties.description) {
			return EsbPackage.eINSTANCE.getEsbElement_Description();
		}
		if (editorKey == EsbViewsRepository.NamedEndpoint.Properties.commentsList) {
			return EsbPackage.eINSTANCE.getEsbElement_CommentsList();
		}
		if (editorKey == EsbViewsRepository.NamedEndpoint.Properties.endPointName) {
			return EsbPackage.eINSTANCE.getEndPoint_EndPointName();
		}
		if (editorKey == EsbViewsRepository.NamedEndpoint.Properties.anonymous) {
			return EsbPackage.eINSTANCE.getEndPoint_Anonymous();
		}
		if (editorKey == EsbViewsRepository.NamedEndpoint.Properties.inLine) {
			return EsbPackage.eINSTANCE.getEndPoint_InLine();
		}
		if (editorKey == EsbViewsRepository.NamedEndpoint.Properties.duplicate) {
			return EsbPackage.eINSTANCE.getEndPoint_Duplicate();
		}
		if (editorKey == EsbViewsRepository.NamedEndpoint.Properties.properties_) {
			return EsbPackage.eINSTANCE.getEndPoint_Properties();
		}
		if (editorKey == EsbViewsRepository.NamedEndpoint.Properties.reversed) {
			return EsbPackage.eINSTANCE.getEndPoint_Reversed();
		}
		if (editorKey == EsbViewsRepository.NamedEndpoint.Properties.reliableMessagingEnabled) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_ReliableMessagingEnabled();
		}
		if (editorKey == EsbViewsRepository.NamedEndpoint.Properties.securityEnabled) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_SecurityEnabled();
		}
		if (editorKey == EsbViewsRepository.NamedEndpoint.Properties.addressingEnabled) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_AddressingEnabled();
		}
		if (editorKey == EsbViewsRepository.NamedEndpoint.Properties.addressingVersion) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_AddressingVersion();
		}
		if (editorKey == EsbViewsRepository.NamedEndpoint.Properties.addressingSeparateListener) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_AddressingSeparateListener();
		}
		if (editorKey == EsbViewsRepository.NamedEndpoint.Properties.timeOutDuration) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_TimeOutDuration();
		}
		if (editorKey == EsbViewsRepository.NamedEndpoint.Properties.timeOutAction) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_TimeOutAction();
		}
		if (editorKey == EsbViewsRepository.NamedEndpoint.Properties.retryErrorCodes) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_RetryErrorCodes();
		}
		if (editorKey == EsbViewsRepository.NamedEndpoint.Properties.retryCount) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_RetryCount();
		}
		if (editorKey == EsbViewsRepository.NamedEndpoint.Properties.retryDelay) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_RetryDelay();
		}
		if (editorKey == EsbViewsRepository.NamedEndpoint.Properties.suspendErrorCodes) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendErrorCodes();
		}
		if (editorKey == EsbViewsRepository.NamedEndpoint.Properties.suspendInitialDuration) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendInitialDuration();
		}
		if (editorKey == EsbViewsRepository.NamedEndpoint.Properties.suspendMaximumDuration) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendMaximumDuration();
		}
		if (editorKey == EsbViewsRepository.NamedEndpoint.Properties.suspendProgressionFactor) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendProgressionFactor();
		}
		if (editorKey == EsbViewsRepository.NamedEndpoint.Properties.format) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_Format();
		}
		if (editorKey == EsbViewsRepository.NamedEndpoint.Properties.optimize) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_Optimize();
		}
		if (editorKey == EsbViewsRepository.NamedEndpoint.Properties.templateParameters) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_TemplateParameters();
		}
		if (editorKey == EsbViewsRepository.NamedEndpoint.Properties.statisticsEnabled) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_StatisticsEnabled();
		}
		if (editorKey == EsbViewsRepository.NamedEndpoint.Properties.traceEnabled) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_TraceEnabled();
		}
		if (editorKey == EsbViewsRepository.NamedEndpoint.Properties.name) {
			return EsbPackage.eINSTANCE.getNamedEndpoint_Name();
		}
		if (editorKey == EsbViewsRepository.NamedEndpoint.Properties.referringEndpointType) {
			return EsbPackage.eINSTANCE.getNamedEndpoint_ReferringEndpointType();
		}
		if (editorKey == EsbViewsRepository.NamedEndpoint.Properties.staticReferenceKey) {
			return EsbPackage.eINSTANCE.getNamedEndpoint_StaticReferenceKey();
		}
		if (editorKey == EsbViewsRepository.NamedEndpoint.Properties.dynamicReferenceKey) {
			return EsbPackage.eINSTANCE.getNamedEndpoint_DynamicReferenceKey();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		NamedEndpoint namedEndpoint = (NamedEndpoint)semanticObject;
		if (EsbViewsRepository.NamedEndpoint.Properties.description == event.getAffectedEditor()) {
			namedEndpoint.setDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.NamedEndpoint.Properties.commentsList == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				namedEndpoint.getCommentsList().clear();
				namedEndpoint.getCommentsList().addAll(((EList) event.getNewValue()));
			}
		}
		if (EsbViewsRepository.NamedEndpoint.Properties.endPointName == event.getAffectedEditor()) {
			namedEndpoint.setEndPointName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.NamedEndpoint.Properties.anonymous == event.getAffectedEditor()) {
			namedEndpoint.setAnonymous((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.NamedEndpoint.Properties.inLine == event.getAffectedEditor()) {
			namedEndpoint.setInLine((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.NamedEndpoint.Properties.duplicate == event.getAffectedEditor()) {
			namedEndpoint.setDuplicate((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.NamedEndpoint.Properties.properties_ == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, propertiesSettings, editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(semanticObject, PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy policy = provider.getPolicy(context);
					if (policy instanceof CreateEditingPolicy) {
						policy.execute();
					}
				}
			} else if (event.getKind() == PropertiesEditionEvent.EDIT) {
				EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(editingContext, this, (EObject) event.getNewValue(), editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt((EObject) event.getNewValue(), PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy editionPolicy = provider.getPolicy(context);
					if (editionPolicy != null) {
						editionPolicy.execute();
					}
				}
			} else if (event.getKind() == PropertiesEditionEvent.REMOVE) {
				propertiesSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				propertiesSettings.move(event.getNewIndex(), (EndPointProperty) event.getNewValue());
			}
		}
		if (EsbViewsRepository.NamedEndpoint.Properties.reversed == event.getAffectedEditor()) {
			namedEndpoint.setReversed((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.NamedEndpoint.Properties.reliableMessagingEnabled == event.getAffectedEditor()) {
			namedEndpoint.setReliableMessagingEnabled((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.NamedEndpoint.Properties.securityEnabled == event.getAffectedEditor()) {
			namedEndpoint.setSecurityEnabled((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.NamedEndpoint.Properties.addressingEnabled == event.getAffectedEditor()) {
			namedEndpoint.setAddressingEnabled((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.NamedEndpoint.Properties.addressingVersion == event.getAffectedEditor()) {
			namedEndpoint.setAddressingVersion((EndPointAddressingVersion)event.getNewValue());
		}
		if (EsbViewsRepository.NamedEndpoint.Properties.addressingSeparateListener == event.getAffectedEditor()) {
			namedEndpoint.setAddressingSeparateListener((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.NamedEndpoint.Properties.timeOutDuration == event.getAffectedEditor()) {
			namedEndpoint.setTimeOutDuration((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.NamedEndpoint.Properties.timeOutAction == event.getAffectedEditor()) {
			namedEndpoint.setTimeOutAction((EndPointTimeOutAction)event.getNewValue());
		}
		if (EsbViewsRepository.NamedEndpoint.Properties.retryErrorCodes == event.getAffectedEditor()) {
			namedEndpoint.setRetryErrorCodes((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.NamedEndpoint.Properties.retryCount == event.getAffectedEditor()) {
			namedEndpoint.setRetryCount((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.NamedEndpoint.Properties.retryDelay == event.getAffectedEditor()) {
			namedEndpoint.setRetryDelay((EEFConverterUtil.createLongFromString(EcorePackage.Literals.ELONG, (String)event.getNewValue())));
		}
		if (EsbViewsRepository.NamedEndpoint.Properties.suspendErrorCodes == event.getAffectedEditor()) {
			namedEndpoint.setSuspendErrorCodes((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.NamedEndpoint.Properties.suspendInitialDuration == event.getAffectedEditor()) {
			namedEndpoint.setSuspendInitialDuration((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.NamedEndpoint.Properties.suspendMaximumDuration == event.getAffectedEditor()) {
			namedEndpoint.setSuspendMaximumDuration((EEFConverterUtil.createLongFromString(EcorePackage.Literals.ELONG, (String)event.getNewValue())));
		}
		if (EsbViewsRepository.NamedEndpoint.Properties.suspendProgressionFactor == event.getAffectedEditor()) {
			namedEndpoint.setSuspendProgressionFactor((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.NamedEndpoint.Properties.format == event.getAffectedEditor()) {
			namedEndpoint.setFormat((EndPointMessageFormat)event.getNewValue());
		}
		if (EsbViewsRepository.NamedEndpoint.Properties.optimize == event.getAffectedEditor()) {
			namedEndpoint.setOptimize((EndPointAttachmentOptimization)event.getNewValue());
		}
		if (EsbViewsRepository.NamedEndpoint.Properties.templateParameters == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, templateParametersSettings, editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(semanticObject, PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy policy = provider.getPolicy(context);
					if (policy instanceof CreateEditingPolicy) {
						policy.execute();
					}
				}
			} else if (event.getKind() == PropertiesEditionEvent.EDIT) {
				EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(editingContext, this, (EObject) event.getNewValue(), editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt((EObject) event.getNewValue(), PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy editionPolicy = provider.getPolicy(context);
					if (editionPolicy != null) {
						editionPolicy.execute();
					}
				}
			} else if (event.getKind() == PropertiesEditionEvent.REMOVE) {
				templateParametersSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				templateParametersSettings.move(event.getNewIndex(), (TemplateParameter) event.getNewValue());
			}
		}
		if (EsbViewsRepository.NamedEndpoint.Properties.statisticsEnabled == event.getAffectedEditor()) {
			namedEndpoint.setStatisticsEnabled((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.NamedEndpoint.Properties.traceEnabled == event.getAffectedEditor()) {
			namedEndpoint.setTraceEnabled((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.NamedEndpoint.Properties.name == event.getAffectedEditor()) {
			namedEndpoint.setName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.NamedEndpoint.Properties.referringEndpointType == event.getAffectedEditor()) {
			namedEndpoint.setReferringEndpointType((KeyType)event.getNewValue());
		}
		if (EsbViewsRepository.NamedEndpoint.Properties.staticReferenceKey == event.getAffectedEditor()) {
			// Start of user code for updateStaticReferenceKey method body
            if (event.getNewValue() != null) {
                RegistryKeyProperty rkp = (RegistryKeyProperty) event.getNewValue();
                namedEndpoint.setStaticReferenceKey(rkp);
            } else {
                namedEndpoint.setStaticReferenceKey(EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty());
            }
			// End of user code
			
		}
		if (EsbViewsRepository.NamedEndpoint.Properties.dynamicReferenceKey == event.getAffectedEditor()) {
			// Start of user code for updateDynamicReferenceKey method body
            if (event.getNewValue() != null) {
                NamespacedProperty nsp = (NamespacedProperty) event.getNewValue();
                namedEndpoint.setDynamicReferenceKey(nsp);
            } else {
                namedEndpoint.setDynamicReferenceKey(EsbFactoryImpl.eINSTANCE.createNamespacedProperty());
            }
			// End of user code
			
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			NamedEndpointPropertiesEditionPart basePart = (NamedEndpointPropertiesEditionPart)editingPart;
			if (EsbPackage.eINSTANCE.getEsbElement_Description().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.NamedEndpoint.Properties.description)) {
				if (msg.getNewValue() != null) {
					basePart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setDescription("");
				}
			}
			if (EsbPackage.eINSTANCE.getEsbElement_CommentsList().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.NamedEndpoint.Properties.commentsList)) {
				if (msg.getNewValue() instanceof EList<?>) {
					basePart.setCommentsList((EList<?>)msg.getNewValue());
				} else if (msg.getNewValue() == null) {
					basePart.setCommentsList(new BasicEList<Object>());
				} else {
					BasicEList<Object> newValueAsList = new BasicEList<Object>();
					newValueAsList.add(msg.getNewValue());
					basePart.setCommentsList(newValueAsList);
				}
			}
			
			if (EsbPackage.eINSTANCE.getEndPoint_EndPointName().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.NamedEndpoint.Properties.endPointName)) {
				if (msg.getNewValue() != null) {
					basePart.setEndPointName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setEndPointName("");
				}
			}
			if (EsbPackage.eINSTANCE.getEndPoint_Anonymous().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.NamedEndpoint.Properties.anonymous))
				basePart.setAnonymous((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getEndPoint_InLine().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.NamedEndpoint.Properties.inLine))
				basePart.setInLine((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getEndPoint_Duplicate().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.NamedEndpoint.Properties.duplicate))
				basePart.setDuplicate((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getEndPoint_Properties().equals(msg.getFeature()) && isAccessible(EsbViewsRepository.NamedEndpoint.Properties.properties_))
				basePart.updateProperties();
			if (EsbPackage.eINSTANCE.getEndPoint_Reversed().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.NamedEndpoint.Properties.reversed))
				basePart.setReversed((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_ReliableMessagingEnabled().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.NamedEndpoint.Properties.reliableMessagingEnabled))
				basePart.setReliableMessagingEnabled((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_SecurityEnabled().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.NamedEndpoint.Properties.securityEnabled))
				basePart.setSecurityEnabled((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_AddressingEnabled().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.NamedEndpoint.Properties.addressingEnabled))
				basePart.setAddressingEnabled((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_AddressingVersion().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.NamedEndpoint.Properties.addressingVersion))
				basePart.setAddressingVersion((EndPointAddressingVersion)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_AddressingSeparateListener().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.NamedEndpoint.Properties.addressingSeparateListener))
				basePart.setAddressingSeparateListener((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_TimeOutDuration().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.NamedEndpoint.Properties.timeOutDuration)) {
				if (msg.getNewValue() != null) {
					basePart.setTimeOutDuration(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTimeOutDuration("");
				}
			}
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_TimeOutAction().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.NamedEndpoint.Properties.timeOutAction))
				basePart.setTimeOutAction((EndPointTimeOutAction)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_RetryErrorCodes().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.NamedEndpoint.Properties.retryErrorCodes)) {
				if (msg.getNewValue() != null) {
					basePart.setRetryErrorCodes(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setRetryErrorCodes("");
				}
			}
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_RetryCount().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.NamedEndpoint.Properties.retryCount)) {
				if (msg.getNewValue() != null) {
					basePart.setRetryCount(EcoreUtil.convertToString(EcorePackage.Literals.EINT, msg.getNewValue()));
				} else {
					basePart.setRetryCount("");
				}
			}
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_RetryDelay().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.NamedEndpoint.Properties.retryDelay)) {
				if (msg.getNewValue() != null) {
					basePart.setRetryDelay(EcoreUtil.convertToString(EcorePackage.Literals.ELONG, msg.getNewValue()));
				} else {
					basePart.setRetryDelay("");
				}
			}
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendErrorCodes().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.NamedEndpoint.Properties.suspendErrorCodes)) {
				if (msg.getNewValue() != null) {
					basePart.setSuspendErrorCodes(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setSuspendErrorCodes("");
				}
			}
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendInitialDuration().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.NamedEndpoint.Properties.suspendInitialDuration)) {
				if (msg.getNewValue() != null) {
					basePart.setSuspendInitialDuration(EcoreUtil.convertToString(EcorePackage.Literals.ELONG, msg.getNewValue()));
				} else {
					basePart.setSuspendInitialDuration("");
				}
			}
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendMaximumDuration().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.NamedEndpoint.Properties.suspendMaximumDuration)) {
				if (msg.getNewValue() != null) {
					basePart.setSuspendMaximumDuration(EcoreUtil.convertToString(EcorePackage.Literals.ELONG, msg.getNewValue()));
				} else {
					basePart.setSuspendMaximumDuration("");
				}
			}
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendProgressionFactor().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.NamedEndpoint.Properties.suspendProgressionFactor)) {
				if (msg.getNewValue() != null) {
					basePart.setSuspendProgressionFactor(EcoreUtil.convertToString(EcorePackage.Literals.EFLOAT, msg.getNewValue()));
				} else {
					basePart.setSuspendProgressionFactor("");
				}
			}
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_Format().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.NamedEndpoint.Properties.format))
				basePart.setFormat((EndPointMessageFormat)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_Optimize().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.NamedEndpoint.Properties.optimize))
				basePart.setOptimize((EndPointAttachmentOptimization)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_TemplateParameters().equals(msg.getFeature()) && isAccessible(EsbViewsRepository.NamedEndpoint.Properties.templateParameters))
				basePart.updateTemplateParameters();
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_StatisticsEnabled().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.NamedEndpoint.Properties.statisticsEnabled))
				basePart.setStatisticsEnabled((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_TraceEnabled().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.NamedEndpoint.Properties.traceEnabled))
				basePart.setTraceEnabled((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getNamedEndpoint_Name().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.NamedEndpoint.Properties.name)) {
				if (msg.getNewValue() != null) {
					basePart.setName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setName("");
				}
			}
			if (EsbPackage.eINSTANCE.getNamedEndpoint_ReferringEndpointType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.NamedEndpoint.Properties.referringEndpointType))
				basePart.setReferringEndpointType((KeyType)msg.getNewValue());
			
					// Start of user code for staticReferenceKey live update
            if (EsbPackage.eINSTANCE.getAbstractCommonTarget_EndpointKey().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject) && basePart != null
                    && isAccessible(EsbViewsRepository.NamedEndpoint.Properties.staticReferenceKey)) {
                if (msg.getNewValue() != null) {
                    basePart.setStaticReferenceKey((RegistryKeyProperty) msg.getNewValue());
                } else {
                    basePart.setStaticReferenceKey(EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty());
                }
            }
					// End of user code
			
					// Start of user code for dynamicReferenceKey live update
            if (EsbPackage.eINSTANCE.getNamedEndpoint_DynamicReferenceKey().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject) && basePart != null
                    && isAccessible(EsbViewsRepository.NamedEndpoint.Properties.dynamicReferenceKey)) {
                if (msg.getNewValue() != null) {
                    basePart.setDynamicReferenceKey((NamespacedProperty) msg.getNewValue());
                } else {
                    basePart.setDynamicReferenceKey(EsbFactoryImpl.eINSTANCE.createNamespacedProperty());
                }
            }
					// End of user code
			
			
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#getNotificationFilters()
	 */
	@Override
	protected NotificationFilter[] getNotificationFilters() {
		NotificationFilter filter = new EStructuralFeatureNotificationFilter(
			EsbPackage.eINSTANCE.getEsbElement_Description(),
			EsbPackage.eINSTANCE.getEsbElement_CommentsList(),
			EsbPackage.eINSTANCE.getEndPoint_EndPointName(),
			EsbPackage.eINSTANCE.getEndPoint_Anonymous(),
			EsbPackage.eINSTANCE.getEndPoint_InLine(),
			EsbPackage.eINSTANCE.getEndPoint_Duplicate(),
			EsbPackage.eINSTANCE.getEndPoint_Properties(),
			EsbPackage.eINSTANCE.getEndPoint_Reversed(),
			EsbPackage.eINSTANCE.getAbstractEndPoint_ReliableMessagingEnabled(),
			EsbPackage.eINSTANCE.getAbstractEndPoint_SecurityEnabled(),
			EsbPackage.eINSTANCE.getAbstractEndPoint_AddressingEnabled(),
			EsbPackage.eINSTANCE.getAbstractEndPoint_AddressingVersion(),
			EsbPackage.eINSTANCE.getAbstractEndPoint_AddressingSeparateListener(),
			EsbPackage.eINSTANCE.getAbstractEndPoint_TimeOutDuration(),
			EsbPackage.eINSTANCE.getAbstractEndPoint_TimeOutAction(),
			EsbPackage.eINSTANCE.getAbstractEndPoint_RetryErrorCodes(),
			EsbPackage.eINSTANCE.getAbstractEndPoint_RetryCount(),
			EsbPackage.eINSTANCE.getAbstractEndPoint_RetryDelay(),
			EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendErrorCodes(),
			EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendInitialDuration(),
			EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendMaximumDuration(),
			EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendProgressionFactor(),
			EsbPackage.eINSTANCE.getAbstractEndPoint_Format(),
			EsbPackage.eINSTANCE.getAbstractEndPoint_Optimize(),
			EsbPackage.eINSTANCE.getAbstractEndPoint_TemplateParameters(),
			EsbPackage.eINSTANCE.getAbstractEndPoint_StatisticsEnabled(),
			EsbPackage.eINSTANCE.getAbstractEndPoint_TraceEnabled(),
			EsbPackage.eINSTANCE.getNamedEndpoint_Name(),
			EsbPackage.eINSTANCE.getNamedEndpoint_ReferringEndpointType(),
			EsbPackage.eINSTANCE.getNamedEndpoint_StaticReferenceKey(),
			EsbPackage.eINSTANCE.getNamedEndpoint_DynamicReferenceKey()		);
		return new NotificationFilter[] {filter,};
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#validateValue(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public Diagnostic validateValue(IPropertiesEditionEvent event) {
		Diagnostic ret = Diagnostic.OK_INSTANCE;
		if (event.getNewValue() != null) {
			try {
				if (EsbViewsRepository.NamedEndpoint.Properties.description == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.NamedEndpoint.Properties.commentsList == event.getAffectedEditor()) {
					BasicDiagnostic chain = new BasicDiagnostic();
					for (Iterator iterator = ((List)event.getNewValue()).iterator(); iterator.hasNext();) {
						chain.add(Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEAttributeType(), iterator.next()));
					}
					ret = chain;
				}
				if (EsbViewsRepository.NamedEndpoint.Properties.endPointName == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEndPoint_EndPointName().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEndPoint_EndPointName().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.NamedEndpoint.Properties.anonymous == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEndPoint_Anonymous().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEndPoint_Anonymous().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.NamedEndpoint.Properties.inLine == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEndPoint_InLine().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEndPoint_InLine().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.NamedEndpoint.Properties.duplicate == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEndPoint_Duplicate().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEndPoint_Duplicate().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.NamedEndpoint.Properties.reversed == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEndPoint_Reversed().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEndPoint_Reversed().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.NamedEndpoint.Properties.reliableMessagingEnabled == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_ReliableMessagingEnabled().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_ReliableMessagingEnabled().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.NamedEndpoint.Properties.securityEnabled == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_SecurityEnabled().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_SecurityEnabled().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.NamedEndpoint.Properties.addressingEnabled == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_AddressingEnabled().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_AddressingEnabled().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.NamedEndpoint.Properties.addressingVersion == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_AddressingVersion().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_AddressingVersion().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.NamedEndpoint.Properties.addressingSeparateListener == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_AddressingSeparateListener().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_AddressingSeparateListener().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.NamedEndpoint.Properties.timeOutDuration == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_TimeOutDuration().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_TimeOutDuration().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.NamedEndpoint.Properties.timeOutAction == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_TimeOutAction().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_TimeOutAction().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.NamedEndpoint.Properties.retryErrorCodes == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_RetryErrorCodes().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_RetryErrorCodes().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.NamedEndpoint.Properties.retryCount == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_RetryCount().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_RetryCount().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.NamedEndpoint.Properties.retryDelay == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_RetryDelay().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_RetryDelay().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.NamedEndpoint.Properties.suspendErrorCodes == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendErrorCodes().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendErrorCodes().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.NamedEndpoint.Properties.suspendInitialDuration == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendInitialDuration().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendInitialDuration().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.NamedEndpoint.Properties.suspendMaximumDuration == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendMaximumDuration().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendMaximumDuration().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.NamedEndpoint.Properties.suspendProgressionFactor == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendProgressionFactor().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendProgressionFactor().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.NamedEndpoint.Properties.format == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_Format().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_Format().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.NamedEndpoint.Properties.optimize == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_Optimize().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_Optimize().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.NamedEndpoint.Properties.statisticsEnabled == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_StatisticsEnabled().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_StatisticsEnabled().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.NamedEndpoint.Properties.traceEnabled == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_TraceEnabled().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_TraceEnabled().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.NamedEndpoint.Properties.name == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getNamedEndpoint_Name().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getNamedEndpoint_Name().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.NamedEndpoint.Properties.referringEndpointType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getNamedEndpoint_ReferringEndpointType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getNamedEndpoint_ReferringEndpointType().getEAttributeType(), newValue);
				}
			} catch (IllegalArgumentException iae) {
				ret = BasicDiagnostic.toDiagnostic(iae);
			} catch (WrappedException we) {
				ret = BasicDiagnostic.toDiagnostic(we);
			}
		}
		return ret;
	}

    // Start of user code for help compatibility

    /**
     * @generated NOT
     */
    @Override
    public String getHelpContent(Object key, int kind) {
        return EEFPropertyViewUtil.getHelpContent(key);
    }

    // End of user code

	

	

}
