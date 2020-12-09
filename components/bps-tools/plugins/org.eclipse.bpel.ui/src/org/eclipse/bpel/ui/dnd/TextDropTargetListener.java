/*******************************************************************************
 * Copyright (c) 2006, 2012 Oracle Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Oracle Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.ui.dnd;

import org.eclipse.bpel.ui.BPELEditor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;



/**
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Nov 16, 2006
 *
 */
public class TextDropTargetListener extends FileDropTargetListener {
	
	/**
	 * 
	 * @param viewer
	 * @param editor
	 */
	
	public TextDropTargetListener ( GraphicalViewer viewer, BPELEditor editor) {
		super( viewer, editor );	
	}
	
	

	/** (non-Javadoc)
	 * @see org.eclipse.swt.dnd.DropTargetListener#drop(org.eclipse.swt.dnd.DropTargetEvent)
	 */
	@SuppressWarnings("nls")
	@Override
	public void drop (DropTargetEvent event) {
		
		 if (getTransfer().isSupportedType(event.currentDataType)) {
		     String data = (String) getTextTransfer().nativeToJava(event.currentDataType);
		     if (data == null) {
		    	 return ;
		     }		     
		     data = data.trim();
		     
		     // Ignore non-url drops.
		     if (data.startsWith("http://") == false &&  
		    	 data.startsWith("https://") == false &&		    	 
		         data.startsWith("ftp://") == false &&
		         data.startsWith("ftps://") == false ) 
		     {
		    	 return ;
		     }
		     
		     
		     URI uri = null;
		     try {
		    	 uri = URI.createURI(data);
		    	 startImport();
		    	 addImport( attemptLoad ( uri ), uri );
		    	 endImport(event);
		    	 
		     } catch (Throwable t) {
		    	 
		    	 return ; 
		     }		     	
		     		    
		}
		
	}



	/** (non-Javadoc)
	 * @see org.eclipse.jface.util.TransferDropTargetListener#getTransfer()
	 */
	@Override
	public Transfer getTransfer() {		
		return TextTransfer.getInstance();
	}
	
	/**
	 * This only here because nativeToJava() in Transfer is protected.
	 * 
	 * @return the text transfer instance.
	 */
	
	public TextTransfer getTextTransfer () {
		return (TextTransfer) getTransfer();
	}
	
	/** (non-Javadoc)
	 * @see org.eclipse.jface.util.TransferDropTargetListener#isEnabled(org.eclipse.swt.dnd.DropTargetEvent)
	 */
	@Override
	public boolean isEnabled (DropTargetEvent event) {
		if (TextTransfer.getInstance().isSupportedType(event.currentDataType)) {			
			String data = (String) TextTransfer.getInstance().nativeToJava(event.currentDataType);
			if (data == null) {
				return false;
			}
			data = data.trim();
			return data.startsWith("http://") || data.startsWith("https://");		
		}
		return false;
	}
	
}
