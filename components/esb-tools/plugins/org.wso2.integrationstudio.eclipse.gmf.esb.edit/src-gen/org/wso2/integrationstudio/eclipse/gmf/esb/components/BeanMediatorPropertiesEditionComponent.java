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

import org.wso2.integrationstudio.eclipse.gmf.esb.BeanMediator;
import org.wso2.integrationstudio.eclipse.gmf.esb.BeanMediatorAction;
import org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.integrationstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.PropertyValueType;
import org.wso2.integrationstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.BeanMediatorPropertiesEditionPart;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.integrationstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;


// End of user code

/**
 * 
 * 
 */
public class BeanMediatorPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	
	/**
	 * Default constructor
	 * 
	 */
	public BeanMediatorPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject beanMediator, String editing_mode) {
		super(editingContext, beanMediator, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EsbViewsRepository.class;
		partKey = EsbViewsRepository.BeanMediator.class;
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
			
			final BeanMediator beanMediator = (BeanMediator)elt;
			final BeanMediatorPropertiesEditionPart basePart = (BeanMediatorPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EsbViewsRepository.BeanMediator.Properties.description))
				basePart.setDescription(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, beanMediator.getDescription()));
			
			if (isAccessible(EsbViewsRepository.BeanMediator.Properties.commentsList))
				basePart.setCommentsList(beanMediator.getCommentsList());
			
			if (isAccessible(EsbViewsRepository.BeanMediator.Properties.reverse)) {
				basePart.setReverse(beanMediator.isReverse());
			}
			if (isAccessible(EsbViewsRepository.BeanMediator.Properties.class_))
				basePart.setClass_(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, beanMediator.getClass_()));
			
			if (isAccessible(EsbViewsRepository.BeanMediator.Properties.action)) {
				basePart.initAction(EEFUtils.choiceOfValues(beanMediator, EsbPackage.eINSTANCE.getBeanMediator_Action()), beanMediator.getAction());
			}
			if (isAccessible(EsbViewsRepository.BeanMediator.Properties.var))
				basePart.setVar(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, beanMediator.getVar()));
			
			if (isAccessible(EsbViewsRepository.BeanMediator.Properties.property))
				basePart.setProperty(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, beanMediator.getProperty()));
			
			if (isAccessible(EsbViewsRepository.BeanMediator.Properties.valueType)) {
				basePart.initValueType(EEFUtils.choiceOfValues(beanMediator, EsbPackage.eINSTANCE.getBeanMediator_ValueType()), beanMediator.getValueType());
			}
			if (isAccessible(EsbViewsRepository.BeanMediator.Properties.valueLiteral))
				basePart.setValueLiteral(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, beanMediator.getValueLiteral()));
			
			if (isAccessible(EsbViewsRepository.BeanMediator.Properties.targetType)) {
				basePart.initTargetType(EEFUtils.choiceOfValues(beanMediator, EsbPackage.eINSTANCE.getBeanMediator_TargetType()), beanMediator.getTargetType());
			}
			if (isAccessible(EsbViewsRepository.BeanMediator.Properties.targetLiteral))
				basePart.setTargetLiteral(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, beanMediator.getTargetLiteral()));
			
            // Start of user code for valueExpression command update
            if (isAccessible(EsbViewsRepository.BeanMediator.Properties.valueExpression)) {
                basePart.setValueExpression(beanMediator.getValueExpression());
            }
            // End of user code

            // Start of user code for targetExpression command update
            if (isAccessible(EsbViewsRepository.BeanMediator.Properties.targetExpression)) {
                basePart.setTargetExpression(beanMediator.getTargetExpression());
            }
            // End of user code
			
			// init filters
			
			
			
			
			
			
			
			
			
			
			
			// Start of user code  for valueExpression filter update
			// End of user code
			
			// Start of user code  for targetExpression filter update
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
		if (editorKey == EsbViewsRepository.BeanMediator.Properties.description) {
			return EsbPackage.eINSTANCE.getEsbElement_Description();
		}
		if (editorKey == EsbViewsRepository.BeanMediator.Properties.commentsList) {
			return EsbPackage.eINSTANCE.getEsbElement_CommentsList();
		}
		if (editorKey == EsbViewsRepository.BeanMediator.Properties.reverse) {
			return EsbPackage.eINSTANCE.getMediator_Reverse();
		}
		if (editorKey == EsbViewsRepository.BeanMediator.Properties.class_) {
			return EsbPackage.eINSTANCE.getBeanMediator_Class();
		}
		if (editorKey == EsbViewsRepository.BeanMediator.Properties.action) {
			return EsbPackage.eINSTANCE.getBeanMediator_Action();
		}
		if (editorKey == EsbViewsRepository.BeanMediator.Properties.var) {
			return EsbPackage.eINSTANCE.getBeanMediator_Var();
		}
		if (editorKey == EsbViewsRepository.BeanMediator.Properties.property) {
			return EsbPackage.eINSTANCE.getBeanMediator_Property();
		}
		if (editorKey == EsbViewsRepository.BeanMediator.Properties.valueType) {
			return EsbPackage.eINSTANCE.getBeanMediator_ValueType();
		}
		if (editorKey == EsbViewsRepository.BeanMediator.Properties.valueLiteral) {
			return EsbPackage.eINSTANCE.getBeanMediator_ValueLiteral();
		}
		if (editorKey == EsbViewsRepository.BeanMediator.Properties.targetType) {
			return EsbPackage.eINSTANCE.getBeanMediator_TargetType();
		}
		if (editorKey == EsbViewsRepository.BeanMediator.Properties.targetLiteral) {
			return EsbPackage.eINSTANCE.getBeanMediator_TargetLiteral();
		}
		if (editorKey == EsbViewsRepository.BeanMediator.Properties.valueExpression) {
			return EsbPackage.eINSTANCE.getBeanMediator_ValueExpression();
		}
		if (editorKey == EsbViewsRepository.BeanMediator.Properties.targetExpression) {
			return EsbPackage.eINSTANCE.getBeanMediator_TargetExpression();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		BeanMediator beanMediator = (BeanMediator)semanticObject;
		if (EsbViewsRepository.BeanMediator.Properties.description == event.getAffectedEditor()) {
			beanMediator.setDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.BeanMediator.Properties.commentsList == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				beanMediator.getCommentsList().clear();
				beanMediator.getCommentsList().addAll(((EList) event.getNewValue()));
			}
		}
		if (EsbViewsRepository.BeanMediator.Properties.reverse == event.getAffectedEditor()) {
			beanMediator.setReverse((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.BeanMediator.Properties.class_ == event.getAffectedEditor()) {
			beanMediator.setClass((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.BeanMediator.Properties.action == event.getAffectedEditor()) {
			beanMediator.setAction((BeanMediatorAction)event.getNewValue());
		}
		if (EsbViewsRepository.BeanMediator.Properties.var == event.getAffectedEditor()) {
			beanMediator.setVar((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.BeanMediator.Properties.property == event.getAffectedEditor()) {
			beanMediator.setProperty((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.BeanMediator.Properties.valueType == event.getAffectedEditor()) {
			beanMediator.setValueType((PropertyValueType)event.getNewValue());
		}
		if (EsbViewsRepository.BeanMediator.Properties.valueLiteral == event.getAffectedEditor()) {
			beanMediator.setValueLiteral((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.BeanMediator.Properties.targetType == event.getAffectedEditor()) {
			beanMediator.setTargetType((PropertyValueType)event.getNewValue());
		}
		if (EsbViewsRepository.BeanMediator.Properties.targetLiteral == event.getAffectedEditor()) {
			beanMediator.setTargetLiteral((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.BeanMediator.Properties.valueExpression == event.getAffectedEditor()) {
			// Start of user code for updateValueExpression method body
            if (event.getNewValue() != null) {
                NamespacedProperty nspValueExpression = (NamespacedProperty) event.getNewValue();
                beanMediator.setValueExpression(nspValueExpression);
            } else {
                beanMediator.setValueExpression(EsbFactoryImpl.eINSTANCE.createNamespacedProperty());
            }
			// End of user code
			
		}
		if (EsbViewsRepository.BeanMediator.Properties.targetExpression == event.getAffectedEditor()) {
			// Start of user code for updateTargetExpression method body
            if (event.getNewValue() != null) {
                NamespacedProperty nspValueExpression = (NamespacedProperty) event.getNewValue();
                beanMediator.setTargetExpression(nspValueExpression);
            } else {
                beanMediator.setTargetExpression(EsbFactoryImpl.eINSTANCE.createNamespacedProperty());
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
			BeanMediatorPropertiesEditionPart basePart = (BeanMediatorPropertiesEditionPart)editingPart;
			if (EsbPackage.eINSTANCE.getEsbElement_Description().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.BeanMediator.Properties.description)) {
				if (msg.getNewValue() != null) {
					basePart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setDescription("");
				}
			}
			if (EsbPackage.eINSTANCE.getEsbElement_CommentsList().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.BeanMediator.Properties.commentsList)) {
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
			
			if (EsbPackage.eINSTANCE.getMediator_Reverse().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.BeanMediator.Properties.reverse))
				basePart.setReverse((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getBeanMediator_Class().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.BeanMediator.Properties.class_)) {
				if (msg.getNewValue() != null) {
					basePart.setClass_(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setClass_("");
				}
			}
			if (EsbPackage.eINSTANCE.getBeanMediator_Action().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.BeanMediator.Properties.action))
				basePart.setAction((BeanMediatorAction)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getBeanMediator_Var().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.BeanMediator.Properties.var)) {
				if (msg.getNewValue() != null) {
					basePart.setVar(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setVar("");
				}
			}
			if (EsbPackage.eINSTANCE.getBeanMediator_Property().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.BeanMediator.Properties.property)) {
				if (msg.getNewValue() != null) {
					basePart.setProperty(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setProperty("");
				}
			}
			if (EsbPackage.eINSTANCE.getBeanMediator_ValueType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.BeanMediator.Properties.valueType))
				basePart.setValueType((PropertyValueType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getBeanMediator_ValueLiteral().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.BeanMediator.Properties.valueLiteral)) {
				if (msg.getNewValue() != null) {
					basePart.setValueLiteral(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setValueLiteral("");
				}
			}
			if (EsbPackage.eINSTANCE.getBeanMediator_TargetType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.BeanMediator.Properties.targetType))
				basePart.setTargetType((PropertyValueType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getBeanMediator_TargetLiteral().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.BeanMediator.Properties.targetLiteral)) {
				if (msg.getNewValue() != null) {
					basePart.setTargetLiteral(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTargetLiteral("");
				}
			}
					// Start of user code for valueExpression live update
            if (EsbPackage.eINSTANCE.getBeanMediator_TargetExpression().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.BeanMediator.Properties.targetExpression)) {
                if (msg.getNewValue() != null) {
                    basePart.setTargetExpression((NamespacedProperty)msg.getNewValue());
                } else {
                    basePart.setTargetExpression(EsbFactoryImpl.eINSTANCE.createNamespacedProperty());
                }
            }
					// End of user code
			
					// Start of user code for targetExpression live update
	           if (EsbPackage.eINSTANCE.getBeanMediator_ValueExpression().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.BeanMediator.Properties.valueExpression)) {
	                if (msg.getNewValue() != null) {
	                    basePart.setValueExpression((NamespacedProperty)msg.getNewValue());
	                } else {
	                    basePart.setValueExpression(EsbFactoryImpl.eINSTANCE.createNamespacedProperty());
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
			EsbPackage.eINSTANCE.getBeanMediator_Class(),
			EsbPackage.eINSTANCE.getBeanMediator_Action(),
			EsbPackage.eINSTANCE.getBeanMediator_Var(),
			EsbPackage.eINSTANCE.getBeanMediator_Property(),
			EsbPackage.eINSTANCE.getBeanMediator_ValueType(),
			EsbPackage.eINSTANCE.getBeanMediator_ValueLiteral(),
			EsbPackage.eINSTANCE.getBeanMediator_TargetType(),
			EsbPackage.eINSTANCE.getBeanMediator_TargetLiteral(),
			EsbPackage.eINSTANCE.getBeanMediator_ValueExpression(),
			EsbPackage.eINSTANCE.getBeanMediator_TargetExpression()		);
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
				if (EsbViewsRepository.BeanMediator.Properties.description == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.BeanMediator.Properties.commentsList == event.getAffectedEditor()) {
					BasicDiagnostic chain = new BasicDiagnostic();
					for (Iterator iterator = ((List)event.getNewValue()).iterator(); iterator.hasNext();) {
						chain.add(Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEAttributeType(), iterator.next()));
					}
					ret = chain;
				}
				if (EsbViewsRepository.BeanMediator.Properties.reverse == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMediator_Reverse().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMediator_Reverse().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.BeanMediator.Properties.class_ == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getBeanMediator_Class().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getBeanMediator_Class().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.BeanMediator.Properties.action == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getBeanMediator_Action().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getBeanMediator_Action().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.BeanMediator.Properties.var == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getBeanMediator_Var().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getBeanMediator_Var().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.BeanMediator.Properties.property == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getBeanMediator_Property().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getBeanMediator_Property().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.BeanMediator.Properties.valueType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getBeanMediator_ValueType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getBeanMediator_ValueType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.BeanMediator.Properties.valueLiteral == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getBeanMediator_ValueLiteral().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getBeanMediator_ValueLiteral().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.BeanMediator.Properties.targetType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getBeanMediator_TargetType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getBeanMediator_TargetType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.BeanMediator.Properties.targetLiteral == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getBeanMediator_TargetLiteral().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getBeanMediator_TargetLiteral().getEAttributeType(), newValue);
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
