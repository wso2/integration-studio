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
import org.eclipse.emf.eef.runtime.impl.utils.EEFUtils;

import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy;

import org.eclipse.emf.eef.runtime.policies.impl.CreateEditingPolicy;

import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

import org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.integrationstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.ScriptLanguage;
import org.wso2.integrationstudio.eclipse.gmf.esb.ScriptMediator;
import org.wso2.integrationstudio.eclipse.gmf.esb.ScriptType;

import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.ScriptMediatorPropertiesEditionPart;
import org.wso2.integrationstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;
import org.wso2.integrationstudio.eclipse.gmf.esb.scriptKeyTypeEnum;
import org.wso2.integrationstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;


// End of user code

/**
 * 
 * 
 */
public class ScriptMediatorPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	/**
	 * Settings for scriptKeys ReferencesTable
	 */
	protected ReferencesTableSettings scriptKeysSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public ScriptMediatorPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject scriptMediator, String editing_mode) {
		super(editingContext, scriptMediator, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EsbViewsRepository.class;
		partKey = EsbViewsRepository.ScriptMediator.class;
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
			
			final ScriptMediator scriptMediator = (ScriptMediator)elt;
			final ScriptMediatorPropertiesEditionPart basePart = (ScriptMediatorPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EsbViewsRepository.ScriptMediator.Properties.description))
				basePart.setDescription(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, scriptMediator.getDescription()));
			
			if (isAccessible(EsbViewsRepository.ScriptMediator.Properties.commentsList))
				basePart.setCommentsList(scriptMediator.getCommentsList());
			
			if (isAccessible(EsbViewsRepository.ScriptMediator.Properties.reverse)) {
				basePart.setReverse(scriptMediator.isReverse());
			}
			if (isAccessible(EsbViewsRepository.ScriptMediator.Properties.scriptType)) {
				basePart.initScriptType(EEFUtils.choiceOfValues(scriptMediator, EsbPackage.eINSTANCE.getScriptMediator_ScriptType()), scriptMediator.getScriptType());
			}
			if (isAccessible(EsbViewsRepository.ScriptMediator.Properties.scriptLanguage)) {
				basePart.initScriptLanguage(EEFUtils.choiceOfValues(scriptMediator, EsbPackage.eINSTANCE.getScriptMediator_ScriptLanguage()), scriptMediator.getScriptLanguage());
			}
			if (isAccessible(EsbViewsRepository.ScriptMediator.Properties.mediateFunction))
				basePart.setMediateFunction(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, scriptMediator.getMediateFunction()));
			
			if (isAccessible(EsbViewsRepository.ScriptMediator.Properties.scriptBody))
				basePart.setScriptBody(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, scriptMediator.getScriptBody()));
			
			if (isAccessible(EsbViewsRepository.ScriptMediator.Properties.keyType)) {
				basePart.initKeyType(EEFUtils.choiceOfValues(scriptMediator, EsbPackage.eINSTANCE.getScriptMediator_KeyType()), scriptMediator.getKeyType());
			}
			if (isAccessible(EsbViewsRepository.ScriptMediator.Properties.scriptKeys)) {
				scriptKeysSettings = new ReferencesTableSettings(scriptMediator, EsbPackage.eINSTANCE.getScriptMediator_ScriptKeys());
				basePart.initScriptKeys(scriptKeysSettings);
			}
			// Start of user code  for scriptStaticKey command update
			if (isAccessible(EsbViewsRepository.ScriptMediator.Properties.scriptStaticKey)) {
				basePart.setScriptStaticKey(scriptMediator.getScriptStaticKey());
			}
			// End of user code
			
			// Start of user code  for scriptDynamicKey command update
			if (isAccessible(EsbViewsRepository.ScriptMediator.Properties.scriptDynamicKey)) {
				basePart.setScriptDynamicKey(scriptMediator.getScriptDynamicKey());
			}
			// End of user code
			
			// init filters
			
			
			
			
			
			
			
			
			if (isAccessible(EsbViewsRepository.ScriptMediator.Properties.scriptKeys)) {
				basePart.addFilterToScriptKeys(new ViewerFilter() {
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof RegistryKeyProperty); //$NON-NLS-1$ 
					}
			
				});
				// Start of user code for additional businessfilters for scriptKeys
				// End of user code
			}
			// Start of user code  for scriptStaticKey filter update
			// End of user code
			
			// Start of user code  for scriptDynamicKey filter update
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
		if (editorKey == EsbViewsRepository.ScriptMediator.Properties.description) {
			return EsbPackage.eINSTANCE.getEsbElement_Description();
		}
		if (editorKey == EsbViewsRepository.ScriptMediator.Properties.commentsList) {
			return EsbPackage.eINSTANCE.getEsbElement_CommentsList();
		}
		if (editorKey == EsbViewsRepository.ScriptMediator.Properties.reverse) {
			return EsbPackage.eINSTANCE.getMediator_Reverse();
		}
		if (editorKey == EsbViewsRepository.ScriptMediator.Properties.scriptType) {
			return EsbPackage.eINSTANCE.getScriptMediator_ScriptType();
		}
		if (editorKey == EsbViewsRepository.ScriptMediator.Properties.scriptLanguage) {
			return EsbPackage.eINSTANCE.getScriptMediator_ScriptLanguage();
		}
		if (editorKey == EsbViewsRepository.ScriptMediator.Properties.mediateFunction) {
			return EsbPackage.eINSTANCE.getScriptMediator_MediateFunction();
		}
		if (editorKey == EsbViewsRepository.ScriptMediator.Properties.scriptBody) {
			return EsbPackage.eINSTANCE.getScriptMediator_ScriptBody();
		}
		if (editorKey == EsbViewsRepository.ScriptMediator.Properties.keyType) {
			return EsbPackage.eINSTANCE.getScriptMediator_KeyType();
		}
		if (editorKey == EsbViewsRepository.ScriptMediator.Properties.scriptKeys) {
			return EsbPackage.eINSTANCE.getScriptMediator_ScriptKeys();
		}
		if (editorKey == EsbViewsRepository.ScriptMediator.Properties.scriptStaticKey) {
			return EsbPackage.eINSTANCE.getScriptMediator_ScriptStaticKey();
		}
		if (editorKey == EsbViewsRepository.ScriptMediator.Properties.scriptDynamicKey) {
			return EsbPackage.eINSTANCE.getScriptMediator_ScriptDynamicKey();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		ScriptMediator scriptMediator = (ScriptMediator)semanticObject;
		if (EsbViewsRepository.ScriptMediator.Properties.description == event.getAffectedEditor()) {
			scriptMediator.setDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.ScriptMediator.Properties.commentsList == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				scriptMediator.getCommentsList().clear();
				scriptMediator.getCommentsList().addAll(((EList) event.getNewValue()));
			}
		}
		if (EsbViewsRepository.ScriptMediator.Properties.reverse == event.getAffectedEditor()) {
			scriptMediator.setReverse((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.ScriptMediator.Properties.scriptType == event.getAffectedEditor()) {
			scriptMediator.setScriptType((ScriptType)event.getNewValue());
		}
		if (EsbViewsRepository.ScriptMediator.Properties.scriptLanguage == event.getAffectedEditor()) {
			scriptMediator.setScriptLanguage((ScriptLanguage)event.getNewValue());
		}
		if (EsbViewsRepository.ScriptMediator.Properties.mediateFunction == event.getAffectedEditor()) {
			scriptMediator.setMediateFunction((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.ScriptMediator.Properties.scriptBody == event.getAffectedEditor()) {
			scriptMediator.setScriptBody((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.ScriptMediator.Properties.keyType == event.getAffectedEditor()) {
			scriptMediator.setKeyType((scriptKeyTypeEnum)event.getNewValue());
		}
		if (EsbViewsRepository.ScriptMediator.Properties.scriptKeys == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, scriptKeysSettings, editingContext.getAdapterFactory());
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
				scriptKeysSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				scriptKeysSettings.move(event.getNewIndex(), (RegistryKeyProperty) event.getNewValue());
			}
		}
		if (EsbViewsRepository.ScriptMediator.Properties.scriptStaticKey == event.getAffectedEditor()) {
			// Start of user code for updateScriptStaticKey method body
			if (event.getNewValue() != null) {
				RegistryKeyProperty rkp = (RegistryKeyProperty) event.getNewValue();
				scriptMediator.setScriptStaticKey(rkp);
			} else {
				scriptMediator.setScriptStaticKey(EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty());
			}
			// End of user code
			
		}
		if (EsbViewsRepository.ScriptMediator.Properties.scriptDynamicKey == event.getAffectedEditor()) {
			// Start of user code for updateScriptDynamicKey method body
			if (event.getNewValue() != null) {
                NamespacedProperty nsp = (NamespacedProperty) event.getNewValue();
                scriptMediator.setScriptDynamicKey(nsp);
            } else {
            	scriptMediator.setScriptDynamicKey(EsbFactoryImpl.eINSTANCE.createNamespacedProperty());
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
			ScriptMediatorPropertiesEditionPart basePart = (ScriptMediatorPropertiesEditionPart)editingPart;
			if (EsbPackage.eINSTANCE.getEsbElement_Description().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.ScriptMediator.Properties.description)) {
				if (msg.getNewValue() != null) {
					basePart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setDescription("");
				}
			}
			if (EsbPackage.eINSTANCE.getEsbElement_CommentsList().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.ScriptMediator.Properties.commentsList)) {
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
			
			if (EsbPackage.eINSTANCE.getMediator_Reverse().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.ScriptMediator.Properties.reverse))
				basePart.setReverse((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getScriptMediator_ScriptType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.ScriptMediator.Properties.scriptType))
				basePart.setScriptType((ScriptType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getScriptMediator_ScriptLanguage().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.ScriptMediator.Properties.scriptLanguage))
				basePart.setScriptLanguage((ScriptLanguage)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getScriptMediator_MediateFunction().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.ScriptMediator.Properties.mediateFunction)) {
				if (msg.getNewValue() != null) {
					basePart.setMediateFunction(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setMediateFunction("");
				}
			}
			if (EsbPackage.eINSTANCE.getScriptMediator_ScriptBody().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.ScriptMediator.Properties.scriptBody)) {
				if (msg.getNewValue() != null) {
					basePart.setScriptBody(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setScriptBody("");
				}
			}
			if (EsbPackage.eINSTANCE.getScriptMediator_KeyType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.ScriptMediator.Properties.keyType))
				basePart.setKeyType((scriptKeyTypeEnum)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getScriptMediator_ScriptKeys().equals(msg.getFeature()) && isAccessible(EsbViewsRepository.ScriptMediator.Properties.scriptKeys))
				basePart.updateScriptKeys();
					// Start of user code for scriptStaticKey live update
			if (EsbPackage.eINSTANCE.getScriptMediator_ScriptStaticKey().equals(msg.getFeature())
					&& msg.getNotifier().equals(semanticObject) && basePart != null
					&& isAccessible(EsbViewsRepository.ScriptMediator.Properties.scriptStaticKey)) {
				if (msg.getNewValue() != null) {
					basePart.setScriptStaticKey((RegistryKeyProperty) msg.getNewValue());
				} else {
					basePart.setScriptStaticKey(EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty());
				}
			}
					// End of user code
			
					// Start of user code for scriptDynamicKey live update
			if (EsbPackage.eINSTANCE.getScriptMediator_ScriptDynamicKey().equals(msg.getFeature())
					&& msg.getNotifier().equals(semanticObject) && basePart != null
					&& isAccessible(EsbViewsRepository.ScriptMediator.Properties.scriptDynamicKey)) {
				if (msg.getNewValue() != null) {
					basePart.setScriptDynamicKey((NamespacedProperty) msg.getNewValue());
				} else {
					basePart.setScriptDynamicKey(EsbFactoryImpl.eINSTANCE.createNamespacedProperty());
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
			EsbPackage.eINSTANCE.getScriptMediator_ScriptType(),
			EsbPackage.eINSTANCE.getScriptMediator_ScriptLanguage(),
			EsbPackage.eINSTANCE.getScriptMediator_MediateFunction(),
			EsbPackage.eINSTANCE.getScriptMediator_ScriptBody(),
			EsbPackage.eINSTANCE.getScriptMediator_KeyType(),
			EsbPackage.eINSTANCE.getScriptMediator_ScriptKeys(),
			EsbPackage.eINSTANCE.getScriptMediator_ScriptStaticKey(),
			EsbPackage.eINSTANCE.getScriptMediator_ScriptDynamicKey()		);
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
				if (EsbViewsRepository.ScriptMediator.Properties.description == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.ScriptMediator.Properties.commentsList == event.getAffectedEditor()) {
					BasicDiagnostic chain = new BasicDiagnostic();
					for (Iterator iterator = ((List)event.getNewValue()).iterator(); iterator.hasNext();) {
						chain.add(Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEAttributeType(), iterator.next()));
					}
					ret = chain;
				}
				if (EsbViewsRepository.ScriptMediator.Properties.reverse == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMediator_Reverse().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMediator_Reverse().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.ScriptMediator.Properties.scriptType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getScriptMediator_ScriptType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getScriptMediator_ScriptType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.ScriptMediator.Properties.scriptLanguage == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getScriptMediator_ScriptLanguage().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getScriptMediator_ScriptLanguage().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.ScriptMediator.Properties.mediateFunction == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getScriptMediator_MediateFunction().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getScriptMediator_MediateFunction().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.ScriptMediator.Properties.scriptBody == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getScriptMediator_ScriptBody().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getScriptMediator_ScriptBody().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.ScriptMediator.Properties.keyType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getScriptMediator_KeyType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getScriptMediator_KeyType().getEAttributeType(), newValue);
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
