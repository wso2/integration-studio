/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.humantask.model.ht.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.wso2.developerstudio.eclipse.humantask.model.ht.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage
 * @generated
 */
public class HTAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static HTPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HTAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = HTPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HTSwitch<Adapter> modelSwitch =
		new HTSwitch<Adapter>() {
			@Override
			public Adapter caseDocumentRoot(DocumentRoot object) {
				return createDocumentRootAdapter();
			}
			@Override
			public Adapter caseTArgument(TArgument object) {
				return createTArgumentAdapter();
			}
			@Override
			public Adapter caseTBooleanExpr(TBooleanExpr object) {
				return createTBooleanExprAdapter();
			}
			@Override
			public Adapter caseTDeadline(TDeadline object) {
				return createTDeadlineAdapter();
			}
			@Override
			public Adapter caseTDeadlineExpr(TDeadlineExpr object) {
				return createTDeadlineExprAdapter();
			}
			@Override
			public Adapter caseTDeadlines(TDeadlines object) {
				return createTDeadlinesAdapter();
			}
			@Override
			public Adapter caseTDelegation(TDelegation object) {
				return createTDelegationAdapter();
			}
			@Override
			public Adapter caseTDescription(TDescription object) {
				return createTDescriptionAdapter();
			}
			@Override
			public Adapter caseTDocumentation(TDocumentation object) {
				return createTDocumentationAdapter();
			}
			@Override
			public Adapter caseTDurationExpr(TDurationExpr object) {
				return createTDurationExprAdapter();
			}
			@Override
			public Adapter caseTEscalation(TEscalation object) {
				return createTEscalationAdapter();
			}
			@Override
			public Adapter caseTExpression(TExpression object) {
				return createTExpressionAdapter();
			}
			@Override
			public Adapter caseTExtensibleElements(TExtensibleElements object) {
				return createTExtensibleElementsAdapter();
			}
			@Override
			public Adapter caseTExtensibleMixedContentElements(TExtensibleMixedContentElements object) {
				return createTExtensibleMixedContentElementsAdapter();
			}
			@Override
			public Adapter caseTExtension(TExtension object) {
				return createTExtensionAdapter();
			}
			@Override
			public Adapter caseTExtensions(TExtensions object) {
				return createTExtensionsAdapter();
			}
			@Override
			public Adapter caseTFrom(TFrom object) {
				return createTFromAdapter();
			}
			@Override
			public Adapter caseTGenericHumanRole(TGenericHumanRole object) {
				return createTGenericHumanRoleAdapter();
			}
			@Override
			public Adapter caseTGrouplist(TGrouplist object) {
				return createTGrouplistAdapter();
			}
			@Override
			public Adapter caseTHumanInteractions(THumanInteractions object) {
				return createTHumanInteractionsAdapter();
			}
			@Override
			public Adapter caseTImport(TImport object) {
				return createTImportAdapter();
			}
			@Override
			public Adapter caseTLiteral(TLiteral object) {
				return createTLiteralAdapter();
			}
			@Override
			public Adapter caseTLocalNotification(TLocalNotification object) {
				return createTLocalNotificationAdapter();
			}
			@Override
			public Adapter caseTLogicalPeopleGroup(TLogicalPeopleGroup object) {
				return createTLogicalPeopleGroupAdapter();
			}
			@Override
			public Adapter caseTLogicalPeopleGroups(TLogicalPeopleGroups object) {
				return createTLogicalPeopleGroupsAdapter();
			}
			@Override
			public Adapter caseTNotification(TNotification object) {
				return createTNotificationAdapter();
			}
			@Override
			public Adapter caseTNotificationInterface(TNotificationInterface object) {
				return createTNotificationInterfaceAdapter();
			}
			@Override
			public Adapter caseTNotifications(TNotifications object) {
				return createTNotificationsAdapter();
			}
			@Override
			public Adapter caseTOrganizationalEntity(TOrganizationalEntity object) {
				return createTOrganizationalEntityAdapter();
			}
			@Override
			public Adapter caseTParameter(TParameter object) {
				return createTParameterAdapter();
			}
			@Override
			public Adapter caseTPeopleAssignments(TPeopleAssignments object) {
				return createTPeopleAssignmentsAdapter();
			}
			@Override
			public Adapter caseTPresentationElements(TPresentationElements object) {
				return createTPresentationElementsAdapter();
			}
			@Override
			public Adapter caseTPresentationParameter(TPresentationParameter object) {
				return createTPresentationParameterAdapter();
			}
			@Override
			public Adapter caseTPresentationParameters(TPresentationParameters object) {
				return createTPresentationParametersAdapter();
			}
			@Override
			public Adapter caseTPriority(TPriority object) {
				return createTPriorityAdapter();
			}
			@Override
			public Adapter caseTQuery(TQuery object) {
				return createTQueryAdapter();
			}
			@Override
			public Adapter caseTReassignment(TReassignment object) {
				return createTReassignmentAdapter();
			}
			@Override
			public Adapter caseTRendering(TRendering object) {
				return createTRenderingAdapter();
			}
			@Override
			public Adapter caseTRenderings(TRenderings object) {
				return createTRenderingsAdapter();
			}
			@Override
			public Adapter caseTTask(TTask object) {
				return createTTaskAdapter();
			}
			@Override
			public Adapter caseTTaskInterface(TTaskInterface object) {
				return createTTaskInterfaceAdapter();
			}
			@Override
			public Adapter caseTTasks(TTasks object) {
				return createTTasksAdapter();
			}
			@Override
			public Adapter caseTText(TText object) {
				return createTTextAdapter();
			}
			@Override
			public Adapter caseTToPart(TToPart object) {
				return createTToPartAdapter();
			}
			@Override
			public Adapter caseTToParts(TToParts object) {
				return createTToPartsAdapter();
			}
			@Override
			public Adapter caseTUserlist(TUserlist object) {
				return createTUserlistAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.DocumentRoot <em>Document Root</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.DocumentRoot
	 * @generated
	 */
	public Adapter createDocumentRootAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TArgument <em>TArgument</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TArgument
	 * @generated
	 */
	public Adapter createTArgumentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TBooleanExpr <em>TBoolean Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TBooleanExpr
	 * @generated
	 */
	public Adapter createTBooleanExprAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TDeadline <em>TDeadline</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TDeadline
	 * @generated
	 */
	public Adapter createTDeadlineAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TDeadlineExpr <em>TDeadline Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TDeadlineExpr
	 * @generated
	 */
	public Adapter createTDeadlineExprAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TDeadlines <em>TDeadlines</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TDeadlines
	 * @generated
	 */
	public Adapter createTDeadlinesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TDelegation <em>TDelegation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TDelegation
	 * @generated
	 */
	public Adapter createTDelegationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TDescription <em>TDescription</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TDescription
	 * @generated
	 */
	public Adapter createTDescriptionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TDocumentation <em>TDocumentation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TDocumentation
	 * @generated
	 */
	public Adapter createTDocumentationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TDurationExpr <em>TDuration Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TDurationExpr
	 * @generated
	 */
	public Adapter createTDurationExprAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TEscalation <em>TEscalation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TEscalation
	 * @generated
	 */
	public Adapter createTEscalationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TExpression <em>TExpression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TExpression
	 * @generated
	 */
	public Adapter createTExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TExtensibleElements <em>TExtensible Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TExtensibleElements
	 * @generated
	 */
	public Adapter createTExtensibleElementsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TExtensibleMixedContentElements <em>TExtensible Mixed Content Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TExtensibleMixedContentElements
	 * @generated
	 */
	public Adapter createTExtensibleMixedContentElementsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TExtension <em>TExtension</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TExtension
	 * @generated
	 */
	public Adapter createTExtensionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TExtensions <em>TExtensions</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TExtensions
	 * @generated
	 */
	public Adapter createTExtensionsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TFrom <em>TFrom</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TFrom
	 * @generated
	 */
	public Adapter createTFromAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TGenericHumanRole <em>TGeneric Human Role</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TGenericHumanRole
	 * @generated
	 */
	public Adapter createTGenericHumanRoleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TGrouplist <em>TGrouplist</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TGrouplist
	 * @generated
	 */
	public Adapter createTGrouplistAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.THumanInteractions <em>THuman Interactions</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.THumanInteractions
	 * @generated
	 */
	public Adapter createTHumanInteractionsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TImport <em>TImport</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TImport
	 * @generated
	 */
	public Adapter createTImportAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TLiteral <em>TLiteral</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TLiteral
	 * @generated
	 */
	public Adapter createTLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TLocalNotification <em>TLocal Notification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TLocalNotification
	 * @generated
	 */
	public Adapter createTLocalNotificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TLogicalPeopleGroup <em>TLogical People Group</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TLogicalPeopleGroup
	 * @generated
	 */
	public Adapter createTLogicalPeopleGroupAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TLogicalPeopleGroups <em>TLogical People Groups</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TLogicalPeopleGroups
	 * @generated
	 */
	public Adapter createTLogicalPeopleGroupsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TNotification <em>TNotification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TNotification
	 * @generated
	 */
	public Adapter createTNotificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TNotificationInterface <em>TNotification Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TNotificationInterface
	 * @generated
	 */
	public Adapter createTNotificationInterfaceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TNotifications <em>TNotifications</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TNotifications
	 * @generated
	 */
	public Adapter createTNotificationsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TOrganizationalEntity <em>TOrganizational Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TOrganizationalEntity
	 * @generated
	 */
	public Adapter createTOrganizationalEntityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TParameter <em>TParameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TParameter
	 * @generated
	 */
	public Adapter createTParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TPeopleAssignments <em>TPeople Assignments</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TPeopleAssignments
	 * @generated
	 */
	public Adapter createTPeopleAssignmentsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TPresentationElements <em>TPresentation Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TPresentationElements
	 * @generated
	 */
	public Adapter createTPresentationElementsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TPresentationParameter <em>TPresentation Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TPresentationParameter
	 * @generated
	 */
	public Adapter createTPresentationParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TPresentationParameters <em>TPresentation Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TPresentationParameters
	 * @generated
	 */
	public Adapter createTPresentationParametersAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TPriority <em>TPriority</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TPriority
	 * @generated
	 */
	public Adapter createTPriorityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TQuery <em>TQuery</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TQuery
	 * @generated
	 */
	public Adapter createTQueryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TReassignment <em>TReassignment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TReassignment
	 * @generated
	 */
	public Adapter createTReassignmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TRendering <em>TRendering</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TRendering
	 * @generated
	 */
	public Adapter createTRenderingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TRenderings <em>TRenderings</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TRenderings
	 * @generated
	 */
	public Adapter createTRenderingsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TTask <em>TTask</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TTask
	 * @generated
	 */
	public Adapter createTTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TTaskInterface <em>TTask Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TTaskInterface
	 * @generated
	 */
	public Adapter createTTaskInterfaceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TTasks <em>TTasks</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TTasks
	 * @generated
	 */
	public Adapter createTTasksAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TText <em>TText</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TText
	 * @generated
	 */
	public Adapter createTTextAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TToPart <em>TTo Part</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TToPart
	 * @generated
	 */
	public Adapter createTToPartAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TToParts <em>TTo Parts</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TToParts
	 * @generated
	 */
	public Adapter createTToPartsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.wso2.developerstudio.eclipse.humantask.model.ht.TUserlist <em>TUserlist</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.TUserlist
	 * @generated
	 */
	public Adapter createTUserlistAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //HTAdapterFactory
