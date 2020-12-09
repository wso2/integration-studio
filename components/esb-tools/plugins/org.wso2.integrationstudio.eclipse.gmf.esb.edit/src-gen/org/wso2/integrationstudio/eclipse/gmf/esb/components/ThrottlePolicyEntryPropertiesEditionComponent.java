/**
 * Generated with Acceleo
 */
package org.wso2.integrationstudio.eclipse.gmf.esb.components;

// Start of user code for imports
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
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

import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;
import org.eclipse.emf.eef.runtime.impl.utils.EEFUtils;

import org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.integrationstudio.eclipse.gmf.esb.ThrottleAccessType;
import org.wso2.integrationstudio.eclipse.gmf.esb.ThrottleConditionType;
import org.wso2.integrationstudio.eclipse.gmf.esb.ThrottlePolicyEntry;

import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.ThrottlePolicyEntryPropertiesEditionPart;


// End of user code

/**
 * 
 * 
 */
public class ThrottlePolicyEntryPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	
	/**
	 * Default constructor
	 * 
	 */
	public ThrottlePolicyEntryPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject throttlePolicyEntry, String editing_mode) {
		super(editingContext, throttlePolicyEntry, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EsbViewsRepository.class;
		partKey = EsbViewsRepository.ThrottlePolicyEntry.class;
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
			
			final ThrottlePolicyEntry throttlePolicyEntry = (ThrottlePolicyEntry)elt;
			final ThrottlePolicyEntryPropertiesEditionPart basePart = (ThrottlePolicyEntryPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EsbViewsRepository.ThrottlePolicyEntry.Properties.throttleType)) {
				basePart.initThrottleType(EEFUtils.choiceOfValues(throttlePolicyEntry, EsbPackage.eINSTANCE.getThrottlePolicyEntry_ThrottleType()), throttlePolicyEntry.getThrottleType());
			}
			if (isAccessible(EsbViewsRepository.ThrottlePolicyEntry.Properties.throttleRange))
				basePart.setThrottleRange(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, throttlePolicyEntry.getThrottleRange()));
			
			if (isAccessible(EsbViewsRepository.ThrottlePolicyEntry.Properties.accessType)) {
				basePart.initAccessType(EEFUtils.choiceOfValues(throttlePolicyEntry, EsbPackage.eINSTANCE.getThrottlePolicyEntry_AccessType()), throttlePolicyEntry.getAccessType());
			}
			if (isAccessible(EsbViewsRepository.ThrottlePolicyEntry.Properties.maxRequestCount)) {
				basePart.setMaxRequestCount(EEFConverterUtil.convertToString(EcorePackage.Literals.EINT, throttlePolicyEntry.getMaxRequestCount()));
			}
			
			if (isAccessible(EsbViewsRepository.ThrottlePolicyEntry.Properties.unitTime)) {
				basePart.setUnitTime(EEFConverterUtil.convertToString(EcorePackage.Literals.EINT, throttlePolicyEntry.getUnitTime()));
			}
			
			if (isAccessible(EsbViewsRepository.ThrottlePolicyEntry.Properties.prohibitPeriod)) {
				basePart.setProhibitPeriod(EEFConverterUtil.convertToString(EcorePackage.Literals.EINT, throttlePolicyEntry.getProhibitPeriod()));
			}
			
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
		if (editorKey == EsbViewsRepository.ThrottlePolicyEntry.Properties.throttleType) {
			return EsbPackage.eINSTANCE.getThrottlePolicyEntry_ThrottleType();
		}
		if (editorKey == EsbViewsRepository.ThrottlePolicyEntry.Properties.throttleRange) {
			return EsbPackage.eINSTANCE.getThrottlePolicyEntry_ThrottleRange();
		}
		if (editorKey == EsbViewsRepository.ThrottlePolicyEntry.Properties.accessType) {
			return EsbPackage.eINSTANCE.getThrottlePolicyEntry_AccessType();
		}
		if (editorKey == EsbViewsRepository.ThrottlePolicyEntry.Properties.maxRequestCount) {
			return EsbPackage.eINSTANCE.getThrottlePolicyEntry_MaxRequestCount();
		}
		if (editorKey == EsbViewsRepository.ThrottlePolicyEntry.Properties.unitTime) {
			return EsbPackage.eINSTANCE.getThrottlePolicyEntry_UnitTime();
		}
		if (editorKey == EsbViewsRepository.ThrottlePolicyEntry.Properties.prohibitPeriod) {
			return EsbPackage.eINSTANCE.getThrottlePolicyEntry_ProhibitPeriod();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		ThrottlePolicyEntry throttlePolicyEntry = (ThrottlePolicyEntry)semanticObject;
		if (EsbViewsRepository.ThrottlePolicyEntry.Properties.throttleType == event.getAffectedEditor()) {
			throttlePolicyEntry.setThrottleType((ThrottleConditionType)event.getNewValue());
		}
		if (EsbViewsRepository.ThrottlePolicyEntry.Properties.throttleRange == event.getAffectedEditor()) {
			throttlePolicyEntry.setThrottleRange((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.ThrottlePolicyEntry.Properties.accessType == event.getAffectedEditor()) {
			throttlePolicyEntry.setAccessType((ThrottleAccessType)event.getNewValue());
		}
		if (EsbViewsRepository.ThrottlePolicyEntry.Properties.maxRequestCount == event.getAffectedEditor()) {
			throttlePolicyEntry.setMaxRequestCount((EEFConverterUtil.createIntFromString(EcorePackage.Literals.EINT, (String)event.getNewValue())));
		}
		if (EsbViewsRepository.ThrottlePolicyEntry.Properties.unitTime == event.getAffectedEditor()) {
			throttlePolicyEntry.setUnitTime((EEFConverterUtil.createIntFromString(EcorePackage.Literals.EINT, (String)event.getNewValue())));
		}
		if (EsbViewsRepository.ThrottlePolicyEntry.Properties.prohibitPeriod == event.getAffectedEditor()) {
			throttlePolicyEntry.setProhibitPeriod((EEFConverterUtil.createIntFromString(EcorePackage.Literals.EINT, (String)event.getNewValue())));
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			ThrottlePolicyEntryPropertiesEditionPart basePart = (ThrottlePolicyEntryPropertiesEditionPart)editingPart;
			if (EsbPackage.eINSTANCE.getThrottlePolicyEntry_ThrottleType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.ThrottlePolicyEntry.Properties.throttleType))
				basePart.setThrottleType((ThrottleConditionType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getThrottlePolicyEntry_ThrottleRange().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.ThrottlePolicyEntry.Properties.throttleRange)) {
				if (msg.getNewValue() != null) {
					basePart.setThrottleRange(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setThrottleRange("");
				}
			}
			if (EsbPackage.eINSTANCE.getThrottlePolicyEntry_AccessType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.ThrottlePolicyEntry.Properties.accessType))
				basePart.setAccessType((ThrottleAccessType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getThrottlePolicyEntry_MaxRequestCount().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.ThrottlePolicyEntry.Properties.maxRequestCount)) {
				if (msg.getNewValue() != null) {
					basePart.setMaxRequestCount(EcoreUtil.convertToString(EcorePackage.Literals.EINT, msg.getNewValue()));
				} else {
					basePart.setMaxRequestCount("");
				}
			}
			if (EsbPackage.eINSTANCE.getThrottlePolicyEntry_UnitTime().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.ThrottlePolicyEntry.Properties.unitTime)) {
				if (msg.getNewValue() != null) {
					basePart.setUnitTime(EcoreUtil.convertToString(EcorePackage.Literals.EINT, msg.getNewValue()));
				} else {
					basePart.setUnitTime("");
				}
			}
			if (EsbPackage.eINSTANCE.getThrottlePolicyEntry_ProhibitPeriod().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.ThrottlePolicyEntry.Properties.prohibitPeriod)) {
				if (msg.getNewValue() != null) {
					basePart.setProhibitPeriod(EcoreUtil.convertToString(EcorePackage.Literals.EINT, msg.getNewValue()));
				} else {
					basePart.setProhibitPeriod("");
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
			EsbPackage.eINSTANCE.getThrottlePolicyEntry_ThrottleType(),
			EsbPackage.eINSTANCE.getThrottlePolicyEntry_ThrottleRange(),
			EsbPackage.eINSTANCE.getThrottlePolicyEntry_AccessType(),
			EsbPackage.eINSTANCE.getThrottlePolicyEntry_MaxRequestCount(),
			EsbPackage.eINSTANCE.getThrottlePolicyEntry_UnitTime(),
			EsbPackage.eINSTANCE.getThrottlePolicyEntry_ProhibitPeriod()		);
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
				if (EsbViewsRepository.ThrottlePolicyEntry.Properties.throttleType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getThrottlePolicyEntry_ThrottleType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getThrottlePolicyEntry_ThrottleType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.ThrottlePolicyEntry.Properties.throttleRange == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getThrottlePolicyEntry_ThrottleRange().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getThrottlePolicyEntry_ThrottleRange().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.ThrottlePolicyEntry.Properties.accessType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getThrottlePolicyEntry_AccessType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getThrottlePolicyEntry_AccessType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.ThrottlePolicyEntry.Properties.maxRequestCount == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getThrottlePolicyEntry_MaxRequestCount().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getThrottlePolicyEntry_MaxRequestCount().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.ThrottlePolicyEntry.Properties.unitTime == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getThrottlePolicyEntry_UnitTime().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getThrottlePolicyEntry_UnitTime().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.ThrottlePolicyEntry.Properties.prohibitPeriod == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getThrottlePolicyEntry_ProhibitPeriod().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getThrottlePolicyEntry_ProhibitPeriod().getEAttributeType(), newValue);
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
