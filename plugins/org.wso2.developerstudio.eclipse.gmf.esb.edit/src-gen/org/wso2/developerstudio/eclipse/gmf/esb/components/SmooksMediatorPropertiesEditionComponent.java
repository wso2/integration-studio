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

import org.eclipse.emf.eef.runtime.impl.components.SinglePartPropertiesEditingComponent;

import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;
import org.eclipse.emf.eef.runtime.impl.utils.EEFUtils;

import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.ExpressionAction;
import org.wso2.developerstudio.eclipse.gmf.esb.OutputMethod;
import org.wso2.developerstudio.eclipse.gmf.esb.SmooksIODataType;
import org.wso2.developerstudio.eclipse.gmf.esb.SmooksMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.SmooksOutputDataType;

import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.SmooksMediatorPropertiesEditionPart;


// End of user code

/**
 * 
 * 
 */
public class SmooksMediatorPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	
	/**
	 * Default constructor
	 * 
	 */
	public SmooksMediatorPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject smooksMediator, String editing_mode) {
		super(editingContext, smooksMediator, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EsbViewsRepository.class;
		partKey = EsbViewsRepository.SmooksMediator.class;
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
			
			final SmooksMediator smooksMediator = (SmooksMediator)elt;
			final SmooksMediatorPropertiesEditionPart basePart = (SmooksMediatorPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EsbViewsRepository.SmooksMediator.Properties.description))
				basePart.setDescription(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, smooksMediator.getDescription()));
			
			if (isAccessible(EsbViewsRepository.SmooksMediator.Properties.commentsList))
				basePart.setCommentsList(smooksMediator.getCommentsList());
			
			if (isAccessible(EsbViewsRepository.SmooksMediator.Properties.reverse)) {
				basePart.setReverse(smooksMediator.isReverse());
			}
			if (isAccessible(EsbViewsRepository.SmooksMediator.Properties.inputType)) {
				basePart.initInputType(EEFUtils.choiceOfValues(smooksMediator, EsbPackage.eINSTANCE.getSmooksMediator_InputType()), smooksMediator.getInputType());
			}
			if (isAccessible(EsbViewsRepository.SmooksMediator.Properties.outputType)) {
				basePart.initOutputType(EEFUtils.choiceOfValues(smooksMediator, EsbPackage.eINSTANCE.getSmooksMediator_OutputType()), smooksMediator.getOutputType());
			}
			if (isAccessible(EsbViewsRepository.SmooksMediator.Properties.outputProperty))
				basePart.setOutputProperty(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, smooksMediator.getOutputProperty()));
			
			if (isAccessible(EsbViewsRepository.SmooksMediator.Properties.outputAction)) {
				basePart.initOutputAction(EEFUtils.choiceOfValues(smooksMediator, EsbPackage.eINSTANCE.getSmooksMediator_OutputAction()), smooksMediator.getOutputAction());
			}
			if (isAccessible(EsbViewsRepository.SmooksMediator.Properties.outputMethod)) {
				basePart.initOutputMethod(EEFUtils.choiceOfValues(smooksMediator, EsbPackage.eINSTANCE.getSmooksMediator_OutputMethod()), smooksMediator.getOutputMethod());
			}
			// init filters
			
			
			
			
			
			
			
			
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
		if (editorKey == EsbViewsRepository.SmooksMediator.Properties.description) {
			return EsbPackage.eINSTANCE.getEsbElement_Description();
		}
		if (editorKey == EsbViewsRepository.SmooksMediator.Properties.commentsList) {
			return EsbPackage.eINSTANCE.getEsbElement_CommentsList();
		}
		if (editorKey == EsbViewsRepository.SmooksMediator.Properties.reverse) {
			return EsbPackage.eINSTANCE.getMediator_Reverse();
		}
		if (editorKey == EsbViewsRepository.SmooksMediator.Properties.inputType) {
			return EsbPackage.eINSTANCE.getSmooksMediator_InputType();
		}
		if (editorKey == EsbViewsRepository.SmooksMediator.Properties.outputType) {
			return EsbPackage.eINSTANCE.getSmooksMediator_OutputType();
		}
		if (editorKey == EsbViewsRepository.SmooksMediator.Properties.outputProperty) {
			return EsbPackage.eINSTANCE.getSmooksMediator_OutputProperty();
		}
		if (editorKey == EsbViewsRepository.SmooksMediator.Properties.outputAction) {
			return EsbPackage.eINSTANCE.getSmooksMediator_OutputAction();
		}
		if (editorKey == EsbViewsRepository.SmooksMediator.Properties.outputMethod) {
			return EsbPackage.eINSTANCE.getSmooksMediator_OutputMethod();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		SmooksMediator smooksMediator = (SmooksMediator)semanticObject;
		if (EsbViewsRepository.SmooksMediator.Properties.description == event.getAffectedEditor()) {
			smooksMediator.setDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.SmooksMediator.Properties.commentsList == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				smooksMediator.getCommentsList().clear();
				smooksMediator.getCommentsList().addAll(((EList) event.getNewValue()));
			}
		}
		if (EsbViewsRepository.SmooksMediator.Properties.reverse == event.getAffectedEditor()) {
			smooksMediator.setReverse((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.SmooksMediator.Properties.inputType == event.getAffectedEditor()) {
			smooksMediator.setInputType((SmooksIODataType)event.getNewValue());
		}
		if (EsbViewsRepository.SmooksMediator.Properties.outputType == event.getAffectedEditor()) {
			smooksMediator.setOutputType((SmooksOutputDataType)event.getNewValue());
		}
		if (EsbViewsRepository.SmooksMediator.Properties.outputProperty == event.getAffectedEditor()) {
			smooksMediator.setOutputProperty((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.SmooksMediator.Properties.outputAction == event.getAffectedEditor()) {
			smooksMediator.setOutputAction((ExpressionAction)event.getNewValue());
		}
		if (EsbViewsRepository.SmooksMediator.Properties.outputMethod == event.getAffectedEditor()) {
			smooksMediator.setOutputMethod((OutputMethod)event.getNewValue());
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			SmooksMediatorPropertiesEditionPart basePart = (SmooksMediatorPropertiesEditionPart)editingPart;
			if (EsbPackage.eINSTANCE.getEsbElement_Description().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.SmooksMediator.Properties.description)) {
				if (msg.getNewValue() != null) {
					basePart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setDescription("");
				}
			}
			if (EsbPackage.eINSTANCE.getEsbElement_CommentsList().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.SmooksMediator.Properties.commentsList)) {
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
			
			if (EsbPackage.eINSTANCE.getMediator_Reverse().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.SmooksMediator.Properties.reverse))
				basePart.setReverse((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getSmooksMediator_InputType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.SmooksMediator.Properties.inputType))
				basePart.setInputType((SmooksIODataType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getSmooksMediator_OutputType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.SmooksMediator.Properties.outputType))
				basePart.setOutputType((SmooksOutputDataType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getSmooksMediator_OutputProperty().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.SmooksMediator.Properties.outputProperty)) {
				if (msg.getNewValue() != null) {
					basePart.setOutputProperty(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setOutputProperty("");
				}
			}
			if (EsbPackage.eINSTANCE.getSmooksMediator_OutputAction().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.SmooksMediator.Properties.outputAction))
				basePart.setOutputAction((ExpressionAction)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getSmooksMediator_OutputMethod().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.SmooksMediator.Properties.outputMethod))
				basePart.setOutputMethod((OutputMethod)msg.getNewValue());
			
			
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
			EsbPackage.eINSTANCE.getSmooksMediator_InputType(),
			EsbPackage.eINSTANCE.getSmooksMediator_OutputType(),
			EsbPackage.eINSTANCE.getSmooksMediator_OutputProperty(),
			EsbPackage.eINSTANCE.getSmooksMediator_OutputAction(),
			EsbPackage.eINSTANCE.getSmooksMediator_OutputMethod()		);
		return new NotificationFilter[] {filter,};
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#getHelpContent(java.lang.Object, int)
	 * 
	 */
	public String getHelpContent(Object key, int kind) {
		if (key == EsbViewsRepository.SmooksMediator.Properties.inputType)
			return "Type"; //$NON-NLS-1$
		if (key == EsbViewsRepository.SmooksMediator.Properties.outputType)
			return "Type"; //$NON-NLS-1$
		if (key == EsbViewsRepository.SmooksMediator.Properties.outputProperty)
			return "Property"; //$NON-NLS-1$
		if (key == EsbViewsRepository.SmooksMediator.Properties.outputAction)
			return "Action"; //$NON-NLS-1$
		if (key == EsbViewsRepository.SmooksMediator.Properties.outputMethod)
			return "Method"; //$NON-NLS-1$
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
				if (EsbViewsRepository.SmooksMediator.Properties.description == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.SmooksMediator.Properties.commentsList == event.getAffectedEditor()) {
					BasicDiagnostic chain = new BasicDiagnostic();
					for (Iterator iterator = ((List)event.getNewValue()).iterator(); iterator.hasNext();) {
						chain.add(Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEAttributeType(), iterator.next()));
					}
					ret = chain;
				}
				if (EsbViewsRepository.SmooksMediator.Properties.reverse == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMediator_Reverse().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMediator_Reverse().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.SmooksMediator.Properties.inputType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getSmooksMediator_InputType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getSmooksMediator_InputType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.SmooksMediator.Properties.outputType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getSmooksMediator_OutputType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getSmooksMediator_OutputType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.SmooksMediator.Properties.outputProperty == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getSmooksMediator_OutputProperty().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getSmooksMediator_OutputProperty().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.SmooksMediator.Properties.outputAction == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getSmooksMediator_OutputAction().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getSmooksMediator_OutputAction().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.SmooksMediator.Properties.outputMethod == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getSmooksMediator_OutputMethod().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getSmooksMediator_OutputMethod().getEAttributeType(), newValue);
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
