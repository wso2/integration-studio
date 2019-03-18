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

import org.wso2.developerstudio.eclipse.gmf.esb.DBReportMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.SqlDatabaseType;
import org.wso2.developerstudio.eclipse.gmf.esb.SqlExecutorBooleanValue;
import org.wso2.developerstudio.eclipse.gmf.esb.SqlExecutorConnectionType;
import org.wso2.developerstudio.eclipse.gmf.esb.SqlExecutorDatasourceType;
import org.wso2.developerstudio.eclipse.gmf.esb.SqlExecutorIsolationLevel;
import org.wso2.developerstudio.eclipse.gmf.esb.SqlStatement;

import org.wso2.developerstudio.eclipse.gmf.esb.parts.DBReportMediatorPropertiesEditionPart;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;


// End of user code

/**
 * 
 * 
 */
public class DBReportMediatorPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	/**
	 * Settings for sqlStatements ReferencesTable
	 */
	protected ReferencesTableSettings sqlStatementsSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public DBReportMediatorPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject dBReportMediator, String editing_mode) {
		super(editingContext, dBReportMediator, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EsbViewsRepository.class;
		partKey = EsbViewsRepository.DBReportMediator.class;
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
			
			final DBReportMediator dBReportMediator = (DBReportMediator)elt;
			final DBReportMediatorPropertiesEditionPart basePart = (DBReportMediatorPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EsbViewsRepository.DBReportMediator.Misc.description))
				basePart.setDescription(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, dBReportMediator.getDescription()));
			
			if (isAccessible(EsbViewsRepository.DBReportMediator.Properties.commentsList))
				basePart.setCommentsList(dBReportMediator.getCommentsList());
			
			if (isAccessible(EsbViewsRepository.DBReportMediator.Properties.reverse)) {
				basePart.setReverse(dBReportMediator.isReverse());
			}
			if (isAccessible(EsbViewsRepository.DBReportMediator.Connection.connectionType)) {
				basePart.initConnectionType(EEFUtils.choiceOfValues(dBReportMediator, EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_ConnectionType()), dBReportMediator.getConnectionType());
			}
			if (isAccessible(EsbViewsRepository.DBReportMediator.Connection.connectionDsType)) {
				basePart.initConnectionDsType(EEFUtils.choiceOfValues(dBReportMediator, EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_ConnectionDsType()), dBReportMediator.getConnectionDsType());
			}
			if (isAccessible(EsbViewsRepository.DBReportMediator.Connection.connectionDbType)) {
				basePart.initConnectionDbType(EEFUtils.choiceOfValues(dBReportMediator, EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_ConnectionDbType()), dBReportMediator.getConnectionDbType());
			}
			if (isAccessible(EsbViewsRepository.DBReportMediator.Connection.connectionDbDriver))
				basePart.setConnectionDbDriver(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, dBReportMediator.getConnectionDbDriver()));
			
			if (isAccessible(EsbViewsRepository.DBReportMediator.Connection.connectionDsInitialContext))
				basePart.setConnectionDsInitialContext(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, dBReportMediator.getConnectionDsInitialContext()));
			
			if (isAccessible(EsbViewsRepository.DBReportMediator.Connection.connectionDsName))
				basePart.setConnectionDsName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, dBReportMediator.getConnectionDsName()));
			
			if (isAccessible(EsbViewsRepository.DBReportMediator.Connection.connectionURL))
				basePart.setConnectionURL(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, dBReportMediator.getConnectionURL()));
			
			if (isAccessible(EsbViewsRepository.DBReportMediator.Connection.connectionUsername))
				basePart.setConnectionUsername(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, dBReportMediator.getConnectionUsername()));
			
			if (isAccessible(EsbViewsRepository.DBReportMediator.Connection.connectionPassword))
				basePart.setConnectionPassword(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, dBReportMediator.getConnectionPassword()));
			
			if (isAccessible(EsbViewsRepository.DBReportMediator.Properties.propertyAutocommit)) {
				basePart.initPropertyAutocommit(EEFUtils.choiceOfValues(dBReportMediator, EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyAutocommit()), dBReportMediator.getPropertyAutocommit());
			}
			if (isAccessible(EsbViewsRepository.DBReportMediator.Properties.propertyIsolation)) {
				basePart.initPropertyIsolation(EEFUtils.choiceOfValues(dBReportMediator, EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyIsolation()), dBReportMediator.getPropertyIsolation());
			}
			if (isAccessible(EsbViewsRepository.DBReportMediator.Properties.propertyMaxactive)) {
				basePart.setPropertyMaxactive(EEFConverterUtil.convertToString(EcorePackage.Literals.EINT, dBReportMediator.getPropertyMaxactive()));
			}
			
			if (isAccessible(EsbViewsRepository.DBReportMediator.Properties.propertyMaxidle)) {
				basePart.setPropertyMaxidle(EEFConverterUtil.convertToString(EcorePackage.Literals.EINT, dBReportMediator.getPropertyMaxidle()));
			}
			
			if (isAccessible(EsbViewsRepository.DBReportMediator.Properties.propertyMaxopenstatements)) {
				basePart.setPropertyMaxopenstatements(EEFConverterUtil.convertToString(EcorePackage.Literals.EINT, dBReportMediator.getPropertyMaxopenstatements()));
			}
			
			if (isAccessible(EsbViewsRepository.DBReportMediator.Properties.propertyMaxwait)) {
				basePart.setPropertyMaxwait(EEFConverterUtil.convertToString(EcorePackage.Literals.EINT, dBReportMediator.getPropertyMaxwait()));
			}
			
			if (isAccessible(EsbViewsRepository.DBReportMediator.Properties.propertyMinidle)) {
				basePart.setPropertyMinidle(EEFConverterUtil.convertToString(EcorePackage.Literals.EINT, dBReportMediator.getPropertyMinidle()));
			}
			
			if (isAccessible(EsbViewsRepository.DBReportMediator.Properties.propertyPoolstatements)) {
				basePart.initPropertyPoolstatements(EEFUtils.choiceOfValues(dBReportMediator, EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyPoolstatements()), dBReportMediator.getPropertyPoolstatements());
			}
			if (isAccessible(EsbViewsRepository.DBReportMediator.Properties.propertyTestonborrow)) {
				basePart.initPropertyTestonborrow(EEFUtils.choiceOfValues(dBReportMediator, EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyTestonborrow()), dBReportMediator.getPropertyTestonborrow());
			}
			if (isAccessible(EsbViewsRepository.DBReportMediator.Properties.propertyTestwhileidle)) {
				basePart.initPropertyTestwhileidle(EEFUtils.choiceOfValues(dBReportMediator, EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyTestwhileidle()), dBReportMediator.getPropertyTestwhileidle());
			}
			if (isAccessible(EsbViewsRepository.DBReportMediator.Properties.propertyValidationquery))
				basePart.setPropertyValidationquery(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, dBReportMediator.getPropertyValidationquery()));
			
			if (isAccessible(EsbViewsRepository.DBReportMediator.Properties.propertyInitialsize)) {
				basePart.setPropertyInitialsize(EEFConverterUtil.convertToString(EcorePackage.Literals.EINT, dBReportMediator.getPropertyInitialsize()));
			}
			
			if (isAccessible(EsbViewsRepository.DBReportMediator.Statements.sqlStatements)) {
				sqlStatementsSettings = new ReferencesTableSettings(dBReportMediator, EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_SqlStatements());
				basePart.initSqlStatements(sqlStatementsSettings);
			}
			if (isAccessible(EsbViewsRepository.DBReportMediator.Connection.connectionUseTransaction)) {
				basePart.setConnectionUseTransaction(dBReportMediator.isConnectionUseTransaction());
			}
			// Start of user code  for Database Configuration command update
			// End of user code
			
			// init filters
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			if (isAccessible(EsbViewsRepository.DBReportMediator.Statements.sqlStatements)) {
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
			
			// Start of user code  for Database Configuration filter update
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
		if (editorKey == EsbViewsRepository.DBReportMediator.Misc.description) {
			return EsbPackage.eINSTANCE.getEsbElement_Description();
		}
		if (editorKey == EsbViewsRepository.DBReportMediator.Properties.commentsList) {
			return EsbPackage.eINSTANCE.getEsbElement_CommentsList();
		}
		if (editorKey == EsbViewsRepository.DBReportMediator.Properties.reverse) {
			return EsbPackage.eINSTANCE.getMediator_Reverse();
		}
		if (editorKey == EsbViewsRepository.DBReportMediator.Connection.connectionType) {
			return EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_ConnectionType();
		}
		if (editorKey == EsbViewsRepository.DBReportMediator.Connection.connectionDsType) {
			return EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_ConnectionDsType();
		}
		if (editorKey == EsbViewsRepository.DBReportMediator.Connection.connectionDbType) {
			return EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_ConnectionDbType();
		}
		if (editorKey == EsbViewsRepository.DBReportMediator.Connection.connectionDbDriver) {
			return EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_ConnectionDbDriver();
		}
		if (editorKey == EsbViewsRepository.DBReportMediator.Connection.connectionDsInitialContext) {
			return EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_ConnectionDsInitialContext();
		}
		if (editorKey == EsbViewsRepository.DBReportMediator.Connection.connectionDsName) {
			return EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_ConnectionDsName();
		}
		if (editorKey == EsbViewsRepository.DBReportMediator.Connection.connectionURL) {
			return EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_ConnectionURL();
		}
		if (editorKey == EsbViewsRepository.DBReportMediator.Connection.connectionUsername) {
			return EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_ConnectionUsername();
		}
		if (editorKey == EsbViewsRepository.DBReportMediator.Connection.connectionPassword) {
			return EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_ConnectionPassword();
		}
		if (editorKey == EsbViewsRepository.DBReportMediator.Properties.propertyAutocommit) {
			return EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyAutocommit();
		}
		if (editorKey == EsbViewsRepository.DBReportMediator.Properties.propertyIsolation) {
			return EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyIsolation();
		}
		if (editorKey == EsbViewsRepository.DBReportMediator.Properties.propertyMaxactive) {
			return EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyMaxactive();
		}
		if (editorKey == EsbViewsRepository.DBReportMediator.Properties.propertyMaxidle) {
			return EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyMaxidle();
		}
		if (editorKey == EsbViewsRepository.DBReportMediator.Properties.propertyMaxopenstatements) {
			return EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyMaxopenstatements();
		}
		if (editorKey == EsbViewsRepository.DBReportMediator.Properties.propertyMaxwait) {
			return EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyMaxwait();
		}
		if (editorKey == EsbViewsRepository.DBReportMediator.Properties.propertyMinidle) {
			return EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyMinidle();
		}
		if (editorKey == EsbViewsRepository.DBReportMediator.Properties.propertyPoolstatements) {
			return EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyPoolstatements();
		}
		if (editorKey == EsbViewsRepository.DBReportMediator.Properties.propertyTestonborrow) {
			return EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyTestonborrow();
		}
		if (editorKey == EsbViewsRepository.DBReportMediator.Properties.propertyTestwhileidle) {
			return EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyTestwhileidle();
		}
		if (editorKey == EsbViewsRepository.DBReportMediator.Properties.propertyValidationquery) {
			return EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyValidationquery();
		}
		if (editorKey == EsbViewsRepository.DBReportMediator.Properties.propertyInitialsize) {
			return EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyInitialsize();
		}
		if (editorKey == EsbViewsRepository.DBReportMediator.Statements.sqlStatements) {
			return EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_SqlStatements();
		}
		if (editorKey == EsbViewsRepository.DBReportMediator.Connection.connectionUseTransaction) {
			return EsbPackage.eINSTANCE.getDBReportMediator_ConnectionUseTransaction();
		}
		if (editorKey == EsbViewsRepository.DBReportMediator.Connection.databaseConfiguration) {
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
		DBReportMediator dBReportMediator = (DBReportMediator)semanticObject;
		if (EsbViewsRepository.DBReportMediator.Misc.description == event.getAffectedEditor()) {
			dBReportMediator.setDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.DBReportMediator.Properties.commentsList == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				dBReportMediator.getCommentsList().clear();
				dBReportMediator.getCommentsList().addAll(((EList) event.getNewValue()));
			}
		}
		if (EsbViewsRepository.DBReportMediator.Properties.reverse == event.getAffectedEditor()) {
			dBReportMediator.setReverse((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.DBReportMediator.Connection.connectionType == event.getAffectedEditor()) {
			dBReportMediator.setConnectionType((SqlExecutorConnectionType)event.getNewValue());
		}
		if (EsbViewsRepository.DBReportMediator.Connection.connectionDsType == event.getAffectedEditor()) {
			dBReportMediator.setConnectionDsType((SqlExecutorDatasourceType)event.getNewValue());
		}
		if (EsbViewsRepository.DBReportMediator.Connection.connectionDbType == event.getAffectedEditor()) {
			dBReportMediator.setConnectionDbType((SqlDatabaseType)event.getNewValue());
		}
		if (EsbViewsRepository.DBReportMediator.Connection.connectionDbDriver == event.getAffectedEditor()) {
			dBReportMediator.setConnectionDbDriver((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.DBReportMediator.Connection.connectionDsInitialContext == event.getAffectedEditor()) {
			dBReportMediator.setConnectionDsInitialContext((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.DBReportMediator.Connection.connectionDsName == event.getAffectedEditor()) {
			dBReportMediator.setConnectionDsName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.DBReportMediator.Connection.connectionURL == event.getAffectedEditor()) {
			dBReportMediator.setConnectionURL((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.DBReportMediator.Connection.connectionUsername == event.getAffectedEditor()) {
			dBReportMediator.setConnectionUsername((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.DBReportMediator.Connection.connectionPassword == event.getAffectedEditor()) {
			dBReportMediator.setConnectionPassword((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.DBReportMediator.Properties.propertyAutocommit == event.getAffectedEditor()) {
			dBReportMediator.setPropertyAutocommit((SqlExecutorBooleanValue)event.getNewValue());
		}
		if (EsbViewsRepository.DBReportMediator.Properties.propertyIsolation == event.getAffectedEditor()) {
			dBReportMediator.setPropertyIsolation((SqlExecutorIsolationLevel)event.getNewValue());
		}
		if (EsbViewsRepository.DBReportMediator.Properties.propertyMaxactive == event.getAffectedEditor()) {
			dBReportMediator.setPropertyMaxactive((EEFConverterUtil.createIntFromString(EcorePackage.Literals.EINT, (String)event.getNewValue())));
		}
		if (EsbViewsRepository.DBReportMediator.Properties.propertyMaxidle == event.getAffectedEditor()) {
			dBReportMediator.setPropertyMaxidle((EEFConverterUtil.createIntFromString(EcorePackage.Literals.EINT, (String)event.getNewValue())));
		}
		if (EsbViewsRepository.DBReportMediator.Properties.propertyMaxopenstatements == event.getAffectedEditor()) {
			dBReportMediator.setPropertyMaxopenstatements((EEFConverterUtil.createIntFromString(EcorePackage.Literals.EINT, (String)event.getNewValue())));
		}
		if (EsbViewsRepository.DBReportMediator.Properties.propertyMaxwait == event.getAffectedEditor()) {
			dBReportMediator.setPropertyMaxwait((EEFConverterUtil.createIntFromString(EcorePackage.Literals.EINT, (String)event.getNewValue())));
		}
		if (EsbViewsRepository.DBReportMediator.Properties.propertyMinidle == event.getAffectedEditor()) {
			dBReportMediator.setPropertyMinidle((EEFConverterUtil.createIntFromString(EcorePackage.Literals.EINT, (String)event.getNewValue())));
		}
		if (EsbViewsRepository.DBReportMediator.Properties.propertyPoolstatements == event.getAffectedEditor()) {
			dBReportMediator.setPropertyPoolstatements((SqlExecutorBooleanValue)event.getNewValue());
		}
		if (EsbViewsRepository.DBReportMediator.Properties.propertyTestonborrow == event.getAffectedEditor()) {
			dBReportMediator.setPropertyTestonborrow((SqlExecutorBooleanValue)event.getNewValue());
		}
		if (EsbViewsRepository.DBReportMediator.Properties.propertyTestwhileidle == event.getAffectedEditor()) {
			dBReportMediator.setPropertyTestwhileidle((SqlExecutorBooleanValue)event.getNewValue());
		}
		if (EsbViewsRepository.DBReportMediator.Properties.propertyValidationquery == event.getAffectedEditor()) {
			dBReportMediator.setPropertyValidationquery((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.DBReportMediator.Properties.propertyInitialsize == event.getAffectedEditor()) {
			dBReportMediator.setPropertyInitialsize((EEFConverterUtil.createIntFromString(EcorePackage.Literals.EINT, (String)event.getNewValue())));
		}
		if (EsbViewsRepository.DBReportMediator.Statements.sqlStatements == event.getAffectedEditor()) {
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
		if (EsbViewsRepository.DBReportMediator.Connection.connectionUseTransaction == event.getAffectedEditor()) {
			dBReportMediator.setConnectionUseTransaction((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.DBReportMediator.Connection.databaseConfiguration == event.getAffectedEditor()) {
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
			DBReportMediatorPropertiesEditionPart basePart = (DBReportMediatorPropertiesEditionPart)editingPart;
			if (EsbPackage.eINSTANCE.getEsbElement_Description().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.DBReportMediator.Misc.description)) {
				if (msg.getNewValue() != null) {
					basePart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setDescription("");
				}
			}
			if (EsbPackage.eINSTANCE.getEsbElement_CommentsList().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.DBReportMediator.Properties.commentsList)) {
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
			
			if (EsbPackage.eINSTANCE.getMediator_Reverse().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.DBReportMediator.Properties.reverse))
				basePart.setReverse((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_ConnectionType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.DBReportMediator.Connection.connectionType))
				basePart.setConnectionType((SqlExecutorConnectionType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_ConnectionDsType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.DBReportMediator.Connection.connectionDsType))
				basePart.setConnectionDsType((SqlExecutorDatasourceType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_ConnectionDbType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.DBReportMediator.Connection.connectionDbType))
				basePart.setConnectionDbType((SqlDatabaseType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_ConnectionDbDriver().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.DBReportMediator.Connection.connectionDbDriver)) {
				if (msg.getNewValue() != null) {
					basePart.setConnectionDbDriver(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setConnectionDbDriver("");
				}
			}
			if (EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_ConnectionDsInitialContext().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.DBReportMediator.Connection.connectionDsInitialContext)) {
				if (msg.getNewValue() != null) {
					basePart.setConnectionDsInitialContext(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setConnectionDsInitialContext("");
				}
			}
			if (EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_ConnectionDsName().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.DBReportMediator.Connection.connectionDsName)) {
				if (msg.getNewValue() != null) {
					basePart.setConnectionDsName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setConnectionDsName("");
				}
			}
			if (EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_ConnectionURL().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.DBReportMediator.Connection.connectionURL)) {
				if (msg.getNewValue() != null) {
					basePart.setConnectionURL(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setConnectionURL("");
				}
			}
			if (EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_ConnectionUsername().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.DBReportMediator.Connection.connectionUsername)) {
				if (msg.getNewValue() != null) {
					basePart.setConnectionUsername(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setConnectionUsername("");
				}
			}
			if (EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_ConnectionPassword().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.DBReportMediator.Connection.connectionPassword)) {
				if (msg.getNewValue() != null) {
					basePart.setConnectionPassword(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setConnectionPassword("");
				}
			}
			if (EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyAutocommit().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.DBReportMediator.Properties.propertyAutocommit))
				basePart.setPropertyAutocommit((SqlExecutorBooleanValue)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyIsolation().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.DBReportMediator.Properties.propertyIsolation))
				basePart.setPropertyIsolation((SqlExecutorIsolationLevel)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyMaxactive().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.DBReportMediator.Properties.propertyMaxactive)) {
				if (msg.getNewValue() != null) {
					basePart.setPropertyMaxactive(EcoreUtil.convertToString(EcorePackage.Literals.EINT, msg.getNewValue()));
				} else {
					basePart.setPropertyMaxactive("");
				}
			}
			if (EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyMaxidle().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.DBReportMediator.Properties.propertyMaxidle)) {
				if (msg.getNewValue() != null) {
					basePart.setPropertyMaxidle(EcoreUtil.convertToString(EcorePackage.Literals.EINT, msg.getNewValue()));
				} else {
					basePart.setPropertyMaxidle("");
				}
			}
			if (EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyMaxopenstatements().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.DBReportMediator.Properties.propertyMaxopenstatements)) {
				if (msg.getNewValue() != null) {
					basePart.setPropertyMaxopenstatements(EcoreUtil.convertToString(EcorePackage.Literals.EINT, msg.getNewValue()));
				} else {
					basePart.setPropertyMaxopenstatements("");
				}
			}
			if (EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyMaxwait().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.DBReportMediator.Properties.propertyMaxwait)) {
				if (msg.getNewValue() != null) {
					basePart.setPropertyMaxwait(EcoreUtil.convertToString(EcorePackage.Literals.EINT, msg.getNewValue()));
				} else {
					basePart.setPropertyMaxwait("");
				}
			}
			if (EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyMinidle().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.DBReportMediator.Properties.propertyMinidle)) {
				if (msg.getNewValue() != null) {
					basePart.setPropertyMinidle(EcoreUtil.convertToString(EcorePackage.Literals.EINT, msg.getNewValue()));
				} else {
					basePart.setPropertyMinidle("");
				}
			}
			if (EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyPoolstatements().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.DBReportMediator.Properties.propertyPoolstatements))
				basePart.setPropertyPoolstatements((SqlExecutorBooleanValue)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyTestonborrow().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.DBReportMediator.Properties.propertyTestonborrow))
				basePart.setPropertyTestonborrow((SqlExecutorBooleanValue)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyTestwhileidle().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.DBReportMediator.Properties.propertyTestwhileidle))
				basePart.setPropertyTestwhileidle((SqlExecutorBooleanValue)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyValidationquery().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.DBReportMediator.Properties.propertyValidationquery)) {
				if (msg.getNewValue() != null) {
					basePart.setPropertyValidationquery(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setPropertyValidationquery("");
				}
			}
			if (EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyInitialsize().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.DBReportMediator.Properties.propertyInitialsize)) {
				if (msg.getNewValue() != null) {
					basePart.setPropertyInitialsize(EcoreUtil.convertToString(EcorePackage.Literals.EINT, msg.getNewValue()));
				} else {
					basePart.setPropertyInitialsize("");
				}
			}
			if (EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_SqlStatements().equals(msg.getFeature()) && isAccessible(EsbViewsRepository.DBReportMediator.Statements.sqlStatements))
				basePart.updateSqlStatements();
			if (EsbPackage.eINSTANCE.getDBReportMediator_ConnectionUseTransaction().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.DBReportMediator.Connection.connectionUseTransaction))
				basePart.setConnectionUseTransaction((Boolean)msg.getNewValue());
			
					// Start of user code for Database Configuration live update
					
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
			EsbPackage.eINSTANCE.getDBReportMediator_ConnectionUseTransaction(),
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
		if (key == EsbViewsRepository.DBReportMediator.Statements.sqlStatements)
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
				if (EsbViewsRepository.DBReportMediator.Misc.description == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.DBReportMediator.Properties.commentsList == event.getAffectedEditor()) {
					BasicDiagnostic chain = new BasicDiagnostic();
					for (Iterator iterator = ((List)event.getNewValue()).iterator(); iterator.hasNext();) {
						chain.add(Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEAttributeType(), iterator.next()));
					}
					ret = chain;
				}
				if (EsbViewsRepository.DBReportMediator.Properties.reverse == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMediator_Reverse().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMediator_Reverse().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.DBReportMediator.Connection.connectionType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_ConnectionType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_ConnectionType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.DBReportMediator.Connection.connectionDsType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_ConnectionDsType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_ConnectionDsType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.DBReportMediator.Connection.connectionDbType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_ConnectionDbType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_ConnectionDbType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.DBReportMediator.Connection.connectionDbDriver == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_ConnectionDbDriver().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_ConnectionDbDriver().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.DBReportMediator.Connection.connectionDsInitialContext == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_ConnectionDsInitialContext().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_ConnectionDsInitialContext().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.DBReportMediator.Connection.connectionDsName == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_ConnectionDsName().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_ConnectionDsName().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.DBReportMediator.Connection.connectionURL == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_ConnectionURL().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_ConnectionURL().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.DBReportMediator.Connection.connectionUsername == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_ConnectionUsername().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_ConnectionUsername().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.DBReportMediator.Connection.connectionPassword == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_ConnectionPassword().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_ConnectionPassword().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.DBReportMediator.Properties.propertyAutocommit == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyAutocommit().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyAutocommit().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.DBReportMediator.Properties.propertyIsolation == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyIsolation().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyIsolation().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.DBReportMediator.Properties.propertyMaxactive == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyMaxactive().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyMaxactive().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.DBReportMediator.Properties.propertyMaxidle == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyMaxidle().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyMaxidle().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.DBReportMediator.Properties.propertyMaxopenstatements == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyMaxopenstatements().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyMaxopenstatements().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.DBReportMediator.Properties.propertyMaxwait == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyMaxwait().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyMaxwait().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.DBReportMediator.Properties.propertyMinidle == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyMinidle().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyMinidle().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.DBReportMediator.Properties.propertyPoolstatements == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyPoolstatements().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyPoolstatements().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.DBReportMediator.Properties.propertyTestonborrow == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyTestonborrow().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyTestonborrow().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.DBReportMediator.Properties.propertyTestwhileidle == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyTestwhileidle().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyTestwhileidle().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.DBReportMediator.Properties.propertyValidationquery == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyValidationquery().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyValidationquery().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.DBReportMediator.Properties.propertyInitialsize == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyInitialsize().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getAbstractSqlExecutorMediator_PropertyInitialsize().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.DBReportMediator.Connection.connectionUseTransaction == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getDBReportMediator_ConnectionUseTransaction().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getDBReportMediator_ConnectionUseTransaction().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.DBReportMediator.Connection.databaseConfiguration == event.getAffectedEditor()) {
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
