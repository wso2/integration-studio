package org.eclipse.bpel.ui.util;

import org.eclipse.wst.wsdl.ui.internal.util.NodeAssociationManager;
import org.eclipse.wst.wsdl.ui.internal.extensions.INodeAssociationProvider;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class BPELNodeAssociationManager extends NodeAssociationManager {
	protected INodeAssociationProvider wsdlProvider;
	protected INodeAssociationProvider xsdProvider;
	
	public BPELNodeAssociationManager() {             
		//FIXME init bpelProvider here
		super();
	}        

	
	protected INodeAssociationProvider getAppicableProvider(Object object) {
		//FIXME add code for returning bpelProvider here
		return super.getAppicableProvider(object);
	}
    
	
	public Object getModelObjectForNode(Object rootObject, Element targetNode) {
		//FIXME try super; delete is super is OK
		return super.getModelObjectForNode(rootObject, targetNode);
	}

	
	public Node getNode(Object modelObject) {
		//FIXME try super; delete is super is OK
		return super.getNode(modelObject);
	}
	
	
	protected Element[] getParentElementChain(Element element) {
		//FIXME try super; delete is super is OK
		return super.getParentElementChain(element);
	}
}
