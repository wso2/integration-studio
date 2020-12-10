/**
 * Generated with Acceleo
 */
package org.wso2.integrationstudio.eclipse.gmf.esb.components;

// Start of user code for imports
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.WrappedException;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.ecore.resource.ResourceSet;

import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.emf.eef.runtime.api.notify.EStructuralFeatureNotificationFilter;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.notify.NotificationFilter;

import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;

import org.eclipse.emf.eef.runtime.impl.components.SinglePartPropertiesEditingComponent;

import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;

import org.wso2.integrationstudio.eclipse.gmf.esb.ConditionalRouteBranch;
import org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.integrationstudio.eclipse.gmf.esb.EvaluatorExpressionProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.integrationstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.ConditionalRouteBranchPropertiesEditionPart;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EsbViewsRepository;


// End of user code

/**
 * 
 * 
 */
public class ConditionalRouteBranchPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	
	/**
	 * Default constructor
	 * 
	 */
	public ConditionalRouteBranchPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject conditionalRouteBranch, String editing_mode) {
		super(editingContext, conditionalRouteBranch, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EsbViewsRepository.class;
		partKey = EsbViewsRepository.ConditionalRouteBranch.class;
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
			
			final ConditionalRouteBranch conditionalRouteBranch = (ConditionalRouteBranch)elt;
			final ConditionalRouteBranchPropertiesEditionPart basePart = (ConditionalRouteBranchPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EsbViewsRepository.ConditionalRouteBranch.Properties.breakAfterRoute)) {
				basePart.setBreakAfterRoute(conditionalRouteBranch.isBreakAfterRoute());
			}
			// Start of user code  for targetSequence command update
            if (isAccessible(EsbViewsRepository.ConditionalRouteBranch.Properties.targetSequence)) {
                basePart.setTargetSequence(conditionalRouteBranch.getTargetSequence());
            }
			// End of user code
			
			// Start of user code  for evaluatorExpression command update
            if (isAccessible(EsbViewsRepository.ConditionalRouteBranch.evaluatorExpression)) {
                basePart.setEvaluatorExpression(conditionalRouteBranch.getEvaluatorExpression());
            }
			// End of user code
			
			// init filters
			
			// Start of user code  for targetSequence filter update
			// End of user code
			
			// Start of user code  for evaluatorExpression filter update
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
		if (editorKey == EsbViewsRepository.ConditionalRouteBranch.Properties.breakAfterRoute) {
			return EsbPackage.eINSTANCE.getConditionalRouteBranch_BreakAfterRoute();
		}
		if (editorKey == EsbViewsRepository.ConditionalRouteBranch.Properties.targetSequence) {
			return EsbPackage.eINSTANCE.getConditionalRouteBranch_TargetSequence();
		}
		if (editorKey == EsbViewsRepository.ConditionalRouteBranch.evaluatorExpression) {
			return EsbPackage.eINSTANCE.getConditionalRouteBranch_EvaluatorExpression();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		ConditionalRouteBranch conditionalRouteBranch = (ConditionalRouteBranch)semanticObject;
		if (EsbViewsRepository.ConditionalRouteBranch.Properties.breakAfterRoute == event.getAffectedEditor()) {
			conditionalRouteBranch.setBreakAfterRoute((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.ConditionalRouteBranch.Properties.targetSequence == event.getAffectedEditor()) {
			// Start of user code for updateTargetSequence method body
            if (event.getNewValue() != null) {
                RegistryKeyProperty rkp = (RegistryKeyProperty) event.getNewValue();
                conditionalRouteBranch.setTargetSequence(rkp);
            } else {
                conditionalRouteBranch.setTargetSequence(EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty());
            }
			// End of user code
			
		}
		if (EsbViewsRepository.ConditionalRouteBranch.evaluatorExpression == event.getAffectedEditor()) {
			// Start of user code for updateEvaluatorExpression method body
            if (event.getNewValue() != null) {
                EvaluatorExpressionProperty eep = (EvaluatorExpressionProperty) event.getNewValue();
                conditionalRouteBranch.setEvaluatorExpression(eep);
            } else {
                conditionalRouteBranch.setEvaluatorExpression(EsbFactoryImpl.eINSTANCE.createEvaluatorExpressionProperty());
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
			ConditionalRouteBranchPropertiesEditionPart basePart = (ConditionalRouteBranchPropertiesEditionPart)editingPart;
			if (EsbPackage.eINSTANCE.getConditionalRouteBranch_BreakAfterRoute().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.ConditionalRouteBranch.Properties.breakAfterRoute))
				basePart.setBreakAfterRoute((Boolean)msg.getNewValue());
			
					// Start of user code for targetSequence live update
            if (EsbPackage.eINSTANCE.getConditionalRouteBranch_TargetSequence().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject) && basePart != null
                    && isAccessible(EsbViewsRepository.ConditionalRouteBranch.Properties.targetSequence)) {
                if (msg.getNewValue() != null) {
                    basePart.setTargetSequence((RegistryKeyProperty) msg.getNewValue());
                } else {
                    basePart.setTargetSequence(EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty());
                }
            }
					// End of user code
			
					// Start of user code for evaluatorExpression live update
            if (EsbPackage.eINSTANCE.getConditionalRouteBranch_EvaluatorExpression().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject) && basePart != null
                    && isAccessible(EsbViewsRepository.ConditionalRouteBranch.evaluatorExpression)) {
                if (msg.getNewValue() != null) {
                    basePart.setEvaluatorExpression((EvaluatorExpressionProperty) msg.getNewValue());
                } else {
                    basePart.setEvaluatorExpression(EsbFactoryImpl.eINSTANCE.createEvaluatorExpressionProperty());
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
			EsbPackage.eINSTANCE.getConditionalRouteBranch_BreakAfterRoute(),
			EsbPackage.eINSTANCE.getConditionalRouteBranch_TargetSequence(),
			EsbPackage.eINSTANCE.getConditionalRouteBranch_EvaluatorExpression()		);
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
				if (EsbViewsRepository.ConditionalRouteBranch.Properties.breakAfterRoute == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getConditionalRouteBranch_BreakAfterRoute().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getConditionalRouteBranch_BreakAfterRoute().getEAttributeType(), newValue);
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
