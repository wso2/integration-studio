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

import org.eclipse.emf.eef.runtime.impl.components.SinglePartPropertiesEditingComponent;

import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;
import org.eclipse.emf.eef.runtime.impl.utils.EEFUtils;

import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.LocalEntry;
import org.wso2.developerstudio.eclipse.gmf.esb.LocalEntryValueType;

import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.LocalEntryPropertiesEditionPart;


// End of user code

/**
 * 
 * 
 */
public class LocalEntryPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	
	/**
	 * Default constructor
	 * 
	 */
	public LocalEntryPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject localEntry, String editing_mode) {
		super(editingContext, localEntry, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EsbViewsRepository.class;
		partKey = EsbViewsRepository.LocalEntry.class;
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
			
			final LocalEntry localEntry = (LocalEntry)elt;
			final LocalEntryPropertiesEditionPart basePart = (LocalEntryPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EsbViewsRepository.LocalEntry.Properties.description))
				basePart.setDescription(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, localEntry.getDescription()));
			
			if (isAccessible(EsbViewsRepository.LocalEntry.Properties.commentsList))
				basePart.setCommentsList(localEntry.getCommentsList());
			
			if (isAccessible(EsbViewsRepository.LocalEntry.Properties.entryName))
				basePart.setEntryName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, localEntry.getEntryName()));
			
			if (isAccessible(EsbViewsRepository.LocalEntry.Properties.localEntryType)) {
				basePart.initLocalEntryType(EEFUtils.choiceOfValues(localEntry, EsbPackage.eINSTANCE.getLocalEntry_LocalEntryType()), localEntry.getLocalEntryType());
			}
			if (isAccessible(EsbViewsRepository.LocalEntry.Properties.valueLiteral))
				basePart.setValueLiteral(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, localEntry.getValueLiteral()));
			
			if (isAccessible(EsbViewsRepository.LocalEntry.Properties.valueXML))
				basePart.setValueXML(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, localEntry.getValueXML()));
			
			if (isAccessible(EsbViewsRepository.LocalEntry.Properties.valueURL))
				basePart.setValueURL(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, localEntry.getValueURL()));
			
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
		if (editorKey == EsbViewsRepository.LocalEntry.Properties.description) {
			return EsbPackage.eINSTANCE.getEsbElement_Description();
		}
		if (editorKey == EsbViewsRepository.LocalEntry.Properties.commentsList) {
			return EsbPackage.eINSTANCE.getEsbElement_CommentsList();
		}
		if (editorKey == EsbViewsRepository.LocalEntry.Properties.entryName) {
			return EsbPackage.eINSTANCE.getLocalEntry_EntryName();
		}
		if (editorKey == EsbViewsRepository.LocalEntry.Properties.localEntryType) {
			return EsbPackage.eINSTANCE.getLocalEntry_LocalEntryType();
		}
		if (editorKey == EsbViewsRepository.LocalEntry.Properties.valueLiteral) {
			return EsbPackage.eINSTANCE.getLocalEntry_ValueLiteral();
		}
		if (editorKey == EsbViewsRepository.LocalEntry.Properties.valueXML) {
			return EsbPackage.eINSTANCE.getLocalEntry_ValueXML();
		}
		if (editorKey == EsbViewsRepository.LocalEntry.Properties.valueURL) {
			return EsbPackage.eINSTANCE.getLocalEntry_ValueURL();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		LocalEntry localEntry = (LocalEntry)semanticObject;
		if (EsbViewsRepository.LocalEntry.Properties.description == event.getAffectedEditor()) {
			localEntry.setDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.LocalEntry.Properties.commentsList == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				localEntry.getCommentsList().clear();
				localEntry.getCommentsList().addAll(((EList) event.getNewValue()));
			}
		}
		if (EsbViewsRepository.LocalEntry.Properties.entryName == event.getAffectedEditor()) {
			localEntry.setEntryName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.LocalEntry.Properties.localEntryType == event.getAffectedEditor()) {
			localEntry.setLocalEntryType((LocalEntryValueType)event.getNewValue());
		}
		if (EsbViewsRepository.LocalEntry.Properties.valueLiteral == event.getAffectedEditor()) {
			localEntry.setValueLiteral((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.LocalEntry.Properties.valueXML == event.getAffectedEditor()) {
			localEntry.setValueXML((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.LocalEntry.Properties.valueURL == event.getAffectedEditor()) {
			localEntry.setValueURL((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			LocalEntryPropertiesEditionPart basePart = (LocalEntryPropertiesEditionPart)editingPart;
			if (EsbPackage.eINSTANCE.getEsbElement_Description().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.LocalEntry.Properties.description)) {
				if (msg.getNewValue() != null) {
					basePart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setDescription("");
				}
			}
			if (EsbPackage.eINSTANCE.getEsbElement_CommentsList().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.LocalEntry.Properties.commentsList)) {
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
			
			if (EsbPackage.eINSTANCE.getLocalEntry_EntryName().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.LocalEntry.Properties.entryName)) {
				if (msg.getNewValue() != null) {
					basePart.setEntryName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setEntryName("");
				}
			}
			if (EsbPackage.eINSTANCE.getLocalEntry_LocalEntryType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.LocalEntry.Properties.localEntryType))
				basePart.setLocalEntryType((LocalEntryValueType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getLocalEntry_ValueLiteral().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.LocalEntry.Properties.valueLiteral)) {
				if (msg.getNewValue() != null) {
					basePart.setValueLiteral(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setValueLiteral("");
				}
			}
			if (EsbPackage.eINSTANCE.getLocalEntry_ValueXML().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.LocalEntry.Properties.valueXML)) {
				if (msg.getNewValue() != null) {
					basePart.setValueXML(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setValueXML("");
				}
			}
			if (EsbPackage.eINSTANCE.getLocalEntry_ValueURL().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.LocalEntry.Properties.valueURL)) {
				if (msg.getNewValue() != null) {
					basePart.setValueURL(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setValueURL("");
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
			EsbPackage.eINSTANCE.getLocalEntry_EntryName(),
			EsbPackage.eINSTANCE.getLocalEntry_LocalEntryType(),
			EsbPackage.eINSTANCE.getLocalEntry_ValueLiteral(),
			EsbPackage.eINSTANCE.getLocalEntry_ValueXML(),
			EsbPackage.eINSTANCE.getLocalEntry_ValueURL()		);
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
				if (EsbViewsRepository.LocalEntry.Properties.description == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.LocalEntry.Properties.commentsList == event.getAffectedEditor()) {
					BasicDiagnostic chain = new BasicDiagnostic();
					for (Iterator iterator = ((List)event.getNewValue()).iterator(); iterator.hasNext();) {
						chain.add(Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEAttributeType(), iterator.next()));
					}
					ret = chain;
				}
				if (EsbViewsRepository.LocalEntry.Properties.entryName == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getLocalEntry_EntryName().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getLocalEntry_EntryName().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.LocalEntry.Properties.localEntryType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getLocalEntry_LocalEntryType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getLocalEntry_LocalEntryType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.LocalEntry.Properties.valueLiteral == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getLocalEntry_ValueLiteral().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getLocalEntry_ValueLiteral().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.LocalEntry.Properties.valueXML == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getLocalEntry_ValueXML().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getLocalEntry_ValueXML().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.LocalEntry.Properties.valueURL == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getLocalEntry_ValueURL().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getLocalEntry_ValueURL().getEAttributeType(), newValue);
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
