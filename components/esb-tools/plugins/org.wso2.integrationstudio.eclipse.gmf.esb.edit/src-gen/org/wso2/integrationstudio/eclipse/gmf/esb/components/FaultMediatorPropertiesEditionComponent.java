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

import org.eclipse.emf.eef.runtime.impl.components.SinglePartPropertiesEditingComponent;

import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;
import org.eclipse.emf.eef.runtime.impl.utils.EEFUtils;

import org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.integrationstudio.eclipse.gmf.esb.FaultCodeSoap11;
import org.wso2.integrationstudio.eclipse.gmf.esb.FaultCodeSoap12;
import org.wso2.integrationstudio.eclipse.gmf.esb.FaultCodeType;
import org.wso2.integrationstudio.eclipse.gmf.esb.FaultDetailType;
import org.wso2.integrationstudio.eclipse.gmf.esb.FaultMediator;
import org.wso2.integrationstudio.eclipse.gmf.esb.FaultReasonType;
import org.wso2.integrationstudio.eclipse.gmf.esb.FaultSoapVersion;
import org.wso2.integrationstudio.eclipse.gmf.esb.FaultStringType;
import org.wso2.integrationstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.FaultMediatorPropertiesEditionPart;
import org.wso2.integrationstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;


// End of user code

/**
 * 
 * 
 */
