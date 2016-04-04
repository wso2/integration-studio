/*******************************************************************************
 * Copyright (c) 2005, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.ui.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.bpel.common.extension.model.ExtensionMap;
import org.eclipse.bpel.model.Activity;
import org.eclipse.bpel.model.CorrelationSet;
import org.eclipse.bpel.model.PartnerLink;
import org.eclipse.bpel.model.Source;
import org.eclipse.bpel.model.Sources;
import org.eclipse.bpel.model.Target;
import org.eclipse.bpel.model.Targets;
import org.eclipse.bpel.model.Variable;
import org.eclipse.bpel.model.resource.BPELResource;
import org.eclipse.bpel.model.resource.BPELWriter;
import org.eclipse.bpel.model.util.BPELConstants;
import org.eclipse.bpel.ui.adapters.IContainer;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Display;

/**
 * The transfer buffer is the de-facto clipboard that us being used by the BPEL editor.
 * 
 * Each BPEL editor has its own transfer buffer. The objects in the transfer buffer
 * are just clones of the selected EMF objects. A little post processing is done to make
 * sure that in the case of a multiple selection only the top most objects of any tree
 * are in the selection (so if you select "empty" and a "sequence" in which the "empty"
 * resides then only "sequence" is copied to the transfer buffer.
 * 
 * In addition to coping the objects to the transfer buffer a serialized version of the
 * them is dumped into the system clipboard as BPEL XML. This allows for cross-editor copy/paste
 * that works reasonably well.
 * 
 * It also allows for valid BPEL XML to be pasted into the editor from other (textual) representations.
 * 
 *  
 * @author IBM, Original contribution. 
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Jun 4, 2007
 * 
 */

@SuppressWarnings("nls")
public class TransferBuffer {

	protected static final boolean DEBUG = false;
		
	static final String NL = System.getProperty("line.separator");
	
	/**
	 * @author IBM, Original contribution.
	 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
	 * @date Jun 4, 2007
	 *
	 */
	public class Contents {
		
		Map<EObject, EObject> fExtensionMap;
				
		/** The list of root objects in our transfer buffer */
		List<EObject> fRootObjects;
		
		/** The textual content of the clipboard */
		String fText;
		
		Contents (Map<EObject, EObject> extensionMap, List<EObject> rootList ) {			
			fExtensionMap = extensionMap;
			fRootObjects = rootList;					
		}
		
		@SuppressWarnings("nls")
		void transferToClipboard () {						
			// Populate the clipboard with the XML version of this object list.
			
			if (fRootObjects.size() == 1) {				
				EObject ref = fRootObjects.get(0);				
				fText = fWriter.toXML ( ref );							
				
			} else if (fRootObjects.size() > 1) {
				StringBuilder builder = new StringBuilder();
				builder.append("<bag>").append("\n\n");			
				for(EObject obj : fRootObjects) {								
					builder.append(fWriter.toXML ( obj ));
				}
				builder.append("\n</bag>");
				fText = builder.toString();				
			}
						
			// System.out.println("BPEL Source: " + fClipboardText);
		
			/** Clipboard clipboard = new Clipboard(display);
			 *	String textData = "Hello World";
			 *	String rtfData = "{\\rtf1\\b\\i Hello World}";
			 *	TextTransfer textTransfer = TextTransfer.getInstance();
			 *	RTFTransfer rtfTransfer = RTFTransfer.getInstance();
			 *	Transfer[] transfers = new Transfer[]{textTransfer, rtfTransfer};
			 *	Object[] data = new Object[]{textData, rtfData};
			 *	clipboard.setContents(data, transfers, DND.CLIPBOARD);
			 *	clipboard.dispose();
			 *
			 * Object[] data, Transfer[] dataTypes
			 */		
			fClipboard.setContents(new Object[] { fText } , new Transfer[] { TextTransfer.getInstance() }) ;
		}
		
	}

	/** The system clipboard */
	Clipboard fClipboard = null;
	
	/** The model BPEL Reader that we use to read the content from a clipboard (text paste) */
	org.eclipse.bpel.model.resource.BPELReader fReader = null;	
	
	/** The model BPEL Writer that we use to serialize the content */
	BPELWriter fWriter = null;
	
	/** The current contents of the transfer buffer */
	Contents fContents;
		
	/** The target resource */
	BPELResource fTargetResource;
	
	
	/**
	 * Brand new shiny transfer buffer with clipboard support.
	 * 
	 * @param display
	 */
	
