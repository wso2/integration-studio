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

import org.wso2.developerstudio.eclipse.gmf.esb.DBLookupMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.SqlDatabaseType;
import org.wso2.developerstudio.eclipse.gmf.esb.SqlExecutorBooleanValue;
import org.wso2.developerstudio.eclipse.gmf.esb.SqlExecutorConnectionType;
import org.wso2.developerstudio.eclipse.gmf.esb.SqlExecutorDatasourceType;
import org.wso2.developerstudio.eclipse.gmf.esb.SqlExecutorIsolationLevel;
import org.wso2.developerstudio.eclipse.gmf.esb.SqlStatement;

import org.wso2.developerstudio.eclipse.gmf.esb.parts.DBLookupMediatorPropertiesEditionPart;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;


// End of user code

/**
 * 
 * 
 */
public class DBLookupMediatorPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	/**
	 * Settings for sqlStatements ReferencesTable
	 */
	protected ReferencesTableSettings sqlStatementsSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public DBLookupMediatorPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject dBLookupMediator, String editing_mode) {
		super(editingContext, dBLookupMediator, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EsbViewsRepository.class;
		partKey = EsbViewsRepository.DBLookupMediator.class;
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
			
			final DBLookupMediator dBLookupMediator = (DBLookupMediator)elt;
			final DBLookupMediatorPropertiesEditionPart basePart = (DBLookupMediatorPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EsbViewsRepository.DBLookupMediator.Misc.description))
				basePart.setDescription(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, dBLookupMediator.getDescription()));
			
			if (isAccessible(EsbViewsRepository.DBLookupMediator.Properties.commentsList))
				basePart.setCommentsList(dBLookupMediator.getCommentsList());
			
			if (isAccessible(EsbViewsRepository.DBLookupMediator.Properties.reverse)) {
				basePart.setReverse(dBLookupMediator.isReverse());
			}
			if (isAccessible(EsbViewsRepository.DBLookupMediator.Connection.connectionType)) {
				basePart.initConnectionType(EEFUtils.choiceOfValues(dBLookupMediator, EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_ConnectionType()), dBLookupMediator.getConnectionType());
			}
			if (isAccessible(EsbViewsRepository.DBLookupMediator.Connection.connectionDsType)) {
				basePart.initConnectionDsType(EEFUtils.choiceOfValues(dBLookupMediator, EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_ConnectionDsType()), dBLookupMediator.getConnectionDsType());
			}
			if (isAccessible(EsbViewsRepository.DBLookupMediator.Connection.connectionDbType)) {
				basePart.initConnectionDbType(EEFUtils.choiceOfValues(dBLookupMediator, EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_ConnectionDbType()), dBLookupMediator.getConnectionDbType());
			}
			if (isAccessible(EsbViewsRepository.DBLookupMediator.Connection.connectionDbDriver))
				basePart.setConnectionDbDriver(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, dBLookupMediator.getConnectionDbDriver()));
			
			if (isAccessible(EsbViewsRepository.DBLookupMediator.Connection.connectionDsInitialContext))
				basePart.setConnectionDsInitialContext(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, dBLookupMediator.getConnectionDsInitialContext()));
			
			if (isAccessible(EsbViewsRepository.DBLookupMediator.Connection.connectionDsName))
				basePart.setConnectionDsName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, dBLookupMediator.getConnectionDsName()));
			
			if (isAccessible(EsbViewsRepository.DBLookupMediator.Connection.connectionURL))
				basePart.setConnectionURL(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, dBLookupMediator.getConnectionURL()));
			
			if (isAccessible(EsbViewsRepository.DBLookupMediator.Connection.connectionUsername))
				basePart.setConnectionUsername(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, dBLookupMediator.getConnectionUsername()));
			
			if (isAccessible(EsbViewsRepository.DBLookupMediator.Connection.connectionPassword))
				basePart.setConnectionPassword(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, dBLookupMediator.getConnectionPassword()));
			
			if (isAccessible(EsbViewsRepository.DBLookupMediator.Properties.propertyAutocommit)) {
				basePart.initPropertyAutocommit(EEFUtils.choiceOfValues(dBLookupMediator, EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyAutocommit()), dBLookupMediator.getPropertyAutocommit());
			}
			if (isAccessible(EsbViewsRepository.DBLookupMediator.Properties.propertyIsolation)) {
				basePart.initPropertyIsolation(EEFUtils.choiceOfValues(dBLookupMediator, EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyIsolation()), dBLookupMediator.getPropertyIsolation());
			}
			if (isAccessible(EsbViewsRepository.DBLookupMediator.Properties.propertyMaxactive)) {
				basePart.setPropertyMaxactive(EEFConverterUtil.convertToString(EcorePackage.Literals.EINT, dBLookupMediator.getPropertyMaxactive()));
			}
			
			if (isAccessible(EsbViewsRepository.DBLookupMediator.Properties.propertyMaxidle)) {
				basePart.setPropertyMaxidle(EEFConverterUtil.convertToString(EcorePackage.Literals.EINT, dBLookupMediator.getPropertyMaxidle()));
			}
			
			if (isAccessible(EsbViewsRepository.DBLookupMediator.Properties.propertyMaxopenstatements)) {
				basePart.setPropertyMaxopenstatements(EEFConverterUtil.convertToString(EcorePackage.Literals.EINT, dBLookupMediator.getPropertyMaxopenstatements()));
			}
			
			if (isAccessible(EsbViewsRepository.DBLookupMediator.Properties.propertyMaxwait)) {
				basePart.setPropertyMaxwait(EEFConverterUtil.convertToString(EcorePackage.Literals.EINT, dBLookupMediator.getPropertyMaxwait()));
			}
			
			if (isAccessible(EsbViewsRepository.DBLookupMediator.Properties.propertyMinidle)) {
				basePart.setPropertyMinidle(EEFConverterUtil.convertToString(EcorePackage.Literals.EINT, dBLookupMediator.getPropertyMinidle()));
			}
			
			if (isAccessible(EsbViewsRepository.DBLookupMediator.Properties.propertyPoolstatements)) {
				basePart.initPropertyPoolstatements(EEFUtils.choiceOfValues(dBLookupMediator, EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyPoolstatements()), dBLookupMediator.getPropertyPoolstatements());
			}
			if (isAccessible(EsbViewsRepository.DBLookupMediator.Properties.propertyTestonborrow)) {
				basePart.initPropertyTestonborrow(EEFUtils.choiceOfValues(dBLookupMediator, EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyTestonborrow()), dBLookupMediator.getPropertyTestonborrow());
			}
			if (isAccessible(EsbViewsRepository.DBLookupMediator.Properties.propertyTestwhileidle)) {
				basePart.initPropertyTestwhileidle(EEFUtils.choiceOfValues(dBLookupMediator, EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyTestwhileidle()), dBLookupMediator.getPropertyTestwhileidle());
			}
			if (isAccessible(EsbViewsRepository.DBLookupMediator.Properties.propertyValidationquery))
				basePart.setPropertyValidationquery(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, dBLookupMediator.getPropertyValidationquery()));
			
			if (isAccessible(EsbViewsRepository.DBLookupMediator.Properties.propertyInitialsize)) {
				basePart.setPropertyInitialsize(EEFConverterUtil.convertToString(EcorePackage.Literals.EINT, dBLookupMediator.getPropertyInitialsize()));
			}
			
			if (isAccessible(EsbViewsRepository.DBLookupMediator.Statements.sqlStatements)) {
				sqlStatementsSettings = new ReferencesTableSettings(dBLookupMediator, EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_SqlStatements());
				basePart.initSqlStatements(sqlStatementsSettings);
			}
			// Start of user code  for DatabaseConfiguration command update
			// End of user code
			
			// init filters
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			if (isAccessible(EsbViewsRepository.DBLookupMediator.Statements.sqlStatements)) {
				basePart.addFilterToSqlStatements(new ViewerFilter() {
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof SqlStatement); //$NON-NLS-1$ 
					}
			
				});
				// Start of user code for additional businessfilters for sqlStatements
				// End of user code
			}
			// Start of user code  for DatabaseConfiguration filter update
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
		if (editorKey == EsbViewsRepository.DBLookupMediator.Misc.description) {
			return EsbPackage.eINSTANCE.getEsbElement_Description();
		}
		if (editorKey == EsbViewsRepository.DBLookupMediator.Properties.commentsList) {
			return EsbPackage.eINSTANCE.getEsbElement_CommentsList();
		}
		if (editorKey == EsbViewsRepository.DBLookupMediator.Properties.reverse) {
			return EsbPackage.eINSTANCE.getMediator_Reverse();
		}
		if (editorKey == EsbViewsRepository.DBLookupMediator.Connection.connectionType) {
			return EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_ConnectionType();
		}
		if (editorKey == EsbViewsRepository.DBLookupMediator.Connection.connectionDsType) {
			return EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_ConnectionDsType();
		}
		if (editorKey == EsbViewsRepository.DBLookupMediator.Connection.connectionDbType) {
			return EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_ConnectionDbType();
		}
		if (editorKey == EsbViewsRepository.DBLookupMediator.Connection.connectionDbDriver) {
			return EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_ConnectionDbDriver();
		}
		if (editorKey == EsbViewsRepository.DBLookupMediator.Connection.connectionDsInitialContext) {
			return EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_ConnectionDsInitialContext();
		}
		if (editorKey == EsbViewsRepository.DBLookupMediator.Connection.connectionDsName) {
			return EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_ConnectionDsName();
		}
		if (editorKey == EsbViewsRepository.DBLookupMediator.Connection.connectionURL) {
			return EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_ConnectionURL();
		}
		if (editorKey == EsbViewsRepository.DBLookupMediator.Connection.connectionUsername) {
			return EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_ConnectionUsername();
		}
		if (editorKey == EsbViewsRepository.DBLookupMediator.Connection.connectionPassword) {
			return EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_ConnectionPassword();
		}
		if (editorKey == EsbViewsRepository.DBLookupMediator.Properties.propertyAutocommit) {
			return EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyAutocommit();
		}
		if (editorKey == EsbViewsRepository.DBLookupMediator.Properties.propertyIsolation) {
			return EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyIsolation();
		}
		if (editorKey == EsbViewsRepository.DBLookupMediator.Properties.propertyMaxactive) {
			return EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyMaxactive();
		}
		if (editorKey == EsbViewsRepository.DBLookupMediator.Properties.propertyMaxidle) {
			return EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyMaxidle();
		}
		if (editorKey == EsbViewsRepository.DBLookupMediator.Properties.propertyMaxopenstatements) {
			return EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyMaxopenstatements();
		}
		if (editorKey == EsbViewsRepository.DBLookupMediator.Properties.propertyMaxwait) {
			return EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyMaxwait();
		}
		if (editorKey == EsbViewsRepository.DBLookupMediator.Properties.propertyMinidle) {
			return EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyMinidle();
		}
		if (editorKey == EsbViewsRepository.DBLookupMediator.Properties.propertyPoolstatements) {
			return EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyPoolstatements();
		}
		if (editorKey == EsbViewsRepository.DBLookupMediator.Properties.propertyTestonborrow) {
			return EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyTestonborrow();
		}
		if (editorKey == EsbViewsRepository.DBLookupMediator.Properties.propertyTestwhileidle) {
			return EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyTestwhileidle();
		}
		if (editorKey == EsbViewsRepository.DBLookupMediator.Properties.propertyValidationquery) {
			return EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyValidationquery();
		}
		if (editorKey == EsbViewsRepository.DBLookupMediator.Properties.propertyInitialsize) {
			return EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyInitialsize();
		}
		if (editorKey == EsbViewsRepository.DBLookupMediator.Statements.sqlStatements) {
			return EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_SqlStatements();
		}
		if (editorKey == EsbViewsRepository.DBLookupMediator.Connection.databaseConfiguration) {
			return EsbPackage.eINSTANCE.getMediator_Reverse();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		DBLookupMediator dBLookupMediator = (DBLookupMediator)semanticObject;
		if (EsbViewsRepository.DBLookupMediator.Misc.description == event.getAffectedEditor()) {
			dBLookupMediator.setDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.DBLookupMediator.Properties.commentsList == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				dBLookupMediator.getCommentsList().clear();
				dBLookupMediator.getCommentsList().addAll(((EList) event.getNewValue()));
			}
		}
		if (EsbViewsRepository.DBLookupMediator.Properties.reverse == event.getAffectedEditor()) {
			dBLookupMediator.setReverse((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.DBLookupMediator.Connection.connectionType == event.getAffectedEditor()) {
			dBLookupMediator.setConnectionType((SqlExecutorConnectionType)event.getNewValue());
		}
		if (EsbViewsRepository.DBLookupMediator.Connection.connectionDsType == event.getAffectedEditor()) {
			dBLookupMediator.setConnectionDsType((SqlExecutorDatasourceType)event.getNewValue());
		}
		if (EsbViewsRepository.DBLookupMediator.Connection.connectionDbType == event.getAffectedEditor()) {
			dBLookupMediator.setConnectionDbType((SqlDatabaseType)event.getNewValue());
		}
		if (EsbViewsRepository.DBLookupMediator.Connection.connectionDbDriver == event.getAffectedEditor()) {
			dBLookupMediator.setConnectionDbDriver((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.DBLookupMediator.Connection.connectionDsInitialContext == event.getAffectedEditor()) {
			dBLookupMediator.setConnectionDsInitialContext((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.DBLookupMediator.Connection.connectionDsName == event.getAffectedEditor()) {
			dBLookupMediator.setConnectionDsName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.DBLookupMediator.Connection.connectionURL == event.getAffectedEditor()) {
			dBLookupMediator.setConnectionURL((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.DBLookupMediator.Connection.connectionUsername == event.getAffectedEditor()) {
			dBLookupMediator.setConnectionUsername((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.DBLookupMediator.Connection.connectionPassword == event.getAffectedEditor()) {
			dBLookupMediator.setConnectionPassword((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.DBLookupMediator.Properties.propertyAutocommit == event.getAffectedEditor()) {
			dBLookupMediator.setPropertyAutocommit((SqlExecutorBooleanValue)event.getNewValue());
		}
		if (EsbViewsRepository.DBLookupMediator.Properties.propertyIsolation == event.getAffectedEditor()) {
			dBLookupMediator.setPropertyIsolation((SqlExecutorIsolationLevel)event.getNewValue());
		}
		if (EsbViewsRepository.DBLookupMediator.Properties.propertyMaxactive == event.getAffectedEditor()) {
			dBLookupMediator.setPropertyMaxactive((EEFConverterUtil.createIntFromString(EcorePackage.Literals.EINT, (String)event.getNewValue())));
		}
		if (EsbViewsRepository.DBLookupMediator.Properties.propertyMaxidle == event.getAffectedEditor()) {
			dBLookupMediator.setPropertyMaxidle((EEFConverterUtil.createIntFromString(EcorePackage.Literals.EINT, (String)event.getNewValue())));
		}
		if (EsbViewsRepository.DBLookupMediator.Properties.propertyMaxopenstatements == event.getAffectedEditor()) {
			dBLookupMediator.setPropertyMaxopenstatements((EEFConverterUtil.createIntFromString(EcorePackage.Literals.EINT, (String)event.getNewValue())));
		}
		if (EsbViewsRepository.DBLookupMediator.Properties.propertyMaxwait == event.getAffectedEditor()) {
			dBLookupMediator.setPropertyMaxwait((EEFConverterUtil.createIntFromString(EcorePackage.Literals.EINT, (String)event.getNewValue())));
		}
		if (EsbViewsRepository.DBLookupMediator.Properties.propertyMinidle == event.getAffectedEditor()) {
			dBLookupMediator.setPropertyMinidle((EEFConverterUtil.createIntFromString(EcorePackage.Literals.EINT, (String)event.getNewValue())));
		}
		if (EsbViewsRepository.DBLookupMediator.Properties.propertyPoolstatements == event.getAffectedEditor()) {
			dBLookupMediator.setPropertyPoolstatements((SqlExecutorBooleanValue)event.getNewValue());
		}
		if (EsbViewsRepository.DBLookupMediator.Properties.propertyTestonborrow == event.getAffectedEditor()) {
			dBLookupMediator.setPropertyTestonborrow((SqlExecutorBooleanValue)event.getNewValue());
		}
		if (EsbViewsRepository.DBLookupMediator.Properties.propertyTestwhileidle == event.getAffectedEditor()) {
			dBLookupMediator.setPropertyTestwhileidle((SqlExecutorBooleanValue)event.getNewValue());
		}
		if (EsbViewsRepository.DBLookupMediator.Properties.propertyValidationquery == event.getAffectedEditor()) {
			dBLookupMediator.setPropertyValidationquery((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.DBLookupMediator.Properties.propertyInitialsize == event.getAffectedEditor()) {
			dBLookupMediator.setPropertyInitialsize((EEFConverterUtil.createIntFromString(EcorePackage.Literals.EINT, (String)event.getNewValue())));
		}
		if (EsbViewsRepository.DBLookupMediator.Statements.sqlStatements == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, sqlStatementsSettings, editingContext.getAdapterFactory());
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
				sqlStatementsSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				sqlStatementsSettings.move(event.getNewIndex(), (SqlStatement) event.getNewValue());
			}
		}
		if (EsbViewsRepository.DBLookupMediator.Connection.databaseConfiguration == event.getAffectedEditor()) {
			// Start of user code for updateDatabaseConfiguration method body
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
			DBLookupMediatorPropertiesEditionPart basePart = (DBLookupMediatorPropertiesEditionPart)editingPart;
			if (EsbPackage.eINSTANCE.getEsbElement_Description().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.DBLookupMediator.Misc.description)) {
				if (msg.getNewValue() != null) {
					basePart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setDescription("");
				}
			}
			if (EsbPackage.eINSTANCE.getEsbElement_CommentsList().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.DBLookupMediator.Properties.commentsList)) {
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
			
			if (EsbPackage.eINSTANCE.getMediator_Reverse().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.DBLookupMediator.Properties.reverse))
				basePart.setReverse((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_ConnectionType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.DBLookupMediator.Connection.connectionType))
				basePart.setConnectionType((SqlExecutorConnectionType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_ConnectionDsType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.DBLookupMediator.Connection.connectionDsType))
				basePart.setConnectionDsType((SqlExecutorDatasourceType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_ConnectionDbType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.DBLookupMediator.Connection.connectionDbType))
				basePart.setConnectionDbType((SqlDatabaseType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_ConnectionDbDriver().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.DBLookupMediator.Connection.connectionDbDriver)) {
				if (msg.getNewValue() != null) {
					basePart.setConnectionDbDriver(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setConnectionDbDriver("");
				}
			}
			if (EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_ConnectionDsInitialContext().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.DBLookupMediator.Connection.connectionDsInitialContext)) {
				if (msg.getNewValue() != null) {
					basePart.setConnectionDsInitialContext(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setConnectionDsInitialContext("");
				}
			}
			if (EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_ConnectionDsName().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.DBLookupMediator.Connection.connectionDsName)) {
				if (msg.getNewValue() != null) {
					basePart.setConnectionDsName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setConnectionDsName("");
				}
			}
			if (EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_ConnectionURL().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.DBLookupMediator.Connection.connectionURL)) {
				if (msg.getNewValue() != null) {
					basePart.setConnectionURL(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setConnectionURL("");
				}
			}
			if (EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_ConnectionUsername().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.DBLookupMediator.Connection.connectionUsername)) {
				if (msg.getNewValue() != null) {
					basePart.setConnectionUsername(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setConnectionUsername("");
				}
			}
			if (EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_ConnectionPassword().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.DBLookupMediator.Connection.connectionPassword)) {
				if (msg.getNewValue() != null) {
					basePart.setConnectionPassword(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setConnectionPassword("");
				}
			}
			if (EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyAutocommit().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.DBLookupMediator.Properties.propertyAutocommit))
				basePart.setPropertyAutocommit((SqlExecutorBooleanValue)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyIsolation().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.DBLookupMediator.Properties.propertyIsolation))
				basePart.setPropertyIsolation((SqlExecutorIsolationLevel)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyMaxactive().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.DBLookupMediator.Properties.propertyMaxactive)) {
				if (msg.getNewValue() != null) {
					basePart.setPropertyMaxactive(EcoreUtil.convertToString(EcorePackage.Literals.EINT, msg.getNewValue()));
				} else {
					basePart.setPropertyMaxactive("");
				}
			}
			if (EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyMaxidle().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.DBLookupMediator.Properties.propertyMaxidle)) {
				if (msg.getNewValue() != null) {
					basePart.setPropertyMaxidle(EcoreUtil.convertToString(EcorePackage.Literals.EINT, msg.getNewValue()));
				} else {
					basePart.setPropertyMaxidle("");
				}
			}
			if (EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyMaxopenstatements().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.DBLookupMediator.Properties.propertyMaxopenstatements)) {
				if (msg.getNewValue() != null) {
					basePart.setPropertyMaxopenstatements(EcoreUtil.convertToString(EcorePackage.Literals.EINT, msg.getNewValue()));
				} else {
					basePart.setPropertyMaxopenstatements("");
				}
			}
			if (EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyMaxwait().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.DBLookupMediator.Properties.propertyMaxwait)) {
				if (msg.getNewValue() != null) {
					basePart.setPropertyMaxwait(EcoreUtil.convertToString(EcorePackage.Literals.EINT, msg.getNewValue()));
				} else {
					basePart.setPropertyMaxwait("");
				}
			}
			if (EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyMinidle().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.DBLookupMediator.Properties.propertyMinidle)) {
				if (msg.getNewValue() != null) {
					basePart.setPropertyMinidle(EcoreUtil.convertToString(EcorePackage.Literals.EINT, msg.getNewValue()));
				} else {
					basePart.setPropertyMinidle("");
				}
			}
			if (EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyPoolstatements().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.DBLookupMediator.Properties.propertyPoolstatements))
				basePart.setPropertyPoolstatements((SqlExecutorBooleanValue)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyTestonborrow().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.DBLookupMediator.Properties.propertyTestonborrow))
				basePart.setPropertyTestonborrow((SqlExecutorBooleanValue)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyTestwhileidle().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.DBLookupMediator.Properties.propertyTestwhileidle))
				basePart.setPropertyTestwhileidle((SqlExecutorBooleanValue)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyValidationquery().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.DBLookupMediator.Properties.propertyValidationquery)) {
				if (msg.getNewValue() != null) {
					basePart.setPropertyValidationquery(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setPropertyValidationquery("");
				}
			}
			if (EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyInitialsize().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.DBLookupMediator.Properties.propertyInitialsize)) {
				if (msg.getNewValue() != null) {
					basePart.setPropertyInitialsize(EcoreUtil.convertToString(EcorePackage.Literals.EINT, msg.getNewValue()));
				} else {
					basePart.setPropertyInitialsize("");
				}
			}
			if (EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_SqlStatements().equals(msg.getFeature()) && isAccessible(EsbViewsRepository.DBLookupMediator.Statements.sqlStatements))
				basePart.updateSqlStatements();
					// Start of user code for DatabaseConfiguration live update
					
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
			EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_ConnectionType(),
			EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_ConnectionDsType(),
			EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_ConnectionDbType(),
			EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_ConnectionDbDriver(),
			EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_ConnectionDsInitialContext(),
			EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_ConnectionDsName(),
			EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_ConnectionURL(),
			EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_ConnectionUsername(),
			EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_ConnectionPassword(),
			EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyAutocommit(),
			EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyIsolation(),
			EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyMaxactive(),
			EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyMaxidle(),
			EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyMaxopenstatements(),
			EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyMaxwait(),
			EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyMinidle(),
			EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyPoolstatements(),
			EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyTestonborrow(),
			EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyTestwhileidle(),
			EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyValidationquery(),
			EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyInitialsize(),
			EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_SqlStatements(),
			EsbPackage.eINSTANCE.getMediator_Reverse()		);
		return new NotificationFilter[] {filter,};
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#getHelpContent(java.lang.Object, int)
	 * 
	 */
	public String getHelpContent(Object key, int kind) {
		if (key == EsbViewsRepository.DBLookupMediator.Statements.sqlStatements)
			return "SQL Statements"; //$NON-NLS-1$
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
				if (EsbViewsRepository.DBLookupMediator.Misc.description == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.DBLookupMediator.Properties.commentsList == event.getAffectedEditor()) {
					BasicDiagnostic chain = new BasicDiagnostic();
					for (Iterator iterator = ((List)event.getNewValue()).iterator(); iterator.hasNext();) {
						chain.add(Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEAttributeType(), iterator.next()));
					}
					ret = chain;
				}
				if (EsbViewsRepository.DBLookupMediator.Properties.reverse == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMediator_Reverse().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMediator_Reverse().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.DBLookupMediator.Connection.connectionType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_ConnectionType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_ConnectionType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.DBLookupMediator.Connection.connectionDsType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_ConnectionDsType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_ConnectionDsType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.DBLookupMediator.Connection.connectionDbType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_ConnectionDbType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_ConnectionDbType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.DBLookupMediator.Connection.connectionDbDriver == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_ConnectionDbDriver().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_ConnectionDbDriver().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.DBLookupMediator.Connection.connectionDsInitialContext == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_ConnectionDsInitialContext().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_ConnectionDsInitialContext().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.DBLookupMediator.Connection.connectionDsName == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_ConnectionDsName().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_ConnectionDsName().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.DBLookupMediator.Connection.connectionURL == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_ConnectionURL().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_ConnectionURL().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.DBLookupMediator.Connection.connectionUsername == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_ConnectionUsername().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_ConnectionUsername().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.DBLookupMediator.Connection.connectionPassword == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_ConnectionPassword().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_ConnectionPassword().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.DBLookupMediator.Properties.propertyAutocommit == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyAutocommit().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyAutocommit().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.DBLookupMediator.Properties.propertyIsolation == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyIsolation().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyIsolation().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.DBLookupMediator.Properties.propertyMaxactive == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyMaxactive().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyMaxactive().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.DBLookupMediator.Properties.propertyMaxidle == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyMaxidle().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyMaxidle().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.DBLookupMediator.Properties.propertyMaxopenstatements == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyMaxopenstatements().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyMaxopenstatements().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.DBLookupMediator.Properties.propertyMaxwait == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyMaxwait().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyMaxwait().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.DBLookupMediator.Properties.propertyMinidle == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyMinidle().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyMinidle().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.DBLookupMediator.Properties.propertyPoolstatements == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyPoolstatements().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyPoolstatements().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.DBLookupMediator.Properties.propertyTestonborrow == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyTestonborrow().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyTestonborrow().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.DBLookupMediator.Properties.propertyTestwhileidle == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyTestwhileidle().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyTestwhileidle().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.DBLookupMediator.Properties.propertyValidationquery == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyValidationquery().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyValidationquery().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.DBLookupMediator.Properties.propertyInitialsize == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyInitialsize().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyInitialsize().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.DBLookupMediator.Connection.databaseConfiguration == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMediator_Reverse().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMediator_Reverse().getEAttributeType(), newValue);
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
