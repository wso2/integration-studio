/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.parts;

// Start of user code for imports
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.Enumerator;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;

import org.eclipse.jface.viewers.ViewerFilter;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;


// End of user code

/**
 * 
 * 
 */
public interface RuleMediatorPropertiesEditionPart {

	/**
	 * @return the description
	 * 
	 */
	public String getDescription();

	/**
	 * Defines a new description
	 * @param newValue the new description to set
	 * 
	 */
	public void setDescription(String newValue);


	/**
	 * @return the commentsList
	 * 
	 */
	public EList getCommentsList();

	/**
	 * Defines a new commentsList
	 * @param newValue the new commentsList to set
	 * 
	 */
	public void setCommentsList(EList newValue);

	/**
	 * Add a value to the commentsList multivalued attribute.
	 * @param newValue the value to add
	 */
	public void addToCommentsList(Object newValue);

	/**
	 * Remove a value to the commentsList multivalued attribute.
	 * @param newValue the value to remove
	 */
	public void removeToCommentsList(Object newValue);


	/**
	 * @return the Reverse
	 * 
	 */
	public Boolean getReverse();

	/**
	 * Defines a new Reverse
	 * @param newValue the new Reverse to set
	 * 
	 */
	public void setReverse(Boolean newValue);


	/**
	 * @return the statefulSession
	 * 
	 */
	public Boolean getStatefulSession();

	/**
	 * Defines a new statefulSession
	 * @param newValue the new statefulSession to set
	 * 
	 */
	public void setStatefulSession(Boolean newValue);




	/**
	 * Init the RuleSessionProperties
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initRuleSessionProperties(ReferencesTableSettings settings);

	/**
	 * Update the RuleSessionProperties
	 * @param newValue the RuleSessionProperties to update
	 * 
	 */
	public void updateRuleSessionProperties();

	/**
	 * Adds the given filter to the RuleSessionProperties edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToRuleSessionProperties(ViewerFilter filter);

	/**
	 * Adds the given filter to the RuleSessionProperties edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToRuleSessionProperties(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the RuleSessionProperties table
	 * 
	 */
	public boolean isContainedInRuleSessionPropertiesTable(EObject element);


	/**
	 * @return the InputWrapperName
	 * 
	 */
	public String getInputWrapperName();

	/**
	 * Defines a new InputWrapperName
	 * @param newValue the new InputWrapperName to set
	 * 
	 */
	public void setInputWrapperName(String newValue);


	/**
	 * @return the InputNameSpace
	 * 
	 */
	public String getInputNameSpace();

	/**
	 * Defines a new InputNameSpace
	 * @param newValue the new InputNameSpace to set
	 * 
	 */
	public void setInputNameSpace(String newValue);




	/**
	 * Init the ruleFactsConfiguration
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initRuleFactsConfiguration(ReferencesTableSettings settings);

	/**
	 * Update the ruleFactsConfiguration
	 * @param newValue the ruleFactsConfiguration to update
	 * 
	 */
	public void updateRuleFactsConfiguration();

	/**
	 * Adds the given filter to the ruleFactsConfiguration edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToRuleFactsConfiguration(ViewerFilter filter);

	/**
	 * Adds the given filter to the ruleFactsConfiguration edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToRuleFactsConfiguration(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the ruleFactsConfiguration table
	 * 
	 */
	public boolean isContainedInRuleFactsConfigurationTable(EObject element);


	/**
	 * @return the OutputWrapperName
	 * 
	 */
	public String getOutputWrapperName();

	/**
	 * Defines a new OutputWrapperName
	 * @param newValue the new OutputWrapperName to set
	 * 
	 */
	public void setOutputWrapperName(String newValue);


	/**
	 * @return the OutputNameSpace
	 * 
	 */
	public String getOutputNameSpace();

	/**
	 * Defines a new OutputNameSpace
	 * @param newValue the new OutputNameSpace to set
	 * 
	 */
	public void setOutputNameSpace(String newValue);




	/**
	 * Init the ruleResultsConfiguration
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initRuleResultsConfiguration(ReferencesTableSettings settings);

	/**
	 * Update the ruleResultsConfiguration
	 * @param newValue the ruleResultsConfiguration to update
	 * 
	 */
	public void updateRuleResultsConfiguration();

	/**
	 * Adds the given filter to the ruleResultsConfiguration edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToRuleResultsConfiguration(ViewerFilter filter);

	/**
	 * Adds the given filter to the ruleResultsConfiguration edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToRuleResultsConfiguration(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the ruleResultsConfiguration table
	 * 
	 */
	public boolean isContainedInRuleResultsConfigurationTable(EObject element);


	/**
	 * @return the sourceValue
	 * 
	 */
	public String getSourceValue();

	/**
	 * Defines a new sourceValue
	 * @param newValue the new sourceValue to set
	 * 
	 */
	public void setSourceValue(String newValue);


	/**
	 * @return the targetValue
	 * 
	 */
	public String getTargetValue();

	/**
	 * Defines a new targetValue
	 * @param newValue the new targetValue to set
	 * 
	 */
	public void setTargetValue(String newValue);


	/**
	 * @return the targetAction
	 * 
	 */
	public Enumerator getTargetAction();

	/**
	 * Init the targetAction
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initTargetAction(Object input, Enumerator current);

	/**
	 * Defines a new targetAction
	 * @param newValue the new targetAction to set
	 * 
	 */
	public void setTargetAction(Enumerator newValue);


	/**
	 * @return the RuleSetType
	 * 
	 */
	public Enumerator getRuleSetType();

	/**
	 * Init the RuleSetType
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initRuleSetType(Object input, Enumerator current);

	/**
	 * Defines a new RuleSetType
	 * @param newValue the new RuleSetType to set
	 * 
	 */
	public void setRuleSetType(Enumerator newValue);


	/**
	 * @return the RuleSetURL
	 * 
	 */
	public String getRuleSetURL();

	/**
	 * Defines a new RuleSetURL
	 * @param newValue the new RuleSetURL to set
	 * 
	 */
	public void setRuleSetURL(String newValue);


	/**
	 * @return the ruleSetSourceType
	 * 
	 */
	public Enumerator getRuleSetSourceType();

	/**
	 * Init the ruleSetSourceType
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initRuleSetSourceType(Object input, Enumerator current);

	/**
	 * Defines a new ruleSetSourceType
	 * @param newValue the new ruleSetSourceType to set
	 * 
	 */
	public void setRuleSetSourceType(Enumerator newValue);


	/**
	 * @return the ruleSetSourceCode
	 * 
	 */
	public String getRuleSetSourceCode();

	/**
	 * Defines a new ruleSetSourceCode
	 * @param newValue the new ruleSetSourceCode to set
	 * 
	 */
	public void setRuleSetSourceCode(String newValue);




	// Start of user code for sourceXPath specific getters and setters declaration
    public NamespacedProperty getSourceXPath();

    public void setSourceXPath(NamespacedProperty nameSpacedProperty);
	// End of user code
	// Start of user code for targetXPath specific getters and setters declaration
    public NamespacedProperty getTargetXPath();
    
    public void setTargetXPath(NamespacedProperty nameSpacedProperty);
	// End of user code
	// Start of user code for targetResultXPath specific getters and setters declaration
    public NamespacedProperty getTargetResultXPath();
    
    public void setTargetResultXPath(NamespacedProperty nameSpacedProperty);
	// End of user code
	// Start of user code for ruleSetSourceKey specific getters and setters declaration
    public RegistryKeyProperty getRuleSetSourceKey();
    
    public void setRuleSetSourceKey(RegistryKeyProperty registryKeyProperty);
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
