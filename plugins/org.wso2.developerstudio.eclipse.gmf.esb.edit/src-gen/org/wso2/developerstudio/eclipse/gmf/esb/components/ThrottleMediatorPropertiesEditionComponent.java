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
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.ThrottleMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.ThrottlePolicyEntry;
import org.wso2.developerstudio.eclipse.gmf.esb.ThrottlePolicyType;
import org.wso2.developerstudio.eclipse.gmf.esb.ThrottleSequenceType;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.ThrottleMediatorPropertiesEditionPart;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;


// End of user code

/**
 * 
 * 
 */
public class ThrottleMediatorPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	/**
	 * Settings for policyEntries ReferencesTable
	 */
	protected ReferencesTableSettings policyEntriesSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public ThrottleMediatorPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject throttleMediator, String editing_mode) {
		super(editingContext, throttleMediator, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EsbViewsRepository.class;
		partKey = EsbViewsRepository.ThrottleMediator.class;
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
			
			final ThrottleMediator throttleMediator = (ThrottleMediator)elt;
			final ThrottleMediatorPropertiesEditionPart basePart = (ThrottleMediatorPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EsbViewsRepository.ThrottleMediator.Misc.description))
				basePart.setDescription(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, throttleMediator.getDescription()));
			
			if (isAccessible(EsbViewsRepository.ThrottleMediator.General.commentsList))
				basePart.setCommentsList(throttleMediator.getCommentsList());
			
			if (isAccessible(EsbViewsRepository.ThrottleMediator.General.reverse)) {
				basePart.setReverse(throttleMediator.isReverse());
			}
			if (isAccessible(EsbViewsRepository.ThrottleMediator.General.groupId))
				basePart.setGroupId(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, throttleMediator.getGroupId()));
			
			if (isAccessible(EsbViewsRepository.ThrottleMediator.ThrottlePolicy.policyType)) {
				basePart.initPolicyType(EEFUtils.choiceOfValues(throttleMediator, EsbPackage.eINSTANCE.getThrottleMediator_PolicyType()), throttleMediator.getPolicyType());
			}
			if (isAccessible(EsbViewsRepository.ThrottleMediator.ThrottlePolicy.maxConcurrentAccessCount)) {
				basePart.setMaxConcurrentAccessCount(EEFConverterUtil.convertToString(EcorePackage.Literals.EINT, throttleMediator.getMaxConcurrentAccessCount()));
			}
			
			if (isAccessible(EsbViewsRepository.ThrottleMediator.ThrottlePolicy.policyEntries)) {
				policyEntriesSettings = new ReferencesTableSettings(throttleMediator, EsbPackage.eINSTANCE.getThrottleMediator_PolicyEntries());
				basePart.initPolicyEntries(policyEntriesSettings);
			}
			if (isAccessible(EsbViewsRepository.ThrottleMediator.OnAccept.onAcceptBranchsequenceType)) {
				basePart.initOnAcceptBranchsequenceType(EEFUtils.choiceOfValues(throttleMediator, EsbPackage.eINSTANCE.getThrottleMediator_OnAcceptBranchsequenceType()), throttleMediator.getOnAcceptBranchsequenceType());
			}
			if (isAccessible(EsbViewsRepository.ThrottleMediator.OnReject.onRejectBranchsequenceType)) {
				basePart.initOnRejectBranchsequenceType(EEFUtils.choiceOfValues(throttleMediator, EsbPackage.eINSTANCE.getThrottleMediator_OnRejectBranchsequenceType()), throttleMediator.getOnRejectBranchsequenceType());
			}
			// Start of user code  for OnAcceptBranchSequenceKey command update
            if (isAccessible(EsbViewsRepository.ThrottleMediator.OnAccept.onAcceptBranchSequenceKey)) {
                basePart.setOnAcceptBranchSequenceKey(throttleMediator.getOnAcceptBranchsequenceKey());
            }
			// End of user code
			
			// Start of user code  for OnRejectBranchSequenceKey command update
            if (isAccessible(EsbViewsRepository.ThrottleMediator.OnReject.onRejectBranchSequenceKey)) {
                basePart.setOnAcceptBranchSequenceKey(throttleMediator.getOnRejectBranchsequenceKey());
            }
			// End of user code
			
			// Start of user code  for policyKey command update
            if (isAccessible(EsbViewsRepository.ThrottleMediator.ThrottlePolicy.policyKey)) {
                basePart.setPolicyKey(throttleMediator.getPolicyKey());
            }
			// End of user code
			
			// init filters
			
			
			
			
			
			
			if (isAccessible(EsbViewsRepository.ThrottleMediator.ThrottlePolicy.policyEntries)) {
				basePart.addFilterToPolicyEntries(new ViewerFilter() {
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof ThrottlePolicyEntry); //$NON-NLS-1$ 
					}
			
				});
				// Start of user code for additional businessfilters for policyEntries
				// End of user code
			}
			
			
			// Start of user code  for OnAcceptBranchSequenceKey filter update
			// End of user code
			
			// Start of user code  for OnRejectBranchSequenceKey filter update
			// End of user code
			
			// Start of user code  for policyKey filter update
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
		if (editorKey == EsbViewsRepository.ThrottleMediator.Misc.description) {
			return EsbPackage.eINSTANCE.getEsbElement_Description();
		}
		if (editorKey == EsbViewsRepository.ThrottleMediator.General.commentsList) {
			return EsbPackage.eINSTANCE.getEsbElement_CommentsList();
		}
		if (editorKey == EsbViewsRepository.ThrottleMediator.General.reverse) {
			return EsbPackage.eINSTANCE.getMediator_Reverse();
		}
		if (editorKey == EsbViewsRepository.ThrottleMediator.General.groupId) {
			return EsbPackage.eINSTANCE.getThrottleMediator_GroupId();
		}
		if (editorKey == EsbViewsRepository.ThrottleMediator.ThrottlePolicy.policyType) {
			return EsbPackage.eINSTANCE.getThrottleMediator_PolicyType();
		}
		if (editorKey == EsbViewsRepository.ThrottleMediator.ThrottlePolicy.maxConcurrentAccessCount) {
			return EsbPackage.eINSTANCE.getThrottleMediator_MaxConcurrentAccessCount();
		}
		if (editorKey == EsbViewsRepository.ThrottleMediator.ThrottlePolicy.policyEntries) {
			return EsbPackage.eINSTANCE.getThrottleMediator_PolicyEntries();
		}
		if (editorKey == EsbViewsRepository.ThrottleMediator.OnAccept.onAcceptBranchsequenceType) {
			return EsbPackage.eINSTANCE.getThrottleMediator_OnAcceptBranchsequenceType();
		}
		if (editorKey == EsbViewsRepository.ThrottleMediator.OnReject.onRejectBranchsequenceType) {
			return EsbPackage.eINSTANCE.getThrottleMediator_OnRejectBranchsequenceType();
		}
		if (editorKey == EsbViewsRepository.ThrottleMediator.OnAccept.onAcceptBranchSequenceKey) {
			return EsbPackage.eINSTANCE.getThrottleMediator_OnAcceptBranchsequenceKey();
		}
		if (editorKey == EsbViewsRepository.ThrottleMediator.OnReject.onRejectBranchSequenceKey) {
			return EsbPackage.eINSTANCE.getThrottleMediator_OnRejectBranchsequenceKey();
		}
		if (editorKey == EsbViewsRepository.ThrottleMediator.ThrottlePolicy.policyKey) {
			return EsbPackage.eINSTANCE.getThrottleMediator_PolicyKey();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		ThrottleMediator throttleMediator = (ThrottleMediator)semanticObject;
		if (EsbViewsRepository.ThrottleMediator.Misc.description == event.getAffectedEditor()) {
			throttleMediator.setDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.ThrottleMediator.General.commentsList == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				throttleMediator.getCommentsList().clear();
				throttleMediator.getCommentsList().addAll(((EList) event.getNewValue()));
			}
		}
		if (EsbViewsRepository.ThrottleMediator.General.reverse == event.getAffectedEditor()) {
			throttleMediator.setReverse((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.ThrottleMediator.General.groupId == event.getAffectedEditor()) {
			throttleMediator.setGroupId((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.ThrottleMediator.ThrottlePolicy.policyType == event.getAffectedEditor()) {
			throttleMediator.setPolicyType((ThrottlePolicyType)event.getNewValue());
		}
		if (EsbViewsRepository.ThrottleMediator.ThrottlePolicy.maxConcurrentAccessCount == event.getAffectedEditor()) {
			throttleMediator.setMaxConcurrentAccessCount((EEFConverterUtil.createIntFromString(EcorePackage.Literals.EINT, (String)event.getNewValue())));
		}
		if (EsbViewsRepository.ThrottleMediator.ThrottlePolicy.policyEntries == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, policyEntriesSettings, editingContext.getAdapterFactory());
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
				policyEntriesSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				policyEntriesSettings.move(event.getNewIndex(), (ThrottlePolicyEntry) event.getNewValue());
			}
		}
		if (EsbViewsRepository.ThrottleMediator.OnAccept.onAcceptBranchsequenceType == event.getAffectedEditor()) {
			throttleMediator.setOnAcceptBranchsequenceType((ThrottleSequenceType)event.getNewValue());
		}
		if (EsbViewsRepository.ThrottleMediator.OnReject.onRejectBranchsequenceType == event.getAffectedEditor()) {
			throttleMediator.setOnRejectBranchsequenceType((ThrottleSequenceType)event.getNewValue());
		}
		if (EsbViewsRepository.ThrottleMediator.OnAccept.onAcceptBranchSequenceKey == event.getAffectedEditor()) {
			// Start of user code for updateOnAcceptBranchSequenceKey method body
            if (event.getNewValue() != null) {
                RegistryKeyProperty rkp = (RegistryKeyProperty) event.getNewValue();
                throttleMediator.setOnAcceptBranchsequenceKey(rkp);
            } else {
                throttleMediator.setOnAcceptBranchsequenceKey(EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty());
            }
			// End of user code
			
		}
		if (EsbViewsRepository.ThrottleMediator.OnReject.onRejectBranchSequenceKey == event.getAffectedEditor()) {
			// Start of user code for updateOnRejectBranchSequenceKey method body
            if (event.getNewValue() != null) {
                RegistryKeyProperty rkp = (RegistryKeyProperty) event.getNewValue();
                throttleMediator.setOnRejectBranchsequenceKey(rkp);
            } else {
                throttleMediator.setOnRejectBranchsequenceKey(EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty());
            }
			// End of user code
			
		}
		if (EsbViewsRepository.ThrottleMediator.ThrottlePolicy.policyKey == event.getAffectedEditor()) {
			// Start of user code for updatePolicyKey method body
            if (event.getNewValue() != null) {
                RegistryKeyProperty rkp = (RegistryKeyProperty) event.getNewValue();
                throttleMediator.setPolicyKey(rkp);
            } else {
                throttleMediator.setPolicyKey(EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty());
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
			ThrottleMediatorPropertiesEditionPart basePart = (ThrottleMediatorPropertiesEditionPart)editingPart;
			if (EsbPackage.eINSTANCE.getEsbElement_Description().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.ThrottleMediator.Misc.description)) {
				if (msg.getNewValue() != null) {
					basePart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setDescription("");
				}
			}
			if (EsbPackage.eINSTANCE.getEsbElement_CommentsList().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.ThrottleMediator.General.commentsList)) {
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
			
			if (EsbPackage.eINSTANCE.getMediator_Reverse().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.ThrottleMediator.General.reverse))
				basePart.setReverse((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getThrottleMediator_GroupId().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.ThrottleMediator.General.groupId)) {
				if (msg.getNewValue() != null) {
					basePart.setGroupId(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setGroupId("");
				}
			}
			if (EsbPackage.eINSTANCE.getThrottleMediator_PolicyType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.ThrottleMediator.ThrottlePolicy.policyType))
				basePart.setPolicyType((ThrottlePolicyType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getThrottleMediator_MaxConcurrentAccessCount().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.ThrottleMediator.ThrottlePolicy.maxConcurrentAccessCount)) {
				if (msg.getNewValue() != null) {
					basePart.setMaxConcurrentAccessCount(EcoreUtil.convertToString(EcorePackage.Literals.EINT, msg.getNewValue()));
				} else {
					basePart.setMaxConcurrentAccessCount("");
				}
			}
			if (EsbPackage.eINSTANCE.getThrottleMediator_PolicyEntries().equals(msg.getFeature()) && isAccessible(EsbViewsRepository.ThrottleMediator.ThrottlePolicy.policyEntries))
				basePart.updatePolicyEntries();
			if (EsbPackage.eINSTANCE.getThrottleMediator_OnAcceptBranchsequenceType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.ThrottleMediator.OnAccept.onAcceptBranchsequenceType))
				basePart.setOnAcceptBranchsequenceType((ThrottleSequenceType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getThrottleMediator_OnRejectBranchsequenceType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.ThrottleMediator.OnReject.onRejectBranchsequenceType))
				basePart.setOnRejectBranchsequenceType((ThrottleSequenceType)msg.getNewValue());
			
					// Start of user code for OnAcceptBranchSequenceKey live update
	           if (EsbPackage.eINSTANCE.getThrottleMediator_OnAcceptBranchsequenceKey().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.ThrottleMediator.OnAccept.onAcceptBranchSequenceKey)) {
	               if (msg.getNewValue() != null) {
	                   basePart.setOnAcceptBranchSequenceKey((RegistryKeyProperty)msg.getNewValue());
	               } else {
	                   basePart.setOnAcceptBranchSequenceKey(EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty());
	               }
	           }
					// End of user code
			
					// Start of user code for OnRejectBranchSequenceKey live update
            if (EsbPackage.eINSTANCE.getThrottleMediator_OnRejectBranchsequenceKey().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject) && basePart != null
                    && isAccessible(EsbViewsRepository.ThrottleMediator.OnReject.onRejectBranchSequenceKey)) {
                if (msg.getNewValue() != null) {
                    basePart.setOnRejectBranchSequenceKey((RegistryKeyProperty) msg.getNewValue());
                } else {
                    basePart.setOnRejectBranchSequenceKey(EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty());
                }
            }
            // End of user code
			
					// Start of user code for policyKey live update
            if (EsbPackage.eINSTANCE.getThrottleMediator_PolicyKey().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject) && basePart != null
                    && isAccessible(EsbViewsRepository.ThrottleMediator.ThrottlePolicy.policyKey)) {
                if (msg.getNewValue() != null) {
                    basePart.setPolicyKey((RegistryKeyProperty) msg.getNewValue());
                } else {
                    basePart.setPolicyKey(EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty());
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
			EsbPackage.eINSTANCE.getThrottleMediator_GroupId(),
			EsbPackage.eINSTANCE.getThrottleMediator_PolicyType(),
			EsbPackage.eINSTANCE.getThrottleMediator_MaxConcurrentAccessCount(),
			EsbPackage.eINSTANCE.getThrottleMediator_PolicyEntries(),
			EsbPackage.eINSTANCE.getThrottleMediator_OnAcceptBranchsequenceType(),
			EsbPackage.eINSTANCE.getThrottleMediator_OnRejectBranchsequenceType(),
			EsbPackage.eINSTANCE.getThrottleMediator_OnAcceptBranchsequenceKey(),
			EsbPackage.eINSTANCE.getThrottleMediator_OnRejectBranchsequenceKey(),
			EsbPackage.eINSTANCE.getThrottleMediator_PolicyKey()		);
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
				if (EsbViewsRepository.ThrottleMediator.Misc.description == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.ThrottleMediator.General.commentsList == event.getAffectedEditor()) {
					BasicDiagnostic chain = new BasicDiagnostic();
					for (Iterator iterator = ((List)event.getNewValue()).iterator(); iterator.hasNext();) {
						chain.add(Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEAttributeType(), iterator.next()));
					}
					ret = chain;
				}
				if (EsbViewsRepository.ThrottleMediator.General.reverse == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMediator_Reverse().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMediator_Reverse().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.ThrottleMediator.General.groupId == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getThrottleMediator_GroupId().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getThrottleMediator_GroupId().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.ThrottleMediator.ThrottlePolicy.policyType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getThrottleMediator_PolicyType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getThrottleMediator_PolicyType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.ThrottleMediator.ThrottlePolicy.maxConcurrentAccessCount == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getThrottleMediator_MaxConcurrentAccessCount().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getThrottleMediator_MaxConcurrentAccessCount().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.ThrottleMediator.OnAccept.onAcceptBranchsequenceType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getThrottleMediator_OnAcceptBranchsequenceType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getThrottleMediator_OnAcceptBranchsequenceType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.ThrottleMediator.OnReject.onRejectBranchsequenceType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getThrottleMediator_OnRejectBranchsequenceType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getThrottleMediator_OnRejectBranchsequenceType().getEAttributeType(), newValue);
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
