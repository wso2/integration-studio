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

import org.eclipse.emf.eef.runtime.context.impl.EObjectPropertiesEditionContext;

import org.eclipse.emf.eef.runtime.impl.components.SinglePartPropertiesEditingComponent;

import org.eclipse.emf.eef.runtime.impl.filters.EObjectFilter;

import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;

import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy;

import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;

import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;

import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.Mediator;
import org.wso2.developerstudio.eclipse.gmf.esb.MediatorSequence;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;

import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.MediatorSequencePropertiesEditionPart;


// End of user code

/**
 * 
 * 
 */
public class MediatorSequencePropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	/**
	 * Settings for mediators ReferencesTable
	 */
	private ReferencesTableSettings mediatorsSettings;
	
	/**
	 * Settings for onError EObjectFlatComboViewer
	 */
	private EObjectFlatComboSettings onErrorSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public MediatorSequencePropertiesEditionComponent(PropertiesEditingContext editingContext, EObject mediatorSequence, String editing_mode) {
		super(editingContext, mediatorSequence, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EsbViewsRepository.class;
		partKey = EsbViewsRepository.MediatorSequence.class;
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
			
			final MediatorSequence mediatorSequence = (MediatorSequence)elt;
			final MediatorSequencePropertiesEditionPart basePart = (MediatorSequencePropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EsbViewsRepository.MediatorSequence.Properties.anonymous)) {
				basePart.setAnonymous(mediatorSequence.isAnonymous());
			}
			if (isAccessible(EsbViewsRepository.MediatorSequence.Properties.sequenceName))
				basePart.setSequenceName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, mediatorSequence.getSequenceName()));
			
			if (isAccessible(EsbViewsRepository.MediatorSequence.Properties.mediators)) {
				mediatorsSettings = new ReferencesTableSettings(mediatorSequence, EsbPackage.eINSTANCE.getMediatorSequence_Mediators());
				basePart.initMediators(mediatorsSettings);
			}
			if (isAccessible(EsbViewsRepository.MediatorSequence.Properties.onError)) {
				// init part
				onErrorSettings = new EObjectFlatComboSettings(mediatorSequence, EsbPackage.eINSTANCE.getMediatorSequence_OnError());
				basePart.initOnError(onErrorSettings);
				// set the button mode
				basePart.setOnErrorButtonMode(ButtonsModeEnum.BROWSE);
			}
			if (isAccessible(EsbViewsRepository.MediatorSequence.Properties.description))
				basePart.setDescription(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, mediatorSequence.getDescription()));
			
			// init filters
			
			
			if (isAccessible(EsbViewsRepository.MediatorSequence.Properties.mediators)) {
				basePart.addFilterToMediators(new EObjectFilter(EsbPackage.Literals.MEDIATOR));
				// Start of user code for additional businessfilters for mediators
				// End of user code
			}
			if (isAccessible(EsbViewsRepository.MediatorSequence.Properties.onError)) {
				basePart.addFilterToOnError(new ViewerFilter() {
				
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof RegistryKeyProperty); //$NON-NLS-1$ 
					}
					
				});
				// Start of user code for additional businessfilters for onError
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
		if (editorKey == EsbViewsRepository.MediatorSequence.Properties.anonymous) {
			return EsbPackage.eINSTANCE.getMediatorSequence_Anonymous();
		}
		if (editorKey == EsbViewsRepository.MediatorSequence.Properties.sequenceName) {
			return EsbPackage.eINSTANCE.getMediatorSequence_SequenceName();
		}
		if (editorKey == EsbViewsRepository.MediatorSequence.Properties.mediators) {
			return EsbPackage.eINSTANCE.getMediatorSequence_Mediators();
		}
		if (editorKey == EsbViewsRepository.MediatorSequence.Properties.onError) {
			return EsbPackage.eINSTANCE.getMediatorSequence_OnError();
		}
		if (editorKey == EsbViewsRepository.MediatorSequence.Properties.description) {
			return EsbPackage.eINSTANCE.getMediatorSequence_Description();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		MediatorSequence mediatorSequence = (MediatorSequence)semanticObject;
		if (EsbViewsRepository.MediatorSequence.Properties.anonymous == event.getAffectedEditor()) {
			mediatorSequence.setAnonymous((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.MediatorSequence.Properties.sequenceName == event.getAffectedEditor()) {
			mediatorSequence.setSequenceName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.MediatorSequence.Properties.mediators == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				if (event.getNewValue() instanceof Mediator) {
					mediatorsSettings.addToReference((EObject) event.getNewValue());
				}
			} else if (event.getKind() == PropertiesEditionEvent.REMOVE) {
				mediatorsSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				mediatorsSettings.move(event.getNewIndex(), (Mediator) event.getNewValue());
			}
		}
		if (EsbViewsRepository.MediatorSequence.Properties.onError == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				onErrorSettings.setToReference((RegistryKeyProperty)event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.ADD) {
				RegistryKeyProperty eObject = EsbFactory.eINSTANCE.createRegistryKeyProperty();
				EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(editingContext, this, eObject, editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(eObject, PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy policy = provider.getPolicy(context);
					if (policy != null) {
						policy.execute();
					}
				}
				onErrorSettings.setToReference(eObject);
			}
		}
		if (EsbViewsRepository.MediatorSequence.Properties.description == event.getAffectedEditor()) {
			mediatorSequence.setDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			MediatorSequencePropertiesEditionPart basePart = (MediatorSequencePropertiesEditionPart)editingPart;
			if (EsbPackage.eINSTANCE.getMediatorSequence_Anonymous().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.MediatorSequence.Properties.anonymous))
				basePart.setAnonymous((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getMediatorSequence_SequenceName().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.MediatorSequence.Properties.sequenceName)) {
				if (msg.getNewValue() != null) {
					basePart.setSequenceName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setSequenceName("");
				}
			}
			if (EsbPackage.eINSTANCE.getMediatorSequence_Mediators().equals(msg.getFeature())  && isAccessible(EsbViewsRepository.MediatorSequence.Properties.mediators))
				basePart.updateMediators();
			if (EsbPackage.eINSTANCE.getMediatorSequence_OnError().equals(msg.getFeature()) && basePart != null && isAccessible(EsbViewsRepository.MediatorSequence.Properties.onError))
				basePart.setOnError((EObject)msg.getNewValue());
			if (EsbPackage.eINSTANCE.getMediatorSequence_Description().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.MediatorSequence.Properties.description)) {
				if (msg.getNewValue() != null) {
					basePart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setDescription("");
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
			EsbPackage.eINSTANCE.getMediatorSequence_Anonymous(),
			EsbPackage.eINSTANCE.getMediatorSequence_SequenceName(),
			EsbPackage.eINSTANCE.getMediatorSequence_Mediators(),
			EsbPackage.eINSTANCE.getMediatorSequence_OnError(),
			EsbPackage.eINSTANCE.getMediatorSequence_Description()		);
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
				if (EsbViewsRepository.MediatorSequence.Properties.anonymous == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMediatorSequence_Anonymous().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMediatorSequence_Anonymous().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.MediatorSequence.Properties.sequenceName == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMediatorSequence_SequenceName().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMediatorSequence_SequenceName().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.MediatorSequence.Properties.description == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMediatorSequence_Description().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMediatorSequence_Description().getEAttributeType(), newValue);
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
