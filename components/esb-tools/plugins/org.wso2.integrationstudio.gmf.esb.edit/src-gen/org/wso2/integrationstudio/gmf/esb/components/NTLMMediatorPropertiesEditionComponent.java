/**
 * Generated with Acceleo
 */
package org.wso2.integrationstudio.gmf.esb.components;

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

import org.wso2.integrationstudio.gmf.esb.EsbPackage;
import org.wso2.integrationstudio.gmf.esb.NTLMMediator;

import org.wso2.integrationstudio.gmf.esb.parts.EsbViewsRepository;
import org.wso2.integrationstudio.gmf.esb.parts.NTLMMediatorPropertiesEditionPart;


// End of user code

/**
 * 
 * 
 */
public class NTLMMediatorPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	
	/**
	 * Default constructor
	 * 
	 */
	public NTLMMediatorPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject nTLMMediator, String editing_mode) {
		super(editingContext, nTLMMediator, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EsbViewsRepository.class;
		partKey = EsbViewsRepository.NTLMMediator.class;
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
			
			final NTLMMediator nTLMMediator = (NTLMMediator)elt;
			final NTLMMediatorPropertiesEditionPart basePart = (NTLMMediatorPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EsbViewsRepository.NTLMMediator.Properties.description))
				basePart.setDescription(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, nTLMMediator.getDescription()));
			
			if (isAccessible(EsbViewsRepository.NTLMMediator.Properties.username))
				basePart.setUsername(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, nTLMMediator.getUsername()));
			
			if (isAccessible(EsbViewsRepository.NTLMMediator.Properties.password))
				basePart.setPassword(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, nTLMMediator.getPassword()));
			
			if (isAccessible(EsbViewsRepository.NTLMMediator.Properties.host))
				basePart.setHost(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, nTLMMediator.getHost()));
			
			if (isAccessible(EsbViewsRepository.NTLMMediator.Properties.domain))
				basePart.setDomain(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, nTLMMediator.getDomain()));
			
			if (isAccessible(EsbViewsRepository.NTLMMediator.Properties.ntlmVersion))
				basePart.setNtlmVersion(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, nTLMMediator.getNtlmVersion()));
			
			// init filters
			
			
			
			
			
			
			
			
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
		if (editorKey == EsbViewsRepository.NTLMMediator.Properties.description) {
			return EsbPackage.eINSTANCE.getEsbElement_Description();
		}
		if (editorKey == EsbViewsRepository.NTLMMediator.Properties.commentsList) {
			return EsbPackage.eINSTANCE.getEsbElement_CommentsList();
		}
		if (editorKey == EsbViewsRepository.NTLMMediator.Properties.reverse) {
			return EsbPackage.eINSTANCE.getMediator_Reverse();
		}
		if (editorKey == EsbViewsRepository.NTLMMediator.Properties.username) {
			return EsbPackage.eINSTANCE.getNTLMMediator_Username();
		}
		if (editorKey == EsbViewsRepository.NTLMMediator.Properties.password) {
			return EsbPackage.eINSTANCE.getNTLMMediator_Password();
		}
		if (editorKey == EsbViewsRepository.NTLMMediator.Properties.host) {
			return EsbPackage.eINSTANCE.getNTLMMediator_Host();
		}
		if (editorKey == EsbViewsRepository.NTLMMediator.Properties.domain) {
			return EsbPackage.eINSTANCE.getNTLMMediator_Domain();
		}
		if (editorKey == EsbViewsRepository.NTLMMediator.Properties.ntlmVersion) {
			return EsbPackage.eINSTANCE.getNTLMMediator_NtlmVersion();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		NTLMMediator nTLMMediator = (NTLMMediator)semanticObject;
		if (EsbViewsRepository.NTLMMediator.Properties.description == event.getAffectedEditor()) {
			nTLMMediator.setDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.NTLMMediator.Properties.commentsList == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				nTLMMediator.getCommentsList().clear();
				nTLMMediator.getCommentsList().addAll(((EList) event.getNewValue()));
			}
		}
		if (EsbViewsRepository.NTLMMediator.Properties.reverse == event.getAffectedEditor()) {
			nTLMMediator.setReverse((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.NTLMMediator.Properties.username == event.getAffectedEditor()) {
			nTLMMediator.setUsername((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.NTLMMediator.Properties.password == event.getAffectedEditor()) {
			nTLMMediator.setPassword((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.NTLMMediator.Properties.host == event.getAffectedEditor()) {
			nTLMMediator.setHost((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.NTLMMediator.Properties.domain == event.getAffectedEditor()) {
			nTLMMediator.setDomain((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.NTLMMediator.Properties.ntlmVersion == event.getAffectedEditor()) {
			nTLMMediator.setNtlmVersion((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			NTLMMediatorPropertiesEditionPart basePart = (NTLMMediatorPropertiesEditionPart)editingPart;
			if (EsbPackage.eINSTANCE.getEsbElement_Description().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.NTLMMediator.Properties.description)) {
				if (msg.getNewValue() != null) {
					basePart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setDescription("");
				}
			}
			
			
			if (EsbPackage.eINSTANCE.getNTLMMediator_Username().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.NTLMMediator.Properties.username)) {
				if (msg.getNewValue() != null) {
					basePart.setUsername(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setUsername("");
				}
			}
			if (EsbPackage.eINSTANCE.getNTLMMediator_Password().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.NTLMMediator.Properties.password)) {
				if (msg.getNewValue() != null) {
					basePart.setPassword(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setPassword("");
				}
			}
			if (EsbPackage.eINSTANCE.getNTLMMediator_Host().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.NTLMMediator.Properties.host)) {
				if (msg.getNewValue() != null) {
					basePart.setHost(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setHost("");
				}
			}
			if (EsbPackage.eINSTANCE.getNTLMMediator_Domain().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.NTLMMediator.Properties.domain)) {
				if (msg.getNewValue() != null) {
					basePart.setDomain(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setDomain("");
				}
			}
			if (EsbPackage.eINSTANCE.getNTLMMediator_NtlmVersion().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.NTLMMediator.Properties.ntlmVersion)) {
				if (msg.getNewValue() != null) {
					basePart.setNtlmVersion(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setNtlmVersion("");
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
			EsbPackage.eINSTANCE.getMediator_Reverse(),
			EsbPackage.eINSTANCE.getNTLMMediator_Username(),
			EsbPackage.eINSTANCE.getNTLMMediator_Password(),
			EsbPackage.eINSTANCE.getNTLMMediator_Host(),
			EsbPackage.eINSTANCE.getNTLMMediator_Domain(),
			EsbPackage.eINSTANCE.getNTLMMediator_NtlmVersion()		);
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
				if (EsbViewsRepository.NTLMMediator.Properties.description == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.NTLMMediator.Properties.commentsList == event.getAffectedEditor()) {
					BasicDiagnostic chain = new BasicDiagnostic();
					for (Iterator iterator = ((List)event.getNewValue()).iterator(); iterator.hasNext();) {
						chain.add(Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEAttributeType(), iterator.next()));
					}
					ret = chain;
				}
				if (EsbViewsRepository.NTLMMediator.Properties.reverse == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMediator_Reverse().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMediator_Reverse().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.NTLMMediator.Properties.username == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getNTLMMediator_Username().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getNTLMMediator_Username().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.NTLMMediator.Properties.password == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getNTLMMediator_Password().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getNTLMMediator_Password().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.NTLMMediator.Properties.host == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getNTLMMediator_Host().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getNTLMMediator_Host().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.NTLMMediator.Properties.domain == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getNTLMMediator_Domain().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getNTLMMediator_Domain().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.NTLMMediator.Properties.ntlmVersion == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getNTLMMediator_NtlmVersion().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getNTLMMediator_NtlmVersion().getEAttributeType(), newValue);
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
