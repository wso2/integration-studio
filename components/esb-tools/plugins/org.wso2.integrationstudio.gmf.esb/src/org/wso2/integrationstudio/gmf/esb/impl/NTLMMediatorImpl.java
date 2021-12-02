/**
 * Copyright 2009-2012 WSO2, Inc. (http://wso2.com)
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
package org.wso2.integrationstudio.gmf.esb.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.wso2.integrationstudio.gmf.esb.EsbPackage;
import org.wso2.integrationstudio.gmf.esb.NTLMMediator;
import org.wso2.integrationstudio.gmf.esb.NTLMMediatorInputConnector;
import org.wso2.integrationstudio.gmf.esb.NTLMMediatorOutputConnector;
import org.wso2.integrationstudio.gmf.esb.NamespacedProperty;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>NTLM Mediator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.wso2.integrationstudio.gmf.esb.impl.NTLMMediatorImpl#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.gmf.esb.impl.NTLMMediatorImpl#getOutputConnector <em>Output Connector</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.gmf.esb.impl.NTLMMediatorImpl#getUsername <em>Username</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.gmf.esb.impl.NTLMMediatorImpl#getPassword <em>Password</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.gmf.esb.impl.NTLMMediatorImpl#getHost <em>Host</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.gmf.esb.impl.NTLMMediatorImpl#getDomain <em>Domain</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.gmf.esb.impl.NTLMMediatorImpl#getNtlmVersion <em>Ntlm Version</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.gmf.esb.impl.NTLMMediatorImpl#getUsernameExpression <em>Username Expression</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.gmf.esb.impl.NTLMMediatorImpl#getPasswordExpression <em>Password Expression</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.gmf.esb.impl.NTLMMediatorImpl#getHostExpression <em>Host Expression</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.gmf.esb.impl.NTLMMediatorImpl#getDomainExpression <em>Domain Expression</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.gmf.esb.impl.NTLMMediatorImpl#getNtlmVersionExpression <em>Ntlm Version Expression</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NTLMMediatorImpl extends MediatorImpl implements NTLMMediator {
    /**
     * The cached value of the '{@link #getInputConnector() <em>Input Connector</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInputConnector()
     * @generated
     * @ordered
     */
    protected NTLMMediatorInputConnector inputConnector;

    /**
     * The cached value of the '{@link #getOutputConnector() <em>Output Connector</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOutputConnector()
     * @generated
     * @ordered
     */
    protected NTLMMediatorOutputConnector outputConnector;

    /**
     * The default value of the '{@link #getUsername() <em>Username</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getUsername()
     * @generated
     * @ordered
     */
    protected static final String USERNAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getUsername() <em>Username</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getUsername()
     * @generated
     * @ordered
     */
    protected String username = USERNAME_EDEFAULT;

    /**
     * The default value of the '{@link #getPassword() <em>Password</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPassword()
     * @generated
     * @ordered
     */
    protected static final String PASSWORD_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getPassword() <em>Password</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPassword()
     * @generated
     * @ordered
     */
    protected String password = PASSWORD_EDEFAULT;

    /**
     * The default value of the '{@link #getHost() <em>Host</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getHost()
     * @generated
     * @ordered
     */
    protected static final String HOST_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getHost() <em>Host</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getHost()
     * @generated
     * @ordered
     */
    protected String host = HOST_EDEFAULT;

    /**
     * The default value of the '{@link #getDomain() <em>Domain</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDomain()
     * @generated
     * @ordered
     */
    protected static final String DOMAIN_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getDomain() <em>Domain</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDomain()
     * @generated
     * @ordered
     */
    protected String domain = DOMAIN_EDEFAULT;

    /**
     * The default value of the '{@link #getNtlmVersion() <em>Ntlm Version</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getNtlmVersion()
     * @generated
     * @ordered
     */
    protected static final String NTLM_VERSION_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getNtlmVersion() <em>Ntlm Version</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getNtlmVersion()
     * @generated
     * @ordered
     */
    protected String ntlmVersion = NTLM_VERSION_EDEFAULT;

    /**
     * The cached value of the '{@link #getUsernameExpression() <em>Username Expression</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getUsernameExpression()
     * @generated
     * @ordered
     */
    protected NamespacedProperty usernameExpression;

    /**
     * The cached value of the '{@link #getPasswordExpression() <em>Password Expression</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPasswordExpression()
     * @generated
     * @ordered
     */
    protected NamespacedProperty passwordExpression;

    /**
     * The cached value of the '{@link #getHostExpression() <em>Host Expression</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getHostExpression()
     * @generated
     * @ordered
     */
    protected NamespacedProperty hostExpression;

    /**
     * The cached value of the '{@link #getDomainExpression() <em>Domain Expression</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDomainExpression()
     * @generated
     * @ordered
     */
    protected NamespacedProperty domainExpression;

    /**
     * The cached value of the '{@link #getNtlmVersionExpression() <em>Ntlm Version Expression</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getNtlmVersionExpression()
     * @generated
     * @ordered
     */
    protected NamespacedProperty ntlmVersionExpression;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected NTLMMediatorImpl() {
        super();

        setUsernameExpression(createNamespacedProperty());
        setPasswordExpression(createNamespacedProperty());
        setHostExpression(createNamespacedProperty());
        setDomainExpression(createNamespacedProperty());
        setNtlmVersionExpression(createNamespacedProperty());
    }

    private NamespacedProperty createNamespacedProperty() {
        NamespacedProperty expression = EsbFactoryImpl.eINSTANCE.createNamespacedProperty();
        expression.setPrettyName("Property Expression");
        expression.setPropertyName("expression");
        expression.setSupportJsonPaths(true);
        expression.setPropertyValue(DEFAULT_EXPRESSION_PROPERTY_VALUE);
        return expression;
    }
    
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return EsbPackage.Literals.NTLM_MEDIATOR;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NTLMMediatorInputConnector getInputConnector() {
        return inputConnector;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetInputConnector(NTLMMediatorInputConnector newInputConnector, NotificationChain msgs) {
        NTLMMediatorInputConnector oldInputConnector = inputConnector;
        inputConnector = newInputConnector;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.NTLM_MEDIATOR__INPUT_CONNECTOR, oldInputConnector, newInputConnector);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setInputConnector(NTLMMediatorInputConnector newInputConnector) {
        if (newInputConnector != inputConnector) {
            NotificationChain msgs = null;
            if (inputConnector != null)
                msgs = ((InternalEObject)inputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.NTLM_MEDIATOR__INPUT_CONNECTOR, null, msgs);
            if (newInputConnector != null)
                msgs = ((InternalEObject)newInputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.NTLM_MEDIATOR__INPUT_CONNECTOR, null, msgs);
            msgs = basicSetInputConnector(newInputConnector, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.NTLM_MEDIATOR__INPUT_CONNECTOR, newInputConnector, newInputConnector));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NTLMMediatorOutputConnector getOutputConnector() {
        return outputConnector;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetOutputConnector(NTLMMediatorOutputConnector newOutputConnector, NotificationChain msgs) {
        NTLMMediatorOutputConnector oldOutputConnector = outputConnector;
        outputConnector = newOutputConnector;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.NTLM_MEDIATOR__OUTPUT_CONNECTOR, oldOutputConnector, newOutputConnector);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setOutputConnector(NTLMMediatorOutputConnector newOutputConnector) {
        if (newOutputConnector != outputConnector) {
            NotificationChain msgs = null;
            if (outputConnector != null)
                msgs = ((InternalEObject)outputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.NTLM_MEDIATOR__OUTPUT_CONNECTOR, null, msgs);
            if (newOutputConnector != null)
                msgs = ((InternalEObject)newOutputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.NTLM_MEDIATOR__OUTPUT_CONNECTOR, null, msgs);
            msgs = basicSetOutputConnector(newOutputConnector, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.NTLM_MEDIATOR__OUTPUT_CONNECTOR, newOutputConnector, newOutputConnector));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getUsername() {
        return username;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setUsername(String newUsername) {
        String oldUsername = username;
        username = newUsername;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.NTLM_MEDIATOR__USERNAME, oldUsername, username));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getPassword() {
        return password;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setPassword(String newPassword) {
        String oldPassword = password;
        password = newPassword;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.NTLM_MEDIATOR__PASSWORD, oldPassword, password));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getHost() {
        return host;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setHost(String newHost) {
        String oldHost = host;
        host = newHost;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.NTLM_MEDIATOR__HOST, oldHost, host));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getDomain() {
        return domain;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDomain(String newDomain) {
        String oldDomain = domain;
        domain = newDomain;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.NTLM_MEDIATOR__DOMAIN, oldDomain, domain));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getNtlmVersion() {
        return ntlmVersion;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setNtlmVersion(String newNtlmVersion) {
        String oldNtlmVersion = ntlmVersion;
        ntlmVersion = newNtlmVersion;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.NTLM_MEDIATOR__NTLM_VERSION, oldNtlmVersion, ntlmVersion));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NamespacedProperty getUsernameExpression() {
        if (usernameExpression != null && usernameExpression.eIsProxy()) {
            InternalEObject oldUsernameExpression = (InternalEObject)usernameExpression;
            usernameExpression = (NamespacedProperty)eResolveProxy(oldUsernameExpression);
            if (usernameExpression != oldUsernameExpression) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, EsbPackage.NTLM_MEDIATOR__USERNAME_EXPRESSION, oldUsernameExpression, usernameExpression));
            }
        }
        return usernameExpression;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NamespacedProperty basicGetUsernameExpression() {
        return usernameExpression;
    }

    public NotificationChain basicSetUsernameExpression(NamespacedProperty newExpression, NotificationChain msgs) {
        NamespacedProperty oldExpression = usernameExpression;
        usernameExpression = newExpression;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
                    EsbPackage.NTLM_MEDIATOR__USERNAME_EXPRESSION, oldExpression, newExpression);
            if (msgs == null)
                msgs = notification;
            else
                msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public void setUsernameExpression(NamespacedProperty newExpression) {
        if (newExpression != usernameExpression) {
            NotificationChain msgs = null;
            if (usernameExpression != null)
                msgs = ((InternalEObject) usernameExpression).eInverseRemove(this,
                        EOPPOSITE_FEATURE_BASE - EsbPackage.NTLM_MEDIATOR__USERNAME_EXPRESSION, null, msgs);
            if (newExpression != null)
                msgs = ((InternalEObject) newExpression).eInverseAdd(this,
                        EOPPOSITE_FEATURE_BASE - EsbPackage.NTLM_MEDIATOR__USERNAME_EXPRESSION, null, msgs);
            msgs = basicSetUsernameExpression(newExpression, msgs);
            if (msgs != null)
                msgs.dispatch();
        } else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.NTLM_MEDIATOR__USERNAME_EXPRESSION,
                    newExpression, newExpression));

    }
    
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NamespacedProperty getPasswordExpression() {
        if (passwordExpression != null && passwordExpression.eIsProxy()) {
            InternalEObject oldPasswordExpression = (InternalEObject)passwordExpression;
            passwordExpression = (NamespacedProperty)eResolveProxy(oldPasswordExpression);
            if (passwordExpression != oldPasswordExpression) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, EsbPackage.NTLM_MEDIATOR__PASSWORD_EXPRESSION, oldPasswordExpression, passwordExpression));
            }
        }
        return passwordExpression;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NamespacedProperty basicGetPasswordExpression() {
        return passwordExpression;
    }

    public NotificationChain basicSetPasswordExpression(NamespacedProperty newExpression, NotificationChain msgs) {
        NamespacedProperty oldExpression = passwordExpression;
        passwordExpression = newExpression;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
                    EsbPackage.NTLM_MEDIATOR__PASSWORD_EXPRESSION, oldExpression, newExpression);
            if (msgs == null)
                msgs = notification;
            else
                msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public void setPasswordExpression(NamespacedProperty newExpression) {
        if (newExpression != passwordExpression) {
            NotificationChain msgs = null;
            if (passwordExpression != null)
                msgs = ((InternalEObject) passwordExpression).eInverseRemove(this,
                        EOPPOSITE_FEATURE_BASE - EsbPackage.NTLM_MEDIATOR__PASSWORD_EXPRESSION, null, msgs);
            if (newExpression != null)
                msgs = ((InternalEObject) newExpression).eInverseAdd(this,
                        EOPPOSITE_FEATURE_BASE - EsbPackage.NTLM_MEDIATOR__PASSWORD_EXPRESSION, null, msgs);
            msgs = basicSetPasswordExpression(newExpression, msgs);
            if (msgs != null)
                msgs.dispatch();
        } else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.NTLM_MEDIATOR__PASSWORD_EXPRESSION,
                    newExpression, newExpression));

    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NamespacedProperty getHostExpression() {
        if (hostExpression != null && hostExpression.eIsProxy()) {
            InternalEObject oldHostExpression = (InternalEObject)hostExpression;
            hostExpression = (NamespacedProperty)eResolveProxy(oldHostExpression);
            if (hostExpression != oldHostExpression) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, EsbPackage.NTLM_MEDIATOR__HOST_EXPRESSION, oldHostExpression, hostExpression));
            }
        }
        return hostExpression;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NamespacedProperty basicGetHostExpression() {
        return hostExpression;
    }

    public NotificationChain basicSetHostExpression(NamespacedProperty newExpression, NotificationChain msgs) {
        NamespacedProperty oldExpression = hostExpression;
        hostExpression = newExpression;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
                    EsbPackage.NTLM_MEDIATOR__HOST_EXPRESSION, oldExpression, newExpression);
            if (msgs == null)
                msgs = notification;
            else
                msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public void setHostExpression(NamespacedProperty newExpression) {
        if (newExpression != hostExpression) {
            NotificationChain msgs = null;
            if (hostExpression != null)
                msgs = ((InternalEObject) hostExpression).eInverseRemove(this,
                        EOPPOSITE_FEATURE_BASE - EsbPackage.NTLM_MEDIATOR__HOST_EXPRESSION, null, msgs);
            if (newExpression != null)
                msgs = ((InternalEObject) newExpression).eInverseAdd(this,
                        EOPPOSITE_FEATURE_BASE - EsbPackage.NTLM_MEDIATOR__HOST_EXPRESSION, null, msgs);
            msgs = basicSetHostExpression(newExpression, msgs);
            if (msgs != null)
                msgs.dispatch();
        } else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.NTLM_MEDIATOR__HOST_EXPRESSION,
                    newExpression, newExpression));

    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NamespacedProperty getDomainExpression() {
        if (domainExpression != null && domainExpression.eIsProxy()) {
            InternalEObject oldDomainExpression = (InternalEObject)domainExpression;
            domainExpression = (NamespacedProperty)eResolveProxy(oldDomainExpression);
            if (domainExpression != oldDomainExpression) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, EsbPackage.NTLM_MEDIATOR__DOMAIN_EXPRESSION, oldDomainExpression, domainExpression));
            }
        }
        return domainExpression;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NamespacedProperty basicGetDomainExpression() {
        return domainExpression;
    }

    public NotificationChain basicSetDomainExpression(NamespacedProperty newExpression, NotificationChain msgs) {
        NamespacedProperty oldExpression = domainExpression;
        domainExpression = newExpression;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
                    EsbPackage.NTLM_MEDIATOR__DOMAIN_EXPRESSION, oldExpression, newExpression);
            if (msgs == null)
                msgs = notification;
            else
                msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public void setDomainExpression(NamespacedProperty newExpression) {
        if (newExpression != domainExpression) {
            NotificationChain msgs = null;
            if (domainExpression != null)
                msgs = ((InternalEObject) domainExpression).eInverseRemove(this,
                        EOPPOSITE_FEATURE_BASE - EsbPackage.NTLM_MEDIATOR__DOMAIN_EXPRESSION, null, msgs);
            if (newExpression != null)
                msgs = ((InternalEObject) newExpression).eInverseAdd(this,
                        EOPPOSITE_FEATURE_BASE - EsbPackage.NTLM_MEDIATOR__DOMAIN_EXPRESSION, null, msgs);
            msgs = basicSetDomainExpression(newExpression, msgs);
            if (msgs != null)
                msgs.dispatch();
        } else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.NTLM_MEDIATOR__DOMAIN_EXPRESSION,
                    newExpression, newExpression));

    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NamespacedProperty getNtlmVersionExpression() {
        if (ntlmVersionExpression != null && ntlmVersionExpression.eIsProxy()) {
            InternalEObject oldNtlmVersionExpression = (InternalEObject)ntlmVersionExpression;
            ntlmVersionExpression = (NamespacedProperty)eResolveProxy(oldNtlmVersionExpression);
            if (ntlmVersionExpression != oldNtlmVersionExpression) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, EsbPackage.NTLM_MEDIATOR__NTLM_VERSION_EXPRESSION, oldNtlmVersionExpression, ntlmVersionExpression));
            }
        }
        return ntlmVersionExpression;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NamespacedProperty basicGetNtlmVersionExpression() {
        return ntlmVersionExpression;
    }

    
    public NotificationChain basicSetNtlmVersionExpression(NamespacedProperty newExpression, NotificationChain msgs) {
        NamespacedProperty oldExpression = ntlmVersionExpression;
        ntlmVersionExpression = newExpression;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
                    EsbPackage.NTLM_MEDIATOR__NTLM_VERSION_EXPRESSION, oldExpression, newExpression);
            if (msgs == null)
                msgs = notification;
            else
                msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public void setNtlmVersionExpression(NamespacedProperty newExpression) {
        if (newExpression != ntlmVersionExpression) {
            NotificationChain msgs = null;
            if (ntlmVersionExpression != null)
                msgs = ((InternalEObject) ntlmVersionExpression).eInverseRemove(this,
                        EOPPOSITE_FEATURE_BASE - EsbPackage.NTLM_MEDIATOR__NTLM_VERSION_EXPRESSION, null, msgs);
            if (newExpression != null)
                msgs = ((InternalEObject) newExpression).eInverseAdd(this,
                        EOPPOSITE_FEATURE_BASE - EsbPackage.NTLM_MEDIATOR__NTLM_VERSION_EXPRESSION, null, msgs);
            msgs = basicSetNtlmVersionExpression(newExpression, msgs);
            if (msgs != null)
                msgs.dispatch();
        } else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.NTLM_MEDIATOR__NTLM_VERSION_EXPRESSION,
                    newExpression, newExpression));

    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case EsbPackage.NTLM_MEDIATOR__INPUT_CONNECTOR:
                return basicSetInputConnector(null, msgs);
            case EsbPackage.NTLM_MEDIATOR__OUTPUT_CONNECTOR:
                return basicSetOutputConnector(null, msgs);
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
            case EsbPackage.NTLM_MEDIATOR__INPUT_CONNECTOR:
                return getInputConnector();
            case EsbPackage.NTLM_MEDIATOR__OUTPUT_CONNECTOR:
                return getOutputConnector();
            case EsbPackage.NTLM_MEDIATOR__USERNAME:
                return getUsername();
            case EsbPackage.NTLM_MEDIATOR__PASSWORD:
                return getPassword();
            case EsbPackage.NTLM_MEDIATOR__HOST:
                return getHost();
            case EsbPackage.NTLM_MEDIATOR__DOMAIN:
                return getDomain();
            case EsbPackage.NTLM_MEDIATOR__NTLM_VERSION:
                return getNtlmVersion();
            case EsbPackage.NTLM_MEDIATOR__USERNAME_EXPRESSION:
                return basicGetUsernameExpression();
            case EsbPackage.NTLM_MEDIATOR__PASSWORD_EXPRESSION:
                return basicGetPasswordExpression();
            case EsbPackage.NTLM_MEDIATOR__HOST_EXPRESSION:
                return basicGetHostExpression();
            case EsbPackage.NTLM_MEDIATOR__DOMAIN_EXPRESSION:
                return basicGetDomainExpression();
            case EsbPackage.NTLM_MEDIATOR__NTLM_VERSION_EXPRESSION:
                return basicGetNtlmVersionExpression();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case EsbPackage.NTLM_MEDIATOR__INPUT_CONNECTOR:
                setInputConnector((NTLMMediatorInputConnector)newValue);
                return;
            case EsbPackage.NTLM_MEDIATOR__OUTPUT_CONNECTOR:
                setOutputConnector((NTLMMediatorOutputConnector)newValue);
                return;
            case EsbPackage.NTLM_MEDIATOR__USERNAME:
                setUsername((String)newValue);
                return;
            case EsbPackage.NTLM_MEDIATOR__PASSWORD:
                setPassword((String)newValue);
                return;
            case EsbPackage.NTLM_MEDIATOR__HOST:
                setHost((String)newValue);
                return;
            case EsbPackage.NTLM_MEDIATOR__DOMAIN:
                setDomain((String)newValue);
                return;
            case EsbPackage.NTLM_MEDIATOR__NTLM_VERSION:
                setNtlmVersion((String)newValue);
                return;
            case EsbPackage.NTLM_MEDIATOR__USERNAME_EXPRESSION:
                setUsernameExpression((NamespacedProperty)newValue);
                return;
            case EsbPackage.NTLM_MEDIATOR__PASSWORD_EXPRESSION:
                setPasswordExpression((NamespacedProperty)newValue);
                return;
            case EsbPackage.NTLM_MEDIATOR__HOST_EXPRESSION:
                setHostExpression((NamespacedProperty)newValue);
                return;
            case EsbPackage.NTLM_MEDIATOR__DOMAIN_EXPRESSION:
                setDomainExpression((NamespacedProperty)newValue);
                return;
            case EsbPackage.NTLM_MEDIATOR__NTLM_VERSION_EXPRESSION:
                setNtlmVersionExpression((NamespacedProperty)newValue);
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
            case EsbPackage.NTLM_MEDIATOR__INPUT_CONNECTOR:
                setInputConnector((NTLMMediatorInputConnector)null);
                return;
            case EsbPackage.NTLM_MEDIATOR__OUTPUT_CONNECTOR:
                setOutputConnector((NTLMMediatorOutputConnector)null);
                return;
            case EsbPackage.NTLM_MEDIATOR__USERNAME:
                setUsername(USERNAME_EDEFAULT);
                return;
            case EsbPackage.NTLM_MEDIATOR__PASSWORD:
                setPassword(PASSWORD_EDEFAULT);
                return;
            case EsbPackage.NTLM_MEDIATOR__HOST:
                setHost(HOST_EDEFAULT);
                return;
            case EsbPackage.NTLM_MEDIATOR__DOMAIN:
                setDomain(DOMAIN_EDEFAULT);
                return;
            case EsbPackage.NTLM_MEDIATOR__NTLM_VERSION:
                setNtlmVersion(NTLM_VERSION_EDEFAULT);
                return;
            case EsbPackage.NTLM_MEDIATOR__USERNAME_EXPRESSION:
                setUsernameExpression((NamespacedProperty)null);
                return;
            case EsbPackage.NTLM_MEDIATOR__PASSWORD_EXPRESSION:
                setPasswordExpression((NamespacedProperty)null);
                return;
            case EsbPackage.NTLM_MEDIATOR__HOST_EXPRESSION:
                setHostExpression((NamespacedProperty)null);
                return;
            case EsbPackage.NTLM_MEDIATOR__DOMAIN_EXPRESSION:
                setDomainExpression((NamespacedProperty)null);
                return;
            case EsbPackage.NTLM_MEDIATOR__NTLM_VERSION_EXPRESSION:
                setNtlmVersionExpression((NamespacedProperty)null);
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
            case EsbPackage.NTLM_MEDIATOR__INPUT_CONNECTOR:
                return inputConnector != null;
            case EsbPackage.NTLM_MEDIATOR__OUTPUT_CONNECTOR:
                return outputConnector != null;
            case EsbPackage.NTLM_MEDIATOR__USERNAME:
                return USERNAME_EDEFAULT == null ? username != null : !USERNAME_EDEFAULT.equals(username);
            case EsbPackage.NTLM_MEDIATOR__PASSWORD:
                return PASSWORD_EDEFAULT == null ? password != null : !PASSWORD_EDEFAULT.equals(password);
            case EsbPackage.NTLM_MEDIATOR__HOST:
                return HOST_EDEFAULT == null ? host != null : !HOST_EDEFAULT.equals(host);
            case EsbPackage.NTLM_MEDIATOR__DOMAIN:
                return DOMAIN_EDEFAULT == null ? domain != null : !DOMAIN_EDEFAULT.equals(domain);
            case EsbPackage.NTLM_MEDIATOR__NTLM_VERSION:
                return NTLM_VERSION_EDEFAULT == null ? ntlmVersion != null : !NTLM_VERSION_EDEFAULT.equals(ntlmVersion);
            case EsbPackage.NTLM_MEDIATOR__USERNAME_EXPRESSION:
                return usernameExpression != null;
            case EsbPackage.NTLM_MEDIATOR__PASSWORD_EXPRESSION:
                return passwordExpression != null;
            case EsbPackage.NTLM_MEDIATOR__HOST_EXPRESSION:
                return hostExpression != null;
            case EsbPackage.NTLM_MEDIATOR__DOMAIN_EXPRESSION:
                return domainExpression != null;
            case EsbPackage.NTLM_MEDIATOR__NTLM_VERSION_EXPRESSION:
                return ntlmVersionExpression != null;
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

        StringBuilder result = new StringBuilder(super.toString());
        result.append(" (username: ");
        result.append(username);
        result.append(", password: ");
        result.append(password);
        result.append(", host: ");
        result.append(host);
        result.append(", domain: ");
        result.append(domain);
        result.append(", ntlmVersion: ");
        result.append(ntlmVersion);
        result.append(')');
        return result.toString();
    }

} //NTLMMediatorImpl
