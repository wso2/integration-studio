/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.bpel.fnmeta.model.util;

import org.eclipse.bpel.fnmeta.model.Argument;
import org.eclipse.bpel.fnmeta.model.Assistant;
import org.eclipse.bpel.fnmeta.model.Registry;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.xmi.XMLLoad;
import org.eclipse.emf.ecore.xmi.XMLSave;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;

/**
 * <!-- begin-user-doc -->
 * The <b>Resource </b> associated with the package.
 * <!-- end-user-doc -->
 * @see org.eclipse.bpel.fnmeta.model.util.FMResourceFactoryImpl
 * @generated
 */

@SuppressWarnings("nls")

public class FMResourceImpl extends XMLResourceImpl {
	/**
	 * Creates an instance of the resource.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param uri the URI of the new resource.
	 * @generated
	 */
	public FMResourceImpl(URI uri) {
		super(uri);
	}

	/**
	 * @generated NOT 
	 */
	@Override
	protected XMLLoad createXMLLoad() {
		return new FMReader();
	}

	/**
	 * @generated NOT 
	 */
	
	@Override
	protected XMLSave createXMLSave() {
		throw new RuntimeException("Resource does know how to save itself");
	}

	/**
	 * @generated NOT 
	 */
    @Override
	public String getURIFragment(EObject eObject)
    {
        return super.getURIFragment(eObject);
    }
    
	/**
	 * @generated NOT 
	 */
    @Override
	public EObject getEObject (String uriFragment) {
	    
    	if (uriFragment == null) {
	    	return null;
	    }
    	EObject eObj = super.getEObject(uriFragment);
    	if (eObj != null) {
    		return eObj;    		
    	}
    	if (getContents().size() < 1) {
    		return null;
    	}
    	Registry registry = (Registry) getContents().get(0);    	
    	
    	String name = parse(uriFragment,"assistant=");
    	if (name != null) {
    		for(Assistant a : registry.getAssistants()) {
    			if (name.equals(a.getName())) {
    				return a;
    			}
    		}
    	}
    	
    	name = parse(uriFragment,"argument=");
    	if (name != null) {
    		for(Argument a : registry.getArguments()) {
    			if (name.equals(a.getName())) {
    				return a;
    			}
    		}
    	}
    	
    	return null;
	}

	/**
	 * @generated NOT 
	 */
    String parse ( String str, String what ) {    	
    	int x = str.lastIndexOf(what);
    	if (x < 0) {
    		return null;
    	}
    	return str.substring(x+what.length());    	
    }
    	

} //FMResourceImpl
