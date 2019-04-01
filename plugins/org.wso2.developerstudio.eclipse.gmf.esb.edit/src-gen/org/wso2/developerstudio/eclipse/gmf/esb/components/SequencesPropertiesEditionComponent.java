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

import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy;

import org.eclipse.emf.eef.runtime.policies.impl.CreateEditingPolicy;

import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.Sequences;
import org.wso2.developerstudio.eclipse.gmf.esb.TemplateParameter;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.SequencesPropertiesEditionPart;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;


// End of user code

/**
 * 
 * 
 */
public class SequencesPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	/**
	 * Settings for templateParameters ReferencesTable
	 */
	protected ReferencesTableSettings templateParametersSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public SequencesPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject sequences, String editing_mode) {
		super(editingContext, sequences, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EsbViewsRepository.class;
		partKey = EsbViewsRepository.Sequences.class;
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
			
			final Sequences sequences = (Sequences)elt;
			final SequencesPropertiesEditionPart basePart = (SequencesPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EsbViewsRepository.Sequences.Properties.description))
				basePart.setDescription(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, sequences.getDescription()));
			
			if (isAccessible(EsbViewsRepository.Sequences.Properties.commentsList))
				basePart.setCommentsList(sequences.getCommentsList());
			
			if (isAccessible(EsbViewsRepository.Sequences.Properties.name))
				basePart.setName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, sequences.getName()));
			
			if (isAccessible(EsbViewsRepository.Sequences.Properties.recieveSequence)) {
				basePart.setRecieveSequence(sequences.isRecieveSequence());
			}
			if (isAccessible(EsbViewsRepository.Sequences.Properties.associatedProxy))
				basePart.setAssociatedProxy(sequences.getAssociatedProxy());
			
			if (isAccessible(EsbViewsRepository.Sequences.Properties.templateParameters)) {
				templateParametersSettings = new ReferencesTableSettings(sequences, EsbPackage.eINSTANCE.getSequences_TemplateParameters());
				basePart.initTemplateParameters(templateParametersSettings);
			}
			if (isAccessible(EsbViewsRepository.Sequences.Properties.traceEnabled)) {
				basePart.setTraceEnabled(sequences.isTraceEnabled());
			}
			if (isAccessible(EsbViewsRepository.Sequences.Properties.statisticsEnabled)) {
				basePart.setStatisticsEnabled(sequences.isStatisticsEnabled());
			}
			// Start of user code  for onError command update
			if (isAccessible(EsbViewsRepository.Sequences.Properties.onError)) {
				basePart.setOnError(sequences.getOnError());
			}
			// End of user code
			
			// init filters
			
			
			
			
			
			if (isAccessible(EsbViewsRepository.Sequences.Properties.templateParameters)) {
				basePart.addFilterToTemplateParameters(new ViewerFilter() {
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof TemplateParameter); //$NON-NLS-1$ 
					}
			
				});
				// Start of user code for additional businessfilters for templateParameters
				// End of user code
			}
			
			
			// Start of user code  for onError filter update
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
		if (editorKey == EsbViewsRepository.Sequences.Properties.description) {
			return EsbPackage.eINSTANCE.getEsbElement_Description();
		}
		if (editorKey == EsbViewsRepository.Sequences.Properties.commentsList) {
			return EsbPackage.eINSTANCE.getEsbElement_CommentsList();
		}
		if (editorKey == EsbViewsRepository.Sequences.Properties.name) {
			return EsbPackage.eINSTANCE.getSequences_Name();
		}
		if (editorKey == EsbViewsRepository.Sequences.Properties.recieveSequence) {
			return EsbPackage.eINSTANCE.getSequences_RecieveSequence();
		}
		if (editorKey == EsbViewsRepository.Sequences.Properties.associatedProxy) {
			return EsbPackage.eINSTANCE.getSequences_AssociatedProxy();
		}
		if (editorKey == EsbViewsRepository.Sequences.Properties.templateParameters) {
			return EsbPackage.eINSTANCE.getSequences_TemplateParameters();
		}
		if (editorKey == EsbViewsRepository.Sequences.Properties.traceEnabled) {
			return EsbPackage.eINSTANCE.getSequences_TraceEnabled();
		}
		if (editorKey == EsbViewsRepository.Sequences.Properties.statisticsEnabled) {
			return EsbPackage.eINSTANCE.getSequences_StatisticsEnabled();
		}
		if (editorKey == EsbViewsRepository.Sequences.Properties.onError) {
			return EsbPackage.eINSTANCE.getSequences_OnError();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		Sequences sequences = (Sequences)semanticObject;
		if (EsbViewsRepository.Sequences.Properties.description == event.getAffectedEditor()) {
			sequences.setDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.Sequences.Properties.commentsList == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				sequences.getCommentsList().clear();
				sequences.getCommentsList().addAll(((EList) event.getNewValue()));
			}
		}
		if (EsbViewsRepository.Sequences.Properties.name == event.getAffectedEditor()) {
			sequences.setName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.Sequences.Properties.recieveSequence == event.getAffectedEditor()) {
			sequences.setRecieveSequence((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.Sequences.Properties.associatedProxy == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				sequences.getAssociatedProxy().clear();
				sequences.getAssociatedProxy().addAll(((EList) event.getNewValue()));
			}
		}
		if (EsbViewsRepository.Sequences.Properties.templateParameters == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, templateParametersSettings, editingContext.getAdapterFactory());
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
				templateParametersSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				templateParametersSettings.move(event.getNewIndex(), (TemplateParameter) event.getNewValue());
			}
		}
		if (EsbViewsRepository.Sequences.Properties.traceEnabled == event.getAffectedEditor()) {
			sequences.setTraceEnabled((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.Sequences.Properties.statisticsEnabled == event.getAffectedEditor()) {
			sequences.setStatisticsEnabled((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.Sequences.Properties.onError == event.getAffectedEditor()) {
			// Start of user code for updateOnError method body
			if (event.getNewValue() != null) {
				RegistryKeyProperty rkp = (RegistryKeyProperty) event.getNewValue();
				sequences.setOnError(rkp);
			} else {
				sequences.setOnError(EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty());
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
			SequencesPropertiesEditionPart basePart = (SequencesPropertiesEditionPart)editingPart;
			if (EsbPackage.eINSTANCE.getEsbElement_Description().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.Sequences.Properties.description)) {
				if (msg.getNewValue() != null) {
					basePart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setDescription("");
				}
			}
			if (EsbPackage.eINSTANCE.getEsbElement_CommentsList().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.Sequences.Properties.commentsList)) {
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
			
			if (EsbPackage.eINSTANCE.getSequences_Name().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.Sequences.Properties.name)) {
				if (msg.getNewValue() != null) {
					basePart.setName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setName("");
				}
			}
			if (EsbPackage.eINSTANCE.getSequences_RecieveSequence().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.Sequences.Properties.recieveSequence))
				basePart.setRecieveSequence((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getSequences_AssociatedProxy().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.Sequences.Properties.associatedProxy)) {
				if (msg.getNewValue() instanceof EList<?>) {
					basePart.setAssociatedProxy((EList<?>)msg.getNewValue());
				} else if (msg.getNewValue() == null) {
					basePart.setAssociatedProxy(new BasicEList<Object>());
				} else {
					BasicEList<Object> newValueAsList = new BasicEList<Object>();
					newValueAsList.add(msg.getNewValue());
					basePart.setAssociatedProxy(newValueAsList);
				}
			}
			
			if (EsbPackage.eINSTANCE.getSequences_TemplateParameters().equals(msg.getFeature()) && isAccessible(EsbViewsRepository.Sequences.Properties.templateParameters))
				basePart.updateTemplateParameters();
			if (EsbPackage.eINSTANCE.getSequences_TraceEnabled().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.Sequences.Properties.traceEnabled))
				basePart.setTraceEnabled((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getSequences_StatisticsEnabled().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.Sequences.Properties.statisticsEnabled))
				basePart.setStatisticsEnabled((Boolean)msg.getNewValue());
			
					// Start of user code for onError live update
			if (EsbPackage.eINSTANCE.getSequences_OnError().equals(msg.getFeature())
					&& msg.getNotifier().equals(semanticObject) && basePart != null
					&& isAccessible(EsbViewsRepository.Sequences.Properties.onError)) {
				if (msg.getNewValue() != null) {
					basePart.setOnError((RegistryKeyProperty) msg.getNewValue());
				} else {
					basePart.setOnError(EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty());
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
			EsbPackage.eINSTANCE.getSequences_Name(),
			EsbPackage.eINSTANCE.getSequences_RecieveSequence(),
			EsbPackage.eINSTANCE.getSequences_AssociatedProxy(),
			EsbPackage.eINSTANCE.getSequences_TemplateParameters(),
			EsbPackage.eINSTANCE.getSequences_TraceEnabled(),
			EsbPackage.eINSTANCE.getSequences_StatisticsEnabled(),
			EsbPackage.eINSTANCE.getSequences_OnError()		);
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
				if (EsbViewsRepository.Sequences.Properties.description == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.Sequences.Properties.commentsList == event.getAffectedEditor()) {
					BasicDiagnostic chain = new BasicDiagnostic();
					for (Iterator iterator = ((List)event.getNewValue()).iterator(); iterator.hasNext();) {
						chain.add(Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEAttributeType(), iterator.next()));
					}
					ret = chain;
				}
				if (EsbViewsRepository.Sequences.Properties.name == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getSequences_Name().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getSequences_Name().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.Sequences.Properties.recieveSequence == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getSequences_RecieveSequence().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getSequences_RecieveSequence().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.Sequences.Properties.associatedProxy == event.getAffectedEditor()) {
					BasicDiagnostic chain = new BasicDiagnostic();
					for (Iterator iterator = ((List)event.getNewValue()).iterator(); iterator.hasNext();) {
						chain.add(Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getSequences_AssociatedProxy().getEAttributeType(), iterator.next()));
					}
					ret = chain;
				}
				if (EsbViewsRepository.Sequences.Properties.traceEnabled == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getSequences_TraceEnabled().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getSequences_TraceEnabled().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.Sequences.Properties.statisticsEnabled == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getSequences_StatisticsEnabled().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getSequences_StatisticsEnabled().getEAttributeType(), newValue);
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
