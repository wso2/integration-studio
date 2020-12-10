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

import org.wso2.integrationstudio.eclipse.gmf.esb.CloneMediatorTargetOutputConnector;
import org.wso2.integrationstudio.eclipse.gmf.esb.CommentMediator;
import org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage;

import org.wso2.integrationstudio.eclipse.gmf.esb.parts.CloneMediatorTargetOutputConnectorPropertiesEditionPart;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EsbViewsRepository;


// End of user code

/**
 * 
 * 
 */
public class CloneMediatorTargetOutputConnectorPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	/**
	 * Settings for commentMediators ReferencesTable
	 */
	protected ReferencesTableSettings commentMediatorsSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public CloneMediatorTargetOutputConnectorPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject cloneMediatorTargetOutputConnector, String editing_mode) {
		super(editingContext, cloneMediatorTargetOutputConnector, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EsbViewsRepository.class;
		partKey = EsbViewsRepository.CloneMediatorTargetOutputConnector.class;
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
			
			final CloneMediatorTargetOutputConnector cloneMediatorTargetOutputConnector = (CloneMediatorTargetOutputConnector)elt;
			final CloneMediatorTargetOutputConnectorPropertiesEditionPart basePart = (CloneMediatorTargetOutputConnectorPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EsbViewsRepository.CloneMediatorTargetOutputConnector.Properties.commentMediators)) {
				commentMediatorsSettings = new ReferencesTableSettings(cloneMediatorTargetOutputConnector, EsbPackage.eINSTANCE.getOutputConnector_CommentMediators());
				basePart.initCommentMediators(commentMediatorsSettings);
			}
			if (isAccessible(EsbViewsRepository.CloneMediatorTargetOutputConnector.Properties.soapAction))
				basePart.setSoapAction(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, cloneMediatorTargetOutputConnector.getSoapAction()));
			
			if (isAccessible(EsbViewsRepository.CloneMediatorTargetOutputConnector.Properties.toAddress))
				basePart.setToAddress(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, cloneMediatorTargetOutputConnector.getToAddress()));
			
			// init filters
			if (isAccessible(EsbViewsRepository.CloneMediatorTargetOutputConnector.Properties.commentMediators)) {
				basePart.addFilterToCommentMediators(new ViewerFilter() {
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof CommentMediator); //$NON-NLS-1$ 
					}
			
				});
				// Start of user code for additional businessfilters for commentMediators
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
		if (editorKey == EsbViewsRepository.CloneMediatorTargetOutputConnector.Properties.commentMediators) {
			return EsbPackage.eINSTANCE.getOutputConnector_CommentMediators();
		}
		if (editorKey == EsbViewsRepository.CloneMediatorTargetOutputConnector.Properties.soapAction) {
			return EsbPackage.eINSTANCE.getCloneMediatorTargetOutputConnector_SoapAction();
		}
		if (editorKey == EsbViewsRepository.CloneMediatorTargetOutputConnector.Properties.toAddress) {
			return EsbPackage.eINSTANCE.getCloneMediatorTargetOutputConnector_ToAddress();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		CloneMediatorTargetOutputConnector cloneMediatorTargetOutputConnector = (CloneMediatorTargetOutputConnector)semanticObject;
		if (EsbViewsRepository.CloneMediatorTargetOutputConnector.Properties.commentMediators == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, commentMediatorsSettings, editingContext.getAdapterFactory());
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
				commentMediatorsSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				commentMediatorsSettings.move(event.getNewIndex(), (CommentMediator) event.getNewValue());
			}
		}
		if (EsbViewsRepository.CloneMediatorTargetOutputConnector.Properties.soapAction == event.getAffectedEditor()) {
			cloneMediatorTargetOutputConnector.setSoapAction((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.CloneMediatorTargetOutputConnector.Properties.toAddress == event.getAffectedEditor()) {
			cloneMediatorTargetOutputConnector.setToAddress((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			CloneMediatorTargetOutputConnectorPropertiesEditionPart basePart = (CloneMediatorTargetOutputConnectorPropertiesEditionPart)editingPart;
			if (EsbPackage.eINSTANCE.getOutputConnector_CommentMediators().equals(msg.getFeature()) && isAccessible(EsbViewsRepository.CloneMediatorTargetOutputConnector.Properties.commentMediators))
				basePart.updateCommentMediators();
			if (EsbPackage.eINSTANCE.getCloneMediatorTargetOutputConnector_SoapAction().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.CloneMediatorTargetOutputConnector.Properties.soapAction)) {
				if (msg.getNewValue() != null) {
					basePart.setSoapAction(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setSoapAction("");
				}
			}
			if (EsbPackage.eINSTANCE.getCloneMediatorTargetOutputConnector_ToAddress().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.CloneMediatorTargetOutputConnector.Properties.toAddress)) {
				if (msg.getNewValue() != null) {
					basePart.setToAddress(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setToAddress("");
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
			EsbPackage.eINSTANCE.getOutputConnector_CommentMediators(),
			EsbPackage.eINSTANCE.getCloneMediatorTargetOutputConnector_SoapAction(),
			EsbPackage.eINSTANCE.getCloneMediatorTargetOutputConnector_ToAddress()		);
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
				if (EsbViewsRepository.CloneMediatorTargetOutputConnector.Properties.soapAction == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getCloneMediatorTargetOutputConnector_SoapAction().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getCloneMediatorTargetOutputConnector_SoapAction().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.CloneMediatorTargetOutputConnector.Properties.toAddress == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getCloneMediatorTargetOutputConnector_ToAddress().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getCloneMediatorTargetOutputConnector_ToAddress().getEAttributeType(), newValue);
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
