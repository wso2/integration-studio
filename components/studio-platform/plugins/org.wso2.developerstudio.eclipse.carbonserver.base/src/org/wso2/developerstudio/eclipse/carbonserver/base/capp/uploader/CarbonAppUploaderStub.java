/**
 * CarbonAppUploaderStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6-wso2v4 Built on : Dec 08, 2010 (06:36:57
 * UTC)
 */
package org.wso2.developerstudio.eclipse.carbonserver.base.capp.uploader;

/*
 * CarbonAppUploaderStub java implementation
 */

public class CarbonAppUploaderStub extends org.apache.axis2.client.Stub {
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
		return java.lang.Long.toString(java.lang.System.currentTimeMillis()) + "_" + counter;
	}

	private void populateAxisService() throws org.apache.axis2.AxisFault {

		// creating the Service with a unique name
		_service = new org.apache.axis2.description.AxisService("CarbonAppUploader" + getUniqueSuffix());
		addAnonymousOperations();

		// creating the operations
		org.apache.axis2.description.AxisOperation __operation;

		_operations = new org.apache.axis2.description.AxisOperation[1];

		__operation = new org.apache.axis2.description.OutInAxisOperation();

		__operation.setName(new javax.xml.namespace.QName("http://upload.application.carbon.wso2.org", "uploadApp"));
		_service.addOperation(__operation);

		_operations[0] = __operation;

	}

	// populates the faults
	private void populateFaults() {

	}

	/**
	 * Constructor that takes in a configContext
	 */

	public CarbonAppUploaderStub(org.apache.axis2.context.ConfigurationContext configurationContext,
	                             java.lang.String targetEndpoint) throws org.apache.axis2.AxisFault {
		this(configurationContext, targetEndpoint, false);
	}

	/**
	 * Constructor that takes in a configContext and useseperate listner
	 */
	public CarbonAppUploaderStub(org.apache.axis2.context.ConfigurationContext configurationContext,
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
	public CarbonAppUploaderStub(org.apache.axis2.context.ConfigurationContext configurationContext)
	                                                                                                throws org.apache.axis2.AxisFault {

		this(configurationContext,
		     "https://10.100.0.162:9443/services/CarbonAppUploader.CarbonAppUploaderHttpsSoap12Endpoint/");

	}

	/**
	 * Default Constructor
	 */
	public CarbonAppUploaderStub() throws org.apache.axis2.AxisFault {

		this("https://10.100.0.162:9443/services/CarbonAppUploader.CarbonAppUploaderHttpsSoap12Endpoint/");

	}

	/**
	 * Constructor taking the target endpoint
	 */
	public CarbonAppUploaderStub(java.lang.String targetEndpoint) throws org.apache.axis2.AxisFault {
		this(null, targetEndpoint);
	}

	/**
	 * Auto generated method signature
	 * 
	 * @see org.wso2.developerstudio.eclipse.carbonserver.base.capp.uploader.CarbonAppUploader#uploadApp
	 * @param uploadApp
	 */

	public void uploadApp(

	org.wso2.developerstudio.eclipse.carbonserver.base.capp.uploader.CarbonAppUploaderStub.UploadedFileItem[] fileItems)

	throws java.rmi.RemoteException

	{
		org.apache.axis2.context.MessageContext _messageContext = null;
		try {
			org.apache.axis2.client.OperationClient _operationClient =
			                                                           _serviceClient.createClient(_operations[0].getName());
			_operationClient.getOptions().setAction("urn:uploadApp");
			_operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

			addPropertyToOperationClient(_operationClient,
			                             org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,
			                             "&");

			// create a message context
			_messageContext = new org.apache.axis2.context.MessageContext();

			// create SOAP envelope with that payload
			org.apache.axiom.soap.SOAPEnvelope env = null;
			org.wso2.developerstudio.eclipse.carbonserver.base.capp.uploader.CarbonAppUploaderStub.UploadApp dummyWrappedType =
			                                                                                                                    null;
			env =
			      toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()), fileItems,
			                 dummyWrappedType,
			                 optimizeContent(new javax.xml.namespace.QName("http://upload.application.carbon.wso2.org",
			                                                               "uploadApp")));

			// adding SOAP soap_headers
			_serviceClient.addHeadersToEnvelope(env);
			// set the message context with that soap envelope
			_messageContext.setEnvelope(env);

			// add the message contxt to the operation client
			_operationClient.addMessageContext(_messageContext);

			// execute the operation client
			_operationClient.execute(true);

			return;

		} catch (org.apache.axis2.AxisFault f) {

			org.apache.axiom.om.OMElement faultElt = f.getDetail();
			if (faultElt != null) {
				if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),
				                                                                              "uploadApp"))) {
					// make the fault by reflection
					try {
						java.lang.String exceptionClassName =
						                                      (java.lang.String) faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(
						                                                                                                                                faultElt.getQName(),
						                                                                                                                                "uploadApp"));
						java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
						java.lang.Exception ex = (java.lang.Exception) exceptionClass.newInstance();
						// message class
						java.lang.String messageClassName =
						                                    (java.lang.String) faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(
						                                                                                                                   faultElt.getQName(),
						                                                                                                                   "uploadApp"));
						java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
						java.lang.Object messageObject = fromOM(faultElt, messageClass, null);
						java.lang.reflect.Method m =
						                             exceptionClass.getMethod("setFaultMessage",
						                                                      new java.lang.Class[] { messageClass });
						m.invoke(ex, new java.lang.Object[] { messageObject });

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
			if (_messageContext.getTransportOut() != null) {
				_messageContext.getTransportOut().getSender().cleanup(_messageContext);
			}
		}
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

	// https://10.100.0.162:9443/services/CarbonAppUploader.CarbonAppUploaderHttpsSoap12Endpoint/
	public static class ExtensionMapper {

		public static java.lang.Object getTypeObject(java.lang.String namespaceURI, java.lang.String typeName,
		                                             javax.xml.stream.XMLStreamReader reader)
		                                                                                     throws java.lang.Exception {

			if ("http://upload.application.carbon.wso2.org/xsd".equals(namespaceURI) &&
			    "UploadedFileItem".equals(typeName)) {

				return UploadedFileItem.Factory.parse(reader);

			}

			throw new org.apache.axis2.databinding.ADBException("Unsupported type " + namespaceURI + " " + typeName);
		}

	}

	public static class UploadApp implements org.apache.axis2.databinding.ADBBean {

		public static final javax.xml.namespace.QName MY_QNAME =
		                                                         new javax.xml.namespace.QName(
		                                                                                       "http://upload.application.carbon.wso2.org",
		                                                                                       "uploadApp", "ns2");

		/**
		 * field for FileItems
		 * This was an Array!
		 */

		protected UploadedFileItem[] localFileItems;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method
		 * for this attribute. It will be used to determine whether to include
		 * this field
		 * in the serialized XML
		 */
		protected boolean localFileItemsTracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return UploadedFileItem[]
		 */
		public UploadedFileItem[] getFileItems() {
			return localFileItems;
		}

		/**
		 * validate the array for FileItems
		 */
		protected void validateFileItems(UploadedFileItem[] param) {

		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            FileItems
		 */
		public void setFileItems(UploadedFileItem[] param) {

			validateFileItems(param);

			localFileItemsTracker = true;

			this.localFileItems = param;
		}

		/**
		 * Auto generated add method for the array for convenience
		 * 
		 * @param param
		 *            UploadedFileItem
		 */
		public void addFileItems(UploadedFileItem param) {
			if (localFileItems == null) {
				localFileItems = new UploadedFileItem[] {};
			}

			// update the setting tracker
			localFileItemsTracker = true;

			java.util.List list = org.apache.axis2.databinding.utils.ConverterUtil.toList(localFileItems);
			list.add(param);
			this.localFileItems = (UploadedFileItem[]) list.toArray(new UploadedFileItem[list.size()]);

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

				java.lang.String namespacePrefix =
				                                   registerPrefix(xmlWriter,
				                                                  "http://upload.application.carbon.wso2.org");
				if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", namespacePrefix +
					                                                                           ":uploadApp", xmlWriter);
				} else {
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "uploadApp", xmlWriter);
				}

			}
			if (localFileItemsTracker) {
				if (localFileItems != null) {
					for (int i = 0; i < localFileItems.length; i++) {
						if (localFileItems[i] != null) {
							localFileItems[i].serialize(new javax.xml.namespace.QName(
							                                                          "http://upload.application.carbon.wso2.org",
							                                                          "fileItems"), xmlWriter);
						} else {

							writeStartElement(null, "http://upload.application.carbon.wso2.org", "fileItems", xmlWriter);

							// write the nil attribute
							writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);
							xmlWriter.writeEndElement();

						}

					}
				} else {

					writeStartElement(null, "http://upload.application.carbon.wso2.org", "fileItems", xmlWriter);

					// write the nil attribute
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);
					xmlWriter.writeEndElement();

				}
			}
			xmlWriter.writeEndElement();

		}

		private static java.lang.String generatePrefix(java.lang.String namespace) {
			if (namespace.equals("http://upload.application.carbon.wso2.org")) {
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

			if (localFileItemsTracker) {
				if (localFileItems != null) {
					for (int i = 0; i < localFileItems.length; i++) {

						if (localFileItems[i] != null) {
							elementList.add(new javax.xml.namespace.QName("http://upload.application.carbon.wso2.org",
							                                              "fileItems"));
							elementList.add(localFileItems[i]);
						} else {

							elementList.add(new javax.xml.namespace.QName("http://upload.application.carbon.wso2.org",
							                                              "fileItems"));
							elementList.add(null);

						}

					}
				} else {

					elementList.add(new javax.xml.namespace.QName("http://upload.application.carbon.wso2.org",
					                                              "fileItems"));
					elementList.add(localFileItems);

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
			public static UploadApp parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
				UploadApp object = new UploadApp();

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

							if (!"uploadApp".equals(type)) {
								// find namespace for the prefix
								java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
								return (UploadApp) ExtensionMapper.getTypeObject(nsUri, type, reader);
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
					    new javax.xml.namespace.QName("http://upload.application.carbon.wso2.org", "fileItems").equals(reader.getName())) {

						// Process the array and step past its final element's
						// end.

						nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
						if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
							list1.add(null);
							reader.next();
						} else {
							list1.add(UploadedFileItem.Factory.parse(reader));
						}
						// loop until we find a start element that is not part
						// of this array
						boolean loopDone1 = false;
						while (!loopDone1) {
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
								loopDone1 = true;
							} else {
								if (new javax.xml.namespace.QName("http://upload.application.carbon.wso2.org",
								                                  "fileItems").equals(reader.getName())) {

									nillableValue =
									                reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
									                                         "nil");
									if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
										list1.add(null);
										reader.next();
									} else {
										list1.add(UploadedFileItem.Factory.parse(reader));
									}
								} else {
									loopDone1 = true;
								}
							}
						}
						// call the converter utility to convert and set the
						// array

						object.setFileItems((UploadedFileItem[]) org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(UploadedFileItem.class,
						                                                                                                         list1));

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

	public static class UploadedFileItem implements org.apache.axis2.databinding.ADBBean {
		/*
		 * This type was generated from the piece of schema that had
		 * name = UploadedFileItem
		 * Namespace URI = http://upload.application.carbon.wso2.org/xsd
		 * Namespace Prefix = ns1
		 */

		/**
		 * field for DataHandler
		 */

		protected javax.activation.DataHandler localDataHandler;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method
		 * for this attribute. It will be used to determine whether to include
		 * this field
		 * in the serialized XML
		 */
		protected boolean localDataHandlerTracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return javax.activation.DataHandler
		 */
		public javax.activation.DataHandler getDataHandler() {
			return localDataHandler;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            DataHandler
		 */
		public void setDataHandler(javax.activation.DataHandler param) {
			localDataHandlerTracker = true;

			this.localDataHandler = param;

		}

		/**
		 * field for FileName
		 */

		protected java.lang.String localFileName;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method
		 * for this attribute. It will be used to determine whether to include
		 * this field
		 * in the serialized XML
		 */
		protected boolean localFileNameTracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getFileName() {
			return localFileName;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            FileName
		 */
		public void setFileName(java.lang.String param) {
			localFileNameTracker = true;

			this.localFileName = param;

		}

		/**
		 * field for FileType
		 */

		protected java.lang.String localFileType;

		/*
		 * This tracker boolean wil be used to detect whether the user called
		 * the set method
		 * for this attribute. It will be used to determine whether to include
		 * this field
		 * in the serialized XML
		 */
		protected boolean localFileTypeTracker = false;

		/**
		 * Auto generated getter method
		 * 
		 * @return java.lang.String
		 */
		public java.lang.String getFileType() {
			return localFileType;
		}

		/**
		 * Auto generated setter method
		 * 
		 * @param param
		 *            FileType
		 */
		public void setFileType(java.lang.String param) {
			localFileTypeTracker = true;

			this.localFileType = param;

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
				                                                  "http://upload.application.carbon.wso2.org/xsd");
				if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", namespacePrefix +
					                                                                           ":UploadedFileItem",
					               xmlWriter);
				} else {
					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "UploadedFileItem",
					               xmlWriter);
				}

			}
			if (localDataHandlerTracker) {
				namespace = "http://upload.application.carbon.wso2.org/xsd";
				writeStartElement(null, namespace, "dataHandler", xmlWriter);

				if (localDataHandler != null) {
					try {
						org.apache.axiom.util.stax.XMLStreamWriterUtils.writeDataHandler(xmlWriter, localDataHandler,
						                                                                 null, true);
					} catch (java.io.IOException ex) {
						throw new javax.xml.stream.XMLStreamException("Unable to read data handler for dataHandler", ex);
					}
				} else {

					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

				}

				xmlWriter.writeEndElement();
			}
			if (localFileNameTracker) {
				namespace = "http://upload.application.carbon.wso2.org/xsd";
				writeStartElement(null, namespace, "fileName", xmlWriter);

				if (localFileName == null) {
					// write the nil attribute

					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

				} else {

					xmlWriter.writeCharacters(localFileName);

				}

				xmlWriter.writeEndElement();
			}
			if (localFileTypeTracker) {
				namespace = "http://upload.application.carbon.wso2.org/xsd";
				writeStartElement(null, namespace, "fileType", xmlWriter);

				if (localFileType == null) {
					// write the nil attribute

					writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);

				} else {

					xmlWriter.writeCharacters(localFileType);

				}

				xmlWriter.writeEndElement();
			}
			xmlWriter.writeEndElement();

		}

		private static java.lang.String generatePrefix(java.lang.String namespace) {
			if (namespace.equals("http://upload.application.carbon.wso2.org/xsd")) {
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

			if (localDataHandlerTracker) {
				elementList.add(new javax.xml.namespace.QName("http://upload.application.carbon.wso2.org/xsd",
				                                              "dataHandler"));

				elementList.add(localDataHandler);
			}
			if (localFileNameTracker) {
				elementList.add(new javax.xml.namespace.QName("http://upload.application.carbon.wso2.org/xsd",
				                                              "fileName"));

				elementList.add(localFileName == null
				                                     ? null
				                                     : org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localFileName));
			}
			if (localFileTypeTracker) {
				elementList.add(new javax.xml.namespace.QName("http://upload.application.carbon.wso2.org/xsd",
				                                              "fileType"));

				elementList.add(localFileType == null
				                                     ? null
				                                     : org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localFileType));
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
			public static UploadedFileItem parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
				UploadedFileItem object = new UploadedFileItem();

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

							if (!"UploadedFileItem".equals(type)) {
								// find namespace for the prefix
								java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
								return (UploadedFileItem) ExtensionMapper.getTypeObject(nsUri, type, reader);
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
					    new javax.xml.namespace.QName("http://upload.application.carbon.wso2.org/xsd", "dataHandler").equals(reader.getName())) {

						nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
						if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
							object.setDataHandler(null);
							reader.next();
						} else {

							object.setDataHandler(org.apache.axiom.util.stax.XMLStreamReaderUtils.getDataHandlerFromElement(reader));

						}

						reader.next();

					} // End of if for expected property start element

					else {

					}

					while (!reader.isStartElement() && !reader.isEndElement())
						reader.next();

					if (reader.isStartElement() &&
					    new javax.xml.namespace.QName("http://upload.application.carbon.wso2.org/xsd", "fileName").equals(reader.getName())) {

						nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
						if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

							java.lang.String content = reader.getElementText();

							object.setFileName(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

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
					    new javax.xml.namespace.QName("http://upload.application.carbon.wso2.org/xsd", "fileType").equals(reader.getName())) {

						nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
						if (!"true".equals(nillableValue) && !"1".equals(nillableValue)) {

							java.lang.String content = reader.getElementText();

							object.setFileType(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

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

	private org.apache.axiom.om.OMElement toOM(org.wso2.developerstudio.eclipse.carbonserver.base.capp.uploader.CarbonAppUploaderStub.UploadApp param,
	                                           boolean optimizeContent) throws org.apache.axis2.AxisFault {

		try {
			return param.getOMElement(org.wso2.developerstudio.eclipse.carbonserver.base.capp.uploader.CarbonAppUploaderStub.UploadApp.MY_QNAME,
			                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
		} catch (org.apache.axis2.databinding.ADBException e) {
			throw org.apache.axis2.AxisFault.makeFault(e);
		}

	}

	private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory,
	                                                      org.wso2.developerstudio.eclipse.carbonserver.base.capp.uploader.CarbonAppUploaderStub.UploadedFileItem[] param1,
	                                                      org.wso2.developerstudio.eclipse.carbonserver.base.capp.uploader.CarbonAppUploaderStub.UploadApp dummyWrappedType,
	                                                      boolean optimizeContent) throws org.apache.axis2.AxisFault {

		try {
			org.wso2.developerstudio.eclipse.carbonserver.base.capp.uploader.CarbonAppUploaderStub.UploadApp wrappedType =
			                                                                                                               new org.wso2.developerstudio.eclipse.carbonserver.base.capp.uploader.CarbonAppUploaderStub.UploadApp();

			wrappedType.setFileItems(param1);

			org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();

			emptyEnvelope.getBody()
			             .addChild(wrappedType.getOMElement(org.wso2.developerstudio.eclipse.carbonserver.base.capp.uploader.CarbonAppUploaderStub.UploadApp.MY_QNAME,
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

			if (org.wso2.developerstudio.eclipse.carbonserver.base.capp.uploader.CarbonAppUploaderStub.UploadApp.class.equals(type)) {

				return org.wso2.developerstudio.eclipse.carbonserver.base.capp.uploader.CarbonAppUploaderStub.UploadApp.Factory.parse(param.getXMLStreamReaderWithoutCaching());

			}

		} catch (java.lang.Exception e) {
			throw org.apache.axis2.AxisFault.makeFault(e);
		}
		return null;
	}

}
