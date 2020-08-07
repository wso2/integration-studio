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

import org.eclipse.emf.eef.runtime.context.impl.EObjectPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.context.impl.EReferencePropertiesEditionContext;

import org.eclipse.emf.eef.runtime.impl.components.SinglePartPropertiesEditingComponent;

import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;
import org.eclipse.emf.eef.runtime.impl.utils.EEFUtils;

import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy;

import org.eclipse.emf.eef.runtime.policies.impl.CreateEditingPolicy;

import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

import org.wso2.developerstudio.eclipse.gmf.esb.CallTemplateParameter;
import org.wso2.developerstudio.eclipse.gmf.esb.CloudConnectorOperation;
import org.wso2.developerstudio.eclipse.gmf.esb.CloudConnectorOperationParamEditorType;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;

import org.wso2.developerstudio.eclipse.gmf.esb.parts.CloudConnectorOperationPropertiesEditionPart;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.forms.CloudConnectorOperationPropertiesEditionPartForm;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.ConnectorSchemaHolder;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;


// End of user code

/**
 * 
 * 
 */
public class CloudConnectorOperationPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$
	public static String ADVANCE_PART = "Advance";

	
	/**
	 * Settings for connectorParameters ReferencesTable
	 */
	protected ReferencesTableSettings connectorParametersSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public CloudConnectorOperationPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject cloudConnectorOperation, String editing_mode) {
		super(editingContext, cloudConnectorOperation, editing_mode);
		parts = new String[] { BASE_PART, ADVANCE_PART};
		repositoryKey = EsbViewsRepository.class;
		partKey = EsbViewsRepository.CloudConnectorOperation.class;
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
			
			final CloudConnectorOperation cloudConnectorOperation = (CloudConnectorOperation)elt;
			final CloudConnectorOperationPropertiesEditionPart basePart = (CloudConnectorOperationPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EsbViewsRepository.CloudConnectorOperation.Properties.description))
				basePart.setDescription(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, cloudConnectorOperation.getDescription()));
			
			if (isAccessible(EsbViewsRepository.CloudConnectorOperation.Properties.commentsList))
				basePart.setCommentsList(cloudConnectorOperation.getCommentsList());
			
			if (isAccessible(EsbViewsRepository.CloudConnectorOperation.Properties.reverse)) {
				basePart.setReverse(cloudConnectorOperation.isReverse());
			}
			if (isAccessible(EsbViewsRepository.CloudConnectorOperation.Properties.connectorParameters)) {
				connectorParametersSettings = new ReferencesTableSettings(cloudConnectorOperation, EsbPackage.eINSTANCE.getCloudConnectorOperation_ConnectorParameters());
				basePart.initConnectorParameters(connectorParametersSettings);
			}
			if (isAccessible(EsbViewsRepository.CloudConnectorOperation.Properties.configRef))
				basePart.setConfigRef(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, cloudConnectorOperation.getConfigRef()));
			
			if (isAccessible(EsbViewsRepository.CloudConnectorOperation.Properties.connectorName))
				basePart.setConnectorName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, cloudConnectorOperation.getConnectorName()));
			
			if (isAccessible(EsbViewsRepository.CloudConnectorOperation.Properties.operationName))
				basePart.setOperationName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, cloudConnectorOperation.getOperationName()));
			
			if (isAccessible(EsbViewsRepository.CloudConnectorOperation.Properties.cloudConnectorName))
				basePart.setCloudConnectorName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, cloudConnectorOperation.getCloudConnectorName()));
			
			if (isAccessible(EsbViewsRepository.CloudConnectorOperation.Properties.availableConfigs))
				basePart.setAvailableConfigs(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, cloudConnectorOperation.getAvailableConfigs()));
			
			if (isAccessible(EsbViewsRepository.CloudConnectorOperation.Properties.parameterEditorType)) {
				basePart.initParameterEditorType(EEFUtils.choiceOfValues(cloudConnectorOperation, EsbPackage.eINSTANCE.getCloudConnectorOperation_ParameterEditorType()), cloudConnectorOperation.getParameterEditorType());
			}
			// init filters
			
			
			
			if (isAccessible(EsbViewsRepository.CloudConnectorOperation.Properties.connectorParameters)) {
				basePart.addFilterToConnectorParameters(new ViewerFilter() {
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof CallTemplateParameter); //$NON-NLS-1$ 
					}
			
				});
				// Start of user code for additional businessfilters for connectorParameters
				// End of user code
			}






			// init values for referenced views

			// init filters for referenced views

		}
		setInitializing(false);

		// Start of user code for additional businessfilters for connectorParameters
		if (editingPart != null) {
			((CloudConnectorOperationPropertiesEditionPartForm) editingPart).afterInitialization();
		}
		// End of user code
	}













	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#associatedFeature(java.lang.Object)
	 */
	public EStructuralFeature associatedFeature(Object editorKey) {
		if (editorKey == EsbViewsRepository.CloudConnectorOperation.Properties.description) {
			return EsbPackage.eINSTANCE.getEsbElement_Description();
		}
		if (editorKey == EsbViewsRepository.CloudConnectorOperation.Properties.commentsList) {
			return EsbPackage.eINSTANCE.getEsbElement_CommentsList();
		}
		if (editorKey == EsbViewsRepository.CloudConnectorOperation.Properties.reverse) {
			return EsbPackage.eINSTANCE.getMediator_Reverse();
		}
		if (editorKey == EsbViewsRepository.CloudConnectorOperation.Properties.connectorParameters) {
			return EsbPackage.eINSTANCE.getCloudConnectorOperation_ConnectorParameters();
		}
		if (editorKey == EsbViewsRepository.CloudConnectorOperation.Properties.configRef) {
			return EsbPackage.eINSTANCE.getCloudConnectorOperation_ConfigRef();
		}
		if (editorKey == EsbViewsRepository.CloudConnectorOperation.Properties.connectorName) {
			return EsbPackage.eINSTANCE.getCloudConnectorOperation_ConnectorName();
		}
		if (editorKey == EsbViewsRepository.CloudConnectorOperation.Properties.operationName) {
			return EsbPackage.eINSTANCE.getCloudConnectorOperation_OperationName();
		}
		if (editorKey == EsbViewsRepository.CloudConnectorOperation.Properties.cloudConnectorName) {
			return EsbPackage.eINSTANCE.getCloudConnectorOperation_CloudConnectorName();
		}
		if (editorKey == EsbViewsRepository.CloudConnectorOperation.Properties.availableConfigs) {
			return EsbPackage.eINSTANCE.getCloudConnectorOperation_AvailableConfigs();
		}
		if (editorKey == EsbViewsRepository.CloudConnectorOperation.Properties.parameterEditorType) {
			return EsbPackage.eINSTANCE.getCloudConnectorOperation_ParameterEditorType();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		CloudConnectorOperation cloudConnectorOperation = (CloudConnectorOperation)semanticObject;
		if (EsbViewsRepository.CloudConnectorOperation.Properties.description == event.getAffectedEditor()) {
			cloudConnectorOperation.setDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.CloudConnectorOperation.Properties.commentsList == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				cloudConnectorOperation.getCommentsList().clear();
				cloudConnectorOperation.getCommentsList().addAll(((EList) event.getNewValue()));
			}
		}
		if (EsbViewsRepository.CloudConnectorOperation.Properties.reverse == event.getAffectedEditor()) {
			cloudConnectorOperation.setReverse((Boolean)event.getNewValue());
		}

		if (EsbViewsRepository.CloudConnectorOperation.Properties.connectorParameters == event.getAffectedEditor()) {
		      String schemaName = cloudConnectorOperation.getConnectorName().split("connector")[0] + "-" + cloudConnectorOperation.getOperationName();
		      if(ConnectorSchemaHolder.getInstance().hasConnectorOperationSchema(schemaName) && (!EEFPropertyViewUtil.isLegacyPropertiesViewSet())) {
		          EList connectorParams = cloudConnectorOperation.getConnectorParameters();
	              int index = connectorParams.indexOf(event.getOldValue());
	              CallTemplateParameter ctpi = (CallTemplateParameter)connectorParams.get(index);
	              ctpi.setParameterValue(event.getNewValue().toString());
	              connectorParams.set(index, ctpi);
		      } else {
		          if (event.getKind() == PropertiesEditionEvent.ADD) {
		                EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, connectorParametersSettings, editingContext.getAdapterFactory());
		                PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(semanticObject, PropertiesEditingProvider.class);
		                if (provider != null) {
		                    PropertiesEditingPolicy policy = provider.getPolicy(context);
		                    if (policy instanceof CreateEditingPolicy) {
		                        policy.execute();
		                    }
		                }
		            } else if (event.getKind() == PropertiesEditionEvent.EDIT) {
		                EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(editingContext, this, (EObject) event.getNewValue(), editingContext.getAdapterFactory());
		                PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt((EObject) event.getNewValue(), PropertiesEditingProvider.class);
		                if (provider != null) {
		                    PropertiesEditingPolicy editionPolicy = provider.getPolicy(context);
		                    if (editionPolicy != null) {
		                        editionPolicy.execute();
		                    }
		                }
		            } else if (event.getKind() == PropertiesEditionEvent.REMOVE) {
		                connectorParametersSettings.removeFromReference((EObject) event.getNewValue());
		            } else if (event.getKind() == PropertiesEditionEvent.MOVE) {
		                connectorParametersSettings.move(event.getNewIndex(), (CallTemplateParameter) event.getNewValue());
		            }
		      }
		}
		if (EsbViewsRepository.CloudConnectorOperation.Properties.configRef == event.getAffectedEditor()) {
			cloudConnectorOperation.setConfigRef((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.CloudConnectorOperation.Properties.connectorName == event.getAffectedEditor()) {
			cloudConnectorOperation.setConnectorName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.CloudConnectorOperation.Properties.operationName == event.getAffectedEditor()) {
			cloudConnectorOperation.setOperationName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.CloudConnectorOperation.Properties.cloudConnectorName == event.getAffectedEditor()) {
			cloudConnectorOperation.setCloudConnectorName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.CloudConnectorOperation.Properties.availableConfigs == event.getAffectedEditor()) {
			cloudConnectorOperation.setAvailableConfigs((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.CloudConnectorOperation.Properties.parameterEditorType == event.getAffectedEditor()) {
			cloudConnectorOperation.setParameterEditorType((CloudConnectorOperationParamEditorType)event.getNewValue());
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			CloudConnectorOperationPropertiesEditionPart basePart = (CloudConnectorOperationPropertiesEditionPart)editingPart;
			if (EsbPackage.eINSTANCE.getEsbElement_Description().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.CloudConnectorOperation.Properties.description)) {
				if (msg.getNewValue() != null) {
					basePart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setDescription("");
				}
			}
			if (EsbPackage.eINSTANCE.getEsbElement_CommentsList().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.CloudConnectorOperation.Properties.commentsList)) {
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
			
			if (EsbPackage.eINSTANCE.getMediator_Reverse().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.CloudConnectorOperation.Properties.reverse))
				basePart.setReverse((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getCloudConnectorOperation_ConnectorParameters().equals(msg.getFeature()) && isAccessible(EsbViewsRepository.CloudConnectorOperation.Properties.connectorParameters))
				basePart.updateConnectorParameters();
			if (EsbPackage.eINSTANCE.getCloudConnectorOperation_ConfigRef().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.CloudConnectorOperation.Properties.configRef)) {
				if (msg.getNewValue() != null) {
					basePart.setConfigRef(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setConfigRef("");
				}
			}
			if (EsbPackage.eINSTANCE.getCloudConnectorOperation_ConnectorName().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.CloudConnectorOperation.Properties.connectorName)) {
				if (msg.getNewValue() != null) {
					basePart.setConnectorName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setConnectorName("");
				}
			}
			if (EsbPackage.eINSTANCE.getCloudConnectorOperation_OperationName().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.CloudConnectorOperation.Properties.operationName)) {
				if (msg.getNewValue() != null) {
					basePart.setOperationName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setOperationName("");
				}
			}
			if (EsbPackage.eINSTANCE.getCloudConnectorOperation_CloudConnectorName().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.CloudConnectorOperation.Properties.cloudConnectorName)) {
				if (msg.getNewValue() != null) {
					basePart.setCloudConnectorName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setCloudConnectorName("");
				}
			}
			if (EsbPackage.eINSTANCE.getCloudConnectorOperation_AvailableConfigs().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.CloudConnectorOperation.Properties.availableConfigs)) {
				if (msg.getNewValue() != null) {
					basePart.setAvailableConfigs(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setAvailableConfigs("");
				}
			}
			if (EsbPackage.eINSTANCE.getCloudConnectorOperation_ParameterEditorType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.CloudConnectorOperation.Properties.parameterEditorType))
				basePart.setParameterEditorType((CloudConnectorOperationParamEditorType)msg.getNewValue());
			
			
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
			EsbPackage.eINSTANCE.getCloudConnectorOperation_ConnectorParameters(),
			EsbPackage.eINSTANCE.getCloudConnectorOperation_ConfigRef(),
			EsbPackage.eINSTANCE.getCloudConnectorOperation_ConnectorName(),
			EsbPackage.eINSTANCE.getCloudConnectorOperation_OperationName(),
			EsbPackage.eINSTANCE.getCloudConnectorOperation_CloudConnectorName(),
			EsbPackage.eINSTANCE.getCloudConnectorOperation_AvailableConfigs(),
			EsbPackage.eINSTANCE.getCloudConnectorOperation_ParameterEditorType()		);
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
				if (EsbViewsRepository.CloudConnectorOperation.Properties.description == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.CloudConnectorOperation.Properties.commentsList == event.getAffectedEditor()) {
					BasicDiagnostic chain = new BasicDiagnostic();
					for (Iterator iterator = ((List)event.getNewValue()).iterator(); iterator.hasNext();) {
						chain.add(Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEAttributeType(), iterator.next()));
					}
					ret = chain;
				}
				if (EsbViewsRepository.CloudConnectorOperation.Properties.reverse == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMediator_Reverse().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMediator_Reverse().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.CloudConnectorOperation.Properties.configRef == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getCloudConnectorOperation_ConfigRef().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getCloudConnectorOperation_ConfigRef().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.CloudConnectorOperation.Properties.connectorName == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getCloudConnectorOperation_ConnectorName().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getCloudConnectorOperation_ConnectorName().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.CloudConnectorOperation.Properties.operationName == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getCloudConnectorOperation_OperationName().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getCloudConnectorOperation_OperationName().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.CloudConnectorOperation.Properties.cloudConnectorName == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getCloudConnectorOperation_CloudConnectorName().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getCloudConnectorOperation_CloudConnectorName().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.CloudConnectorOperation.Properties.availableConfigs == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getCloudConnectorOperation_AvailableConfigs().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getCloudConnectorOperation_AvailableConfigs().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.CloudConnectorOperation.Properties.parameterEditorType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getCloudConnectorOperation_ParameterEditorType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getCloudConnectorOperation_ParameterEditorType().getEAttributeType(), newValue);
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
