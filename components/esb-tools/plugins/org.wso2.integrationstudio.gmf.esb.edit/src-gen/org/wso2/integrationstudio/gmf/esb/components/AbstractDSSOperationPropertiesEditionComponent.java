/**
 * Generated with Acceleo
 */
package org.wso2.integrationstudio.gmf.esb.components;

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

import org.wso2.integrationstudio.gmf.esb.AbstractDSSOperation;
import org.wso2.integrationstudio.gmf.esb.DSSoperationProperty;
import org.wso2.integrationstudio.gmf.esb.EsbPackage;

import org.wso2.integrationstudio.gmf.esb.parts.AbstractDSSOperationPropertiesEditionPart;
import org.wso2.integrationstudio.gmf.esb.parts.EsbViewsRepository;


// End of user code

/**
 * 
 * 
 */
public class AbstractDSSOperationPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	/**
	 * Settings for DSSPrperties ReferencesTable
	 */
	protected ReferencesTableSettings dSSPrpertiesSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public AbstractDSSOperationPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject abstractDSSOperation, String editing_mode) {
		super(editingContext, abstractDSSOperation, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EsbViewsRepository.class;
		partKey = EsbViewsRepository.AbstractDSSOperation.class;
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
			
			final AbstractDSSOperation abstractDSSOperation = (AbstractDSSOperation)elt;
			final AbstractDSSOperationPropertiesEditionPart basePart = (AbstractDSSOperationPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EsbViewsRepository.AbstractDSSOperation.dSSPrperties)) {
				dSSPrpertiesSettings = new ReferencesTableSettings(abstractDSSOperation, EsbPackage.eINSTANCE.getAbstractDSSOperation_DSSPrperties());
				basePart.initDSSPrperties(dSSPrpertiesSettings);
			}
			if (isAccessible(EsbViewsRepository.AbstractDSSOperation.operationName))
				basePart.setOperationName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, abstractDSSOperation.getOperationName()));
			
			// init filters
			if (isAccessible(EsbViewsRepository.AbstractDSSOperation.dSSPrperties)) {
				basePart.addFilterToDSSPrperties(new ViewerFilter() {
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof DSSoperationProperty); //$NON-NLS-1$ 
					}
			
				});
				// Start of user code for additional businessfilters for DSSPrperties
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
		if (editorKey == EsbViewsRepository.AbstractDSSOperation.dSSPrperties) {
			return EsbPackage.eINSTANCE.getAbstractDSSOperation_DSSPrperties();
		}
		if (editorKey == EsbViewsRepository.AbstractDSSOperation.operationName) {
			return EsbPackage.eINSTANCE.getAbstractDSSOperation_OperationName();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		AbstractDSSOperation abstractDSSOperation = (AbstractDSSOperation)semanticObject;
		if (EsbViewsRepository.AbstractDSSOperation.dSSPrperties == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, dSSPrpertiesSettings, editingContext.getAdapterFactory());
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
				dSSPrpertiesSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				dSSPrpertiesSettings.move(event.getNewIndex(), (DSSoperationProperty) event.getNewValue());
			}
		}
		if (EsbViewsRepository.AbstractDSSOperation.operationName == event.getAffectedEditor()) {
			abstractDSSOperation.setOperationName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			AbstractDSSOperationPropertiesEditionPart basePart = (AbstractDSSOperationPropertiesEditionPart)editingPart;
			if (EsbPackage.eINSTANCE.getAbstractDSSOperation_DSSPrperties().equals(msg.getFeature()) && isAccessible(EsbViewsRepository.AbstractDSSOperation.dSSPrperties))
				basePart.updateDSSPrperties();
			if (EsbPackage.eINSTANCE.getAbstractDSSOperation_OperationName().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.AbstractDSSOperation.operationName)) {
				if (msg.getNewValue() != null) {
					basePart.setOperationName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setOperationName("");
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
			EsbPackage.eINSTANCE.getAbstractDSSOperation_DSSPrperties(),
			EsbPackage.eINSTANCE.getAbstractDSSOperation_OperationName()		);
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
				if (EsbViewsRepository.AbstractDSSOperation.operationName == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractDSSOperation_OperationName().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractDSSOperation_OperationName().getEAttributeType(), newValue);
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
