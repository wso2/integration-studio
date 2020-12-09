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

import org.wso2.developerstudio.eclipse.gmf.esb.APIHandler;
import org.wso2.developerstudio.eclipse.gmf.esb.APIResource;
import org.wso2.developerstudio.eclipse.gmf.esb.APIVersionType;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.SynapseAPI;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.SynapseAPIPropertiesEditionPart;


// End of user code

/**
 * 
 * 
 */
public class SynapseAPIPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	/**
	 * Settings for handlers ReferencesTable
	 */
	protected ReferencesTableSettings handlersSettings;
	
	/**
	 * Settings for resources ReferencesTable
	 */
	protected ReferencesTableSettings resourcesSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public SynapseAPIPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject synapseAPI, String editing_mode) {
		super(editingContext, synapseAPI, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EsbViewsRepository.class;
		partKey = EsbViewsRepository.SynapseAPI.class;
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
			
			final SynapseAPI synapseAPI = (SynapseAPI)elt;
			final SynapseAPIPropertiesEditionPart basePart = (SynapseAPIPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EsbViewsRepository.SynapseAPI.Handler.handlers)) {
				handlersSettings = new ReferencesTableSettings(synapseAPI, EsbPackage.eINSTANCE.getSynapseAPI_Handlers());
				basePart.initHandlers(handlersSettings);
			}
			if (isAccessible(EsbViewsRepository.SynapseAPI.Handler.Properties.commentsList))
				basePart.setCommentsList(synapseAPI.getCommentsList());
			
			if (isAccessible(EsbViewsRepository.SynapseAPI.Handler.Properties.apiName))
				basePart.setApiName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, synapseAPI.getApiName()));
			
			if (isAccessible(EsbViewsRepository.SynapseAPI.Handler.Properties.context))
				basePart.setContext(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, synapseAPI.getContext()));
			
			if (isAccessible(EsbViewsRepository.SynapseAPI.Handler.Properties.hostName))
				basePart.setHostName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, synapseAPI.getHostName()));
			
			if (isAccessible(EsbViewsRepository.SynapseAPI.Handler.Properties.port)) {
				basePart.setPort(EEFConverterUtil.convertToString(EcorePackage.Literals.EINT, synapseAPI.getPort()));
			}
			
			if (isAccessible(EsbViewsRepository.SynapseAPI.Handler.Properties.resources)) {
				resourcesSettings = new ReferencesTableSettings(synapseAPI, EsbPackage.eINSTANCE.getSynapseAPI_Resources());
				basePart.initResources(resourcesSettings);
			}
			if (isAccessible(EsbViewsRepository.SynapseAPI.Handler.Properties.versionType)) {
				basePart.initVersionType(EEFUtils.choiceOfValues(synapseAPI, EsbPackage.eINSTANCE.getSynapseAPI_VersionType()), synapseAPI.getVersionType());
			}
			if (isAccessible(EsbViewsRepository.SynapseAPI.Handler.Properties.version))
				basePart.setVersion(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, synapseAPI.getVersion()));
			
			if (isAccessible(EsbViewsRepository.SynapseAPI.Handler.Properties.traceEnabled)) {
				basePart.setTraceEnabled(synapseAPI.isTraceEnabled());
			}
			if (isAccessible(EsbViewsRepository.SynapseAPI.Handler.Properties.statisticsEnabled)) {
				basePart.setStatisticsEnabled(synapseAPI.isStatisticsEnabled());
			}
			if (isAccessible(EsbViewsRepository.SynapseAPI.Handler.Properties.description))
				basePart.setDescription(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, synapseAPI.getDescription()));
			
			// Start of user code  for publishSwagger command update
			if (isAccessible(EsbViewsRepository.SynapseAPI.Handler.Properties.publishSwagger)) {
				basePart.setPublishSwagger(synapseAPI.getPublishSwagger());
			}
			// End of user code
			
			// init filters
			if (isAccessible(EsbViewsRepository.SynapseAPI.Handler.handlers)) {
				basePart.addFilterToHandlers(new ViewerFilter() {
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof APIHandler); //$NON-NLS-1$ 
					}
			
				});
				// Start of user code for additional businessfilters for handlers
				// End of user code
			}
			
			
			
			
			
			if (isAccessible(EsbViewsRepository.SynapseAPI.Handler.Properties.resources)) {
				basePart.addFilterToResources(new ViewerFilter() {
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof APIResource); //$NON-NLS-1$ 
					}
			
				});
				// Start of user code for additional businessfilters for resources
				// End of user code
			}
			
			
			
			
			
			// Start of user code  for publishSwagger filter update
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
		if (editorKey == EsbViewsRepository.SynapseAPI.Handler.handlers) {
			return EsbPackage.eINSTANCE.getSynapseAPI_Handlers();
		}
		if (editorKey == EsbViewsRepository.SynapseAPI.Handler.Properties.commentsList) {
			return EsbPackage.eINSTANCE.getEsbElement_CommentsList();
		}
		if (editorKey == EsbViewsRepository.SynapseAPI.Handler.Properties.apiName) {
			return EsbPackage.eINSTANCE.getSynapseAPI_ApiName();
		}
		if (editorKey == EsbViewsRepository.SynapseAPI.Handler.Properties.context) {
			return EsbPackage.eINSTANCE.getSynapseAPI_Context();
		}
		if (editorKey == EsbViewsRepository.SynapseAPI.Handler.Properties.hostName) {
			return EsbPackage.eINSTANCE.getSynapseAPI_HostName();
		}
		if (editorKey == EsbViewsRepository.SynapseAPI.Handler.Properties.port) {
			return EsbPackage.eINSTANCE.getSynapseAPI_Port();
		}
		if (editorKey == EsbViewsRepository.SynapseAPI.Handler.Properties.resources) {
			return EsbPackage.eINSTANCE.getSynapseAPI_Resources();
		}
		if (editorKey == EsbViewsRepository.SynapseAPI.Handler.Properties.versionType) {
			return EsbPackage.eINSTANCE.getSynapseAPI_VersionType();
		}
		if (editorKey == EsbViewsRepository.SynapseAPI.Handler.Properties.version) {
			return EsbPackage.eINSTANCE.getSynapseAPI_Version();
		}
		if (editorKey == EsbViewsRepository.SynapseAPI.Handler.Properties.traceEnabled) {
			return EsbPackage.eINSTANCE.getSynapseAPI_TraceEnabled();
		}
		if (editorKey == EsbViewsRepository.SynapseAPI.Handler.Properties.statisticsEnabled) {
			return EsbPackage.eINSTANCE.getSynapseAPI_StatisticsEnabled();
		}
		if (editorKey == EsbViewsRepository.SynapseAPI.Handler.Properties.description) {
			return EsbPackage.eINSTANCE.getEsbElement_Description();
		}
		if (editorKey == EsbViewsRepository.SynapseAPI.Handler.Properties.publishSwagger) {
			return EsbPackage.eINSTANCE.getSynapseAPI_PublishSwagger();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		SynapseAPI synapseAPI = (SynapseAPI)semanticObject;
		if (EsbViewsRepository.SynapseAPI.Handler.handlers == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, handlersSettings, editingContext.getAdapterFactory());
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
				handlersSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				handlersSettings.move(event.getNewIndex(), (APIHandler) event.getNewValue());
			}
		}
		if (EsbViewsRepository.SynapseAPI.Handler.Properties.commentsList == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				synapseAPI.getCommentsList().clear();
				synapseAPI.getCommentsList().addAll(((EList) event.getNewValue()));
			}
		}
		if (EsbViewsRepository.SynapseAPI.Handler.Properties.apiName == event.getAffectedEditor()) {
			synapseAPI.setApiName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.SynapseAPI.Handler.Properties.context == event.getAffectedEditor()) {
			synapseAPI.setContext((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.SynapseAPI.Handler.Properties.hostName == event.getAffectedEditor()) {
			synapseAPI.setHostName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.SynapseAPI.Handler.Properties.port == event.getAffectedEditor()) {
			synapseAPI.setPort((EEFConverterUtil.createIntFromString(EcorePackage.Literals.EINT, (String)event.getNewValue())));
		}
		if (EsbViewsRepository.SynapseAPI.Handler.Properties.resources == event.getAffectedEditor()) {
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
				resourcesSettings.move(event.getNewIndex(), (APIResource) event.getNewValue());
			}
		}
		if (EsbViewsRepository.SynapseAPI.Handler.Properties.versionType == event.getAffectedEditor()) {
			synapseAPI.setVersionType((APIVersionType)event.getNewValue());
		}
		if (EsbViewsRepository.SynapseAPI.Handler.Properties.version == event.getAffectedEditor()) {
			synapseAPI.setVersion((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.SynapseAPI.Handler.Properties.traceEnabled == event.getAffectedEditor()) {
			synapseAPI.setTraceEnabled((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.SynapseAPI.Handler.Properties.statisticsEnabled == event.getAffectedEditor()) {
			synapseAPI.setStatisticsEnabled((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.SynapseAPI.Handler.Properties.description == event.getAffectedEditor()) {
			synapseAPI.setDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.SynapseAPI.Handler.Properties.publishSwagger == event.getAffectedEditor()) {
			// Start of user code for updatePublishSwagger method body
			if (event.getNewValue() != null) {
				RegistryKeyProperty rkp = (RegistryKeyProperty) event.getNewValue();
				synapseAPI.setPublishSwagger(rkp);
			} else {
				synapseAPI.setPublishSwagger(EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty());
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
			SynapseAPIPropertiesEditionPart basePart = (SynapseAPIPropertiesEditionPart)editingPart;
			if (EsbPackage.eINSTANCE.getSynapseAPI_Handlers().equals(msg.getFeature()) && isAccessible(EsbViewsRepository.SynapseAPI.Handler.handlers))
				basePart.updateHandlers();
			if (EsbPackage.eINSTANCE.getEsbElement_CommentsList().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.SynapseAPI.Handler.Properties.commentsList)) {
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
			
			if (EsbPackage.eINSTANCE.getSynapseAPI_ApiName().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.SynapseAPI.Handler.Properties.apiName)) {
				if (msg.getNewValue() != null) {
					basePart.setApiName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setApiName("");
				}
			}
			if (EsbPackage.eINSTANCE.getSynapseAPI_Context().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.SynapseAPI.Handler.Properties.context)) {
				if (msg.getNewValue() != null) {
					basePart.setContext(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setContext("");
				}
			}
			if (EsbPackage.eINSTANCE.getSynapseAPI_HostName().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.SynapseAPI.Handler.Properties.hostName)) {
				if (msg.getNewValue() != null) {
					basePart.setHostName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setHostName("");
				}
			}
			if (EsbPackage.eINSTANCE.getSynapseAPI_Port().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.SynapseAPI.Handler.Properties.port)) {
				if (msg.getNewValue() != null) {
					basePart.setPort(EcoreUtil.convertToString(EcorePackage.Literals.EINT, msg.getNewValue()));
				} else {
					basePart.setPort("");
				}
			}
			if (EsbPackage.eINSTANCE.getSynapseAPI_Resources().equals(msg.getFeature()) && isAccessible(EsbViewsRepository.SynapseAPI.Handler.Properties.resources))
				basePart.updateResources();
			if (EsbPackage.eINSTANCE.getSynapseAPI_VersionType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.SynapseAPI.Handler.Properties.versionType))
				basePart.setVersionType((APIVersionType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getSynapseAPI_Version().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.SynapseAPI.Handler.Properties.version)) {
				if (msg.getNewValue() != null) {
					basePart.setVersion(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setVersion("");
				}
			}
			if (EsbPackage.eINSTANCE.getSynapseAPI_TraceEnabled().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.SynapseAPI.Handler.Properties.traceEnabled))
				basePart.setTraceEnabled((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getSynapseAPI_StatisticsEnabled().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.SynapseAPI.Handler.Properties.statisticsEnabled))
				basePart.setStatisticsEnabled((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getEsbElement_Description().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.SynapseAPI.Handler.Properties.description)) {
				if (msg.getNewValue() != null) {
					basePart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setDescription("");
				}
			}
					// Start of user code for publishSwagger live update
			if (EsbPackage.eINSTANCE.getSynapseAPI_PublishSwagger()
					.equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null
					&& isAccessible(EsbViewsRepository.SynapseAPI.Handler.Properties.publishSwagger)) {
				if (msg.getNewValue() != null) {
					basePart.setPublishSwagger((RegistryKeyProperty) msg.getNewValue());
				} else {
					basePart.setPublishSwagger(EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty());
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
			EsbPackage.eINSTANCE.getSynapseAPI_Handlers(),
			EsbPackage.eINSTANCE.getEsbElement_CommentsList(),
			EsbPackage.eINSTANCE.getSynapseAPI_ApiName(),
			EsbPackage.eINSTANCE.getSynapseAPI_Context(),
			EsbPackage.eINSTANCE.getSynapseAPI_HostName(),
			EsbPackage.eINSTANCE.getSynapseAPI_Port(),
			EsbPackage.eINSTANCE.getSynapseAPI_Resources(),
			EsbPackage.eINSTANCE.getSynapseAPI_VersionType(),
			EsbPackage.eINSTANCE.getSynapseAPI_Version(),
			EsbPackage.eINSTANCE.getSynapseAPI_TraceEnabled(),
			EsbPackage.eINSTANCE.getSynapseAPI_StatisticsEnabled(),
			EsbPackage.eINSTANCE.getEsbElement_Description(),
			EsbPackage.eINSTANCE.getSynapseAPI_PublishSwagger()		);
		return new NotificationFilter[] {filter,};
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#isRequired(java.lang.Object, int)
	 * 
	 */
	public boolean isRequired(Object key, int kind) {
		return key == EsbViewsRepository.SynapseAPI.Handler.Properties.apiName || key == EsbViewsRepository.SynapseAPI.Handler.Properties.context;
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
				if (EsbViewsRepository.SynapseAPI.Handler.Properties.commentsList == event.getAffectedEditor()) {
					BasicDiagnostic chain = new BasicDiagnostic();
					for (Iterator iterator = ((List)event.getNewValue()).iterator(); iterator.hasNext();) {
						chain.add(Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEAttributeType(), iterator.next()));
					}
					ret = chain;
				}
				if (EsbViewsRepository.SynapseAPI.Handler.Properties.apiName == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getSynapseAPI_ApiName().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getSynapseAPI_ApiName().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.SynapseAPI.Handler.Properties.context == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getSynapseAPI_Context().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getSynapseAPI_Context().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.SynapseAPI.Handler.Properties.hostName == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getSynapseAPI_HostName().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getSynapseAPI_HostName().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.SynapseAPI.Handler.Properties.port == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getSynapseAPI_Port().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getSynapseAPI_Port().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.SynapseAPI.Handler.Properties.versionType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getSynapseAPI_VersionType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getSynapseAPI_VersionType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.SynapseAPI.Handler.Properties.version == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getSynapseAPI_Version().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getSynapseAPI_Version().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.SynapseAPI.Handler.Properties.traceEnabled == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getSynapseAPI_TraceEnabled().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getSynapseAPI_TraceEnabled().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.SynapseAPI.Handler.Properties.statisticsEnabled == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getSynapseAPI_StatisticsEnabled().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getSynapseAPI_StatisticsEnabled().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.SynapseAPI.Handler.Properties.description == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), newValue);
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
