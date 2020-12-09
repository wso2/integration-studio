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
import org.wso2.integrationstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.SqlParameterDataType;
import org.wso2.integrationstudio.eclipse.gmf.esb.SqlParameterDefinition;
import org.wso2.integrationstudio.eclipse.gmf.esb.SqlParameterValueType;
import org.wso2.integrationstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.SqlParameterDefinitionPropertiesEditionPart;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.impl.SqlParameterDefinitionPropertiesEditionPartImpl;


// End of user code

/**
 * 
 * 
 */
public class SqlParameterDefinitionPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	
	/**
	 * Default constructor
	 * 
	 */
	public SqlParameterDefinitionPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject sqlParameterDefinition, String editing_mode) {
		super(editingContext, sqlParameterDefinition, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EsbViewsRepository.class;
		partKey = EsbViewsRepository.SqlParameterDefinition.class;
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
			
			final SqlParameterDefinition sqlParameterDefinition = (SqlParameterDefinition)elt;
			final SqlParameterDefinitionPropertiesEditionPart basePart = (SqlParameterDefinitionPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EsbViewsRepository.SqlParameterDefinition.Properties.dataType)) {
				basePart.initDataType(EEFUtils.choiceOfValues(sqlParameterDefinition, EsbPackage.eINSTANCE.getSqlParameterDefinition_DataType()), sqlParameterDefinition.getDataType());
			}
			if (isAccessible(EsbViewsRepository.SqlParameterDefinition.Properties.valueType)) {
				basePart.initValueType(EEFUtils.choiceOfValues(sqlParameterDefinition, EsbPackage.eINSTANCE.getSqlParameterDefinition_ValueType()), sqlParameterDefinition.getValueType());
			}
			if (isAccessible(EsbViewsRepository.SqlParameterDefinition.Properties.valueLiteral))
				basePart.setValueLiteral(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, sqlParameterDefinition.getValueLiteral()));
			
			// Start of user code  for valueExpression command update
			if (isAccessible(EsbViewsRepository.SqlParameterDefinition.Properties.valueExpression)) {
                basePart.setValueExpression(sqlParameterDefinition.getValueExpression());
            }
			// End of user code
			
			// init filters
			
			
			
			// Start of user code  for valueExpression filter update
			((SqlParameterDefinitionPropertiesEditionPartImpl) editingPart).validate();
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
		if (editorKey == EsbViewsRepository.SqlParameterDefinition.Properties.dataType) {
			return EsbPackage.eINSTANCE.getSqlParameterDefinition_DataType();
		}
		if (editorKey == EsbViewsRepository.SqlParameterDefinition.Properties.valueType) {
			return EsbPackage.eINSTANCE.getSqlParameterDefinition_ValueType();
		}
		if (editorKey == EsbViewsRepository.SqlParameterDefinition.Properties.valueLiteral) {
			return EsbPackage.eINSTANCE.getSqlParameterDefinition_ValueLiteral();
		}
		if (editorKey == EsbViewsRepository.SqlParameterDefinition.Properties.valueExpression) {
			return EsbPackage.eINSTANCE.getSqlParameterDefinition_ValueExpression();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		SqlParameterDefinition sqlParameterDefinition = (SqlParameterDefinition)semanticObject;
		if (EsbViewsRepository.SqlParameterDefinition.Properties.dataType == event.getAffectedEditor()) {
			sqlParameterDefinition.setDataType((SqlParameterDataType)event.getNewValue());
		}
		if (EsbViewsRepository.SqlParameterDefinition.Properties.valueType == event.getAffectedEditor()) {
			sqlParameterDefinition.setValueType((SqlParameterValueType)event.getNewValue());
		}
		if (EsbViewsRepository.SqlParameterDefinition.Properties.valueLiteral == event.getAffectedEditor()) {
			sqlParameterDefinition.setValueLiteral((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.SqlParameterDefinition.Properties.valueExpression == event.getAffectedEditor()) {
			// Start of user code for updateValueExpression method body
		    if (event.getNewValue() != null) {
                NamespacedProperty nsp = (NamespacedProperty) event.getNewValue();
                sqlParameterDefinition.setValueExpression(nsp);
            } else {
                sqlParameterDefinition.setValueExpression(EsbFactoryImpl.eINSTANCE.createNamespacedProperty());
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
			SqlParameterDefinitionPropertiesEditionPart basePart = (SqlParameterDefinitionPropertiesEditionPart)editingPart;
			if (EsbPackage.eINSTANCE.getSqlParameterDefinition_DataType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.SqlParameterDefinition.Properties.dataType))
				basePart.setDataType((SqlParameterDataType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getSqlParameterDefinition_ValueType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.SqlParameterDefinition.Properties.valueType))
				basePart.setValueType((SqlParameterValueType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getSqlParameterDefinition_ValueLiteral().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.SqlParameterDefinition.Properties.valueLiteral)) {
				if (msg.getNewValue() != null) {
					basePart.setValueLiteral(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setValueLiteral("");
				}
			}
					// Start of user code for valueExpression live update
			if (EsbPackage.eINSTANCE.getSqlParameterDefinition_ValueExpression().equals(msg.getFeature()) && 
			        msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.SqlParameterDefinition.Properties.valueExpression)) {
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
			EsbPackage.eINSTANCE.getSqlParameterDefinition_DataType(),
			EsbPackage.eINSTANCE.getSqlParameterDefinition_ValueType(),
			EsbPackage.eINSTANCE.getSqlParameterDefinition_ValueLiteral(),
			EsbPackage.eINSTANCE.getSqlParameterDefinition_ValueExpression()		);
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
				if (EsbViewsRepository.SqlParameterDefinition.Properties.dataType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getSqlParameterDefinition_DataType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getSqlParameterDefinition_DataType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.SqlParameterDefinition.Properties.valueType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getSqlParameterDefinition_ValueType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getSqlParameterDefinition_ValueType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.SqlParameterDefinition.Properties.valueLiteral == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getSqlParameterDefinition_ValueLiteral().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getSqlParameterDefinition_ValueLiteral().getEAttributeType(), newValue);
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
