/**
 */
package org.wso2.developerstudio.datamapper.impl;

import java.util.Collection;

import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ImageFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.wso2.developerstudio.datamapper.DataMapperPackage;
import org.wso2.developerstudio.datamapper.DataMapperRoot;
import org.wso2.developerstudio.datamapper.Input;
import org.wso2.developerstudio.datamapper.Operator;
import org.wso2.developerstudio.datamapper.Output;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.wso2.developerstudio.datamapper.impl.DataMapperRootImpl#getInput <em>Input</em>}</li>
 *   <li>{@link org.wso2.developerstudio.datamapper.impl.DataMapperRootImpl#getOutput <em>Output</em>}</li>
 *   <li>{@link org.wso2.developerstudio.datamapper.impl.DataMapperRootImpl#getOperators <em>Operators</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DataMapperRootImpl extends EObjectImpl implements DataMapperRoot {
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
	 * The cached value of the '{@link #getOperators() <em>Operators</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperators()
	 * @generated
	 * @ordered
	 */
	protected EList<Operator> operators;
	
	private ImageFigure aiDataMapperButton;
	private Label aiDataMapperLabel;
	private RectangleFigure aiDataMapperLabelBox;
	private IFigure figure;
	private boolean canAIBasedDataMappingButtonLoadToCanvas = true;
	private FigureCanvas canvas;
	
    private IDeveloperStudioLog log = Logger.getLog(this.getClass().getName());
	
	public void setFigure(IFigure figure) {
		this.figure = figure;
	}

	public void setCanvas(FigureCanvas canvas) {
		this.canvas = canvas;
	}

	/**
	 * Setting reference for the AI DataMapper Button.
	 * 
	 * @param aiDataMapperButton
	 *            reference to the AI Datamapper Button
	 */
	public void setAiDataMapperButton(ImageFigure aiDataMapperButton) {
		this.aiDataMapperButton = aiDataMapperButton;
	}

	/**
	 * Setting reference for the AI DataMapper Label.
	 * 
	 * @param aiDataMapperLabel
	 *            reference to the AI Datamapper description
	 */
	public void setAiDataMapperLabel(Label aiDataMapperLabel) {
		this.aiDataMapperLabel = aiDataMapperLabel;
	}

	/**
	 * Setting reference for the AI DataMapper bar.
	 * 
	 * @param aiDataMapperLabelBox
	 *            reference to the AI Datamapper bar
	 */
	public void setAiDataMapperLabelBox(RectangleFigure aiDataMapperLabelBox) {
		this.aiDataMapperLabelBox = aiDataMapperLabelBox;
	}

    /**
     * This method set AI DataMapper functionality visible only if both input and
     * output trees are available.
     */
    private void setAiButtonVisibility() {
        try {
            if (!canAIBasedDataMappingButtonLoadToCanvas && figure != null
                    && ((input.getTreeNode().size() == 0) || (output.getTreeNode().size() == 0))) {
                aiDataMapperButton.setVisible(false);
                aiDataMapperLabel.setVisible(false);
                aiDataMapperLabelBox.setVisible(false);
            } else if (figure != null && ((input.getTreeNode().size() > 0) && (output.getTreeNode().size() > 0))) {
                if (canAIBasedDataMappingButtonLoadToCanvas) {
                    figure.add(aiDataMapperLabelBox);
                    figure.add(aiDataMapperLabel);
                    figure.add(aiDataMapperButton);
                    canvas.scrollToY(0);
                    canAIBasedDataMappingButtonLoadToCanvas = false;
                }
                if (!canAIBasedDataMappingButtonLoadToCanvas) {
                    aiDataMapperButton.setVisible(true);
                    aiDataMapperLabel.setVisible(true);
                    aiDataMapperLabelBox.setVisible(true);
                }
            }
        } catch (Exception e) {
            log.error("Exception occured while trying to display AI suggesions", e);
        }
    }

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataMapperRootImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DataMapperPackage.Literals.DATA_MAPPER_ROOT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Input getInput() {
		setAiButtonVisibility();
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DataMapperPackage.DATA_MAPPER_ROOT__INPUT, oldInput, newInput);
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
				msgs = ((InternalEObject)input).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DataMapperPackage.DATA_MAPPER_ROOT__INPUT, null, msgs);
			if (newInput != null)
				msgs = ((InternalEObject)newInput).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DataMapperPackage.DATA_MAPPER_ROOT__INPUT, null, msgs);
			msgs = basicSetInput(newInput, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataMapperPackage.DATA_MAPPER_ROOT__INPUT, newInput, newInput));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Output getOutput() {
		setAiButtonVisibility();
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DataMapperPackage.DATA_MAPPER_ROOT__OUTPUT, oldOutput, newOutput);
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
				msgs = ((InternalEObject)output).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DataMapperPackage.DATA_MAPPER_ROOT__OUTPUT, null, msgs);
			if (newOutput != null)
				msgs = ((InternalEObject)newOutput).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DataMapperPackage.DATA_MAPPER_ROOT__OUTPUT, null, msgs);
			msgs = basicSetOutput(newOutput, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataMapperPackage.DATA_MAPPER_ROOT__OUTPUT, newOutput, newOutput));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Operator> getOperators() {
		if (operators == null) {
			operators = new EObjectContainmentEList<Operator>(Operator.class, this, DataMapperPackage.DATA_MAPPER_ROOT__OPERATORS);
		}
		return operators;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DataMapperPackage.DATA_MAPPER_ROOT__INPUT:
				return basicSetInput(null, msgs);
			case DataMapperPackage.DATA_MAPPER_ROOT__OUTPUT:
				return basicSetOutput(null, msgs);
			case DataMapperPackage.DATA_MAPPER_ROOT__OPERATORS:
				return ((InternalEList<?>)getOperators()).basicRemove(otherEnd, msgs);
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
			case DataMapperPackage.DATA_MAPPER_ROOT__INPUT:
				return getInput();
			case DataMapperPackage.DATA_MAPPER_ROOT__OUTPUT:
				return getOutput();
			case DataMapperPackage.DATA_MAPPER_ROOT__OPERATORS:
				return getOperators();
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
			case DataMapperPackage.DATA_MAPPER_ROOT__INPUT:
				setInput((Input)newValue);
				return;
			case DataMapperPackage.DATA_MAPPER_ROOT__OUTPUT:
				setOutput((Output)newValue);
				return;
			case DataMapperPackage.DATA_MAPPER_ROOT__OPERATORS:
				getOperators().clear();
				getOperators().addAll((Collection<? extends Operator>)newValue);
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
			case DataMapperPackage.DATA_MAPPER_ROOT__INPUT:
				setInput((Input)null);
				return;
			case DataMapperPackage.DATA_MAPPER_ROOT__OUTPUT:
				setOutput((Output)null);
				return;
			case DataMapperPackage.DATA_MAPPER_ROOT__OPERATORS:
				getOperators().clear();
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
			case DataMapperPackage.DATA_MAPPER_ROOT__INPUT:
				return input != null;
			case DataMapperPackage.DATA_MAPPER_ROOT__OUTPUT:
				return output != null;
			case DataMapperPackage.DATA_MAPPER_ROOT__OPERATORS:
				return operators != null && !operators.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //DataMapperRootImpl
