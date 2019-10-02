/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.components;

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

import org.wso2.developerstudio.eclipse.gmf.esb.AddressingEndpoint;
import org.wso2.developerstudio.eclipse.gmf.esb.EndPointAddressingVersion;
import org.wso2.developerstudio.eclipse.gmf.esb.EndPointAttachmentOptimization;
import org.wso2.developerstudio.eclipse.gmf.esb.EndPointMessageFormat;
import org.wso2.developerstudio.eclipse.gmf.esb.EndPointProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.EndPointTimeOutAction;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.TemplateParameter;

import org.wso2.developerstudio.eclipse.gmf.esb.parts.AddressingEndpointPropertiesEditionPart;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;


// End of user code

/**
 * 
 * 
 */
public class AddressingEndpointPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
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
	public AddressingEndpointPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject addressingEndpoint, String editing_mode) {
		super(editingContext, addressingEndpoint, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EsbViewsRepository.class;
		partKey = EsbViewsRepository.AddressingEndpoint.class;
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
			
			final AddressingEndpoint addressingEndpoint = (AddressingEndpoint)elt;
			final AddressingEndpointPropertiesEditionPart basePart = (AddressingEndpointPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EsbViewsRepository.AddressingEndpoint.Properties.description))
				basePart.setDescription(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, addressingEndpoint.getDescription()));
			
			if (isAccessible(EsbViewsRepository.AddressingEndpoint.Properties.commentsList))
				basePart.setCommentsList(addressingEndpoint.getCommentsList());
			
			if (isAccessible(EsbViewsRepository.AddressingEndpoint.Properties.endPointName))
				basePart.setEndPointName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, addressingEndpoint.getEndPointName()));
			
			if (isAccessible(EsbViewsRepository.AddressingEndpoint.Properties.anonymous)) {
				basePart.setAnonymous(addressingEndpoint.isAnonymous());
			}
			if (isAccessible(EsbViewsRepository.AddressingEndpoint.Properties.inLine)) {
				basePart.setInLine(addressingEndpoint.isInLine());
			}
			if (isAccessible(EsbViewsRepository.AddressingEndpoint.Properties.duplicate)) {
				basePart.setDuplicate(addressingEndpoint.isDuplicate());
			}
			if (isAccessible(EsbViewsRepository.AddressingEndpoint.Properties.properties_)) {
				propertiesSettings = new ReferencesTableSettings(addressingEndpoint, EsbPackage.eINSTANCE.getEndPoint_Properties());
				basePart.initProperties(propertiesSettings);
			}
			if (isAccessible(EsbViewsRepository.AddressingEndpoint.Properties.reversed)) {
				basePart.setReversed(addressingEndpoint.isReversed());
			}
			if (isAccessible(EsbViewsRepository.AddressingEndpoint.Properties.reliableMessagingEnabled)) {
				basePart.setReliableMessagingEnabled(addressingEndpoint.isReliableMessagingEnabled());
			}
			if (isAccessible(EsbViewsRepository.AddressingEndpoint.Properties.securityEnabled)) {
				basePart.setSecurityEnabled(addressingEndpoint.isSecurityEnabled());
			}
			if (isAccessible(EsbViewsRepository.AddressingEndpoint.Properties.addressingEnabled)) {
				basePart.setAddressingEnabled(addressingEndpoint.isAddressingEnabled());
			}
			if (isAccessible(EsbViewsRepository.AddressingEndpoint.Properties.addressingVersion)) {
				basePart.initAddressingVersion(EEFUtils.choiceOfValues(addressingEndpoint, EsbPackage.eINSTANCE.getAbstractEndPoint_AddressingVersion()), addressingEndpoint.getAddressingVersion());
			}
			if (isAccessible(EsbViewsRepository.AddressingEndpoint.Properties.addressingSeparateListener)) {
				basePart.setAddressingSeparateListener(addressingEndpoint.isAddressingSeparateListener());
			}
			if (isAccessible(EsbViewsRepository.AddressingEndpoint.Properties.timeOutDuration))
				basePart.setTimeOutDuration(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, addressingEndpoint.getTimeOutDuration()));
			
			if (isAccessible(EsbViewsRepository.AddressingEndpoint.Properties.timeOutAction)) {
				basePart.initTimeOutAction(EEFUtils.choiceOfValues(addressingEndpoint, EsbPackage.eINSTANCE.getAbstractEndPoint_TimeOutAction()), addressingEndpoint.getTimeOutAction());
			}
			if (isAccessible(EsbViewsRepository.AddressingEndpoint.Properties.retryErrorCodes))
				basePart.setRetryErrorCodes(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, addressingEndpoint.getRetryErrorCodes()));
			
			if (isAccessible(EsbViewsRepository.AddressingEndpoint.Properties.retryCount))
				basePart.setRetryCount(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, addressingEndpoint.getRetryCount()));
			
			if (isAccessible(EsbViewsRepository.AddressingEndpoint.Properties.retryDelay)) {
				basePart.setRetryDelay(EEFConverterUtil.convertToString(EcorePackage.Literals.ELONG, addressingEndpoint.getRetryDelay()));
			}
			
			if (isAccessible(EsbViewsRepository.AddressingEndpoint.Properties.suspendErrorCodes))
				basePart.setSuspendErrorCodes(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, addressingEndpoint.getSuspendErrorCodes()));
			
			if (isAccessible(EsbViewsRepository.AddressingEndpoint.Properties.suspendInitialDuration))
				basePart.setSuspendInitialDuration(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, addressingEndpoint.getSuspendInitialDuration()));
			
			if (isAccessible(EsbViewsRepository.AddressingEndpoint.Properties.suspendMaximumDuration)) {
				basePart.setSuspendMaximumDuration(EEFConverterUtil.convertToString(EcorePackage.Literals.ELONG, addressingEndpoint.getSuspendMaximumDuration()));
			}
			
			if (isAccessible(EsbViewsRepository.AddressingEndpoint.Properties.suspendProgressionFactor))
				basePart.setSuspendProgressionFactor(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, addressingEndpoint.getSuspendProgressionFactor()));
			
			if (isAccessible(EsbViewsRepository.AddressingEndpoint.Properties.format)) {
				basePart.initFormat(EEFUtils.choiceOfValues(addressingEndpoint, EsbPackage.eINSTANCE.getAbstractEndPoint_Format()), addressingEndpoint.getFormat());
			}
			if (isAccessible(EsbViewsRepository.AddressingEndpoint.Properties.optimize)) {
				basePart.initOptimize(EEFUtils.choiceOfValues(addressingEndpoint, EsbPackage.eINSTANCE.getAbstractEndPoint_Optimize()), addressingEndpoint.getOptimize());
			}
			if (isAccessible(EsbViewsRepository.AddressingEndpoint.Properties.templateParameters)) {
				templateParametersSettings = new ReferencesTableSettings(addressingEndpoint, EsbPackage.eINSTANCE.getAbstractEndPoint_TemplateParameters());
				basePart.initTemplateParameters(templateParametersSettings);
			}
			if (isAccessible(EsbViewsRepository.AddressingEndpoint.Properties.statisticsEnabled)) {
				basePart.setStatisticsEnabled(addressingEndpoint.isStatisticsEnabled());
			}
			if (isAccessible(EsbViewsRepository.AddressingEndpoint.Properties.traceEnabled)) {
				basePart.setTraceEnabled(addressingEndpoint.isTraceEnabled());
			}
			// init filters
			
			
			
			
			
			
			if (isAccessible(EsbViewsRepository.AddressingEndpoint.Properties.properties_)) {
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
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			if (isAccessible(EsbViewsRepository.AddressingEndpoint.Properties.templateParameters)) {
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
		if (editorKey == EsbViewsRepository.AddressingEndpoint.Properties.description) {
			return EsbPackage.eINSTANCE.getEsbElement_Description();
		}
		if (editorKey == EsbViewsRepository.AddressingEndpoint.Properties.commentsList) {
			return EsbPackage.eINSTANCE.getEsbElement_CommentsList();
		}
		if (editorKey == EsbViewsRepository.AddressingEndpoint.Properties.endPointName) {
			return EsbPackage.eINSTANCE.getEndPoint_EndPointName();
		}
		if (editorKey == EsbViewsRepository.AddressingEndpoint.Properties.anonymous) {
			return EsbPackage.eINSTANCE.getEndPoint_Anonymous();
		}
		if (editorKey == EsbViewsRepository.AddressingEndpoint.Properties.inLine) {
			return EsbPackage.eINSTANCE.getEndPoint_InLine();
		}
		if (editorKey == EsbViewsRepository.AddressingEndpoint.Properties.duplicate) {
			return EsbPackage.eINSTANCE.getEndPoint_Duplicate();
		}
		if (editorKey == EsbViewsRepository.AddressingEndpoint.Properties.properties_) {
			return EsbPackage.eINSTANCE.getEndPoint_Properties();
		}
		if (editorKey == EsbViewsRepository.AddressingEndpoint.Properties.reversed) {
			return EsbPackage.eINSTANCE.getEndPoint_Reversed();
		}
		if (editorKey == EsbViewsRepository.AddressingEndpoint.Properties.reliableMessagingEnabled) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_ReliableMessagingEnabled();
		}
		if (editorKey == EsbViewsRepository.AddressingEndpoint.Properties.securityEnabled) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_SecurityEnabled();
		}
		if (editorKey == EsbViewsRepository.AddressingEndpoint.Properties.addressingEnabled) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_AddressingEnabled();
		}
		if (editorKey == EsbViewsRepository.AddressingEndpoint.Properties.addressingVersion) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_AddressingVersion();
		}
		if (editorKey == EsbViewsRepository.AddressingEndpoint.Properties.addressingSeparateListener) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_AddressingSeparateListener();
		}
		if (editorKey == EsbViewsRepository.AddressingEndpoint.Properties.timeOutDuration) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_TimeOutDuration();
		}
		if (editorKey == EsbViewsRepository.AddressingEndpoint.Properties.timeOutAction) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_TimeOutAction();
		}
		if (editorKey == EsbViewsRepository.AddressingEndpoint.Properties.retryErrorCodes) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_RetryErrorCodes();
		}
		if (editorKey == EsbViewsRepository.AddressingEndpoint.Properties.retryCount) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_RetryCount();
		}
		if (editorKey == EsbViewsRepository.AddressingEndpoint.Properties.retryDelay) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_RetryDelay();
		}
		if (editorKey == EsbViewsRepository.AddressingEndpoint.Properties.suspendErrorCodes) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendErrorCodes();
		}
		if (editorKey == EsbViewsRepository.AddressingEndpoint.Properties.suspendInitialDuration) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendInitialDuration();
		}
		if (editorKey == EsbViewsRepository.AddressingEndpoint.Properties.suspendMaximumDuration) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendMaximumDuration();
		}
		if (editorKey == EsbViewsRepository.AddressingEndpoint.Properties.suspendProgressionFactor) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendProgressionFactor();
		}
		if (editorKey == EsbViewsRepository.AddressingEndpoint.Properties.format) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_Format();
		}
		if (editorKey == EsbViewsRepository.AddressingEndpoint.Properties.optimize) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_Optimize();
		}
		if (editorKey == EsbViewsRepository.AddressingEndpoint.Properties.templateParameters) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_TemplateParameters();
		}
		if (editorKey == EsbViewsRepository.AddressingEndpoint.Properties.statisticsEnabled) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_StatisticsEnabled();
		}
		if (editorKey == EsbViewsRepository.AddressingEndpoint.Properties.traceEnabled) {
			return EsbPackage.eINSTANCE.getAbstractEndPoint_TraceEnabled();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		AddressingEndpoint addressingEndpoint = (AddressingEndpoint)semanticObject;
		if (EsbViewsRepository.AddressingEndpoint.Properties.description == event.getAffectedEditor()) {
			addressingEndpoint.setDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.AddressingEndpoint.Properties.commentsList == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				addressingEndpoint.getCommentsList().clear();
				addressingEndpoint.getCommentsList().addAll(((EList) event.getNewValue()));
			}
		}
		if (EsbViewsRepository.AddressingEndpoint.Properties.endPointName == event.getAffectedEditor()) {
			addressingEndpoint.setEndPointName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.AddressingEndpoint.Properties.anonymous == event.getAffectedEditor()) {
			addressingEndpoint.setAnonymous((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.AddressingEndpoint.Properties.inLine == event.getAffectedEditor()) {
			addressingEndpoint.setInLine((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.AddressingEndpoint.Properties.duplicate == event.getAffectedEditor()) {
			addressingEndpoint.setDuplicate((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.AddressingEndpoint.Properties.properties_ == event.getAffectedEditor()) {
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
		if (EsbViewsRepository.AddressingEndpoint.Properties.reversed == event.getAffectedEditor()) {
			addressingEndpoint.setReversed((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.AddressingEndpoint.Properties.reliableMessagingEnabled == event.getAffectedEditor()) {
			addressingEndpoint.setReliableMessagingEnabled((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.AddressingEndpoint.Properties.securityEnabled == event.getAffectedEditor()) {
			addressingEndpoint.setSecurityEnabled((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.AddressingEndpoint.Properties.addressingEnabled == event.getAffectedEditor()) {
			addressingEndpoint.setAddressingEnabled((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.AddressingEndpoint.Properties.addressingVersion == event.getAffectedEditor()) {
			addressingEndpoint.setAddressingVersion((EndPointAddressingVersion)event.getNewValue());
		}
		if (EsbViewsRepository.AddressingEndpoint.Properties.addressingSeparateListener == event.getAffectedEditor()) {
			addressingEndpoint.setAddressingSeparateListener((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.AddressingEndpoint.Properties.timeOutDuration == event.getAffectedEditor()) {
			addressingEndpoint.setTimeOutDuration((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.AddressingEndpoint.Properties.timeOutAction == event.getAffectedEditor()) {
			addressingEndpoint.setTimeOutAction((EndPointTimeOutAction)event.getNewValue());
		}
		if (EsbViewsRepository.AddressingEndpoint.Properties.retryErrorCodes == event.getAffectedEditor()) {
			addressingEndpoint.setRetryErrorCodes((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.AddressingEndpoint.Properties.retryCount == event.getAffectedEditor()) {
			addressingEndpoint.setRetryCount((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.AddressingEndpoint.Properties.retryDelay == event.getAffectedEditor()) {
			addressingEndpoint.setRetryDelay((EEFConverterUtil.createLongFromString(EcorePackage.Literals.ELONG, (String)event.getNewValue())));
		}
		if (EsbViewsRepository.AddressingEndpoint.Properties.suspendErrorCodes == event.getAffectedEditor()) {
			addressingEndpoint.setSuspendErrorCodes((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.AddressingEndpoint.Properties.suspendInitialDuration == event.getAffectedEditor()) {
			addressingEndpoint.setSuspendInitialDuration((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.AddressingEndpoint.Properties.suspendMaximumDuration == event.getAffectedEditor()) {
			addressingEndpoint.setSuspendMaximumDuration((EEFConverterUtil.createLongFromString(EcorePackage.Literals.ELONG, (String)event.getNewValue())));
		}
		if (EsbViewsRepository.AddressingEndpoint.Properties.suspendProgressionFactor == event.getAffectedEditor()) {
			addressingEndpoint.setSuspendProgressionFactor((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.AddressingEndpoint.Properties.format == event.getAffectedEditor()) {
			addressingEndpoint.setFormat((EndPointMessageFormat)event.getNewValue());
		}
		if (EsbViewsRepository.AddressingEndpoint.Properties.optimize == event.getAffectedEditor()) {
			addressingEndpoint.setOptimize((EndPointAttachmentOptimization)event.getNewValue());
		}
		if (EsbViewsRepository.AddressingEndpoint.Properties.templateParameters == event.getAffectedEditor()) {
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
		if (EsbViewsRepository.AddressingEndpoint.Properties.statisticsEnabled == event.getAffectedEditor()) {
			addressingEndpoint.setStatisticsEnabled((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.AddressingEndpoint.Properties.traceEnabled == event.getAffectedEditor()) {
			addressingEndpoint.setTraceEnabled((Boolean)event.getNewValue());
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			AddressingEndpointPropertiesEditionPart basePart = (AddressingEndpointPropertiesEditionPart)editingPart;
			if (EsbPackage.eINSTANCE.getEsbElement_Description().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.AddressingEndpoint.Properties.description)) {
				if (msg.getNewValue() != null) {
					basePart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setDescription("");
				}
			}
			if (EsbPackage.eINSTANCE.getEsbElement_CommentsList().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.AddressingEndpoint.Properties.commentsList)) {
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
			
			if (EsbPackage.eINSTANCE.getEndPoint_EndPointName().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.AddressingEndpoint.Properties.endPointName)) {
				if (msg.getNewValue() != null) {
					basePart.setEndPointName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setEndPointName("");
				}
			}
			if (EsbPackage.eINSTANCE.getEndPoint_Anonymous().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.AddressingEndpoint.Properties.anonymous))
				basePart.setAnonymous((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getEndPoint_InLine().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.AddressingEndpoint.Properties.inLine))
				basePart.setInLine((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getEndPoint_Duplicate().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.AddressingEndpoint.Properties.duplicate))
				basePart.setDuplicate((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getEndPoint_Properties().equals(msg.getFeature()) && isAccessible(EsbViewsRepository.AddressingEndpoint.Properties.properties_))
				basePart.updateProperties();
			if (EsbPackage.eINSTANCE.getEndPoint_Reversed().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.AddressingEndpoint.Properties.reversed))
				basePart.setReversed((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_ReliableMessagingEnabled().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.AddressingEndpoint.Properties.reliableMessagingEnabled))
				basePart.setReliableMessagingEnabled((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_SecurityEnabled().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.AddressingEndpoint.Properties.securityEnabled))
				basePart.setSecurityEnabled((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_AddressingEnabled().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.AddressingEndpoint.Properties.addressingEnabled))
				basePart.setAddressingEnabled((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_AddressingVersion().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.AddressingEndpoint.Properties.addressingVersion))
				basePart.setAddressingVersion((EndPointAddressingVersion)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_AddressingSeparateListener().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.AddressingEndpoint.Properties.addressingSeparateListener))
				basePart.setAddressingSeparateListener((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_TimeOutDuration().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.AddressingEndpoint.Properties.timeOutDuration)) {
				if (msg.getNewValue() != null) {
					basePart.setTimeOutDuration(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTimeOutDuration("");
				}
			}
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_TimeOutAction().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.AddressingEndpoint.Properties.timeOutAction))
				basePart.setTimeOutAction((EndPointTimeOutAction)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_RetryErrorCodes().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.AddressingEndpoint.Properties.retryErrorCodes)) {
				if (msg.getNewValue() != null) {
					basePart.setRetryErrorCodes(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setRetryErrorCodes("");
				}
			}
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_RetryCount().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.AddressingEndpoint.Properties.retryCount)) {
				if (msg.getNewValue() != null) {
					basePart.setRetryCount(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setRetryCount("");
				}
			}
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_RetryDelay().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.AddressingEndpoint.Properties.retryDelay)) {
				if (msg.getNewValue() != null) {
					basePart.setRetryDelay(EcoreUtil.convertToString(EcorePackage.Literals.ELONG, msg.getNewValue()));
				} else {
					basePart.setRetryDelay("");
				}
			}
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendErrorCodes().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.AddressingEndpoint.Properties.suspendErrorCodes)) {
				if (msg.getNewValue() != null) {
					basePart.setSuspendErrorCodes(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setSuspendErrorCodes("");
				}
			}
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendInitialDuration().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.AddressingEndpoint.Properties.suspendInitialDuration)) {
				if (msg.getNewValue() != null) {
					basePart.setSuspendInitialDuration(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setSuspendInitialDuration("");
				}
			}
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendMaximumDuration().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.AddressingEndpoint.Properties.suspendMaximumDuration)) {
				if (msg.getNewValue() != null) {
					basePart.setSuspendMaximumDuration(EcoreUtil.convertToString(EcorePackage.Literals.ELONG, msg.getNewValue()));
				} else {
					basePart.setSuspendMaximumDuration("");
				}
			}
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendProgressionFactor().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.AddressingEndpoint.Properties.suspendProgressionFactor)) {
				if (msg.getNewValue() != null) {
					basePart.setSuspendProgressionFactor(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setSuspendProgressionFactor("");
				}
			}
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_Format().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.AddressingEndpoint.Properties.format))
				basePart.setFormat((EndPointMessageFormat)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_Optimize().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.AddressingEndpoint.Properties.optimize))
				basePart.setOptimize((EndPointAttachmentOptimization)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_TemplateParameters().equals(msg.getFeature()) && isAccessible(EsbViewsRepository.AddressingEndpoint.Properties.templateParameters))
				basePart.updateTemplateParameters();
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_StatisticsEnabled().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.AddressingEndpoint.Properties.statisticsEnabled))
				basePart.setStatisticsEnabled((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAbstractEndPoint_TraceEnabled().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.AddressingEndpoint.Properties.traceEnabled))
				basePart.setTraceEnabled((Boolean)msg.getNewValue());
			
			
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
			EsbPackage.eINSTANCE.getAbstractEndPoint_TraceEnabled()		);
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
				if (EsbViewsRepository.AddressingEndpoint.Properties.description == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.AddressingEndpoint.Properties.commentsList == event.getAffectedEditor()) {
					BasicDiagnostic chain = new BasicDiagnostic();
					for (Iterator iterator = ((List)event.getNewValue()).iterator(); iterator.hasNext();) {
						chain.add(Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEAttributeType(), iterator.next()));
					}
					ret = chain;
				}
				if (EsbViewsRepository.AddressingEndpoint.Properties.endPointName == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEndPoint_EndPointName().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEndPoint_EndPointName().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.AddressingEndpoint.Properties.anonymous == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEndPoint_Anonymous().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEndPoint_Anonymous().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.AddressingEndpoint.Properties.inLine == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEndPoint_InLine().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEndPoint_InLine().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.AddressingEndpoint.Properties.duplicate == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEndPoint_Duplicate().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEndPoint_Duplicate().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.AddressingEndpoint.Properties.reversed == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEndPoint_Reversed().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEndPoint_Reversed().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.AddressingEndpoint.Properties.reliableMessagingEnabled == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_ReliableMessagingEnabled().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_ReliableMessagingEnabled().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.AddressingEndpoint.Properties.securityEnabled == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_SecurityEnabled().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_SecurityEnabled().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.AddressingEndpoint.Properties.addressingEnabled == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_AddressingEnabled().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_AddressingEnabled().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.AddressingEndpoint.Properties.addressingVersion == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_AddressingVersion().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_AddressingVersion().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.AddressingEndpoint.Properties.addressingSeparateListener == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_AddressingSeparateListener().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_AddressingSeparateListener().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.AddressingEndpoint.Properties.timeOutDuration == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_TimeOutDuration().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_TimeOutDuration().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.AddressingEndpoint.Properties.timeOutAction == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_TimeOutAction().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_TimeOutAction().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.AddressingEndpoint.Properties.retryErrorCodes == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_RetryErrorCodes().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_RetryErrorCodes().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.AddressingEndpoint.Properties.retryCount == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_RetryCount().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_RetryCount().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.AddressingEndpoint.Properties.retryDelay == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_RetryDelay().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_RetryDelay().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.AddressingEndpoint.Properties.suspendErrorCodes == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendErrorCodes().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendErrorCodes().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.AddressingEndpoint.Properties.suspendInitialDuration == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendInitialDuration().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendInitialDuration().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.AddressingEndpoint.Properties.suspendMaximumDuration == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendMaximumDuration().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendMaximumDuration().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.AddressingEndpoint.Properties.suspendProgressionFactor == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendProgressionFactor().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_SuspendProgressionFactor().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.AddressingEndpoint.Properties.format == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_Format().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_Format().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.AddressingEndpoint.Properties.optimize == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_Optimize().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_Optimize().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.AddressingEndpoint.Properties.statisticsEnabled == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_StatisticsEnabled().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_StatisticsEnabled().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.AddressingEndpoint.Properties.traceEnabled == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractEndPoint_TraceEnabled().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractEndPoint_TraceEnabled().getEAttributeType(), newValue);
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
