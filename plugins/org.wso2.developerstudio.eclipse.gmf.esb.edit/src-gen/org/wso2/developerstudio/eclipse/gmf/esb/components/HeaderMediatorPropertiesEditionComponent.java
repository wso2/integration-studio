/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.components;

// Start of user code for imports
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
import org.wso2.developerstudio.eclipse.gmf.esb.HeaderAction;
import org.wso2.developerstudio.eclipse.gmf.esb.HeaderMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.HeaderValueType;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.ScopeType;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.HeaderMediatorPropertiesEditionPart;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;

import java.util.Iterator;
import java.util.List;

// End of user code

/**
 * 
 * 
 */
public class HeaderMediatorPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	
	/**
	 * Default constructor
	 * 
	 */
	public HeaderMediatorPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject headerMediator, String editing_mode) {
		super(editingContext, headerMediator, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EsbViewsRepository.class;
		partKey = EsbViewsRepository.HeaderMediator.class;
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
			
			final HeaderMediator headerMediator = (HeaderMediator)elt;
			final HeaderMediatorPropertiesEditionPart basePart = (HeaderMediatorPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EsbViewsRepository.HeaderMediator.Properties.headerAction)) {
				basePart.initHeaderAction(EEFUtils.choiceOfValues(headerMediator, EsbPackage.eINSTANCE.getHeaderMediator_HeaderAction()), headerMediator.getHeaderAction());
			}
			if (isAccessible(EsbViewsRepository.HeaderMediator.Properties.valueType)) {
				basePart.initValueType(EEFUtils.choiceOfValues(headerMediator, EsbPackage.eINSTANCE.getHeaderMediator_ValueType()), headerMediator.getValueType());
			}
			if (isAccessible(EsbViewsRepository.HeaderMediator.Properties.scope)) {
				basePart.initScope(EEFUtils.choiceOfValues(headerMediator, EsbPackage.eINSTANCE.getHeaderMediator_Scope()), headerMediator.getScope());
			}
			if (isAccessible(EsbViewsRepository.HeaderMediator.Properties.valueLiteral))
				basePart.setValueLiteral(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, headerMediator.getValueLiteral()));
			
			if (isAccessible(EsbViewsRepository.HeaderMediator.Properties.valueInline))
				basePart.setValueInline(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, headerMediator.getValueInline()));
			
			// Start of user code  for headerName command update
			if (isAccessible(EsbViewsRepository.HeaderMediator.Properties.headerName)) {
				basePart.setHeaderName(headerMediator.getHeaderName());
			}
			// End of user code
			
			// Start of user code  for valueExpression command update
			if (isAccessible(EsbViewsRepository.HeaderMediator.Properties.valueExpression)) {
				basePart.setValueExpression(headerMediator.getValueExpression());
			}
			// End of user code
			
			if (isAccessible(EsbViewsRepository.HeaderMediator.Properties.description))
				basePart.setDescription(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, headerMediator.getDescription()));
			
			if (isAccessible(EsbViewsRepository.HeaderMediator.Properties.commentsList))
				basePart.setCommentsList(headerMediator.getCommentsList());
			
			if (isAccessible(EsbViewsRepository.HeaderMediator.Properties.reverse)) {
				basePart.setReverse(headerMediator.isReverse());
			}
			// init filters
			
			
			
			
			
			// Start of user code  for headerName filter update
			// End of user code
			
			// Start of user code  for valueExpression filter update
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
		if (editorKey == EsbViewsRepository.HeaderMediator.Properties.headerAction) {
			return EsbPackage.eINSTANCE.getHeaderMediator_HeaderAction();
		}
		if (editorKey == EsbViewsRepository.HeaderMediator.Properties.valueType) {
			return EsbPackage.eINSTANCE.getHeaderMediator_ValueType();
		}
		if (editorKey == EsbViewsRepository.HeaderMediator.Properties.scope) {
			return EsbPackage.eINSTANCE.getHeaderMediator_Scope();
		}
		if (editorKey == EsbViewsRepository.HeaderMediator.Properties.valueLiteral) {
			return EsbPackage.eINSTANCE.getHeaderMediator_ValueLiteral();
		}
		if (editorKey == EsbViewsRepository.HeaderMediator.Properties.valueInline) {
			return EsbPackage.eINSTANCE.getHeaderMediator_ValueInline();
		}
		if (editorKey == EsbViewsRepository.HeaderMediator.Properties.headerName) {
			return EsbPackage.eINSTANCE.getHeaderMediator_ValueExpression();
		}
		if (editorKey == EsbViewsRepository.HeaderMediator.Properties.valueExpression) {
			return EsbPackage.eINSTANCE.getHeaderMediator_ValueExpression();
		}
		if (editorKey == EsbViewsRepository.HeaderMediator.Properties.description) {
			return EsbPackage.eINSTANCE.getEsbElement_Description();
		}
		if (editorKey == EsbViewsRepository.HeaderMediator.Properties.commentsList) {
			return EsbPackage.eINSTANCE.getEsbElement_CommentsList();
		}
		if (editorKey == EsbViewsRepository.HeaderMediator.Properties.reverse) {
			return EsbPackage.eINSTANCE.getMediator_Reverse();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		HeaderMediator headerMediator = (HeaderMediator)semanticObject;
		if (EsbViewsRepository.HeaderMediator.Properties.headerAction == event.getAffectedEditor()) {
			headerMediator.setHeaderAction((HeaderAction)event.getNewValue());
		}
		if (EsbViewsRepository.HeaderMediator.Properties.valueType == event.getAffectedEditor()) {
			headerMediator.setValueType((HeaderValueType)event.getNewValue());
		}
		if (EsbViewsRepository.HeaderMediator.Properties.scope == event.getAffectedEditor()) {
			headerMediator.setScope((ScopeType)event.getNewValue());
		}
		if (EsbViewsRepository.HeaderMediator.Properties.valueLiteral == event.getAffectedEditor()) {
			headerMediator.setValueLiteral((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.HeaderMediator.Properties.valueInline == event.getAffectedEditor()) {
			headerMediator.setValueInline((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.HeaderMediator.Properties.headerName == event.getAffectedEditor()) {
			// Start of user code for updateHeaderName method body
			if (event.getNewValue() != null) {
				NamespacedProperty nspHeaderName = (NamespacedProperty)event.getNewValue();
				headerMediator.setHeaderName(nspHeaderName);
			} else {
				headerMediator.setHeaderName(EsbFactoryImpl.eINSTANCE.createNamespacedProperty());
			}
			// End of user code
			
		}
		if (EsbViewsRepository.HeaderMediator.Properties.valueExpression == event.getAffectedEditor()) {
			// Start of user code for updateValueExpression method body
			if (event.getNewValue() != null) {
				NamespacedProperty nspValueExpression = (NamespacedProperty)event.getNewValue();
				headerMediator.setValueExpression(nspValueExpression);
			} else {
				headerMediator.setValueExpression(EsbFactoryImpl.eINSTANCE.createNamespacedProperty());
			}
			// End of user code
			
		}
		if (EsbViewsRepository.HeaderMediator.Properties.description == event.getAffectedEditor()) {
			headerMediator.setDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.HeaderMediator.Properties.commentsList == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				headerMediator.getCommentsList().clear();
				headerMediator.getCommentsList().addAll(((EList) event.getNewValue()));
			}
		}
		if (EsbViewsRepository.HeaderMediator.Properties.reverse == event.getAffectedEditor()) {
			headerMediator.setReverse((Boolean)event.getNewValue());
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			HeaderMediatorPropertiesEditionPart basePart = (HeaderMediatorPropertiesEditionPart)editingPart;
			if (EsbPackage.eINSTANCE.getHeaderMediator_HeaderAction().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.HeaderMediator.Properties.headerAction))
				basePart.setHeaderAction((HeaderAction)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getHeaderMediator_ValueType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.HeaderMediator.Properties.valueType))
				basePart.setValueType((HeaderValueType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getHeaderMediator_Scope().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.HeaderMediator.Properties.scope))
				basePart.setScope((ScopeType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getHeaderMediator_ValueLiteral().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.HeaderMediator.Properties.valueLiteral)) {
				if (msg.getNewValue() != null) {
					basePart.setValueLiteral(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setValueLiteral("");
				}
			}
			if (EsbPackage.eINSTANCE.getHeaderMediator_ValueInline().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.HeaderMediator.Properties.valueInline)) {
				if (msg.getNewValue() != null) {
					basePart.setValueInline(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setValueInline("");
				}
			}
					// Start of user code for headerName live update
					
			if (EsbPackage.eINSTANCE.getHeaderMediator_HeaderName().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.HeaderMediator.Properties.headerName)) {
				if (msg.getNewValue() != null) {
					basePart.setHeaderName((NamespacedProperty)msg.getNewValue());
				} else {
					basePart.setHeaderName(EsbFactoryImpl.eINSTANCE.createNamespacedProperty());
				}
			}
					// End of user code
			
					// Start of user code for valueExpression live update
					
			if (EsbPackage.eINSTANCE.getHeaderMediator_ValueExpression().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.HeaderMediator.Properties.valueExpression)) {
				if (msg.getNewValue() != null) {
					basePart.setValueExpression((NamespacedProperty)msg.getNewValue());
				} else {
					basePart.setValueExpression(EsbFactoryImpl.eINSTANCE.createNamespacedProperty());
				}
			}
					// End of user code
			
			if (EsbPackage.eINSTANCE.getEsbElement_Description().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.HeaderMediator.Properties.description)) {
				if (msg.getNewValue() != null) {
					basePart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setDescription("");
				}
			}
			if (EsbPackage.eINSTANCE.getEsbElement_CommentsList().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.HeaderMediator.Properties.commentsList)) {
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
			
			if (EsbPackage.eINSTANCE.getMediator_Reverse().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.HeaderMediator.Properties.reverse))
				basePart.setReverse((Boolean)msg.getNewValue());
			
			
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
			EsbPackage.eINSTANCE.getHeaderMediator_HeaderAction(),
			EsbPackage.eINSTANCE.getHeaderMediator_ValueType(),
			EsbPackage.eINSTANCE.getHeaderMediator_Scope(),
			EsbPackage.eINSTANCE.getHeaderMediator_ValueLiteral(),
			EsbPackage.eINSTANCE.getHeaderMediator_ValueInline(),
			EsbPackage.eINSTANCE.getHeaderMediator_ValueExpression(),
			EsbPackage.eINSTANCE.getHeaderMediator_ValueExpression(),
			EsbPackage.eINSTANCE.getEsbElement_Description(),
			EsbPackage.eINSTANCE.getEsbElement_CommentsList(),
			EsbPackage.eINSTANCE.getMediator_Reverse()		);
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
				if (EsbViewsRepository.HeaderMediator.Properties.headerAction == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getHeaderMediator_HeaderAction().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getHeaderMediator_HeaderAction().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.HeaderMediator.Properties.valueType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getHeaderMediator_ValueType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getHeaderMediator_ValueType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.HeaderMediator.Properties.scope == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getHeaderMediator_Scope().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getHeaderMediator_Scope().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.HeaderMediator.Properties.valueLiteral == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getHeaderMediator_ValueLiteral().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getHeaderMediator_ValueLiteral().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.HeaderMediator.Properties.valueInline == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getHeaderMediator_ValueInline().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getHeaderMediator_ValueInline().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.HeaderMediator.Properties.description == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.HeaderMediator.Properties.commentsList == event.getAffectedEditor()) {
					BasicDiagnostic chain = new BasicDiagnostic();
					for (Iterator iterator = ((List)event.getNewValue()).iterator(); iterator.hasNext();) {
						chain.add(Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEAttributeType(), iterator.next()));
					}
					ret = chain;
				}
				if (EsbViewsRepository.HeaderMediator.Properties.reverse == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMediator_Reverse().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMediator_Reverse().getEAttributeType(), newValue);
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
