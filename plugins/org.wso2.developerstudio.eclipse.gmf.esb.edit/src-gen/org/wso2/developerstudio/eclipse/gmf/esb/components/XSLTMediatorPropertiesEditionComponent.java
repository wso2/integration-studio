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
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.XSLTFeature;
import org.wso2.developerstudio.eclipse.gmf.esb.XSLTMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.XSLTProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.XSLTResource;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.XSLTMediatorPropertiesEditionPart;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;


// End of user code

/**
 * 
 * 
 */
public class XSLTMediatorPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	/**
	 * Settings for properties ReferencesTable
	 */
	protected ReferencesTableSettings propertiesSettings;
	
	/**
	 * Settings for features ReferencesTable
	 */
	protected ReferencesTableSettings featuresSettings;
	
	/**
	 * Settings for resources ReferencesTable
	 */
	protected ReferencesTableSettings resourcesSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public XSLTMediatorPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject xSLTMediator, String editing_mode) {
		super(editingContext, xSLTMediator, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EsbViewsRepository.class;
		partKey = EsbViewsRepository.XSLTMediator.class;
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
			
			final XSLTMediator xSLTMediator = (XSLTMediator)elt;
			final XSLTMediatorPropertiesEditionPart basePart = (XSLTMediatorPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EsbViewsRepository.XSLTMediator.Properties.description))
				basePart.setDescription(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, xSLTMediator.getDescription()));
			
			if (isAccessible(EsbViewsRepository.XSLTMediator.Properties.commentsList))
				basePart.setCommentsList(xSLTMediator.getCommentsList());
			
			if (isAccessible(EsbViewsRepository.XSLTMediator.Properties.reverse)) {
				basePart.setReverse(xSLTMediator.isReverse());
			}
			if (isAccessible(EsbViewsRepository.XSLTMediator.Properties.xsltSchemaKeyType)) {
				basePart.initXsltSchemaKeyType(EEFUtils.choiceOfValues(xSLTMediator, EsbPackage.eINSTANCE.getXSLTMediator_XsltSchemaKeyType()), xSLTMediator.getXsltSchemaKeyType());
			}
			if (isAccessible(EsbViewsRepository.XSLTMediator.Properties.properties_)) {
				propertiesSettings = new ReferencesTableSettings(xSLTMediator, EsbPackage.eINSTANCE.getXSLTMediator_Properties());
				basePart.initProperties(propertiesSettings);
			}
			if (isAccessible(EsbViewsRepository.XSLTMediator.Properties.features)) {
				featuresSettings = new ReferencesTableSettings(xSLTMediator, EsbPackage.eINSTANCE.getXSLTMediator_Features());
				basePart.initFeatures(featuresSettings);
			}
			if (isAccessible(EsbViewsRepository.XSLTMediator.Properties.resources)) {
				resourcesSettings = new ReferencesTableSettings(xSLTMediator, EsbPackage.eINSTANCE.getXSLTMediator_Resources());
				basePart.initResources(resourcesSettings);
			}
			// Start of user code  for sourceXpath command update
		    if (isAccessible(EsbViewsRepository.XSLTMediator.Properties.sourceXpath)) {
                basePart.setSourceXpath(xSLTMediator.getSourceXPath());
            }
			// End of user code
			
			// Start of user code  for XSLTDynamicSchemaKey command update
		    if (isAccessible(EsbViewsRepository.XSLTMediator.Properties.xSLTDynamicSchemaKey)) {
                basePart.setXSLTDynamicSchemaKey(xSLTMediator.getXsltDynamicSchemaKey());
            }
		    // End of user code
			
			// Start of user code  for XSLTStaticSchemaKey command update
		    if (isAccessible(EsbViewsRepository.XSLTMediator.Properties.xSLTStaticSchemaKey)) {
                basePart.setXSLTStaticSchemaKey(xSLTMediator.getXsltStaticSchemaKey());
            }
		    // End of user code
			
			// init filters
			
			
			
			
			if (isAccessible(EsbViewsRepository.XSLTMediator.Properties.properties_)) {
				basePart.addFilterToProperties(new ViewerFilter() {
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof XSLTProperty); //$NON-NLS-1$ 
					}
			
				});
				// Start of user code for additional businessfilters for properties
				// End of user code
			}
			if (isAccessible(EsbViewsRepository.XSLTMediator.Properties.features)) {
				basePart.addFilterToFeatures(new ViewerFilter() {
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof XSLTFeature); //$NON-NLS-1$ 
					}
			
				});
				// Start of user code for additional businessfilters for features
				// End of user code
			}
			if (isAccessible(EsbViewsRepository.XSLTMediator.Properties.resources)) {
				basePart.addFilterToResources(new ViewerFilter() {
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof XSLTResource); //$NON-NLS-1$ 
					}
			
				});
				// Start of user code for additional businessfilters for resources
				// End of user code
			}
			// Start of user code  for sourceXpath filter update
			// End of user code
			
			// Start of user code  for XSLTDynamicSchemaKey filter update
			// End of user code
			
			// Start of user code  for XSLTStaticSchemaKey filter update
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
		if (editorKey == EsbViewsRepository.XSLTMediator.Properties.description) {
			return EsbPackage.eINSTANCE.getEsbElement_Description();
		}
		if (editorKey == EsbViewsRepository.XSLTMediator.Properties.commentsList) {
			return EsbPackage.eINSTANCE.getEsbElement_CommentsList();
		}
		if (editorKey == EsbViewsRepository.XSLTMediator.Properties.reverse) {
			return EsbPackage.eINSTANCE.getMediator_Reverse();
		}
		if (editorKey == EsbViewsRepository.XSLTMediator.Properties.xsltSchemaKeyType) {
			return EsbPackage.eINSTANCE.getXSLTMediator_XsltSchemaKeyType();
		}
		if (editorKey == EsbViewsRepository.XSLTMediator.Properties.properties_) {
			return EsbPackage.eINSTANCE.getXSLTMediator_Properties();
		}
		if (editorKey == EsbViewsRepository.XSLTMediator.Properties.features) {
			return EsbPackage.eINSTANCE.getXSLTMediator_Features();
		}
		if (editorKey == EsbViewsRepository.XSLTMediator.Properties.resources) {
			return EsbPackage.eINSTANCE.getXSLTMediator_Resources();
		}
		if (editorKey == EsbViewsRepository.XSLTMediator.Properties.sourceXpath) {
			return EsbPackage.eINSTANCE.getXSLTMediator_SourceXPath();
		}
		if (editorKey == EsbViewsRepository.XSLTMediator.Properties.xSLTDynamicSchemaKey) {
			return EsbPackage.eINSTANCE.getXSLTMediator_XsltDynamicSchemaKey();
		}
		if (editorKey == EsbViewsRepository.XSLTMediator.Properties.xSLTStaticSchemaKey) {
			return EsbPackage.eINSTANCE.getXSLTMediator_XsltStaticSchemaKey();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		XSLTMediator xSLTMediator = (XSLTMediator)semanticObject;
		if (EsbViewsRepository.XSLTMediator.Properties.description == event.getAffectedEditor()) {
			xSLTMediator.setDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.XSLTMediator.Properties.commentsList == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				xSLTMediator.getCommentsList().clear();
				xSLTMediator.getCommentsList().addAll(((EList) event.getNewValue()));
			}
		}
		if (EsbViewsRepository.XSLTMediator.Properties.reverse == event.getAffectedEditor()) {
			xSLTMediator.setReverse((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.XSLTMediator.Properties.xsltSchemaKeyType == event.getAffectedEditor()) {
			xSLTMediator.setXsltSchemaKeyType((KeyType)event.getNewValue());
		}
		if (EsbViewsRepository.XSLTMediator.Properties.properties_ == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, propertiesSettings, editingContext.getAdapterFactory());
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
				propertiesSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				propertiesSettings.move(event.getNewIndex(), (XSLTProperty) event.getNewValue());
			}
		}
		if (EsbViewsRepository.XSLTMediator.Properties.features == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, featuresSettings, editingContext.getAdapterFactory());
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
				featuresSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				featuresSettings.move(event.getNewIndex(), (XSLTFeature) event.getNewValue());
			}
		}
		if (EsbViewsRepository.XSLTMediator.Properties.resources == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, resourcesSettings, editingContext.getAdapterFactory());
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
				resourcesSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				resourcesSettings.move(event.getNewIndex(), (XSLTResource) event.getNewValue());
			}
		}
		if (EsbViewsRepository.XSLTMediator.Properties.sourceXpath == event.getAffectedEditor()) {
			// Start of user code for updateSourceXpath method body
		    if (event.getNewValue() != null) {
                NamespacedProperty nsp = (NamespacedProperty) event.getNewValue();
                xSLTMediator.setSourceXPath(nsp);
            } else {
                xSLTMediator.setSourceXPath(EsbFactoryImpl.eINSTANCE.createNamespacedProperty());
            }
			// End of user code
			
		}
		if (EsbViewsRepository.XSLTMediator.Properties.xSLTDynamicSchemaKey == event.getAffectedEditor()) {
			// Start of user code for updateXSLTDynamicSchemaKey method body
		    if (event.getNewValue() != null) {
                NamespacedProperty nsp = (NamespacedProperty) event.getNewValue();
                xSLTMediator.setXsltDynamicSchemaKey(nsp);
            } else {
                xSLTMediator.setXsltDynamicSchemaKey(EsbFactoryImpl.eINSTANCE.createNamespacedProperty());
            }
			// End of user code
			
		}
		if (EsbViewsRepository.XSLTMediator.Properties.xSLTStaticSchemaKey == event.getAffectedEditor()) {
			// Start of user code for updateXSLTStaticSchemaKey method body
		    if (event.getNewValue() != null) {
                RegistryKeyProperty rkp = (RegistryKeyProperty) event.getNewValue();
                xSLTMediator.setXsltStaticSchemaKey(rkp);
            } else {
                xSLTMediator.setXsltStaticSchemaKey(EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty());
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
			XSLTMediatorPropertiesEditionPart basePart = (XSLTMediatorPropertiesEditionPart)editingPart;
			if (EsbPackage.eINSTANCE.getEsbElement_Description().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.XSLTMediator.Properties.description)) {
				if (msg.getNewValue() != null) {
					basePart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setDescription("");
				}
			}
			if (EsbPackage.eINSTANCE.getEsbElement_CommentsList().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.XSLTMediator.Properties.commentsList)) {
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
			
			if (EsbPackage.eINSTANCE.getMediator_Reverse().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.XSLTMediator.Properties.reverse))
				basePart.setReverse((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getXSLTMediator_XsltSchemaKeyType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.XSLTMediator.Properties.xsltSchemaKeyType))
				basePart.setXsltSchemaKeyType((KeyType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getXSLTMediator_Properties().equals(msg.getFeature()) && isAccessible(EsbViewsRepository.XSLTMediator.Properties.properties_))
				basePart.updateProperties();
			if (EsbPackage.eINSTANCE.getXSLTMediator_Features().equals(msg.getFeature()) && isAccessible(EsbViewsRepository.XSLTMediator.Properties.features))
				basePart.updateFeatures();
			if (EsbPackage.eINSTANCE.getXSLTMediator_Resources().equals(msg.getFeature()) && isAccessible(EsbViewsRepository.XSLTMediator.Properties.resources))
				basePart.updateResources();
					// Start of user code for sourceXpath live update
            if (EsbPackage.eINSTANCE.getXSLTMediator_SourceXPath().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject) && basePart != null
                    && isAccessible(EsbViewsRepository.XSLTMediator.Properties.sourceXpath)) {
                if (msg.getNewValue() != null) {
                    basePart.setSourceXpath((NamespacedProperty) msg.getNewValue());
                } else {
                    basePart.setSourceXpath(EsbFactoryImpl.eINSTANCE.createNamespacedProperty());
                }
            }
            // End of user code
			
					// Start of user code for XSLTDynamicSchemaKey live update
            if (EsbPackage.eINSTANCE.getXSLTMediator_XsltDynamicSchemaKey().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject) && basePart != null
                    && isAccessible(EsbViewsRepository.XSLTMediator.Properties.xSLTDynamicSchemaKey)) {
                if (msg.getNewValue() != null) {
                    basePart.setXSLTDynamicSchemaKey((NamespacedProperty) msg.getNewValue());
                } else {
                    basePart.setXSLTDynamicSchemaKey(EsbFactoryImpl.eINSTANCE.createNamespacedProperty());
                }
            }
            // End of user code
			
					// Start of user code for XSLTStaticSchemaKey live update
            if (EsbPackage.eINSTANCE.getAbstractCommonTarget_EndpointKey().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject) && basePart != null
                    && isAccessible(EsbViewsRepository.XSLTMediator.Properties.xSLTStaticSchemaKey)) {
                if (msg.getNewValue() != null) {
                    basePart.setXSLTStaticSchemaKey((RegistryKeyProperty) msg.getNewValue());
                } else {
                    basePart.setXSLTStaticSchemaKey(EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty());
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
			EsbPackage.eINSTANCE.getXSLTMediator_XsltSchemaKeyType(),
			EsbPackage.eINSTANCE.getXSLTMediator_Properties(),
			EsbPackage.eINSTANCE.getXSLTMediator_Features(),
			EsbPackage.eINSTANCE.getXSLTMediator_Resources(),
			EsbPackage.eINSTANCE.getXSLTMediator_SourceXPath(),
			EsbPackage.eINSTANCE.getXSLTMediator_XsltDynamicSchemaKey(),
			EsbPackage.eINSTANCE.getXSLTMediator_XsltStaticSchemaKey()		);
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
				if (EsbViewsRepository.XSLTMediator.Properties.description == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.XSLTMediator.Properties.commentsList == event.getAffectedEditor()) {
					BasicDiagnostic chain = new BasicDiagnostic();
					for (Iterator iterator = ((List)event.getNewValue()).iterator(); iterator.hasNext();) {
						chain.add(Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEAttributeType(), iterator.next()));
					}
					ret = chain;
				}
				if (EsbViewsRepository.XSLTMediator.Properties.reverse == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMediator_Reverse().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMediator_Reverse().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.XSLTMediator.Properties.xsltSchemaKeyType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getXSLTMediator_XsltSchemaKeyType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getXSLTMediator_XsltSchemaKeyType().getEAttributeType(), newValue);
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
