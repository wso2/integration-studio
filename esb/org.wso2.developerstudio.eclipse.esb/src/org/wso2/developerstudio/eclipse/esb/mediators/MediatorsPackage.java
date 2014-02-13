/**
 * Copyright 2009-2010 WSO2, Inc. (http://wso2.com)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.wso2.developerstudio.eclipse.esb.mediators;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.wso2.developerstudio.eclipse.esb.EsbPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsFactory
 * @model kind="package"
 * @generated
 */
public interface MediatorsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "mediators";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///org/wso2/developerstudio/eclipse/esb/mediators";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "mediators";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MediatorsPackage eINSTANCE = org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.InMediatorImpl <em>In Mediator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.InMediatorImpl
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getInMediator()
	 * @generated
	 */
	int IN_MEDIATOR = 0;

	/**
	 * The feature id for the '<em><b>Object State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_MEDIATOR__OBJECT_STATE = EsbPackage.PARENT_MEDIATOR__OBJECT_STATE;

	/**
	 * The feature id for the '<em><b>Source Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_MEDIATOR__SOURCE_TEXT = EsbPackage.PARENT_MEDIATOR__SOURCE_TEXT;

	/**
	 * The feature id for the '<em><b>Default Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_MEDIATOR__DEFAULT_NAMESPACE = EsbPackage.PARENT_MEDIATOR__DEFAULT_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Additional Namespaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_MEDIATOR__ADDITIONAL_NAMESPACES = EsbPackage.PARENT_MEDIATOR__ADDITIONAL_NAMESPACES;

	/**
	 * The feature id for the '<em><b>Current Esb Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_MEDIATOR__CURRENT_ESB_VERSION = EsbPackage.PARENT_MEDIATOR__CURRENT_ESB_VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_MEDIATOR__COMMENT = EsbPackage.PARENT_MEDIATOR__COMMENT;

	/**
	 * The feature id for the '<em><b>Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_MEDIATOR__DESCRIPTION = EsbPackage.PARENT_MEDIATOR__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_MEDIATOR__CHILDREN = EsbPackage.PARENT_MEDIATOR__CHILDREN;

	/**
	 * The number of structural features of the '<em>In Mediator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_MEDIATOR_FEATURE_COUNT = EsbPackage.PARENT_MEDIATOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.OutMediatorImpl <em>Out Mediator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.OutMediatorImpl
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getOutMediator()
	 * @generated
	 */
	int OUT_MEDIATOR = 1;

	/**
	 * The feature id for the '<em><b>Object State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUT_MEDIATOR__OBJECT_STATE = EsbPackage.PARENT_MEDIATOR__OBJECT_STATE;

	/**
	 * The feature id for the '<em><b>Source Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUT_MEDIATOR__SOURCE_TEXT = EsbPackage.PARENT_MEDIATOR__SOURCE_TEXT;

	/**
	 * The feature id for the '<em><b>Default Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUT_MEDIATOR__DEFAULT_NAMESPACE = EsbPackage.PARENT_MEDIATOR__DEFAULT_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Additional Namespaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUT_MEDIATOR__ADDITIONAL_NAMESPACES = EsbPackage.PARENT_MEDIATOR__ADDITIONAL_NAMESPACES;

	/**
	 * The feature id for the '<em><b>Current Esb Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUT_MEDIATOR__CURRENT_ESB_VERSION = EsbPackage.PARENT_MEDIATOR__CURRENT_ESB_VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUT_MEDIATOR__COMMENT = EsbPackage.PARENT_MEDIATOR__COMMENT;

	/**
	 * The feature id for the '<em><b>Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUT_MEDIATOR__DESCRIPTION = EsbPackage.PARENT_MEDIATOR__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUT_MEDIATOR__CHILDREN = EsbPackage.PARENT_MEDIATOR__CHILDREN;

	/**
	 * The number of structural features of the '<em>Out Mediator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUT_MEDIATOR_FEATURE_COUNT = EsbPackage.PARENT_MEDIATOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.DropMediatorImpl <em>Drop Mediator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.DropMediatorImpl
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getDropMediator()
	 * @generated
	 */
	int DROP_MEDIATOR = 2;

	/**
	 * The feature id for the '<em><b>Object State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DROP_MEDIATOR__OBJECT_STATE = EsbPackage.MEDIATOR__OBJECT_STATE;

	/**
	 * The feature id for the '<em><b>Source Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DROP_MEDIATOR__SOURCE_TEXT = EsbPackage.MEDIATOR__SOURCE_TEXT;

	/**
	 * The feature id for the '<em><b>Default Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DROP_MEDIATOR__DEFAULT_NAMESPACE = EsbPackage.MEDIATOR__DEFAULT_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Additional Namespaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DROP_MEDIATOR__ADDITIONAL_NAMESPACES = EsbPackage.MEDIATOR__ADDITIONAL_NAMESPACES;

	/**
	 * The feature id for the '<em><b>Current Esb Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DROP_MEDIATOR__CURRENT_ESB_VERSION = EsbPackage.MEDIATOR__CURRENT_ESB_VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DROP_MEDIATOR__COMMENT = EsbPackage.MEDIATOR__COMMENT;

	/**
	 * The feature id for the '<em><b>Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DROP_MEDIATOR__DESCRIPTION = EsbPackage.MEDIATOR__DESCRIPTION;

	/**
	 * The number of structural features of the '<em>Drop Mediator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DROP_MEDIATOR_FEATURE_COUNT = EsbPackage.MEDIATOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.SendMediatorImpl <em>Send Mediator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.SendMediatorImpl
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getSendMediator()
	 * @generated
	 */
	int SEND_MEDIATOR = 3;

	/**
	 * The feature id for the '<em><b>Object State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND_MEDIATOR__OBJECT_STATE = EsbPackage.MEDIATOR__OBJECT_STATE;

	/**
	 * The feature id for the '<em><b>Source Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND_MEDIATOR__SOURCE_TEXT = EsbPackage.MEDIATOR__SOURCE_TEXT;

	/**
	 * The feature id for the '<em><b>Default Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND_MEDIATOR__DEFAULT_NAMESPACE = EsbPackage.MEDIATOR__DEFAULT_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Additional Namespaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND_MEDIATOR__ADDITIONAL_NAMESPACES = EsbPackage.MEDIATOR__ADDITIONAL_NAMESPACES;

	/**
	 * The feature id for the '<em><b>Current Esb Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND_MEDIATOR__CURRENT_ESB_VERSION = EsbPackage.MEDIATOR__CURRENT_ESB_VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND_MEDIATOR__COMMENT = EsbPackage.MEDIATOR__COMMENT;

	/**
	 * The feature id for the '<em><b>Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND_MEDIATOR__DESCRIPTION = EsbPackage.MEDIATOR__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Anonymous End Point</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND_MEDIATOR__ANONYMOUS_END_POINT = EsbPackage.MEDIATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>End Point Reference</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND_MEDIATOR__END_POINT_REFERENCE = EsbPackage.MEDIATOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Receiving Sequence Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND_MEDIATOR__RECEIVING_SEQUENCE_TYPE = EsbPackage.MEDIATOR_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Static Receiving Sequence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND_MEDIATOR__STATIC_RECEIVING_SEQUENCE = EsbPackage.MEDIATOR_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Dynamic Receiving Sequence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND_MEDIATOR__DYNAMIC_RECEIVING_SEQUENCE = EsbPackage.MEDIATOR_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Send Mediator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND_MEDIATOR_FEATURE_COUNT = EsbPackage.MEDIATOR_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.LogMediatorImpl <em>Log Mediator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.LogMediatorImpl
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getLogMediator()
	 * @generated
	 */
	int LOG_MEDIATOR = 4;

	/**
	 * The feature id for the '<em><b>Object State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_MEDIATOR__OBJECT_STATE = EsbPackage.MEDIATOR__OBJECT_STATE;

	/**
	 * The feature id for the '<em><b>Source Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_MEDIATOR__SOURCE_TEXT = EsbPackage.MEDIATOR__SOURCE_TEXT;

	/**
	 * The feature id for the '<em><b>Default Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_MEDIATOR__DEFAULT_NAMESPACE = EsbPackage.MEDIATOR__DEFAULT_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Additional Namespaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_MEDIATOR__ADDITIONAL_NAMESPACES = EsbPackage.MEDIATOR__ADDITIONAL_NAMESPACES;

	/**
	 * The feature id for the '<em><b>Current Esb Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_MEDIATOR__CURRENT_ESB_VERSION = EsbPackage.MEDIATOR__CURRENT_ESB_VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_MEDIATOR__COMMENT = EsbPackage.MEDIATOR__COMMENT;

	/**
	 * The feature id for the '<em><b>Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_MEDIATOR__DESCRIPTION = EsbPackage.MEDIATOR__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Log Category</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_MEDIATOR__LOG_CATEGORY = EsbPackage.MEDIATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Log Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_MEDIATOR__LOG_LEVEL = EsbPackage.MEDIATOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Log Separator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_MEDIATOR__LOG_SEPARATOR = EsbPackage.MEDIATOR_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_MEDIATOR__PROPERTIES = EsbPackage.MEDIATOR_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Log Mediator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_MEDIATOR_FEATURE_COUNT = EsbPackage.MEDIATOR_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.LogPropertyImpl <em>Log Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.LogPropertyImpl
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getLogProperty()
	 * @generated
	 */
	int LOG_PROPERTY = 5;

	/**
	 * The feature id for the '<em><b>Object State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_PROPERTY__OBJECT_STATE = EsbPackage.ABSTRACT_NAME_VALUE_EXPRESSION_PROPERTY__OBJECT_STATE;

	/**
	 * The feature id for the '<em><b>Source Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_PROPERTY__SOURCE_TEXT = EsbPackage.ABSTRACT_NAME_VALUE_EXPRESSION_PROPERTY__SOURCE_TEXT;

	/**
	 * The feature id for the '<em><b>Default Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_PROPERTY__DEFAULT_NAMESPACE = EsbPackage.ABSTRACT_NAME_VALUE_EXPRESSION_PROPERTY__DEFAULT_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Additional Namespaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_PROPERTY__ADDITIONAL_NAMESPACES = EsbPackage.ABSTRACT_NAME_VALUE_EXPRESSION_PROPERTY__ADDITIONAL_NAMESPACES;

	/**
	 * The feature id for the '<em><b>Current Esb Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_PROPERTY__CURRENT_ESB_VERSION = EsbPackage.ABSTRACT_NAME_VALUE_EXPRESSION_PROPERTY__CURRENT_ESB_VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_PROPERTY__COMMENT = EsbPackage.ABSTRACT_NAME_VALUE_EXPRESSION_PROPERTY__COMMENT;

	/**
	 * The feature id for the '<em><b>Property Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_PROPERTY__PROPERTY_NAME = EsbPackage.ABSTRACT_NAME_VALUE_EXPRESSION_PROPERTY__PROPERTY_NAME;

	/**
	 * The feature id for the '<em><b>Property Value Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_PROPERTY__PROPERTY_VALUE_TYPE = EsbPackage.ABSTRACT_NAME_VALUE_EXPRESSION_PROPERTY__PROPERTY_VALUE_TYPE;

	/**
	 * The feature id for the '<em><b>Property Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_PROPERTY__PROPERTY_VALUE = EsbPackage.ABSTRACT_NAME_VALUE_EXPRESSION_PROPERTY__PROPERTY_VALUE;

	/**
	 * The feature id for the '<em><b>Property Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_PROPERTY__PROPERTY_EXPRESSION = EsbPackage.ABSTRACT_NAME_VALUE_EXPRESSION_PROPERTY__PROPERTY_EXPRESSION;

	/**
	 * The number of structural features of the '<em>Log Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_PROPERTY_FEATURE_COUNT = EsbPackage.ABSTRACT_NAME_VALUE_EXPRESSION_PROPERTY_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.FilterMediatorImpl <em>Filter Mediator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.FilterMediatorImpl
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getFilterMediator()
	 * @generated
	 */
	int FILTER_MEDIATOR = 6;

	/**
	 * The feature id for the '<em><b>Object State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILTER_MEDIATOR__OBJECT_STATE = EsbPackage.MEDIATOR__OBJECT_STATE;

	/**
	 * The feature id for the '<em><b>Source Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILTER_MEDIATOR__SOURCE_TEXT = EsbPackage.MEDIATOR__SOURCE_TEXT;

	/**
	 * The feature id for the '<em><b>Default Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILTER_MEDIATOR__DEFAULT_NAMESPACE = EsbPackage.MEDIATOR__DEFAULT_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Additional Namespaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILTER_MEDIATOR__ADDITIONAL_NAMESPACES = EsbPackage.MEDIATOR__ADDITIONAL_NAMESPACES;

	/**
	 * The feature id for the '<em><b>Current Esb Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILTER_MEDIATOR__CURRENT_ESB_VERSION = EsbPackage.MEDIATOR__CURRENT_ESB_VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILTER_MEDIATOR__COMMENT = EsbPackage.MEDIATOR__COMMENT;

	/**
	 * The feature id for the '<em><b>Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILTER_MEDIATOR__DESCRIPTION = EsbPackage.MEDIATOR__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Condition Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILTER_MEDIATOR__CONDITION_TYPE = EsbPackage.MEDIATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Filter Xpath</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILTER_MEDIATOR__FILTER_XPATH = EsbPackage.MEDIATOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Filter Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILTER_MEDIATOR__FILTER_SOURCE = EsbPackage.MEDIATOR_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Filter Regex</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILTER_MEDIATOR__FILTER_REGEX = EsbPackage.MEDIATOR_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Then Branch</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILTER_MEDIATOR__THEN_BRANCH = EsbPackage.MEDIATOR_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Else Branch</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILTER_MEDIATOR__ELSE_BRANCH = EsbPackage.MEDIATOR_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Filter Mediator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILTER_MEDIATOR_FEATURE_COUNT = EsbPackage.MEDIATOR_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.FilterThenBranchImpl <em>Filter Then Branch</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.FilterThenBranchImpl
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getFilterThenBranch()
	 * @generated
	 */
	int FILTER_THEN_BRANCH = 7;

	/**
	 * The feature id for the '<em><b>Object State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILTER_THEN_BRANCH__OBJECT_STATE = EsbPackage.MEDIATOR_BRANCH__OBJECT_STATE;

	/**
	 * The feature id for the '<em><b>Source Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILTER_THEN_BRANCH__SOURCE_TEXT = EsbPackage.MEDIATOR_BRANCH__SOURCE_TEXT;

	/**
	 * The feature id for the '<em><b>Default Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILTER_THEN_BRANCH__DEFAULT_NAMESPACE = EsbPackage.MEDIATOR_BRANCH__DEFAULT_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Additional Namespaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILTER_THEN_BRANCH__ADDITIONAL_NAMESPACES = EsbPackage.MEDIATOR_BRANCH__ADDITIONAL_NAMESPACES;

	/**
	 * The feature id for the '<em><b>Current Esb Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILTER_THEN_BRANCH__CURRENT_ESB_VERSION = EsbPackage.MEDIATOR_BRANCH__CURRENT_ESB_VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILTER_THEN_BRANCH__COMMENT = EsbPackage.MEDIATOR_BRANCH__COMMENT;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILTER_THEN_BRANCH__CHILDREN = EsbPackage.MEDIATOR_BRANCH__CHILDREN;

	/**
	 * The number of structural features of the '<em>Filter Then Branch</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILTER_THEN_BRANCH_FEATURE_COUNT = EsbPackage.MEDIATOR_BRANCH_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.FilterElseBranchImpl <em>Filter Else Branch</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.FilterElseBranchImpl
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getFilterElseBranch()
	 * @generated
	 */
	int FILTER_ELSE_BRANCH = 8;

	/**
	 * The feature id for the '<em><b>Object State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILTER_ELSE_BRANCH__OBJECT_STATE = EsbPackage.MEDIATOR_BRANCH__OBJECT_STATE;

	/**
	 * The feature id for the '<em><b>Source Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILTER_ELSE_BRANCH__SOURCE_TEXT = EsbPackage.MEDIATOR_BRANCH__SOURCE_TEXT;

	/**
	 * The feature id for the '<em><b>Default Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILTER_ELSE_BRANCH__DEFAULT_NAMESPACE = EsbPackage.MEDIATOR_BRANCH__DEFAULT_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Additional Namespaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILTER_ELSE_BRANCH__ADDITIONAL_NAMESPACES = EsbPackage.MEDIATOR_BRANCH__ADDITIONAL_NAMESPACES;

	/**
	 * The feature id for the '<em><b>Current Esb Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILTER_ELSE_BRANCH__CURRENT_ESB_VERSION = EsbPackage.MEDIATOR_BRANCH__CURRENT_ESB_VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILTER_ELSE_BRANCH__COMMENT = EsbPackage.MEDIATOR_BRANCH__COMMENT;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILTER_ELSE_BRANCH__CHILDREN = EsbPackage.MEDIATOR_BRANCH__CHILDREN;

	/**
	 * The number of structural features of the '<em>Filter Else Branch</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILTER_ELSE_BRANCH_FEATURE_COUNT = EsbPackage.MEDIATOR_BRANCH_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.SwitchMediatorImpl <em>Switch Mediator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.SwitchMediatorImpl
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getSwitchMediator()
	 * @generated
	 */
	int SWITCH_MEDIATOR = 9;

	/**
	 * The feature id for the '<em><b>Object State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_MEDIATOR__OBJECT_STATE = EsbPackage.MEDIATOR__OBJECT_STATE;

	/**
	 * The feature id for the '<em><b>Source Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_MEDIATOR__SOURCE_TEXT = EsbPackage.MEDIATOR__SOURCE_TEXT;

	/**
	 * The feature id for the '<em><b>Default Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_MEDIATOR__DEFAULT_NAMESPACE = EsbPackage.MEDIATOR__DEFAULT_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Additional Namespaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_MEDIATOR__ADDITIONAL_NAMESPACES = EsbPackage.MEDIATOR__ADDITIONAL_NAMESPACES;

	/**
	 * The feature id for the '<em><b>Current Esb Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_MEDIATOR__CURRENT_ESB_VERSION = EsbPackage.MEDIATOR__CURRENT_ESB_VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_MEDIATOR__COMMENT = EsbPackage.MEDIATOR__COMMENT;

	/**
	 * The feature id for the '<em><b>Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_MEDIATOR__DESCRIPTION = EsbPackage.MEDIATOR__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Source Xpath</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_MEDIATOR__SOURCE_XPATH = EsbPackage.MEDIATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Case Branches</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_MEDIATOR__CASE_BRANCHES = EsbPackage.MEDIATOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Default Branch</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_MEDIATOR__DEFAULT_BRANCH = EsbPackage.MEDIATOR_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Switch Mediator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_MEDIATOR_FEATURE_COUNT = EsbPackage.MEDIATOR_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.SwitchCaseBranchImpl <em>Switch Case Branch</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.SwitchCaseBranchImpl
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getSwitchCaseBranch()
	 * @generated
	 */
	int SWITCH_CASE_BRANCH = 10;

	/**
	 * The feature id for the '<em><b>Object State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_CASE_BRANCH__OBJECT_STATE = EsbPackage.MEDIATOR_BRANCH__OBJECT_STATE;

	/**
	 * The feature id for the '<em><b>Source Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_CASE_BRANCH__SOURCE_TEXT = EsbPackage.MEDIATOR_BRANCH__SOURCE_TEXT;

	/**
	 * The feature id for the '<em><b>Default Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_CASE_BRANCH__DEFAULT_NAMESPACE = EsbPackage.MEDIATOR_BRANCH__DEFAULT_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Additional Namespaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_CASE_BRANCH__ADDITIONAL_NAMESPACES = EsbPackage.MEDIATOR_BRANCH__ADDITIONAL_NAMESPACES;

	/**
	 * The feature id for the '<em><b>Current Esb Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_CASE_BRANCH__CURRENT_ESB_VERSION = EsbPackage.MEDIATOR_BRANCH__CURRENT_ESB_VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_CASE_BRANCH__COMMENT = EsbPackage.MEDIATOR_BRANCH__COMMENT;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_CASE_BRANCH__CHILDREN = EsbPackage.MEDIATOR_BRANCH__CHILDREN;

	/**
	 * The feature id for the '<em><b>Case Regex</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_CASE_BRANCH__CASE_REGEX = EsbPackage.MEDIATOR_BRANCH_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Switch Case Branch</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_CASE_BRANCH_FEATURE_COUNT = EsbPackage.MEDIATOR_BRANCH_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.SwitchDefaultBranchImpl <em>Switch Default Branch</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.SwitchDefaultBranchImpl
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getSwitchDefaultBranch()
	 * @generated
	 */
	int SWITCH_DEFAULT_BRANCH = 11;

	/**
	 * The feature id for the '<em><b>Object State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_DEFAULT_BRANCH__OBJECT_STATE = EsbPackage.MEDIATOR_BRANCH__OBJECT_STATE;

	/**
	 * The feature id for the '<em><b>Source Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_DEFAULT_BRANCH__SOURCE_TEXT = EsbPackage.MEDIATOR_BRANCH__SOURCE_TEXT;

	/**
	 * The feature id for the '<em><b>Default Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_DEFAULT_BRANCH__DEFAULT_NAMESPACE = EsbPackage.MEDIATOR_BRANCH__DEFAULT_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Additional Namespaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_DEFAULT_BRANCH__ADDITIONAL_NAMESPACES = EsbPackage.MEDIATOR_BRANCH__ADDITIONAL_NAMESPACES;

	/**
	 * The feature id for the '<em><b>Current Esb Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_DEFAULT_BRANCH__CURRENT_ESB_VERSION = EsbPackage.MEDIATOR_BRANCH__CURRENT_ESB_VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_DEFAULT_BRANCH__COMMENT = EsbPackage.MEDIATOR_BRANCH__COMMENT;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_DEFAULT_BRANCH__CHILDREN = EsbPackage.MEDIATOR_BRANCH__CHILDREN;

	/**
	 * The number of structural features of the '<em>Switch Default Branch</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_DEFAULT_BRANCH_FEATURE_COUNT = EsbPackage.MEDIATOR_BRANCH_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.EntitlementMediatorImpl <em>Entitlement Mediator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.EntitlementMediatorImpl
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getEntitlementMediator()
	 * @generated
	 */
	int ENTITLEMENT_MEDIATOR = 12;

	/**
	 * The feature id for the '<em><b>Object State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITLEMENT_MEDIATOR__OBJECT_STATE = EsbPackage.MEDIATOR__OBJECT_STATE;

	/**
	 * The feature id for the '<em><b>Source Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITLEMENT_MEDIATOR__SOURCE_TEXT = EsbPackage.MEDIATOR__SOURCE_TEXT;

	/**
	 * The feature id for the '<em><b>Default Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITLEMENT_MEDIATOR__DEFAULT_NAMESPACE = EsbPackage.MEDIATOR__DEFAULT_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Additional Namespaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITLEMENT_MEDIATOR__ADDITIONAL_NAMESPACES = EsbPackage.MEDIATOR__ADDITIONAL_NAMESPACES;

	/**
	 * The feature id for the '<em><b>Current Esb Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITLEMENT_MEDIATOR__CURRENT_ESB_VERSION = EsbPackage.MEDIATOR__CURRENT_ESB_VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITLEMENT_MEDIATOR__COMMENT = EsbPackage.MEDIATOR__COMMENT;

	/**
	 * The feature id for the '<em><b>Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITLEMENT_MEDIATOR__DESCRIPTION = EsbPackage.MEDIATOR__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Server URL</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITLEMENT_MEDIATOR__SERVER_URL = EsbPackage.MEDIATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Username</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITLEMENT_MEDIATOR__USERNAME = EsbPackage.MEDIATOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITLEMENT_MEDIATOR__PASSWORD = EsbPackage.MEDIATOR_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>On Accept</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITLEMENT_MEDIATOR__ON_ACCEPT = EsbPackage.MEDIATOR_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>On Reject</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITLEMENT_MEDIATOR__ON_REJECT = EsbPackage.MEDIATOR_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Obligations</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITLEMENT_MEDIATOR__OBLIGATIONS = EsbPackage.MEDIATOR_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Advice</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITLEMENT_MEDIATOR__ADVICE = EsbPackage.MEDIATOR_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Callback Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITLEMENT_MEDIATOR__CALLBACK_CLASS = EsbPackage.MEDIATOR_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Entitlement Mediator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITLEMENT_MEDIATOR_FEATURE_COUNT = EsbPackage.MEDIATOR_FEATURE_COUNT + 8;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.EntitlementAdviceBranchImpl <em>Entitlement Advice Branch</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.EntitlementAdviceBranchImpl
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getEntitlementAdviceBranch()
	 * @generated
	 */
	int ENTITLEMENT_ADVICE_BRANCH = 13;

	/**
	 * The feature id for the '<em><b>Object State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITLEMENT_ADVICE_BRANCH__OBJECT_STATE = EsbPackage.MEDIATOR_BRANCH__OBJECT_STATE;

	/**
	 * The feature id for the '<em><b>Source Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITLEMENT_ADVICE_BRANCH__SOURCE_TEXT = EsbPackage.MEDIATOR_BRANCH__SOURCE_TEXT;

	/**
	 * The feature id for the '<em><b>Default Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITLEMENT_ADVICE_BRANCH__DEFAULT_NAMESPACE = EsbPackage.MEDIATOR_BRANCH__DEFAULT_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Additional Namespaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITLEMENT_ADVICE_BRANCH__ADDITIONAL_NAMESPACES = EsbPackage.MEDIATOR_BRANCH__ADDITIONAL_NAMESPACES;

	/**
	 * The feature id for the '<em><b>Current Esb Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITLEMENT_ADVICE_BRANCH__CURRENT_ESB_VERSION = EsbPackage.MEDIATOR_BRANCH__CURRENT_ESB_VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITLEMENT_ADVICE_BRANCH__COMMENT = EsbPackage.MEDIATOR_BRANCH__COMMENT;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITLEMENT_ADVICE_BRANCH__CHILDREN = EsbPackage.MEDIATOR_BRANCH__CHILDREN;

	/**
	 * The feature id for the '<em><b>Sequence Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITLEMENT_ADVICE_BRANCH__SEQUENCE_TYPE = EsbPackage.MEDIATOR_BRANCH_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Sequence Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITLEMENT_ADVICE_BRANCH__SEQUENCE_KEY = EsbPackage.MEDIATOR_BRANCH_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Entitlement Advice Branch</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITLEMENT_ADVICE_BRANCH_FEATURE_COUNT = EsbPackage.MEDIATOR_BRANCH_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.EntitlementObligationsBranchImpl <em>Entitlement Obligations Branch</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.EntitlementObligationsBranchImpl
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getEntitlementObligationsBranch()
	 * @generated
	 */
	int ENTITLEMENT_OBLIGATIONS_BRANCH = 14;

	/**
	 * The feature id for the '<em><b>Object State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITLEMENT_OBLIGATIONS_BRANCH__OBJECT_STATE = EsbPackage.MEDIATOR_BRANCH__OBJECT_STATE;

	/**
	 * The feature id for the '<em><b>Source Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITLEMENT_OBLIGATIONS_BRANCH__SOURCE_TEXT = EsbPackage.MEDIATOR_BRANCH__SOURCE_TEXT;

	/**
	 * The feature id for the '<em><b>Default Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITLEMENT_OBLIGATIONS_BRANCH__DEFAULT_NAMESPACE = EsbPackage.MEDIATOR_BRANCH__DEFAULT_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Additional Namespaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITLEMENT_OBLIGATIONS_BRANCH__ADDITIONAL_NAMESPACES = EsbPackage.MEDIATOR_BRANCH__ADDITIONAL_NAMESPACES;

	/**
	 * The feature id for the '<em><b>Current Esb Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITLEMENT_OBLIGATIONS_BRANCH__CURRENT_ESB_VERSION = EsbPackage.MEDIATOR_BRANCH__CURRENT_ESB_VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITLEMENT_OBLIGATIONS_BRANCH__COMMENT = EsbPackage.MEDIATOR_BRANCH__COMMENT;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITLEMENT_OBLIGATIONS_BRANCH__CHILDREN = EsbPackage.MEDIATOR_BRANCH__CHILDREN;

	/**
	 * The feature id for the '<em><b>Sequence Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITLEMENT_OBLIGATIONS_BRANCH__SEQUENCE_TYPE = EsbPackage.MEDIATOR_BRANCH_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Sequence Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITLEMENT_OBLIGATIONS_BRANCH__SEQUENCE_KEY = EsbPackage.MEDIATOR_BRANCH_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Entitlement Obligations Branch</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITLEMENT_OBLIGATIONS_BRANCH_FEATURE_COUNT = EsbPackage.MEDIATOR_BRANCH_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.EntitlementMediatorOnRejectBranchImpl <em>Entitlement Mediator On Reject Branch</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.EntitlementMediatorOnRejectBranchImpl
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getEntitlementMediatorOnRejectBranch()
	 * @generated
	 */
	int ENTITLEMENT_MEDIATOR_ON_REJECT_BRANCH = 15;

	/**
	 * The feature id for the '<em><b>Object State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITLEMENT_MEDIATOR_ON_REJECT_BRANCH__OBJECT_STATE = EsbPackage.MEDIATOR_BRANCH__OBJECT_STATE;

	/**
	 * The feature id for the '<em><b>Source Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITLEMENT_MEDIATOR_ON_REJECT_BRANCH__SOURCE_TEXT = EsbPackage.MEDIATOR_BRANCH__SOURCE_TEXT;

	/**
	 * The feature id for the '<em><b>Default Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITLEMENT_MEDIATOR_ON_REJECT_BRANCH__DEFAULT_NAMESPACE = EsbPackage.MEDIATOR_BRANCH__DEFAULT_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Additional Namespaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITLEMENT_MEDIATOR_ON_REJECT_BRANCH__ADDITIONAL_NAMESPACES = EsbPackage.MEDIATOR_BRANCH__ADDITIONAL_NAMESPACES;

	/**
	 * The feature id for the '<em><b>Current Esb Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITLEMENT_MEDIATOR_ON_REJECT_BRANCH__CURRENT_ESB_VERSION = EsbPackage.MEDIATOR_BRANCH__CURRENT_ESB_VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITLEMENT_MEDIATOR_ON_REJECT_BRANCH__COMMENT = EsbPackage.MEDIATOR_BRANCH__COMMENT;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITLEMENT_MEDIATOR_ON_REJECT_BRANCH__CHILDREN = EsbPackage.MEDIATOR_BRANCH__CHILDREN;

	/**
	 * The feature id for the '<em><b>Sequence Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITLEMENT_MEDIATOR_ON_REJECT_BRANCH__SEQUENCE_TYPE = EsbPackage.MEDIATOR_BRANCH_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Sequence Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITLEMENT_MEDIATOR_ON_REJECT_BRANCH__SEQUENCE_KEY = EsbPackage.MEDIATOR_BRANCH_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Entitlement Mediator On Reject Branch</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITLEMENT_MEDIATOR_ON_REJECT_BRANCH_FEATURE_COUNT = EsbPackage.MEDIATOR_BRANCH_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.EntitlementMediatorOnAcceptBranchImpl <em>Entitlement Mediator On Accept Branch</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.EntitlementMediatorOnAcceptBranchImpl
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getEntitlementMediatorOnAcceptBranch()
	 * @generated
	 */
	int ENTITLEMENT_MEDIATOR_ON_ACCEPT_BRANCH = 16;

	/**
	 * The feature id for the '<em><b>Object State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITLEMENT_MEDIATOR_ON_ACCEPT_BRANCH__OBJECT_STATE = EsbPackage.MEDIATOR_BRANCH__OBJECT_STATE;

	/**
	 * The feature id for the '<em><b>Source Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITLEMENT_MEDIATOR_ON_ACCEPT_BRANCH__SOURCE_TEXT = EsbPackage.MEDIATOR_BRANCH__SOURCE_TEXT;

	/**
	 * The feature id for the '<em><b>Default Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITLEMENT_MEDIATOR_ON_ACCEPT_BRANCH__DEFAULT_NAMESPACE = EsbPackage.MEDIATOR_BRANCH__DEFAULT_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Additional Namespaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITLEMENT_MEDIATOR_ON_ACCEPT_BRANCH__ADDITIONAL_NAMESPACES = EsbPackage.MEDIATOR_BRANCH__ADDITIONAL_NAMESPACES;

	/**
	 * The feature id for the '<em><b>Current Esb Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITLEMENT_MEDIATOR_ON_ACCEPT_BRANCH__CURRENT_ESB_VERSION = EsbPackage.MEDIATOR_BRANCH__CURRENT_ESB_VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITLEMENT_MEDIATOR_ON_ACCEPT_BRANCH__COMMENT = EsbPackage.MEDIATOR_BRANCH__COMMENT;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITLEMENT_MEDIATOR_ON_ACCEPT_BRANCH__CHILDREN = EsbPackage.MEDIATOR_BRANCH__CHILDREN;

	/**
	 * The feature id for the '<em><b>Sequence Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITLEMENT_MEDIATOR_ON_ACCEPT_BRANCH__SEQUENCE_TYPE = EsbPackage.MEDIATOR_BRANCH_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Sequence Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITLEMENT_MEDIATOR_ON_ACCEPT_BRANCH__SEQUENCE_KEY = EsbPackage.MEDIATOR_BRANCH_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Entitlement Mediator On Accept Branch</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITLEMENT_MEDIATOR_ON_ACCEPT_BRANCH_FEATURE_COUNT = EsbPackage.MEDIATOR_BRANCH_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.EnqueueMediatorImpl <em>Enqueue Mediator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.EnqueueMediatorImpl
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getEnqueueMediator()
	 * @generated
	 */
	int ENQUEUE_MEDIATOR = 17;

	/**
	 * The feature id for the '<em><b>Object State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENQUEUE_MEDIATOR__OBJECT_STATE = EsbPackage.MEDIATOR__OBJECT_STATE;

	/**
	 * The feature id for the '<em><b>Source Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENQUEUE_MEDIATOR__SOURCE_TEXT = EsbPackage.MEDIATOR__SOURCE_TEXT;

	/**
	 * The feature id for the '<em><b>Default Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENQUEUE_MEDIATOR__DEFAULT_NAMESPACE = EsbPackage.MEDIATOR__DEFAULT_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Additional Namespaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENQUEUE_MEDIATOR__ADDITIONAL_NAMESPACES = EsbPackage.MEDIATOR__ADDITIONAL_NAMESPACES;

	/**
	 * The feature id for the '<em><b>Current Esb Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENQUEUE_MEDIATOR__CURRENT_ESB_VERSION = EsbPackage.MEDIATOR__CURRENT_ESB_VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENQUEUE_MEDIATOR__COMMENT = EsbPackage.MEDIATOR__COMMENT;

	/**
	 * The feature id for the '<em><b>Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENQUEUE_MEDIATOR__DESCRIPTION = EsbPackage.MEDIATOR__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Executor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENQUEUE_MEDIATOR__EXECUTOR = EsbPackage.MEDIATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENQUEUE_MEDIATOR__PRIORITY = EsbPackage.MEDIATOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Sequence Key</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENQUEUE_MEDIATOR__SEQUENCE_KEY = EsbPackage.MEDIATOR_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Enqueue Mediator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENQUEUE_MEDIATOR_FEATURE_COUNT = EsbPackage.MEDIATOR_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.ClassMediatorImpl <em>Class Mediator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.ClassMediatorImpl
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getClassMediator()
	 * @generated
	 */
	int CLASS_MEDIATOR = 18;

	/**
	 * The feature id for the '<em><b>Object State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_MEDIATOR__OBJECT_STATE = EsbPackage.MEDIATOR__OBJECT_STATE;

	/**
	 * The feature id for the '<em><b>Source Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_MEDIATOR__SOURCE_TEXT = EsbPackage.MEDIATOR__SOURCE_TEXT;

	/**
	 * The feature id for the '<em><b>Default Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_MEDIATOR__DEFAULT_NAMESPACE = EsbPackage.MEDIATOR__DEFAULT_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Additional Namespaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_MEDIATOR__ADDITIONAL_NAMESPACES = EsbPackage.MEDIATOR__ADDITIONAL_NAMESPACES;

	/**
	 * The feature id for the '<em><b>Current Esb Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_MEDIATOR__CURRENT_ESB_VERSION = EsbPackage.MEDIATOR__CURRENT_ESB_VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_MEDIATOR__COMMENT = EsbPackage.MEDIATOR__COMMENT;

	/**
	 * The feature id for the '<em><b>Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_MEDIATOR__DESCRIPTION = EsbPackage.MEDIATOR__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_MEDIATOR__CLASS_NAME = EsbPackage.MEDIATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_MEDIATOR__PROPERTIES = EsbPackage.MEDIATOR_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Class Mediator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_MEDIATOR_FEATURE_COUNT = EsbPackage.MEDIATOR_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.ClassPropertyImpl <em>Class Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.ClassPropertyImpl
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getClassProperty()
	 * @generated
	 */
	int CLASS_PROPERTY = 19;

	/**
	 * The feature id for the '<em><b>Object State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_PROPERTY__OBJECT_STATE = EsbPackage.ABSTRACT_NAME_VALUE_PROPERTY__OBJECT_STATE;

	/**
	 * The feature id for the '<em><b>Source Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_PROPERTY__SOURCE_TEXT = EsbPackage.ABSTRACT_NAME_VALUE_PROPERTY__SOURCE_TEXT;

	/**
	 * The feature id for the '<em><b>Default Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_PROPERTY__DEFAULT_NAMESPACE = EsbPackage.ABSTRACT_NAME_VALUE_PROPERTY__DEFAULT_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Additional Namespaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_PROPERTY__ADDITIONAL_NAMESPACES = EsbPackage.ABSTRACT_NAME_VALUE_PROPERTY__ADDITIONAL_NAMESPACES;

	/**
	 * The feature id for the '<em><b>Current Esb Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_PROPERTY__CURRENT_ESB_VERSION = EsbPackage.ABSTRACT_NAME_VALUE_PROPERTY__CURRENT_ESB_VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_PROPERTY__COMMENT = EsbPackage.ABSTRACT_NAME_VALUE_PROPERTY__COMMENT;

	/**
	 * The feature id for the '<em><b>Property Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_PROPERTY__PROPERTY_NAME = EsbPackage.ABSTRACT_NAME_VALUE_PROPERTY__PROPERTY_NAME;

	/**
	 * The feature id for the '<em><b>Property Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_PROPERTY__PROPERTY_VALUE = EsbPackage.ABSTRACT_NAME_VALUE_PROPERTY__PROPERTY_VALUE;

	/**
	 * The number of structural features of the '<em>Class Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_PROPERTY_FEATURE_COUNT = EsbPackage.ABSTRACT_NAME_VALUE_PROPERTY_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.SpringMediatorImpl <em>Spring Mediator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.SpringMediatorImpl
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getSpringMediator()
	 * @generated
	 */
	int SPRING_MEDIATOR = 20;

	/**
	 * The feature id for the '<em><b>Object State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPRING_MEDIATOR__OBJECT_STATE = EsbPackage.MEDIATOR__OBJECT_STATE;

	/**
	 * The feature id for the '<em><b>Source Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPRING_MEDIATOR__SOURCE_TEXT = EsbPackage.MEDIATOR__SOURCE_TEXT;

	/**
	 * The feature id for the '<em><b>Default Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPRING_MEDIATOR__DEFAULT_NAMESPACE = EsbPackage.MEDIATOR__DEFAULT_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Additional Namespaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPRING_MEDIATOR__ADDITIONAL_NAMESPACES = EsbPackage.MEDIATOR__ADDITIONAL_NAMESPACES;

	/**
	 * The feature id for the '<em><b>Current Esb Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPRING_MEDIATOR__CURRENT_ESB_VERSION = EsbPackage.MEDIATOR__CURRENT_ESB_VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPRING_MEDIATOR__COMMENT = EsbPackage.MEDIATOR__COMMENT;

	/**
	 * The feature id for the '<em><b>Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPRING_MEDIATOR__DESCRIPTION = EsbPackage.MEDIATOR__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Bean Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPRING_MEDIATOR__BEAN_NAME = EsbPackage.MEDIATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Configuration Key</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPRING_MEDIATOR__CONFIGURATION_KEY = EsbPackage.MEDIATOR_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Spring Mediator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPRING_MEDIATOR_FEATURE_COUNT = EsbPackage.MEDIATOR_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.ValidateMediatorImpl <em>Validate Mediator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.ValidateMediatorImpl
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getValidateMediator()
	 * @generated
	 */
	int VALIDATE_MEDIATOR = 21;

	/**
	 * The feature id for the '<em><b>Object State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATE_MEDIATOR__OBJECT_STATE = EsbPackage.MEDIATOR__OBJECT_STATE;

	/**
	 * The feature id for the '<em><b>Source Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATE_MEDIATOR__SOURCE_TEXT = EsbPackage.MEDIATOR__SOURCE_TEXT;

	/**
	 * The feature id for the '<em><b>Default Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATE_MEDIATOR__DEFAULT_NAMESPACE = EsbPackage.MEDIATOR__DEFAULT_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Additional Namespaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATE_MEDIATOR__ADDITIONAL_NAMESPACES = EsbPackage.MEDIATOR__ADDITIONAL_NAMESPACES;

	/**
	 * The feature id for the '<em><b>Current Esb Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATE_MEDIATOR__CURRENT_ESB_VERSION = EsbPackage.MEDIATOR__CURRENT_ESB_VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATE_MEDIATOR__COMMENT = EsbPackage.MEDIATOR__COMMENT;

	/**
	 * The feature id for the '<em><b>Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATE_MEDIATOR__DESCRIPTION = EsbPackage.MEDIATOR__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Source Xpath</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATE_MEDIATOR__SOURCE_XPATH = EsbPackage.MEDIATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>On Fail Branch</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATE_MEDIATOR__ON_FAIL_BRANCH = EsbPackage.MEDIATOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Features</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATE_MEDIATOR__FEATURES = EsbPackage.MEDIATOR_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Schemas</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATE_MEDIATOR__SCHEMAS = EsbPackage.MEDIATOR_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Resources</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATE_MEDIATOR__RESOURCES = EsbPackage.MEDIATOR_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Validate Mediator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATE_MEDIATOR_FEATURE_COUNT = EsbPackage.MEDIATOR_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.ValidateOnFailBranchImpl <em>Validate On Fail Branch</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.ValidateOnFailBranchImpl
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getValidateOnFailBranch()
	 * @generated
	 */
	int VALIDATE_ON_FAIL_BRANCH = 22;

	/**
	 * The feature id for the '<em><b>Object State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATE_ON_FAIL_BRANCH__OBJECT_STATE = EsbPackage.MEDIATOR_BRANCH__OBJECT_STATE;

	/**
	 * The feature id for the '<em><b>Source Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATE_ON_FAIL_BRANCH__SOURCE_TEXT = EsbPackage.MEDIATOR_BRANCH__SOURCE_TEXT;

	/**
	 * The feature id for the '<em><b>Default Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATE_ON_FAIL_BRANCH__DEFAULT_NAMESPACE = EsbPackage.MEDIATOR_BRANCH__DEFAULT_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Additional Namespaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATE_ON_FAIL_BRANCH__ADDITIONAL_NAMESPACES = EsbPackage.MEDIATOR_BRANCH__ADDITIONAL_NAMESPACES;

	/**
	 * The feature id for the '<em><b>Current Esb Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATE_ON_FAIL_BRANCH__CURRENT_ESB_VERSION = EsbPackage.MEDIATOR_BRANCH__CURRENT_ESB_VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATE_ON_FAIL_BRANCH__COMMENT = EsbPackage.MEDIATOR_BRANCH__COMMENT;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATE_ON_FAIL_BRANCH__CHILDREN = EsbPackage.MEDIATOR_BRANCH__CHILDREN;

	/**
	 * The number of structural features of the '<em>Validate On Fail Branch</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATE_ON_FAIL_BRANCH_FEATURE_COUNT = EsbPackage.MEDIATOR_BRANCH_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.ValidateFeatureImpl <em>Validate Feature</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.ValidateFeatureImpl
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getValidateFeature()
	 * @generated
	 */
	int VALIDATE_FEATURE = 23;

	/**
	 * The feature id for the '<em><b>Object State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATE_FEATURE__OBJECT_STATE = EsbPackage.ABSTRACT_BOOLEAN_FEATURE__OBJECT_STATE;

	/**
	 * The feature id for the '<em><b>Source Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATE_FEATURE__SOURCE_TEXT = EsbPackage.ABSTRACT_BOOLEAN_FEATURE__SOURCE_TEXT;

	/**
	 * The feature id for the '<em><b>Default Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATE_FEATURE__DEFAULT_NAMESPACE = EsbPackage.ABSTRACT_BOOLEAN_FEATURE__DEFAULT_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Additional Namespaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATE_FEATURE__ADDITIONAL_NAMESPACES = EsbPackage.ABSTRACT_BOOLEAN_FEATURE__ADDITIONAL_NAMESPACES;

	/**
	 * The feature id for the '<em><b>Current Esb Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATE_FEATURE__CURRENT_ESB_VERSION = EsbPackage.ABSTRACT_BOOLEAN_FEATURE__CURRENT_ESB_VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATE_FEATURE__COMMENT = EsbPackage.ABSTRACT_BOOLEAN_FEATURE__COMMENT;

	/**
	 * The feature id for the '<em><b>Feature Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATE_FEATURE__FEATURE_NAME = EsbPackage.ABSTRACT_BOOLEAN_FEATURE__FEATURE_NAME;

	/**
	 * The feature id for the '<em><b>Feature Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATE_FEATURE__FEATURE_ENABLED = EsbPackage.ABSTRACT_BOOLEAN_FEATURE__FEATURE_ENABLED;

	/**
	 * The number of structural features of the '<em>Validate Feature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATE_FEATURE_FEATURE_COUNT = EsbPackage.ABSTRACT_BOOLEAN_FEATURE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.ValidateSchemaImpl <em>Validate Schema</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.ValidateSchemaImpl
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getValidateSchema()
	 * @generated
	 */
	int VALIDATE_SCHEMA = 24;

	/**
	 * The feature id for the '<em><b>Object State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATE_SCHEMA__OBJECT_STATE = EsbPackage.MODEL_OBJECT__OBJECT_STATE;

	/**
	 * The feature id for the '<em><b>Source Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATE_SCHEMA__SOURCE_TEXT = EsbPackage.MODEL_OBJECT__SOURCE_TEXT;

	/**
	 * The feature id for the '<em><b>Default Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATE_SCHEMA__DEFAULT_NAMESPACE = EsbPackage.MODEL_OBJECT__DEFAULT_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Additional Namespaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATE_SCHEMA__ADDITIONAL_NAMESPACES = EsbPackage.MODEL_OBJECT__ADDITIONAL_NAMESPACES;

	/**
	 * The feature id for the '<em><b>Current Esb Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATE_SCHEMA__CURRENT_ESB_VERSION = EsbPackage.MODEL_OBJECT__CURRENT_ESB_VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATE_SCHEMA__COMMENT = EsbPackage.MODEL_OBJECT__COMMENT;

	/**
	 * The feature id for the '<em><b>Validate Static Schema Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATE_SCHEMA__VALIDATE_STATIC_SCHEMA_KEY = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Validate Dynamic Schema Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATE_SCHEMA__VALIDATE_DYNAMIC_SCHEMA_KEY = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Validate Schema Key Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATE_SCHEMA__VALIDATE_SCHEMA_KEY_TYPE = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Schema Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATE_SCHEMA__SCHEMA_KEY = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Validate Schema</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATE_SCHEMA_FEATURE_COUNT = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.ValidateResourceImpl <em>Validate Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.ValidateResourceImpl
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getValidateResource()
	 * @generated
	 */
	int VALIDATE_RESOURCE = 25;

	/**
	 * The feature id for the '<em><b>Object State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATE_RESOURCE__OBJECT_STATE = EsbPackage.ABSTRACT_LOCATION_KEY_RESOURCE__OBJECT_STATE;

	/**
	 * The feature id for the '<em><b>Source Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATE_RESOURCE__SOURCE_TEXT = EsbPackage.ABSTRACT_LOCATION_KEY_RESOURCE__SOURCE_TEXT;

	/**
	 * The feature id for the '<em><b>Default Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATE_RESOURCE__DEFAULT_NAMESPACE = EsbPackage.ABSTRACT_LOCATION_KEY_RESOURCE__DEFAULT_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Additional Namespaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATE_RESOURCE__ADDITIONAL_NAMESPACES = EsbPackage.ABSTRACT_LOCATION_KEY_RESOURCE__ADDITIONAL_NAMESPACES;

	/**
	 * The feature id for the '<em><b>Current Esb Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATE_RESOURCE__CURRENT_ESB_VERSION = EsbPackage.ABSTRACT_LOCATION_KEY_RESOURCE__CURRENT_ESB_VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATE_RESOURCE__COMMENT = EsbPackage.ABSTRACT_LOCATION_KEY_RESOURCE__COMMENT;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATE_RESOURCE__LOCATION = EsbPackage.ABSTRACT_LOCATION_KEY_RESOURCE__LOCATION;

	/**
	 * The feature id for the '<em><b>Key</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATE_RESOURCE__KEY = EsbPackage.ABSTRACT_LOCATION_KEY_RESOURCE__KEY;

	/**
	 * The number of structural features of the '<em>Validate Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATE_RESOURCE_FEATURE_COUNT = EsbPackage.ABSTRACT_LOCATION_KEY_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.ScriptMediatorImpl <em>Script Mediator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.ScriptMediatorImpl
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getScriptMediator()
	 * @generated
	 */
	int SCRIPT_MEDIATOR = 26;

	/**
	 * The feature id for the '<em><b>Object State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_MEDIATOR__OBJECT_STATE = EsbPackage.MEDIATOR__OBJECT_STATE;

	/**
	 * The feature id for the '<em><b>Source Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_MEDIATOR__SOURCE_TEXT = EsbPackage.MEDIATOR__SOURCE_TEXT;

	/**
	 * The feature id for the '<em><b>Default Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_MEDIATOR__DEFAULT_NAMESPACE = EsbPackage.MEDIATOR__DEFAULT_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Additional Namespaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_MEDIATOR__ADDITIONAL_NAMESPACES = EsbPackage.MEDIATOR__ADDITIONAL_NAMESPACES;

	/**
	 * The feature id for the '<em><b>Current Esb Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_MEDIATOR__CURRENT_ESB_VERSION = EsbPackage.MEDIATOR__CURRENT_ESB_VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_MEDIATOR__COMMENT = EsbPackage.MEDIATOR__COMMENT;

	/**
	 * The feature id for the '<em><b>Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_MEDIATOR__DESCRIPTION = EsbPackage.MEDIATOR__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Script Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_MEDIATOR__SCRIPT_TYPE = EsbPackage.MEDIATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Script Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_MEDIATOR__SCRIPT_LANGUAGE = EsbPackage.MEDIATOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Mediate Function</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_MEDIATOR__MEDIATE_FUNCTION = EsbPackage.MEDIATOR_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Script Key</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_MEDIATOR__SCRIPT_KEY = EsbPackage.MEDIATOR_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Script Body</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_MEDIATOR__SCRIPT_BODY = EsbPackage.MEDIATOR_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Script Mediator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_MEDIATOR_FEATURE_COUNT = EsbPackage.MEDIATOR_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.EnrichMediatorImpl <em>Enrich Mediator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.EnrichMediatorImpl
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getEnrichMediator()
	 * @generated
	 */
	int ENRICH_MEDIATOR = 27;

	/**
	 * The feature id for the '<em><b>Object State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENRICH_MEDIATOR__OBJECT_STATE = EsbPackage.MEDIATOR__OBJECT_STATE;

	/**
	 * The feature id for the '<em><b>Source Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENRICH_MEDIATOR__SOURCE_TEXT = EsbPackage.MEDIATOR__SOURCE_TEXT;

	/**
	 * The feature id for the '<em><b>Default Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENRICH_MEDIATOR__DEFAULT_NAMESPACE = EsbPackage.MEDIATOR__DEFAULT_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Additional Namespaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENRICH_MEDIATOR__ADDITIONAL_NAMESPACES = EsbPackage.MEDIATOR__ADDITIONAL_NAMESPACES;

	/**
	 * The feature id for the '<em><b>Current Esb Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENRICH_MEDIATOR__CURRENT_ESB_VERSION = EsbPackage.MEDIATOR__CURRENT_ESB_VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENRICH_MEDIATOR__COMMENT = EsbPackage.MEDIATOR__COMMENT;

	/**
	 * The feature id for the '<em><b>Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENRICH_MEDIATOR__DESCRIPTION = EsbPackage.MEDIATOR__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Clone Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENRICH_MEDIATOR__CLONE_SOURCE = EsbPackage.MEDIATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENRICH_MEDIATOR__SOURCE_TYPE = EsbPackage.MEDIATOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Source Xpath</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENRICH_MEDIATOR__SOURCE_XPATH = EsbPackage.MEDIATOR_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Source Property</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENRICH_MEDIATOR__SOURCE_PROPERTY = EsbPackage.MEDIATOR_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Source XML</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENRICH_MEDIATOR__SOURCE_XML = EsbPackage.MEDIATOR_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Target Action</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENRICH_MEDIATOR__TARGET_ACTION = EsbPackage.MEDIATOR_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Target Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENRICH_MEDIATOR__TARGET_TYPE = EsbPackage.MEDIATOR_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Target Xpath</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENRICH_MEDIATOR__TARGET_XPATH = EsbPackage.MEDIATOR_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Target Property</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENRICH_MEDIATOR__TARGET_PROPERTY = EsbPackage.MEDIATOR_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Inline Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENRICH_MEDIATOR__INLINE_TYPE = EsbPackage.MEDIATOR_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Inline Registry Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENRICH_MEDIATOR__INLINE_REGISTRY_KEY = EsbPackage.MEDIATOR_FEATURE_COUNT + 10;

	/**
	 * The number of structural features of the '<em>Enrich Mediator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENRICH_MEDIATOR_FEATURE_COUNT = EsbPackage.MEDIATOR_FEATURE_COUNT + 11;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.FaultMediatorImpl <em>Fault Mediator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.FaultMediatorImpl
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getFaultMediator()
	 * @generated
	 */
	int FAULT_MEDIATOR = 28;

	/**
	 * The feature id for the '<em><b>Object State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAULT_MEDIATOR__OBJECT_STATE = EsbPackage.MEDIATOR__OBJECT_STATE;

	/**
	 * The feature id for the '<em><b>Source Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAULT_MEDIATOR__SOURCE_TEXT = EsbPackage.MEDIATOR__SOURCE_TEXT;

	/**
	 * The feature id for the '<em><b>Default Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAULT_MEDIATOR__DEFAULT_NAMESPACE = EsbPackage.MEDIATOR__DEFAULT_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Additional Namespaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAULT_MEDIATOR__ADDITIONAL_NAMESPACES = EsbPackage.MEDIATOR__ADDITIONAL_NAMESPACES;

	/**
	 * The feature id for the '<em><b>Current Esb Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAULT_MEDIATOR__CURRENT_ESB_VERSION = EsbPackage.MEDIATOR__CURRENT_ESB_VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAULT_MEDIATOR__COMMENT = EsbPackage.MEDIATOR__COMMENT;

	/**
	 * The feature id for the '<em><b>Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAULT_MEDIATOR__DESCRIPTION = EsbPackage.MEDIATOR__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Soap Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAULT_MEDIATOR__SOAP_VERSION = EsbPackage.MEDIATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Fault Code Soap11</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAULT_MEDIATOR__FAULT_CODE_SOAP11 = EsbPackage.MEDIATOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Fault String Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAULT_MEDIATOR__FAULT_STRING_TYPE = EsbPackage.MEDIATOR_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Fault String Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAULT_MEDIATOR__FAULT_STRING_VALUE = EsbPackage.MEDIATOR_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Fault String Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAULT_MEDIATOR__FAULT_STRING_EXPRESSION = EsbPackage.MEDIATOR_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Fault Actor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAULT_MEDIATOR__FAULT_ACTOR = EsbPackage.MEDIATOR_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Fault Code Soap12</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAULT_MEDIATOR__FAULT_CODE_SOAP12 = EsbPackage.MEDIATOR_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Fault Reason Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAULT_MEDIATOR__FAULT_REASON_TYPE = EsbPackage.MEDIATOR_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Fault Reason Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAULT_MEDIATOR__FAULT_REASON_VALUE = EsbPackage.MEDIATOR_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Fault Reason Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAULT_MEDIATOR__FAULT_REASON_EXPRESSION = EsbPackage.MEDIATOR_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Role Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAULT_MEDIATOR__ROLE_NAME = EsbPackage.MEDIATOR_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Node Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAULT_MEDIATOR__NODE_NAME = EsbPackage.MEDIATOR_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Fault Detail Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAULT_MEDIATOR__FAULT_DETAIL_TYPE = EsbPackage.MEDIATOR_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Fault Detail Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAULT_MEDIATOR__FAULT_DETAIL_VALUE = EsbPackage.MEDIATOR_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Fault Detail Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAULT_MEDIATOR__FAULT_DETAIL_EXPRESSION = EsbPackage.MEDIATOR_FEATURE_COUNT + 14;

	/**
	 * The number of structural features of the '<em>Fault Mediator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAULT_MEDIATOR_FEATURE_COUNT = EsbPackage.MEDIATOR_FEATURE_COUNT + 15;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.AggregateMediatorImpl <em>Aggregate Mediator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.AggregateMediatorImpl
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getAggregateMediator()
	 * @generated
	 */
	int AGGREGATE_MEDIATOR = 29;

	/**
	 * The feature id for the '<em><b>Object State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATE_MEDIATOR__OBJECT_STATE = EsbPackage.MEDIATOR__OBJECT_STATE;

	/**
	 * The feature id for the '<em><b>Source Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATE_MEDIATOR__SOURCE_TEXT = EsbPackage.MEDIATOR__SOURCE_TEXT;

	/**
	 * The feature id for the '<em><b>Default Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATE_MEDIATOR__DEFAULT_NAMESPACE = EsbPackage.MEDIATOR__DEFAULT_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Additional Namespaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATE_MEDIATOR__ADDITIONAL_NAMESPACES = EsbPackage.MEDIATOR__ADDITIONAL_NAMESPACES;

	/**
	 * The feature id for the '<em><b>Current Esb Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATE_MEDIATOR__CURRENT_ESB_VERSION = EsbPackage.MEDIATOR__CURRENT_ESB_VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATE_MEDIATOR__COMMENT = EsbPackage.MEDIATOR__COMMENT;

	/**
	 * The feature id for the '<em><b>Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATE_MEDIATOR__DESCRIPTION = EsbPackage.MEDIATOR__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Aggregate ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATE_MEDIATOR__AGGREGATE_ID = EsbPackage.MEDIATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Correlation Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATE_MEDIATOR__CORRELATION_EXPRESSION = EsbPackage.MEDIATOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Completion Timeout</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATE_MEDIATOR__COMPLETION_TIMEOUT = EsbPackage.MEDIATOR_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Completion Min Messages</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATE_MEDIATOR__COMPLETION_MIN_MESSAGES = EsbPackage.MEDIATOR_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Completion Max Messages</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATE_MEDIATOR__COMPLETION_MAX_MESSAGES = EsbPackage.MEDIATOR_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>On Complete Branch</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATE_MEDIATOR__ON_COMPLETE_BRANCH = EsbPackage.MEDIATOR_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Aggregate Mediator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATE_MEDIATOR_FEATURE_COUNT = EsbPackage.MEDIATOR_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.AggregateOnCompleteBranchImpl <em>Aggregate On Complete Branch</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.AggregateOnCompleteBranchImpl
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getAggregateOnCompleteBranch()
	 * @generated
	 */
	int AGGREGATE_ON_COMPLETE_BRANCH = 30;

	/**
	 * The feature id for the '<em><b>Object State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATE_ON_COMPLETE_BRANCH__OBJECT_STATE = EsbPackage.MEDIATOR_BRANCH__OBJECT_STATE;

	/**
	 * The feature id for the '<em><b>Source Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATE_ON_COMPLETE_BRANCH__SOURCE_TEXT = EsbPackage.MEDIATOR_BRANCH__SOURCE_TEXT;

	/**
	 * The feature id for the '<em><b>Default Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATE_ON_COMPLETE_BRANCH__DEFAULT_NAMESPACE = EsbPackage.MEDIATOR_BRANCH__DEFAULT_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Additional Namespaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATE_ON_COMPLETE_BRANCH__ADDITIONAL_NAMESPACES = EsbPackage.MEDIATOR_BRANCH__ADDITIONAL_NAMESPACES;

	/**
	 * The feature id for the '<em><b>Current Esb Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATE_ON_COMPLETE_BRANCH__CURRENT_ESB_VERSION = EsbPackage.MEDIATOR_BRANCH__CURRENT_ESB_VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATE_ON_COMPLETE_BRANCH__COMMENT = EsbPackage.MEDIATOR_BRANCH__COMMENT;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATE_ON_COMPLETE_BRANCH__CHILDREN = EsbPackage.MEDIATOR_BRANCH__CHILDREN;

	/**
	 * The feature id for the '<em><b>Aggregation Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATE_ON_COMPLETE_BRANCH__AGGREGATION_EXPRESSION = EsbPackage.MEDIATOR_BRANCH_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Sequence Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATE_ON_COMPLETE_BRANCH__SEQUENCE_TYPE = EsbPackage.MEDIATOR_BRANCH_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Sequence Key</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATE_ON_COMPLETE_BRANCH__SEQUENCE_KEY = EsbPackage.MEDIATOR_BRANCH_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Aggregate On Complete Branch</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATE_ON_COMPLETE_BRANCH_FEATURE_COUNT = EsbPackage.MEDIATOR_BRANCH_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.RouterMediatorImpl <em>Router Mediator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.RouterMediatorImpl
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getRouterMediator()
	 * @generated
	 */
	int ROUTER_MEDIATOR = 31;

	/**
	 * The feature id for the '<em><b>Object State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTER_MEDIATOR__OBJECT_STATE = EsbPackage.MEDIATOR__OBJECT_STATE;

	/**
	 * The feature id for the '<em><b>Source Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTER_MEDIATOR__SOURCE_TEXT = EsbPackage.MEDIATOR__SOURCE_TEXT;

	/**
	 * The feature id for the '<em><b>Default Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTER_MEDIATOR__DEFAULT_NAMESPACE = EsbPackage.MEDIATOR__DEFAULT_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Additional Namespaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTER_MEDIATOR__ADDITIONAL_NAMESPACES = EsbPackage.MEDIATOR__ADDITIONAL_NAMESPACES;

	/**
	 * The feature id for the '<em><b>Current Esb Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTER_MEDIATOR__CURRENT_ESB_VERSION = EsbPackage.MEDIATOR__CURRENT_ESB_VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTER_MEDIATOR__COMMENT = EsbPackage.MEDIATOR__COMMENT;

	/**
	 * The feature id for the '<em><b>Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTER_MEDIATOR__DESCRIPTION = EsbPackage.MEDIATOR__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Continue After Routing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTER_MEDIATOR__CONTINUE_AFTER_ROUTING = EsbPackage.MEDIATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Routes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTER_MEDIATOR__ROUTES = EsbPackage.MEDIATOR_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Router Mediator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTER_MEDIATOR_FEATURE_COUNT = EsbPackage.MEDIATOR_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.RouterRouteImpl <em>Router Route</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.RouterRouteImpl
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getRouterRoute()
	 * @generated
	 */
	int ROUTER_ROUTE = 32;

	/**
	 * The feature id for the '<em><b>Object State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTER_ROUTE__OBJECT_STATE = EsbPackage.MODEL_OBJECT__OBJECT_STATE;

	/**
	 * The feature id for the '<em><b>Source Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTER_ROUTE__SOURCE_TEXT = EsbPackage.MODEL_OBJECT__SOURCE_TEXT;

	/**
	 * The feature id for the '<em><b>Default Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTER_ROUTE__DEFAULT_NAMESPACE = EsbPackage.MODEL_OBJECT__DEFAULT_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Additional Namespaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTER_ROUTE__ADDITIONAL_NAMESPACES = EsbPackage.MODEL_OBJECT__ADDITIONAL_NAMESPACES;

	/**
	 * The feature id for the '<em><b>Current Esb Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTER_ROUTE__CURRENT_ESB_VERSION = EsbPackage.MODEL_OBJECT__CURRENT_ESB_VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTER_ROUTE__COMMENT = EsbPackage.MODEL_OBJECT__COMMENT;

	/**
	 * The feature id for the '<em><b>Break After Route</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTER_ROUTE__BREAK_AFTER_ROUTE = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Route Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTER_ROUTE__ROUTE_EXPRESSION = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Route Pattern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTER_ROUTE__ROUTE_PATTERN = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTER_ROUTE__TARGET = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Router Route</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTER_ROUTE_FEATURE_COUNT = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.RouteTargetImpl <em>Route Target</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.RouteTargetImpl
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getRouteTarget()
	 * @generated
	 */
	int ROUTE_TARGET = 33;

	/**
	 * The feature id for the '<em><b>Object State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTE_TARGET__OBJECT_STATE = EsbPackage.ABSTRACT_COMMON_TARGET__OBJECT_STATE;

	/**
	 * The feature id for the '<em><b>Source Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTE_TARGET__SOURCE_TEXT = EsbPackage.ABSTRACT_COMMON_TARGET__SOURCE_TEXT;

	/**
	 * The feature id for the '<em><b>Default Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTE_TARGET__DEFAULT_NAMESPACE = EsbPackage.ABSTRACT_COMMON_TARGET__DEFAULT_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Additional Namespaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTE_TARGET__ADDITIONAL_NAMESPACES = EsbPackage.ABSTRACT_COMMON_TARGET__ADDITIONAL_NAMESPACES;

	/**
	 * The feature id for the '<em><b>Current Esb Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTE_TARGET__CURRENT_ESB_VERSION = EsbPackage.ABSTRACT_COMMON_TARGET__CURRENT_ESB_VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTE_TARGET__COMMENT = EsbPackage.ABSTRACT_COMMON_TARGET__COMMENT;

	/**
	 * The feature id for the '<em><b>Sequence Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTE_TARGET__SEQUENCE_TYPE = EsbPackage.ABSTRACT_COMMON_TARGET__SEQUENCE_TYPE;

	/**
	 * The feature id for the '<em><b>Sequence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTE_TARGET__SEQUENCE = EsbPackage.ABSTRACT_COMMON_TARGET__SEQUENCE;

	/**
	 * The feature id for the '<em><b>Sequence Key</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTE_TARGET__SEQUENCE_KEY = EsbPackage.ABSTRACT_COMMON_TARGET__SEQUENCE_KEY;

	/**
	 * The feature id for the '<em><b>Endpoint Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTE_TARGET__ENDPOINT_TYPE = EsbPackage.ABSTRACT_COMMON_TARGET__ENDPOINT_TYPE;

	/**
	 * The feature id for the '<em><b>Endpoint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTE_TARGET__ENDPOINT = EsbPackage.ABSTRACT_COMMON_TARGET__ENDPOINT;

	/**
	 * The feature id for the '<em><b>Endpoint Key</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTE_TARGET__ENDPOINT_KEY = EsbPackage.ABSTRACT_COMMON_TARGET__ENDPOINT_KEY;

	/**
	 * The number of structural features of the '<em>Route Target</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTE_TARGET_FEATURE_COUNT = EsbPackage.ABSTRACT_COMMON_TARGET_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.CloneMediatorImpl <em>Clone Mediator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.CloneMediatorImpl
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getCloneMediator()
	 * @generated
	 */
	int CLONE_MEDIATOR = 34;

	/**
	 * The feature id for the '<em><b>Object State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLONE_MEDIATOR__OBJECT_STATE = EsbPackage.MEDIATOR__OBJECT_STATE;

	/**
	 * The feature id for the '<em><b>Source Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLONE_MEDIATOR__SOURCE_TEXT = EsbPackage.MEDIATOR__SOURCE_TEXT;

	/**
	 * The feature id for the '<em><b>Default Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLONE_MEDIATOR__DEFAULT_NAMESPACE = EsbPackage.MEDIATOR__DEFAULT_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Additional Namespaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLONE_MEDIATOR__ADDITIONAL_NAMESPACES = EsbPackage.MEDIATOR__ADDITIONAL_NAMESPACES;

	/**
	 * The feature id for the '<em><b>Current Esb Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLONE_MEDIATOR__CURRENT_ESB_VERSION = EsbPackage.MEDIATOR__CURRENT_ESB_VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLONE_MEDIATOR__COMMENT = EsbPackage.MEDIATOR__COMMENT;

	/**
	 * The feature id for the '<em><b>Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLONE_MEDIATOR__DESCRIPTION = EsbPackage.MEDIATOR__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Clone ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLONE_MEDIATOR__CLONE_ID = EsbPackage.MEDIATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Sequential Mediation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLONE_MEDIATOR__SEQUENTIAL_MEDIATION = EsbPackage.MEDIATOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Continue Parent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLONE_MEDIATOR__CONTINUE_PARENT = EsbPackage.MEDIATOR_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Targets</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLONE_MEDIATOR__TARGETS = EsbPackage.MEDIATOR_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Clone Mediator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLONE_MEDIATOR_FEATURE_COUNT = EsbPackage.MEDIATOR_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.CloneTargetImpl <em>Clone Target</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.CloneTargetImpl
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getCloneTarget()
	 * @generated
	 */
	int CLONE_TARGET = 35;

	/**
	 * The feature id for the '<em><b>Object State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLONE_TARGET__OBJECT_STATE = EsbPackage.ABSTRACT_COMMON_TARGET__OBJECT_STATE;

	/**
	 * The feature id for the '<em><b>Source Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLONE_TARGET__SOURCE_TEXT = EsbPackage.ABSTRACT_COMMON_TARGET__SOURCE_TEXT;

	/**
	 * The feature id for the '<em><b>Default Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLONE_TARGET__DEFAULT_NAMESPACE = EsbPackage.ABSTRACT_COMMON_TARGET__DEFAULT_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Additional Namespaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLONE_TARGET__ADDITIONAL_NAMESPACES = EsbPackage.ABSTRACT_COMMON_TARGET__ADDITIONAL_NAMESPACES;

	/**
	 * The feature id for the '<em><b>Current Esb Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLONE_TARGET__CURRENT_ESB_VERSION = EsbPackage.ABSTRACT_COMMON_TARGET__CURRENT_ESB_VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLONE_TARGET__COMMENT = EsbPackage.ABSTRACT_COMMON_TARGET__COMMENT;

	/**
	 * The feature id for the '<em><b>Sequence Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLONE_TARGET__SEQUENCE_TYPE = EsbPackage.ABSTRACT_COMMON_TARGET__SEQUENCE_TYPE;

	/**
	 * The feature id for the '<em><b>Sequence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLONE_TARGET__SEQUENCE = EsbPackage.ABSTRACT_COMMON_TARGET__SEQUENCE;

	/**
	 * The feature id for the '<em><b>Sequence Key</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLONE_TARGET__SEQUENCE_KEY = EsbPackage.ABSTRACT_COMMON_TARGET__SEQUENCE_KEY;

	/**
	 * The feature id for the '<em><b>Endpoint Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLONE_TARGET__ENDPOINT_TYPE = EsbPackage.ABSTRACT_COMMON_TARGET__ENDPOINT_TYPE;

	/**
	 * The feature id for the '<em><b>Endpoint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLONE_TARGET__ENDPOINT = EsbPackage.ABSTRACT_COMMON_TARGET__ENDPOINT;

	/**
	 * The feature id for the '<em><b>Endpoint Key</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLONE_TARGET__ENDPOINT_KEY = EsbPackage.ABSTRACT_COMMON_TARGET__ENDPOINT_KEY;

	/**
	 * The feature id for the '<em><b>Soap Action</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLONE_TARGET__SOAP_ACTION = EsbPackage.ABSTRACT_COMMON_TARGET_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>To Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLONE_TARGET__TO_ADDRESS = EsbPackage.ABSTRACT_COMMON_TARGET_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Clone Target</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLONE_TARGET_FEATURE_COUNT = EsbPackage.ABSTRACT_COMMON_TARGET_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.IterateMediatorImpl <em>Iterate Mediator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.IterateMediatorImpl
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getIterateMediator()
	 * @generated
	 */
	int ITERATE_MEDIATOR = 36;

	/**
	 * The feature id for the '<em><b>Object State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_MEDIATOR__OBJECT_STATE = EsbPackage.MEDIATOR__OBJECT_STATE;

	/**
	 * The feature id for the '<em><b>Source Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_MEDIATOR__SOURCE_TEXT = EsbPackage.MEDIATOR__SOURCE_TEXT;

	/**
	 * The feature id for the '<em><b>Default Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_MEDIATOR__DEFAULT_NAMESPACE = EsbPackage.MEDIATOR__DEFAULT_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Additional Namespaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_MEDIATOR__ADDITIONAL_NAMESPACES = EsbPackage.MEDIATOR__ADDITIONAL_NAMESPACES;

	/**
	 * The feature id for the '<em><b>Current Esb Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_MEDIATOR__CURRENT_ESB_VERSION = EsbPackage.MEDIATOR__CURRENT_ESB_VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_MEDIATOR__COMMENT = EsbPackage.MEDIATOR__COMMENT;

	/**
	 * The feature id for the '<em><b>Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_MEDIATOR__DESCRIPTION = EsbPackage.MEDIATOR__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Iterate ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_MEDIATOR__ITERATE_ID = EsbPackage.MEDIATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Sequential Mediation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_MEDIATOR__SEQUENTIAL_MEDIATION = EsbPackage.MEDIATOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Continue Parent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_MEDIATOR__CONTINUE_PARENT = EsbPackage.MEDIATOR_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Preserve Payload</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_MEDIATOR__PRESERVE_PAYLOAD = EsbPackage.MEDIATOR_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Iterate Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_MEDIATOR__ITERATE_EXPRESSION = EsbPackage.MEDIATOR_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Attach Path</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_MEDIATOR__ATTACH_PATH = EsbPackage.MEDIATOR_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_MEDIATOR__TARGET = EsbPackage.MEDIATOR_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Iterate Mediator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_MEDIATOR_FEATURE_COUNT = EsbPackage.MEDIATOR_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.IterateTargetImpl <em>Iterate Target</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.IterateTargetImpl
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getIterateTarget()
	 * @generated
	 */
	int ITERATE_TARGET = 37;

	/**
	 * The feature id for the '<em><b>Object State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_TARGET__OBJECT_STATE = EsbPackage.ABSTRACT_COMMON_TARGET__OBJECT_STATE;

	/**
	 * The feature id for the '<em><b>Source Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_TARGET__SOURCE_TEXT = EsbPackage.ABSTRACT_COMMON_TARGET__SOURCE_TEXT;

	/**
	 * The feature id for the '<em><b>Default Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_TARGET__DEFAULT_NAMESPACE = EsbPackage.ABSTRACT_COMMON_TARGET__DEFAULT_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Additional Namespaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_TARGET__ADDITIONAL_NAMESPACES = EsbPackage.ABSTRACT_COMMON_TARGET__ADDITIONAL_NAMESPACES;

	/**
	 * The feature id for the '<em><b>Current Esb Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_TARGET__CURRENT_ESB_VERSION = EsbPackage.ABSTRACT_COMMON_TARGET__CURRENT_ESB_VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_TARGET__COMMENT = EsbPackage.ABSTRACT_COMMON_TARGET__COMMENT;

	/**
	 * The feature id for the '<em><b>Sequence Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_TARGET__SEQUENCE_TYPE = EsbPackage.ABSTRACT_COMMON_TARGET__SEQUENCE_TYPE;

	/**
	 * The feature id for the '<em><b>Sequence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_TARGET__SEQUENCE = EsbPackage.ABSTRACT_COMMON_TARGET__SEQUENCE;

	/**
	 * The feature id for the '<em><b>Sequence Key</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_TARGET__SEQUENCE_KEY = EsbPackage.ABSTRACT_COMMON_TARGET__SEQUENCE_KEY;

	/**
	 * The feature id for the '<em><b>Endpoint Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_TARGET__ENDPOINT_TYPE = EsbPackage.ABSTRACT_COMMON_TARGET__ENDPOINT_TYPE;

	/**
	 * The feature id for the '<em><b>Endpoint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_TARGET__ENDPOINT = EsbPackage.ABSTRACT_COMMON_TARGET__ENDPOINT;

	/**
	 * The feature id for the '<em><b>Endpoint Key</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_TARGET__ENDPOINT_KEY = EsbPackage.ABSTRACT_COMMON_TARGET__ENDPOINT_KEY;

	/**
	 * The feature id for the '<em><b>Soap Action</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_TARGET__SOAP_ACTION = EsbPackage.ABSTRACT_COMMON_TARGET_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>To Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_TARGET__TO_ADDRESS = EsbPackage.ABSTRACT_COMMON_TARGET_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Iterate Target</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_TARGET_FEATURE_COUNT = EsbPackage.ABSTRACT_COMMON_TARGET_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.CacheMediatorImpl <em>Cache Mediator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.CacheMediatorImpl
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getCacheMediator()
	 * @generated
	 */
	int CACHE_MEDIATOR = 38;

	/**
	 * The feature id for the '<em><b>Object State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CACHE_MEDIATOR__OBJECT_STATE = EsbPackage.MEDIATOR__OBJECT_STATE;

	/**
	 * The feature id for the '<em><b>Source Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CACHE_MEDIATOR__SOURCE_TEXT = EsbPackage.MEDIATOR__SOURCE_TEXT;

	/**
	 * The feature id for the '<em><b>Default Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CACHE_MEDIATOR__DEFAULT_NAMESPACE = EsbPackage.MEDIATOR__DEFAULT_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Additional Namespaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CACHE_MEDIATOR__ADDITIONAL_NAMESPACES = EsbPackage.MEDIATOR__ADDITIONAL_NAMESPACES;

	/**
	 * The feature id for the '<em><b>Current Esb Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CACHE_MEDIATOR__CURRENT_ESB_VERSION = EsbPackage.MEDIATOR__CURRENT_ESB_VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CACHE_MEDIATOR__COMMENT = EsbPackage.MEDIATOR__COMMENT;

	/**
	 * The feature id for the '<em><b>Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CACHE_MEDIATOR__DESCRIPTION = EsbPackage.MEDIATOR__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Cache Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CACHE_MEDIATOR__CACHE_ID = EsbPackage.MEDIATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Cache Scope</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CACHE_MEDIATOR__CACHE_SCOPE = EsbPackage.MEDIATOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Cache Action</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CACHE_MEDIATOR__CACHE_ACTION = EsbPackage.MEDIATOR_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Hash Generator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CACHE_MEDIATOR__HASH_GENERATOR = EsbPackage.MEDIATOR_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Cache Timeout</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CACHE_MEDIATOR__CACHE_TIMEOUT = EsbPackage.MEDIATOR_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Max Message Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CACHE_MEDIATOR__MAX_MESSAGE_SIZE = EsbPackage.MEDIATOR_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Implementation Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CACHE_MEDIATOR__IMPLEMENTATION_TYPE = EsbPackage.MEDIATOR_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Max Entry Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CACHE_MEDIATOR__MAX_ENTRY_COUNT = EsbPackage.MEDIATOR_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>On Hit Branch</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CACHE_MEDIATOR__ON_HIT_BRANCH = EsbPackage.MEDIATOR_FEATURE_COUNT + 8;

	/**
	 * The number of structural features of the '<em>Cache Mediator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CACHE_MEDIATOR_FEATURE_COUNT = EsbPackage.MEDIATOR_FEATURE_COUNT + 9;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.CacheOnHitBranchImpl <em>Cache On Hit Branch</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.CacheOnHitBranchImpl
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getCacheOnHitBranch()
	 * @generated
	 */
	int CACHE_ON_HIT_BRANCH = 39;

	/**
	 * The feature id for the '<em><b>Object State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CACHE_ON_HIT_BRANCH__OBJECT_STATE = EsbPackage.MEDIATOR_BRANCH__OBJECT_STATE;

	/**
	 * The feature id for the '<em><b>Source Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CACHE_ON_HIT_BRANCH__SOURCE_TEXT = EsbPackage.MEDIATOR_BRANCH__SOURCE_TEXT;

	/**
	 * The feature id for the '<em><b>Default Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CACHE_ON_HIT_BRANCH__DEFAULT_NAMESPACE = EsbPackage.MEDIATOR_BRANCH__DEFAULT_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Additional Namespaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CACHE_ON_HIT_BRANCH__ADDITIONAL_NAMESPACES = EsbPackage.MEDIATOR_BRANCH__ADDITIONAL_NAMESPACES;

	/**
	 * The feature id for the '<em><b>Current Esb Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CACHE_ON_HIT_BRANCH__CURRENT_ESB_VERSION = EsbPackage.MEDIATOR_BRANCH__CURRENT_ESB_VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CACHE_ON_HIT_BRANCH__COMMENT = EsbPackage.MEDIATOR_BRANCH__COMMENT;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CACHE_ON_HIT_BRANCH__CHILDREN = EsbPackage.MEDIATOR_BRANCH__CHILDREN;

	/**
	 * The feature id for the '<em><b>Sequence Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CACHE_ON_HIT_BRANCH__SEQUENCE_TYPE = EsbPackage.MEDIATOR_BRANCH_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Sequence Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CACHE_ON_HIT_BRANCH__SEQUENCE_KEY = EsbPackage.MEDIATOR_BRANCH_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Cache On Hit Branch</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CACHE_ON_HIT_BRANCH_FEATURE_COUNT = EsbPackage.MEDIATOR_BRANCH_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.XSLTMediatorImpl <em>XSLT Mediator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.XSLTMediatorImpl
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getXSLTMediator()
	 * @generated
	 */
	int XSLT_MEDIATOR = 40;

	/**
	 * The feature id for the '<em><b>Object State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XSLT_MEDIATOR__OBJECT_STATE = EsbPackage.MEDIATOR__OBJECT_STATE;

	/**
	 * The feature id for the '<em><b>Source Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XSLT_MEDIATOR__SOURCE_TEXT = EsbPackage.MEDIATOR__SOURCE_TEXT;

	/**
	 * The feature id for the '<em><b>Default Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XSLT_MEDIATOR__DEFAULT_NAMESPACE = EsbPackage.MEDIATOR__DEFAULT_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Additional Namespaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XSLT_MEDIATOR__ADDITIONAL_NAMESPACES = EsbPackage.MEDIATOR__ADDITIONAL_NAMESPACES;

	/**
	 * The feature id for the '<em><b>Current Esb Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XSLT_MEDIATOR__CURRENT_ESB_VERSION = EsbPackage.MEDIATOR__CURRENT_ESB_VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XSLT_MEDIATOR__COMMENT = EsbPackage.MEDIATOR__COMMENT;

	/**
	 * The feature id for the '<em><b>Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XSLT_MEDIATOR__DESCRIPTION = EsbPackage.MEDIATOR__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XSLT_MEDIATOR__PROPERTIES = EsbPackage.MEDIATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Features</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XSLT_MEDIATOR__FEATURES = EsbPackage.MEDIATOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Resources</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XSLT_MEDIATOR__RESOURCES = EsbPackage.MEDIATOR_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Xslt Schema Key Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XSLT_MEDIATOR__XSLT_SCHEMA_KEY_TYPE = EsbPackage.MEDIATOR_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Xslt Static Schema Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XSLT_MEDIATOR__XSLT_STATIC_SCHEMA_KEY = EsbPackage.MEDIATOR_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Xslt Dynamic Schema Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XSLT_MEDIATOR__XSLT_DYNAMIC_SCHEMA_KEY = EsbPackage.MEDIATOR_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Source XPath</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XSLT_MEDIATOR__SOURCE_XPATH = EsbPackage.MEDIATOR_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Xslt Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XSLT_MEDIATOR__XSLT_KEY = EsbPackage.MEDIATOR_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>XSLT Mediator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XSLT_MEDIATOR_FEATURE_COUNT = EsbPackage.MEDIATOR_FEATURE_COUNT + 8;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.XSLTPropertyImpl <em>XSLT Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.XSLTPropertyImpl
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getXSLTProperty()
	 * @generated
	 */
	int XSLT_PROPERTY = 41;

	/**
	 * The feature id for the '<em><b>Object State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XSLT_PROPERTY__OBJECT_STATE = EsbPackage.ABSTRACT_NAME_VALUE_EXPRESSION_PROPERTY__OBJECT_STATE;

	/**
	 * The feature id for the '<em><b>Source Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XSLT_PROPERTY__SOURCE_TEXT = EsbPackage.ABSTRACT_NAME_VALUE_EXPRESSION_PROPERTY__SOURCE_TEXT;

	/**
	 * The feature id for the '<em><b>Default Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XSLT_PROPERTY__DEFAULT_NAMESPACE = EsbPackage.ABSTRACT_NAME_VALUE_EXPRESSION_PROPERTY__DEFAULT_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Additional Namespaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XSLT_PROPERTY__ADDITIONAL_NAMESPACES = EsbPackage.ABSTRACT_NAME_VALUE_EXPRESSION_PROPERTY__ADDITIONAL_NAMESPACES;

	/**
	 * The feature id for the '<em><b>Current Esb Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XSLT_PROPERTY__CURRENT_ESB_VERSION = EsbPackage.ABSTRACT_NAME_VALUE_EXPRESSION_PROPERTY__CURRENT_ESB_VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XSLT_PROPERTY__COMMENT = EsbPackage.ABSTRACT_NAME_VALUE_EXPRESSION_PROPERTY__COMMENT;

	/**
	 * The feature id for the '<em><b>Property Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XSLT_PROPERTY__PROPERTY_NAME = EsbPackage.ABSTRACT_NAME_VALUE_EXPRESSION_PROPERTY__PROPERTY_NAME;

	/**
	 * The feature id for the '<em><b>Property Value Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XSLT_PROPERTY__PROPERTY_VALUE_TYPE = EsbPackage.ABSTRACT_NAME_VALUE_EXPRESSION_PROPERTY__PROPERTY_VALUE_TYPE;

	/**
	 * The feature id for the '<em><b>Property Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XSLT_PROPERTY__PROPERTY_VALUE = EsbPackage.ABSTRACT_NAME_VALUE_EXPRESSION_PROPERTY__PROPERTY_VALUE;

	/**
	 * The feature id for the '<em><b>Property Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XSLT_PROPERTY__PROPERTY_EXPRESSION = EsbPackage.ABSTRACT_NAME_VALUE_EXPRESSION_PROPERTY__PROPERTY_EXPRESSION;

	/**
	 * The number of structural features of the '<em>XSLT Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XSLT_PROPERTY_FEATURE_COUNT = EsbPackage.ABSTRACT_NAME_VALUE_EXPRESSION_PROPERTY_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.XSLTFeatureImpl <em>XSLT Feature</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.XSLTFeatureImpl
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getXSLTFeature()
	 * @generated
	 */
	int XSLT_FEATURE = 42;

	/**
	 * The feature id for the '<em><b>Object State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XSLT_FEATURE__OBJECT_STATE = EsbPackage.ABSTRACT_BOOLEAN_FEATURE__OBJECT_STATE;

	/**
	 * The feature id for the '<em><b>Source Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XSLT_FEATURE__SOURCE_TEXT = EsbPackage.ABSTRACT_BOOLEAN_FEATURE__SOURCE_TEXT;

	/**
	 * The feature id for the '<em><b>Default Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XSLT_FEATURE__DEFAULT_NAMESPACE = EsbPackage.ABSTRACT_BOOLEAN_FEATURE__DEFAULT_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Additional Namespaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XSLT_FEATURE__ADDITIONAL_NAMESPACES = EsbPackage.ABSTRACT_BOOLEAN_FEATURE__ADDITIONAL_NAMESPACES;

	/**
	 * The feature id for the '<em><b>Current Esb Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XSLT_FEATURE__CURRENT_ESB_VERSION = EsbPackage.ABSTRACT_BOOLEAN_FEATURE__CURRENT_ESB_VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XSLT_FEATURE__COMMENT = EsbPackage.ABSTRACT_BOOLEAN_FEATURE__COMMENT;

	/**
	 * The feature id for the '<em><b>Feature Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XSLT_FEATURE__FEATURE_NAME = EsbPackage.ABSTRACT_BOOLEAN_FEATURE__FEATURE_NAME;

	/**
	 * The feature id for the '<em><b>Feature Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XSLT_FEATURE__FEATURE_ENABLED = EsbPackage.ABSTRACT_BOOLEAN_FEATURE__FEATURE_ENABLED;

	/**
	 * The number of structural features of the '<em>XSLT Feature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XSLT_FEATURE_FEATURE_COUNT = EsbPackage.ABSTRACT_BOOLEAN_FEATURE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.XSLTResourceImpl <em>XSLT Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.XSLTResourceImpl
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getXSLTResource()
	 * @generated
	 */
	int XSLT_RESOURCE = 43;

	/**
	 * The feature id for the '<em><b>Object State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XSLT_RESOURCE__OBJECT_STATE = EsbPackage.ABSTRACT_LOCATION_KEY_RESOURCE__OBJECT_STATE;

	/**
	 * The feature id for the '<em><b>Source Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XSLT_RESOURCE__SOURCE_TEXT = EsbPackage.ABSTRACT_LOCATION_KEY_RESOURCE__SOURCE_TEXT;

	/**
	 * The feature id for the '<em><b>Default Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XSLT_RESOURCE__DEFAULT_NAMESPACE = EsbPackage.ABSTRACT_LOCATION_KEY_RESOURCE__DEFAULT_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Additional Namespaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XSLT_RESOURCE__ADDITIONAL_NAMESPACES = EsbPackage.ABSTRACT_LOCATION_KEY_RESOURCE__ADDITIONAL_NAMESPACES;

	/**
	 * The feature id for the '<em><b>Current Esb Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XSLT_RESOURCE__CURRENT_ESB_VERSION = EsbPackage.ABSTRACT_LOCATION_KEY_RESOURCE__CURRENT_ESB_VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XSLT_RESOURCE__COMMENT = EsbPackage.ABSTRACT_LOCATION_KEY_RESOURCE__COMMENT;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XSLT_RESOURCE__LOCATION = EsbPackage.ABSTRACT_LOCATION_KEY_RESOURCE__LOCATION;

	/**
	 * The feature id for the '<em><b>Key</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XSLT_RESOURCE__KEY = EsbPackage.ABSTRACT_LOCATION_KEY_RESOURCE__KEY;

	/**
	 * The number of structural features of the '<em>XSLT Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XSLT_RESOURCE_FEATURE_COUNT = EsbPackage.ABSTRACT_LOCATION_KEY_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.XQueryMediatorImpl <em>XQuery Mediator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.XQueryMediatorImpl
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getXQueryMediator()
	 * @generated
	 */
	int XQUERY_MEDIATOR = 44;

	/**
	 * The feature id for the '<em><b>Object State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XQUERY_MEDIATOR__OBJECT_STATE = EsbPackage.MEDIATOR__OBJECT_STATE;

	/**
	 * The feature id for the '<em><b>Source Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XQUERY_MEDIATOR__SOURCE_TEXT = EsbPackage.MEDIATOR__SOURCE_TEXT;

	/**
	 * The feature id for the '<em><b>Default Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XQUERY_MEDIATOR__DEFAULT_NAMESPACE = EsbPackage.MEDIATOR__DEFAULT_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Additional Namespaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XQUERY_MEDIATOR__ADDITIONAL_NAMESPACES = EsbPackage.MEDIATOR__ADDITIONAL_NAMESPACES;

	/**
	 * The feature id for the '<em><b>Current Esb Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XQUERY_MEDIATOR__CURRENT_ESB_VERSION = EsbPackage.MEDIATOR__CURRENT_ESB_VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XQUERY_MEDIATOR__COMMENT = EsbPackage.MEDIATOR__COMMENT;

	/**
	 * The feature id for the '<em><b>Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XQUERY_MEDIATOR__DESCRIPTION = EsbPackage.MEDIATOR__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Variables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XQUERY_MEDIATOR__VARIABLES = EsbPackage.MEDIATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target XPath</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XQUERY_MEDIATOR__TARGET_XPATH = EsbPackage.MEDIATOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Script Key Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XQUERY_MEDIATOR__SCRIPT_KEY_TYPE = EsbPackage.MEDIATOR_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Static Script Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XQUERY_MEDIATOR__STATIC_SCRIPT_KEY = EsbPackage.MEDIATOR_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Dynamic Script Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XQUERY_MEDIATOR__DYNAMIC_SCRIPT_KEY = EsbPackage.MEDIATOR_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Query Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XQUERY_MEDIATOR__QUERY_KEY = EsbPackage.MEDIATOR_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>XQuery Mediator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XQUERY_MEDIATOR_FEATURE_COUNT = EsbPackage.MEDIATOR_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.XQueryVariableImpl <em>XQuery Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.XQueryVariableImpl
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getXQueryVariable()
	 * @generated
	 */
	int XQUERY_VARIABLE = 45;

	/**
	 * The feature id for the '<em><b>Object State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XQUERY_VARIABLE__OBJECT_STATE = EsbPackage.MODEL_OBJECT__OBJECT_STATE;

	/**
	 * The feature id for the '<em><b>Source Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XQUERY_VARIABLE__SOURCE_TEXT = EsbPackage.MODEL_OBJECT__SOURCE_TEXT;

	/**
	 * The feature id for the '<em><b>Default Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XQUERY_VARIABLE__DEFAULT_NAMESPACE = EsbPackage.MODEL_OBJECT__DEFAULT_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Additional Namespaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XQUERY_VARIABLE__ADDITIONAL_NAMESPACES = EsbPackage.MODEL_OBJECT__ADDITIONAL_NAMESPACES;

	/**
	 * The feature id for the '<em><b>Current Esb Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XQUERY_VARIABLE__CURRENT_ESB_VERSION = EsbPackage.MODEL_OBJECT__CURRENT_ESB_VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XQUERY_VARIABLE__COMMENT = EsbPackage.MODEL_OBJECT__COMMENT;

	/**
	 * The feature id for the '<em><b>Variable Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XQUERY_VARIABLE__VARIABLE_NAME = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Variable Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XQUERY_VARIABLE__VARIABLE_TYPE = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Value Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XQUERY_VARIABLE__VALUE_TYPE = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Value Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XQUERY_VARIABLE__VALUE_LITERAL = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Value Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XQUERY_VARIABLE__VALUE_EXPRESSION = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Value Key</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XQUERY_VARIABLE__VALUE_KEY = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>XQuery Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XQUERY_VARIABLE_FEATURE_COUNT = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.CalloutMediatorImpl <em>Callout Mediator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.CalloutMediatorImpl
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getCalloutMediator()
	 * @generated
	 */
	int CALLOUT_MEDIATOR = 46;

	/**
	 * The feature id for the '<em><b>Object State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALLOUT_MEDIATOR__OBJECT_STATE = EsbPackage.MEDIATOR__OBJECT_STATE;

	/**
	 * The feature id for the '<em><b>Source Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALLOUT_MEDIATOR__SOURCE_TEXT = EsbPackage.MEDIATOR__SOURCE_TEXT;

	/**
	 * The feature id for the '<em><b>Default Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALLOUT_MEDIATOR__DEFAULT_NAMESPACE = EsbPackage.MEDIATOR__DEFAULT_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Additional Namespaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALLOUT_MEDIATOR__ADDITIONAL_NAMESPACES = EsbPackage.MEDIATOR__ADDITIONAL_NAMESPACES;

	/**
	 * The feature id for the '<em><b>Current Esb Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALLOUT_MEDIATOR__CURRENT_ESB_VERSION = EsbPackage.MEDIATOR__CURRENT_ESB_VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALLOUT_MEDIATOR__COMMENT = EsbPackage.MEDIATOR__COMMENT;

	/**
	 * The feature id for the '<em><b>Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALLOUT_MEDIATOR__DESCRIPTION = EsbPackage.MEDIATOR__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Service URL</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALLOUT_MEDIATOR__SERVICE_URL = EsbPackage.MEDIATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Soap Action</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALLOUT_MEDIATOR__SOAP_ACTION = EsbPackage.MEDIATOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Path To Axis2xml</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALLOUT_MEDIATOR__PATH_TO_AXIS2XML = EsbPackage.MEDIATOR_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Path To Axis2 Repository</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALLOUT_MEDIATOR__PATH_TO_AXIS2_REPOSITORY = EsbPackage.MEDIATOR_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Payload Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALLOUT_MEDIATOR__PAYLOAD_TYPE = EsbPackage.MEDIATOR_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Payload Message Xpath</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALLOUT_MEDIATOR__PAYLOAD_MESSAGE_XPATH = EsbPackage.MEDIATOR_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Payload Registry Key</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALLOUT_MEDIATOR__PAYLOAD_REGISTRY_KEY = EsbPackage.MEDIATOR_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Result Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALLOUT_MEDIATOR__RESULT_TYPE = EsbPackage.MEDIATOR_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Result Message Xpath</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALLOUT_MEDIATOR__RESULT_MESSAGE_XPATH = EsbPackage.MEDIATOR_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Result Context Property</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALLOUT_MEDIATOR__RESULT_CONTEXT_PROPERTY = EsbPackage.MEDIATOR_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Pass Headers</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALLOUT_MEDIATOR__PASS_HEADERS = EsbPackage.MEDIATOR_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Use Server Config</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALLOUT_MEDIATOR__USE_SERVER_CONFIG = EsbPackage.MEDIATOR_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Endpoint Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALLOUT_MEDIATOR__ENDPOINT_TYPE = EsbPackage.MEDIATOR_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Endpoint Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALLOUT_MEDIATOR__ENDPOINT_KEY = EsbPackage.MEDIATOR_FEATURE_COUNT + 13;

	/**
	 * The number of structural features of the '<em>Callout Mediator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALLOUT_MEDIATOR_FEATURE_COUNT = EsbPackage.MEDIATOR_FEATURE_COUNT + 14;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.RMSequenceMediatorImpl <em>RM Sequence Mediator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.RMSequenceMediatorImpl
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getRMSequenceMediator()
	 * @generated
	 */
	int RM_SEQUENCE_MEDIATOR = 47;

	/**
	 * The feature id for the '<em><b>Object State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RM_SEQUENCE_MEDIATOR__OBJECT_STATE = EsbPackage.MEDIATOR__OBJECT_STATE;

	/**
	 * The feature id for the '<em><b>Source Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RM_SEQUENCE_MEDIATOR__SOURCE_TEXT = EsbPackage.MEDIATOR__SOURCE_TEXT;

	/**
	 * The feature id for the '<em><b>Default Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RM_SEQUENCE_MEDIATOR__DEFAULT_NAMESPACE = EsbPackage.MEDIATOR__DEFAULT_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Additional Namespaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RM_SEQUENCE_MEDIATOR__ADDITIONAL_NAMESPACES = EsbPackage.MEDIATOR__ADDITIONAL_NAMESPACES;

	/**
	 * The feature id for the '<em><b>Current Esb Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RM_SEQUENCE_MEDIATOR__CURRENT_ESB_VERSION = EsbPackage.MEDIATOR__CURRENT_ESB_VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RM_SEQUENCE_MEDIATOR__COMMENT = EsbPackage.MEDIATOR__COMMENT;

	/**
	 * The feature id for the '<em><b>Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RM_SEQUENCE_MEDIATOR__DESCRIPTION = EsbPackage.MEDIATOR__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Rm Spec Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RM_SEQUENCE_MEDIATOR__RM_SPEC_VERSION = EsbPackage.MEDIATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Sequence Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RM_SEQUENCE_MEDIATOR__SEQUENCE_TYPE = EsbPackage.MEDIATOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Correlation Xpath</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RM_SEQUENCE_MEDIATOR__CORRELATION_XPATH = EsbPackage.MEDIATOR_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Last Message Xpath</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RM_SEQUENCE_MEDIATOR__LAST_MESSAGE_XPATH = EsbPackage.MEDIATOR_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>RM Sequence Mediator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RM_SEQUENCE_MEDIATOR_FEATURE_COUNT = EsbPackage.MEDIATOR_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.TransactionMediatorImpl <em>Transaction Mediator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.TransactionMediatorImpl
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getTransactionMediator()
	 * @generated
	 */
	int TRANSACTION_MEDIATOR = 48;

	/**
	 * The feature id for the '<em><b>Object State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION_MEDIATOR__OBJECT_STATE = EsbPackage.MEDIATOR__OBJECT_STATE;

	/**
	 * The feature id for the '<em><b>Source Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION_MEDIATOR__SOURCE_TEXT = EsbPackage.MEDIATOR__SOURCE_TEXT;

	/**
	 * The feature id for the '<em><b>Default Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION_MEDIATOR__DEFAULT_NAMESPACE = EsbPackage.MEDIATOR__DEFAULT_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Additional Namespaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION_MEDIATOR__ADDITIONAL_NAMESPACES = EsbPackage.MEDIATOR__ADDITIONAL_NAMESPACES;

	/**
	 * The feature id for the '<em><b>Current Esb Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION_MEDIATOR__CURRENT_ESB_VERSION = EsbPackage.MEDIATOR__CURRENT_ESB_VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION_MEDIATOR__COMMENT = EsbPackage.MEDIATOR__COMMENT;

	/**
	 * The feature id for the '<em><b>Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION_MEDIATOR__DESCRIPTION = EsbPackage.MEDIATOR__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Action</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION_MEDIATOR__ACTION = EsbPackage.MEDIATOR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Transaction Mediator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION_MEDIATOR_FEATURE_COUNT = EsbPackage.MEDIATOR_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.PropertyMediatorImpl <em>Property Mediator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.PropertyMediatorImpl
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getPropertyMediator()
	 * @generated
	 */
	int PROPERTY_MEDIATOR = 49;

	/**
	 * The feature id for the '<em><b>Object State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_MEDIATOR__OBJECT_STATE = EsbPackage.MEDIATOR__OBJECT_STATE;

	/**
	 * The feature id for the '<em><b>Source Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_MEDIATOR__SOURCE_TEXT = EsbPackage.MEDIATOR__SOURCE_TEXT;

	/**
	 * The feature id for the '<em><b>Default Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_MEDIATOR__DEFAULT_NAMESPACE = EsbPackage.MEDIATOR__DEFAULT_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Additional Namespaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_MEDIATOR__ADDITIONAL_NAMESPACES = EsbPackage.MEDIATOR__ADDITIONAL_NAMESPACES;

	/**
	 * The feature id for the '<em><b>Current Esb Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_MEDIATOR__CURRENT_ESB_VERSION = EsbPackage.MEDIATOR__CURRENT_ESB_VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_MEDIATOR__COMMENT = EsbPackage.MEDIATOR__COMMENT;

	/**
	 * The feature id for the '<em><b>Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_MEDIATOR__DESCRIPTION = EsbPackage.MEDIATOR__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Property Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_MEDIATOR__PROPERTY_NAME = EsbPackage.MEDIATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Property Data Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_MEDIATOR__PROPERTY_DATA_TYPE = EsbPackage.MEDIATOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Property Action</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_MEDIATOR__PROPERTY_ACTION = EsbPackage.MEDIATOR_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Property Scope</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_MEDIATOR__PROPERTY_SCOPE = EsbPackage.MEDIATOR_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Value Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_MEDIATOR__VALUE_TYPE = EsbPackage.MEDIATOR_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Value Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_MEDIATOR__VALUE_LITERAL = EsbPackage.MEDIATOR_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Value Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_MEDIATOR__VALUE_EXPRESSION = EsbPackage.MEDIATOR_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Value OM</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_MEDIATOR__VALUE_OM = EsbPackage.MEDIATOR_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Value String Pattern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_MEDIATOR__VALUE_STRING_PATTERN = EsbPackage.MEDIATOR_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Value String Capturing Group</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_MEDIATOR__VALUE_STRING_CAPTURING_GROUP = EsbPackage.MEDIATOR_FEATURE_COUNT + 9;

	/**
	 * The number of structural features of the '<em>Property Mediator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_MEDIATOR_FEATURE_COUNT = EsbPackage.MEDIATOR_FEATURE_COUNT + 10;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.OAuthMediatorImpl <em>OAuth Mediator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.OAuthMediatorImpl
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getOAuthMediator()
	 * @generated
	 */
	int OAUTH_MEDIATOR = 50;

	/**
	 * The feature id for the '<em><b>Object State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OAUTH_MEDIATOR__OBJECT_STATE = EsbPackage.MEDIATOR__OBJECT_STATE;

	/**
	 * The feature id for the '<em><b>Source Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OAUTH_MEDIATOR__SOURCE_TEXT = EsbPackage.MEDIATOR__SOURCE_TEXT;

	/**
	 * The feature id for the '<em><b>Default Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OAUTH_MEDIATOR__DEFAULT_NAMESPACE = EsbPackage.MEDIATOR__DEFAULT_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Additional Namespaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OAUTH_MEDIATOR__ADDITIONAL_NAMESPACES = EsbPackage.MEDIATOR__ADDITIONAL_NAMESPACES;

	/**
	 * The feature id for the '<em><b>Current Esb Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OAUTH_MEDIATOR__CURRENT_ESB_VERSION = EsbPackage.MEDIATOR__CURRENT_ESB_VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OAUTH_MEDIATOR__COMMENT = EsbPackage.MEDIATOR__COMMENT;

	/**
	 * The feature id for the '<em><b>Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OAUTH_MEDIATOR__DESCRIPTION = EsbPackage.MEDIATOR__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Remote Service Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OAUTH_MEDIATOR__REMOTE_SERVICE_URL = EsbPackage.MEDIATOR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>OAuth Mediator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OAUTH_MEDIATOR_FEATURE_COUNT = EsbPackage.MEDIATOR_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.AutoscaleInMediatorImpl <em>Autoscale In Mediator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.AutoscaleInMediatorImpl
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getAutoscaleInMediator()
	 * @generated
	 */
	int AUTOSCALE_IN_MEDIATOR = 51;

	/**
	 * The feature id for the '<em><b>Object State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTOSCALE_IN_MEDIATOR__OBJECT_STATE = EsbPackage.MEDIATOR__OBJECT_STATE;

	/**
	 * The feature id for the '<em><b>Source Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTOSCALE_IN_MEDIATOR__SOURCE_TEXT = EsbPackage.MEDIATOR__SOURCE_TEXT;

	/**
	 * The feature id for the '<em><b>Default Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTOSCALE_IN_MEDIATOR__DEFAULT_NAMESPACE = EsbPackage.MEDIATOR__DEFAULT_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Additional Namespaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTOSCALE_IN_MEDIATOR__ADDITIONAL_NAMESPACES = EsbPackage.MEDIATOR__ADDITIONAL_NAMESPACES;

	/**
	 * The feature id for the '<em><b>Current Esb Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTOSCALE_IN_MEDIATOR__CURRENT_ESB_VERSION = EsbPackage.MEDIATOR__CURRENT_ESB_VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTOSCALE_IN_MEDIATOR__COMMENT = EsbPackage.MEDIATOR__COMMENT;

	/**
	 * The feature id for the '<em><b>Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTOSCALE_IN_MEDIATOR__DESCRIPTION = EsbPackage.MEDIATOR__DESCRIPTION;

	/**
	 * The number of structural features of the '<em>Autoscale In Mediator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTOSCALE_IN_MEDIATOR_FEATURE_COUNT = EsbPackage.MEDIATOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.AutoscaleOutMediatorImpl <em>Autoscale Out Mediator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.AutoscaleOutMediatorImpl
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getAutoscaleOutMediator()
	 * @generated
	 */
	int AUTOSCALE_OUT_MEDIATOR = 52;

	/**
	 * The feature id for the '<em><b>Object State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTOSCALE_OUT_MEDIATOR__OBJECT_STATE = EsbPackage.MEDIATOR__OBJECT_STATE;

	/**
	 * The feature id for the '<em><b>Source Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTOSCALE_OUT_MEDIATOR__SOURCE_TEXT = EsbPackage.MEDIATOR__SOURCE_TEXT;

	/**
	 * The feature id for the '<em><b>Default Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTOSCALE_OUT_MEDIATOR__DEFAULT_NAMESPACE = EsbPackage.MEDIATOR__DEFAULT_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Additional Namespaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTOSCALE_OUT_MEDIATOR__ADDITIONAL_NAMESPACES = EsbPackage.MEDIATOR__ADDITIONAL_NAMESPACES;

	/**
	 * The feature id for the '<em><b>Current Esb Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTOSCALE_OUT_MEDIATOR__CURRENT_ESB_VERSION = EsbPackage.MEDIATOR__CURRENT_ESB_VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTOSCALE_OUT_MEDIATOR__COMMENT = EsbPackage.MEDIATOR__COMMENT;

	/**
	 * The feature id for the '<em><b>Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTOSCALE_OUT_MEDIATOR__DESCRIPTION = EsbPackage.MEDIATOR__DESCRIPTION;

	/**
	 * The number of structural features of the '<em>Autoscale Out Mediator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTOSCALE_OUT_MEDIATOR_FEATURE_COUNT = EsbPackage.MEDIATOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.HeaderMediatorImpl <em>Header Mediator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.HeaderMediatorImpl
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getHeaderMediator()
	 * @generated
	 */
	int HEADER_MEDIATOR = 53;

	/**
	 * The feature id for the '<em><b>Object State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEADER_MEDIATOR__OBJECT_STATE = EsbPackage.MEDIATOR__OBJECT_STATE;

	/**
	 * The feature id for the '<em><b>Source Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEADER_MEDIATOR__SOURCE_TEXT = EsbPackage.MEDIATOR__SOURCE_TEXT;

	/**
	 * The feature id for the '<em><b>Default Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEADER_MEDIATOR__DEFAULT_NAMESPACE = EsbPackage.MEDIATOR__DEFAULT_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Additional Namespaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEADER_MEDIATOR__ADDITIONAL_NAMESPACES = EsbPackage.MEDIATOR__ADDITIONAL_NAMESPACES;

	/**
	 * The feature id for the '<em><b>Current Esb Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEADER_MEDIATOR__CURRENT_ESB_VERSION = EsbPackage.MEDIATOR__CURRENT_ESB_VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEADER_MEDIATOR__COMMENT = EsbPackage.MEDIATOR__COMMENT;

	/**
	 * The feature id for the '<em><b>Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEADER_MEDIATOR__DESCRIPTION = EsbPackage.MEDIATOR__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Header Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEADER_MEDIATOR__HEADER_NAME = EsbPackage.MEDIATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Header Action</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEADER_MEDIATOR__HEADER_ACTION = EsbPackage.MEDIATOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Value Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEADER_MEDIATOR__VALUE_TYPE = EsbPackage.MEDIATOR_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Value Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEADER_MEDIATOR__VALUE_LITERAL = EsbPackage.MEDIATOR_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Value Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEADER_MEDIATOR__VALUE_EXPRESSION = EsbPackage.MEDIATOR_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Header Mediator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEADER_MEDIATOR_FEATURE_COUNT = EsbPackage.MEDIATOR_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.ThrottleMediatorImpl <em>Throttle Mediator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.ThrottleMediatorImpl
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getThrottleMediator()
	 * @generated
	 */
	int THROTTLE_MEDIATOR = 54;

	/**
	 * The feature id for the '<em><b>Object State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROTTLE_MEDIATOR__OBJECT_STATE = EsbPackage.MEDIATOR__OBJECT_STATE;

	/**
	 * The feature id for the '<em><b>Source Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROTTLE_MEDIATOR__SOURCE_TEXT = EsbPackage.MEDIATOR__SOURCE_TEXT;

	/**
	 * The feature id for the '<em><b>Default Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROTTLE_MEDIATOR__DEFAULT_NAMESPACE = EsbPackage.MEDIATOR__DEFAULT_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Additional Namespaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROTTLE_MEDIATOR__ADDITIONAL_NAMESPACES = EsbPackage.MEDIATOR__ADDITIONAL_NAMESPACES;

	/**
	 * The feature id for the '<em><b>Current Esb Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROTTLE_MEDIATOR__CURRENT_ESB_VERSION = EsbPackage.MEDIATOR__CURRENT_ESB_VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROTTLE_MEDIATOR__COMMENT = EsbPackage.MEDIATOR__COMMENT;

	/**
	 * The feature id for the '<em><b>Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROTTLE_MEDIATOR__DESCRIPTION = EsbPackage.MEDIATOR__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Group Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROTTLE_MEDIATOR__GROUP_ID = EsbPackage.MEDIATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Policy Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROTTLE_MEDIATOR__POLICY_CONFIGURATION = EsbPackage.MEDIATOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>On Accept Branch</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROTTLE_MEDIATOR__ON_ACCEPT_BRANCH = EsbPackage.MEDIATOR_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>On Reject Branch</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROTTLE_MEDIATOR__ON_REJECT_BRANCH = EsbPackage.MEDIATOR_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Throttle Mediator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROTTLE_MEDIATOR_FEATURE_COUNT = EsbPackage.MEDIATOR_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.ThrottlePolicyConfigurationImpl <em>Throttle Policy Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.ThrottlePolicyConfigurationImpl
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getThrottlePolicyConfiguration()
	 * @generated
	 */
	int THROTTLE_POLICY_CONFIGURATION = 55;

	/**
	 * The feature id for the '<em><b>Object State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROTTLE_POLICY_CONFIGURATION__OBJECT_STATE = EsbPackage.MODEL_OBJECT__OBJECT_STATE;

	/**
	 * The feature id for the '<em><b>Source Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROTTLE_POLICY_CONFIGURATION__SOURCE_TEXT = EsbPackage.MODEL_OBJECT__SOURCE_TEXT;

	/**
	 * The feature id for the '<em><b>Default Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROTTLE_POLICY_CONFIGURATION__DEFAULT_NAMESPACE = EsbPackage.MODEL_OBJECT__DEFAULT_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Additional Namespaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROTTLE_POLICY_CONFIGURATION__ADDITIONAL_NAMESPACES = EsbPackage.MODEL_OBJECT__ADDITIONAL_NAMESPACES;

	/**
	 * The feature id for the '<em><b>Current Esb Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROTTLE_POLICY_CONFIGURATION__CURRENT_ESB_VERSION = EsbPackage.MODEL_OBJECT__CURRENT_ESB_VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROTTLE_POLICY_CONFIGURATION__COMMENT = EsbPackage.MODEL_OBJECT__COMMENT;

	/**
	 * The feature id for the '<em><b>Policy Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROTTLE_POLICY_CONFIGURATION__POLICY_TYPE = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Policy Key</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROTTLE_POLICY_CONFIGURATION__POLICY_KEY = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Max Concurrent Access Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROTTLE_POLICY_CONFIGURATION__MAX_CONCURRENT_ACCESS_COUNT = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Policy Entries</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROTTLE_POLICY_CONFIGURATION__POLICY_ENTRIES = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Throttle Policy Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROTTLE_POLICY_CONFIGURATION_FEATURE_COUNT = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.ThrottlePolicyEntryImpl <em>Throttle Policy Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.ThrottlePolicyEntryImpl
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getThrottlePolicyEntry()
	 * @generated
	 */
	int THROTTLE_POLICY_ENTRY = 56;

	/**
	 * The feature id for the '<em><b>Object State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROTTLE_POLICY_ENTRY__OBJECT_STATE = EsbPackage.MODEL_OBJECT__OBJECT_STATE;

	/**
	 * The feature id for the '<em><b>Source Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROTTLE_POLICY_ENTRY__SOURCE_TEXT = EsbPackage.MODEL_OBJECT__SOURCE_TEXT;

	/**
	 * The feature id for the '<em><b>Default Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROTTLE_POLICY_ENTRY__DEFAULT_NAMESPACE = EsbPackage.MODEL_OBJECT__DEFAULT_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Additional Namespaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROTTLE_POLICY_ENTRY__ADDITIONAL_NAMESPACES = EsbPackage.MODEL_OBJECT__ADDITIONAL_NAMESPACES;

	/**
	 * The feature id for the '<em><b>Current Esb Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROTTLE_POLICY_ENTRY__CURRENT_ESB_VERSION = EsbPackage.MODEL_OBJECT__CURRENT_ESB_VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROTTLE_POLICY_ENTRY__COMMENT = EsbPackage.MODEL_OBJECT__COMMENT;

	/**
	 * The feature id for the '<em><b>Throttle Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROTTLE_POLICY_ENTRY__THROTTLE_TYPE = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Throttle Range</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROTTLE_POLICY_ENTRY__THROTTLE_RANGE = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Access Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROTTLE_POLICY_ENTRY__ACCESS_TYPE = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Max Request Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROTTLE_POLICY_ENTRY__MAX_REQUEST_COUNT = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Unit Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROTTLE_POLICY_ENTRY__UNIT_TIME = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Prohibit Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROTTLE_POLICY_ENTRY__PROHIBIT_PERIOD = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Throttle Policy Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROTTLE_POLICY_ENTRY_FEATURE_COUNT = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.ThrottleOnAcceptBranchImpl <em>Throttle On Accept Branch</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.ThrottleOnAcceptBranchImpl
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getThrottleOnAcceptBranch()
	 * @generated
	 */
	int THROTTLE_ON_ACCEPT_BRANCH = 57;

	/**
	 * The feature id for the '<em><b>Object State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROTTLE_ON_ACCEPT_BRANCH__OBJECT_STATE = EsbPackage.MEDIATOR_BRANCH__OBJECT_STATE;

	/**
	 * The feature id for the '<em><b>Source Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROTTLE_ON_ACCEPT_BRANCH__SOURCE_TEXT = EsbPackage.MEDIATOR_BRANCH__SOURCE_TEXT;

	/**
	 * The feature id for the '<em><b>Default Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROTTLE_ON_ACCEPT_BRANCH__DEFAULT_NAMESPACE = EsbPackage.MEDIATOR_BRANCH__DEFAULT_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Additional Namespaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROTTLE_ON_ACCEPT_BRANCH__ADDITIONAL_NAMESPACES = EsbPackage.MEDIATOR_BRANCH__ADDITIONAL_NAMESPACES;

	/**
	 * The feature id for the '<em><b>Current Esb Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROTTLE_ON_ACCEPT_BRANCH__CURRENT_ESB_VERSION = EsbPackage.MEDIATOR_BRANCH__CURRENT_ESB_VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROTTLE_ON_ACCEPT_BRANCH__COMMENT = EsbPackage.MEDIATOR_BRANCH__COMMENT;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROTTLE_ON_ACCEPT_BRANCH__CHILDREN = EsbPackage.MEDIATOR_BRANCH__CHILDREN;

	/**
	 * The feature id for the '<em><b>Sequence Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROTTLE_ON_ACCEPT_BRANCH__SEQUENCE_TYPE = EsbPackage.MEDIATOR_BRANCH_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Sequence Key</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROTTLE_ON_ACCEPT_BRANCH__SEQUENCE_KEY = EsbPackage.MEDIATOR_BRANCH_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Throttle On Accept Branch</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROTTLE_ON_ACCEPT_BRANCH_FEATURE_COUNT = EsbPackage.MEDIATOR_BRANCH_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.ThrottleOnRejectBranchImpl <em>Throttle On Reject Branch</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.ThrottleOnRejectBranchImpl
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getThrottleOnRejectBranch()
	 * @generated
	 */
	int THROTTLE_ON_REJECT_BRANCH = 58;

	/**
	 * The feature id for the '<em><b>Object State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROTTLE_ON_REJECT_BRANCH__OBJECT_STATE = EsbPackage.MEDIATOR_BRANCH__OBJECT_STATE;

	/**
	 * The feature id for the '<em><b>Source Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROTTLE_ON_REJECT_BRANCH__SOURCE_TEXT = EsbPackage.MEDIATOR_BRANCH__SOURCE_TEXT;

	/**
	 * The feature id for the '<em><b>Default Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROTTLE_ON_REJECT_BRANCH__DEFAULT_NAMESPACE = EsbPackage.MEDIATOR_BRANCH__DEFAULT_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Additional Namespaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROTTLE_ON_REJECT_BRANCH__ADDITIONAL_NAMESPACES = EsbPackage.MEDIATOR_BRANCH__ADDITIONAL_NAMESPACES;

	/**
	 * The feature id for the '<em><b>Current Esb Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROTTLE_ON_REJECT_BRANCH__CURRENT_ESB_VERSION = EsbPackage.MEDIATOR_BRANCH__CURRENT_ESB_VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROTTLE_ON_REJECT_BRANCH__COMMENT = EsbPackage.MEDIATOR_BRANCH__COMMENT;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROTTLE_ON_REJECT_BRANCH__CHILDREN = EsbPackage.MEDIATOR_BRANCH__CHILDREN;

	/**
	 * The feature id for the '<em><b>Sequence Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROTTLE_ON_REJECT_BRANCH__SEQUENCE_TYPE = EsbPackage.MEDIATOR_BRANCH_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Sequence Key</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROTTLE_ON_REJECT_BRANCH__SEQUENCE_KEY = EsbPackage.MEDIATOR_BRANCH_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Throttle On Reject Branch</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROTTLE_ON_REJECT_BRANCH_FEATURE_COUNT = EsbPackage.MEDIATOR_BRANCH_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.CommandMediatorImpl <em>Command Mediator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.CommandMediatorImpl
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getCommandMediator()
	 * @generated
	 */
	int COMMAND_MEDIATOR = 59;

	/**
	 * The feature id for the '<em><b>Object State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND_MEDIATOR__OBJECT_STATE = EsbPackage.MEDIATOR__OBJECT_STATE;

	/**
	 * The feature id for the '<em><b>Source Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND_MEDIATOR__SOURCE_TEXT = EsbPackage.MEDIATOR__SOURCE_TEXT;

	/**
	 * The feature id for the '<em><b>Default Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND_MEDIATOR__DEFAULT_NAMESPACE = EsbPackage.MEDIATOR__DEFAULT_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Additional Namespaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND_MEDIATOR__ADDITIONAL_NAMESPACES = EsbPackage.MEDIATOR__ADDITIONAL_NAMESPACES;

	/**
	 * The feature id for the '<em><b>Current Esb Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND_MEDIATOR__CURRENT_ESB_VERSION = EsbPackage.MEDIATOR__CURRENT_ESB_VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND_MEDIATOR__COMMENT = EsbPackage.MEDIATOR__COMMENT;

	/**
	 * The feature id for the '<em><b>Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND_MEDIATOR__DESCRIPTION = EsbPackage.MEDIATOR__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND_MEDIATOR__CLASS_NAME = EsbPackage.MEDIATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND_MEDIATOR__PROPERTIES = EsbPackage.MEDIATOR_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Command Mediator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND_MEDIATOR_FEATURE_COUNT = EsbPackage.MEDIATOR_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.CommandPropertyImpl <em>Command Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.CommandPropertyImpl
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getCommandProperty()
	 * @generated
	 */
	int COMMAND_PROPERTY = 60;

	/**
	 * The feature id for the '<em><b>Object State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND_PROPERTY__OBJECT_STATE = EsbPackage.MODEL_OBJECT__OBJECT_STATE;

	/**
	 * The feature id for the '<em><b>Source Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND_PROPERTY__SOURCE_TEXT = EsbPackage.MODEL_OBJECT__SOURCE_TEXT;

	/**
	 * The feature id for the '<em><b>Default Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND_PROPERTY__DEFAULT_NAMESPACE = EsbPackage.MODEL_OBJECT__DEFAULT_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Additional Namespaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND_PROPERTY__ADDITIONAL_NAMESPACES = EsbPackage.MODEL_OBJECT__ADDITIONAL_NAMESPACES;

	/**
	 * The feature id for the '<em><b>Current Esb Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND_PROPERTY__CURRENT_ESB_VERSION = EsbPackage.MODEL_OBJECT__CURRENT_ESB_VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND_PROPERTY__COMMENT = EsbPackage.MODEL_OBJECT__COMMENT;

	/**
	 * The feature id for the '<em><b>Property Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND_PROPERTY__PROPERTY_NAME = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND_PROPERTY__VALUE_TYPE = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Value Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND_PROPERTY__VALUE_LITERAL = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Value Context Property Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND_PROPERTY__VALUE_CONTEXT_PROPERTY_NAME = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Value Message Element Xpath</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND_PROPERTY__VALUE_MESSAGE_ELEMENT_XPATH = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Context Action</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND_PROPERTY__CONTEXT_ACTION = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Message Action</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND_PROPERTY__MESSAGE_ACTION = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Command Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND_PROPERTY_FEATURE_COUNT = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.EventMediatorImpl <em>Event Mediator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.EventMediatorImpl
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getEventMediator()
	 * @generated
	 */
	int EVENT_MEDIATOR = 61;

	/**
	 * The feature id for the '<em><b>Object State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_MEDIATOR__OBJECT_STATE = EsbPackage.MEDIATOR__OBJECT_STATE;

	/**
	 * The feature id for the '<em><b>Source Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_MEDIATOR__SOURCE_TEXT = EsbPackage.MEDIATOR__SOURCE_TEXT;

	/**
	 * The feature id for the '<em><b>Default Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_MEDIATOR__DEFAULT_NAMESPACE = EsbPackage.MEDIATOR__DEFAULT_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Additional Namespaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_MEDIATOR__ADDITIONAL_NAMESPACES = EsbPackage.MEDIATOR__ADDITIONAL_NAMESPACES;

	/**
	 * The feature id for the '<em><b>Current Esb Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_MEDIATOR__CURRENT_ESB_VERSION = EsbPackage.MEDIATOR__CURRENT_ESB_VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_MEDIATOR__COMMENT = EsbPackage.MEDIATOR__COMMENT;

	/**
	 * The feature id for the '<em><b>Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_MEDIATOR__DESCRIPTION = EsbPackage.MEDIATOR__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Topic Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_MEDIATOR__TOPIC_TYPE = EsbPackage.MEDIATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Static Topic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_MEDIATOR__STATIC_TOPIC = EsbPackage.MEDIATOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Dynamic Topic</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_MEDIATOR__DYNAMIC_TOPIC = EsbPackage.MEDIATOR_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Event Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_MEDIATOR__EVENT_EXPRESSION = EsbPackage.MEDIATOR_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Event Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_MEDIATOR__EVENT_SOURCE = EsbPackage.MEDIATOR_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Event Mediator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_MEDIATOR_FEATURE_COUNT = EsbPackage.MEDIATOR_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.AbstractSqlExecutorMediatorImpl <em>Abstract Sql Executor Mediator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.AbstractSqlExecutorMediatorImpl
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getAbstractSqlExecutorMediator()
	 * @generated
	 */
	int ABSTRACT_SQL_EXECUTOR_MEDIATOR = 62;

	/**
	 * The feature id for the '<em><b>Object State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_SQL_EXECUTOR_MEDIATOR__OBJECT_STATE = EsbPackage.MEDIATOR__OBJECT_STATE;

	/**
	 * The feature id for the '<em><b>Source Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_SQL_EXECUTOR_MEDIATOR__SOURCE_TEXT = EsbPackage.MEDIATOR__SOURCE_TEXT;

	/**
	 * The feature id for the '<em><b>Default Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_SQL_EXECUTOR_MEDIATOR__DEFAULT_NAMESPACE = EsbPackage.MEDIATOR__DEFAULT_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Additional Namespaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_SQL_EXECUTOR_MEDIATOR__ADDITIONAL_NAMESPACES = EsbPackage.MEDIATOR__ADDITIONAL_NAMESPACES;

	/**
	 * The feature id for the '<em><b>Current Esb Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_SQL_EXECUTOR_MEDIATOR__CURRENT_ESB_VERSION = EsbPackage.MEDIATOR__CURRENT_ESB_VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_SQL_EXECUTOR_MEDIATOR__COMMENT = EsbPackage.MEDIATOR__COMMENT;

	/**
	 * The feature id for the '<em><b>Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_SQL_EXECUTOR_MEDIATOR__DESCRIPTION = EsbPackage.MEDIATOR__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Connection Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_TYPE = EsbPackage.MEDIATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Connection Ds Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_DS_TYPE = EsbPackage.MEDIATOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Connection Db Driver</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_DB_DRIVER = EsbPackage.MEDIATOR_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Connection Ds Initial Context</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_DS_INITIAL_CONTEXT = EsbPackage.MEDIATOR_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Connection Ds Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_DS_NAME = EsbPackage.MEDIATOR_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Connection URL</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_URL = EsbPackage.MEDIATOR_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Connection Username</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_USERNAME = EsbPackage.MEDIATOR_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Connection Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_PASSWORD = EsbPackage.MEDIATOR_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Property Autocommit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_AUTOCOMMIT = EsbPackage.MEDIATOR_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Property Isolation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_ISOLATION = EsbPackage.MEDIATOR_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Property Maxactive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_MAXACTIVE = EsbPackage.MEDIATOR_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Property Maxidle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_MAXIDLE = EsbPackage.MEDIATOR_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Property Maxopenstatements</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_MAXOPENSTATEMENTS = EsbPackage.MEDIATOR_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Property Maxwait</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_MAXWAIT = EsbPackage.MEDIATOR_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Property Minidle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_MINIDLE = EsbPackage.MEDIATOR_FEATURE_COUNT + 14;

	/**
	 * The feature id for the '<em><b>Property Poolstatements</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_POOLSTATEMENTS = EsbPackage.MEDIATOR_FEATURE_COUNT + 15;

	/**
	 * The feature id for the '<em><b>Property Testonborrow</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_TESTONBORROW = EsbPackage.MEDIATOR_FEATURE_COUNT + 16;

	/**
	 * The feature id for the '<em><b>Property Testwhileidle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_TESTWHILEIDLE = EsbPackage.MEDIATOR_FEATURE_COUNT + 17;

	/**
	 * The feature id for the '<em><b>Property Validationquery</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_VALIDATIONQUERY = EsbPackage.MEDIATOR_FEATURE_COUNT + 18;

	/**
	 * The feature id for the '<em><b>Property Initialsize</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_INITIALSIZE = EsbPackage.MEDIATOR_FEATURE_COUNT + 19;

	/**
	 * The feature id for the '<em><b>Sql Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_SQL_EXECUTOR_MEDIATOR__SQL_STATEMENTS = EsbPackage.MEDIATOR_FEATURE_COUNT + 20;

	/**
	 * The number of structural features of the '<em>Abstract Sql Executor Mediator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_SQL_EXECUTOR_MEDIATOR_FEATURE_COUNT = EsbPackage.MEDIATOR_FEATURE_COUNT + 21;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.SqlStatementImpl <em>Sql Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.SqlStatementImpl
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getSqlStatement()
	 * @generated
	 */
	int SQL_STATEMENT = 63;

	/**
	 * The feature id for the '<em><b>Object State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQL_STATEMENT__OBJECT_STATE = EsbPackage.MODEL_OBJECT__OBJECT_STATE;

	/**
	 * The feature id for the '<em><b>Source Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQL_STATEMENT__SOURCE_TEXT = EsbPackage.MODEL_OBJECT__SOURCE_TEXT;

	/**
	 * The feature id for the '<em><b>Default Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQL_STATEMENT__DEFAULT_NAMESPACE = EsbPackage.MODEL_OBJECT__DEFAULT_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Additional Namespaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQL_STATEMENT__ADDITIONAL_NAMESPACES = EsbPackage.MODEL_OBJECT__ADDITIONAL_NAMESPACES;

	/**
	 * The feature id for the '<em><b>Current Esb Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQL_STATEMENT__CURRENT_ESB_VERSION = EsbPackage.MODEL_OBJECT__CURRENT_ESB_VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQL_STATEMENT__COMMENT = EsbPackage.MODEL_OBJECT__COMMENT;

	/**
	 * The feature id for the '<em><b>Query String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQL_STATEMENT__QUERY_STRING = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQL_STATEMENT__PARAMETERS = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Results Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQL_STATEMENT__RESULTS_ENABLED = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Results</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQL_STATEMENT__RESULTS = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Sql Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQL_STATEMENT_FEATURE_COUNT = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.SqlParameterDefinitionImpl <em>Sql Parameter Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.SqlParameterDefinitionImpl
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getSqlParameterDefinition()
	 * @generated
	 */
	int SQL_PARAMETER_DEFINITION = 64;

	/**
	 * The feature id for the '<em><b>Object State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQL_PARAMETER_DEFINITION__OBJECT_STATE = EsbPackage.MODEL_OBJECT__OBJECT_STATE;

	/**
	 * The feature id for the '<em><b>Source Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQL_PARAMETER_DEFINITION__SOURCE_TEXT = EsbPackage.MODEL_OBJECT__SOURCE_TEXT;

	/**
	 * The feature id for the '<em><b>Default Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQL_PARAMETER_DEFINITION__DEFAULT_NAMESPACE = EsbPackage.MODEL_OBJECT__DEFAULT_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Additional Namespaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQL_PARAMETER_DEFINITION__ADDITIONAL_NAMESPACES = EsbPackage.MODEL_OBJECT__ADDITIONAL_NAMESPACES;

	/**
	 * The feature id for the '<em><b>Current Esb Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQL_PARAMETER_DEFINITION__CURRENT_ESB_VERSION = EsbPackage.MODEL_OBJECT__CURRENT_ESB_VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQL_PARAMETER_DEFINITION__COMMENT = EsbPackage.MODEL_OBJECT__COMMENT;

	/**
	 * The feature id for the '<em><b>Data Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQL_PARAMETER_DEFINITION__DATA_TYPE = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQL_PARAMETER_DEFINITION__VALUE_TYPE = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Value Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQL_PARAMETER_DEFINITION__VALUE_LITERAL = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Value Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQL_PARAMETER_DEFINITION__VALUE_EXPRESSION = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Sql Parameter Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQL_PARAMETER_DEFINITION_FEATURE_COUNT = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.SqlResultMappingImpl <em>Sql Result Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.SqlResultMappingImpl
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getSqlResultMapping()
	 * @generated
	 */
	int SQL_RESULT_MAPPING = 65;

	/**
	 * The feature id for the '<em><b>Object State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQL_RESULT_MAPPING__OBJECT_STATE = EsbPackage.MODEL_OBJECT__OBJECT_STATE;

	/**
	 * The feature id for the '<em><b>Source Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQL_RESULT_MAPPING__SOURCE_TEXT = EsbPackage.MODEL_OBJECT__SOURCE_TEXT;

	/**
	 * The feature id for the '<em><b>Default Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQL_RESULT_MAPPING__DEFAULT_NAMESPACE = EsbPackage.MODEL_OBJECT__DEFAULT_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Additional Namespaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQL_RESULT_MAPPING__ADDITIONAL_NAMESPACES = EsbPackage.MODEL_OBJECT__ADDITIONAL_NAMESPACES;

	/**
	 * The feature id for the '<em><b>Current Esb Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQL_RESULT_MAPPING__CURRENT_ESB_VERSION = EsbPackage.MODEL_OBJECT__CURRENT_ESB_VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQL_RESULT_MAPPING__COMMENT = EsbPackage.MODEL_OBJECT__COMMENT;

	/**
	 * The feature id for the '<em><b>Property Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQL_RESULT_MAPPING__PROPERTY_NAME = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Column Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQL_RESULT_MAPPING__COLUMN_ID = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Sql Result Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQL_RESULT_MAPPING_FEATURE_COUNT = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.DBLookupMediatorImpl <em>DB Lookup Mediator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.DBLookupMediatorImpl
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getDBLookupMediator()
	 * @generated
	 */
	int DB_LOOKUP_MEDIATOR = 66;

	/**
	 * The feature id for the '<em><b>Object State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB_LOOKUP_MEDIATOR__OBJECT_STATE = ABSTRACT_SQL_EXECUTOR_MEDIATOR__OBJECT_STATE;

	/**
	 * The feature id for the '<em><b>Source Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB_LOOKUP_MEDIATOR__SOURCE_TEXT = ABSTRACT_SQL_EXECUTOR_MEDIATOR__SOURCE_TEXT;

	/**
	 * The feature id for the '<em><b>Default Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB_LOOKUP_MEDIATOR__DEFAULT_NAMESPACE = ABSTRACT_SQL_EXECUTOR_MEDIATOR__DEFAULT_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Additional Namespaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB_LOOKUP_MEDIATOR__ADDITIONAL_NAMESPACES = ABSTRACT_SQL_EXECUTOR_MEDIATOR__ADDITIONAL_NAMESPACES;

	/**
	 * The feature id for the '<em><b>Current Esb Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB_LOOKUP_MEDIATOR__CURRENT_ESB_VERSION = ABSTRACT_SQL_EXECUTOR_MEDIATOR__CURRENT_ESB_VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB_LOOKUP_MEDIATOR__COMMENT = ABSTRACT_SQL_EXECUTOR_MEDIATOR__COMMENT;

	/**
	 * The feature id for the '<em><b>Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB_LOOKUP_MEDIATOR__DESCRIPTION = ABSTRACT_SQL_EXECUTOR_MEDIATOR__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Connection Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB_LOOKUP_MEDIATOR__CONNECTION_TYPE = ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_TYPE;

	/**
	 * The feature id for the '<em><b>Connection Ds Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB_LOOKUP_MEDIATOR__CONNECTION_DS_TYPE = ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_DS_TYPE;

	/**
	 * The feature id for the '<em><b>Connection Db Driver</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB_LOOKUP_MEDIATOR__CONNECTION_DB_DRIVER = ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_DB_DRIVER;

	/**
	 * The feature id for the '<em><b>Connection Ds Initial Context</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB_LOOKUP_MEDIATOR__CONNECTION_DS_INITIAL_CONTEXT = ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_DS_INITIAL_CONTEXT;

	/**
	 * The feature id for the '<em><b>Connection Ds Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB_LOOKUP_MEDIATOR__CONNECTION_DS_NAME = ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_DS_NAME;

	/**
	 * The feature id for the '<em><b>Connection URL</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB_LOOKUP_MEDIATOR__CONNECTION_URL = ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_URL;

	/**
	 * The feature id for the '<em><b>Connection Username</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB_LOOKUP_MEDIATOR__CONNECTION_USERNAME = ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_USERNAME;

	/**
	 * The feature id for the '<em><b>Connection Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB_LOOKUP_MEDIATOR__CONNECTION_PASSWORD = ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_PASSWORD;

	/**
	 * The feature id for the '<em><b>Property Autocommit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB_LOOKUP_MEDIATOR__PROPERTY_AUTOCOMMIT = ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_AUTOCOMMIT;

	/**
	 * The feature id for the '<em><b>Property Isolation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB_LOOKUP_MEDIATOR__PROPERTY_ISOLATION = ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_ISOLATION;

	/**
	 * The feature id for the '<em><b>Property Maxactive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB_LOOKUP_MEDIATOR__PROPERTY_MAXACTIVE = ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_MAXACTIVE;

	/**
	 * The feature id for the '<em><b>Property Maxidle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB_LOOKUP_MEDIATOR__PROPERTY_MAXIDLE = ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_MAXIDLE;

	/**
	 * The feature id for the '<em><b>Property Maxopenstatements</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB_LOOKUP_MEDIATOR__PROPERTY_MAXOPENSTATEMENTS = ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_MAXOPENSTATEMENTS;

	/**
	 * The feature id for the '<em><b>Property Maxwait</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB_LOOKUP_MEDIATOR__PROPERTY_MAXWAIT = ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_MAXWAIT;

	/**
	 * The feature id for the '<em><b>Property Minidle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB_LOOKUP_MEDIATOR__PROPERTY_MINIDLE = ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_MINIDLE;

	/**
	 * The feature id for the '<em><b>Property Poolstatements</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB_LOOKUP_MEDIATOR__PROPERTY_POOLSTATEMENTS = ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_POOLSTATEMENTS;

	/**
	 * The feature id for the '<em><b>Property Testonborrow</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB_LOOKUP_MEDIATOR__PROPERTY_TESTONBORROW = ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_TESTONBORROW;

	/**
	 * The feature id for the '<em><b>Property Testwhileidle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB_LOOKUP_MEDIATOR__PROPERTY_TESTWHILEIDLE = ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_TESTWHILEIDLE;

	/**
	 * The feature id for the '<em><b>Property Validationquery</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB_LOOKUP_MEDIATOR__PROPERTY_VALIDATIONQUERY = ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_VALIDATIONQUERY;

	/**
	 * The feature id for the '<em><b>Property Initialsize</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB_LOOKUP_MEDIATOR__PROPERTY_INITIALSIZE = ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_INITIALSIZE;

	/**
	 * The feature id for the '<em><b>Sql Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB_LOOKUP_MEDIATOR__SQL_STATEMENTS = ABSTRACT_SQL_EXECUTOR_MEDIATOR__SQL_STATEMENTS;

	/**
	 * The number of structural features of the '<em>DB Lookup Mediator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB_LOOKUP_MEDIATOR_FEATURE_COUNT = ABSTRACT_SQL_EXECUTOR_MEDIATOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.DBReportMediatorImpl <em>DB Report Mediator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.DBReportMediatorImpl
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getDBReportMediator()
	 * @generated
	 */
	int DB_REPORT_MEDIATOR = 67;

	/**
	 * The feature id for the '<em><b>Object State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB_REPORT_MEDIATOR__OBJECT_STATE = ABSTRACT_SQL_EXECUTOR_MEDIATOR__OBJECT_STATE;

	/**
	 * The feature id for the '<em><b>Source Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB_REPORT_MEDIATOR__SOURCE_TEXT = ABSTRACT_SQL_EXECUTOR_MEDIATOR__SOURCE_TEXT;

	/**
	 * The feature id for the '<em><b>Default Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB_REPORT_MEDIATOR__DEFAULT_NAMESPACE = ABSTRACT_SQL_EXECUTOR_MEDIATOR__DEFAULT_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Additional Namespaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB_REPORT_MEDIATOR__ADDITIONAL_NAMESPACES = ABSTRACT_SQL_EXECUTOR_MEDIATOR__ADDITIONAL_NAMESPACES;

	/**
	 * The feature id for the '<em><b>Current Esb Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB_REPORT_MEDIATOR__CURRENT_ESB_VERSION = ABSTRACT_SQL_EXECUTOR_MEDIATOR__CURRENT_ESB_VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB_REPORT_MEDIATOR__COMMENT = ABSTRACT_SQL_EXECUTOR_MEDIATOR__COMMENT;

	/**
	 * The feature id for the '<em><b>Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB_REPORT_MEDIATOR__DESCRIPTION = ABSTRACT_SQL_EXECUTOR_MEDIATOR__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Connection Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB_REPORT_MEDIATOR__CONNECTION_TYPE = ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_TYPE;

	/**
	 * The feature id for the '<em><b>Connection Ds Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB_REPORT_MEDIATOR__CONNECTION_DS_TYPE = ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_DS_TYPE;

	/**
	 * The feature id for the '<em><b>Connection Db Driver</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB_REPORT_MEDIATOR__CONNECTION_DB_DRIVER = ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_DB_DRIVER;

	/**
	 * The feature id for the '<em><b>Connection Ds Initial Context</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB_REPORT_MEDIATOR__CONNECTION_DS_INITIAL_CONTEXT = ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_DS_INITIAL_CONTEXT;

	/**
	 * The feature id for the '<em><b>Connection Ds Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB_REPORT_MEDIATOR__CONNECTION_DS_NAME = ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_DS_NAME;

	/**
	 * The feature id for the '<em><b>Connection URL</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB_REPORT_MEDIATOR__CONNECTION_URL = ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_URL;

	/**
	 * The feature id for the '<em><b>Connection Username</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB_REPORT_MEDIATOR__CONNECTION_USERNAME = ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_USERNAME;

	/**
	 * The feature id for the '<em><b>Connection Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB_REPORT_MEDIATOR__CONNECTION_PASSWORD = ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_PASSWORD;

	/**
	 * The feature id for the '<em><b>Property Autocommit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB_REPORT_MEDIATOR__PROPERTY_AUTOCOMMIT = ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_AUTOCOMMIT;

	/**
	 * The feature id for the '<em><b>Property Isolation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB_REPORT_MEDIATOR__PROPERTY_ISOLATION = ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_ISOLATION;

	/**
	 * The feature id for the '<em><b>Property Maxactive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB_REPORT_MEDIATOR__PROPERTY_MAXACTIVE = ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_MAXACTIVE;

	/**
	 * The feature id for the '<em><b>Property Maxidle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB_REPORT_MEDIATOR__PROPERTY_MAXIDLE = ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_MAXIDLE;

	/**
	 * The feature id for the '<em><b>Property Maxopenstatements</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB_REPORT_MEDIATOR__PROPERTY_MAXOPENSTATEMENTS = ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_MAXOPENSTATEMENTS;

	/**
	 * The feature id for the '<em><b>Property Maxwait</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB_REPORT_MEDIATOR__PROPERTY_MAXWAIT = ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_MAXWAIT;

	/**
	 * The feature id for the '<em><b>Property Minidle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB_REPORT_MEDIATOR__PROPERTY_MINIDLE = ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_MINIDLE;

	/**
	 * The feature id for the '<em><b>Property Poolstatements</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB_REPORT_MEDIATOR__PROPERTY_POOLSTATEMENTS = ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_POOLSTATEMENTS;

	/**
	 * The feature id for the '<em><b>Property Testonborrow</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB_REPORT_MEDIATOR__PROPERTY_TESTONBORROW = ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_TESTONBORROW;

	/**
	 * The feature id for the '<em><b>Property Testwhileidle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB_REPORT_MEDIATOR__PROPERTY_TESTWHILEIDLE = ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_TESTWHILEIDLE;

	/**
	 * The feature id for the '<em><b>Property Validationquery</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB_REPORT_MEDIATOR__PROPERTY_VALIDATIONQUERY = ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_VALIDATIONQUERY;

	/**
	 * The feature id for the '<em><b>Property Initialsize</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB_REPORT_MEDIATOR__PROPERTY_INITIALSIZE = ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_INITIALSIZE;

	/**
	 * The feature id for the '<em><b>Sql Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB_REPORT_MEDIATOR__SQL_STATEMENTS = ABSTRACT_SQL_EXECUTOR_MEDIATOR__SQL_STATEMENTS;

	/**
	 * The feature id for the '<em><b>Connection Use Transaction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB_REPORT_MEDIATOR__CONNECTION_USE_TRANSACTION = ABSTRACT_SQL_EXECUTOR_MEDIATOR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>DB Report Mediator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DB_REPORT_MEDIATOR_FEATURE_COUNT = ABSTRACT_SQL_EXECUTOR_MEDIATOR_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.RuleMediatorImpl <em>Rule Mediator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.RuleMediatorImpl
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getRuleMediator()
	 * @generated
	 */
	int RULE_MEDIATOR = 68;

	/**
	 * The feature id for the '<em><b>Object State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_MEDIATOR__OBJECT_STATE = EsbPackage.MEDIATOR__OBJECT_STATE;

	/**
	 * The feature id for the '<em><b>Source Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_MEDIATOR__SOURCE_TEXT = EsbPackage.MEDIATOR__SOURCE_TEXT;

	/**
	 * The feature id for the '<em><b>Default Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_MEDIATOR__DEFAULT_NAMESPACE = EsbPackage.MEDIATOR__DEFAULT_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Additional Namespaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_MEDIATOR__ADDITIONAL_NAMESPACES = EsbPackage.MEDIATOR__ADDITIONAL_NAMESPACES;

	/**
	 * The feature id for the '<em><b>Current Esb Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_MEDIATOR__CURRENT_ESB_VERSION = EsbPackage.MEDIATOR__CURRENT_ESB_VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_MEDIATOR__COMMENT = EsbPackage.MEDIATOR__COMMENT;

	/**
	 * The feature id for the '<em><b>Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_MEDIATOR__DESCRIPTION = EsbPackage.MEDIATOR__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Rule Set Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_MEDIATOR__RULE_SET_CONFIGURATION = EsbPackage.MEDIATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Rule Session Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_MEDIATOR__RULE_SESSION_CONFIGURATION = EsbPackage.MEDIATOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Facts Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_MEDIATOR__FACTS_CONFIGURATION = EsbPackage.MEDIATOR_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Results Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_MEDIATOR__RESULTS_CONFIGURATION = EsbPackage.MEDIATOR_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Child Mediators Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_MEDIATOR__CHILD_MEDIATORS_CONFIGURATION = EsbPackage.MEDIATOR_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Rule Mediator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_MEDIATOR_FEATURE_COUNT = EsbPackage.MEDIATOR_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.RuleSetConfigurationImpl <em>Rule Set Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.RuleSetConfigurationImpl
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getRuleSetConfiguration()
	 * @generated
	 */
	int RULE_SET_CONFIGURATION = 69;

	/**
	 * The feature id for the '<em><b>Object State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_SET_CONFIGURATION__OBJECT_STATE = EsbPackage.MODEL_OBJECT__OBJECT_STATE;

	/**
	 * The feature id for the '<em><b>Source Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_SET_CONFIGURATION__SOURCE_TEXT = EsbPackage.MODEL_OBJECT__SOURCE_TEXT;

	/**
	 * The feature id for the '<em><b>Default Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_SET_CONFIGURATION__DEFAULT_NAMESPACE = EsbPackage.MODEL_OBJECT__DEFAULT_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Additional Namespaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_SET_CONFIGURATION__ADDITIONAL_NAMESPACES = EsbPackage.MODEL_OBJECT__ADDITIONAL_NAMESPACES;

	/**
	 * The feature id for the '<em><b>Current Esb Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_SET_CONFIGURATION__CURRENT_ESB_VERSION = EsbPackage.MODEL_OBJECT__CURRENT_ESB_VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_SET_CONFIGURATION__COMMENT = EsbPackage.MODEL_OBJECT__COMMENT;

	/**
	 * The feature id for the '<em><b>Source Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_SET_CONFIGURATION__SOURCE_TYPE = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_SET_CONFIGURATION__SOURCE_CODE = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Source Key</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_SET_CONFIGURATION__SOURCE_KEY = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_SET_CONFIGURATION__PROPERTIES = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Rule Set Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_SET_CONFIGURATION_FEATURE_COUNT = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.RuleSetCreationPropertyImpl <em>Rule Set Creation Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.RuleSetCreationPropertyImpl
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getRuleSetCreationProperty()
	 * @generated
	 */
	int RULE_SET_CREATION_PROPERTY = 70;

	/**
	 * The feature id for the '<em><b>Object State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_SET_CREATION_PROPERTY__OBJECT_STATE = EsbPackage.ABSTRACT_NAME_VALUE_PROPERTY__OBJECT_STATE;

	/**
	 * The feature id for the '<em><b>Source Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_SET_CREATION_PROPERTY__SOURCE_TEXT = EsbPackage.ABSTRACT_NAME_VALUE_PROPERTY__SOURCE_TEXT;

	/**
	 * The feature id for the '<em><b>Default Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_SET_CREATION_PROPERTY__DEFAULT_NAMESPACE = EsbPackage.ABSTRACT_NAME_VALUE_PROPERTY__DEFAULT_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Additional Namespaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_SET_CREATION_PROPERTY__ADDITIONAL_NAMESPACES = EsbPackage.ABSTRACT_NAME_VALUE_PROPERTY__ADDITIONAL_NAMESPACES;

	/**
	 * The feature id for the '<em><b>Current Esb Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_SET_CREATION_PROPERTY__CURRENT_ESB_VERSION = EsbPackage.ABSTRACT_NAME_VALUE_PROPERTY__CURRENT_ESB_VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_SET_CREATION_PROPERTY__COMMENT = EsbPackage.ABSTRACT_NAME_VALUE_PROPERTY__COMMENT;

	/**
	 * The feature id for the '<em><b>Property Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_SET_CREATION_PROPERTY__PROPERTY_NAME = EsbPackage.ABSTRACT_NAME_VALUE_PROPERTY__PROPERTY_NAME;

	/**
	 * The feature id for the '<em><b>Property Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_SET_CREATION_PROPERTY__PROPERTY_VALUE = EsbPackage.ABSTRACT_NAME_VALUE_PROPERTY__PROPERTY_VALUE;

	/**
	 * The number of structural features of the '<em>Rule Set Creation Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_SET_CREATION_PROPERTY_FEATURE_COUNT = EsbPackage.ABSTRACT_NAME_VALUE_PROPERTY_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.RuleSessionConfigurationImpl <em>Rule Session Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.RuleSessionConfigurationImpl
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getRuleSessionConfiguration()
	 * @generated
	 */
	int RULE_SESSION_CONFIGURATION = 71;

	/**
	 * The feature id for the '<em><b>Object State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_SESSION_CONFIGURATION__OBJECT_STATE = EsbPackage.MODEL_OBJECT__OBJECT_STATE;

	/**
	 * The feature id for the '<em><b>Source Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_SESSION_CONFIGURATION__SOURCE_TEXT = EsbPackage.MODEL_OBJECT__SOURCE_TEXT;

	/**
	 * The feature id for the '<em><b>Default Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_SESSION_CONFIGURATION__DEFAULT_NAMESPACE = EsbPackage.MODEL_OBJECT__DEFAULT_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Additional Namespaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_SESSION_CONFIGURATION__ADDITIONAL_NAMESPACES = EsbPackage.MODEL_OBJECT__ADDITIONAL_NAMESPACES;

	/**
	 * The feature id for the '<em><b>Current Esb Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_SESSION_CONFIGURATION__CURRENT_ESB_VERSION = EsbPackage.MODEL_OBJECT__CURRENT_ESB_VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_SESSION_CONFIGURATION__COMMENT = EsbPackage.MODEL_OBJECT__COMMENT;

	/**
	 * The feature id for the '<em><b>Stateful Session</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_SESSION_CONFIGURATION__STATEFUL_SESSION = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_SESSION_CONFIGURATION__PROPERTIES = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Rule Session Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_SESSION_CONFIGURATION_FEATURE_COUNT = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.RuleSessionPropertyImpl <em>Rule Session Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.RuleSessionPropertyImpl
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getRuleSessionProperty()
	 * @generated
	 */
	int RULE_SESSION_PROPERTY = 72;

	/**
	 * The feature id for the '<em><b>Object State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_SESSION_PROPERTY__OBJECT_STATE = EsbPackage.ABSTRACT_NAME_VALUE_PROPERTY__OBJECT_STATE;

	/**
	 * The feature id for the '<em><b>Source Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_SESSION_PROPERTY__SOURCE_TEXT = EsbPackage.ABSTRACT_NAME_VALUE_PROPERTY__SOURCE_TEXT;

	/**
	 * The feature id for the '<em><b>Default Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_SESSION_PROPERTY__DEFAULT_NAMESPACE = EsbPackage.ABSTRACT_NAME_VALUE_PROPERTY__DEFAULT_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Additional Namespaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_SESSION_PROPERTY__ADDITIONAL_NAMESPACES = EsbPackage.ABSTRACT_NAME_VALUE_PROPERTY__ADDITIONAL_NAMESPACES;

	/**
	 * The feature id for the '<em><b>Current Esb Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_SESSION_PROPERTY__CURRENT_ESB_VERSION = EsbPackage.ABSTRACT_NAME_VALUE_PROPERTY__CURRENT_ESB_VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_SESSION_PROPERTY__COMMENT = EsbPackage.ABSTRACT_NAME_VALUE_PROPERTY__COMMENT;

	/**
	 * The feature id for the '<em><b>Property Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_SESSION_PROPERTY__PROPERTY_NAME = EsbPackage.ABSTRACT_NAME_VALUE_PROPERTY__PROPERTY_NAME;

	/**
	 * The feature id for the '<em><b>Property Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_SESSION_PROPERTY__PROPERTY_VALUE = EsbPackage.ABSTRACT_NAME_VALUE_PROPERTY__PROPERTY_VALUE;

	/**
	 * The number of structural features of the '<em>Rule Session Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_SESSION_PROPERTY_FEATURE_COUNT = EsbPackage.ABSTRACT_NAME_VALUE_PROPERTY_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.RuleFactsConfigurationImpl <em>Rule Facts Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.RuleFactsConfigurationImpl
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getRuleFactsConfiguration()
	 * @generated
	 */
	int RULE_FACTS_CONFIGURATION = 73;

	/**
	 * The feature id for the '<em><b>Object State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_FACTS_CONFIGURATION__OBJECT_STATE = EsbPackage.MODEL_OBJECT__OBJECT_STATE;

	/**
	 * The feature id for the '<em><b>Source Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_FACTS_CONFIGURATION__SOURCE_TEXT = EsbPackage.MODEL_OBJECT__SOURCE_TEXT;

	/**
	 * The feature id for the '<em><b>Default Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_FACTS_CONFIGURATION__DEFAULT_NAMESPACE = EsbPackage.MODEL_OBJECT__DEFAULT_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Additional Namespaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_FACTS_CONFIGURATION__ADDITIONAL_NAMESPACES = EsbPackage.MODEL_OBJECT__ADDITIONAL_NAMESPACES;

	/**
	 * The feature id for the '<em><b>Current Esb Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_FACTS_CONFIGURATION__CURRENT_ESB_VERSION = EsbPackage.MODEL_OBJECT__CURRENT_ESB_VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_FACTS_CONFIGURATION__COMMENT = EsbPackage.MODEL_OBJECT__COMMENT;

	/**
	 * The feature id for the '<em><b>Facts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_FACTS_CONFIGURATION__FACTS = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Rule Facts Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_FACTS_CONFIGURATION_FEATURE_COUNT = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.RuleFactImpl <em>Rule Fact</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.RuleFactImpl
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getRuleFact()
	 * @generated
	 */
	int RULE_FACT = 74;

	/**
	 * The feature id for the '<em><b>Object State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_FACT__OBJECT_STATE = EsbPackage.MODEL_OBJECT__OBJECT_STATE;

	/**
	 * The feature id for the '<em><b>Source Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_FACT__SOURCE_TEXT = EsbPackage.MODEL_OBJECT__SOURCE_TEXT;

	/**
	 * The feature id for the '<em><b>Default Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_FACT__DEFAULT_NAMESPACE = EsbPackage.MODEL_OBJECT__DEFAULT_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Additional Namespaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_FACT__ADDITIONAL_NAMESPACES = EsbPackage.MODEL_OBJECT__ADDITIONAL_NAMESPACES;

	/**
	 * The feature id for the '<em><b>Current Esb Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_FACT__CURRENT_ESB_VERSION = EsbPackage.MODEL_OBJECT__CURRENT_ESB_VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_FACT__COMMENT = EsbPackage.MODEL_OBJECT__COMMENT;

	/**
	 * The feature id for the '<em><b>Fact Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_FACT__FACT_TYPE = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Fact Custom Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_FACT__FACT_CUSTOM_TYPE = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Fact Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_FACT__FACT_NAME = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Value Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_FACT__VALUE_TYPE = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Value Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_FACT__VALUE_LITERAL = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Value Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_FACT__VALUE_EXPRESSION = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Value Key</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_FACT__VALUE_KEY = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Rule Fact</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_FACT_FEATURE_COUNT = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.RuleResultsConfigurationImpl <em>Rule Results Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.RuleResultsConfigurationImpl
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getRuleResultsConfiguration()
	 * @generated
	 */
	int RULE_RESULTS_CONFIGURATION = 75;

	/**
	 * The feature id for the '<em><b>Object State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_RESULTS_CONFIGURATION__OBJECT_STATE = EsbPackage.MODEL_OBJECT__OBJECT_STATE;

	/**
	 * The feature id for the '<em><b>Source Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_RESULTS_CONFIGURATION__SOURCE_TEXT = EsbPackage.MODEL_OBJECT__SOURCE_TEXT;

	/**
	 * The feature id for the '<em><b>Default Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_RESULTS_CONFIGURATION__DEFAULT_NAMESPACE = EsbPackage.MODEL_OBJECT__DEFAULT_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Additional Namespaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_RESULTS_CONFIGURATION__ADDITIONAL_NAMESPACES = EsbPackage.MODEL_OBJECT__ADDITIONAL_NAMESPACES;

	/**
	 * The feature id for the '<em><b>Current Esb Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_RESULTS_CONFIGURATION__CURRENT_ESB_VERSION = EsbPackage.MODEL_OBJECT__CURRENT_ESB_VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_RESULTS_CONFIGURATION__COMMENT = EsbPackage.MODEL_OBJECT__COMMENT;

	/**
	 * The feature id for the '<em><b>Results</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_RESULTS_CONFIGURATION__RESULTS = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Rule Results Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_RESULTS_CONFIGURATION_FEATURE_COUNT = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.RuleResultImpl <em>Rule Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.RuleResultImpl
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getRuleResult()
	 * @generated
	 */
	int RULE_RESULT = 76;

	/**
	 * The feature id for the '<em><b>Object State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_RESULT__OBJECT_STATE = EsbPackage.MODEL_OBJECT__OBJECT_STATE;

	/**
	 * The feature id for the '<em><b>Source Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_RESULT__SOURCE_TEXT = EsbPackage.MODEL_OBJECT__SOURCE_TEXT;

	/**
	 * The feature id for the '<em><b>Default Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_RESULT__DEFAULT_NAMESPACE = EsbPackage.MODEL_OBJECT__DEFAULT_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Additional Namespaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_RESULT__ADDITIONAL_NAMESPACES = EsbPackage.MODEL_OBJECT__ADDITIONAL_NAMESPACES;

	/**
	 * The feature id for the '<em><b>Current Esb Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_RESULT__CURRENT_ESB_VERSION = EsbPackage.MODEL_OBJECT__CURRENT_ESB_VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_RESULT__COMMENT = EsbPackage.MODEL_OBJECT__COMMENT;

	/**
	 * The feature id for the '<em><b>Result Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_RESULT__RESULT_TYPE = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Result Custom Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_RESULT__RESULT_CUSTOM_TYPE = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Result Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_RESULT__RESULT_NAME = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Value Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_RESULT__VALUE_TYPE = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Value Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_RESULT__VALUE_LITERAL = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Value Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_RESULT__VALUE_EXPRESSION = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Value Key</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_RESULT__VALUE_KEY = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Rule Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_RESULT_FEATURE_COUNT = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.RuleChildMediatorsConfigurationImpl <em>Rule Child Mediators Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.RuleChildMediatorsConfigurationImpl
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getRuleChildMediatorsConfiguration()
	 * @generated
	 */
	int RULE_CHILD_MEDIATORS_CONFIGURATION = 77;

	/**
	 * The feature id for the '<em><b>Object State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_CHILD_MEDIATORS_CONFIGURATION__OBJECT_STATE = EsbPackage.MEDIATOR_BRANCH__OBJECT_STATE;

	/**
	 * The feature id for the '<em><b>Source Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_CHILD_MEDIATORS_CONFIGURATION__SOURCE_TEXT = EsbPackage.MEDIATOR_BRANCH__SOURCE_TEXT;

	/**
	 * The feature id for the '<em><b>Default Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_CHILD_MEDIATORS_CONFIGURATION__DEFAULT_NAMESPACE = EsbPackage.MEDIATOR_BRANCH__DEFAULT_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Additional Namespaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_CHILD_MEDIATORS_CONFIGURATION__ADDITIONAL_NAMESPACES = EsbPackage.MEDIATOR_BRANCH__ADDITIONAL_NAMESPACES;

	/**
	 * The feature id for the '<em><b>Current Esb Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_CHILD_MEDIATORS_CONFIGURATION__CURRENT_ESB_VERSION = EsbPackage.MEDIATOR_BRANCH__CURRENT_ESB_VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_CHILD_MEDIATORS_CONFIGURATION__COMMENT = EsbPackage.MEDIATOR_BRANCH__COMMENT;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_CHILD_MEDIATORS_CONFIGURATION__CHILDREN = EsbPackage.MEDIATOR_BRANCH__CHILDREN;

	/**
	 * The number of structural features of the '<em>Rule Child Mediators Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_CHILD_MEDIATORS_CONFIGURATION_FEATURE_COUNT = EsbPackage.MEDIATOR_BRANCH_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.SequenceMediatorImpl <em>Sequence Mediator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.SequenceMediatorImpl
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getSequenceMediator()
	 * @generated
	 */
	int SEQUENCE_MEDIATOR = 78;

	/**
	 * The feature id for the '<em><b>Object State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_MEDIATOR__OBJECT_STATE = EsbPackage.MEDIATOR__OBJECT_STATE;

	/**
	 * The feature id for the '<em><b>Source Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_MEDIATOR__SOURCE_TEXT = EsbPackage.MEDIATOR__SOURCE_TEXT;

	/**
	 * The feature id for the '<em><b>Default Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_MEDIATOR__DEFAULT_NAMESPACE = EsbPackage.MEDIATOR__DEFAULT_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Additional Namespaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_MEDIATOR__ADDITIONAL_NAMESPACES = EsbPackage.MEDIATOR__ADDITIONAL_NAMESPACES;

	/**
	 * The feature id for the '<em><b>Current Esb Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_MEDIATOR__CURRENT_ESB_VERSION = EsbPackage.MEDIATOR__CURRENT_ESB_VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_MEDIATOR__COMMENT = EsbPackage.MEDIATOR__COMMENT;

	/**
	 * The feature id for the '<em><b>Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_MEDIATOR__DESCRIPTION = EsbPackage.MEDIATOR__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Referring Sequence Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_MEDIATOR__REFERRING_SEQUENCE_TYPE = EsbPackage.MEDIATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Dynamic Reference Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_MEDIATOR__DYNAMIC_REFERENCE_KEY = EsbPackage.MEDIATOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Static Reference Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_MEDIATOR__STATIC_REFERENCE_KEY = EsbPackage.MEDIATOR_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Sequence Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_MEDIATOR__SEQUENCE_KEY = EsbPackage.MEDIATOR_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Sequence Mediator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_MEDIATOR_FEATURE_COUNT = EsbPackage.MEDIATOR_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.BuilderMediatorImpl <em>Builder Mediator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.BuilderMediatorImpl
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getBuilderMediator()
	 * @generated
	 */
	int BUILDER_MEDIATOR = 79;

	/**
	 * The feature id for the '<em><b>Object State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILDER_MEDIATOR__OBJECT_STATE = EsbPackage.MEDIATOR__OBJECT_STATE;

	/**
	 * The feature id for the '<em><b>Source Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILDER_MEDIATOR__SOURCE_TEXT = EsbPackage.MEDIATOR__SOURCE_TEXT;

	/**
	 * The feature id for the '<em><b>Default Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILDER_MEDIATOR__DEFAULT_NAMESPACE = EsbPackage.MEDIATOR__DEFAULT_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Additional Namespaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILDER_MEDIATOR__ADDITIONAL_NAMESPACES = EsbPackage.MEDIATOR__ADDITIONAL_NAMESPACES;

	/**
	 * The feature id for the '<em><b>Current Esb Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILDER_MEDIATOR__CURRENT_ESB_VERSION = EsbPackage.MEDIATOR__CURRENT_ESB_VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILDER_MEDIATOR__COMMENT = EsbPackage.MEDIATOR__COMMENT;

	/**
	 * The feature id for the '<em><b>Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILDER_MEDIATOR__DESCRIPTION = EsbPackage.MEDIATOR__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Message Builders</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILDER_MEDIATOR__MESSAGE_BUILDERS = EsbPackage.MEDIATOR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Builder Mediator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILDER_MEDIATOR_FEATURE_COUNT = EsbPackage.MEDIATOR_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.MessageBuilderImpl <em>Message Builder</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MessageBuilderImpl
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getMessageBuilder()
	 * @generated
	 */
	int MESSAGE_BUILDER = 80;

	/**
	 * The feature id for the '<em><b>Object State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_BUILDER__OBJECT_STATE = EsbPackage.MODEL_OBJECT__OBJECT_STATE;

	/**
	 * The feature id for the '<em><b>Source Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_BUILDER__SOURCE_TEXT = EsbPackage.MODEL_OBJECT__SOURCE_TEXT;

	/**
	 * The feature id for the '<em><b>Default Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_BUILDER__DEFAULT_NAMESPACE = EsbPackage.MODEL_OBJECT__DEFAULT_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Additional Namespaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_BUILDER__ADDITIONAL_NAMESPACES = EsbPackage.MODEL_OBJECT__ADDITIONAL_NAMESPACES;

	/**
	 * The feature id for the '<em><b>Current Esb Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_BUILDER__CURRENT_ESB_VERSION = EsbPackage.MODEL_OBJECT__CURRENT_ESB_VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_BUILDER__COMMENT = EsbPackage.MODEL_OBJECT__COMMENT;

	/**
	 * The feature id for the '<em><b>Content Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_BUILDER__CONTENT_TYPE = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Builder Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_BUILDER__BUILDER_CLASS = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Formatter Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_BUILDER__FORMATTER_CLASS = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Message Builder</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_BUILDER_FEATURE_COUNT = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.SmooksMediatorImpl <em>Smooks Mediator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.SmooksMediatorImpl
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getSmooksMediator()
	 * @generated
	 */
	int SMOOKS_MEDIATOR = 81;

	/**
	 * The feature id for the '<em><b>Object State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMOOKS_MEDIATOR__OBJECT_STATE = EsbPackage.MEDIATOR__OBJECT_STATE;

	/**
	 * The feature id for the '<em><b>Source Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMOOKS_MEDIATOR__SOURCE_TEXT = EsbPackage.MEDIATOR__SOURCE_TEXT;

	/**
	 * The feature id for the '<em><b>Default Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMOOKS_MEDIATOR__DEFAULT_NAMESPACE = EsbPackage.MEDIATOR__DEFAULT_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Additional Namespaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMOOKS_MEDIATOR__ADDITIONAL_NAMESPACES = EsbPackage.MEDIATOR__ADDITIONAL_NAMESPACES;

	/**
	 * The feature id for the '<em><b>Current Esb Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMOOKS_MEDIATOR__CURRENT_ESB_VERSION = EsbPackage.MEDIATOR__CURRENT_ESB_VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMOOKS_MEDIATOR__COMMENT = EsbPackage.MEDIATOR__COMMENT;

	/**
	 * The feature id for the '<em><b>Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMOOKS_MEDIATOR__DESCRIPTION = EsbPackage.MEDIATOR__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Configuration Key</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMOOKS_MEDIATOR__CONFIGURATION_KEY = EsbPackage.MEDIATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Input</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMOOKS_MEDIATOR__INPUT = EsbPackage.MEDIATOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Output</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMOOKS_MEDIATOR__OUTPUT = EsbPackage.MEDIATOR_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Smooks Mediator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMOOKS_MEDIATOR_FEATURE_COUNT = EsbPackage.MEDIATOR_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.SmooksInConfigurationImpl <em>Smooks In Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.SmooksInConfigurationImpl
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getSmooksInConfiguration()
	 * @generated
	 */
	int SMOOKS_IN_CONFIGURATION = 82;

	/**
	 * The feature id for the '<em><b>Object State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMOOKS_IN_CONFIGURATION__OBJECT_STATE = EsbPackage.MODEL_OBJECT__OBJECT_STATE;

	/**
	 * The feature id for the '<em><b>Source Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMOOKS_IN_CONFIGURATION__SOURCE_TEXT = EsbPackage.MODEL_OBJECT__SOURCE_TEXT;

	/**
	 * The feature id for the '<em><b>Default Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMOOKS_IN_CONFIGURATION__DEFAULT_NAMESPACE = EsbPackage.MODEL_OBJECT__DEFAULT_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Additional Namespaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMOOKS_IN_CONFIGURATION__ADDITIONAL_NAMESPACES = EsbPackage.MODEL_OBJECT__ADDITIONAL_NAMESPACES;

	/**
	 * The feature id for the '<em><b>Current Esb Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMOOKS_IN_CONFIGURATION__CURRENT_ESB_VERSION = EsbPackage.MODEL_OBJECT__CURRENT_ESB_VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMOOKS_IN_CONFIGURATION__COMMENT = EsbPackage.MODEL_OBJECT__COMMENT;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMOOKS_IN_CONFIGURATION__TYPE = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMOOKS_IN_CONFIGURATION__EXPRESSION = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Smooks In Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMOOKS_IN_CONFIGURATION_FEATURE_COUNT = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.SmooksOutConfigurationImpl <em>Smooks Out Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.SmooksOutConfigurationImpl
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getSmooksOutConfiguration()
	 * @generated
	 */
	int SMOOKS_OUT_CONFIGURATION = 83;

	/**
	 * The feature id for the '<em><b>Object State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMOOKS_OUT_CONFIGURATION__OBJECT_STATE = EsbPackage.MODEL_OBJECT__OBJECT_STATE;

	/**
	 * The feature id for the '<em><b>Source Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMOOKS_OUT_CONFIGURATION__SOURCE_TEXT = EsbPackage.MODEL_OBJECT__SOURCE_TEXT;

	/**
	 * The feature id for the '<em><b>Default Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMOOKS_OUT_CONFIGURATION__DEFAULT_NAMESPACE = EsbPackage.MODEL_OBJECT__DEFAULT_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Additional Namespaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMOOKS_OUT_CONFIGURATION__ADDITIONAL_NAMESPACES = EsbPackage.MODEL_OBJECT__ADDITIONAL_NAMESPACES;

	/**
	 * The feature id for the '<em><b>Current Esb Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMOOKS_OUT_CONFIGURATION__CURRENT_ESB_VERSION = EsbPackage.MODEL_OBJECT__CURRENT_ESB_VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMOOKS_OUT_CONFIGURATION__COMMENT = EsbPackage.MODEL_OBJECT__COMMENT;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMOOKS_OUT_CONFIGURATION__TYPE = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMOOKS_OUT_CONFIGURATION__EXPRESSION = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Property</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMOOKS_OUT_CONFIGURATION__PROPERTY = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Action</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMOOKS_OUT_CONFIGURATION__ACTION = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Output Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMOOKS_OUT_CONFIGURATION__OUTPUT_METHOD = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Smooks Out Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMOOKS_OUT_CONFIGURATION_FEATURE_COUNT = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.StoreMediatorImpl <em>Store Mediator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.StoreMediatorImpl
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getStoreMediator()
	 * @generated
	 */
	int STORE_MEDIATOR = 84;

	/**
	 * The feature id for the '<em><b>Object State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORE_MEDIATOR__OBJECT_STATE = EsbPackage.MEDIATOR__OBJECT_STATE;

	/**
	 * The feature id for the '<em><b>Source Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORE_MEDIATOR__SOURCE_TEXT = EsbPackage.MEDIATOR__SOURCE_TEXT;

	/**
	 * The feature id for the '<em><b>Default Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORE_MEDIATOR__DEFAULT_NAMESPACE = EsbPackage.MEDIATOR__DEFAULT_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Additional Namespaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORE_MEDIATOR__ADDITIONAL_NAMESPACES = EsbPackage.MEDIATOR__ADDITIONAL_NAMESPACES;

	/**
	 * The feature id for the '<em><b>Current Esb Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORE_MEDIATOR__CURRENT_ESB_VERSION = EsbPackage.MEDIATOR__CURRENT_ESB_VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORE_MEDIATOR__COMMENT = EsbPackage.MEDIATOR__COMMENT;

	/**
	 * The feature id for the '<em><b>Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORE_MEDIATOR__DESCRIPTION = EsbPackage.MEDIATOR__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Message Store</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORE_MEDIATOR__MESSAGE_STORE = EsbPackage.MEDIATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>On Store Sequence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORE_MEDIATOR__ON_STORE_SEQUENCE = EsbPackage.MEDIATOR_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Store Mediator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORE_MEDIATOR_FEATURE_COUNT = EsbPackage.MEDIATOR_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.ConditionalRouteBranchImpl <em>Conditional Route Branch</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.ConditionalRouteBranchImpl
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getConditionalRouteBranch()
	 * @generated
	 */
	int CONDITIONAL_ROUTE_BRANCH = 85;

	/**
	 * The feature id for the '<em><b>Object State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_ROUTE_BRANCH__OBJECT_STATE = EsbPackage.MEDIATOR_BRANCH__OBJECT_STATE;

	/**
	 * The feature id for the '<em><b>Source Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_ROUTE_BRANCH__SOURCE_TEXT = EsbPackage.MEDIATOR_BRANCH__SOURCE_TEXT;

	/**
	 * The feature id for the '<em><b>Default Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_ROUTE_BRANCH__DEFAULT_NAMESPACE = EsbPackage.MEDIATOR_BRANCH__DEFAULT_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Additional Namespaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_ROUTE_BRANCH__ADDITIONAL_NAMESPACES = EsbPackage.MEDIATOR_BRANCH__ADDITIONAL_NAMESPACES;

	/**
	 * The feature id for the '<em><b>Current Esb Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_ROUTE_BRANCH__CURRENT_ESB_VERSION = EsbPackage.MEDIATOR_BRANCH__CURRENT_ESB_VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_ROUTE_BRANCH__COMMENT = EsbPackage.MEDIATOR_BRANCH__COMMENT;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_ROUTE_BRANCH__CHILDREN = EsbPackage.MEDIATOR_BRANCH__CHILDREN;

	/**
	 * The feature id for the '<em><b>Break After Route</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_ROUTE_BRANCH__BREAK_AFTER_ROUTE = EsbPackage.MEDIATOR_BRANCH_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Evaluator Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_ROUTE_BRANCH__EVALUATOR_EXPRESSION = EsbPackage.MEDIATOR_BRANCH_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Target Sequence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_ROUTE_BRANCH__TARGET_SEQUENCE = EsbPackage.MEDIATOR_BRANCH_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Conditional Route Branch</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_ROUTE_BRANCH_FEATURE_COUNT = EsbPackage.MEDIATOR_BRANCH_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.ConditionalRouterMediatorImpl <em>Conditional Router Mediator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.ConditionalRouterMediatorImpl
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getConditionalRouterMediator()
	 * @generated
	 */
	int CONDITIONAL_ROUTER_MEDIATOR = 86;

	/**
	 * The feature id for the '<em><b>Object State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_ROUTER_MEDIATOR__OBJECT_STATE = EsbPackage.MEDIATOR__OBJECT_STATE;

	/**
	 * The feature id for the '<em><b>Source Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_ROUTER_MEDIATOR__SOURCE_TEXT = EsbPackage.MEDIATOR__SOURCE_TEXT;

	/**
	 * The feature id for the '<em><b>Default Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_ROUTER_MEDIATOR__DEFAULT_NAMESPACE = EsbPackage.MEDIATOR__DEFAULT_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Additional Namespaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_ROUTER_MEDIATOR__ADDITIONAL_NAMESPACES = EsbPackage.MEDIATOR__ADDITIONAL_NAMESPACES;

	/**
	 * The feature id for the '<em><b>Current Esb Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_ROUTER_MEDIATOR__CURRENT_ESB_VERSION = EsbPackage.MEDIATOR__CURRENT_ESB_VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_ROUTER_MEDIATOR__COMMENT = EsbPackage.MEDIATOR__COMMENT;

	/**
	 * The feature id for the '<em><b>Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_ROUTER_MEDIATOR__DESCRIPTION = EsbPackage.MEDIATOR__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Continue After Route</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_ROUTER_MEDIATOR__CONTINUE_AFTER_ROUTE = EsbPackage.MEDIATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Conditional Route Braches</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_ROUTER_MEDIATOR__CONDITIONAL_ROUTE_BRACHES = EsbPackage.MEDIATOR_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Conditional Router Mediator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_ROUTER_MEDIATOR_FEATURE_COUNT = EsbPackage.MEDIATOR_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.URLRewriteRuleActionImpl <em>URL Rewrite Rule Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.URLRewriteRuleActionImpl
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getURLRewriteRuleAction()
	 * @generated
	 */
	int URL_REWRITE_RULE_ACTION = 87;

	/**
	 * The feature id for the '<em><b>Object State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URL_REWRITE_RULE_ACTION__OBJECT_STATE = EsbPackage.MODEL_OBJECT__OBJECT_STATE;

	/**
	 * The feature id for the '<em><b>Source Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URL_REWRITE_RULE_ACTION__SOURCE_TEXT = EsbPackage.MODEL_OBJECT__SOURCE_TEXT;

	/**
	 * The feature id for the '<em><b>Default Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URL_REWRITE_RULE_ACTION__DEFAULT_NAMESPACE = EsbPackage.MODEL_OBJECT__DEFAULT_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Additional Namespaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URL_REWRITE_RULE_ACTION__ADDITIONAL_NAMESPACES = EsbPackage.MODEL_OBJECT__ADDITIONAL_NAMESPACES;

	/**
	 * The feature id for the '<em><b>Current Esb Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URL_REWRITE_RULE_ACTION__CURRENT_ESB_VERSION = EsbPackage.MODEL_OBJECT__CURRENT_ESB_VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URL_REWRITE_RULE_ACTION__COMMENT = EsbPackage.MODEL_OBJECT__COMMENT;

	/**
	 * The feature id for the '<em><b>Rule Action</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URL_REWRITE_RULE_ACTION__RULE_ACTION = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Rule Fragment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URL_REWRITE_RULE_ACTION__RULE_FRAGMENT = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Rule Option</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URL_REWRITE_RULE_ACTION__RULE_OPTION = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Action Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URL_REWRITE_RULE_ACTION__ACTION_EXPRESSION = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Action Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URL_REWRITE_RULE_ACTION__ACTION_VALUE = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Action Regex</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URL_REWRITE_RULE_ACTION__ACTION_REGEX = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>URL Rewrite Rule Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URL_REWRITE_RULE_ACTION_FEATURE_COUNT = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.URLRewriteRuleImpl <em>URL Rewrite Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.URLRewriteRuleImpl
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getURLRewriteRule()
	 * @generated
	 */
	int URL_REWRITE_RULE = 88;

	/**
	 * The feature id for the '<em><b>Object State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URL_REWRITE_RULE__OBJECT_STATE = EsbPackage.MODEL_OBJECT__OBJECT_STATE;

	/**
	 * The feature id for the '<em><b>Source Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URL_REWRITE_RULE__SOURCE_TEXT = EsbPackage.MODEL_OBJECT__SOURCE_TEXT;

	/**
	 * The feature id for the '<em><b>Default Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URL_REWRITE_RULE__DEFAULT_NAMESPACE = EsbPackage.MODEL_OBJECT__DEFAULT_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Additional Namespaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URL_REWRITE_RULE__ADDITIONAL_NAMESPACES = EsbPackage.MODEL_OBJECT__ADDITIONAL_NAMESPACES;

	/**
	 * The feature id for the '<em><b>Current Esb Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URL_REWRITE_RULE__CURRENT_ESB_VERSION = EsbPackage.MODEL_OBJECT__CURRENT_ESB_VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URL_REWRITE_RULE__COMMENT = EsbPackage.MODEL_OBJECT__COMMENT;

	/**
	 * The feature id for the '<em><b>Url Rewrite Rule Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URL_REWRITE_RULE__URL_REWRITE_RULE_CONDITION = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Rewrite Rule Action</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URL_REWRITE_RULE__REWRITE_RULE_ACTION = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>URL Rewrite Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URL_REWRITE_RULE_FEATURE_COUNT = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.URLRewriteMediatorImpl <em>URL Rewrite Mediator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.URLRewriteMediatorImpl
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getURLRewriteMediator()
	 * @generated
	 */
	int URL_REWRITE_MEDIATOR = 89;

	/**
	 * The feature id for the '<em><b>Object State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URL_REWRITE_MEDIATOR__OBJECT_STATE = EsbPackage.MEDIATOR__OBJECT_STATE;

	/**
	 * The feature id for the '<em><b>Source Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URL_REWRITE_MEDIATOR__SOURCE_TEXT = EsbPackage.MEDIATOR__SOURCE_TEXT;

	/**
	 * The feature id for the '<em><b>Default Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URL_REWRITE_MEDIATOR__DEFAULT_NAMESPACE = EsbPackage.MEDIATOR__DEFAULT_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Additional Namespaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URL_REWRITE_MEDIATOR__ADDITIONAL_NAMESPACES = EsbPackage.MEDIATOR__ADDITIONAL_NAMESPACES;

	/**
	 * The feature id for the '<em><b>Current Esb Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URL_REWRITE_MEDIATOR__CURRENT_ESB_VERSION = EsbPackage.MEDIATOR__CURRENT_ESB_VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URL_REWRITE_MEDIATOR__COMMENT = EsbPackage.MEDIATOR__COMMENT;

	/**
	 * The feature id for the '<em><b>Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URL_REWRITE_MEDIATOR__DESCRIPTION = EsbPackage.MEDIATOR__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Url Rewrite Rules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URL_REWRITE_MEDIATOR__URL_REWRITE_RULES = EsbPackage.MEDIATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>In Property</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URL_REWRITE_MEDIATOR__IN_PROPERTY = EsbPackage.MEDIATOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Out Property</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URL_REWRITE_MEDIATOR__OUT_PROPERTY = EsbPackage.MEDIATOR_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>URL Rewrite Mediator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URL_REWRITE_MEDIATOR_FEATURE_COUNT = EsbPackage.MEDIATOR_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.CallTemplateMediatorImpl <em>Call Template Mediator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.CallTemplateMediatorImpl
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getCallTemplateMediator()
	 * @generated
	 */
	int CALL_TEMPLATE_MEDIATOR = 90;

	/**
	 * The feature id for the '<em><b>Object State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_TEMPLATE_MEDIATOR__OBJECT_STATE = EsbPackage.MEDIATOR__OBJECT_STATE;

	/**
	 * The feature id for the '<em><b>Source Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_TEMPLATE_MEDIATOR__SOURCE_TEXT = EsbPackage.MEDIATOR__SOURCE_TEXT;

	/**
	 * The feature id for the '<em><b>Default Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_TEMPLATE_MEDIATOR__DEFAULT_NAMESPACE = EsbPackage.MEDIATOR__DEFAULT_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Additional Namespaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_TEMPLATE_MEDIATOR__ADDITIONAL_NAMESPACES = EsbPackage.MEDIATOR__ADDITIONAL_NAMESPACES;

	/**
	 * The feature id for the '<em><b>Current Esb Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_TEMPLATE_MEDIATOR__CURRENT_ESB_VERSION = EsbPackage.MEDIATOR__CURRENT_ESB_VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_TEMPLATE_MEDIATOR__COMMENT = EsbPackage.MEDIATOR__COMMENT;

	/**
	 * The feature id for the '<em><b>Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_TEMPLATE_MEDIATOR__DESCRIPTION = EsbPackage.MEDIATOR__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Target Template</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_TEMPLATE_MEDIATOR__TARGET_TEMPLATE = EsbPackage.MEDIATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Template Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_TEMPLATE_MEDIATOR__TEMPLATE_PARAMETERS = EsbPackage.MEDIATOR_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Call Template Mediator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_TEMPLATE_MEDIATOR_FEATURE_COUNT = EsbPackage.MEDIATOR_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.CallTemplateParameterImpl <em>Call Template Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.CallTemplateParameterImpl
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getCallTemplateParameter()
	 * @generated
	 */
	int CALL_TEMPLATE_PARAMETER = 91;

	/**
	 * The feature id for the '<em><b>Object State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_TEMPLATE_PARAMETER__OBJECT_STATE = EsbPackage.MODEL_OBJECT__OBJECT_STATE;

	/**
	 * The feature id for the '<em><b>Source Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_TEMPLATE_PARAMETER__SOURCE_TEXT = EsbPackage.MODEL_OBJECT__SOURCE_TEXT;

	/**
	 * The feature id for the '<em><b>Default Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_TEMPLATE_PARAMETER__DEFAULT_NAMESPACE = EsbPackage.MODEL_OBJECT__DEFAULT_NAMESPACE;

	/**
	 * The feature id for the '<em><b>Additional Namespaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_TEMPLATE_PARAMETER__ADDITIONAL_NAMESPACES = EsbPackage.MODEL_OBJECT__ADDITIONAL_NAMESPACES;

	/**
	 * The feature id for the '<em><b>Current Esb Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_TEMPLATE_PARAMETER__CURRENT_ESB_VERSION = EsbPackage.MODEL_OBJECT__CURRENT_ESB_VERSION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_TEMPLATE_PARAMETER__COMMENT = EsbPackage.MODEL_OBJECT__COMMENT;

	/**
	 * The feature id for the '<em><b>Parameter Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_TEMPLATE_PARAMETER__PARAMETER_NAME = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Template Parameter Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_TEMPLATE_PARAMETER__TEMPLATE_PARAMETER_TYPE = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Parameter Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_TEMPLATE_PARAMETER__PARAMETER_VALUE = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Parameter Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_TEMPLATE_PARAMETER__PARAMETER_EXPRESSION = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Call Template Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_TEMPLATE_PARAMETER_FEATURE_COUNT = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.PayloadFactoryMediatorImpl <em>Payload Factory Mediator</em>}' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.PayloadFactoryMediatorImpl
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getPayloadFactoryMediator()
	 * @generated
	 */
    int PAYLOAD_FACTORY_MEDIATOR = 92;

    /**
	 * The feature id for the '<em><b>Object State</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int PAYLOAD_FACTORY_MEDIATOR__OBJECT_STATE = EsbPackage.MEDIATOR__OBJECT_STATE;

    /**
	 * The feature id for the '<em><b>Source Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int PAYLOAD_FACTORY_MEDIATOR__SOURCE_TEXT = EsbPackage.MEDIATOR__SOURCE_TEXT;

    /**
	 * The feature id for the '<em><b>Default Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int PAYLOAD_FACTORY_MEDIATOR__DEFAULT_NAMESPACE = EsbPackage.MEDIATOR__DEFAULT_NAMESPACE;

    /**
	 * The feature id for the '<em><b>Additional Namespaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int PAYLOAD_FACTORY_MEDIATOR__ADDITIONAL_NAMESPACES = EsbPackage.MEDIATOR__ADDITIONAL_NAMESPACES;

    /**
	 * The feature id for the '<em><b>Current Esb Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int PAYLOAD_FACTORY_MEDIATOR__CURRENT_ESB_VERSION = EsbPackage.MEDIATOR__CURRENT_ESB_VERSION;

    /**
	 * The feature id for the '<em><b>Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAYLOAD_FACTORY_MEDIATOR__COMMENT = EsbPackage.MEDIATOR__COMMENT;

				/**
	 * The feature id for the '<em><b>Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAYLOAD_FACTORY_MEDIATOR__DESCRIPTION = EsbPackage.MEDIATOR__DESCRIPTION;

				/**
	 * The feature id for the '<em><b>Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int PAYLOAD_FACTORY_MEDIATOR__FORMAT = EsbPackage.MEDIATOR_FEATURE_COUNT + 0;

    /**
	 * The feature id for the '<em><b>Args</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int PAYLOAD_FACTORY_MEDIATOR__ARGS = EsbPackage.MEDIATOR_FEATURE_COUNT + 1;

    /**
	 * The number of structural features of the '<em>Payload Factory Mediator</em>' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int PAYLOAD_FACTORY_MEDIATOR_FEATURE_COUNT = EsbPackage.MEDIATOR_FEATURE_COUNT + 2;

    /**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.PayloadFactoryArgumentImpl <em>Payload Factory Argument</em>}' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.PayloadFactoryArgumentImpl
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getPayloadFactoryArgument()
	 * @generated
	 */
    int PAYLOAD_FACTORY_ARGUMENT = 93;

    /**
	 * The feature id for the '<em><b>Object State</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int PAYLOAD_FACTORY_ARGUMENT__OBJECT_STATE = EsbPackage.MODEL_OBJECT__OBJECT_STATE;

    /**
	 * The feature id for the '<em><b>Source Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int PAYLOAD_FACTORY_ARGUMENT__SOURCE_TEXT = EsbPackage.MODEL_OBJECT__SOURCE_TEXT;

    /**
	 * The feature id for the '<em><b>Default Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int PAYLOAD_FACTORY_ARGUMENT__DEFAULT_NAMESPACE = EsbPackage.MODEL_OBJECT__DEFAULT_NAMESPACE;

    /**
	 * The feature id for the '<em><b>Additional Namespaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int PAYLOAD_FACTORY_ARGUMENT__ADDITIONAL_NAMESPACES = EsbPackage.MODEL_OBJECT__ADDITIONAL_NAMESPACES;

    /**
	 * The feature id for the '<em><b>Current Esb Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int PAYLOAD_FACTORY_ARGUMENT__CURRENT_ESB_VERSION = EsbPackage.MODEL_OBJECT__CURRENT_ESB_VERSION;

    /**
	 * The feature id for the '<em><b>Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAYLOAD_FACTORY_ARGUMENT__COMMENT = EsbPackage.MODEL_OBJECT__COMMENT;

				/**
	 * The feature id for the '<em><b>Argument Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int PAYLOAD_FACTORY_ARGUMENT__ARGUMENT_TYPE = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 0;

    /**
	 * The feature id for the '<em><b>Argument Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int PAYLOAD_FACTORY_ARGUMENT__ARGUMENT_VALUE = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 1;

    /**
	 * The feature id for the '<em><b>Argument Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int PAYLOAD_FACTORY_ARGUMENT__ARGUMENT_EXPRESSION = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 2;

    /**
	 * The number of structural features of the '<em>Payload Factory Argument</em>' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int PAYLOAD_FACTORY_ARGUMENT_FEATURE_COUNT = EsbPackage.MODEL_OBJECT_FEATURE_COUNT + 3;

    /**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.LogCategory <em>Log Category</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.LogCategory
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getLogCategory()
	 * @generated
	 */
	int LOG_CATEGORY = 94;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.LogLevel <em>Log Level</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.LogLevel
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getLogLevel()
	 * @generated
	 */
	int LOG_LEVEL = 95;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.FilterConditionType <em>Filter Condition Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.FilterConditionType
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getFilterConditionType()
	 * @generated
	 */
	int FILTER_CONDITION_TYPE = 96;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.EntitlementSequence <em>Entitlement Sequence</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.EntitlementSequence
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getEntitlementSequence()
	 * @generated
	 */
	int ENTITLEMENT_SEQUENCE = 97;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.ScriptType <em>Script Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ScriptType
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getScriptType()
	 * @generated
	 */
	int SCRIPT_TYPE = 98;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.ScriptLanguage <em>Script Language</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ScriptLanguage
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getScriptLanguage()
	 * @generated
	 */
	int SCRIPT_LANGUAGE = 99;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.EnrichSourceType <em>Enrich Source Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.EnrichSourceType
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getEnrichSourceType()
	 * @generated
	 */
	int ENRICH_SOURCE_TYPE = 100;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.EnrichTargetAction <em>Enrich Target Action</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.EnrichTargetAction
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getEnrichTargetAction()
	 * @generated
	 */
	int ENRICH_TARGET_ACTION = 101;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.EnrichTargetType <em>Enrich Target Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.EnrichTargetType
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getEnrichTargetType()
	 * @generated
	 */
	int ENRICH_TARGET_TYPE = 102;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.FaultSoapVersion <em>Fault Soap Version</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.FaultSoapVersion
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getFaultSoapVersion()
	 * @generated
	 */
	int FAULT_SOAP_VERSION = 103;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.FaultCodeSoap11 <em>Fault Code Soap11</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.FaultCodeSoap11
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getFaultCodeSoap11()
	 * @generated
	 */
	int FAULT_CODE_SOAP11 = 104;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.FaultCodeSoap12 <em>Fault Code Soap12</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.FaultCodeSoap12
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getFaultCodeSoap12()
	 * @generated
	 */
	int FAULT_CODE_SOAP12 = 105;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.FaultStringType <em>Fault String Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.FaultStringType
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getFaultStringType()
	 * @generated
	 */
	int FAULT_STRING_TYPE = 106;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.FaultReasonType <em>Fault Reason Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.FaultReasonType
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getFaultReasonType()
	 * @generated
	 */
	int FAULT_REASON_TYPE = 107;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.FaultDetailType <em>Fault Detail Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.FaultDetailType
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getFaultDetailType()
	 * @generated
	 */
	int FAULT_DETAIL_TYPE = 108;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.AggregateSequenceType <em>Aggregate Sequence Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.AggregateSequenceType
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getAggregateSequenceType()
	 * @generated
	 */
	int AGGREGATE_SEQUENCE_TYPE = 109;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.CacheSequenceType <em>Cache Sequence Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CacheSequenceType
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getCacheSequenceType()
	 * @generated
	 */
	int CACHE_SEQUENCE_TYPE = 110;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.CacheImplementationType <em>Cache Implementation Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CacheImplementationType
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getCacheImplementationType()
	 * @generated
	 */
	int CACHE_IMPLEMENTATION_TYPE = 111;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.CacheAction <em>Cache Action</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CacheAction
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getCacheAction()
	 * @generated
	 */
	int CACHE_ACTION = 112;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.CacheScope <em>Cache Scope</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CacheScope
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getCacheScope()
	 * @generated
	 */
	int CACHE_SCOPE = 113;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.XQueryVariableType <em>XQuery Variable Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.XQueryVariableType
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getXQueryVariableType()
	 * @generated
	 */
	int XQUERY_VARIABLE_TYPE = 114;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.XQueryVariableValueType <em>XQuery Variable Value Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.XQueryVariableValueType
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getXQueryVariableValueType()
	 * @generated
	 */
	int XQUERY_VARIABLE_VALUE_TYPE = 115;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.CalloutPayloadType <em>Callout Payload Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CalloutPayloadType
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getCalloutPayloadType()
	 * @generated
	 */
	int CALLOUT_PAYLOAD_TYPE = 116;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.CalloutResultType <em>Callout Result Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CalloutResultType
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getCalloutResultType()
	 * @generated
	 */
	int CALLOUT_RESULT_TYPE = 117;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.RMSpecVersion <em>RM Spec Version</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RMSpecVersion
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getRMSpecVersion()
	 * @generated
	 */
	int RM_SPEC_VERSION = 118;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.RMSequenceType <em>RM Sequence Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RMSequenceType
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getRMSequenceType()
	 * @generated
	 */
	int RM_SEQUENCE_TYPE = 119;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.TransactionAction <em>Transaction Action</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.TransactionAction
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getTransactionAction()
	 * @generated
	 */
	int TRANSACTION_ACTION = 120;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.PropertyDataType <em>Property Data Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.PropertyDataType
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getPropertyDataType()
	 * @generated
	 */
	int PROPERTY_DATA_TYPE = 121;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.PropertyAction <em>Property Action</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.PropertyAction
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getPropertyAction()
	 * @generated
	 */
	int PROPERTY_ACTION = 122;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.PropertyScope <em>Property Scope</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.PropertyScope
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getPropertyScope()
	 * @generated
	 */
	int PROPERTY_SCOPE = 123;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.PropertyValueType <em>Property Value Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.PropertyValueType
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getPropertyValueType()
	 * @generated
	 */
	int PROPERTY_VALUE_TYPE = 124;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.HeaderAction <em>Header Action</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.HeaderAction
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getHeaderAction()
	 * @generated
	 */
	int HEADER_ACTION = 125;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.HeaderValueType <em>Header Value Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.HeaderValueType
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getHeaderValueType()
	 * @generated
	 */
	int HEADER_VALUE_TYPE = 126;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.ThrottlePolicyType <em>Throttle Policy Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ThrottlePolicyType
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getThrottlePolicyType()
	 * @generated
	 */
	int THROTTLE_POLICY_TYPE = 127;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.ThrottleConditionType <em>Throttle Condition Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ThrottleConditionType
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getThrottleConditionType()
	 * @generated
	 */
	int THROTTLE_CONDITION_TYPE = 128;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.ThrottleAccessType <em>Throttle Access Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ThrottleAccessType
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getThrottleAccessType()
	 * @generated
	 */
	int THROTTLE_ACCESS_TYPE = 129;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.ThrottleSequenceType <em>Throttle Sequence Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ThrottleSequenceType
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getThrottleSequenceType()
	 * @generated
	 */
	int THROTTLE_SEQUENCE_TYPE = 130;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.CommandPropertyValueType <em>Command Property Value Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CommandPropertyValueType
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getCommandPropertyValueType()
	 * @generated
	 */
	int COMMAND_PROPERTY_VALUE_TYPE = 131;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.CommandPropertyMessageAction <em>Command Property Message Action</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CommandPropertyMessageAction
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getCommandPropertyMessageAction()
	 * @generated
	 */
	int COMMAND_PROPERTY_MESSAGE_ACTION = 132;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.CommandPropertyContextAction <em>Command Property Context Action</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CommandPropertyContextAction
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getCommandPropertyContextAction()
	 * @generated
	 */
	int COMMAND_PROPERTY_CONTEXT_ACTION = 133;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.SqlExecutorConnectionType <em>Sql Executor Connection Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.SqlExecutorConnectionType
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getSqlExecutorConnectionType()
	 * @generated
	 */
	int SQL_EXECUTOR_CONNECTION_TYPE = 134;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.SqlExecutorDatasourceType <em>Sql Executor Datasource Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.SqlExecutorDatasourceType
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getSqlExecutorDatasourceType()
	 * @generated
	 */
	int SQL_EXECUTOR_DATASOURCE_TYPE = 135;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.SqlExecutorBooleanValue <em>Sql Executor Boolean Value</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.SqlExecutorBooleanValue
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getSqlExecutorBooleanValue()
	 * @generated
	 */
	int SQL_EXECUTOR_BOOLEAN_VALUE = 136;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.SqlExecutorIsolationLevel <em>Sql Executor Isolation Level</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.SqlExecutorIsolationLevel
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getSqlExecutorIsolationLevel()
	 * @generated
	 */
	int SQL_EXECUTOR_ISOLATION_LEVEL = 137;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.SqlParameterValueType <em>Sql Parameter Value Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.SqlParameterValueType
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getSqlParameterValueType()
	 * @generated
	 */
	int SQL_PARAMETER_VALUE_TYPE = 138;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.SqlParameterDataType <em>Sql Parameter Data Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.SqlParameterDataType
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getSqlParameterDataType()
	 * @generated
	 */
	int SQL_PARAMETER_DATA_TYPE = 139;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.RuleSourceType <em>Rule Source Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RuleSourceType
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getRuleSourceType()
	 * @generated
	 */
	int RULE_SOURCE_TYPE = 140;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.RuleFactType <em>Rule Fact Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RuleFactType
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getRuleFactType()
	 * @generated
	 */
	int RULE_FACT_TYPE = 141;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.RuleFactValueType <em>Rule Fact Value Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RuleFactValueType
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getRuleFactValueType()
	 * @generated
	 */
	int RULE_FACT_VALUE_TYPE = 142;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.RuleResultType <em>Rule Result Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RuleResultType
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getRuleResultType()
	 * @generated
	 */
	int RULE_RESULT_TYPE = 143;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.RuleResultValueType <em>Rule Result Value Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RuleResultValueType
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getRuleResultValueType()
	 * @generated
	 */
	int RULE_RESULT_VALUE_TYPE = 144;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.SmooksIODataType <em>Smooks IO Data Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.SmooksIODataType
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getSmooksIODataType()
	 * @generated
	 */
	int SMOOKS_IO_DATA_TYPE = 145;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.ExpressionAction <em>Expression Action</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ExpressionAction
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getExpressionAction()
	 * @generated
	 */
	int EXPRESSION_ACTION = 146;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.OutputMethod <em>Output Method</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.OutputMethod
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getOutputMethod()
	 * @generated
	 */
	int OUTPUT_METHOD = 147;


	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.ReceivingSequenceType <em>Receiving Sequence Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ReceivingSequenceType
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getReceivingSequenceType()
	 * @generated
	 */
	int RECEIVING_SEQUENCE_TYPE = 148;


	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.KeyType <em>Key Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.KeyType
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getKeyType()
	 * @generated
	 */
	int KEY_TYPE = 149;


	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.RuleActionType <em>Rule Action Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RuleActionType
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getRuleActionType()
	 * @generated
	 */
	int RULE_ACTION_TYPE = 150;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.RuleFragmentType <em>Rule Fragment Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RuleFragmentType
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getRuleFragmentType()
	 * @generated
	 */
	int RULE_FRAGMENT_TYPE = 151;

	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.RuleOptionType <em>Rule Option Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RuleOptionType
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getRuleOptionType()
	 * @generated
	 */
	int RULE_OPTION_TYPE = 152;


	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.EnrichSourceInlineType <em>Enrich Source Inline Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.EnrichSourceInlineType
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getEnrichSourceInlineType()
	 * @generated
	 */
	int ENRICH_SOURCE_INLINE_TYPE = 153;


	/**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.PayloadFactoryArgumentType <em>Payload Factory Argument Type</em>}' enum.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.PayloadFactoryArgumentType
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getPayloadFactoryArgumentType()
	 * @generated
	 */
    int PAYLOAD_FACTORY_ARGUMENT_TYPE = 154;


    /**
	 * The meta object id for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.CallOutMediatorEndpointType <em>Call Out Mediator Endpoint Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CallOutMediatorEndpointType
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getCallOutMediatorEndpointType()
	 * @generated
	 */
	int CALL_OUT_MEDIATOR_ENDPOINT_TYPE = 155;


				/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.esb.mediators.InMediator <em>In Mediator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>In Mediator</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.InMediator
	 * @generated
	 */
	EClass getInMediator();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.esb.mediators.OutMediator <em>Out Mediator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Out Mediator</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.OutMediator
	 * @generated
	 */
	EClass getOutMediator();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.esb.mediators.DropMediator <em>Drop Mediator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Drop Mediator</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.DropMediator
	 * @generated
	 */
	EClass getDropMediator();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.esb.mediators.SendMediator <em>Send Mediator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Send Mediator</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.SendMediator
	 * @generated
	 */
	EClass getSendMediator();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.esb.mediators.SendMediator#getAnonymousEndPoint <em>Anonymous End Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Anonymous End Point</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.SendMediator#getAnonymousEndPoint()
	 * @see #getSendMediator()
	 * @generated
	 */
	EReference getSendMediator_AnonymousEndPoint();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.esb.mediators.SendMediator#getEndPointReference <em>End Point Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>End Point Reference</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.SendMediator#getEndPointReference()
	 * @see #getSendMediator()
	 * @generated
	 */
	EReference getSendMediator_EndPointReference();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.SendMediator#getReceivingSequenceType <em>Receiving Sequence Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Receiving Sequence Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.SendMediator#getReceivingSequenceType()
	 * @see #getSendMediator()
	 * @generated
	 */
	EAttribute getSendMediator_ReceivingSequenceType();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.esb.mediators.SendMediator#getStaticReceivingSequence <em>Static Receiving Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Static Receiving Sequence</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.SendMediator#getStaticReceivingSequence()
	 * @see #getSendMediator()
	 * @generated
	 */
	EReference getSendMediator_StaticReceivingSequence();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.esb.mediators.SendMediator#getDynamicReceivingSequence <em>Dynamic Receiving Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Dynamic Receiving Sequence</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.SendMediator#getDynamicReceivingSequence()
	 * @see #getSendMediator()
	 * @generated
	 */
	EReference getSendMediator_DynamicReceivingSequence();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.esb.mediators.LogMediator <em>Log Mediator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Log Mediator</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.LogMediator
	 * @generated
	 */
	EClass getLogMediator();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.LogMediator#getLogCategory <em>Log Category</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Log Category</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.LogMediator#getLogCategory()
	 * @see #getLogMediator()
	 * @generated
	 */
	EAttribute getLogMediator_LogCategory();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.LogMediator#getLogLevel <em>Log Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Log Level</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.LogMediator#getLogLevel()
	 * @see #getLogMediator()
	 * @generated
	 */
	EAttribute getLogMediator_LogLevel();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.LogMediator#getLogSeparator <em>Log Separator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Log Separator</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.LogMediator#getLogSeparator()
	 * @see #getLogMediator()
	 * @generated
	 */
	EAttribute getLogMediator_LogSeparator();

	/**
	 * Returns the meta object for the containment reference list '{@link org.wso2.developerstudio.eclipse.esb.mediators.LogMediator#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Properties</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.LogMediator#getProperties()
	 * @see #getLogMediator()
	 * @generated
	 */
	EReference getLogMediator_Properties();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.esb.mediators.LogProperty <em>Log Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Log Property</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.LogProperty
	 * @generated
	 */
	EClass getLogProperty();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.esb.mediators.FilterMediator <em>Filter Mediator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Filter Mediator</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.FilterMediator
	 * @generated
	 */
	EClass getFilterMediator();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.FilterMediator#getConditionType <em>Condition Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Condition Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.FilterMediator#getConditionType()
	 * @see #getFilterMediator()
	 * @generated
	 */
	EAttribute getFilterMediator_ConditionType();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.esb.mediators.FilterMediator#getFilterXpath <em>Filter Xpath</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Filter Xpath</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.FilterMediator#getFilterXpath()
	 * @see #getFilterMediator()
	 * @generated
	 */
	EReference getFilterMediator_FilterXpath();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.esb.mediators.FilterMediator#getFilterSource <em>Filter Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Filter Source</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.FilterMediator#getFilterSource()
	 * @see #getFilterMediator()
	 * @generated
	 */
	EReference getFilterMediator_FilterSource();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.FilterMediator#getFilterRegex <em>Filter Regex</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Filter Regex</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.FilterMediator#getFilterRegex()
	 * @see #getFilterMediator()
	 * @generated
	 */
	EAttribute getFilterMediator_FilterRegex();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.esb.mediators.FilterMediator#getThenBranch <em>Then Branch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Then Branch</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.FilterMediator#getThenBranch()
	 * @see #getFilterMediator()
	 * @generated
	 */
	EReference getFilterMediator_ThenBranch();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.esb.mediators.FilterMediator#getElseBranch <em>Else Branch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Else Branch</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.FilterMediator#getElseBranch()
	 * @see #getFilterMediator()
	 * @generated
	 */
	EReference getFilterMediator_ElseBranch();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.esb.mediators.FilterThenBranch <em>Filter Then Branch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Filter Then Branch</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.FilterThenBranch
	 * @generated
	 */
	EClass getFilterThenBranch();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.esb.mediators.FilterElseBranch <em>Filter Else Branch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Filter Else Branch</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.FilterElseBranch
	 * @generated
	 */
	EClass getFilterElseBranch();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.esb.mediators.SwitchMediator <em>Switch Mediator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Switch Mediator</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.SwitchMediator
	 * @generated
	 */
	EClass getSwitchMediator();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.esb.mediators.SwitchMediator#getSourceXpath <em>Source Xpath</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Source Xpath</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.SwitchMediator#getSourceXpath()
	 * @see #getSwitchMediator()
	 * @generated
	 */
	EReference getSwitchMediator_SourceXpath();

	/**
	 * Returns the meta object for the containment reference list '{@link org.wso2.developerstudio.eclipse.esb.mediators.SwitchMediator#getCaseBranches <em>Case Branches</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Case Branches</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.SwitchMediator#getCaseBranches()
	 * @see #getSwitchMediator()
	 * @generated
	 */
	EReference getSwitchMediator_CaseBranches();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.esb.mediators.SwitchMediator#getDefaultBranch <em>Default Branch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Default Branch</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.SwitchMediator#getDefaultBranch()
	 * @see #getSwitchMediator()
	 * @generated
	 */
	EReference getSwitchMediator_DefaultBranch();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.esb.mediators.SwitchCaseBranch <em>Switch Case Branch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Switch Case Branch</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.SwitchCaseBranch
	 * @generated
	 */
	EClass getSwitchCaseBranch();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.SwitchCaseBranch#getCaseRegex <em>Case Regex</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Case Regex</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.SwitchCaseBranch#getCaseRegex()
	 * @see #getSwitchCaseBranch()
	 * @generated
	 */
	EAttribute getSwitchCaseBranch_CaseRegex();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.esb.mediators.SwitchDefaultBranch <em>Switch Default Branch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Switch Default Branch</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.SwitchDefaultBranch
	 * @generated
	 */
	EClass getSwitchDefaultBranch();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.esb.mediators.EntitlementMediator <em>Entitlement Mediator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entitlement Mediator</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.EntitlementMediator
	 * @generated
	 */
	EClass getEntitlementMediator();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.EntitlementMediator#getServerURL <em>Server URL</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Server URL</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.EntitlementMediator#getServerURL()
	 * @see #getEntitlementMediator()
	 * @generated
	 */
	EAttribute getEntitlementMediator_ServerURL();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.EntitlementMediator#getUsername <em>Username</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Username</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.EntitlementMediator#getUsername()
	 * @see #getEntitlementMediator()
	 * @generated
	 */
	EAttribute getEntitlementMediator_Username();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.EntitlementMediator#getPassword <em>Password</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Password</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.EntitlementMediator#getPassword()
	 * @see #getEntitlementMediator()
	 * @generated
	 */
	EAttribute getEntitlementMediator_Password();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.esb.mediators.EntitlementMediator#getOnAccept <em>On Accept</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>On Accept</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.EntitlementMediator#getOnAccept()
	 * @see #getEntitlementMediator()
	 * @generated
	 */
	EReference getEntitlementMediator_OnAccept();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.esb.mediators.EntitlementMediator#getOnReject <em>On Reject</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>On Reject</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.EntitlementMediator#getOnReject()
	 * @see #getEntitlementMediator()
	 * @generated
	 */
	EReference getEntitlementMediator_OnReject();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.esb.mediators.EntitlementMediator#getObligations <em>Obligations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Obligations</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.EntitlementMediator#getObligations()
	 * @see #getEntitlementMediator()
	 * @generated
	 */
	EReference getEntitlementMediator_Obligations();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.esb.mediators.EntitlementMediator#getAdvice <em>Advice</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Advice</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.EntitlementMediator#getAdvice()
	 * @see #getEntitlementMediator()
	 * @generated
	 */
	EReference getEntitlementMediator_Advice();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.EntitlementMediator#getCallbackClass <em>Callback Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Callback Class</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.EntitlementMediator#getCallbackClass()
	 * @see #getEntitlementMediator()
	 * @generated
	 */
	EAttribute getEntitlementMediator_CallbackClass();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.esb.mediators.EntitlementAdviceBranch <em>Entitlement Advice Branch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entitlement Advice Branch</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.EntitlementAdviceBranch
	 * @generated
	 */
	EClass getEntitlementAdviceBranch();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.EntitlementAdviceBranch#getSequenceType <em>Sequence Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sequence Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.EntitlementAdviceBranch#getSequenceType()
	 * @see #getEntitlementAdviceBranch()
	 * @generated
	 */
	EAttribute getEntitlementAdviceBranch_SequenceType();

	/**
	 * Returns the meta object for the reference '{@link org.wso2.developerstudio.eclipse.esb.mediators.EntitlementAdviceBranch#getSequenceKey <em>Sequence Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Sequence Key</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.EntitlementAdviceBranch#getSequenceKey()
	 * @see #getEntitlementAdviceBranch()
	 * @generated
	 */
	EReference getEntitlementAdviceBranch_SequenceKey();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.esb.mediators.EntitlementObligationsBranch <em>Entitlement Obligations Branch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entitlement Obligations Branch</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.EntitlementObligationsBranch
	 * @generated
	 */
	EClass getEntitlementObligationsBranch();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.EntitlementObligationsBranch#getSequenceType <em>Sequence Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sequence Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.EntitlementObligationsBranch#getSequenceType()
	 * @see #getEntitlementObligationsBranch()
	 * @generated
	 */
	EAttribute getEntitlementObligationsBranch_SequenceType();

	/**
	 * Returns the meta object for the reference '{@link org.wso2.developerstudio.eclipse.esb.mediators.EntitlementObligationsBranch#getSequenceKey <em>Sequence Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Sequence Key</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.EntitlementObligationsBranch#getSequenceKey()
	 * @see #getEntitlementObligationsBranch()
	 * @generated
	 */
	EReference getEntitlementObligationsBranch_SequenceKey();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.esb.mediators.EntitlementMediatorOnRejectBranch <em>Entitlement Mediator On Reject Branch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entitlement Mediator On Reject Branch</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.EntitlementMediatorOnRejectBranch
	 * @generated
	 */
	EClass getEntitlementMediatorOnRejectBranch();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.EntitlementMediatorOnRejectBranch#getSequenceType <em>Sequence Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sequence Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.EntitlementMediatorOnRejectBranch#getSequenceType()
	 * @see #getEntitlementMediatorOnRejectBranch()
	 * @generated
	 */
	EAttribute getEntitlementMediatorOnRejectBranch_SequenceType();

	/**
	 * Returns the meta object for the reference '{@link org.wso2.developerstudio.eclipse.esb.mediators.EntitlementMediatorOnRejectBranch#getSequenceKey <em>Sequence Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Sequence Key</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.EntitlementMediatorOnRejectBranch#getSequenceKey()
	 * @see #getEntitlementMediatorOnRejectBranch()
	 * @generated
	 */
	EReference getEntitlementMediatorOnRejectBranch_SequenceKey();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.esb.mediators.EntitlementMediatorOnAcceptBranch <em>Entitlement Mediator On Accept Branch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entitlement Mediator On Accept Branch</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.EntitlementMediatorOnAcceptBranch
	 * @generated
	 */
	EClass getEntitlementMediatorOnAcceptBranch();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.EntitlementMediatorOnAcceptBranch#getSequenceType <em>Sequence Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sequence Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.EntitlementMediatorOnAcceptBranch#getSequenceType()
	 * @see #getEntitlementMediatorOnAcceptBranch()
	 * @generated
	 */
	EAttribute getEntitlementMediatorOnAcceptBranch_SequenceType();

	/**
	 * Returns the meta object for the reference '{@link org.wso2.developerstudio.eclipse.esb.mediators.EntitlementMediatorOnAcceptBranch#getSequenceKey <em>Sequence Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Sequence Key</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.EntitlementMediatorOnAcceptBranch#getSequenceKey()
	 * @see #getEntitlementMediatorOnAcceptBranch()
	 * @generated
	 */
	EReference getEntitlementMediatorOnAcceptBranch_SequenceKey();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.esb.mediators.EnqueueMediator <em>Enqueue Mediator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enqueue Mediator</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.EnqueueMediator
	 * @generated
	 */
	EClass getEnqueueMediator();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.EnqueueMediator#getExecutor <em>Executor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Executor</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.EnqueueMediator#getExecutor()
	 * @see #getEnqueueMediator()
	 * @generated
	 */
	EAttribute getEnqueueMediator_Executor();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.EnqueueMediator#getPriority <em>Priority</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Priority</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.EnqueueMediator#getPriority()
	 * @see #getEnqueueMediator()
	 * @generated
	 */
	EAttribute getEnqueueMediator_Priority();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.esb.mediators.EnqueueMediator#getSequenceKey <em>Sequence Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Sequence Key</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.EnqueueMediator#getSequenceKey()
	 * @see #getEnqueueMediator()
	 * @generated
	 */
	EReference getEnqueueMediator_SequenceKey();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.esb.mediators.ClassMediator <em>Class Mediator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class Mediator</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ClassMediator
	 * @generated
	 */
	EClass getClassMediator();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.ClassMediator#getClassName <em>Class Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Class Name</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ClassMediator#getClassName()
	 * @see #getClassMediator()
	 * @generated
	 */
	EAttribute getClassMediator_ClassName();

	/**
	 * Returns the meta object for the containment reference list '{@link org.wso2.developerstudio.eclipse.esb.mediators.ClassMediator#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Properties</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ClassMediator#getProperties()
	 * @see #getClassMediator()
	 * @generated
	 */
	EReference getClassMediator_Properties();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.esb.mediators.ClassProperty <em>Class Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class Property</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ClassProperty
	 * @generated
	 */
	EClass getClassProperty();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.esb.mediators.SpringMediator <em>Spring Mediator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Spring Mediator</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.SpringMediator
	 * @generated
	 */
	EClass getSpringMediator();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.SpringMediator#getBeanName <em>Bean Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bean Name</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.SpringMediator#getBeanName()
	 * @see #getSpringMediator()
	 * @generated
	 */
	EAttribute getSpringMediator_BeanName();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.esb.mediators.SpringMediator#getConfigurationKey <em>Configuration Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Configuration Key</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.SpringMediator#getConfigurationKey()
	 * @see #getSpringMediator()
	 * @generated
	 */
	EReference getSpringMediator_ConfigurationKey();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.esb.mediators.ValidateMediator <em>Validate Mediator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Validate Mediator</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ValidateMediator
	 * @generated
	 */
	EClass getValidateMediator();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.esb.mediators.ValidateMediator#getSourceXpath <em>Source Xpath</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Source Xpath</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ValidateMediator#getSourceXpath()
	 * @see #getValidateMediator()
	 * @generated
	 */
	EReference getValidateMediator_SourceXpath();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.esb.mediators.ValidateMediator#getOnFailBranch <em>On Fail Branch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>On Fail Branch</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ValidateMediator#getOnFailBranch()
	 * @see #getValidateMediator()
	 * @generated
	 */
	EReference getValidateMediator_OnFailBranch();

	/**
	 * Returns the meta object for the containment reference list '{@link org.wso2.developerstudio.eclipse.esb.mediators.ValidateMediator#getFeatures <em>Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Features</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ValidateMediator#getFeatures()
	 * @see #getValidateMediator()
	 * @generated
	 */
	EReference getValidateMediator_Features();

	/**
	 * Returns the meta object for the containment reference list '{@link org.wso2.developerstudio.eclipse.esb.mediators.ValidateMediator#getSchemas <em>Schemas</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Schemas</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ValidateMediator#getSchemas()
	 * @see #getValidateMediator()
	 * @generated
	 */
	EReference getValidateMediator_Schemas();

	/**
	 * Returns the meta object for the containment reference list '{@link org.wso2.developerstudio.eclipse.esb.mediators.ValidateMediator#getResources <em>Resources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Resources</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ValidateMediator#getResources()
	 * @see #getValidateMediator()
	 * @generated
	 */
	EReference getValidateMediator_Resources();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.esb.mediators.ValidateOnFailBranch <em>Validate On Fail Branch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Validate On Fail Branch</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ValidateOnFailBranch
	 * @generated
	 */
	EClass getValidateOnFailBranch();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.esb.mediators.ValidateFeature <em>Validate Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Validate Feature</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ValidateFeature
	 * @generated
	 */
	EClass getValidateFeature();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.esb.mediators.ValidateSchema <em>Validate Schema</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Validate Schema</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ValidateSchema
	 * @generated
	 */
	EClass getValidateSchema();

	/**
	 * Returns the meta object for the reference '{@link org.wso2.developerstudio.eclipse.esb.mediators.ValidateSchema#getValidateStaticSchemaKey <em>Validate Static Schema Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Validate Static Schema Key</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ValidateSchema#getValidateStaticSchemaKey()
	 * @see #getValidateSchema()
	 * @generated
	 */
	EReference getValidateSchema_ValidateStaticSchemaKey();

	/**
	 * Returns the meta object for the reference '{@link org.wso2.developerstudio.eclipse.esb.mediators.ValidateSchema#getValidateDynamicSchemaKey <em>Validate Dynamic Schema Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Validate Dynamic Schema Key</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ValidateSchema#getValidateDynamicSchemaKey()
	 * @see #getValidateSchema()
	 * @generated
	 */
	EReference getValidateSchema_ValidateDynamicSchemaKey();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.ValidateSchema#getValidateSchemaKeyType <em>Validate Schema Key Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Validate Schema Key Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ValidateSchema#getValidateSchemaKeyType()
	 * @see #getValidateSchema()
	 * @generated
	 */
	EAttribute getValidateSchema_ValidateSchemaKeyType();

	/**
	 * Returns the meta object for the reference '{@link org.wso2.developerstudio.eclipse.esb.mediators.ValidateSchema#getSchemaKey <em>Schema Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Schema Key</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ValidateSchema#getSchemaKey()
	 * @see #getValidateSchema()
	 * @generated
	 */
	EReference getValidateSchema_SchemaKey();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.esb.mediators.ValidateResource <em>Validate Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Validate Resource</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ValidateResource
	 * @generated
	 */
	EClass getValidateResource();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.esb.mediators.ScriptMediator <em>Script Mediator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Script Mediator</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ScriptMediator
	 * @generated
	 */
	EClass getScriptMediator();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.ScriptMediator#getScriptType <em>Script Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Script Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ScriptMediator#getScriptType()
	 * @see #getScriptMediator()
	 * @generated
	 */
	EAttribute getScriptMediator_ScriptType();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.ScriptMediator#getScriptLanguage <em>Script Language</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Script Language</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ScriptMediator#getScriptLanguage()
	 * @see #getScriptMediator()
	 * @generated
	 */
	EAttribute getScriptMediator_ScriptLanguage();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.ScriptMediator#getMediateFunction <em>Mediate Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mediate Function</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ScriptMediator#getMediateFunction()
	 * @see #getScriptMediator()
	 * @generated
	 */
	EAttribute getScriptMediator_MediateFunction();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.esb.mediators.ScriptMediator#getScriptKey <em>Script Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Script Key</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ScriptMediator#getScriptKey()
	 * @see #getScriptMediator()
	 * @generated
	 */
	EReference getScriptMediator_ScriptKey();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.ScriptMediator#getScriptBody <em>Script Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Script Body</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ScriptMediator#getScriptBody()
	 * @see #getScriptMediator()
	 * @generated
	 */
	EAttribute getScriptMediator_ScriptBody();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.esb.mediators.EnrichMediator <em>Enrich Mediator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enrich Mediator</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.EnrichMediator
	 * @generated
	 */
	EClass getEnrichMediator();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.EnrichMediator#isCloneSource <em>Clone Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Clone Source</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.EnrichMediator#isCloneSource()
	 * @see #getEnrichMediator()
	 * @generated
	 */
	EAttribute getEnrichMediator_CloneSource();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.EnrichMediator#getSourceType <em>Source Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.EnrichMediator#getSourceType()
	 * @see #getEnrichMediator()
	 * @generated
	 */
	EAttribute getEnrichMediator_SourceType();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.esb.mediators.EnrichMediator#getSourceXpath <em>Source Xpath</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Source Xpath</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.EnrichMediator#getSourceXpath()
	 * @see #getEnrichMediator()
	 * @generated
	 */
	EReference getEnrichMediator_SourceXpath();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.EnrichMediator#getSourceProperty <em>Source Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source Property</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.EnrichMediator#getSourceProperty()
	 * @see #getEnrichMediator()
	 * @generated
	 */
	EAttribute getEnrichMediator_SourceProperty();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.EnrichMediator#getSourceXML <em>Source XML</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source XML</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.EnrichMediator#getSourceXML()
	 * @see #getEnrichMediator()
	 * @generated
	 */
	EAttribute getEnrichMediator_SourceXML();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.EnrichMediator#getTargetAction <em>Target Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target Action</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.EnrichMediator#getTargetAction()
	 * @see #getEnrichMediator()
	 * @generated
	 */
	EAttribute getEnrichMediator_TargetAction();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.EnrichMediator#getTargetType <em>Target Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.EnrichMediator#getTargetType()
	 * @see #getEnrichMediator()
	 * @generated
	 */
	EAttribute getEnrichMediator_TargetType();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.esb.mediators.EnrichMediator#getTargetXpath <em>Target Xpath</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Target Xpath</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.EnrichMediator#getTargetXpath()
	 * @see #getEnrichMediator()
	 * @generated
	 */
	EReference getEnrichMediator_TargetXpath();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.EnrichMediator#getTargetProperty <em>Target Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target Property</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.EnrichMediator#getTargetProperty()
	 * @see #getEnrichMediator()
	 * @generated
	 */
	EAttribute getEnrichMediator_TargetProperty();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.EnrichMediator#getInlineType <em>Inline Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Inline Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.EnrichMediator#getInlineType()
	 * @see #getEnrichMediator()
	 * @generated
	 */
	EAttribute getEnrichMediator_InlineType();

	/**
	 * Returns the meta object for the reference '{@link org.wso2.developerstudio.eclipse.esb.mediators.EnrichMediator#getInlineRegistryKey <em>Inline Registry Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Inline Registry Key</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.EnrichMediator#getInlineRegistryKey()
	 * @see #getEnrichMediator()
	 * @generated
	 */
	EReference getEnrichMediator_InlineRegistryKey();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.esb.mediators.FaultMediator <em>Fault Mediator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fault Mediator</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.FaultMediator
	 * @generated
	 */
	EClass getFaultMediator();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.FaultMediator#getSoapVersion <em>Soap Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Soap Version</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.FaultMediator#getSoapVersion()
	 * @see #getFaultMediator()
	 * @generated
	 */
	EAttribute getFaultMediator_SoapVersion();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.FaultMediator#getFaultCodeSoap11 <em>Fault Code Soap11</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fault Code Soap11</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.FaultMediator#getFaultCodeSoap11()
	 * @see #getFaultMediator()
	 * @generated
	 */
	EAttribute getFaultMediator_FaultCodeSoap11();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.FaultMediator#getFaultStringType <em>Fault String Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fault String Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.FaultMediator#getFaultStringType()
	 * @see #getFaultMediator()
	 * @generated
	 */
	EAttribute getFaultMediator_FaultStringType();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.FaultMediator#getFaultStringValue <em>Fault String Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fault String Value</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.FaultMediator#getFaultStringValue()
	 * @see #getFaultMediator()
	 * @generated
	 */
	EAttribute getFaultMediator_FaultStringValue();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.esb.mediators.FaultMediator#getFaultStringExpression <em>Fault String Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Fault String Expression</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.FaultMediator#getFaultStringExpression()
	 * @see #getFaultMediator()
	 * @generated
	 */
	EReference getFaultMediator_FaultStringExpression();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.FaultMediator#getFaultActor <em>Fault Actor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fault Actor</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.FaultMediator#getFaultActor()
	 * @see #getFaultMediator()
	 * @generated
	 */
	EAttribute getFaultMediator_FaultActor();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.FaultMediator#getFaultCodeSoap12 <em>Fault Code Soap12</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fault Code Soap12</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.FaultMediator#getFaultCodeSoap12()
	 * @see #getFaultMediator()
	 * @generated
	 */
	EAttribute getFaultMediator_FaultCodeSoap12();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.FaultMediator#getFaultReasonType <em>Fault Reason Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fault Reason Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.FaultMediator#getFaultReasonType()
	 * @see #getFaultMediator()
	 * @generated
	 */
	EAttribute getFaultMediator_FaultReasonType();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.FaultMediator#getFaultReasonValue <em>Fault Reason Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fault Reason Value</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.FaultMediator#getFaultReasonValue()
	 * @see #getFaultMediator()
	 * @generated
	 */
	EAttribute getFaultMediator_FaultReasonValue();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.esb.mediators.FaultMediator#getFaultReasonExpression <em>Fault Reason Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Fault Reason Expression</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.FaultMediator#getFaultReasonExpression()
	 * @see #getFaultMediator()
	 * @generated
	 */
	EReference getFaultMediator_FaultReasonExpression();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.FaultMediator#getRoleName <em>Role Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Role Name</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.FaultMediator#getRoleName()
	 * @see #getFaultMediator()
	 * @generated
	 */
	EAttribute getFaultMediator_RoleName();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.FaultMediator#getNodeName <em>Node Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Node Name</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.FaultMediator#getNodeName()
	 * @see #getFaultMediator()
	 * @generated
	 */
	EAttribute getFaultMediator_NodeName();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.FaultMediator#getFaultDetailType <em>Fault Detail Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fault Detail Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.FaultMediator#getFaultDetailType()
	 * @see #getFaultMediator()
	 * @generated
	 */
	EAttribute getFaultMediator_FaultDetailType();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.FaultMediator#getFaultDetailValue <em>Fault Detail Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fault Detail Value</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.FaultMediator#getFaultDetailValue()
	 * @see #getFaultMediator()
	 * @generated
	 */
	EAttribute getFaultMediator_FaultDetailValue();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.esb.mediators.FaultMediator#getFaultDetailExpression <em>Fault Detail Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Fault Detail Expression</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.FaultMediator#getFaultDetailExpression()
	 * @see #getFaultMediator()
	 * @generated
	 */
	EReference getFaultMediator_FaultDetailExpression();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.esb.mediators.AggregateMediator <em>Aggregate Mediator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Aggregate Mediator</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.AggregateMediator
	 * @generated
	 */
	EClass getAggregateMediator();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.esb.mediators.AggregateMediator#getCorrelationExpression <em>Correlation Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Correlation Expression</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.AggregateMediator#getCorrelationExpression()
	 * @see #getAggregateMediator()
	 * @generated
	 */
	EReference getAggregateMediator_CorrelationExpression();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.AggregateMediator#getCompletionTimeout <em>Completion Timeout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Completion Timeout</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.AggregateMediator#getCompletionTimeout()
	 * @see #getAggregateMediator()
	 * @generated
	 */
	EAttribute getAggregateMediator_CompletionTimeout();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.AggregateMediator#getCompletionMinMessages <em>Completion Min Messages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Completion Min Messages</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.AggregateMediator#getCompletionMinMessages()
	 * @see #getAggregateMediator()
	 * @generated
	 */
	EAttribute getAggregateMediator_CompletionMinMessages();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.AggregateMediator#getCompletionMaxMessages <em>Completion Max Messages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Completion Max Messages</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.AggregateMediator#getCompletionMaxMessages()
	 * @see #getAggregateMediator()
	 * @generated
	 */
	EAttribute getAggregateMediator_CompletionMaxMessages();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.esb.mediators.AggregateMediator#getOnCompleteBranch <em>On Complete Branch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>On Complete Branch</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.AggregateMediator#getOnCompleteBranch()
	 * @see #getAggregateMediator()
	 * @generated
	 */
	EReference getAggregateMediator_OnCompleteBranch();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.AggregateMediator#getAggregateID <em>Aggregate ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Aggregate ID</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.AggregateMediator#getAggregateID()
	 * @see #getAggregateMediator()
	 * @generated
	 */
	EAttribute getAggregateMediator_AggregateID();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.esb.mediators.AggregateOnCompleteBranch <em>Aggregate On Complete Branch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Aggregate On Complete Branch</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.AggregateOnCompleteBranch
	 * @generated
	 */
	EClass getAggregateOnCompleteBranch();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.esb.mediators.AggregateOnCompleteBranch#getAggregationExpression <em>Aggregation Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Aggregation Expression</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.AggregateOnCompleteBranch#getAggregationExpression()
	 * @see #getAggregateOnCompleteBranch()
	 * @generated
	 */
	EReference getAggregateOnCompleteBranch_AggregationExpression();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.AggregateOnCompleteBranch#getSequenceType <em>Sequence Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sequence Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.AggregateOnCompleteBranch#getSequenceType()
	 * @see #getAggregateOnCompleteBranch()
	 * @generated
	 */
	EAttribute getAggregateOnCompleteBranch_SequenceType();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.esb.mediators.AggregateOnCompleteBranch#getSequenceKey <em>Sequence Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Sequence Key</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.AggregateOnCompleteBranch#getSequenceKey()
	 * @see #getAggregateOnCompleteBranch()
	 * @generated
	 */
	EReference getAggregateOnCompleteBranch_SequenceKey();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.esb.mediators.RouterMediator <em>Router Mediator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Router Mediator</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RouterMediator
	 * @generated
	 */
	EClass getRouterMediator();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.RouterMediator#isContinueAfterRouting <em>Continue After Routing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Continue After Routing</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RouterMediator#isContinueAfterRouting()
	 * @see #getRouterMediator()
	 * @generated
	 */
	EAttribute getRouterMediator_ContinueAfterRouting();

	/**
	 * Returns the meta object for the containment reference list '{@link org.wso2.developerstudio.eclipse.esb.mediators.RouterMediator#getRoutes <em>Routes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Routes</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RouterMediator#getRoutes()
	 * @see #getRouterMediator()
	 * @generated
	 */
	EReference getRouterMediator_Routes();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.esb.mediators.RouterRoute <em>Router Route</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Router Route</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RouterRoute
	 * @generated
	 */
	EClass getRouterRoute();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.RouterRoute#isBreakAfterRoute <em>Break After Route</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Break After Route</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RouterRoute#isBreakAfterRoute()
	 * @see #getRouterRoute()
	 * @generated
	 */
	EAttribute getRouterRoute_BreakAfterRoute();

	/**
	 * Returns the meta object for the reference '{@link org.wso2.developerstudio.eclipse.esb.mediators.RouterRoute#getRouteExpression <em>Route Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Route Expression</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RouterRoute#getRouteExpression()
	 * @see #getRouterRoute()
	 * @generated
	 */
	EReference getRouterRoute_RouteExpression();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.RouterRoute#getRoutePattern <em>Route Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Route Pattern</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RouterRoute#getRoutePattern()
	 * @see #getRouterRoute()
	 * @generated
	 */
	EAttribute getRouterRoute_RoutePattern();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.esb.mediators.RouterRoute#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Target</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RouterRoute#getTarget()
	 * @see #getRouterRoute()
	 * @generated
	 */
	EReference getRouterRoute_Target();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.esb.mediators.RouteTarget <em>Route Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Route Target</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RouteTarget
	 * @generated
	 */
	EClass getRouteTarget();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.esb.mediators.CloneMediator <em>Clone Mediator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Clone Mediator</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CloneMediator
	 * @generated
	 */
	EClass getCloneMediator();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.CloneMediator#getCloneID <em>Clone ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Clone ID</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CloneMediator#getCloneID()
	 * @see #getCloneMediator()
	 * @generated
	 */
	EAttribute getCloneMediator_CloneID();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.CloneMediator#isSequentialMediation <em>Sequential Mediation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sequential Mediation</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CloneMediator#isSequentialMediation()
	 * @see #getCloneMediator()
	 * @generated
	 */
	EAttribute getCloneMediator_SequentialMediation();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.CloneMediator#isContinueParent <em>Continue Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Continue Parent</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CloneMediator#isContinueParent()
	 * @see #getCloneMediator()
	 * @generated
	 */
	EAttribute getCloneMediator_ContinueParent();

	/**
	 * Returns the meta object for the containment reference list '{@link org.wso2.developerstudio.eclipse.esb.mediators.CloneMediator#getTargets <em>Targets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Targets</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CloneMediator#getTargets()
	 * @see #getCloneMediator()
	 * @generated
	 */
	EReference getCloneMediator_Targets();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.esb.mediators.CloneTarget <em>Clone Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Clone Target</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CloneTarget
	 * @generated
	 */
	EClass getCloneTarget();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.CloneTarget#getSoapAction <em>Soap Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Soap Action</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CloneTarget#getSoapAction()
	 * @see #getCloneTarget()
	 * @generated
	 */
	EAttribute getCloneTarget_SoapAction();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.CloneTarget#getToAddress <em>To Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>To Address</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CloneTarget#getToAddress()
	 * @see #getCloneTarget()
	 * @generated
	 */
	EAttribute getCloneTarget_ToAddress();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.esb.mediators.IterateMediator <em>Iterate Mediator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Iterate Mediator</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.IterateMediator
	 * @generated
	 */
	EClass getIterateMediator();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.IterateMediator#getIterateID <em>Iterate ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Iterate ID</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.IterateMediator#getIterateID()
	 * @see #getIterateMediator()
	 * @generated
	 */
	EAttribute getIterateMediator_IterateID();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.IterateMediator#isSequentialMediation <em>Sequential Mediation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sequential Mediation</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.IterateMediator#isSequentialMediation()
	 * @see #getIterateMediator()
	 * @generated
	 */
	EAttribute getIterateMediator_SequentialMediation();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.IterateMediator#isContinueParent <em>Continue Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Continue Parent</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.IterateMediator#isContinueParent()
	 * @see #getIterateMediator()
	 * @generated
	 */
	EAttribute getIterateMediator_ContinueParent();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.IterateMediator#isPreservePayload <em>Preserve Payload</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Preserve Payload</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.IterateMediator#isPreservePayload()
	 * @see #getIterateMediator()
	 * @generated
	 */
	EAttribute getIterateMediator_PreservePayload();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.esb.mediators.IterateMediator#getIterateExpression <em>Iterate Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Iterate Expression</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.IterateMediator#getIterateExpression()
	 * @see #getIterateMediator()
	 * @generated
	 */
	EReference getIterateMediator_IterateExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.esb.mediators.IterateMediator#getAttachPath <em>Attach Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Attach Path</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.IterateMediator#getAttachPath()
	 * @see #getIterateMediator()
	 * @generated
	 */
	EReference getIterateMediator_AttachPath();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.esb.mediators.IterateMediator#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Target</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.IterateMediator#getTarget()
	 * @see #getIterateMediator()
	 * @generated
	 */
	EReference getIterateMediator_Target();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.esb.mediators.IterateTarget <em>Iterate Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Iterate Target</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.IterateTarget
	 * @generated
	 */
	EClass getIterateTarget();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.IterateTarget#getSoapAction <em>Soap Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Soap Action</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.IterateTarget#getSoapAction()
	 * @see #getIterateTarget()
	 * @generated
	 */
	EAttribute getIterateTarget_SoapAction();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.IterateTarget#getToAddress <em>To Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>To Address</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.IterateTarget#getToAddress()
	 * @see #getIterateTarget()
	 * @generated
	 */
	EAttribute getIterateTarget_ToAddress();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.esb.mediators.CacheMediator <em>Cache Mediator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cache Mediator</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CacheMediator
	 * @generated
	 */
	EClass getCacheMediator();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.CacheMediator#getCacheId <em>Cache Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cache Id</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CacheMediator#getCacheId()
	 * @see #getCacheMediator()
	 * @generated
	 */
	EAttribute getCacheMediator_CacheId();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.CacheMediator#getCacheScope <em>Cache Scope</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cache Scope</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CacheMediator#getCacheScope()
	 * @see #getCacheMediator()
	 * @generated
	 */
	EAttribute getCacheMediator_CacheScope();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.CacheMediator#getCacheAction <em>Cache Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cache Action</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CacheMediator#getCacheAction()
	 * @see #getCacheMediator()
	 * @generated
	 */
	EAttribute getCacheMediator_CacheAction();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.CacheMediator#getHashGenerator <em>Hash Generator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hash Generator</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CacheMediator#getHashGenerator()
	 * @see #getCacheMediator()
	 * @generated
	 */
	EAttribute getCacheMediator_HashGenerator();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.CacheMediator#getCacheTimeout <em>Cache Timeout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cache Timeout</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CacheMediator#getCacheTimeout()
	 * @see #getCacheMediator()
	 * @generated
	 */
	EAttribute getCacheMediator_CacheTimeout();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.CacheMediator#getMaxMessageSize <em>Max Message Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Message Size</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CacheMediator#getMaxMessageSize()
	 * @see #getCacheMediator()
	 * @generated
	 */
	EAttribute getCacheMediator_MaxMessageSize();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.CacheMediator#getImplementationType <em>Implementation Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Implementation Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CacheMediator#getImplementationType()
	 * @see #getCacheMediator()
	 * @generated
	 */
	EAttribute getCacheMediator_ImplementationType();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.CacheMediator#getMaxEntryCount <em>Max Entry Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Entry Count</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CacheMediator#getMaxEntryCount()
	 * @see #getCacheMediator()
	 * @generated
	 */
	EAttribute getCacheMediator_MaxEntryCount();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.esb.mediators.CacheMediator#getOnHitBranch <em>On Hit Branch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>On Hit Branch</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CacheMediator#getOnHitBranch()
	 * @see #getCacheMediator()
	 * @generated
	 */
	EReference getCacheMediator_OnHitBranch();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.esb.mediators.CacheOnHitBranch <em>Cache On Hit Branch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cache On Hit Branch</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CacheOnHitBranch
	 * @generated
	 */
	EClass getCacheOnHitBranch();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.CacheOnHitBranch#getSequenceType <em>Sequence Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sequence Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CacheOnHitBranch#getSequenceType()
	 * @see #getCacheOnHitBranch()
	 * @generated
	 */
	EAttribute getCacheOnHitBranch_SequenceType();

	/**
	 * Returns the meta object for the reference '{@link org.wso2.developerstudio.eclipse.esb.mediators.CacheOnHitBranch#getSequenceKey <em>Sequence Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Sequence Key</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CacheOnHitBranch#getSequenceKey()
	 * @see #getCacheOnHitBranch()
	 * @generated
	 */
	EReference getCacheOnHitBranch_SequenceKey();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.esb.mediators.XSLTMediator <em>XSLT Mediator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XSLT Mediator</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.XSLTMediator
	 * @generated
	 */
	EClass getXSLTMediator();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.esb.mediators.XSLTMediator#getSourceXPath <em>Source XPath</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Source XPath</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.XSLTMediator#getSourceXPath()
	 * @see #getXSLTMediator()
	 * @generated
	 */
	EReference getXSLTMediator_SourceXPath();

	/**
	 * Returns the meta object for the reference '{@link org.wso2.developerstudio.eclipse.esb.mediators.XSLTMediator#getXsltKey <em>Xslt Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Xslt Key</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.XSLTMediator#getXsltKey()
	 * @see #getXSLTMediator()
	 * @generated
	 */
	EReference getXSLTMediator_XsltKey();

	/**
	 * Returns the meta object for the containment reference list '{@link org.wso2.developerstudio.eclipse.esb.mediators.XSLTMediator#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Properties</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.XSLTMediator#getProperties()
	 * @see #getXSLTMediator()
	 * @generated
	 */
	EReference getXSLTMediator_Properties();

	/**
	 * Returns the meta object for the containment reference list '{@link org.wso2.developerstudio.eclipse.esb.mediators.XSLTMediator#getFeatures <em>Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Features</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.XSLTMediator#getFeatures()
	 * @see #getXSLTMediator()
	 * @generated
	 */
	EReference getXSLTMediator_Features();

	/**
	 * Returns the meta object for the containment reference list '{@link org.wso2.developerstudio.eclipse.esb.mediators.XSLTMediator#getResources <em>Resources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Resources</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.XSLTMediator#getResources()
	 * @see #getXSLTMediator()
	 * @generated
	 */
	EReference getXSLTMediator_Resources();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.XSLTMediator#getXsltSchemaKeyType <em>Xslt Schema Key Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Xslt Schema Key Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.XSLTMediator#getXsltSchemaKeyType()
	 * @see #getXSLTMediator()
	 * @generated
	 */
	EAttribute getXSLTMediator_XsltSchemaKeyType();

	/**
	 * Returns the meta object for the reference '{@link org.wso2.developerstudio.eclipse.esb.mediators.XSLTMediator#getXsltStaticSchemaKey <em>Xslt Static Schema Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Xslt Static Schema Key</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.XSLTMediator#getXsltStaticSchemaKey()
	 * @see #getXSLTMediator()
	 * @generated
	 */
	EReference getXSLTMediator_XsltStaticSchemaKey();

	/**
	 * Returns the meta object for the reference '{@link org.wso2.developerstudio.eclipse.esb.mediators.XSLTMediator#getXsltDynamicSchemaKey <em>Xslt Dynamic Schema Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Xslt Dynamic Schema Key</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.XSLTMediator#getXsltDynamicSchemaKey()
	 * @see #getXSLTMediator()
	 * @generated
	 */
	EReference getXSLTMediator_XsltDynamicSchemaKey();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.esb.mediators.XSLTProperty <em>XSLT Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XSLT Property</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.XSLTProperty
	 * @generated
	 */
	EClass getXSLTProperty();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.esb.mediators.XSLTFeature <em>XSLT Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XSLT Feature</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.XSLTFeature
	 * @generated
	 */
	EClass getXSLTFeature();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.esb.mediators.XSLTResource <em>XSLT Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XSLT Resource</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.XSLTResource
	 * @generated
	 */
	EClass getXSLTResource();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.esb.mediators.XQueryMediator <em>XQuery Mediator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XQuery Mediator</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.XQueryMediator
	 * @generated
	 */
	EClass getXQueryMediator();

	/**
	 * Returns the meta object for the reference '{@link org.wso2.developerstudio.eclipse.esb.mediators.XQueryMediator#getTargetXPath <em>Target XPath</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target XPath</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.XQueryMediator#getTargetXPath()
	 * @see #getXQueryMediator()
	 * @generated
	 */
	EReference getXQueryMediator_TargetXPath();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.XQueryMediator#getScriptKeyType <em>Script Key Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Script Key Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.XQueryMediator#getScriptKeyType()
	 * @see #getXQueryMediator()
	 * @generated
	 */
	EAttribute getXQueryMediator_ScriptKeyType();

	/**
	 * Returns the meta object for the reference '{@link org.wso2.developerstudio.eclipse.esb.mediators.XQueryMediator#getStaticScriptKey <em>Static Script Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Static Script Key</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.XQueryMediator#getStaticScriptKey()
	 * @see #getXQueryMediator()
	 * @generated
	 */
	EReference getXQueryMediator_StaticScriptKey();

	/**
	 * Returns the meta object for the reference '{@link org.wso2.developerstudio.eclipse.esb.mediators.XQueryMediator#getDynamicScriptKey <em>Dynamic Script Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Dynamic Script Key</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.XQueryMediator#getDynamicScriptKey()
	 * @see #getXQueryMediator()
	 * @generated
	 */
	EReference getXQueryMediator_DynamicScriptKey();

	/**
	 * Returns the meta object for the reference '{@link org.wso2.developerstudio.eclipse.esb.mediators.XQueryMediator#getQueryKey <em>Query Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Query Key</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.XQueryMediator#getQueryKey()
	 * @see #getXQueryMediator()
	 * @generated
	 */
	EReference getXQueryMediator_QueryKey();

	/**
	 * Returns the meta object for the containment reference list '{@link org.wso2.developerstudio.eclipse.esb.mediators.XQueryMediator#getVariables <em>Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Variables</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.XQueryMediator#getVariables()
	 * @see #getXQueryMediator()
	 * @generated
	 */
	EReference getXQueryMediator_Variables();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.esb.mediators.XQueryVariable <em>XQuery Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XQuery Variable</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.XQueryVariable
	 * @generated
	 */
	EClass getXQueryVariable();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.XQueryVariable#getVariableName <em>Variable Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Variable Name</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.XQueryVariable#getVariableName()
	 * @see #getXQueryVariable()
	 * @generated
	 */
	EAttribute getXQueryVariable_VariableName();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.XQueryVariable#getVariableType <em>Variable Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Variable Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.XQueryVariable#getVariableType()
	 * @see #getXQueryVariable()
	 * @generated
	 */
	EAttribute getXQueryVariable_VariableType();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.XQueryVariable#getValueType <em>Value Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.XQueryVariable#getValueType()
	 * @see #getXQueryVariable()
	 * @generated
	 */
	EAttribute getXQueryVariable_ValueType();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.XQueryVariable#getValueLiteral <em>Value Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value Literal</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.XQueryVariable#getValueLiteral()
	 * @see #getXQueryVariable()
	 * @generated
	 */
	EAttribute getXQueryVariable_ValueLiteral();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.esb.mediators.XQueryVariable#getValueExpression <em>Value Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value Expression</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.XQueryVariable#getValueExpression()
	 * @see #getXQueryVariable()
	 * @generated
	 */
	EReference getXQueryVariable_ValueExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.esb.mediators.XQueryVariable#getValueKey <em>Value Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value Key</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.XQueryVariable#getValueKey()
	 * @see #getXQueryVariable()
	 * @generated
	 */
	EReference getXQueryVariable_ValueKey();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.esb.mediators.CalloutMediator <em>Callout Mediator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Callout Mediator</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CalloutMediator
	 * @generated
	 */
	EClass getCalloutMediator();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.CalloutMediator#getServiceURL <em>Service URL</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Service URL</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CalloutMediator#getServiceURL()
	 * @see #getCalloutMediator()
	 * @generated
	 */
	EAttribute getCalloutMediator_ServiceURL();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.CalloutMediator#getSoapAction <em>Soap Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Soap Action</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CalloutMediator#getSoapAction()
	 * @see #getCalloutMediator()
	 * @generated
	 */
	EAttribute getCalloutMediator_SoapAction();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.CalloutMediator#getPathToAxis2xml <em>Path To Axis2xml</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path To Axis2xml</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CalloutMediator#getPathToAxis2xml()
	 * @see #getCalloutMediator()
	 * @generated
	 */
	EAttribute getCalloutMediator_PathToAxis2xml();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.CalloutMediator#getPathToAxis2Repository <em>Path To Axis2 Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path To Axis2 Repository</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CalloutMediator#getPathToAxis2Repository()
	 * @see #getCalloutMediator()
	 * @generated
	 */
	EAttribute getCalloutMediator_PathToAxis2Repository();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.CalloutMediator#getPayloadType <em>Payload Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Payload Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CalloutMediator#getPayloadType()
	 * @see #getCalloutMediator()
	 * @generated
	 */
	EAttribute getCalloutMediator_PayloadType();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.esb.mediators.CalloutMediator#getPayloadMessageXpath <em>Payload Message Xpath</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Payload Message Xpath</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CalloutMediator#getPayloadMessageXpath()
	 * @see #getCalloutMediator()
	 * @generated
	 */
	EReference getCalloutMediator_PayloadMessageXpath();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.esb.mediators.CalloutMediator#getPayloadRegistryKey <em>Payload Registry Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Payload Registry Key</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CalloutMediator#getPayloadRegistryKey()
	 * @see #getCalloutMediator()
	 * @generated
	 */
	EReference getCalloutMediator_PayloadRegistryKey();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.CalloutMediator#getResultType <em>Result Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Result Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CalloutMediator#getResultType()
	 * @see #getCalloutMediator()
	 * @generated
	 */
	EAttribute getCalloutMediator_ResultType();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.esb.mediators.CalloutMediator#getResultMessageXpath <em>Result Message Xpath</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Result Message Xpath</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CalloutMediator#getResultMessageXpath()
	 * @see #getCalloutMediator()
	 * @generated
	 */
	EReference getCalloutMediator_ResultMessageXpath();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.CalloutMediator#getResultContextProperty <em>Result Context Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Result Context Property</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CalloutMediator#getResultContextProperty()
	 * @see #getCalloutMediator()
	 * @generated
	 */
	EAttribute getCalloutMediator_ResultContextProperty();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.CalloutMediator#isPassHeaders <em>Pass Headers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pass Headers</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CalloutMediator#isPassHeaders()
	 * @see #getCalloutMediator()
	 * @generated
	 */
	EAttribute getCalloutMediator_PassHeaders();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.CalloutMediator#isUseServerConfig <em>Use Server Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Use Server Config</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CalloutMediator#isUseServerConfig()
	 * @see #getCalloutMediator()
	 * @generated
	 */
	EAttribute getCalloutMediator_UseServerConfig();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.CalloutMediator#getEndpointType <em>Endpoint Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Endpoint Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CalloutMediator#getEndpointType()
	 * @see #getCalloutMediator()
	 * @generated
	 */
	EAttribute getCalloutMediator_EndpointType();

	/**
	 * Returns the meta object for the reference '{@link org.wso2.developerstudio.eclipse.esb.mediators.CalloutMediator#getEndpointKey <em>Endpoint Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Endpoint Key</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CalloutMediator#getEndpointKey()
	 * @see #getCalloutMediator()
	 * @generated
	 */
	EReference getCalloutMediator_EndpointKey();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.esb.mediators.RMSequenceMediator <em>RM Sequence Mediator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>RM Sequence Mediator</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RMSequenceMediator
	 * @generated
	 */
	EClass getRMSequenceMediator();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.RMSequenceMediator#getRmSpecVersion <em>Rm Spec Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rm Spec Version</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RMSequenceMediator#getRmSpecVersion()
	 * @see #getRMSequenceMediator()
	 * @generated
	 */
	EAttribute getRMSequenceMediator_RmSpecVersion();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.RMSequenceMediator#getSequenceType <em>Sequence Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sequence Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RMSequenceMediator#getSequenceType()
	 * @see #getRMSequenceMediator()
	 * @generated
	 */
	EAttribute getRMSequenceMediator_SequenceType();

	/**
	 * Returns the meta object for the reference '{@link org.wso2.developerstudio.eclipse.esb.mediators.RMSequenceMediator#getCorrelationXpath <em>Correlation Xpath</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Correlation Xpath</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RMSequenceMediator#getCorrelationXpath()
	 * @see #getRMSequenceMediator()
	 * @generated
	 */
	EReference getRMSequenceMediator_CorrelationXpath();

	/**
	 * Returns the meta object for the reference '{@link org.wso2.developerstudio.eclipse.esb.mediators.RMSequenceMediator#getLastMessageXpath <em>Last Message Xpath</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Last Message Xpath</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RMSequenceMediator#getLastMessageXpath()
	 * @see #getRMSequenceMediator()
	 * @generated
	 */
	EReference getRMSequenceMediator_LastMessageXpath();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.esb.mediators.TransactionMediator <em>Transaction Mediator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transaction Mediator</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.TransactionMediator
	 * @generated
	 */
	EClass getTransactionMediator();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.TransactionMediator#getAction <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Action</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.TransactionMediator#getAction()
	 * @see #getTransactionMediator()
	 * @generated
	 */
	EAttribute getTransactionMediator_Action();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.esb.mediators.PropertyMediator <em>Property Mediator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Mediator</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.PropertyMediator
	 * @generated
	 */
	EClass getPropertyMediator();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.PropertyMediator#getPropertyName <em>Property Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Property Name</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.PropertyMediator#getPropertyName()
	 * @see #getPropertyMediator()
	 * @generated
	 */
	EAttribute getPropertyMediator_PropertyName();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.PropertyMediator#getPropertyDataType <em>Property Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Property Data Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.PropertyMediator#getPropertyDataType()
	 * @see #getPropertyMediator()
	 * @generated
	 */
	EAttribute getPropertyMediator_PropertyDataType();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.PropertyMediator#getPropertyAction <em>Property Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Property Action</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.PropertyMediator#getPropertyAction()
	 * @see #getPropertyMediator()
	 * @generated
	 */
	EAttribute getPropertyMediator_PropertyAction();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.PropertyMediator#getPropertyScope <em>Property Scope</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Property Scope</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.PropertyMediator#getPropertyScope()
	 * @see #getPropertyMediator()
	 * @generated
	 */
	EAttribute getPropertyMediator_PropertyScope();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.PropertyMediator#getValueType <em>Value Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.PropertyMediator#getValueType()
	 * @see #getPropertyMediator()
	 * @generated
	 */
	EAttribute getPropertyMediator_ValueType();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.PropertyMediator#getValueLiteral <em>Value Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value Literal</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.PropertyMediator#getValueLiteral()
	 * @see #getPropertyMediator()
	 * @generated
	 */
	EAttribute getPropertyMediator_ValueLiteral();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.esb.mediators.PropertyMediator#getValueExpression <em>Value Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value Expression</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.PropertyMediator#getValueExpression()
	 * @see #getPropertyMediator()
	 * @generated
	 */
	EReference getPropertyMediator_ValueExpression();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.PropertyMediator#getValueOM <em>Value OM</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value OM</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.PropertyMediator#getValueOM()
	 * @see #getPropertyMediator()
	 * @generated
	 */
	EAttribute getPropertyMediator_ValueOM();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.PropertyMediator#getValueStringPattern <em>Value String Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value String Pattern</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.PropertyMediator#getValueStringPattern()
	 * @see #getPropertyMediator()
	 * @generated
	 */
	EAttribute getPropertyMediator_ValueStringPattern();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.PropertyMediator#getValueStringCapturingGroup <em>Value String Capturing Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value String Capturing Group</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.PropertyMediator#getValueStringCapturingGroup()
	 * @see #getPropertyMediator()
	 * @generated
	 */
	EAttribute getPropertyMediator_ValueStringCapturingGroup();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.esb.mediators.OAuthMediator <em>OAuth Mediator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>OAuth Mediator</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.OAuthMediator
	 * @generated
	 */
	EClass getOAuthMediator();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.OAuthMediator#getRemoteServiceUrl <em>Remote Service Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Remote Service Url</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.OAuthMediator#getRemoteServiceUrl()
	 * @see #getOAuthMediator()
	 * @generated
	 */
	EAttribute getOAuthMediator_RemoteServiceUrl();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.esb.mediators.AutoscaleInMediator <em>Autoscale In Mediator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Autoscale In Mediator</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.AutoscaleInMediator
	 * @generated
	 */
	EClass getAutoscaleInMediator();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.esb.mediators.AutoscaleOutMediator <em>Autoscale Out Mediator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Autoscale Out Mediator</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.AutoscaleOutMediator
	 * @generated
	 */
	EClass getAutoscaleOutMediator();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.esb.mediators.HeaderMediator <em>Header Mediator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Header Mediator</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.HeaderMediator
	 * @generated
	 */
	EClass getHeaderMediator();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.esb.mediators.HeaderMediator#getHeaderName <em>Header Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Header Name</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.HeaderMediator#getHeaderName()
	 * @see #getHeaderMediator()
	 * @generated
	 */
	EReference getHeaderMediator_HeaderName();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.HeaderMediator#getHeaderAction <em>Header Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Header Action</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.HeaderMediator#getHeaderAction()
	 * @see #getHeaderMediator()
	 * @generated
	 */
	EAttribute getHeaderMediator_HeaderAction();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.HeaderMediator#getValueType <em>Value Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.HeaderMediator#getValueType()
	 * @see #getHeaderMediator()
	 * @generated
	 */
	EAttribute getHeaderMediator_ValueType();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.HeaderMediator#getValueLiteral <em>Value Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value Literal</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.HeaderMediator#getValueLiteral()
	 * @see #getHeaderMediator()
	 * @generated
	 */
	EAttribute getHeaderMediator_ValueLiteral();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.esb.mediators.HeaderMediator#getValueExpression <em>Value Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value Expression</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.HeaderMediator#getValueExpression()
	 * @see #getHeaderMediator()
	 * @generated
	 */
	EReference getHeaderMediator_ValueExpression();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.esb.mediators.ThrottleMediator <em>Throttle Mediator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Throttle Mediator</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ThrottleMediator
	 * @generated
	 */
	EClass getThrottleMediator();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.ThrottleMediator#getGroupId <em>Group Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Group Id</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ThrottleMediator#getGroupId()
	 * @see #getThrottleMediator()
	 * @generated
	 */
	EAttribute getThrottleMediator_GroupId();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.esb.mediators.ThrottleMediator#getPolicyConfiguration <em>Policy Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Policy Configuration</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ThrottleMediator#getPolicyConfiguration()
	 * @see #getThrottleMediator()
	 * @generated
	 */
	EReference getThrottleMediator_PolicyConfiguration();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.esb.mediators.ThrottleMediator#getOnAcceptBranch <em>On Accept Branch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>On Accept Branch</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ThrottleMediator#getOnAcceptBranch()
	 * @see #getThrottleMediator()
	 * @generated
	 */
	EReference getThrottleMediator_OnAcceptBranch();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.esb.mediators.ThrottleMediator#getOnRejectBranch <em>On Reject Branch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>On Reject Branch</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ThrottleMediator#getOnRejectBranch()
	 * @see #getThrottleMediator()
	 * @generated
	 */
	EReference getThrottleMediator_OnRejectBranch();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.esb.mediators.ThrottlePolicyConfiguration <em>Throttle Policy Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Throttle Policy Configuration</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ThrottlePolicyConfiguration
	 * @generated
	 */
	EClass getThrottlePolicyConfiguration();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.ThrottlePolicyConfiguration#getPolicyType <em>Policy Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Policy Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ThrottlePolicyConfiguration#getPolicyType()
	 * @see #getThrottlePolicyConfiguration()
	 * @generated
	 */
	EAttribute getThrottlePolicyConfiguration_PolicyType();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.esb.mediators.ThrottlePolicyConfiguration#getPolicyKey <em>Policy Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Policy Key</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ThrottlePolicyConfiguration#getPolicyKey()
	 * @see #getThrottlePolicyConfiguration()
	 * @generated
	 */
	EReference getThrottlePolicyConfiguration_PolicyKey();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.ThrottlePolicyConfiguration#getMaxConcurrentAccessCount <em>Max Concurrent Access Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Concurrent Access Count</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ThrottlePolicyConfiguration#getMaxConcurrentAccessCount()
	 * @see #getThrottlePolicyConfiguration()
	 * @generated
	 */
	EAttribute getThrottlePolicyConfiguration_MaxConcurrentAccessCount();

	/**
	 * Returns the meta object for the containment reference list '{@link org.wso2.developerstudio.eclipse.esb.mediators.ThrottlePolicyConfiguration#getPolicyEntries <em>Policy Entries</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Policy Entries</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ThrottlePolicyConfiguration#getPolicyEntries()
	 * @see #getThrottlePolicyConfiguration()
	 * @generated
	 */
	EReference getThrottlePolicyConfiguration_PolicyEntries();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.esb.mediators.ThrottlePolicyEntry <em>Throttle Policy Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Throttle Policy Entry</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ThrottlePolicyEntry
	 * @generated
	 */
	EClass getThrottlePolicyEntry();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.ThrottlePolicyEntry#getThrottleType <em>Throttle Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Throttle Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ThrottlePolicyEntry#getThrottleType()
	 * @see #getThrottlePolicyEntry()
	 * @generated
	 */
	EAttribute getThrottlePolicyEntry_ThrottleType();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.ThrottlePolicyEntry#getThrottleRange <em>Throttle Range</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Throttle Range</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ThrottlePolicyEntry#getThrottleRange()
	 * @see #getThrottlePolicyEntry()
	 * @generated
	 */
	EAttribute getThrottlePolicyEntry_ThrottleRange();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.ThrottlePolicyEntry#getAccessType <em>Access Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Access Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ThrottlePolicyEntry#getAccessType()
	 * @see #getThrottlePolicyEntry()
	 * @generated
	 */
	EAttribute getThrottlePolicyEntry_AccessType();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.ThrottlePolicyEntry#getMaxRequestCount <em>Max Request Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Request Count</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ThrottlePolicyEntry#getMaxRequestCount()
	 * @see #getThrottlePolicyEntry()
	 * @generated
	 */
	EAttribute getThrottlePolicyEntry_MaxRequestCount();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.ThrottlePolicyEntry#getUnitTime <em>Unit Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unit Time</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ThrottlePolicyEntry#getUnitTime()
	 * @see #getThrottlePolicyEntry()
	 * @generated
	 */
	EAttribute getThrottlePolicyEntry_UnitTime();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.ThrottlePolicyEntry#getProhibitPeriod <em>Prohibit Period</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Prohibit Period</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ThrottlePolicyEntry#getProhibitPeriod()
	 * @see #getThrottlePolicyEntry()
	 * @generated
	 */
	EAttribute getThrottlePolicyEntry_ProhibitPeriod();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.esb.mediators.ThrottleOnAcceptBranch <em>Throttle On Accept Branch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Throttle On Accept Branch</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ThrottleOnAcceptBranch
	 * @generated
	 */
	EClass getThrottleOnAcceptBranch();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.ThrottleOnAcceptBranch#getSequenceType <em>Sequence Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sequence Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ThrottleOnAcceptBranch#getSequenceType()
	 * @see #getThrottleOnAcceptBranch()
	 * @generated
	 */
	EAttribute getThrottleOnAcceptBranch_SequenceType();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.esb.mediators.ThrottleOnAcceptBranch#getSequenceKey <em>Sequence Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Sequence Key</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ThrottleOnAcceptBranch#getSequenceKey()
	 * @see #getThrottleOnAcceptBranch()
	 * @generated
	 */
	EReference getThrottleOnAcceptBranch_SequenceKey();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.esb.mediators.ThrottleOnRejectBranch <em>Throttle On Reject Branch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Throttle On Reject Branch</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ThrottleOnRejectBranch
	 * @generated
	 */
	EClass getThrottleOnRejectBranch();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.ThrottleOnRejectBranch#getSequenceType <em>Sequence Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sequence Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ThrottleOnRejectBranch#getSequenceType()
	 * @see #getThrottleOnRejectBranch()
	 * @generated
	 */
	EAttribute getThrottleOnRejectBranch_SequenceType();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.esb.mediators.ThrottleOnRejectBranch#getSequenceKey <em>Sequence Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Sequence Key</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ThrottleOnRejectBranch#getSequenceKey()
	 * @see #getThrottleOnRejectBranch()
	 * @generated
	 */
	EReference getThrottleOnRejectBranch_SequenceKey();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.esb.mediators.CommandMediator <em>Command Mediator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Command Mediator</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CommandMediator
	 * @generated
	 */
	EClass getCommandMediator();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.CommandMediator#getClassName <em>Class Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Class Name</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CommandMediator#getClassName()
	 * @see #getCommandMediator()
	 * @generated
	 */
	EAttribute getCommandMediator_ClassName();

	/**
	 * Returns the meta object for the containment reference list '{@link org.wso2.developerstudio.eclipse.esb.mediators.CommandMediator#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Properties</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CommandMediator#getProperties()
	 * @see #getCommandMediator()
	 * @generated
	 */
	EReference getCommandMediator_Properties();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.esb.mediators.CommandProperty <em>Command Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Command Property</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CommandProperty
	 * @generated
	 */
	EClass getCommandProperty();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.CommandProperty#getPropertyName <em>Property Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Property Name</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CommandProperty#getPropertyName()
	 * @see #getCommandProperty()
	 * @generated
	 */
	EAttribute getCommandProperty_PropertyName();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.CommandProperty#getValueType <em>Value Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CommandProperty#getValueType()
	 * @see #getCommandProperty()
	 * @generated
	 */
	EAttribute getCommandProperty_ValueType();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.CommandProperty#getValueLiteral <em>Value Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value Literal</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CommandProperty#getValueLiteral()
	 * @see #getCommandProperty()
	 * @generated
	 */
	EAttribute getCommandProperty_ValueLiteral();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.CommandProperty#getValueContextPropertyName <em>Value Context Property Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value Context Property Name</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CommandProperty#getValueContextPropertyName()
	 * @see #getCommandProperty()
	 * @generated
	 */
	EAttribute getCommandProperty_ValueContextPropertyName();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.esb.mediators.CommandProperty#getValueMessageElementXpath <em>Value Message Element Xpath</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value Message Element Xpath</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CommandProperty#getValueMessageElementXpath()
	 * @see #getCommandProperty()
	 * @generated
	 */
	EReference getCommandProperty_ValueMessageElementXpath();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.CommandProperty#getContextAction <em>Context Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Context Action</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CommandProperty#getContextAction()
	 * @see #getCommandProperty()
	 * @generated
	 */
	EAttribute getCommandProperty_ContextAction();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.CommandProperty#getMessageAction <em>Message Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Message Action</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CommandProperty#getMessageAction()
	 * @see #getCommandProperty()
	 * @generated
	 */
	EAttribute getCommandProperty_MessageAction();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.esb.mediators.EventMediator <em>Event Mediator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event Mediator</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.EventMediator
	 * @generated
	 */
	EClass getEventMediator();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.EventMediator#getTopicType <em>Topic Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Topic Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.EventMediator#getTopicType()
	 * @see #getEventMediator()
	 * @generated
	 */
	EAttribute getEventMediator_TopicType();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.EventMediator#getStaticTopic <em>Static Topic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Static Topic</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.EventMediator#getStaticTopic()
	 * @see #getEventMediator()
	 * @generated
	 */
	EAttribute getEventMediator_StaticTopic();

	/**
	 * Returns the meta object for the reference '{@link org.wso2.developerstudio.eclipse.esb.mediators.EventMediator#getDynamicTopic <em>Dynamic Topic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Dynamic Topic</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.EventMediator#getDynamicTopic()
	 * @see #getEventMediator()
	 * @generated
	 */
	EReference getEventMediator_DynamicTopic();

	/**
	 * Returns the meta object for the reference '{@link org.wso2.developerstudio.eclipse.esb.mediators.EventMediator#getEventExpression <em>Event Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Event Expression</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.EventMediator#getEventExpression()
	 * @see #getEventMediator()
	 * @generated
	 */
	EReference getEventMediator_EventExpression();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.EventMediator#getEventSource <em>Event Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Event Source</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.EventMediator#getEventSource()
	 * @see #getEventMediator()
	 * @generated
	 */
	EAttribute getEventMediator_EventSource();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.esb.mediators.AbstractSqlExecutorMediator <em>Abstract Sql Executor Mediator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Sql Executor Mediator</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.AbstractSqlExecutorMediator
	 * @generated
	 */
	EClass getAbstractSqlExecutorMediator();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.AbstractSqlExecutorMediator#getConnectionType <em>Connection Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Connection Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.AbstractSqlExecutorMediator#getConnectionType()
	 * @see #getAbstractSqlExecutorMediator()
	 * @generated
	 */
	EAttribute getAbstractSqlExecutorMediator_ConnectionType();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.AbstractSqlExecutorMediator#getConnectionDsType <em>Connection Ds Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Connection Ds Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.AbstractSqlExecutorMediator#getConnectionDsType()
	 * @see #getAbstractSqlExecutorMediator()
	 * @generated
	 */
	EAttribute getAbstractSqlExecutorMediator_ConnectionDsType();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.AbstractSqlExecutorMediator#getConnectionDbDriver <em>Connection Db Driver</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Connection Db Driver</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.AbstractSqlExecutorMediator#getConnectionDbDriver()
	 * @see #getAbstractSqlExecutorMediator()
	 * @generated
	 */
	EAttribute getAbstractSqlExecutorMediator_ConnectionDbDriver();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.AbstractSqlExecutorMediator#getConnectionDsInitialContext <em>Connection Ds Initial Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Connection Ds Initial Context</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.AbstractSqlExecutorMediator#getConnectionDsInitialContext()
	 * @see #getAbstractSqlExecutorMediator()
	 * @generated
	 */
	EAttribute getAbstractSqlExecutorMediator_ConnectionDsInitialContext();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.AbstractSqlExecutorMediator#getConnectionDsName <em>Connection Ds Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Connection Ds Name</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.AbstractSqlExecutorMediator#getConnectionDsName()
	 * @see #getAbstractSqlExecutorMediator()
	 * @generated
	 */
	EAttribute getAbstractSqlExecutorMediator_ConnectionDsName();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.AbstractSqlExecutorMediator#getConnectionURL <em>Connection URL</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Connection URL</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.AbstractSqlExecutorMediator#getConnectionURL()
	 * @see #getAbstractSqlExecutorMediator()
	 * @generated
	 */
	EAttribute getAbstractSqlExecutorMediator_ConnectionURL();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.AbstractSqlExecutorMediator#getConnectionUsername <em>Connection Username</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Connection Username</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.AbstractSqlExecutorMediator#getConnectionUsername()
	 * @see #getAbstractSqlExecutorMediator()
	 * @generated
	 */
	EAttribute getAbstractSqlExecutorMediator_ConnectionUsername();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.AbstractSqlExecutorMediator#getConnectionPassword <em>Connection Password</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Connection Password</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.AbstractSqlExecutorMediator#getConnectionPassword()
	 * @see #getAbstractSqlExecutorMediator()
	 * @generated
	 */
	EAttribute getAbstractSqlExecutorMediator_ConnectionPassword();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.AbstractSqlExecutorMediator#getPropertyAutocommit <em>Property Autocommit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Property Autocommit</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.AbstractSqlExecutorMediator#getPropertyAutocommit()
	 * @see #getAbstractSqlExecutorMediator()
	 * @generated
	 */
	EAttribute getAbstractSqlExecutorMediator_PropertyAutocommit();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.AbstractSqlExecutorMediator#getPropertyIsolation <em>Property Isolation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Property Isolation</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.AbstractSqlExecutorMediator#getPropertyIsolation()
	 * @see #getAbstractSqlExecutorMediator()
	 * @generated
	 */
	EAttribute getAbstractSqlExecutorMediator_PropertyIsolation();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.AbstractSqlExecutorMediator#getPropertyMaxactive <em>Property Maxactive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Property Maxactive</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.AbstractSqlExecutorMediator#getPropertyMaxactive()
	 * @see #getAbstractSqlExecutorMediator()
	 * @generated
	 */
	EAttribute getAbstractSqlExecutorMediator_PropertyMaxactive();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.AbstractSqlExecutorMediator#getPropertyMaxidle <em>Property Maxidle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Property Maxidle</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.AbstractSqlExecutorMediator#getPropertyMaxidle()
	 * @see #getAbstractSqlExecutorMediator()
	 * @generated
	 */
	EAttribute getAbstractSqlExecutorMediator_PropertyMaxidle();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.AbstractSqlExecutorMediator#getPropertyMaxopenstatements <em>Property Maxopenstatements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Property Maxopenstatements</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.AbstractSqlExecutorMediator#getPropertyMaxopenstatements()
	 * @see #getAbstractSqlExecutorMediator()
	 * @generated
	 */
	EAttribute getAbstractSqlExecutorMediator_PropertyMaxopenstatements();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.AbstractSqlExecutorMediator#getPropertyMaxwait <em>Property Maxwait</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Property Maxwait</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.AbstractSqlExecutorMediator#getPropertyMaxwait()
	 * @see #getAbstractSqlExecutorMediator()
	 * @generated
	 */
	EAttribute getAbstractSqlExecutorMediator_PropertyMaxwait();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.AbstractSqlExecutorMediator#getPropertyMinidle <em>Property Minidle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Property Minidle</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.AbstractSqlExecutorMediator#getPropertyMinidle()
	 * @see #getAbstractSqlExecutorMediator()
	 * @generated
	 */
	EAttribute getAbstractSqlExecutorMediator_PropertyMinidle();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.AbstractSqlExecutorMediator#getPropertyPoolstatements <em>Property Poolstatements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Property Poolstatements</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.AbstractSqlExecutorMediator#getPropertyPoolstatements()
	 * @see #getAbstractSqlExecutorMediator()
	 * @generated
	 */
	EAttribute getAbstractSqlExecutorMediator_PropertyPoolstatements();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.AbstractSqlExecutorMediator#getPropertyTestonborrow <em>Property Testonborrow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Property Testonborrow</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.AbstractSqlExecutorMediator#getPropertyTestonborrow()
	 * @see #getAbstractSqlExecutorMediator()
	 * @generated
	 */
	EAttribute getAbstractSqlExecutorMediator_PropertyTestonborrow();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.AbstractSqlExecutorMediator#getPropertyTestwhileidle <em>Property Testwhileidle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Property Testwhileidle</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.AbstractSqlExecutorMediator#getPropertyTestwhileidle()
	 * @see #getAbstractSqlExecutorMediator()
	 * @generated
	 */
	EAttribute getAbstractSqlExecutorMediator_PropertyTestwhileidle();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.AbstractSqlExecutorMediator#getPropertyValidationquery <em>Property Validationquery</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Property Validationquery</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.AbstractSqlExecutorMediator#getPropertyValidationquery()
	 * @see #getAbstractSqlExecutorMediator()
	 * @generated
	 */
	EAttribute getAbstractSqlExecutorMediator_PropertyValidationquery();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.AbstractSqlExecutorMediator#getPropertyInitialsize <em>Property Initialsize</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Property Initialsize</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.AbstractSqlExecutorMediator#getPropertyInitialsize()
	 * @see #getAbstractSqlExecutorMediator()
	 * @generated
	 */
	EAttribute getAbstractSqlExecutorMediator_PropertyInitialsize();

	/**
	 * Returns the meta object for the containment reference list '{@link org.wso2.developerstudio.eclipse.esb.mediators.AbstractSqlExecutorMediator#getSqlStatements <em>Sql Statements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sql Statements</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.AbstractSqlExecutorMediator#getSqlStatements()
	 * @see #getAbstractSqlExecutorMediator()
	 * @generated
	 */
	EReference getAbstractSqlExecutorMediator_SqlStatements();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.esb.mediators.SqlStatement <em>Sql Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sql Statement</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.SqlStatement
	 * @generated
	 */
	EClass getSqlStatement();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.SqlStatement#getQueryString <em>Query String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Query String</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.SqlStatement#getQueryString()
	 * @see #getSqlStatement()
	 * @generated
	 */
	EAttribute getSqlStatement_QueryString();

	/**
	 * Returns the meta object for the containment reference list '{@link org.wso2.developerstudio.eclipse.esb.mediators.SqlStatement#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.SqlStatement#getParameters()
	 * @see #getSqlStatement()
	 * @generated
	 */
	EReference getSqlStatement_Parameters();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.SqlStatement#isResultsEnabled <em>Results Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Results Enabled</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.SqlStatement#isResultsEnabled()
	 * @see #getSqlStatement()
	 * @generated
	 */
	EAttribute getSqlStatement_ResultsEnabled();

	/**
	 * Returns the meta object for the containment reference list '{@link org.wso2.developerstudio.eclipse.esb.mediators.SqlStatement#getResults <em>Results</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Results</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.SqlStatement#getResults()
	 * @see #getSqlStatement()
	 * @generated
	 */
	EReference getSqlStatement_Results();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.esb.mediators.SqlParameterDefinition <em>Sql Parameter Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sql Parameter Definition</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.SqlParameterDefinition
	 * @generated
	 */
	EClass getSqlParameterDefinition();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.SqlParameterDefinition#getDataType <em>Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Data Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.SqlParameterDefinition#getDataType()
	 * @see #getSqlParameterDefinition()
	 * @generated
	 */
	EAttribute getSqlParameterDefinition_DataType();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.SqlParameterDefinition#getValueType <em>Value Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.SqlParameterDefinition#getValueType()
	 * @see #getSqlParameterDefinition()
	 * @generated
	 */
	EAttribute getSqlParameterDefinition_ValueType();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.SqlParameterDefinition#getValueLiteral <em>Value Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value Literal</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.SqlParameterDefinition#getValueLiteral()
	 * @see #getSqlParameterDefinition()
	 * @generated
	 */
	EAttribute getSqlParameterDefinition_ValueLiteral();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.esb.mediators.SqlParameterDefinition#getValueExpression <em>Value Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value Expression</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.SqlParameterDefinition#getValueExpression()
	 * @see #getSqlParameterDefinition()
	 * @generated
	 */
	EReference getSqlParameterDefinition_ValueExpression();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.esb.mediators.SqlResultMapping <em>Sql Result Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sql Result Mapping</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.SqlResultMapping
	 * @generated
	 */
	EClass getSqlResultMapping();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.SqlResultMapping#getPropertyName <em>Property Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Property Name</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.SqlResultMapping#getPropertyName()
	 * @see #getSqlResultMapping()
	 * @generated
	 */
	EAttribute getSqlResultMapping_PropertyName();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.SqlResultMapping#getColumnId <em>Column Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Column Id</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.SqlResultMapping#getColumnId()
	 * @see #getSqlResultMapping()
	 * @generated
	 */
	EAttribute getSqlResultMapping_ColumnId();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.esb.mediators.DBLookupMediator <em>DB Lookup Mediator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DB Lookup Mediator</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.DBLookupMediator
	 * @generated
	 */
	EClass getDBLookupMediator();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.esb.mediators.DBReportMediator <em>DB Report Mediator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DB Report Mediator</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.DBReportMediator
	 * @generated
	 */
	EClass getDBReportMediator();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.DBReportMediator#isConnectionUseTransaction <em>Connection Use Transaction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Connection Use Transaction</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.DBReportMediator#isConnectionUseTransaction()
	 * @see #getDBReportMediator()
	 * @generated
	 */
	EAttribute getDBReportMediator_ConnectionUseTransaction();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.esb.mediators.RuleMediator <em>Rule Mediator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rule Mediator</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RuleMediator
	 * @generated
	 */
	EClass getRuleMediator();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.esb.mediators.RuleMediator#getRuleSetConfiguration <em>Rule Set Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Rule Set Configuration</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RuleMediator#getRuleSetConfiguration()
	 * @see #getRuleMediator()
	 * @generated
	 */
	EReference getRuleMediator_RuleSetConfiguration();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.esb.mediators.RuleMediator#getRuleSessionConfiguration <em>Rule Session Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Rule Session Configuration</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RuleMediator#getRuleSessionConfiguration()
	 * @see #getRuleMediator()
	 * @generated
	 */
	EReference getRuleMediator_RuleSessionConfiguration();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.esb.mediators.RuleMediator#getFactsConfiguration <em>Facts Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Facts Configuration</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RuleMediator#getFactsConfiguration()
	 * @see #getRuleMediator()
	 * @generated
	 */
	EReference getRuleMediator_FactsConfiguration();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.esb.mediators.RuleMediator#getResultsConfiguration <em>Results Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Results Configuration</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RuleMediator#getResultsConfiguration()
	 * @see #getRuleMediator()
	 * @generated
	 */
	EReference getRuleMediator_ResultsConfiguration();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.esb.mediators.RuleMediator#getChildMediatorsConfiguration <em>Child Mediators Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Child Mediators Configuration</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RuleMediator#getChildMediatorsConfiguration()
	 * @see #getRuleMediator()
	 * @generated
	 */
	EReference getRuleMediator_ChildMediatorsConfiguration();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.esb.mediators.RuleSetConfiguration <em>Rule Set Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rule Set Configuration</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RuleSetConfiguration
	 * @generated
	 */
	EClass getRuleSetConfiguration();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.RuleSetConfiguration#getSourceType <em>Source Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RuleSetConfiguration#getSourceType()
	 * @see #getRuleSetConfiguration()
	 * @generated
	 */
	EAttribute getRuleSetConfiguration_SourceType();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.RuleSetConfiguration#getSourceCode <em>Source Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source Code</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RuleSetConfiguration#getSourceCode()
	 * @see #getRuleSetConfiguration()
	 * @generated
	 */
	EAttribute getRuleSetConfiguration_SourceCode();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.esb.mediators.RuleSetConfiguration#getSourceKey <em>Source Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Source Key</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RuleSetConfiguration#getSourceKey()
	 * @see #getRuleSetConfiguration()
	 * @generated
	 */
	EReference getRuleSetConfiguration_SourceKey();

	/**
	 * Returns the meta object for the containment reference list '{@link org.wso2.developerstudio.eclipse.esb.mediators.RuleSetConfiguration#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Properties</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RuleSetConfiguration#getProperties()
	 * @see #getRuleSetConfiguration()
	 * @generated
	 */
	EReference getRuleSetConfiguration_Properties();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.esb.mediators.RuleSetCreationProperty <em>Rule Set Creation Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rule Set Creation Property</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RuleSetCreationProperty
	 * @generated
	 */
	EClass getRuleSetCreationProperty();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.esb.mediators.RuleSessionConfiguration <em>Rule Session Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rule Session Configuration</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RuleSessionConfiguration
	 * @generated
	 */
	EClass getRuleSessionConfiguration();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.RuleSessionConfiguration#isStatefulSession <em>Stateful Session</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stateful Session</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RuleSessionConfiguration#isStatefulSession()
	 * @see #getRuleSessionConfiguration()
	 * @generated
	 */
	EAttribute getRuleSessionConfiguration_StatefulSession();

	/**
	 * Returns the meta object for the containment reference list '{@link org.wso2.developerstudio.eclipse.esb.mediators.RuleSessionConfiguration#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Properties</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RuleSessionConfiguration#getProperties()
	 * @see #getRuleSessionConfiguration()
	 * @generated
	 */
	EReference getRuleSessionConfiguration_Properties();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.esb.mediators.RuleSessionProperty <em>Rule Session Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rule Session Property</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RuleSessionProperty
	 * @generated
	 */
	EClass getRuleSessionProperty();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.esb.mediators.RuleFactsConfiguration <em>Rule Facts Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rule Facts Configuration</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RuleFactsConfiguration
	 * @generated
	 */
	EClass getRuleFactsConfiguration();

	/**
	 * Returns the meta object for the containment reference list '{@link org.wso2.developerstudio.eclipse.esb.mediators.RuleFactsConfiguration#getFacts <em>Facts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Facts</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RuleFactsConfiguration#getFacts()
	 * @see #getRuleFactsConfiguration()
	 * @generated
	 */
	EReference getRuleFactsConfiguration_Facts();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.esb.mediators.RuleFact <em>Rule Fact</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rule Fact</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RuleFact
	 * @generated
	 */
	EClass getRuleFact();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.RuleFact#getFactType <em>Fact Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fact Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RuleFact#getFactType()
	 * @see #getRuleFact()
	 * @generated
	 */
	EAttribute getRuleFact_FactType();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.RuleFact#getFactCustomType <em>Fact Custom Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fact Custom Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RuleFact#getFactCustomType()
	 * @see #getRuleFact()
	 * @generated
	 */
	EAttribute getRuleFact_FactCustomType();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.RuleFact#getFactName <em>Fact Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fact Name</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RuleFact#getFactName()
	 * @see #getRuleFact()
	 * @generated
	 */
	EAttribute getRuleFact_FactName();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.RuleFact#getValueType <em>Value Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RuleFact#getValueType()
	 * @see #getRuleFact()
	 * @generated
	 */
	EAttribute getRuleFact_ValueType();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.RuleFact#getValueLiteral <em>Value Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value Literal</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RuleFact#getValueLiteral()
	 * @see #getRuleFact()
	 * @generated
	 */
	EAttribute getRuleFact_ValueLiteral();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.esb.mediators.RuleFact#getValueExpression <em>Value Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value Expression</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RuleFact#getValueExpression()
	 * @see #getRuleFact()
	 * @generated
	 */
	EReference getRuleFact_ValueExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.esb.mediators.RuleFact#getValueKey <em>Value Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value Key</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RuleFact#getValueKey()
	 * @see #getRuleFact()
	 * @generated
	 */
	EReference getRuleFact_ValueKey();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.esb.mediators.RuleResultsConfiguration <em>Rule Results Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rule Results Configuration</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RuleResultsConfiguration
	 * @generated
	 */
	EClass getRuleResultsConfiguration();

	/**
	 * Returns the meta object for the containment reference list '{@link org.wso2.developerstudio.eclipse.esb.mediators.RuleResultsConfiguration#getResults <em>Results</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Results</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RuleResultsConfiguration#getResults()
	 * @see #getRuleResultsConfiguration()
	 * @generated
	 */
	EReference getRuleResultsConfiguration_Results();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.esb.mediators.RuleResult <em>Rule Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rule Result</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RuleResult
	 * @generated
	 */
	EClass getRuleResult();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.RuleResult#getResultType <em>Result Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Result Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RuleResult#getResultType()
	 * @see #getRuleResult()
	 * @generated
	 */
	EAttribute getRuleResult_ResultType();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.RuleResult#getResultCustomType <em>Result Custom Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Result Custom Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RuleResult#getResultCustomType()
	 * @see #getRuleResult()
	 * @generated
	 */
	EAttribute getRuleResult_ResultCustomType();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.RuleResult#getResultName <em>Result Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Result Name</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RuleResult#getResultName()
	 * @see #getRuleResult()
	 * @generated
	 */
	EAttribute getRuleResult_ResultName();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.RuleResult#getValueType <em>Value Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RuleResult#getValueType()
	 * @see #getRuleResult()
	 * @generated
	 */
	EAttribute getRuleResult_ValueType();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.RuleResult#getValueLiteral <em>Value Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value Literal</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RuleResult#getValueLiteral()
	 * @see #getRuleResult()
	 * @generated
	 */
	EAttribute getRuleResult_ValueLiteral();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.esb.mediators.RuleResult#getValueExpression <em>Value Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value Expression</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RuleResult#getValueExpression()
	 * @see #getRuleResult()
	 * @generated
	 */
	EReference getRuleResult_ValueExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.esb.mediators.RuleResult#getValueKey <em>Value Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value Key</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RuleResult#getValueKey()
	 * @see #getRuleResult()
	 * @generated
	 */
	EReference getRuleResult_ValueKey();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.esb.mediators.RuleChildMediatorsConfiguration <em>Rule Child Mediators Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rule Child Mediators Configuration</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RuleChildMediatorsConfiguration
	 * @generated
	 */
	EClass getRuleChildMediatorsConfiguration();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.esb.mediators.SequenceMediator <em>Sequence Mediator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sequence Mediator</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.SequenceMediator
	 * @generated
	 */
	EClass getSequenceMediator();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.SequenceMediator#getReferringSequenceType <em>Referring Sequence Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Referring Sequence Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.SequenceMediator#getReferringSequenceType()
	 * @see #getSequenceMediator()
	 * @generated
	 */
	EAttribute getSequenceMediator_ReferringSequenceType();

	/**
	 * Returns the meta object for the reference '{@link org.wso2.developerstudio.eclipse.esb.mediators.SequenceMediator#getDynamicReferenceKey <em>Dynamic Reference Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Dynamic Reference Key</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.SequenceMediator#getDynamicReferenceKey()
	 * @see #getSequenceMediator()
	 * @generated
	 */
	EReference getSequenceMediator_DynamicReferenceKey();

	/**
	 * Returns the meta object for the reference '{@link org.wso2.developerstudio.eclipse.esb.mediators.SequenceMediator#getStaticReferenceKey <em>Static Reference Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Static Reference Key</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.SequenceMediator#getStaticReferenceKey()
	 * @see #getSequenceMediator()
	 * @generated
	 */
	EReference getSequenceMediator_StaticReferenceKey();

	/**
	 * Returns the meta object for the reference '{@link org.wso2.developerstudio.eclipse.esb.mediators.SequenceMediator#getSequenceKey <em>Sequence Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Sequence Key</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.SequenceMediator#getSequenceKey()
	 * @see #getSequenceMediator()
	 * @generated
	 */
	EReference getSequenceMediator_SequenceKey();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.esb.mediators.BuilderMediator <em>Builder Mediator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Builder Mediator</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.BuilderMediator
	 * @generated
	 */
	EClass getBuilderMediator();

	/**
	 * Returns the meta object for the containment reference list '{@link org.wso2.developerstudio.eclipse.esb.mediators.BuilderMediator#getMessageBuilders <em>Message Builders</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Message Builders</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.BuilderMediator#getMessageBuilders()
	 * @see #getBuilderMediator()
	 * @generated
	 */
	EReference getBuilderMediator_MessageBuilders();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.esb.mediators.MessageBuilder <em>Message Builder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Message Builder</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MessageBuilder
	 * @generated
	 */
	EClass getMessageBuilder();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.MessageBuilder#getContentType <em>Content Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Content Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MessageBuilder#getContentType()
	 * @see #getMessageBuilder()
	 * @generated
	 */
	EAttribute getMessageBuilder_ContentType();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.MessageBuilder#getBuilderClass <em>Builder Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Builder Class</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MessageBuilder#getBuilderClass()
	 * @see #getMessageBuilder()
	 * @generated
	 */
	EAttribute getMessageBuilder_BuilderClass();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.MessageBuilder#getFormatterClass <em>Formatter Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Formatter Class</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MessageBuilder#getFormatterClass()
	 * @see #getMessageBuilder()
	 * @generated
	 */
	EAttribute getMessageBuilder_FormatterClass();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.esb.mediators.SmooksMediator <em>Smooks Mediator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Smooks Mediator</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.SmooksMediator
	 * @generated
	 */
	EClass getSmooksMediator();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.esb.mediators.SmooksMediator#getConfigurationKey <em>Configuration Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Configuration Key</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.SmooksMediator#getConfigurationKey()
	 * @see #getSmooksMediator()
	 * @generated
	 */
	EReference getSmooksMediator_ConfigurationKey();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.esb.mediators.SmooksMediator#getInput <em>Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Input</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.SmooksMediator#getInput()
	 * @see #getSmooksMediator()
	 * @generated
	 */
	EReference getSmooksMediator_Input();

	/**
	 * Returns the meta object for the containment reference '{@link org.wso2.developerstudio.eclipse.esb.mediators.SmooksMediator#getOutput <em>Output</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Output</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.SmooksMediator#getOutput()
	 * @see #getSmooksMediator()
	 * @generated
	 */
	EReference getSmooksMediator_Output();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.esb.mediators.SmooksInConfiguration <em>Smooks In Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Smooks In Configuration</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.SmooksInConfiguration
	 * @generated
	 */
	EClass getSmooksInConfiguration();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.SmooksInConfiguration#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.SmooksInConfiguration#getType()
	 * @see #getSmooksInConfiguration()
	 * @generated
	 */
	EAttribute getSmooksInConfiguration_Type();

	/**
	 * Returns the meta object for the reference '{@link org.wso2.developerstudio.eclipse.esb.mediators.SmooksInConfiguration#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Expression</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.SmooksInConfiguration#getExpression()
	 * @see #getSmooksInConfiguration()
	 * @generated
	 */
	EReference getSmooksInConfiguration_Expression();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.esb.mediators.SmooksOutConfiguration <em>Smooks Out Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Smooks Out Configuration</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.SmooksOutConfiguration
	 * @generated
	 */
	EClass getSmooksOutConfiguration();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.SmooksOutConfiguration#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.SmooksOutConfiguration#getType()
	 * @see #getSmooksOutConfiguration()
	 * @generated
	 */
	EAttribute getSmooksOutConfiguration_Type();

	/**
	 * Returns the meta object for the reference '{@link org.wso2.developerstudio.eclipse.esb.mediators.SmooksOutConfiguration#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Expression</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.SmooksOutConfiguration#getExpression()
	 * @see #getSmooksOutConfiguration()
	 * @generated
	 */
	EReference getSmooksOutConfiguration_Expression();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.SmooksOutConfiguration#getProperty <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Property</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.SmooksOutConfiguration#getProperty()
	 * @see #getSmooksOutConfiguration()
	 * @generated
	 */
	EAttribute getSmooksOutConfiguration_Property();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.SmooksOutConfiguration#getAction <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Action</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.SmooksOutConfiguration#getAction()
	 * @see #getSmooksOutConfiguration()
	 * @generated
	 */
	EAttribute getSmooksOutConfiguration_Action();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.SmooksOutConfiguration#getOutputMethod <em>Output Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Output Method</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.SmooksOutConfiguration#getOutputMethod()
	 * @see #getSmooksOutConfiguration()
	 * @generated
	 */
	EAttribute getSmooksOutConfiguration_OutputMethod();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.esb.mediators.StoreMediator <em>Store Mediator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Store Mediator</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.StoreMediator
	 * @generated
	 */
	EClass getStoreMediator();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.StoreMediator#getMessageStore <em>Message Store</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Message Store</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.StoreMediator#getMessageStore()
	 * @see #getStoreMediator()
	 * @generated
	 */
	EAttribute getStoreMediator_MessageStore();

	/**
	 * Returns the meta object for the reference '{@link org.wso2.developerstudio.eclipse.esb.mediators.StoreMediator#getOnStoreSequence <em>On Store Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>On Store Sequence</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.StoreMediator#getOnStoreSequence()
	 * @see #getStoreMediator()
	 * @generated
	 */
	EReference getStoreMediator_OnStoreSequence();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.esb.mediators.ConditionalRouteBranch <em>Conditional Route Branch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Conditional Route Branch</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ConditionalRouteBranch
	 * @generated
	 */
	EClass getConditionalRouteBranch();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.ConditionalRouteBranch#isBreakAfterRoute <em>Break After Route</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Break After Route</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ConditionalRouteBranch#isBreakAfterRoute()
	 * @see #getConditionalRouteBranch()
	 * @generated
	 */
	EAttribute getConditionalRouteBranch_BreakAfterRoute();

	/**
	 * Returns the meta object for the reference '{@link org.wso2.developerstudio.eclipse.esb.mediators.ConditionalRouteBranch#getEvaluatorExpression <em>Evaluator Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Evaluator Expression</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ConditionalRouteBranch#getEvaluatorExpression()
	 * @see #getConditionalRouteBranch()
	 * @generated
	 */
	EReference getConditionalRouteBranch_EvaluatorExpression();

	/**
	 * Returns the meta object for the reference '{@link org.wso2.developerstudio.eclipse.esb.mediators.ConditionalRouteBranch#getTargetSequence <em>Target Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Sequence</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ConditionalRouteBranch#getTargetSequence()
	 * @see #getConditionalRouteBranch()
	 * @generated
	 */
	EReference getConditionalRouteBranch_TargetSequence();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.esb.mediators.ConditionalRouterMediator <em>Conditional Router Mediator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Conditional Router Mediator</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ConditionalRouterMediator
	 * @generated
	 */
	EClass getConditionalRouterMediator();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.ConditionalRouterMediator#isContinueAfterRoute <em>Continue After Route</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Continue After Route</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ConditionalRouterMediator#isContinueAfterRoute()
	 * @see #getConditionalRouterMediator()
	 * @generated
	 */
	EAttribute getConditionalRouterMediator_ContinueAfterRoute();

	/**
	 * Returns the meta object for the containment reference list '{@link org.wso2.developerstudio.eclipse.esb.mediators.ConditionalRouterMediator#getConditionalRouteBraches <em>Conditional Route Braches</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Conditional Route Braches</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ConditionalRouterMediator#getConditionalRouteBraches()
	 * @see #getConditionalRouterMediator()
	 * @generated
	 */
	EReference getConditionalRouterMediator_ConditionalRouteBraches();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.esb.mediators.URLRewriteRuleAction <em>URL Rewrite Rule Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>URL Rewrite Rule Action</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.URLRewriteRuleAction
	 * @generated
	 */
	EClass getURLRewriteRuleAction();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.URLRewriteRuleAction#getRuleAction <em>Rule Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rule Action</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.URLRewriteRuleAction#getRuleAction()
	 * @see #getURLRewriteRuleAction()
	 * @generated
	 */
	EAttribute getURLRewriteRuleAction_RuleAction();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.URLRewriteRuleAction#getRuleFragment <em>Rule Fragment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rule Fragment</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.URLRewriteRuleAction#getRuleFragment()
	 * @see #getURLRewriteRuleAction()
	 * @generated
	 */
	EAttribute getURLRewriteRuleAction_RuleFragment();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.URLRewriteRuleAction#getRuleOption <em>Rule Option</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rule Option</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.URLRewriteRuleAction#getRuleOption()
	 * @see #getURLRewriteRuleAction()
	 * @generated
	 */
	EAttribute getURLRewriteRuleAction_RuleOption();

	/**
	 * Returns the meta object for the reference '{@link org.wso2.developerstudio.eclipse.esb.mediators.URLRewriteRuleAction#getActionExpression <em>Action Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Action Expression</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.URLRewriteRuleAction#getActionExpression()
	 * @see #getURLRewriteRuleAction()
	 * @generated
	 */
	EReference getURLRewriteRuleAction_ActionExpression();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.URLRewriteRuleAction#getActionValue <em>Action Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Action Value</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.URLRewriteRuleAction#getActionValue()
	 * @see #getURLRewriteRuleAction()
	 * @generated
	 */
	EAttribute getURLRewriteRuleAction_ActionValue();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.URLRewriteRuleAction#getActionRegex <em>Action Regex</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Action Regex</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.URLRewriteRuleAction#getActionRegex()
	 * @see #getURLRewriteRuleAction()
	 * @generated
	 */
	EAttribute getURLRewriteRuleAction_ActionRegex();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.esb.mediators.URLRewriteRule <em>URL Rewrite Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>URL Rewrite Rule</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.URLRewriteRule
	 * @generated
	 */
	EClass getURLRewriteRule();

	/**
	 * Returns the meta object for the reference '{@link org.wso2.developerstudio.eclipse.esb.mediators.URLRewriteRule#getUrlRewriteRuleCondition <em>Url Rewrite Rule Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Url Rewrite Rule Condition</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.URLRewriteRule#getUrlRewriteRuleCondition()
	 * @see #getURLRewriteRule()
	 * @generated
	 */
	EReference getURLRewriteRule_UrlRewriteRuleCondition();

	/**
	 * Returns the meta object for the containment reference list '{@link org.wso2.developerstudio.eclipse.esb.mediators.URLRewriteRule#getRewriteRuleAction <em>Rewrite Rule Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Rewrite Rule Action</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.URLRewriteRule#getRewriteRuleAction()
	 * @see #getURLRewriteRule()
	 * @generated
	 */
	EReference getURLRewriteRule_RewriteRuleAction();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.esb.mediators.URLRewriteMediator <em>URL Rewrite Mediator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>URL Rewrite Mediator</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.URLRewriteMediator
	 * @generated
	 */
	EClass getURLRewriteMediator();

	/**
	 * Returns the meta object for the containment reference list '{@link org.wso2.developerstudio.eclipse.esb.mediators.URLRewriteMediator#getUrlRewriteRules <em>Url Rewrite Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Url Rewrite Rules</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.URLRewriteMediator#getUrlRewriteRules()
	 * @see #getURLRewriteMediator()
	 * @generated
	 */
	EReference getURLRewriteMediator_UrlRewriteRules();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.URLRewriteMediator#getInProperty <em>In Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>In Property</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.URLRewriteMediator#getInProperty()
	 * @see #getURLRewriteMediator()
	 * @generated
	 */
	EAttribute getURLRewriteMediator_InProperty();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.URLRewriteMediator#getOutProperty <em>Out Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Out Property</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.URLRewriteMediator#getOutProperty()
	 * @see #getURLRewriteMediator()
	 * @generated
	 */
	EAttribute getURLRewriteMediator_OutProperty();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.esb.mediators.CallTemplateMediator <em>Call Template Mediator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Call Template Mediator</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CallTemplateMediator
	 * @generated
	 */
	EClass getCallTemplateMediator();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.CallTemplateMediator#getTargetTemplate <em>Target Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target Template</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CallTemplateMediator#getTargetTemplate()
	 * @see #getCallTemplateMediator()
	 * @generated
	 */
	EAttribute getCallTemplateMediator_TargetTemplate();

	/**
	 * Returns the meta object for the containment reference list '{@link org.wso2.developerstudio.eclipse.esb.mediators.CallTemplateMediator#getTemplateParameters <em>Template Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Template Parameters</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CallTemplateMediator#getTemplateParameters()
	 * @see #getCallTemplateMediator()
	 * @generated
	 */
	EReference getCallTemplateMediator_TemplateParameters();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.esb.mediators.CallTemplateParameter <em>Call Template Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Call Template Parameter</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CallTemplateParameter
	 * @generated
	 */
	EClass getCallTemplateParameter();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.CallTemplateParameter#getParameterName <em>Parameter Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Parameter Name</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CallTemplateParameter#getParameterName()
	 * @see #getCallTemplateParameter()
	 * @generated
	 */
	EAttribute getCallTemplateParameter_ParameterName();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.CallTemplateParameter#getTemplateParameterType <em>Template Parameter Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Template Parameter Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CallTemplateParameter#getTemplateParameterType()
	 * @see #getCallTemplateParameter()
	 * @generated
	 */
	EAttribute getCallTemplateParameter_TemplateParameterType();

	/**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.CallTemplateParameter#getParameterValue <em>Parameter Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Parameter Value</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CallTemplateParameter#getParameterValue()
	 * @see #getCallTemplateParameter()
	 * @generated
	 */
	EAttribute getCallTemplateParameter_ParameterValue();

	/**
	 * Returns the meta object for the reference '{@link org.wso2.developerstudio.eclipse.esb.mediators.CallTemplateParameter#getParameterExpression <em>Parameter Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parameter Expression</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CallTemplateParameter#getParameterExpression()
	 * @see #getCallTemplateParameter()
	 * @generated
	 */
	EReference getCallTemplateParameter_ParameterExpression();

	/**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.esb.mediators.PayloadFactoryMediator <em>Payload Factory Mediator</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Payload Factory Mediator</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.PayloadFactoryMediator
	 * @generated
	 */
    EClass getPayloadFactoryMediator();

    /**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.PayloadFactoryMediator#getFormat <em>Format</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Format</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.PayloadFactoryMediator#getFormat()
	 * @see #getPayloadFactoryMediator()
	 * @generated
	 */
    EAttribute getPayloadFactoryMediator_Format();

    /**
	 * Returns the meta object for the containment reference list '{@link org.wso2.developerstudio.eclipse.esb.mediators.PayloadFactoryMediator#getArgs <em>Args</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Args</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.PayloadFactoryMediator#getArgs()
	 * @see #getPayloadFactoryMediator()
	 * @generated
	 */
    EReference getPayloadFactoryMediator_Args();

    /**
	 * Returns the meta object for class '{@link org.wso2.developerstudio.eclipse.esb.mediators.PayloadFactoryArgument <em>Payload Factory Argument</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Payload Factory Argument</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.PayloadFactoryArgument
	 * @generated
	 */
    EClass getPayloadFactoryArgument();

    /**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.PayloadFactoryArgument#getArgumentType <em>Argument Type</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Argument Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.PayloadFactoryArgument#getArgumentType()
	 * @see #getPayloadFactoryArgument()
	 * @generated
	 */
    EAttribute getPayloadFactoryArgument_ArgumentType();

    /**
	 * Returns the meta object for the attribute '{@link org.wso2.developerstudio.eclipse.esb.mediators.PayloadFactoryArgument#getArgumentValue <em>Argument Value</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Argument Value</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.PayloadFactoryArgument#getArgumentValue()
	 * @see #getPayloadFactoryArgument()
	 * @generated
	 */
    EAttribute getPayloadFactoryArgument_ArgumentValue();

    /**
	 * Returns the meta object for the reference '{@link org.wso2.developerstudio.eclipse.esb.mediators.PayloadFactoryArgument#getArgumentExpression <em>Argument Expression</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Argument Expression</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.PayloadFactoryArgument#getArgumentExpression()
	 * @see #getPayloadFactoryArgument()
	 * @generated
	 */
    EReference getPayloadFactoryArgument_ArgumentExpression();

    /**
	 * Returns the meta object for enum '{@link org.wso2.developerstudio.eclipse.esb.mediators.LogCategory <em>Log Category</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Log Category</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.LogCategory
	 * @generated
	 */
	EEnum getLogCategory();

	/**
	 * Returns the meta object for enum '{@link org.wso2.developerstudio.eclipse.esb.mediators.LogLevel <em>Log Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Log Level</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.LogLevel
	 * @generated
	 */
	EEnum getLogLevel();

	/**
	 * Returns the meta object for enum '{@link org.wso2.developerstudio.eclipse.esb.mediators.FilterConditionType <em>Filter Condition Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Filter Condition Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.FilterConditionType
	 * @generated
	 */
	EEnum getFilterConditionType();

	/**
	 * Returns the meta object for enum '{@link org.wso2.developerstudio.eclipse.esb.mediators.EntitlementSequence <em>Entitlement Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Entitlement Sequence</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.EntitlementSequence
	 * @generated
	 */
	EEnum getEntitlementSequence();

	/**
	 * Returns the meta object for enum '{@link org.wso2.developerstudio.eclipse.esb.mediators.ScriptType <em>Script Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Script Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ScriptType
	 * @generated
	 */
	EEnum getScriptType();

	/**
	 * Returns the meta object for enum '{@link org.wso2.developerstudio.eclipse.esb.mediators.ScriptLanguage <em>Script Language</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Script Language</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ScriptLanguage
	 * @generated
	 */
	EEnum getScriptLanguage();

	/**
	 * Returns the meta object for enum '{@link org.wso2.developerstudio.eclipse.esb.mediators.EnrichSourceType <em>Enrich Source Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Enrich Source Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.EnrichSourceType
	 * @generated
	 */
	EEnum getEnrichSourceType();

	/**
	 * Returns the meta object for enum '{@link org.wso2.developerstudio.eclipse.esb.mediators.EnrichTargetAction <em>Enrich Target Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Enrich Target Action</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.EnrichTargetAction
	 * @generated
	 */
	EEnum getEnrichTargetAction();

	/**
	 * Returns the meta object for enum '{@link org.wso2.developerstudio.eclipse.esb.mediators.EnrichTargetType <em>Enrich Target Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Enrich Target Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.EnrichTargetType
	 * @generated
	 */
	EEnum getEnrichTargetType();

	/**
	 * Returns the meta object for enum '{@link org.wso2.developerstudio.eclipse.esb.mediators.FaultSoapVersion <em>Fault Soap Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Fault Soap Version</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.FaultSoapVersion
	 * @generated
	 */
	EEnum getFaultSoapVersion();

	/**
	 * Returns the meta object for enum '{@link org.wso2.developerstudio.eclipse.esb.mediators.FaultCodeSoap11 <em>Fault Code Soap11</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Fault Code Soap11</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.FaultCodeSoap11
	 * @generated
	 */
	EEnum getFaultCodeSoap11();

	/**
	 * Returns the meta object for enum '{@link org.wso2.developerstudio.eclipse.esb.mediators.FaultCodeSoap12 <em>Fault Code Soap12</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Fault Code Soap12</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.FaultCodeSoap12
	 * @generated
	 */
	EEnum getFaultCodeSoap12();

	/**
	 * Returns the meta object for enum '{@link org.wso2.developerstudio.eclipse.esb.mediators.FaultStringType <em>Fault String Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Fault String Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.FaultStringType
	 * @generated
	 */
	EEnum getFaultStringType();

	/**
	 * Returns the meta object for enum '{@link org.wso2.developerstudio.eclipse.esb.mediators.FaultReasonType <em>Fault Reason Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Fault Reason Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.FaultReasonType
	 * @generated
	 */
	EEnum getFaultReasonType();

	/**
	 * Returns the meta object for enum '{@link org.wso2.developerstudio.eclipse.esb.mediators.FaultDetailType <em>Fault Detail Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Fault Detail Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.FaultDetailType
	 * @generated
	 */
	EEnum getFaultDetailType();

	/**
	 * Returns the meta object for enum '{@link org.wso2.developerstudio.eclipse.esb.mediators.AggregateSequenceType <em>Aggregate Sequence Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Aggregate Sequence Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.AggregateSequenceType
	 * @generated
	 */
	EEnum getAggregateSequenceType();

	/**
	 * Returns the meta object for enum '{@link org.wso2.developerstudio.eclipse.esb.mediators.CacheSequenceType <em>Cache Sequence Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Cache Sequence Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CacheSequenceType
	 * @generated
	 */
	EEnum getCacheSequenceType();

	/**
	 * Returns the meta object for enum '{@link org.wso2.developerstudio.eclipse.esb.mediators.CacheImplementationType <em>Cache Implementation Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Cache Implementation Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CacheImplementationType
	 * @generated
	 */
	EEnum getCacheImplementationType();

	/**
	 * Returns the meta object for enum '{@link org.wso2.developerstudio.eclipse.esb.mediators.CacheAction <em>Cache Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Cache Action</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CacheAction
	 * @generated
	 */
	EEnum getCacheAction();

	/**
	 * Returns the meta object for enum '{@link org.wso2.developerstudio.eclipse.esb.mediators.CacheScope <em>Cache Scope</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Cache Scope</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CacheScope
	 * @generated
	 */
	EEnum getCacheScope();

	/**
	 * Returns the meta object for enum '{@link org.wso2.developerstudio.eclipse.esb.mediators.XQueryVariableType <em>XQuery Variable Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>XQuery Variable Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.XQueryVariableType
	 * @generated
	 */
	EEnum getXQueryVariableType();

	/**
	 * Returns the meta object for enum '{@link org.wso2.developerstudio.eclipse.esb.mediators.XQueryVariableValueType <em>XQuery Variable Value Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>XQuery Variable Value Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.XQueryVariableValueType
	 * @generated
	 */
	EEnum getXQueryVariableValueType();

	/**
	 * Returns the meta object for enum '{@link org.wso2.developerstudio.eclipse.esb.mediators.CalloutPayloadType <em>Callout Payload Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Callout Payload Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CalloutPayloadType
	 * @generated
	 */
	EEnum getCalloutPayloadType();

	/**
	 * Returns the meta object for enum '{@link org.wso2.developerstudio.eclipse.esb.mediators.CalloutResultType <em>Callout Result Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Callout Result Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CalloutResultType
	 * @generated
	 */
	EEnum getCalloutResultType();

	/**
	 * Returns the meta object for enum '{@link org.wso2.developerstudio.eclipse.esb.mediators.RMSpecVersion <em>RM Spec Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>RM Spec Version</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RMSpecVersion
	 * @generated
	 */
	EEnum getRMSpecVersion();

	/**
	 * Returns the meta object for enum '{@link org.wso2.developerstudio.eclipse.esb.mediators.RMSequenceType <em>RM Sequence Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>RM Sequence Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RMSequenceType
	 * @generated
	 */
	EEnum getRMSequenceType();

	/**
	 * Returns the meta object for enum '{@link org.wso2.developerstudio.eclipse.esb.mediators.TransactionAction <em>Transaction Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Transaction Action</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.TransactionAction
	 * @generated
	 */
	EEnum getTransactionAction();

	/**
	 * Returns the meta object for enum '{@link org.wso2.developerstudio.eclipse.esb.mediators.PropertyDataType <em>Property Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Property Data Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.PropertyDataType
	 * @generated
	 */
	EEnum getPropertyDataType();

	/**
	 * Returns the meta object for enum '{@link org.wso2.developerstudio.eclipse.esb.mediators.PropertyAction <em>Property Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Property Action</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.PropertyAction
	 * @generated
	 */
	EEnum getPropertyAction();

	/**
	 * Returns the meta object for enum '{@link org.wso2.developerstudio.eclipse.esb.mediators.PropertyScope <em>Property Scope</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Property Scope</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.PropertyScope
	 * @generated
	 */
	EEnum getPropertyScope();

	/**
	 * Returns the meta object for enum '{@link org.wso2.developerstudio.eclipse.esb.mediators.PropertyValueType <em>Property Value Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Property Value Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.PropertyValueType
	 * @generated
	 */
	EEnum getPropertyValueType();

	/**
	 * Returns the meta object for enum '{@link org.wso2.developerstudio.eclipse.esb.mediators.HeaderAction <em>Header Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Header Action</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.HeaderAction
	 * @generated
	 */
	EEnum getHeaderAction();

	/**
	 * Returns the meta object for enum '{@link org.wso2.developerstudio.eclipse.esb.mediators.HeaderValueType <em>Header Value Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Header Value Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.HeaderValueType
	 * @generated
	 */
	EEnum getHeaderValueType();

	/**
	 * Returns the meta object for enum '{@link org.wso2.developerstudio.eclipse.esb.mediators.ThrottlePolicyType <em>Throttle Policy Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Throttle Policy Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ThrottlePolicyType
	 * @generated
	 */
	EEnum getThrottlePolicyType();

	/**
	 * Returns the meta object for enum '{@link org.wso2.developerstudio.eclipse.esb.mediators.ThrottleConditionType <em>Throttle Condition Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Throttle Condition Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ThrottleConditionType
	 * @generated
	 */
	EEnum getThrottleConditionType();

	/**
	 * Returns the meta object for enum '{@link org.wso2.developerstudio.eclipse.esb.mediators.ThrottleAccessType <em>Throttle Access Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Throttle Access Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ThrottleAccessType
	 * @generated
	 */
	EEnum getThrottleAccessType();

	/**
	 * Returns the meta object for enum '{@link org.wso2.developerstudio.eclipse.esb.mediators.ThrottleSequenceType <em>Throttle Sequence Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Throttle Sequence Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ThrottleSequenceType
	 * @generated
	 */
	EEnum getThrottleSequenceType();

	/**
	 * Returns the meta object for enum '{@link org.wso2.developerstudio.eclipse.esb.mediators.CommandPropertyValueType <em>Command Property Value Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Command Property Value Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CommandPropertyValueType
	 * @generated
	 */
	EEnum getCommandPropertyValueType();

	/**
	 * Returns the meta object for enum '{@link org.wso2.developerstudio.eclipse.esb.mediators.CommandPropertyMessageAction <em>Command Property Message Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Command Property Message Action</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CommandPropertyMessageAction
	 * @generated
	 */
	EEnum getCommandPropertyMessageAction();

	/**
	 * Returns the meta object for enum '{@link org.wso2.developerstudio.eclipse.esb.mediators.CommandPropertyContextAction <em>Command Property Context Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Command Property Context Action</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CommandPropertyContextAction
	 * @generated
	 */
	EEnum getCommandPropertyContextAction();

	/**
	 * Returns the meta object for enum '{@link org.wso2.developerstudio.eclipse.esb.mediators.SqlExecutorConnectionType <em>Sql Executor Connection Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Sql Executor Connection Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.SqlExecutorConnectionType
	 * @generated
	 */
	EEnum getSqlExecutorConnectionType();

	/**
	 * Returns the meta object for enum '{@link org.wso2.developerstudio.eclipse.esb.mediators.SqlExecutorDatasourceType <em>Sql Executor Datasource Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Sql Executor Datasource Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.SqlExecutorDatasourceType
	 * @generated
	 */
	EEnum getSqlExecutorDatasourceType();

	/**
	 * Returns the meta object for enum '{@link org.wso2.developerstudio.eclipse.esb.mediators.SqlExecutorBooleanValue <em>Sql Executor Boolean Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Sql Executor Boolean Value</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.SqlExecutorBooleanValue
	 * @generated
	 */
	EEnum getSqlExecutorBooleanValue();

	/**
	 * Returns the meta object for enum '{@link org.wso2.developerstudio.eclipse.esb.mediators.SqlExecutorIsolationLevel <em>Sql Executor Isolation Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Sql Executor Isolation Level</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.SqlExecutorIsolationLevel
	 * @generated
	 */
	EEnum getSqlExecutorIsolationLevel();

	/**
	 * Returns the meta object for enum '{@link org.wso2.developerstudio.eclipse.esb.mediators.SqlParameterValueType <em>Sql Parameter Value Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Sql Parameter Value Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.SqlParameterValueType
	 * @generated
	 */
	EEnum getSqlParameterValueType();

	/**
	 * Returns the meta object for enum '{@link org.wso2.developerstudio.eclipse.esb.mediators.SqlParameterDataType <em>Sql Parameter Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Sql Parameter Data Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.SqlParameterDataType
	 * @generated
	 */
	EEnum getSqlParameterDataType();

	/**
	 * Returns the meta object for enum '{@link org.wso2.developerstudio.eclipse.esb.mediators.RuleSourceType <em>Rule Source Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Rule Source Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RuleSourceType
	 * @generated
	 */
	EEnum getRuleSourceType();

	/**
	 * Returns the meta object for enum '{@link org.wso2.developerstudio.eclipse.esb.mediators.RuleFactType <em>Rule Fact Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Rule Fact Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RuleFactType
	 * @generated
	 */
	EEnum getRuleFactType();

	/**
	 * Returns the meta object for enum '{@link org.wso2.developerstudio.eclipse.esb.mediators.RuleFactValueType <em>Rule Fact Value Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Rule Fact Value Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RuleFactValueType
	 * @generated
	 */
	EEnum getRuleFactValueType();

	/**
	 * Returns the meta object for enum '{@link org.wso2.developerstudio.eclipse.esb.mediators.RuleResultType <em>Rule Result Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Rule Result Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RuleResultType
	 * @generated
	 */
	EEnum getRuleResultType();

	/**
	 * Returns the meta object for enum '{@link org.wso2.developerstudio.eclipse.esb.mediators.RuleResultValueType <em>Rule Result Value Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Rule Result Value Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RuleResultValueType
	 * @generated
	 */
	EEnum getRuleResultValueType();

	/**
	 * Returns the meta object for enum '{@link org.wso2.developerstudio.eclipse.esb.mediators.SmooksIODataType <em>Smooks IO Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Smooks IO Data Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.SmooksIODataType
	 * @generated
	 */
	EEnum getSmooksIODataType();

	/**
	 * Returns the meta object for enum '{@link org.wso2.developerstudio.eclipse.esb.mediators.ExpressionAction <em>Expression Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Expression Action</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ExpressionAction
	 * @generated
	 */
	EEnum getExpressionAction();

	/**
	 * Returns the meta object for enum '{@link org.wso2.developerstudio.eclipse.esb.mediators.OutputMethod <em>Output Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Output Method</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.OutputMethod
	 * @generated
	 */
	EEnum getOutputMethod();

	/**
	 * Returns the meta object for enum '{@link org.wso2.developerstudio.eclipse.esb.mediators.ReceivingSequenceType <em>Receiving Sequence Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Receiving Sequence Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.ReceivingSequenceType
	 * @generated
	 */
	EEnum getReceivingSequenceType();

	/**
	 * Returns the meta object for enum '{@link org.wso2.developerstudio.eclipse.esb.mediators.KeyType <em>Key Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Key Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.KeyType
	 * @generated
	 */
	EEnum getKeyType();

	/**
	 * Returns the meta object for enum '{@link org.wso2.developerstudio.eclipse.esb.mediators.RuleActionType <em>Rule Action Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Rule Action Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RuleActionType
	 * @generated
	 */
	EEnum getRuleActionType();

	/**
	 * Returns the meta object for enum '{@link org.wso2.developerstudio.eclipse.esb.mediators.RuleFragmentType <em>Rule Fragment Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Rule Fragment Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RuleFragmentType
	 * @generated
	 */
	EEnum getRuleFragmentType();

	/**
	 * Returns the meta object for enum '{@link org.wso2.developerstudio.eclipse.esb.mediators.RuleOptionType <em>Rule Option Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Rule Option Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.RuleOptionType
	 * @generated
	 */
	EEnum getRuleOptionType();

	/**
	 * Returns the meta object for enum '{@link org.wso2.developerstudio.eclipse.esb.mediators.EnrichSourceInlineType <em>Enrich Source Inline Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Enrich Source Inline Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.EnrichSourceInlineType
	 * @generated
	 */
	EEnum getEnrichSourceInlineType();

	/**
	 * Returns the meta object for enum '{@link org.wso2.developerstudio.eclipse.esb.mediators.PayloadFactoryArgumentType <em>Payload Factory Argument Type</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Payload Factory Argument Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.PayloadFactoryArgumentType
	 * @generated
	 */
    EEnum getPayloadFactoryArgumentType();

    /**
	 * Returns the meta object for enum '{@link org.wso2.developerstudio.eclipse.esb.mediators.CallOutMediatorEndpointType <em>Call Out Mediator Endpoint Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Call Out Mediator Endpoint Type</em>'.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CallOutMediatorEndpointType
	 * @generated
	 */
	EEnum getCallOutMediatorEndpointType();

				/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	MediatorsFactory getMediatorsFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.InMediatorImpl <em>In Mediator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.InMediatorImpl
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getInMediator()
		 * @generated
		 */
		EClass IN_MEDIATOR = eINSTANCE.getInMediator();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.OutMediatorImpl <em>Out Mediator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.OutMediatorImpl
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getOutMediator()
		 * @generated
		 */
		EClass OUT_MEDIATOR = eINSTANCE.getOutMediator();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.DropMediatorImpl <em>Drop Mediator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.DropMediatorImpl
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getDropMediator()
		 * @generated
		 */
		EClass DROP_MEDIATOR = eINSTANCE.getDropMediator();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.SendMediatorImpl <em>Send Mediator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.SendMediatorImpl
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getSendMediator()
		 * @generated
		 */
		EClass SEND_MEDIATOR = eINSTANCE.getSendMediator();

		/**
		 * The meta object literal for the '<em><b>Anonymous End Point</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEND_MEDIATOR__ANONYMOUS_END_POINT = eINSTANCE.getSendMediator_AnonymousEndPoint();

		/**
		 * The meta object literal for the '<em><b>End Point Reference</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEND_MEDIATOR__END_POINT_REFERENCE = eINSTANCE.getSendMediator_EndPointReference();

		/**
		 * The meta object literal for the '<em><b>Receiving Sequence Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEND_MEDIATOR__RECEIVING_SEQUENCE_TYPE = eINSTANCE.getSendMediator_ReceivingSequenceType();

		/**
		 * The meta object literal for the '<em><b>Static Receiving Sequence</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEND_MEDIATOR__STATIC_RECEIVING_SEQUENCE = eINSTANCE.getSendMediator_StaticReceivingSequence();

		/**
		 * The meta object literal for the '<em><b>Dynamic Receiving Sequence</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEND_MEDIATOR__DYNAMIC_RECEIVING_SEQUENCE = eINSTANCE.getSendMediator_DynamicReceivingSequence();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.LogMediatorImpl <em>Log Mediator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.LogMediatorImpl
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getLogMediator()
		 * @generated
		 */
		EClass LOG_MEDIATOR = eINSTANCE.getLogMediator();

		/**
		 * The meta object literal for the '<em><b>Log Category</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOG_MEDIATOR__LOG_CATEGORY = eINSTANCE.getLogMediator_LogCategory();

		/**
		 * The meta object literal for the '<em><b>Log Level</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOG_MEDIATOR__LOG_LEVEL = eINSTANCE.getLogMediator_LogLevel();

		/**
		 * The meta object literal for the '<em><b>Log Separator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOG_MEDIATOR__LOG_SEPARATOR = eINSTANCE.getLogMediator_LogSeparator();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOG_MEDIATOR__PROPERTIES = eINSTANCE.getLogMediator_Properties();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.LogPropertyImpl <em>Log Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.LogPropertyImpl
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getLogProperty()
		 * @generated
		 */
		EClass LOG_PROPERTY = eINSTANCE.getLogProperty();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.FilterMediatorImpl <em>Filter Mediator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.FilterMediatorImpl
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getFilterMediator()
		 * @generated
		 */
		EClass FILTER_MEDIATOR = eINSTANCE.getFilterMediator();

		/**
		 * The meta object literal for the '<em><b>Condition Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILTER_MEDIATOR__CONDITION_TYPE = eINSTANCE.getFilterMediator_ConditionType();

		/**
		 * The meta object literal for the '<em><b>Filter Xpath</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FILTER_MEDIATOR__FILTER_XPATH = eINSTANCE.getFilterMediator_FilterXpath();

		/**
		 * The meta object literal for the '<em><b>Filter Source</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FILTER_MEDIATOR__FILTER_SOURCE = eINSTANCE.getFilterMediator_FilterSource();

		/**
		 * The meta object literal for the '<em><b>Filter Regex</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILTER_MEDIATOR__FILTER_REGEX = eINSTANCE.getFilterMediator_FilterRegex();

		/**
		 * The meta object literal for the '<em><b>Then Branch</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FILTER_MEDIATOR__THEN_BRANCH = eINSTANCE.getFilterMediator_ThenBranch();

		/**
		 * The meta object literal for the '<em><b>Else Branch</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FILTER_MEDIATOR__ELSE_BRANCH = eINSTANCE.getFilterMediator_ElseBranch();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.FilterThenBranchImpl <em>Filter Then Branch</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.FilterThenBranchImpl
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getFilterThenBranch()
		 * @generated
		 */
		EClass FILTER_THEN_BRANCH = eINSTANCE.getFilterThenBranch();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.FilterElseBranchImpl <em>Filter Else Branch</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.FilterElseBranchImpl
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getFilterElseBranch()
		 * @generated
		 */
		EClass FILTER_ELSE_BRANCH = eINSTANCE.getFilterElseBranch();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.SwitchMediatorImpl <em>Switch Mediator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.SwitchMediatorImpl
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getSwitchMediator()
		 * @generated
		 */
		EClass SWITCH_MEDIATOR = eINSTANCE.getSwitchMediator();

		/**
		 * The meta object literal for the '<em><b>Source Xpath</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SWITCH_MEDIATOR__SOURCE_XPATH = eINSTANCE.getSwitchMediator_SourceXpath();

		/**
		 * The meta object literal for the '<em><b>Case Branches</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SWITCH_MEDIATOR__CASE_BRANCHES = eINSTANCE.getSwitchMediator_CaseBranches();

		/**
		 * The meta object literal for the '<em><b>Default Branch</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SWITCH_MEDIATOR__DEFAULT_BRANCH = eINSTANCE.getSwitchMediator_DefaultBranch();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.SwitchCaseBranchImpl <em>Switch Case Branch</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.SwitchCaseBranchImpl
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getSwitchCaseBranch()
		 * @generated
		 */
		EClass SWITCH_CASE_BRANCH = eINSTANCE.getSwitchCaseBranch();

		/**
		 * The meta object literal for the '<em><b>Case Regex</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SWITCH_CASE_BRANCH__CASE_REGEX = eINSTANCE.getSwitchCaseBranch_CaseRegex();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.SwitchDefaultBranchImpl <em>Switch Default Branch</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.SwitchDefaultBranchImpl
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getSwitchDefaultBranch()
		 * @generated
		 */
		EClass SWITCH_DEFAULT_BRANCH = eINSTANCE.getSwitchDefaultBranch();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.EntitlementMediatorImpl <em>Entitlement Mediator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.EntitlementMediatorImpl
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getEntitlementMediator()
		 * @generated
		 */
		EClass ENTITLEMENT_MEDIATOR = eINSTANCE.getEntitlementMediator();

		/**
		 * The meta object literal for the '<em><b>Server URL</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENTITLEMENT_MEDIATOR__SERVER_URL = eINSTANCE.getEntitlementMediator_ServerURL();

		/**
		 * The meta object literal for the '<em><b>Username</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENTITLEMENT_MEDIATOR__USERNAME = eINSTANCE.getEntitlementMediator_Username();

		/**
		 * The meta object literal for the '<em><b>Password</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENTITLEMENT_MEDIATOR__PASSWORD = eINSTANCE.getEntitlementMediator_Password();

		/**
		 * The meta object literal for the '<em><b>On Accept</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTITLEMENT_MEDIATOR__ON_ACCEPT = eINSTANCE.getEntitlementMediator_OnAccept();

		/**
		 * The meta object literal for the '<em><b>On Reject</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTITLEMENT_MEDIATOR__ON_REJECT = eINSTANCE.getEntitlementMediator_OnReject();

		/**
		 * The meta object literal for the '<em><b>Obligations</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTITLEMENT_MEDIATOR__OBLIGATIONS = eINSTANCE.getEntitlementMediator_Obligations();

		/**
		 * The meta object literal for the '<em><b>Advice</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTITLEMENT_MEDIATOR__ADVICE = eINSTANCE.getEntitlementMediator_Advice();

		/**
		 * The meta object literal for the '<em><b>Callback Class</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENTITLEMENT_MEDIATOR__CALLBACK_CLASS = eINSTANCE.getEntitlementMediator_CallbackClass();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.EntitlementAdviceBranchImpl <em>Entitlement Advice Branch</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.EntitlementAdviceBranchImpl
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getEntitlementAdviceBranch()
		 * @generated
		 */
		EClass ENTITLEMENT_ADVICE_BRANCH = eINSTANCE.getEntitlementAdviceBranch();

		/**
		 * The meta object literal for the '<em><b>Sequence Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENTITLEMENT_ADVICE_BRANCH__SEQUENCE_TYPE = eINSTANCE.getEntitlementAdviceBranch_SequenceType();

		/**
		 * The meta object literal for the '<em><b>Sequence Key</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTITLEMENT_ADVICE_BRANCH__SEQUENCE_KEY = eINSTANCE.getEntitlementAdviceBranch_SequenceKey();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.EntitlementObligationsBranchImpl <em>Entitlement Obligations Branch</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.EntitlementObligationsBranchImpl
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getEntitlementObligationsBranch()
		 * @generated
		 */
		EClass ENTITLEMENT_OBLIGATIONS_BRANCH = eINSTANCE.getEntitlementObligationsBranch();

		/**
		 * The meta object literal for the '<em><b>Sequence Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENTITLEMENT_OBLIGATIONS_BRANCH__SEQUENCE_TYPE = eINSTANCE.getEntitlementObligationsBranch_SequenceType();

		/**
		 * The meta object literal for the '<em><b>Sequence Key</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTITLEMENT_OBLIGATIONS_BRANCH__SEQUENCE_KEY = eINSTANCE.getEntitlementObligationsBranch_SequenceKey();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.EntitlementMediatorOnRejectBranchImpl <em>Entitlement Mediator On Reject Branch</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.EntitlementMediatorOnRejectBranchImpl
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getEntitlementMediatorOnRejectBranch()
		 * @generated
		 */
		EClass ENTITLEMENT_MEDIATOR_ON_REJECT_BRANCH = eINSTANCE.getEntitlementMediatorOnRejectBranch();

		/**
		 * The meta object literal for the '<em><b>Sequence Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENTITLEMENT_MEDIATOR_ON_REJECT_BRANCH__SEQUENCE_TYPE = eINSTANCE.getEntitlementMediatorOnRejectBranch_SequenceType();

		/**
		 * The meta object literal for the '<em><b>Sequence Key</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTITLEMENT_MEDIATOR_ON_REJECT_BRANCH__SEQUENCE_KEY = eINSTANCE.getEntitlementMediatorOnRejectBranch_SequenceKey();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.EntitlementMediatorOnAcceptBranchImpl <em>Entitlement Mediator On Accept Branch</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.EntitlementMediatorOnAcceptBranchImpl
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getEntitlementMediatorOnAcceptBranch()
		 * @generated
		 */
		EClass ENTITLEMENT_MEDIATOR_ON_ACCEPT_BRANCH = eINSTANCE.getEntitlementMediatorOnAcceptBranch();

		/**
		 * The meta object literal for the '<em><b>Sequence Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENTITLEMENT_MEDIATOR_ON_ACCEPT_BRANCH__SEQUENCE_TYPE = eINSTANCE.getEntitlementMediatorOnAcceptBranch_SequenceType();

		/**
		 * The meta object literal for the '<em><b>Sequence Key</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTITLEMENT_MEDIATOR_ON_ACCEPT_BRANCH__SEQUENCE_KEY = eINSTANCE.getEntitlementMediatorOnAcceptBranch_SequenceKey();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.EnqueueMediatorImpl <em>Enqueue Mediator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.EnqueueMediatorImpl
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getEnqueueMediator()
		 * @generated
		 */
		EClass ENQUEUE_MEDIATOR = eINSTANCE.getEnqueueMediator();

		/**
		 * The meta object literal for the '<em><b>Executor</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENQUEUE_MEDIATOR__EXECUTOR = eINSTANCE.getEnqueueMediator_Executor();

		/**
		 * The meta object literal for the '<em><b>Priority</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENQUEUE_MEDIATOR__PRIORITY = eINSTANCE.getEnqueueMediator_Priority();

		/**
		 * The meta object literal for the '<em><b>Sequence Key</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENQUEUE_MEDIATOR__SEQUENCE_KEY = eINSTANCE.getEnqueueMediator_SequenceKey();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.ClassMediatorImpl <em>Class Mediator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.ClassMediatorImpl
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getClassMediator()
		 * @generated
		 */
		EClass CLASS_MEDIATOR = eINSTANCE.getClassMediator();

		/**
		 * The meta object literal for the '<em><b>Class Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASS_MEDIATOR__CLASS_NAME = eINSTANCE.getClassMediator_ClassName();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_MEDIATOR__PROPERTIES = eINSTANCE.getClassMediator_Properties();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.ClassPropertyImpl <em>Class Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.ClassPropertyImpl
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getClassProperty()
		 * @generated
		 */
		EClass CLASS_PROPERTY = eINSTANCE.getClassProperty();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.SpringMediatorImpl <em>Spring Mediator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.SpringMediatorImpl
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getSpringMediator()
		 * @generated
		 */
		EClass SPRING_MEDIATOR = eINSTANCE.getSpringMediator();

		/**
		 * The meta object literal for the '<em><b>Bean Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SPRING_MEDIATOR__BEAN_NAME = eINSTANCE.getSpringMediator_BeanName();

		/**
		 * The meta object literal for the '<em><b>Configuration Key</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPRING_MEDIATOR__CONFIGURATION_KEY = eINSTANCE.getSpringMediator_ConfigurationKey();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.ValidateMediatorImpl <em>Validate Mediator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.ValidateMediatorImpl
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getValidateMediator()
		 * @generated
		 */
		EClass VALIDATE_MEDIATOR = eINSTANCE.getValidateMediator();

		/**
		 * The meta object literal for the '<em><b>Source Xpath</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VALIDATE_MEDIATOR__SOURCE_XPATH = eINSTANCE.getValidateMediator_SourceXpath();

		/**
		 * The meta object literal for the '<em><b>On Fail Branch</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VALIDATE_MEDIATOR__ON_FAIL_BRANCH = eINSTANCE.getValidateMediator_OnFailBranch();

		/**
		 * The meta object literal for the '<em><b>Features</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VALIDATE_MEDIATOR__FEATURES = eINSTANCE.getValidateMediator_Features();

		/**
		 * The meta object literal for the '<em><b>Schemas</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VALIDATE_MEDIATOR__SCHEMAS = eINSTANCE.getValidateMediator_Schemas();

		/**
		 * The meta object literal for the '<em><b>Resources</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VALIDATE_MEDIATOR__RESOURCES = eINSTANCE.getValidateMediator_Resources();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.ValidateOnFailBranchImpl <em>Validate On Fail Branch</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.ValidateOnFailBranchImpl
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getValidateOnFailBranch()
		 * @generated
		 */
		EClass VALIDATE_ON_FAIL_BRANCH = eINSTANCE.getValidateOnFailBranch();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.ValidateFeatureImpl <em>Validate Feature</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.ValidateFeatureImpl
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getValidateFeature()
		 * @generated
		 */
		EClass VALIDATE_FEATURE = eINSTANCE.getValidateFeature();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.ValidateSchemaImpl <em>Validate Schema</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.ValidateSchemaImpl
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getValidateSchema()
		 * @generated
		 */
		EClass VALIDATE_SCHEMA = eINSTANCE.getValidateSchema();

		/**
		 * The meta object literal for the '<em><b>Validate Static Schema Key</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VALIDATE_SCHEMA__VALIDATE_STATIC_SCHEMA_KEY = eINSTANCE.getValidateSchema_ValidateStaticSchemaKey();

		/**
		 * The meta object literal for the '<em><b>Validate Dynamic Schema Key</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VALIDATE_SCHEMA__VALIDATE_DYNAMIC_SCHEMA_KEY = eINSTANCE.getValidateSchema_ValidateDynamicSchemaKey();

		/**
		 * The meta object literal for the '<em><b>Validate Schema Key Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VALIDATE_SCHEMA__VALIDATE_SCHEMA_KEY_TYPE = eINSTANCE.getValidateSchema_ValidateSchemaKeyType();

		/**
		 * The meta object literal for the '<em><b>Schema Key</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VALIDATE_SCHEMA__SCHEMA_KEY = eINSTANCE.getValidateSchema_SchemaKey();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.ValidateResourceImpl <em>Validate Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.ValidateResourceImpl
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getValidateResource()
		 * @generated
		 */
		EClass VALIDATE_RESOURCE = eINSTANCE.getValidateResource();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.ScriptMediatorImpl <em>Script Mediator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.ScriptMediatorImpl
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getScriptMediator()
		 * @generated
		 */
		EClass SCRIPT_MEDIATOR = eINSTANCE.getScriptMediator();

		/**
		 * The meta object literal for the '<em><b>Script Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCRIPT_MEDIATOR__SCRIPT_TYPE = eINSTANCE.getScriptMediator_ScriptType();

		/**
		 * The meta object literal for the '<em><b>Script Language</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCRIPT_MEDIATOR__SCRIPT_LANGUAGE = eINSTANCE.getScriptMediator_ScriptLanguage();

		/**
		 * The meta object literal for the '<em><b>Mediate Function</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCRIPT_MEDIATOR__MEDIATE_FUNCTION = eINSTANCE.getScriptMediator_MediateFunction();

		/**
		 * The meta object literal for the '<em><b>Script Key</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCRIPT_MEDIATOR__SCRIPT_KEY = eINSTANCE.getScriptMediator_ScriptKey();

		/**
		 * The meta object literal for the '<em><b>Script Body</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCRIPT_MEDIATOR__SCRIPT_BODY = eINSTANCE.getScriptMediator_ScriptBody();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.EnrichMediatorImpl <em>Enrich Mediator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.EnrichMediatorImpl
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getEnrichMediator()
		 * @generated
		 */
		EClass ENRICH_MEDIATOR = eINSTANCE.getEnrichMediator();

		/**
		 * The meta object literal for the '<em><b>Clone Source</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENRICH_MEDIATOR__CLONE_SOURCE = eINSTANCE.getEnrichMediator_CloneSource();

		/**
		 * The meta object literal for the '<em><b>Source Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENRICH_MEDIATOR__SOURCE_TYPE = eINSTANCE.getEnrichMediator_SourceType();

		/**
		 * The meta object literal for the '<em><b>Source Xpath</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENRICH_MEDIATOR__SOURCE_XPATH = eINSTANCE.getEnrichMediator_SourceXpath();

		/**
		 * The meta object literal for the '<em><b>Source Property</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENRICH_MEDIATOR__SOURCE_PROPERTY = eINSTANCE.getEnrichMediator_SourceProperty();

		/**
		 * The meta object literal for the '<em><b>Source XML</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENRICH_MEDIATOR__SOURCE_XML = eINSTANCE.getEnrichMediator_SourceXML();

		/**
		 * The meta object literal for the '<em><b>Target Action</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENRICH_MEDIATOR__TARGET_ACTION = eINSTANCE.getEnrichMediator_TargetAction();

		/**
		 * The meta object literal for the '<em><b>Target Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENRICH_MEDIATOR__TARGET_TYPE = eINSTANCE.getEnrichMediator_TargetType();

		/**
		 * The meta object literal for the '<em><b>Target Xpath</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENRICH_MEDIATOR__TARGET_XPATH = eINSTANCE.getEnrichMediator_TargetXpath();

		/**
		 * The meta object literal for the '<em><b>Target Property</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENRICH_MEDIATOR__TARGET_PROPERTY = eINSTANCE.getEnrichMediator_TargetProperty();

		/**
		 * The meta object literal for the '<em><b>Inline Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENRICH_MEDIATOR__INLINE_TYPE = eINSTANCE.getEnrichMediator_InlineType();

		/**
		 * The meta object literal for the '<em><b>Inline Registry Key</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENRICH_MEDIATOR__INLINE_REGISTRY_KEY = eINSTANCE.getEnrichMediator_InlineRegistryKey();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.FaultMediatorImpl <em>Fault Mediator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.FaultMediatorImpl
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getFaultMediator()
		 * @generated
		 */
		EClass FAULT_MEDIATOR = eINSTANCE.getFaultMediator();

		/**
		 * The meta object literal for the '<em><b>Soap Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FAULT_MEDIATOR__SOAP_VERSION = eINSTANCE.getFaultMediator_SoapVersion();

		/**
		 * The meta object literal for the '<em><b>Fault Code Soap11</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FAULT_MEDIATOR__FAULT_CODE_SOAP11 = eINSTANCE.getFaultMediator_FaultCodeSoap11();

		/**
		 * The meta object literal for the '<em><b>Fault String Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FAULT_MEDIATOR__FAULT_STRING_TYPE = eINSTANCE.getFaultMediator_FaultStringType();

		/**
		 * The meta object literal for the '<em><b>Fault String Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FAULT_MEDIATOR__FAULT_STRING_VALUE = eINSTANCE.getFaultMediator_FaultStringValue();

		/**
		 * The meta object literal for the '<em><b>Fault String Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FAULT_MEDIATOR__FAULT_STRING_EXPRESSION = eINSTANCE.getFaultMediator_FaultStringExpression();

		/**
		 * The meta object literal for the '<em><b>Fault Actor</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FAULT_MEDIATOR__FAULT_ACTOR = eINSTANCE.getFaultMediator_FaultActor();

		/**
		 * The meta object literal for the '<em><b>Fault Code Soap12</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FAULT_MEDIATOR__FAULT_CODE_SOAP12 = eINSTANCE.getFaultMediator_FaultCodeSoap12();

		/**
		 * The meta object literal for the '<em><b>Fault Reason Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FAULT_MEDIATOR__FAULT_REASON_TYPE = eINSTANCE.getFaultMediator_FaultReasonType();

		/**
		 * The meta object literal for the '<em><b>Fault Reason Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FAULT_MEDIATOR__FAULT_REASON_VALUE = eINSTANCE.getFaultMediator_FaultReasonValue();

		/**
		 * The meta object literal for the '<em><b>Fault Reason Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FAULT_MEDIATOR__FAULT_REASON_EXPRESSION = eINSTANCE.getFaultMediator_FaultReasonExpression();

		/**
		 * The meta object literal for the '<em><b>Role Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FAULT_MEDIATOR__ROLE_NAME = eINSTANCE.getFaultMediator_RoleName();

		/**
		 * The meta object literal for the '<em><b>Node Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FAULT_MEDIATOR__NODE_NAME = eINSTANCE.getFaultMediator_NodeName();

		/**
		 * The meta object literal for the '<em><b>Fault Detail Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FAULT_MEDIATOR__FAULT_DETAIL_TYPE = eINSTANCE.getFaultMediator_FaultDetailType();

		/**
		 * The meta object literal for the '<em><b>Fault Detail Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FAULT_MEDIATOR__FAULT_DETAIL_VALUE = eINSTANCE.getFaultMediator_FaultDetailValue();

		/**
		 * The meta object literal for the '<em><b>Fault Detail Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FAULT_MEDIATOR__FAULT_DETAIL_EXPRESSION = eINSTANCE.getFaultMediator_FaultDetailExpression();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.AggregateMediatorImpl <em>Aggregate Mediator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.AggregateMediatorImpl
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getAggregateMediator()
		 * @generated
		 */
		EClass AGGREGATE_MEDIATOR = eINSTANCE.getAggregateMediator();

		/**
		 * The meta object literal for the '<em><b>Correlation Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AGGREGATE_MEDIATOR__CORRELATION_EXPRESSION = eINSTANCE.getAggregateMediator_CorrelationExpression();

		/**
		 * The meta object literal for the '<em><b>Completion Timeout</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AGGREGATE_MEDIATOR__COMPLETION_TIMEOUT = eINSTANCE.getAggregateMediator_CompletionTimeout();

		/**
		 * The meta object literal for the '<em><b>Completion Min Messages</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AGGREGATE_MEDIATOR__COMPLETION_MIN_MESSAGES = eINSTANCE.getAggregateMediator_CompletionMinMessages();

		/**
		 * The meta object literal for the '<em><b>Completion Max Messages</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AGGREGATE_MEDIATOR__COMPLETION_MAX_MESSAGES = eINSTANCE.getAggregateMediator_CompletionMaxMessages();

		/**
		 * The meta object literal for the '<em><b>On Complete Branch</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AGGREGATE_MEDIATOR__ON_COMPLETE_BRANCH = eINSTANCE.getAggregateMediator_OnCompleteBranch();

		/**
		 * The meta object literal for the '<em><b>Aggregate ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AGGREGATE_MEDIATOR__AGGREGATE_ID = eINSTANCE.getAggregateMediator_AggregateID();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.AggregateOnCompleteBranchImpl <em>Aggregate On Complete Branch</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.AggregateOnCompleteBranchImpl
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getAggregateOnCompleteBranch()
		 * @generated
		 */
		EClass AGGREGATE_ON_COMPLETE_BRANCH = eINSTANCE.getAggregateOnCompleteBranch();

		/**
		 * The meta object literal for the '<em><b>Aggregation Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AGGREGATE_ON_COMPLETE_BRANCH__AGGREGATION_EXPRESSION = eINSTANCE.getAggregateOnCompleteBranch_AggregationExpression();

		/**
		 * The meta object literal for the '<em><b>Sequence Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AGGREGATE_ON_COMPLETE_BRANCH__SEQUENCE_TYPE = eINSTANCE.getAggregateOnCompleteBranch_SequenceType();

		/**
		 * The meta object literal for the '<em><b>Sequence Key</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AGGREGATE_ON_COMPLETE_BRANCH__SEQUENCE_KEY = eINSTANCE.getAggregateOnCompleteBranch_SequenceKey();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.RouterMediatorImpl <em>Router Mediator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.RouterMediatorImpl
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getRouterMediator()
		 * @generated
		 */
		EClass ROUTER_MEDIATOR = eINSTANCE.getRouterMediator();

		/**
		 * The meta object literal for the '<em><b>Continue After Routing</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROUTER_MEDIATOR__CONTINUE_AFTER_ROUTING = eINSTANCE.getRouterMediator_ContinueAfterRouting();

		/**
		 * The meta object literal for the '<em><b>Routes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROUTER_MEDIATOR__ROUTES = eINSTANCE.getRouterMediator_Routes();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.RouterRouteImpl <em>Router Route</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.RouterRouteImpl
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getRouterRoute()
		 * @generated
		 */
		EClass ROUTER_ROUTE = eINSTANCE.getRouterRoute();

		/**
		 * The meta object literal for the '<em><b>Break After Route</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROUTER_ROUTE__BREAK_AFTER_ROUTE = eINSTANCE.getRouterRoute_BreakAfterRoute();

		/**
		 * The meta object literal for the '<em><b>Route Expression</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROUTER_ROUTE__ROUTE_EXPRESSION = eINSTANCE.getRouterRoute_RouteExpression();

		/**
		 * The meta object literal for the '<em><b>Route Pattern</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROUTER_ROUTE__ROUTE_PATTERN = eINSTANCE.getRouterRoute_RoutePattern();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROUTER_ROUTE__TARGET = eINSTANCE.getRouterRoute_Target();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.RouteTargetImpl <em>Route Target</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.RouteTargetImpl
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getRouteTarget()
		 * @generated
		 */
		EClass ROUTE_TARGET = eINSTANCE.getRouteTarget();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.CloneMediatorImpl <em>Clone Mediator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.CloneMediatorImpl
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getCloneMediator()
		 * @generated
		 */
		EClass CLONE_MEDIATOR = eINSTANCE.getCloneMediator();

		/**
		 * The meta object literal for the '<em><b>Clone ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLONE_MEDIATOR__CLONE_ID = eINSTANCE.getCloneMediator_CloneID();

		/**
		 * The meta object literal for the '<em><b>Sequential Mediation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLONE_MEDIATOR__SEQUENTIAL_MEDIATION = eINSTANCE.getCloneMediator_SequentialMediation();

		/**
		 * The meta object literal for the '<em><b>Continue Parent</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLONE_MEDIATOR__CONTINUE_PARENT = eINSTANCE.getCloneMediator_ContinueParent();

		/**
		 * The meta object literal for the '<em><b>Targets</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLONE_MEDIATOR__TARGETS = eINSTANCE.getCloneMediator_Targets();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.CloneTargetImpl <em>Clone Target</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.CloneTargetImpl
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getCloneTarget()
		 * @generated
		 */
		EClass CLONE_TARGET = eINSTANCE.getCloneTarget();

		/**
		 * The meta object literal for the '<em><b>Soap Action</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLONE_TARGET__SOAP_ACTION = eINSTANCE.getCloneTarget_SoapAction();

		/**
		 * The meta object literal for the '<em><b>To Address</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLONE_TARGET__TO_ADDRESS = eINSTANCE.getCloneTarget_ToAddress();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.IterateMediatorImpl <em>Iterate Mediator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.IterateMediatorImpl
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getIterateMediator()
		 * @generated
		 */
		EClass ITERATE_MEDIATOR = eINSTANCE.getIterateMediator();

		/**
		 * The meta object literal for the '<em><b>Iterate ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ITERATE_MEDIATOR__ITERATE_ID = eINSTANCE.getIterateMediator_IterateID();

		/**
		 * The meta object literal for the '<em><b>Sequential Mediation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ITERATE_MEDIATOR__SEQUENTIAL_MEDIATION = eINSTANCE.getIterateMediator_SequentialMediation();

		/**
		 * The meta object literal for the '<em><b>Continue Parent</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ITERATE_MEDIATOR__CONTINUE_PARENT = eINSTANCE.getIterateMediator_ContinueParent();

		/**
		 * The meta object literal for the '<em><b>Preserve Payload</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ITERATE_MEDIATOR__PRESERVE_PAYLOAD = eINSTANCE.getIterateMediator_PreservePayload();

		/**
		 * The meta object literal for the '<em><b>Iterate Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ITERATE_MEDIATOR__ITERATE_EXPRESSION = eINSTANCE.getIterateMediator_IterateExpression();

		/**
		 * The meta object literal for the '<em><b>Attach Path</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ITERATE_MEDIATOR__ATTACH_PATH = eINSTANCE.getIterateMediator_AttachPath();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ITERATE_MEDIATOR__TARGET = eINSTANCE.getIterateMediator_Target();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.IterateTargetImpl <em>Iterate Target</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.IterateTargetImpl
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getIterateTarget()
		 * @generated
		 */
		EClass ITERATE_TARGET = eINSTANCE.getIterateTarget();

		/**
		 * The meta object literal for the '<em><b>Soap Action</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ITERATE_TARGET__SOAP_ACTION = eINSTANCE.getIterateTarget_SoapAction();

		/**
		 * The meta object literal for the '<em><b>To Address</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ITERATE_TARGET__TO_ADDRESS = eINSTANCE.getIterateTarget_ToAddress();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.CacheMediatorImpl <em>Cache Mediator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.CacheMediatorImpl
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getCacheMediator()
		 * @generated
		 */
		EClass CACHE_MEDIATOR = eINSTANCE.getCacheMediator();

		/**
		 * The meta object literal for the '<em><b>Cache Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CACHE_MEDIATOR__CACHE_ID = eINSTANCE.getCacheMediator_CacheId();

		/**
		 * The meta object literal for the '<em><b>Cache Scope</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CACHE_MEDIATOR__CACHE_SCOPE = eINSTANCE.getCacheMediator_CacheScope();

		/**
		 * The meta object literal for the '<em><b>Cache Action</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CACHE_MEDIATOR__CACHE_ACTION = eINSTANCE.getCacheMediator_CacheAction();

		/**
		 * The meta object literal for the '<em><b>Hash Generator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CACHE_MEDIATOR__HASH_GENERATOR = eINSTANCE.getCacheMediator_HashGenerator();

		/**
		 * The meta object literal for the '<em><b>Cache Timeout</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CACHE_MEDIATOR__CACHE_TIMEOUT = eINSTANCE.getCacheMediator_CacheTimeout();

		/**
		 * The meta object literal for the '<em><b>Max Message Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CACHE_MEDIATOR__MAX_MESSAGE_SIZE = eINSTANCE.getCacheMediator_MaxMessageSize();

		/**
		 * The meta object literal for the '<em><b>Implementation Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CACHE_MEDIATOR__IMPLEMENTATION_TYPE = eINSTANCE.getCacheMediator_ImplementationType();

		/**
		 * The meta object literal for the '<em><b>Max Entry Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CACHE_MEDIATOR__MAX_ENTRY_COUNT = eINSTANCE.getCacheMediator_MaxEntryCount();

		/**
		 * The meta object literal for the '<em><b>On Hit Branch</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CACHE_MEDIATOR__ON_HIT_BRANCH = eINSTANCE.getCacheMediator_OnHitBranch();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.CacheOnHitBranchImpl <em>Cache On Hit Branch</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.CacheOnHitBranchImpl
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getCacheOnHitBranch()
		 * @generated
		 */
		EClass CACHE_ON_HIT_BRANCH = eINSTANCE.getCacheOnHitBranch();

		/**
		 * The meta object literal for the '<em><b>Sequence Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CACHE_ON_HIT_BRANCH__SEQUENCE_TYPE = eINSTANCE.getCacheOnHitBranch_SequenceType();

		/**
		 * The meta object literal for the '<em><b>Sequence Key</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CACHE_ON_HIT_BRANCH__SEQUENCE_KEY = eINSTANCE.getCacheOnHitBranch_SequenceKey();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.XSLTMediatorImpl <em>XSLT Mediator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.XSLTMediatorImpl
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getXSLTMediator()
		 * @generated
		 */
		EClass XSLT_MEDIATOR = eINSTANCE.getXSLTMediator();

		/**
		 * The meta object literal for the '<em><b>Source XPath</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XSLT_MEDIATOR__SOURCE_XPATH = eINSTANCE.getXSLTMediator_SourceXPath();

		/**
		 * The meta object literal for the '<em><b>Xslt Key</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XSLT_MEDIATOR__XSLT_KEY = eINSTANCE.getXSLTMediator_XsltKey();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XSLT_MEDIATOR__PROPERTIES = eINSTANCE.getXSLTMediator_Properties();

		/**
		 * The meta object literal for the '<em><b>Features</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XSLT_MEDIATOR__FEATURES = eINSTANCE.getXSLTMediator_Features();

		/**
		 * The meta object literal for the '<em><b>Resources</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XSLT_MEDIATOR__RESOURCES = eINSTANCE.getXSLTMediator_Resources();

		/**
		 * The meta object literal for the '<em><b>Xslt Schema Key Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XSLT_MEDIATOR__XSLT_SCHEMA_KEY_TYPE = eINSTANCE.getXSLTMediator_XsltSchemaKeyType();

		/**
		 * The meta object literal for the '<em><b>Xslt Static Schema Key</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XSLT_MEDIATOR__XSLT_STATIC_SCHEMA_KEY = eINSTANCE.getXSLTMediator_XsltStaticSchemaKey();

		/**
		 * The meta object literal for the '<em><b>Xslt Dynamic Schema Key</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XSLT_MEDIATOR__XSLT_DYNAMIC_SCHEMA_KEY = eINSTANCE.getXSLTMediator_XsltDynamicSchemaKey();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.XSLTPropertyImpl <em>XSLT Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.XSLTPropertyImpl
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getXSLTProperty()
		 * @generated
		 */
		EClass XSLT_PROPERTY = eINSTANCE.getXSLTProperty();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.XSLTFeatureImpl <em>XSLT Feature</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.XSLTFeatureImpl
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getXSLTFeature()
		 * @generated
		 */
		EClass XSLT_FEATURE = eINSTANCE.getXSLTFeature();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.XSLTResourceImpl <em>XSLT Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.XSLTResourceImpl
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getXSLTResource()
		 * @generated
		 */
		EClass XSLT_RESOURCE = eINSTANCE.getXSLTResource();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.XQueryMediatorImpl <em>XQuery Mediator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.XQueryMediatorImpl
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getXQueryMediator()
		 * @generated
		 */
		EClass XQUERY_MEDIATOR = eINSTANCE.getXQueryMediator();

		/**
		 * The meta object literal for the '<em><b>Target XPath</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XQUERY_MEDIATOR__TARGET_XPATH = eINSTANCE.getXQueryMediator_TargetXPath();

		/**
		 * The meta object literal for the '<em><b>Script Key Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XQUERY_MEDIATOR__SCRIPT_KEY_TYPE = eINSTANCE.getXQueryMediator_ScriptKeyType();

		/**
		 * The meta object literal for the '<em><b>Static Script Key</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XQUERY_MEDIATOR__STATIC_SCRIPT_KEY = eINSTANCE.getXQueryMediator_StaticScriptKey();

		/**
		 * The meta object literal for the '<em><b>Dynamic Script Key</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XQUERY_MEDIATOR__DYNAMIC_SCRIPT_KEY = eINSTANCE.getXQueryMediator_DynamicScriptKey();

		/**
		 * The meta object literal for the '<em><b>Query Key</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XQUERY_MEDIATOR__QUERY_KEY = eINSTANCE.getXQueryMediator_QueryKey();

		/**
		 * The meta object literal for the '<em><b>Variables</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XQUERY_MEDIATOR__VARIABLES = eINSTANCE.getXQueryMediator_Variables();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.XQueryVariableImpl <em>XQuery Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.XQueryVariableImpl
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getXQueryVariable()
		 * @generated
		 */
		EClass XQUERY_VARIABLE = eINSTANCE.getXQueryVariable();

		/**
		 * The meta object literal for the '<em><b>Variable Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XQUERY_VARIABLE__VARIABLE_NAME = eINSTANCE.getXQueryVariable_VariableName();

		/**
		 * The meta object literal for the '<em><b>Variable Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XQUERY_VARIABLE__VARIABLE_TYPE = eINSTANCE.getXQueryVariable_VariableType();

		/**
		 * The meta object literal for the '<em><b>Value Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XQUERY_VARIABLE__VALUE_TYPE = eINSTANCE.getXQueryVariable_ValueType();

		/**
		 * The meta object literal for the '<em><b>Value Literal</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XQUERY_VARIABLE__VALUE_LITERAL = eINSTANCE.getXQueryVariable_ValueLiteral();

		/**
		 * The meta object literal for the '<em><b>Value Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XQUERY_VARIABLE__VALUE_EXPRESSION = eINSTANCE.getXQueryVariable_ValueExpression();

		/**
		 * The meta object literal for the '<em><b>Value Key</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XQUERY_VARIABLE__VALUE_KEY = eINSTANCE.getXQueryVariable_ValueKey();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.CalloutMediatorImpl <em>Callout Mediator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.CalloutMediatorImpl
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getCalloutMediator()
		 * @generated
		 */
		EClass CALLOUT_MEDIATOR = eINSTANCE.getCalloutMediator();

		/**
		 * The meta object literal for the '<em><b>Service URL</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CALLOUT_MEDIATOR__SERVICE_URL = eINSTANCE.getCalloutMediator_ServiceURL();

		/**
		 * The meta object literal for the '<em><b>Soap Action</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CALLOUT_MEDIATOR__SOAP_ACTION = eINSTANCE.getCalloutMediator_SoapAction();

		/**
		 * The meta object literal for the '<em><b>Path To Axis2xml</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CALLOUT_MEDIATOR__PATH_TO_AXIS2XML = eINSTANCE.getCalloutMediator_PathToAxis2xml();

		/**
		 * The meta object literal for the '<em><b>Path To Axis2 Repository</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CALLOUT_MEDIATOR__PATH_TO_AXIS2_REPOSITORY = eINSTANCE.getCalloutMediator_PathToAxis2Repository();

		/**
		 * The meta object literal for the '<em><b>Payload Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CALLOUT_MEDIATOR__PAYLOAD_TYPE = eINSTANCE.getCalloutMediator_PayloadType();

		/**
		 * The meta object literal for the '<em><b>Payload Message Xpath</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CALLOUT_MEDIATOR__PAYLOAD_MESSAGE_XPATH = eINSTANCE.getCalloutMediator_PayloadMessageXpath();

		/**
		 * The meta object literal for the '<em><b>Payload Registry Key</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CALLOUT_MEDIATOR__PAYLOAD_REGISTRY_KEY = eINSTANCE.getCalloutMediator_PayloadRegistryKey();

		/**
		 * The meta object literal for the '<em><b>Result Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CALLOUT_MEDIATOR__RESULT_TYPE = eINSTANCE.getCalloutMediator_ResultType();

		/**
		 * The meta object literal for the '<em><b>Result Message Xpath</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CALLOUT_MEDIATOR__RESULT_MESSAGE_XPATH = eINSTANCE.getCalloutMediator_ResultMessageXpath();

		/**
		 * The meta object literal for the '<em><b>Result Context Property</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CALLOUT_MEDIATOR__RESULT_CONTEXT_PROPERTY = eINSTANCE.getCalloutMediator_ResultContextProperty();

		/**
		 * The meta object literal for the '<em><b>Pass Headers</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CALLOUT_MEDIATOR__PASS_HEADERS = eINSTANCE.getCalloutMediator_PassHeaders();

		/**
		 * The meta object literal for the '<em><b>Use Server Config</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CALLOUT_MEDIATOR__USE_SERVER_CONFIG = eINSTANCE.getCalloutMediator_UseServerConfig();

		/**
		 * The meta object literal for the '<em><b>Endpoint Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CALLOUT_MEDIATOR__ENDPOINT_TYPE = eINSTANCE.getCalloutMediator_EndpointType();

		/**
		 * The meta object literal for the '<em><b>Endpoint Key</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CALLOUT_MEDIATOR__ENDPOINT_KEY = eINSTANCE.getCalloutMediator_EndpointKey();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.RMSequenceMediatorImpl <em>RM Sequence Mediator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.RMSequenceMediatorImpl
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getRMSequenceMediator()
		 * @generated
		 */
		EClass RM_SEQUENCE_MEDIATOR = eINSTANCE.getRMSequenceMediator();

		/**
		 * The meta object literal for the '<em><b>Rm Spec Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RM_SEQUENCE_MEDIATOR__RM_SPEC_VERSION = eINSTANCE.getRMSequenceMediator_RmSpecVersion();

		/**
		 * The meta object literal for the '<em><b>Sequence Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RM_SEQUENCE_MEDIATOR__SEQUENCE_TYPE = eINSTANCE.getRMSequenceMediator_SequenceType();

		/**
		 * The meta object literal for the '<em><b>Correlation Xpath</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RM_SEQUENCE_MEDIATOR__CORRELATION_XPATH = eINSTANCE.getRMSequenceMediator_CorrelationXpath();

		/**
		 * The meta object literal for the '<em><b>Last Message Xpath</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RM_SEQUENCE_MEDIATOR__LAST_MESSAGE_XPATH = eINSTANCE.getRMSequenceMediator_LastMessageXpath();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.TransactionMediatorImpl <em>Transaction Mediator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.TransactionMediatorImpl
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getTransactionMediator()
		 * @generated
		 */
		EClass TRANSACTION_MEDIATOR = eINSTANCE.getTransactionMediator();

		/**
		 * The meta object literal for the '<em><b>Action</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSACTION_MEDIATOR__ACTION = eINSTANCE.getTransactionMediator_Action();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.PropertyMediatorImpl <em>Property Mediator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.PropertyMediatorImpl
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getPropertyMediator()
		 * @generated
		 */
		EClass PROPERTY_MEDIATOR = eINSTANCE.getPropertyMediator();

		/**
		 * The meta object literal for the '<em><b>Property Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY_MEDIATOR__PROPERTY_NAME = eINSTANCE.getPropertyMediator_PropertyName();

		/**
		 * The meta object literal for the '<em><b>Property Data Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY_MEDIATOR__PROPERTY_DATA_TYPE = eINSTANCE.getPropertyMediator_PropertyDataType();

		/**
		 * The meta object literal for the '<em><b>Property Action</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY_MEDIATOR__PROPERTY_ACTION = eINSTANCE.getPropertyMediator_PropertyAction();

		/**
		 * The meta object literal for the '<em><b>Property Scope</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY_MEDIATOR__PROPERTY_SCOPE = eINSTANCE.getPropertyMediator_PropertyScope();

		/**
		 * The meta object literal for the '<em><b>Value Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY_MEDIATOR__VALUE_TYPE = eINSTANCE.getPropertyMediator_ValueType();

		/**
		 * The meta object literal for the '<em><b>Value Literal</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY_MEDIATOR__VALUE_LITERAL = eINSTANCE.getPropertyMediator_ValueLiteral();

		/**
		 * The meta object literal for the '<em><b>Value Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_MEDIATOR__VALUE_EXPRESSION = eINSTANCE.getPropertyMediator_ValueExpression();

		/**
		 * The meta object literal for the '<em><b>Value OM</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY_MEDIATOR__VALUE_OM = eINSTANCE.getPropertyMediator_ValueOM();

		/**
		 * The meta object literal for the '<em><b>Value String Pattern</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY_MEDIATOR__VALUE_STRING_PATTERN = eINSTANCE.getPropertyMediator_ValueStringPattern();

		/**
		 * The meta object literal for the '<em><b>Value String Capturing Group</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY_MEDIATOR__VALUE_STRING_CAPTURING_GROUP = eINSTANCE.getPropertyMediator_ValueStringCapturingGroup();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.OAuthMediatorImpl <em>OAuth Mediator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.OAuthMediatorImpl
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getOAuthMediator()
		 * @generated
		 */
		EClass OAUTH_MEDIATOR = eINSTANCE.getOAuthMediator();

		/**
		 * The meta object literal for the '<em><b>Remote Service Url</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OAUTH_MEDIATOR__REMOTE_SERVICE_URL = eINSTANCE.getOAuthMediator_RemoteServiceUrl();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.AutoscaleInMediatorImpl <em>Autoscale In Mediator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.AutoscaleInMediatorImpl
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getAutoscaleInMediator()
		 * @generated
		 */
		EClass AUTOSCALE_IN_MEDIATOR = eINSTANCE.getAutoscaleInMediator();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.AutoscaleOutMediatorImpl <em>Autoscale Out Mediator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.AutoscaleOutMediatorImpl
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getAutoscaleOutMediator()
		 * @generated
		 */
		EClass AUTOSCALE_OUT_MEDIATOR = eINSTANCE.getAutoscaleOutMediator();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.HeaderMediatorImpl <em>Header Mediator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.HeaderMediatorImpl
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getHeaderMediator()
		 * @generated
		 */
		EClass HEADER_MEDIATOR = eINSTANCE.getHeaderMediator();

		/**
		 * The meta object literal for the '<em><b>Header Name</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HEADER_MEDIATOR__HEADER_NAME = eINSTANCE.getHeaderMediator_HeaderName();

		/**
		 * The meta object literal for the '<em><b>Header Action</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HEADER_MEDIATOR__HEADER_ACTION = eINSTANCE.getHeaderMediator_HeaderAction();

		/**
		 * The meta object literal for the '<em><b>Value Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HEADER_MEDIATOR__VALUE_TYPE = eINSTANCE.getHeaderMediator_ValueType();

		/**
		 * The meta object literal for the '<em><b>Value Literal</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HEADER_MEDIATOR__VALUE_LITERAL = eINSTANCE.getHeaderMediator_ValueLiteral();

		/**
		 * The meta object literal for the '<em><b>Value Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HEADER_MEDIATOR__VALUE_EXPRESSION = eINSTANCE.getHeaderMediator_ValueExpression();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.ThrottleMediatorImpl <em>Throttle Mediator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.ThrottleMediatorImpl
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getThrottleMediator()
		 * @generated
		 */
		EClass THROTTLE_MEDIATOR = eINSTANCE.getThrottleMediator();

		/**
		 * The meta object literal for the '<em><b>Group Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute THROTTLE_MEDIATOR__GROUP_ID = eINSTANCE.getThrottleMediator_GroupId();

		/**
		 * The meta object literal for the '<em><b>Policy Configuration</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference THROTTLE_MEDIATOR__POLICY_CONFIGURATION = eINSTANCE.getThrottleMediator_PolicyConfiguration();

		/**
		 * The meta object literal for the '<em><b>On Accept Branch</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference THROTTLE_MEDIATOR__ON_ACCEPT_BRANCH = eINSTANCE.getThrottleMediator_OnAcceptBranch();

		/**
		 * The meta object literal for the '<em><b>On Reject Branch</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference THROTTLE_MEDIATOR__ON_REJECT_BRANCH = eINSTANCE.getThrottleMediator_OnRejectBranch();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.ThrottlePolicyConfigurationImpl <em>Throttle Policy Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.ThrottlePolicyConfigurationImpl
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getThrottlePolicyConfiguration()
		 * @generated
		 */
		EClass THROTTLE_POLICY_CONFIGURATION = eINSTANCE.getThrottlePolicyConfiguration();

		/**
		 * The meta object literal for the '<em><b>Policy Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute THROTTLE_POLICY_CONFIGURATION__POLICY_TYPE = eINSTANCE.getThrottlePolicyConfiguration_PolicyType();

		/**
		 * The meta object literal for the '<em><b>Policy Key</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference THROTTLE_POLICY_CONFIGURATION__POLICY_KEY = eINSTANCE.getThrottlePolicyConfiguration_PolicyKey();

		/**
		 * The meta object literal for the '<em><b>Max Concurrent Access Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute THROTTLE_POLICY_CONFIGURATION__MAX_CONCURRENT_ACCESS_COUNT = eINSTANCE.getThrottlePolicyConfiguration_MaxConcurrentAccessCount();

		/**
		 * The meta object literal for the '<em><b>Policy Entries</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference THROTTLE_POLICY_CONFIGURATION__POLICY_ENTRIES = eINSTANCE.getThrottlePolicyConfiguration_PolicyEntries();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.ThrottlePolicyEntryImpl <em>Throttle Policy Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.ThrottlePolicyEntryImpl
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getThrottlePolicyEntry()
		 * @generated
		 */
		EClass THROTTLE_POLICY_ENTRY = eINSTANCE.getThrottlePolicyEntry();

		/**
		 * The meta object literal for the '<em><b>Throttle Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute THROTTLE_POLICY_ENTRY__THROTTLE_TYPE = eINSTANCE.getThrottlePolicyEntry_ThrottleType();

		/**
		 * The meta object literal for the '<em><b>Throttle Range</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute THROTTLE_POLICY_ENTRY__THROTTLE_RANGE = eINSTANCE.getThrottlePolicyEntry_ThrottleRange();

		/**
		 * The meta object literal for the '<em><b>Access Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute THROTTLE_POLICY_ENTRY__ACCESS_TYPE = eINSTANCE.getThrottlePolicyEntry_AccessType();

		/**
		 * The meta object literal for the '<em><b>Max Request Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute THROTTLE_POLICY_ENTRY__MAX_REQUEST_COUNT = eINSTANCE.getThrottlePolicyEntry_MaxRequestCount();

		/**
		 * The meta object literal for the '<em><b>Unit Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute THROTTLE_POLICY_ENTRY__UNIT_TIME = eINSTANCE.getThrottlePolicyEntry_UnitTime();

		/**
		 * The meta object literal for the '<em><b>Prohibit Period</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute THROTTLE_POLICY_ENTRY__PROHIBIT_PERIOD = eINSTANCE.getThrottlePolicyEntry_ProhibitPeriod();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.ThrottleOnAcceptBranchImpl <em>Throttle On Accept Branch</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.ThrottleOnAcceptBranchImpl
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getThrottleOnAcceptBranch()
		 * @generated
		 */
		EClass THROTTLE_ON_ACCEPT_BRANCH = eINSTANCE.getThrottleOnAcceptBranch();

		/**
		 * The meta object literal for the '<em><b>Sequence Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute THROTTLE_ON_ACCEPT_BRANCH__SEQUENCE_TYPE = eINSTANCE.getThrottleOnAcceptBranch_SequenceType();

		/**
		 * The meta object literal for the '<em><b>Sequence Key</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference THROTTLE_ON_ACCEPT_BRANCH__SEQUENCE_KEY = eINSTANCE.getThrottleOnAcceptBranch_SequenceKey();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.ThrottleOnRejectBranchImpl <em>Throttle On Reject Branch</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.ThrottleOnRejectBranchImpl
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getThrottleOnRejectBranch()
		 * @generated
		 */
		EClass THROTTLE_ON_REJECT_BRANCH = eINSTANCE.getThrottleOnRejectBranch();

		/**
		 * The meta object literal for the '<em><b>Sequence Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute THROTTLE_ON_REJECT_BRANCH__SEQUENCE_TYPE = eINSTANCE.getThrottleOnRejectBranch_SequenceType();

		/**
		 * The meta object literal for the '<em><b>Sequence Key</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference THROTTLE_ON_REJECT_BRANCH__SEQUENCE_KEY = eINSTANCE.getThrottleOnRejectBranch_SequenceKey();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.CommandMediatorImpl <em>Command Mediator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.CommandMediatorImpl
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getCommandMediator()
		 * @generated
		 */
		EClass COMMAND_MEDIATOR = eINSTANCE.getCommandMediator();

		/**
		 * The meta object literal for the '<em><b>Class Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMMAND_MEDIATOR__CLASS_NAME = eINSTANCE.getCommandMediator_ClassName();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMMAND_MEDIATOR__PROPERTIES = eINSTANCE.getCommandMediator_Properties();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.CommandPropertyImpl <em>Command Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.CommandPropertyImpl
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getCommandProperty()
		 * @generated
		 */
		EClass COMMAND_PROPERTY = eINSTANCE.getCommandProperty();

		/**
		 * The meta object literal for the '<em><b>Property Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMMAND_PROPERTY__PROPERTY_NAME = eINSTANCE.getCommandProperty_PropertyName();

		/**
		 * The meta object literal for the '<em><b>Value Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMMAND_PROPERTY__VALUE_TYPE = eINSTANCE.getCommandProperty_ValueType();

		/**
		 * The meta object literal for the '<em><b>Value Literal</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMMAND_PROPERTY__VALUE_LITERAL = eINSTANCE.getCommandProperty_ValueLiteral();

		/**
		 * The meta object literal for the '<em><b>Value Context Property Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMMAND_PROPERTY__VALUE_CONTEXT_PROPERTY_NAME = eINSTANCE.getCommandProperty_ValueContextPropertyName();

		/**
		 * The meta object literal for the '<em><b>Value Message Element Xpath</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMMAND_PROPERTY__VALUE_MESSAGE_ELEMENT_XPATH = eINSTANCE.getCommandProperty_ValueMessageElementXpath();

		/**
		 * The meta object literal for the '<em><b>Context Action</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMMAND_PROPERTY__CONTEXT_ACTION = eINSTANCE.getCommandProperty_ContextAction();

		/**
		 * The meta object literal for the '<em><b>Message Action</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMMAND_PROPERTY__MESSAGE_ACTION = eINSTANCE.getCommandProperty_MessageAction();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.EventMediatorImpl <em>Event Mediator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.EventMediatorImpl
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getEventMediator()
		 * @generated
		 */
		EClass EVENT_MEDIATOR = eINSTANCE.getEventMediator();

		/**
		 * The meta object literal for the '<em><b>Topic Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT_MEDIATOR__TOPIC_TYPE = eINSTANCE.getEventMediator_TopicType();

		/**
		 * The meta object literal for the '<em><b>Static Topic</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT_MEDIATOR__STATIC_TOPIC = eINSTANCE.getEventMediator_StaticTopic();

		/**
		 * The meta object literal for the '<em><b>Dynamic Topic</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT_MEDIATOR__DYNAMIC_TOPIC = eINSTANCE.getEventMediator_DynamicTopic();

		/**
		 * The meta object literal for the '<em><b>Event Expression</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT_MEDIATOR__EVENT_EXPRESSION = eINSTANCE.getEventMediator_EventExpression();

		/**
		 * The meta object literal for the '<em><b>Event Source</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT_MEDIATOR__EVENT_SOURCE = eINSTANCE.getEventMediator_EventSource();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.AbstractSqlExecutorMediatorImpl <em>Abstract Sql Executor Mediator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.AbstractSqlExecutorMediatorImpl
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getAbstractSqlExecutorMediator()
		 * @generated
		 */
		EClass ABSTRACT_SQL_EXECUTOR_MEDIATOR = eINSTANCE.getAbstractSqlExecutorMediator();

		/**
		 * The meta object literal for the '<em><b>Connection Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_TYPE = eINSTANCE.getAbstractSqlExecutorMediator_ConnectionType();

		/**
		 * The meta object literal for the '<em><b>Connection Ds Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_DS_TYPE = eINSTANCE.getAbstractSqlExecutorMediator_ConnectionDsType();

		/**
		 * The meta object literal for the '<em><b>Connection Db Driver</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_DB_DRIVER = eINSTANCE.getAbstractSqlExecutorMediator_ConnectionDbDriver();

		/**
		 * The meta object literal for the '<em><b>Connection Ds Initial Context</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_DS_INITIAL_CONTEXT = eINSTANCE.getAbstractSqlExecutorMediator_ConnectionDsInitialContext();

		/**
		 * The meta object literal for the '<em><b>Connection Ds Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_DS_NAME = eINSTANCE.getAbstractSqlExecutorMediator_ConnectionDsName();

		/**
		 * The meta object literal for the '<em><b>Connection URL</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_URL = eINSTANCE.getAbstractSqlExecutorMediator_ConnectionURL();

		/**
		 * The meta object literal for the '<em><b>Connection Username</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_USERNAME = eINSTANCE.getAbstractSqlExecutorMediator_ConnectionUsername();

		/**
		 * The meta object literal for the '<em><b>Connection Password</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_PASSWORD = eINSTANCE.getAbstractSqlExecutorMediator_ConnectionPassword();

		/**
		 * The meta object literal for the '<em><b>Property Autocommit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_AUTOCOMMIT = eINSTANCE.getAbstractSqlExecutorMediator_PropertyAutocommit();

		/**
		 * The meta object literal for the '<em><b>Property Isolation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_ISOLATION = eINSTANCE.getAbstractSqlExecutorMediator_PropertyIsolation();

		/**
		 * The meta object literal for the '<em><b>Property Maxactive</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_MAXACTIVE = eINSTANCE.getAbstractSqlExecutorMediator_PropertyMaxactive();

		/**
		 * The meta object literal for the '<em><b>Property Maxidle</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_MAXIDLE = eINSTANCE.getAbstractSqlExecutorMediator_PropertyMaxidle();

		/**
		 * The meta object literal for the '<em><b>Property Maxopenstatements</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_MAXOPENSTATEMENTS = eINSTANCE.getAbstractSqlExecutorMediator_PropertyMaxopenstatements();

		/**
		 * The meta object literal for the '<em><b>Property Maxwait</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_MAXWAIT = eINSTANCE.getAbstractSqlExecutorMediator_PropertyMaxwait();

		/**
		 * The meta object literal for the '<em><b>Property Minidle</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_MINIDLE = eINSTANCE.getAbstractSqlExecutorMediator_PropertyMinidle();

		/**
		 * The meta object literal for the '<em><b>Property Poolstatements</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_POOLSTATEMENTS = eINSTANCE.getAbstractSqlExecutorMediator_PropertyPoolstatements();

		/**
		 * The meta object literal for the '<em><b>Property Testonborrow</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_TESTONBORROW = eINSTANCE.getAbstractSqlExecutorMediator_PropertyTestonborrow();

		/**
		 * The meta object literal for the '<em><b>Property Testwhileidle</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_TESTWHILEIDLE = eINSTANCE.getAbstractSqlExecutorMediator_PropertyTestwhileidle();

		/**
		 * The meta object literal for the '<em><b>Property Validationquery</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_VALIDATIONQUERY = eINSTANCE.getAbstractSqlExecutorMediator_PropertyValidationquery();

		/**
		 * The meta object literal for the '<em><b>Property Initialsize</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_INITIALSIZE = eINSTANCE.getAbstractSqlExecutorMediator_PropertyInitialsize();

		/**
		 * The meta object literal for the '<em><b>Sql Statements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_SQL_EXECUTOR_MEDIATOR__SQL_STATEMENTS = eINSTANCE.getAbstractSqlExecutorMediator_SqlStatements();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.SqlStatementImpl <em>Sql Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.SqlStatementImpl
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getSqlStatement()
		 * @generated
		 */
		EClass SQL_STATEMENT = eINSTANCE.getSqlStatement();

		/**
		 * The meta object literal for the '<em><b>Query String</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SQL_STATEMENT__QUERY_STRING = eINSTANCE.getSqlStatement_QueryString();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SQL_STATEMENT__PARAMETERS = eINSTANCE.getSqlStatement_Parameters();

		/**
		 * The meta object literal for the '<em><b>Results Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SQL_STATEMENT__RESULTS_ENABLED = eINSTANCE.getSqlStatement_ResultsEnabled();

		/**
		 * The meta object literal for the '<em><b>Results</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SQL_STATEMENT__RESULTS = eINSTANCE.getSqlStatement_Results();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.SqlParameterDefinitionImpl <em>Sql Parameter Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.SqlParameterDefinitionImpl
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getSqlParameterDefinition()
		 * @generated
		 */
		EClass SQL_PARAMETER_DEFINITION = eINSTANCE.getSqlParameterDefinition();

		/**
		 * The meta object literal for the '<em><b>Data Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SQL_PARAMETER_DEFINITION__DATA_TYPE = eINSTANCE.getSqlParameterDefinition_DataType();

		/**
		 * The meta object literal for the '<em><b>Value Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SQL_PARAMETER_DEFINITION__VALUE_TYPE = eINSTANCE.getSqlParameterDefinition_ValueType();

		/**
		 * The meta object literal for the '<em><b>Value Literal</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SQL_PARAMETER_DEFINITION__VALUE_LITERAL = eINSTANCE.getSqlParameterDefinition_ValueLiteral();

		/**
		 * The meta object literal for the '<em><b>Value Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SQL_PARAMETER_DEFINITION__VALUE_EXPRESSION = eINSTANCE.getSqlParameterDefinition_ValueExpression();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.SqlResultMappingImpl <em>Sql Result Mapping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.SqlResultMappingImpl
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getSqlResultMapping()
		 * @generated
		 */
		EClass SQL_RESULT_MAPPING = eINSTANCE.getSqlResultMapping();

		/**
		 * The meta object literal for the '<em><b>Property Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SQL_RESULT_MAPPING__PROPERTY_NAME = eINSTANCE.getSqlResultMapping_PropertyName();

		/**
		 * The meta object literal for the '<em><b>Column Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SQL_RESULT_MAPPING__COLUMN_ID = eINSTANCE.getSqlResultMapping_ColumnId();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.DBLookupMediatorImpl <em>DB Lookup Mediator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.DBLookupMediatorImpl
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getDBLookupMediator()
		 * @generated
		 */
		EClass DB_LOOKUP_MEDIATOR = eINSTANCE.getDBLookupMediator();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.DBReportMediatorImpl <em>DB Report Mediator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.DBReportMediatorImpl
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getDBReportMediator()
		 * @generated
		 */
		EClass DB_REPORT_MEDIATOR = eINSTANCE.getDBReportMediator();

		/**
		 * The meta object literal for the '<em><b>Connection Use Transaction</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DB_REPORT_MEDIATOR__CONNECTION_USE_TRANSACTION = eINSTANCE.getDBReportMediator_ConnectionUseTransaction();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.RuleMediatorImpl <em>Rule Mediator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.RuleMediatorImpl
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getRuleMediator()
		 * @generated
		 */
		EClass RULE_MEDIATOR = eINSTANCE.getRuleMediator();

		/**
		 * The meta object literal for the '<em><b>Rule Set Configuration</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RULE_MEDIATOR__RULE_SET_CONFIGURATION = eINSTANCE.getRuleMediator_RuleSetConfiguration();

		/**
		 * The meta object literal for the '<em><b>Rule Session Configuration</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RULE_MEDIATOR__RULE_SESSION_CONFIGURATION = eINSTANCE.getRuleMediator_RuleSessionConfiguration();

		/**
		 * The meta object literal for the '<em><b>Facts Configuration</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RULE_MEDIATOR__FACTS_CONFIGURATION = eINSTANCE.getRuleMediator_FactsConfiguration();

		/**
		 * The meta object literal for the '<em><b>Results Configuration</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RULE_MEDIATOR__RESULTS_CONFIGURATION = eINSTANCE.getRuleMediator_ResultsConfiguration();

		/**
		 * The meta object literal for the '<em><b>Child Mediators Configuration</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RULE_MEDIATOR__CHILD_MEDIATORS_CONFIGURATION = eINSTANCE.getRuleMediator_ChildMediatorsConfiguration();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.RuleSetConfigurationImpl <em>Rule Set Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.RuleSetConfigurationImpl
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getRuleSetConfiguration()
		 * @generated
		 */
		EClass RULE_SET_CONFIGURATION = eINSTANCE.getRuleSetConfiguration();

		/**
		 * The meta object literal for the '<em><b>Source Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RULE_SET_CONFIGURATION__SOURCE_TYPE = eINSTANCE.getRuleSetConfiguration_SourceType();

		/**
		 * The meta object literal for the '<em><b>Source Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RULE_SET_CONFIGURATION__SOURCE_CODE = eINSTANCE.getRuleSetConfiguration_SourceCode();

		/**
		 * The meta object literal for the '<em><b>Source Key</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RULE_SET_CONFIGURATION__SOURCE_KEY = eINSTANCE.getRuleSetConfiguration_SourceKey();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RULE_SET_CONFIGURATION__PROPERTIES = eINSTANCE.getRuleSetConfiguration_Properties();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.RuleSetCreationPropertyImpl <em>Rule Set Creation Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.RuleSetCreationPropertyImpl
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getRuleSetCreationProperty()
		 * @generated
		 */
		EClass RULE_SET_CREATION_PROPERTY = eINSTANCE.getRuleSetCreationProperty();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.RuleSessionConfigurationImpl <em>Rule Session Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.RuleSessionConfigurationImpl
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getRuleSessionConfiguration()
		 * @generated
		 */
		EClass RULE_SESSION_CONFIGURATION = eINSTANCE.getRuleSessionConfiguration();

		/**
		 * The meta object literal for the '<em><b>Stateful Session</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RULE_SESSION_CONFIGURATION__STATEFUL_SESSION = eINSTANCE.getRuleSessionConfiguration_StatefulSession();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RULE_SESSION_CONFIGURATION__PROPERTIES = eINSTANCE.getRuleSessionConfiguration_Properties();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.RuleSessionPropertyImpl <em>Rule Session Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.RuleSessionPropertyImpl
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getRuleSessionProperty()
		 * @generated
		 */
		EClass RULE_SESSION_PROPERTY = eINSTANCE.getRuleSessionProperty();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.RuleFactsConfigurationImpl <em>Rule Facts Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.RuleFactsConfigurationImpl
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getRuleFactsConfiguration()
		 * @generated
		 */
		EClass RULE_FACTS_CONFIGURATION = eINSTANCE.getRuleFactsConfiguration();

		/**
		 * The meta object literal for the '<em><b>Facts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RULE_FACTS_CONFIGURATION__FACTS = eINSTANCE.getRuleFactsConfiguration_Facts();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.RuleFactImpl <em>Rule Fact</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.RuleFactImpl
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getRuleFact()
		 * @generated
		 */
		EClass RULE_FACT = eINSTANCE.getRuleFact();

		/**
		 * The meta object literal for the '<em><b>Fact Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RULE_FACT__FACT_TYPE = eINSTANCE.getRuleFact_FactType();

		/**
		 * The meta object literal for the '<em><b>Fact Custom Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RULE_FACT__FACT_CUSTOM_TYPE = eINSTANCE.getRuleFact_FactCustomType();

		/**
		 * The meta object literal for the '<em><b>Fact Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RULE_FACT__FACT_NAME = eINSTANCE.getRuleFact_FactName();

		/**
		 * The meta object literal for the '<em><b>Value Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RULE_FACT__VALUE_TYPE = eINSTANCE.getRuleFact_ValueType();

		/**
		 * The meta object literal for the '<em><b>Value Literal</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RULE_FACT__VALUE_LITERAL = eINSTANCE.getRuleFact_ValueLiteral();

		/**
		 * The meta object literal for the '<em><b>Value Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RULE_FACT__VALUE_EXPRESSION = eINSTANCE.getRuleFact_ValueExpression();

		/**
		 * The meta object literal for the '<em><b>Value Key</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RULE_FACT__VALUE_KEY = eINSTANCE.getRuleFact_ValueKey();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.RuleResultsConfigurationImpl <em>Rule Results Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.RuleResultsConfigurationImpl
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getRuleResultsConfiguration()
		 * @generated
		 */
		EClass RULE_RESULTS_CONFIGURATION = eINSTANCE.getRuleResultsConfiguration();

		/**
		 * The meta object literal for the '<em><b>Results</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RULE_RESULTS_CONFIGURATION__RESULTS = eINSTANCE.getRuleResultsConfiguration_Results();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.RuleResultImpl <em>Rule Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.RuleResultImpl
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getRuleResult()
		 * @generated
		 */
		EClass RULE_RESULT = eINSTANCE.getRuleResult();

		/**
		 * The meta object literal for the '<em><b>Result Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RULE_RESULT__RESULT_TYPE = eINSTANCE.getRuleResult_ResultType();

		/**
		 * The meta object literal for the '<em><b>Result Custom Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RULE_RESULT__RESULT_CUSTOM_TYPE = eINSTANCE.getRuleResult_ResultCustomType();

		/**
		 * The meta object literal for the '<em><b>Result Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RULE_RESULT__RESULT_NAME = eINSTANCE.getRuleResult_ResultName();

		/**
		 * The meta object literal for the '<em><b>Value Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RULE_RESULT__VALUE_TYPE = eINSTANCE.getRuleResult_ValueType();

		/**
		 * The meta object literal for the '<em><b>Value Literal</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RULE_RESULT__VALUE_LITERAL = eINSTANCE.getRuleResult_ValueLiteral();

		/**
		 * The meta object literal for the '<em><b>Value Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RULE_RESULT__VALUE_EXPRESSION = eINSTANCE.getRuleResult_ValueExpression();

		/**
		 * The meta object literal for the '<em><b>Value Key</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RULE_RESULT__VALUE_KEY = eINSTANCE.getRuleResult_ValueKey();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.RuleChildMediatorsConfigurationImpl <em>Rule Child Mediators Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.RuleChildMediatorsConfigurationImpl
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getRuleChildMediatorsConfiguration()
		 * @generated
		 */
		EClass RULE_CHILD_MEDIATORS_CONFIGURATION = eINSTANCE.getRuleChildMediatorsConfiguration();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.SequenceMediatorImpl <em>Sequence Mediator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.SequenceMediatorImpl
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getSequenceMediator()
		 * @generated
		 */
		EClass SEQUENCE_MEDIATOR = eINSTANCE.getSequenceMediator();

		/**
		 * The meta object literal for the '<em><b>Referring Sequence Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEQUENCE_MEDIATOR__REFERRING_SEQUENCE_TYPE = eINSTANCE.getSequenceMediator_ReferringSequenceType();

		/**
		 * The meta object literal for the '<em><b>Dynamic Reference Key</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEQUENCE_MEDIATOR__DYNAMIC_REFERENCE_KEY = eINSTANCE.getSequenceMediator_DynamicReferenceKey();

		/**
		 * The meta object literal for the '<em><b>Static Reference Key</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEQUENCE_MEDIATOR__STATIC_REFERENCE_KEY = eINSTANCE.getSequenceMediator_StaticReferenceKey();

		/**
		 * The meta object literal for the '<em><b>Sequence Key</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEQUENCE_MEDIATOR__SEQUENCE_KEY = eINSTANCE.getSequenceMediator_SequenceKey();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.BuilderMediatorImpl <em>Builder Mediator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.BuilderMediatorImpl
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getBuilderMediator()
		 * @generated
		 */
		EClass BUILDER_MEDIATOR = eINSTANCE.getBuilderMediator();

		/**
		 * The meta object literal for the '<em><b>Message Builders</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUILDER_MEDIATOR__MESSAGE_BUILDERS = eINSTANCE.getBuilderMediator_MessageBuilders();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.MessageBuilderImpl <em>Message Builder</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MessageBuilderImpl
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getMessageBuilder()
		 * @generated
		 */
		EClass MESSAGE_BUILDER = eINSTANCE.getMessageBuilder();

		/**
		 * The meta object literal for the '<em><b>Content Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MESSAGE_BUILDER__CONTENT_TYPE = eINSTANCE.getMessageBuilder_ContentType();

		/**
		 * The meta object literal for the '<em><b>Builder Class</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MESSAGE_BUILDER__BUILDER_CLASS = eINSTANCE.getMessageBuilder_BuilderClass();

		/**
		 * The meta object literal for the '<em><b>Formatter Class</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MESSAGE_BUILDER__FORMATTER_CLASS = eINSTANCE.getMessageBuilder_FormatterClass();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.SmooksMediatorImpl <em>Smooks Mediator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.SmooksMediatorImpl
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getSmooksMediator()
		 * @generated
		 */
		EClass SMOOKS_MEDIATOR = eINSTANCE.getSmooksMediator();

		/**
		 * The meta object literal for the '<em><b>Configuration Key</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SMOOKS_MEDIATOR__CONFIGURATION_KEY = eINSTANCE.getSmooksMediator_ConfigurationKey();

		/**
		 * The meta object literal for the '<em><b>Input</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SMOOKS_MEDIATOR__INPUT = eINSTANCE.getSmooksMediator_Input();

		/**
		 * The meta object literal for the '<em><b>Output</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SMOOKS_MEDIATOR__OUTPUT = eINSTANCE.getSmooksMediator_Output();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.SmooksInConfigurationImpl <em>Smooks In Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.SmooksInConfigurationImpl
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getSmooksInConfiguration()
		 * @generated
		 */
		EClass SMOOKS_IN_CONFIGURATION = eINSTANCE.getSmooksInConfiguration();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SMOOKS_IN_CONFIGURATION__TYPE = eINSTANCE.getSmooksInConfiguration_Type();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SMOOKS_IN_CONFIGURATION__EXPRESSION = eINSTANCE.getSmooksInConfiguration_Expression();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.SmooksOutConfigurationImpl <em>Smooks Out Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.SmooksOutConfigurationImpl
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getSmooksOutConfiguration()
		 * @generated
		 */
		EClass SMOOKS_OUT_CONFIGURATION = eINSTANCE.getSmooksOutConfiguration();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SMOOKS_OUT_CONFIGURATION__TYPE = eINSTANCE.getSmooksOutConfiguration_Type();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SMOOKS_OUT_CONFIGURATION__EXPRESSION = eINSTANCE.getSmooksOutConfiguration_Expression();

		/**
		 * The meta object literal for the '<em><b>Property</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SMOOKS_OUT_CONFIGURATION__PROPERTY = eINSTANCE.getSmooksOutConfiguration_Property();

		/**
		 * The meta object literal for the '<em><b>Action</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SMOOKS_OUT_CONFIGURATION__ACTION = eINSTANCE.getSmooksOutConfiguration_Action();

		/**
		 * The meta object literal for the '<em><b>Output Method</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SMOOKS_OUT_CONFIGURATION__OUTPUT_METHOD = eINSTANCE.getSmooksOutConfiguration_OutputMethod();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.StoreMediatorImpl <em>Store Mediator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.StoreMediatorImpl
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getStoreMediator()
		 * @generated
		 */
		EClass STORE_MEDIATOR = eINSTANCE.getStoreMediator();

		/**
		 * The meta object literal for the '<em><b>Message Store</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STORE_MEDIATOR__MESSAGE_STORE = eINSTANCE.getStoreMediator_MessageStore();

		/**
		 * The meta object literal for the '<em><b>On Store Sequence</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STORE_MEDIATOR__ON_STORE_SEQUENCE = eINSTANCE.getStoreMediator_OnStoreSequence();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.ConditionalRouteBranchImpl <em>Conditional Route Branch</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.ConditionalRouteBranchImpl
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getConditionalRouteBranch()
		 * @generated
		 */
		EClass CONDITIONAL_ROUTE_BRANCH = eINSTANCE.getConditionalRouteBranch();

		/**
		 * The meta object literal for the '<em><b>Break After Route</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONDITIONAL_ROUTE_BRANCH__BREAK_AFTER_ROUTE = eINSTANCE.getConditionalRouteBranch_BreakAfterRoute();

		/**
		 * The meta object literal for the '<em><b>Evaluator Expression</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONDITIONAL_ROUTE_BRANCH__EVALUATOR_EXPRESSION = eINSTANCE.getConditionalRouteBranch_EvaluatorExpression();

		/**
		 * The meta object literal for the '<em><b>Target Sequence</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONDITIONAL_ROUTE_BRANCH__TARGET_SEQUENCE = eINSTANCE.getConditionalRouteBranch_TargetSequence();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.ConditionalRouterMediatorImpl <em>Conditional Router Mediator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.ConditionalRouterMediatorImpl
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getConditionalRouterMediator()
		 * @generated
		 */
		EClass CONDITIONAL_ROUTER_MEDIATOR = eINSTANCE.getConditionalRouterMediator();

		/**
		 * The meta object literal for the '<em><b>Continue After Route</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONDITIONAL_ROUTER_MEDIATOR__CONTINUE_AFTER_ROUTE = eINSTANCE.getConditionalRouterMediator_ContinueAfterRoute();

		/**
		 * The meta object literal for the '<em><b>Conditional Route Braches</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONDITIONAL_ROUTER_MEDIATOR__CONDITIONAL_ROUTE_BRACHES = eINSTANCE.getConditionalRouterMediator_ConditionalRouteBraches();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.URLRewriteRuleActionImpl <em>URL Rewrite Rule Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.URLRewriteRuleActionImpl
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getURLRewriteRuleAction()
		 * @generated
		 */
		EClass URL_REWRITE_RULE_ACTION = eINSTANCE.getURLRewriteRuleAction();

		/**
		 * The meta object literal for the '<em><b>Rule Action</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute URL_REWRITE_RULE_ACTION__RULE_ACTION = eINSTANCE.getURLRewriteRuleAction_RuleAction();

		/**
		 * The meta object literal for the '<em><b>Rule Fragment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute URL_REWRITE_RULE_ACTION__RULE_FRAGMENT = eINSTANCE.getURLRewriteRuleAction_RuleFragment();

		/**
		 * The meta object literal for the '<em><b>Rule Option</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute URL_REWRITE_RULE_ACTION__RULE_OPTION = eINSTANCE.getURLRewriteRuleAction_RuleOption();

		/**
		 * The meta object literal for the '<em><b>Action Expression</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference URL_REWRITE_RULE_ACTION__ACTION_EXPRESSION = eINSTANCE.getURLRewriteRuleAction_ActionExpression();

		/**
		 * The meta object literal for the '<em><b>Action Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute URL_REWRITE_RULE_ACTION__ACTION_VALUE = eINSTANCE.getURLRewriteRuleAction_ActionValue();

		/**
		 * The meta object literal for the '<em><b>Action Regex</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute URL_REWRITE_RULE_ACTION__ACTION_REGEX = eINSTANCE.getURLRewriteRuleAction_ActionRegex();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.URLRewriteRuleImpl <em>URL Rewrite Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.URLRewriteRuleImpl
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getURLRewriteRule()
		 * @generated
		 */
		EClass URL_REWRITE_RULE = eINSTANCE.getURLRewriteRule();

		/**
		 * The meta object literal for the '<em><b>Url Rewrite Rule Condition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference URL_REWRITE_RULE__URL_REWRITE_RULE_CONDITION = eINSTANCE.getURLRewriteRule_UrlRewriteRuleCondition();

		/**
		 * The meta object literal for the '<em><b>Rewrite Rule Action</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference URL_REWRITE_RULE__REWRITE_RULE_ACTION = eINSTANCE.getURLRewriteRule_RewriteRuleAction();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.URLRewriteMediatorImpl <em>URL Rewrite Mediator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.URLRewriteMediatorImpl
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getURLRewriteMediator()
		 * @generated
		 */
		EClass URL_REWRITE_MEDIATOR = eINSTANCE.getURLRewriteMediator();

		/**
		 * The meta object literal for the '<em><b>Url Rewrite Rules</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference URL_REWRITE_MEDIATOR__URL_REWRITE_RULES = eINSTANCE.getURLRewriteMediator_UrlRewriteRules();

		/**
		 * The meta object literal for the '<em><b>In Property</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute URL_REWRITE_MEDIATOR__IN_PROPERTY = eINSTANCE.getURLRewriteMediator_InProperty();

		/**
		 * The meta object literal for the '<em><b>Out Property</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute URL_REWRITE_MEDIATOR__OUT_PROPERTY = eINSTANCE.getURLRewriteMediator_OutProperty();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.CallTemplateMediatorImpl <em>Call Template Mediator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.CallTemplateMediatorImpl
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getCallTemplateMediator()
		 * @generated
		 */
		EClass CALL_TEMPLATE_MEDIATOR = eINSTANCE.getCallTemplateMediator();

		/**
		 * The meta object literal for the '<em><b>Target Template</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CALL_TEMPLATE_MEDIATOR__TARGET_TEMPLATE = eINSTANCE.getCallTemplateMediator_TargetTemplate();

		/**
		 * The meta object literal for the '<em><b>Template Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CALL_TEMPLATE_MEDIATOR__TEMPLATE_PARAMETERS = eINSTANCE.getCallTemplateMediator_TemplateParameters();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.CallTemplateParameterImpl <em>Call Template Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.CallTemplateParameterImpl
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getCallTemplateParameter()
		 * @generated
		 */
		EClass CALL_TEMPLATE_PARAMETER = eINSTANCE.getCallTemplateParameter();

		/**
		 * The meta object literal for the '<em><b>Parameter Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CALL_TEMPLATE_PARAMETER__PARAMETER_NAME = eINSTANCE.getCallTemplateParameter_ParameterName();

		/**
		 * The meta object literal for the '<em><b>Template Parameter Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CALL_TEMPLATE_PARAMETER__TEMPLATE_PARAMETER_TYPE = eINSTANCE.getCallTemplateParameter_TemplateParameterType();

		/**
		 * The meta object literal for the '<em><b>Parameter Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CALL_TEMPLATE_PARAMETER__PARAMETER_VALUE = eINSTANCE.getCallTemplateParameter_ParameterValue();

		/**
		 * The meta object literal for the '<em><b>Parameter Expression</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CALL_TEMPLATE_PARAMETER__PARAMETER_EXPRESSION = eINSTANCE.getCallTemplateParameter_ParameterExpression();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.PayloadFactoryMediatorImpl <em>Payload Factory Mediator</em>}' class.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.PayloadFactoryMediatorImpl
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getPayloadFactoryMediator()
		 * @generated
		 */
        EClass PAYLOAD_FACTORY_MEDIATOR = eINSTANCE.getPayloadFactoryMediator();

        /**
		 * The meta object literal for the '<em><b>Format</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @generated
		 */
        EAttribute PAYLOAD_FACTORY_MEDIATOR__FORMAT = eINSTANCE.getPayloadFactoryMediator_Format();

        /**
		 * The meta object literal for the '<em><b>Args</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @generated
		 */
        EReference PAYLOAD_FACTORY_MEDIATOR__ARGS = eINSTANCE.getPayloadFactoryMediator_Args();

        /**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.impl.PayloadFactoryArgumentImpl <em>Payload Factory Argument</em>}' class.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.PayloadFactoryArgumentImpl
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getPayloadFactoryArgument()
		 * @generated
		 */
        EClass PAYLOAD_FACTORY_ARGUMENT = eINSTANCE.getPayloadFactoryArgument();

        /**
		 * The meta object literal for the '<em><b>Argument Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @generated
		 */
        EAttribute PAYLOAD_FACTORY_ARGUMENT__ARGUMENT_TYPE = eINSTANCE.getPayloadFactoryArgument_ArgumentType();

        /**
		 * The meta object literal for the '<em><b>Argument Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @generated
		 */
        EAttribute PAYLOAD_FACTORY_ARGUMENT__ARGUMENT_VALUE = eINSTANCE.getPayloadFactoryArgument_ArgumentValue();

        /**
		 * The meta object literal for the '<em><b>Argument Expression</b></em>' reference feature.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @generated
		 */
        EReference PAYLOAD_FACTORY_ARGUMENT__ARGUMENT_EXPRESSION = eINSTANCE.getPayloadFactoryArgument_ArgumentExpression();

        /**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.LogCategory <em>Log Category</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.LogCategory
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getLogCategory()
		 * @generated
		 */
		EEnum LOG_CATEGORY = eINSTANCE.getLogCategory();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.LogLevel <em>Log Level</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.LogLevel
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getLogLevel()
		 * @generated
		 */
		EEnum LOG_LEVEL = eINSTANCE.getLogLevel();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.FilterConditionType <em>Filter Condition Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.FilterConditionType
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getFilterConditionType()
		 * @generated
		 */
		EEnum FILTER_CONDITION_TYPE = eINSTANCE.getFilterConditionType();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.EntitlementSequence <em>Entitlement Sequence</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.EntitlementSequence
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getEntitlementSequence()
		 * @generated
		 */
		EEnum ENTITLEMENT_SEQUENCE = eINSTANCE.getEntitlementSequence();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.ScriptType <em>Script Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.ScriptType
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getScriptType()
		 * @generated
		 */
		EEnum SCRIPT_TYPE = eINSTANCE.getScriptType();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.ScriptLanguage <em>Script Language</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.ScriptLanguage
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getScriptLanguage()
		 * @generated
		 */
		EEnum SCRIPT_LANGUAGE = eINSTANCE.getScriptLanguage();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.EnrichSourceType <em>Enrich Source Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.EnrichSourceType
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getEnrichSourceType()
		 * @generated
		 */
		EEnum ENRICH_SOURCE_TYPE = eINSTANCE.getEnrichSourceType();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.EnrichTargetAction <em>Enrich Target Action</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.EnrichTargetAction
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getEnrichTargetAction()
		 * @generated
		 */
		EEnum ENRICH_TARGET_ACTION = eINSTANCE.getEnrichTargetAction();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.EnrichTargetType <em>Enrich Target Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.EnrichTargetType
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getEnrichTargetType()
		 * @generated
		 */
		EEnum ENRICH_TARGET_TYPE = eINSTANCE.getEnrichTargetType();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.FaultSoapVersion <em>Fault Soap Version</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.FaultSoapVersion
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getFaultSoapVersion()
		 * @generated
		 */
		EEnum FAULT_SOAP_VERSION = eINSTANCE.getFaultSoapVersion();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.FaultCodeSoap11 <em>Fault Code Soap11</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.FaultCodeSoap11
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getFaultCodeSoap11()
		 * @generated
		 */
		EEnum FAULT_CODE_SOAP11 = eINSTANCE.getFaultCodeSoap11();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.FaultCodeSoap12 <em>Fault Code Soap12</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.FaultCodeSoap12
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getFaultCodeSoap12()
		 * @generated
		 */
		EEnum FAULT_CODE_SOAP12 = eINSTANCE.getFaultCodeSoap12();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.FaultStringType <em>Fault String Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.FaultStringType
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getFaultStringType()
		 * @generated
		 */
		EEnum FAULT_STRING_TYPE = eINSTANCE.getFaultStringType();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.FaultReasonType <em>Fault Reason Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.FaultReasonType
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getFaultReasonType()
		 * @generated
		 */
		EEnum FAULT_REASON_TYPE = eINSTANCE.getFaultReasonType();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.FaultDetailType <em>Fault Detail Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.FaultDetailType
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getFaultDetailType()
		 * @generated
		 */
		EEnum FAULT_DETAIL_TYPE = eINSTANCE.getFaultDetailType();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.AggregateSequenceType <em>Aggregate Sequence Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.AggregateSequenceType
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getAggregateSequenceType()
		 * @generated
		 */
		EEnum AGGREGATE_SEQUENCE_TYPE = eINSTANCE.getAggregateSequenceType();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.CacheSequenceType <em>Cache Sequence Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.CacheSequenceType
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getCacheSequenceType()
		 * @generated
		 */
		EEnum CACHE_SEQUENCE_TYPE = eINSTANCE.getCacheSequenceType();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.CacheImplementationType <em>Cache Implementation Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.CacheImplementationType
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getCacheImplementationType()
		 * @generated
		 */
		EEnum CACHE_IMPLEMENTATION_TYPE = eINSTANCE.getCacheImplementationType();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.CacheAction <em>Cache Action</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.CacheAction
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getCacheAction()
		 * @generated
		 */
		EEnum CACHE_ACTION = eINSTANCE.getCacheAction();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.CacheScope <em>Cache Scope</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.CacheScope
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getCacheScope()
		 * @generated
		 */
		EEnum CACHE_SCOPE = eINSTANCE.getCacheScope();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.XQueryVariableType <em>XQuery Variable Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.XQueryVariableType
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getXQueryVariableType()
		 * @generated
		 */
		EEnum XQUERY_VARIABLE_TYPE = eINSTANCE.getXQueryVariableType();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.XQueryVariableValueType <em>XQuery Variable Value Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.XQueryVariableValueType
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getXQueryVariableValueType()
		 * @generated
		 */
		EEnum XQUERY_VARIABLE_VALUE_TYPE = eINSTANCE.getXQueryVariableValueType();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.CalloutPayloadType <em>Callout Payload Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.CalloutPayloadType
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getCalloutPayloadType()
		 * @generated
		 */
		EEnum CALLOUT_PAYLOAD_TYPE = eINSTANCE.getCalloutPayloadType();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.CalloutResultType <em>Callout Result Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.CalloutResultType
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getCalloutResultType()
		 * @generated
		 */
		EEnum CALLOUT_RESULT_TYPE = eINSTANCE.getCalloutResultType();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.RMSpecVersion <em>RM Spec Version</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.RMSpecVersion
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getRMSpecVersion()
		 * @generated
		 */
		EEnum RM_SPEC_VERSION = eINSTANCE.getRMSpecVersion();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.RMSequenceType <em>RM Sequence Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.RMSequenceType
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getRMSequenceType()
		 * @generated
		 */
		EEnum RM_SEQUENCE_TYPE = eINSTANCE.getRMSequenceType();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.TransactionAction <em>Transaction Action</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.TransactionAction
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getTransactionAction()
		 * @generated
		 */
		EEnum TRANSACTION_ACTION = eINSTANCE.getTransactionAction();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.PropertyDataType <em>Property Data Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.PropertyDataType
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getPropertyDataType()
		 * @generated
		 */
		EEnum PROPERTY_DATA_TYPE = eINSTANCE.getPropertyDataType();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.PropertyAction <em>Property Action</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.PropertyAction
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getPropertyAction()
		 * @generated
		 */
		EEnum PROPERTY_ACTION = eINSTANCE.getPropertyAction();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.PropertyScope <em>Property Scope</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.PropertyScope
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getPropertyScope()
		 * @generated
		 */
		EEnum PROPERTY_SCOPE = eINSTANCE.getPropertyScope();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.PropertyValueType <em>Property Value Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.PropertyValueType
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getPropertyValueType()
		 * @generated
		 */
		EEnum PROPERTY_VALUE_TYPE = eINSTANCE.getPropertyValueType();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.HeaderAction <em>Header Action</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.HeaderAction
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getHeaderAction()
		 * @generated
		 */
		EEnum HEADER_ACTION = eINSTANCE.getHeaderAction();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.HeaderValueType <em>Header Value Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.HeaderValueType
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getHeaderValueType()
		 * @generated
		 */
		EEnum HEADER_VALUE_TYPE = eINSTANCE.getHeaderValueType();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.ThrottlePolicyType <em>Throttle Policy Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.ThrottlePolicyType
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getThrottlePolicyType()
		 * @generated
		 */
		EEnum THROTTLE_POLICY_TYPE = eINSTANCE.getThrottlePolicyType();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.ThrottleConditionType <em>Throttle Condition Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.ThrottleConditionType
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getThrottleConditionType()
		 * @generated
		 */
		EEnum THROTTLE_CONDITION_TYPE = eINSTANCE.getThrottleConditionType();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.ThrottleAccessType <em>Throttle Access Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.ThrottleAccessType
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getThrottleAccessType()
		 * @generated
		 */
		EEnum THROTTLE_ACCESS_TYPE = eINSTANCE.getThrottleAccessType();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.ThrottleSequenceType <em>Throttle Sequence Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.ThrottleSequenceType
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getThrottleSequenceType()
		 * @generated
		 */
		EEnum THROTTLE_SEQUENCE_TYPE = eINSTANCE.getThrottleSequenceType();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.CommandPropertyValueType <em>Command Property Value Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.CommandPropertyValueType
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getCommandPropertyValueType()
		 * @generated
		 */
		EEnum COMMAND_PROPERTY_VALUE_TYPE = eINSTANCE.getCommandPropertyValueType();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.CommandPropertyMessageAction <em>Command Property Message Action</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.CommandPropertyMessageAction
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getCommandPropertyMessageAction()
		 * @generated
		 */
		EEnum COMMAND_PROPERTY_MESSAGE_ACTION = eINSTANCE.getCommandPropertyMessageAction();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.CommandPropertyContextAction <em>Command Property Context Action</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.CommandPropertyContextAction
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getCommandPropertyContextAction()
		 * @generated
		 */
		EEnum COMMAND_PROPERTY_CONTEXT_ACTION = eINSTANCE.getCommandPropertyContextAction();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.SqlExecutorConnectionType <em>Sql Executor Connection Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.SqlExecutorConnectionType
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getSqlExecutorConnectionType()
		 * @generated
		 */
		EEnum SQL_EXECUTOR_CONNECTION_TYPE = eINSTANCE.getSqlExecutorConnectionType();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.SqlExecutorDatasourceType <em>Sql Executor Datasource Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.SqlExecutorDatasourceType
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getSqlExecutorDatasourceType()
		 * @generated
		 */
		EEnum SQL_EXECUTOR_DATASOURCE_TYPE = eINSTANCE.getSqlExecutorDatasourceType();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.SqlExecutorBooleanValue <em>Sql Executor Boolean Value</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.SqlExecutorBooleanValue
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getSqlExecutorBooleanValue()
		 * @generated
		 */
		EEnum SQL_EXECUTOR_BOOLEAN_VALUE = eINSTANCE.getSqlExecutorBooleanValue();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.SqlExecutorIsolationLevel <em>Sql Executor Isolation Level</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.SqlExecutorIsolationLevel
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getSqlExecutorIsolationLevel()
		 * @generated
		 */
		EEnum SQL_EXECUTOR_ISOLATION_LEVEL = eINSTANCE.getSqlExecutorIsolationLevel();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.SqlParameterValueType <em>Sql Parameter Value Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.SqlParameterValueType
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getSqlParameterValueType()
		 * @generated
		 */
		EEnum SQL_PARAMETER_VALUE_TYPE = eINSTANCE.getSqlParameterValueType();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.SqlParameterDataType <em>Sql Parameter Data Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.SqlParameterDataType
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getSqlParameterDataType()
		 * @generated
		 */
		EEnum SQL_PARAMETER_DATA_TYPE = eINSTANCE.getSqlParameterDataType();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.RuleSourceType <em>Rule Source Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.RuleSourceType
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getRuleSourceType()
		 * @generated
		 */
		EEnum RULE_SOURCE_TYPE = eINSTANCE.getRuleSourceType();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.RuleFactType <em>Rule Fact Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.RuleFactType
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getRuleFactType()
		 * @generated
		 */
		EEnum RULE_FACT_TYPE = eINSTANCE.getRuleFactType();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.RuleFactValueType <em>Rule Fact Value Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.RuleFactValueType
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getRuleFactValueType()
		 * @generated
		 */
		EEnum RULE_FACT_VALUE_TYPE = eINSTANCE.getRuleFactValueType();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.RuleResultType <em>Rule Result Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.RuleResultType
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getRuleResultType()
		 * @generated
		 */
		EEnum RULE_RESULT_TYPE = eINSTANCE.getRuleResultType();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.RuleResultValueType <em>Rule Result Value Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.RuleResultValueType
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getRuleResultValueType()
		 * @generated
		 */
		EEnum RULE_RESULT_VALUE_TYPE = eINSTANCE.getRuleResultValueType();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.SmooksIODataType <em>Smooks IO Data Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.SmooksIODataType
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getSmooksIODataType()
		 * @generated
		 */
		EEnum SMOOKS_IO_DATA_TYPE = eINSTANCE.getSmooksIODataType();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.ExpressionAction <em>Expression Action</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.ExpressionAction
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getExpressionAction()
		 * @generated
		 */
		EEnum EXPRESSION_ACTION = eINSTANCE.getExpressionAction();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.OutputMethod <em>Output Method</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.OutputMethod
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getOutputMethod()
		 * @generated
		 */
		EEnum OUTPUT_METHOD = eINSTANCE.getOutputMethod();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.ReceivingSequenceType <em>Receiving Sequence Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.ReceivingSequenceType
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getReceivingSequenceType()
		 * @generated
		 */
		EEnum RECEIVING_SEQUENCE_TYPE = eINSTANCE.getReceivingSequenceType();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.KeyType <em>Key Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.KeyType
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getKeyType()
		 * @generated
		 */
		EEnum KEY_TYPE = eINSTANCE.getKeyType();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.RuleActionType <em>Rule Action Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.RuleActionType
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getRuleActionType()
		 * @generated
		 */
		EEnum RULE_ACTION_TYPE = eINSTANCE.getRuleActionType();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.RuleFragmentType <em>Rule Fragment Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.RuleFragmentType
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getRuleFragmentType()
		 * @generated
		 */
		EEnum RULE_FRAGMENT_TYPE = eINSTANCE.getRuleFragmentType();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.RuleOptionType <em>Rule Option Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.RuleOptionType
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getRuleOptionType()
		 * @generated
		 */
		EEnum RULE_OPTION_TYPE = eINSTANCE.getRuleOptionType();

		/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.EnrichSourceInlineType <em>Enrich Source Inline Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.EnrichSourceInlineType
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getEnrichSourceInlineType()
		 * @generated
		 */
		EEnum ENRICH_SOURCE_INLINE_TYPE = eINSTANCE.getEnrichSourceInlineType();

        /**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.PayloadFactoryArgumentType <em>Payload Factory Argument Type</em>}' enum.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.PayloadFactoryArgumentType
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getPayloadFactoryArgumentType()
		 * @generated
		 */
        EEnum PAYLOAD_FACTORY_ARGUMENT_TYPE = eINSTANCE.getPayloadFactoryArgumentType();

								/**
		 * The meta object literal for the '{@link org.wso2.developerstudio.eclipse.esb.mediators.CallOutMediatorEndpointType <em>Call Out Mediator Endpoint Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.CallOutMediatorEndpointType
		 * @see org.wso2.developerstudio.eclipse.esb.mediators.impl.MediatorsPackageImpl#getCallOutMediatorEndpointType()
		 * @generated
		 */
		EEnum CALL_OUT_MEDIATOR_ENDPOINT_TYPE = eINSTANCE.getCallOutMediatorEndpointType();

	}

} //MediatorsPackage
