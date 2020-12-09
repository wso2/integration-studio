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

import org.wso2.integrationstudio.eclipse.gmf.esb.DataMapperMediator;
import org.wso2.integrationstudio.eclipse.gmf.esb.DataMapperMediatorDataTypes;
import org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage;

import org.wso2.integrationstudio.eclipse.gmf.esb.parts.DataMapperMediatorPropertiesEditionPart;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.integrationstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;


// End of user code

/**
 * 
 * 
 */
public class DataMapperMediatorPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	/**
	 * Default constructor
	 * 
	 */
	public DataMapperMediatorPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject dataMapperMediator, String editing_mode) {
		super(editingContext, dataMapperMediator, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EsbViewsRepository.class;
		partKey = EsbViewsRepository.DataMapperMediator.class;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#initPart(java.lang.Object, int, org.eclipse.emf.ecore.EObject, 
	 *      org.eclipse.emf.ecore.resource.ResourceSet)
	 * @generated NOT
	 */
	public void initPart(Object key, int kind, EObject elt, ResourceSet allResource) {
		setInitializing(true);
		if (editingPart != null && key == partKey) {
			editingPart.setContext(elt, allResource);
			
			final DataMapperMediator dataMapperMediator = (DataMapperMediator)elt;
			final DataMapperMediatorPropertiesEditionPart basePart = (DataMapperMediatorPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EsbViewsRepository.DataMapperMediator.Properties.description))
				basePart.setDescription(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, dataMapperMediator.getDescription()));
			
			if (isAccessible(EsbViewsRepository.DataMapperMediator.Properties.commentsList))
				basePart.setCommentsList(dataMapperMediator.getCommentsList());
			
			if (isAccessible(EsbViewsRepository.DataMapperMediator.Properties.reverse)) {
				basePart.setReverse(dataMapperMediator.isReverse());
			}
			if (isAccessible(EsbViewsRepository.DataMapperMediator.Properties.inputType)) {
				basePart.initInputType(EEFUtils.choiceOfValues(dataMapperMediator, EsbPackage.eINSTANCE.getDataMapperMediator_InputType()), dataMapperMediator.getInputType());
			}
			if (isAccessible(EsbViewsRepository.DataMapperMediator.Properties.configurationLocalPath))
				basePart.setConfigurationLocalPath(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, dataMapperMediator.getConfiguration().getKeyValue()));
			
			if (isAccessible(EsbViewsRepository.DataMapperMediator.Properties.inputSchemaLocalPath))
				basePart.setInputSchemaLocalPath(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, dataMapperMediator.getInputSchema().getKeyValue()));
			
			if (isAccessible(EsbViewsRepository.DataMapperMediator.Properties.outputSchemaLocalPath))
				basePart.setOutputSchemaLocalPath(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, dataMapperMediator.getOutputSchema().getKeyValue()));
			
			if (isAccessible(EsbViewsRepository.DataMapperMediator.Properties.outputType)) {
				basePart.initOutputType(EEFUtils.choiceOfValues(dataMapperMediator, EsbPackage.eINSTANCE.getDataMapperMediator_OutputType()), dataMapperMediator.getOutputType());
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
		if (editorKey == EsbViewsRepository.DataMapperMediator.Properties.description) {
			return EsbPackage.eINSTANCE.getEsbElement_Description();
		}
		if (editorKey == EsbViewsRepository.DataMapperMediator.Properties.commentsList) {
			return EsbPackage.eINSTANCE.getEsbElement_CommentsList();
		}
		if (editorKey == EsbViewsRepository.DataMapperMediator.Properties.reverse) {
			return EsbPackage.eINSTANCE.getMediator_Reverse();
		}
		if (editorKey == EsbViewsRepository.DataMapperMediator.Properties.inputType) {
			return EsbPackage.eINSTANCE.getDataMapperMediator_InputType();
		}
		if (editorKey == EsbViewsRepository.DataMapperMediator.Properties.configurationLocalPath) {
			return EsbPackage.eINSTANCE.getDataMapperMediator_ConfigurationLocalPath();
		}
		if (editorKey == EsbViewsRepository.DataMapperMediator.Properties.inputSchemaLocalPath) {
			return EsbPackage.eINSTANCE.getDataMapperMediator_InputSchemaLocalPath();
		}
		if (editorKey == EsbViewsRepository.DataMapperMediator.Properties.outputSchemaLocalPath) {
			return EsbPackage.eINSTANCE.getDataMapperMediator_OutputSchemaLocalPath();
		}
		if (editorKey == EsbViewsRepository.DataMapperMediator.Properties.outputType) {
			return EsbPackage.eINSTANCE.getDataMapperMediator_OutputType();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		DataMapperMediator dataMapperMediator = (DataMapperMediator)semanticObject;
		if (EsbViewsRepository.DataMapperMediator.Properties.description == event.getAffectedEditor()) {
			dataMapperMediator.setDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.DataMapperMediator.Properties.commentsList == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				dataMapperMediator.getCommentsList().clear();
				dataMapperMediator.getCommentsList().addAll(((EList) event.getNewValue()));
			}
		}
		if (EsbViewsRepository.DataMapperMediator.Properties.reverse == event.getAffectedEditor()) {
			dataMapperMediator.setReverse((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.DataMapperMediator.Properties.inputType == event.getAffectedEditor()) {
			dataMapperMediator.setInputType((DataMapperMediatorDataTypes)event.getNewValue());
		}
		if (EsbViewsRepository.DataMapperMediator.Properties.configurationLocalPath == event.getAffectedEditor()) {
			dataMapperMediator.setConfigurationLocalPath((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.DataMapperMediator.Properties.inputSchemaLocalPath == event.getAffectedEditor()) {
			dataMapperMediator.setInputSchemaLocalPath((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.DataMapperMediator.Properties.outputSchemaLocalPath == event.getAffectedEditor()) {
			dataMapperMediator.setOutputSchemaLocalPath((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.DataMapperMediator.Properties.outputType == event.getAffectedEditor()) {
			dataMapperMediator.setOutputType((DataMapperMediatorDataTypes)event.getNewValue());
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			DataMapperMediatorPropertiesEditionPart basePart = (DataMapperMediatorPropertiesEditionPart)editingPart;
			if (EsbPackage.eINSTANCE.getEsbElement_Description().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.DataMapperMediator.Properties.description)) {
				if (msg.getNewValue() != null) {
					basePart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setDescription("");
				}
			}
			if (EsbPackage.eINSTANCE.getEsbElement_CommentsList().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.DataMapperMediator.Properties.commentsList)) {
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
			
			if (EsbPackage.eINSTANCE.getMediator_Reverse().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.DataMapperMediator.Properties.reverse))
				basePart.setReverse((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getDataMapperMediator_InputType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.DataMapperMediator.Properties.inputType))
				basePart.setInputType((DataMapperMediatorDataTypes)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getDataMapperMediator_ConfigurationLocalPath().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.DataMapperMediator.Properties.configurationLocalPath)) {
				if (msg.getNewValue() != null) {
					basePart.setConfigurationLocalPath(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setConfigurationLocalPath("");
				}
			}
			if (EsbPackage.eINSTANCE.getDataMapperMediator_InputSchemaLocalPath().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.DataMapperMediator.Properties.inputSchemaLocalPath)) {
				if (msg.getNewValue() != null) {
					basePart.setInputSchemaLocalPath(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setInputSchemaLocalPath("");
				}
			}
			if (EsbPackage.eINSTANCE.getDataMapperMediator_OutputSchemaLocalPath().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.DataMapperMediator.Properties.outputSchemaLocalPath)) {
				if (msg.getNewValue() != null) {
					basePart.setOutputSchemaLocalPath(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setOutputSchemaLocalPath("");
				}
			}
			if (EsbPackage.eINSTANCE.getDataMapperMediator_OutputType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.DataMapperMediator.Properties.outputType))
				basePart.setOutputType((DataMapperMediatorDataTypes)msg.getNewValue());
			
			
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
			EsbPackage.eINSTANCE.getDataMapperMediator_InputType(),
			EsbPackage.eINSTANCE.getDataMapperMediator_ConfigurationLocalPath(),
			EsbPackage.eINSTANCE.getDataMapperMediator_InputSchemaLocalPath(),
			EsbPackage.eINSTANCE.getDataMapperMediator_OutputSchemaLocalPath(),
			EsbPackage.eINSTANCE.getDataMapperMediator_OutputType()		);
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
				if (EsbViewsRepository.DataMapperMediator.Properties.description == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.DataMapperMediator.Properties.commentsList == event.getAffectedEditor()) {
					BasicDiagnostic chain = new BasicDiagnostic();
					for (Iterator iterator = ((List)event.getNewValue()).iterator(); iterator.hasNext();) {
						chain.add(Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEAttributeType(), iterator.next()));
					}
					ret = chain;
				}
				if (EsbViewsRepository.DataMapperMediator.Properties.reverse == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMediator_Reverse().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMediator_Reverse().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.DataMapperMediator.Properties.inputType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getDataMapperMediator_InputType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getDataMapperMediator_InputType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.DataMapperMediator.Properties.configurationLocalPath == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getDataMapperMediator_ConfigurationLocalPath().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getDataMapperMediator_ConfigurationLocalPath().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.DataMapperMediator.Properties.inputSchemaLocalPath == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getDataMapperMediator_InputSchemaLocalPath().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getDataMapperMediator_InputSchemaLocalPath().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.DataMapperMediator.Properties.outputSchemaLocalPath == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getDataMapperMediator_OutputSchemaLocalPath().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getDataMapperMediator_OutputSchemaLocalPath().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.DataMapperMediator.Properties.outputType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getDataMapperMediator_OutputType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getDataMapperMediator_OutputType().getEAttributeType(), newValue);
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
