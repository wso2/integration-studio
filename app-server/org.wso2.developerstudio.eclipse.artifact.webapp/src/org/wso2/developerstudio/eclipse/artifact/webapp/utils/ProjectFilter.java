package org.wso2.developerstudio.eclipse.artifact.webapp.utils;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jst.ws.jaxws.dom.runtime.internal.impl.IWebServiceProjectImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.common.notify.impl.BasicNotifierImpl;

public class ProjectFilter  extends ViewerFilter  {

	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		// TODO Auto-generated method stub
		//System.out.println(element);
		if(element instanceof IWebServiceProjectImpl){
			
		return false;	
		}
		
		return true;
	}

}
