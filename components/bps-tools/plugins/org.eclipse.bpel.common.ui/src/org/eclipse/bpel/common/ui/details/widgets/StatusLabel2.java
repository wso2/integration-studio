/*******************************************************************************
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.common.ui.details.widgets;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.bpel.common.ui.CommonUIPlugin;
import org.eclipse.bpel.common.ui.ICommonUIConstants;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Control;

/**
 * Status label which holds information from text markers next to labels.
 * 
 * @author IBM
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date May 15, 2007
 */
public class StatusLabel2 {

	final static private int MAX_MESSAGES = 5;
	final static private String STATUS_MESSAGE_ID = "STATUS_MESSAGE"; //$NON-NLS-1$
	final static private String NEW_LINE = "\n"; //$NON-NLS-1$
	final static private String ETCETERA = "..."; //$NON-NLS-1$

	protected DecoratedLabel label;
	protected List<StatusMessage> statusMessageList;

	protected static Image blankImage, infoImage, warnImage, errorImage;

	/**
	 * Inner class: StatusMessage which holds one message and its dedicated severity
	 * 
	 */
	protected class StatusMessage {

		protected String id;       //* e.g name of originator of message   
		protected int severity;
		protected String message;

		/**
		 * constructor
		 * 
		 */
		protected StatusMessage(String messageId, int sev, String msg) {
			setSeverity(messageId, sev, msg);
		}

		/**
		 * constructor
		 * 
		 */
		protected StatusMessage() {
			setStatus(null);
		}

		/**
		 * Sets the severity and (optional) message.
		 * 
		 * @param messageId message id
		 * @param sev One of IStatus.OK, IStatus.INFO, IStatus.WARNING, IStatus.ERROR
		 * @param msg A text message describing the condition (or null).
		 * 
		 */
		protected void setSeverity(String messageId, int sev, String msg) {
			setId(messageId);
			setSeverity(sev);
			setMessage(msg);
		}

		/**
		 * Convenience method taking an IStatus as input.
		 * 
		 * @param IStatus
		 */
		protected void setStatus (IStatus status) {
			if (status == null) {
				setSeverity(STATUS_MESSAGE_ID, IStatus.OK, null);
			} else {
				setSeverity(STATUS_MESSAGE_ID, status.getSeverity(), status.getMessage());
			}
		}

		/**
		 * @return the severity
		 */
		protected int getSeverity() {
			return severity;
		}

		/**
		 * @param i the severity
		 */
		protected void setSeverity(int i) {
			severity = i;
		}

		/**
		 * @return String the message
		 */
		protected String getMessage() {
			return message;
		}

		/**
		 * @param String the message
		 */
		protected void setMessage(String string) {
			message = string;
		}
		/**
		 * @return String id of status message
		 */
		protected String getId() {
			return id;
		}

		/**
		 * @param string id of status message
		 */
		protected void setId(String string) {
			id = string;
		}

	}

	/**
	 * constructor
	 * 
	 * @param aLabel to be wrapped
	 * 
	 */
	
	public StatusLabel2(DecoratedLabel aLabel) {
		this.label = aLabel;

		if (blankImage == null) {
			initSharedImages();
		}

		setStatusMessageList(new ArrayList<StatusMessage>());
		
		clear();
	}

	/**
	 * Initializes the images
	 * 
	 */
	protected static void initSharedImages() {
		ImageRegistry registry = CommonUIPlugin.getDefault().getImageRegistry();
		// blankImage = registry.get(ICommonUIConstants.ICON_SM_BLANK);
		
		infoImage = registry.get(ICommonUIConstants.ICON_SM_INFO);
		warnImage = registry.get(ICommonUIConstants.ICON_SM_WARN);
		errorImage = registry.get(ICommonUIConstants.ICON_SM_ERROR);
	}

	/**
	 * Returns the CLabel.
	 * 
	 * @return CLabel
	 * 
	 */
	public DecoratedLabel getLabel() {
		return label;
	}

	/**
	 * Returns the primary control (e.g. maybe a composite).  In this implementation, the CLabel.
	 * 
	 * @return Control
	 * 
	 */
	public Control getControl() {
		return label;
	}

	/**
	 * Returns the CLabel text
	 * 
	 * @return String
	 * 
	 */
	public String getText() {
		return label.getText();
	}

	/**
	 * Sets the CLabel text
	 * 
	 * @param s the label text
	 * 
	 */
	public void setText(String s) {
		label.setText(s);
	}

	/**
	 * Returns the CLabel LayoutData
	 * 
	 * @return Object LayoutData
	 * 
	 */
	public Object getLayoutData() {
		return label.getLayoutData();
	}

	/**
	 * Sets the CLabel LayoutData
	 * 
	 * @param layoutData layout data
	 * 
	 */
	public void setLayoutData(Object layoutData) {
		label.setLayoutData(layoutData);
	}

	/**
	 * clears (removes) all status messages
	 * 
	 */
	public void clear() {
		statusMessageList.clear();
		updateLabel() ;
	}

	/**
	 * clears all status message with a id equals to the passed messageId
	 * 
	 * @param messageId id of status message to be removed
	 * 
	 */
	public void clear (String messageId) {

		if (messageId == null) {
			clear();
			return ;
		}
		List<StatusMessage> removeList = new ArrayList<StatusMessage>();

		// get all status messages to be removed
		for(StatusMessage m : statusMessageList ) {
			if (messageId.equals(m.getId())) {
				removeList.add(m);
			}
		}
		// remove all just now collected status messages
		statusMessageList.removeAll(removeList);
		// update label
		updateLabel() ;
	}

