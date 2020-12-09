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
import org.wso2.integrationstudio.eclipse.gmf.esb.Task;
import org.wso2.integrationstudio.eclipse.gmf.esb.TaskProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.TaskTriggerType;

import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.TaskPropertiesEditionPart;


// End of user code

/**
 * 
 * 
 */
public class TaskPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	/**
	 * Settings for taskProperties ReferencesTable
	 */
	protected ReferencesTableSettings taskPropertiesSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public TaskPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject task, String editing_mode) {
		super(editingContext, task, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EsbViewsRepository.class;
		partKey = EsbViewsRepository.Task.class;
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
			
			final Task task = (Task)elt;
			final TaskPropertiesEditionPart basePart = (TaskPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EsbViewsRepository.Task.Properties.description))
				basePart.setDescription(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, task.getDescription()));
			
			if (isAccessible(EsbViewsRepository.Task.Properties.commentsList))
				basePart.setCommentsList(task.getCommentsList());
			
			if (isAccessible(EsbViewsRepository.Task.Properties.taskName))
				basePart.setTaskName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, task.getTaskName()));
			
			if (isAccessible(EsbViewsRepository.Task.Properties.taskGroup))
				basePart.setTaskGroup(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, task.getTaskGroup()));
			
			if (isAccessible(EsbViewsRepository.Task.Properties.triggerType)) {
				basePart.initTriggerType(EEFUtils.choiceOfValues(task, EsbPackage.eINSTANCE.getTask_TriggerType()), task.getTriggerType());
			}
			if (isAccessible(EsbViewsRepository.Task.Properties.count)) {
				basePart.setCount(EEFConverterUtil.convertToString(EcorePackage.Literals.ELONG, task.getCount()));
			}
			
			if (isAccessible(EsbViewsRepository.Task.Properties.interval)) {
				basePart.setInterval(EEFConverterUtil.convertToString(EcorePackage.Literals.ELONG, task.getInterval()));
			}
			
			if (isAccessible(EsbViewsRepository.Task.Properties.cron))
				basePart.setCron(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, task.getCron()));
			
			if (isAccessible(EsbViewsRepository.Task.Properties.pinnedServers))
				basePart.setPinnedServers(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, task.getPinnedServers()));
			
			if (isAccessible(EsbViewsRepository.Task.Properties.taskImplementation))
				basePart.setTaskImplementation(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, task.getTaskImplementation()));
			
			if (isAccessible(EsbViewsRepository.Task.Properties.taskProperties)) {
				taskPropertiesSettings = new ReferencesTableSettings(task, EsbPackage.eINSTANCE.getTask_TaskProperties());
				basePart.initTaskProperties(taskPropertiesSettings);
			}
			// init filters
			
			
			
			
			
			
			
			
			
			
			if (isAccessible(EsbViewsRepository.Task.Properties.taskProperties)) {
				basePart.addFilterToTaskProperties(new ViewerFilter() {
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof TaskProperty); //$NON-NLS-1$ 
					}
			
				});
				// Start of user code for additional businessfilters for taskProperties
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
		if (editorKey == EsbViewsRepository.Task.Properties.description) {
			return EsbPackage.eINSTANCE.getEsbElement_Description();
		}
		if (editorKey == EsbViewsRepository.Task.Properties.commentsList) {
			return EsbPackage.eINSTANCE.getEsbElement_CommentsList();
		}
		if (editorKey == EsbViewsRepository.Task.Properties.taskName) {
			return EsbPackage.eINSTANCE.getTask_TaskName();
		}
		if (editorKey == EsbViewsRepository.Task.Properties.taskGroup) {
			return EsbPackage.eINSTANCE.getTask_TaskGroup();
		}
		if (editorKey == EsbViewsRepository.Task.Properties.triggerType) {
			return EsbPackage.eINSTANCE.getTask_TriggerType();
		}
		if (editorKey == EsbViewsRepository.Task.Properties.count) {
			return EsbPackage.eINSTANCE.getTask_Count();
		}
		if (editorKey == EsbViewsRepository.Task.Properties.interval) {
			return EsbPackage.eINSTANCE.getTask_Interval();
		}
		if (editorKey == EsbViewsRepository.Task.Properties.cron) {
			return EsbPackage.eINSTANCE.getTask_Cron();
		}
		if (editorKey == EsbViewsRepository.Task.Properties.pinnedServers) {
			return EsbPackage.eINSTANCE.getTask_PinnedServers();
		}
		if (editorKey == EsbViewsRepository.Task.Properties.taskImplementation) {
			return EsbPackage.eINSTANCE.getTask_TaskImplementation();
		}
		if (editorKey == EsbViewsRepository.Task.Properties.taskProperties) {
			return EsbPackage.eINSTANCE.getTask_TaskProperties();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		Task task = (Task)semanticObject;
		if (EsbViewsRepository.Task.Properties.description == event.getAffectedEditor()) {
			task.setDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.Task.Properties.commentsList == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				task.getCommentsList().clear();
				task.getCommentsList().addAll(((EList) event.getNewValue()));
			}
		}
		if (EsbViewsRepository.Task.Properties.taskName == event.getAffectedEditor()) {
			task.setTaskName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.Task.Properties.taskGroup == event.getAffectedEditor()) {
			task.setTaskGroup((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.Task.Properties.triggerType == event.getAffectedEditor()) {
			task.setTriggerType((TaskTriggerType)event.getNewValue());
		}
		if (EsbViewsRepository.Task.Properties.count == event.getAffectedEditor()) {
			task.setCount((EEFConverterUtil.createLongFromString(EcorePackage.Literals.ELONG, (String)event.getNewValue())));
		}
		if (EsbViewsRepository.Task.Properties.interval == event.getAffectedEditor()) {
			task.setInterval((EEFConverterUtil.createLongFromString(EcorePackage.Literals.ELONG, (String)event.getNewValue())));
		}
		if (EsbViewsRepository.Task.Properties.cron == event.getAffectedEditor()) {
			task.setCron((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.Task.Properties.pinnedServers == event.getAffectedEditor()) {
			task.setPinnedServers((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.Task.Properties.taskImplementation == event.getAffectedEditor()) {
			task.setTaskImplementation((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.Task.Properties.taskProperties == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, taskPropertiesSettings, editingContext.getAdapterFactory());
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
				taskPropertiesSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				taskPropertiesSettings.move(event.getNewIndex(), (TaskProperty) event.getNewValue());
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
			TaskPropertiesEditionPart basePart = (TaskPropertiesEditionPart)editingPart;
			if (EsbPackage.eINSTANCE.getEsbElement_Description().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.Task.Properties.description)) {
				if (msg.getNewValue() != null) {
					basePart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setDescription("");
				}
			}
			if (EsbPackage.eINSTANCE.getEsbElement_CommentsList().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.Task.Properties.commentsList)) {
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
			
			if (EsbPackage.eINSTANCE.getTask_TaskName().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.Task.Properties.taskName)) {
				if (msg.getNewValue() != null) {
					basePart.setTaskName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTaskName("");
				}
			}
			if (EsbPackage.eINSTANCE.getTask_TaskGroup().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.Task.Properties.taskGroup)) {
				if (msg.getNewValue() != null) {
					basePart.setTaskGroup(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTaskGroup("");
				}
			}
			if (EsbPackage.eINSTANCE.getTask_TriggerType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.Task.Properties.triggerType))
				basePart.setTriggerType((TaskTriggerType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getTask_Count().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.Task.Properties.count)) {
				if (msg.getNewValue() != null) {
					basePart.setCount(EcoreUtil.convertToString(EcorePackage.Literals.ELONG, msg.getNewValue()));
				} else {
					basePart.setCount("");
				}
			}
			if (EsbPackage.eINSTANCE.getTask_Interval().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.Task.Properties.interval)) {
				if (msg.getNewValue() != null) {
					basePart.setInterval(EcoreUtil.convertToString(EcorePackage.Literals.ELONG, msg.getNewValue()));
				} else {
					basePart.setInterval("");
				}
			}
			if (EsbPackage.eINSTANCE.getTask_Cron().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.Task.Properties.cron)) {
				if (msg.getNewValue() != null) {
					basePart.setCron(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setCron("");
				}
			}
			if (EsbPackage.eINSTANCE.getTask_PinnedServers().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.Task.Properties.pinnedServers)) {
				if (msg.getNewValue() != null) {
					basePart.setPinnedServers(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setPinnedServers("");
				}
			}
			if (EsbPackage.eINSTANCE.getTask_TaskImplementation().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.Task.Properties.taskImplementation)) {
				if (msg.getNewValue() != null) {
					basePart.setTaskImplementation(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setTaskImplementation("");
				}
			}
			if (EsbPackage.eINSTANCE.getTask_TaskProperties().equals(msg.getFeature()) && isAccessible(EsbViewsRepository.Task.Properties.taskProperties))
				basePart.updateTaskProperties();
			
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
			EsbPackage.eINSTANCE.getTask_TaskName(),
			EsbPackage.eINSTANCE.getTask_TaskGroup(),
			EsbPackage.eINSTANCE.getTask_TriggerType(),
			EsbPackage.eINSTANCE.getTask_Count(),
			EsbPackage.eINSTANCE.getTask_Interval(),
			EsbPackage.eINSTANCE.getTask_Cron(),
			EsbPackage.eINSTANCE.getTask_PinnedServers(),
			EsbPackage.eINSTANCE.getTask_TaskImplementation(),
			EsbPackage.eINSTANCE.getTask_TaskProperties()		);
		return new NotificationFilter[] {filter,};
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#isRequired(java.lang.Object, int)
	 * 
	 */
	public boolean isRequired(Object key, int kind) {
		return key == EsbViewsRepository.Task.Properties.taskImplementation;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#getHelpContent(java.lang.Object, int)
	 * 
	 */
	public String getHelpContent(Object key, int kind) {
		if (key == EsbViewsRepository.Task.Properties.cron)
			return ""; //$NON-NLS-1$
		if (key == EsbViewsRepository.Task.Properties.taskProperties)
			return ""; //$NON-NLS-1$
		return super.getHelpContent(key, kind);
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
				if (EsbViewsRepository.Task.Properties.description == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.Task.Properties.commentsList == event.getAffectedEditor()) {
					BasicDiagnostic chain = new BasicDiagnostic();
					for (Iterator iterator = ((List)event.getNewValue()).iterator(); iterator.hasNext();) {
						chain.add(Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEAttributeType(), iterator.next()));
					}
					ret = chain;
				}
				if (EsbViewsRepository.Task.Properties.taskName == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getTask_TaskName().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getTask_TaskName().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.Task.Properties.taskGroup == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getTask_TaskGroup().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getTask_TaskGroup().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.Task.Properties.triggerType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getTask_TriggerType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getTask_TriggerType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.Task.Properties.count == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getTask_Count().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getTask_Count().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.Task.Properties.interval == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getTask_Interval().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getTask_Interval().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.Task.Properties.cron == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getTask_Cron().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getTask_Cron().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.Task.Properties.pinnedServers == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getTask_PinnedServers().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getTask_PinnedServers().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.Task.Properties.taskImplementation == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getTask_TaskImplementation().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getTask_TaskImplementation().getEAttributeType(), newValue);
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
