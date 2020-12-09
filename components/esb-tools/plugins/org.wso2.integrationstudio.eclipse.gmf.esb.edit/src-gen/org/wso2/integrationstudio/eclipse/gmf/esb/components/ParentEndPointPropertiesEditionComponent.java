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

import org.wso2.integrationstudio.eclipse.gmf.esb.EndPoint;
import org.wso2.integrationstudio.eclipse.gmf.esb.EndPointProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.integrationstudio.eclipse.gmf.esb.ParentEndPoint;

import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.ParentEndPointPropertiesEditionPart;


// End of user code

/**
 * 
 * 
 */
public class ParentEndPointPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
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
	 * Default constructor
	 * 
	 */
	public ParentEndPointPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject parentEndPoint, String editing_mode) {
		super(editingContext, parentEndPoint, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EsbViewsRepository.class;
		partKey = EsbViewsRepository.ParentEndPoint.class;
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
			
			final ParentEndPoint parentEndPoint = (ParentEndPoint)elt;
			final ParentEndPointPropertiesEditionPart basePart = (ParentEndPointPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EsbViewsRepository.ParentEndPoint.Properties.description))
				basePart.setDescription(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, parentEndPoint.getDescription()));
			
			if (isAccessible(EsbViewsRepository.ParentEndPoint.Properties.commentsList))
				basePart.setCommentsList(parentEndPoint.getCommentsList());
			
			if (isAccessible(EsbViewsRepository.ParentEndPoint.Properties.endPointName))
				basePart.setEndPointName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, parentEndPoint.getEndPointName()));
			
			if (isAccessible(EsbViewsRepository.ParentEndPoint.Properties.anonymous)) {
				basePart.setAnonymous(parentEndPoint.isAnonymous());
			}
			if (isAccessible(EsbViewsRepository.ParentEndPoint.Properties.inLine)) {
				basePart.setInLine(parentEndPoint.isInLine());
			}
			if (isAccessible(EsbViewsRepository.ParentEndPoint.Properties.duplicate)) {
				basePart.setDuplicate(parentEndPoint.isDuplicate());
			}
			if (isAccessible(EsbViewsRepository.ParentEndPoint.Properties.properties_)) {
				propertiesSettings = new ReferencesTableSettings(parentEndPoint, EsbPackage.eINSTANCE.getEndPoint_Properties());
				basePart.initProperties(propertiesSettings);
			}
			if (isAccessible(EsbViewsRepository.ParentEndPoint.Properties.reversed)) {
				basePart.setReversed(parentEndPoint.isReversed());
			}
			if (isAccessible(EsbViewsRepository.ParentEndPoint.Properties.children)) {
				childrenSettings = new ReferencesTableSettings(parentEndPoint, EsbPackage.eINSTANCE.getParentEndPoint_Children());
				basePart.initChildren(childrenSettings);
			}
			if (isAccessible(EsbViewsRepository.ParentEndPoint.Properties.name))
				basePart.setName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, parentEndPoint.getName()));
			
			// init filters
			
			
			
			
			
			
			if (isAccessible(EsbViewsRepository.ParentEndPoint.Properties.properties_)) {
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
			
			if (isAccessible(EsbViewsRepository.ParentEndPoint.Properties.children)) {
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
		if (editorKey == EsbViewsRepository.ParentEndPoint.Properties.description) {
			return EsbPackage.eINSTANCE.getEsbElement_Description();
		}
		if (editorKey == EsbViewsRepository.ParentEndPoint.Properties.commentsList) {
			return EsbPackage.eINSTANCE.getEsbElement_CommentsList();
		}
		if (editorKey == EsbViewsRepository.ParentEndPoint.Properties.endPointName) {
			return EsbPackage.eINSTANCE.getEndPoint_EndPointName();
		}
		if (editorKey == EsbViewsRepository.ParentEndPoint.Properties.anonymous) {
			return EsbPackage.eINSTANCE.getEndPoint_Anonymous();
		}
		if (editorKey == EsbViewsRepository.ParentEndPoint.Properties.inLine) {
			return EsbPackage.eINSTANCE.getEndPoint_InLine();
		}
		if (editorKey == EsbViewsRepository.ParentEndPoint.Properties.duplicate) {
			return EsbPackage.eINSTANCE.getEndPoint_Duplicate();
		}
		if (editorKey == EsbViewsRepository.ParentEndPoint.Properties.properties_) {
			return EsbPackage.eINSTANCE.getEndPoint_Properties();
		}
		if (editorKey == EsbViewsRepository.ParentEndPoint.Properties.reversed) {
			return EsbPackage.eINSTANCE.getEndPoint_Reversed();
		}
		if (editorKey == EsbViewsRepository.ParentEndPoint.Properties.children) {
			return EsbPackage.eINSTANCE.getParentEndPoint_Children();
		}
		if (editorKey == EsbViewsRepository.ParentEndPoint.Properties.name) {
			return EsbPackage.eINSTANCE.getParentEndPoint_Name();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		ParentEndPoint parentEndPoint = (ParentEndPoint)semanticObject;
		if (EsbViewsRepository.ParentEndPoint.Properties.description == event.getAffectedEditor()) {
			parentEndPoint.setDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.ParentEndPoint.Properties.commentsList == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				parentEndPoint.getCommentsList().clear();
				parentEndPoint.getCommentsList().addAll(((EList) event.getNewValue()));
			}
		}
		if (EsbViewsRepository.ParentEndPoint.Properties.endPointName == event.getAffectedEditor()) {
			parentEndPoint.setEndPointName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.ParentEndPoint.Properties.anonymous == event.getAffectedEditor()) {
			parentEndPoint.setAnonymous((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.ParentEndPoint.Properties.inLine == event.getAffectedEditor()) {
			parentEndPoint.setInLine((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.ParentEndPoint.Properties.duplicate == event.getAffectedEditor()) {
			parentEndPoint.setDuplicate((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.ParentEndPoint.Properties.properties_ == event.getAffectedEditor()) {
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
		if (EsbViewsRepository.ParentEndPoint.Properties.reversed == event.getAffectedEditor()) {
			parentEndPoint.setReversed((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.ParentEndPoint.Properties.children == event.getAffectedEditor()) {
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
		if (EsbViewsRepository.ParentEndPoint.Properties.name == event.getAffectedEditor()) {
			parentEndPoint.setName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			ParentEndPointPropertiesEditionPart basePart = (ParentEndPointPropertiesEditionPart)editingPart;
			if (EsbPackage.eINSTANCE.getEsbElement_Description().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.ParentEndPoint.Properties.description)) {
				if (msg.getNewValue() != null) {
					basePart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setDescription("");
				}
			}
			if (EsbPackage.eINSTANCE.getEsbElement_CommentsList().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.ParentEndPoint.Properties.commentsList)) {
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
			
			if (EsbPackage.eINSTANCE.getEndPoint_EndPointName().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.ParentEndPoint.Properties.endPointName)) {
				if (msg.getNewValue() != null) {
					basePart.setEndPointName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setEndPointName("");
				}
			}
			if (EsbPackage.eINSTANCE.getEndPoint_Anonymous().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.ParentEndPoint.Properties.anonymous))
				basePart.setAnonymous((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getEndPoint_InLine().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.ParentEndPoint.Properties.inLine))
				basePart.setInLine((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getEndPoint_Duplicate().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.ParentEndPoint.Properties.duplicate))
				basePart.setDuplicate((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getEndPoint_Properties().equals(msg.getFeature()) && isAccessible(EsbViewsRepository.ParentEndPoint.Properties.properties_))
				basePart.updateProperties();
			if (EsbPackage.eINSTANCE.getEndPoint_Reversed().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.ParentEndPoint.Properties.reversed))
				basePart.setReversed((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getParentEndPoint_Children().equals(msg.getFeature()) && isAccessible(EsbViewsRepository.ParentEndPoint.Properties.children))
				basePart.updateChildren();
			if (EsbPackage.eINSTANCE.getParentEndPoint_Name().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.ParentEndPoint.Properties.name)) {
				if (msg.getNewValue() != null) {
					basePart.setName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setName("");
				}
			}
			
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
			EsbPackage.eINSTANCE.getParentEndPoint_Name()		);
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
				if (EsbViewsRepository.ParentEndPoint.Properties.description == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.ParentEndPoint.Properties.commentsList == event.getAffectedEditor()) {
					BasicDiagnostic chain = new BasicDiagnostic();
					for (Iterator iterator = ((List)event.getNewValue()).iterator(); iterator.hasNext();) {
						chain.add(Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEAttributeType(), iterator.next()));
					}
					ret = chain;
				}
				if (EsbViewsRepository.ParentEndPoint.Properties.endPointName == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEndPoint_EndPointName().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEndPoint_EndPointName().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.ParentEndPoint.Properties.anonymous == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEndPoint_Anonymous().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEndPoint_Anonymous().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.ParentEndPoint.Properties.inLine == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEndPoint_InLine().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEndPoint_InLine().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.ParentEndPoint.Properties.duplicate == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEndPoint_Duplicate().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEndPoint_Duplicate().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.ParentEndPoint.Properties.reversed == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEndPoint_Reversed().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEndPoint_Reversed().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.ParentEndPoint.Properties.name == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getParentEndPoint_Name().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getParentEndPoint_Name().getEAttributeType(), newValue);
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
