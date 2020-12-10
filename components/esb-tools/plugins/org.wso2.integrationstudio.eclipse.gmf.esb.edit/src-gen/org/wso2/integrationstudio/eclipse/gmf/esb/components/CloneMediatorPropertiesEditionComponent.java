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

import org.wso2.integrationstudio.eclipse.gmf.esb.CloneMediator;
import org.wso2.integrationstudio.eclipse.gmf.esb.CloneMediatorTargetOutputConnector;
import org.wso2.integrationstudio.eclipse.gmf.esb.CloneTarget;
import org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage;

import org.wso2.integrationstudio.eclipse.gmf.esb.parts.CloneMediatorPropertiesEditionPart;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.integrationstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;


// End of user code

/**
 * 
 * 
 */
public class CloneMediatorPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	/**
	 * Settings for targets ReferencesTable
	 */
	protected ReferencesTableSettings targetsSettings;
	
	/**
	 * Settings for targetsOutputConnector ReferencesTable
	 */
	protected ReferencesTableSettings targetsOutputConnectorSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public CloneMediatorPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject cloneMediator, String editing_mode) {
		super(editingContext, cloneMediator, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EsbViewsRepository.class;
		partKey = EsbViewsRepository.CloneMediator.class;
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
			
			final CloneMediator cloneMediator = (CloneMediator)elt;
			final CloneMediatorPropertiesEditionPart basePart = (CloneMediatorPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EsbViewsRepository.CloneMediator.Properties.description))
				basePart.setDescription(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, cloneMediator.getDescription()));
			
			if (isAccessible(EsbViewsRepository.CloneMediator.Properties.commentsList))
				basePart.setCommentsList(cloneMediator.getCommentsList());
			
			if (isAccessible(EsbViewsRepository.CloneMediator.Properties.reverse)) {
				basePart.setReverse(cloneMediator.isReverse());
			}
			if (isAccessible(EsbViewsRepository.CloneMediator.Properties.cloneID))
				basePart.setCloneID(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, cloneMediator.getCloneID()));
			
			if (isAccessible(EsbViewsRepository.CloneMediator.Properties.sequentialMediation)) {
				basePart.setSequentialMediation(cloneMediator.isSequentialMediation());
			}
			if (isAccessible(EsbViewsRepository.CloneMediator.Properties.continueParent)) {
				basePart.setContinueParent(cloneMediator.isContinueParent());
			}
			if (isAccessible(EsbViewsRepository.CloneMediator.Properties.targets)) {
				targetsSettings = new ReferencesTableSettings(cloneMediator, EsbPackage.eINSTANCE.getCloneMediator_Targets());
				basePart.initTargets(targetsSettings);
			}
			if (isAccessible(EsbViewsRepository.CloneMediator.Properties.targetsOutputConnector)) {
				targetsOutputConnectorSettings = new ReferencesTableSettings(cloneMediator, EsbPackage.eINSTANCE.getCloneMediator_TargetsOutputConnector());
				basePart.initTargetsOutputConnector(targetsOutputConnectorSettings);
			}
			// init filters
			
			
			
			
			
			
			if (isAccessible(EsbViewsRepository.CloneMediator.Properties.targets)) {
				basePart.addFilterToTargets(new ViewerFilter() {
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof CloneTarget); //$NON-NLS-1$ 
					}
			
				});
				// Start of user code for additional businessfilters for targets
				// End of user code
			}
			if (isAccessible(EsbViewsRepository.CloneMediator.Properties.targetsOutputConnector)) {
				basePart.addFilterToTargetsOutputConnector(new ViewerFilter() {
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof CloneMediatorTargetOutputConnector); //$NON-NLS-1$ 
					}
			
				});
				// Start of user code for additional businessfilters for targetsOutputConnector
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
		if (editorKey == EsbViewsRepository.CloneMediator.Properties.description) {
			return EsbPackage.eINSTANCE.getEsbElement_Description();
		}
		if (editorKey == EsbViewsRepository.CloneMediator.Properties.commentsList) {
			return EsbPackage.eINSTANCE.getEsbElement_CommentsList();
		}
		if (editorKey == EsbViewsRepository.CloneMediator.Properties.reverse) {
			return EsbPackage.eINSTANCE.getMediator_Reverse();
		}
		if (editorKey == EsbViewsRepository.CloneMediator.Properties.cloneID) {
			return EsbPackage.eINSTANCE.getCloneMediator_CloneID();
		}
		if (editorKey == EsbViewsRepository.CloneMediator.Properties.sequentialMediation) {
			return EsbPackage.eINSTANCE.getCloneMediator_SequentialMediation();
		}
		if (editorKey == EsbViewsRepository.CloneMediator.Properties.continueParent) {
			return EsbPackage.eINSTANCE.getCloneMediator_ContinueParent();
		}
		if (editorKey == EsbViewsRepository.CloneMediator.Properties.targets) {
			return EsbPackage.eINSTANCE.getCloneMediator_Targets();
		}
		if (editorKey == EsbViewsRepository.CloneMediator.Properties.targetsOutputConnector) {
			return EsbPackage.eINSTANCE.getCloneMediator_TargetsOutputConnector();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		CloneMediator cloneMediator = (CloneMediator)semanticObject;
		if (EsbViewsRepository.CloneMediator.Properties.description == event.getAffectedEditor()) {
			cloneMediator.setDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.CloneMediator.Properties.commentsList == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				cloneMediator.getCommentsList().clear();
				cloneMediator.getCommentsList().addAll(((EList) event.getNewValue()));
			}
		}
		if (EsbViewsRepository.CloneMediator.Properties.reverse == event.getAffectedEditor()) {
			cloneMediator.setReverse((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.CloneMediator.Properties.cloneID == event.getAffectedEditor()) {
			cloneMediator.setCloneID((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.CloneMediator.Properties.sequentialMediation == event.getAffectedEditor()) {
			cloneMediator.setSequentialMediation((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.CloneMediator.Properties.continueParent == event.getAffectedEditor()) {
			cloneMediator.setContinueParent((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.CloneMediator.Properties.targets == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, targetsSettings, editingContext.getAdapterFactory());
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
				targetsSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				targetsSettings.move(event.getNewIndex(), (CloneTarget) event.getNewValue());
			}
		}
		if (EsbViewsRepository.CloneMediator.Properties.targetsOutputConnector == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, targetsOutputConnectorSettings, editingContext.getAdapterFactory());
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
				targetsOutputConnectorSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				targetsOutputConnectorSettings.move(event.getNewIndex(), (CloneMediatorTargetOutputConnector) event.getNewValue());
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			CloneMediatorPropertiesEditionPart basePart = (CloneMediatorPropertiesEditionPart)editingPart;
			if (EsbPackage.eINSTANCE.getEsbElement_Description().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.CloneMediator.Properties.description)) {
				if (msg.getNewValue() != null) {
					basePart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setDescription("");
				}
			}
			if (EsbPackage.eINSTANCE.getEsbElement_CommentsList().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.CloneMediator.Properties.commentsList)) {
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
			
			if (EsbPackage.eINSTANCE.getMediator_Reverse().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.CloneMediator.Properties.reverse))
				basePart.setReverse((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getCloneMediator_CloneID().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.CloneMediator.Properties.cloneID)) {
				if (msg.getNewValue() != null) {
					basePart.setCloneID(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setCloneID("");
				}
			}
			if (EsbPackage.eINSTANCE.getCloneMediator_SequentialMediation().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.CloneMediator.Properties.sequentialMediation))
				basePart.setSequentialMediation((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getCloneMediator_ContinueParent().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.CloneMediator.Properties.continueParent))
				basePart.setContinueParent((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getCloneMediator_Targets().equals(msg.getFeature()) && isAccessible(EsbViewsRepository.CloneMediator.Properties.targets))
				basePart.updateTargets();
			if (EsbPackage.eINSTANCE.getCloneMediator_TargetsOutputConnector().equals(msg.getFeature()) && isAccessible(EsbViewsRepository.CloneMediator.Properties.targetsOutputConnector))
				basePart.updateTargetsOutputConnector();
			
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
			EsbPackage.eINSTANCE.getCloneMediator_CloneID(),
			EsbPackage.eINSTANCE.getCloneMediator_SequentialMediation(),
			EsbPackage.eINSTANCE.getCloneMediator_ContinueParent(),
			EsbPackage.eINSTANCE.getCloneMediator_Targets(),
			EsbPackage.eINSTANCE.getCloneMediator_TargetsOutputConnector()		);
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
				if (EsbViewsRepository.CloneMediator.Properties.description == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.CloneMediator.Properties.commentsList == event.getAffectedEditor()) {
					BasicDiagnostic chain = new BasicDiagnostic();
					for (Iterator iterator = ((List)event.getNewValue()).iterator(); iterator.hasNext();) {
						chain.add(Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEAttributeType(), iterator.next()));
					}
					ret = chain;
				}
				if (EsbViewsRepository.CloneMediator.Properties.reverse == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMediator_Reverse().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMediator_Reverse().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.CloneMediator.Properties.cloneID == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getCloneMediator_CloneID().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getCloneMediator_CloneID().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.CloneMediator.Properties.sequentialMediation == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getCloneMediator_SequentialMediation().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getCloneMediator_SequentialMediation().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.CloneMediator.Properties.continueParent == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getCloneMediator_ContinueParent().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getCloneMediator_ContinueParent().getEAttributeType(), newValue);
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
