/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.components;

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

import org.wso2.developerstudio.eclipse.gmf.esb.CommandProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.CommandPropertyContextAction;
import org.wso2.developerstudio.eclipse.gmf.esb.CommandPropertyMessageAction;
import org.wso2.developerstudio.eclipse.gmf.esb.CommandPropertyValueType;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.CommandPropertyPropertiesEditionPart;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.impl.CommandPropertyPropertiesEditionPartImpl;


// End of user code

/**
 * 
 * 
 */
public class CommandPropertyPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	
	/**
	 * Default constructor
	 * 
	 */
	public CommandPropertyPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject commandProperty, String editing_mode) {
		super(editingContext, commandProperty, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EsbViewsRepository.class;
		partKey = EsbViewsRepository.CommandProperty.class;
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
			
			final CommandProperty commandProperty = (CommandProperty)elt;
			final CommandPropertyPropertiesEditionPart basePart = (CommandPropertyPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EsbViewsRepository.CommandProperty.Properties.propertyName))
				basePart.setPropertyName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, commandProperty.getPropertyName()));
			
			if (isAccessible(EsbViewsRepository.CommandProperty.Properties.valueType)) {
				basePart.initValueType(EEFUtils.choiceOfValues(commandProperty, EsbPackage.eINSTANCE.getCommandProperty_ValueType()), commandProperty.getValueType());
			}
			if (isAccessible(EsbViewsRepository.CommandProperty.Properties.valueLiteral))
				basePart.setValueLiteral(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, commandProperty.getValueLiteral()));
			
			if (isAccessible(EsbViewsRepository.CommandProperty.Properties.valueContextPropertyName))
				basePart.setValueContextPropertyName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, commandProperty.getValueContextPropertyName()));
			
			if (isAccessible(EsbViewsRepository.CommandProperty.Properties.contextAction)) {
				basePart.initContextAction(EEFUtils.choiceOfValues(commandProperty, EsbPackage.eINSTANCE.getCommandProperty_ContextAction()), commandProperty.getContextAction());
			}
			if (isAccessible(EsbViewsRepository.CommandProperty.Properties.messageAction)) {
				basePart.initMessageAction(EEFUtils.choiceOfValues(commandProperty, EsbPackage.eINSTANCE.getCommandProperty_MessageAction()), commandProperty.getMessageAction());
			}
			// Start of user code  for valueMessageElementXpath command update
			if (isAccessible(EsbViewsRepository.CommandProperty.Properties.valueMessageElementXpath)) {
                basePart.setValueMessageElementXpath(commandProperty.getValueMessageElementXpath());
            }
			// End of user code
			
			// init filters
			
            // Start of user code for CommandProperty filter update
            ((CommandPropertyPropertiesEditionPartImpl) editingPart).validate();
            // End of user code
			
		}
		setInitializing(false);
	}










	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#associatedFeature(java.lang.Object)
	 */
	public EStructuralFeature associatedFeature(Object editorKey) {
		if (editorKey == EsbViewsRepository.CommandProperty.Properties.propertyName) {
			return EsbPackage.eINSTANCE.getCommandProperty_PropertyName();
		}
		if (editorKey == EsbViewsRepository.CommandProperty.Properties.valueType) {
			return EsbPackage.eINSTANCE.getCommandProperty_ValueType();
		}
		if (editorKey == EsbViewsRepository.CommandProperty.Properties.valueLiteral) {
			return EsbPackage.eINSTANCE.getCommandProperty_ValueLiteral();
		}
		if (editorKey == EsbViewsRepository.CommandProperty.Properties.valueContextPropertyName) {
			return EsbPackage.eINSTANCE.getCommandProperty_ValueContextPropertyName();
		}
		if (editorKey == EsbViewsRepository.CommandProperty.Properties.contextAction) {
			return EsbPackage.eINSTANCE.getCommandProperty_ContextAction();
		}
		if (editorKey == EsbViewsRepository.CommandProperty.Properties.messageAction) {
			return EsbPackage.eINSTANCE.getCommandProperty_MessageAction();
		}
		if (editorKey == EsbViewsRepository.CommandProperty.Properties.valueMessageElementXpath) {
			return EsbPackage.eINSTANCE.getCommandProperty_ValueMessageElementXpath();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		CommandProperty commandProperty = (CommandProperty)semanticObject;
		if (EsbViewsRepository.CommandProperty.Properties.propertyName == event.getAffectedEditor()) {
			commandProperty.setPropertyName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.CommandProperty.Properties.valueType == event.getAffectedEditor()) {
			commandProperty.setValueType((CommandPropertyValueType)event.getNewValue());
		}
		if (EsbViewsRepository.CommandProperty.Properties.valueLiteral == event.getAffectedEditor()) {
			commandProperty.setValueLiteral((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.CommandProperty.Properties.valueContextPropertyName == event.getAffectedEditor()) {
			commandProperty.setValueContextPropertyName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.CommandProperty.Properties.contextAction == event.getAffectedEditor()) {
			commandProperty.setContextAction((CommandPropertyContextAction)event.getNewValue());
		}
		if (EsbViewsRepository.CommandProperty.Properties.messageAction == event.getAffectedEditor()) {
			commandProperty.setMessageAction((CommandPropertyMessageAction)event.getNewValue());
		}
		if (EsbViewsRepository.CommandProperty.Properties.valueMessageElementXpath == event.getAffectedEditor()) {
			// Start of user code for updateValueMessageElementXpath method body
	          if (event.getNewValue() != null) {
	                NamespacedProperty nsp = (NamespacedProperty) event.getNewValue();
	                commandProperty.setValueMessageElementXpath(nsp);
	            } else {
	                commandProperty.setValueMessageElementXpath(EsbFactoryImpl.eINSTANCE.createNamespacedProperty());
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
			CommandPropertyPropertiesEditionPart basePart = (CommandPropertyPropertiesEditionPart)editingPart;
			if (EsbPackage.eINSTANCE.getCommandProperty_PropertyName().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.CommandProperty.Properties.propertyName)) {
				if (msg.getNewValue() != null) {
					basePart.setPropertyName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setPropertyName("");
				}
			}
			if (EsbPackage.eINSTANCE.getCommandProperty_ValueType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.CommandProperty.Properties.valueType))
				basePart.setValueType((CommandPropertyValueType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getCommandProperty_ValueLiteral().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.CommandProperty.Properties.valueLiteral)) {
				if (msg.getNewValue() != null) {
					basePart.setValueLiteral(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setValueLiteral("");
				}
			}
			if (EsbPackage.eINSTANCE.getCommandProperty_ValueContextPropertyName().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.CommandProperty.Properties.valueContextPropertyName)) {
				if (msg.getNewValue() != null) {
					basePart.setValueContextPropertyName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setValueContextPropertyName("");
				}
			}
			if (EsbPackage.eINSTANCE.getCommandProperty_ContextAction().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.CommandProperty.Properties.contextAction))
				basePart.setContextAction((CommandPropertyContextAction)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getCommandProperty_MessageAction().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.CommandProperty.Properties.messageAction))
				basePart.setMessageAction((CommandPropertyMessageAction)msg.getNewValue());
			
					// Start of user code for valueMessageElementXpath live update
	         if (EsbPackage.eINSTANCE.getCommandProperty_ValueMessageElementXpath()
	                    .equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null
	                    && isAccessible(EsbViewsRepository.CommandProperty.Properties.valueMessageElementXpath)) {
	                if (msg.getNewValue() != null) {
	                    basePart.setValueMessageElementXpath((NamespacedProperty) msg.getNewValue());
	                } else {
	                    basePart.setValueMessageElementXpath(EsbFactoryImpl.eINSTANCE.createNamespacedProperty());
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
			EsbPackage.eINSTANCE.getCommandProperty_PropertyName(),
			EsbPackage.eINSTANCE.getCommandProperty_ValueType(),
			EsbPackage.eINSTANCE.getCommandProperty_ValueLiteral(),
			EsbPackage.eINSTANCE.getCommandProperty_ValueContextPropertyName(),
			EsbPackage.eINSTANCE.getCommandProperty_ContextAction(),
			EsbPackage.eINSTANCE.getCommandProperty_MessageAction(),
			EsbPackage.eINSTANCE.getCommandProperty_ValueMessageElementXpath()		);
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
				if (EsbViewsRepository.CommandProperty.Properties.propertyName == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getCommandProperty_PropertyName().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getCommandProperty_PropertyName().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.CommandProperty.Properties.valueType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getCommandProperty_ValueType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getCommandProperty_ValueType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.CommandProperty.Properties.valueLiteral == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getCommandProperty_ValueLiteral().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getCommandProperty_ValueLiteral().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.CommandProperty.Properties.valueContextPropertyName == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getCommandProperty_ValueContextPropertyName().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getCommandProperty_ValueContextPropertyName().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.CommandProperty.Properties.contextAction == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getCommandProperty_ContextAction().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getCommandProperty_ContextAction().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.CommandProperty.Properties.messageAction == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getCommandProperty_MessageAction().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getCommandProperty_MessageAction().getEAttributeType(), newValue);
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
