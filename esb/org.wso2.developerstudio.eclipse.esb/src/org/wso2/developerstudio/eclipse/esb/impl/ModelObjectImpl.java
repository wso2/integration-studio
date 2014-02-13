/*
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
package org.wso2.developerstudio.eclipse.esb.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.w3c.dom.Attr;
import org.w3c.dom.CDATASection;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.wso2.developerstudio.eclipse.esb.Comment;
import org.wso2.developerstudio.eclipse.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.esb.EsbVersion;
import org.wso2.developerstudio.eclipse.esb.ModelObject;
import org.wso2.developerstudio.eclipse.esb.ModelObjectState;
import org.wso2.developerstudio.eclipse.esb.Namespace;
import org.wso2.developerstudio.eclipse.esb.core.preferences.ui.PreferenceData;
import org.wso2.developerstudio.eclipse.esb.mediators.MediatorsFactory;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Model Object</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.ModelObjectImpl#getObjectState <em>Object State</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.ModelObjectImpl#getSourceText <em>Source Text</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.ModelObjectImpl#getDefaultNamespace <em>Default Namespace</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.ModelObjectImpl#getAdditionalNamespaces <em>Additional Namespaces</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.ModelObjectImpl#getCurrentEsbVersion <em>Current Esb Version</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.impl.ModelObjectImpl#getComment <em>Comment</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ModelObjectImpl extends EObjectImpl implements
		ModelObject {
	/**
	 * The default value of the '{@link #getObjectState() <em>Object State</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getObjectState()
	 * @generated
	 * @ordered
	 */
	protected static final ModelObjectState OBJECT_STATE_EDEFAULT = ModelObjectState.NORMAL;

	/**
	 * The cached value of the '{@link #getObjectState() <em>Object State</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getObjectState()
	 * @generated
	 * @ordered
	 */
	protected ModelObjectState objectState = OBJECT_STATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getSourceText() <em>Source Text</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getSourceText()
	 * @generated
	 * @ordered
	 */
	protected static final String SOURCE_TEXT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSourceText() <em>Source Text</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getSourceText()
	 * @generated
	 * @ordered
	 */
	protected String sourceText = SOURCE_TEXT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDefaultNamespace() <em>Default Namespace</em>}' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getDefaultNamespace()
	 * @generated
	 * @ordered
	 */
	protected Namespace defaultNamespace;

	/**
	 * The cached value of the '{@link #getAdditionalNamespaces() <em>Additional Namespaces</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdditionalNamespaces()
	 * @generated
	 * @ordered
	 */
	protected EList<Namespace> additionalNamespaces;

	/**
	 * The default value of the '{@link #getCurrentEsbVersion() <em>Current Esb Version</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getCurrentEsbVersion()
	 * @generated
	 * @ordered
	 */
	protected static final EsbVersion CURRENT_ESB_VERSION_EDEFAULT = EsbVersion.ESB301;

	/**
	 * The cached value of the '{@link #getCurrentEsbVersion() <em>Current Esb Version</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getCurrentEsbVersion()
	 * @generated
	 * @ordered
	 */
	protected EsbVersion currentEsbVersion = CURRENT_ESB_VERSION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getComment() <em>Comment</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComment()
	 * @generated
	 * @ordered
	 */
	protected EList<Comment> comment;

	/**
	 * Utility interface for handling loaded objects.
	 * 
	 * @param <T>
	 *            {@link ModelObject} sub type.
	 */
	protected interface ObjectHandler<T> {
		void handle(T object);
	}

	/**
	 * Reference to the esb factory.
	 */
	private EsbFactory esbFactory = EsbFactory.eINSTANCE;

	/**
	 * Reference to the mediator factory.
	 */
	private MediatorsFactory mediatorFactory = MediatorsFactory.eINSTANCE;

	/**
	 * List of errors encountered while loading this model object.
	 */
	private List<Throwable> loadErrors;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @!generated
	 */
	protected ModelObjectImpl() {
		super();

		if (PreferenceData.getEsbVersionPreference().equals("ESB.3.0.1")) {
			setCurrentEsbVersion(EsbVersion.ESB301);
		} else if (PreferenceData.getEsbVersionPreference().equals("ESB.4.0.0")) {
			setCurrentEsbVersion(EsbVersion.ESB400);
		} else {
			setCurrentEsbVersion(EsbVersion.ESB301);
		}

	}

	/**
	 * {@inheritDoc}
	 */
	public void load(Element self) throws Exception {
		// Extract additional namespaces.
		Map<String, String> extractedNamespaceEntries = extractNamespaces(self);
		// Load default namespace info.
		if (!StringUtils.isBlank(self.getNamespaceURI())) {
			Namespace defaultNs = getEsbFactory().createNamespace();
			defaultNs.setUri(self.getNamespaceURI());

			if (!StringUtils.isBlank(self.getPrefix())) {
				defaultNs.setPrefix(self.getPrefix());
				// Additional namespaces should not contain the namespace
				// corresponding to current element itself.
				extractedNamespaceEntries.remove(self.getPrefix());
			}
			setDefaultNamespace(defaultNs);
		}

		// Store extracted namespaces as additional namespaces.
		for (Entry<String, String> namespaceEntry : extractedNamespaceEntries
				.entrySet()) {
			Namespace extractedNs = getEsbFactory().createNamespace();
			extractedNs.setPrefix(namespaceEntry.getKey());
			extractedNs.setUri(namespaceEntry.getValue());
			getAdditionalNamespaces().add(extractedNs);
		}

		doLoad(self);
	}

	/**
	 * {@inheritDoc}
	 */
	public Element save(Element parent) throws Exception {
		if (getObjectState().equals(ModelObjectState.NORMAL)) {
			Element self = doSave(parent);

			// Save additional namespace declarations.
			if (null != self) {
				for (Namespace additionalNs : getAdditionalNamespaces()) {
					String nsAttributeName = String.format("xmlns:%s",
							additionalNs.getPrefix());

					// Do not override.
					if (!self.hasAttribute(nsAttributeName)) {
						self.setAttribute(nsAttributeName,
								additionalNs.getUri());
					}
				}
			}
			return self;
		} else {
			// Append the source text as a comment node.
			org.w3c.dom.Comment comment = parent.getOwnerDocument().createComment(
					getSourceText());
			parent.appendChild(comment);
			return parent;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean hasSourceRepresentation() {
		return true;
	}

	/**
	 * Performs the actual loading operation.
	 * 
	 * @param self
	 *            serialized form of this model object.
	 * @throws Exception
	 *             if the given {@link Element} cannot be understood by this
	 *             model object.
	 */
	//protected abstract void doLoad(Element self) throws Exception;

	protected void doLoad(Element self) throws Exception {
		int realCount=0;
		for (int i=0;i<self.getChildNodes().getLength();++i){
			if(self.getChildNodes().item(i) instanceof org.w3c.dom.Comment){
				Comment newComment= getEsbFactory().createComment();
				newComment.setValue(((org.w3c.dom.Comment)self.getChildNodes().item(i)).getTextContent());
				newComment.setPosition(realCount);
				getComment().add(newComment);				
			}
			++realCount;
			/*
			 * There is '#text' element in between actual elements.These elements should be avoid when we count.  
			 */
			if(self.getChildNodes().item(i).getNodeName().equals("#text")){
				--realCount;
			}
		}		 
	}
	
	/**
	 * Performs the actual saving operation.
	 * 
	 * @param parent
	 *            parent element.
	 * @return newly created child {@link Element} or parent itself if no child
	 *         element was created.
	 * @throws Exception
	 *             if an error occurs while serializing.
	 */
	protected abstract Element doSave(Element parent) throws Exception;

	
	protected Element addComments(Element self) throws Exception {
		if(comment !=null){
			for(int i=0;i<comment.size();++i){
				Node tempNode=self.getFirstChild();
				for(int j=0;(tempNode!=null)&&(j<comment.get(i).getPosition());++j){
					tempNode=tempNode.getNextSibling();
				}
				self.insertBefore(self.getOwnerDocument().createComment(comment.get(i).getValue()), tempNode);
			}
			}
		return null;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public List<Throwable> getLoadErrors() {
		// TODO: It's not good to allow direct access to this list, a better
		// design must be deviced later.
		if (null == loadErrors) {
			loadErrors = new ArrayList<Throwable>();
		}
		return loadErrors;
	}

	/**
	 * Utility method for retrieving the {@link EsbFactory}.
	 * 
	 * @return {@link EsbFactory} instance.
	 */
	protected EsbFactory getEsbFactory() {
		return this.esbFactory;
	}

	/**
	 * Utility method for retrieving the {@link MediatorFactory}.
	 * 
	 * @return {@link MediatorFactory} instance.
	 */
	protected MediatorsFactory getMediatorFactory() {
		return this.mediatorFactory;
	}

	/**
	 * Utility method for loading a {@link ModelObject} instance from the
	 * corresponding XML {@link Element}.
	 * 
	 * @param <T>
	 *            {@link ModelObject} sub type.
	 * @param element
	 *            {@link Element} which holds the {@link ModelObject}
	 *            definition.
	 * @param clazz
	 *            {@link Class} of the object to be loaded.
	 * @param isMandatory
	 *            whether this object is mandatory.
	 * @param handler
	 *            call back used to report back upon a successful loading
	 *            operation.
	 * @throws Exception
	 *             if a mandatory object cannot be loaded.
	 */
	protected <T extends ModelObject> void loadObject(Element element,
			Class<T> clazz, boolean isMandatory, ObjectHandler<T> handler)
			throws Exception {
		T result = getEsbFactory().loadModelObject(element, clazz, this);
		if (null != result) {
			handler.handle(result);
		} else if (isMandatory) {
			throw new Exception(
					String.format(
							"Error while loading mandatory object corresponding to element [%s].",
							element.getLocalName()));
		}
	}

	/**
	 * Attempts to load the {@link ModelObject} corresponding to the specified
	 * child {@link Element}.
	 * 
	 * @param <T>
	 *            {@link ModelObject} sub type.
	 * @param parent
	 *            parent element.
	 * @param childName
	 *            local name of the child element.
	 * @param clazz
	 *            class of the child object to be loaded.
	 * @param isMandatory
	 *            whether this object is mandatory.
	 * @param handler
	 *            call back used to report back upon a successful loading
	 *            operation.
	 * @throws Exception
	 *             if a mandatory object cannot be loaded.
	 */
	protected <T extends ModelObject> void loadObject(Element parent,
			String childName, Class<T> clazz, boolean isMandatory,
			ObjectHandler<T> handler) throws Exception {
		Element childElem = getChildElement(parent, childName);
		if (null != childElem) {
			loadObject(childElem, clazz, isMandatory, handler);
		} else if (isMandatory) {
			throw new Exception(
					String.format(
							"The element [%s] is missing the required child element [%s].",
							parent.getLocalName(), childName));
		}
	}

	/**
	 * Attempts to load all the child objects corresponding to the specified
	 * child elements.
	 * 
	 * @param <T>
	 *            {@link ModelObject} sub type.
	 * @param parent
	 *            parent element.
	 * @param childName
	 *            local name of the child elements.
	 * @param clazz
	 *            class of the child objects to be loaded.
	 * @param handler
	 *            call back used to report back upon successful loading
	 *            operations.
	 * @throws Exception
	 *             if at least one object cannot be loaded.
	 */
	protected <T extends ModelObject> void loadObjects(Element parent,
			String childName, Class<T> clazz, ObjectHandler<T> handler)
			throws Exception {
		List<Element> childElems = getChildElements(parent, childName);
		for (Element childElem : childElems) {
			loadObject(childElem, clazz, true, handler);
		}
	}

	/**
	 * Attempts to load all the child objects nested within the specified parent
	 * element.
	 * 
	 * @param <T>
	 *            {@link ModelObject} sub type.
	 * @param parent
	 *            parent element.
	 * @param clazz
	 *            class of the child objects to be loaded.
	 * @param handler
	 *            call back used to report back upon successful loading
	 *            operations.
	 * @throws Exception
	 *             if at least one object cannot be loaded.
	 */
	protected <T extends ModelObject> void loadObjects(Element parent,
			Class<T> clazz, ObjectHandler<T> handler) throws Exception {
		List<Element> childElems = getChildElements(parent);
		for (Element childElem : childElems) {
			loadObject(childElem, clazz, true, handler);
		}
	}

	/**
	 * Creates a child under the parent element with default namespace
	 * configuration.
	 * 
	 * @param parent
	 *            parent {@link Element}.
	 * @param localName
	 *            local name of the child {@link Element}.
	 * @return newly created child {@link Element}.
	 */
	protected Element createChildElement(Element parent, String localName) {
		String qualifiedName = localName;
		String namespaceUri = DEFAULT_SYNAPSE_NAMESPACE_URI;

		// Calculate namespace information.
		Namespace defaultNs = lookupNamespace();
		if (null != defaultNs && !StringUtils.isBlank(defaultNs.getUri())) {
			namespaceUri = defaultNs.getUri();
			if (!StringUtils.isBlank(defaultNs.getPrefix())) {
				qualifiedName = String.format("%s:%s", defaultNs.getPrefix(),
						localName);
			}
		} else if (USE_SYNAPSE_NAMESPACE_PREFIX) {
			qualifiedName = String.format("%s:%s",
					DEFAULT_SYNAPSE_NAMESPACE_PREFIX, localName);
		}

		Element child = parent.getOwnerDocument().createElementNS(namespaceUri,
				qualifiedName);
		parent.appendChild(child);

		return child;
	}

	/**
	 * Creates a child under the parent element with the given namespace
	 * configuration.
	 * 
	 * @param parent
	 *            parent {@link Element}.
	 * @param childNsURI
	 *            namespace uri of the child element.
	 * @param childNsPrefix
	 *            namespace prefix.
	 * @param childLocalName
	 *            localname of the child element.
	 * @return newly created child element.
	 */
	protected Element createChildElement(Element parent, String childNsURI,
			String childNsPrefix, String childLocalName) {
		String qualifiedName = String.format("%s:%s", childNsPrefix,
				childLocalName);
		Element child = parent.getOwnerDocument().createElementNS(childNsURI,
				qualifiedName);
		parent.appendChild(child);
		return child;
	}

	/**
	 * Search within the parent element for the specified child element.
	 * 
	 * @param parent
	 *            parent {@link Element}.
	 * @param localName
	 *            local name of the child element.
	 * @return child {@link Element} if found or null.
	 */
	protected Element getChildElement(Element parent, String localName) {
		NodeList children = parent.getChildNodes();
		for (int i = 0; i < children.getLength(); i++) {
			Node node = children.item(i);
			if (node instanceof Element) {
				Element child = (Element) node;
				if (child.getLocalName().equalsIgnoreCase(localName)) {
					return child;
				}
			}
		}
		return null;
	}

	/**
	 * Utility method for getting a nested {@link CDATASection} directly under
	 * the given parent {@link Element}.
	 * 
	 * @param parent
	 *            parent {@link Element}.
	 * @return {@link CDATASection} nested under the given parent
	 *         {@link Element} or null.
	 */
	protected CDATASection getChildCDATASection(Element parent) {
		NodeList children = parent.getChildNodes();
		for (int i = 0; i < children.getLength(); i++) {
			Node child = children.item(i);
			if (child instanceof CDATASection) {
				return (CDATASection) child;
			}
		}
		return null;
	}

	/**
	 * Search within the parent element for all child elements bearing the
	 * specified local name.
	 * 
	 * @param parent
	 *            parent {@link Element}.
	 * @param localName
	 *            local name of child elements.
	 * @return list of child elements having the specified local name.
	 */
	protected List<Element> getChildElements(Element parent, String localName) {
		NodeList children = parent.getChildNodes();
		List<Element> result = new ArrayList<Element>();
		for (int i = 0; i < children.getLength(); i++) {
			Node node = children.item(i);
			if (node instanceof Element) {
				Element child = (Element) node;
				if (child.getLocalName().equalsIgnoreCase(localName)) {
					result.add(child);
				}
			}
		}
		return result;
	}

	/**
	 * Retrieve all the child elements of the specified parent element.
	 * 
	 * @param parent
	 *            parent {@link Element}.
	 * @return list of child elements.
	 */
	protected List<Element> getChildElements(Element parent) {
		NodeList children = parent.getChildNodes();
		List<Element> result = new ArrayList<Element>();
		for (int i = 0; i < children.getLength(); i++) {
			Node node = children.item(i);
			if (node instanceof Element) {
				result.add((Element) node);
			}
		}
		return result;
	}

	/**
	 * Extracts any namespace definitions ("xmlns:prefix=uri") declared on the
	 * element.
	 * 
	 * @param element
	 *            {@link Element} to be examined.
	 * @return mapping of namespace prefixes to URIs.
	 */
	protected Map<String, String> extractNamespaces(Element element) {
		Map<String, String> namespaces = new HashMap<String, String>();
		NamedNodeMap attributes = element.getAttributes();
		for (int i = 0; i < attributes.getLength(); i++) {
			Attr attr = (Attr) attributes.item(i);
			if (attr.getName().startsWith("xmlns:")) {
				namespaces.put(attr.getName().substring("xmlns:".length()),
						attr.getValue());
			}
		}
		return namespaces;
	}

	/**
	 * Utility method for concatenating an string array with a provided
	 * separator.
	 * 
	 * @param strArray
	 *            array of strings to be concatenated.
	 * @param seperator
	 *            separator string.
	 * @return concatenated string.
	 */
	protected String concatStringArray(String[] strArray, String seperator) {
		StringBuffer buf = new StringBuffer();
		if (strArray.length > 0) {
			buf.append(strArray[0]);
			for (int i = 1; i < strArray.length; i++) {
				buf.append(seperator);
				buf.append(strArray[i]);
			}
		}
		return buf.toString();
	}

	/**
	 * Utility method for checking if a given string is represents a registry
	 * key or not. Current implementation only looks for path separators which
	 * are present in registry keys.
	 * 
	 * @param key
	 *            input string.
	 * @return true if the given string represents a registry key, false
	 *         otherwise.
	 */
	protected boolean isRegistryKey(String key) {
		return (-1 != key.indexOf('/'));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.MODEL_OBJECT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ModelObjectState getObjectState() {
		return objectState;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setObjectState(ModelObjectState newObjectState) {
		ModelObjectState oldObjectState = objectState;
		objectState = newObjectState == null ? OBJECT_STATE_EDEFAULT : newObjectState;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.MODEL_OBJECT__OBJECT_STATE, oldObjectState, objectState));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getSourceText() {
		return sourceText;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceText(String newSourceText) {
		String oldSourceText = sourceText;
		sourceText = newSourceText;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.MODEL_OBJECT__SOURCE_TEXT, oldSourceText, sourceText));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Namespace getDefaultNamespace() {
		if (defaultNamespace != null && defaultNamespace.eIsProxy()) {
			InternalEObject oldDefaultNamespace = (InternalEObject)defaultNamespace;
			defaultNamespace = (Namespace)eResolveProxy(oldDefaultNamespace);
			if (defaultNamespace != oldDefaultNamespace) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EsbPackage.MODEL_OBJECT__DEFAULT_NAMESPACE, oldDefaultNamespace, defaultNamespace));
			}
		}
		return defaultNamespace;
	}

	/**
	 * Utility method for recursively looking up the namespace of this object.
	 * 
	 * @return {@link Namespace} corresponding to this object or null if no such
	 *         namespace can be deducted.
	 */
	protected Namespace lookupNamespace() {
		Namespace resultNs = getDefaultNamespace();
		if (null == resultNs) {
			if (eContainer() instanceof ModelObjectImpl) {
				resultNs = ((ModelObjectImpl) eContainer()).lookupNamespace();
			}
		}
		return resultNs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Namespace basicGetDefaultNamespace() {
		return defaultNamespace;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultNamespace(Namespace newDefaultNamespace) {
		Namespace oldDefaultNamespace = defaultNamespace;
		defaultNamespace = newDefaultNamespace;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.MODEL_OBJECT__DEFAULT_NAMESPACE, oldDefaultNamespace, defaultNamespace));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Namespace> getAdditionalNamespaces() {
		if (additionalNamespaces == null) {
			additionalNamespaces = new EObjectResolvingEList<Namespace>(Namespace.class, this, EsbPackage.MODEL_OBJECT__ADDITIONAL_NAMESPACES);
		}
		return additionalNamespaces;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EsbVersion getCurrentEsbVersion() {
		return currentEsbVersion;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCurrentEsbVersion(EsbVersion newCurrentEsbVersion) {
		EsbVersion oldCurrentEsbVersion = currentEsbVersion;
		currentEsbVersion = newCurrentEsbVersion == null ? CURRENT_ESB_VERSION_EDEFAULT : newCurrentEsbVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.MODEL_OBJECT__CURRENT_ESB_VERSION, oldCurrentEsbVersion, currentEsbVersion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Comment> getComment() {
		if (comment == null) {
			comment = new EObjectContainmentEList<Comment>(Comment.class, this, EsbPackage.MODEL_OBJECT__COMMENT);
		}
		return comment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsbPackage.MODEL_OBJECT__COMMENT:
				return ((InternalEList<?>)getComment()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EsbPackage.MODEL_OBJECT__OBJECT_STATE:
				return getObjectState();
			case EsbPackage.MODEL_OBJECT__SOURCE_TEXT:
				return getSourceText();
			case EsbPackage.MODEL_OBJECT__DEFAULT_NAMESPACE:
				if (resolve) return getDefaultNamespace();
				return basicGetDefaultNamespace();
			case EsbPackage.MODEL_OBJECT__ADDITIONAL_NAMESPACES:
				return getAdditionalNamespaces();
			case EsbPackage.MODEL_OBJECT__CURRENT_ESB_VERSION:
				return getCurrentEsbVersion();
			case EsbPackage.MODEL_OBJECT__COMMENT:
				return getComment();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EsbPackage.MODEL_OBJECT__OBJECT_STATE:
				setObjectState((ModelObjectState)newValue);
				return;
			case EsbPackage.MODEL_OBJECT__SOURCE_TEXT:
				setSourceText((String)newValue);
				return;
			case EsbPackage.MODEL_OBJECT__DEFAULT_NAMESPACE:
				setDefaultNamespace((Namespace)newValue);
				return;
			case EsbPackage.MODEL_OBJECT__ADDITIONAL_NAMESPACES:
				getAdditionalNamespaces().clear();
				getAdditionalNamespaces().addAll((Collection<? extends Namespace>)newValue);
				return;
			case EsbPackage.MODEL_OBJECT__CURRENT_ESB_VERSION:
				setCurrentEsbVersion((EsbVersion)newValue);
				return;
			case EsbPackage.MODEL_OBJECT__COMMENT:
				getComment().clear();
				getComment().addAll((Collection<? extends Comment>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case EsbPackage.MODEL_OBJECT__OBJECT_STATE:
				setObjectState(OBJECT_STATE_EDEFAULT);
				return;
			case EsbPackage.MODEL_OBJECT__SOURCE_TEXT:
				setSourceText(SOURCE_TEXT_EDEFAULT);
				return;
			case EsbPackage.MODEL_OBJECT__DEFAULT_NAMESPACE:
				setDefaultNamespace((Namespace)null);
				return;
			case EsbPackage.MODEL_OBJECT__ADDITIONAL_NAMESPACES:
				getAdditionalNamespaces().clear();
				return;
			case EsbPackage.MODEL_OBJECT__CURRENT_ESB_VERSION:
				setCurrentEsbVersion(CURRENT_ESB_VERSION_EDEFAULT);
				return;
			case EsbPackage.MODEL_OBJECT__COMMENT:
				getComment().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case EsbPackage.MODEL_OBJECT__OBJECT_STATE:
				return objectState != OBJECT_STATE_EDEFAULT;
			case EsbPackage.MODEL_OBJECT__SOURCE_TEXT:
				return SOURCE_TEXT_EDEFAULT == null ? sourceText != null : !SOURCE_TEXT_EDEFAULT.equals(sourceText);
			case EsbPackage.MODEL_OBJECT__DEFAULT_NAMESPACE:
				return defaultNamespace != null;
			case EsbPackage.MODEL_OBJECT__ADDITIONAL_NAMESPACES:
				return additionalNamespaces != null && !additionalNamespaces.isEmpty();
			case EsbPackage.MODEL_OBJECT__CURRENT_ESB_VERSION:
				return currentEsbVersion != CURRENT_ESB_VERSION_EDEFAULT;
			case EsbPackage.MODEL_OBJECT__COMMENT:
				return comment != null && !comment.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (objectState: ");
		result.append(objectState);
		result.append(", sourceText: ");
		result.append(sourceText);
		result.append(", currentEsbVersion: ");
		result.append(currentEsbVersion);
		result.append(')');
		return result.toString();
	}

} // ModelObjectImpl
