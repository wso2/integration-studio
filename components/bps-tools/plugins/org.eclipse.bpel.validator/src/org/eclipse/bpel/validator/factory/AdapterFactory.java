package org.eclipse.bpel.validator.factory;


import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.xml.namespace.QName;

import org.eclipse.bpel.model.adapters.AdapterRegistry;
import org.eclipse.bpel.validator.Activator;
import org.eclipse.bpel.validator.IBPELMarker;
import org.eclipse.bpel.validator.helpers.DOMNodeAdapter;
import org.eclipse.bpel.validator.model.INode;
import org.eclipse.bpel.validator.model.IProblem;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.wst.validation.internal.provisional.core.IMessage;
import org.w3c.dom.Element;


/**
 * An adapter factory.  
 *  
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Sep 19, 2006
 *
 */

@SuppressWarnings({"boxing","nls","restriction"})

public class AdapterFactory implements IAdapterFactory {

	/** debug variance in behavior */
	static public boolean DEBUG = false;
		
	/** We adapt to these types ... */	
	
	Class<?> [] adapterList = { 
			IMarker.class , 
			IResource.class , 
			INode.class ,
			IMessage.class };
	
	
	/**
	 * Get the adapter for the requested adaptable object.
	 * 
	 * @param adaptableObject adaptable object.
	 * @param adapterType the adapter type
	 * @return the adapter or null 
	 */
	
	@SuppressWarnings("unchecked")
	public Object getAdapter (Object adaptableObject, Class adapterType) {
		
		if (adaptableObject instanceof EObject) {
			Object adapter = AdapterRegistry.INSTANCE.adapt(adaptableObject, adapterType,false);
			if (adapter != null) {
				return adapter;
			}
		}
		
		if (adapterType == IMarker.class) {
			
			if (adaptableObject instanceof IProblem) {				
				return adapt_IProblem2IMarker ( (IProblem) adaptableObject );
			}
			
		} else if (adapterType == IResource.class) {
			
			if (adaptableObject instanceof EObject) {
				return adapt_EObject2IResource ( (EObject) adaptableObject );
			}
			if (adaptableObject instanceof Element) {
				return adapt_Element2IResource( (Element) adaptableObject );
			}
			
		} else if (adapterType == INode.class ) {
						
			if (adaptableObject instanceof Element) {
				Element elm = (Element) adaptableObject;
				
				Object adapter = elm.getUserData(DOMNodeAdapter.KEY);
				if (adapter instanceof DOMNodeAdapter) {
					return adapterType.cast(adapter);
				}
				adapter = new DOMNodeAdapter( elm );
				elm.setUserData(DOMNodeAdapter.KEY, adapter, null );
				return adapterType.cast(adapter);																				
			}
			
		} else if (adapterType == IMessage.class) {
			
			if (adaptableObject instanceof IProblem) {
				return adapt_IProblem2IMessage( (IProblem) adaptableObject );
			}
			
		}
		return null;
	}

	
	/**
	 * Return an IResource adapter for the EObject. 
	 * 
	 * @param eObj
	 * @return the IResource to which we will be creating markers. 
	 */
	
	IResource adapt_EObject2IResource (EObject eObj) {
		if (eObj == null) {
			return null;
		}
		
		Resource r = eObj.eResource();
		if (r == null) {
			return null;
		}
		// Bugzilla 323858 and JBIDE-6472
		else if ( r.getURI()==null ) {
			return null;
		}
		return getFileFromURI ( r.getURI() );		
	}

	IResource adapt_Element2IResource ( Element elm ) {
		
		Element top = elm.getOwnerDocument().getDocumentElement();
		IResource result = null;
		if (top != null) {
			// Find the EObject reference to the emf model in the hierarchy of
			// the
			EObject eObj = (EObject) top.getUserData("emf.model");
			// https://bugs.eclipse.org/bugs/show_bug.cgi?id=330813
			// https://jira.jboss.org/browse/JBIDE-7116
			if (eObj==null)
				eObj = (EObject) elm.getUserData("emf.model");

			result = adapt_EObject2IResource(eObj);
		}
		return result;
	}

	/**
	 * Return an IMarker which is derived from IProblem. 
	 *  
	 * @param problem the problem to adapt (convert to) IMarker
	 * @return an appropriate IMarker
	 */
	  

