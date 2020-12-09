/**
 * Generated with Acceleo
 */
package org.wso2.integrationstudio.eclipse.gmf.esb.parts;

// Start of user code for imports
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;

import org.eclipse.jface.viewers.ViewerFilter;


// End of user code

/**
 * 
 * 
 */
public interface PublishEventMediatorPropertiesEditionPart {

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
	 * @return the streamName
	 * 
	 */
	public String getStreamName();

	/**
	 * Defines a new streamName
	 * @param newValue the new streamName to set
	 * 
	 */
	public void setStreamName(String newValue);


	/**
	 * @return the streamVersion
	 * 
	 */
	public String getStreamVersion();

	/**
	 * Defines a new streamVersion
	 * @param newValue the new streamVersion to set
	 * 
	 */
	public void setStreamVersion(String newValue);


	/**
	 * @return the eventSink
	 * 
	 */
	public String getEventSink();

	/**
	 * Defines a new eventSink
	 * @param newValue the new eventSink to set
	 * 
	 */
	public void setEventSink(String newValue);




	/**
	 * Init the metaAttributes
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initMetaAttributes(ReferencesTableSettings settings);

	/**
	 * Update the metaAttributes
	 * @param newValue the metaAttributes to update
	 * 
	 */
	public void updateMetaAttributes();

	/**
	 * Adds the given filter to the metaAttributes edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToMetaAttributes(ViewerFilter filter);

	/**
	 * Adds the given filter to the metaAttributes edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToMetaAttributes(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the metaAttributes table
	 * 
	 */
	public boolean isContainedInMetaAttributesTable(EObject element);




	/**
	 * Init the correlationAttributes
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initCorrelationAttributes(ReferencesTableSettings settings);

	/**
	 * Update the correlationAttributes
	 * @param newValue the correlationAttributes to update
	 * 
	 */
	public void updateCorrelationAttributes();

	/**
	 * Adds the given filter to the correlationAttributes edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToCorrelationAttributes(ViewerFilter filter);

	/**
	 * Adds the given filter to the correlationAttributes edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToCorrelationAttributes(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the correlationAttributes table
	 * 
	 */
	public boolean isContainedInCorrelationAttributesTable(EObject element);




	/**
	 * Init the payloadAttributes
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initPayloadAttributes(ReferencesTableSettings settings);

	/**
	 * Update the payloadAttributes
	 * @param newValue the payloadAttributes to update
	 * 
	 */
	public void updatePayloadAttributes();

	/**
	 * Adds the given filter to the payloadAttributes edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToPayloadAttributes(ViewerFilter filter);

	/**
	 * Adds the given filter to the payloadAttributes edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToPayloadAttributes(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the payloadAttributes table
	 * 
	 */
	public boolean isContainedInPayloadAttributesTable(EObject element);




	/**
	 * Init the arbitraryAttributes
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initArbitraryAttributes(ReferencesTableSettings settings);

	/**
	 * Update the arbitraryAttributes
	 * @param newValue the arbitraryAttributes to update
	 * 
	 */
	public void updateArbitraryAttributes();

	/**
	 * Adds the given filter to the arbitraryAttributes edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToArbitraryAttributes(ViewerFilter filter);

	/**
	 * Adds the given filter to the arbitraryAttributes edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToArbitraryAttributes(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the arbitraryAttributes table
	 * 
	 */
	public boolean isContainedInArbitraryAttributesTable(EObject element);


	/**
	 * @return the Async
	 * 
	 */
	public Boolean getAsync();

	/**
	 * Defines a new Async
	 * @param newValue the new Async to set
	 * 
	 */
	public void setAsync(Boolean newValue);


	/**
	 * @return the AsyncTimeout
	 * 
	 */
	public String getAsyncTimeout();

	/**
	 * Defines a new AsyncTimeout
	 * @param newValue the new AsyncTimeout to set
	 * 
	 */
	public void setAsyncTimeout(String newValue);





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
