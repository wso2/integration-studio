/**
 */
package dataMapper.impl;

import dataMapper.Attribute;
import dataMapper.DataMapperPackage;
import dataMapper.Element;
import dataMapper.Input;
import dataMapper.Output;
import dataMapper.TreeNode;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tree Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link dataMapper.impl.TreeNodeImpl#getName <em>Name</em>}</li>
 *   <li>{@link dataMapper.impl.TreeNodeImpl#getNode <em>Node</em>}</li>
 *   <li>{@link dataMapper.impl.TreeNodeImpl#getAttribute <em>Attribute</em>}</li>
 *   <li>{@link dataMapper.impl.TreeNodeImpl#getElement <em>Element</em>}</li>
 *   <li>{@link dataMapper.impl.TreeNodeImpl#getFieldParent <em>Field Parent</em>}</li>
 *   <li>{@link dataMapper.impl.TreeNodeImpl#getOutputParent <em>Output Parent</em>}</li>
 *   <li>{@link dataMapper.impl.TreeNodeImpl#getInputParent <em>Input Parent</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TreeNodeImpl extends EObjectImpl implements TreeNode {
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
	 * The cached value of the '{@link #getNode() <em>Node</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNode()
	 * @generated
	 * @ordered
	 */
	protected EList<TreeNode> node;

	/**
	 * The cached value of the '{@link #getAttribute() <em>Attribute</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttribute()
	 * @generated
	 * @ordered
	 */
	protected EList<Attribute> attribute;

	/**
	 * The cached value of the '{@link #getElement() <em>Element</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElement()
	 * @generated
	 * @ordered
	 */
	protected EList<Element> element;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TreeNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DataMapperPackage.Literals.TREE_NODE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, DataMapperPackage.TREE_NODE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TreeNode> getNode() {
		if (node == null) {
			node = new EObjectContainmentWithInverseEList<TreeNode>(TreeNode.class, this, DataMapperPackage.TREE_NODE__NODE, DataMapperPackage.TREE_NODE__FIELD_PARENT);
		}
		return node;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Attribute> getAttribute() {
		if (attribute == null) {
			attribute = new EObjectContainmentWithInverseEList<Attribute>(Attribute.class, this, DataMapperPackage.TREE_NODE__ATTRIBUTE, DataMapperPackage.ATTRIBUTE__FIELD_PARENT);
		}
		return attribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Element> getElement() {
		if (element == null) {
			element = new EObjectContainmentWithInverseEList<Element>(Element.class, this, DataMapperPackage.TREE_NODE__ELEMENT, DataMapperPackage.ELEMENT__FIELD_PARENT);
		}
		return element;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TreeNode getFieldParent() {
		if (eContainerFeatureID() != DataMapperPackage.TREE_NODE__FIELD_PARENT) return null;
		return (TreeNode)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFieldParent(TreeNode newFieldParent, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newFieldParent, DataMapperPackage.TREE_NODE__FIELD_PARENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFieldParent(TreeNode newFieldParent) {
		if (newFieldParent != eInternalContainer() || (eContainerFeatureID() != DataMapperPackage.TREE_NODE__FIELD_PARENT && newFieldParent != null)) {
			if (EcoreUtil.isAncestor(this, newFieldParent))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newFieldParent != null)
				msgs = ((InternalEObject)newFieldParent).eInverseAdd(this, DataMapperPackage.TREE_NODE__NODE, TreeNode.class, msgs);
			msgs = basicSetFieldParent(newFieldParent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataMapperPackage.TREE_NODE__FIELD_PARENT, newFieldParent, newFieldParent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Output getOutputParent() {
		if (eContainerFeatureID() != DataMapperPackage.TREE_NODE__OUTPUT_PARENT) return null;
		return (Output)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOutputParent(Output newOutputParent, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOutputParent, DataMapperPackage.TREE_NODE__OUTPUT_PARENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutputParent(Output newOutputParent) {
		if (newOutputParent != eInternalContainer() || (eContainerFeatureID() != DataMapperPackage.TREE_NODE__OUTPUT_PARENT && newOutputParent != null)) {
			if (EcoreUtil.isAncestor(this, newOutputParent))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOutputParent != null)
				msgs = ((InternalEObject)newOutputParent).eInverseAdd(this, DataMapperPackage.OUTPUT__TREE_NODE, Output.class, msgs);
			msgs = basicSetOutputParent(newOutputParent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataMapperPackage.TREE_NODE__OUTPUT_PARENT, newOutputParent, newOutputParent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Input getInputParent() {
		if (eContainerFeatureID() != DataMapperPackage.TREE_NODE__INPUT_PARENT) return null;
		return (Input)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInputParent(Input newInputParent, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newInputParent, DataMapperPackage.TREE_NODE__INPUT_PARENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInputParent(Input newInputParent) {
		if (newInputParent != eInternalContainer() || (eContainerFeatureID() != DataMapperPackage.TREE_NODE__INPUT_PARENT && newInputParent != null)) {
			if (EcoreUtil.isAncestor(this, newInputParent))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newInputParent != null)
				msgs = ((InternalEObject)newInputParent).eInverseAdd(this, DataMapperPackage.INPUT__TREE_NODE, Input.class, msgs);
			msgs = basicSetInputParent(newInputParent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataMapperPackage.TREE_NODE__INPUT_PARENT, newInputParent, newInputParent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DataMapperPackage.TREE_NODE__NODE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getNode()).basicAdd(otherEnd, msgs);
			case DataMapperPackage.TREE_NODE__ATTRIBUTE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAttribute()).basicAdd(otherEnd, msgs);
			case DataMapperPackage.TREE_NODE__ELEMENT:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getElement()).basicAdd(otherEnd, msgs);
			case DataMapperPackage.TREE_NODE__FIELD_PARENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetFieldParent((TreeNode)otherEnd, msgs);
			case DataMapperPackage.TREE_NODE__OUTPUT_PARENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOutputParent((Output)otherEnd, msgs);
			case DataMapperPackage.TREE_NODE__INPUT_PARENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetInputParent((Input)otherEnd, msgs);
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
			case DataMapperPackage.TREE_NODE__NODE:
				return ((InternalEList<?>)getNode()).basicRemove(otherEnd, msgs);
			case DataMapperPackage.TREE_NODE__ATTRIBUTE:
				return ((InternalEList<?>)getAttribute()).basicRemove(otherEnd, msgs);
			case DataMapperPackage.TREE_NODE__ELEMENT:
				return ((InternalEList<?>)getElement()).basicRemove(otherEnd, msgs);
			case DataMapperPackage.TREE_NODE__FIELD_PARENT:
				return basicSetFieldParent(null, msgs);
			case DataMapperPackage.TREE_NODE__OUTPUT_PARENT:
				return basicSetOutputParent(null, msgs);
			case DataMapperPackage.TREE_NODE__INPUT_PARENT:
				return basicSetInputParent(null, msgs);
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
			case DataMapperPackage.TREE_NODE__FIELD_PARENT:
				return eInternalContainer().eInverseRemove(this, DataMapperPackage.TREE_NODE__NODE, TreeNode.class, msgs);
			case DataMapperPackage.TREE_NODE__OUTPUT_PARENT:
				return eInternalContainer().eInverseRemove(this, DataMapperPackage.OUTPUT__TREE_NODE, Output.class, msgs);
			case DataMapperPackage.TREE_NODE__INPUT_PARENT:
				return eInternalContainer().eInverseRemove(this, DataMapperPackage.INPUT__TREE_NODE, Input.class, msgs);
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
			case DataMapperPackage.TREE_NODE__NAME:
				return getName();
			case DataMapperPackage.TREE_NODE__NODE:
				return getNode();
			case DataMapperPackage.TREE_NODE__ATTRIBUTE:
				return getAttribute();
			case DataMapperPackage.TREE_NODE__ELEMENT:
				return getElement();
			case DataMapperPackage.TREE_NODE__FIELD_PARENT:
				return getFieldParent();
			case DataMapperPackage.TREE_NODE__OUTPUT_PARENT:
				return getOutputParent();
			case DataMapperPackage.TREE_NODE__INPUT_PARENT:
				return getInputParent();
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
			case DataMapperPackage.TREE_NODE__NAME:
				setName((String)newValue);
				return;
			case DataMapperPackage.TREE_NODE__NODE:
				getNode().clear();
				getNode().addAll((Collection<? extends TreeNode>)newValue);
				return;
			case DataMapperPackage.TREE_NODE__ATTRIBUTE:
				getAttribute().clear();
				getAttribute().addAll((Collection<? extends Attribute>)newValue);
				return;
			case DataMapperPackage.TREE_NODE__ELEMENT:
				getElement().clear();
				getElement().addAll((Collection<? extends Element>)newValue);
				return;
			case DataMapperPackage.TREE_NODE__FIELD_PARENT:
				setFieldParent((TreeNode)newValue);
				return;
			case DataMapperPackage.TREE_NODE__OUTPUT_PARENT:
				setOutputParent((Output)newValue);
				return;
			case DataMapperPackage.TREE_NODE__INPUT_PARENT:
				setInputParent((Input)newValue);
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
			case DataMapperPackage.TREE_NODE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case DataMapperPackage.TREE_NODE__NODE:
				getNode().clear();
				return;
			case DataMapperPackage.TREE_NODE__ATTRIBUTE:
				getAttribute().clear();
				return;
			case DataMapperPackage.TREE_NODE__ELEMENT:
				getElement().clear();
				return;
			case DataMapperPackage.TREE_NODE__FIELD_PARENT:
				setFieldParent((TreeNode)null);
				return;
			case DataMapperPackage.TREE_NODE__OUTPUT_PARENT:
				setOutputParent((Output)null);
				return;
			case DataMapperPackage.TREE_NODE__INPUT_PARENT:
				setInputParent((Input)null);
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
			case DataMapperPackage.TREE_NODE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case DataMapperPackage.TREE_NODE__NODE:
				return node != null && !node.isEmpty();
			case DataMapperPackage.TREE_NODE__ATTRIBUTE:
				return attribute != null && !attribute.isEmpty();
			case DataMapperPackage.TREE_NODE__ELEMENT:
				return element != null && !element.isEmpty();
			case DataMapperPackage.TREE_NODE__FIELD_PARENT:
				return getFieldParent() != null;
			case DataMapperPackage.TREE_NODE__OUTPUT_PARENT:
				return getOutputParent() != null;
			case DataMapperPackage.TREE_NODE__INPUT_PARENT:
				return getInputParent() != null;
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
		result.append(')');
		return result.toString();
	}

} //TreeNodeImpl