	IMarker adapt_IProblem2IMarker (IProblem problem ) {
				
		IResource resource = null;
		INode node = (INode) problem.getAttribute( IProblem.NODE );
		if (node!=null)
			resource = (IResource) getAdapter(node.nodeValue(), IResource.class );
		else
		{
			// https://jira.jboss.org/browse/JBIDE-6825
			// added a new ERESOURCE attribute
			Resource modelResource = (Resource) problem.getAttribute( IProblem.ERESOURCE );
			resource = getFileFromURI(modelResource.getURI());
		}		
		
		Map<String,Object> props = new HashMap<String,Object>();
		
		//message && fix  		
		String msg  = problem.getAttribute(IProblem.MESSAGE);
		String rule = problem.getAttribute(IProblem.RULE);

		// https://bugs.eclipse.org/bugs/show_bug.cgi?id=330813
		// https://jira.jboss.org/browse/JBIDE-7116
		// fix ugliness in DEBUG mode (see "org.eclipse.bpel.validator.builder" buildCommand in .project)
		if (rule!=null)
			props.put("bpel.validation.rule", rule);
		
		if (DEBUG) {
			StringBuilder emsg = new StringBuilder( msg );
			Throwable t = problem.getAttribute(IProblem.EXCEPTION);
			if (rule!=null || t!=null) {

				emsg.append( "(DEBUG: " );
				if (rule!=null)
					emsg.append( "rule=" + rule );
			
				if (t != null) {
					if (rule!=null)
						emsg.append( "; " );
					emsg.append( "stack=" );
					
					int count = 0;
					for(StackTraceElement e : t.getStackTrace()) {
						emsg.append( "[" + count + "]" );
						emsg.append( e.getClassName() + "." );
						emsg.append( e.getMethodName() + "@" + e.getLineNumber());
						count += 1;
						if (count > 2) {
							break;
						}
						emsg.append( "/" );
					}
				}
			
				emsg.append( ")" );
			}
			props.put(IMarker.MESSAGE, emsg.toString());
			
		} else {
			props.put(IMarker.MESSAGE, msg );
		}
		
		// Path to object in the BPEL model.
		
		// Location of the marker in the source
		int lineNo = problem.getAttribute(IProblem.LINE_NUMBER,-1);
		props.put(IMarker.LINE_NUMBER, lineNo );
		props.put(IMarker.CHAR_END, problem.getAttribute(IProblem.CHAR_END, -1));
		props.put(IMarker.CHAR_START, problem.getAttribute(IProblem.CHAR_START,-1));
		
		// Location
		if (lineNo < 0) {
			props.put(IMarker.LOCATION, problem.getAttribute(IProblem.LOCATION));
		}
		
		// type of marker
		switch (problem.getAttribute(IProblem.SEVERITY,IProblem.SEVERITY_ERROR )) {
		case IProblem.SEVERITY_WARNING : 				
			props.put(IMarker.SEVERITY, IMarker.SEVERITY_WARNING);
			break;
		case IProblem.SEVERITY_INFO :
			props.put(IMarker.SEVERITY, IMarker.SEVERITY_INFO);
			break;
		default :
			props.put(IMarker.SEVERITY, IMarker.SEVERITY_ERROR);
			break;
		}			
		
		// the pointer in the model object space to the object on which this marker is produced. 
		props.put( IBPELMarker.ADDRESS_MODEL , problem.getAttribute( IProblem.ADDRESS_MODEL ));
		// the pointer in the DOM object space to the object on which this marker is produced.			
		props.put( IBPELMarker.ADDRESS_XPATH, problem.getAttribute( IProblem.ADDRESS_XPATH ));
		
		// href.context refers to the problem context, expressed  
		// in the model object space context. 
		Object context = problem.getAttribute(IProblem.CONTEXT );
		if( context instanceof QName){
			QName qname = (QName)context;
			props.put( "href.context", qname.getLocalPart());	
		}
		else{
			props.put( "href.context", problem.getAttribute(IProblem.CONTEXT ));
		}
		
		
		// do not save this marker
		// props.put( IMarker.TRANSIENT, true);
			
		
		IMarker marker = null;
		try {
			marker = resource.createMarker( IBPELMarker.ID );
			marker.setAttributes( props );
		} catch (Exception ex) {
			// can't create marker ... ?
			Activator.log(ex);
			return null;
		}
			
		
		// return the marker.
		return marker;				
	}

	
	/**
	 * Return an IMessage which is derived from IProblem. 
	 *  
	 * @param problem the problem to adapt (convert to) IMarker
	 * @return an appropriate IMarker
	 */
	  

	
	IMessage adapt_IProblem2IMessage (IProblem problem ) {										
		// IResource resource = (IResource) getAdapter(node.nodeValue(), IResource.class );			
		return new Message ( problem );		
	}
	
	
	
