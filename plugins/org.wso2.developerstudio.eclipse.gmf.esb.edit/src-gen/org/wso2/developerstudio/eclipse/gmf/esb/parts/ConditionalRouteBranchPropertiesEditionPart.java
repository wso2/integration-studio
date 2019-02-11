/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.parts;



// Start of user code for imports
import org.wso2.developerstudio.eclipse.gmf.esb.EvaluatorExpressionProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;


// End of user code

/**
 * 
 * 
 */
public interface ConditionalRouteBranchPropertiesEditionPart {

	/**
	 * @return the breakAfterRoute
	 * 
	 */
	public Boolean getBreakAfterRoute();

	/**
	 * Defines a new breakAfterRoute
	 * @param newValue the new breakAfterRoute to set
	 * 
	 */
	public void setBreakAfterRoute(Boolean newValue);




	// Start of user code for targetSequence specific getters and setters declaration
    public RegistryKeyProperty getTargetSequence();
    
    public void setTargetSequence(RegistryKeyProperty registryKeyProperty);
	// End of user code
	// Start of user code for evaluatorExpression specific getters and setters declaration
    public EvaluatorExpressionProperty getEvaluatorExpression();
    
    public void setEvaluatorExpression(EvaluatorExpressionProperty evaluatorExpressionProperty);
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
