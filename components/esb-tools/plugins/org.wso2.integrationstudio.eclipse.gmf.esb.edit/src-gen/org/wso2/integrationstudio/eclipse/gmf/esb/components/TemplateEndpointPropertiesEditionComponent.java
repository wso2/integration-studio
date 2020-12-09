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
import org.wso2.integrationstudio.eclipse.gmf.esb.TemplateEndpoint;
import org.wso2.integrationstudio.eclipse.gmf.esb.TemplateEndpointParameter;
import org.wso2.integrationstudio.eclipse.gmf.esb.TemplateParameter;

import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.TemplateEndpointPropertiesEditionPart;


// End of user code

/**
 * 
 * 
 */
public class TemplateEndpointPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
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
	 * Settings for parameters ReferencesTable
	 */
	protected ReferencesTableSettings parametersSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public TemplateEndpointPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject templateEndpoint, String editing_mode) {
		super(editingContext, templateEndpoint, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EsbViewsRepository.class;
		partKey = EsbViewsRepository.TemplateEndpoint.class;
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
			
			final TemplateEndpoint templateEndpoint = (TemplateEndpoint)elt;
			final TemplateEndpointPropertiesEditionPart basePart = (TemplateEndpointPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EsbViewsRepository.TemplateEndpoint.Properties.description))
				basePart.setDescription(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, templateEndpoint.getDescription()));
			
			if (isAccessible(EsbViewsRepository.TemplateEndpoint.Properties.commentsList))
				basePart.setCommentsList(templateEndpoint.getCommentsList());
			
			if (isAccessible(EsbViewsRepository.TemplateEndpoint.Properties.endPointName))
				basePart.setEndPointName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, templateEndpoint.getEndPointName()));
			
			if (isAccessible(EsbViewsRepository.TemplateEndpoint.Properties.anonymous)) {
				basePart.setAnonymous(templateEndpoint.isAnonymous());
			}
			if (isAccessible(EsbViewsRepository.TemplateEndpoint.Properties.inLine)) {
				basePart.setInLine(templateEndpoint.isInLine());
			}
			if (isAccessible(EsbViewsRepository.TemplateEndpoint.Properties.duplicate)) {
				basePart.setDuplicate(templateEndpoint.isDuplicate());
			}
			if (isAccessible(EsbViewsRepository.TemplateEndpoint.Properties.properties_)) {
				propertiesSettings = new ReferencesTableSettings(templateEndpoint, EsbPackage.eINSTANCE.getEndPoint_Properties());
				basePart.initProperties(propertiesSettings);
			}
			if (isAccessible(EsbViewsRepository.TemplateEndpoint.Properties.reversed)) {
				basePart.setReversed(templateEndpoint.isReversed());
			}
			if (isAccessible(EsbViewsRepository.TemplateEndpoint.Properties.reliableMessagingEnabled)) {
				basePart.setReliableMessagingEnabled(templateEndpoint.isReliableMessagingEnabled());
			}
			if (isAccessible(EsbViewsRepository.TemplateEndpoint.Properties.securityEnabled)) {
				basePart.setSecurityEnabled(templateEndpoint.isSecurityEnabled());
			}
			if (isAccessible(EsbViewsRepository.TemplateEndpoint.Properties.addressingEnabled)) {
				basePart.setAddressingEnabled(templateEndpoint.isAddressingEnabled());
			}
			if (isAccessible(EsbViewsRepository.TemplateEndpoint.Properties.addressingVersion)) {
				basePart.initAddressingVersion(EEFUtils.choiceOfValues(templateEndpoint, EsbPackage.eINSTANCE.getAbstractEndPoint_AddressingVersion()), templateEndpoint.getAddressingVersion());
			}
			if (isAccessible(EsbViewsRepository.TemplateEndpoint.Properties.addressingSeparateListener)) {
				basePart.setAddressingSeparateListener(templateEndpoint.isAddressingSeparateListener());
			}
			if (isAccessible(EsbViewsRepository.TemplateEndpoint.Properties.timeOutDuration))
				basePart.setTimeOutDuration(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, templateEndpoint.getTimeOutDuration()));
			
			if (isAccessible(EsbViewsRepository.TemplateEndpoint.Properties.timeOutAction)) {
				basePart.initTimeOutAction(EEFUtils.choiceOfValues(templateEndpoint, EsbPackage.eINSTANCE.getAbstractEndPoint_TimeOutAction()), templateEndpoint.getTimeOutAction());
			}
			if (isAccessible(EsbViewsRepository.TemplateEndpoint.Properties.retryErrorCodes))
				basePart.setRetryErrorCodes(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, templateEndpoint.getRetryErrorCodes()));
			
			if (isAccessible(EsbViewsRepository.TemplateEndpoint.Properties.retryCount))
				basePart.setRetryCount(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, templateEndpoint.getRetryCount()));
			
			if (isAccessible(EsbViewsRepository.TemplateEndpoint.Properties.retryDelay)) {
				basePart.setRetryDelay(EEFConverterUtil.convertToString(EcorePackage.Literals.ELONG, templateEndpoint.getRetryDelay()));
			}
			
			if (isAccessible(EsbViewsRepository.TemplateEndpoint.Properties.suspendErrorCodes))
				basePart.setSuspendErrorCodes(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, templateEndpoint.getSuspendErrorCodes()));
			
			if (isAccessible(EsbViewsRepository.TemplateEndpoint.Properties.suspendInitialDuration))
				basePart.setSuspendInitialDuration(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, templateEndpoint.getSuspendInitialDuration()));
			
			if (isAccessible(EsbViewsRepository.TemplateEndpoint.Properties.suspendMaximumDuration)) {
				basePart.setSuspendMaximumDuration(EEFConverterUtil.convertToString(EcorePackage.Literals.ELONG, templateEndpoint.getSuspendMaximumDuration()));
			}
			
			if (isAccessible(EsbViewsRepository.TemplateEndpoint.Properties.suspendProgressionFactor))
				basePart.setSuspendProgressionFactor(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, templateEndpoint.getSuspendProgressionFactor()));
			
			if (isAccessible(EsbViewsRepository.TemplateEndpoint.Properties.format)) {
				basePart.initFormat(EEFUtils.choiceOfValues(templateEndpoint, EsbPackage.eINSTANCE.getAbstractEndPoint_Format()), templateEndpoint.getFormat());
			}
			if (isAccessible(EsbViewsRepository.TemplateEndpoint.Properties.optimize)) {
				basePart.initOptimize(EEFUtils.choiceOfValues(templateEndpoint, EsbPackage.eINSTANCE.getAbstractEndPoint_Optimize()), templateEndpoint.getOptimize());
			}
			if (isAccessible(EsbViewsRepository.TemplateEndpoint.Properties.templateParameters)) {
				templateParametersSettings = new ReferencesTableSettings(templateEndpoint, EsbPackage.eINSTANCE.getAbstractEndPoint_TemplateParameters());
				basePart.initTemplateParameters(templateParametersSettings);
			}
			if (isAccessible(EsbViewsRepository.TemplateEndpoint.Properties.statisticsEnabled)) {
				basePart.setStatisticsEnabled(templateEndpoint.isStatisticsEnabled());
			}
			if (isAccessible(EsbViewsRepository.TemplateEndpoint.Properties.traceEnabled)) {
				basePart.setTraceEnabled(templateEndpoint.isTraceEnabled());
			}
			if (isAccessible(EsbViewsRepository.TemplateEndpoint.Properties.address))
				basePart.setAddress(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, templateEndpoint.getAddress()));
			
			if (isAccessible(EsbViewsRepository.TemplateEndpoint.Properties.targetTemplate))
				basePart.setTargetTemplate(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, templateEndpoint.getTargetTemplate()));
			
			if (isAccessible(EsbViewsRepository.TemplateEndpoint.Properties.parameters)) {
				parametersSettings = new ReferencesTableSettings(templateEndpoint, EsbPackage.eINSTANCE.getTemplateEndpoint_Parameters());
				basePart.initParameters(parametersSettings);
			}
			if (isAccessible(EsbViewsRepository.TemplateEndpoint.Properties.availableTemplates))
				basePart.setAvailableTemplates(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, templateEndpoint.getAvailableTemplates()));
			
			// init filters
			
			
			
			
			
			
			if (isAccessible(EsbViewsRepository.TemplateEndpoint.Properties.properties_)) {
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
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			if (isAccessible(EsbViewsRepository.TemplateEndpoint.Properties.templateParameters)) {
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
			
			
			
			
			if (isAccessible(EsbViewsRepository.TemplateEndpoint.Properties.parameters)) {
				basePart.addFilterToParameters(new ViewerFilter() {
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof TemplateEndpointParameter); //$NON-NLS-1$ 
					}
			
				});
				// Start of user code for additional businessfilters for parameters
				// End of user code
			}
			
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
		if (editorKey == EsbViewsRepository.TemplateEndpoint.Properties.description) {
			return EsbPackage.eINSTANCE.getEsbElement_Description();
		}
		if (editorKey == EsbViewsRepository.TemplateEndpoint.Properties.commentsList) {
			return EsbPackage.eINSTANCE.getEsbElement_CommentsList();
		}
		if (editorKey == EsbViewsRepository.TemplateEndpoint.Properties.endPointName) {
			return EsbPackage.eINSTANCE.getEndPoint_EndPointName();
		}
		if (editorKey == EsbViewsRepository.TemplateEndpoint.Properties.anonymous) {
			return EsbPackage.eINSTANCE.getEndPoint_Anonymous();
		}
		if (editorKey == EsbViewsRepository.TemplateEndpoint.Properties.inLine) {
			return EsbPackage.eINSTANCE.getEndPoint_InLine();
		}
		if (editorKey == EsbViewsRepository.TemplateEndpoint.Properties.duplicate) {
			return EsbPackage.eINSTANCE.getEndPoint_Duplicate();
		}
		if (editorKey == EsbViewsRepository.TemplateEndpoint.Properties.properties_) {
			return EsbPackage.eINSTANCE.getEndPoint_Properties();
		}
		if (editorKey == EsbViewsRepository.TemplateEndpoint.Properties.reversed) {
			return EsbPackage.eINSTANCE.getEndPoint_Reversed();
		}
		if (editorKey == EsbViewsRepository.TemplateEndpoint.Properties.reliableMessagingEnabled) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_ReliableMessagingEnabled();
		}
		if (editorKey == EsbViewsRepository.TemplateEndpoint.Properties.securityEnabled) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_SecurityEnabled();
		}
		if (editorKey == EsbViewsRepository.TemplateEndpoint.Properties.addressingEnabled) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_AddressingEnabled();
		}
		if (editorKey == EsbViewsRepository.TemplateEndpoint.Properties.addressingVersion) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_AddressingVersion();
		}
		if (editorKey == EsbViewsRepository.TemplateEndpoint.Properties.addressingSeparateListener) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_AddressingSeparateListener();
		}
		if (editorKey == EsbViewsRepository.TemplateEndpoint.Properties.timeOutDuration) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_TimeOutDuration();
		}
		if (editorKey == EsbViewsRepository.TemplateEndpoint.Properties.timeOutAction) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_TimeOutAction();
		}
		if (editorKey == EsbViewsRepository.TemplateEndpoint.Properties.retryErrorCodes) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_RetryErrorCodes();
		}
		if (editorKey == EsbViewsRepository.TemplateEndpoint.Properties.retryCount) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_RetryCount();
		}
		if (editorKey == EsbViewsRepository.TemplateEndpoint.Properties.retryDelay) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_RetryDelay();
		}
		if (editorKey == EsbViewsRepository.TemplateEndpoint.Properties.suspendErrorCodes) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendErrorCodes();
		}
		if (editorKey == EsbViewsRepository.TemplateEndpoint.Properties.suspendInitialDuration) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendInitialDuration();
		}
		if (editorKey == EsbViewsRepository.TemplateEndpoint.Properties.suspendMaximumDuration) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendMaximumDuration();
		}
		if (editorKey == EsbViewsRepository.TemplateEndpoint.Properties.suspendProgressionFactor) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendProgressionFactor();
		}
		if (editorKey == EsbViewsRepository.TemplateEndpoint.Properties.format) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_Format();
		}
		if (editorKey == EsbViewsRepository.TemplateEndpoint.Properties.optimize) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_Optimize();
		}
		if (editorKey == EsbViewsRepository.TemplateEndpoint.Properties.templateParameters) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_TemplateParameters();
		}
		if (editorKey == EsbViewsRepository.TemplateEndpoint.Properties.statisticsEnabled) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_StatisticsEnabled();
		}
		if (editorKey == EsbViewsRepository.TemplateEndpoint.Properties.traceEnabled) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_TraceEnabled();
		}
		if (editorKey == EsbViewsRepository.TemplateEndpoint.Properties.address) {
			return EsbPackage.eINSTANCE.getTemplateEndpoint_Address();
		}
		if (editorKey == EsbViewsRepository.TemplateEndpoint.Properties.targetTemplate) {
			return EsbPackage.eINSTANCE.getTemplateEndpoint_TargetTemplate();
		}
		if (editorKey == EsbViewsRepository.TemplateEndpoint.Properties.parameters) {
			return EsbPackage.eINSTANCE.getTemplateEndpoint_Parameters();
		}
		if (editorKey == EsbViewsRepository.TemplateEndpoint.Properties.availableTemplates) {
			return EsbPackage.eINSTANCE.getTemplateEndpoint_AvailableTemplates();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		TemplateEndpoint templateEndpoint = (TemplateEndpoint)semanticObject;
		if (EsbViewsRepository.TemplateEndpoint.Properties.description == event.getAffectedEditor()) {
			templateEndpoint.setDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.TemplateEndpoint.Properties.commentsList == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				templateEndpoint.getCommentsList().clear();
				templateEndpoint.getCommentsList().addAll(((EList) event.getNewValue()));
			}
		}
		if (EsbViewsRepository.TemplateEndpoint.Properties.endPointName == event.getAffectedEditor()) {
			templateEndpoint.setEndPointName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.TemplateEndpoint.Properties.anonymous == event.getAffectedEditor()) {
			templateEndpoint.setAnonymous((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.TemplateEndpoint.Properties.inLine == event.getAffectedEditor()) {
			templateEndpoint.setInLine((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.TemplateEndpoint.Properties.duplicate == event.getAffectedEditor()) {
			templateEndpoint.setDuplicate((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.TemplateEndpoint.Properties.properties_ == event.getAffectedEditor()) {
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
		if (EsbViewsRepository.TemplateEndpoint.Properties.reversed == event.getAffectedEditor()) {
			templateEndpoint.setReversed((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.TemplateEndpoint.Properties.reliableMessagingEnabled == event.getAffectedEditor()) {
			templateEndpoint.setReliableMessagingEnabled((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.TemplateEndpoint.Properties.securityEnabled == event.getAffectedEditor()) {
			templateEndpoint.setSecurityEnabled((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.TemplateEndpoint.Properties.addressingEnabled == event.getAffectedEditor()) {
			templateEndpoint.setAddressingEnabled((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.TemplateEndpoint.Properties.addressingVersion == event.getAffectedEditor()) {
			templateEndpoint.setAddressingVersion((EndPointAddressingVersion)event.getNewValue());
		}
		if (EsbViewsRepository.TemplateEndpoint.Properties.addressingSeparateListener == event.getAffectedEditor()) {
			templateEndpoint.setAddressingSeparateListener((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.TemplateEndpoint.Properties.timeOutDuration == event.getAffectedEditor()) {
			templateEndpoint.setTimeOutDuration((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.TemplateEndpoint.Properties.timeOutAction == event.getAffectedEditor()) {
			templateEndpoint.setTimeOutAction((EndPointTimeOutAction)event.getNewValue());
		}
		if (EsbViewsRepository.TemplateEndpoint.Properties.retryErrorCodes == event.getAffectedEditor()) {
			templateEndpoint.setRetryErrorCodes((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.TemplateEndpoint.Properties.retryCount == event.getAffectedEditor()) {
			templateEndpoint.setRetryCount((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.TemplateEndpoint.Properties.retryDelay == event.getAffectedEditor()) {
			templateEndpoint.setRetryDelay((EEFConverterUtil.createLongFromString(EcorePackage.Literals.ELONG, (String)event.getNewValue())));
		}
		if (EsbViewsRepository.TemplateEndpoint.Properties.suspendErrorCodes == event.getAffectedEditor()) {
			templateEndpoint.setSuspendErrorCodes((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.TemplateEndpoint.Properties.suspendInitialDuration == event.getAffectedEditor()) {
			templateEndpoint.setSuspendInitialDuration((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.TemplateEndpoint.Properties.suspendMaximumDuration == event.getAffectedEditor()) {
			templateEndpoint.setSuspendMaximumDuration((EEFConverterUtil.createLongFromString(EcorePackage.Literals.ELONG, (String)event.getNewValue())));
		}
		if (EsbViewsRepository.TemplateEndpoint.Properties.suspendProgressionFactor == event.getAffectedEditor()) {
			templateEndpoint.setSuspendProgressionFactor((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.TemplateEndpoint.Properties.format == event.getAffectedEditor()) {
			templateEndpoint.setFormat((EndPointMessageFormat)event.getNewValue());
		}
		if (EsbViewsRepository.TemplateEndpoint.Properties.optimize == event.getAffectedEditor()) {
			templateEndpoint.setOptimize((EndPointAttachmentOptimization)event.getNewValue());
		}
		if (EsbViewsRepository.TemplateEndpoint.Properties.templateParameters == event.getAffectedEditor()) {
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
		if (EsbViewsRepository.TemplateEndpoint.Properties.statisticsEnabled == event.getAffectedEditor()) {
			templateEndpoint.setStatisticsEnabled((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.TemplateEndpoint.Properties.traceEnabled == event.getAffectedEditor()) {
			templateEndpoint.setTraceEnabled((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.TemplateEndpoint.Properties.address == event.getAffectedEditor()) {
			templateEndpoint.setAddress((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.TemplateEndpoint.Properties.targetTemplate == event.getAffectedEditor()) {
			templateEndpoint.setTargetTemplate((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.TemplateEndpoint.Properties.parameters == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, parametersSettings, editingContext.getAdapterFactory());
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
				parametersSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				parametersSettings.move(event.getNewIndex(), (TemplateEndpointParameter) event.getNewValue());
			}
		}
		if (EsbViewsRepository.TemplateEndpoint.Properties.availableTemplates == event.getAffectedEditor()) {
			templateEndpoint.setAvailableTemplates((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			TemplateEndpointPropertiesEditionPart basePart = (TemplateEndpointPropertiesEditionPart)editingPart;
			if (EsbPackage.eINSTANCE.getEsbElement_Description().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.TemplateEndpoint.Properties.description)) {
				if (msg.getNewValue() != null) {
					basePart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setDescription("");
				}
			}
			if (EsbPackage.eINSTANCE.getEsbElement_CommentsList().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.TemplateEndpoint.Properties.commentsList)) {
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
			
			if (EsbPackage.eINSTANCE.getEndPoint_EndPointName().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.TemplateEndpoint.Properties.endPointName)) {
				if (msg.getNewValue() != null) {
					basePart.setEndPointName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setEndPointName("");
				}
			}
			if (EsbPackage.eINSTANCE.getEndPoint_Anonymous().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.TemplateEndpoint.Properties.anonymous))
				basePart.setAnonymous((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getEndPoint_InLine().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.TemplateEndpoint.Properties.inLine))
				basePart.setInLine((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getEndPoint_Duplicate().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.TemplateEndpoint.Properties.duplicate))
				basePart.setDuplicate((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getEndPoint_Properties().equals(msg.getFeature()) && isAccessible(EsbViewsRepository.TemplateEndpoint.Properties.properties_))
				basePart.updateProperties();
			if (EsbPackage.eINSTANCE.getEndPoint_Reversed().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.TemplateEndpoint.Properties.reversed))
				basePart.setReversed((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_ReliableMessagingEnabled().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.TemplateEndpoint.Properties.reliableMessagingEnabled))
				basePart.setReliableMessagingEnabled((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_SecurityEnabled().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.TemplateEndpoint.Properties.securityEnabled))
				basePart.setSecurityEnabled((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_AddressingEnabled().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.TemplateEndpoint.Properties.addressingEnabled))
				basePart.setAddressingEnabled((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_AddressingVersion().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.TemplateEndpoint.Properties.addressingVersion))
				basePart.setAddressingVersion((EndPointAddressingVersion)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_AddressingSeparateListener().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.TemplateEndpoint.Properties.addressingSeparateListener))
				basePart.setAddressingSeparateListener((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_TimeOutDuration().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.TemplateEndpoint.Properties.timeOutDuration)) {
				if (msg.getNewValue() != null) {
					basePart.setTimeOutDuration(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTimeOutDuration("");
				}
			}
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_TimeOutAction().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.TemplateEndpoint.Properties.timeOutAction))
				basePart.setTimeOutAction((EndPointTimeOutAction)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_RetryErrorCodes().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.TemplateEndpoint.Properties.retryErrorCodes)) {
				if (msg.getNewValue() != null) {
					basePart.setRetryErrorCodes(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setRetryErrorCodes("");
				}
			}
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_RetryCount().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.TemplateEndpoint.Properties.retryCount)) {
				if (msg.getNewValue() != null) {
					basePart.setRetryCount(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setRetryCount("");
				}
			}
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_RetryDelay().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.TemplateEndpoint.Properties.retryDelay)) {
				if (msg.getNewValue() != null) {
					basePart.setRetryDelay(EcoreUtil.convertToString(EcorePackage.Literals.ELONG, msg.getNewValue()));
				} else {
					basePart.setRetryDelay("");
				}
			}
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendErrorCodes().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.TemplateEndpoint.Properties.suspendErrorCodes)) {
				if (msg.getNewValue() != null) {
					basePart.setSuspendErrorCodes(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setSuspendErrorCodes("");
				}
			}
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendInitialDuration().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.TemplateEndpoint.Properties.suspendInitialDuration)) {
				if (msg.getNewValue() != null) {
					basePart.setSuspendInitialDuration(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setSuspendInitialDuration("");
				}
			}
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendMaximumDuration().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.TemplateEndpoint.Properties.suspendMaximumDuration)) {
				if (msg.getNewValue() != null) {
					basePart.setSuspendMaximumDuration(EcoreUtil.convertToString(EcorePackage.Literals.ELONG, msg.getNewValue()));
				} else {
					basePart.setSuspendMaximumDuration("");
				}
			}
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendProgressionFactor().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.TemplateEndpoint.Properties.suspendProgressionFactor)) {
				if (msg.getNewValue() != null) {
					basePart.setSuspendProgressionFactor(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setSuspendProgressionFactor("");
				}
			}
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_Format().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.TemplateEndpoint.Properties.format))
				basePart.setFormat((EndPointMessageFormat)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_Optimize().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.TemplateEndpoint.Properties.optimize))
				basePart.setOptimize((EndPointAttachmentOptimization)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_TemplateParameters().equals(msg.getFeature()) && isAccessible(EsbViewsRepository.TemplateEndpoint.Properties.templateParameters))
				basePart.updateTemplateParameters();
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_StatisticsEnabled().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.TemplateEndpoint.Properties.statisticsEnabled))
				basePart.setStatisticsEnabled((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_TraceEnabled().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.TemplateEndpoint.Properties.traceEnabled))
				basePart.setTraceEnabled((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getTemplateEndpoint_Address().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.TemplateEndpoint.Properties.address)) {
				if (msg.getNewValue() != null) {
					basePart.setAddress(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setAddress("");
				}
			}
			if (EsbPackage.eINSTANCE.getTemplateEndpoint_TargetTemplate().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.TemplateEndpoint.Properties.targetTemplate)) {
				if (msg.getNewValue() != null) {
					basePart.setTargetTemplate(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTargetTemplate("");
				}
			}
			if (EsbPackage.eINSTANCE.getTemplateEndpoint_Parameters().equals(msg.getFeature()) && isAccessible(EsbViewsRepository.TemplateEndpoint.Properties.parameters))
				basePart.updateParameters();
			if (EsbPackage.eINSTANCE.getTemplateEndpoint_AvailableTemplates().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.TemplateEndpoint.Properties.availableTemplates)) {
				if (msg.getNewValue() != null) {
					basePart.setAvailableTemplates(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setAvailableTemplates("");
				}
			}
			
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
			EsbPackage.eINSTANCE.getTemplateEndpoint_Address(),
			EsbPackage.eINSTANCE.getTemplateEndpoint_TargetTemplate(),
			EsbPackage.eINSTANCE.getTemplateEndpoint_Parameters(),
			EsbPackage.eINSTANCE.getTemplateEndpoint_AvailableTemplates()		);
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
				if (EsbViewsRepository.TemplateEndpoint.Properties.description == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.TemplateEndpoint.Properties.commentsList == event.getAffectedEditor()) {
					BasicDiagnostic chain = new BasicDiagnostic();
					for (Iterator iterator = ((List)event.getNewValue()).iterator(); iterator.hasNext();) {
						chain.add(Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEAttributeType(), iterator.next()));
					}
					ret = chain;
				}
				if (EsbViewsRepository.TemplateEndpoint.Properties.endPointName == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEndPoint_EndPointName().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEndPoint_EndPointName().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.TemplateEndpoint.Properties.anonymous == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEndPoint_Anonymous().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEndPoint_Anonymous().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.TemplateEndpoint.Properties.inLine == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEndPoint_InLine().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEndPoint_InLine().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.TemplateEndpoint.Properties.duplicate == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEndPoint_Duplicate().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEndPoint_Duplicate().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.TemplateEndpoint.Properties.reversed == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEndPoint_Reversed().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEndPoint_Reversed().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.TemplateEndpoint.Properties.reliableMessagingEnabled == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_ReliableMessagingEnabled().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_ReliableMessagingEnabled().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.TemplateEndpoint.Properties.securityEnabled == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_SecurityEnabled().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_SecurityEnabled().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.TemplateEndpoint.Properties.addressingEnabled == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_AddressingEnabled().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_AddressingEnabled().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.TemplateEndpoint.Properties.addressingVersion == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_AddressingVersion().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_AddressingVersion().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.TemplateEndpoint.Properties.addressingSeparateListener == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_AddressingSeparateListener().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_AddressingSeparateListener().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.TemplateEndpoint.Properties.timeOutDuration == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_TimeOutDuration().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_TimeOutDuration().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.TemplateEndpoint.Properties.timeOutAction == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_TimeOutAction().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_TimeOutAction().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.TemplateEndpoint.Properties.retryErrorCodes == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_RetryErrorCodes().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_RetryErrorCodes().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.TemplateEndpoint.Properties.retryCount == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_RetryCount().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_RetryCount().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.TemplateEndpoint.Properties.retryDelay == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_RetryDelay().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_RetryDelay().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.TemplateEndpoint.Properties.suspendErrorCodes == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendErrorCodes().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendErrorCodes().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.TemplateEndpoint.Properties.suspendInitialDuration == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendInitialDuration().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendInitialDuration().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.TemplateEndpoint.Properties.suspendMaximumDuration == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendMaximumDuration().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendMaximumDuration().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.TemplateEndpoint.Properties.suspendProgressionFactor == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendProgressionFactor().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendProgressionFactor().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.TemplateEndpoint.Properties.format == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_Format().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_Format().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.TemplateEndpoint.Properties.optimize == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_Optimize().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_Optimize().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.TemplateEndpoint.Properties.statisticsEnabled == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_StatisticsEnabled().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_StatisticsEnabled().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.TemplateEndpoint.Properties.traceEnabled == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_TraceEnabled().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_TraceEnabled().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.TemplateEndpoint.Properties.address == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getTemplateEndpoint_Address().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getTemplateEndpoint_Address().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.TemplateEndpoint.Properties.targetTemplate == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getTemplateEndpoint_TargetTemplate().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getTemplateEndpoint_TargetTemplate().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.TemplateEndpoint.Properties.availableTemplates == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getTemplateEndpoint_AvailableTemplates().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getTemplateEndpoint_AvailableTemplates().getEAttributeType(), newValue);
				}
			} catch (IllegalArgumentException iae) {
				ret = BasicDiagnostic.toDiagnostic(iae);
			} catch (WrappedException we) {
				ret = BasicDiagnostic.toDiagnostic(we);
			}
		}
		return ret;
	}


	

	

}
