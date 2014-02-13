package org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.custom;

import org.apache.synapse.MessageContext;
import org.apache.synapse.mediators.AbstractMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;

public class RuleMediatorExt extends AbstractMediator{

	private EsbNode subject;
	  
    public void setSubject(EsbNode subject) {
		this.subject = subject;
	}
    
    public EsbNode getSubject(){
    	return subject;
    }
    
    
	public boolean mediate(MessageContext arg0) {
		// TODO Auto-generated method stub
		return true;
	}

}
