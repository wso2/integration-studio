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

import org.eclipse.emf.ecore.resource.ResourceSet;

import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.emf.eef.runtime.api.notify.EStructuralFeatureNotificationFilter;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.notify.NotificationFilter;

import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;

import org.eclipse.emf.eef.runtime.context.impl.EObjectPropertiesEditionContext;

import org.eclipse.emf.eef.runtime.impl.components.SinglePartPropertiesEditingComponent;

import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;
import org.eclipse.emf.eef.runtime.impl.utils.EEFUtils;

import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy;

import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;

import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;

import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

import org.wso2.integrationstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.integrationstudio.eclipse.gmf.esb.KeyType;
import org.wso2.integrationstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.ValidateSchema;
import org.wso2.integrationstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.ValidateSchemaPropertiesEditionPart;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.impl.ValidateSchemaPropertiesEditionPartImpl;


// End of user code

/**
 * 
 * 
 */
public class ValidateSchemaPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	/**
	 * Settings for schemaKey EObjectFlatComboViewer
	 */
	private EObjectFlatComboSettings schemaKeySettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public ValidateSchemaPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject validateSchema, String editing_mode) {
		super(editingContext, validateSchema, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EsbViewsRepository.class;
		partKey = EsbViewsRepository.ValidateSchema.class;
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
			
			final ValidateSchema validateSchema = (ValidateSchema)elt;
			final ValidateSchemaPropertiesEditionPart basePart = (ValidateSchemaPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EsbViewsRepository.ValidateSchema.Properties.validateSchemaKeyType)) {
				basePart.initValidateSchemaKeyType(EEFUtils.choiceOfValues(validateSchema, EsbPackage.eINSTANCE.getValidateSchema_ValidateSchemaKeyType()), validateSchema.getValidateSchemaKeyType());
			}
			if (isAccessible(EsbViewsRepository.ValidateSchema.Properties.schemaKey)) {
				// init part
				schemaKeySettings = new EObjectFlatComboSettings(validateSchema, EsbPackage.eINSTANCE.getValidateSchema_SchemaKey());
				basePart.initSchemaKey(schemaKeySettings);
				// set the button mode
				basePart.setSchemaKeyButtonMode(ButtonsModeEnum.BROWSE);
			}
			// Start of user code  for staticSchemaKey command update
            if (isAccessible(EsbViewsRepository.ValidateSchema.Properties.staticSchemaKey)) {
                basePart.setStaticSchemaKey(validateSchema.getValidateStaticSchemaKey());
            }
			// End of user code
			
			// Start of user code  for dynamicSchemaKey command update
            if (isAccessible(EsbViewsRepository.ValidateSchema.Properties.dynamicSchemaKey)) {
                basePart.setDynamicSchemaKey(validateSchema.getValidateDynamicSchemaKey());
            }
			// End of user code
			
			// init filters
			
			if (isAccessible(EsbViewsRepository.ValidateSchema.Properties.schemaKey)) {
				basePart.addFilterToSchemaKey(new ViewerFilter() {
				
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof RegistryKeyProperty); //$NON-NLS-1$ 
					}
					
				});
				// Start of user code for additional businessfilters for schemaKey
				// End of user code
			}
			// Start of user code  for staticSchemaKey filter update
			((ValidateSchemaPropertiesEditionPartImpl) editingPart).validate();
			// End of user code
			
			// Start of user code  for dynamicSchemaKey filter update
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
		if (editorKey == EsbViewsRepository.ValidateSchema.Properties.validateSchemaKeyType) {
			return EsbPackage.eINSTANCE.getValidateSchema_ValidateSchemaKeyType();
		}
		if (editorKey == EsbViewsRepository.ValidateSchema.Properties.schemaKey) {
			return EsbPackage.eINSTANCE.getValidateSchema_SchemaKey();
		}
		if (editorKey == EsbViewsRepository.ValidateSchema.Properties.staticSchemaKey) {
			return EsbPackage.eINSTANCE.getValidateSchema_ValidateStaticSchemaKey();
		}
		if (editorKey == EsbViewsRepository.ValidateSchema.Properties.dynamicSchemaKey) {
			return EsbPackage.eINSTANCE.getValidateSchema_ValidateDynamicSchemaKey();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		ValidateSchema validateSchema = (ValidateSchema)semanticObject;
		if (EsbViewsRepository.ValidateSchema.Properties.validateSchemaKeyType == event.getAffectedEditor()) {
			validateSchema.setValidateSchemaKeyType((KeyType)event.getNewValue());
		}
		if (EsbViewsRepository.ValidateSchema.Properties.schemaKey == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				schemaKeySettings.setToReference((RegistryKeyProperty)event.getNewValue());
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
				schemaKeySettings.setToReference(eObject);
			}
		}
		if (EsbViewsRepository.ValidateSchema.Properties.staticSchemaKey == event.getAffectedEditor()) {
			// Start of user code for updateStaticSchemaKey method body
            if (event.getNewValue() != null) {
                RegistryKeyProperty rkp = (RegistryKeyProperty) event.getNewValue();
                validateSchema.setValidateStaticSchemaKey(rkp);
            } else {
                validateSchema.setValidateStaticSchemaKey(EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty());
            }
			// End of user code
			
		}
		if (EsbViewsRepository.ValidateSchema.Properties.dynamicSchemaKey == event.getAffectedEditor()) {
			// Start of user code for updateDynamicSchemaKey method body
            if (event.getNewValue() != null) {
                NamespacedProperty nsp = (NamespacedProperty) event.getNewValue();
                validateSchema.setValidateDynamicSchemaKey(nsp);
            } else {
                validateSchema.setValidateDynamicSchemaKey(EsbFactoryImpl.eINSTANCE.createNamespacedProperty());
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
			ValidateSchemaPropertiesEditionPart basePart = (ValidateSchemaPropertiesEditionPart)editingPart;
			if (EsbPackage.eINSTANCE.getValidateSchema_ValidateSchemaKeyType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.ValidateSchema.Properties.validateSchemaKeyType))
				basePart.setValidateSchemaKeyType((KeyType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getValidateSchema_SchemaKey().equals(msg.getFeature()) && basePart != null && isAccessible(EsbViewsRepository.ValidateSchema.Properties.schemaKey))
				basePart.setSchemaKey((EObject)msg.getNewValue());
					// Start of user code for staticSchemaKey live update
                if (EsbPackage.eINSTANCE.getValidateSchema_ValidateStaticSchemaKey().equals(msg.getFeature())
                        && msg.getNotifier().equals(semanticObject) && basePart != null
                        && isAccessible(EsbViewsRepository.ValidateSchema.Properties.staticSchemaKey)) {
                    if (msg.getNewValue() != null) {
                        basePart.setStaticSchemaKey((RegistryKeyProperty)msg.getNewValue());
                    } else {
                        basePart.setStaticSchemaKey(EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty());
                    }
                }
					// End of user code
			
					// Start of user code for dynamicSchemaKey live update
                if (EsbPackage.eINSTANCE.getValidateSchema_ValidateDynamicSchemaKey().equals(msg.getFeature())
                        && msg.getNotifier().equals(semanticObject) && basePart != null
                        && isAccessible(EsbViewsRepository.ValidateSchema.Properties.dynamicSchemaKey)) {
                    if (msg.getNewValue() != null) {
                        basePart.setDynamicSchemaKey((NamespacedProperty)msg.getNewValue());
                    } else {
                        basePart.setDynamicSchemaKey(EsbFactoryImpl.eINSTANCE.createNamespacedProperty());
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
			EsbPackage.eINSTANCE.getValidateSchema_ValidateSchemaKeyType(),
			EsbPackage.eINSTANCE.getValidateSchema_SchemaKey(),
			EsbPackage.eINSTANCE.getValidateSchema_ValidateStaticSchemaKey(),
			EsbPackage.eINSTANCE.getValidateSchema_ValidateDynamicSchemaKey()		);
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
				if (EsbViewsRepository.ValidateSchema.Properties.validateSchemaKeyType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getValidateSchema_ValidateSchemaKeyType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getValidateSchema_ValidateSchemaKeyType().getEAttributeType(), newValue);
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
