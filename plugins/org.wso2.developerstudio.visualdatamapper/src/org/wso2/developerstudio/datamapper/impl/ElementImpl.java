/**
 */
package org.wso2.developerstudio.datamapper.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.wso2.developerstudio.datamapper.DataMapperPackage;
import org.wso2.developerstudio.datamapper.Element;
import org.wso2.developerstudio.datamapper.InNode;
import org.wso2.developerstudio.datamapper.Order;
import org.wso2.developerstudio.datamapper.OutNode;
import org.wso2.developerstudio.datamapper.SchemaDataType;
import org.wso2.developerstudio.datamapper.TreeNode;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.datamapper.impl.ElementImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.datamapper.impl.ElementImpl#getValue <em>Value</em>}</li>
 *   <li>{@link org.wso2.developerstudio.datamapper.impl.ElementImpl#getOutNode <em>Out Node</em>}</li>
 *   <li>{@link org.wso2.developerstudio.datamapper.impl.ElementImpl#getInNode <em>In Node</em>}</li>
 *   <li>{@link org.wso2.developerstudio.datamapper.impl.ElementImpl#getFieldParent <em>Field Parent</em>}</li>
 *   <li>{@link org.wso2.developerstudio.datamapper.impl.ElementImpl#getSchemaDataType <em>Schema Data Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.datamapper.impl.ElementImpl#getLevel <em>Level</em>}</li>
 *   <li>{@link org.wso2.developerstudio.datamapper.impl.ElementImpl#getDoc <em>Doc</em>}</li>
 *   <li>{@link org.wso2.developerstudio.datamapper.impl.ElementImpl#getDefault <em>Default</em>}</li>
 *   <li>{@link org.wso2.developerstudio.datamapper.impl.ElementImpl#getAliases <em>Aliases</em>}</li>
 *   <li>{@link org.wso2.developerstudio.datamapper.impl.ElementImpl#getOrder <em>Order</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ElementImpl extends EObjectImpl implements Element {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final String VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected String value = VALUE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOutNode() <em>Out Node</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutNode()
	 * @generated
	 * @ordered
	 */
	protected OutNode outNode;

	/**
	 * The cached value of the '{@link #getInNode() <em>In Node</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInNode()
	 * @generated
	 * @ordered
	 */
	protected InNode inNode;

	/**
	 * The default value of the '{@link #getSchemaDataType() <em>Schema Data Type</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getSchemaDataType()
	 * @generated
	 * @ordered
	 */
    protected static final SchemaDataType SCHEMA_DATA_TYPE_EDEFAULT = SchemaDataType.ARRAY;

    /**
	 * The cached value of the '{@link #getSchemaDataType() <em>Schema Data Type</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getSchemaDataType()
	 * @generated
	 * @ordered
	 */
    protected SchemaDataType schemaDataType = SCHEMA_DATA_TYPE_EDEFAULT;

    /**
	 * The default value of the '{@link #getLevel() <em>Level</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getLevel()
	 * @generated
	 * @ordered
	 */
    protected static final int LEVEL_EDEFAULT = 0;

    /**
	 * The cached value of the '{@link #getLevel() <em>Level</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getLevel()
	 * @generated
	 * @ordered
	 */
    protected int level = LEVEL_EDEFAULT;

    
    /**
	 * The default value of the '{@link #getDoc() <em>Doc</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDoc()
	 * @generated
	 * @ordered
	 */
	protected static final String DOC_EDEFAULT = null;

				/**
	 * The cached value of the '{@link #getDoc() <em>Doc</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDoc()
	 * @generated
	 * @ordered
	 */
	protected String doc = DOC_EDEFAULT;

				/**
	 * The default value of the '{@link #getDefault() <em>Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefault()
	 * @generated
	 * @ordered
	 */
	protected static final String DEFAULT_EDEFAULT = null;

				/**
	 * The cached value of the '{@link #getDefault() <em>Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefault()
	 * @generated
	 * @ordered
	 */
	protected String default_ = DEFAULT_EDEFAULT;

				/**
	 * The cached value of the '{@link #getAliases() <em>Aliases</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAliases()
	 * @generated
	 * @ordered
	 */
	protected EList<String> aliases;

				/**
	 * The default value of the '{@link #getOrder() <em>Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrder()
	 * @generated
	 * @ordered
	 */
	protected static final String ORDER_EDEFAULT = null;

				/**
	 * The cached value of the '{@link #getOrder() <em>Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrder()
	 * @generated
	 * @ordered
	 */
	protected String order = ORDER_EDEFAULT;

				private int index=-1;
    
    /**
     * This node has been visited by the graph traversal algorithm
     */
    private boolean visited;
    
    /**
     * This node has been added to the list of nodes in the graph traversal algorithm
     */
    private boolean marked;
    
    private List<Integer> portVariableIndex=new ArrayList<Integer>();
    
    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public boolean isMarked() {
        return marked;
    }

    public void setMarked(boolean marked) {
        this.marked = marked;
    }

    public List<Integer> getPortVariableIndex() {
        return portVariableIndex;
    }

    public void setPortVariableIndex(List<Integer> portVariableIndex) {
        this.portVariableIndex = portVariableIndex;
    }
    
    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
    protected ElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DataMapperPackage.Literals.ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataMapperPackage.ELEMENT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(String newValue) {
		String oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataMapperPackage.ELEMENT__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutNode getOutNode() {
		return outNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOutNode(OutNode newOutNode, NotificationChain msgs) {
		OutNode oldOutNode = outNode;
		outNode = newOutNode;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DataMapperPackage.ELEMENT__OUT_NODE, oldOutNode, newOutNode);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutNode(OutNode newOutNode) {
		if (newOutNode != outNode) {
			NotificationChain msgs = null;
			if (outNode != null)
				msgs = ((InternalEObject)outNode).eInverseRemove(this, DataMapperPackage.OUT_NODE__ELEMENT_PARENT, OutNode.class, msgs);
			if (newOutNode != null)
				msgs = ((InternalEObject)newOutNode).eInverseAdd(this, DataMapperPackage.OUT_NODE__ELEMENT_PARENT, OutNode.class, msgs);
			msgs = basicSetOutNode(newOutNode, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataMapperPackage.ELEMENT__OUT_NODE, newOutNode, newOutNode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InNode getInNode() {
		return inNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInNode(InNode newInNode, NotificationChain msgs) {
		InNode oldInNode = inNode;
		inNode = newInNode;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DataMapperPackage.ELEMENT__IN_NODE, oldInNode, newInNode);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInNode(InNode newInNode) {
		if (newInNode != inNode) {
			NotificationChain msgs = null;
			if (inNode != null)
				msgs = ((InternalEObject)inNode).eInverseRemove(this, DataMapperPackage.IN_NODE__ELEMENT_PARENT, InNode.class, msgs);
			if (newInNode != null)
				msgs = ((InternalEObject)newInNode).eInverseAdd(this, DataMapperPackage.IN_NODE__ELEMENT_PARENT, InNode.class, msgs);
			msgs = basicSetInNode(newInNode, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataMapperPackage.ELEMENT__IN_NODE, newInNode, newInNode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TreeNode getFieldParent() {
		if (eContainerFeatureID() != DataMapperPackage.ELEMENT__FIELD_PARENT) return null;
		return (TreeNode)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFieldParent(TreeNode newFieldParent, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newFieldParent, DataMapperPackage.ELEMENT__FIELD_PARENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFieldParent(TreeNode newFieldParent) {
		if (newFieldParent != eInternalContainer() || (eContainerFeatureID() != DataMapperPackage.ELEMENT__FIELD_PARENT && newFieldParent != null)) {
			if (EcoreUtil.isAncestor(this, newFieldParent))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newFieldParent != null)
				msgs = ((InternalEObject)newFieldParent).eInverseAdd(this, DataMapperPackage.TREE_NODE__ELEMENT, TreeNode.class, msgs);
			msgs = basicSetFieldParent(newFieldParent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataMapperPackage.ELEMENT__FIELD_PARENT, newFieldParent, newFieldParent));
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public SchemaDataType getSchemaDataType() {
		return schemaDataType;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setSchemaDataType(SchemaDataType newSchemaDataType) {
		SchemaDataType oldSchemaDataType = schemaDataType;
		schemaDataType = newSchemaDataType == null ? SCHEMA_DATA_TYPE_EDEFAULT : newSchemaDataType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataMapperPackage.ELEMENT__SCHEMA_DATA_TYPE, oldSchemaDataType, schemaDataType));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public int getLevel() {
		return level;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setLevel(int newLevel) {
		int oldLevel = level;
		level = newLevel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataMapperPackage.ELEMENT__LEVEL, oldLevel, level));
	}

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDoc() {
		return doc;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDoc(String newDoc) {
		String oldDoc = doc;
		doc = newDoc;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataMapperPackage.ELEMENT__DOC, oldDoc, doc));
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDefault() {
		return default_;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefault(String newDefault) {
		String oldDefault = default_;
		default_ = newDefault;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataMapperPackage.ELEMENT__DEFAULT, oldDefault, default_));
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getAliases() {
		if (aliases == null) {
			aliases = new EDataTypeUniqueEList<String>(String.class, this, DataMapperPackage.ELEMENT__ALIASES);
		}
		return aliases;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOrder() {
		return order;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOrder(String newOrder) {
		String oldOrder = order;
		order = newOrder;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataMapperPackage.ELEMENT__ORDER, oldOrder, order));
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DataMapperPackage.ELEMENT__OUT_NODE:
				if (outNode != null)
					msgs = ((InternalEObject)outNode).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DataMapperPackage.ELEMENT__OUT_NODE, null, msgs);
				return basicSetOutNode((OutNode)otherEnd, msgs);
			case DataMapperPackage.ELEMENT__IN_NODE:
				if (inNode != null)
					msgs = ((InternalEObject)inNode).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DataMapperPackage.ELEMENT__IN_NODE, null, msgs);
				return basicSetInNode((InNode)otherEnd, msgs);
			case DataMapperPackage.ELEMENT__FIELD_PARENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetFieldParent((TreeNode)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DataMapperPackage.ELEMENT__OUT_NODE:
				return basicSetOutNode(null, msgs);
			case DataMapperPackage.ELEMENT__IN_NODE:
				return basicSetInNode(null, msgs);
			case DataMapperPackage.ELEMENT__FIELD_PARENT:
				return basicSetFieldParent(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case DataMapperPackage.ELEMENT__FIELD_PARENT:
				return eInternalContainer().eInverseRemove(this, DataMapperPackage.TREE_NODE__ELEMENT, TreeNode.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DataMapperPackage.ELEMENT__NAME:
				return getName();
			case DataMapperPackage.ELEMENT__VALUE:
				return getValue();
			case DataMapperPackage.ELEMENT__OUT_NODE:
				return getOutNode();
			case DataMapperPackage.ELEMENT__IN_NODE:
				return getInNode();
			case DataMapperPackage.ELEMENT__FIELD_PARENT:
				return getFieldParent();
			case DataMapperPackage.ELEMENT__SCHEMA_DATA_TYPE:
				return getSchemaDataType();
			case DataMapperPackage.ELEMENT__LEVEL:
				return getLevel();
			case DataMapperPackage.ELEMENT__DOC:
				return getDoc();
			case DataMapperPackage.ELEMENT__DEFAULT:
				return getDefault();
			case DataMapperPackage.ELEMENT__ALIASES:
				return getAliases();
			case DataMapperPackage.ELEMENT__ORDER:
				return getOrder();
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
			case DataMapperPackage.ELEMENT__NAME:
				setName((String)newValue);
				return;
			case DataMapperPackage.ELEMENT__VALUE:
				setValue((String)newValue);
				return;
			case DataMapperPackage.ELEMENT__OUT_NODE:
				setOutNode((OutNode)newValue);
				return;
			case DataMapperPackage.ELEMENT__IN_NODE:
				setInNode((InNode)newValue);
				return;
			case DataMapperPackage.ELEMENT__FIELD_PARENT:
				setFieldParent((TreeNode)newValue);
				return;
			case DataMapperPackage.ELEMENT__SCHEMA_DATA_TYPE:
				setSchemaDataType((SchemaDataType)newValue);
				return;
			case DataMapperPackage.ELEMENT__LEVEL:
				setLevel((Integer)newValue);
				return;
			case DataMapperPackage.ELEMENT__DOC:
				setDoc((String)newValue);
				return;
			case DataMapperPackage.ELEMENT__DEFAULT:
				setDefault((String)newValue);
				return;
			case DataMapperPackage.ELEMENT__ALIASES:
				getAliases().clear();
				getAliases().addAll((Collection<? extends String>)newValue);
				return;
			case DataMapperPackage.ELEMENT__ORDER:
				setOrder((String)newValue);
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
			case DataMapperPackage.ELEMENT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case DataMapperPackage.ELEMENT__VALUE:
				setValue(VALUE_EDEFAULT);
				return;
			case DataMapperPackage.ELEMENT__OUT_NODE:
				setOutNode((OutNode)null);
				return;
			case DataMapperPackage.ELEMENT__IN_NODE:
				setInNode((InNode)null);
				return;
			case DataMapperPackage.ELEMENT__FIELD_PARENT:
				setFieldParent((TreeNode)null);
				return;
			case DataMapperPackage.ELEMENT__SCHEMA_DATA_TYPE:
				setSchemaDataType(SCHEMA_DATA_TYPE_EDEFAULT);
				return;
			case DataMapperPackage.ELEMENT__LEVEL:
				setLevel(LEVEL_EDEFAULT);
				return;
			case DataMapperPackage.ELEMENT__DOC:
				setDoc(DOC_EDEFAULT);
				return;
			case DataMapperPackage.ELEMENT__DEFAULT:
				setDefault(DEFAULT_EDEFAULT);
				return;
			case DataMapperPackage.ELEMENT__ALIASES:
				getAliases().clear();
				return;
			case DataMapperPackage.ELEMENT__ORDER:
				setOrder(ORDER_EDEFAULT);
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
			case DataMapperPackage.ELEMENT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case DataMapperPackage.ELEMENT__VALUE:
				return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
			case DataMapperPackage.ELEMENT__OUT_NODE:
				return outNode != null;
			case DataMapperPackage.ELEMENT__IN_NODE:
				return inNode != null;
			case DataMapperPackage.ELEMENT__FIELD_PARENT:
				return getFieldParent() != null;
			case DataMapperPackage.ELEMENT__SCHEMA_DATA_TYPE:
				return schemaDataType != SCHEMA_DATA_TYPE_EDEFAULT;
			case DataMapperPackage.ELEMENT__LEVEL:
				return level != LEVEL_EDEFAULT;
			case DataMapperPackage.ELEMENT__DOC:
				return DOC_EDEFAULT == null ? doc != null : !DOC_EDEFAULT.equals(doc);
			case DataMapperPackage.ELEMENT__DEFAULT:
				return DEFAULT_EDEFAULT == null ? default_ != null : !DEFAULT_EDEFAULT.equals(default_);
			case DataMapperPackage.ELEMENT__ALIASES:
				return aliases != null && !aliases.isEmpty();
			case DataMapperPackage.ELEMENT__ORDER:
				return ORDER_EDEFAULT == null ? order != null : !ORDER_EDEFAULT.equals(order);
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
		result.append(" (name: ");
		result.append(name);
		result.append(", value: ");
		result.append(value);
		result.append(", schemaDataType: ");
		result.append(schemaDataType);
		result.append(", level: ");
		result.append(level);
		result.append(", doc: ");
		result.append(doc);
		result.append(", default: ");
		result.append(default_);
		result.append(", aliases: ");
		result.append(aliases);
		result.append(", order: ");
		result.append(order);
		result.append(')');
		return result.toString();
	}

} //ElementImpl