	public TransferBuffer ( Display display ) {	
		fClipboard = new Clipboard(display);
		
		fWriter = new BPELWriter() {
			@Override
			public BPELResource getResource() {
				return fTargetResource;
			}			
		};
		
		fReader = new org.eclipse.bpel.model.resource.BPELReader () {
			@Override
			public Resource getResource() {
				return fTargetResource;
			}			
		};
		
		
	}
	
	
	/**
	 * Return the contents of the transfer buffer.
	 * 
	 * @return contents of the transfer buffer.
	 */

	public Contents getContents() {
		return fContents;
	}

	/**
	 * Set the contents of this transfer buffer.
	 * 
	 * This happens from the BPEL editor side, that is, when the Copy command is issued.
	 * 
	 * @param aContents  contents of this transfer buffer.
	 */

	@SuppressWarnings("nls")
	void setContents (Contents aContents) {		
		fContents = aContents;
	}

	
	String getClipboardText () {			
		return (String) fClipboard.getContents( TextTransfer.getInstance() );		
	}
	
	/**
	 * Get the list of outermost objects from the list of objects passed.
	 * If a sequence and an activity in the sequence are present in aList, then only
	 * the sequence is returned.
	 * 
	 * @param aList
	 * @return the list of outermost objects.
	 */
	
	List<EObject> getOutermostObjects(List<EObject> aList) {

		ArrayList<EObject> trimmedList = new ArrayList<EObject>(aList.size());

		for (EObject next : aList) {
			boolean skipNext = false;
			for (EObject parent : aList) {
				if (next != parent
						&& ModelHelper.isChildContainedBy(parent, next)) {
					skipNext = true;
					break;
				}
			}

			if (skipNext) {
				continue;
			}

			trimmedList.add(next);
		}
		return trimmedList;
	}

	
	
	
	/**
	 * Copy the passed source objects to the transfer buffer.
	 * 
	 * 
	 * @param sourceObjects
	 * @param sourceMap
	 */
	
	public void copyObjectsToTransferBuffer (List<EObject> sourceObjects, ExtensionMap sourceMap) {
		if (DEBUG) {
			System.out
					.println("copyObjectsToTransferBuffer(" + sourceObjects.size() + ")"); //$NON-NLS-1$ //$NON-NLS-2$
		}
		
		Map<EObject, EObject> targetMap = new HashMap<EObject, EObject>();
		List<EObject> sourceList = getOutermostObjects (sourceObjects);
		List<EObject> targetList = new ArrayList<EObject>();
		
		
		// TODO: are there issues here with processing subtrees one-by-one?
		// E.g. references
		// to an object which is copied in a different subtree? (Probably not,
		// for our model)
		
		for (EObject source : sourceList) {
			EObject target = BPELUtil
					.cloneSubtree(source, sourceMap, targetMap).targetRoot;
			targetList.add(target);		
		}

		
		// Remove links which are referenced by root activities and were not
		// copied! Otherwise, when the root activities are pasted the stale
		// references from
		// roots to these links will be pasted too.
		
		for ( EObject next : targetList ) {
			if (next instanceof Activity == false) {
				continue;
			}
			
			Activity activity = (Activity) next;
			
			Sources sources = activity.getSources();
			if (sources != null) {
				
				for(Source source : sources.getChildren() ) {
					if (!targetMap.containsValue(source.getLink())) {
						source.setLink(null);
						sources.getChildren().remove(source);						
					}
				}
				if (sources.getChildren().isEmpty()) {
					activity.setSources(null);
				}
			}

			Targets targets = activity.getTargets();
			if (targets != null) {
				for (Target target : targets.getChildren() ) {
					if (!targetMap.containsValue(target.getLink())) {
						target.setLink(null);
						targets.getChildren().remove(target);
					}
				}
				if (targets.getChildren().isEmpty()) {
					activity.setTargets(null);
				}
			}
		}

		/**
		 * This has to have a better way of being computed.
		 * The transfer buffer belongs to the editor and an editor edits one resource. So this should be an invariant 
		 * over the lifetime of the transfer buffer.
		 * 
		 */
		
		if (fTargetResource == null) {
			fTargetResource = (BPELResource) ModelHelper.getBPELEditor( sourceList.get(0) ).getResource();
		}		
		
		Contents contents = new Contents( targetMap,targetList );
		contents.transferToClipboard();
		
		setContents( contents );
	}

	/**
	 * Copy the transfer buffer to the targetObject.
	 * 
	 * @param targetObject
	 *            the target object to act as an anchor point.
	 * 
	 * @param targetMap
	 * @param bReference treat target as reference.
	 * 
	 * @return the list of new objects added.
	 */

