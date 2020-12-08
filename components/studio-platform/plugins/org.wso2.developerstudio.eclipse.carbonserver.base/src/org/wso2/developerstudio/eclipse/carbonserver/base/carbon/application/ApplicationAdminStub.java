/**
 * ApplicationAdminStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6-wso2v2 Built on : Sep 04, 2010 (05:02:54
 * UTC)
 */
package org.wso2.developerstudio.eclipse.carbonserver.base.carbon.application;

/*
 * ApplicationAdminStub java implementation
 */

public class ApplicationAdminStub extends org.apache.axis2.client.Stub {
	protected org.apache.axis2.description.AxisOperation[] _operations;

	// hashmaps to keep the fault mapping
	private java.util.HashMap faultExceptionNameMap = new java.util.HashMap();
	private java.util.HashMap faultExceptionClassNameMap = new java.util.HashMap();
	private java.util.HashMap faultMessageMap = new java.util.HashMap();

	private static int counter = 0;

	private static synchronized java.lang.String getUniqueSuffix() {
		// reset the counter if it is greater than 99999
		if (counter > 99999) {
			counter = 0;
		}
		counter = counter + 1;
		return java.lang.Long.toString(System.currentTimeMillis()) + "_" + counter;
	}

	private void populateAxisService() throws org.apache.axis2.AxisFault {

		// creating the Service with a unique name
		_service = new org.apache.axis2.description.AxisService("ApplicationAdmin" + getUniqueSuffix());
		addAnonymousOperations();

		// creating the operations
		org.apache.axis2.description.AxisOperation __operation;

		_operations = new org.apache.axis2.description.AxisOperation[3];

		__operation = new org.apache.axis2.description.OutInAxisOperation();

		__operation.setName(new javax.xml.namespace.QName("http://mgt.application.carbon.wso2.org", "getAppData"));
		_service.addOperation(__operation);

		_operations[0] = __operation;

		__operation = new org.apache.axis2.description.OutInAxisOperation();

		__operation.setName(new javax.xml.namespace.QName("http://mgt.application.carbon.wso2.org",
		                                                  "listAllApplications"));
		_service.addOperation(__operation);

		_operations[1] = __operation;

		__operation = new org.apache.axis2.description.RobustOutOnlyAxisOperation();

		__operation.setName(new javax.xml.namespace.QName("http://mgt.application.carbon.wso2.org", "deleteApplication"));
		_service.addOperation(__operation);

		_operations[2] = __operation;

	}

	// populates the faults
	private void populateFaults() {

		faultExceptionNameMap.put(new org.apache.axis2.client.FaultMapKey(
		                                                                  new javax.xml.namespace.QName(
		                                                                                                "http://mgt.application.carbon.wso2.org",
		                                                                                                "Exception"),
		                                                                  "getAppData"),
		                          "org.wso2.developerstudio.eclipse.carbonserver.base.carbon.application.ExceptionException");
		faultExceptionClassNameMap.put(new org.apache.axis2.client.FaultMapKey(
		                                                                       new javax.xml.namespace.QName(
		                                                                                                     "http://mgt.application.carbon.wso2.org",
		                                                                                                     "Exception"),
		                                                                       "getAppData"),
		                               "org.wso2.developerstudio.eclipse.carbonserver.base.carbon.application.ExceptionException");
		faultMessageMap.put(new org.apache.axis2.client.FaultMapKey(
		                                                            new javax.xml.namespace.QName(
		                                                                                          "http://mgt.application.carbon.wso2.org",
		                                                                                          "Exception"),
		                                                            "getAppData"),
		                    "org.wso2.developerstudio.eclipse.carbonserver.base.carbon.application.ApplicationAdminStub$ExceptionE");

		faultExceptionNameMap.put(new org.apache.axis2.client.FaultMapKey(
		                                                                  new javax.xml.namespace.QName(
		                                                                                                "http://mgt.application.carbon.wso2.org",
		                                                                                                "Exception"),
		                                                                  "listAllApplications"),
		                          "org.wso2.developerstudio.eclipse.carbonserver.base.carbon.application.ExceptionException");
		faultExceptionClassNameMap.put(new org.apache.axis2.client.FaultMapKey(
		                                                                       new javax.xml.namespace.QName(
		                                                                                                     "http://mgt.application.carbon.wso2.org",
		                                                                                                     "Exception"),
		                                                                       "listAllApplications"),
		                               "org.wso2.developerstudio.eclipse.carbonserver.base.carbon.application.ExceptionException");
		faultMessageMap.put(new org.apache.axis2.client.FaultMapKey(
		                                                            new javax.xml.namespace.QName(
		                                                                                          "http://mgt.application.carbon.wso2.org",
		                                                                                          "Exception"),
		                                                            "listAllApplications"),
		                    "org.wso2.developerstudio.eclipse.carbonserver.base.carbon.application.ApplicationAdminStub$ExceptionE");

		faultExceptionNameMap.put(new org.apache.axis2.client.FaultMapKey(
		                                                                  new javax.xml.namespace.QName(
		                                                                                                "http://mgt.application.carbon.wso2.org",
		                                                                                                "Exception"),
		                                                                  "deleteApplication"),
		                          "org.wso2.developerstudio.eclipse.carbonserver.base.carbon.application.ExceptionException");
		faultExceptionClassNameMap.put(new org.apache.axis2.client.FaultMapKey(
		                                                                       new javax.xml.namespace.QName(
		                                                                                                     "http://mgt.application.carbon.wso2.org",
		                                                                                                     "Exception"),
		                                                                       "deleteApplication"),
		                               "org.wso2.developerstudio.eclipse.carbonserver.base.carbon.application.ExceptionException");
		faultMessageMap.put(new org.apache.axis2.client.FaultMapKey(
		                                                            new javax.xml.namespace.QName(
		                                                                                          "http://mgt.application.carbon.wso2.org",
		                                                                                          "Exception"),
		                                                            "deleteApplication"),
		                    "org.wso2.developerstudio.eclipse.carbonserver.base.carbon.application.ApplicationAdminStub$ExceptionE");

	}

	/**
	 * Constructor that takes in a configContext
	 */

	public ApplicationAdminStub(org.apache.axis2.context.ConfigurationContext configurationContext,
	                            java.lang.String targetEndpoint) throws org.apache.axis2.AxisFault {
		this(configurationContext, targetEndpoint, false);
	}

	/**
	 * Constructor that takes in a configContext and useseperate listner
	 */
	public ApplicationAdminStub(org.apache.axis2.context.ConfigurationContext configurationContext,
	                            java.lang.String targetEndpoint, boolean useSeparateListener)
	                                                                                         throws org.apache.axis2.AxisFault {
		// To populate AxisService
		populateAxisService();
		populateFaults();

		_serviceClient = new org.apache.axis2.client.ServiceClient(configurationContext, _service);

		_serviceClient.getOptions().setTo(new org.apache.axis2.addressing.EndpointReference(targetEndpoint));
		_serviceClient.getOptions().setUseSeparateListener(useSeparateListener);

		// Set the soap version
		_serviceClient.getOptions()
		              .setSoapVersionURI(org.apache.axiom.soap.SOAP12Constants.SOAP_ENVELOPE_NAMESPACE_URI);

	}

	/**
	 * Default Constructor
	 */
	public ApplicationAdminStub(org.apache.axis2.context.ConfigurationContext configurationContext)
	                                                                                               throws org.apache.axis2.AxisFault {

		this(configurationContext,
		     "https://localhost:8243/services/ApplicationAdmin.ApplicationAdminHttpsSoap12Endpoint");

	}

	/**
	 * Default Constructor
	 */
	public ApplicationAdminStub() throws org.apache.axis2.AxisFault {

		this("https://localhost:8243/services/ApplicationAdmin.ApplicationAdminHttpsSoap12Endpoint");

	}

	/**
	 * Constructor taking the target endpoint
	 */
	public ApplicationAdminStub(java.lang.String targetEndpoint) throws org.apache.axis2.AxisFault {
		this(null, targetEndpoint);
	}

	/**
	 * Auto generated method signature
	 * 
	 * @see org.wso2.developerstudio.eclipse.carbonserver.base.carbon.application.ApplicationAdmin#getAppData
	 * @param getAppData3
	 * 
	 * @throws org.wso2.developerstudio.eclipse.carbonserver.base.carbon.application.ExceptionException
	 *             :
	 */

	public org.wso2.developerstudio.eclipse.carbonserver.base.carbon.application.ApplicationAdminStub.ApplicationMetadata getAppData(

	java.lang.String appName4)

	throws java.rmi.RemoteException

	, org.wso2.developerstudio.eclipse.carbonserver.base.carbon.application.ExceptionException {
		org.apache.axis2.context.MessageContext _messageContext = null;
		try {
			org.apache.axis2.client.OperationClient _operationClient =
			                                                           _serviceClient.createClient(_operations[0].getName());
			_operationClient.getOptions().setAction("urn:getAppData");
			_operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

			addPropertyToOperationClient(_operationClient,
			                             org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
			                             "&");

			// create a message context
			_messageContext = new org.apache.axis2.context.MessageContext();

			// create SOAP envelope with that payload
			org.apache.axiom.soap.SOAPEnvelope env = null;
			org.wso2.developerstudio.eclipse.carbonserver.base.carbon.application.ApplicationAdminStub.GetAppData dummyWrappedType =
			                                                                                                                         null;
			env =
			      toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()), appName4, dummyWrappedType,
			                 optimizeContent(new javax.xml.namespace.QName("http://mgt.application.carbon.wso2.org",
			                                                               "getAppData")));

			// adding SOAP soap_headers
			_serviceClient.addHeadersToEnvelope(env);
			// set the message context with that soap envelope
			_messageContext.setEnvelope(env);

			// add the message contxt to the operation client
			_operationClient.addMessageContext(_messageContext);

			// execute the operation client
			_operationClient.execute(true);

