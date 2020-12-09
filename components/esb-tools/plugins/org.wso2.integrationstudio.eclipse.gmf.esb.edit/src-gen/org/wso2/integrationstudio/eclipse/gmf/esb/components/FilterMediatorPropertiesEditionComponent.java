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
import org.wso2.integrationstudio.eclipse.gmf.esb.FilterMediator;
import org.wso2.integrationstudio.eclipse.gmf.esb.FilterMediatorConditionType;
import org.wso2.integrationstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.FilterMediatorPropertiesEditionPart;
import org.wso2.integrationstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;


// End of user code

/**
 * 
 * 
 */
public class FilterMediatorPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	
	/**
	 * Default constructor
	 * 
	 */
	public FilterMediatorPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject filterMediator, String editing_mode) {
		super(editingContext, filterMediator, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EsbViewsRepository.class;
		partKey = EsbViewsRepository.FilterMediator.class;
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
			
			final FilterMediator filterMediator = (FilterMediator)elt;
			final FilterMediatorPropertiesEditionPart basePart = (FilterMediatorPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EsbViewsRepository.FilterMediator.Properties.description))
				basePart.setDescription(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, filterMediator.getDescription()));
			
			if (isAccessible(EsbViewsRepository.FilterMediator.Properties.commentsList))
				basePart.setCommentsList(filterMediator.getCommentsList());
			
			if (isAccessible(EsbViewsRepository.FilterMediator.Properties.reverse)) {
				basePart.setReverse(filterMediator.isReverse());
			}
			if (isAccessible(EsbViewsRepository.FilterMediator.Properties.conditionType)) {
				basePart.initConditionType(EEFUtils.choiceOfValues(filterMediator, EsbPackage.eINSTANCE.getFilterMediator_ConditionType()), filterMediator.getConditionType());
			}
			if (isAccessible(EsbViewsRepository.FilterMediator.Properties.regex))
				basePart.setRegex(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, filterMediator.getRegex()));
			
			// Start of user code  for source command update
            if (isAccessible(EsbViewsRepository.FilterMediator.Properties.source)) {
                basePart.setSource(filterMediator.getSource());
            }
			// End of user code
			
			// Start of user code  for xpath command update
            if (isAccessible(EsbViewsRepository.FilterMediator.Properties.xPath)) {
                basePart.setXPath(filterMediator.getXpath());
            }
			// End of user code
			
			// init filters
			
			
			
			
			
			// Start of user code  for source filter update
			// End of user code
			
			// Start of user code  for xpath filter update
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
		if (editorKey == EsbViewsRepository.FilterMediator.Properties.description) {
			return EsbPackage.eINSTANCE.getEsbElement_Description();
		}
		if (editorKey == EsbViewsRepository.FilterMediator.Properties.commentsList) {
			return EsbPackage.eINSTANCE.getEsbElement_CommentsList();
		}
		if (editorKey == EsbViewsRepository.FilterMediator.Properties.reverse) {
			return EsbPackage.eINSTANCE.getMediator_Reverse();
		}
		if (editorKey == EsbViewsRepository.FilterMediator.Properties.conditionType) {
			return EsbPackage.eINSTANCE.getFilterMediator_ConditionType();
		}
		if (editorKey == EsbViewsRepository.FilterMediator.Properties.regex) {
			return EsbPackage.eINSTANCE.getFilterMediator_Regex();
		}
		if (editorKey == EsbViewsRepository.FilterMediator.Properties.source) {
			return EsbPackage.eINSTANCE.getFilterMediator_Source();
		}
		if (editorKey == EsbViewsRepository.FilterMediator.Properties.xPath) {
			return EsbPackage.eINSTANCE.getFilterMediator_Xpath();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		FilterMediator filterMediator = (FilterMediator)semanticObject;
		if (EsbViewsRepository.FilterMediator.Properties.description == event.getAffectedEditor()) {
			filterMediator.setDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.FilterMediator.Properties.commentsList == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				filterMediator.getCommentsList().clear();
				filterMediator.getCommentsList().addAll(((EList) event.getNewValue()));
			}
		}
		if (EsbViewsRepository.FilterMediator.Properties.reverse == event.getAffectedEditor()) {
			filterMediator.setReverse((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.FilterMediator.Properties.conditionType == event.getAffectedEditor()) {
			filterMediator.setConditionType((FilterMediatorConditionType)event.getNewValue());
		}
		if (EsbViewsRepository.FilterMediator.Properties.regex == event.getAffectedEditor()) {
			filterMediator.setRegex((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.FilterMediator.Properties.source == event.getAffectedEditor()) {
			// Start of user code for updateSource method body
            if (event.getNewValue() != null) {
                NamespacedProperty nsp = (NamespacedProperty) event.getNewValue();
                filterMediator.setSource(nsp);
            } else {
                filterMediator.setSource(EsbFactoryImpl.eINSTANCE.createNamespacedProperty());
            }
			// End of user code
			
		}
		if (EsbViewsRepository.FilterMediator.Properties.xPath == event.getAffectedEditor()) {
			// Start of user code for updateXpath method body
            if (event.getNewValue() != null) {
                NamespacedProperty nsp = (NamespacedProperty) event.getNewValue();
                filterMediator.setXpath(nsp);
            } else {
                filterMediator.setXpath(EsbFactoryImpl.eINSTANCE.createNamespacedProperty());
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
			FilterMediatorPropertiesEditionPart basePart = (FilterMediatorPropertiesEditionPart)editingPart;
			if (EsbPackage.eINSTANCE.getEsbElement_Description().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.FilterMediator.Properties.description)) {
				if (msg.getNewValue() != null) {
					basePart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setDescription("");
				}
			}
			if (EsbPackage.eINSTANCE.getEsbElement_CommentsList().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.FilterMediator.Properties.commentsList)) {
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
			
			if (EsbPackage.eINSTANCE.getMediator_Reverse().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.FilterMediator.Properties.reverse))
				basePart.setReverse((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getFilterMediator_ConditionType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.FilterMediator.Properties.conditionType))
				basePart.setConditionType((FilterMediatorConditionType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getFilterMediator_Regex().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.FilterMediator.Properties.regex)) {
				if (msg.getNewValue() != null) {
					basePart.setRegex(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setRegex("");
				}
			}
					// Start of user code for source live update
            if (EsbPackage.eINSTANCE.getFilterMediator_Source().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject) && basePart != null
                    && isAccessible(EsbViewsRepository.FilterMediator.Properties.source)) {
                if (msg.getNewValue() != null) {
                    basePart.setSource((NamespacedProperty) msg.getNewValue());
                } else {
                    basePart.setSource(EsbFactoryImpl.eINSTANCE.createNamespacedProperty());
                }
            }
					// End of user code
			
					// Start of user code for xpath live update
            if (EsbPackage.eINSTANCE.getFilterMediator_Xpath().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject) && basePart != null
                    && isAccessible(EsbViewsRepository.FilterMediator.Properties.xPath)) {
                if (msg.getNewValue() != null) {
                    basePart.setXPath((NamespacedProperty) msg.getNewValue());
                } else {
                    basePart.setXPath(EsbFactoryImpl.eINSTANCE.createNamespacedProperty());
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
			EsbPackage.eINSTANCE.getFilterMediator_ConditionType(),
			EsbPackage.eINSTANCE.getFilterMediator_Regex(),
			EsbPackage.eINSTANCE.getFilterMediator_Source(),
			EsbPackage.eINSTANCE.getFilterMediator_Xpath()		);
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
				if (EsbViewsRepository.FilterMediator.Properties.description == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.FilterMediator.Properties.commentsList == event.getAffectedEditor()) {
					BasicDiagnostic chain = new BasicDiagnostic();
					for (Iterator iterator = ((List)event.getNewValue()).iterator(); iterator.hasNext();) {
						chain.add(Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEAttributeType(), iterator.next()));
					}
					ret = chain;
				}
				if (EsbViewsRepository.FilterMediator.Properties.reverse == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMediator_Reverse().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMediator_Reverse().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.FilterMediator.Properties.conditionType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getFilterMediator_ConditionType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getFilterMediator_ConditionType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.FilterMediator.Properties.regex == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getFilterMediator_Regex().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getFilterMediator_Regex().getEAttributeType(), newValue);
				}
			} catch (IllegalArgumentException iae) {
				ret = BasicDiagnostic.toDiagnostic(iae);
			} catch (WrappedException we) {
				ret = BasicDiagnostic.toDiagnostic(we);
			}
		}
		return ret;
	}

    /**
     * @generated NOT
     */
    @Override
    public String getHelpContent(Object key, int kind) {
        return EEFPropertyViewUtil.getHelpContent(key);
    }
	

	

}