	@SuppressWarnings("nls")
	public List<EObject> copyTransferBuffer (EObject targetObject,
			ExtensionMap targetMap, boolean bReference ) {

		String xml = getClipboardText();

		// First check if we need to copy from clipboard.
		
		if (fContents == null || xml.equals(fContents.fText) == false ) {
			
			if (couldBeXML(xml) == false) {
				setContents( null );
			} else {
				if (fTargetResource == null) {
					// This has to have a better way of being computed.
					fTargetResource = (BPELResource) ModelHelper.getBPELEditor( targetObject ).getResource();
				}
	
				List<EObject> result = fReader.fromXML( adjustXMLSource(xml) , "Clipboard", fTargetResource );
				if (result.size() > 0) {
					setContents( new Contents(null,result) );
				} else {
					setContents( null );
				}
			} 
		}
		
		Anchors anchors = getAnchors (targetObject,bReference,fContents);		
		
		return copyContentsTo (fContents, anchors, targetMap);				
	}
	
	
	
	List<EObject> copyContentsTo ( Contents contents, Anchors anchors, ExtensionMap targetMap ) {
	
		ArrayList<EObject> newObjects = new ArrayList<EObject>();
		
		if (contents == null) {
			return newObjects;
		}
		
		for (EObject source : contents.fRootObjects) {

			BPELUtil.CloneResult cloneResult = BPELUtil.cloneSubtree(source,contents.fExtensionMap, targetMap);
						
			anchors.fContainer.addChild(anchors.fTarget, cloneResult.targetRoot, anchors.fRefObject );
			// Resolve name of the source activity to be unique
			if (source instanceof Activity) {
				Activity node = (Activity) cloneResult.targetRoot;								
				String uniqueName = BPELUtil.generateUniqueModelName ( anchors.fTarget, node.getName(), node );				
				node.setName(BPELUtil.upperCaseFirstLetter (uniqueName) );
			} else if (source instanceof Variable) {
				Variable node = (Variable) cloneResult.targetRoot;								
				String uniqueName = BPELUtil.generateUniqueModelName ( anchors.fTarget, node.getName(), node );
				node.setName(uniqueName);				
			} else if (source instanceof PartnerLink) {
				PartnerLink node = (PartnerLink) cloneResult.targetRoot;								
				String uniqueName = BPELUtil.generateUniqueModelName ( anchors.fTarget, node.getName(), node );
				node.setName(uniqueName);								
			} else if (source instanceof CorrelationSet ) {
				CorrelationSet node = (CorrelationSet) cloneResult.targetRoot;								
				String uniqueName = BPELUtil.generateUniqueModelName (anchors.fTarget, node.getName(), node );
				node.setName(uniqueName);								
			}
			newObjects.add(cloneResult.targetRoot);
		}

		return newObjects;
	}

	
	class Anchors {
		EObject fTarget;
		EObject fRefObject;
		IContainer<EObject> fContainer;
	}

	/**
	 * Anchors just represent the anchor points for the paste operation.
	 *  
	 * There are several possibilities to consider.
	 *   
	 * <ol>
	 * <li> The  
	 */
	
	Anchors getAnchors ( EObject targetObject, boolean bReference, Contents contents ) {

		Anchors anchors = new Anchors();		
		
		
		anchors.fTarget = targetObject;		
		anchors.fContainer = BPELUtil.adapt(anchors.fTarget, IContainer.class);
			
		/**
		 * If we are not a container, then we presume that a container is our parent
		 * (such an an activity and its container being say a sequence).
		 * 
		 * Also, if bReference is forced, then were a reference object (the insertion point)
		 * and so we must go to our container.
		 */
		
		if (anchors.fContainer == null || bReference ) {
			
			// check its container
			anchors.fRefObject = targetObject;
			anchors.fTarget  = targetObject.eContainer();
			anchors.fContainer = BPELUtil.adapt(anchors.fTarget, IContainer.class);
			
		} else {
		
			/** Otherwise we are container.
			 *  
			 * But can we take the contents that is given to us ?
			 */ 
			
			if (canCopyContents(anchors, contents) == true) {
				return anchors;
			}
			
			/** Otherwise we assume that we are referenced container*/
			anchors.fRefObject = targetObject;
			anchors.fTarget    = targetObject.eContainer();
			anchors.fContainer = BPELUtil.adapt(anchors.fTarget, IContainer.class);
			
		}
		return anchors;		
	}

	
	boolean canCopyContents ( Anchors anchors, Contents content ) {
		
		if (content == null) {
			return false;
		}
		
		// check each root object's type against the container..
		for (EObject next : content.fRootObjects ) {				
			if (anchors.fContainer.canAddObject(anchors.fTarget, next, anchors.fRefObject) ) {
				return true;
			}
		}
		
		return false;
	}
	
	
	/**
	 * 
	 * 
	 * @param targetObject
	 *            the target reference object around which the copy-from-buffer
	 *            should be made.
	 * @param bReference - treat the target as a reference, even if it is a container.
	 * @return true of copy of transfer buffer can be made, false otherwise.
	 */

