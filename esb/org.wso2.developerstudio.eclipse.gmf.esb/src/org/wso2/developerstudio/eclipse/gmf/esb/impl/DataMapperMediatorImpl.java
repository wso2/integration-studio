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
package org.wso2.developerstudio.eclipse.gmf.esb.impl;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.wso2.developerstudio.eclipse.esb.core.utils.ESBMediaTypeConstants;
import org.wso2.developerstudio.eclipse.gmf.esb.DataMapperMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.DataMapperMediatorDataTypes;
import org.wso2.developerstudio.eclipse.gmf.esb.DataMapperMediatorInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.DataMapperMediatorOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.platform.core.utils.CSProviderConstants;
import org.wso2.developerstudio.eclipse.platform.core.utils.DeveloperStudioProviderUtils;



/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Mapper Mediator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.DataMapperMediatorImpl#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.DataMapperMediatorImpl#getInputType <em>Input Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.DataMapperMediatorImpl#getOutputConnector <em>Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.DataMapperMediatorImpl#getConfiguration <em>Configuration</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.DataMapperMediatorImpl#getInputSchema <em>Input Schema</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.DataMapperMediatorImpl#getOutputSchema <em>Output Schema</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.DataMapperMediatorImpl#getConfigurationLocalPath <em>Configuration Local Path</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.DataMapperMediatorImpl#getInputSchemaLocalPath <em>Input Schema Local Path</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.DataMapperMediatorImpl#getOutputSchemaLocalPath <em>Output Schema Local Path</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.DataMapperMediatorImpl#getOutputType <em>Output Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DataMapperMediatorImpl extends MediatorImpl implements DataMapperMediator {
	/**
	 * The cached value of the '{@link #getInputConnector() <em>Input Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputConnector()
	 * @generated
	 * @ordered
	 */
	protected DataMapperMediatorInputConnector inputConnector;

	/**
	 * The default value of the '{@link #getInputType() <em>Input Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputType()
	 * @generated
	 * @ordered
	 */
	protected static final DataMapperMediatorDataTypes INPUT_TYPE_EDEFAULT = DataMapperMediatorDataTypes.XML;

	/**
	 * The cached value of the '{@link #getInputType() <em>Input Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputType()
	 * @generated
	 * @ordered
	 */
	protected DataMapperMediatorDataTypes inputType = INPUT_TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOutputConnector() <em>Output Connector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputConnector()
	 * @generated
	 * @ordered
	 */
	protected DataMapperMediatorOutputConnector outputConnector;

	/**
	 * The cached value of the '{@link #getConfiguration() <em>Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfiguration()
	 * @generated
	 * @ordered
	 */
	protected RegistryKeyProperty configuration;

	/**
	 * The cached value of the '{@link #getInputSchema() <em>Input Schema</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputSchema()
	 * @generated
	 * @ordered
	 */
	protected RegistryKeyProperty inputSchema;

	/**
	 * The cached value of the '{@link #getOutputSchema() <em>Output Schema</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputSchema()
	 * @generated
	 * @ordered
	 */
	protected RegistryKeyProperty outputSchema;

	/**
	 * The default value of the '{@link #getConfigurationLocalPath() <em>Configuration Local Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfigurationLocalPath()
	 * @generated
	 * @ordered
	 */
	protected static final String CONFIGURATION_LOCAL_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getConfigurationLocalPath() <em>Configuration Local Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfigurationLocalPath()
	 * @generated
	 * @ordered
	 */
	protected String configurationLocalPath = CONFIGURATION_LOCAL_PATH_EDEFAULT;

	/**
	 * The default value of the '{@link #getInputSchemaLocalPath() <em>Input Schema Local Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputSchemaLocalPath()
	 * @generated
	 * @ordered
	 */
	protected static final String INPUT_SCHEMA_LOCAL_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInputSchemaLocalPath() <em>Input Schema Local Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputSchemaLocalPath()
	 * @generated
	 * @ordered
	 */
	protected String inputSchemaLocalPath = INPUT_SCHEMA_LOCAL_PATH_EDEFAULT;

	/**
	 * The default value of the '{@link #getOutputSchemaLocalPath() <em>Output Schema Local Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputSchemaLocalPath()
	 * @generated
	 * @ordered
	 */
	protected static final String OUTPUT_SCHEMA_LOCAL_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOutputSchemaLocalPath() <em>Output Schema Local Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputSchemaLocalPath()
	 * @generated
	 * @ordered
	 */
	protected String outputSchemaLocalPath = OUTPUT_SCHEMA_LOCAL_PATH_EDEFAULT;

	/**
	 * The default value of the '{@link #getOutputType() <em>Output Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputType()
	 * @generated
	 * @ordered
	 */
	protected static final DataMapperMediatorDataTypes OUTPUT_TYPE_EDEFAULT = DataMapperMediatorDataTypes.XML;

	/**
	 * The cached value of the '{@link #getOutputType() <em>Output Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputType()
	 * @generated
	 * @ordered
	 */
	protected DataMapperMediatorDataTypes outputType = OUTPUT_TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected DataMapperMediatorImpl() {
		super();

  		RegistryKeyProperty configuration = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
  		configuration.setKeyName("Configuration");
  		configuration.setPrettyName("configuration");
  		//configuration.setKeyValue("/default/key");
  		setConfiguration(configuration);
  		
  		RegistryKeyProperty inputSchema = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
  		inputSchema.setKeyName("InputSchema");
  		inputSchema.setPrettyName("inputschema");
  		//inputSchema.setKeyValue("/default/key");
  		setInputSchema(inputSchema);
  		
  		RegistryKeyProperty outputSchema = EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
  		outputSchema.setKeyName("OutputSchema");
  		outputSchema.setPrettyName("outputschema");
  		//outputSchema.setKeyValue("/default/key");
  		setOutputSchema(outputSchema);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.DATA_MAPPER_MEDIATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataMapperMediatorInputConnector getInputConnector() {
		return inputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInputConnector(DataMapperMediatorInputConnector newInputConnector, NotificationChain msgs) {
		DataMapperMediatorInputConnector oldInputConnector = inputConnector;
		inputConnector = newInputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.DATA_MAPPER_MEDIATOR__INPUT_CONNECTOR, oldInputConnector, newInputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInputConnector(DataMapperMediatorInputConnector newInputConnector) {
		if (newInputConnector != inputConnector) {
			NotificationChain msgs = null;
			if (inputConnector != null)
				msgs = ((InternalEObject)inputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.DATA_MAPPER_MEDIATOR__INPUT_CONNECTOR, null, msgs);
			if (newInputConnector != null)
				msgs = ((InternalEObject)newInputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.DATA_MAPPER_MEDIATOR__INPUT_CONNECTOR, null, msgs);
			msgs = basicSetInputConnector(newInputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.DATA_MAPPER_MEDIATOR__INPUT_CONNECTOR, newInputConnector, newInputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataMapperMediatorDataTypes getInputType() {
		return inputType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInputType(DataMapperMediatorDataTypes newInputType) {
		DataMapperMediatorDataTypes oldInputType = inputType;
		inputType = newInputType == null ? INPUT_TYPE_EDEFAULT : newInputType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.DATA_MAPPER_MEDIATOR__INPUT_TYPE, oldInputType, inputType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataMapperMediatorOutputConnector getOutputConnector() {
		return outputConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOutputConnector(DataMapperMediatorOutputConnector newOutputConnector, NotificationChain msgs) {
		DataMapperMediatorOutputConnector oldOutputConnector = outputConnector;
		outputConnector = newOutputConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.DATA_MAPPER_MEDIATOR__OUTPUT_CONNECTOR, oldOutputConnector, newOutputConnector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutputConnector(DataMapperMediatorOutputConnector newOutputConnector) {
		if (newOutputConnector != outputConnector) {
			NotificationChain msgs = null;
			if (outputConnector != null)
				msgs = ((InternalEObject)outputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.DATA_MAPPER_MEDIATOR__OUTPUT_CONNECTOR, null, msgs);
			if (newOutputConnector != null)
				msgs = ((InternalEObject)newOutputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.DATA_MAPPER_MEDIATOR__OUTPUT_CONNECTOR, null, msgs);
			msgs = basicSetOutputConnector(newOutputConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.DATA_MAPPER_MEDIATOR__OUTPUT_CONNECTOR, newOutputConnector, newOutputConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegistryKeyProperty getConfiguration() {
		return configuration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConfiguration(RegistryKeyProperty newConfiguration, NotificationChain msgs) {
		RegistryKeyProperty oldConfiguration = configuration;
		configuration = newConfiguration;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.DATA_MAPPER_MEDIATOR__CONFIGURATION, oldConfiguration, newConfiguration);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConfiguration(RegistryKeyProperty newConfiguration) {
		if (newConfiguration != configuration) {
			NotificationChain msgs = null;
			if (configuration != null)
				msgs = ((InternalEObject)configuration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.DATA_MAPPER_MEDIATOR__CONFIGURATION, null, msgs);
			if (newConfiguration != null)
				msgs = ((InternalEObject)newConfiguration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.DATA_MAPPER_MEDIATOR__CONFIGURATION, null, msgs);
			msgs = basicSetConfiguration(newConfiguration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.DATA_MAPPER_MEDIATOR__CONFIGURATION, newConfiguration, newConfiguration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegistryKeyProperty getInputSchema() {
		return inputSchema;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInputSchema(RegistryKeyProperty newInputSchema, NotificationChain msgs) {
		RegistryKeyProperty oldInputSchema = inputSchema;
		inputSchema = newInputSchema;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.DATA_MAPPER_MEDIATOR__INPUT_SCHEMA, oldInputSchema, newInputSchema);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInputSchema(RegistryKeyProperty newInputSchema) {
		if (newInputSchema != inputSchema) {
			NotificationChain msgs = null;
			if (inputSchema != null)
				msgs = ((InternalEObject)inputSchema).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.DATA_MAPPER_MEDIATOR__INPUT_SCHEMA, null, msgs);
			if (newInputSchema != null)
				msgs = ((InternalEObject)newInputSchema).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.DATA_MAPPER_MEDIATOR__INPUT_SCHEMA, null, msgs);
			msgs = basicSetInputSchema(newInputSchema, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.DATA_MAPPER_MEDIATOR__INPUT_SCHEMA, newInputSchema, newInputSchema));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegistryKeyProperty getOutputSchema() {
		return outputSchema;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOutputSchema(RegistryKeyProperty newOutputSchema, NotificationChain msgs) {
		RegistryKeyProperty oldOutputSchema = outputSchema;
		outputSchema = newOutputSchema;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.DATA_MAPPER_MEDIATOR__OUTPUT_SCHEMA, oldOutputSchema, newOutputSchema);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutputSchema(RegistryKeyProperty newOutputSchema) {
		if (newOutputSchema != outputSchema) {
			NotificationChain msgs = null;
			if (outputSchema != null)
				msgs = ((InternalEObject)outputSchema).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.DATA_MAPPER_MEDIATOR__OUTPUT_SCHEMA, null, msgs);
			if (newOutputSchema != null)
				msgs = ((InternalEObject)newOutputSchema).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.DATA_MAPPER_MEDIATOR__OUTPUT_SCHEMA, null, msgs);
			msgs = basicSetOutputSchema(newOutputSchema, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.DATA_MAPPER_MEDIATOR__OUTPUT_SCHEMA, newOutputSchema, newOutputSchema));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getConfigurationLocalPath() {
		return configurationLocalPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConfigurationLocalPath(String newConfigurationLocalPath) {
		String oldConfigurationLocalPath = configurationLocalPath;
		configurationLocalPath = newConfigurationLocalPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.DATA_MAPPER_MEDIATOR__CONFIGURATION_LOCAL_PATH, oldConfigurationLocalPath, configurationLocalPath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInputSchemaLocalPath() {
		return inputSchemaLocalPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInputSchemaLocalPath(String newInputSchemaLocalPath) {
		String oldInputSchemaLocalPath = inputSchemaLocalPath;
		inputSchemaLocalPath = newInputSchemaLocalPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.DATA_MAPPER_MEDIATOR__INPUT_SCHEMA_LOCAL_PATH, oldInputSchemaLocalPath, inputSchemaLocalPath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOutputSchemaLocalPath() {
		return outputSchemaLocalPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutputSchemaLocalPath(String newOutputSchemaLocalPath) {
		String oldOutputSchemaLocalPath = outputSchemaLocalPath;
		outputSchemaLocalPath = newOutputSchemaLocalPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.DATA_MAPPER_MEDIATOR__OUTPUT_SCHEMA_LOCAL_PATH, oldOutputSchemaLocalPath, outputSchemaLocalPath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataMapperMediatorDataTypes getOutputType() {
		return outputType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutputType(DataMapperMediatorDataTypes newOutputType) {
		DataMapperMediatorDataTypes oldOutputType = outputType;
		outputType = newOutputType == null ? OUTPUT_TYPE_EDEFAULT : newOutputType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.DATA_MAPPER_MEDIATOR__OUTPUT_TYPE, oldOutputType, outputType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsbPackage.DATA_MAPPER_MEDIATOR__INPUT_CONNECTOR:
				return basicSetInputConnector(null, msgs);
			case EsbPackage.DATA_MAPPER_MEDIATOR__OUTPUT_CONNECTOR:
				return basicSetOutputConnector(null, msgs);
			case EsbPackage.DATA_MAPPER_MEDIATOR__CONFIGURATION:
				return basicSetConfiguration(null, msgs);
			case EsbPackage.DATA_MAPPER_MEDIATOR__INPUT_SCHEMA:
				return basicSetInputSchema(null, msgs);
			case EsbPackage.DATA_MAPPER_MEDIATOR__OUTPUT_SCHEMA:
				return basicSetOutputSchema(null, msgs);
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
			case EsbPackage.DATA_MAPPER_MEDIATOR__INPUT_CONNECTOR:
				return getInputConnector();
			case EsbPackage.DATA_MAPPER_MEDIATOR__INPUT_TYPE:
				return getInputType();
			case EsbPackage.DATA_MAPPER_MEDIATOR__OUTPUT_CONNECTOR:
				return getOutputConnector();
			case EsbPackage.DATA_MAPPER_MEDIATOR__CONFIGURATION:
				return getConfiguration();
			case EsbPackage.DATA_MAPPER_MEDIATOR__INPUT_SCHEMA:
				return getInputSchema();
			case EsbPackage.DATA_MAPPER_MEDIATOR__OUTPUT_SCHEMA:
				return getOutputSchema();
			case EsbPackage.DATA_MAPPER_MEDIATOR__CONFIGURATION_LOCAL_PATH:
				return getConfigurationLocalPath();
			case EsbPackage.DATA_MAPPER_MEDIATOR__INPUT_SCHEMA_LOCAL_PATH:
				return getInputSchemaLocalPath();
			case EsbPackage.DATA_MAPPER_MEDIATOR__OUTPUT_SCHEMA_LOCAL_PATH:
				return getOutputSchemaLocalPath();
			case EsbPackage.DATA_MAPPER_MEDIATOR__OUTPUT_TYPE:
				return getOutputType();
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
			case EsbPackage.DATA_MAPPER_MEDIATOR__INPUT_CONNECTOR:
				setInputConnector((DataMapperMediatorInputConnector)newValue);
				return;
			case EsbPackage.DATA_MAPPER_MEDIATOR__INPUT_TYPE:
				setInputType((DataMapperMediatorDataTypes)newValue);
				return;
			case EsbPackage.DATA_MAPPER_MEDIATOR__OUTPUT_CONNECTOR:
				setOutputConnector((DataMapperMediatorOutputConnector)newValue);
				return;
			case EsbPackage.DATA_MAPPER_MEDIATOR__CONFIGURATION:
				setConfiguration((RegistryKeyProperty)newValue);
				return;
			case EsbPackage.DATA_MAPPER_MEDIATOR__INPUT_SCHEMA:
				setInputSchema((RegistryKeyProperty)newValue);
				return;
			case EsbPackage.DATA_MAPPER_MEDIATOR__OUTPUT_SCHEMA:
				setOutputSchema((RegistryKeyProperty)newValue);
				return;
			case EsbPackage.DATA_MAPPER_MEDIATOR__CONFIGURATION_LOCAL_PATH:
				setConfigurationLocalPath((String)newValue);
				return;
			case EsbPackage.DATA_MAPPER_MEDIATOR__INPUT_SCHEMA_LOCAL_PATH:
				setInputSchemaLocalPath((String)newValue);
				return;
			case EsbPackage.DATA_MAPPER_MEDIATOR__OUTPUT_SCHEMA_LOCAL_PATH:
				setOutputSchemaLocalPath((String)newValue);
				return;
			case EsbPackage.DATA_MAPPER_MEDIATOR__OUTPUT_TYPE:
				setOutputType((DataMapperMediatorDataTypes)newValue);
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
			case EsbPackage.DATA_MAPPER_MEDIATOR__INPUT_CONNECTOR:
				setInputConnector((DataMapperMediatorInputConnector)null);
				return;
			case EsbPackage.DATA_MAPPER_MEDIATOR__INPUT_TYPE:
				setInputType(INPUT_TYPE_EDEFAULT);
				return;
			case EsbPackage.DATA_MAPPER_MEDIATOR__OUTPUT_CONNECTOR:
				setOutputConnector((DataMapperMediatorOutputConnector)null);
				return;
			case EsbPackage.DATA_MAPPER_MEDIATOR__CONFIGURATION:
				setConfiguration((RegistryKeyProperty)null);
				return;
			case EsbPackage.DATA_MAPPER_MEDIATOR__INPUT_SCHEMA:
				setInputSchema((RegistryKeyProperty)null);
				return;
			case EsbPackage.DATA_MAPPER_MEDIATOR__OUTPUT_SCHEMA:
				setOutputSchema((RegistryKeyProperty)null);
				return;
			case EsbPackage.DATA_MAPPER_MEDIATOR__CONFIGURATION_LOCAL_PATH:
				setConfigurationLocalPath(CONFIGURATION_LOCAL_PATH_EDEFAULT);
				return;
			case EsbPackage.DATA_MAPPER_MEDIATOR__INPUT_SCHEMA_LOCAL_PATH:
				setInputSchemaLocalPath(INPUT_SCHEMA_LOCAL_PATH_EDEFAULT);
				return;
			case EsbPackage.DATA_MAPPER_MEDIATOR__OUTPUT_SCHEMA_LOCAL_PATH:
				setOutputSchemaLocalPath(OUTPUT_SCHEMA_LOCAL_PATH_EDEFAULT);
				return;
			case EsbPackage.DATA_MAPPER_MEDIATOR__OUTPUT_TYPE:
				setOutputType(OUTPUT_TYPE_EDEFAULT);
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
			case EsbPackage.DATA_MAPPER_MEDIATOR__INPUT_CONNECTOR:
				return inputConnector != null;
			case EsbPackage.DATA_MAPPER_MEDIATOR__INPUT_TYPE:
				return inputType != INPUT_TYPE_EDEFAULT;
			case EsbPackage.DATA_MAPPER_MEDIATOR__OUTPUT_CONNECTOR:
				return outputConnector != null;
			case EsbPackage.DATA_MAPPER_MEDIATOR__CONFIGURATION:
				return configuration != null;
			case EsbPackage.DATA_MAPPER_MEDIATOR__INPUT_SCHEMA:
				return inputSchema != null;
			case EsbPackage.DATA_MAPPER_MEDIATOR__OUTPUT_SCHEMA:
				return outputSchema != null;
			case EsbPackage.DATA_MAPPER_MEDIATOR__CONFIGURATION_LOCAL_PATH:
				return CONFIGURATION_LOCAL_PATH_EDEFAULT == null ? configurationLocalPath != null : !CONFIGURATION_LOCAL_PATH_EDEFAULT.equals(configurationLocalPath);
			case EsbPackage.DATA_MAPPER_MEDIATOR__INPUT_SCHEMA_LOCAL_PATH:
				return INPUT_SCHEMA_LOCAL_PATH_EDEFAULT == null ? inputSchemaLocalPath != null : !INPUT_SCHEMA_LOCAL_PATH_EDEFAULT.equals(inputSchemaLocalPath);
			case EsbPackage.DATA_MAPPER_MEDIATOR__OUTPUT_SCHEMA_LOCAL_PATH:
				return OUTPUT_SCHEMA_LOCAL_PATH_EDEFAULT == null ? outputSchemaLocalPath != null : !OUTPUT_SCHEMA_LOCAL_PATH_EDEFAULT.equals(outputSchemaLocalPath);
			case EsbPackage.DATA_MAPPER_MEDIATOR__OUTPUT_TYPE:
				return outputType != OUTPUT_TYPE_EDEFAULT;
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
		result.append(" (inputType: ");
		result.append(inputType);
		result.append(", configurationLocalPath: ");
		result.append(configurationLocalPath);
		result.append(", inputSchemaLocalPath: ");
		result.append(inputSchemaLocalPath);
		result.append(", outputSchemaLocalPath: ");
		result.append(outputSchemaLocalPath);
		result.append(", outputType: ");
		result.append(outputType);
		result.append(')');
		return result.toString();
	}

} //DataMapperMediatorImpl
