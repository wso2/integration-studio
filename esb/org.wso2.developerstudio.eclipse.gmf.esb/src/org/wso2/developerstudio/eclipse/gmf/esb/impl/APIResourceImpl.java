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
import org.wso2.developerstudio.eclipse.gmf.esb.APIResource;
import org.wso2.developerstudio.eclipse.gmf.esb.APIResourceFaultInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.APIResourceInSequenceInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.APIResourceInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.APIResourceOutSequenceOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.APIResourceOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.ApiResourceUrlStyle;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.Protocol;
import org.wso2.developerstudio.eclipse.gmf.esb.ProxyServiceContainer;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.SequenceType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>API Resource</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.APIResourceImpl#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.APIResourceImpl#getOutputConnector <em>Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.APIResourceImpl#getOutSequenceOutputConnector <em>Out Sequence Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.APIResourceImpl#getInSequenceInputConnectors <em>In Sequence Input Connectors</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.APIResourceImpl#getFaultInputConnector <em>Fault Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.APIResourceImpl#getUrlStyle <em>Url Style</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.APIResourceImpl#getUriTemplate <em>Uri Template</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.APIResourceImpl#getUrlMapping <em>Url Mapping</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.APIResourceImpl#isAllowGet <em>Allow Get</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.APIResourceImpl#isAllowPost <em>Allow Post</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.APIResourceImpl#isAllowPut <em>Allow Put</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.APIResourceImpl#isAllowDelete <em>Allow Delete</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.APIResourceImpl#isAllowOptions <em>Allow Options</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.APIResourceImpl#isAllowHead <em>Allow Head</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.APIResourceImpl#isAllowPatch <em>Allow Patch</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.APIResourceImpl#getContainer <em>Container</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.APIResourceImpl#getInSequenceType <em>In Sequence Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.APIResourceImpl#getInSequenceKey <em>In Sequence Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.APIResourceImpl#getInSequenceName <em>In Sequence Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.APIResourceImpl#getOutSequenceType <em>Out Sequence Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.APIResourceImpl#getOutSequenceKey <em>Out Sequence Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.APIResourceImpl#getOutSequenceName <em>Out Sequence Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.APIResourceImpl#getFaultSequenceType <em>Fault Sequence Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.APIResourceImpl#getFaultSequenceKey <em>Fault Sequence Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.APIResourceImpl#getFaultSequenceName <em>Fault Sequence Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.APIResourceImpl#getProtocol <em>Protocol</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class APIResourceImpl extends EsbNodeImpl implements APIResource {
	/**
	 * The cached value of the '{@link #getInputConnector() <em>Input Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputConnector()
	 * @generated
	 * @ordered
	 */
	protected APIResourceInputConnector inputConnector;

	/**
	 * The cached value of the '{@link #getOutputConnector() <em>Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputConnector()
	 * @generated
	 * @ordered
	 */
	protected APIResourceOutputConnector outputConnector;

	/**
	 * The cached value of the '{@link #getOutSequenceOutputConnector() <em>Out Sequence Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutSequenceOutputConnector()
	 * @generated
	 * @ordered
	 */
	protected APIResourceOutSequenceOutputConnector outSequenceOutputConnector;

	/**
	 * The cached value of the '{@link #getInSequenceInputConnectors() <em>In Sequence Input Connectors</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInSequenceInputConnectors()
	 * @generated
	 * @ordered
	 */
	protected EList<APIResourceInSequenceInputConnector> inSequenceInputConnectors;

	/**
	 * The cached value of the '{@link #getFaultInputConnector() <em>Fault Input Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFaultInputConnector()
	 * @generated
	 * @ordered
	 */
	protected APIResourceFaultInputConnector faultInputConnector;

	/**
	 * The default value of the '{@link #getUrlStyle() <em>Url Style</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUrlStyle()
	 * @generated
	 * @ordered
	 */
	protected static final ApiResourceUrlStyle URL_STYLE_EDEFAULT = ApiResourceUrlStyle.NONE;

	/**
	 * The cached value of the '{@link #getUrlStyle() <em>Url Style</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUrlStyle()
	 * @generated
	 * @ordered
	 */
	protected ApiResourceUrlStyle urlStyle = URL_STYLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getUriTemplate() <em>Uri Template</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUriTemplate()
	 * @generated
	 * @ordered
	 */
	protected static final String URI_TEMPLATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUriTemplate() <em>Uri Template</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUriTemplate()
	 * @generated
	 * @ordered
	 */
	protected String uriTemplate = URI_TEMPLATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getUrlMapping() <em>Url Mapping</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUrlMapping()
	 * @generated
	 * @ordered
	 */
	protected static final String URL_MAPPING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUrlMapping() <em>Url Mapping</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUrlMapping()
	 * @generated
	 * @ordered
	 */
	protected String urlMapping = URL_MAPPING_EDEFAULT;

	/**
	 * The default value of the '{@link #isAllowGet() <em>Allow Get</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAllowGet()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ALLOW_GET_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAllowGet() <em>Allow Get</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAllowGet()
	 * @generated
	 * @ordered
	 */
	protected boolean allowGet = ALLOW_GET_EDEFAULT;

	/**
	 * The default value of the '{@link #isAllowPost() <em>Allow Post</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAllowPost()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ALLOW_POST_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAllowPost() <em>Allow Post</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAllowPost()
	 * @generated
	 * @ordered
	 */
	protected boolean allowPost = ALLOW_POST_EDEFAULT;

	/**
	 * The default value of the '{@link #isAllowPut() <em>Allow Put</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAllowPut()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ALLOW_PUT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAllowPut() <em>Allow Put</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAllowPut()
	 * @generated
	 * @ordered
	 */
	protected boolean allowPut = ALLOW_PUT_EDEFAULT;

	/**
	 * The default value of the '{@link #isAllowDelete() <em>Allow Delete</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAllowDelete()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ALLOW_DELETE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAllowDelete() <em>Allow Delete</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAllowDelete()
	 * @generated
	 * @ordered
	 */
	protected boolean allowDelete = ALLOW_DELETE_EDEFAULT;

	/**
	 * The default value of the '{@link #isAllowOptions() <em>Allow Options</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAllowOptions()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ALLOW_OPTIONS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAllowOptions() <em>Allow Options</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAllowOptions()
	 * @generated
	 * @ordered
	 */
	protected boolean allowOptions = ALLOW_OPTIONS_EDEFAULT;

	/**
	 * The default value of the '{@link #isAllowHead() <em>Allow Head</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAllowHead()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ALLOW_HEAD_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAllowHead() <em>Allow Head</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAllowHead()
	 * @generated
	 * @ordered
	 */
	protected boolean allowHead = ALLOW_HEAD_EDEFAULT;

	/**
	 * The default value of the '{@link #isAllowPatch() <em>Allow Patch</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAllowPatch()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ALLOW_PATCH_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAllowPatch() <em>Allow Patch</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAllowPatch()
	 * @generated
	 * @ordered
	 */
	protected boolean allowPatch = ALLOW_PATCH_EDEFAULT;

	/**
	 * The cached value of the '{@link #getContainer() <em>Container</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContainer()
	 * @generated
	 * @ordered
	 */
	protected ProxyServiceContainer container;

	/**
	 * The default value of the '{@link #getInSequenceType() <em>In Sequence Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInSequenceType()
	 * @generated
	 * @ordered
	 */
	protected static final SequenceType IN_SEQUENCE_TYPE_EDEFAULT = SequenceType.ANONYMOUS;

	/**
	 * The cached value of the '{@link #getInSequenceType() <em>In Sequence Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInSequenceType()
	 * @generated
	 * @ordered
	 */
	protected SequenceType inSequenceType = IN_SEQUENCE_TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getInSequenceKey() <em>In Sequence Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInSequenceKey()
	 * @generated
	 * @ordered
	 */
	protected RegistryKeyProperty inSequenceKey;

	/**
	 * The default value of the '{@link #getInSequenceName() <em>In Sequence Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInSequenceName()
	 * @generated
	 * @ordered
	 */
	protected static final String IN_SEQUENCE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInSequenceName() <em>In Sequence Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInSequenceName()
	 * @generated
	 * @ordered
	 */
	protected String inSequenceName = IN_SEQUENCE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getOutSequenceType() <em>Out Sequence Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutSequenceType()
	 * @generated
	 * @ordered
	 */
	protected static final SequenceType OUT_SEQUENCE_TYPE_EDEFAULT = SequenceType.ANONYMOUS;

	/**
	 * The cached value of the '{@link #getOutSequenceType() <em>Out Sequence Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutSequenceType()
	 * @generated
	 * @ordered
	 */
	protected SequenceType outSequenceType = OUT_SEQUENCE_TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOutSequenceKey() <em>Out Sequence Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutSequenceKey()
	 * @generated
	 * @ordered
	 */
	protected RegistryKeyProperty outSequenceKey;

	/**
	 * The default value of the '{@link #getOutSequenceName() <em>Out Sequence Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutSequenceName()
	 * @generated
	 * @ordered
	 */
	protected static final String OUT_SEQUENCE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOutSequenceName() <em>Out Sequence Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutSequenceName()
	 * @generated
	 * @ordered
	 */
	protected String outSequenceName = OUT_SEQUENCE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getFaultSequenceType() <em>Fault Sequence Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFaultSequenceType()
	 * @generated
	 * @ordered
	 */
	protected static final SequenceType FAULT_SEQUENCE_TYPE_EDEFAULT = SequenceType.ANONYMOUS;

	/**
	 * The cached value of the '{@link #getFaultSequenceType() <em>Fault Sequence Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFaultSequenceType()
	 * @generated
	 * @ordered
	 */
	protected SequenceType faultSequenceType = FAULT_SEQUENCE_TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFaultSequenceKey() <em>Fault Sequence Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFaultSequenceKey()
	 * @generated
	 * @ordered
	 */
	protected RegistryKeyProperty faultSequenceKey;

	/**
	 * The default value of the '{@link #getFaultSequenceName() <em>Fault Sequence Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFaultSequenceName()
	 * @generated
	 * @ordered
	 */
	protected static final String FAULT_SEQUENCE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFaultSequenceName() <em>Fault Sequence Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFaultSequenceName()
	 * @generated
	 * @ordered
	 */
	protected String faultSequenceName = FAULT_SEQUENCE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getProtocol() <em>Protocol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProtocol()
	 * @generated
	 * @ordered
	 */
	protected static final Protocol PROTOCOL_EDEFAULT = Protocol.HTTP;

	/**
	 * The cached value of the '{@link #getProtocol() <em>Protocol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProtocol()
	 * @generated
	 * @ordered
	 */
	protected Protocol protocol = PROTOCOL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected APIResourceImpl() {
		super();
		
		RegistryKeyProperty inSequenceKey = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
		inSequenceKey.setPrettyName("In Sequence Reference");
		inSequenceKey.setKeyName("key");
		inSequenceKey.setKeyValue(org.wso2.developerstudio.eclipse.gmf.esb.EsbElement.DEFAULT_REGISTRY_KEY);
		setInSequenceKey(inSequenceKey);
		
		RegistryKeyProperty outSequenceKey = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
		outSequenceKey.setPrettyName("Out Sequence Reference");
		outSequenceKey.setKeyName("key");
		outSequenceKey.setKeyValue(org.wso2.developerstudio.eclipse.gmf.esb.EsbElement.DEFAULT_REGISTRY_KEY);
		setOutSequenceKey(outSequenceKey);
		
		RegistryKeyProperty faultSequenceKey = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
		faultSequenceKey.setPrettyName("Fault Sequence Reference");
		faultSequenceKey.setKeyName("key");
		faultSequenceKey.setKeyValue(org.wso2.developerstudio.eclipse.gmf.esb.EsbElement.DEFAULT_REGISTRY_KEY);
		setFaultSequenceKey(faultSequenceKey);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.API_RESOURCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public APIResourceInputConnector getInputConnector() {
		return inputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInputConnector(APIResourceInputConnector newInputConnector, NotificationChain msgs) {
		APIResourceInputConnector oldInputConnector = inputConnector;
		inputConnector = newInputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.API_RESOURCE__INPUT_CONNECTOR, oldInputConnector, newInputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInputConnector(APIResourceInputConnector newInputConnector) {
		if (newInputConnector != inputConnector) {
			NotificationChain msgs = null;
			if (inputConnector != null)
				msgs = ((InternalEObject)inputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.API_RESOURCE__INPUT_CONNECTOR, null, msgs);
			if (newInputConnector != null)
				msgs = ((InternalEObject)newInputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.API_RESOURCE__INPUT_CONNECTOR, null, msgs);
			msgs = basicSetInputConnector(newInputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.API_RESOURCE__INPUT_CONNECTOR, newInputConnector, newInputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public APIResourceOutputConnector getOutputConnector() {
		return outputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOutputConnector(APIResourceOutputConnector newOutputConnector, NotificationChain msgs) {
		APIResourceOutputConnector oldOutputConnector = outputConnector;
		outputConnector = newOutputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.API_RESOURCE__OUTPUT_CONNECTOR, oldOutputConnector, newOutputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutputConnector(APIResourceOutputConnector newOutputConnector) {
		if (newOutputConnector != outputConnector) {
			NotificationChain msgs = null;
			if (outputConnector != null)
				msgs = ((InternalEObject)outputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.API_RESOURCE__OUTPUT_CONNECTOR, null, msgs);
			if (newOutputConnector != null)
				msgs = ((InternalEObject)newOutputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.API_RESOURCE__OUTPUT_CONNECTOR, null, msgs);
			msgs = basicSetOutputConnector(newOutputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.API_RESOURCE__OUTPUT_CONNECTOR, newOutputConnector, newOutputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public APIResourceOutSequenceOutputConnector getOutSequenceOutputConnector() {
		return outSequenceOutputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOutSequenceOutputConnector(APIResourceOutSequenceOutputConnector newOutSequenceOutputConnector, NotificationChain msgs) {
		APIResourceOutSequenceOutputConnector oldOutSequenceOutputConnector = outSequenceOutputConnector;
		outSequenceOutputConnector = newOutSequenceOutputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.API_RESOURCE__OUT_SEQUENCE_OUTPUT_CONNECTOR, oldOutSequenceOutputConnector, newOutSequenceOutputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutSequenceOutputConnector(APIResourceOutSequenceOutputConnector newOutSequenceOutputConnector) {
		if (newOutSequenceOutputConnector != outSequenceOutputConnector) {
			NotificationChain msgs = null;
			if (outSequenceOutputConnector != null)
				msgs = ((InternalEObject)outSequenceOutputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.API_RESOURCE__OUT_SEQUENCE_OUTPUT_CONNECTOR, null, msgs);
			if (newOutSequenceOutputConnector != null)
				msgs = ((InternalEObject)newOutSequenceOutputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.API_RESOURCE__OUT_SEQUENCE_OUTPUT_CONNECTOR, null, msgs);
			msgs = basicSetOutSequenceOutputConnector(newOutSequenceOutputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.API_RESOURCE__OUT_SEQUENCE_OUTPUT_CONNECTOR, newOutSequenceOutputConnector, newOutSequenceOutputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<APIResourceInSequenceInputConnector> getInSequenceInputConnectors() {
		if (inSequenceInputConnectors == null) {
			inSequenceInputConnectors = new EObjectContainmentEList<APIResourceInSequenceInputConnector>(APIResourceInSequenceInputConnector.class, this, EsbPackage.API_RESOURCE__IN_SEQUENCE_INPUT_CONNECTORS);
		}
		return inSequenceInputConnectors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public APIResourceFaultInputConnector getFaultInputConnector() {
		return faultInputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFaultInputConnector(APIResourceFaultInputConnector newFaultInputConnector, NotificationChain msgs) {
		APIResourceFaultInputConnector oldFaultInputConnector = faultInputConnector;
		faultInputConnector = newFaultInputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.API_RESOURCE__FAULT_INPUT_CONNECTOR, oldFaultInputConnector, newFaultInputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFaultInputConnector(APIResourceFaultInputConnector newFaultInputConnector) {
		if (newFaultInputConnector != faultInputConnector) {
			NotificationChain msgs = null;
			if (faultInputConnector != null)
				msgs = ((InternalEObject)faultInputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.API_RESOURCE__FAULT_INPUT_CONNECTOR, null, msgs);
			if (newFaultInputConnector != null)
				msgs = ((InternalEObject)newFaultInputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.API_RESOURCE__FAULT_INPUT_CONNECTOR, null, msgs);
			msgs = basicSetFaultInputConnector(newFaultInputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.API_RESOURCE__FAULT_INPUT_CONNECTOR, newFaultInputConnector, newFaultInputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ApiResourceUrlStyle getUrlStyle() {
		return urlStyle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUrlStyle(ApiResourceUrlStyle newUrlStyle) {
		ApiResourceUrlStyle oldUrlStyle = urlStyle;
		urlStyle = newUrlStyle == null ? URL_STYLE_EDEFAULT : newUrlStyle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.API_RESOURCE__URL_STYLE, oldUrlStyle, urlStyle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUriTemplate() {
		return uriTemplate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUriTemplate(String newUriTemplate) {
		String oldUriTemplate = uriTemplate;
		uriTemplate = newUriTemplate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.API_RESOURCE__URI_TEMPLATE, oldUriTemplate, uriTemplate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUrlMapping() {
		return urlMapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUrlMapping(String newUrlMapping) {
		String oldUrlMapping = urlMapping;
		urlMapping = newUrlMapping;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.API_RESOURCE__URL_MAPPING, oldUrlMapping, urlMapping));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAllowGet() {
		return allowGet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAllowGet(boolean newAllowGet) {
		boolean oldAllowGet = allowGet;
		allowGet = newAllowGet;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.API_RESOURCE__ALLOW_GET, oldAllowGet, allowGet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAllowPost() {
		return allowPost;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAllowPost(boolean newAllowPost) {
		boolean oldAllowPost = allowPost;
		allowPost = newAllowPost;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.API_RESOURCE__ALLOW_POST, oldAllowPost, allowPost));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAllowPut() {
		return allowPut;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAllowPut(boolean newAllowPut) {
		boolean oldAllowPut = allowPut;
		allowPut = newAllowPut;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.API_RESOURCE__ALLOW_PUT, oldAllowPut, allowPut));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAllowDelete() {
		return allowDelete;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAllowDelete(boolean newAllowDelete) {
		boolean oldAllowDelete = allowDelete;
		allowDelete = newAllowDelete;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.API_RESOURCE__ALLOW_DELETE, oldAllowDelete, allowDelete));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAllowOptions() {
		return allowOptions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAllowOptions(boolean newAllowOptions) {
		boolean oldAllowOptions = allowOptions;
		allowOptions = newAllowOptions;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.API_RESOURCE__ALLOW_OPTIONS, oldAllowOptions, allowOptions));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAllowHead() {
		return allowHead;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAllowHead(boolean newAllowHead) {
		boolean oldAllowHead = allowHead;
		allowHead = newAllowHead;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.API_RESOURCE__ALLOW_HEAD, oldAllowHead, allowHead));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAllowPatch() {
		return allowPatch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAllowPatch(boolean newAllowPatch) {
		boolean oldAllowPatch = allowPatch;
		allowPatch = newAllowPatch;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.API_RESOURCE__ALLOW_PATCH, oldAllowPatch, allowPatch));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProxyServiceContainer getContainer() {
		return container;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContainer(ProxyServiceContainer newContainer, NotificationChain msgs) {
		ProxyServiceContainer oldContainer = container;
		container = newContainer;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.API_RESOURCE__CONTAINER, oldContainer, newContainer);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainer(ProxyServiceContainer newContainer) {
		if (newContainer != container) {
			NotificationChain msgs = null;
			if (container != null)
				msgs = ((InternalEObject)container).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.API_RESOURCE__CONTAINER, null, msgs);
			if (newContainer != null)
				msgs = ((InternalEObject)newContainer).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.API_RESOURCE__CONTAINER, null, msgs);
			msgs = basicSetContainer(newContainer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.API_RESOURCE__CONTAINER, newContainer, newContainer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SequenceType getInSequenceType() {
		return inSequenceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInSequenceType(SequenceType newInSequenceType) {
		SequenceType oldInSequenceType = inSequenceType;
		inSequenceType = newInSequenceType == null ? IN_SEQUENCE_TYPE_EDEFAULT : newInSequenceType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.API_RESOURCE__IN_SEQUENCE_TYPE, oldInSequenceType, inSequenceType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegistryKeyProperty getInSequenceKey() {
		return inSequenceKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInSequenceKey(RegistryKeyProperty newInSequenceKey, NotificationChain msgs) {
		RegistryKeyProperty oldInSequenceKey = inSequenceKey;
		inSequenceKey = newInSequenceKey;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.API_RESOURCE__IN_SEQUENCE_KEY, oldInSequenceKey, newInSequenceKey);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInSequenceKey(RegistryKeyProperty newInSequenceKey) {
		if (newInSequenceKey != inSequenceKey) {
			NotificationChain msgs = null;
			if (inSequenceKey != null)
				msgs = ((InternalEObject)inSequenceKey).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.API_RESOURCE__IN_SEQUENCE_KEY, null, msgs);
			if (newInSequenceKey != null)
				msgs = ((InternalEObject)newInSequenceKey).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.API_RESOURCE__IN_SEQUENCE_KEY, null, msgs);
			msgs = basicSetInSequenceKey(newInSequenceKey, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.API_RESOURCE__IN_SEQUENCE_KEY, newInSequenceKey, newInSequenceKey));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInSequenceName() {
		return inSequenceName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInSequenceName(String newInSequenceName) {
		String oldInSequenceName = inSequenceName;
		inSequenceName = newInSequenceName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.API_RESOURCE__IN_SEQUENCE_NAME, oldInSequenceName, inSequenceName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SequenceType getOutSequenceType() {
		return outSequenceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutSequenceType(SequenceType newOutSequenceType) {
		SequenceType oldOutSequenceType = outSequenceType;
		outSequenceType = newOutSequenceType == null ? OUT_SEQUENCE_TYPE_EDEFAULT : newOutSequenceType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.API_RESOURCE__OUT_SEQUENCE_TYPE, oldOutSequenceType, outSequenceType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegistryKeyProperty getOutSequenceKey() {
		return outSequenceKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOutSequenceKey(RegistryKeyProperty newOutSequenceKey, NotificationChain msgs) {
		RegistryKeyProperty oldOutSequenceKey = outSequenceKey;
		outSequenceKey = newOutSequenceKey;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.API_RESOURCE__OUT_SEQUENCE_KEY, oldOutSequenceKey, newOutSequenceKey);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutSequenceKey(RegistryKeyProperty newOutSequenceKey) {
		if (newOutSequenceKey != outSequenceKey) {
			NotificationChain msgs = null;
			if (outSequenceKey != null)
				msgs = ((InternalEObject)outSequenceKey).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.API_RESOURCE__OUT_SEQUENCE_KEY, null, msgs);
			if (newOutSequenceKey != null)
				msgs = ((InternalEObject)newOutSequenceKey).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.API_RESOURCE__OUT_SEQUENCE_KEY, null, msgs);
			msgs = basicSetOutSequenceKey(newOutSequenceKey, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.API_RESOURCE__OUT_SEQUENCE_KEY, newOutSequenceKey, newOutSequenceKey));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOutSequenceName() {
		return outSequenceName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutSequenceName(String newOutSequenceName) {
		String oldOutSequenceName = outSequenceName;
		outSequenceName = newOutSequenceName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.API_RESOURCE__OUT_SEQUENCE_NAME, oldOutSequenceName, outSequenceName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SequenceType getFaultSequenceType() {
		return faultSequenceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFaultSequenceType(SequenceType newFaultSequenceType) {
		SequenceType oldFaultSequenceType = faultSequenceType;
		faultSequenceType = newFaultSequenceType == null ? FAULT_SEQUENCE_TYPE_EDEFAULT : newFaultSequenceType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.API_RESOURCE__FAULT_SEQUENCE_TYPE, oldFaultSequenceType, faultSequenceType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegistryKeyProperty getFaultSequenceKey() {
		return faultSequenceKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFaultSequenceKey(RegistryKeyProperty newFaultSequenceKey, NotificationChain msgs) {
		RegistryKeyProperty oldFaultSequenceKey = faultSequenceKey;
		faultSequenceKey = newFaultSequenceKey;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.API_RESOURCE__FAULT_SEQUENCE_KEY, oldFaultSequenceKey, newFaultSequenceKey);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFaultSequenceKey(RegistryKeyProperty newFaultSequenceKey) {
		if (newFaultSequenceKey != faultSequenceKey) {
			NotificationChain msgs = null;
			if (faultSequenceKey != null)
				msgs = ((InternalEObject)faultSequenceKey).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.API_RESOURCE__FAULT_SEQUENCE_KEY, null, msgs);
			if (newFaultSequenceKey != null)
				msgs = ((InternalEObject)newFaultSequenceKey).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.API_RESOURCE__FAULT_SEQUENCE_KEY, null, msgs);
			msgs = basicSetFaultSequenceKey(newFaultSequenceKey, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.API_RESOURCE__FAULT_SEQUENCE_KEY, newFaultSequenceKey, newFaultSequenceKey));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFaultSequenceName() {
		return faultSequenceName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFaultSequenceName(String newFaultSequenceName) {
		String oldFaultSequenceName = faultSequenceName;
		faultSequenceName = newFaultSequenceName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.API_RESOURCE__FAULT_SEQUENCE_NAME, oldFaultSequenceName, faultSequenceName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Protocol getProtocol() {
		return protocol;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProtocol(Protocol newProtocol) {
		Protocol oldProtocol = protocol;
		protocol = newProtocol == null ? PROTOCOL_EDEFAULT : newProtocol;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.API_RESOURCE__PROTOCOL, oldProtocol, protocol));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsbPackage.API_RESOURCE__INPUT_CONNECTOR:
				return basicSetInputConnector(null, msgs);
			case EsbPackage.API_RESOURCE__OUTPUT_CONNECTOR:
				return basicSetOutputConnector(null, msgs);
			case EsbPackage.API_RESOURCE__OUT_SEQUENCE_OUTPUT_CONNECTOR:
				return basicSetOutSequenceOutputConnector(null, msgs);
			case EsbPackage.API_RESOURCE__IN_SEQUENCE_INPUT_CONNECTORS:
				return ((InternalEList<?>)getInSequenceInputConnectors()).basicRemove(otherEnd, msgs);
			case EsbPackage.API_RESOURCE__FAULT_INPUT_CONNECTOR:
				return basicSetFaultInputConnector(null, msgs);
			case EsbPackage.API_RESOURCE__CONTAINER:
				return basicSetContainer(null, msgs);
			case EsbPackage.API_RESOURCE__IN_SEQUENCE_KEY:
				return basicSetInSequenceKey(null, msgs);
			case EsbPackage.API_RESOURCE__OUT_SEQUENCE_KEY:
				return basicSetOutSequenceKey(null, msgs);
			case EsbPackage.API_RESOURCE__FAULT_SEQUENCE_KEY:
				return basicSetFaultSequenceKey(null, msgs);
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
			case EsbPackage.API_RESOURCE__INPUT_CONNECTOR:
				return getInputConnector();
			case EsbPackage.API_RESOURCE__OUTPUT_CONNECTOR:
				return getOutputConnector();
			case EsbPackage.API_RESOURCE__OUT_SEQUENCE_OUTPUT_CONNECTOR:
				return getOutSequenceOutputConnector();
			case EsbPackage.API_RESOURCE__IN_SEQUENCE_INPUT_CONNECTORS:
				return getInSequenceInputConnectors();
			case EsbPackage.API_RESOURCE__FAULT_INPUT_CONNECTOR:
				return getFaultInputConnector();
			case EsbPackage.API_RESOURCE__URL_STYLE:
				return getUrlStyle();
			case EsbPackage.API_RESOURCE__URI_TEMPLATE:
				return getUriTemplate();
			case EsbPackage.API_RESOURCE__URL_MAPPING:
				return getUrlMapping();
			case EsbPackage.API_RESOURCE__ALLOW_GET:
				return isAllowGet();
			case EsbPackage.API_RESOURCE__ALLOW_POST:
				return isAllowPost();
			case EsbPackage.API_RESOURCE__ALLOW_PUT:
				return isAllowPut();
			case EsbPackage.API_RESOURCE__ALLOW_DELETE:
				return isAllowDelete();
			case EsbPackage.API_RESOURCE__ALLOW_OPTIONS:
				return isAllowOptions();
			case EsbPackage.API_RESOURCE__ALLOW_HEAD:
				return isAllowHead();
			case EsbPackage.API_RESOURCE__ALLOW_PATCH:
				return isAllowPatch();
			case EsbPackage.API_RESOURCE__CONTAINER:
				return getContainer();
			case EsbPackage.API_RESOURCE__IN_SEQUENCE_TYPE:
				return getInSequenceType();
			case EsbPackage.API_RESOURCE__IN_SEQUENCE_KEY:
				return getInSequenceKey();
			case EsbPackage.API_RESOURCE__IN_SEQUENCE_NAME:
				return getInSequenceName();
			case EsbPackage.API_RESOURCE__OUT_SEQUENCE_TYPE:
				return getOutSequenceType();
			case EsbPackage.API_RESOURCE__OUT_SEQUENCE_KEY:
				return getOutSequenceKey();
			case EsbPackage.API_RESOURCE__OUT_SEQUENCE_NAME:
				return getOutSequenceName();
			case EsbPackage.API_RESOURCE__FAULT_SEQUENCE_TYPE:
				return getFaultSequenceType();
			case EsbPackage.API_RESOURCE__FAULT_SEQUENCE_KEY:
				return getFaultSequenceKey();
			case EsbPackage.API_RESOURCE__FAULT_SEQUENCE_NAME:
				return getFaultSequenceName();
			case EsbPackage.API_RESOURCE__PROTOCOL:
				return getProtocol();
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
			case EsbPackage.API_RESOURCE__INPUT_CONNECTOR:
				setInputConnector((APIResourceInputConnector)newValue);
				return;
			case EsbPackage.API_RESOURCE__OUTPUT_CONNECTOR:
				setOutputConnector((APIResourceOutputConnector)newValue);
				return;
			case EsbPackage.API_RESOURCE__OUT_SEQUENCE_OUTPUT_CONNECTOR:
				setOutSequenceOutputConnector((APIResourceOutSequenceOutputConnector)newValue);
				return;
			case EsbPackage.API_RESOURCE__IN_SEQUENCE_INPUT_CONNECTORS:
				getInSequenceInputConnectors().clear();
				getInSequenceInputConnectors().addAll((Collection<? extends APIResourceInSequenceInputConnector>)newValue);
				return;
			case EsbPackage.API_RESOURCE__FAULT_INPUT_CONNECTOR:
				setFaultInputConnector((APIResourceFaultInputConnector)newValue);
				return;
			case EsbPackage.API_RESOURCE__URL_STYLE:
				setUrlStyle((ApiResourceUrlStyle)newValue);
				return;
			case EsbPackage.API_RESOURCE__URI_TEMPLATE:
				setUriTemplate((String)newValue);
				return;
			case EsbPackage.API_RESOURCE__URL_MAPPING:
				setUrlMapping((String)newValue);
				return;
			case EsbPackage.API_RESOURCE__ALLOW_GET:
				setAllowGet((Boolean)newValue);
				return;
			case EsbPackage.API_RESOURCE__ALLOW_POST:
				setAllowPost((Boolean)newValue);
				return;
			case EsbPackage.API_RESOURCE__ALLOW_PUT:
				setAllowPut((Boolean)newValue);
				return;
			case EsbPackage.API_RESOURCE__ALLOW_DELETE:
				setAllowDelete((Boolean)newValue);
				return;
			case EsbPackage.API_RESOURCE__ALLOW_OPTIONS:
				setAllowOptions((Boolean)newValue);
				return;
			case EsbPackage.API_RESOURCE__ALLOW_HEAD:
				setAllowHead((Boolean)newValue);
				return;
			case EsbPackage.API_RESOURCE__ALLOW_PATCH:
				setAllowPatch((Boolean)newValue);
				return;
			case EsbPackage.API_RESOURCE__CONTAINER:
				setContainer((ProxyServiceContainer)newValue);
				return;
			case EsbPackage.API_RESOURCE__IN_SEQUENCE_TYPE:
				setInSequenceType((SequenceType)newValue);
				return;
			case EsbPackage.API_RESOURCE__IN_SEQUENCE_KEY:
				setInSequenceKey((RegistryKeyProperty)newValue);
				return;
			case EsbPackage.API_RESOURCE__IN_SEQUENCE_NAME:
				setInSequenceName((String)newValue);
				return;
			case EsbPackage.API_RESOURCE__OUT_SEQUENCE_TYPE:
				setOutSequenceType((SequenceType)newValue);
				return;
			case EsbPackage.API_RESOURCE__OUT_SEQUENCE_KEY:
				setOutSequenceKey((RegistryKeyProperty)newValue);
				return;
			case EsbPackage.API_RESOURCE__OUT_SEQUENCE_NAME:
				setOutSequenceName((String)newValue);
				return;
			case EsbPackage.API_RESOURCE__FAULT_SEQUENCE_TYPE:
				setFaultSequenceType((SequenceType)newValue);
				return;
			case EsbPackage.API_RESOURCE__FAULT_SEQUENCE_KEY:
				setFaultSequenceKey((RegistryKeyProperty)newValue);
				return;
			case EsbPackage.API_RESOURCE__FAULT_SEQUENCE_NAME:
				setFaultSequenceName((String)newValue);
				return;
			case EsbPackage.API_RESOURCE__PROTOCOL:
				setProtocol((Protocol)newValue);
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
			case EsbPackage.API_RESOURCE__INPUT_CONNECTOR:
				setInputConnector((APIResourceInputConnector)null);
				return;
			case EsbPackage.API_RESOURCE__OUTPUT_CONNECTOR:
				setOutputConnector((APIResourceOutputConnector)null);
				return;
			case EsbPackage.API_RESOURCE__OUT_SEQUENCE_OUTPUT_CONNECTOR:
				setOutSequenceOutputConnector((APIResourceOutSequenceOutputConnector)null);
				return;
			case EsbPackage.API_RESOURCE__IN_SEQUENCE_INPUT_CONNECTORS:
				getInSequenceInputConnectors().clear();
				return;
			case EsbPackage.API_RESOURCE__FAULT_INPUT_CONNECTOR:
				setFaultInputConnector((APIResourceFaultInputConnector)null);
				return;
			case EsbPackage.API_RESOURCE__URL_STYLE:
				setUrlStyle(URL_STYLE_EDEFAULT);
				return;
			case EsbPackage.API_RESOURCE__URI_TEMPLATE:
				setUriTemplate(URI_TEMPLATE_EDEFAULT);
				return;
			case EsbPackage.API_RESOURCE__URL_MAPPING:
				setUrlMapping(URL_MAPPING_EDEFAULT);
				return;
			case EsbPackage.API_RESOURCE__ALLOW_GET:
				setAllowGet(ALLOW_GET_EDEFAULT);
				return;
			case EsbPackage.API_RESOURCE__ALLOW_POST:
				setAllowPost(ALLOW_POST_EDEFAULT);
				return;
			case EsbPackage.API_RESOURCE__ALLOW_PUT:
				setAllowPut(ALLOW_PUT_EDEFAULT);
				return;
			case EsbPackage.API_RESOURCE__ALLOW_DELETE:
				setAllowDelete(ALLOW_DELETE_EDEFAULT);
				return;
			case EsbPackage.API_RESOURCE__ALLOW_OPTIONS:
				setAllowOptions(ALLOW_OPTIONS_EDEFAULT);
				return;
			case EsbPackage.API_RESOURCE__ALLOW_HEAD:
				setAllowHead(ALLOW_HEAD_EDEFAULT);
				return;
			case EsbPackage.API_RESOURCE__ALLOW_PATCH:
				setAllowPatch(ALLOW_PATCH_EDEFAULT);
				return;
			case EsbPackage.API_RESOURCE__CONTAINER:
				setContainer((ProxyServiceContainer)null);
				return;
			case EsbPackage.API_RESOURCE__IN_SEQUENCE_TYPE:
				setInSequenceType(IN_SEQUENCE_TYPE_EDEFAULT);
				return;
			case EsbPackage.API_RESOURCE__IN_SEQUENCE_KEY:
				setInSequenceKey((RegistryKeyProperty)null);
				return;
			case EsbPackage.API_RESOURCE__IN_SEQUENCE_NAME:
				setInSequenceName(IN_SEQUENCE_NAME_EDEFAULT);
				return;
			case EsbPackage.API_RESOURCE__OUT_SEQUENCE_TYPE:
				setOutSequenceType(OUT_SEQUENCE_TYPE_EDEFAULT);
				return;
			case EsbPackage.API_RESOURCE__OUT_SEQUENCE_KEY:
				setOutSequenceKey((RegistryKeyProperty)null);
				return;
			case EsbPackage.API_RESOURCE__OUT_SEQUENCE_NAME:
				setOutSequenceName(OUT_SEQUENCE_NAME_EDEFAULT);
				return;
			case EsbPackage.API_RESOURCE__FAULT_SEQUENCE_TYPE:
				setFaultSequenceType(FAULT_SEQUENCE_TYPE_EDEFAULT);
				return;
			case EsbPackage.API_RESOURCE__FAULT_SEQUENCE_KEY:
				setFaultSequenceKey((RegistryKeyProperty)null);
				return;
			case EsbPackage.API_RESOURCE__FAULT_SEQUENCE_NAME:
				setFaultSequenceName(FAULT_SEQUENCE_NAME_EDEFAULT);
				return;
			case EsbPackage.API_RESOURCE__PROTOCOL:
				setProtocol(PROTOCOL_EDEFAULT);
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
			case EsbPackage.API_RESOURCE__INPUT_CONNECTOR:
				return inputConnector != null;
			case EsbPackage.API_RESOURCE__OUTPUT_CONNECTOR:
				return outputConnector != null;
			case EsbPackage.API_RESOURCE__OUT_SEQUENCE_OUTPUT_CONNECTOR:
				return outSequenceOutputConnector != null;
			case EsbPackage.API_RESOURCE__IN_SEQUENCE_INPUT_CONNECTORS:
				return inSequenceInputConnectors != null && !inSequenceInputConnectors.isEmpty();
			case EsbPackage.API_RESOURCE__FAULT_INPUT_CONNECTOR:
				return faultInputConnector != null;
			case EsbPackage.API_RESOURCE__URL_STYLE:
				return urlStyle != URL_STYLE_EDEFAULT;
			case EsbPackage.API_RESOURCE__URI_TEMPLATE:
				return URI_TEMPLATE_EDEFAULT == null ? uriTemplate != null : !URI_TEMPLATE_EDEFAULT.equals(uriTemplate);
			case EsbPackage.API_RESOURCE__URL_MAPPING:
				return URL_MAPPING_EDEFAULT == null ? urlMapping != null : !URL_MAPPING_EDEFAULT.equals(urlMapping);
			case EsbPackage.API_RESOURCE__ALLOW_GET:
				return allowGet != ALLOW_GET_EDEFAULT;
			case EsbPackage.API_RESOURCE__ALLOW_POST:
				return allowPost != ALLOW_POST_EDEFAULT;
			case EsbPackage.API_RESOURCE__ALLOW_PUT:
				return allowPut != ALLOW_PUT_EDEFAULT;
			case EsbPackage.API_RESOURCE__ALLOW_DELETE:
				return allowDelete != ALLOW_DELETE_EDEFAULT;
			case EsbPackage.API_RESOURCE__ALLOW_OPTIONS:
				return allowOptions != ALLOW_OPTIONS_EDEFAULT;
			case EsbPackage.API_RESOURCE__ALLOW_HEAD:
				return allowHead != ALLOW_HEAD_EDEFAULT;
			case EsbPackage.API_RESOURCE__ALLOW_PATCH:
				return allowPatch != ALLOW_PATCH_EDEFAULT;
			case EsbPackage.API_RESOURCE__CONTAINER:
				return container != null;
			case EsbPackage.API_RESOURCE__IN_SEQUENCE_TYPE:
				return inSequenceType != IN_SEQUENCE_TYPE_EDEFAULT;
			case EsbPackage.API_RESOURCE__IN_SEQUENCE_KEY:
				return inSequenceKey != null;
			case EsbPackage.API_RESOURCE__IN_SEQUENCE_NAME:
				return IN_SEQUENCE_NAME_EDEFAULT == null ? inSequenceName != null : !IN_SEQUENCE_NAME_EDEFAULT.equals(inSequenceName);
			case EsbPackage.API_RESOURCE__OUT_SEQUENCE_TYPE:
				return outSequenceType != OUT_SEQUENCE_TYPE_EDEFAULT;
			case EsbPackage.API_RESOURCE__OUT_SEQUENCE_KEY:
				return outSequenceKey != null;
			case EsbPackage.API_RESOURCE__OUT_SEQUENCE_NAME:
				return OUT_SEQUENCE_NAME_EDEFAULT == null ? outSequenceName != null : !OUT_SEQUENCE_NAME_EDEFAULT.equals(outSequenceName);
			case EsbPackage.API_RESOURCE__FAULT_SEQUENCE_TYPE:
				return faultSequenceType != FAULT_SEQUENCE_TYPE_EDEFAULT;
			case EsbPackage.API_RESOURCE__FAULT_SEQUENCE_KEY:
				return faultSequenceKey != null;
			case EsbPackage.API_RESOURCE__FAULT_SEQUENCE_NAME:
				return FAULT_SEQUENCE_NAME_EDEFAULT == null ? faultSequenceName != null : !FAULT_SEQUENCE_NAME_EDEFAULT.equals(faultSequenceName);
			case EsbPackage.API_RESOURCE__PROTOCOL:
				return protocol != PROTOCOL_EDEFAULT;
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
		result.append(" (urlStyle: ");
		result.append(urlStyle);
		result.append(", uriTemplate: ");
		result.append(uriTemplate);
		result.append(", urlMapping: ");
		result.append(urlMapping);
		result.append(", allowGet: ");
		result.append(allowGet);
		result.append(", allowPost: ");
		result.append(allowPost);
		result.append(", allowPut: ");
		result.append(allowPut);
		result.append(", allowDelete: ");
		result.append(allowDelete);
		result.append(", allowOptions: ");
		result.append(allowOptions);
		result.append(", allowHead: ");
		result.append(allowHead);
		result.append(", allowPatch: ");
		result.append(allowPatch);
		result.append(", inSequenceType: ");
		result.append(inSequenceType);
		result.append(", inSequenceName: ");
		result.append(inSequenceName);
		result.append(", outSequenceType: ");
		result.append(outSequenceType);
		result.append(", outSequenceName: ");
		result.append(outSequenceName);
		result.append(", faultSequenceType: ");
		result.append(faultSequenceType);
		result.append(", faultSequenceName: ");
		result.append(faultSequenceName);
		result.append(", protocol: ");
		result.append(protocol);
		result.append(')');
		return result.toString();
	}

} //APIResourceImpl