	@SuppressWarnings("nls")
	public boolean canCopyTransferBufferTo (EObject targetObject, boolean bReference  ) {
		if (targetObject == null ) {
			return false;
		}
		
		Anchors anchors = getAnchors (targetObject,bReference, fContents );
				
		if (anchors.fContainer == null) {
			return false;
		}		
		
		return canCopyContents ( anchors, fContents ) || couldBeXML(getClipboardText()) ;
	}

	

	
	
	/**
	 * This is a completely heuristic test to see if we have something in XML in the clipboard
	 * that "could" be converted into objects in our little world.
	 * 
	 * 
	 * 
	 * @param xml
	 * @return
	 */
	boolean couldBeXML (String xml) {
		
		if (xml == null || xml.length() < 4) {
			return false;
		}
		// Short valid XML element would be .... ?
		// <f/>
		
		int nOpen = 0;
		int nClose = 0;
		int nNonWhitespace = 0;
		int nWhitespace = 0;
		
		/** open and close should match, we count them, and then make sure we have about 0.95 ratio */
		for (char ch : xml.toCharArray() ) {
			
			if (Character.isWhitespace(ch)) {
				nWhitespace += 1;
			} else if (ch == '<') {
				// leading non-whitespace 
				if (nOpen == 0 && nNonWhitespace > 0) {
					return false;
				}
				nOpen += 1;
			} else if (ch == '>') {
				nClose += 1;
			} else {
				nNonWhitespace += 1;
			}
			
		}
		
		if (nOpen == 0 || nClose == 0) {
			return false;
		}
		
		float ratio = (float) (Math.min(nOpen, nClose) * 1.0 / 1.0 * Math.max(nOpen,nClose));
		
		if (ratio < 0.95) {
			return false;
		}

		return true;
	}
	
	
	/** Any namespace declaration, either xmlns="" or pfx:xmlns="xx" */
	static Pattern anyNamespace = Pattern.compile("(\\:|\\s)xmlns=(\\\"|\\')", Pattern.MULTILINE );
	
	/** BPEL 2004 namespace, as default (no prefix mapping) */
	static Pattern bpel2004DefaultNS = Pattern.compile("\\sxmlns=(\"|\')" + Pattern.quote(BPELConstants.NAMESPACE_2004) + "(\"|\')",
			Pattern.MULTILINE);
	
	/** BPEL 2003 namespace, as default (no prefix mapping) */
	static Pattern bpel2003DefaultNS = Pattern.compile("\\sxmlns=(\"|\')" + Pattern.quote(BPELConstants.NAMESPACE_2003) + "(\"|\')",
			Pattern.MULTILINE);
	
	static String EMPTY_STRING = "";
	
	 
	/**
	 * Adjust XML source so that we can parse it as BPEL 2.0 
	 * 
	 * @param buffer the current XML source.
	 * @return the adjust source.
	 */
	
	static public String adjustXMLSource ( String buffer ) {
		 
		/** Check if no Namespaces at all. Then there are no prefixes that are namespace bound */
		Matcher matcher = anyNamespace.matcher(buffer);
		
		if (matcher.find() == false) {
			StringBuilder sb = new StringBuilder(buffer.length() + 128);
			sb.append("<bag xmlns=\"").append( BPELConstants.NAMESPACE ).append("\">").append(NL);
			sb.append(buffer);			
			sb.append(NL).append("</bag>");
			return sb.toString();
			
		}
		
		/** Check if there is a BPELNamespace source mapping in the buffer. */

		/** Check pre-2.0 namespaces as well and replace them by the 2.0 BPEL namespace */
		
		matcher = bpel2004DefaultNS.matcher(buffer);
		if ( matcher.find() ) {			
			return adjustXMLSource(matcher.replaceAll( EMPTY_STRING )) ;
		}
		
		matcher = bpel2003DefaultNS.matcher(buffer);
		if ( matcher.find() ) {			
			return adjustXMLSource ( matcher.replaceAll( EMPTY_STRING ) );			
		}
		
		/** Return buffer as is */
		return buffer;
		
	}
	/**
	 * 
	 */
	
	public void dispose() {
		setContents(null);
		
		if (fClipboard != null) {
			fClipboard.dispose();
			fClipboard = null;
		}		
	}


}
