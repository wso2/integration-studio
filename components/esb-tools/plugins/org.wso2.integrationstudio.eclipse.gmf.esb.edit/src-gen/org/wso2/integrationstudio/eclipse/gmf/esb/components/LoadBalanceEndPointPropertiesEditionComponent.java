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

import org.wso2.integrationstudio.eclipse.gmf.esb.EndPoint;
import org.wso2.integrationstudio.eclipse.gmf.esb.EndPointProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.integrationstudio.eclipse.gmf.esb.LoadBalanceEndPoint;
import org.wso2.integrationstudio.eclipse.gmf.esb.LoadBalanceEndPointOutputConnector;
import org.wso2.integrationstudio.eclipse.gmf.esb.LoadBalanceSessionType;

import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.LoadBalanceEndPointPropertiesEditionPart;
import org.wso2.integrationstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;


// End of user code

/**
 * 
 * 
 */
public class LoadBalanceEndPointPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	/**
	 * Settings for properties ReferencesTable
	 */
	protected ReferencesTableSettings propertiesSettings;
	
	/**
	 * Settings for Children ReferencesTable
	 */
	protected ReferencesTableSettings childrenSettings;
	
	/**
	 * Settings for outputConnector ReferencesTable
	 */
	protected ReferencesTableSettings outputConnectorSettings;
	
	
	/**
   * Settings for members ReferencesTable
   */
  protected ReferencesTableSettings membersSettings;


  /**
	 * Default constructor
	 * 
	 */
	public LoadBalanceEndPointPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject loadBalanceEndPoint, String editing_mode) {
		super(editingContext, loadBalanceEndPoint, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EsbViewsRepository.class;
		partKey = EsbViewsRepository.LoadBalanceEndPoint.class;
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
			
			final LoadBalanceEndPoint loadBalanceEndPoint = (LoadBalanceEndPoint)elt;
			final LoadBalanceEndPointPropertiesEditionPart basePart = (LoadBalanceEndPointPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EsbViewsRepository.LoadBalanceEndPoint.Properties.description))
				basePart.setDescription(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, loadBalanceEndPoint.getDescription()));
			
			if (isAccessible(EsbViewsRepository.LoadBalanceEndPoint.Properties.commentsList))
				basePart.setCommentsList(loadBalanceEndPoint.getCommentsList());
			
			if (isAccessible(EsbViewsRepository.LoadBalanceEndPoint.Properties.endPointName))
				basePart.setEndPointName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, loadBalanceEndPoint.getEndPointName()));
			
			if (isAccessible(EsbViewsRepository.LoadBalanceEndPoint.Properties.anonymous)) {
				basePart.setAnonymous(loadBalanceEndPoint.isAnonymous());
			}
			if (isAccessible(EsbViewsRepository.LoadBalanceEndPoint.Properties.inLine)) {
				basePart.setInLine(loadBalanceEndPoint.isInLine());
			}
			if (isAccessible(EsbViewsRepository.LoadBalanceEndPoint.Properties.duplicate)) {
				basePart.setDuplicate(loadBalanceEndPoint.isDuplicate());
			}
			if (isAccessible(EsbViewsRepository.LoadBalanceEndPoint.Properties.properties_)) {
				propertiesSettings = new ReferencesTableSettings(loadBalanceEndPoint, EsbPackage.eINSTANCE.getEndPoint_Properties());
				basePart.initProperties(propertiesSettings);
			}
			if (isAccessible(EsbViewsRepository.LoadBalanceEndPoint.Properties.reversed)) {
				basePart.setReversed(loadBalanceEndPoint.isReversed());
			}
			if (isAccessible(EsbViewsRepository.LoadBalanceEndPoint.Properties.children)) {
				childrenSettings = new ReferencesTableSettings(loadBalanceEndPoint, EsbPackage.eINSTANCE.getParentEndPoint_Children());
				basePart.initChildren(childrenSettings);
			}
			if (isAccessible(EsbViewsRepository.LoadBalanceEndPoint.Properties.name))
				basePart.setName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, loadBalanceEndPoint.getName()));
			
			if (isAccessible(EsbViewsRepository.LoadBalanceEndPoint.Properties.failover)) {
				basePart.setFailover(loadBalanceEndPoint.isFailover());
			}
			if (isAccessible(EsbViewsRepository.LoadBalanceEndPoint.Properties.policy))
				basePart.setPolicy(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, loadBalanceEndPoint.getPolicy()));
			
			if (isAccessible(EsbViewsRepository.LoadBalanceEndPoint.Properties.outputConnector)) {
				outputConnectorSettings = new ReferencesTableSettings(loadBalanceEndPoint, EsbPackage.eINSTANCE.getLoadBalanceEndPoint_OutputConnector());
				basePart.initOutputConnector(outputConnectorSettings);
			}
			if (isAccessible(EsbViewsRepository.LoadBalanceEndPoint.Properties.sessionType)) {
				basePart.initSessionType(EEFUtils.choiceOfValues(loadBalanceEndPoint, EsbPackage.eINSTANCE.getLoadBalanceEndPoint_SessionType()), loadBalanceEndPoint.getSessionType());
			}
			if (isAccessible(EsbViewsRepository.LoadBalanceEndPoint.Properties.algorithm))
				basePart.setAlgorithm(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, loadBalanceEndPoint.getAlgorithm()));
			
			if (isAccessible(EsbViewsRepository.LoadBalanceEndPoint.Properties.sessionTimeout)) {
				basePart.setSessionTimeout(EEFConverterUtil.convertToString(EcorePackage.Literals.ELONG, loadBalanceEndPoint.getSessionTimeout()));
			}
			
			if (isAccessible(EsbViewsRepository.LoadBalanceEndPoint.Properties.buildMessage)) {
				basePart.setBuildMessage(loadBalanceEndPoint.isBuildMessage());
			}
			// init filters
			
			
			
			
			
			
			if (isAccessible(EsbViewsRepository.LoadBalanceEndPoint.Properties.properties_)) {
				basePart.addFilterToProperties(new ViewerFilter() {
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof EndPointProperty); //$NON-NLS-1$ 
					}
			
				});
				// Start of user code for additional businessfilters for properties
				// End of user code
			}
			
			if (isAccessible(EsbViewsRepository.LoadBalanceEndPoint.Properties.children)) {
				basePart.addFilterToChildren(new ViewerFilter() {
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof EndPoint); //$NON-NLS-1$ 
					}
			
				});
				// Start of user code for additional businessfilters for Children
				// End of user code
			}
			
			
			
			if (isAccessible(EsbViewsRepository.LoadBalanceEndPoint.Properties.outputConnector)) {
				basePart.addFilterToOutputConnector(new ViewerFilter() {
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof LoadBalanceEndPointOutputConnector); //$NON-NLS-1$ 
					}
			
				});
				// Start of user code for additional businessfilters for outputConnector
				// End of user code
			}
			
			
			
			
			// init values for referenced views
			if (isAccessible(EsbViewsRepository.LoadBalanceEndPoint.Properties.members)) {
				membersSettings = new ReferencesTableSettings(loadBalanceEndPoint, EsbPackage.eINSTANCE.getLoadBalanceEndPoint_Member());
				basePart.initMembers(membersSettings);
			}
			
			// init filters for referenced views
			
		}
		setInitializing(false);
	}




















	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#associatedFeature(java.lang.Object)
	 */
	public EStructuralFeature associatedFeature(Object editorKey) {
		if (editorKey == EsbViewsRepository.LoadBalanceEndPoint.Properties.description) {
			return EsbPackage.eINSTANCE.getEsbElement_Description();
		}
		if (editorKey == EsbViewsRepository.LoadBalanceEndPoint.Properties.commentsList) {
			return EsbPackage.eINSTANCE.getEsbElement_CommentsList();
		}
		if (editorKey == EsbViewsRepository.LoadBalanceEndPoint.Properties.endPointName) {
			return EsbPackage.eINSTANCE.getEndPoint_EndPointName();
		}
		if (editorKey == EsbViewsRepository.LoadBalanceEndPoint.Properties.anonymous) {
			return EsbPackage.eINSTANCE.getEndPoint_Anonymous();
		}
		if (editorKey == EsbViewsRepository.LoadBalanceEndPoint.Properties.inLine) {
			return EsbPackage.eINSTANCE.getEndPoint_InLine();
		}
		if (editorKey == EsbViewsRepository.LoadBalanceEndPoint.Properties.duplicate) {
			return EsbPackage.eINSTANCE.getEndPoint_Duplicate();
		}
		if (editorKey == EsbViewsRepository.LoadBalanceEndPoint.Properties.properties_) {
			return EsbPackage.eINSTANCE.getEndPoint_Properties();
		}
		if (editorKey == EsbViewsRepository.LoadBalanceEndPoint.Properties.reversed) {
			return EsbPackage.eINSTANCE.getEndPoint_Reversed();
		}
		if (editorKey == EsbViewsRepository.LoadBalanceEndPoint.Properties.children) {
			return EsbPackage.eINSTANCE.getParentEndPoint_Children();
		}
		if (editorKey == EsbViewsRepository.LoadBalanceEndPoint.Properties.name) {
			return EsbPackage.eINSTANCE.getParentEndPoint_Name();
		}
		if (editorKey == EsbViewsRepository.LoadBalanceEndPoint.Properties.failover) {
			return EsbPackage.eINSTANCE.getLoadBalanceEndPoint_Failover();
		}
		if (editorKey == EsbViewsRepository.LoadBalanceEndPoint.Properties.policy) {
			return EsbPackage.eINSTANCE.getLoadBalanceEndPoint_Policy();
		}
		if (editorKey == EsbViewsRepository.LoadBalanceEndPoint.Properties.outputConnector) {
			return EsbPackage.eINSTANCE.getLoadBalanceEndPoint_OutputConnector();
		}
		if (editorKey == EsbViewsRepository.LoadBalanceEndPoint.Properties.sessionType) {
			return EsbPackage.eINSTANCE.getLoadBalanceEndPoint_SessionType();
		}
		if (editorKey == EsbViewsRepository.LoadBalanceEndPoint.Properties.algorithm) {
			return EsbPackage.eINSTANCE.getLoadBalanceEndPoint_Algorithm();
		}
		if (editorKey == EsbViewsRepository.LoadBalanceEndPoint.Properties.sessionTimeout) {
			return EsbPackage.eINSTANCE.getLoadBalanceEndPoint_SessionTimeout();
		}
		if (editorKey == EsbViewsRepository.LoadBalanceEndPoint.Properties.buildMessage) {
			return EsbPackage.eINSTANCE.getLoadBalanceEndPoint_BuildMessage();
		}
		if (editorKey == EsbViewsRepository.LoadBalanceEndPoint.Properties.members) {
			return EsbPackage.eINSTANCE.getLoadBalanceEndPoint_Member();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		LoadBalanceEndPoint loadBalanceEndPoint = (LoadBalanceEndPoint)semanticObject;
		if (EsbViewsRepository.LoadBalanceEndPoint.Properties.description == event.getAffectedEditor()) {
			loadBalanceEndPoint.setDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.LoadBalanceEndPoint.Properties.commentsList == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				loadBalanceEndPoint.getCommentsList().clear();
				loadBalanceEndPoint.getCommentsList().addAll(((EList) event.getNewValue()));
			}
		}
		if (EsbViewsRepository.LoadBalanceEndPoint.Properties.endPointName == event.getAffectedEditor()) {
			loadBalanceEndPoint.setEndPointName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.LoadBalanceEndPoint.Properties.anonymous == event.getAffectedEditor()) {
			loadBalanceEndPoint.setAnonymous((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.LoadBalanceEndPoint.Properties.inLine == event.getAffectedEditor()) {
			loadBalanceEndPoint.setInLine((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.LoadBalanceEndPoint.Properties.duplicate == event.getAffectedEditor()) {
			loadBalanceEndPoint.setDuplicate((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.LoadBalanceEndPoint.Properties.properties_ == event.getAffectedEditor()) {
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
				propertiesSettings.move(event.getNewIndex(), (EndPointProperty) event.getNewValue());
			}
		}
		if (EsbViewsRepository.LoadBalanceEndPoint.Properties.reversed == event.getAffectedEditor()) {
			loadBalanceEndPoint.setReversed((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.LoadBalanceEndPoint.Properties.children == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, childrenSettings, editingContext.getAdapterFactory());
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
				childrenSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				childrenSettings.move(event.getNewIndex(), (EndPoint) event.getNewValue());
			}
		}
		if (EsbViewsRepository.LoadBalanceEndPoint.Properties.name == event.getAffectedEditor()) {
			loadBalanceEndPoint.setName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.LoadBalanceEndPoint.Properties.failover == event.getAffectedEditor()) {
			loadBalanceEndPoint.setFailover((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.LoadBalanceEndPoint.Properties.policy == event.getAffectedEditor()) {
			loadBalanceEndPoint.setPolicy((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.LoadBalanceEndPoint.Properties.outputConnector == event.getAffectedEditor()) {
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
				outputConnectorSettings.move(event.getNewIndex(), (LoadBalanceEndPointOutputConnector) event.getNewValue());
			}
		}
		if (EsbViewsRepository.LoadBalanceEndPoint.Properties.sessionType == event.getAffectedEditor()) {
			loadBalanceEndPoint.setSessionType((LoadBalanceSessionType)event.getNewValue());
		}
		if (EsbViewsRepository.LoadBalanceEndPoint.Properties.algorithm == event.getAffectedEditor()) {
			loadBalanceEndPoint.setAlgorithm((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.LoadBalanceEndPoint.Properties.sessionTimeout == event.getAffectedEditor()) {
			loadBalanceEndPoint.setSessionTimeout((EEFConverterUtil.createLongFromString(EcorePackage.Literals.ELONG, (String)event.getNewValue())));
		}
		if (EsbViewsRepository.LoadBalanceEndPoint.Properties.buildMessage == event.getAffectedEditor()) {
			loadBalanceEndPoint.setBuildMessage((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.LoadBalanceEndPoint.Properties.members == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, membersSettings, editingContext.getAdapterFactory());
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
				membersSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				membersSettings.move(event.getNewIndex(), (EndPoint) event.getNewValue());
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			LoadBalanceEndPointPropertiesEditionPart basePart = (LoadBalanceEndPointPropertiesEditionPart)editingPart;
			if (EsbPackage.eINSTANCE.getEsbElement_Description().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.LoadBalanceEndPoint.Properties.description)) {
				if (msg.getNewValue() != null) {
					basePart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setDescription("");
				}
			}
			if (EsbPackage.eINSTANCE.getEsbElement_CommentsList().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.LoadBalanceEndPoint.Properties.commentsList)) {
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
			
			if (EsbPackage.eINSTANCE.getEndPoint_EndPointName().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.LoadBalanceEndPoint.Properties.endPointName)) {
				if (msg.getNewValue() != null) {
					basePart.setEndPointName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setEndPointName("");
				}
			}
			if (EsbPackage.eINSTANCE.getEndPoint_Anonymous().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.LoadBalanceEndPoint.Properties.anonymous))
				basePart.setAnonymous((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getEndPoint_InLine().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.LoadBalanceEndPoint.Properties.inLine))
				basePart.setInLine((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getEndPoint_Duplicate().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.LoadBalanceEndPoint.Properties.duplicate))
				basePart.setDuplicate((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getEndPoint_Properties().equals(msg.getFeature()) && isAccessible(EsbViewsRepository.LoadBalanceEndPoint.Properties.properties_))
				basePart.updateProperties();
			if (EsbPackage.eINSTANCE.getEndPoint_Reversed().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.LoadBalanceEndPoint.Properties.reversed))
				basePart.setReversed((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getParentEndPoint_Children().equals(msg.getFeature()) && isAccessible(EsbViewsRepository.LoadBalanceEndPoint.Properties.children))
				basePart.updateChildren();
			if (EsbPackage.eINSTANCE.getParentEndPoint_Name().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.LoadBalanceEndPoint.Properties.name)) {
				if (msg.getNewValue() != null) {
					basePart.setName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setName("");
				}
			}
			if (EsbPackage.eINSTANCE.getLoadBalanceEndPoint_Failover().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.LoadBalanceEndPoint.Properties.failover))
				basePart.setFailover((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getLoadBalanceEndPoint_Policy().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.LoadBalanceEndPoint.Properties.policy)) {
				if (msg.getNewValue() != null) {
					basePart.setPolicy(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setPolicy("");
				}
			}
			if (EsbPackage.eINSTANCE.getLoadBalanceEndPoint_OutputConnector().equals(msg.getFeature()) && isAccessible(EsbViewsRepository.LoadBalanceEndPoint.Properties.outputConnector))
				basePart.updateOutputConnector();
			if (EsbPackage.eINSTANCE.getLoadBalanceEndPoint_SessionType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.LoadBalanceEndPoint.Properties.sessionType))
				basePart.setSessionType((LoadBalanceSessionType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getLoadBalanceEndPoint_Algorithm().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.LoadBalanceEndPoint.Properties.algorithm)) {
				if (msg.getNewValue() != null) {
					basePart.setAlgorithm(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setAlgorithm("");
				}
			}
			if (EsbPackage.eINSTANCE.getLoadBalanceEndPoint_SessionTimeout().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.LoadBalanceEndPoint.Properties.sessionTimeout)) {
				if (msg.getNewValue() != null) {
					basePart.setSessionTimeout(EcoreUtil.convertToString(EcorePackage.Literals.ELONG, msg.getNewValue()));
				} else {
					basePart.setSessionTimeout("");
				}
			}
			if (EsbPackage.eINSTANCE.getLoadBalanceEndPoint_BuildMessage().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.LoadBalanceEndPoint.Properties.buildMessage))
				basePart.setBuildMessage((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getLoadBalanceEndPoint_Member().equals(msg.getFeature()) && isAccessible(EsbViewsRepository.LoadBalanceEndPoint.Properties.members))
				basePart.updateMembers();
			
			
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
			EsbPackage.eINSTANCE.getEndPoint_EndPointName(),
			EsbPackage.eINSTANCE.getEndPoint_Anonymous(),
			EsbPackage.eINSTANCE.getEndPoint_InLine(),
			EsbPackage.eINSTANCE.getEndPoint_Duplicate(),
			EsbPackage.eINSTANCE.getEndPoint_Properties(),
			EsbPackage.eINSTANCE.getEndPoint_Reversed(),
			EsbPackage.eINSTANCE.getParentEndPoint_Children(),
			EsbPackage.eINSTANCE.getParentEndPoint_Name(),
			EsbPackage.eINSTANCE.getLoadBalanceEndPoint_Failover(),
			EsbPackage.eINSTANCE.getLoadBalanceEndPoint_Policy(),
			EsbPackage.eINSTANCE.getLoadBalanceEndPoint_OutputConnector(),
			EsbPackage.eINSTANCE.getLoadBalanceEndPoint_SessionType(),
			EsbPackage.eINSTANCE.getLoadBalanceEndPoint_Algorithm(),
			EsbPackage.eINSTANCE.getLoadBalanceEndPoint_SessionTimeout(),
			EsbPackage.eINSTANCE.getLoadBalanceEndPoint_BuildMessage(),
			EsbPackage.eINSTANCE.getLoadBalanceEndPoint_Member());
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
				if (EsbViewsRepository.LoadBalanceEndPoint.Properties.description == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.LoadBalanceEndPoint.Properties.commentsList == event.getAffectedEditor()) {
					BasicDiagnostic chain = new BasicDiagnostic();
					for (Iterator iterator = ((List)event.getNewValue()).iterator(); iterator.hasNext();) {
						chain.add(Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEAttributeType(), iterator.next()));
					}
					ret = chain;
				}
				if (EsbViewsRepository.LoadBalanceEndPoint.Properties.endPointName == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEndPoint_EndPointName().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEndPoint_EndPointName().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.LoadBalanceEndPoint.Properties.anonymous == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEndPoint_Anonymous().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEndPoint_Anonymous().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.LoadBalanceEndPoint.Properties.inLine == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEndPoint_InLine().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEndPoint_InLine().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.LoadBalanceEndPoint.Properties.duplicate == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEndPoint_Duplicate().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEndPoint_Duplicate().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.LoadBalanceEndPoint.Properties.reversed == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEndPoint_Reversed().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEndPoint_Reversed().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.LoadBalanceEndPoint.Properties.name == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getParentEndPoint_Name().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getParentEndPoint_Name().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.LoadBalanceEndPoint.Properties.failover == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getLoadBalanceEndPoint_Failover().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getLoadBalanceEndPoint_Failover().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.LoadBalanceEndPoint.Properties.policy == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getLoadBalanceEndPoint_Policy().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getLoadBalanceEndPoint_Policy().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.LoadBalanceEndPoint.Properties.sessionType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getLoadBalanceEndPoint_SessionType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getLoadBalanceEndPoint_SessionType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.LoadBalanceEndPoint.Properties.algorithm == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getLoadBalanceEndPoint_Algorithm().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getLoadBalanceEndPoint_Algorithm().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.LoadBalanceEndPoint.Properties.sessionTimeout == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getLoadBalanceEndPoint_SessionTimeout().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getLoadBalanceEndPoint_SessionTimeout().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.LoadBalanceEndPoint.Properties.buildMessage == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getLoadBalanceEndPoint_BuildMessage().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getLoadBalanceEndPoint_BuildMessage().getEAttributeType(), newValue);
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
