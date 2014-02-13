/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.humantask.model.ht.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.ecore.xml.namespace.XMLNamespacePackage;

import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

import org.wso2.developerstudio.eclipse.humantask.model.ht.DocumentRoot;
import org.wso2.developerstudio.eclipse.humantask.model.ht.HTFactory;
import org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage;
import org.wso2.developerstudio.eclipse.humantask.model.ht.TArgument;
import org.wso2.developerstudio.eclipse.humantask.model.ht.TBoolean;
import org.wso2.developerstudio.eclipse.humantask.model.ht.TBooleanExpr;
import org.wso2.developerstudio.eclipse.humantask.model.ht.TDeadline;
import org.wso2.developerstudio.eclipse.humantask.model.ht.TDeadlineExpr;
import org.wso2.developerstudio.eclipse.humantask.model.ht.TDeadlines;
import org.wso2.developerstudio.eclipse.humantask.model.ht.TDelegation;
import org.wso2.developerstudio.eclipse.humantask.model.ht.TDescription;
import org.wso2.developerstudio.eclipse.humantask.model.ht.TDocumentation;
import org.wso2.developerstudio.eclipse.humantask.model.ht.TDurationExpr;
import org.wso2.developerstudio.eclipse.humantask.model.ht.TEscalation;
import org.wso2.developerstudio.eclipse.humantask.model.ht.TExpression;
import org.wso2.developerstudio.eclipse.humantask.model.ht.TExtensibleElements;
import org.wso2.developerstudio.eclipse.humantask.model.ht.TExtensibleMixedContentElements;
import org.wso2.developerstudio.eclipse.humantask.model.ht.TExtension;
import org.wso2.developerstudio.eclipse.humantask.model.ht.TExtensions;
import org.wso2.developerstudio.eclipse.humantask.model.ht.TFrom;
import org.wso2.developerstudio.eclipse.humantask.model.ht.TGenericHumanRole;
import org.wso2.developerstudio.eclipse.humantask.model.ht.TGrouplist;
import org.wso2.developerstudio.eclipse.humantask.model.ht.THumanInteractions;
import org.wso2.developerstudio.eclipse.humantask.model.ht.TImport;
import org.wso2.developerstudio.eclipse.humantask.model.ht.TLiteral;
import org.wso2.developerstudio.eclipse.humantask.model.ht.TLocalNotification;
import org.wso2.developerstudio.eclipse.humantask.model.ht.TLogicalPeopleGroup;
import org.wso2.developerstudio.eclipse.humantask.model.ht.TLogicalPeopleGroups;
import org.wso2.developerstudio.eclipse.humantask.model.ht.TNotification;
import org.wso2.developerstudio.eclipse.humantask.model.ht.TNotificationInterface;
import org.wso2.developerstudio.eclipse.humantask.model.ht.TNotifications;
import org.wso2.developerstudio.eclipse.humantask.model.ht.TOrganizationalEntity;
import org.wso2.developerstudio.eclipse.humantask.model.ht.TParameter;
import org.wso2.developerstudio.eclipse.humantask.model.ht.TPeopleAssignments;
import org.wso2.developerstudio.eclipse.humantask.model.ht.TPotentialDelegatees;
import org.wso2.developerstudio.eclipse.humantask.model.ht.TPresentationElements;
import org.wso2.developerstudio.eclipse.humantask.model.ht.TPresentationParameter;
import org.wso2.developerstudio.eclipse.humantask.model.ht.TPresentationParameters;
import org.wso2.developerstudio.eclipse.humantask.model.ht.TPriority;
import org.wso2.developerstudio.eclipse.humantask.model.ht.TQuery;
import org.wso2.developerstudio.eclipse.humantask.model.ht.TReassignment;
import org.wso2.developerstudio.eclipse.humantask.model.ht.TRendering;
import org.wso2.developerstudio.eclipse.humantask.model.ht.TRenderings;
import org.wso2.developerstudio.eclipse.humantask.model.ht.TTask;
import org.wso2.developerstudio.eclipse.humantask.model.ht.TTaskInterface;
import org.wso2.developerstudio.eclipse.humantask.model.ht.TTasks;
import org.wso2.developerstudio.eclipse.humantask.model.ht.TText;
import org.wso2.developerstudio.eclipse.humantask.model.ht.TToPart;
import org.wso2.developerstudio.eclipse.humantask.model.ht.TToParts;
import org.wso2.developerstudio.eclipse.humantask.model.ht.TUserlist;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class HTPackageImpl extends EPackageImpl implements HTPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass documentRootEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tArgumentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tBooleanExprEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tDeadlineEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tDeadlineExprEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tDeadlinesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tDelegationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tDescriptionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tDocumentationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tDurationExprEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tEscalationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tExtensibleElementsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tExtensibleMixedContentElementsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tExtensionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tExtensionsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tFromEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tGenericHumanRoleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tGrouplistEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tHumanInteractionsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tImportEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tLocalNotificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tLogicalPeopleGroupEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tLogicalPeopleGroupsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tNotificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tNotificationInterfaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tNotificationsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tOrganizationalEntityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tPeopleAssignmentsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tPresentationElementsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tPresentationParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tPresentationParametersEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tPriorityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tQueryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tReassignmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tRenderingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tRenderingsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tTaskInterfaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tTasksEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tTextEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tToPartEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tToPartsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tUserlistEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum tBooleanEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum tPotentialDelegateesEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType tBooleanObjectEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType tGroupEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType tPotentialDelegateesObjectEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType tUserEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private HTPackageImpl() {
		super(eNS_URI, HTFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link HTPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static HTPackage init() {
		if (isInited) return (HTPackage)EPackage.Registry.INSTANCE.getEPackage(HTPackage.eNS_URI);

		// Obtain or create and register package
		HTPackageImpl theHTPackage = (HTPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof HTPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new HTPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		XMLNamespacePackage.eINSTANCE.eClass();
		XMLTypePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theHTPackage.createPackageContents();

		// Initialize created meta-data
		theHTPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theHTPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(HTPackage.eNS_URI, theHTPackage);
		return theHTPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDocumentRoot() {
		return documentRootEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentRoot_Mixed() {
		return (EAttribute)documentRootEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_XMLNSPrefixMap() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_XSISchemaLocation() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_BusinessAdministrators() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_ExcludedOwners() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentRoot_Group() {
		return (EAttribute)documentRootEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Groups() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_HumanInteractions() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Import() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_LogicalPeopleGroups() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Notification() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Notifications() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_OrganizationalEntity() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_PeopleAssignments() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_PotentialOwners() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Priority() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Recipients() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Task() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_TaskInitiator() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Tasks() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_TaskStakeholders() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentRoot_User() {
		return (EAttribute)documentRootEClass.getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Users() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTArgument() {
		return tArgumentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTArgument_ExpressionLanguage() {
		return (EAttribute)tArgumentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTArgument_Name() {
		return (EAttribute)tArgumentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTBooleanExpr() {
		return tBooleanExprEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTDeadline() {
		return tDeadlineEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTDeadline_For() {
		return (EReference)tDeadlineEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTDeadline_Until() {
		return (EReference)tDeadlineEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTDeadline_Escalation() {
		return (EReference)tDeadlineEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTDeadlineExpr() {
		return tDeadlineExprEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTDeadlines() {
		return tDeadlinesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTDeadlines_StartDeadline() {
		return (EReference)tDeadlinesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTDeadlines_CompletionDeadline() {
		return (EReference)tDeadlinesEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTDelegation() {
		return tDelegationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTDelegation_From() {
		return (EReference)tDelegationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTDelegation_PotentialDelegatees() {
		return (EAttribute)tDelegationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTDescription() {
		return tDescriptionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTDescription_ContentType() {
		return (EAttribute)tDescriptionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTDescription_Lang() {
		return (EAttribute)tDescriptionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTDocumentation() {
		return tDocumentationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTDocumentation_Mixed() {
		return (EAttribute)tDocumentationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTDocumentation_Any() {
		return (EAttribute)tDocumentationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTDocumentation_Lang() {
		return (EAttribute)tDocumentationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTDurationExpr() {
		return tDurationExprEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTEscalation() {
		return tEscalationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTEscalation_Condition() {
		return (EReference)tEscalationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTEscalation_ToParts() {
		return (EReference)tEscalationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTEscalation_Notification() {
		return (EReference)tEscalationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTEscalation_LocalNotification() {
		return (EReference)tEscalationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTEscalation_Reassignment() {
		return (EReference)tEscalationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTEscalation_Name() {
		return (EAttribute)tEscalationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTExpression() {
		return tExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTExpression_Mixed() {
		return (EAttribute)tExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTExpression_Any() {
		return (EAttribute)tExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTExpression_ExpressionLanguage() {
		return (EAttribute)tExpressionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTExpression_AnyAttribute() {
		return (EAttribute)tExpressionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTExtensibleElements() {
		return tExtensibleElementsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTExtensibleElements_Documentation() {
		return (EReference)tExtensibleElementsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTExtensibleElements_Any() {
		return (EAttribute)tExtensibleElementsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTExtensibleElements_AnyAttribute() {
		return (EAttribute)tExtensibleElementsEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTExtensibleMixedContentElements() {
		return tExtensibleMixedContentElementsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTExtensibleMixedContentElements_Mixed() {
		return (EAttribute)tExtensibleMixedContentElementsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTExtensibleMixedContentElements_Documentation() {
		return (EReference)tExtensibleMixedContentElementsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTExtensibleMixedContentElements_Any() {
		return (EAttribute)tExtensibleMixedContentElementsEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTExtensibleMixedContentElements_AnyAttribute() {
		return (EAttribute)tExtensibleMixedContentElementsEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTExtension() {
		return tExtensionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTExtension_MustUnderstand() {
		return (EAttribute)tExtensionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTExtension_Namespace() {
		return (EAttribute)tExtensionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTExtensions() {
		return tExtensionsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTExtensions_Extension() {
		return (EReference)tExtensionsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTFrom() {
		return tFromEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTFrom_Argument() {
		return (EReference)tFromEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTFrom_Literal() {
		return (EReference)tFromEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTFrom_ExpressionLanguage() {
		return (EAttribute)tFromEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTFrom_LogicalPeopleGroup() {
		return (EAttribute)tFromEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTGenericHumanRole() {
		return tGenericHumanRoleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTGenericHumanRole_From() {
		return (EReference)tGenericHumanRoleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTGrouplist() {
		return tGrouplistEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTGrouplist_Group() {
		return (EAttribute)tGrouplistEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTHumanInteractions() {
		return tHumanInteractionsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTHumanInteractions_Extensions() {
		return (EReference)tHumanInteractionsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTHumanInteractions_Import() {
		return (EReference)tHumanInteractionsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTHumanInteractions_LogicalPeopleGroups() {
		return (EReference)tHumanInteractionsEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTHumanInteractions_Tasks() {
		return (EReference)tHumanInteractionsEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTHumanInteractions_Notifications() {
		return (EReference)tHumanInteractionsEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTHumanInteractions_ExpressionLanguage() {
		return (EAttribute)tHumanInteractionsEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTHumanInteractions_QueryLanguage() {
		return (EAttribute)tHumanInteractionsEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTHumanInteractions_TargetNamespace() {
		return (EAttribute)tHumanInteractionsEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTImport() {
		return tImportEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTImport_ImportType() {
		return (EAttribute)tImportEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTImport_Location() {
		return (EAttribute)tImportEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTImport_Namespace() {
		return (EAttribute)tImportEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTLiteral() {
		return tLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTLiteral_Mixed() {
		return (EAttribute)tLiteralEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTLiteral_Any() {
		return (EAttribute)tLiteralEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTLiteral_AnyAttribute() {
		return (EAttribute)tLiteralEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTLocalNotification() {
		return tLocalNotificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTLocalNotification_Priority() {
		return (EReference)tLocalNotificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTLocalNotification_PeopleAssignments() {
		return (EReference)tLocalNotificationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTLocalNotification_Reference() {
		return (EAttribute)tLocalNotificationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTLogicalPeopleGroup() {
		return tLogicalPeopleGroupEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTLogicalPeopleGroup_Parameter() {
		return (EReference)tLogicalPeopleGroupEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTLogicalPeopleGroup_Name() {
		return (EAttribute)tLogicalPeopleGroupEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTLogicalPeopleGroup_Reference() {
		return (EAttribute)tLogicalPeopleGroupEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTLogicalPeopleGroups() {
		return tLogicalPeopleGroupsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTLogicalPeopleGroups_LogicalPeopleGroup() {
		return (EReference)tLogicalPeopleGroupsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTNotification() {
		return tNotificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTNotification_Interface() {
		return (EReference)tNotificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTNotification_Priority() {
		return (EReference)tNotificationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTNotification_PeopleAssignments() {
		return (EReference)tNotificationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTNotification_PresentationElements() {
		return (EReference)tNotificationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTNotification_Renderings() {
		return (EReference)tNotificationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTNotification_Name() {
		return (EAttribute)tNotificationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTNotificationInterface() {
		return tNotificationInterfaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTNotificationInterface_Operation() {
		return (EAttribute)tNotificationInterfaceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTNotificationInterface_PortType() {
		return (EAttribute)tNotificationInterfaceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTNotifications() {
		return tNotificationsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTNotifications_Notification() {
		return (EReference)tNotificationsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTOrganizationalEntity() {
		return tOrganizationalEntityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTOrganizationalEntity_Users() {
		return (EReference)tOrganizationalEntityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTOrganizationalEntity_Groups() {
		return (EReference)tOrganizationalEntityEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTParameter() {
		return tParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTParameter_Name() {
		return (EAttribute)tParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTParameter_Type() {
		return (EAttribute)tParameterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTPeopleAssignments() {
		return tPeopleAssignmentsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTPeopleAssignments_GenericHumanRole() {
		return (EAttribute)tPeopleAssignmentsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTPeopleAssignments_PotentialOwners() {
		return (EReference)tPeopleAssignmentsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTPeopleAssignments_ExcludedOwners() {
		return (EReference)tPeopleAssignmentsEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTPeopleAssignments_TaskInitiator() {
		return (EReference)tPeopleAssignmentsEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTPeopleAssignments_TaskStakeholders() {
		return (EReference)tPeopleAssignmentsEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTPeopleAssignments_BusinessAdministrators() {
		return (EReference)tPeopleAssignmentsEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTPeopleAssignments_Recipients() {
		return (EReference)tPeopleAssignmentsEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTPresentationElements() {
		return tPresentationElementsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTPresentationElements_Name() {
		return (EReference)tPresentationElementsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTPresentationElements_PresentationParameters() {
		return (EReference)tPresentationElementsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTPresentationElements_Subject() {
		return (EReference)tPresentationElementsEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTPresentationElements_Description() {
		return (EReference)tPresentationElementsEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTPresentationParameter() {
		return tPresentationParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTPresentationParameters() {
		return tPresentationParametersEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTPresentationParameters_PresentationParameter() {
		return (EReference)tPresentationParametersEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTPresentationParameters_ExpressionLanguage() {
		return (EAttribute)tPresentationParametersEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTPriority() {
		return tPriorityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTQuery() {
		return tQueryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTQuery_Mixed() {
		return (EAttribute)tQueryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTQuery_Any() {
		return (EAttribute)tQueryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTQuery_Part() {
		return (EAttribute)tQueryEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTQuery_QueryLanguage() {
		return (EAttribute)tQueryEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTQuery_AnyAttribute() {
		return (EAttribute)tQueryEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTReassignment() {
		return tReassignmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTReassignment_PotentialOwners() {
		return (EReference)tReassignmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTRendering() {
		return tRenderingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTRendering_Type() {
		return (EAttribute)tRenderingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTRenderings() {
		return tRenderingsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTRenderings_Rendering() {
		return (EReference)tRenderingsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTTask() {
		return tTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTTask_Interface() {
		return (EReference)tTaskEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTTask_Priority() {
		return (EReference)tTaskEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTTask_PeopleAssignments() {
		return (EReference)tTaskEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTTask_Delegation() {
		return (EReference)tTaskEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTTask_PresentationElements() {
		return (EReference)tTaskEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTTask_Outcome() {
		return (EReference)tTaskEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTTask_SearchBy() {
		return (EReference)tTaskEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTTask_Renderings() {
		return (EReference)tTaskEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTTask_Deadlines() {
		return (EReference)tTaskEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTTask_Name() {
		return (EAttribute)tTaskEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTTaskInterface() {
		return tTaskInterfaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTTaskInterface_Operation() {
		return (EAttribute)tTaskInterfaceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTTaskInterface_PortType() {
		return (EAttribute)tTaskInterfaceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTTaskInterface_ResponseOperation() {
		return (EAttribute)tTaskInterfaceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTTaskInterface_ResponsePortType() {
		return (EAttribute)tTaskInterfaceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTTasks() {
		return tTasksEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTTasks_Task() {
		return (EReference)tTasksEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTText() {
		return tTextEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTText_Lang() {
		return (EAttribute)tTextEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTToPart() {
		return tToPartEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTToPart_ExpressionLanguage() {
		return (EAttribute)tToPartEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTToPart_Name() {
		return (EAttribute)tToPartEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTToParts() {
		return tToPartsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTToParts_ToPart() {
		return (EReference)tToPartsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTUserlist() {
		return tUserlistEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTUserlist_User() {
		return (EAttribute)tUserlistEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getTBoolean() {
		return tBooleanEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getTPotentialDelegatees() {
		return tPotentialDelegateesEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getTBooleanObject() {
		return tBooleanObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getTGroup() {
		return tGroupEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getTPotentialDelegateesObject() {
		return tPotentialDelegateesObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getTUser() {
		return tUserEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HTFactory getHTFactory() {
		return (HTFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		documentRootEClass = createEClass(DOCUMENT_ROOT);
		createEAttribute(documentRootEClass, DOCUMENT_ROOT__MIXED);
		createEReference(documentRootEClass, DOCUMENT_ROOT__XMLNS_PREFIX_MAP);
		createEReference(documentRootEClass, DOCUMENT_ROOT__XSI_SCHEMA_LOCATION);
		createEReference(documentRootEClass, DOCUMENT_ROOT__BUSINESS_ADMINISTRATORS);
		createEReference(documentRootEClass, DOCUMENT_ROOT__EXCLUDED_OWNERS);
		createEAttribute(documentRootEClass, DOCUMENT_ROOT__GROUP);
		createEReference(documentRootEClass, DOCUMENT_ROOT__GROUPS);
		createEReference(documentRootEClass, DOCUMENT_ROOT__HUMAN_INTERACTIONS);
		createEReference(documentRootEClass, DOCUMENT_ROOT__IMPORT);
		createEReference(documentRootEClass, DOCUMENT_ROOT__LOGICAL_PEOPLE_GROUPS);
		createEReference(documentRootEClass, DOCUMENT_ROOT__NOTIFICATION);
		createEReference(documentRootEClass, DOCUMENT_ROOT__NOTIFICATIONS);
		createEReference(documentRootEClass, DOCUMENT_ROOT__ORGANIZATIONAL_ENTITY);
		createEReference(documentRootEClass, DOCUMENT_ROOT__PEOPLE_ASSIGNMENTS);
		createEReference(documentRootEClass, DOCUMENT_ROOT__POTENTIAL_OWNERS);
		createEReference(documentRootEClass, DOCUMENT_ROOT__PRIORITY);
		createEReference(documentRootEClass, DOCUMENT_ROOT__RECIPIENTS);
		createEReference(documentRootEClass, DOCUMENT_ROOT__TASK);
		createEReference(documentRootEClass, DOCUMENT_ROOT__TASK_INITIATOR);
		createEReference(documentRootEClass, DOCUMENT_ROOT__TASKS);
		createEReference(documentRootEClass, DOCUMENT_ROOT__TASK_STAKEHOLDERS);
		createEAttribute(documentRootEClass, DOCUMENT_ROOT__USER);
		createEReference(documentRootEClass, DOCUMENT_ROOT__USERS);

		tArgumentEClass = createEClass(TARGUMENT);
		createEAttribute(tArgumentEClass, TARGUMENT__EXPRESSION_LANGUAGE);
		createEAttribute(tArgumentEClass, TARGUMENT__NAME);

		tBooleanExprEClass = createEClass(TBOOLEAN_EXPR);

		tDeadlineEClass = createEClass(TDEADLINE);
		createEReference(tDeadlineEClass, TDEADLINE__FOR);
		createEReference(tDeadlineEClass, TDEADLINE__UNTIL);
		createEReference(tDeadlineEClass, TDEADLINE__ESCALATION);

		tDeadlineExprEClass = createEClass(TDEADLINE_EXPR);

		tDeadlinesEClass = createEClass(TDEADLINES);
		createEReference(tDeadlinesEClass, TDEADLINES__START_DEADLINE);
		createEReference(tDeadlinesEClass, TDEADLINES__COMPLETION_DEADLINE);

		tDelegationEClass = createEClass(TDELEGATION);
		createEReference(tDelegationEClass, TDELEGATION__FROM);
		createEAttribute(tDelegationEClass, TDELEGATION__POTENTIAL_DELEGATEES);

		tDescriptionEClass = createEClass(TDESCRIPTION);
		createEAttribute(tDescriptionEClass, TDESCRIPTION__CONTENT_TYPE);
		createEAttribute(tDescriptionEClass, TDESCRIPTION__LANG);

		tDocumentationEClass = createEClass(TDOCUMENTATION);
		createEAttribute(tDocumentationEClass, TDOCUMENTATION__MIXED);
		createEAttribute(tDocumentationEClass, TDOCUMENTATION__ANY);
		createEAttribute(tDocumentationEClass, TDOCUMENTATION__LANG);

		tDurationExprEClass = createEClass(TDURATION_EXPR);

		tEscalationEClass = createEClass(TESCALATION);
		createEReference(tEscalationEClass, TESCALATION__CONDITION);
		createEReference(tEscalationEClass, TESCALATION__TO_PARTS);
		createEReference(tEscalationEClass, TESCALATION__NOTIFICATION);
		createEReference(tEscalationEClass, TESCALATION__LOCAL_NOTIFICATION);
		createEReference(tEscalationEClass, TESCALATION__REASSIGNMENT);
		createEAttribute(tEscalationEClass, TESCALATION__NAME);

		tExpressionEClass = createEClass(TEXPRESSION);
		createEAttribute(tExpressionEClass, TEXPRESSION__MIXED);
		createEAttribute(tExpressionEClass, TEXPRESSION__ANY);
		createEAttribute(tExpressionEClass, TEXPRESSION__EXPRESSION_LANGUAGE);
		createEAttribute(tExpressionEClass, TEXPRESSION__ANY_ATTRIBUTE);

		tExtensibleElementsEClass = createEClass(TEXTENSIBLE_ELEMENTS);
		createEReference(tExtensibleElementsEClass, TEXTENSIBLE_ELEMENTS__DOCUMENTATION);
		createEAttribute(tExtensibleElementsEClass, TEXTENSIBLE_ELEMENTS__ANY);
		createEAttribute(tExtensibleElementsEClass, TEXTENSIBLE_ELEMENTS__ANY_ATTRIBUTE);

		tExtensibleMixedContentElementsEClass = createEClass(TEXTENSIBLE_MIXED_CONTENT_ELEMENTS);
		createEAttribute(tExtensibleMixedContentElementsEClass, TEXTENSIBLE_MIXED_CONTENT_ELEMENTS__MIXED);
		createEReference(tExtensibleMixedContentElementsEClass, TEXTENSIBLE_MIXED_CONTENT_ELEMENTS__DOCUMENTATION);
		createEAttribute(tExtensibleMixedContentElementsEClass, TEXTENSIBLE_MIXED_CONTENT_ELEMENTS__ANY);
		createEAttribute(tExtensibleMixedContentElementsEClass, TEXTENSIBLE_MIXED_CONTENT_ELEMENTS__ANY_ATTRIBUTE);

		tExtensionEClass = createEClass(TEXTENSION);
		createEAttribute(tExtensionEClass, TEXTENSION__MUST_UNDERSTAND);
		createEAttribute(tExtensionEClass, TEXTENSION__NAMESPACE);

		tExtensionsEClass = createEClass(TEXTENSIONS);
		createEReference(tExtensionsEClass, TEXTENSIONS__EXTENSION);

		tFromEClass = createEClass(TFROM);
		createEReference(tFromEClass, TFROM__ARGUMENT);
		createEReference(tFromEClass, TFROM__LITERAL);
		createEAttribute(tFromEClass, TFROM__EXPRESSION_LANGUAGE);
		createEAttribute(tFromEClass, TFROM__LOGICAL_PEOPLE_GROUP);

		tGenericHumanRoleEClass = createEClass(TGENERIC_HUMAN_ROLE);
		createEReference(tGenericHumanRoleEClass, TGENERIC_HUMAN_ROLE__FROM);

		tGrouplistEClass = createEClass(TGROUPLIST);
		createEAttribute(tGrouplistEClass, TGROUPLIST__GROUP);

		tHumanInteractionsEClass = createEClass(THUMAN_INTERACTIONS);
		createEReference(tHumanInteractionsEClass, THUMAN_INTERACTIONS__EXTENSIONS);
		createEReference(tHumanInteractionsEClass, THUMAN_INTERACTIONS__IMPORT);
		createEReference(tHumanInteractionsEClass, THUMAN_INTERACTIONS__LOGICAL_PEOPLE_GROUPS);
		createEReference(tHumanInteractionsEClass, THUMAN_INTERACTIONS__TASKS);
		createEReference(tHumanInteractionsEClass, THUMAN_INTERACTIONS__NOTIFICATIONS);
		createEAttribute(tHumanInteractionsEClass, THUMAN_INTERACTIONS__EXPRESSION_LANGUAGE);
		createEAttribute(tHumanInteractionsEClass, THUMAN_INTERACTIONS__QUERY_LANGUAGE);
		createEAttribute(tHumanInteractionsEClass, THUMAN_INTERACTIONS__TARGET_NAMESPACE);

		tImportEClass = createEClass(TIMPORT);
		createEAttribute(tImportEClass, TIMPORT__IMPORT_TYPE);
		createEAttribute(tImportEClass, TIMPORT__LOCATION);
		createEAttribute(tImportEClass, TIMPORT__NAMESPACE);

		tLiteralEClass = createEClass(TLITERAL);
		createEAttribute(tLiteralEClass, TLITERAL__MIXED);
		createEAttribute(tLiteralEClass, TLITERAL__ANY);
		createEAttribute(tLiteralEClass, TLITERAL__ANY_ATTRIBUTE);

		tLocalNotificationEClass = createEClass(TLOCAL_NOTIFICATION);
		createEReference(tLocalNotificationEClass, TLOCAL_NOTIFICATION__PRIORITY);
		createEReference(tLocalNotificationEClass, TLOCAL_NOTIFICATION__PEOPLE_ASSIGNMENTS);
		createEAttribute(tLocalNotificationEClass, TLOCAL_NOTIFICATION__REFERENCE);

		tLogicalPeopleGroupEClass = createEClass(TLOGICAL_PEOPLE_GROUP);
		createEReference(tLogicalPeopleGroupEClass, TLOGICAL_PEOPLE_GROUP__PARAMETER);
		createEAttribute(tLogicalPeopleGroupEClass, TLOGICAL_PEOPLE_GROUP__NAME);
		createEAttribute(tLogicalPeopleGroupEClass, TLOGICAL_PEOPLE_GROUP__REFERENCE);

		tLogicalPeopleGroupsEClass = createEClass(TLOGICAL_PEOPLE_GROUPS);
		createEReference(tLogicalPeopleGroupsEClass, TLOGICAL_PEOPLE_GROUPS__LOGICAL_PEOPLE_GROUP);

		tNotificationEClass = createEClass(TNOTIFICATION);
		createEReference(tNotificationEClass, TNOTIFICATION__INTERFACE);
		createEReference(tNotificationEClass, TNOTIFICATION__PRIORITY);
		createEReference(tNotificationEClass, TNOTIFICATION__PEOPLE_ASSIGNMENTS);
		createEReference(tNotificationEClass, TNOTIFICATION__PRESENTATION_ELEMENTS);
		createEReference(tNotificationEClass, TNOTIFICATION__RENDERINGS);
		createEAttribute(tNotificationEClass, TNOTIFICATION__NAME);

		tNotificationInterfaceEClass = createEClass(TNOTIFICATION_INTERFACE);
		createEAttribute(tNotificationInterfaceEClass, TNOTIFICATION_INTERFACE__OPERATION);
		createEAttribute(tNotificationInterfaceEClass, TNOTIFICATION_INTERFACE__PORT_TYPE);

		tNotificationsEClass = createEClass(TNOTIFICATIONS);
		createEReference(tNotificationsEClass, TNOTIFICATIONS__NOTIFICATION);

		tOrganizationalEntityEClass = createEClass(TORGANIZATIONAL_ENTITY);
		createEReference(tOrganizationalEntityEClass, TORGANIZATIONAL_ENTITY__USERS);
		createEReference(tOrganizationalEntityEClass, TORGANIZATIONAL_ENTITY__GROUPS);

		tParameterEClass = createEClass(TPARAMETER);
		createEAttribute(tParameterEClass, TPARAMETER__NAME);
		createEAttribute(tParameterEClass, TPARAMETER__TYPE);

		tPeopleAssignmentsEClass = createEClass(TPEOPLE_ASSIGNMENTS);
		createEAttribute(tPeopleAssignmentsEClass, TPEOPLE_ASSIGNMENTS__GENERIC_HUMAN_ROLE);
		createEReference(tPeopleAssignmentsEClass, TPEOPLE_ASSIGNMENTS__POTENTIAL_OWNERS);
		createEReference(tPeopleAssignmentsEClass, TPEOPLE_ASSIGNMENTS__EXCLUDED_OWNERS);
		createEReference(tPeopleAssignmentsEClass, TPEOPLE_ASSIGNMENTS__TASK_INITIATOR);
		createEReference(tPeopleAssignmentsEClass, TPEOPLE_ASSIGNMENTS__TASK_STAKEHOLDERS);
		createEReference(tPeopleAssignmentsEClass, TPEOPLE_ASSIGNMENTS__BUSINESS_ADMINISTRATORS);
		createEReference(tPeopleAssignmentsEClass, TPEOPLE_ASSIGNMENTS__RECIPIENTS);

		tPresentationElementsEClass = createEClass(TPRESENTATION_ELEMENTS);
		createEReference(tPresentationElementsEClass, TPRESENTATION_ELEMENTS__NAME);
		createEReference(tPresentationElementsEClass, TPRESENTATION_ELEMENTS__PRESENTATION_PARAMETERS);
		createEReference(tPresentationElementsEClass, TPRESENTATION_ELEMENTS__SUBJECT);
		createEReference(tPresentationElementsEClass, TPRESENTATION_ELEMENTS__DESCRIPTION);

		tPresentationParameterEClass = createEClass(TPRESENTATION_PARAMETER);

		tPresentationParametersEClass = createEClass(TPRESENTATION_PARAMETERS);
		createEReference(tPresentationParametersEClass, TPRESENTATION_PARAMETERS__PRESENTATION_PARAMETER);
		createEAttribute(tPresentationParametersEClass, TPRESENTATION_PARAMETERS__EXPRESSION_LANGUAGE);

		tPriorityEClass = createEClass(TPRIORITY);

		tQueryEClass = createEClass(TQUERY);
		createEAttribute(tQueryEClass, TQUERY__MIXED);
		createEAttribute(tQueryEClass, TQUERY__ANY);
		createEAttribute(tQueryEClass, TQUERY__PART);
		createEAttribute(tQueryEClass, TQUERY__QUERY_LANGUAGE);
		createEAttribute(tQueryEClass, TQUERY__ANY_ATTRIBUTE);

		tReassignmentEClass = createEClass(TREASSIGNMENT);
		createEReference(tReassignmentEClass, TREASSIGNMENT__POTENTIAL_OWNERS);

		tRenderingEClass = createEClass(TRENDERING);
		createEAttribute(tRenderingEClass, TRENDERING__TYPE);

		tRenderingsEClass = createEClass(TRENDERINGS);
		createEReference(tRenderingsEClass, TRENDERINGS__RENDERING);

		tTaskEClass = createEClass(TTASK);
		createEReference(tTaskEClass, TTASK__INTERFACE);
		createEReference(tTaskEClass, TTASK__PRIORITY);
		createEReference(tTaskEClass, TTASK__PEOPLE_ASSIGNMENTS);
		createEReference(tTaskEClass, TTASK__DELEGATION);
		createEReference(tTaskEClass, TTASK__PRESENTATION_ELEMENTS);
		createEReference(tTaskEClass, TTASK__OUTCOME);
		createEReference(tTaskEClass, TTASK__SEARCH_BY);
		createEReference(tTaskEClass, TTASK__RENDERINGS);
		createEReference(tTaskEClass, TTASK__DEADLINES);
		createEAttribute(tTaskEClass, TTASK__NAME);

		tTaskInterfaceEClass = createEClass(TTASK_INTERFACE);
		createEAttribute(tTaskInterfaceEClass, TTASK_INTERFACE__OPERATION);
		createEAttribute(tTaskInterfaceEClass, TTASK_INTERFACE__PORT_TYPE);
		createEAttribute(tTaskInterfaceEClass, TTASK_INTERFACE__RESPONSE_OPERATION);
		createEAttribute(tTaskInterfaceEClass, TTASK_INTERFACE__RESPONSE_PORT_TYPE);

		tTasksEClass = createEClass(TTASKS);
		createEReference(tTasksEClass, TTASKS__TASK);

		tTextEClass = createEClass(TTEXT);
		createEAttribute(tTextEClass, TTEXT__LANG);

		tToPartEClass = createEClass(TTO_PART);
		createEAttribute(tToPartEClass, TTO_PART__EXPRESSION_LANGUAGE);
		createEAttribute(tToPartEClass, TTO_PART__NAME);

		tToPartsEClass = createEClass(TTO_PARTS);
		createEReference(tToPartsEClass, TTO_PARTS__TO_PART);

		tUserlistEClass = createEClass(TUSERLIST);
		createEAttribute(tUserlistEClass, TUSERLIST__USER);

		// Create enums
		tBooleanEEnum = createEEnum(TBOOLEAN);
		tPotentialDelegateesEEnum = createEEnum(TPOTENTIAL_DELEGATEES);

		// Create data types
		tBooleanObjectEDataType = createEDataType(TBOOLEAN_OBJECT);
		tGroupEDataType = createEDataType(TGROUP);
		tPotentialDelegateesObjectEDataType = createEDataType(TPOTENTIAL_DELEGATEES_OBJECT);
		tUserEDataType = createEDataType(TUSER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);
		XMLNamespacePackage theXMLNamespacePackage = (XMLNamespacePackage)EPackage.Registry.INSTANCE.getEPackage(XMLNamespacePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		tArgumentEClass.getESuperTypes().add(this.getTExtensibleMixedContentElements());
		tBooleanExprEClass.getESuperTypes().add(this.getTExpression());
		tDeadlineEClass.getESuperTypes().add(this.getTExtensibleElements());
		tDeadlineExprEClass.getESuperTypes().add(this.getTExpression());
		tDeadlinesEClass.getESuperTypes().add(this.getTExtensibleElements());
		tDelegationEClass.getESuperTypes().add(this.getTExtensibleElements());
		tDescriptionEClass.getESuperTypes().add(this.getTExtensibleMixedContentElements());
		tDurationExprEClass.getESuperTypes().add(this.getTExpression());
		tEscalationEClass.getESuperTypes().add(this.getTExtensibleElements());
		tExtensionEClass.getESuperTypes().add(this.getTExtensibleElements());
		tExtensionsEClass.getESuperTypes().add(this.getTExtensibleElements());
		tFromEClass.getESuperTypes().add(this.getTExtensibleMixedContentElements());
		tGenericHumanRoleEClass.getESuperTypes().add(this.getTExtensibleElements());
		tHumanInteractionsEClass.getESuperTypes().add(this.getTExtensibleElements());
		tImportEClass.getESuperTypes().add(this.getTExtensibleElements());
		tLocalNotificationEClass.getESuperTypes().add(this.getTExtensibleElements());
		tLogicalPeopleGroupEClass.getESuperTypes().add(this.getTExtensibleElements());
		tLogicalPeopleGroupsEClass.getESuperTypes().add(this.getTExtensibleElements());
		tNotificationEClass.getESuperTypes().add(this.getTExtensibleElements());
		tNotificationInterfaceEClass.getESuperTypes().add(this.getTExtensibleElements());
		tNotificationsEClass.getESuperTypes().add(this.getTExtensibleElements());
		tParameterEClass.getESuperTypes().add(this.getTExtensibleMixedContentElements());
		tPeopleAssignmentsEClass.getESuperTypes().add(this.getTExtensibleElements());
		tPresentationElementsEClass.getESuperTypes().add(this.getTExtensibleElements());
		tPresentationParameterEClass.getESuperTypes().add(this.getTParameter());
		tPresentationParametersEClass.getESuperTypes().add(this.getTExtensibleElements());
		tPriorityEClass.getESuperTypes().add(this.getTExpression());
		tReassignmentEClass.getESuperTypes().add(this.getTExtensibleElements());
		tRenderingEClass.getESuperTypes().add(this.getTExtensibleElements());
		tRenderingsEClass.getESuperTypes().add(this.getTExtensibleElements());
		tTaskEClass.getESuperTypes().add(this.getTExtensibleElements());
		tTaskInterfaceEClass.getESuperTypes().add(this.getTExtensibleElements());
		tTasksEClass.getESuperTypes().add(this.getTExtensibleElements());
		tTextEClass.getESuperTypes().add(this.getTExtensibleMixedContentElements());
		tToPartEClass.getESuperTypes().add(this.getTExtensibleMixedContentElements());
		tToPartsEClass.getESuperTypes().add(this.getTExtensibleElements());

		// Initialize classes and features; add operations and parameters
		initEClass(documentRootEClass, DocumentRoot.class, "DocumentRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDocumentRoot_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_XMLNSPrefixMap(), ecorePackage.getEStringToStringMapEntry(), null, "xMLNSPrefixMap", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_XSISchemaLocation(), ecorePackage.getEStringToStringMapEntry(), null, "xSISchemaLocation", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_BusinessAdministrators(), this.getTGenericHumanRole(), null, "businessAdministrators", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_ExcludedOwners(), this.getTGenericHumanRole(), null, "excludedOwners", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getDocumentRoot_Group(), this.getTGroup(), "group", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Groups(), this.getTGrouplist(), null, "groups", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_HumanInteractions(), this.getTHumanInteractions(), null, "humanInteractions", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Import(), this.getTImport(), null, "import", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_LogicalPeopleGroups(), this.getTLogicalPeopleGroups(), null, "logicalPeopleGroups", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Notification(), this.getTNotification(), null, "notification", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Notifications(), this.getTNotifications(), null, "notifications", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_OrganizationalEntity(), this.getTOrganizationalEntity(), null, "organizationalEntity", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_PeopleAssignments(), this.getTPeopleAssignments(), null, "peopleAssignments", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_PotentialOwners(), this.getTGenericHumanRole(), null, "potentialOwners", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Priority(), this.getTPriority(), null, "priority", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Recipients(), this.getTGenericHumanRole(), null, "recipients", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Task(), this.getTTask(), null, "task", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_TaskInitiator(), this.getTGenericHumanRole(), null, "taskInitiator", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Tasks(), this.getTTasks(), null, "tasks", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_TaskStakeholders(), this.getTGenericHumanRole(), null, "taskStakeholders", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getDocumentRoot_User(), this.getTUser(), "user", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Users(), this.getTUserlist(), null, "users", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(tArgumentEClass, TArgument.class, "TArgument", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTArgument_ExpressionLanguage(), theXMLTypePackage.getAnyURI(), "expressionLanguage", null, 0, 1, TArgument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTArgument_Name(), theXMLTypePackage.getNCName(), "name", null, 0, 1, TArgument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tBooleanExprEClass, TBooleanExpr.class, "TBooleanExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(tDeadlineEClass, TDeadline.class, "TDeadline", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTDeadline_For(), this.getTDurationExpr(), null, "for", null, 0, 1, TDeadline.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTDeadline_Until(), this.getTDeadlineExpr(), null, "until", null, 0, 1, TDeadline.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTDeadline_Escalation(), this.getTEscalation(), null, "escalation", null, 0, -1, TDeadline.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tDeadlineExprEClass, TDeadlineExpr.class, "TDeadlineExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(tDeadlinesEClass, TDeadlines.class, "TDeadlines", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTDeadlines_StartDeadline(), this.getTDeadline(), null, "startDeadline", null, 0, -1, TDeadlines.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTDeadlines_CompletionDeadline(), this.getTDeadline(), null, "completionDeadline", null, 0, -1, TDeadlines.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tDelegationEClass, TDelegation.class, "TDelegation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTDelegation_From(), this.getTFrom(), null, "from", null, 0, 1, TDelegation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTDelegation_PotentialDelegatees(), this.getTPotentialDelegatees(), "potentialDelegatees", null, 1, 1, TDelegation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tDescriptionEClass, TDescription.class, "TDescription", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTDescription_ContentType(), theXMLTypePackage.getString(), "contentType", null, 0, 1, TDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTDescription_Lang(), theXMLNamespacePackage.getLangType(), "lang", null, 0, 1, TDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tDocumentationEClass, TDocumentation.class, "TDocumentation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTDocumentation_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, TDocumentation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTDocumentation_Any(), ecorePackage.getEFeatureMapEntry(), "any", null, 0, -1, TDocumentation.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getTDocumentation_Lang(), theXMLNamespacePackage.getLangType(), "lang", null, 0, 1, TDocumentation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tDurationExprEClass, TDurationExpr.class, "TDurationExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(tEscalationEClass, TEscalation.class, "TEscalation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTEscalation_Condition(), this.getTBooleanExpr(), null, "condition", null, 0, 1, TEscalation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTEscalation_ToParts(), this.getTToParts(), null, "toParts", null, 0, -1, TEscalation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTEscalation_Notification(), this.getTNotification(), null, "notification", null, 0, 1, TEscalation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTEscalation_LocalNotification(), this.getTLocalNotification(), null, "localNotification", null, 0, 1, TEscalation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTEscalation_Reassignment(), this.getTReassignment(), null, "reassignment", null, 0, 1, TEscalation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTEscalation_Name(), theXMLTypePackage.getNCName(), "name", null, 1, 1, TEscalation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tExpressionEClass, TExpression.class, "TExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTExpression_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, TExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTExpression_Any(), ecorePackage.getEFeatureMapEntry(), "any", null, 0, -1, TExpression.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getTExpression_ExpressionLanguage(), theXMLTypePackage.getAnyURI(), "expressionLanguage", null, 0, 1, TExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTExpression_AnyAttribute(), ecorePackage.getEFeatureMapEntry(), "anyAttribute", null, 0, -1, TExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tExtensibleElementsEClass, TExtensibleElements.class, "TExtensibleElements", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTExtensibleElements_Documentation(), this.getTDocumentation(), null, "documentation", null, 0, -1, TExtensibleElements.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTExtensibleElements_Any(), ecorePackage.getEFeatureMapEntry(), "any", null, 0, -1, TExtensibleElements.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTExtensibleElements_AnyAttribute(), ecorePackage.getEFeatureMapEntry(), "anyAttribute", null, 0, -1, TExtensibleElements.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tExtensibleMixedContentElementsEClass, TExtensibleMixedContentElements.class, "TExtensibleMixedContentElements", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTExtensibleMixedContentElements_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, TExtensibleMixedContentElements.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTExtensibleMixedContentElements_Documentation(), this.getTDocumentation(), null, "documentation", null, 0, -1, TExtensibleMixedContentElements.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getTExtensibleMixedContentElements_Any(), ecorePackage.getEFeatureMapEntry(), "any", null, 0, -1, TExtensibleMixedContentElements.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getTExtensibleMixedContentElements_AnyAttribute(), ecorePackage.getEFeatureMapEntry(), "anyAttribute", null, 0, -1, TExtensibleMixedContentElements.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tExtensionEClass, TExtension.class, "TExtension", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTExtension_MustUnderstand(), this.getTBoolean(), "mustUnderstand", null, 1, 1, TExtension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTExtension_Namespace(), theXMLTypePackage.getAnyURI(), "namespace", null, 1, 1, TExtension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tExtensionsEClass, TExtensions.class, "TExtensions", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTExtensions_Extension(), this.getTExtension(), null, "extension", null, 1, -1, TExtensions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tFromEClass, TFrom.class, "TFrom", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTFrom_Argument(), this.getTArgument(), null, "argument", null, 0, -1, TFrom.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getTFrom_Literal(), this.getTLiteral(), null, "literal", null, 0, 1, TFrom.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getTFrom_ExpressionLanguage(), theXMLTypePackage.getAnyURI(), "expressionLanguage", null, 0, 1, TFrom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTFrom_LogicalPeopleGroup(), theXMLTypePackage.getQName(), "logicalPeopleGroup", null, 0, 1, TFrom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tGenericHumanRoleEClass, TGenericHumanRole.class, "TGenericHumanRole", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTGenericHumanRole_From(), this.getTFrom(), null, "from", null, 1, 1, TGenericHumanRole.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tGrouplistEClass, TGrouplist.class, "TGrouplist", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTGrouplist_Group(), this.getTGroup(), "group", null, 0, -1, TGrouplist.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tHumanInteractionsEClass, THumanInteractions.class, "THumanInteractions", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTHumanInteractions_Extensions(), this.getTExtensions(), null, "extensions", null, 0, 1, THumanInteractions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTHumanInteractions_Import(), this.getTImport(), null, "import", null, 0, -1, THumanInteractions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTHumanInteractions_LogicalPeopleGroups(), this.getTLogicalPeopleGroups(), null, "logicalPeopleGroups", null, 0, 1, THumanInteractions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTHumanInteractions_Tasks(), this.getTTasks(), null, "tasks", null, 0, 1, THumanInteractions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTHumanInteractions_Notifications(), this.getTNotifications(), null, "notifications", null, 0, 1, THumanInteractions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTHumanInteractions_ExpressionLanguage(), theXMLTypePackage.getAnyURI(), "expressionLanguage", null, 0, 1, THumanInteractions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTHumanInteractions_QueryLanguage(), theXMLTypePackage.getAnyURI(), "queryLanguage", null, 0, 1, THumanInteractions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTHumanInteractions_TargetNamespace(), theXMLTypePackage.getAnyURI(), "targetNamespace", null, 1, 1, THumanInteractions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tImportEClass, TImport.class, "TImport", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTImport_ImportType(), theXMLTypePackage.getAnyURI(), "importType", null, 1, 1, TImport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTImport_Location(), theXMLTypePackage.getAnyURI(), "location", null, 0, 1, TImport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTImport_Namespace(), theXMLTypePackage.getAnyURI(), "namespace", null, 0, 1, TImport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tLiteralEClass, TLiteral.class, "TLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTLiteral_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, TLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTLiteral_Any(), ecorePackage.getEFeatureMapEntry(), "any", null, 0, -1, TLiteral.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getTLiteral_AnyAttribute(), ecorePackage.getEFeatureMapEntry(), "anyAttribute", null, 0, -1, TLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tLocalNotificationEClass, TLocalNotification.class, "TLocalNotification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTLocalNotification_Priority(), this.getTPriority(), null, "priority", null, 0, 1, TLocalNotification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTLocalNotification_PeopleAssignments(), this.getTPeopleAssignments(), null, "peopleAssignments", null, 0, 1, TLocalNotification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTLocalNotification_Reference(), theXMLTypePackage.getQName(), "reference", null, 1, 1, TLocalNotification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tLogicalPeopleGroupEClass, TLogicalPeopleGroup.class, "TLogicalPeopleGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTLogicalPeopleGroup_Parameter(), this.getTParameter(), null, "parameter", null, 0, -1, TLogicalPeopleGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTLogicalPeopleGroup_Name(), theXMLTypePackage.getNCName(), "name", null, 1, 1, TLogicalPeopleGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTLogicalPeopleGroup_Reference(), theXMLTypePackage.getNCName(), "reference", null, 0, 1, TLogicalPeopleGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tLogicalPeopleGroupsEClass, TLogicalPeopleGroups.class, "TLogicalPeopleGroups", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTLogicalPeopleGroups_LogicalPeopleGroup(), this.getTLogicalPeopleGroup(), null, "logicalPeopleGroup", null, 1, -1, TLogicalPeopleGroups.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tNotificationEClass, TNotification.class, "TNotification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTNotification_Interface(), this.getTNotificationInterface(), null, "interface", null, 1, 1, TNotification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTNotification_Priority(), this.getTPriority(), null, "priority", null, 0, 1, TNotification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTNotification_PeopleAssignments(), this.getTPeopleAssignments(), null, "peopleAssignments", null, 1, 1, TNotification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTNotification_PresentationElements(), this.getTPresentationElements(), null, "presentationElements", null, 1, 1, TNotification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTNotification_Renderings(), this.getTRenderings(), null, "renderings", null, 0, 1, TNotification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTNotification_Name(), theXMLTypePackage.getNCName(), "name", null, 1, 1, TNotification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tNotificationInterfaceEClass, TNotificationInterface.class, "TNotificationInterface", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTNotificationInterface_Operation(), theXMLTypePackage.getNCName(), "operation", null, 1, 1, TNotificationInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTNotificationInterface_PortType(), theXMLTypePackage.getQName(), "portType", null, 1, 1, TNotificationInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tNotificationsEClass, TNotifications.class, "TNotifications", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTNotifications_Notification(), this.getTNotification(), null, "notification", null, 1, -1, TNotifications.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tOrganizationalEntityEClass, TOrganizationalEntity.class, "TOrganizationalEntity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTOrganizationalEntity_Users(), this.getTUserlist(), null, "users", null, 0, 1, TOrganizationalEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTOrganizationalEntity_Groups(), this.getTGrouplist(), null, "groups", null, 0, 1, TOrganizationalEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tParameterEClass, TParameter.class, "TParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTParameter_Name(), theXMLTypePackage.getNCName(), "name", null, 1, 1, TParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTParameter_Type(), theXMLTypePackage.getQName(), "type", null, 1, 1, TParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tPeopleAssignmentsEClass, TPeopleAssignments.class, "TPeopleAssignments", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTPeopleAssignments_GenericHumanRole(), ecorePackage.getEFeatureMapEntry(), "genericHumanRole", null, 0, -1, TPeopleAssignments.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTPeopleAssignments_PotentialOwners(), this.getTGenericHumanRole(), null, "potentialOwners", null, 0, -1, TPeopleAssignments.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getTPeopleAssignments_ExcludedOwners(), this.getTGenericHumanRole(), null, "excludedOwners", null, 0, -1, TPeopleAssignments.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getTPeopleAssignments_TaskInitiator(), this.getTGenericHumanRole(), null, "taskInitiator", null, 0, -1, TPeopleAssignments.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getTPeopleAssignments_TaskStakeholders(), this.getTGenericHumanRole(), null, "taskStakeholders", null, 0, -1, TPeopleAssignments.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getTPeopleAssignments_BusinessAdministrators(), this.getTGenericHumanRole(), null, "businessAdministrators", null, 0, -1, TPeopleAssignments.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getTPeopleAssignments_Recipients(), this.getTGenericHumanRole(), null, "recipients", null, 0, -1, TPeopleAssignments.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(tPresentationElementsEClass, TPresentationElements.class, "TPresentationElements", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTPresentationElements_Name(), this.getTText(), null, "name", null, 0, -1, TPresentationElements.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTPresentationElements_PresentationParameters(), this.getTPresentationParameters(), null, "presentationParameters", null, 0, 1, TPresentationElements.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTPresentationElements_Subject(), this.getTText(), null, "subject", null, 0, -1, TPresentationElements.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTPresentationElements_Description(), this.getTDescription(), null, "description", null, 0, -1, TPresentationElements.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tPresentationParameterEClass, TPresentationParameter.class, "TPresentationParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(tPresentationParametersEClass, TPresentationParameters.class, "TPresentationParameters", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTPresentationParameters_PresentationParameter(), this.getTPresentationParameter(), null, "presentationParameter", null, 1, -1, TPresentationParameters.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTPresentationParameters_ExpressionLanguage(), theXMLTypePackage.getAnyURI(), "expressionLanguage", null, 0, 1, TPresentationParameters.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tPriorityEClass, TPriority.class, "TPriority", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(tQueryEClass, TQuery.class, "TQuery", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTQuery_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, TQuery.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTQuery_Any(), ecorePackage.getEFeatureMapEntry(), "any", null, 0, -1, TQuery.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getTQuery_Part(), theXMLTypePackage.getAnySimpleType(), "part", null, 0, 1, TQuery.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTQuery_QueryLanguage(), theXMLTypePackage.getAnyURI(), "queryLanguage", null, 0, 1, TQuery.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTQuery_AnyAttribute(), ecorePackage.getEFeatureMapEntry(), "anyAttribute", null, 0, -1, TQuery.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tReassignmentEClass, TReassignment.class, "TReassignment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTReassignment_PotentialOwners(), this.getTGenericHumanRole(), null, "potentialOwners", null, 1, 1, TReassignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tRenderingEClass, TRendering.class, "TRendering", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTRendering_Type(), theXMLTypePackage.getQName(), "type", null, 1, 1, TRendering.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tRenderingsEClass, TRenderings.class, "TRenderings", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTRenderings_Rendering(), this.getTRendering(), null, "rendering", null, 1, -1, TRenderings.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tTaskEClass, TTask.class, "TTask", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTTask_Interface(), this.getTTaskInterface(), null, "interface", null, 1, 1, TTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTTask_Priority(), this.getTPriority(), null, "priority", null, 0, 1, TTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTTask_PeopleAssignments(), this.getTPeopleAssignments(), null, "peopleAssignments", null, 1, 1, TTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTTask_Delegation(), this.getTDelegation(), null, "delegation", null, 0, 1, TTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTTask_PresentationElements(), this.getTPresentationElements(), null, "presentationElements", null, 1, 1, TTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTTask_Outcome(), this.getTQuery(), null, "outcome", null, 0, 1, TTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTTask_SearchBy(), this.getTExpression(), null, "searchBy", null, 0, 1, TTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTTask_Renderings(), this.getTRenderings(), null, "renderings", null, 0, 1, TTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTTask_Deadlines(), this.getTDeadlines(), null, "deadlines", null, 0, 1, TTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTTask_Name(), theXMLTypePackage.getNCName(), "name", null, 1, 1, TTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tTaskInterfaceEClass, TTaskInterface.class, "TTaskInterface", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTTaskInterface_Operation(), theXMLTypePackage.getNCName(), "operation", null, 1, 1, TTaskInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTTaskInterface_PortType(), theXMLTypePackage.getQName(), "portType", null, 1, 1, TTaskInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTTaskInterface_ResponseOperation(), theXMLTypePackage.getNCName(), "responseOperation", null, 0, 1, TTaskInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTTaskInterface_ResponsePortType(), theXMLTypePackage.getQName(), "responsePortType", null, 0, 1, TTaskInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tTasksEClass, TTasks.class, "TTasks", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTTasks_Task(), this.getTTask(), null, "task", null, 1, -1, TTasks.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tTextEClass, TText.class, "TText", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTText_Lang(), theXMLNamespacePackage.getLangType(), "lang", null, 0, 1, TText.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tToPartEClass, TToPart.class, "TToPart", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTToPart_ExpressionLanguage(), theXMLTypePackage.getAnyURI(), "expressionLanguage", null, 0, 1, TToPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTToPart_Name(), theXMLTypePackage.getNCName(), "name", null, 1, 1, TToPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tToPartsEClass, TToParts.class, "TToParts", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTToParts_ToPart(), this.getTToPart(), null, "toPart", null, 1, -1, TToParts.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tUserlistEClass, TUserlist.class, "TUserlist", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTUserlist_User(), this.getTUser(), "user", null, 0, -1, TUserlist.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(tBooleanEEnum, TBoolean.class, "TBoolean");
		addEEnumLiteral(tBooleanEEnum, TBoolean.YES);
		addEEnumLiteral(tBooleanEEnum, TBoolean.NO);

		initEEnum(tPotentialDelegateesEEnum, TPotentialDelegatees.class, "TPotentialDelegatees");
		addEEnumLiteral(tPotentialDelegateesEEnum, TPotentialDelegatees.ANYBODY);
		addEEnumLiteral(tPotentialDelegateesEEnum, TPotentialDelegatees.NOBODY);
		addEEnumLiteral(tPotentialDelegateesEEnum, TPotentialDelegatees.POTENTIAL_OWNERS);
		addEEnumLiteral(tPotentialDelegateesEEnum, TPotentialDelegatees.OTHER);

		// Initialize data types
		initEDataType(tBooleanObjectEDataType, TBoolean.class, "TBooleanObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);
		initEDataType(tGroupEDataType, String.class, "TGroup", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(tPotentialDelegateesObjectEDataType, TPotentialDelegatees.class, "TPotentialDelegateesObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);
		initEDataType(tUserEDataType, String.class, "TUser", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createExtendedMetaDataAnnotations() {
		String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";			
		addAnnotation
		  (documentRootEClass, 
		   source, 
		   new String[] {
			 "name", "",
			 "kind", "mixed"
		   });		
		addAnnotation
		  (getDocumentRoot_Mixed(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "name", ":mixed"
		   });		
		addAnnotation
		  (getDocumentRoot_XMLNSPrefixMap(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "xmlns:prefix"
		   });		
		addAnnotation
		  (getDocumentRoot_XSISchemaLocation(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "xsi:schemaLocation"
		   });		
		addAnnotation
		  (getDocumentRoot_BusinessAdministrators(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "businessAdministrators",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDocumentRoot_ExcludedOwners(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "excludedOwners",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDocumentRoot_Group(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "group",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDocumentRoot_Groups(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "groups",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDocumentRoot_HumanInteractions(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "humanInteractions",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDocumentRoot_Import(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "import",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDocumentRoot_LogicalPeopleGroups(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "logicalPeopleGroups",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDocumentRoot_Notification(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "notification",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDocumentRoot_Notifications(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "notifications",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDocumentRoot_OrganizationalEntity(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "organizationalEntity",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDocumentRoot_PeopleAssignments(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "peopleAssignments",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDocumentRoot_PotentialOwners(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "potentialOwners",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDocumentRoot_Priority(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "priority",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDocumentRoot_Recipients(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "recipients",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDocumentRoot_Task(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "task",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDocumentRoot_TaskInitiator(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "taskInitiator",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDocumentRoot_Tasks(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "tasks",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDocumentRoot_TaskStakeholders(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "taskStakeholders",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDocumentRoot_User(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "user",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDocumentRoot_Users(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "users",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (tArgumentEClass, 
		   source, 
		   new String[] {
			 "name", "tArgument",
			 "kind", "mixed"
		   });		
		addAnnotation
		  (getTArgument_ExpressionLanguage(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "expressionLanguage"
		   });		
		addAnnotation
		  (getTArgument_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });		
		addAnnotation
		  (tBooleanEEnum, 
		   source, 
		   new String[] {
			 "name", "tBoolean"
		   });		
		addAnnotation
		  (tBooleanExprEClass, 
		   source, 
		   new String[] {
			 "name", "tBoolean-expr",
			 "kind", "mixed"
		   });		
		addAnnotation
		  (tBooleanObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "tBoolean:Object",
			 "baseType", "tBoolean"
		   });		
		addAnnotation
		  (tDeadlineEClass, 
		   source, 
		   new String[] {
			 "name", "tDeadline",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTDeadline_For(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "for",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTDeadline_Until(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "until",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTDeadline_Escalation(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "escalation",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (tDeadlineExprEClass, 
		   source, 
		   new String[] {
			 "name", "tDeadline-expr",
			 "kind", "mixed"
		   });		
		addAnnotation
		  (tDeadlinesEClass, 
		   source, 
		   new String[] {
			 "name", "tDeadlines",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTDeadlines_StartDeadline(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "startDeadline",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTDeadlines_CompletionDeadline(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "completionDeadline",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (tDelegationEClass, 
		   source, 
		   new String[] {
			 "name", "tDelegation",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTDelegation_From(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "from",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTDelegation_PotentialDelegatees(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "potentialDelegatees"
		   });		
		addAnnotation
		  (tDescriptionEClass, 
		   source, 
		   new String[] {
			 "name", "tDescription",
			 "kind", "mixed"
		   });		
		addAnnotation
		  (getTDescription_ContentType(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "contentType"
		   });			
		addAnnotation
		  (getTDescription_Lang(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "lang",
			 "namespace", "http://www.w3.org/XML/1998/namespace"
		   });		
		addAnnotation
		  (tDocumentationEClass, 
		   source, 
		   new String[] {
			 "name", "tDocumentation",
			 "kind", "mixed"
		   });		
		addAnnotation
		  (getTDocumentation_Mixed(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "name", ":mixed"
		   });		
		addAnnotation
		  (getTDocumentation_Any(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "wildcards", "##other",
			 "name", ":1",
			 "processing", "lax"
		   });			
		addAnnotation
		  (getTDocumentation_Lang(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "lang",
			 "namespace", "http://www.w3.org/XML/1998/namespace"
		   });		
		addAnnotation
		  (tDurationExprEClass, 
		   source, 
		   new String[] {
			 "name", "tDuration-expr",
			 "kind", "mixed"
		   });		
		addAnnotation
		  (tEscalationEClass, 
		   source, 
		   new String[] {
			 "name", "tEscalation",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTEscalation_Condition(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "condition",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTEscalation_ToParts(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "toParts",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTEscalation_Notification(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "notification",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTEscalation_LocalNotification(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "localNotification",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTEscalation_Reassignment(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "reassignment",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTEscalation_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });		
		addAnnotation
		  (tExpressionEClass, 
		   source, 
		   new String[] {
			 "name", "tExpression",
			 "kind", "mixed"
		   });		
		addAnnotation
		  (getTExpression_Mixed(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "name", ":mixed"
		   });		
		addAnnotation
		  (getTExpression_Any(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "wildcards", "##other",
			 "name", ":1",
			 "processing", "lax"
		   });		
		addAnnotation
		  (getTExpression_ExpressionLanguage(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "expressionLanguage"
		   });		
		addAnnotation
		  (getTExpression_AnyAttribute(), 
		   source, 
		   new String[] {
			 "kind", "attributeWildcard",
			 "wildcards", "##other",
			 "name", ":3",
			 "processing", "lax"
		   });		
		addAnnotation
		  (tExtensibleElementsEClass, 
		   source, 
		   new String[] {
			 "name", "tExtensibleElements",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTExtensibleElements_Documentation(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "documentation",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTExtensibleElements_Any(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "wildcards", "##other",
			 "name", ":1",
			 "processing", "lax"
		   });		
		addAnnotation
		  (getTExtensibleElements_AnyAttribute(), 
		   source, 
		   new String[] {
			 "kind", "attributeWildcard",
			 "wildcards", "##other",
			 "name", ":2",
			 "processing", "lax"
		   });		
		addAnnotation
		  (tExtensibleMixedContentElementsEClass, 
		   source, 
		   new String[] {
			 "name", "tExtensibleMixedContentElements",
			 "kind", "mixed"
		   });		
		addAnnotation
		  (getTExtensibleMixedContentElements_Mixed(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "name", ":mixed"
		   });		
		addAnnotation
		  (getTExtensibleMixedContentElements_Documentation(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "documentation",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTExtensibleMixedContentElements_Any(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "wildcards", "##other",
			 "name", ":2",
			 "processing", "skip"
		   });		
		addAnnotation
		  (getTExtensibleMixedContentElements_AnyAttribute(), 
		   source, 
		   new String[] {
			 "kind", "attributeWildcard",
			 "wildcards", "##other",
			 "name", ":3",
			 "processing", "lax"
		   });		
		addAnnotation
		  (tExtensionEClass, 
		   source, 
		   new String[] {
			 "name", "tExtension",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTExtension_MustUnderstand(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "mustUnderstand"
		   });		
		addAnnotation
		  (getTExtension_Namespace(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "namespace"
		   });		
		addAnnotation
		  (tExtensionsEClass, 
		   source, 
		   new String[] {
			 "name", "tExtensions",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTExtensions_Extension(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "extension",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (tFromEClass, 
		   source, 
		   new String[] {
			 "name", "tFrom",
			 "kind", "mixed"
		   });		
		addAnnotation
		  (getTFrom_Argument(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "argument",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTFrom_Literal(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "literal",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTFrom_ExpressionLanguage(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "expressionLanguage"
		   });		
		addAnnotation
		  (getTFrom_LogicalPeopleGroup(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "logicalPeopleGroup"
		   });		
		addAnnotation
		  (tGenericHumanRoleEClass, 
		   source, 
		   new String[] {
			 "name", "tGenericHumanRole",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTGenericHumanRole_From(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "from",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (tGroupEDataType, 
		   source, 
		   new String[] {
			 "name", "tGroup",
			 "baseType", "http://www.eclipse.org/emf/2003/XMLType#string"
		   });		
		addAnnotation
		  (tGrouplistEClass, 
		   source, 
		   new String[] {
			 "name", "tGrouplist",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTGrouplist_Group(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "group",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (tHumanInteractionsEClass, 
		   source, 
		   new String[] {
			 "name", "tHumanInteractions",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTHumanInteractions_Extensions(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "extensions",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTHumanInteractions_Import(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "import",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTHumanInteractions_LogicalPeopleGroups(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "logicalPeopleGroups",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTHumanInteractions_Tasks(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "tasks",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTHumanInteractions_Notifications(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "notifications",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTHumanInteractions_ExpressionLanguage(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "expressionLanguage"
		   });		
		addAnnotation
		  (getTHumanInteractions_QueryLanguage(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "queryLanguage"
		   });		
		addAnnotation
		  (getTHumanInteractions_TargetNamespace(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "targetNamespace"
		   });		
		addAnnotation
		  (tImportEClass, 
		   source, 
		   new String[] {
			 "name", "tImport",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTImport_ImportType(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "importType"
		   });		
		addAnnotation
		  (getTImport_Location(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "location"
		   });		
		addAnnotation
		  (getTImport_Namespace(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "namespace"
		   });		
		addAnnotation
		  (tLiteralEClass, 
		   source, 
		   new String[] {
			 "name", "tLiteral",
			 "kind", "mixed"
		   });		
		addAnnotation
		  (getTLiteral_Mixed(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "name", ":mixed"
		   });		
		addAnnotation
		  (getTLiteral_Any(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "wildcards", "##any",
			 "name", ":1",
			 "processing", "lax"
		   });		
		addAnnotation
		  (getTLiteral_AnyAttribute(), 
		   source, 
		   new String[] {
			 "kind", "attributeWildcard",
			 "wildcards", "##other",
			 "name", ":2",
			 "processing", "lax"
		   });		
		addAnnotation
		  (tLocalNotificationEClass, 
		   source, 
		   new String[] {
			 "name", "tLocalNotification",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTLocalNotification_Priority(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "priority",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTLocalNotification_PeopleAssignments(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "peopleAssignments",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTLocalNotification_Reference(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "reference"
		   });		
		addAnnotation
		  (tLogicalPeopleGroupEClass, 
		   source, 
		   new String[] {
			 "name", "tLogicalPeopleGroup",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTLogicalPeopleGroup_Parameter(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "parameter",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTLogicalPeopleGroup_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });		
		addAnnotation
		  (getTLogicalPeopleGroup_Reference(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "reference"
		   });		
		addAnnotation
		  (tLogicalPeopleGroupsEClass, 
		   source, 
		   new String[] {
			 "name", "tLogicalPeopleGroups",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTLogicalPeopleGroups_LogicalPeopleGroup(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "logicalPeopleGroup",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (tNotificationEClass, 
		   source, 
		   new String[] {
			 "name", "tNotification",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTNotification_Interface(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "interface",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTNotification_Priority(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "priority",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTNotification_PeopleAssignments(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "peopleAssignments",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTNotification_PresentationElements(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "presentationElements",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTNotification_Renderings(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "renderings",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTNotification_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });		
		addAnnotation
		  (tNotificationInterfaceEClass, 
		   source, 
		   new String[] {
			 "name", "tNotificationInterface",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTNotificationInterface_Operation(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "operation"
		   });		
		addAnnotation
		  (getTNotificationInterface_PortType(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "portType"
		   });		
		addAnnotation
		  (tNotificationsEClass, 
		   source, 
		   new String[] {
			 "name", "tNotifications",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTNotifications_Notification(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "notification",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (tOrganizationalEntityEClass, 
		   source, 
		   new String[] {
			 "name", "tOrganizationalEntity",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTOrganizationalEntity_Users(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "users",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTOrganizationalEntity_Groups(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "groups",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (tParameterEClass, 
		   source, 
		   new String[] {
			 "name", "tParameter",
			 "kind", "mixed"
		   });		
		addAnnotation
		  (getTParameter_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });		
		addAnnotation
		  (getTParameter_Type(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "type"
		   });		
		addAnnotation
		  (tPeopleAssignmentsEClass, 
		   source, 
		   new String[] {
			 "name", "tPeopleAssignments",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTPeopleAssignments_GenericHumanRole(), 
		   source, 
		   new String[] {
			 "kind", "group",
			 "name", "GenericHumanRole:3"
		   });		
		addAnnotation
		  (getTPeopleAssignments_PotentialOwners(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "potentialOwners",
			 "namespace", "##targetNamespace",
			 "group", "#GenericHumanRole:3"
		   });		
		addAnnotation
		  (getTPeopleAssignments_ExcludedOwners(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "excludedOwners",
			 "namespace", "##targetNamespace",
			 "group", "#GenericHumanRole:3"
		   });		
		addAnnotation
		  (getTPeopleAssignments_TaskInitiator(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "taskInitiator",
			 "namespace", "##targetNamespace",
			 "group", "#GenericHumanRole:3"
		   });		
		addAnnotation
		  (getTPeopleAssignments_TaskStakeholders(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "taskStakeholders",
			 "namespace", "##targetNamespace",
			 "group", "#GenericHumanRole:3"
		   });		
		addAnnotation
		  (getTPeopleAssignments_BusinessAdministrators(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "businessAdministrators",
			 "namespace", "##targetNamespace",
			 "group", "#GenericHumanRole:3"
		   });		
		addAnnotation
		  (getTPeopleAssignments_Recipients(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "recipients",
			 "namespace", "##targetNamespace",
			 "group", "#GenericHumanRole:3"
		   });		
		addAnnotation
		  (tPotentialDelegateesEEnum, 
		   source, 
		   new String[] {
			 "name", "tPotentialDelegatees"
		   });		
		addAnnotation
		  (tPotentialDelegateesObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "tPotentialDelegatees:Object",
			 "baseType", "tPotentialDelegatees"
		   });		
		addAnnotation
		  (tPresentationElementsEClass, 
		   source, 
		   new String[] {
			 "name", "tPresentationElements",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTPresentationElements_Name(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "name",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTPresentationElements_PresentationParameters(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "presentationParameters",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTPresentationElements_Subject(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "subject",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTPresentationElements_Description(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "description",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (tPresentationParameterEClass, 
		   source, 
		   new String[] {
			 "name", "tPresentationParameter",
			 "kind", "mixed"
		   });		
		addAnnotation
		  (tPresentationParametersEClass, 
		   source, 
		   new String[] {
			 "name", "tPresentationParameters",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTPresentationParameters_PresentationParameter(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "presentationParameter",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTPresentationParameters_ExpressionLanguage(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "expressionLanguage"
		   });		
		addAnnotation
		  (tPriorityEClass, 
		   source, 
		   new String[] {
			 "name", "tPriority",
			 "kind", "mixed"
		   });		
		addAnnotation
		  (tQueryEClass, 
		   source, 
		   new String[] {
			 "name", "tQuery",
			 "kind", "mixed"
		   });		
		addAnnotation
		  (getTQuery_Mixed(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "name", ":mixed"
		   });		
		addAnnotation
		  (getTQuery_Any(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "wildcards", "##other",
			 "name", ":1",
			 "processing", "lax"
		   });		
		addAnnotation
		  (getTQuery_Part(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "part"
		   });		
		addAnnotation
		  (getTQuery_QueryLanguage(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "queryLanguage"
		   });		
		addAnnotation
		  (getTQuery_AnyAttribute(), 
		   source, 
		   new String[] {
			 "kind", "attributeWildcard",
			 "wildcards", "##other",
			 "name", ":4",
			 "processing", "lax"
		   });		
		addAnnotation
		  (tReassignmentEClass, 
		   source, 
		   new String[] {
			 "name", "tReassignment",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTReassignment_PotentialOwners(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "potentialOwners",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (tRenderingEClass, 
		   source, 
		   new String[] {
			 "name", "tRendering",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTRendering_Type(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "type"
		   });		
		addAnnotation
		  (tRenderingsEClass, 
		   source, 
		   new String[] {
			 "name", "tRenderings",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTRenderings_Rendering(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "rendering",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (tTaskEClass, 
		   source, 
		   new String[] {
			 "name", "tTask",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTTask_Interface(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "interface",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTTask_Priority(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "priority",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTTask_PeopleAssignments(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "peopleAssignments",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTTask_Delegation(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "delegation",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTTask_PresentationElements(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "presentationElements",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTTask_Outcome(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "outcome",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTTask_SearchBy(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "searchBy",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTTask_Renderings(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "renderings",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTTask_Deadlines(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "deadlines",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTTask_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });		
		addAnnotation
		  (tTaskInterfaceEClass, 
		   source, 
		   new String[] {
			 "name", "tTaskInterface",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTTaskInterface_Operation(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "operation"
		   });		
		addAnnotation
		  (getTTaskInterface_PortType(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "portType"
		   });		
		addAnnotation
		  (getTTaskInterface_ResponseOperation(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "responseOperation"
		   });		
		addAnnotation
		  (getTTaskInterface_ResponsePortType(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "responsePortType"
		   });		
		addAnnotation
		  (tTasksEClass, 
		   source, 
		   new String[] {
			 "name", "tTasks",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTTasks_Task(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "task",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (tTextEClass, 
		   source, 
		   new String[] {
			 "name", "tText",
			 "kind", "mixed"
		   });			
		addAnnotation
		  (getTText_Lang(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "lang",
			 "namespace", "http://www.w3.org/XML/1998/namespace"
		   });		
		addAnnotation
		  (tToPartEClass, 
		   source, 
		   new String[] {
			 "name", "tToPart",
			 "kind", "mixed"
		   });		
		addAnnotation
		  (getTToPart_ExpressionLanguage(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "expressionLanguage"
		   });		
		addAnnotation
		  (getTToPart_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });		
		addAnnotation
		  (tToPartsEClass, 
		   source, 
		   new String[] {
			 "name", "tToParts",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTToParts_ToPart(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "toPart",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (tUserEDataType, 
		   source, 
		   new String[] {
			 "name", "tUser",
			 "baseType", "http://www.eclipse.org/emf/2003/XMLType#string"
		   });		
		addAnnotation
		  (tUserlistEClass, 
		   source, 
		   new String[] {
			 "name", "tUserlist",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTUserlist_User(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "user",
			 "namespace", "##targetNamespace"
		   });
	}

} //HTPackageImpl
