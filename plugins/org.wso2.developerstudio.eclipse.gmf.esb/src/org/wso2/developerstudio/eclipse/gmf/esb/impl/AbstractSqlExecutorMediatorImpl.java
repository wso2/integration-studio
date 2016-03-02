/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.esb.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.wso2.developerstudio.eclipse.gmf.esb.AbstractSqlExecutorMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.SqlExecutorBooleanValue;
import org.wso2.developerstudio.eclipse.gmf.esb.SqlExecutorConnectionType;
import org.wso2.developerstudio.eclipse.gmf.esb.SqlExecutorDatasourceType;
import org.wso2.developerstudio.eclipse.gmf.esb.SqlExecutorIsolationLevel;
import org.wso2.developerstudio.eclipse.gmf.esb.SqlStatement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Sql Executor Mediator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.AbstractSqlExecutorMediatorImpl#getConnectionType <em>Connection Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.AbstractSqlExecutorMediatorImpl#getConnectionDsType <em>Connection Ds Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.AbstractSqlExecutorMediatorImpl#getConnectionDbDriver <em>Connection Db Driver</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.AbstractSqlExecutorMediatorImpl#getConnectionDsInitialContext <em>Connection Ds Initial Context</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.AbstractSqlExecutorMediatorImpl#getConnectionDsName <em>Connection Ds Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.AbstractSqlExecutorMediatorImpl#getConnectionURL <em>Connection URL</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.AbstractSqlExecutorMediatorImpl#getConnectionUsername <em>Connection Username</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.AbstractSqlExecutorMediatorImpl#getConnectionPassword <em>Connection Password</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.AbstractSqlExecutorMediatorImpl#getPropertyAutocommit <em>Property Autocommit</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.AbstractSqlExecutorMediatorImpl#getPropertyIsolation <em>Property Isolation</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.AbstractSqlExecutorMediatorImpl#getPropertyMaxactive <em>Property Maxactive</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.AbstractSqlExecutorMediatorImpl#getPropertyMaxidle <em>Property Maxidle</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.AbstractSqlExecutorMediatorImpl#getPropertyMaxopenstatements <em>Property Maxopenstatements</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.AbstractSqlExecutorMediatorImpl#getPropertyMaxwait <em>Property Maxwait</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.AbstractSqlExecutorMediatorImpl#getPropertyMinidle <em>Property Minidle</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.AbstractSqlExecutorMediatorImpl#getPropertyPoolstatements <em>Property Poolstatements</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.AbstractSqlExecutorMediatorImpl#getPropertyTestonborrow <em>Property Testonborrow</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.AbstractSqlExecutorMediatorImpl#getPropertyTestwhileidle <em>Property Testwhileidle</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.AbstractSqlExecutorMediatorImpl#getPropertyValidationquery <em>Property Validationquery</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.AbstractSqlExecutorMediatorImpl#getPropertyInitialsize <em>Property Initialsize</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.AbstractSqlExecutorMediatorImpl#getSqlStatements <em>Sql Statements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AbstractSqlExecutorMediatorImpl extends MediatorImpl implements AbstractSqlExecutorMediator {
	/**
	 * The default value of the '{@link #getConnectionType() <em>Connection Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectionType()
	 * @generated
	 * @ordered
	 */
	protected static final SqlExecutorConnectionType CONNECTION_TYPE_EDEFAULT = SqlExecutorConnectionType.DB_CONNECTION;

	/**
	 * The cached value of the '{@link #getConnectionType() <em>Connection Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectionType()
	 * @generated
	 * @ordered
	 */
	protected SqlExecutorConnectionType connectionType = CONNECTION_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getConnectionDsType() <em>Connection Ds Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectionDsType()
	 * @generated
	 * @ordered
	 */
	protected static final SqlExecutorDatasourceType CONNECTION_DS_TYPE_EDEFAULT = SqlExecutorDatasourceType.EXTERNAL;

	/**
	 * The cached value of the '{@link #getConnectionDsType() <em>Connection Ds Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectionDsType()
	 * @generated
	 * @ordered
	 */
	protected SqlExecutorDatasourceType connectionDsType = CONNECTION_DS_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getConnectionDbDriver() <em>Connection Db Driver</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectionDbDriver()
	 * @generated
	 * @ordered
	 */
	protected static final String CONNECTION_DB_DRIVER_EDEFAULT = "driver_class";

	/**
	 * The cached value of the '{@link #getConnectionDbDriver() <em>Connection Db Driver</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectionDbDriver()
	 * @generated
	 * @ordered
	 */
	protected String connectionDbDriver = CONNECTION_DB_DRIVER_EDEFAULT;

	/**
	 * The default value of the '{@link #getConnectionDsInitialContext() <em>Connection Ds Initial Context</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectionDsInitialContext()
	 * @generated
	 * @ordered
	 */
	protected static final String CONNECTION_DS_INITIAL_CONTEXT_EDEFAULT = "initial_context";

	/**
	 * The cached value of the '{@link #getConnectionDsInitialContext() <em>Connection Ds Initial Context</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectionDsInitialContext()
	 * @generated
	 * @ordered
	 */
	protected String connectionDsInitialContext = CONNECTION_DS_INITIAL_CONTEXT_EDEFAULT;

	/**
	 * The default value of the '{@link #getConnectionDsName() <em>Connection Ds Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectionDsName()
	 * @generated
	 * @ordered
	 */
	protected static final String CONNECTION_DS_NAME_EDEFAULT = "datasource_name";

	/**
	 * The cached value of the '{@link #getConnectionDsName() <em>Connection Ds Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectionDsName()
	 * @generated
	 * @ordered
	 */
	protected String connectionDsName = CONNECTION_DS_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getConnectionURL() <em>Connection URL</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectionURL()
	 * @generated
	 * @ordered
	 */
	protected static final String CONNECTION_URL_EDEFAULT = "connection_url";

	/**
	 * The cached value of the '{@link #getConnectionURL() <em>Connection URL</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectionURL()
	 * @generated
	 * @ordered
	 */
	protected String connectionURL = CONNECTION_URL_EDEFAULT;

	/**
	 * The default value of the '{@link #getConnectionUsername() <em>Connection Username</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectionUsername()
	 * @generated
	 * @ordered
	 */
	protected static final String CONNECTION_USERNAME_EDEFAULT = "username";

	/**
	 * The cached value of the '{@link #getConnectionUsername() <em>Connection Username</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectionUsername()
	 * @generated
	 * @ordered
	 */
	protected String connectionUsername = CONNECTION_USERNAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getConnectionPassword() <em>Connection Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectionPassword()
	 * @generated
	 * @ordered
	 */
	protected static final String CONNECTION_PASSWORD_EDEFAULT = "password";

	/**
	 * The cached value of the '{@link #getConnectionPassword() <em>Connection Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectionPassword()
	 * @generated
	 * @ordered
	 */
	protected String connectionPassword = CONNECTION_PASSWORD_EDEFAULT;

	/**
	 * The default value of the '{@link #getPropertyAutocommit() <em>Property Autocommit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyAutocommit()
	 * @generated
	 * @ordered
	 */
	protected static final SqlExecutorBooleanValue PROPERTY_AUTOCOMMIT_EDEFAULT = SqlExecutorBooleanValue.DEFAULT;

	/**
	 * The cached value of the '{@link #getPropertyAutocommit() <em>Property Autocommit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyAutocommit()
	 * @generated
	 * @ordered
	 */
	protected SqlExecutorBooleanValue propertyAutocommit = PROPERTY_AUTOCOMMIT_EDEFAULT;

	/**
	 * The default value of the '{@link #getPropertyIsolation() <em>Property Isolation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyIsolation()
	 * @generated
	 * @ordered
	 */
	protected static final SqlExecutorIsolationLevel PROPERTY_ISOLATION_EDEFAULT = SqlExecutorIsolationLevel.DEFAULT;

	/**
	 * The cached value of the '{@link #getPropertyIsolation() <em>Property Isolation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyIsolation()
	 * @generated
	 * @ordered
	 */
	protected SqlExecutorIsolationLevel propertyIsolation = PROPERTY_ISOLATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getPropertyMaxactive() <em>Property Maxactive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyMaxactive()
	 * @generated
	 * @ordered
	 */
	protected static final int PROPERTY_MAXACTIVE_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getPropertyMaxactive() <em>Property Maxactive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyMaxactive()
	 * @generated
	 * @ordered
	 */
	protected int propertyMaxactive = PROPERTY_MAXACTIVE_EDEFAULT;

	/**
	 * The default value of the '{@link #getPropertyMaxidle() <em>Property Maxidle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyMaxidle()
	 * @generated
	 * @ordered
	 */
	protected static final int PROPERTY_MAXIDLE_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getPropertyMaxidle() <em>Property Maxidle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyMaxidle()
	 * @generated
	 * @ordered
	 */
	protected int propertyMaxidle = PROPERTY_MAXIDLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getPropertyMaxopenstatements() <em>Property Maxopenstatements</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyMaxopenstatements()
	 * @generated
	 * @ordered
	 */
	protected static final int PROPERTY_MAXOPENSTATEMENTS_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getPropertyMaxopenstatements() <em>Property Maxopenstatements</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyMaxopenstatements()
	 * @generated
	 * @ordered
	 */
	protected int propertyMaxopenstatements = PROPERTY_MAXOPENSTATEMENTS_EDEFAULT;

	/**
	 * The default value of the '{@link #getPropertyMaxwait() <em>Property Maxwait</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyMaxwait()
	 * @generated
	 * @ordered
	 */
	protected static final int PROPERTY_MAXWAIT_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getPropertyMaxwait() <em>Property Maxwait</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyMaxwait()
	 * @generated
	 * @ordered
	 */
	protected int propertyMaxwait = PROPERTY_MAXWAIT_EDEFAULT;

	/**
	 * The default value of the '{@link #getPropertyMinidle() <em>Property Minidle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyMinidle()
	 * @generated
	 * @ordered
	 */
	protected static final int PROPERTY_MINIDLE_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getPropertyMinidle() <em>Property Minidle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyMinidle()
	 * @generated
	 * @ordered
	 */
	protected int propertyMinidle = PROPERTY_MINIDLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getPropertyPoolstatements() <em>Property Poolstatements</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyPoolstatements()
	 * @generated
	 * @ordered
	 */
	protected static final SqlExecutorBooleanValue PROPERTY_POOLSTATEMENTS_EDEFAULT = SqlExecutorBooleanValue.DEFAULT;

	/**
	 * The cached value of the '{@link #getPropertyPoolstatements() <em>Property Poolstatements</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyPoolstatements()
	 * @generated
	 * @ordered
	 */
	protected SqlExecutorBooleanValue propertyPoolstatements = PROPERTY_POOLSTATEMENTS_EDEFAULT;

	/**
	 * The default value of the '{@link #getPropertyTestonborrow() <em>Property Testonborrow</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyTestonborrow()
	 * @generated
	 * @ordered
	 */
	protected static final SqlExecutorBooleanValue PROPERTY_TESTONBORROW_EDEFAULT = SqlExecutorBooleanValue.DEFAULT;

	/**
	 * The cached value of the '{@link #getPropertyTestonborrow() <em>Property Testonborrow</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyTestonborrow()
	 * @generated
	 * @ordered
	 */
	protected SqlExecutorBooleanValue propertyTestonborrow = PROPERTY_TESTONBORROW_EDEFAULT;

	/**
	 * The default value of the '{@link #getPropertyTestwhileidle() <em>Property Testwhileidle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyTestwhileidle()
	 * @generated
	 * @ordered
	 */
	protected static final SqlExecutorBooleanValue PROPERTY_TESTWHILEIDLE_EDEFAULT = SqlExecutorBooleanValue.DEFAULT;

	/**
	 * The cached value of the '{@link #getPropertyTestwhileidle() <em>Property Testwhileidle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyTestwhileidle()
	 * @generated
	 * @ordered
	 */
	protected SqlExecutorBooleanValue propertyTestwhileidle = PROPERTY_TESTWHILEIDLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getPropertyValidationquery() <em>Property Validationquery</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyValidationquery()
	 * @generated
	 * @ordered
	 */
	protected static final String PROPERTY_VALIDATIONQUERY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPropertyValidationquery() <em>Property Validationquery</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyValidationquery()
	 * @generated
	 * @ordered
	 */
	protected String propertyValidationquery = PROPERTY_VALIDATIONQUERY_EDEFAULT;

	/**
	 * The default value of the '{@link #getPropertyInitialsize() <em>Property Initialsize</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyInitialsize()
	 * @generated
	 * @ordered
	 */
	protected static final int PROPERTY_INITIALSIZE_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getPropertyInitialsize() <em>Property Initialsize</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyInitialsize()
	 * @generated
	 * @ordered
	 */
	protected int propertyInitialsize = PROPERTY_INITIALSIZE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSqlStatements() <em>Sql Statements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSqlStatements()
	 * @generated
	 * @ordered
	 */
	protected EList<SqlStatement> sqlStatements;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractSqlExecutorMediatorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.ABSTRACT_SQL_EXECUTOR_MEDIATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SqlExecutorConnectionType getConnectionType() {
		return connectionType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConnectionType(SqlExecutorConnectionType newConnectionType) {
		SqlExecutorConnectionType oldConnectionType = connectionType;
		connectionType = newConnectionType == null ? CONNECTION_TYPE_EDEFAULT : newConnectionType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_TYPE, oldConnectionType, connectionType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SqlExecutorDatasourceType getConnectionDsType() {
		return connectionDsType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConnectionDsType(SqlExecutorDatasourceType newConnectionDsType) {
		SqlExecutorDatasourceType oldConnectionDsType = connectionDsType;
		connectionDsType = newConnectionDsType == null ? CONNECTION_DS_TYPE_EDEFAULT : newConnectionDsType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_DS_TYPE, oldConnectionDsType, connectionDsType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getConnectionDbDriver() {
		return connectionDbDriver;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConnectionDbDriver(String newConnectionDbDriver) {
		String oldConnectionDbDriver = connectionDbDriver;
		connectionDbDriver = newConnectionDbDriver;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_DB_DRIVER, oldConnectionDbDriver, connectionDbDriver));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getConnectionDsInitialContext() {
		return connectionDsInitialContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConnectionDsInitialContext(String newConnectionDsInitialContext) {
		String oldConnectionDsInitialContext = connectionDsInitialContext;
		connectionDsInitialContext = newConnectionDsInitialContext;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_DS_INITIAL_CONTEXT, oldConnectionDsInitialContext, connectionDsInitialContext));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getConnectionDsName() {
		return connectionDsName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConnectionDsName(String newConnectionDsName) {
		String oldConnectionDsName = connectionDsName;
		connectionDsName = newConnectionDsName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_DS_NAME, oldConnectionDsName, connectionDsName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getConnectionURL() {
		return connectionURL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConnectionURL(String newConnectionURL) {
		String oldConnectionURL = connectionURL;
		connectionURL = newConnectionURL;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_URL, oldConnectionURL, connectionURL));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getConnectionUsername() {
		return connectionUsername;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConnectionUsername(String newConnectionUsername) {
		String oldConnectionUsername = connectionUsername;
		connectionUsername = newConnectionUsername;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_USERNAME, oldConnectionUsername, connectionUsername));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getConnectionPassword() {
		return connectionPassword;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConnectionPassword(String newConnectionPassword) {
		String oldConnectionPassword = connectionPassword;
		connectionPassword = newConnectionPassword;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_PASSWORD, oldConnectionPassword, connectionPassword));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SqlExecutorBooleanValue getPropertyAutocommit() {
		return propertyAutocommit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPropertyAutocommit(SqlExecutorBooleanValue newPropertyAutocommit) {
		SqlExecutorBooleanValue oldPropertyAutocommit = propertyAutocommit;
		propertyAutocommit = newPropertyAutocommit == null ? PROPERTY_AUTOCOMMIT_EDEFAULT : newPropertyAutocommit;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_AUTOCOMMIT, oldPropertyAutocommit, propertyAutocommit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SqlExecutorIsolationLevel getPropertyIsolation() {
		return propertyIsolation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPropertyIsolation(SqlExecutorIsolationLevel newPropertyIsolation) {
		SqlExecutorIsolationLevel oldPropertyIsolation = propertyIsolation;
		propertyIsolation = newPropertyIsolation == null ? PROPERTY_ISOLATION_EDEFAULT : newPropertyIsolation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_ISOLATION, oldPropertyIsolation, propertyIsolation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getPropertyMaxactive() {
		return propertyMaxactive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPropertyMaxactive(int newPropertyMaxactive) {
		int oldPropertyMaxactive = propertyMaxactive;
		propertyMaxactive = newPropertyMaxactive;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_MAXACTIVE, oldPropertyMaxactive, propertyMaxactive));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getPropertyMaxidle() {
		return propertyMaxidle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPropertyMaxidle(int newPropertyMaxidle) {
		int oldPropertyMaxidle = propertyMaxidle;
		propertyMaxidle = newPropertyMaxidle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_MAXIDLE, oldPropertyMaxidle, propertyMaxidle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getPropertyMaxopenstatements() {
		return propertyMaxopenstatements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPropertyMaxopenstatements(int newPropertyMaxopenstatements) {
		int oldPropertyMaxopenstatements = propertyMaxopenstatements;
		propertyMaxopenstatements = newPropertyMaxopenstatements;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_MAXOPENSTATEMENTS, oldPropertyMaxopenstatements, propertyMaxopenstatements));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getPropertyMaxwait() {
		return propertyMaxwait;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPropertyMaxwait(int newPropertyMaxwait) {
		int oldPropertyMaxwait = propertyMaxwait;
		propertyMaxwait = newPropertyMaxwait;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_MAXWAIT, oldPropertyMaxwait, propertyMaxwait));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getPropertyMinidle() {
		return propertyMinidle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPropertyMinidle(int newPropertyMinidle) {
		int oldPropertyMinidle = propertyMinidle;
		propertyMinidle = newPropertyMinidle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_MINIDLE, oldPropertyMinidle, propertyMinidle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SqlExecutorBooleanValue getPropertyPoolstatements() {
		return propertyPoolstatements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPropertyPoolstatements(SqlExecutorBooleanValue newPropertyPoolstatements) {
		SqlExecutorBooleanValue oldPropertyPoolstatements = propertyPoolstatements;
		propertyPoolstatements = newPropertyPoolstatements == null ? PROPERTY_POOLSTATEMENTS_EDEFAULT : newPropertyPoolstatements;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_POOLSTATEMENTS, oldPropertyPoolstatements, propertyPoolstatements));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SqlExecutorBooleanValue getPropertyTestonborrow() {
		return propertyTestonborrow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPropertyTestonborrow(SqlExecutorBooleanValue newPropertyTestonborrow) {
		SqlExecutorBooleanValue oldPropertyTestonborrow = propertyTestonborrow;
		propertyTestonborrow = newPropertyTestonborrow == null ? PROPERTY_TESTONBORROW_EDEFAULT : newPropertyTestonborrow;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_TESTONBORROW, oldPropertyTestonborrow, propertyTestonborrow));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SqlExecutorBooleanValue getPropertyTestwhileidle() {
		return propertyTestwhileidle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPropertyTestwhileidle(SqlExecutorBooleanValue newPropertyTestwhileidle) {
		SqlExecutorBooleanValue oldPropertyTestwhileidle = propertyTestwhileidle;
		propertyTestwhileidle = newPropertyTestwhileidle == null ? PROPERTY_TESTWHILEIDLE_EDEFAULT : newPropertyTestwhileidle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_TESTWHILEIDLE, oldPropertyTestwhileidle, propertyTestwhileidle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPropertyValidationquery() {
		return propertyValidationquery;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPropertyValidationquery(String newPropertyValidationquery) {
		String oldPropertyValidationquery = propertyValidationquery;
		propertyValidationquery = newPropertyValidationquery;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_VALIDATIONQUERY, oldPropertyValidationquery, propertyValidationquery));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getPropertyInitialsize() {
		return propertyInitialsize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPropertyInitialsize(int newPropertyInitialsize) {
		int oldPropertyInitialsize = propertyInitialsize;
		propertyInitialsize = newPropertyInitialsize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_INITIALSIZE, oldPropertyInitialsize, propertyInitialsize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SqlStatement> getSqlStatements() {
		if (sqlStatements == null) {
			sqlStatements = new EObjectContainmentEList<SqlStatement>(SqlStatement.class, this, EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__SQL_STATEMENTS);
		}
		return sqlStatements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__SQL_STATEMENTS:
				return ((InternalEList<?>)getSqlStatements()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_TYPE:
				return getConnectionType();
			case EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_DS_TYPE:
				return getConnectionDsType();
			case EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_DB_DRIVER:
				return getConnectionDbDriver();
			case EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_DS_INITIAL_CONTEXT:
				return getConnectionDsInitialContext();
			case EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_DS_NAME:
				return getConnectionDsName();
			case EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_URL:
				return getConnectionURL();
			case EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_USERNAME:
				return getConnectionUsername();
			case EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_PASSWORD:
				return getConnectionPassword();
			case EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_AUTOCOMMIT:
				return getPropertyAutocommit();
			case EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_ISOLATION:
				return getPropertyIsolation();
			case EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_MAXACTIVE:
				return getPropertyMaxactive();
			case EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_MAXIDLE:
				return getPropertyMaxidle();
			case EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_MAXOPENSTATEMENTS:
				return getPropertyMaxopenstatements();
			case EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_MAXWAIT:
				return getPropertyMaxwait();
			case EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_MINIDLE:
				return getPropertyMinidle();
			case EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_POOLSTATEMENTS:
				return getPropertyPoolstatements();
			case EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_TESTONBORROW:
				return getPropertyTestonborrow();
			case EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_TESTWHILEIDLE:
				return getPropertyTestwhileidle();
			case EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_VALIDATIONQUERY:
				return getPropertyValidationquery();
			case EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_INITIALSIZE:
				return getPropertyInitialsize();
			case EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__SQL_STATEMENTS:
				return getSqlStatements();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_TYPE:
				setConnectionType((SqlExecutorConnectionType)newValue);
				return;
			case EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_DS_TYPE:
				setConnectionDsType((SqlExecutorDatasourceType)newValue);
				return;
			case EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_DB_DRIVER:
				setConnectionDbDriver((String)newValue);
				return;
			case EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_DS_INITIAL_CONTEXT:
				setConnectionDsInitialContext((String)newValue);
				return;
			case EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_DS_NAME:
				setConnectionDsName((String)newValue);
				return;
			case EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_URL:
				setConnectionURL((String)newValue);
				return;
			case EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_USERNAME:
				setConnectionUsername((String)newValue);
				return;
			case EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_PASSWORD:
				setConnectionPassword((String)newValue);
				return;
			case EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_AUTOCOMMIT:
				setPropertyAutocommit((SqlExecutorBooleanValue)newValue);
				return;
			case EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_ISOLATION:
				setPropertyIsolation((SqlExecutorIsolationLevel)newValue);
				return;
			case EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_MAXACTIVE:
				setPropertyMaxactive((Integer)newValue);
				return;
			case EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_MAXIDLE:
				setPropertyMaxidle((Integer)newValue);
				return;
			case EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_MAXOPENSTATEMENTS:
				setPropertyMaxopenstatements((Integer)newValue);
				return;
			case EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_MAXWAIT:
				setPropertyMaxwait((Integer)newValue);
				return;
			case EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_MINIDLE:
				setPropertyMinidle((Integer)newValue);
				return;
			case EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_POOLSTATEMENTS:
				setPropertyPoolstatements((SqlExecutorBooleanValue)newValue);
				return;
			case EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_TESTONBORROW:
				setPropertyTestonborrow((SqlExecutorBooleanValue)newValue);
				return;
			case EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_TESTWHILEIDLE:
				setPropertyTestwhileidle((SqlExecutorBooleanValue)newValue);
				return;
			case EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_VALIDATIONQUERY:
				setPropertyValidationquery((String)newValue);
				return;
			case EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_INITIALSIZE:
				setPropertyInitialsize((Integer)newValue);
				return;
			case EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__SQL_STATEMENTS:
				getSqlStatements().clear();
				getSqlStatements().addAll((Collection<? extends SqlStatement>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_TYPE:
				setConnectionType(CONNECTION_TYPE_EDEFAULT);
				return;
			case EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_DS_TYPE:
				setConnectionDsType(CONNECTION_DS_TYPE_EDEFAULT);
				return;
			case EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_DB_DRIVER:
				setConnectionDbDriver(CONNECTION_DB_DRIVER_EDEFAULT);
				return;
			case EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_DS_INITIAL_CONTEXT:
				setConnectionDsInitialContext(CONNECTION_DS_INITIAL_CONTEXT_EDEFAULT);
				return;
			case EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_DS_NAME:
				setConnectionDsName(CONNECTION_DS_NAME_EDEFAULT);
				return;
			case EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_URL:
				setConnectionURL(CONNECTION_URL_EDEFAULT);
				return;
			case EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_USERNAME:
				setConnectionUsername(CONNECTION_USERNAME_EDEFAULT);
				return;
			case EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_PASSWORD:
				setConnectionPassword(CONNECTION_PASSWORD_EDEFAULT);
				return;
			case EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_AUTOCOMMIT:
				setPropertyAutocommit(PROPERTY_AUTOCOMMIT_EDEFAULT);
				return;
			case EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_ISOLATION:
				setPropertyIsolation(PROPERTY_ISOLATION_EDEFAULT);
				return;
			case EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_MAXACTIVE:
				setPropertyMaxactive(PROPERTY_MAXACTIVE_EDEFAULT);
				return;
			case EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_MAXIDLE:
				setPropertyMaxidle(PROPERTY_MAXIDLE_EDEFAULT);
				return;
			case EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_MAXOPENSTATEMENTS:
				setPropertyMaxopenstatements(PROPERTY_MAXOPENSTATEMENTS_EDEFAULT);
				return;
			case EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_MAXWAIT:
				setPropertyMaxwait(PROPERTY_MAXWAIT_EDEFAULT);
				return;
			case EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_MINIDLE:
				setPropertyMinidle(PROPERTY_MINIDLE_EDEFAULT);
				return;
			case EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_POOLSTATEMENTS:
				setPropertyPoolstatements(PROPERTY_POOLSTATEMENTS_EDEFAULT);
				return;
			case EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_TESTONBORROW:
				setPropertyTestonborrow(PROPERTY_TESTONBORROW_EDEFAULT);
				return;
			case EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_TESTWHILEIDLE:
				setPropertyTestwhileidle(PROPERTY_TESTWHILEIDLE_EDEFAULT);
				return;
			case EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_VALIDATIONQUERY:
				setPropertyValidationquery(PROPERTY_VALIDATIONQUERY_EDEFAULT);
				return;
			case EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_INITIALSIZE:
				setPropertyInitialsize(PROPERTY_INITIALSIZE_EDEFAULT);
				return;
			case EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__SQL_STATEMENTS:
				getSqlStatements().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_TYPE:
				return connectionType != CONNECTION_TYPE_EDEFAULT;
			case EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_DS_TYPE:
				return connectionDsType != CONNECTION_DS_TYPE_EDEFAULT;
			case EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_DB_DRIVER:
				return CONNECTION_DB_DRIVER_EDEFAULT == null ? connectionDbDriver != null : !CONNECTION_DB_DRIVER_EDEFAULT.equals(connectionDbDriver);
			case EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_DS_INITIAL_CONTEXT:
				return CONNECTION_DS_INITIAL_CONTEXT_EDEFAULT == null ? connectionDsInitialContext != null : !CONNECTION_DS_INITIAL_CONTEXT_EDEFAULT.equals(connectionDsInitialContext);
			case EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_DS_NAME:
				return CONNECTION_DS_NAME_EDEFAULT == null ? connectionDsName != null : !CONNECTION_DS_NAME_EDEFAULT.equals(connectionDsName);
			case EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_URL:
				return CONNECTION_URL_EDEFAULT == null ? connectionURL != null : !CONNECTION_URL_EDEFAULT.equals(connectionURL);
			case EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_USERNAME:
				return CONNECTION_USERNAME_EDEFAULT == null ? connectionUsername != null : !CONNECTION_USERNAME_EDEFAULT.equals(connectionUsername);
			case EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__CONNECTION_PASSWORD:
				return CONNECTION_PASSWORD_EDEFAULT == null ? connectionPassword != null : !CONNECTION_PASSWORD_EDEFAULT.equals(connectionPassword);
			case EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_AUTOCOMMIT:
				return propertyAutocommit != PROPERTY_AUTOCOMMIT_EDEFAULT;
			case EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_ISOLATION:
				return propertyIsolation != PROPERTY_ISOLATION_EDEFAULT;
			case EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_MAXACTIVE:
				return propertyMaxactive != PROPERTY_MAXACTIVE_EDEFAULT;
			case EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_MAXIDLE:
				return propertyMaxidle != PROPERTY_MAXIDLE_EDEFAULT;
			case EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_MAXOPENSTATEMENTS:
				return propertyMaxopenstatements != PROPERTY_MAXOPENSTATEMENTS_EDEFAULT;
			case EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_MAXWAIT:
				return propertyMaxwait != PROPERTY_MAXWAIT_EDEFAULT;
			case EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_MINIDLE:
				return propertyMinidle != PROPERTY_MINIDLE_EDEFAULT;
			case EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_POOLSTATEMENTS:
				return propertyPoolstatements != PROPERTY_POOLSTATEMENTS_EDEFAULT;
			case EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_TESTONBORROW:
				return propertyTestonborrow != PROPERTY_TESTONBORROW_EDEFAULT;
			case EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_TESTWHILEIDLE:
				return propertyTestwhileidle != PROPERTY_TESTWHILEIDLE_EDEFAULT;
			case EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_VALIDATIONQUERY:
				return PROPERTY_VALIDATIONQUERY_EDEFAULT == null ? propertyValidationquery != null : !PROPERTY_VALIDATIONQUERY_EDEFAULT.equals(propertyValidationquery);
			case EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__PROPERTY_INITIALSIZE:
				return propertyInitialsize != PROPERTY_INITIALSIZE_EDEFAULT;
			case EsbPackage.ABSTRACT_SQL_EXECUTOR_MEDIATOR__SQL_STATEMENTS:
				return sqlStatements != null && !sqlStatements.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (connectionType: ");
		result.append(connectionType);
		result.append(", connectionDsType: ");
		result.append(connectionDsType);
		result.append(", connectionDbDriver: ");
		result.append(connectionDbDriver);
		result.append(", connectionDsInitialContext: ");
		result.append(connectionDsInitialContext);
		result.append(", connectionDsName: ");
		result.append(connectionDsName);
		result.append(", connectionURL: ");
		result.append(connectionURL);
		result.append(", connectionUsername: ");
		result.append(connectionUsername);
		result.append(", connectionPassword: ");
		result.append(connectionPassword);
		result.append(", propertyAutocommit: ");
		result.append(propertyAutocommit);
		result.append(", propertyIsolation: ");
		result.append(propertyIsolation);
		result.append(", propertyMaxactive: ");
		result.append(propertyMaxactive);
		result.append(", propertyMaxidle: ");
		result.append(propertyMaxidle);
		result.append(", propertyMaxopenstatements: ");
		result.append(propertyMaxopenstatements);
		result.append(", propertyMaxwait: ");
		result.append(propertyMaxwait);
		result.append(", propertyMinidle: ");
		result.append(propertyMinidle);
		result.append(", propertyPoolstatements: ");
		result.append(propertyPoolstatements);
		result.append(", propertyTestonborrow: ");
		result.append(propertyTestonborrow);
		result.append(", propertyTestwhileidle: ");
		result.append(propertyTestwhileidle);
		result.append(", propertyValidationquery: ");
		result.append(propertyValidationquery);
		result.append(", propertyInitialsize: ");
		result.append(propertyInitialsize);
		result.append(')');
		return result.toString();
	}

} //AbstractSqlExecutorMediatorImpl
