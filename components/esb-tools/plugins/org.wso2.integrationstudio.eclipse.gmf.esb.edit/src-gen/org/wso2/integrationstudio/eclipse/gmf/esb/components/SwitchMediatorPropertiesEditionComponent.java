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

import org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.integrationstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.SwitchCaseBranchOutputConnector;
import org.wso2.integrationstudio.eclipse.gmf.esb.SwitchMediator;
import org.wso2.integrationstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.SwitchMediatorPropertiesEditionPart;
import org.wso2.integrationstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;


// End of user code

/**
 * 
 * 
 */
public class SwitchMediatorPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	/**
	 * Settings for caseBranches ReferencesTable
	 */
	protected ReferencesTableSettings caseBranchesSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public SwitchMediatorPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject switchMediator, String editing_mode) {
		super(editingContext, switchMediator, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EsbViewsRepository.class;
		partKey = EsbViewsRepository.SwitchMediator.class;
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
			
			final SwitchMediator switchMediator = (SwitchMediator)elt;
			final SwitchMediatorPropertiesEditionPart basePart = (SwitchMediatorPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EsbViewsRepository.SwitchMediator.Properties.description))
				basePart.setDescription(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, switchMediator.getDescription()));
			
			if (isAccessible(EsbViewsRepository.SwitchMediator.Properties.commentsList))
				basePart.setCommentsList(switchMediator.getCommentsList());
			
			if (isAccessible(EsbViewsRepository.SwitchMediator.Properties.reverse)) {
				basePart.setReverse(switchMediator.isReverse());
			}
			if (isAccessible(EsbViewsRepository.SwitchMediator.Properties.source))
				basePart.setSource(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, switchMediator.getSource()));
			
			if (isAccessible(EsbViewsRepository.SwitchMediator.Properties.namespace))
				basePart.setNamespace(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, switchMediator.getNamespace()));
			
			if (isAccessible(EsbViewsRepository.SwitchMediator.Properties.namespacePrefix))
				basePart.setNamespacePrefix(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, switchMediator.getNamespacePrefix()));
			
			if (isAccessible(EsbViewsRepository.SwitchMediator.Properties.caseBranches)) {
				caseBranchesSettings = new ReferencesTableSettings(switchMediator, EsbPackage.eINSTANCE.getSwitchMediator_CaseBranches());
				basePart.initCaseBranches(caseBranchesSettings);
			}
			// Start of user code  for sourceXPath command update
            if (isAccessible(EsbViewsRepository.SwitchMediator.Properties.sourceXPath)) {
                basePart.setSourceXPath(switchMediator.getSourceXpath());
            }
			// End of user code
			
			// init filters
			
			
			
			
			
			
			if (isAccessible(EsbViewsRepository.SwitchMediator.Properties.caseBranches)) {
				basePart.addFilterToCaseBranches(new ViewerFilter() {
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof SwitchCaseBranchOutputConnector); //$NON-NLS-1$ 
					}
			
				});
				// Start of user code for additional businessfilters for caseBranches
				// End of user code
			}
			// Start of user code  for sourceXPath filter update
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
		if (editorKey == EsbViewsRepository.SwitchMediator.Properties.description) {
			return EsbPackage.eINSTANCE.getEsbElement_Description();
		}
		if (editorKey == EsbViewsRepository.SwitchMediator.Properties.commentsList) {
			return EsbPackage.eINSTANCE.getEsbElement_CommentsList();
		}
		if (editorKey == EsbViewsRepository.SwitchMediator.Properties.reverse) {
			return EsbPackage.eINSTANCE.getMediator_Reverse();
		}
		if (editorKey == EsbViewsRepository.SwitchMediator.Properties.source) {
			return EsbPackage.eINSTANCE.getSwitchMediator_Source();
		}
		if (editorKey == EsbViewsRepository.SwitchMediator.Properties.namespace) {
			return EsbPackage.eINSTANCE.getSwitchMediator_Namespace();
		}
		if (editorKey == EsbViewsRepository.SwitchMediator.Properties.namespacePrefix) {
			return EsbPackage.eINSTANCE.getSwitchMediator_NamespacePrefix();
		}
		if (editorKey == EsbViewsRepository.SwitchMediator.Properties.caseBranches) {
			return EsbPackage.eINSTANCE.getSwitchMediator_CaseBranches();
		}
		if (editorKey == EsbViewsRepository.SwitchMediator.Properties.sourceXPath) {
			return EsbPackage.eINSTANCE.getSwitchMediator_SourceXpath();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		SwitchMediator switchMediator = (SwitchMediator)semanticObject;
		if (EsbViewsRepository.SwitchMediator.Properties.description == event.getAffectedEditor()) {
			switchMediator.setDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.SwitchMediator.Properties.commentsList == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				switchMediator.getCommentsList().clear();
				switchMediator.getCommentsList().addAll(((EList) event.getNewValue()));
			}
		}
		if (EsbViewsRepository.SwitchMediator.Properties.reverse == event.getAffectedEditor()) {
			switchMediator.setReverse((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.SwitchMediator.Properties.source == event.getAffectedEditor()) {
			switchMediator.setSource((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.SwitchMediator.Properties.namespace == event.getAffectedEditor()) {
			switchMediator.setNamespace((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.SwitchMediator.Properties.namespacePrefix == event.getAffectedEditor()) {
			switchMediator.setNamespacePrefix((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.SwitchMediator.Properties.caseBranches == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, caseBranchesSettings, editingContext.getAdapterFactory());
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
				caseBranchesSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				caseBranchesSettings.move(event.getNewIndex(), (SwitchCaseBranchOutputConnector) event.getNewValue());
			}
		}
		if (EsbViewsRepository.SwitchMediator.Properties.sourceXPath == event.getAffectedEditor()) {
			// Start of user code for updateSourceXPath method body
            if (event.getNewValue() != null) {
                NamespacedProperty nsp = (NamespacedProperty) event.getNewValue();
                switchMediator.setSourceXpath(nsp);
            } else {
                switchMediator.setSourceXpath(EsbFactoryImpl.eINSTANCE.createNamespacedProperty());
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
			SwitchMediatorPropertiesEditionPart basePart = (SwitchMediatorPropertiesEditionPart)editingPart;
			if (EsbPackage.eINSTANCE.getEsbElement_Description().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.SwitchMediator.Properties.description)) {
				if (msg.getNewValue() != null) {
					basePart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setDescription("");
				}
			}
			if (EsbPackage.eINSTANCE.getEsbElement_CommentsList().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.SwitchMediator.Properties.commentsList)) {
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
			
			if (EsbPackage.eINSTANCE.getMediator_Reverse().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.SwitchMediator.Properties.reverse))
				basePart.setReverse((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getSwitchMediator_Source().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.SwitchMediator.Properties.source)) {
				if (msg.getNewValue() != null) {
					basePart.setSource(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setSource("");
				}
			}
			if (EsbPackage.eINSTANCE.getSwitchMediator_Namespace().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.SwitchMediator.Properties.namespace)) {
				if (msg.getNewValue() != null) {
					basePart.setNamespace(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setNamespace("");
				}
			}
			if (EsbPackage.eINSTANCE.getSwitchMediator_NamespacePrefix().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.SwitchMediator.Properties.namespacePrefix)) {
				if (msg.getNewValue() != null) {
					basePart.setNamespacePrefix(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setNamespacePrefix("");
				}
			}
			if (EsbPackage.eINSTANCE.getSwitchMediator_CaseBranches().equals(msg.getFeature()) && isAccessible(EsbViewsRepository.SwitchMediator.Properties.caseBranches))
				basePart.updateCaseBranches();
					// Start of user code for sourceXPath live update
           if (EsbPackage.eINSTANCE.getSwitchMediator_SourceXpath().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.SwitchMediator.Properties.sourceXPath)) {
                if (msg.getNewValue() != null) {
                    basePart.setSourceXPath((NamespacedProperty)msg.getNewValue());
                } else {
                    basePart.setSourceXPath(EsbFactoryImpl.eINSTANCE.createNamespacedProperty());
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
			EsbPackage.eINSTANCE.getSwitchMediator_Source(),
			EsbPackage.eINSTANCE.getSwitchMediator_Namespace(),
			EsbPackage.eINSTANCE.getSwitchMediator_NamespacePrefix(),
			EsbPackage.eINSTANCE.getSwitchMediator_CaseBranches(),
			EsbPackage.eINSTANCE.getSwitchMediator_SourceXpath()		);
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
				if (EsbViewsRepository.SwitchMediator.Properties.description == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.SwitchMediator.Properties.commentsList == event.getAffectedEditor()) {
					BasicDiagnostic chain = new BasicDiagnostic();
					for (Iterator iterator = ((List)event.getNewValue()).iterator(); iterator.hasNext();) {
						chain.add(Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEAttributeType(), iterator.next()));
					}
					ret = chain;
				}
				if (EsbViewsRepository.SwitchMediator.Properties.reverse == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMediator_Reverse().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMediator_Reverse().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.SwitchMediator.Properties.source == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getSwitchMediator_Source().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getSwitchMediator_Source().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.SwitchMediator.Properties.namespace == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getSwitchMediator_Namespace().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getSwitchMediator_Namespace().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.SwitchMediator.Properties.namespacePrefix == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getSwitchMediator_NamespacePrefix().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getSwitchMediator_NamespacePrefix().getEAttributeType(), newValue);
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
