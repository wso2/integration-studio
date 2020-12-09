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

import org.wso2.integrationstudio.eclipse.gmf.esb.EJBMediator;
import org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.integrationstudio.eclipse.gmf.esb.MethodArgument;
import org.wso2.integrationstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.PropertyValueType;
import org.wso2.integrationstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EJBMediatorPropertiesEditionPart;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.integrationstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;

// End of user code

/**
 * 
 * 
 */
public class EJBMediatorPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	/**
	 * Settings for methodArguments ReferencesTable
	 */
	protected ReferencesTableSettings methodArgumentsSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public EJBMediatorPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject eJBMediator, String editing_mode) {
		super(editingContext, eJBMediator, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EsbViewsRepository.class;
		partKey = EsbViewsRepository.EJBMediator.class;
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
			
			final EJBMediator eJBMediator = (EJBMediator)elt;
			final EJBMediatorPropertiesEditionPart basePart = (EJBMediatorPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EsbViewsRepository.EJBMediator.Properties.description))
				basePart.setDescription(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, eJBMediator.getDescription()));
			
			if (isAccessible(EsbViewsRepository.EJBMediator.Properties.commentsList))
				basePart.setCommentsList(eJBMediator.getCommentsList());
			
			if (isAccessible(EsbViewsRepository.EJBMediator.Properties.reverse)) {
				basePart.setReverse(eJBMediator.isReverse());
			}
			if (isAccessible(EsbViewsRepository.EJBMediator.Properties.beanstalk))
				basePart.setBeanstalk(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, eJBMediator.getBeanstalk()));
			
			if (isAccessible(EsbViewsRepository.EJBMediator.Properties.class_))
				basePart.setClass_(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, eJBMediator.getClass_()));
			
			if (isAccessible(EsbViewsRepository.EJBMediator.Properties.method))
				basePart.setMethod(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, eJBMediator.getMethod()));
			
			if (isAccessible(EsbViewsRepository.EJBMediator.Properties.sessionIdType)) {
				basePart.initSessionIdType(EEFUtils.choiceOfValues(eJBMediator, EsbPackage.eINSTANCE.getEJBMediator_SessionIdType()), eJBMediator.getSessionIdType());
			}
			if (isAccessible(EsbViewsRepository.EJBMediator.Properties.sessionIdLiteral))
				basePart.setSessionIdLiteral(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, eJBMediator.getSessionIdLiteral()));
			
			if (isAccessible(EsbViewsRepository.EJBMediator.Properties.remove)) {
				basePart.setRemove(eJBMediator.isRemove());
			}
			if (isAccessible(EsbViewsRepository.EJBMediator.Properties.target))
				basePart.setTarget(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, eJBMediator.getTarget()));
			
			if (isAccessible(EsbViewsRepository.EJBMediator.Properties.jNDIName))
				basePart.setJNDIName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, eJBMediator.getJNDIName()));
			
			if (isAccessible(EsbViewsRepository.EJBMediator.Properties.methodArguments)) {
				methodArgumentsSettings = new ReferencesTableSettings(eJBMediator, EsbPackage.eINSTANCE.getEJBMediator_MethodArguments());
				basePart.initMethodArguments(methodArgumentsSettings);
			}
			// Start of user code  for sessionIdExpression command update
            if (isAccessible(EsbViewsRepository.EJBMediator.Properties.sessionIdExpression)) {
                basePart.setSessionIdExpression(eJBMediator.getSessionIdExpression());
            }
			// End of user code
			
			// init filters
			
			
			
			
			
			
			
			
			
			
			
			if (isAccessible(EsbViewsRepository.EJBMediator.Properties.methodArguments)) {
				basePart.addFilterToMethodArguments(new ViewerFilter() {
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof MethodArgument); //$NON-NLS-1$ 
					}
			
				});
				// Start of user code for additional businessfilters for methodArguments
				// End of user code
			}
			// Start of user code  for sessionIdExpression filter update
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
		if (editorKey == EsbViewsRepository.EJBMediator.Properties.description) {
			return EsbPackage.eINSTANCE.getEsbElement_Description();
		}
		if (editorKey == EsbViewsRepository.EJBMediator.Properties.commentsList) {
			return EsbPackage.eINSTANCE.getEsbElement_CommentsList();
		}
		if (editorKey == EsbViewsRepository.EJBMediator.Properties.reverse) {
			return EsbPackage.eINSTANCE.getMediator_Reverse();
		}
		if (editorKey == EsbViewsRepository.EJBMediator.Properties.beanstalk) {
			return EsbPackage.eINSTANCE.getEJBMediator_Beanstalk();
		}
		if (editorKey == EsbViewsRepository.EJBMediator.Properties.class_) {
			return EsbPackage.eINSTANCE.getEJBMediator_Class();
		}
		if (editorKey == EsbViewsRepository.EJBMediator.Properties.method) {
			return EsbPackage.eINSTANCE.getEJBMediator_Method();
		}
		if (editorKey == EsbViewsRepository.EJBMediator.Properties.sessionIdType) {
			return EsbPackage.eINSTANCE.getEJBMediator_SessionIdType();
		}
		if (editorKey == EsbViewsRepository.EJBMediator.Properties.sessionIdLiteral) {
			return EsbPackage.eINSTANCE.getEJBMediator_SessionIdLiteral();
		}
		if (editorKey == EsbViewsRepository.EJBMediator.Properties.remove) {
			return EsbPackage.eINSTANCE.getEJBMediator_Remove();
		}
		if (editorKey == EsbViewsRepository.EJBMediator.Properties.target) {
			return EsbPackage.eINSTANCE.getEJBMediator_Target();
		}
		if (editorKey == EsbViewsRepository.EJBMediator.Properties.jNDIName) {
			return EsbPackage.eINSTANCE.getEJBMediator_JNDIName();
		}
		if (editorKey == EsbViewsRepository.EJBMediator.Properties.methodArguments) {
			return EsbPackage.eINSTANCE.getEJBMediator_MethodArguments();
		}
		if (editorKey == EsbViewsRepository.EJBMediator.Properties.sessionIdExpression) {
			return EsbPackage.eINSTANCE.getEJBMediator_SessionIdExpression();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		EJBMediator eJBMediator = (EJBMediator)semanticObject;
		if (EsbViewsRepository.EJBMediator.Properties.description == event.getAffectedEditor()) {
			eJBMediator.setDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.EJBMediator.Properties.commentsList == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				eJBMediator.getCommentsList().clear();
				eJBMediator.getCommentsList().addAll(((EList) event.getNewValue()));
			}
		}
		if (EsbViewsRepository.EJBMediator.Properties.reverse == event.getAffectedEditor()) {
			eJBMediator.setReverse((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.EJBMediator.Properties.beanstalk == event.getAffectedEditor()) {
			eJBMediator.setBeanstalk((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.EJBMediator.Properties.class_ == event.getAffectedEditor()) {
			eJBMediator.setClass((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.EJBMediator.Properties.method == event.getAffectedEditor()) {
			eJBMediator.setMethod((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.EJBMediator.Properties.sessionIdType == event.getAffectedEditor()) {
			eJBMediator.setSessionIdType((PropertyValueType)event.getNewValue());
		}
		if (EsbViewsRepository.EJBMediator.Properties.sessionIdLiteral == event.getAffectedEditor()) {
			eJBMediator.setSessionIdLiteral((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.EJBMediator.Properties.remove == event.getAffectedEditor()) {
			eJBMediator.setRemove((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.EJBMediator.Properties.target == event.getAffectedEditor()) {
			eJBMediator.setTarget((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.EJBMediator.Properties.jNDIName == event.getAffectedEditor()) {
			eJBMediator.setJNDIName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.EJBMediator.Properties.methodArguments == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, methodArgumentsSettings, editingContext.getAdapterFactory());
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
				methodArgumentsSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				methodArgumentsSettings.move(event.getNewIndex(), (MethodArgument) event.getNewValue());
			}
		}
		if (EsbViewsRepository.EJBMediator.Properties.sessionIdExpression == event.getAffectedEditor()) {
			// Start of user code for updateSessionIdExpression method body
            if (event.getNewValue() != null) {
                NamespacedProperty nsp = (NamespacedProperty) event.getNewValue();
                eJBMediator.setSessionIdExpression(nsp);
            } else {
                eJBMediator.setSessionIdExpression(EsbFactoryImpl.eINSTANCE.createNamespacedProperty());
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
			EJBMediatorPropertiesEditionPart basePart = (EJBMediatorPropertiesEditionPart)editingPart;
			if (EsbPackage.eINSTANCE.getEsbElement_Description().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.EJBMediator.Properties.description)) {
				if (msg.getNewValue() != null) {
					basePart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setDescription("");
				}
			}
			if (EsbPackage.eINSTANCE.getEsbElement_CommentsList().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.EJBMediator.Properties.commentsList)) {
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
			
			if (EsbPackage.eINSTANCE.getMediator_Reverse().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.EJBMediator.Properties.reverse))
				basePart.setReverse((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getEJBMediator_Beanstalk().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.EJBMediator.Properties.beanstalk)) {
				if (msg.getNewValue() != null) {
					basePart.setBeanstalk(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setBeanstalk("");
				}
			}
			if (EsbPackage.eINSTANCE.getEJBMediator_Class().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.EJBMediator.Properties.class_)) {
				if (msg.getNewValue() != null) {
					basePart.setClass_(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setClass_("");
				}
			}
			if (EsbPackage.eINSTANCE.getEJBMediator_Method().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.EJBMediator.Properties.method)) {
				if (msg.getNewValue() != null) {
					basePart.setMethod(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setMethod("");
				}
			}
			if (EsbPackage.eINSTANCE.getEJBMediator_SessionIdType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.EJBMediator.Properties.sessionIdType))
				basePart.setSessionIdType((PropertyValueType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getEJBMediator_SessionIdLiteral().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.EJBMediator.Properties.sessionIdLiteral)) {
				if (msg.getNewValue() != null) {
					basePart.setSessionIdLiteral(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setSessionIdLiteral("");
				}
			}
			if (EsbPackage.eINSTANCE.getEJBMediator_Remove().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.EJBMediator.Properties.remove))
				basePart.setRemove((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getEJBMediator_Target().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.EJBMediator.Properties.target)) {
				if (msg.getNewValue() != null) {
					basePart.setTarget(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTarget("");
				}
			}
			if (EsbPackage.eINSTANCE.getEJBMediator_JNDIName().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.EJBMediator.Properties.jNDIName)) {
				if (msg.getNewValue() != null) {
					basePart.setJNDIName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setJNDIName("");
				}
			}
			if (EsbPackage.eINSTANCE.getEJBMediator_MethodArguments().equals(msg.getFeature()) && isAccessible(EsbViewsRepository.EJBMediator.Properties.methodArguments))
				basePart.updateMethodArguments();
					// Start of user code for sessionIdExpression live update
            if (EsbPackage.eINSTANCE.getEJBMediator_SessionIdExpression().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject) && basePart != null
                    && isAccessible(EsbViewsRepository.EJBMediator.Properties.sessionIdExpression)) {
                if (msg.getNewValue() != null) {
                    basePart.setSessionIdExpression((NamespacedProperty) msg.getNewValue());
                } else {
                    basePart.setSessionIdExpression(EsbFactoryImpl.eINSTANCE.createNamespacedProperty());
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
			EsbPackage.eINSTANCE.getEJBMediator_Beanstalk(),
			EsbPackage.eINSTANCE.getEJBMediator_Class(),
			EsbPackage.eINSTANCE.getEJBMediator_Method(),
			EsbPackage.eINSTANCE.getEJBMediator_SessionIdType(),
			EsbPackage.eINSTANCE.getEJBMediator_SessionIdLiteral(),
			EsbPackage.eINSTANCE.getEJBMediator_Remove(),
			EsbPackage.eINSTANCE.getEJBMediator_Target(),
			EsbPackage.eINSTANCE.getEJBMediator_JNDIName(),
			EsbPackage.eINSTANCE.getEJBMediator_MethodArguments(),
			EsbPackage.eINSTANCE.getEJBMediator_SessionIdExpression()		);
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
				if (EsbViewsRepository.EJBMediator.Properties.description == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.EJBMediator.Properties.commentsList == event.getAffectedEditor()) {
					BasicDiagnostic chain = new BasicDiagnostic();
					for (Iterator iterator = ((List)event.getNewValue()).iterator(); iterator.hasNext();) {
						chain.add(Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEAttributeType(), iterator.next()));
					}
					ret = chain;
				}
				if (EsbViewsRepository.EJBMediator.Properties.reverse == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMediator_Reverse().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMediator_Reverse().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.EJBMediator.Properties.beanstalk == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEJBMediator_Beanstalk().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEJBMediator_Beanstalk().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.EJBMediator.Properties.class_ == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEJBMediator_Class().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEJBMediator_Class().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.EJBMediator.Properties.method == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEJBMediator_Method().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEJBMediator_Method().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.EJBMediator.Properties.sessionIdType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEJBMediator_SessionIdType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEJBMediator_SessionIdType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.EJBMediator.Properties.sessionIdLiteral == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEJBMediator_SessionIdLiteral().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEJBMediator_SessionIdLiteral().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.EJBMediator.Properties.remove == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEJBMediator_Remove().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEJBMediator_Remove().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.EJBMediator.Properties.target == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEJBMediator_Target().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEJBMediator_Target().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.EJBMediator.Properties.jNDIName == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEJBMediator_JNDIName().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEJBMediator_JNDIName().getEAttributeType(), newValue);
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
