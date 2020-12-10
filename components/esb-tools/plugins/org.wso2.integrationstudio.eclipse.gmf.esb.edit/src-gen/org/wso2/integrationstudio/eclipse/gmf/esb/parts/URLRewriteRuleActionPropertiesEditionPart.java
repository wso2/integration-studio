/**
 * Generated with Acceleo
 */
package org.wso2.integrationstudio.eclipse.gmf.esb.parts;

// Start of user code for imports
import org.eclipse.emf.common.util.Enumerator;
import org.wso2.integrationstudio.eclipse.gmf.esb.NamespacedProperty;


// End of user code

/**
 * 
 * 
 */
public interface URLRewriteRuleActionPropertiesEditionPart {

	/**
	 * @return the ruleAction
	 * 
	 */
	public Enumerator getRuleAction();

	/**
	 * Init the ruleAction
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initRuleAction(Object input, Enumerator current);

	/**
	 * Defines a new ruleAction
	 * @param newValue the new ruleAction to set
	 * 
	 */
	public void setRuleAction(Enumerator newValue);


	/**
	 * @return the ruleFragment
	 * 
	 */
	public Enumerator getRuleFragment();

	/**
	 * Init the ruleFragment
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initRuleFragment(Object input, Enumerator current);

	/**
	 * Defines a new ruleFragment
	 * @param newValue the new ruleFragment to set
	 * 
	 */
	public void setRuleFragment(Enumerator newValue);


	/**
	 * @return the ruleOption
	 * 
	 */
	public Enumerator getRuleOption();

	/**
	 * Init the ruleOption
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initRuleOption(Object input, Enumerator current);

	/**
	 * Defines a new ruleOption
	 * @param newValue the new ruleOption to set
	 * 
	 */
	public void setRuleOption(Enumerator newValue);


	/**
	 * @return the actionValue
	 * 
	 */
	public String getActionValue();

	/**
	 * Defines a new actionValue
	 * @param newValue the new actionValue to set
	 * 
	 */
	public void setActionValue(String newValue);


	/**
	 * @return the actionRegex
	 * 
	 */
	public String getActionRegex();

	/**
	 * Defines a new actionRegex
	 * @param newValue the new actionRegex to set
	 * 
	 */
	public void setActionRegex(String newValue);




	// Start of user code for actionExpression specific getters and setters declaration
    public NamespacedProperty getActionExpression();
    
    public void setActionExpression(NamespacedProperty nameSpacedProperty);
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
