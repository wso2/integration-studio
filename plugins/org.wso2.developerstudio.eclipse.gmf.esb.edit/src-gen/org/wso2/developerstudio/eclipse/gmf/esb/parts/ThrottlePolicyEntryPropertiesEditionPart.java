/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.parts;

// Start of user code for imports
import org.eclipse.emf.common.util.Enumerator;


// End of user code

/**
 * 
 * 
 */
public interface ThrottlePolicyEntryPropertiesEditionPart {

	/**
	 * @return the throttleType
	 * 
	 */
	public Enumerator getThrottleType();

	/**
	 * Init the throttleType
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initThrottleType(Object input, Enumerator current);

	/**
	 * Defines a new throttleType
	 * @param newValue the new throttleType to set
	 * 
	 */
	public void setThrottleType(Enumerator newValue);


	/**
	 * @return the throttleRange
	 * 
	 */
	public String getThrottleRange();

	/**
	 * Defines a new throttleRange
	 * @param newValue the new throttleRange to set
	 * 
	 */
	public void setThrottleRange(String newValue);


	/**
	 * @return the accessType
	 * 
	 */
	public Enumerator getAccessType();

	/**
	 * Init the accessType
	 * @param input the viewer input
	 * @param current the current value
	 */
	public void initAccessType(Object input, Enumerator current);

	/**
	 * Defines a new accessType
	 * @param newValue the new accessType to set
	 * 
	 */
	public void setAccessType(Enumerator newValue);


	/**
	 * @return the maxRequestCount
	 * 
	 */
	public String getMaxRequestCount();

	/**
	 * Defines a new maxRequestCount
	 * @param newValue the new maxRequestCount to set
	 * 
	 */
	public void setMaxRequestCount(String newValue);


	/**
	 * @return the unitTime
	 * 
	 */
	public String getUnitTime();

	/**
	 * Defines a new unitTime
	 * @param newValue the new unitTime to set
	 * 
	 */
	public void setUnitTime(String newValue);


	/**
	 * @return the prohibitPeriod
	 * 
	 */
	public String getProhibitPeriod();

	/**
	 * Defines a new prohibitPeriod
	 * @param newValue the new prohibitPeriod to set
	 * 
	 */
	public void setProhibitPeriod(String newValue);





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