public class FaultMediatorPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	
	/**
	 * Default constructor
	 * 
	 */
	public FaultMediatorPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject faultMediator, String editing_mode) {
		super(editingContext, faultMediator, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EsbViewsRepository.class;
		partKey = EsbViewsRepository.FaultMediator.class;
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
			
			final FaultMediator faultMediator = (FaultMediator)elt;
			final FaultMediatorPropertiesEditionPart basePart = (FaultMediatorPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EsbViewsRepository.FaultMediator.Properties.description))
				basePart.setDescription(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, faultMediator.getDescription()));
			
			if (isAccessible(EsbViewsRepository.FaultMediator.Properties.commentsList))
				basePart.setCommentsList(faultMediator.getCommentsList());
			
			if (isAccessible(EsbViewsRepository.FaultMediator.Properties.reverse)) {
				basePart.setReverse(faultMediator.isReverse());
			}
			if (isAccessible(EsbViewsRepository.FaultMediator.Properties.soapVersion)) {
				basePart.initSoapVersion(EEFUtils.choiceOfValues(faultMediator, EsbPackage.eINSTANCE.getFaultMediator_SoapVersion()), faultMediator.getSoapVersion());
			}
			if (isAccessible(EsbViewsRepository.FaultMediator.Properties.serializeResponse)) {
				basePart.setSerializeResponse(faultMediator.isSerializeResponse());
			}
			if (isAccessible(EsbViewsRepository.FaultMediator.Properties.markAsResponse)) {
				basePart.setMarkAsResponse(faultMediator.isMarkAsResponse());
			}
			if (isAccessible(EsbViewsRepository.FaultMediator.Properties.faultCodeSoap11)) {
				basePart.initFaultCodeSoap11(EEFUtils.choiceOfValues(faultMediator, EsbPackage.eINSTANCE.getFaultMediator_FaultCodeSoap11()), faultMediator.getFaultCodeSoap11());
			}
			if (isAccessible(EsbViewsRepository.FaultMediator.Properties.faultCodeType)) {
				basePart.initFaultCodeType(EEFUtils.choiceOfValues(faultMediator, EsbPackage.eINSTANCE.getFaultMediator_FaultCodeType()), faultMediator.getFaultCodeType());
			}
			if (isAccessible(EsbViewsRepository.FaultMediator.Properties.faultStringType)) {
				basePart.initFaultStringType(EEFUtils.choiceOfValues(faultMediator, EsbPackage.eINSTANCE.getFaultMediator_FaultStringType()), faultMediator.getFaultStringType());
			}
			if (isAccessible(EsbViewsRepository.FaultMediator.Properties.faultStringValue))
				basePart.setFaultStringValue(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, faultMediator.getFaultStringValue()));
			
			if (isAccessible(EsbViewsRepository.FaultMediator.Properties.faultActor))
				basePart.setFaultActor(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, faultMediator.getFaultActor()));
			
			if (isAccessible(EsbViewsRepository.FaultMediator.Properties.faultCodeSoap12)) {
				basePart.initFaultCodeSoap12(EEFUtils.choiceOfValues(faultMediator, EsbPackage.eINSTANCE.getFaultMediator_FaultCodeSoap12()), faultMediator.getFaultCodeSoap12());
			}
			if (isAccessible(EsbViewsRepository.FaultMediator.Properties.faultReasonType)) {
				basePart.initFaultReasonType(EEFUtils.choiceOfValues(faultMediator, EsbPackage.eINSTANCE.getFaultMediator_FaultReasonType()), faultMediator.getFaultReasonType());
			}
			if (isAccessible(EsbViewsRepository.FaultMediator.Properties.faultReasonValue))
				basePart.setFaultReasonValue(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, faultMediator.getFaultReasonValue()));
			
			if (isAccessible(EsbViewsRepository.FaultMediator.Properties.roleName))
				basePart.setRoleName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, faultMediator.getRoleName()));
			
			if (isAccessible(EsbViewsRepository.FaultMediator.Properties.nodeName))
				basePart.setNodeName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, faultMediator.getNodeName()));
			
			if (isAccessible(EsbViewsRepository.FaultMediator.Properties.faultDetailType)) {
				basePart.initFaultDetailType(EEFUtils.choiceOfValues(faultMediator, EsbPackage.eINSTANCE.getFaultMediator_FaultDetailType()), faultMediator.getFaultDetailType());
			}
			if (isAccessible(EsbViewsRepository.FaultMediator.Properties.faultDetailValue))
				basePart.setFaultDetailValue(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, faultMediator.getFaultDetailValue()));
			
			// Start of user code  for faultDetailExpression command update
            if (isAccessible(EsbViewsRepository.FaultMediator.Properties.faultDetailExpression)) {
                basePart.setFaultDetailExpression(faultMediator.getFaultDetailExpression());
            }
			// End of user code
			
			// Start of user code  for faultReasonExpression command update
            if (isAccessible(EsbViewsRepository.FaultMediator.Properties.faultReasonExpression)) {
                basePart.setFaultReasonExpression(faultMediator.getFaultReasonExpression());
            }
            // End of user code
			
			// Start of user code  for faultCodeExpression command update
            if (isAccessible(EsbViewsRepository.FaultMediator.Properties.faultCodeExpression)) {
                basePart.setFaultCodeExpression(faultMediator.getFaultCodeExpression());
            }
			// End of user code
			
			// Start of user code  for faultStringExpression command update
            if (isAccessible(EsbViewsRepository.FaultMediator.Properties.faultStringExpression)) {
                basePart.setFaultStringExpression(faultMediator.getFaultStringExpression());
            }
            // End of user code
			
			// init filters
	
			// Start of user code  for faultDetailExpression filter update
			// End of user code
			
			// Start of user code  for faultReasonExpression filter update
			// End of user code
			
			// Start of user code  for faultCodeExpression filter update
			// End of user code
			
			// Start of user code  for faultStringExpression filter update
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
		if (editorKey == EsbViewsRepository.FaultMediator.Properties.description) {
			return EsbPackage.eINSTANCE.getEsbElement_Description();
		}
		if (editorKey == EsbViewsRepository.FaultMediator.Properties.commentsList) {
			return EsbPackage.eINSTANCE.getEsbElement_CommentsList();
		}
		if (editorKey == EsbViewsRepository.FaultMediator.Properties.reverse) {
			return EsbPackage.eINSTANCE.getMediator_Reverse();
		}
		if (editorKey == EsbViewsRepository.FaultMediator.Properties.soapVersion) {
			return EsbPackage.eINSTANCE.getFaultMediator_SoapVersion();
		}
		if (editorKey == EsbViewsRepository.FaultMediator.Properties.serializeResponse) {
			return EsbPackage.eINSTANCE.getFaultMediator_SerializeResponse();
		}
		if (editorKey == EsbViewsRepository.FaultMediator.Properties.markAsResponse) {
			return EsbPackage.eINSTANCE.getFaultMediator_MarkAsResponse();
		}
		if (editorKey == EsbViewsRepository.FaultMediator.Properties.faultCodeSoap11) {
			return EsbPackage.eINSTANCE.getFaultMediator_FaultCodeSoap11();
		}
		if (editorKey == EsbViewsRepository.FaultMediator.Properties.faultCodeType) {
			return EsbPackage.eINSTANCE.getFaultMediator_FaultCodeType();
		}
		if (editorKey == EsbViewsRepository.FaultMediator.Properties.faultStringType) {
			return EsbPackage.eINSTANCE.getFaultMediator_FaultStringType();
		}
		if (editorKey == EsbViewsRepository.FaultMediator.Properties.faultStringValue) {
			return EsbPackage.eINSTANCE.getFaultMediator_FaultStringValue();
		}
		if (editorKey == EsbViewsRepository.FaultMediator.Properties.faultActor) {
			return EsbPackage.eINSTANCE.getFaultMediator_FaultActor();
		}
		if (editorKey == EsbViewsRepository.FaultMediator.Properties.faultCodeSoap12) {
			return EsbPackage.eINSTANCE.getFaultMediator_FaultCodeSoap12();
		}
		if (editorKey == EsbViewsRepository.FaultMediator.Properties.faultReasonType) {
			return EsbPackage.eINSTANCE.getFaultMediator_FaultReasonType();
		}
		if (editorKey == EsbViewsRepository.FaultMediator.Properties.faultReasonValue) {
			return EsbPackage.eINSTANCE.getFaultMediator_FaultReasonValue();
		}
		if (editorKey == EsbViewsRepository.FaultMediator.Properties.roleName) {
			return EsbPackage.eINSTANCE.getFaultMediator_RoleName();
		}
		if (editorKey == EsbViewsRepository.FaultMediator.Properties.nodeName) {
			return EsbPackage.eINSTANCE.getFaultMediator_NodeName();
		}
		if (editorKey == EsbViewsRepository.FaultMediator.Properties.faultDetailType) {
			return EsbPackage.eINSTANCE.getFaultMediator_FaultDetailType();
		}
		if (editorKey == EsbViewsRepository.FaultMediator.Properties.faultDetailValue) {
			return EsbPackage.eINSTANCE.getFaultMediator_FaultDetailValue();
		}
		if (editorKey == EsbViewsRepository.FaultMediator.Properties.faultDetailExpression) {
			return EsbPackage.eINSTANCE.getFaultMediator_FaultDetailExpression();
		}
		if (editorKey == EsbViewsRepository.FaultMediator.Properties.faultReasonExpression) {
			return EsbPackage.eINSTANCE.getFaultMediator_FaultReasonExpression();
		}
		if (editorKey == EsbViewsRepository.FaultMediator.Properties.faultCodeExpression) {
			return EsbPackage.eINSTANCE.getFaultMediator_FaultCodeExpression();
		}
		if (editorKey == EsbViewsRepository.FaultMediator.Properties.faultStringExpression) {
			return EsbPackage.eINSTANCE.getFaultMediator_FaultStringExpression();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		FaultMediator faultMediator = (FaultMediator)semanticObject;
		if (EsbViewsRepository.FaultMediator.Properties.description == event.getAffectedEditor()) {
			faultMediator.setDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.FaultMediator.Properties.commentsList == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				faultMediator.getCommentsList().clear();
				faultMediator.getCommentsList().addAll(((EList) event.getNewValue()));
			}
		}
		if (EsbViewsRepository.FaultMediator.Properties.reverse == event.getAffectedEditor()) {
			faultMediator.setReverse((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.FaultMediator.Properties.soapVersion == event.getAffectedEditor()) {
			faultMediator.setSoapVersion((FaultSoapVersion)event.getNewValue());
		}
		if (EsbViewsRepository.FaultMediator.Properties.serializeResponse == event.getAffectedEditor()) {
			faultMediator.setSerializeResponse((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.FaultMediator.Properties.markAsResponse == event.getAffectedEditor()) {
			faultMediator.setMarkAsResponse((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.FaultMediator.Properties.faultCodeSoap11 == event.getAffectedEditor()) {
			faultMediator.setFaultCodeSoap11((FaultCodeSoap11)event.getNewValue());
		}
		if (EsbViewsRepository.FaultMediator.Properties.faultCodeType == event.getAffectedEditor()) {
			faultMediator.setFaultCodeType((FaultCodeType)event.getNewValue());
		}
		if (EsbViewsRepository.FaultMediator.Properties.faultStringType == event.getAffectedEditor()) {
			faultMediator.setFaultStringType((FaultStringType)event.getNewValue());
		}
		if (EsbViewsRepository.FaultMediator.Properties.faultStringValue == event.getAffectedEditor()) {
			faultMediator.setFaultStringValue((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.FaultMediator.Properties.faultActor == event.getAffectedEditor()) {
			faultMediator.setFaultActor((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.FaultMediator.Properties.faultCodeSoap12 == event.getAffectedEditor()) {
			faultMediator.setFaultCodeSoap12((FaultCodeSoap12)event.getNewValue());
		}
		if (EsbViewsRepository.FaultMediator.Properties.faultReasonType == event.getAffectedEditor()) {
			faultMediator.setFaultReasonType((FaultReasonType)event.getNewValue());
		}
		if (EsbViewsRepository.FaultMediator.Properties.faultReasonValue == event.getAffectedEditor()) {
			faultMediator.setFaultReasonValue((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.FaultMediator.Properties.roleName == event.getAffectedEditor()) {
			faultMediator.setRoleName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.FaultMediator.Properties.nodeName == event.getAffectedEditor()) {
			faultMediator.setNodeName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.FaultMediator.Properties.faultDetailType == event.getAffectedEditor()) {
			faultMediator.setFaultDetailType((FaultDetailType)event.getNewValue());
		}
		if (EsbViewsRepository.FaultMediator.Properties.faultDetailValue == event.getAffectedEditor()) {
			faultMediator.setFaultDetailValue((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.FaultMediator.Properties.faultDetailExpression == event.getAffectedEditor()) {
			// Start of user code for updateFaultDetailExpression method body
		    if (event.getNewValue() != null) {
                NamespacedProperty nsp = (NamespacedProperty) event.getNewValue();
                faultMediator.setFaultDetailExpression(nsp);
            } else {
                faultMediator.setFaultDetailExpression(EsbFactoryImpl.eINSTANCE.createNamespacedProperty());
            }
			// End of user code
			
		}
		if (EsbViewsRepository.FaultMediator.Properties.faultReasonExpression == event.getAffectedEditor()) {
			// Start of user code for updateFaultReasonExpression method body
		    if (event.getNewValue() != null) {
                NamespacedProperty nsp = (NamespacedProperty) event.getNewValue();
                faultMediator.setFaultReasonExpression(nsp);
            } else {
                faultMediator.setFaultReasonExpression(EsbFactoryImpl.eINSTANCE.createNamespacedProperty());
            }
			// End of user code
			
		}
		if (EsbViewsRepository.FaultMediator.Properties.faultCodeExpression == event.getAffectedEditor()) {
			// Start of user code for updateFaultCodeExpression method body
		    if (event.getNewValue() != null) {
                NamespacedProperty nsp = (NamespacedProperty) event.getNewValue();
                faultMediator.setFaultCodeExpression(nsp);
            } else {
                faultMediator.setFaultCodeExpression(EsbFactoryImpl.eINSTANCE.createNamespacedProperty());
            }
			// End of user code
			
		}
		if (EsbViewsRepository.FaultMediator.Properties.faultStringExpression == event.getAffectedEditor()) {
			// Start of user code for updateFaultStringExpression method body
		    if (event.getNewValue() != null) {
                NamespacedProperty nsp = (NamespacedProperty) event.getNewValue();
                faultMediator.setFaultStringExpression(nsp);
            } else {
                faultMediator.setFaultStringExpression(EsbFactoryImpl.eINSTANCE.createNamespacedProperty());
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
			FaultMediatorPropertiesEditionPart basePart = (FaultMediatorPropertiesEditionPart)editingPart;
			if (EsbPackage.eINSTANCE.getEsbElement_Description().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.FaultMediator.Properties.description)) {
				if (msg.getNewValue() != null) {
					basePart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setDescription("");
				}
			}
			if (EsbPackage.eINSTANCE.getEsbElement_CommentsList().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.FaultMediator.Properties.commentsList)) {
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
			
			if (EsbPackage.eINSTANCE.getMediator_Reverse().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.FaultMediator.Properties.reverse))
				basePart.setReverse((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getFaultMediator_SoapVersion().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.FaultMediator.Properties.soapVersion))
				basePart.setSoapVersion((FaultSoapVersion)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getFaultMediator_SerializeResponse().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.FaultMediator.Properties.serializeResponse))
				basePart.setSerializeResponse((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getFaultMediator_MarkAsResponse().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.FaultMediator.Properties.markAsResponse))
				basePart.setMarkAsResponse((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getFaultMediator_FaultCodeSoap11().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.FaultMediator.Properties.faultCodeSoap11))
				basePart.setFaultCodeSoap11((FaultCodeSoap11)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getFaultMediator_FaultCodeType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.FaultMediator.Properties.faultCodeType))
				basePart.setFaultCodeType((FaultCodeType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getFaultMediator_FaultStringType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.FaultMediator.Properties.faultStringType))
				basePart.setFaultStringType((FaultStringType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getFaultMediator_FaultStringValue().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.FaultMediator.Properties.faultStringValue)) {
				if (msg.getNewValue() != null) {
					basePart.setFaultStringValue(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setFaultStringValue("");
				}
			}
			if (EsbPackage.eINSTANCE.getFaultMediator_FaultActor().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.FaultMediator.Properties.faultActor)) {
				if (msg.getNewValue() != null) {
					basePart.setFaultActor(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setFaultActor("");
				}
			}
			if (EsbPackage.eINSTANCE.getFaultMediator_FaultCodeSoap12().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.FaultMediator.Properties.faultCodeSoap12))
				basePart.setFaultCodeSoap12((FaultCodeSoap12)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getFaultMediator_FaultReasonType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.FaultMediator.Properties.faultReasonType))
				basePart.setFaultReasonType((FaultReasonType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getFaultMediator_FaultReasonValue().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.FaultMediator.Properties.faultReasonValue)) {
				if (msg.getNewValue() != null) {
					basePart.setFaultReasonValue(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setFaultReasonValue("");
				}
			}
			if (EsbPackage.eINSTANCE.getFaultMediator_RoleName().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.FaultMediator.Properties.roleName)) {
				if (msg.getNewValue() != null) {
					basePart.setRoleName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setRoleName("");
				}
			}
			if (EsbPackage.eINSTANCE.getFaultMediator_NodeName().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.FaultMediator.Properties.nodeName)) {
				if (msg.getNewValue() != null) {
					basePart.setNodeName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setNodeName("");
				}
			}
			if (EsbPackage.eINSTANCE.getFaultMediator_FaultDetailType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.FaultMediator.Properties.faultDetailType))
				basePart.setFaultDetailType((FaultDetailType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getFaultMediator_FaultDetailValue().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.FaultMediator.Properties.faultDetailValue)) {
				if (msg.getNewValue() != null) {
					basePart.setFaultDetailValue(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setFaultDetailValue("");
				}
			}
					// Start of user code for faultDetailExpression live update
            if (EsbPackage.eINSTANCE.getFaultMediator_FaultDetailExpression().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject) && basePart != null
                    && isAccessible(EsbViewsRepository.FaultMediator.Properties.faultDetailExpression)) {
                if (msg.getNewValue() != null) {
                    basePart.setFaultDetailExpression((NamespacedProperty) msg.getNewValue());
                } else {
                    basePart.setFaultDetailExpression(EsbFactoryImpl.eINSTANCE.createNamespacedProperty());
                }
            }
            // End of user code
			
					// Start of user code for faultReasonExpression live update
            if (EsbPackage.eINSTANCE.getFaultMediator_FaultReasonExpression().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject) && basePart != null
                    && isAccessible(EsbViewsRepository.FaultMediator.Properties.faultReasonExpression)) {
                if (msg.getNewValue() != null) {
                    basePart.setFaultReasonExpression((NamespacedProperty) msg.getNewValue());
                } else {
                    basePart.setFaultReasonExpression(EsbFactoryImpl.eINSTANCE.createNamespacedProperty());
                }
            }
            // End of user code
			
					// Start of user code for faultCodeExpression live update
            if (EsbPackage.eINSTANCE.getFaultMediator_FaultCodeExpression().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject) && basePart != null
                    && isAccessible(EsbViewsRepository.FaultMediator.Properties.faultCodeExpression)) {
                if (msg.getNewValue() != null) {
                    basePart.setFaultCodeExpression((NamespacedProperty) msg.getNewValue());
                } else {
                    basePart.setFaultCodeExpression(EsbFactoryImpl.eINSTANCE.createNamespacedProperty());
                }
            }
					// End of user code
			
					// Start of user code for faultStringExpression live update
            if (EsbPackage.eINSTANCE.getFaultMediator_FaultStringExpression().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject) && basePart != null
                    && isAccessible(EsbViewsRepository.FaultMediator.Properties.faultStringExpression)) {
                if (msg.getNewValue() != null) {
                    basePart.setFaultStringExpression((NamespacedProperty) msg.getNewValue());
                } else {
                    basePart.setFaultStringExpression(EsbFactoryImpl.eINSTANCE.createNamespacedProperty());
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
			EsbPackage.eINSTANCE.getMediator_Reverse(),
			EsbPackage.eINSTANCE.getFaultMediator_SoapVersion(),
			EsbPackage.eINSTANCE.getFaultMediator_SerializeResponse(),
			EsbPackage.eINSTANCE.getFaultMediator_MarkAsResponse(),
			EsbPackage.eINSTANCE.getFaultMediator_FaultCodeSoap11(),
			EsbPackage.eINSTANCE.getFaultMediator_FaultCodeType(),
			EsbPackage.eINSTANCE.getFaultMediator_FaultStringType(),
			EsbPackage.eINSTANCE.getFaultMediator_FaultStringValue(),
			EsbPackage.eINSTANCE.getFaultMediator_FaultActor(),
			EsbPackage.eINSTANCE.getFaultMediator_FaultCodeSoap12(),
			EsbPackage.eINSTANCE.getFaultMediator_FaultReasonType(),
			EsbPackage.eINSTANCE.getFaultMediator_FaultReasonValue(),
			EsbPackage.eINSTANCE.getFaultMediator_RoleName(),
			EsbPackage.eINSTANCE.getFaultMediator_NodeName(),
			EsbPackage.eINSTANCE.getFaultMediator_FaultDetailType(),
			EsbPackage.eINSTANCE.getFaultMediator_FaultDetailValue(),
			EsbPackage.eINSTANCE.getFaultMediator_FaultDetailExpression(),
			EsbPackage.eINSTANCE.getFaultMediator_FaultReasonExpression(),
			EsbPackage.eINSTANCE.getFaultMediator_FaultCodeExpression(),
			EsbPackage.eINSTANCE.getFaultMediator_FaultStringExpression()		);
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
				if (EsbViewsRepository.FaultMediator.Properties.description == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.FaultMediator.Properties.commentsList == event.getAffectedEditor()) {
					BasicDiagnostic chain = new BasicDiagnostic();
					for (Iterator iterator = ((List)event.getNewValue()).iterator(); iterator.hasNext();) {
						chain.add(Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEAttributeType(), iterator.next()));
					}
					ret = chain;
				}
				if (EsbViewsRepository.FaultMediator.Properties.reverse == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMediator_Reverse().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMediator_Reverse().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.FaultMediator.Properties.soapVersion == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getFaultMediator_SoapVersion().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getFaultMediator_SoapVersion().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.FaultMediator.Properties.serializeResponse == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getFaultMediator_SerializeResponse().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getFaultMediator_SerializeResponse().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.FaultMediator.Properties.markAsResponse == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getFaultMediator_MarkAsResponse().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getFaultMediator_MarkAsResponse().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.FaultMediator.Properties.faultCodeSoap11 == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getFaultMediator_FaultCodeSoap11().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getFaultMediator_FaultCodeSoap11().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.FaultMediator.Properties.faultCodeType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getFaultMediator_FaultCodeType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getFaultMediator_FaultCodeType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.FaultMediator.Properties.faultStringType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getFaultMediator_FaultStringType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getFaultMediator_FaultStringType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.FaultMediator.Properties.faultStringValue == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getFaultMediator_FaultStringValue().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getFaultMediator_FaultStringValue().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.FaultMediator.Properties.faultActor == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getFaultMediator_FaultActor().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getFaultMediator_FaultActor().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.FaultMediator.Properties.faultCodeSoap12 == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getFaultMediator_FaultCodeSoap12().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getFaultMediator_FaultCodeSoap12().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.FaultMediator.Properties.faultReasonType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getFaultMediator_FaultReasonType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getFaultMediator_FaultReasonType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.FaultMediator.Properties.faultReasonValue == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getFaultMediator_FaultReasonValue().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getFaultMediator_FaultReasonValue().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.FaultMediator.Properties.roleName == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getFaultMediator_RoleName().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getFaultMediator_RoleName().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.FaultMediator.Properties.nodeName == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getFaultMediator_NodeName().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getFaultMediator_NodeName().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.FaultMediator.Properties.faultDetailType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getFaultMediator_FaultDetailType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getFaultMediator_FaultDetailType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.FaultMediator.Properties.faultDetailValue == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getFaultMediator_FaultDetailValue().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getFaultMediator_FaultDetailValue().getEAttributeType(), newValue);
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
