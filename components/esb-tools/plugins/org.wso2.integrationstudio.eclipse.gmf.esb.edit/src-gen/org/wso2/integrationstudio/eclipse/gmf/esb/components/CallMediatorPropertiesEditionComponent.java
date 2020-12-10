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

import org.eclipse.emf.eef.runtime.impl.components.SinglePartPropertiesEditingComponent;

import org.eclipse.emf.eef.runtime.impl.filters.EObjectFilter;

import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;
import org.eclipse.emf.eef.runtime.impl.utils.EEFUtils;

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;

import org.wso2.integrationstudio.eclipse.gmf.esb.CallMediator;
import org.wso2.integrationstudio.eclipse.gmf.esb.CallMediatorEndpointType;
import org.wso2.integrationstudio.eclipse.gmf.esb.EndPoint;
import org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.integrationstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.CallMediatorPropertiesEditionPart;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.integrationstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;


// End of user code

/**
 * 
 * 
 */
public class CallMediatorPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	/**
	 * Settings for endpoint ReferencesTable
	 */
	private ReferencesTableSettings endpointSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public CallMediatorPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject callMediator, String editing_mode) {
		super(editingContext, callMediator, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EsbViewsRepository.class;
		partKey = EsbViewsRepository.CallMediator.class;
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
			
			final CallMediator callMediator = (CallMediator)elt;
			final CallMediatorPropertiesEditionPart basePart = (CallMediatorPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EsbViewsRepository.CallMediator.Properties.description))
				basePart.setDescription(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, callMediator.getDescription()));
			
			if (isAccessible(EsbViewsRepository.CallMediator.Properties.commentsList))
				basePart.setCommentsList(callMediator.getCommentsList());
			
			if (isAccessible(EsbViewsRepository.CallMediator.Properties.reverse)) {
				basePart.setReverse(callMediator.isReverse());
			}
			if (isAccessible(EsbViewsRepository.CallMediator.Properties.endpoint)) {
				endpointSettings = new ReferencesTableSettings(callMediator, EsbPackage.eINSTANCE.getCallMediator_Endpoint());
				basePart.initEndpoint(endpointSettings);
			}
			if (isAccessible(EsbViewsRepository.CallMediator.Properties.endpointType)) {
				basePart.initEndpointType(EEFUtils.choiceOfValues(callMediator, EsbPackage.eINSTANCE.getCallMediator_EndpointType()), callMediator.getEndpointType());
			}
			if (isAccessible(EsbViewsRepository.CallMediator.Properties.enableBlockingCalls)) {
				basePart.setEnableBlockingCalls(callMediator.isEnableBlockingCalls());
			}
			// Start of user code  for endpointXPath command update
	        if (isAccessible(EsbViewsRepository.CallMediator.Properties.endpointXpath)) {
                  basePart.setEndpointXPath(callMediator.getEndpointXpath());
           }
			// End of user code
			
			// Start of user code  for endpointRegistryKey command update
            if (isAccessible(EsbViewsRepository.CallMediator.Properties.endpointRegistryKey)) {
                basePart.setEndpointRegistryKey(callMediator.getEndpointRegistrykey());
            }
			// End of user code
			
			// init filters
			
			
			
			if (isAccessible(EsbViewsRepository.CallMediator.Properties.endpoint)) {
				basePart.addFilterToEndpoint(new EObjectFilter(EsbPackage.Literals.END_POINT));
				// Start of user code for additional businessfilters for endpoint
				// End of user code
			}
			
			
			// Start of user code  for endpointXPath filter update
			// End of user code
			
			// Start of user code  for endpointRegistryKey filter update
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
		if (editorKey == EsbViewsRepository.CallMediator.Properties.description) {
			return EsbPackage.eINSTANCE.getEsbElement_Description();
		}
		if (editorKey == EsbViewsRepository.CallMediator.Properties.commentsList) {
			return EsbPackage.eINSTANCE.getEsbElement_CommentsList();
		}
		if (editorKey == EsbViewsRepository.CallMediator.Properties.reverse) {
			return EsbPackage.eINSTANCE.getMediator_Reverse();
		}
		if (editorKey == EsbViewsRepository.CallMediator.Properties.endpoint) {
			return EsbPackage.eINSTANCE.getCallMediator_Endpoint();
		}
		if (editorKey == EsbViewsRepository.CallMediator.Properties.endpointType) {
			return EsbPackage.eINSTANCE.getCallMediator_EndpointType();
		}
		if (editorKey == EsbViewsRepository.CallMediator.Properties.enableBlockingCalls) {
			return EsbPackage.eINSTANCE.getCallMediator_EnableBlockingCalls();
		}
		if (editorKey == EsbViewsRepository.CallMediator.Properties.endpointXpath) {
			return EsbPackage.eINSTANCE.getCallMediator_EndpointXpath();
		}
		if (editorKey == EsbViewsRepository.CallMediator.Properties.endpointRegistryKey) {
			return EsbPackage.eINSTANCE.getCallMediator_EndpointRegistrykey();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		CallMediator callMediator = (CallMediator)semanticObject;
		if (EsbViewsRepository.CallMediator.Properties.description == event.getAffectedEditor()) {
			callMediator.setDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.CallMediator.Properties.commentsList == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				callMediator.getCommentsList().clear();
				callMediator.getCommentsList().addAll(((EList) event.getNewValue()));
			}
		}
		if (EsbViewsRepository.CallMediator.Properties.reverse == event.getAffectedEditor()) {
			callMediator.setReverse((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.CallMediator.Properties.endpoint == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				if (event.getNewValue() instanceof EndPoint) {
					endpointSettings.addToReference((EObject) event.getNewValue());
				}
			} else if (event.getKind() == PropertiesEditionEvent.REMOVE) {
				endpointSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				endpointSettings.move(event.getNewIndex(), (EndPoint) event.getNewValue());
			}
		}
		if (EsbViewsRepository.CallMediator.Properties.endpointType == event.getAffectedEditor()) {
			callMediator.setEndpointType((CallMediatorEndpointType)event.getNewValue());
		}
		if (EsbViewsRepository.CallMediator.Properties.enableBlockingCalls == event.getAffectedEditor()) {
			callMediator.setEnableBlockingCalls((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.CallMediator.Properties.endpointXpath == event.getAffectedEditor()) {
			// Start of user code for updateEndpointXPath method body
            if (event.getNewValue() != null) {
                NamespacedProperty nsp = (NamespacedProperty) event.getNewValue();
                callMediator.setEndpointXpath(nsp);
            } else {
                callMediator.setEndpointXpath(EsbFactoryImpl.eINSTANCE.createNamespacedProperty());
            }
			// End of user code
			
		}
		if (EsbViewsRepository.CallMediator.Properties.endpointRegistryKey == event.getAffectedEditor()) {
			// Start of user code for updateEndpointRegistryKey method body
            if (event.getNewValue() != null) {
                RegistryKeyProperty rkp = (RegistryKeyProperty) event.getNewValue();
                callMediator.setEndpointRegistrykey(rkp);
            } else {
                callMediator.setEndpointRegistrykey(EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty());
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
			CallMediatorPropertiesEditionPart basePart = (CallMediatorPropertiesEditionPart)editingPart;
			if (EsbPackage.eINSTANCE.getEsbElement_Description().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.CallMediator.Properties.description)) {
				if (msg.getNewValue() != null) {
					basePart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setDescription("");
				}
			}
			if (EsbPackage.eINSTANCE.getEsbElement_CommentsList().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.CallMediator.Properties.commentsList)) {
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
			
			if (EsbPackage.eINSTANCE.getMediator_Reverse().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.CallMediator.Properties.reverse))
				basePart.setReverse((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getCallMediator_Endpoint().equals(msg.getFeature())  && isAccessible(EsbViewsRepository.CallMediator.Properties.endpoint))
				basePart.updateEndpoint();
			if (EsbPackage.eINSTANCE.getCallMediator_EndpointType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.CallMediator.Properties.endpointType))
				basePart.setEndpointType((CallMediatorEndpointType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getCallMediator_EnableBlockingCalls().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.CallMediator.Properties.enableBlockingCalls))
				basePart.setEnableBlockingCalls((Boolean)msg.getNewValue());
			
					// Start of user code for endpointXPath live update
			if (EsbPackage.eINSTANCE.getCallMediator_EndpointXpath().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.CallMediator.Properties.endpointXpath)) {
                if (msg.getNewValue() != null) {
                    basePart.setEndpointXPath((NamespacedProperty)msg.getNewValue());
                } else {
                    basePart.setEndpointXPath(EsbFactoryImpl.eINSTANCE.createNamespacedProperty());
                }
             }
					// End of user code
			
					// Start of user code for endpointRegistryKey live update
			if (EsbPackage.eINSTANCE.getCallMediator_EndpointRegistrykey().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.CallMediator.Properties.endpointRegistryKey)) {
               if (msg.getNewValue() != null) {
                   basePart.setEndpointRegistryKey((RegistryKeyProperty)msg.getNewValue());
               } else {
                   basePart.setEndpointRegistryKey(EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty());
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
			EsbPackage.eINSTANCE.getCallMediator_Endpoint(),
			EsbPackage.eINSTANCE.getCallMediator_EndpointType(),
			EsbPackage.eINSTANCE.getCallMediator_EnableBlockingCalls(),
			EsbPackage.eINSTANCE.getCallMediator_EndpointXpath(),
			EsbPackage.eINSTANCE.getCallMediator_EndpointRegistrykey()		);
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
				if (EsbViewsRepository.CallMediator.Properties.description == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.CallMediator.Properties.commentsList == event.getAffectedEditor()) {
					BasicDiagnostic chain = new BasicDiagnostic();
					for (Iterator iterator = ((List)event.getNewValue()).iterator(); iterator.hasNext();) {
						chain.add(Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEAttributeType(), iterator.next()));
					}
					ret = chain;
				}
				if (EsbViewsRepository.CallMediator.Properties.reverse == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMediator_Reverse().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMediator_Reverse().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.CallMediator.Properties.endpointType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getCallMediator_EndpointType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getCallMediator_EndpointType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.CallMediator.Properties.enableBlockingCalls == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getCallMediator_EnableBlockingCalls().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getCallMediator_EnableBlockingCalls().getEAttributeType(), newValue);
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