	static class Message implements IMessage {

		static String GENERAL = "general";
		
		IProblem fProblem;

		protected String fMarkerId;
		
		Message ( IProblem problem ) {
			fProblem = problem;
		}
		
		/*** (non-Javadoc)
		 * @see org.eclipse.wst.validation.internal.provisional.core.IMessage#getAttribute(java.lang.String)
		 */
		
		public Object getAttribute(String attributeName) {
			return fProblem.getAttribute(attributeName);
		}

		/*** (non-Javadoc)
		 * @see org.eclipse.wst.validation.internal.provisional.core.IMessage#getAttributes()
		 */
		public HashMap getAttributes() {
			return (HashMap) fProblem.getAttributes();
		}

		/*** (non-Javadoc)
		 * @see org.eclipse.wst.validation.internal.provisional.core.IMessage#getBundleName()
		 */
		public String getBundleName() {
			return fProblem.getAttribute(IProblem.BUNDLE_NAME);
		}

		/*** (non-Javadoc)
		 * @see org.eclipse.wst.validation.internal.provisional.core.IMessage#getGroupName()
		 */
		public String getGroupName() {
			return GENERAL;
		}

		/*** (non-Javadoc)
		 * @see org.eclipse.wst.validation.internal.provisional.core.IMessage#getId()
		 */
		public String getId() {
			return fProblem.getAttribute(IProblem.MESSAGE_ID);
		}

		/*** (non-Javadoc)
		 * @see org.eclipse.wst.validation.internal.provisional.core.IMessage#getLength()
		 */
		public int getLength() {
			int offset = fProblem.getAttribute( IProblem.CHAR_START );
			int offsetEnd = fProblem.getAttribute( IProblem.CHAR_END );
			int length = offsetEnd - offset + 1;
			if (length < 0) {
				return IMessage.OFFSET_UNSET; 
			}
			return length ;
		}

		/** (non-Javadoc)
		 * @see org.eclipse.wst.validation.internal.provisional.core.IMessage#getLineNumber()
		 */
		public int getLineNumber() {
			return fProblem.getAttribute(IProblem.LINE_NUMBER);			
		}

		/*** (non-Javadoc)
		 * @see org.eclipse.wst.validation.internal.provisional.core.IMessage#getMarkerId()
		 */
		public String getMarkerId() {
			return fMarkerId;
		}

		/*** (non-Javadoc)
		 * @see org.eclipse.wst.validation.internal.provisional.core.IMessage#getOffset()
		 */
		public int getOffset() {
			int offset = fProblem.getAttribute( IProblem.CHAR_START );
			if (offset < 0) {
				return IMessage.OFFSET_UNSET; 
			}
			return offset;
		}

		/*** (non-Javadoc)
		 * @see org.eclipse.wst.validation.internal.provisional.core.IMessage#getParams()
		 */
		public String[] getParams() {
			return (String[]) fProblem.getAttribute(IProblem.MESSAGE_ARGS);
		}

		/**non-Javadoc)
		 * @see org.eclipse.wst.validation.internal.provisional.core.IMessage#getSeverity()
		 */
		public int getSeverity() {
			int severity = fProblem.getAttribute(IProblem.SEVERITY);
			switch (severity) {
			case IProblem.SEVERITY_ERROR : 
				return IMessage.HIGH_SEVERITY;
			case IProblem.SEVERITY_WARNING :
			case IProblem.SEVERITY_INFO :
				return IMessage.LOW_SEVERITY;			
			}
			
			return IMessage.LOW_SEVERITY;
		}

		/*** (non-Javadoc)
		 * @see org.eclipse.wst.validation.internal.provisional.core.IMessage#getTargetObject()
		 */
		public Object getTargetObject() {
			INode node = fProblem.getAttribute(IProblem.NODE);
			if (node == null) {
				return null;
			}			
			return node;
		}

		/*** (non-Javadoc)
		 * @see org.eclipse.wst.validation.internal.provisional.core.IMessage#getText()
		 */
		public String getText() {
			return fProblem.getAttribute(IProblem.MESSAGE);
		}

		/*** (non-Javadoc)
		 * @see org.eclipse.wst.validation.internal.provisional.core.IMessage#getText(java.lang.ClassLoader)
		 */
		public String getText(ClassLoader classLoader) {
			return fProblem.getAttribute(IProblem.MESSAGE);
		}