			org.apache.axis2.context.MessageContext _returnMessageContext =
			                                                                _operationClient.getMessageContext(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
			org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();

			java.lang.Object object =
			                          fromOM(_returnEnv.getBody().getFirstElement(),
			                                 org.wso2.developerstudio.eclipse.carbonserver.base.carbon.application.ApplicationAdminStub.GetAppDataResponse.class,
			                                 getEnvelopeNamespaces(_returnEnv));

			return getGetAppDataResponse_return((org.wso2.developerstudio.eclipse.carbonserver.base.carbon.application.ApplicationAdminStub.GetAppDataResponse) object);

		} catch (org.apache.axis2.AxisFault f) {

			org.apache.axiom.om.OMElement faultElt = f.getDetail();
			if (faultElt != null) {
				if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),
				                                                                              "getAppData"))) {
					// make the fault by reflection
					try {
						java.lang.String exceptionClassName =
						                                      (java.lang.String) faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(
						                                                                                                                                faultElt.getQName(),
						                                                                                                                                "getAppData"));
						java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
						java.lang.Exception ex = (java.lang.Exception) exceptionClass.newInstance();
						// message class
						java.lang.String messageClassName =
						                                    (java.lang.String) faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(
						                                                                                                                   faultElt.getQName(),
						                                                                                                                   "getAppData"));
						java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
						java.lang.Object messageObject = fromOM(faultElt, messageClass, null);
						java.lang.reflect.Method m =
						                             exceptionClass.getMethod("setFaultMessage",
						                                                      new java.lang.Class[] { messageClass });
						m.invoke(ex, new java.lang.Object[] { messageObject });

						if (ex instanceof org.wso2.developerstudio.eclipse.carbonserver.base.carbon.application.ExceptionException) {
							throw (org.wso2.developerstudio.eclipse.carbonserver.base.carbon.application.ExceptionException) ex;
						}

						throw new java.rmi.RemoteException(ex.getMessage(), ex);
					} catch (java.lang.ClassCastException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					} catch (java.lang.ClassNotFoundException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					} catch (java.lang.NoSuchMethodException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					} catch (java.lang.reflect.InvocationTargetException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					} catch (java.lang.IllegalAccessException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					} catch (java.lang.InstantiationException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					}
				} else {
					throw f;
				}
			} else {
				throw f;
			}
		} finally {
			_messageContext.getTransportOut().getSender().cleanup(_messageContext);
		}
	}

	/**
	 * Auto generated method signature for Asynchronous Invocations
	 * 
	 * @see org.wso2.developerstudio.eclipse.carbonserver.base.carbon.application.ApplicationAdmin#startgetAppData
	 * @param getAppData3
	 */
	public void startgetAppData(

	java.lang.String appName4,

	final org.wso2.developerstudio.eclipse.carbonserver.base.carbon.application.ApplicationAdminCallbackHandler callback)

	throws java.rmi.RemoteException {

		org.apache.axis2.client.OperationClient _operationClient =
		                                                           _serviceClient.createClient(_operations[0].getName());
		_operationClient.getOptions().setAction("urn:getAppData");
		_operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

		addPropertyToOperationClient(_operationClient,
		                             org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
		                             "&");

		// create SOAP envelope with that payload
		org.apache.axiom.soap.SOAPEnvelope env = null;
		final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

		// Style is Doc.
		org.wso2.developerstudio.eclipse.carbonserver.base.carbon.application.ApplicationAdminStub.GetAppData dummyWrappedType =
		                                                                                                                         null;
		env =
		      toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()), appName4, dummyWrappedType,
		                 optimizeContent(new javax.xml.namespace.QName("http://mgt.application.carbon.wso2.org",
		                                                               "getAppData")));

		// adding SOAP soap_headers
		_serviceClient.addHeadersToEnvelope(env);
		// create message context with that soap envelope
		_messageContext.setEnvelope(env);

		// add the message context to the operation client
		_operationClient.addMessageContext(_messageContext);

		_operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
			public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
				try {
					org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();

					java.lang.Object object =
					                          fromOM(resultEnv.getBody().getFirstElement(),
					                                 org.wso2.developerstudio.eclipse.carbonserver.base.carbon.application.ApplicationAdminStub.GetAppDataResponse.class,
					                                 getEnvelopeNamespaces(resultEnv));
					callback.receiveResultgetAppData(getGetAppDataResponse_return((org.wso2.developerstudio.eclipse.carbonserver.base.carbon.application.ApplicationAdminStub.GetAppDataResponse) object));

				} catch (org.apache.axis2.AxisFault e) {
					callback.receiveErrorgetAppData(e);
				}
			}

			public void onError(java.lang.Exception error) {
				if (error instanceof org.apache.axis2.AxisFault) {
					org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
					org.apache.axiom.om.OMElement faultElt = f.getDetail();
					if (faultElt != null) {
						if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(
						                                                                              faultElt.getQName(),
						                                                                              "getAppData"))) {
							// make the fault by reflection
							try {
								java.lang.String exceptionClassName =
								                                      (java.lang.String) faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(
								                                                                                                                                faultElt.getQName(),
								                                                                                                                                "getAppData"));
								java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
								java.lang.Exception ex = (java.lang.Exception) exceptionClass.newInstance();
								// message class
								java.lang.String messageClassName =
								                                    (java.lang.String) faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(
								                                                                                                                   faultElt.getQName(),
								                                                                                                                   "getAppData"));
								java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
								java.lang.Object messageObject = fromOM(faultElt, messageClass, null);
								java.lang.reflect.Method m =
								                             exceptionClass.getMethod("setFaultMessage",
								                                                      new java.lang.Class[] { messageClass });
								m.invoke(ex, new java.lang.Object[] { messageObject });

								if (ex instanceof org.wso2.developerstudio.eclipse.carbonserver.base.carbon.application.ExceptionException) {
									callback.receiveErrorgetAppData((org.wso2.developerstudio.eclipse.carbonserver.base.carbon.application.ExceptionException) ex);
									return;
								}

								callback.receiveErrorgetAppData(new java.rmi.RemoteException(ex.getMessage(), ex));
							} catch (java.lang.ClassCastException e) {
								// we cannot intantiate the class - throw the
								// original Axis fault
								callback.receiveErrorgetAppData(f);
							} catch (java.lang.ClassNotFoundException e) {
								// we cannot intantiate the class - throw the
								// original Axis fault
								callback.receiveErrorgetAppData(f);
							} catch (java.lang.NoSuchMethodException e) {
								// we cannot intantiate the class - throw the
								// original Axis fault
								callback.receiveErrorgetAppData(f);
							} catch (java.lang.reflect.InvocationTargetException e) {
								// we cannot intantiate the class - throw the
								// original Axis fault
								callback.receiveErrorgetAppData(f);
							} catch (java.lang.IllegalAccessException e) {
								// we cannot intantiate the class - throw the
								// original Axis fault
								callback.receiveErrorgetAppData(f);
							} catch (java.lang.InstantiationException e) {
								// we cannot intantiate the class - throw the
								// original Axis fault
								callback.receiveErrorgetAppData(f);
							} catch (org.apache.axis2.AxisFault e) {
								// we cannot intantiate the class - throw the
								// original Axis fault
								callback.receiveErrorgetAppData(f);
							}
						} else {
							callback.receiveErrorgetAppData(f);
						}
					} else {
						callback.receiveErrorgetAppData(f);
					}
				} else {
					callback.receiveErrorgetAppData(error);
				}
			}

			public void onFault(org.apache.axis2.context.MessageContext faultContext) {
				org.apache.axis2.AxisFault fault =
				                                   org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
				onError(fault);
			}

			public void onComplete() {
				try {
					_messageContext.getTransportOut().getSender().cleanup(_messageContext);
				} catch (org.apache.axis2.AxisFault axisFault) {
					callback.receiveErrorgetAppData(axisFault);
				}
			}
		});

		org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
		if (_operations[0].getMessageReceiver() == null && _operationClient.getOptions().isUseSeparateListener()) {
			_callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
			_operations[0].setMessageReceiver(_callbackReceiver);
		}

		// execute the operation client
		_operationClient.execute(false);

	}

	/**
	 * Auto generated method signature
	 * 
	 * @see org.wso2.developerstudio.eclipse.carbonserver.base.carbon.application.ApplicationAdmin#listAllApplications
	 * @throws org.wso2.developerstudio.eclipse.carbonserver.base.carbon.application.ExceptionException
	 *             :
	 */

	public java.lang.String[] listAllApplications(

	)

	throws java.rmi.RemoteException

	, org.wso2.developerstudio.eclipse.carbonserver.base.carbon.application.ExceptionException {
		org.apache.axis2.context.MessageContext _messageContext = null;
		try {
			org.apache.axis2.client.OperationClient _operationClient =
			                                                           _serviceClient.createClient(_operations[1].getName());
			_operationClient.getOptions().setAction("urn:listAllApplications");
			_operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

			addPropertyToOperationClient(_operationClient,
			                             org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
			                             "&");

			// create a message context
			_messageContext = new org.apache.axis2.context.MessageContext();

			// create SOAP envelope with that payload
			org.apache.axiom.soap.SOAPEnvelope env = null;

			// Style is taken to be "document". No input parameters
			// according to the WS-Basic profile in this case we have to send an
			// empty soap message
			org.apache.axiom.soap.SOAPFactory factory = getFactory(_operationClient.getOptions().getSoapVersionURI());
			env = factory.getDefaultEnvelope();

			// adding SOAP soap_headers
			_serviceClient.addHeadersToEnvelope(env);
			// set the message context with that soap envelope
			_messageContext.setEnvelope(env);

			// add the message contxt to the operation client
			_operationClient.addMessageContext(_messageContext);

			// execute the operation client
			_operationClient.execute(true);

			org.apache.axis2.context.MessageContext _returnMessageContext =
			                                                                _operationClient.getMessageContext(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
			org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();

			java.lang.Object object =
			                          fromOM(_returnEnv.getBody().getFirstElement(),
			                                 org.wso2.developerstudio.eclipse.carbonserver.base.carbon.application.ApplicationAdminStub.ListAllApplicationsResponse.class,
			                                 getEnvelopeNamespaces(_returnEnv));

			return getListAllApplicationsResponse_return((org.wso2.developerstudio.eclipse.carbonserver.base.carbon.application.ApplicationAdminStub.ListAllApplicationsResponse) object);

		} catch (org.apache.axis2.AxisFault f) {

			org.apache.axiom.om.OMElement faultElt = f.getDetail();
			if (faultElt != null) {
				if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),
				                                                                              "listAllApplications"))) {
					// make the fault by reflection
					try {
						java.lang.String exceptionClassName =
						                                      (java.lang.String) faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(
						                                                                                                                                faultElt.getQName(),
						                                                                                                                                "listAllApplications"));
						java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
						java.lang.Exception ex = (java.lang.Exception) exceptionClass.newInstance();
						// message class
						java.lang.String messageClassName =
						                                    (java.lang.String) faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(
						                                                                                                                   faultElt.getQName(),
						                                                                                                                   "listAllApplications"));
						java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
						java.lang.Object messageObject = fromOM(faultElt, messageClass, null);
						java.lang.reflect.Method m =
						                             exceptionClass.getMethod("setFaultMessage",
						                                                      new java.lang.Class[] { messageClass });
						m.invoke(ex, new java.lang.Object[] { messageObject });

						if (ex instanceof org.wso2.developerstudio.eclipse.carbonserver.base.carbon.application.ExceptionException) {
							throw (org.wso2.developerstudio.eclipse.carbonserver.base.carbon.application.ExceptionException) ex;
						}

						throw new java.rmi.RemoteException(ex.getMessage(), ex);
					} catch (java.lang.ClassCastException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					} catch (java.lang.ClassNotFoundException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					} catch (java.lang.NoSuchMethodException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					} catch (java.lang.reflect.InvocationTargetException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					} catch (java.lang.IllegalAccessException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					} catch (java.lang.InstantiationException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					}
				} else {
					throw f;
				}
			} else {
				throw f;
			}
		} finally {
			_messageContext.getTransportOut().getSender().cleanup(_messageContext);
		}
	}

	/**
	 * Auto generated method signature for Asynchronous Invocations
	 * 
	 * @see org.wso2.developerstudio.eclipse.carbonserver.base.carbon.application.ApplicationAdmin#startlistAllApplications
	 */
	public void startlistAllApplications(

	final org.wso2.developerstudio.eclipse.carbonserver.base.carbon.application.ApplicationAdminCallbackHandler callback)

	throws java.rmi.RemoteException {

		org.apache.axis2.client.OperationClient _operationClient =
		                                                           _serviceClient.createClient(_operations[1].getName());
		_operationClient.getOptions().setAction("urn:listAllApplications");
		_operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

		addPropertyToOperationClient(_operationClient,
		                             org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
		                             "&");

		// create SOAP envelope with that payload
		org.apache.axiom.soap.SOAPEnvelope env = null;
		final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

		// Style is taken to be "document". No input parameters
		// according to the WS-Basic profile in this case we have to send an
		// empty soap message
		org.apache.axiom.soap.SOAPFactory factory = getFactory(_operationClient.getOptions().getSoapVersionURI());
		env = factory.getDefaultEnvelope();

		// adding SOAP soap_headers
		_serviceClient.addHeadersToEnvelope(env);
		// create message context with that soap envelope
		_messageContext.setEnvelope(env);

		// add the message context to the operation client
		_operationClient.addMessageContext(_messageContext);

		_operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
			public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
				try {
					org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();

					java.lang.Object object =
					                          fromOM(resultEnv.getBody().getFirstElement(),
					                                 org.wso2.developerstudio.eclipse.carbonserver.base.carbon.application.ApplicationAdminStub.ListAllApplicationsResponse.class,
					                                 getEnvelopeNamespaces(resultEnv));
					callback.receiveResultlistAllApplications(getListAllApplicationsResponse_return((org.wso2.developerstudio.eclipse.carbonserver.base.carbon.application.ApplicationAdminStub.ListAllApplicationsResponse) object));

				} catch (org.apache.axis2.AxisFault e) {
					callback.receiveErrorlistAllApplications(e);
				}
			}

			public void onError(java.lang.Exception error) {
				if (error instanceof org.apache.axis2.AxisFault) {
					org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
					org.apache.axiom.om.OMElement faultElt = f.getDetail();
					if (faultElt != null) {
						if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(
						                                                                              faultElt.getQName(),
						                                                                              "listAllApplications"))) {
							// make the fault by reflection
							try {
								java.lang.String exceptionClassName =
								                                      (java.lang.String) faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(
								                                                                                                                                faultElt.getQName(),
								                                                                                                                                "listAllApplications"));
								java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
								java.lang.Exception ex = (java.lang.Exception) exceptionClass.newInstance();
								// message class
								java.lang.String messageClassName =
								                                    (java.lang.String) faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(
								                                                                                                                   faultElt.getQName(),
								                                                                                                                   "listAllApplications"));
								java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
								java.lang.Object messageObject = fromOM(faultElt, messageClass, null);
								java.lang.reflect.Method m =
								                             exceptionClass.getMethod("setFaultMessage",
								                                                      new java.lang.Class[] { messageClass });
								m.invoke(ex, new java.lang.Object[] { messageObject });

								if (ex instanceof org.wso2.developerstudio.eclipse.carbonserver.base.carbon.application.ExceptionException) {
									callback.receiveErrorlistAllApplications((org.wso2.developerstudio.eclipse.carbonserver.base.carbon.application.ExceptionException) ex);
									return;
								}

								callback.receiveErrorlistAllApplications(new java.rmi.RemoteException(ex.getMessage(),
								                                                                      ex));
							} catch (java.lang.ClassCastException e) {
								// we cannot intantiate the class - throw the
								// original Axis fault
								callback.receiveErrorlistAllApplications(f);
							} catch (java.lang.ClassNotFoundException e) {
								// we cannot intantiate the class - throw the
								// original Axis fault
								callback.receiveErrorlistAllApplications(f);
							} catch (java.lang.NoSuchMethodException e) {
								// we cannot intantiate the class - throw the
								// original Axis fault
								callback.receiveErrorlistAllApplications(f);
							} catch (java.lang.reflect.InvocationTargetException e) {
								// we cannot intantiate the class - throw the
								// original Axis fault
								callback.receiveErrorlistAllApplications(f);
							} catch (java.lang.IllegalAccessException e) {
								// we cannot intantiate the class - throw the
								// original Axis fault
								callback.receiveErrorlistAllApplications(f);
							} catch (java.lang.InstantiationException e) {
								// we cannot intantiate the class - throw the
								// original Axis fault
								callback.receiveErrorlistAllApplications(f);
							} catch (org.apache.axis2.AxisFault e) {
								// we cannot intantiate the class - throw the
								// original Axis fault
								callback.receiveErrorlistAllApplications(f);
							}
						} else {
							callback.receiveErrorlistAllApplications(f);
						}
					} else {
						callback.receiveErrorlistAllApplications(f);
					}
				} else {
					callback.receiveErrorlistAllApplications(error);
				}
			}

			public void onFault(org.apache.axis2.context.MessageContext faultContext) {
				org.apache.axis2.AxisFault fault =
				                                   org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
				onError(fault);
			}

			public void onComplete() {
				try {
					_messageContext.getTransportOut().getSender().cleanup(_messageContext);
				} catch (org.apache.axis2.AxisFault axisFault) {
					callback.receiveErrorlistAllApplications(axisFault);
				}
			}
		});

		org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
		if (_operations[1].getMessageReceiver() == null && _operationClient.getOptions().isUseSeparateListener()) {
			_callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
			_operations[1].setMessageReceiver(_callbackReceiver);
		}

		// execute the operation client
		_operationClient.execute(false);

	}

	/**
	 * Auto generated method signature
	 * 
	 * @throws org.wso2.developerstudio.eclipse.carbonserver.base.carbon.application.ExceptionException
	 *             :
	 */
	public void deleteApplication(java.lang.String appName11

	) throws java.rmi.RemoteException

	, org.wso2.developerstudio.eclipse.carbonserver.base.carbon.application.ExceptionException {
		org.apache.axis2.context.MessageContext _messageContext = null;

		try {
			org.apache.axis2.client.OperationClient _operationClient =
			                                                           _serviceClient.createClient(_operations[2].getName());
			_operationClient.getOptions().setAction("urn:deleteApplication");
			_operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

			addPropertyToOperationClient(_operationClient,
			                             org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
			                             "&");

			org.apache.axiom.soap.SOAPEnvelope env = null;
			_messageContext = new org.apache.axis2.context.MessageContext();

			// Style is Doc.
			org.wso2.developerstudio.eclipse.carbonserver.base.carbon.application.ApplicationAdminStub.DeleteApplication dummyWrappedType =
			                                                                                                                                null;
			env =
			      toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()), appName11,
			                 dummyWrappedType,
			                 optimizeContent(new javax.xml.namespace.QName("http://mgt.application.carbon.wso2.org",
			                                                               "deleteApplication")));

			// adding SOAP soap_headers
			_serviceClient.addHeadersToEnvelope(env);
			// create message context with that soap envelope

			_messageContext.setEnvelope(env);

			// add the message contxt to the operation client
			_operationClient.addMessageContext(_messageContext);

			_operationClient.execute(true);

		} catch (org.apache.axis2.AxisFault f) {
			org.apache.axiom.om.OMElement faultElt = f.getDetail();
			if (faultElt != null) {
				if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),
				                                                                              "deleteApplication"))) {
					// make the fault by reflection
					try {
						java.lang.String exceptionClassName =
						                                      (java.lang.String) faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(
						                                                                                                                                faultElt.getQName(),
						                                                                                                                                "deleteApplication"));
						java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
						java.lang.Exception ex = (java.lang.Exception) exceptionClass.newInstance();
						// message class
						java.lang.String messageClassName =
						                                    (java.lang.String) faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(
						                                                                                                                   faultElt.getQName(),
						                                                                                                                   "deleteApplication"));
						java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
						java.lang.Object messageObject = fromOM(faultElt, messageClass, null);
						java.lang.reflect.Method m =
						                             exceptionClass.getMethod("setFaultMessage",
						                                                      new java.lang.Class[] { messageClass });
						m.invoke(ex, new java.lang.Object[] { messageObject });

						if (ex instanceof org.wso2.developerstudio.eclipse.carbonserver.base.carbon.application.ExceptionException) {
							throw (org.wso2.developerstudio.eclipse.carbonserver.base.carbon.application.ExceptionException) ex;
						}

						throw new java.rmi.RemoteException(ex.getMessage(), ex);
					} catch (java.lang.ClassCastException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					} catch (java.lang.ClassNotFoundException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					} catch (java.lang.NoSuchMethodException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					} catch (java.lang.reflect.InvocationTargetException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					} catch (java.lang.IllegalAccessException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					} catch (java.lang.InstantiationException e) {
						// we cannot intantiate the class - throw the original
						// Axis fault
						throw f;
					}
				} else {
					throw f;
				}
			} else {
				throw f;
			}
		} finally {
			_messageContext.getTransportOut().getSender().cleanup(_messageContext);
		}

		return;
	}

	/**
	 * A utility method that copies the namepaces from the SOAPEnvelope
	 */
	private java.util.Map getEnvelopeNamespaces(org.apache.axiom.soap.SOAPEnvelope env) {
		java.util.Map returnMap = new java.util.HashMap();
		java.util.Iterator namespaceIterator = env.getAllDeclaredNamespaces();
		while (namespaceIterator.hasNext()) {
			org.apache.axiom.om.OMNamespace ns = (org.apache.axiom.om.OMNamespace) namespaceIterator.next();
			returnMap.put(ns.getPrefix(), ns.getNamespaceURI());
		}
		return returnMap;
	}

	private javax.xml.namespace.QName[] opNameArray = null;

	private boolean optimizeContent(javax.xml.namespace.QName opName) {

		if (opNameArray == null) {
			return false;
		}
		for (int i = 0; i < opNameArray.length; i++) {
			if (opName.equals(opNameArray[i])) {
				return true;
			}
		}
		return false;
	}

	// https://localhost:8243/services/ApplicationAdmin.ApplicationAdminHttpsSoap12Endpoint
	public static class ServiceGroupMetadata implements org.apache.axis2.databinding.ADBBean {
		/*
		 * This type was generated from the piece of schema that had
		 * name = ServiceGroupMetadata
		 * Namespace URI = http://mgt.application.carbon.wso2.org/xsd
		 * Namespace Prefix = ns1
		 */

		/**
		 * field for Services
		 * This was an Array!
		 */

		protected java.lang.String[] localServices;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method
		 * for this attribute. It will be used to determine whether to include
		 * this field
		 * in the serialized XML
		 */
		protected boolean localServicesTracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String[]
		 */
		public java.lang.String[] getServices() {
			return localServices;
		}

		/**
		 * validate the array for Services
		 */
		protected void validateServices(java.lang.String[] param) {

		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Services
		 */
		public void setServices(java.lang.String[] param) {

			validateServices(param);

			if (param != null) {
				// update the setting tracker
				localServicesTracker = true;
			} else {
				localServicesTracker = true;

			}

			this.localServices = param;
		}

		/**
		 * Auto generated add method for the array for convenience
		 * 
		 * @param param
		 *            java.lang.String
		 */
		public void addServices(java.lang.String param) {
			if (localServices == null) {
				localServices = new java.lang.String[] {};
			}

			// update the setting tracker
			localServicesTracker = true;

			java.util.List list = org.apache.axis2.databinding.utils.ConverterUtil.toList(localServices);
			list.add(param);
			this.localServices = (java.lang.String[]) list.toArray(new java.lang.String[list.size()]);

		}

		/**
		 * field for SgName
		 */

		protected java.lang.String localSgName;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method
		 * for this attribute. It will be used to determine whether to include
		 * this field
		 * in the serialized XML
		 */
		protected boolean localSgNameTracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getSgName() {
			return localSgName;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            SgName
		 */
		public void setSgName(java.lang.String param) {

			if (param != null) {
				// update the setting tracker
				localSgNameTracker = true;
			} else {
				localSgNameTracker = true;

			}

			this.localSgName = param;

		}

		/**
		 * field for SgType
		 */

		protected java.lang.String localSgType;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method
		 * for this attribute. It will be used to determine whether to include
		 * this field
		 * in the serialized XML
		 */
		protected boolean localSgTypeTracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getSgType() {
			return localSgType;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            SgType
		 */
		public void setSgType(java.lang.String param) {

			if (param != null) {
				// update the setting tracker
				localSgTypeTracker = true;
			} else {
				localSgTypeTracker = true;

			}

			this.localSgType = param;

		}

		/**
		 *
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName,
		                                                  final org.apache.axiom.om.OMFactory factory)
		                                                                                              throws org.apache.axis2.databinding.ADBException {

			org.apache.axiom.om.OMDataSource dataSource =
			                                              new org.apache.axis2.databinding.ADBDataSource(this,
			                                                                                             parentQName);
			return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(parentQName, factory, dataSource);

		}

		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter)
		                                                                                                              throws javax.xml.stream.XMLStreamException,
		                                                                                                              org.apache.axis2.databinding.ADBException {
			serialize(parentQName, xmlWriter, false);
		}

		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter,
		                      boolean serializeType) throws javax.xml.stream.XMLStreamException,
		                                            org.apache.axis2.databinding.ADBException {

			java.lang.String prefix = null;
			java.lang.String namespace = null;

			prefix = parentQName.getPrefix();
			namespace = parentQName.getNamespaceURI();
			writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);

			if (serializeType) {

				java.lang.String namespacePrefix =
				                                   registerPrefix(xmlWriter,
				                                                  "http://mgt.application.carbon.wso2.org/xsd");
				if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", namespacePrefix +
					                                                                           ":ServiceGroupMetadata",
					               xmlWriter);
				} else {
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "ServiceGroupMetadata",
					               xmlWriter);
				}

			}
			if (localServicesTracker) {
				if (localServices != null) {
					namespace = "http://mgt.application.carbon.wso2.org/xsd";
					for (int i = 0; i < localServices.length; i++) {

						if (localServices[i] != null) {

							writeStartElement(null, namespace, "services", xmlWriter);

							xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localServices[i]));

							xmlWriter.writeEndElement();

						} else {

							// write null attribute
							namespace = "http://mgt.application.carbon.wso2.org/xsd";
							writeStartElement(null, namespace, "services", xmlWriter);
							writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);
							xmlWriter.writeEndElement();

						}

					}
				} else {

					// write the null attribute
					// write null attribute
					writeStartElement(null, "http://mgt.application.carbon.wso2.org/xsd", "services", xmlWriter);

					// write the nil attribute
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);
					xmlWriter.writeEndElement();

				}

			}
			if (localSgNameTracker) {
				namespace = "http://mgt.application.carbon.wso2.org/xsd";
				writeStartElement(null, namespace, "sgName", xmlWriter);

				if (localSgName == null) {
					// write the nil attribute

					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

				} else {

					xmlWriter.writeCharacters(localSgName);

				}

				xmlWriter.writeEndElement();
			}
			if (localSgTypeTracker) {
				namespace = "http://mgt.application.carbon.wso2.org/xsd";
				writeStartElement(null, namespace, "sgType", xmlWriter);

				if (localSgType == null) {
					// write the nil attribute

					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

				} else {

					xmlWriter.writeCharacters(localSgType);

				}

				xmlWriter.writeEndElement();
			}
			xmlWriter.writeEndElement();

		}

		private static java.lang.String generatePrefix(java.lang.String namespace) {
			if (namespace.equals("http://mgt.application.carbon.wso2.org/xsd")) {
				return "ns1";
			}
			return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
		}

		/**
		 * Utility method to write an element start tag.
		 */
		private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
		                               javax.xml.stream.XMLStreamWriter xmlWriter)
		                                                                          throws javax.xml.stream.XMLStreamException {
			java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
			if (writerPrefix != null) {
				xmlWriter.writeStartElement(namespace, localPart);
			} else {
				if (namespace.length() == 0) {
					prefix = "";
				} else if (prefix == null) {
					prefix = generatePrefix(namespace);
				}

				xmlWriter.writeStartElement(prefix, localPart, namespace);
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
		                            java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter)
		                                                                                                  throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			xmlWriter.writeAttribute(namespace, attName, attValue);
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue,
		                            javax.xml.stream.XMLStreamWriter xmlWriter)
		                                                                       throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
		                                 javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
		                                                                                                             throws javax.xml.stream.XMLStreamException {

			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}
			java.lang.String attributeValue;
			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */

		private void writeQName(javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
		                                                                                                    throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();
			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix + ":" +
					                          org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				}

			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter)
		                                                                                                        throws javax.xml.stream.XMLStreamException {

			if (qnames != null) {
				// we have to store this data until last moment since it is not
				// possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}
					namespaceURI = qnames[i].getNamespaceURI();
					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);
						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite.append(prefix)
							             .append(":")
							             .append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						} else {
							stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						}
					} else {
						stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
					}
				}
				xmlWriter.writeCharacters(stringToWrite.toString());
			}

		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace)
		                                                                                                               throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);
			if (prefix == null) {
				prefix = generatePrefix(namespace);
				while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
					prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
				}
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 *
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
		                                                                                      throws org.apache.axis2.databinding.ADBException {

			java.util.ArrayList elementList = new java.util.ArrayList();
			java.util.ArrayList attribList = new java.util.ArrayList();

			if (localServicesTracker) {
				if (localServices != null) {
					for (int i = 0; i < localServices.length; i++) {

						if (localServices[i] != null) {
							elementList.add(new javax.xml.namespace.QName("http://mgt.application.carbon.wso2.org/xsd",
							                                              "services"));
							elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localServices[i]));
						} else {

							elementList.add(new javax.xml.namespace.QName("http://mgt.application.carbon.wso2.org/xsd",
							                                              "services"));
							elementList.add(null);

						}

					}
				} else {

					elementList.add(new javax.xml.namespace.QName("http://mgt.application.carbon.wso2.org/xsd",
					                                              "services"));
					elementList.add(null);

				}

			}
			if (localSgNameTracker) {
				elementList.add(new javax.xml.namespace.QName("http://mgt.application.carbon.wso2.org/xsd", "sgName"));

				elementList.add(localSgName == null
				                                   ? null
				                                   : org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localSgName));
			}
			if (localSgTypeTracker) {
				elementList.add(new javax.xml.namespace.QName("http://mgt.application.carbon.wso2.org/xsd", "sgType"));

				elementList.add(localSgType == null
				                                   ? null
				                                   : org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localSgType));
			}

			return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(),
			                                                                            attribList.toArray());

		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {

			/**
			 * static method to create the object
			 * Precondition: If this object is an element, the current or next
			 * start element starts this object and any intervening reader
			 * events are ignorable
			 * If this object is not an element, it is a complex type and the
			 * reader is at the event just after the outer start element
			 * Postcondition: If this object is an element, the reader is
			 * positioned at its end element
			 * If this object is a complex type, the reader is positioned at the
			 * end element of its outer element
			 */
			public static ServiceGroupMetadata parse(javax.xml.stream.XMLStreamReader reader)
			                                                                                 throws java.lang.Exception {
				ServiceGroupMetadata object = new ServiceGroupMetadata();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";
				try {

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
						java.lang.String fullTypeName =
						                                reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
						                                                         "type");
						if (fullTypeName != null) {
							java.lang.String nsPrefix = null;
							if (fullTypeName.indexOf(":") > -1) {
								nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
							}
							nsPrefix = nsPrefix == null ? "" : nsPrefix;

							java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

							if (!"ServiceGroupMetadata".equals(type)) {
								// find namespace for the prefix
								java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
								return (ServiceGroupMetadata) ExtensionMapper.getTypeObject(nsUri, type, reader);
							}

						}

					}

					// Note all attributes that were handled. Used to differ
					// normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					reader.next();

					java.util.ArrayList list1 = new java.util.ArrayList();

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() &&
					    new javax.xml.namespace.QName("http://mgt.application.carbon.wso2.org/xsd", "services").equals(reader.getName())) {

						// Process the array and step past its final element's
						// end.

						nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
						if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
							list1.add(null);

							reader.next();
						} else {
							list1.add(reader.getElementText());
						}
						// loop until we find a start element that is not part
						// of this array
						boolean loopDone1 = false;
						while (!loopDone1) {
							// Ensure we are at the EndElement
							while (!reader.isEndElement()) {
								reader.next();
							}
							// Step out of this element
							reader.next();
							// Step to next element event.
							while (!reader.isStartElement() && !reader.isEndElement())
								reader.next();
							if (reader.isEndElement()) {
								// two continuous end elements means we are
								// exiting the xml structure
								loopDone1 = true;
							} else {
								if (new javax.xml.namespace.QName("http://mgt.application.carbon.wso2.org/xsd",
								                                  "services").equals(reader.getName())) {

									nillableValue =
									                reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
									                                         "nil");
									if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
										list1.add(null);

										reader.next();
									} else {
										list1.add(reader.getElementText());
									}
								} else {
									loopDone1 = true;
								}
							}
						}
						// call the converter utility to convert and set the
						// array

						object.setServices((java.lang.String[]) list1.toArray(new java.lang.String[list1.size()]));

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() &&
					    new javax.xml.namespace.QName("http://mgt.application.carbon.wso2.org/xsd", "sgName").equals(reader.getName())) {

						nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
						if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

							java.lang.String content = reader.getElementText();

							object.setSgName(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

						} else {

							reader.getElementText(); // throw away text nodes if
													 // any.
						}

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() &&
					    new javax.xml.namespace.QName("http://mgt.application.carbon.wso2.org/xsd", "sgType").equals(reader.getName())) {

						nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
						if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

							java.lang.String content = reader.getElementText();

							object.setSgType(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

						} else {

							reader.getElementText(); // throw away text nodes if
													 // any.
						}

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement())
						// A start element we are not expecting indicates a
						// trailing invalid property
						throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
						                                                    reader.getLocalName());

				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}

		}// end of factory class

	}

	public static class ApplicationMetadata implements org.apache.axis2.databinding.ADBBean {
		/*
		 * This type was generated from the piece of schema that had
		 * name = ApplicationMetadata
		 * Namespace URI = http://mgt.application.carbon.wso2.org/xsd
		 * Namespace Prefix = ns1
		 */

		/**
		 * field for AppName
		 */

		protected java.lang.String localAppName;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method
		 * for this attribute. It will be used to determine whether to include
		 * this field
		 * in the serialized XML
		 */
		protected boolean localAppNameTracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getAppName() {
			return localAppName;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            AppName
		 */
		public void setAppName(java.lang.String param) {

			if (param != null) {
				// update the setting tracker
				localAppNameTracker = true;
			} else {
				localAppNameTracker = true;

			}

			this.localAppName = param;

		}

		/**
		 * field for RegistryFilters
		 * This was an Array!
		 */

		protected java.lang.String[] localRegistryFilters;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method
		 * for this attribute. It will be used to determine whether to include
		 * this field
		 * in the serialized XML
		 */
		protected boolean localRegistryFiltersTracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String[]
		 */
		public java.lang.String[] getRegistryFilters() {
			return localRegistryFilters;
		}

		/**
		 * validate the array for RegistryFilters
		 */
		protected void validateRegistryFilters(java.lang.String[] param) {

		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            RegistryFilters
		 */
		public void setRegistryFilters(java.lang.String[] param) {

			validateRegistryFilters(param);

			if (param != null) {
				// update the setting tracker
				localRegistryFiltersTracker = true;
			} else {
				localRegistryFiltersTracker = true;

			}

			this.localRegistryFilters = param;
		}

		/**
		 * Auto generated add method for the array for convenience
		 * 
		 * @param param
		 *            java.lang.String
		 */
		public void addRegistryFilters(java.lang.String param) {
			if (localRegistryFilters == null) {
				localRegistryFilters = new java.lang.String[] {};
			}

			// update the setting tracker
			localRegistryFiltersTracker = true;

			java.util.List list = org.apache.axis2.databinding.utils.ConverterUtil.toList(localRegistryFilters);
			list.add(param);
			this.localRegistryFilters = (java.lang.String[]) list.toArray(new java.lang.String[list.size()]);

		}

		/**
		 * field for ServiceGroups
		 * This was an Array!
		 */

		protected ServiceGroupMetadata[] localServiceGroups;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method
		 * for this attribute. It will be used to determine whether to include
		 * this field
		 * in the serialized XML
		 */
		protected boolean localServiceGroupsTracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return ServiceGroupMetadata[]
		 */
		public ServiceGroupMetadata[] getServiceGroups() {
			return localServiceGroups;
		}

		/**
		 * validate the array for ServiceGroups
		 */
		protected void validateServiceGroups(ServiceGroupMetadata[] param) {

		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            ServiceGroups
		 */
		public void setServiceGroups(ServiceGroupMetadata[] param) {

			validateServiceGroups(param);

			if (param != null) {
				// update the setting tracker
				localServiceGroupsTracker = true;
			} else {
				localServiceGroupsTracker = true;

			}

			this.localServiceGroups = param;
		}

		/**
		 * Auto generated add method for the array for convenience
		 * 
		 * @param param
		 *            ServiceGroupMetadata
		 */
		public void addServiceGroups(ServiceGroupMetadata param) {
			if (localServiceGroups == null) {
				localServiceGroups = new ServiceGroupMetadata[] {};
			}

			// update the setting tracker
			localServiceGroupsTracker = true;

			java.util.List list = org.apache.axis2.databinding.utils.ConverterUtil.toList(localServiceGroups);
			list.add(param);
			this.localServiceGroups = (ServiceGroupMetadata[]) list.toArray(new ServiceGroupMetadata[list.size()]);

		}

		/**
		 *
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName,
		                                                  final org.apache.axiom.om.OMFactory factory)
		                                                                                              throws org.apache.axis2.databinding.ADBException {

			org.apache.axiom.om.OMDataSource dataSource =
			                                              new org.apache.axis2.databinding.ADBDataSource(this,
			                                                                                             parentQName);
			return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(parentQName, factory, dataSource);

		}

		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter)
		                                                                                                              throws javax.xml.stream.XMLStreamException,
		                                                                                                              org.apache.axis2.databinding.ADBException {
			serialize(parentQName, xmlWriter, false);
		}

		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter,
		                      boolean serializeType) throws javax.xml.stream.XMLStreamException,
		                                            org.apache.axis2.databinding.ADBException {

			java.lang.String prefix = null;
			java.lang.String namespace = null;

			prefix = parentQName.getPrefix();
			namespace = parentQName.getNamespaceURI();
			writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);

			if (serializeType) {

				java.lang.String namespacePrefix =
				                                   registerPrefix(xmlWriter,
				                                                  "http://mgt.application.carbon.wso2.org/xsd");
				if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", namespacePrefix +
					                                                                           ":ApplicationMetadata",
					               xmlWriter);
				} else {
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "ApplicationMetadata",
					               xmlWriter);
				}

			}
			if (localAppNameTracker) {
				namespace = "http://mgt.application.carbon.wso2.org/xsd";
				writeStartElement(null, namespace, "appName", xmlWriter);

				if (localAppName == null) {
					// write the nil attribute

					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

				} else {

					xmlWriter.writeCharacters(localAppName);

				}

				xmlWriter.writeEndElement();
			}
			if (localRegistryFiltersTracker) {
				if (localRegistryFilters != null) {
					namespace = "http://mgt.application.carbon.wso2.org/xsd";
					for (int i = 0; i < localRegistryFilters.length; i++) {

						if (localRegistryFilters[i] != null) {

							writeStartElement(null, namespace, "registryFilters", xmlWriter);

							xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localRegistryFilters[i]));

							xmlWriter.writeEndElement();

						} else {

							// write null attribute
							namespace = "http://mgt.application.carbon.wso2.org/xsd";
							writeStartElement(null, namespace, "registryFilters", xmlWriter);
							writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);
							xmlWriter.writeEndElement();

						}

					}
				} else {

					// write the null attribute
					// write null attribute
					writeStartElement(null, "http://mgt.application.carbon.wso2.org/xsd", "registryFilters", xmlWriter);

					// write the nil attribute
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);
					xmlWriter.writeEndElement();

				}

			}
			if (localServiceGroupsTracker) {
				if (localServiceGroups != null) {
					for (int i = 0; i < localServiceGroups.length; i++) {
						if (localServiceGroups[i] != null) {
							localServiceGroups[i].serialize(new javax.xml.namespace.QName(
							                                                              "http://mgt.application.carbon.wso2.org/xsd",
							                                                              "serviceGroups"), xmlWriter);
						} else {

							writeStartElement(null, "http://mgt.application.carbon.wso2.org/xsd", "serviceGroups",
							                  xmlWriter);

							// write the nil attribute
							writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);
							xmlWriter.writeEndElement();

						}

					}
				} else {

					writeStartElement(null, "http://mgt.application.carbon.wso2.org/xsd", "serviceGroups", xmlWriter);

					// write the nil attribute
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);
					xmlWriter.writeEndElement();

				}
			}
			xmlWriter.writeEndElement();

		}

		private static java.lang.String generatePrefix(java.lang.String namespace) {
			if (namespace.equals("http://mgt.application.carbon.wso2.org/xsd")) {
				return "ns1";
			}
			return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
		}

		/**
		 * Utility method to write an element start tag.
		 */
		private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
		                               javax.xml.stream.XMLStreamWriter xmlWriter)
		                                                                          throws javax.xml.stream.XMLStreamException {
			java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
			if (writerPrefix != null) {
				xmlWriter.writeStartElement(namespace, localPart);
			} else {
				if (namespace.length() == 0) {
					prefix = "";
				} else if (prefix == null) {
					prefix = generatePrefix(namespace);
				}

				xmlWriter.writeStartElement(prefix, localPart, namespace);
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
		                            java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter)
		                                                                                                  throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			xmlWriter.writeAttribute(namespace, attName, attValue);
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue,
		                            javax.xml.stream.XMLStreamWriter xmlWriter)
		                                                                       throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
		                                 javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
		                                                                                                             throws javax.xml.stream.XMLStreamException {

			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}
			java.lang.String attributeValue;
			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */

		private void writeQName(javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
		                                                                                                    throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();
			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix + ":" +
					                          org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				}

			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter)
		                                                                                                        throws javax.xml.stream.XMLStreamException {

			if (qnames != null) {
				// we have to store this data until last moment since it is not
				// possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}
					namespaceURI = qnames[i].getNamespaceURI();
					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);
						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite.append(prefix)
							             .append(":")
							             .append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						} else {
							stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						}
					} else {
						stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
					}
				}
				xmlWriter.writeCharacters(stringToWrite.toString());
			}

		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace)
		                                                                                                               throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);
			if (prefix == null) {
				prefix = generatePrefix(namespace);
				while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
					prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
				}
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 *
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
		                                                                                      throws org.apache.axis2.databinding.ADBException {

			java.util.ArrayList elementList = new java.util.ArrayList();
			java.util.ArrayList attribList = new java.util.ArrayList();

			if (localAppNameTracker) {
				elementList.add(new javax.xml.namespace.QName("http://mgt.application.carbon.wso2.org/xsd", "appName"));

				elementList.add(localAppName == null
				                                    ? null
				                                    : org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localAppName));
			}
			if (localRegistryFiltersTracker) {
				if (localRegistryFilters != null) {
					for (int i = 0; i < localRegistryFilters.length; i++) {

						if (localRegistryFilters[i] != null) {
							elementList.add(new javax.xml.namespace.QName("http://mgt.application.carbon.wso2.org/xsd",
							                                              "registryFilters"));
							elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localRegistryFilters[i]));
						} else {

							elementList.add(new javax.xml.namespace.QName("http://mgt.application.carbon.wso2.org/xsd",
							                                              "registryFilters"));
							elementList.add(null);

						}

					}
				} else {

					elementList.add(new javax.xml.namespace.QName("http://mgt.application.carbon.wso2.org/xsd",
					                                              "registryFilters"));
					elementList.add(null);

				}

			}
			if (localServiceGroupsTracker) {
				if (localServiceGroups != null) {
					for (int i = 0; i < localServiceGroups.length; i++) {

						if (localServiceGroups[i] != null) {
							elementList.add(new javax.xml.namespace.QName("http://mgt.application.carbon.wso2.org/xsd",
							                                              "serviceGroups"));
							elementList.add(localServiceGroups[i]);
						} else {

							elementList.add(new javax.xml.namespace.QName("http://mgt.application.carbon.wso2.org/xsd",
							                                              "serviceGroups"));
							elementList.add(null);

						}

					}
				} else {

					elementList.add(new javax.xml.namespace.QName("http://mgt.application.carbon.wso2.org/xsd",
					                                              "serviceGroups"));
					elementList.add(localServiceGroups);

				}

			}

			return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(),
			                                                                            attribList.toArray());

		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {

			/**
			 * static method to create the object
			 * Precondition: If this object is an element, the current or next
			 * start element starts this object and any intervening reader
			 * events are ignorable
			 * If this object is not an element, it is a complex type and the
			 * reader is at the event just after the outer start element
			 * Postcondition: If this object is an element, the reader is
			 * positioned at its end element
			 * If this object is a complex type, the reader is positioned at the
			 * end element of its outer element
			 */
			public static ApplicationMetadata parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
				ApplicationMetadata object = new ApplicationMetadata();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";
				try {

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
						java.lang.String fullTypeName =
						                                reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
						                                                         "type");
						if (fullTypeName != null) {
							java.lang.String nsPrefix = null;
							if (fullTypeName.indexOf(":") > -1) {
								nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
							}
							nsPrefix = nsPrefix == null ? "" : nsPrefix;

							java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

							if (!"ApplicationMetadata".equals(type)) {
								// find namespace for the prefix
								java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
								return (ApplicationMetadata) ExtensionMapper.getTypeObject(nsUri, type, reader);
							}

						}

					}

					// Note all attributes that were handled. Used to differ
					// normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					reader.next();

					java.util.ArrayList list2 = new java.util.ArrayList();

					java.util.ArrayList list3 = new java.util.ArrayList();

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() &&
					    new javax.xml.namespace.QName("http://mgt.application.carbon.wso2.org/xsd", "appName").equals(reader.getName())) {

						nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
						if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

							java.lang.String content = reader.getElementText();

							object.setAppName(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

						} else {

							reader.getElementText(); // throw away text nodes if
													 // any.
						}

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() &&
					    new javax.xml.namespace.QName("http://mgt.application.carbon.wso2.org/xsd", "registryFilters").equals(reader.getName())) {

						// Process the array and step past its final element's
						// end.

						nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
						if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
							list2.add(null);

							reader.next();
						} else {
							list2.add(reader.getElementText());
						}
						// loop until we find a start element that is not part
						// of this array
						boolean loopDone2 = false;
						while (!loopDone2) {
							// Ensure we are at the EndElement
							while (!reader.isEndElement()) {
								reader.next();
							}
							// Step out of this element
							reader.next();
							// Step to next element event.
							while (!reader.isStartElement() && !reader.isEndElement())
								reader.next();
							if (reader.isEndElement()) {
								// two continuous end elements means we are
								// exiting the xml structure
								loopDone2 = true;
							} else {
								if (new javax.xml.namespace.QName("http://mgt.application.carbon.wso2.org/xsd",
								                                  "registryFilters").equals(reader.getName())) {

									nillableValue =
									                reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
									                                         "nil");
									if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
										list2.add(null);

										reader.next();
									} else {
										list2.add(reader.getElementText());
									}
								} else {
									loopDone2 = true;
								}
							}
						}
						// call the converter utility to convert and set the
						// array

						object.setRegistryFilters((java.lang.String[]) list2.toArray(new java.lang.String[list2.size()]));

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() &&
					    new javax.xml.namespace.QName("http://mgt.application.carbon.wso2.org/xsd", "serviceGroups").equals(reader.getName())) {

						// Process the array and step past its final element's
						// end.

						nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
						if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
							list3.add(null);
							reader.next();
						} else {
							list3.add(ServiceGroupMetadata.Factory.parse(reader));
						}
						// loop until we find a start element that is not part
						// of this array
						boolean loopDone3 = false;
						while (!loopDone3) {
							// We should be at the end element, but make sure
							while (!reader.isEndElement())
								reader.next();
							// Step out of this element
							reader.next();
							// Step to next element event.
							while (!reader.isStartElement() && !reader.isEndElement())
								reader.next();
							if (reader.isEndElement()) {
								// two continuous end elements means we are
								// exiting the xml structure
								loopDone3 = true;
							} else {
								if (new javax.xml.namespace.QName("http://mgt.application.carbon.wso2.org/xsd",
								                                  "serviceGroups").equals(reader.getName())) {

									nillableValue =
									                reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
									                                         "nil");
									if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
										list3.add(null);
										reader.next();
									} else {
										list3.add(ServiceGroupMetadata.Factory.parse(reader));
									}
								} else {
									loopDone3 = true;
								}
							}
						}
						// call the converter utility to convert and set the
						// array

						object.setServiceGroups((ServiceGroupMetadata[]) org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(ServiceGroupMetadata.class,
						                                                                                                                 list3));

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement())
						// A start element we are not expecting indicates a
						// trailing invalid property
						throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
						                                                    reader.getLocalName());

				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}

		}// end of factory class

	}

	public static class GetAppData implements org.apache.axis2.databinding.ADBBean {

		public static final javax.xml.namespace.QName MY_QNAME =
		                                                         new javax.xml.namespace.QName(
		                                                                                       "http://mgt.application.carbon.wso2.org",
		                                                                                       "getAppData", "ns2");

		/**
		 * field for AppName
		 */

		protected java.lang.String localAppName;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method
		 * for this attribute. It will be used to determine whether to include
		 * this field
		 * in the serialized XML
		 */
		protected boolean localAppNameTracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getAppName() {
			return localAppName;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            AppName
		 */
		public void setAppName(java.lang.String param) {

			if (param != null) {
				// update the setting tracker
				localAppNameTracker = true;
			} else {
				localAppNameTracker = true;

			}

			this.localAppName = param;

		}

		/**
		 *
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName,
		                                                  final org.apache.axiom.om.OMFactory factory)
		                                                                                              throws org.apache.axis2.databinding.ADBException {

			org.apache.axiom.om.OMDataSource dataSource =
			                                              new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME);
			return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(MY_QNAME, factory, dataSource);

		}

		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter)
		                                                                                                              throws javax.xml.stream.XMLStreamException,
		                                                                                                              org.apache.axis2.databinding.ADBException {
			serialize(parentQName, xmlWriter, false);
		}

		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter,
		                      boolean serializeType) throws javax.xml.stream.XMLStreamException,
		                                            org.apache.axis2.databinding.ADBException {

			java.lang.String prefix = null;
			java.lang.String namespace = null;

			prefix = parentQName.getPrefix();
			namespace = parentQName.getNamespaceURI();
			writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);

			if (serializeType) {

				java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://mgt.application.carbon.wso2.org");
				if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", namespacePrefix +
					                                                                           ":getAppData", xmlWriter);
				} else {
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "getAppData", xmlWriter);
				}

			}
			if (localAppNameTracker) {
				namespace = "http://mgt.application.carbon.wso2.org";
				writeStartElement(null, namespace, "appName", xmlWriter);

				if (localAppName == null) {
					// write the nil attribute

					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

				} else {

					xmlWriter.writeCharacters(localAppName);

				}

				xmlWriter.writeEndElement();
			}
			xmlWriter.writeEndElement();

		}

		private static java.lang.String generatePrefix(java.lang.String namespace) {
			if (namespace.equals("http://mgt.application.carbon.wso2.org")) {
				return "ns2";
			}
			return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
		}

		/**
		 * Utility method to write an element start tag.
		 */
		private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
		                               javax.xml.stream.XMLStreamWriter xmlWriter)
		                                                                          throws javax.xml.stream.XMLStreamException {
			java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
			if (writerPrefix != null) {
				xmlWriter.writeStartElement(namespace, localPart);
			} else {
				if (namespace.length() == 0) {
					prefix = "";
				} else if (prefix == null) {
					prefix = generatePrefix(namespace);
				}

				xmlWriter.writeStartElement(prefix, localPart, namespace);
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
		                            java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter)
		                                                                                                  throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			xmlWriter.writeAttribute(namespace, attName, attValue);
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue,
		                            javax.xml.stream.XMLStreamWriter xmlWriter)
		                                                                       throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
		                                 javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
		                                                                                                             throws javax.xml.stream.XMLStreamException {

			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}
			java.lang.String attributeValue;
			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */

		private void writeQName(javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
		                                                                                                    throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();
			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix + ":" +
					                          org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				}

			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter)
		                                                                                                        throws javax.xml.stream.XMLStreamException {

			if (qnames != null) {
				// we have to store this data until last moment since it is not
				// possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}
					namespaceURI = qnames[i].getNamespaceURI();
					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);
						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite.append(prefix)
							             .append(":")
							             .append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						} else {
							stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						}
					} else {
						stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
					}
				}
				xmlWriter.writeCharacters(stringToWrite.toString());
			}

		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace)
		                                                                                                               throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);
			if (prefix == null) {
				prefix = generatePrefix(namespace);
				while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
					prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
				}
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 *
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
		                                                                                      throws org.apache.axis2.databinding.ADBException {

			java.util.ArrayList elementList = new java.util.ArrayList();
			java.util.ArrayList attribList = new java.util.ArrayList();

			if (localAppNameTracker) {
				elementList.add(new javax.xml.namespace.QName("http://mgt.application.carbon.wso2.org", "appName"));

				elementList.add(localAppName == null
				                                    ? null
				                                    : org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localAppName));
			}

			return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(),
			                                                                            attribList.toArray());

		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {

			/**
			 * static method to create the object
			 * Precondition: If this object is an element, the current or next
			 * start element starts this object and any intervening reader
			 * events are ignorable
			 * If this object is not an element, it is a complex type and the
			 * reader is at the event just after the outer start element
			 * Postcondition: If this object is an element, the reader is
			 * positioned at its end element
			 * If this object is a complex type, the reader is positioned at the
			 * end element of its outer element
			 */
			public static GetAppData parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
				GetAppData object = new GetAppData();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";
				try {

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
						java.lang.String fullTypeName =
						                                reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
						                                                         "type");
						if (fullTypeName != null) {
							java.lang.String nsPrefix = null;
							if (fullTypeName.indexOf(":") > -1) {
								nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
							}
							nsPrefix = nsPrefix == null ? "" : nsPrefix;

							java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

							if (!"getAppData".equals(type)) {
								// find namespace for the prefix
								java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
								return (GetAppData) ExtensionMapper.getTypeObject(nsUri, type, reader);
							}

						}

					}

					// Note all attributes that were handled. Used to differ
					// normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					reader.next();

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() &&
					    new javax.xml.namespace.QName("http://mgt.application.carbon.wso2.org", "appName").equals(reader.getName())) {

						nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
						if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

							java.lang.String content = reader.getElementText();

							object.setAppName(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

						} else {

							reader.getElementText(); // throw away text nodes if
													 // any.
						}

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement())
						// A start element we are not expecting indicates a
						// trailing invalid property
						throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
						                                                    reader.getLocalName());

				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}

		}// end of factory class

	}

	public static class ExtensionMapper {

		public static java.lang.Object getTypeObject(java.lang.String namespaceURI, java.lang.String typeName,
		                                             javax.xml.stream.XMLStreamReader reader)
		                                                                                     throws java.lang.Exception {

			if ("http://mgt.application.carbon.wso2.org/xsd".equals(namespaceURI) &&
			    "ServiceGroupMetadata".equals(typeName)) {

				return ServiceGroupMetadata.Factory.parse(reader);

			}

			if ("http://mgt.application.carbon.wso2.org/xsd".equals(namespaceURI) &&
			    "ApplicationMetadata".equals(typeName)) {

				return ApplicationMetadata.Factory.parse(reader);

			}

			if ("http://mgt.application.carbon.wso2.org".equals(namespaceURI) && "Exception".equals(typeName)) {

				return Exception.Factory.parse(reader);

			}

			throw new org.apache.axis2.databinding.ADBException("Unsupported type " + namespaceURI + " " + typeName);
		}

	}

	public static class ExceptionE implements org.apache.axis2.databinding.ADBBean {

		public static final javax.xml.namespace.QName MY_QNAME =
		                                                         new javax.xml.namespace.QName(
		                                                                                       "http://mgt.application.carbon.wso2.org",
		                                                                                       "Exception", "ns2");

		/**
		 * field for Exception
		 */

		protected Exception localException;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method
		 * for this attribute. It will be used to determine whether to include
		 * this field
		 * in the serialized XML
		 */
		protected boolean localExceptionTracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return Exception
		 */
		public Exception getException() {
			return localException;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Exception
		 */
		public void setException(Exception param) {

			if (param != null) {
				// update the setting tracker
				localExceptionTracker = true;
			} else {
				localExceptionTracker = true;

			}

			this.localException = param;

		}

		/**
		 *
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName,
		                                                  final org.apache.axiom.om.OMFactory factory)
		                                                                                              throws org.apache.axis2.databinding.ADBException {

			org.apache.axiom.om.OMDataSource dataSource =
			                                              new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME);
			return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(MY_QNAME, factory, dataSource);

		}

		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter)
		                                                                                                              throws javax.xml.stream.XMLStreamException,
		                                                                                                              org.apache.axis2.databinding.ADBException {
			serialize(parentQName, xmlWriter, false);
		}

		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter,
		                      boolean serializeType) throws javax.xml.stream.XMLStreamException,
		                                            org.apache.axis2.databinding.ADBException {

			java.lang.String prefix = null;
			java.lang.String namespace = null;

			prefix = parentQName.getPrefix();
			namespace = parentQName.getNamespaceURI();
			writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);

			if (serializeType) {

				java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://mgt.application.carbon.wso2.org");
				if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", namespacePrefix +
					                                                                           ":Exception", xmlWriter);
				} else {
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "Exception", xmlWriter);
				}

			}
			if (localExceptionTracker) {
				if (localException == null) {

					writeStartElement(null, "http://mgt.application.carbon.wso2.org", "Exception", xmlWriter);

					// write the nil attribute
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);
					xmlWriter.writeEndElement();
				} else {
					localException.serialize(new javax.xml.namespace.QName("http://mgt.application.carbon.wso2.org",
					                                                       "Exception"), xmlWriter);
				}
			}
			xmlWriter.writeEndElement();

		}

		private static java.lang.String generatePrefix(java.lang.String namespace) {
			if (namespace.equals("http://mgt.application.carbon.wso2.org")) {
				return "ns2";
			}
			return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
		}

		/**
		 * Utility method to write an element start tag.
		 */
		private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
		                               javax.xml.stream.XMLStreamWriter xmlWriter)
		                                                                          throws javax.xml.stream.XMLStreamException {
			java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
			if (writerPrefix != null) {
				xmlWriter.writeStartElement(namespace, localPart);
			} else {
				if (namespace.length() == 0) {
					prefix = "";
				} else if (prefix == null) {
					prefix = generatePrefix(namespace);
				}

				xmlWriter.writeStartElement(prefix, localPart, namespace);
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
		                            java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter)
		                                                                                                  throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			xmlWriter.writeAttribute(namespace, attName, attValue);
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue,
		                            javax.xml.stream.XMLStreamWriter xmlWriter)
		                                                                       throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
		                                 javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
		                                                                                                             throws javax.xml.stream.XMLStreamException {

			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}
			java.lang.String attributeValue;
			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */

		private void writeQName(javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
		                                                                                                    throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();
			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix + ":" +
					                          org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				}

			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter)
		                                                                                                        throws javax.xml.stream.XMLStreamException {

			if (qnames != null) {
				// we have to store this data until last moment since it is not
				// possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}
					namespaceURI = qnames[i].getNamespaceURI();
					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);
						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite.append(prefix)
							             .append(":")
							             .append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						} else {
							stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						}
					} else {
						stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
					}
				}
				xmlWriter.writeCharacters(stringToWrite.toString());
			}

		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace)
		                                                                                                               throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);
			if (prefix == null) {
				prefix = generatePrefix(namespace);
				while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
					prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
				}
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 *
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
		                                                                                      throws org.apache.axis2.databinding.ADBException {

			java.util.ArrayList elementList = new java.util.ArrayList();
			java.util.ArrayList attribList = new java.util.ArrayList();

			if (localExceptionTracker) {
				elementList.add(new javax.xml.namespace.QName("http://mgt.application.carbon.wso2.org", "Exception"));

				elementList.add(localException == null ? null : localException);
			}

			return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(),
			                                                                            attribList.toArray());

		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {

			/**
			 * static method to create the object
			 * Precondition: If this object is an element, the current or next
			 * start element starts this object and any intervening reader
			 * events are ignorable
			 * If this object is not an element, it is a complex type and the
			 * reader is at the event just after the outer start element
			 * Postcondition: If this object is an element, the reader is
			 * positioned at its end element
			 * If this object is a complex type, the reader is positioned at the
			 * end element of its outer element
			 */
			public static ExceptionE parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
				ExceptionE object = new ExceptionE();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";
				try {

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
					if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
						// Skip the element and report the null value. It cannot
						// have subelements.
						while (!reader.isEndElement())
							reader.next();

						return null;

					}

					if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
						java.lang.String fullTypeName =
						                                reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
						                                                         "type");
						if (fullTypeName != null) {
							java.lang.String nsPrefix = null;
							if (fullTypeName.indexOf(":") > -1) {
								nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
							}
							nsPrefix = nsPrefix == null ? "" : nsPrefix;

							java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

							if (!"Exception".equals(type)) {
								// find namespace for the prefix
								java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
								return (ExceptionE) ExtensionMapper.getTypeObject(nsUri, type, reader);
							}

						}

					}

					// Note all attributes that were handled. Used to differ
					// normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					reader.next();

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() &&
					    new javax.xml.namespace.QName("http://mgt.application.carbon.wso2.org", "Exception").equals(reader.getName())) {

						nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
						if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
							object.setException(null);
							reader.next();

							reader.next();

						} else {

							object.setException(Exception.Factory.parse(reader));

							reader.next();
						}
					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement())
						// A start element we are not expecting indicates a
						// trailing invalid property
						throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
						                                                    reader.getLocalName());

				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}

		}// end of factory class

	}

	public static class DeleteApplication implements org.apache.axis2.databinding.ADBBean {

		public static final javax.xml.namespace.QName MY_QNAME =
		                                                         new javax.xml.namespace.QName(
		                                                                                       "http://mgt.application.carbon.wso2.org",
		                                                                                       "deleteApplication",
		                                                                                       "ns2");

		/**
		 * field for AppName
		 */

		protected java.lang.String localAppName;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method
		 * for this attribute. It will be used to determine whether to include
		 * this field
		 * in the serialized XML
		 */
		protected boolean localAppNameTracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getAppName() {
			return localAppName;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            AppName
		 */
		public void setAppName(java.lang.String param) {

			if (param != null) {
				// update the setting tracker
				localAppNameTracker = true;
			} else {
				localAppNameTracker = true;

			}

			this.localAppName = param;

		}

		/**
		 *
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName,
		                                                  final org.apache.axiom.om.OMFactory factory)
		                                                                                              throws org.apache.axis2.databinding.ADBException {

			org.apache.axiom.om.OMDataSource dataSource =
			                                              new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME);
			return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(MY_QNAME, factory, dataSource);

		}

		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter)
		                                                                                                              throws javax.xml.stream.XMLStreamException,
		                                                                                                              org.apache.axis2.databinding.ADBException {
			serialize(parentQName, xmlWriter, false);
		}

		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter,
		                      boolean serializeType) throws javax.xml.stream.XMLStreamException,
		                                            org.apache.axis2.databinding.ADBException {

			java.lang.String prefix = null;
			java.lang.String namespace = null;

			prefix = parentQName.getPrefix();
			namespace = parentQName.getNamespaceURI();
			writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);

			if (serializeType) {

				java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://mgt.application.carbon.wso2.org");
				if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", namespacePrefix +
					                                                                           ":deleteApplication",
					               xmlWriter);
				} else {
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "deleteApplication",
					               xmlWriter);
				}

			}
			if (localAppNameTracker) {
				namespace = "http://mgt.application.carbon.wso2.org";
				writeStartElement(null, namespace, "appName", xmlWriter);

				if (localAppName == null) {
					// write the nil attribute

					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

				} else {

					xmlWriter.writeCharacters(localAppName);

				}

				xmlWriter.writeEndElement();
			}
			xmlWriter.writeEndElement();

		}

		private static java.lang.String generatePrefix(java.lang.String namespace) {
			if (namespace.equals("http://mgt.application.carbon.wso2.org")) {
				return "ns2";
			}
			return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
		}

		/**
		 * Utility method to write an element start tag.
		 */
		private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
		                               javax.xml.stream.XMLStreamWriter xmlWriter)
		                                                                          throws javax.xml.stream.XMLStreamException {
			java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
			if (writerPrefix != null) {
				xmlWriter.writeStartElement(namespace, localPart);
			} else {
				if (namespace.length() == 0) {
					prefix = "";
				} else if (prefix == null) {
					prefix = generatePrefix(namespace);
				}

				xmlWriter.writeStartElement(prefix, localPart, namespace);
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
		                            java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter)
		                                                                                                  throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			xmlWriter.writeAttribute(namespace, attName, attValue);
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue,
		                            javax.xml.stream.XMLStreamWriter xmlWriter)
		                                                                       throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
		                                 javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
		                                                                                                             throws javax.xml.stream.XMLStreamException {

			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}
			java.lang.String attributeValue;
			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */

		private void writeQName(javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
		                                                                                                    throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();
			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix + ":" +
					                          org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				}

			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter)
		                                                                                                        throws javax.xml.stream.XMLStreamException {

			if (qnames != null) {
				// we have to store this data until last moment since it is not
				// possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}
					namespaceURI = qnames[i].getNamespaceURI();
					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);
						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite.append(prefix)
							             .append(":")
							             .append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						} else {
							stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						}
					} else {
						stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
					}
				}
				xmlWriter.writeCharacters(stringToWrite.toString());
			}

		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace)
		                                                                                                               throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);
			if (prefix == null) {
				prefix = generatePrefix(namespace);
				while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
					prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
				}
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 *
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
		                                                                                      throws org.apache.axis2.databinding.ADBException {

			java.util.ArrayList elementList = new java.util.ArrayList();
			java.util.ArrayList attribList = new java.util.ArrayList();

			if (localAppNameTracker) {
				elementList.add(new javax.xml.namespace.QName("http://mgt.application.carbon.wso2.org", "appName"));

				elementList.add(localAppName == null
				                                    ? null
				                                    : org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localAppName));
			}

			return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(),
			                                                                            attribList.toArray());

		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {

			/**
			 * static method to create the object
			 * Precondition: If this object is an element, the current or next
			 * start element starts this object and any intervening reader
			 * events are ignorable
			 * If this object is not an element, it is a complex type and the
			 * reader is at the event just after the outer start element
			 * Postcondition: If this object is an element, the reader is
			 * positioned at its end element
			 * If this object is a complex type, the reader is positioned at the
			 * end element of its outer element
			 */
			public static DeleteApplication parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
				DeleteApplication object = new DeleteApplication();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";
				try {

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
						java.lang.String fullTypeName =
						                                reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
						                                                         "type");
						if (fullTypeName != null) {
							java.lang.String nsPrefix = null;
							if (fullTypeName.indexOf(":") > -1) {
								nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
							}
							nsPrefix = nsPrefix == null ? "" : nsPrefix;

							java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

							if (!"deleteApplication".equals(type)) {
								// find namespace for the prefix
								java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
								return (DeleteApplication) ExtensionMapper.getTypeObject(nsUri, type, reader);
							}

						}

					}

					// Note all attributes that were handled. Used to differ
					// normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					reader.next();

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() &&
					    new javax.xml.namespace.QName("http://mgt.application.carbon.wso2.org", "appName").equals(reader.getName())) {

						nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
						if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

							java.lang.String content = reader.getElementText();

							object.setAppName(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

						} else {

							reader.getElementText(); // throw away text nodes if
													 // any.
						}

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement())
						// A start element we are not expecting indicates a
						// trailing invalid property
						throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
						                                                    reader.getLocalName());

				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}

		}// end of factory class

	}

	public static class ListAllApplicationsResponse implements org.apache.axis2.databinding.ADBBean {

		public static final javax.xml.namespace.QName MY_QNAME =
		                                                         new javax.xml.namespace.QName(
		                                                                                       "http://mgt.application.carbon.wso2.org",
		                                                                                       "listAllApplicationsResponse",
		                                                                                       "ns2");

		/**
		 * field for _return
		 * This was an Array!
		 */

		protected java.lang.String[] local_return;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method
		 * for this attribute. It will be used to determine whether to include
		 * this field
		 * in the serialized XML
		 */
		protected boolean local_returnTracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String[]
		 */
		public java.lang.String[] get_return() {
			return local_return;
		}

		/**
		 * validate the array for _return
		 */
		protected void validate_return(java.lang.String[] param) {

		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            _return
		 */
		public void set_return(java.lang.String[] param) {

			validate_return(param);

			if (param != null) {
				// update the setting tracker
				local_returnTracker = true;
			} else {
				local_returnTracker = true;

			}

			this.local_return = param;
		}

		/**
		 * Auto generated add method for the array for convenience
		 * 
		 * @param param
		 *            java.lang.String
		 */
		public void add_return(java.lang.String param) {
			if (local_return == null) {
				local_return = new java.lang.String[] {};
			}

			// update the setting tracker
			local_returnTracker = true;

			java.util.List list = org.apache.axis2.databinding.utils.ConverterUtil.toList(local_return);
			list.add(param);
			this.local_return = (java.lang.String[]) list.toArray(new java.lang.String[list.size()]);

		}

		/**
		 *
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName,
		                                                  final org.apache.axiom.om.OMFactory factory)
		                                                                                              throws org.apache.axis2.databinding.ADBException {

			org.apache.axiom.om.OMDataSource dataSource =
			                                              new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME);
			return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(MY_QNAME, factory, dataSource);

		}

		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter)
		                                                                                                              throws javax.xml.stream.XMLStreamException,
		                                                                                                              org.apache.axis2.databinding.ADBException {
			serialize(parentQName, xmlWriter, false);
		}

		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter,
		                      boolean serializeType) throws javax.xml.stream.XMLStreamException,
		                                            org.apache.axis2.databinding.ADBException {

			java.lang.String prefix = null;
			java.lang.String namespace = null;

			prefix = parentQName.getPrefix();
			namespace = parentQName.getNamespaceURI();
			writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);

			if (serializeType) {

				java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://mgt.application.carbon.wso2.org");
				if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
					               namespacePrefix + ":listAllApplicationsResponse", xmlWriter);
				} else {
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
					               "listAllApplicationsResponse", xmlWriter);
				}

			}
			if (local_returnTracker) {
				if (local_return != null) {
					namespace = "http://mgt.application.carbon.wso2.org";
					for (int i = 0; i < local_return.length; i++) {

						if (local_return[i] != null) {

							writeStartElement(null, namespace, "return", xmlWriter);

							xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(local_return[i]));

							xmlWriter.writeEndElement();

						} else {

							// write null attribute
							namespace = "http://mgt.application.carbon.wso2.org";
							writeStartElement(null, namespace, "return", xmlWriter);
							writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);
							xmlWriter.writeEndElement();

						}

					}
				} else {

					// write the null attribute
					// write null attribute
					writeStartElement(null, "http://mgt.application.carbon.wso2.org", "return", xmlWriter);

					// write the nil attribute
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);
					xmlWriter.writeEndElement();

				}

			}
			xmlWriter.writeEndElement();

		}

		private static java.lang.String generatePrefix(java.lang.String namespace) {
			if (namespace.equals("http://mgt.application.carbon.wso2.org")) {
				return "ns2";
			}
			return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
		}

		/**
		 * Utility method to write an element start tag.
		 */
		private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
		                               javax.xml.stream.XMLStreamWriter xmlWriter)
		                                                                          throws javax.xml.stream.XMLStreamException {
			java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
			if (writerPrefix != null) {
				xmlWriter.writeStartElement(namespace, localPart);
			} else {
				if (namespace.length() == 0) {
					prefix = "";
				} else if (prefix == null) {
					prefix = generatePrefix(namespace);
				}

				xmlWriter.writeStartElement(prefix, localPart, namespace);
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
		                            java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter)
		                                                                                                  throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			xmlWriter.writeAttribute(namespace, attName, attValue);
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue,
		                            javax.xml.stream.XMLStreamWriter xmlWriter)
		                                                                       throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
		                                 javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
		                                                                                                             throws javax.xml.stream.XMLStreamException {

			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}
			java.lang.String attributeValue;
			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */

		private void writeQName(javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
		                                                                                                    throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();
			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix + ":" +
					                          org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				}

			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter)
		                                                                                                        throws javax.xml.stream.XMLStreamException {

			if (qnames != null) {
				// we have to store this data until last moment since it is not
				// possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}
					namespaceURI = qnames[i].getNamespaceURI();
					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);
						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite.append(prefix)
							             .append(":")
							             .append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						} else {
							stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						}
					} else {
						stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
					}
				}
				xmlWriter.writeCharacters(stringToWrite.toString());
			}

		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace)
		                                                                                                               throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);
			if (prefix == null) {
				prefix = generatePrefix(namespace);
				while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
					prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
				}
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 *
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
		                                                                                      throws org.apache.axis2.databinding.ADBException {

			java.util.ArrayList elementList = new java.util.ArrayList();
			java.util.ArrayList attribList = new java.util.ArrayList();

			if (local_returnTracker) {
				if (local_return != null) {
					for (int i = 0; i < local_return.length; i++) {

						if (local_return[i] != null) {
							elementList.add(new javax.xml.namespace.QName("http://mgt.application.carbon.wso2.org",
							                                              "return"));
							elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(local_return[i]));
						} else {

							elementList.add(new javax.xml.namespace.QName("http://mgt.application.carbon.wso2.org",
							                                              "return"));
							elementList.add(null);

						}

					}
				} else {

					elementList.add(new javax.xml.namespace.QName("http://mgt.application.carbon.wso2.org", "return"));
					elementList.add(null);

				}

			}

			return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(),
			                                                                            attribList.toArray());

		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {

			/**
			 * static method to create the object
			 * Precondition: If this object is an element, the current or next
			 * start element starts this object and any intervening reader
			 * events are ignorable
			 * If this object is not an element, it is a complex type and the
			 * reader is at the event just after the outer start element
			 * Postcondition: If this object is an element, the reader is
			 * positioned at its end element
			 * If this object is a complex type, the reader is positioned at the
			 * end element of its outer element
			 */
			public static ListAllApplicationsResponse parse(javax.xml.stream.XMLStreamReader reader)
			                                                                                        throws java.lang.Exception {
				ListAllApplicationsResponse object = new ListAllApplicationsResponse();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";
				try {

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
						java.lang.String fullTypeName =
						                                reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
						                                                         "type");
						if (fullTypeName != null) {
							java.lang.String nsPrefix = null;
							if (fullTypeName.indexOf(":") > -1) {
								nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
							}
							nsPrefix = nsPrefix == null ? "" : nsPrefix;

							java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

							if (!"listAllApplicationsResponse".equals(type)) {
								// find namespace for the prefix
								java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
								return (ListAllApplicationsResponse) ExtensionMapper.getTypeObject(nsUri, type, reader);
							}

						}

					}

					// Note all attributes that were handled. Used to differ
					// normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					reader.next();

					java.util.ArrayList list1 = new java.util.ArrayList();

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() &&
					    new javax.xml.namespace.QName("http://mgt.application.carbon.wso2.org", "return").equals(reader.getName())) {

						// Process the array and step past its final element's
						// end.

						nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
						if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
							list1.add(null);

							reader.next();
						} else {
							list1.add(reader.getElementText());
						}
						// loop until we find a start element that is not part
						// of this array
						boolean loopDone1 = false;
						while (!loopDone1) {
							// Ensure we are at the EndElement
							while (!reader.isEndElement()) {
								reader.next();
							}
							// Step out of this element
							reader.next();
							// Step to next element event.
							while (!reader.isStartElement() && !reader.isEndElement())
								reader.next();
							if (reader.isEndElement()) {
								// two continuous end elements means we are
								// exiting the xml structure
								loopDone1 = true;
							} else {
								if (new javax.xml.namespace.QName("http://mgt.application.carbon.wso2.org", "return").equals(reader.getName())) {

									nillableValue =
									                reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
									                                         "nil");
									if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
										list1.add(null);

										reader.next();
									} else {
										list1.add(reader.getElementText());
									}
								} else {
									loopDone1 = true;
								}
							}
						}
						// call the converter utility to convert and set the
						// array

						object.set_return((java.lang.String[]) list1.toArray(new java.lang.String[list1.size()]));

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement())
						// A start element we are not expecting indicates a
						// trailing invalid property
						throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
						                                                    reader.getLocalName());

				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}

		}// end of factory class

	}

	public static class Exception implements org.apache.axis2.databinding.ADBBean {
		/*
		 * This type was generated from the piece of schema that had
		 * name = Exception
		 * Namespace URI = http://mgt.application.carbon.wso2.org
		 * Namespace Prefix = ns2
		 */

		/**
		 * field for Exception
		 */

		protected java.lang.Object localException;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method
		 * for this attribute. It will be used to determine whether to include
		 * this field
		 * in the serialized XML
		 */
		protected boolean localExceptionTracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.Object
		 */
		public java.lang.Object getException() {
			return localException;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            Exception
		 */
		public void setException(java.lang.Object param) {

			if (param != null) {
				// update the setting tracker
				localExceptionTracker = true;
			} else {
				localExceptionTracker = true;

			}

			this.localException = param;

		}

		/**
		 *
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName,
		                                                  final org.apache.axiom.om.OMFactory factory)
		                                                                                              throws org.apache.axis2.databinding.ADBException {

			org.apache.axiom.om.OMDataSource dataSource =
			                                              new org.apache.axis2.databinding.ADBDataSource(this,
			                                                                                             parentQName);
			return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(parentQName, factory, dataSource);

		}

		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter)
		                                                                                                              throws javax.xml.stream.XMLStreamException,
		                                                                                                              org.apache.axis2.databinding.ADBException {
			serialize(parentQName, xmlWriter, false);
		}

		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter,
		                      boolean serializeType) throws javax.xml.stream.XMLStreamException,
		                                            org.apache.axis2.databinding.ADBException {

			java.lang.String prefix = null;
			java.lang.String namespace = null;

			prefix = parentQName.getPrefix();
			namespace = parentQName.getNamespaceURI();
			writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);

			if (serializeType) {

				java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://mgt.application.carbon.wso2.org");
				if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", namespacePrefix +
					                                                                           ":Exception", xmlWriter);
				} else {
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "Exception", xmlWriter);
				}

			}
			if (localExceptionTracker) {

				if (localException != null) {
					if (localException instanceof org.apache.axis2.databinding.ADBBean) {
						((org.apache.axis2.databinding.ADBBean) localException).serialize(new javax.xml.namespace.QName(
						                                                                                                "http://mgt.application.carbon.wso2.org",
						                                                                                                "Exception"),
						                                                                  xmlWriter, true);
					} else {
						writeStartElement(null, "http://mgt.application.carbon.wso2.org", "Exception", xmlWriter);
						org.apache.axis2.databinding.utils.ConverterUtil.serializeAnyType(localException, xmlWriter);
						xmlWriter.writeEndElement();
					}
				} else {

					// write null attribute
					writeStartElement(null, "http://mgt.application.carbon.wso2.org", "Exception", xmlWriter);

					// write the nil attribute
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);
					xmlWriter.writeEndElement();

				}

			}
			xmlWriter.writeEndElement();

		}

		private static java.lang.String generatePrefix(java.lang.String namespace) {
			if (namespace.equals("http://mgt.application.carbon.wso2.org")) {
				return "ns2";
			}
			return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
		}

		/**
		 * Utility method to write an element start tag.
		 */
		private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
		                               javax.xml.stream.XMLStreamWriter xmlWriter)
		                                                                          throws javax.xml.stream.XMLStreamException {
			java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
			if (writerPrefix != null) {
				xmlWriter.writeStartElement(namespace, localPart);
			} else {
				if (namespace.length() == 0) {
					prefix = "";
				} else if (prefix == null) {
					prefix = generatePrefix(namespace);
				}

				xmlWriter.writeStartElement(prefix, localPart, namespace);
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
		                            java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter)
		                                                                                                  throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			xmlWriter.writeAttribute(namespace, attName, attValue);
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue,
		                            javax.xml.stream.XMLStreamWriter xmlWriter)
		                                                                       throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
		                                 javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
		                                                                                                             throws javax.xml.stream.XMLStreamException {

			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}
			java.lang.String attributeValue;
			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */

		private void writeQName(javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
		                                                                                                    throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();
			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix + ":" +
					                          org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				}

			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter)
		                                                                                                        throws javax.xml.stream.XMLStreamException {

			if (qnames != null) {
				// we have to store this data until last moment since it is not
				// possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}
					namespaceURI = qnames[i].getNamespaceURI();
					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);
						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite.append(prefix)
							             .append(":")
							             .append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						} else {
							stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						}
					} else {
						stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
					}
				}
				xmlWriter.writeCharacters(stringToWrite.toString());
			}

		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace)
		                                                                                                               throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);
			if (prefix == null) {
				prefix = generatePrefix(namespace);
				while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
					prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
				}
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 *
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
		                                                                                      throws org.apache.axis2.databinding.ADBException {

			java.util.ArrayList elementList = new java.util.ArrayList();
			java.util.ArrayList attribList = new java.util.ArrayList();

			if (localExceptionTracker) {
				elementList.add(new javax.xml.namespace.QName("http://mgt.application.carbon.wso2.org", "Exception"));

				elementList.add(localException == null ? null : localException);
			}

			return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(),
			                                                                            attribList.toArray());

		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {

			/**
			 * static method to create the object
			 * Precondition: If this object is an element, the current or next
			 * start element starts this object and any intervening reader
			 * events are ignorable
			 * If this object is not an element, it is a complex type and the
			 * reader is at the event just after the outer start element
			 * Postcondition: If this object is an element, the reader is
			 * positioned at its end element
			 * If this object is a complex type, the reader is positioned at the
			 * end element of its outer element
			 */
			public static Exception parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
				Exception object = new Exception();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";
				try {

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
						java.lang.String fullTypeName =
						                                reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
						                                                         "type");
						if (fullTypeName != null) {
							java.lang.String nsPrefix = null;
							if (fullTypeName.indexOf(":") > -1) {
								nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
							}
							nsPrefix = nsPrefix == null ? "" : nsPrefix;

							java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

							if (!"Exception".equals(type)) {
								// find namespace for the prefix
								java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
								return (Exception) ExtensionMapper.getTypeObject(nsUri, type, reader);
							}

						}

					}

					// Note all attributes that were handled. Used to differ
					// normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					reader.next();

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() &&
					    new javax.xml.namespace.QName("http://mgt.application.carbon.wso2.org", "Exception").equals(reader.getName())) {

						object.setException(org.apache.axis2.databinding.utils.ConverterUtil.getAnyTypeObject(reader,
						                                                                                      ExtensionMapper.class));

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement())
						// A start element we are not expecting indicates a
						// trailing invalid property
						throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
						                                                    reader.getLocalName());

				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}

		}// end of factory class

	}

	public static class GetAppDataResponse implements org.apache.axis2.databinding.ADBBean {

		public static final javax.xml.namespace.QName MY_QNAME =
		                                                         new javax.xml.namespace.QName(
		                                                                                       "http://mgt.application.carbon.wso2.org",
		                                                                                       "getAppDataResponse",
		                                                                                       "ns2");

		/**
		 * field for _return
		 */

		protected ApplicationMetadata local_return;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method
		 * for this attribute. It will be used to determine whether to include
		 * this field
		 * in the serialized XML
		 */
		protected boolean local_returnTracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return ApplicationMetadata
		 */
		public ApplicationMetadata get_return() {
			return local_return;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            _return
		 */
		public void set_return(ApplicationMetadata param) {

			if (param != null) {
				// update the setting tracker
				local_returnTracker = true;
			} else {
				local_returnTracker = true;

			}

			this.local_return = param;

		}

		/**
		 *
		 * @param parentQName
		 * @param factory
		 * @return org.apache.axiom.om.OMElement
		 */
		public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName,
		                                                  final org.apache.axiom.om.OMFactory factory)
		                                                                                              throws org.apache.axis2.databinding.ADBException {

			org.apache.axiom.om.OMDataSource dataSource =
			                                              new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME);
			return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(MY_QNAME, factory, dataSource);

		}

		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter)
		                                                                                                              throws javax.xml.stream.XMLStreamException,
		                                                                                                              org.apache.axis2.databinding.ADBException {
			serialize(parentQName, xmlWriter, false);
		}

		public void serialize(final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter,
		                      boolean serializeType) throws javax.xml.stream.XMLStreamException,
		                                            org.apache.axis2.databinding.ADBException {

			java.lang.String prefix = null;
			java.lang.String namespace = null;

			prefix = parentQName.getPrefix();
			namespace = parentQName.getNamespaceURI();
			writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);

			if (serializeType) {

				java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://mgt.application.carbon.wso2.org");
				if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", namespacePrefix +
					                                                                           ":getAppDataResponse",
					               xmlWriter);
				} else {
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "getAppDataResponse",
					               xmlWriter);
				}

			}
			if (local_returnTracker) {
				if (local_return == null) {

					writeStartElement(null, "http://mgt.application.carbon.wso2.org", "return", xmlWriter);

					// write the nil attribute
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);
					xmlWriter.writeEndElement();
				} else {
					local_return.serialize(new javax.xml.namespace.QName("http://mgt.application.carbon.wso2.org",
					                                                     "return"), xmlWriter);
				}
			}
			xmlWriter.writeEndElement();

		}

		private static java.lang.String generatePrefix(java.lang.String namespace) {
			if (namespace.equals("http://mgt.application.carbon.wso2.org")) {
				return "ns2";
			}
			return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
		}

		/**
		 * Utility method to write an element start tag.
		 */
		private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
		                               javax.xml.stream.XMLStreamWriter xmlWriter)
		                                                                          throws javax.xml.stream.XMLStreamException {
			java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
			if (writerPrefix != null) {
				xmlWriter.writeStartElement(namespace, localPart);
			} else {
				if (namespace.length() == 0) {
					prefix = "";
				} else if (prefix == null) {
					prefix = generatePrefix(namespace);
				}

				xmlWriter.writeStartElement(prefix, localPart, namespace);
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
		}

		/**
		 * Util method to write an attribute with the ns prefix
		 */
		private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
		                            java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter)
		                                                                                                  throws javax.xml.stream.XMLStreamException {
			if (xmlWriter.getPrefix(namespace) == null) {
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			xmlWriter.writeAttribute(namespace, attName, attValue);
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeAttribute(java.lang.String namespace, java.lang.String attName, java.lang.String attValue,
		                            javax.xml.stream.XMLStreamWriter xmlWriter)
		                                                                       throws javax.xml.stream.XMLStreamException {
			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attValue);
			}
		}

		/**
		 * Util method to write an attribute without the ns prefix
		 */
		private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
		                                 javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
		                                                                                                             throws javax.xml.stream.XMLStreamException {

			java.lang.String attributeNamespace = qname.getNamespaceURI();
			java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
			if (attributePrefix == null) {
				attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
			}
			java.lang.String attributeValue;
			if (attributePrefix.trim().length() > 0) {
				attributeValue = attributePrefix + ":" + qname.getLocalPart();
			} else {
				attributeValue = qname.getLocalPart();
			}

			if (namespace.equals("")) {
				xmlWriter.writeAttribute(attName, attributeValue);
			} else {
				registerPrefix(xmlWriter, namespace);
				xmlWriter.writeAttribute(namespace, attName, attributeValue);
			}
		}

		/**
		 * method to handle Qnames
		 */

		private void writeQName(javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
		                                                                                                    throws javax.xml.stream.XMLStreamException {
			java.lang.String namespaceURI = qname.getNamespaceURI();
			if (namespaceURI != null) {
				java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
				if (prefix == null) {
					prefix = generatePrefix(namespaceURI);
					xmlWriter.writeNamespace(prefix, namespaceURI);
					xmlWriter.setPrefix(prefix, namespaceURI);
				}

				if (prefix.trim().length() > 0) {
					xmlWriter.writeCharacters(prefix + ":" +
					                          org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				} else {
					// i.e this is the default namespace
					xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
				}

			} else {
				xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			}
		}

		private void writeQNames(javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter)
		                                                                                                        throws javax.xml.stream.XMLStreamException {

			if (qnames != null) {
				// we have to store this data until last moment since it is not
				// possible to write any
				// namespace data after writing the charactor data
				java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
				java.lang.String namespaceURI = null;
				java.lang.String prefix = null;

				for (int i = 0; i < qnames.length; i++) {
					if (i > 0) {
						stringToWrite.append(" ");
					}
					namespaceURI = qnames[i].getNamespaceURI();
					if (namespaceURI != null) {
						prefix = xmlWriter.getPrefix(namespaceURI);
						if ((prefix == null) || (prefix.length() == 0)) {
							prefix = generatePrefix(namespaceURI);
							xmlWriter.writeNamespace(prefix, namespaceURI);
							xmlWriter.setPrefix(prefix, namespaceURI);
						}

						if (prefix.trim().length() > 0) {
							stringToWrite.append(prefix)
							             .append(":")
							             .append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						} else {
							stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
						}
					} else {
						stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
					}
				}
				xmlWriter.writeCharacters(stringToWrite.toString());
			}

		}

		/**
		 * Register a namespace prefix
		 */
		private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace)
		                                                                                                               throws javax.xml.stream.XMLStreamException {
			java.lang.String prefix = xmlWriter.getPrefix(namespace);
			if (prefix == null) {
				prefix = generatePrefix(namespace);
				while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
					prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
				}
				xmlWriter.writeNamespace(prefix, namespace);
				xmlWriter.setPrefix(prefix, namespace);
			}
			return prefix;
		}

		/**
		 * databinding method to get an XML representation of this object
		 *
		 */
		public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
		                                                                                      throws org.apache.axis2.databinding.ADBException {

			java.util.ArrayList elementList = new java.util.ArrayList();
			java.util.ArrayList attribList = new java.util.ArrayList();

			if (local_returnTracker) {
				elementList.add(new javax.xml.namespace.QName("http://mgt.application.carbon.wso2.org", "return"));

				elementList.add(local_return == null ? null : local_return);
			}

			return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(),
			                                                                            attribList.toArray());

		}

		/**
		 * Factory class that keeps the parse method
		 */
		public static class Factory {

			/**
			 * static method to create the object
			 * Precondition: If this object is an element, the current or next
			 * start element starts this object and any intervening reader
			 * events are ignorable
			 * If this object is not an element, it is a complex type and the
			 * reader is at the event just after the outer start element
			 * Postcondition: If this object is an element, the reader is
			 * positioned at its end element
			 * If this object is a complex type, the reader is positioned at the
			 * end element of its outer element
			 */
			public static GetAppDataResponse parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
				GetAppDataResponse object = new GetAppDataResponse();

				int event;
				java.lang.String nillableValue = null;
				java.lang.String prefix = "";
				java.lang.String namespaceuri = "";
				try {

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
						java.lang.String fullTypeName =
						                                reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
						                                                         "type");
						if (fullTypeName != null) {
							java.lang.String nsPrefix = null;
							if (fullTypeName.indexOf(":") > -1) {
								nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
							}
							nsPrefix = nsPrefix == null ? "" : nsPrefix;

							java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

							if (!"getAppDataResponse".equals(type)) {
								// find namespace for the prefix
								java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
								return (GetAppDataResponse) ExtensionMapper.getTypeObject(nsUri, type, reader);
							}

						}

					}

					// Note all attributes that were handled. Used to differ
					// normal attributes
					// from anyAttributes.
					java.util.Vector handledAttributes = new java.util.Vector();

					reader.next();

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() &&
					    new javax.xml.namespace.QName("http://mgt.application.carbon.wso2.org", "return").equals(reader.getName())) {

						nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
						if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
							object.set_return(null);
							reader.next();

							reader.next();

						} else {

							object.set_return(ApplicationMetadata.Factory.parse(reader));

							reader.next();
						}
					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement())
						// A start element we are not expecting indicates a
						// trailing invalid property
						throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " +
						                                                    reader.getLocalName());

				} catch (javax.xml.stream.XMLStreamException e) {
					throw new java.lang.Exception(e);
				}

				return object;
			}

		}// end of factory class

	}

	private org.apache.axiom.om.OMElement toOM(org.wso2.developerstudio.eclipse.carbonserver.base.carbon.application.ApplicationAdminStub.GetAppData param,
	                                           boolean optimizeContent) throws org.apache.axis2.AxisFault {

		try {
			return param.getOMElement(org.wso2.developerstudio.eclipse.carbonserver.base.carbon.application.ApplicationAdminStub.GetAppData.MY_QNAME,
			                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
		} catch (org.apache.axis2.databinding.ADBException e) {
			throw org.apache.axis2.AxisFault.makeFault(e);
		}

	}

	private org.apache.axiom.om.OMElement toOM(org.wso2.developerstudio.eclipse.carbonserver.base.carbon.application.ApplicationAdminStub.GetAppDataResponse param,
	                                           boolean optimizeContent) throws org.apache.axis2.AxisFault {

		try {
			return param.getOMElement(org.wso2.developerstudio.eclipse.carbonserver.base.carbon.application.ApplicationAdminStub.GetAppDataResponse.MY_QNAME,
			                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
		} catch (org.apache.axis2.databinding.ADBException e) {
			throw org.apache.axis2.AxisFault.makeFault(e);
		}

	}

	private org.apache.axiom.om.OMElement toOM(org.wso2.developerstudio.eclipse.carbonserver.base.carbon.application.ApplicationAdminStub.ExceptionE param,
	                                           boolean optimizeContent) throws org.apache.axis2.AxisFault {

		try {
			return param.getOMElement(org.wso2.developerstudio.eclipse.carbonserver.base.carbon.application.ApplicationAdminStub.ExceptionE.MY_QNAME,
			                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
		} catch (org.apache.axis2.databinding.ADBException e) {
			throw org.apache.axis2.AxisFault.makeFault(e);
		}

	}

	private org.apache.axiom.om.OMElement toOM(org.wso2.developerstudio.eclipse.carbonserver.base.carbon.application.ApplicationAdminStub.ListAllApplicationsResponse param,
	                                           boolean optimizeContent) throws org.apache.axis2.AxisFault {

		try {
			return param.getOMElement(org.wso2.developerstudio.eclipse.carbonserver.base.carbon.application.ApplicationAdminStub.ListAllApplicationsResponse.MY_QNAME,
			                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
		} catch (org.apache.axis2.databinding.ADBException e) {
			throw org.apache.axis2.AxisFault.makeFault(e);
		}

	}

	private org.apache.axiom.om.OMElement toOM(org.wso2.developerstudio.eclipse.carbonserver.base.carbon.application.ApplicationAdminStub.DeleteApplication param,
	                                           boolean optimizeContent) throws org.apache.axis2.AxisFault {

		try {
			return param.getOMElement(org.wso2.developerstudio.eclipse.carbonserver.base.carbon.application.ApplicationAdminStub.DeleteApplication.MY_QNAME,
			                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
		} catch (org.apache.axis2.databinding.ADBException e) {
			throw org.apache.axis2.AxisFault.makeFault(e);
		}

	}

	private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory,
	                                                      java.lang.String param1,
	                                                      org.wso2.developerstudio.eclipse.carbonserver.base.carbon.application.ApplicationAdminStub.GetAppData dummyWrappedType,
	                                                      boolean optimizeContent) throws org.apache.axis2.AxisFault {

		try {
			org.wso2.developerstudio.eclipse.carbonserver.base.carbon.application.ApplicationAdminStub.GetAppData wrappedType =
			                                                                                                                    new org.wso2.developerstudio.eclipse.carbonserver.base.carbon.application.ApplicationAdminStub.GetAppData();

			wrappedType.setAppName(param1);

			org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();

			emptyEnvelope.getBody()
			             .addChild(wrappedType.getOMElement(org.wso2.developerstudio.eclipse.carbonserver.base.carbon.application.ApplicationAdminStub.GetAppData.MY_QNAME,
			                                                factory));

			return emptyEnvelope;
		} catch (org.apache.axis2.databinding.ADBException e) {
			throw org.apache.axis2.AxisFault.makeFault(e);
		}
	}

	/* methods to provide back word compatibility */

	private org.wso2.developerstudio.eclipse.carbonserver.base.carbon.application.ApplicationAdminStub.ApplicationMetadata getGetAppDataResponse_return(org.wso2.developerstudio.eclipse.carbonserver.base.carbon.application.ApplicationAdminStub.GetAppDataResponse wrappedType) {

		return wrappedType.get_return();

	}

	private java.lang.String[] getListAllApplicationsResponse_return(org.wso2.developerstudio.eclipse.carbonserver.base.carbon.application.ApplicationAdminStub.ListAllApplicationsResponse wrappedType) {

		return wrappedType.get_return();

	}

	private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory,
	                                                      java.lang.String param1,
	                                                      org.wso2.developerstudio.eclipse.carbonserver.base.carbon.application.ApplicationAdminStub.DeleteApplication dummyWrappedType,
	                                                      boolean optimizeContent) throws org.apache.axis2.AxisFault {

		try {
			org.wso2.developerstudio.eclipse.carbonserver.base.carbon.application.ApplicationAdminStub.DeleteApplication wrappedType =
			                                                                                                                           new org.wso2.developerstudio.eclipse.carbonserver.base.carbon.application.ApplicationAdminStub.DeleteApplication();

			wrappedType.setAppName(param1);

			org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();

			emptyEnvelope.getBody()
			             .addChild(wrappedType.getOMElement(org.wso2.developerstudio.eclipse.carbonserver.base.carbon.application.ApplicationAdminStub.DeleteApplication.MY_QNAME,
			                                                factory));

			return emptyEnvelope;
		} catch (org.apache.axis2.databinding.ADBException e) {
			throw org.apache.axis2.AxisFault.makeFault(e);
		}
	}

	/* methods to provide back word compatibility */

	/**
	 * get the default envelope
	 */
	private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory) {
		return factory.getDefaultEnvelope();
	}

	private java.lang.Object fromOM(org.apache.axiom.om.OMElement param, java.lang.Class type,
	                                java.util.Map extraNamespaces) throws org.apache.axis2.AxisFault {

		try {

			if (org.wso2.developerstudio.eclipse.carbonserver.base.carbon.application.ApplicationAdminStub.GetAppData.class.equals(type)) {

				return org.wso2.developerstudio.eclipse.carbonserver.base.carbon.application.ApplicationAdminStub.GetAppData.Factory.parse(param.getXMLStreamReaderWithoutCaching());

			}

			if (org.wso2.developerstudio.eclipse.carbonserver.base.carbon.application.ApplicationAdminStub.GetAppDataResponse.class.equals(type)) {

				return org.wso2.developerstudio.eclipse.carbonserver.base.carbon.application.ApplicationAdminStub.GetAppDataResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());

			}

			if (org.wso2.developerstudio.eclipse.carbonserver.base.carbon.application.ApplicationAdminStub.ExceptionE.class.equals(type)) {

				return org.wso2.developerstudio.eclipse.carbonserver.base.carbon.application.ApplicationAdminStub.ExceptionE.Factory.parse(param.getXMLStreamReaderWithoutCaching());

			}

			if (org.wso2.developerstudio.eclipse.carbonserver.base.carbon.application.ApplicationAdminStub.ListAllApplicationsResponse.class.equals(type)) {

				return org.wso2.developerstudio.eclipse.carbonserver.base.carbon.application.ApplicationAdminStub.ListAllApplicationsResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());

			}

			if (org.wso2.developerstudio.eclipse.carbonserver.base.carbon.application.ApplicationAdminStub.ExceptionE.class.equals(type)) {

				return org.wso2.developerstudio.eclipse.carbonserver.base.carbon.application.ApplicationAdminStub.ExceptionE.Factory.parse(param.getXMLStreamReaderWithoutCaching());

			}

			if (org.wso2.developerstudio.eclipse.carbonserver.base.carbon.application.ApplicationAdminStub.DeleteApplication.class.equals(type)) {

				return org.wso2.developerstudio.eclipse.carbonserver.base.carbon.application.ApplicationAdminStub.DeleteApplication.Factory.parse(param.getXMLStreamReaderWithoutCaching());

			}

			if (org.wso2.developerstudio.eclipse.carbonserver.base.carbon.application.ApplicationAdminStub.ExceptionE.class.equals(type)) {

				return org.wso2.developerstudio.eclipse.carbonserver.base.carbon.application.ApplicationAdminStub.ExceptionE.Factory.parse(param.getXMLStreamReaderWithoutCaching());

			}

		} catch (java.lang.Exception e) {
			throw org.apache.axis2.AxisFault.makeFault(e);
		}
		return null;
	}

}