	/**
	 * Sets the severity and (optional) message.
	 * 
	 * @param messageId id of status message
	 * @param severity  One of IStatus.OK, IStatus.INFO, IStatus.WARNING, IStatus.ERROR
	 * @param message A text message describing the condition (or null).
	 * 
	 */
	public void setSeverity(String messageId, int severity, String message) {
		statusMessageList.clear();
		addSeverity(severity,message);
	}

	/**
	 * Sets the severity and (optional) message. The status message Id will be set to default
	 * 
	 * @param severity One of IStatus.OK, IStatus.INFO, IStatus.WARNING, IStatus.ERROR
	 * @param message A text message describing the condition (or null).
	 * 
	 */
	public void setSeverity(int severity, String message) {
		setSeverity(STATUS_MESSAGE_ID, severity, message);
	}

	/**
	 * Convenience method taking an IStatus as input.
	 * 
	 * @param status the status to set
	 * 
	 */
	public void setStatus(IStatus status) {
		if (status == null) {
			setSeverity(STATUS_MESSAGE_ID, IStatus.OK, null);
		} else {
			setSeverity(STATUS_MESSAGE_ID, status.getSeverity(), status.getMessage());
		}
	}

	
	/**
	 * Sets the severity and (optional) message.
	 *
	 * @param messageId id of status message  
	 * @param severity One of IStatus.OK, IStatus.INFO, IStatus.WARNING, IStatus.ERROR
	 * @param message A text message describing the condition (or null).
	 * 
	 */
	public void addSeverity(String messageId, int severity, String message) {			
		statusMessageList.add(new StatusMessage(messageId, severity, message) );
		updateLabel();
	}

	/**
	 * Sets the severity and (optional) message. The status message Id will be set to default
	 * 
	 * @param severity One of IStatus.OK, IStatus.INFO, IStatus.WARNING, IStatus.ERROR
	 * @param message A text message describing the condition (or null).
	 * 
	 */
	public void addSeverity(int severity, String message) {
		addSeverity(STATUS_MESSAGE_ID, severity, message);
	}

	/**
	 * Convenience method taking an IStatus as input.
	 * @param status  
	 */
	
	public void addStatus (IStatus status) {
		if (status != null) {
			addSeverity(status.getSeverity(), status.getMessage());
		}
	}

	protected void updateLabel() {

		label.setToolTipText(getToolTipText());

		switch (getHighestSeverity()) {
			case IStatus.OK :
				label.setImage(blankImage);
				break;
			case IStatus.INFO :
				label.setImage(infoImage);
				break;
			case IStatus.WARNING :
				label.setImage(warnImage);
				break;
			default :
				label.setImage(errorImage);
				break;
		}
	}

	/**
	 * returns the tool tip text. Only a maximum of messages will be appended to the tool tip text. The different
	 * messages are separated with a new line character. 
	 * If there are more messages than the maximum number, than three
	 * dots will be appended to the tool tip text.
	 * 
	 * @return the tool tip text from the status message list
	 * 
	 */
	protected String getToolTipText() {

		StringBuilder toolTipText = new StringBuilder(256);		
		List<String> toolTipTextList = new ArrayList<String>();

		appendToolTipTextList(toolTipTextList, IStatus.ERROR, MAX_MESSAGES);
		appendToolTipTextList(toolTipTextList, IStatus.WARNING, MAX_MESSAGES);
		appendToolTipTextList(toolTipTextList, IStatus.INFO, MAX_MESSAGES);
		appendToolTipTextList(toolTipTextList, IStatus.OK, MAX_MESSAGES);

		for (String t : toolTipTextList) {
			toolTipText.append(t).append(NEW_LINE);
		}
		
		if (statusMessageList.size() > toolTipTextList.size()) {
			if (toolTipText.length() > 0) {
				toolTipText.append(ETCETERA);
			}
		}

		return toolTipText.toString().trim();
	}

	/**
	 * reads all messaged according to the passed severity from the status message list and appends them to
	 * the passed toolTipText
	 * 
	 * @param toolTipTextList where message must be appended to
	 * @param severity of messages to be appended
	 * @param maxMessages maximum number of messages to be appended
	 * 
	 */
	protected void appendToolTipTextList(List<String> toolTipTextList, int severity, int maxMessages) {

		for(String m : getMessageList(severity) ) {
			if (toolTipTextList.size() < maxMessages) {
				toolTipTextList.add(m);
			} else {
				break;
			}
		}
	}

	/**
	 * returns messages according to the passed severity
	 * 
	 * @param severity of messages to be returned 
	 * @return List of messages according to the passed severity
	 * 
	 */
	
	protected List<String> getMessageList (int severity) {
		List<String> messageList = new ArrayList<String>();

		for (StatusMessage m : statusMessageList ) {
			if (m.getSeverity() == severity) {
				messageList.add(m.getMessage());
			}
		}
		return messageList;
	}

	/**
	 * @return the highest severity in the status message list
	 * 
	 */
	protected int getHighestSeverity() {
		int severity = IStatus.OK;
		for(StatusMessage m : statusMessageList) {
			if (m.getSeverity() > severity) {
				severity = m.getSeverity();
			}			
		}
		return severity;
	}

	/**
	 * @return List of status messages
	 */
	protected List<StatusMessage> getStatusMessageList() {
		return statusMessageList;
	}

	/**
	 * @param List of status messages
	 */
	protected void setStatusMessageList(List<StatusMessage> list) {
		statusMessageList = list;
	}
}
