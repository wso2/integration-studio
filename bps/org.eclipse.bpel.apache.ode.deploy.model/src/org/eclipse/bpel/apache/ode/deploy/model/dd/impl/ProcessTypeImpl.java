/*******************************************************************************
 * Copyright (c) 2008 IBM Corporation, University of Stuttgart (IAAS) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation, University of Stuttgart (IAAS) - initial API and implementation
 *******************************************************************************/

package org.eclipse.bpel.apache.ode.deploy.model.dd.impl;

import java.util.Collection;

import javax.xml.namespace.QName;

import org.eclipse.bpel.apache.ode.deploy.model.dd.MexInterceptorsType;
import org.eclipse.bpel.apache.ode.deploy.model.dd.ProcessType;
import org.eclipse.bpel.apache.ode.deploy.model.dd.PropertyType;
import org.eclipse.bpel.apache.ode.deploy.model.dd.TBamServerProfiles;
import org.eclipse.bpel.apache.ode.deploy.model.dd.TInvoke;
import org.eclipse.bpel.apache.ode.deploy.model.dd.TProcessEvents;
import org.eclipse.bpel.apache.ode.deploy.model.dd.TProvide;
import org.eclipse.bpel.apache.ode.deploy.model.dd.ddPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Process Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.bpel.apache.ode.deploy.model.dd.impl.ProcessTypeImpl#isActive <em>Active</em>}</li>
 *   <li>{@link org.eclipse.bpel.apache.ode.deploy.model.dd.impl.ProcessTypeImpl#isRetired <em>Retired</em>}</li>
 *   <li>{@link org.eclipse.bpel.apache.ode.deploy.model.dd.impl.ProcessTypeImpl#isInMemory <em>In Memory</em>}</li>
 *   <li>{@link org.eclipse.bpel.apache.ode.deploy.model.dd.impl.ProcessTypeImpl#getProperty <em>Property</em>}</li>
 *   <li>{@link org.eclipse.bpel.apache.ode.deploy.model.dd.impl.ProcessTypeImpl#getProcessEvents <em>Process Events</em>}</li>
 *   <li>{@link org.eclipse.bpel.apache.ode.deploy.model.dd.impl.ProcessTypeImpl#getProvide <em>Provide</em>}</li>
 *   <li>{@link org.eclipse.bpel.apache.ode.deploy.model.dd.impl.ProcessTypeImpl#getInvoke <em>Invoke</em>}</li>
 *   <li>{@link org.eclipse.bpel.apache.ode.deploy.model.dd.impl.ProcessTypeImpl#getMexInterceptors <em>Mex Interceptors</em>}</li>
 *   <li>{@link org.eclipse.bpel.apache.ode.deploy.model.dd.impl.ProcessTypeImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.bpel.apache.ode.deploy.model.dd.impl.ProcessTypeImpl#getBpel11wsdlFileName <em>Bpel11wsdl File Name</em>}</li>
 *   <li>{@link org.eclipse.bpel.apache.ode.deploy.model.dd.impl.ProcessTypeImpl#getFileName <em>File Name</em>}</li>
 *   <li>{@link org.eclipse.bpel.apache.ode.deploy.model.dd.impl.ProcessTypeImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.bpel.apache.ode.deploy.model.dd.impl.ProcessTypeImpl#getModel <em>Model</em>}</li>
 *   <li>{@link org.eclipse.bpel.apache.ode.deploy.model.dd.impl.ProcessTypeImpl#getBamServerProfiles <em>Bam Server Profiles</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProcessTypeImpl extends EObjectImpl implements ProcessType {
	/**
	 * The default value of the '{@link #isActive() <em>Active</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isActive()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ACTIVE_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isActive() <em>Active</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isActive()
	 * @generated
	 * @ordered
	 */
	protected boolean active = ACTIVE_EDEFAULT;

	/**
	 * This is true if the Active attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean activeESet;

	/**
	 * The default value of the '{@link #isRetired() <em>Retired</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRetired()
	 * @generated
	 * @ordered
	 */
	protected static final boolean RETIRED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isRetired() <em>Retired</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRetired()
	 * @generated
	 * @ordered
	 */
	protected boolean retired = RETIRED_EDEFAULT;

	/**
	 * This is true if the Retired attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean retiredESet;

	/**
	 * The default value of the '{@link #isInMemory() <em>In Memory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInMemory()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IN_MEMORY_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isInMemory() <em>In Memory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInMemory()
	 * @generated
	 * @ordered
	 */
	protected boolean inMemory = IN_MEMORY_EDEFAULT;

	/**
	 * This is true if the In Memory attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean inMemoryESet;

	/**
	 * The cached value of the '{@link #getProperty() <em>Property</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperty()
	 * @generated
	 * @ordered
	 */
	protected EList<PropertyType> property;

	/**
	 * The cached value of the '{@link #getProcessEvents() <em>Process Events</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcessEvents()
	 * @generated
	 * @ordered
	 */
	protected TProcessEvents processEvents;

	/**
	 * The cached value of the '{@link #getProvide() <em>Provide</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProvide()
	 * @generated
	 * @ordered
	 */
	protected EList<TProvide> provide;

	/**
	 * The cached value of the '{@link #getInvoke() <em>Invoke</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInvoke()
	 * @generated
	 * @ordered
	 */
	protected EList<TInvoke> invoke;

	/**
	 * The cached value of the '{@link #getMexInterceptors() <em>Mex Interceptors</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMexInterceptors()
	 * @generated
	 * @ordered
	 */
	protected MexInterceptorsType mexInterceptors;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final QName TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected QName type = TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getBpel11wsdlFileName() <em>Bpel11wsdl File Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBpel11wsdlFileName()
	 * @generated
	 * @ordered
	 */
	protected static final String BPEL11WSDL_FILE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBpel11wsdlFileName() <em>Bpel11wsdl File Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBpel11wsdlFileName()
	 * @generated
	 * @ordered
	 */
	protected String bpel11wsdlFileName = BPEL11WSDL_FILE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getFileName() <em>File Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFileName()
	 * @generated
	 * @ordered
	 */
	protected static final String FILE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFileName() <em>File Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFileName()
	 * @generated
	 * @ordered
	 */
	protected String fileName = FILE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final QName NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected QName name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getModel() <em>Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModel()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.bpel.model.Process model;

	/**
	 * The cached value of the '{@link #getBamServerProfiles() <em>Bam Server Profiles</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBamServerProfiles()
	 * @generated
	 * @ordered
	 */
	protected TBamServerProfiles bamServerProfiles;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProcessTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ddPackage.Literals.PROCESS_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActive(boolean newActive) {
		boolean oldActive = active;
		active = newActive;
		boolean oldActiveESet = activeESet;
		activeESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ddPackage.PROCESS_TYPE__ACTIVE, oldActive, active, !oldActiveESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetActive() {
		boolean oldActive = active;
		boolean oldActiveESet = activeESet;
		active = ACTIVE_EDEFAULT;
		activeESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ddPackage.PROCESS_TYPE__ACTIVE, oldActive, ACTIVE_EDEFAULT, oldActiveESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetActive() {
		return activeESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isRetired() {
		return retired;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRetired(boolean newRetired) {
		boolean oldRetired = retired;
		retired = newRetired;
		boolean oldRetiredESet = retiredESet;
		retiredESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ddPackage.PROCESS_TYPE__RETIRED, oldRetired, retired, !oldRetiredESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRetired() {
		boolean oldRetired = retired;
		boolean oldRetiredESet = retiredESet;
		retired = RETIRED_EDEFAULT;
		retiredESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ddPackage.PROCESS_TYPE__RETIRED, oldRetired, RETIRED_EDEFAULT, oldRetiredESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRetired() {
		return retiredESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isInMemory() {
		return inMemory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInMemory(boolean newInMemory) {
		boolean oldInMemory = inMemory;
		inMemory = newInMemory;
		boolean oldInMemoryESet = inMemoryESet;
		inMemoryESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ddPackage.PROCESS_TYPE__IN_MEMORY, oldInMemory, inMemory, !oldInMemoryESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetInMemory() {
		boolean oldInMemory = inMemory;
		boolean oldInMemoryESet = inMemoryESet;
		inMemory = IN_MEMORY_EDEFAULT;
		inMemoryESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ddPackage.PROCESS_TYPE__IN_MEMORY, oldInMemory, IN_MEMORY_EDEFAULT, oldInMemoryESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetInMemory() {
		return inMemoryESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PropertyType> getProperty() {
		if (property == null) {
			property = new EObjectContainmentEList<PropertyType>(PropertyType.class, this, ddPackage.PROCESS_TYPE__PROPERTY);
		}
		return property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TProcessEvents getProcessEvents() {
		return processEvents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetProcessEvents(TProcessEvents newProcessEvents, NotificationChain msgs) {
		TProcessEvents oldProcessEvents = processEvents;
		processEvents = newProcessEvents;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ddPackage.PROCESS_TYPE__PROCESS_EVENTS, oldProcessEvents, newProcessEvents);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProcessEvents(TProcessEvents newProcessEvents) {
		if (newProcessEvents != processEvents) {
			NotificationChain msgs = null;
			if (processEvents != null)
				msgs = ((InternalEObject)processEvents).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ddPackage.PROCESS_TYPE__PROCESS_EVENTS, null, msgs);
			if (newProcessEvents != null)
				msgs = ((InternalEObject)newProcessEvents).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ddPackage.PROCESS_TYPE__PROCESS_EVENTS, null, msgs);
			msgs = basicSetProcessEvents(newProcessEvents, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ddPackage.PROCESS_TYPE__PROCESS_EVENTS, newProcessEvents, newProcessEvents));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TProvide> getProvide() {
		if (provide == null) {
			provide = new EObjectContainmentEList<TProvide>(TProvide.class, this, ddPackage.PROCESS_TYPE__PROVIDE);
		}
		return provide;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TInvoke> getInvoke() {
		if (invoke == null) {
			invoke = new EObjectContainmentEList<TInvoke>(TInvoke.class, this, ddPackage.PROCESS_TYPE__INVOKE);
		}
		return invoke;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MexInterceptorsType getMexInterceptors() {
		return mexInterceptors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMexInterceptors(MexInterceptorsType newMexInterceptors, NotificationChain msgs) {
		MexInterceptorsType oldMexInterceptors = mexInterceptors;
		mexInterceptors = newMexInterceptors;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ddPackage.PROCESS_TYPE__MEX_INTERCEPTORS, oldMexInterceptors, newMexInterceptors);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMexInterceptors(MexInterceptorsType newMexInterceptors) {
		if (newMexInterceptors != mexInterceptors) {
			NotificationChain msgs = null;
			if (mexInterceptors != null)
				msgs = ((InternalEObject)mexInterceptors).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ddPackage.PROCESS_TYPE__MEX_INTERCEPTORS, null, msgs);
			if (newMexInterceptors != null)
				msgs = ((InternalEObject)newMexInterceptors).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ddPackage.PROCESS_TYPE__MEX_INTERCEPTORS, null, msgs);
			msgs = basicSetMexInterceptors(newMexInterceptors, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ddPackage.PROCESS_TYPE__MEX_INTERCEPTORS, newMexInterceptors, newMexInterceptors));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QName getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(QName newType) {
		QName oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ddPackage.PROCESS_TYPE__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBpel11wsdlFileName() {
		return bpel11wsdlFileName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBpel11wsdlFileName(String newBpel11wsdlFileName) {
		String oldBpel11wsdlFileName = bpel11wsdlFileName;
		bpel11wsdlFileName = newBpel11wsdlFileName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ddPackage.PROCESS_TYPE__BPEL11WSDL_FILE_NAME, oldBpel11wsdlFileName, bpel11wsdlFileName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFileName(String newFileName) {
		String oldFileName = fileName;
		fileName = newFileName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ddPackage.PROCESS_TYPE__FILE_NAME, oldFileName, fileName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QName getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(QName newName) {
		QName oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ddPackage.PROCESS_TYPE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.bpel.model.Process getModel() {
		if (model != null && model.eIsProxy()) {
			InternalEObject oldModel = (InternalEObject)model;
			model = (org.eclipse.bpel.model.Process)eResolveProxy(oldModel);
			if (model != oldModel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ddPackage.PROCESS_TYPE__MODEL, oldModel, model));
			}
		}
		return model;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.bpel.model.Process basicGetModel() {
		return model;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModel(org.eclipse.bpel.model.Process newModel) {
		org.eclipse.bpel.model.Process oldModel = model;
		model = newModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ddPackage.PROCESS_TYPE__MODEL, oldModel, model));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TBamServerProfiles getBamServerProfiles() {
		return bamServerProfiles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBamServerProfiles(TBamServerProfiles newBamServerProfiles, NotificationChain msgs) {
		TBamServerProfiles oldBamServerProfiles = bamServerProfiles;
		bamServerProfiles = newBamServerProfiles;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ddPackage.PROCESS_TYPE__BAM_SERVER_PROFILES, oldBamServerProfiles, newBamServerProfiles);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBamServerProfiles(TBamServerProfiles newBamServerProfiles) {
		if (newBamServerProfiles != bamServerProfiles) {
			NotificationChain msgs = null;
			if (bamServerProfiles != null)
				msgs = ((InternalEObject)bamServerProfiles).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ddPackage.PROCESS_TYPE__BAM_SERVER_PROFILES, null, msgs);
			if (newBamServerProfiles != null)
				msgs = ((InternalEObject)newBamServerProfiles).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ddPackage.PROCESS_TYPE__BAM_SERVER_PROFILES, null, msgs);
			msgs = basicSetBamServerProfiles(newBamServerProfiles, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ddPackage.PROCESS_TYPE__BAM_SERVER_PROFILES, newBamServerProfiles, newBamServerProfiles));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ddPackage.PROCESS_TYPE__PROPERTY:
				return ((InternalEList<?>)getProperty()).basicRemove(otherEnd, msgs);
			case ddPackage.PROCESS_TYPE__PROCESS_EVENTS:
				return basicSetProcessEvents(null, msgs);
			case ddPackage.PROCESS_TYPE__PROVIDE:
				return ((InternalEList<?>)getProvide()).basicRemove(otherEnd, msgs);
			case ddPackage.PROCESS_TYPE__INVOKE:
				return ((InternalEList<?>)getInvoke()).basicRemove(otherEnd, msgs);
			case ddPackage.PROCESS_TYPE__MEX_INTERCEPTORS:
				return basicSetMexInterceptors(null, msgs);
			case ddPackage.PROCESS_TYPE__BAM_SERVER_PROFILES:
				return basicSetBamServerProfiles(null, msgs);
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
			case ddPackage.PROCESS_TYPE__ACTIVE:
				return isActive();
			case ddPackage.PROCESS_TYPE__RETIRED:
				return isRetired();
			case ddPackage.PROCESS_TYPE__IN_MEMORY:
				return isInMemory();
			case ddPackage.PROCESS_TYPE__PROPERTY:
				return getProperty();
			case ddPackage.PROCESS_TYPE__PROCESS_EVENTS:
				return getProcessEvents();
			case ddPackage.PROCESS_TYPE__PROVIDE:
				return getProvide();
			case ddPackage.PROCESS_TYPE__INVOKE:
				return getInvoke();
			case ddPackage.PROCESS_TYPE__MEX_INTERCEPTORS:
				return getMexInterceptors();
			case ddPackage.PROCESS_TYPE__TYPE:
				return getType();
			case ddPackage.PROCESS_TYPE__BPEL11WSDL_FILE_NAME:
				return getBpel11wsdlFileName();
			case ddPackage.PROCESS_TYPE__FILE_NAME:
				return getFileName();
			case ddPackage.PROCESS_TYPE__NAME:
				return getName();
			case ddPackage.PROCESS_TYPE__MODEL:
				if (resolve) return getModel();
				return basicGetModel();
			case ddPackage.PROCESS_TYPE__BAM_SERVER_PROFILES:
				return getBamServerProfiles();
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
			case ddPackage.PROCESS_TYPE__ACTIVE:
				setActive((Boolean)newValue);
				return;
			case ddPackage.PROCESS_TYPE__RETIRED:
				setRetired((Boolean)newValue);
				return;
			case ddPackage.PROCESS_TYPE__IN_MEMORY:
				setInMemory((Boolean)newValue);
				return;
			case ddPackage.PROCESS_TYPE__PROPERTY:
				getProperty().clear();
				getProperty().addAll((Collection<? extends PropertyType>)newValue);
				return;
			case ddPackage.PROCESS_TYPE__PROCESS_EVENTS:
				setProcessEvents((TProcessEvents)newValue);
				return;
			case ddPackage.PROCESS_TYPE__PROVIDE:
				getProvide().clear();
				getProvide().addAll((Collection<? extends TProvide>)newValue);
				return;
			case ddPackage.PROCESS_TYPE__INVOKE:
				getInvoke().clear();
				getInvoke().addAll((Collection<? extends TInvoke>)newValue);
				return;
			case ddPackage.PROCESS_TYPE__MEX_INTERCEPTORS:
				setMexInterceptors((MexInterceptorsType)newValue);
				return;
			case ddPackage.PROCESS_TYPE__TYPE:
				setType((QName)newValue);
				return;
			case ddPackage.PROCESS_TYPE__BPEL11WSDL_FILE_NAME:
				setBpel11wsdlFileName((String)newValue);
				return;
			case ddPackage.PROCESS_TYPE__FILE_NAME:
				setFileName((String)newValue);
				return;
			case ddPackage.PROCESS_TYPE__NAME:
				setName((QName)newValue);
				return;
			case ddPackage.PROCESS_TYPE__MODEL:
				setModel((org.eclipse.bpel.model.Process)newValue);
				return;
			case ddPackage.PROCESS_TYPE__BAM_SERVER_PROFILES:
				setBamServerProfiles((TBamServerProfiles)newValue);
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
			case ddPackage.PROCESS_TYPE__ACTIVE:
				unsetActive();
				return;
			case ddPackage.PROCESS_TYPE__RETIRED:
				unsetRetired();
				return;
			case ddPackage.PROCESS_TYPE__IN_MEMORY:
				unsetInMemory();
				return;
			case ddPackage.PROCESS_TYPE__PROPERTY:
				getProperty().clear();
				return;
			case ddPackage.PROCESS_TYPE__PROCESS_EVENTS:
				setProcessEvents((TProcessEvents)null);
				return;
			case ddPackage.PROCESS_TYPE__PROVIDE:
				getProvide().clear();
				return;
			case ddPackage.PROCESS_TYPE__INVOKE:
				getInvoke().clear();
				return;
			case ddPackage.PROCESS_TYPE__MEX_INTERCEPTORS:
				setMexInterceptors((MexInterceptorsType)null);
				return;
			case ddPackage.PROCESS_TYPE__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case ddPackage.PROCESS_TYPE__BPEL11WSDL_FILE_NAME:
				setBpel11wsdlFileName(BPEL11WSDL_FILE_NAME_EDEFAULT);
				return;
			case ddPackage.PROCESS_TYPE__FILE_NAME:
				setFileName(FILE_NAME_EDEFAULT);
				return;
			case ddPackage.PROCESS_TYPE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ddPackage.PROCESS_TYPE__MODEL:
				setModel((org.eclipse.bpel.model.Process)null);
				return;
			case ddPackage.PROCESS_TYPE__BAM_SERVER_PROFILES:
				setBamServerProfiles((TBamServerProfiles)null);
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
			case ddPackage.PROCESS_TYPE__ACTIVE:
				return isSetActive();
			case ddPackage.PROCESS_TYPE__RETIRED:
				return isSetRetired();
			case ddPackage.PROCESS_TYPE__IN_MEMORY:
				return isSetInMemory();
			case ddPackage.PROCESS_TYPE__PROPERTY:
				return property != null && !property.isEmpty();
			case ddPackage.PROCESS_TYPE__PROCESS_EVENTS:
				return processEvents != null;
			case ddPackage.PROCESS_TYPE__PROVIDE:
				return provide != null && !provide.isEmpty();
			case ddPackage.PROCESS_TYPE__INVOKE:
				return invoke != null && !invoke.isEmpty();
			case ddPackage.PROCESS_TYPE__MEX_INTERCEPTORS:
				return mexInterceptors != null;
			case ddPackage.PROCESS_TYPE__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
			case ddPackage.PROCESS_TYPE__BPEL11WSDL_FILE_NAME:
				return BPEL11WSDL_FILE_NAME_EDEFAULT == null ? bpel11wsdlFileName != null : !BPEL11WSDL_FILE_NAME_EDEFAULT.equals(bpel11wsdlFileName);
			case ddPackage.PROCESS_TYPE__FILE_NAME:
				return FILE_NAME_EDEFAULT == null ? fileName != null : !FILE_NAME_EDEFAULT.equals(fileName);
			case ddPackage.PROCESS_TYPE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ddPackage.PROCESS_TYPE__MODEL:
				return model != null;
			case ddPackage.PROCESS_TYPE__BAM_SERVER_PROFILES:
				return bamServerProfiles != null;
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
		result.append(" (active: ");
		if (activeESet) result.append(active); else result.append("<unset>");
		result.append(", retired: ");
		if (retiredESet) result.append(retired); else result.append("<unset>");
		result.append(", inMemory: ");
		if (inMemoryESet) result.append(inMemory); else result.append("<unset>");
		result.append(", type: ");
		result.append(type);
		result.append(", bpel11wsdlFileName: ");
		result.append(bpel11wsdlFileName);
		result.append(", fileName: ");
		result.append(fileName);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //ProcessTypeImpl
