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

import org.wso2.integrationstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.integrationstudio.eclipse.gmf.esb.SqlParameterDefinition;
import org.wso2.integrationstudio.eclipse.gmf.esb.SqlResultMapping;
import org.wso2.integrationstudio.eclipse.gmf.esb.SqlStatement;

import org.wso2.integrationstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.integrationstudio.eclipse.gmf.esb.parts.SqlStatementPropertiesEditionPart;


// End of user code

/**
 * 
 * 
 */
public class SqlStatementPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	/**
	 * Settings for parameters ReferencesTable
	 */
	protected ReferencesTableSettings parametersSettings;
	
	/**
	 * Settings for results ReferencesTable
	 */
	protected ReferencesTableSettings resultsSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public SqlStatementPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject sqlStatement, String editing_mode) {
		super(editingContext, sqlStatement, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EsbViewsRepository.class;
		partKey = EsbViewsRepository.SqlStatement.class;
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
			
			final SqlStatement sqlStatement = (SqlStatement)elt;
			final SqlStatementPropertiesEditionPart basePart = (SqlStatementPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EsbViewsRepository.SqlStatement.Properties.queryString))
				basePart.setQueryString(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, sqlStatement.getQueryString()));
			
			if (isAccessible(EsbViewsRepository.SqlStatement.Properties.parameters)) {
				parametersSettings = new ReferencesTableSettings(sqlStatement, EsbPackage.eINSTANCE.getSqlStatement_Parameters());
				basePart.initParameters(parametersSettings);
			}
			if (isAccessible(EsbViewsRepository.SqlStatement.Properties.resultsEnabled)) {
				basePart.setResultsEnabled(sqlStatement.isResultsEnabled());
			}
			if (isAccessible(EsbViewsRepository.SqlStatement.Properties.results)) {
				resultsSettings = new ReferencesTableSettings(sqlStatement, EsbPackage.eINSTANCE.getSqlStatement_Results());
				basePart.initResults(resultsSettings);
			}
			// init filters
			
			if (isAccessible(EsbViewsRepository.SqlStatement.Properties.parameters)) {
				basePart.addFilterToParameters(new ViewerFilter() {
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof SqlParameterDefinition); //$NON-NLS-1$ 
					}
			
				});
				// Start of user code for additional businessfilters for parameters
				// End of user code
			}
			
			if (isAccessible(EsbViewsRepository.SqlStatement.Properties.results)) {
				basePart.addFilterToResults(new ViewerFilter() {
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof SqlResultMapping); //$NON-NLS-1$ 
					}
			
				});
				// Start of user code for additional businessfilters for results
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
		if (editorKey == EsbViewsRepository.SqlStatement.Properties.queryString) {
			return EsbPackage.eINSTANCE.getSqlStatement_QueryString();
		}
		if (editorKey == EsbViewsRepository.SqlStatement.Properties.parameters) {
			return EsbPackage.eINSTANCE.getSqlStatement_Parameters();
		}
		if (editorKey == EsbViewsRepository.SqlStatement.Properties.resultsEnabled) {
			return EsbPackage.eINSTANCE.getSqlStatement_ResultsEnabled();
		}
		if (editorKey == EsbViewsRepository.SqlStatement.Properties.results) {
			return EsbPackage.eINSTANCE.getSqlStatement_Results();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		SqlStatement sqlStatement = (SqlStatement)semanticObject;
		if (EsbViewsRepository.SqlStatement.Properties.queryString == event.getAffectedEditor()) {
			sqlStatement.setQueryString((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.SqlStatement.Properties.parameters == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, parametersSettings, editingContext.getAdapterFactory());
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
				parametersSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				parametersSettings.move(event.getNewIndex(), (SqlParameterDefinition) event.getNewValue());
			}
		}
		if (EsbViewsRepository.SqlStatement.Properties.resultsEnabled == event.getAffectedEditor()) {
			sqlStatement.setResultsEnabled((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.SqlStatement.Properties.results == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, resultsSettings, editingContext.getAdapterFactory());
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
				resultsSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				resultsSettings.move(event.getNewIndex(), (SqlResultMapping) event.getNewValue());
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
			SqlStatementPropertiesEditionPart basePart = (SqlStatementPropertiesEditionPart)editingPart;
			if (EsbPackage.eINSTANCE.getSqlStatement_QueryString().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.SqlStatement.Properties.queryString)) {
				if (msg.getNewValue() != null) {
					basePart.setQueryString(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setQueryString("");
				}
			}
			if (EsbPackage.eINSTANCE.getSqlStatement_Parameters().equals(msg.getFeature()) && isAccessible(EsbViewsRepository.SqlStatement.Properties.parameters))
				basePart.updateParameters();
			if (EsbPackage.eINSTANCE.getSqlStatement_ResultsEnabled().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.SqlStatement.Properties.resultsEnabled))
				basePart.setResultsEnabled((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getSqlStatement_Results().equals(msg.getFeature()) && isAccessible(EsbViewsRepository.SqlStatement.Properties.results))
				basePart.updateResults();
			
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
			EsbPackage.eINSTANCE.getSqlStatement_QueryString(),
			EsbPackage.eINSTANCE.getSqlStatement_Parameters(),
			EsbPackage.eINSTANCE.getSqlStatement_ResultsEnabled(),
			EsbPackage.eINSTANCE.getSqlStatement_Results()		);
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
				if (EsbViewsRepository.SqlStatement.Properties.queryString == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getSqlStatement_QueryString().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getSqlStatement_QueryString().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.SqlStatement.Properties.resultsEnabled == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getSqlStatement_ResultsEnabled().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getSqlStatement_ResultsEnabled().getEAttributeType(), newValue);
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
