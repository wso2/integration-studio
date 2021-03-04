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

import org.wso2.integrationstudio.gmf.esb.DSSMediator;
import org.wso2.integrationstudio.gmf.esb.DSSSourceType;
import org.wso2.integrationstudio.gmf.esb.DSSTargetType;
import org.wso2.integrationstudio.gmf.esb.DSSoperationProperty;
import org.wso2.integrationstudio.gmf.esb.EsbPackage;

import org.wso2.integrationstudio.gmf.esb.parts.DSSMediatorPropertiesEditionPart;
import org.wso2.integrationstudio.gmf.esb.parts.EsbViewsRepository;


// End of user code

/**
 * 
 * 
 */
public class DSSMediatorPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	/**
	 * Settings for operations ReferencesTable
	 */
	protected ReferencesTableSettings operationsSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public DSSMediatorPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject dSSMediator, String editing_mode) {
		super(editingContext, dSSMediator, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EsbViewsRepository.class;
		partKey = EsbViewsRepository.DSSMediator.class;
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
			
			final DSSMediator dSSMediator = (DSSMediator)elt;
			final DSSMediatorPropertiesEditionPart basePart = (DSSMediatorPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EsbViewsRepository.DSSMediator.Properties.description))
				basePart.setDescription(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, dSSMediator.getDescription()));
			
			if (isAccessible(EsbViewsRepository.DSSMediator.Properties.commentsList))
				basePart.setCommentsList(dSSMediator.getCommentsList());
			
			if (isAccessible(EsbViewsRepository.DSSMediator.Properties.reverse)) {
				basePart.setReverse(dSSMediator.isReverse());
			}
			if (isAccessible(EsbViewsRepository.DSSMediator.Properties.serviceName))
				basePart.setServiceName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, dSSMediator.getServiceName()));
			
			if (isAccessible(EsbViewsRepository.DSSMediator.Properties.sourceType)) {
				basePart.initSourceType(EEFUtils.choiceOfValues(dSSMediator, EsbPackage.eINSTANCE.getDSSMediator_SourceType()), dSSMediator.getSourceType());
			}
			if (isAccessible(EsbViewsRepository.DSSMediator.Properties.operations)) {
				operationsSettings = new ReferencesTableSettings(dSSMediator, EsbPackage.eINSTANCE.getDSSMediator_Operations());
				basePart.initOperations(operationsSettings);
			}
			if (isAccessible(EsbViewsRepository.DSSMediator.Properties.targetType)) {
				basePart.initTargetType(EEFUtils.choiceOfValues(dSSMediator, EsbPackage.eINSTANCE.getDSSMediator_TargetType()), dSSMediator.getTargetType());
			}
			if (isAccessible(EsbViewsRepository.DSSMediator.Properties.targetProperty))
				basePart.setTargetProperty(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, dSSMediator.getTargetProperty()));
			
			// init filters
			
			
			
			
			
			if (isAccessible(EsbViewsRepository.DSSMediator.Properties.operations)) {
				basePart.addFilterToOperations(new ViewerFilter() {
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof DSSoperationProperty); //$NON-NLS-1$ 
					}
			
				});
				// Start of user code for additional businessfilters for operations
				// End of user code
			}
			
			
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
		if (editorKey == EsbViewsRepository.DSSMediator.Properties.description) {
			return EsbPackage.eINSTANCE.getEsbElement_Description();
		}
		if (editorKey == EsbViewsRepository.DSSMediator.Properties.commentsList) {
			return EsbPackage.eINSTANCE.getEsbElement_CommentsList();
		}
		if (editorKey == EsbViewsRepository.DSSMediator.Properties.reverse) {
			return EsbPackage.eINSTANCE.getMediator_Reverse();
		}
		if (editorKey == EsbViewsRepository.DSSMediator.Properties.serviceName) {
			return EsbPackage.eINSTANCE.getDSSMediator_ServiceName();
		}
		if (editorKey == EsbViewsRepository.DSSMediator.Properties.sourceType) {
			return EsbPackage.eINSTANCE.getDSSMediator_SourceType();
		}
		if (editorKey == EsbViewsRepository.DSSMediator.Properties.operations) {
			return EsbPackage.eINSTANCE.getDSSMediator_Operations();
		}
		if (editorKey == EsbViewsRepository.DSSMediator.Properties.targetType) {
			return EsbPackage.eINSTANCE.getDSSMediator_TargetType();
		}
		if (editorKey == EsbViewsRepository.DSSMediator.Properties.targetProperty) {
			return EsbPackage.eINSTANCE.getDSSMediator_TargetProperty();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		DSSMediator dSSMediator = (DSSMediator)semanticObject;
		if (EsbViewsRepository.DSSMediator.Properties.description == event.getAffectedEditor()) {
			dSSMediator.setDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.DSSMediator.Properties.commentsList == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				dSSMediator.getCommentsList().clear();
				dSSMediator.getCommentsList().addAll(((EList) event.getNewValue()));
			}
		}
		if (EsbViewsRepository.DSSMediator.Properties.reverse == event.getAffectedEditor()) {
			dSSMediator.setReverse((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.DSSMediator.Properties.serviceName == event.getAffectedEditor()) {
			dSSMediator.setServiceName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.DSSMediator.Properties.sourceType == event.getAffectedEditor()) {
			dSSMediator.setSourceType((DSSSourceType)event.getNewValue());
		}
		if (EsbViewsRepository.DSSMediator.Properties.operations == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, operationsSettings, editingContext.getAdapterFactory());
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
				operationsSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				operationsSettings.move(event.getNewIndex(), (DSSoperationProperty) event.getNewValue());
			}
		}
		if (EsbViewsRepository.DSSMediator.Properties.targetType == event.getAffectedEditor()) {
			dSSMediator.setTargetType((DSSTargetType)event.getNewValue());
		}
		if (EsbViewsRepository.DSSMediator.Properties.targetProperty == event.getAffectedEditor()) {
			dSSMediator.setTargetProperty((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			DSSMediatorPropertiesEditionPart basePart = (DSSMediatorPropertiesEditionPart)editingPart;
			if (EsbPackage.eINSTANCE.getEsbElement_Description().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.DSSMediator.Properties.description)) {
				if (msg.getNewValue() != null) {
					basePart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setDescription("");
				}
			}
			if (EsbPackage.eINSTANCE.getEsbElement_CommentsList().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.DSSMediator.Properties.commentsList)) {
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
			
			if (EsbPackage.eINSTANCE.getMediator_Reverse().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.DSSMediator.Properties.reverse))
				basePart.setReverse((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getDSSMediator_ServiceName().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.DSSMediator.Properties.serviceName)) {
				if (msg.getNewValue() != null) {
					basePart.setServiceName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setServiceName("");
				}
			}
			if (EsbPackage.eINSTANCE.getDSSMediator_SourceType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.DSSMediator.Properties.sourceType))
				basePart.setSourceType((DSSSourceType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getDSSMediator_Operations().equals(msg.getFeature()) && isAccessible(EsbViewsRepository.DSSMediator.Properties.operations))
				basePart.updateOperations();
			if (EsbPackage.eINSTANCE.getDSSMediator_TargetType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.DSSMediator.Properties.targetType))
				basePart.setTargetType((DSSTargetType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getDSSMediator_TargetProperty().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.DSSMediator.Properties.targetProperty)) {
				if (msg.getNewValue() != null) {
					basePart.setTargetProperty(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTargetProperty("");
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
			EsbPackage.eINSTANCE.getDSSMediator_ServiceName(),
			EsbPackage.eINSTANCE.getDSSMediator_SourceType(),
			EsbPackage.eINSTANCE.getDSSMediator_Operations(),
			EsbPackage.eINSTANCE.getDSSMediator_TargetType(),
			EsbPackage.eINSTANCE.getDSSMediator_TargetProperty()		);
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
				if (EsbViewsRepository.DSSMediator.Properties.description == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.DSSMediator.Properties.commentsList == event.getAffectedEditor()) {
					BasicDiagnostic chain = new BasicDiagnostic();
					for (Iterator iterator = ((List)event.getNewValue()).iterator(); iterator.hasNext();) {
						chain.add(Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEAttributeType(), iterator.next()));
					}
					ret = chain;
				}
				if (EsbViewsRepository.DSSMediator.Properties.reverse == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMediator_Reverse().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMediator_Reverse().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.DSSMediator.Properties.serviceName == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getDSSMediator_ServiceName().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getDSSMediator_ServiceName().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.DSSMediator.Properties.sourceType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getDSSMediator_SourceType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getDSSMediator_SourceType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.DSSMediator.Properties.targetType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getDSSMediator_TargetType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getDSSMediator_TargetType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.DSSMediator.Properties.targetProperty == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getDSSMediator_TargetProperty().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getDSSMediator_TargetProperty().getEAttributeType(), newValue);
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
