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

import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy;

import org.eclipse.emf.eef.runtime.policies.impl.CreateEditingPolicy;

import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

import org.wso2.developerstudio.eclipse.gmf.esb.CallTemplateMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.CallTemplateParameter;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.CallTemplateMediatorPropertiesEditionPart;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;


// End of user code

/**
 * 
 * 
 */
public class CallTemplateMediatorPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	/**
	 * Settings for templateParameters ReferencesTable
	 */
	protected ReferencesTableSettings templateParametersSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public CallTemplateMediatorPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject callTemplateMediator, String editing_mode) {
		super(editingContext, callTemplateMediator, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EsbViewsRepository.class;
		partKey = EsbViewsRepository.CallTemplateMediator.class;
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
			
			final CallTemplateMediator callTemplateMediator = (CallTemplateMediator)elt;
			final CallTemplateMediatorPropertiesEditionPart basePart = (CallTemplateMediatorPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EsbViewsRepository.CallTemplateMediator.Properties.description))
				basePart.setDescription(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, callTemplateMediator.getDescription()));
			
			if (isAccessible(EsbViewsRepository.CallTemplateMediator.Properties.commentsList))
				basePart.setCommentsList(callTemplateMediator.getCommentsList());
			
			if (isAccessible(EsbViewsRepository.CallTemplateMediator.Properties.reverse)) {
				basePart.setReverse(callTemplateMediator.isReverse());
			}
			if (isAccessible(EsbViewsRepository.CallTemplateMediator.Properties.availableTemplates))
				basePart.setAvailableTemplates(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, callTemplateMediator.getAvailableTemplates()));
			
			if (isAccessible(EsbViewsRepository.CallTemplateMediator.Properties.templateParameters)) {
				templateParametersSettings = new ReferencesTableSettings(callTemplateMediator, EsbPackage.eINSTANCE.getCallTemplateMediator_TemplateParameters());
				basePart.initTemplateParameters(templateParametersSettings);
			}
			if (isAccessible(EsbViewsRepository.CallTemplateMediator.Properties.targetTemplate))
				basePart.setTargetTemplate(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, callTemplateMediator.getTargetTemplate()));
			
			// Start of user code  for onError command update
			if (isAccessible(EsbViewsRepository.CallTemplateMediator.Properties.onError))
                basePart.setOnError(callTemplateMediator.getOnError());
			// End of user code
			
			// init filters
			
			
			
			
			if (isAccessible(EsbViewsRepository.CallTemplateMediator.Properties.templateParameters)) {
				basePart.addFilterToTemplateParameters(new ViewerFilter() {
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof CallTemplateParameter); //$NON-NLS-1$ 
					}
			
				});
				// Start of user code for additional businessfilters for templateParameters
				// End of user code
			}
			
			// Start of user code  for onError filter update
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
		if (editorKey == EsbViewsRepository.CallTemplateMediator.Properties.description) {
			return EsbPackage.eINSTANCE.getEsbElement_Description();
		}
		if (editorKey == EsbViewsRepository.CallTemplateMediator.Properties.commentsList) {
			return EsbPackage.eINSTANCE.getEsbElement_CommentsList();
		}
		if (editorKey == EsbViewsRepository.CallTemplateMediator.Properties.reverse) {
			return EsbPackage.eINSTANCE.getMediator_Reverse();
		}
		if (editorKey == EsbViewsRepository.CallTemplateMediator.Properties.availableTemplates) {
			return EsbPackage.eINSTANCE.getCallTemplateMediator_AvailableTemplates();
		}
		if (editorKey == EsbViewsRepository.CallTemplateMediator.Properties.templateParameters) {
			return EsbPackage.eINSTANCE.getCallTemplateMediator_TemplateParameters();
		}
		if (editorKey == EsbViewsRepository.CallTemplateMediator.Properties.targetTemplate) {
			return EsbPackage.eINSTANCE.getCallTemplateMediator_TargetTemplate();
		}
		if (editorKey == EsbViewsRepository.CallTemplateMediator.Properties.onError) {
			return EsbPackage.eINSTANCE.getCallTemplateMediator_OnError();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		CallTemplateMediator callTemplateMediator = (CallTemplateMediator)semanticObject;
		if (EsbViewsRepository.CallTemplateMediator.Properties.description == event.getAffectedEditor()) {
			callTemplateMediator.setDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.CallTemplateMediator.Properties.commentsList == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				callTemplateMediator.getCommentsList().clear();
				callTemplateMediator.getCommentsList().addAll(((EList) event.getNewValue()));
			}
		}
		if (EsbViewsRepository.CallTemplateMediator.Properties.reverse == event.getAffectedEditor()) {
			callTemplateMediator.setReverse((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.CallTemplateMediator.Properties.availableTemplates == event.getAffectedEditor()) {
			callTemplateMediator.setAvailableTemplates((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.CallTemplateMediator.Properties.templateParameters == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, templateParametersSettings, editingContext.getAdapterFactory());
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
				templateParametersSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				templateParametersSettings.move(event.getNewIndex(), (CallTemplateParameter) event.getNewValue());
			}
		}
		if (EsbViewsRepository.CallTemplateMediator.Properties.targetTemplate == event.getAffectedEditor()) {
			callTemplateMediator.setTargetTemplate((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.CallTemplateMediator.Properties.onError == event.getAffectedEditor()) {
			// Start of user code for updateOnError method body
		    if (event.getNewValue() != null) {
                RegistryKeyProperty rkp = (RegistryKeyProperty) event.getNewValue();
                callTemplateMediator.setOnError(rkp);
            } else {
                callTemplateMediator.setOnError(EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty());
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
			CallTemplateMediatorPropertiesEditionPart basePart = (CallTemplateMediatorPropertiesEditionPart)editingPart;
			if (EsbPackage.eINSTANCE.getEsbElement_Description().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.CallTemplateMediator.Properties.description)) {
				if (msg.getNewValue() != null) {
					basePart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setDescription("");
				}
			}
			if (EsbPackage.eINSTANCE.getEsbElement_CommentsList().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.CallTemplateMediator.Properties.commentsList)) {
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
			
			if (EsbPackage.eINSTANCE.getMediator_Reverse().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.CallTemplateMediator.Properties.reverse))
				basePart.setReverse((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getCallTemplateMediator_AvailableTemplates().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.CallTemplateMediator.Properties.availableTemplates)) {
				if (msg.getNewValue() != null) {
					basePart.setAvailableTemplates(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setAvailableTemplates("");
				}
			}
			if (EsbPackage.eINSTANCE.getCallTemplateMediator_TemplateParameters().equals(msg.getFeature()) && isAccessible(EsbViewsRepository.CallTemplateMediator.Properties.templateParameters))
				basePart.updateTemplateParameters();
			if (EsbPackage.eINSTANCE.getCallTemplateMediator_TargetTemplate().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.CallTemplateMediator.Properties.targetTemplate)) {
				if (msg.getNewValue() != null) {
					basePart.setTargetTemplate(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTargetTemplate("");
				}
			}
            // Start of user code for onError live update
            if (EsbPackage.eINSTANCE.getCallTemplateMediator_OnError().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject) && basePart != null
                    && isAccessible(EsbViewsRepository.CallTemplateMediator.Properties.onError)) {
                if (msg.getNewValue() != null) {
                    basePart.setOnError((RegistryKeyProperty) msg.getNewValue());
                } else {
                    basePart.setOnError(EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty());
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
			EsbPackage.eINSTANCE.getCallTemplateMediator_AvailableTemplates(),
			EsbPackage.eINSTANCE.getCallTemplateMediator_TemplateParameters(),
			EsbPackage.eINSTANCE.getCallTemplateMediator_TargetTemplate(),
			EsbPackage.eINSTANCE.getCallTemplateMediator_OnError()		);
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
				if (EsbViewsRepository.CallTemplateMediator.Properties.description == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.CallTemplateMediator.Properties.commentsList == event.getAffectedEditor()) {
					BasicDiagnostic chain = new BasicDiagnostic();
					for (Iterator iterator = ((List)event.getNewValue()).iterator(); iterator.hasNext();) {
						chain.add(Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEAttributeType(), iterator.next()));
					}
					ret = chain;
				}
				if (EsbViewsRepository.CallTemplateMediator.Properties.reverse == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMediator_Reverse().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMediator_Reverse().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.CallTemplateMediator.Properties.availableTemplates == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getCallTemplateMediator_AvailableTemplates().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getCallTemplateMediator_AvailableTemplates().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.CallTemplateMediator.Properties.targetTemplate == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getCallTemplateMediator_TargetTemplate().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getCallTemplateMediator_TargetTemplate().getEAttributeType(), newValue);
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
