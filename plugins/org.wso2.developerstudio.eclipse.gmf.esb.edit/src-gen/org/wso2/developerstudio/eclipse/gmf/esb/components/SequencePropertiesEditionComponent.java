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

import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.KeyType;
import org.wso2.developerstudio.eclipse.gmf.esb.Mediator;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.Sequence;
import org.wso2.developerstudio.eclipse.gmf.esb.SequenceOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.SequencePropertiesEditionPart;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;


// End of user code

/**
 * 
 * 
 */
public class SequencePropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	/**
	 * Settings for outputConnector ReferencesTable
	 */
	protected ReferencesTableSettings outputConnectorSettings;
	
	/**
	 * Settings for includedMediators ReferencesTable
	 */
	protected ReferencesTableSettings includedMediatorsSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public SequencePropertiesEditionComponent(PropertiesEditingContext editingContext, EObject sequence, String editing_mode) {
		super(editingContext, sequence, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EsbViewsRepository.class;
		partKey = EsbViewsRepository.Sequence.class;
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
			
			final Sequence sequence = (Sequence)elt;
			final SequencePropertiesEditionPart basePart = (SequencePropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EsbViewsRepository.Sequence.Properties.description))
				basePart.setDescription(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, sequence.getDescription()));
			
			if (isAccessible(EsbViewsRepository.Sequence.Properties.commentsList))
				basePart.setCommentsList(sequence.getCommentsList());
			
			if (isAccessible(EsbViewsRepository.Sequence.Properties.reverse)) {
				basePart.setReverse(sequence.isReverse());
			}
			if (isAccessible(EsbViewsRepository.Sequence.Properties.name))
				basePart.setName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, sequence.getName()));
			
			if (isAccessible(EsbViewsRepository.Sequence.Properties.key))
				basePart.setKey(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, sequence.getKey()));
			
			if (isAccessible(EsbViewsRepository.Sequence.Properties.outputConnector)) {
				outputConnectorSettings = new ReferencesTableSettings(sequence, EsbPackage.eINSTANCE.getSequence_OutputConnector());
				basePart.initOutputConnector(outputConnectorSettings);
			}
			if (isAccessible(EsbViewsRepository.Sequence.Properties.includedMediators)) {
				includedMediatorsSettings = new ReferencesTableSettings(sequence, EsbPackage.eINSTANCE.getSequence_IncludedMediators());
				basePart.initIncludedMediators(includedMediatorsSettings);
			}
			if (isAccessible(EsbViewsRepository.Sequence.Properties.receiveSequence)) {
				basePart.setReceiveSequence(sequence.isReceiveSequence());
			}
			if (isAccessible(EsbViewsRepository.Sequence.Properties.duplicate)) {
				basePart.setDuplicate(sequence.isDuplicate());
			}
			if (isAccessible(EsbViewsRepository.Sequence.Properties.referringSequenceType)) {
				basePart.initReferringSequenceType(EEFUtils.choiceOfValues(sequence, EsbPackage.eINSTANCE.getSequence_ReferringSequenceType()), sequence.getReferringSequenceType());
			}
			// Start of user code  for staticReferenceKey command update
			if (isAccessible(EsbViewsRepository.Sequence.Properties.staticReferenceKey)) {
				basePart.setStaticReferenceKey(sequence.getStaticReferenceKey());
			}
			// End of user code
			
			// Start of user code  for dynamicReferenceKey command update
			if (isAccessible(EsbViewsRepository.Sequence.Properties.dynamicReferenceKey)) {
				basePart.setDynamicReferenceKey(sequence.getDynamicReferenceKey());
			}
			// End of user code
			
			// init filters
			
			
			
			
			
			if (isAccessible(EsbViewsRepository.Sequence.Properties.outputConnector)) {
				basePart.addFilterToOutputConnector(new ViewerFilter() {
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof SequenceOutputConnector); //$NON-NLS-1$ 
					}
			
				});
				// Start of user code for additional businessfilters for outputConnector
				// End of user code
			}
			if (isAccessible(EsbViewsRepository.Sequence.Properties.includedMediators)) {
				basePart.addFilterToIncludedMediators(new ViewerFilter() {
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof Mediator); //$NON-NLS-1$ 
					}
			
				});
				// Start of user code for additional businessfilters for includedMediators
				// End of user code
			}
			
			
			
			// Start of user code  for staticReferenceKey filter update
			// End of user code
			
			// Start of user code  for dynamicReferenceKey filter update
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
		if (editorKey == EsbViewsRepository.Sequence.Properties.description) {
			return EsbPackage.eINSTANCE.getEsbElement_Description();
		}
		if (editorKey == EsbViewsRepository.Sequence.Properties.commentsList) {
			return EsbPackage.eINSTANCE.getEsbElement_CommentsList();
		}
		if (editorKey == EsbViewsRepository.Sequence.Properties.reverse) {
			return EsbPackage.eINSTANCE.getMediator_Reverse();
		}
		if (editorKey == EsbViewsRepository.Sequence.Properties.name) {
			return EsbPackage.eINSTANCE.getSequence_Name();
		}
		if (editorKey == EsbViewsRepository.Sequence.Properties.key) {
			return EsbPackage.eINSTANCE.getSequence_Key();
		}
		if (editorKey == EsbViewsRepository.Sequence.Properties.outputConnector) {
			return EsbPackage.eINSTANCE.getSequence_OutputConnector();
		}
		if (editorKey == EsbViewsRepository.Sequence.Properties.includedMediators) {
			return EsbPackage.eINSTANCE.getSequence_IncludedMediators();
		}
		if (editorKey == EsbViewsRepository.Sequence.Properties.receiveSequence) {
			return EsbPackage.eINSTANCE.getSequence_ReceiveSequence();
		}
		if (editorKey == EsbViewsRepository.Sequence.Properties.duplicate) {
			return EsbPackage.eINSTANCE.getSequence_Duplicate();
		}
		if (editorKey == EsbViewsRepository.Sequence.Properties.referringSequenceType) {
			return EsbPackage.eINSTANCE.getSequence_ReferringSequenceType();
		}
		if (editorKey == EsbViewsRepository.Sequence.Properties.staticReferenceKey) {
			return EsbPackage.eINSTANCE.getSequence_StaticReferenceKey();
		}
		if (editorKey == EsbViewsRepository.Sequence.Properties.dynamicReferenceKey) {
			return EsbPackage.eINSTANCE.getSequence_DynamicReferenceKey();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		Sequence sequence = (Sequence)semanticObject;
		if (EsbViewsRepository.Sequence.Properties.description == event.getAffectedEditor()) {
			sequence.setDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.Sequence.Properties.commentsList == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				sequence.getCommentsList().clear();
				sequence.getCommentsList().addAll(((EList) event.getNewValue()));
			}
		}
		if (EsbViewsRepository.Sequence.Properties.reverse == event.getAffectedEditor()) {
			sequence.setReverse((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.Sequence.Properties.name == event.getAffectedEditor()) {
			sequence.setName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.Sequence.Properties.key == event.getAffectedEditor()) {
			sequence.setKey((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.Sequence.Properties.outputConnector == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, outputConnectorSettings, editingContext.getAdapterFactory());
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
				outputConnectorSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				outputConnectorSettings.move(event.getNewIndex(), (SequenceOutputConnector) event.getNewValue());
			}
		}
		if (EsbViewsRepository.Sequence.Properties.includedMediators == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, includedMediatorsSettings, editingContext.getAdapterFactory());
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
				includedMediatorsSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				includedMediatorsSettings.move(event.getNewIndex(), (Mediator) event.getNewValue());
			}
		}
		if (EsbViewsRepository.Sequence.Properties.receiveSequence == event.getAffectedEditor()) {
			sequence.setReceiveSequence((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.Sequence.Properties.duplicate == event.getAffectedEditor()) {
			sequence.setDuplicate((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.Sequence.Properties.referringSequenceType == event.getAffectedEditor()) {
			sequence.setReferringSequenceType((KeyType)event.getNewValue());
		}
		if (EsbViewsRepository.Sequence.Properties.staticReferenceKey == event.getAffectedEditor()) {
			// Start of user code for updateStaticReferenceKey method body
			if (event.getNewValue() != null) {
				RegistryKeyProperty rkp = (RegistryKeyProperty) event.getNewValue();
				sequence.setStaticReferenceKey(rkp);
			} else {
				sequence.setStaticReferenceKey(EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty());
			}
			// End of user code
			
		}
		if (EsbViewsRepository.Sequence.Properties.dynamicReferenceKey == event.getAffectedEditor()) {
			// Start of user code for updateDynamicReferenceKey method body
			if (event.getNewValue() != null) {
                NamespacedProperty nsp = (NamespacedProperty) event.getNewValue();
                sequence.setDynamicReferenceKey(nsp);
            } else {
            	sequence.setDynamicReferenceKey(EsbFactoryImpl.eINSTANCE.createNamespacedProperty());
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
			SequencePropertiesEditionPart basePart = (SequencePropertiesEditionPart)editingPart;
			if (EsbPackage.eINSTANCE.getEsbElement_Description().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.Sequence.Properties.description)) {
				if (msg.getNewValue() != null) {
					basePart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setDescription("");
				}
			}
			if (EsbPackage.eINSTANCE.getEsbElement_CommentsList().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.Sequence.Properties.commentsList)) {
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
			
			if (EsbPackage.eINSTANCE.getMediator_Reverse().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.Sequence.Properties.reverse))
				basePart.setReverse((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getSequence_Name().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.Sequence.Properties.name)) {
				if (msg.getNewValue() != null) {
					basePart.setName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setName("");
				}
			}
			if (EsbPackage.eINSTANCE.getSequence_Key().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.Sequence.Properties.key)) {
				if (msg.getNewValue() != null) {
					basePart.setKey(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setKey("");
				}
			}
			if (EsbPackage.eINSTANCE.getSequence_OutputConnector().equals(msg.getFeature()) && isAccessible(EsbViewsRepository.Sequence.Properties.outputConnector))
				basePart.updateOutputConnector();
			if (EsbPackage.eINSTANCE.getSequence_IncludedMediators().equals(msg.getFeature()) && isAccessible(EsbViewsRepository.Sequence.Properties.includedMediators))
				basePart.updateIncludedMediators();
			if (EsbPackage.eINSTANCE.getSequence_ReceiveSequence().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.Sequence.Properties.receiveSequence))
				basePart.setReceiveSequence((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getSequence_Duplicate().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.Sequence.Properties.duplicate))
				basePart.setDuplicate((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getSequence_ReferringSequenceType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.Sequence.Properties.referringSequenceType))
				basePart.setReferringSequenceType((KeyType)msg.getNewValue());
			
					// Start of user code for staticReferenceKey live update
			if (EsbPackage.eINSTANCE.getSequence_StaticReferenceKey().equals(msg.getFeature())
					&& msg.getNotifier().equals(semanticObject) && basePart != null
					&& isAccessible(EsbViewsRepository.Sequence.Properties.staticReferenceKey)) {
				if (msg.getNewValue() != null) {
					basePart.setStaticReferenceKey((RegistryKeyProperty) msg.getNewValue());
				} else {
					basePart.setStaticReferenceKey(EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty());
				}
			}
					// End of user code
			
					// Start of user code for dynamicReferenceKey live update
			if (EsbPackage.eINSTANCE.getSequence_DynamicReferenceKey().equals(msg.getFeature())
					&& msg.getNotifier().equals(semanticObject) && basePart != null
					&& isAccessible(EsbViewsRepository.Sequence.Properties.dynamicReferenceKey)) {
				if (msg.getNewValue() != null) {
					basePart.setDynamicReferenceKey((NamespacedProperty) msg.getNewValue());
				} else {
					basePart.setDynamicReferenceKey(EsbFactoryImpl.eINSTANCE.createNamespacedProperty());
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
			EsbPackage.eINSTANCE.getSequence_Name(),
			EsbPackage.eINSTANCE.getSequence_Key(),
			EsbPackage.eINSTANCE.getSequence_OutputConnector(),
			EsbPackage.eINSTANCE.getSequence_IncludedMediators(),
			EsbPackage.eINSTANCE.getSequence_ReceiveSequence(),
			EsbPackage.eINSTANCE.getSequence_Duplicate(),
			EsbPackage.eINSTANCE.getSequence_ReferringSequenceType(),
			EsbPackage.eINSTANCE.getSequence_StaticReferenceKey(),
			EsbPackage.eINSTANCE.getSequence_DynamicReferenceKey()		);
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
				if (EsbViewsRepository.Sequence.Properties.description == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.Sequence.Properties.commentsList == event.getAffectedEditor()) {
					BasicDiagnostic chain = new BasicDiagnostic();
					for (Iterator iterator = ((List)event.getNewValue()).iterator(); iterator.hasNext();) {
						chain.add(Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEAttributeType(), iterator.next()));
					}
					ret = chain;
				}
				if (EsbViewsRepository.Sequence.Properties.reverse == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMediator_Reverse().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMediator_Reverse().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.Sequence.Properties.name == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getSequence_Name().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getSequence_Name().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.Sequence.Properties.key == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getSequence_Key().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getSequence_Key().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.Sequence.Properties.receiveSequence == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getSequence_ReceiveSequence().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getSequence_ReceiveSequence().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.Sequence.Properties.duplicate == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getSequence_Duplicate().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getSequence_Duplicate().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.Sequence.Properties.referringSequenceType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getSequence_ReferringSequenceType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getSequence_ReferringSequenceType().getEAttributeType(), newValue);
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
