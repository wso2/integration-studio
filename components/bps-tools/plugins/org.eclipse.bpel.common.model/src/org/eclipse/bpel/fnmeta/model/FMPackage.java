/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.bpel.fnmeta.model;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.bpel.fnmeta.model.FMFactory
 * @model kind="package"
 * @generated
 */
public interface FMPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "model";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://eclipse.org/bpel/ns/function-meta";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "fnmeta";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	FMPackage eINSTANCE = org.eclipse.bpel.fnmeta.model.impl.FMPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.bpel.fnmeta.model.impl.FacadeElementImpl <em>Facade Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.bpel.fnmeta.model.impl.FacadeElementImpl
	 * @see org.eclipse.bpel.fnmeta.model.impl.FMPackageImpl#getFacadeElement()
	 * @generated
	 */
	int FACADE_ELEMENT = 5;

	/**
	 * The feature id for the '<em><b>Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACADE_ELEMENT__ELEMENT = 0;

	/**
	 * The number of structural features of the '<em>Facade Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACADE_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.bpel.fnmeta.model.impl.RegistryImpl <em>Registry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.bpel.fnmeta.model.impl.RegistryImpl
	 * @see org.eclipse.bpel.fnmeta.model.impl.FMPackageImpl#getRegistry()
	 * @generated
	 */
	int REGISTRY = 0;

	/**
	 * The feature id for the '<em><b>Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGISTRY__ELEMENT = FACADE_ELEMENT__ELEMENT;

	/**
	 * The feature id for the '<em><b>Functions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGISTRY__FUNCTIONS = FACADE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Assistants</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGISTRY__ASSISTANTS = FACADE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGISTRY__ARGUMENTS = FACADE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Registry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGISTRY_FEATURE_COUNT = FACADE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.bpel.fnmeta.model.impl.AssistantImpl <em>Assistant</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.bpel.fnmeta.model.impl.AssistantImpl
	 * @see org.eclipse.bpel.fnmeta.model.impl.FMPackageImpl#getAssistant()
	 * @generated
	 */
	int ASSISTANT = 1;

	/**
	 * The feature id for the '<em><b>Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSISTANT__ELEMENT = FACADE_ELEMENT__ELEMENT;

	/**
	 * The feature id for the '<em><b>Options</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSISTANT__OPTIONS = FACADE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSISTANT__NAME = FACADE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSISTANT__TYPE = FACADE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Assistant</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSISTANT_FEATURE_COUNT = FACADE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.bpel.fnmeta.model.impl.OptionImpl <em>Option</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.bpel.fnmeta.model.impl.OptionImpl
	 * @see org.eclipse.bpel.fnmeta.model.impl.FMPackageImpl#getOption()
	 * @generated
	 */
	int OPTION = 2;

	/**
	 * The feature id for the '<em><b>Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTION__ELEMENT = FACADE_ELEMENT__ELEMENT;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTION__VALUE = FACADE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Display Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTION__DISPLAY_VALUE = FACADE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Option</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTION_FEATURE_COUNT = FACADE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.bpel.fnmeta.model.impl.ArgumentImpl <em>Argument</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.bpel.fnmeta.model.impl.ArgumentImpl
	 * @see org.eclipse.bpel.fnmeta.model.impl.FMPackageImpl#getArgument()
	 * @generated
	 */
	int ARGUMENT = 3;

	/**
	 * The feature id for the '<em><b>Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARGUMENT__ELEMENT = FACADE_ELEMENT__ELEMENT;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARGUMENT__DEFAULT_VALUE = FACADE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARGUMENT__NAME = FACADE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Optionality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARGUMENT__OPTIONALITY = FACADE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARGUMENT__TYPE = FACADE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARGUMENT__COMMENT = FACADE_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Assistant</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARGUMENT__ASSISTANT = FACADE_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Argument</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARGUMENT_FEATURE_COUNT = FACADE_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.eclipse.bpel.fnmeta.model.impl.FunctionImpl <em>Function</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.bpel.fnmeta.model.impl.FunctionImpl
	 * @see org.eclipse.bpel.fnmeta.model.impl.FMPackageImpl#getFunction()
	 * @generated
	 */
	int FUNCTION = 4;

	/**
	 * The feature id for the '<em><b>Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__ELEMENT = FACADE_ELEMENT__ELEMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__NAME = FACADE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__NAMESPACE = FACADE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Return Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__RETURN_TYPE = FACADE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__ARGUMENTS = FACADE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__COMMENT = FACADE_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Help</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__HELP = FACADE_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__PREFIX = FACADE_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Is Deprecated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__IS_DEPRECATED = FACADE_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Deprecate Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__DEPRECATE_COMMENT = FACADE_ELEMENT_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__CLASS_NAME = FACADE_ELEMENT_FEATURE_COUNT + 9;

	/**
	 * The number of structural features of the '<em>Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_FEATURE_COUNT = FACADE_ELEMENT_FEATURE_COUNT + 10;


	/**
	 * The meta object id for the '{@link org.eclipse.bpel.fnmeta.model.Optionality <em>Optionality</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.bpel.fnmeta.model.Optionality
	 * @see org.eclipse.bpel.fnmeta.model.impl.FMPackageImpl#getOptionality()
	 * @generated
	 */
	int OPTIONALITY = 6;

	/**
	 * The meta object id for the '<em>DOM Element</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.w3c.dom.Element
	 * @see org.eclipse.bpel.fnmeta.model.impl.FMPackageImpl#getDOMElement()
	 * @generated
	 */
	int DOM_ELEMENT = 7;


	/**
	 * Returns the meta object for class '{@link org.eclipse.bpel.fnmeta.model.Registry <em>Registry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Registry</em>'.
	 * @see org.eclipse.bpel.fnmeta.model.Registry
	 * @generated
	 */
	EClass getRegistry();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.bpel.fnmeta.model.Registry#getFunctions <em>Functions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Functions</em>'.
	 * @see org.eclipse.bpel.fnmeta.model.Registry#getFunctions()
	 * @see #getRegistry()
	 * @generated
	 */
	EReference getRegistry_Functions();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.bpel.fnmeta.model.Registry#getAssistants <em>Assistants</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Assistants</em>'.
	 * @see org.eclipse.bpel.fnmeta.model.Registry#getAssistants()
	 * @see #getRegistry()
	 * @generated
	 */
	EReference getRegistry_Assistants();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.bpel.fnmeta.model.Registry#getArguments <em>Arguments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Arguments</em>'.
	 * @see org.eclipse.bpel.fnmeta.model.Registry#getArguments()
	 * @see #getRegistry()
	 * @generated
	 */
	EReference getRegistry_Arguments();

	/**
	 * Returns the meta object for class '{@link org.eclipse.bpel.fnmeta.model.Assistant <em>Assistant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Assistant</em>'.
	 * @see org.eclipse.bpel.fnmeta.model.Assistant
	 * @generated
	 */
	EClass getAssistant();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.bpel.fnmeta.model.Assistant#getOptions <em>Options</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Options</em>'.
	 * @see org.eclipse.bpel.fnmeta.model.Assistant#getOptions()
	 * @see #getAssistant()
	 * @generated
	 */
	EReference getAssistant_Options();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.bpel.fnmeta.model.Assistant#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.bpel.fnmeta.model.Assistant#getName()
	 * @see #getAssistant()
	 * @generated
	 */
	EAttribute getAssistant_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.bpel.fnmeta.model.Assistant#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.eclipse.bpel.fnmeta.model.Assistant#getType()
	 * @see #getAssistant()
	 * @generated
	 */
	EAttribute getAssistant_Type();

	/**
	 * Returns the meta object for class '{@link org.eclipse.bpel.fnmeta.model.Option <em>Option</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Option</em>'.
	 * @see org.eclipse.bpel.fnmeta.model.Option
	 * @generated
	 */
	EClass getOption();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.bpel.fnmeta.model.Option#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.bpel.fnmeta.model.Option#getValue()
	 * @see #getOption()
	 * @generated
	 */
	EAttribute getOption_Value();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.bpel.fnmeta.model.Option#getDisplayValue <em>Display Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Display Value</em>'.
	 * @see org.eclipse.bpel.fnmeta.model.Option#getDisplayValue()
	 * @see #getOption()
	 * @generated
	 */
	EAttribute getOption_DisplayValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.bpel.fnmeta.model.Argument <em>Argument</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Argument</em>'.
	 * @see org.eclipse.bpel.fnmeta.model.Argument
	 * @generated
	 */
	EClass getArgument();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.bpel.fnmeta.model.Argument#getDefaultValue <em>Default Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default Value</em>'.
	 * @see org.eclipse.bpel.fnmeta.model.Argument#getDefaultValue()
	 * @see #getArgument()
	 * @generated
	 */
	EAttribute getArgument_DefaultValue();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.bpel.fnmeta.model.Argument#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.bpel.fnmeta.model.Argument#getName()
	 * @see #getArgument()
	 * @generated
	 */
	EAttribute getArgument_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.bpel.fnmeta.model.Argument#getOptionality <em>Optionality</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Optionality</em>'.
	 * @see org.eclipse.bpel.fnmeta.model.Argument#getOptionality()
	 * @see #getArgument()
	 * @generated
	 */
	EAttribute getArgument_Optionality();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.bpel.fnmeta.model.Argument#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.eclipse.bpel.fnmeta.model.Argument#getType()
	 * @see #getArgument()
	 * @generated
	 */
	EAttribute getArgument_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.bpel.fnmeta.model.Argument#getComment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comment</em>'.
	 * @see org.eclipse.bpel.fnmeta.model.Argument#getComment()
	 * @see #getArgument()
	 * @generated
	 */
	EAttribute getArgument_Comment();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.bpel.fnmeta.model.Argument#getAssistant <em>Assistant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Assistant</em>'.
	 * @see org.eclipse.bpel.fnmeta.model.Argument#getAssistant()
	 * @see #getArgument()
	 * @generated
	 */
	EReference getArgument_Assistant();

	/**
	 * Returns the meta object for class '{@link org.eclipse.bpel.fnmeta.model.Function <em>Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Function</em>'.
	 * @see org.eclipse.bpel.fnmeta.model.Function
	 * @generated
	 */
	EClass getFunction();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.bpel.fnmeta.model.Function#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.bpel.fnmeta.model.Function#getName()
	 * @see #getFunction()
	 * @generated
	 */
	EAttribute getFunction_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.bpel.fnmeta.model.Function#getNamespace <em>Namespace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Namespace</em>'.
	 * @see org.eclipse.bpel.fnmeta.model.Function#getNamespace()
	 * @see #getFunction()
	 * @generated
	 */
	EAttribute getFunction_Namespace();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.bpel.fnmeta.model.Function#getReturnType <em>Return Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Return Type</em>'.
	 * @see org.eclipse.bpel.fnmeta.model.Function#getReturnType()
	 * @see #getFunction()
	 * @generated
	 */
	EAttribute getFunction_ReturnType();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.bpel.fnmeta.model.Function#getArguments <em>Arguments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Arguments</em>'.
	 * @see org.eclipse.bpel.fnmeta.model.Function#getArguments()
	 * @see #getFunction()
	 * @generated
	 */
	EReference getFunction_Arguments();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.bpel.fnmeta.model.Function#getComment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comment</em>'.
	 * @see org.eclipse.bpel.fnmeta.model.Function#getComment()
	 * @see #getFunction()
	 * @generated
	 */
	EAttribute getFunction_Comment();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.bpel.fnmeta.model.Function#getHelp <em>Help</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Help</em>'.
	 * @see org.eclipse.bpel.fnmeta.model.Function#getHelp()
	 * @see #getFunction()
	 * @generated
	 */
	EAttribute getFunction_Help();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.bpel.fnmeta.model.Function#getPrefix <em>Prefix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Prefix</em>'.
	 * @see org.eclipse.bpel.fnmeta.model.Function#getPrefix()
	 * @see #getFunction()
	 * @generated
	 */
	EAttribute getFunction_Prefix();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.bpel.fnmeta.model.Function#getIsDeprecated <em>Is Deprecated</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Deprecated</em>'.
	 * @see org.eclipse.bpel.fnmeta.model.Function#getIsDeprecated()
	 * @see #getFunction()
	 * @generated
	 */
	EAttribute getFunction_IsDeprecated();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.bpel.fnmeta.model.Function#getDeprecateComment <em>Deprecate Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Deprecate Comment</em>'.
	 * @see org.eclipse.bpel.fnmeta.model.Function#getDeprecateComment()
	 * @see #getFunction()
	 * @generated
	 */
	EAttribute getFunction_DeprecateComment();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.bpel.fnmeta.model.Function#getClassName <em>Class Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Class Name</em>'.
	 * @see org.eclipse.bpel.fnmeta.model.Function#getClassName()
	 * @see #getFunction()
	 * @generated
	 */
	EAttribute getFunction_ClassName();

	/**
	 * Returns the meta object for class '{@link org.eclipse.bpel.fnmeta.model.FacadeElement <em>Facade Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Facade Element</em>'.
	 * @see org.eclipse.bpel.fnmeta.model.FacadeElement
	 * @generated
	 */
	EClass getFacadeElement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.bpel.fnmeta.model.FacadeElement#getElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Element</em>'.
	 * @see org.eclipse.bpel.fnmeta.model.FacadeElement#getElement()
	 * @see #getFacadeElement()
	 * @generated
	 */
	EAttribute getFacadeElement_Element();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.bpel.fnmeta.model.Optionality <em>Optionality</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Optionality</em>'.
	 * @see org.eclipse.bpel.fnmeta.model.Optionality
	 * @generated
	 */
	EEnum getOptionality();

	/**
	 * Returns the meta object for data type '{@link org.w3c.dom.Element <em>DOM Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>DOM Element</em>'.
	 * @see org.w3c.dom.Element
	 * @model instanceClass="org.w3c.dom.Element"
	 * @generated
	 */
	EDataType getDOMElement();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	FMFactory getFMFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.bpel.fnmeta.model.impl.RegistryImpl <em>Registry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.bpel.fnmeta.model.impl.RegistryImpl
		 * @see org.eclipse.bpel.fnmeta.model.impl.FMPackageImpl#getRegistry()
		 * @generated
		 */
		EClass REGISTRY = eINSTANCE.getRegistry();

		/**
		 * The meta object literal for the '<em><b>Functions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REGISTRY__FUNCTIONS = eINSTANCE.getRegistry_Functions();

		/**
		 * The meta object literal for the '<em><b>Assistants</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REGISTRY__ASSISTANTS = eINSTANCE.getRegistry_Assistants();

		/**
		 * The meta object literal for the '<em><b>Arguments</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REGISTRY__ARGUMENTS = eINSTANCE.getRegistry_Arguments();

		/**
		 * The meta object literal for the '{@link org.eclipse.bpel.fnmeta.model.impl.AssistantImpl <em>Assistant</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.bpel.fnmeta.model.impl.AssistantImpl
		 * @see org.eclipse.bpel.fnmeta.model.impl.FMPackageImpl#getAssistant()
		 * @generated
		 */
		EClass ASSISTANT = eINSTANCE.getAssistant();

		/**
		 * The meta object literal for the '<em><b>Options</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSISTANT__OPTIONS = eINSTANCE.getAssistant_Options();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASSISTANT__NAME = eINSTANCE.getAssistant_Name();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASSISTANT__TYPE = eINSTANCE.getAssistant_Type();

		/**
		 * The meta object literal for the '{@link org.eclipse.bpel.fnmeta.model.impl.OptionImpl <em>Option</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.bpel.fnmeta.model.impl.OptionImpl
		 * @see org.eclipse.bpel.fnmeta.model.impl.FMPackageImpl#getOption()
		 * @generated
		 */
		EClass OPTION = eINSTANCE.getOption();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPTION__VALUE = eINSTANCE.getOption_Value();

		/**
		 * The meta object literal for the '<em><b>Display Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPTION__DISPLAY_VALUE = eINSTANCE.getOption_DisplayValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.bpel.fnmeta.model.impl.ArgumentImpl <em>Argument</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.bpel.fnmeta.model.impl.ArgumentImpl
		 * @see org.eclipse.bpel.fnmeta.model.impl.FMPackageImpl#getArgument()
		 * @generated
		 */
		EClass ARGUMENT = eINSTANCE.getArgument();

		/**
		 * The meta object literal for the '<em><b>Default Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARGUMENT__DEFAULT_VALUE = eINSTANCE.getArgument_DefaultValue();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARGUMENT__NAME = eINSTANCE.getArgument_Name();

		/**
		 * The meta object literal for the '<em><b>Optionality</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARGUMENT__OPTIONALITY = eINSTANCE.getArgument_Optionality();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARGUMENT__TYPE = eINSTANCE.getArgument_Type();

		/**
		 * The meta object literal for the '<em><b>Comment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARGUMENT__COMMENT = eINSTANCE.getArgument_Comment();

		/**
		 * The meta object literal for the '<em><b>Assistant</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARGUMENT__ASSISTANT = eINSTANCE.getArgument_Assistant();

		/**
		 * The meta object literal for the '{@link org.eclipse.bpel.fnmeta.model.impl.FunctionImpl <em>Function</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.bpel.fnmeta.model.impl.FunctionImpl
		 * @see org.eclipse.bpel.fnmeta.model.impl.FMPackageImpl#getFunction()
		 * @generated
		 */
		EClass FUNCTION = eINSTANCE.getFunction();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FUNCTION__NAME = eINSTANCE.getFunction_Name();

		/**
		 * The meta object literal for the '<em><b>Namespace</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FUNCTION__NAMESPACE = eINSTANCE.getFunction_Namespace();

		/**
		 * The meta object literal for the '<em><b>Return Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FUNCTION__RETURN_TYPE = eINSTANCE.getFunction_ReturnType();

		/**
		 * The meta object literal for the '<em><b>Arguments</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION__ARGUMENTS = eINSTANCE.getFunction_Arguments();

		/**
		 * The meta object literal for the '<em><b>Comment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FUNCTION__COMMENT = eINSTANCE.getFunction_Comment();

		/**
		 * The meta object literal for the '<em><b>Help</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FUNCTION__HELP = eINSTANCE.getFunction_Help();

		/**
		 * The meta object literal for the '<em><b>Prefix</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FUNCTION__PREFIX = eINSTANCE.getFunction_Prefix();

		/**
		 * The meta object literal for the '<em><b>Is Deprecated</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FUNCTION__IS_DEPRECATED = eINSTANCE.getFunction_IsDeprecated();

		/**
		 * The meta object literal for the '<em><b>Deprecate Comment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FUNCTION__DEPRECATE_COMMENT = eINSTANCE.getFunction_DeprecateComment();

		/**
		 * The meta object literal for the '<em><b>Class Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FUNCTION__CLASS_NAME = eINSTANCE.getFunction_ClassName();

		/**
		 * The meta object literal for the '{@link org.eclipse.bpel.fnmeta.model.impl.FacadeElementImpl <em>Facade Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.bpel.fnmeta.model.impl.FacadeElementImpl
		 * @see org.eclipse.bpel.fnmeta.model.impl.FMPackageImpl#getFacadeElement()
		 * @generated
		 */
		EClass FACADE_ELEMENT = eINSTANCE.getFacadeElement();

		/**
		 * The meta object literal for the '<em><b>Element</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FACADE_ELEMENT__ELEMENT = eINSTANCE.getFacadeElement_Element();

		/**
		 * The meta object literal for the '{@link org.eclipse.bpel.fnmeta.model.Optionality <em>Optionality</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.bpel.fnmeta.model.Optionality
		 * @see org.eclipse.bpel.fnmeta.model.impl.FMPackageImpl#getOptionality()
		 * @generated
		 */
		EEnum OPTIONALITY = eINSTANCE.getOptionality();

		/**
		 * The meta object literal for the '<em>DOM Element</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.w3c.dom.Element
		 * @see org.eclipse.bpel.fnmeta.model.impl.FMPackageImpl#getDOMElement()
		 * @generated
		 */
		EDataType DOM_ELEMENT = eINSTANCE.getDOMElement();

	}

} //FMPackage
