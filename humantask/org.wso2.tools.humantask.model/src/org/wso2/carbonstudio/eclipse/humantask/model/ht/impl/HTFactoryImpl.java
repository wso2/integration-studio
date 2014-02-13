/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.humantask.model.ht.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.emf.ecore.xml.type.XMLTypeFactory;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

import org.wso2.developerstudio.eclipse.humantask.model.ht.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class HTFactoryImpl extends EFactoryImpl implements HTFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static HTFactory init() {
		try {
			HTFactory theHTFactory = (HTFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.example.org/WS-HT"); 
			if (theHTFactory != null) {
				return theHTFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new HTFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HTFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case HTPackage.DOCUMENT_ROOT: return createDocumentRoot();
			case HTPackage.TARGUMENT: return createTArgument();
			case HTPackage.TBOOLEAN_EXPR: return createTBooleanExpr();
			case HTPackage.TDEADLINE: return createTDeadline();
			case HTPackage.TDEADLINE_EXPR: return createTDeadlineExpr();
			case HTPackage.TDEADLINES: return createTDeadlines();
			case HTPackage.TDELEGATION: return createTDelegation();
			case HTPackage.TDESCRIPTION: return createTDescription();
			case HTPackage.TDOCUMENTATION: return createTDocumentation();
			case HTPackage.TDURATION_EXPR: return createTDurationExpr();
			case HTPackage.TESCALATION: return createTEscalation();
			case HTPackage.TEXPRESSION: return createTExpression();
			case HTPackage.TEXTENSIBLE_ELEMENTS: return createTExtensibleElements();
			case HTPackage.TEXTENSIBLE_MIXED_CONTENT_ELEMENTS: return createTExtensibleMixedContentElements();
			case HTPackage.TEXTENSION: return createTExtension();
			case HTPackage.TEXTENSIONS: return createTExtensions();
			case HTPackage.TFROM: return createTFrom();
			case HTPackage.TGENERIC_HUMAN_ROLE: return createTGenericHumanRole();
			case HTPackage.TGROUPLIST: return createTGrouplist();
			case HTPackage.THUMAN_INTERACTIONS: return createTHumanInteractions();
			case HTPackage.TIMPORT: return createTImport();
			case HTPackage.TLITERAL: return createTLiteral();
			case HTPackage.TLOCAL_NOTIFICATION: return createTLocalNotification();
			case HTPackage.TLOGICAL_PEOPLE_GROUP: return createTLogicalPeopleGroup();
			case HTPackage.TLOGICAL_PEOPLE_GROUPS: return createTLogicalPeopleGroups();
			case HTPackage.TNOTIFICATION: return createTNotification();
			case HTPackage.TNOTIFICATION_INTERFACE: return createTNotificationInterface();
			case HTPackage.TNOTIFICATIONS: return createTNotifications();
			case HTPackage.TORGANIZATIONAL_ENTITY: return createTOrganizationalEntity();
			case HTPackage.TPARAMETER: return createTParameter();
			case HTPackage.TPEOPLE_ASSIGNMENTS: return createTPeopleAssignments();
			case HTPackage.TPRESENTATION_ELEMENTS: return createTPresentationElements();
			case HTPackage.TPRESENTATION_PARAMETER: return createTPresentationParameter();
			case HTPackage.TPRESENTATION_PARAMETERS: return createTPresentationParameters();
			case HTPackage.TPRIORITY: return createTPriority();
			case HTPackage.TQUERY: return createTQuery();
			case HTPackage.TREASSIGNMENT: return createTReassignment();
			case HTPackage.TRENDERING: return createTRendering();
			case HTPackage.TRENDERINGS: return createTRenderings();
			case HTPackage.TTASK: return createTTask();
			case HTPackage.TTASK_INTERFACE: return createTTaskInterface();
			case HTPackage.TTASKS: return createTTasks();
			case HTPackage.TTEXT: return createTText();
			case HTPackage.TTO_PART: return createTToPart();
			case HTPackage.TTO_PARTS: return createTToParts();
			case HTPackage.TUSERLIST: return createTUserlist();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case HTPackage.TBOOLEAN:
				return createTBooleanFromString(eDataType, initialValue);
			case HTPackage.TPOTENTIAL_DELEGATEES:
				return createTPotentialDelegateesFromString(eDataType, initialValue);
			case HTPackage.TBOOLEAN_OBJECT:
				return createTBooleanObjectFromString(eDataType, initialValue);
			case HTPackage.TGROUP:
				return createTGroupFromString(eDataType, initialValue);
			case HTPackage.TPOTENTIAL_DELEGATEES_OBJECT:
				return createTPotentialDelegateesObjectFromString(eDataType, initialValue);
			case HTPackage.TUSER:
				return createTUserFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case HTPackage.TBOOLEAN:
				return convertTBooleanToString(eDataType, instanceValue);
			case HTPackage.TPOTENTIAL_DELEGATEES:
				return convertTPotentialDelegateesToString(eDataType, instanceValue);
			case HTPackage.TBOOLEAN_OBJECT:
				return convertTBooleanObjectToString(eDataType, instanceValue);
			case HTPackage.TGROUP:
				return convertTGroupToString(eDataType, instanceValue);
			case HTPackage.TPOTENTIAL_DELEGATEES_OBJECT:
				return convertTPotentialDelegateesObjectToString(eDataType, instanceValue);
			case HTPackage.TUSER:
				return convertTUserToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DocumentRoot createDocumentRoot() {
		DocumentRootImpl documentRoot = new DocumentRootImpl();
		return documentRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TArgument createTArgument() {
		TArgumentImpl tArgument = new TArgumentImpl();
		return tArgument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TBooleanExpr createTBooleanExpr() {
		TBooleanExprImpl tBooleanExpr = new TBooleanExprImpl();
		return tBooleanExpr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TDeadline createTDeadline() {
		TDeadlineImpl tDeadline = new TDeadlineImpl();
		return tDeadline;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TDeadlineExpr createTDeadlineExpr() {
		TDeadlineExprImpl tDeadlineExpr = new TDeadlineExprImpl();
		return tDeadlineExpr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TDeadlines createTDeadlines() {
		TDeadlinesImpl tDeadlines = new TDeadlinesImpl();
		return tDeadlines;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TDelegation createTDelegation() {
		TDelegationImpl tDelegation = new TDelegationImpl();
		return tDelegation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TDescription createTDescription() {
		TDescriptionImpl tDescription = new TDescriptionImpl();
		return tDescription;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TDocumentation createTDocumentation() {
		TDocumentationImpl tDocumentation = new TDocumentationImpl();
		return tDocumentation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TDurationExpr createTDurationExpr() {
		TDurationExprImpl tDurationExpr = new TDurationExprImpl();
		return tDurationExpr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TEscalation createTEscalation() {
		TEscalationImpl tEscalation = new TEscalationImpl();
		return tEscalation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TExpression createTExpression() {
		TExpressionImpl tExpression = new TExpressionImpl();
		return tExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TExtensibleElements createTExtensibleElements() {
		TExtensibleElementsImpl tExtensibleElements = new TExtensibleElementsImpl();
		return tExtensibleElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TExtensibleMixedContentElements createTExtensibleMixedContentElements() {
		TExtensibleMixedContentElementsImpl tExtensibleMixedContentElements = new TExtensibleMixedContentElementsImpl();
		return tExtensibleMixedContentElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TExtension createTExtension() {
		TExtensionImpl tExtension = new TExtensionImpl();
		return tExtension;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TExtensions createTExtensions() {
		TExtensionsImpl tExtensions = new TExtensionsImpl();
		return tExtensions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TFrom createTFrom() {
		TFromImpl tFrom = new TFromImpl();
		return tFrom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TGenericHumanRole createTGenericHumanRole() {
		TGenericHumanRoleImpl tGenericHumanRole = new TGenericHumanRoleImpl();
		return tGenericHumanRole;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TGrouplist createTGrouplist() {
		TGrouplistImpl tGrouplist = new TGrouplistImpl();
		return tGrouplist;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public THumanInteractions createTHumanInteractions() {
		THumanInteractionsImpl tHumanInteractions = new THumanInteractionsImpl();
		return tHumanInteractions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TImport createTImport() {
		TImportImpl tImport = new TImportImpl();
		return tImport;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TLiteral createTLiteral() {
		TLiteralImpl tLiteral = new TLiteralImpl();
		return tLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TLocalNotification createTLocalNotification() {
		TLocalNotificationImpl tLocalNotification = new TLocalNotificationImpl();
		return tLocalNotification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TLogicalPeopleGroup createTLogicalPeopleGroup() {
		TLogicalPeopleGroupImpl tLogicalPeopleGroup = new TLogicalPeopleGroupImpl();
		return tLogicalPeopleGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TLogicalPeopleGroups createTLogicalPeopleGroups() {
		TLogicalPeopleGroupsImpl tLogicalPeopleGroups = new TLogicalPeopleGroupsImpl();
		return tLogicalPeopleGroups;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TNotification createTNotification() {
		TNotificationImpl tNotification = new TNotificationImpl();
		return tNotification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TNotificationInterface createTNotificationInterface() {
		TNotificationInterfaceImpl tNotificationInterface = new TNotificationInterfaceImpl();
		return tNotificationInterface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TNotifications createTNotifications() {
		TNotificationsImpl tNotifications = new TNotificationsImpl();
		return tNotifications;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TOrganizationalEntity createTOrganizationalEntity() {
		TOrganizationalEntityImpl tOrganizationalEntity = new TOrganizationalEntityImpl();
		return tOrganizationalEntity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TParameter createTParameter() {
		TParameterImpl tParameter = new TParameterImpl();
		return tParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TPeopleAssignments createTPeopleAssignments() {
		TPeopleAssignmentsImpl tPeopleAssignments = new TPeopleAssignmentsImpl();
		return tPeopleAssignments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TPresentationElements createTPresentationElements() {
		TPresentationElementsImpl tPresentationElements = new TPresentationElementsImpl();
		return tPresentationElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TPresentationParameter createTPresentationParameter() {
		TPresentationParameterImpl tPresentationParameter = new TPresentationParameterImpl();
		return tPresentationParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TPresentationParameters createTPresentationParameters() {
		TPresentationParametersImpl tPresentationParameters = new TPresentationParametersImpl();
		return tPresentationParameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TPriority createTPriority() {
		TPriorityImpl tPriority = new TPriorityImpl();
		return tPriority;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TQuery createTQuery() {
		TQueryImpl tQuery = new TQueryImpl();
		return tQuery;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TReassignment createTReassignment() {
		TReassignmentImpl tReassignment = new TReassignmentImpl();
		return tReassignment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TRendering createTRendering() {
		TRenderingImpl tRendering = new TRenderingImpl();
		return tRendering;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TRenderings createTRenderings() {
		TRenderingsImpl tRenderings = new TRenderingsImpl();
		return tRenderings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TTask createTTask() {
		TTaskImpl tTask = new TTaskImpl();
		return tTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TTaskInterface createTTaskInterface() {
		TTaskInterfaceImpl tTaskInterface = new TTaskInterfaceImpl();
		return tTaskInterface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TTasks createTTasks() {
		TTasksImpl tTasks = new TTasksImpl();
		return tTasks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TText createTText() {
		TTextImpl tText = new TTextImpl();
		return tText;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TToPart createTToPart() {
		TToPartImpl tToPart = new TToPartImpl();
		return tToPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TToParts createTToParts() {
		TToPartsImpl tToParts = new TToPartsImpl();
		return tToParts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TUserlist createTUserlist() {
		TUserlistImpl tUserlist = new TUserlistImpl();
		return tUserlist;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TBoolean createTBooleanFromString(EDataType eDataType, String initialValue) {
		TBoolean result = TBoolean.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTBooleanToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TPotentialDelegatees createTPotentialDelegateesFromString(EDataType eDataType, String initialValue) {
		TPotentialDelegatees result = TPotentialDelegatees.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTPotentialDelegateesToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TBoolean createTBooleanObjectFromString(EDataType eDataType, String initialValue) {
		return createTBooleanFromString(HTPackage.Literals.TBOOLEAN, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTBooleanObjectToString(EDataType eDataType, Object instanceValue) {
		return convertTBooleanToString(HTPackage.Literals.TBOOLEAN, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createTGroupFromString(EDataType eDataType, String initialValue) {
		return (String)XMLTypeFactory.eINSTANCE.createFromString(XMLTypePackage.Literals.STRING, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTGroupToString(EDataType eDataType, Object instanceValue) {
		return XMLTypeFactory.eINSTANCE.convertToString(XMLTypePackage.Literals.STRING, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TPotentialDelegatees createTPotentialDelegateesObjectFromString(EDataType eDataType, String initialValue) {
		return createTPotentialDelegateesFromString(HTPackage.Literals.TPOTENTIAL_DELEGATEES, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTPotentialDelegateesObjectToString(EDataType eDataType, Object instanceValue) {
		return convertTPotentialDelegateesToString(HTPackage.Literals.TPOTENTIAL_DELEGATEES, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createTUserFromString(EDataType eDataType, String initialValue) {
		return (String)XMLTypeFactory.eINSTANCE.createFromString(XMLTypePackage.Literals.STRING, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTUserToString(EDataType eDataType, Object instanceValue) {
		return XMLTypeFactory.eINSTANCE.convertToString(XMLTypePackage.Literals.STRING, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HTPackage getHTPackage() {
		return (HTPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static HTPackage getPackage() {
		return HTPackage.eINSTANCE;
	}

} //HTFactoryImpl