		/*** (non-Javadoc)
		 * @see org.eclipse.wst.validation.internal.provisional.core.IMessage#getText(java.util.Locale)
		 */
		public String getText(Locale locale) {
			return fProblem.getAttribute(IProblem.MESSAGE);
		}

		/*** (non-Javadoc)
		 * @see org.eclipse.wst.validation.internal.provisional.core.IMessage#getText(java.util.Locale, java.lang.ClassLoader)
		 */
		public String getText(Locale locale, ClassLoader classLoader) {
			return fProblem.getAttribute(IProblem.MESSAGE);
		}

		/*** (non-Javadoc)
		 * @see org.eclipse.wst.validation.internal.provisional.core.IMessage#setAttribute(java.lang.String, java.lang.Object)
		 */
		public void setAttribute(String attributeName, Object value) {
			// TODO Auto-generated method stub
			
		}

		/*** (non-Javadoc)
		 * @see org.eclipse.wst.validation.internal.provisional.core.IMessage#setBundleName(java.lang.String)
		 */
		public void setBundleName(String bundleName) {
			 
			
		}

		/*** (non-Javadoc)
		 * @see org.eclipse.wst.validation.internal.provisional.core.IMessage#setGroupName(java.lang.String)
		 */
		public void setGroupName(String name) {
			
			
		}

		/*** (non-Javadoc)
		 * @see org.eclipse.wst.validation.internal.provisional.core.IMessage#setId(java.lang.String)
		 */
		public void setId(String newId) {
			
			
		}

		/*** (non-Javadoc)
		 * @see org.eclipse.wst.validation.internal.provisional.core.IMessage#setLength(int)
		 */
		public void setLength(int length) {
			
			
		}

		/*** (non-Javadoc)
		 * @see org.eclipse.wst.validation.internal.provisional.core.IMessage#setLineNo(int)
		 */
		public void setLineNo(int lineNumber) {
			
			
		}

		/*** (non-Javadoc)
		 * @see org.eclipse.wst.validation.internal.provisional.core.IMessage#setMarkerId(java.lang.String)
		 */
		public void setMarkerId(String markerId) {
			fMarkerId = markerId;
			
		}

		/*** (non-Javadoc)
		 * @see org.eclipse.wst.validation.internal.provisional.core.IMessage#setOffset(int)
		 */
		public void setOffset(int offset) {
			// TODO Auto-generated method stub
			
		}

		/*** (non-Javadoc)
		 * @see org.eclipse.wst.validation.internal.provisional.core.IMessage#setParams(java.lang.String[])
		 */
		public void setParams(String[] newParams) {
			// TODO Auto-generated method stub
			
		}

		/*** (non-Javadoc)
		 * @see org.eclipse.wst.validation.internal.provisional.core.IMessage#setSeverity(int)
		 */
		public void setSeverity(int newSeverity) {
			// TODO Auto-generated method stub
			
		}

		/** (non-Javadoc)
		 * @see org.eclipse.wst.validation.internal.provisional.core.IMessage#setTargetObject(java.lang.Object)
		 */
		public void setTargetObject(Object obj) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
		
	
	/**
	 * Return the adapter list. These are all the interfaces or classes to which
	 * we can adapt objects passed to this factory.
	 * 
	 * @return a list of classes that we can adapt to.
	 */
	
	public Class<?>[] getAdapterList() {
		return adapterList;
	}

	
	
	IFile getFileFromURI (URI uri) {
		if (uri != null) {
			if (uri.isFile()) {
				return getFileFromDeviceURI(uri);
			}
			return getFileFromPlatformURI(uri);
		}
		return null;
	}
	
	IFile getFileFromDeviceURI(URI uri) {
		String device = uri.device();
		StringBuilder path = new StringBuilder();
		for(String segment : uri.segments()) {
			path.append("/").append(segment);
		}		
		return ResourcesPlugin.getWorkspace().getRoot().getFileForLocation(new Path(device, path.toString()));
	}
	
	IFile getFileFromPlatformURI (URI uri) {
		String [] segs  = uri.segments();
		IPath path = null;
		// start at 1 to skip resource
		for (int i = 1; i< segs.length; i++) {
			if (path == null) {
				path = new Path(segs[i]);
			} else {
				path = path.append(segs[i]);
			}
		}
		return ResourcesPlugin.getWorkspace().getRoot().getFile(path);
	}

}
