/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.components;

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
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.PropertyGroupMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.PropertyMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.PropertyGroupMediatorPropertiesEditionPart;

public class PropertyGroupMediatorPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	public static String BASE_PART = "Base"; //$NON-NLS-1$

	/**
	 * Settings for properties ReferencesTable
	 */
	protected ReferencesTableSettings propertiesSettings;

	/**
	 * Default constructor
	 */
	public PropertyGroupMediatorPropertiesEditionComponent(PropertiesEditingContext editingContext,
			EObject propertyGroupMediator, String editing_mode) {
		super(editingContext, propertyGroupMediator, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EsbViewsRepository.class;
		partKey = EsbViewsRepository.PropertyGroupMediator.class;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#initPart(java.lang.Object,
	 *      int, org.eclipse.emf.ecore.EObject,
	 *      org.eclipse.emf.ecore.resource.ResourceSet)
	 */
	public void initPart(Object key, int kind, EObject elt, ResourceSet allResource) {
		setInitializing(true);
		if (editingPart != null && key == partKey) {
			editingPart.setContext(elt, allResource);

			final PropertyGroupMediator propertyGroupMediator = (PropertyGroupMediator) elt;
			final PropertyGroupMediatorPropertiesEditionPart basePart = (PropertyGroupMediatorPropertiesEditionPart) editingPart;
			// init values
			if (isAccessible(EsbViewsRepository.PropertyGroupMediator.Properties.description))
				basePart.setDescription(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING,
						propertyGroupMediator.getDescription()));

			if (isAccessible(EsbViewsRepository.PropertyGroupMediator.Properties.commentsList))
				basePart.setCommentsList(propertyGroupMediator.getCommentsList());

			if (isAccessible(EsbViewsRepository.PropertyGroupMediator.Properties.reverse)) {
				basePart.setReverse(propertyGroupMediator.isReverse());
			}
			if (isAccessible(EsbViewsRepository.PropertyGroupMediator.Properties.properties_)) {
				propertiesSettings = new ReferencesTableSettings(propertyGroupMediator,
						EsbPackage.eINSTANCE.getPropertyGroupMediator_Properties());
				basePart.initProperties(propertiesSettings);
			}
			// init filters

			if (isAccessible(EsbViewsRepository.PropertyGroupMediator.Properties.properties_)) {
				basePart.addFilterToProperties(new ViewerFilter() {
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer,
					 *      java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) //$NON-NLS-1$
								|| (element instanceof PropertyMediator);
					}

				});
				// Start of user code for additional businessfilters for properties
				// End of user code
			}
			// init values for referenced views

			// init filters for referenced views

		}
		setInitializing(false);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#associatedFeature(java.lang.Object)
	 */
	public EStructuralFeature associatedFeature(Object editorKey) {
		if (editorKey == EsbViewsRepository.PropertyGroupMediator.Properties.description) {
			return EsbPackage.eINSTANCE.getEsbElement_Description();
		}
		if (editorKey == EsbViewsRepository.PropertyGroupMediator.Properties.commentsList) {
			return EsbPackage.eINSTANCE.getEsbElement_CommentsList();
		}
		if (editorKey == EsbViewsRepository.PropertyGroupMediator.Properties.reverse) {
			return EsbPackage.eINSTANCE.getMediator_Reverse();
		}
		if (editorKey == EsbViewsRepository.PropertyGroupMediator.Properties.properties_) {
			return EsbPackage.eINSTANCE.getPropertyGroupMediator_Properties();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		PropertyGroupMediator propertyGroupMediator = (PropertyGroupMediator) semanticObject;
		if (EsbViewsRepository.PropertyGroupMediator.Properties.description == event.getAffectedEditor()) {
			propertyGroupMediator.setDescription((java.lang.String) EEFConverterUtil
					.createFromString(EcorePackage.Literals.ESTRING, (String) event.getNewValue()));
		}
		if (EsbViewsRepository.PropertyGroupMediator.Properties.commentsList == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				propertyGroupMediator.getCommentsList().clear();
				propertyGroupMediator.getCommentsList().addAll(((EList) event.getNewValue()));
			}
		}
		if (EsbViewsRepository.PropertyGroupMediator.Properties.reverse == event.getAffectedEditor()) {
			propertyGroupMediator.setReverse((Boolean) event.getNewValue());
		}
		if (EsbViewsRepository.PropertyGroupMediator.Properties.properties_ == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext,
						this, propertiesSettings, editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider) editingContext.getAdapterFactory()
						.adapt(semanticObject, PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy policy = provider.getPolicy(context);
					if (policy instanceof CreateEditingPolicy) {
						policy.execute();
					}
				}
			} else if (event.getKind() == PropertiesEditionEvent.EDIT) {
				EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(editingContext, this,
						(EObject) event.getNewValue(), editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider) editingContext.getAdapterFactory()
						.adapt((EObject) event.getNewValue(), PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy editionPolicy = provider.getPolicy(context);
					if (editionPolicy != null) {
						editionPolicy.execute();
					}
				}
			} else if (event.getKind() == PropertiesEditionEvent.REMOVE) {
				propertiesSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				propertiesSettings.move(event.getNewIndex(), (PropertyMediator) event.getNewValue());
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			PropertyGroupMediatorPropertiesEditionPart basePart = (PropertyGroupMediatorPropertiesEditionPart) editingPart;
			if (EsbPackage.eINSTANCE.getEsbElement_Description().equals(msg.getFeature())
					&& msg.getNotifier().equals(semanticObject) && basePart != null
					&& isAccessible(EsbViewsRepository.PropertyGroupMediator.Properties.description)) {
				if (msg.getNewValue() != null) {
					basePart.setDescription(
							EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setDescription("");
				}
			}
			if (EsbPackage.eINSTANCE.getEsbElement_CommentsList().equals(msg.getFeature())
					&& msg.getNotifier().equals(semanticObject) && basePart != null
					&& isAccessible(EsbViewsRepository.PropertyGroupMediator.Properties.commentsList)) {
				if (msg.getNewValue() instanceof EList<?>) {
					basePart.setCommentsList((EList<?>) msg.getNewValue());
				} else if (msg.getNewValue() == null) {
					basePart.setCommentsList(new BasicEList<Object>());
				} else {
					BasicEList<Object> newValueAsList = new BasicEList<Object>();
					newValueAsList.add(msg.getNewValue());
					basePart.setCommentsList(newValueAsList);
				}
			}

			if (EsbPackage.eINSTANCE.getMediator_Reverse().equals(msg.getFeature())
					&& msg.getNotifier().equals(semanticObject) && basePart != null
					&& isAccessible(EsbViewsRepository.PropertyGroupMediator.Properties.reverse))
				basePart.setReverse((Boolean) msg.getNewValue());

			if (EsbPackage.eINSTANCE.getPropertyGroupMediator_Properties().equals(msg.getFeature())
					&& isAccessible(EsbViewsRepository.PropertyGroupMediator.Properties.properties_))
				basePart.updateProperties();
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
				EsbPackage.eINSTANCE.getEsbElement_Description(), EsbPackage.eINSTANCE.getEsbElement_CommentsList(),
				EsbPackage.eINSTANCE.getMediator_Reverse(), EsbPackage.eINSTANCE.getPropertyGroupMediator_Properties());
		return new NotificationFilter[] { filter, };
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#validateValue(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 */
	public Diagnostic validateValue(IPropertiesEditionEvent event) {
		Diagnostic ret = Diagnostic.OK_INSTANCE;
		if (event.getNewValue() != null) {
			try {
				if (EsbViewsRepository.PropertyGroupMediator.Properties.description == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(
								EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(),
								(String) newValue);
					}
					ret = Diagnostician.INSTANCE
							.validate(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.PropertyGroupMediator.Properties.commentsList == event.getAffectedEditor()) {
					BasicDiagnostic chain = new BasicDiagnostic();
					for (Iterator iterator = ((List) event.getNewValue()).iterator(); iterator.hasNext();) {
						chain.add(Diagnostician.INSTANCE.validate(
								EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEAttributeType(),
								iterator.next()));
					}
					ret = chain;
				}
				if (EsbViewsRepository.PropertyGroupMediator.Properties.reverse == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(
								EsbPackage.eINSTANCE.getMediator_Reverse().getEAttributeType(), (String) newValue);
					}
					ret = Diagnostician.INSTANCE
							.validate(EsbPackage.eINSTANCE.getMediator_Reverse().getEAttributeType(), newValue);
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
