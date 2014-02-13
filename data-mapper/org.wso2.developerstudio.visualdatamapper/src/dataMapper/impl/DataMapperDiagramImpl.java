/**
 */
package dataMapper.impl;

import dataMapper.Concat;
import dataMapper.DataMapperDiagram;
import dataMapper.DataMapperPackage;
import dataMapper.Input;
import dataMapper.Output;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Diagram</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link dataMapper.impl.DataMapperDiagramImpl#getInput <em>Input</em>}</li>
 *   <li>{@link dataMapper.impl.DataMapperDiagramImpl#getOutput <em>Output</em>}</li>
 *   <li>{@link dataMapper.impl.DataMapperDiagramImpl#getConcat <em>Concat</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DataMapperDiagramImpl extends DataMapperNodeImpl implements DataMapperDiagram {
	/**
	 * The cached value of the '{@link #getInput() <em>Input</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInput()
	 * @generated
	 * @ordered
	 */
	protected Input input;

	/**
	 * The cached value of the '{@link #getOutput() <em>Output</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutput()
	 * @generated
	 * @ordered
	 */
	protected Output output;

	/**
	 * The cached value of the '{@link #getConcat() <em>Concat</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConcat()
	 * @generated
	 * @ordered
	 */
	protected EList<Concat> concat;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataMapperDiagramImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DataMapperPackage.Literals.DATA_MAPPER_DIAGRAM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Input getInput() {
		return input;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInput(Input newInput, NotificationChain msgs) {
		Input oldInput = input;
		input = newInput;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DataMapperPackage.DATA_MAPPER_DIAGRAM__INPUT, oldInput, newInput);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInput(Input newInput) {
		if (newInput != input) {
			NotificationChain msgs = null;
			if (input != null)
				msgs = ((InternalEObject)input).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DataMapperPackage.DATA_MAPPER_DIAGRAM__INPUT, null, msgs);
			if (newInput != null)
				msgs = ((InternalEObject)newInput).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DataMapperPackage.DATA_MAPPER_DIAGRAM__INPUT, null, msgs);
			msgs = basicSetInput(newInput, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataMapperPackage.DATA_MAPPER_DIAGRAM__INPUT, newInput, newInput));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Output getOutput() {
		return output;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOutput(Output newOutput, NotificationChain msgs) {
		Output oldOutput = output;
		output = newOutput;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DataMapperPackage.DATA_MAPPER_DIAGRAM__OUTPUT, oldOutput, newOutput);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutput(Output newOutput) {
		if (newOutput != output) {
			NotificationChain msgs = null;
			if (output != null)
				msgs = ((InternalEObject)output).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DataMapperPackage.DATA_MAPPER_DIAGRAM__OUTPUT, null, msgs);
			if (newOutput != null)
				msgs = ((InternalEObject)newOutput).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DataMapperPackage.DATA_MAPPER_DIAGRAM__OUTPUT, null, msgs);
			msgs = basicSetOutput(newOutput, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataMapperPackage.DATA_MAPPER_DIAGRAM__OUTPUT, newOutput, newOutput));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Concat> getConcat() {
		if (concat == null) {
			concat = new EObjectContainmentEList<Concat>(Concat.class, this, DataMapperPackage.DATA_MAPPER_DIAGRAM__CONCAT);
		}
		return concat;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DataMapperPackage.DATA_MAPPER_DIAGRAM__INPUT:
				return basicSetInput(null, msgs);
			case DataMapperPackage.DATA_MAPPER_DIAGRAM__OUTPUT:
				return basicSetOutput(null, msgs);
			case DataMapperPackage.DATA_MAPPER_DIAGRAM__CONCAT:
				return ((InternalEList<?>)getConcat()).basicRemove(otherEnd, msgs);
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
			case DataMapperPackage.DATA_MAPPER_DIAGRAM__INPUT:
				return getInput();
			case DataMapperPackage.DATA_MAPPER_DIAGRAM__OUTPUT:
				return getOutput();
			case DataMapperPackage.DATA_MAPPER_DIAGRAM__CONCAT:
				return getConcat();
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
			case DataMapperPackage.DATA_MAPPER_DIAGRAM__INPUT:
				setInput((Input)newValue);
				return;
			case DataMapperPackage.DATA_MAPPER_DIAGRAM__OUTPUT:
				setOutput((Output)newValue);
				return;
			case DataMapperPackage.DATA_MAPPER_DIAGRAM__CONCAT:
				getConcat().clear();
				getConcat().addAll((Collection<? extends Concat>)newValue);
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
			case DataMapperPackage.DATA_MAPPER_DIAGRAM__INPUT:
				setInput((Input)null);
				return;
			case DataMapperPackage.DATA_MAPPER_DIAGRAM__OUTPUT:
				setOutput((Output)null);
				return;
			case DataMapperPackage.DATA_MAPPER_DIAGRAM__CONCAT:
				getConcat().clear();
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
			case DataMapperPackage.DATA_MAPPER_DIAGRAM__INPUT:
				return input != null;
			case DataMapperPackage.DATA_MAPPER_DIAGRAM__OUTPUT:
				return output != null;
			case DataMapperPackage.DATA_MAPPER_DIAGRAM__CONCAT:
				return concat != null && !concat.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //DataMapperDiagramImpl
