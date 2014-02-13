/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.humantask.model.ht.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.wso2.developerstudio.eclipse.humantask.model.ht.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage
 * @generated
 */
public class HTSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static HTPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HTSwitch() {
		if (modelPackage == null) {
			modelPackage = HTPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case HTPackage.DOCUMENT_ROOT: {
				DocumentRoot documentRoot = (DocumentRoot)theEObject;
				T result = caseDocumentRoot(documentRoot);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HTPackage.TARGUMENT: {
				TArgument tArgument = (TArgument)theEObject;
				T result = caseTArgument(tArgument);
				if (result == null) result = caseTExtensibleMixedContentElements(tArgument);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HTPackage.TBOOLEAN_EXPR: {
				TBooleanExpr tBooleanExpr = (TBooleanExpr)theEObject;
				T result = caseTBooleanExpr(tBooleanExpr);
				if (result == null) result = caseTExpression(tBooleanExpr);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HTPackage.TDEADLINE: {
				TDeadline tDeadline = (TDeadline)theEObject;
				T result = caseTDeadline(tDeadline);
				if (result == null) result = caseTExtensibleElements(tDeadline);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HTPackage.TDEADLINE_EXPR: {
				TDeadlineExpr tDeadlineExpr = (TDeadlineExpr)theEObject;
				T result = caseTDeadlineExpr(tDeadlineExpr);
				if (result == null) result = caseTExpression(tDeadlineExpr);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HTPackage.TDEADLINES: {
				TDeadlines tDeadlines = (TDeadlines)theEObject;
				T result = caseTDeadlines(tDeadlines);
				if (result == null) result = caseTExtensibleElements(tDeadlines);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HTPackage.TDELEGATION: {
				TDelegation tDelegation = (TDelegation)theEObject;
				T result = caseTDelegation(tDelegation);
				if (result == null) result = caseTExtensibleElements(tDelegation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HTPackage.TDESCRIPTION: {
				TDescription tDescription = (TDescription)theEObject;
				T result = caseTDescription(tDescription);
				if (result == null) result = caseTExtensibleMixedContentElements(tDescription);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HTPackage.TDOCUMENTATION: {
				TDocumentation tDocumentation = (TDocumentation)theEObject;
				T result = caseTDocumentation(tDocumentation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HTPackage.TDURATION_EXPR: {
				TDurationExpr tDurationExpr = (TDurationExpr)theEObject;
				T result = caseTDurationExpr(tDurationExpr);
				if (result == null) result = caseTExpression(tDurationExpr);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HTPackage.TESCALATION: {
				TEscalation tEscalation = (TEscalation)theEObject;
				T result = caseTEscalation(tEscalation);
				if (result == null) result = caseTExtensibleElements(tEscalation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HTPackage.TEXPRESSION: {
				TExpression tExpression = (TExpression)theEObject;
				T result = caseTExpression(tExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HTPackage.TEXTENSIBLE_ELEMENTS: {
				TExtensibleElements tExtensibleElements = (TExtensibleElements)theEObject;
				T result = caseTExtensibleElements(tExtensibleElements);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HTPackage.TEXTENSIBLE_MIXED_CONTENT_ELEMENTS: {
				TExtensibleMixedContentElements tExtensibleMixedContentElements = (TExtensibleMixedContentElements)theEObject;
				T result = caseTExtensibleMixedContentElements(tExtensibleMixedContentElements);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HTPackage.TEXTENSION: {
				TExtension tExtension = (TExtension)theEObject;
				T result = caseTExtension(tExtension);
				if (result == null) result = caseTExtensibleElements(tExtension);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HTPackage.TEXTENSIONS: {
				TExtensions tExtensions = (TExtensions)theEObject;
				T result = caseTExtensions(tExtensions);
				if (result == null) result = caseTExtensibleElements(tExtensions);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HTPackage.TFROM: {
				TFrom tFrom = (TFrom)theEObject;
				T result = caseTFrom(tFrom);
				if (result == null) result = caseTExtensibleMixedContentElements(tFrom);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HTPackage.TGENERIC_HUMAN_ROLE: {
				TGenericHumanRole tGenericHumanRole = (TGenericHumanRole)theEObject;
				T result = caseTGenericHumanRole(tGenericHumanRole);
				if (result == null) result = caseTExtensibleElements(tGenericHumanRole);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HTPackage.TGROUPLIST: {
				TGrouplist tGrouplist = (TGrouplist)theEObject;
				T result = caseTGrouplist(tGrouplist);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HTPackage.THUMAN_INTERACTIONS: {
				THumanInteractions tHumanInteractions = (THumanInteractions)theEObject;
				T result = caseTHumanInteractions(tHumanInteractions);
				if (result == null) result = caseTExtensibleElements(tHumanInteractions);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HTPackage.TIMPORT: {
				TImport tImport = (TImport)theEObject;
				T result = caseTImport(tImport);
				if (result == null) result = caseTExtensibleElements(tImport);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HTPackage.TLITERAL: {
				TLiteral tLiteral = (TLiteral)theEObject;
				T result = caseTLiteral(tLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HTPackage.TLOCAL_NOTIFICATION: {
				TLocalNotification tLocalNotification = (TLocalNotification)theEObject;
				T result = caseTLocalNotification(tLocalNotification);
				if (result == null) result = caseTExtensibleElements(tLocalNotification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HTPackage.TLOGICAL_PEOPLE_GROUP: {
				TLogicalPeopleGroup tLogicalPeopleGroup = (TLogicalPeopleGroup)theEObject;
				T result = caseTLogicalPeopleGroup(tLogicalPeopleGroup);
				if (result == null) result = caseTExtensibleElements(tLogicalPeopleGroup);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HTPackage.TLOGICAL_PEOPLE_GROUPS: {
				TLogicalPeopleGroups tLogicalPeopleGroups = (TLogicalPeopleGroups)theEObject;
				T result = caseTLogicalPeopleGroups(tLogicalPeopleGroups);
				if (result == null) result = caseTExtensibleElements(tLogicalPeopleGroups);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HTPackage.TNOTIFICATION: {
				TNotification tNotification = (TNotification)theEObject;
				T result = caseTNotification(tNotification);
				if (result == null) result = caseTExtensibleElements(tNotification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HTPackage.TNOTIFICATION_INTERFACE: {
				TNotificationInterface tNotificationInterface = (TNotificationInterface)theEObject;
				T result = caseTNotificationInterface(tNotificationInterface);
				if (result == null) result = caseTExtensibleElements(tNotificationInterface);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HTPackage.TNOTIFICATIONS: {
				TNotifications tNotifications = (TNotifications)theEObject;
				T result = caseTNotifications(tNotifications);
				if (result == null) result = caseTExtensibleElements(tNotifications);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HTPackage.TORGANIZATIONAL_ENTITY: {
				TOrganizationalEntity tOrganizationalEntity = (TOrganizationalEntity)theEObject;
				T result = caseTOrganizationalEntity(tOrganizationalEntity);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HTPackage.TPARAMETER: {
				TParameter tParameter = (TParameter)theEObject;
				T result = caseTParameter(tParameter);
				if (result == null) result = caseTExtensibleMixedContentElements(tParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HTPackage.TPEOPLE_ASSIGNMENTS: {
				TPeopleAssignments tPeopleAssignments = (TPeopleAssignments)theEObject;
				T result = caseTPeopleAssignments(tPeopleAssignments);
				if (result == null) result = caseTExtensibleElements(tPeopleAssignments);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HTPackage.TPRESENTATION_ELEMENTS: {
				TPresentationElements tPresentationElements = (TPresentationElements)theEObject;
				T result = caseTPresentationElements(tPresentationElements);
				if (result == null) result = caseTExtensibleElements(tPresentationElements);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HTPackage.TPRESENTATION_PARAMETER: {
				TPresentationParameter tPresentationParameter = (TPresentationParameter)theEObject;
				T result = caseTPresentationParameter(tPresentationParameter);
				if (result == null) result = caseTParameter(tPresentationParameter);
				if (result == null) result = caseTExtensibleMixedContentElements(tPresentationParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HTPackage.TPRESENTATION_PARAMETERS: {
				TPresentationParameters tPresentationParameters = (TPresentationParameters)theEObject;
				T result = caseTPresentationParameters(tPresentationParameters);
				if (result == null) result = caseTExtensibleElements(tPresentationParameters);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HTPackage.TPRIORITY: {
				TPriority tPriority = (TPriority)theEObject;
				T result = caseTPriority(tPriority);
				if (result == null) result = caseTExpression(tPriority);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HTPackage.TQUERY: {
				TQuery tQuery = (TQuery)theEObject;
				T result = caseTQuery(tQuery);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HTPackage.TREASSIGNMENT: {
				TReassignment tReassignment = (TReassignment)theEObject;
				T result = caseTReassignment(tReassignment);
				if (result == null) result = caseTExtensibleElements(tReassignment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HTPackage.TRENDERING: {
				TRendering tRendering = (TRendering)theEObject;
				T result = caseTRendering(tRendering);
				if (result == null) result = caseTExtensibleElements(tRendering);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HTPackage.TRENDERINGS: {
				TRenderings tRenderings = (TRenderings)theEObject;
				T result = caseTRenderings(tRenderings);
				if (result == null) result = caseTExtensibleElements(tRenderings);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HTPackage.TTASK: {
				TTask tTask = (TTask)theEObject;
				T result = caseTTask(tTask);
				if (result == null) result = caseTExtensibleElements(tTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HTPackage.TTASK_INTERFACE: {
				TTaskInterface tTaskInterface = (TTaskInterface)theEObject;
				T result = caseTTaskInterface(tTaskInterface);
				if (result == null) result = caseTExtensibleElements(tTaskInterface);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HTPackage.TTASKS: {
				TTasks tTasks = (TTasks)theEObject;
				T result = caseTTasks(tTasks);
				if (result == null) result = caseTExtensibleElements(tTasks);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HTPackage.TTEXT: {
				TText tText = (TText)theEObject;
				T result = caseTText(tText);
				if (result == null) result = caseTExtensibleMixedContentElements(tText);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HTPackage.TTO_PART: {
				TToPart tToPart = (TToPart)theEObject;
				T result = caseTToPart(tToPart);
				if (result == null) result = caseTExtensibleMixedContentElements(tToPart);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HTPackage.TTO_PARTS: {
				TToParts tToParts = (TToParts)theEObject;
				T result = caseTToParts(tToParts);
				if (result == null) result = caseTExtensibleElements(tToParts);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case HTPackage.TUSERLIST: {
				TUserlist tUserlist = (TUserlist)theEObject;
				T result = caseTUserlist(tUserlist);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Document Root</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Document Root</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDocumentRoot(DocumentRoot object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TArgument</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TArgument</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTArgument(TArgument object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TBoolean Expr</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TBoolean Expr</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTBooleanExpr(TBooleanExpr object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TDeadline</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TDeadline</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTDeadline(TDeadline object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TDeadline Expr</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TDeadline Expr</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTDeadlineExpr(TDeadlineExpr object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TDeadlines</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TDeadlines</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTDeadlines(TDeadlines object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TDelegation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TDelegation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTDelegation(TDelegation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TDescription</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TDescription</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTDescription(TDescription object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TDocumentation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TDocumentation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTDocumentation(TDocumentation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TDuration Expr</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TDuration Expr</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTDurationExpr(TDurationExpr object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TEscalation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TEscalation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTEscalation(TEscalation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TExpression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TExpression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTExpression(TExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TExtensible Elements</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TExtensible Elements</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTExtensibleElements(TExtensibleElements object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TExtensible Mixed Content Elements</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TExtensible Mixed Content Elements</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTExtensibleMixedContentElements(TExtensibleMixedContentElements object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TExtension</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TExtension</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTExtension(TExtension object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TExtensions</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TExtensions</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTExtensions(TExtensions object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TFrom</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TFrom</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTFrom(TFrom object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TGeneric Human Role</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TGeneric Human Role</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTGenericHumanRole(TGenericHumanRole object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TGrouplist</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TGrouplist</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTGrouplist(TGrouplist object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>THuman Interactions</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>THuman Interactions</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTHumanInteractions(THumanInteractions object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TImport</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TImport</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTImport(TImport object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TLiteral</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TLiteral</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTLiteral(TLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TLocal Notification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TLocal Notification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTLocalNotification(TLocalNotification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TLogical People Group</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TLogical People Group</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTLogicalPeopleGroup(TLogicalPeopleGroup object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TLogical People Groups</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TLogical People Groups</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTLogicalPeopleGroups(TLogicalPeopleGroups object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TNotification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TNotification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTNotification(TNotification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TNotification Interface</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TNotification Interface</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTNotificationInterface(TNotificationInterface object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TNotifications</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TNotifications</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTNotifications(TNotifications object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TOrganizational Entity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TOrganizational Entity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTOrganizationalEntity(TOrganizationalEntity object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TParameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TParameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTParameter(TParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TPeople Assignments</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TPeople Assignments</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTPeopleAssignments(TPeopleAssignments object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TPresentation Elements</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TPresentation Elements</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTPresentationElements(TPresentationElements object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TPresentation Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TPresentation Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTPresentationParameter(TPresentationParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TPresentation Parameters</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TPresentation Parameters</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTPresentationParameters(TPresentationParameters object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TPriority</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TPriority</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTPriority(TPriority object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TQuery</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TQuery</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTQuery(TQuery object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TReassignment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TReassignment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTReassignment(TReassignment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TRendering</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TRendering</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTRendering(TRendering object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TRenderings</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TRenderings</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTRenderings(TRenderings object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TTask</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TTask</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTTask(TTask object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TTask Interface</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TTask Interface</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTTaskInterface(TTaskInterface object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TTasks</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TTasks</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTTasks(TTasks object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TText</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TText</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTText(TText object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TTo Part</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TTo Part</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTToPart(TToPart object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TTo Parts</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TTo Parts</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTToParts(TToParts object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TUserlist</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TUserlist</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTUserlist(TUserlist object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} //HTSwitch
