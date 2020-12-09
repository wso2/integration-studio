/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.parts;

// Start of user code for imports
import org.eclipse.emf.common.util.Enumerator;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;


// End of user code

/**
 * 
 * 
 */
public interface PayloadFactoryArgumentPropertiesEditionPart {

	/**
	 * @return the argumentType
	 * 
	 */
	public Enumerator getArgumentType();

	/**
	 * Init the argumentType
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initArgumentType(Object input, Enumerator current);

	/**
	 * Defines a new argumentType
	 * @param newValue the new argumentType to set
	 * 
	 */
	public void setArgumentType(Enumerator newValue);


	/**
	 * @return the argumentValue
	 * 
	 */
	public String getArgumentValue();

	/**
	 * Defines a new argumentValue
	 * @param newValue the new argumentValue to set
	 * 
	 */
	public void setArgumentValue(String newValue);


	/**
	 * @return the evaluator
	 * 
	 */
	public Enumerator getEvaluator();

	/**
	 * Init the evaluator
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initEvaluator(Object input, Enumerator current);

	/**
	 * Defines a new evaluator
	 * @param newValue the new evaluator to set
	 * 
	 */
	public void setEvaluator(Enumerator newValue);


	/**
	 * @return the literal
	 * 
	 */
	public Boolean getLiteral();

	/**
	 * Defines a new literal
	 * @param newValue the new literal to set
	 * 
	 */
	public void setLiteral(Boolean newValue);




	// Start of user code for argumentExpression specific getters and setters declaration
	public void setArgumentExpression(NamespacedProperty namespacedProperty);
	
	public NamespacedProperty getArgumentExpression();
	
	// End of user code

	/**
	 * Returns the internationalized title text.
	 * 
	 * @return the internationalized title text.
	 * 
	 */
	public String getTitle();

	// Start of user code for additional methods
	
	// End of user code

}
