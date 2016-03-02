package org.wso2.developerstudio.eclipse.gmf.esb.persistence;

import java.util.HashMap;

import org.wso2.developerstudio.eclipse.gmf.esb.EsbLink;

public interface SequenceInfo {
	
	public HashMap<String, EsbLink> sequenceMap=new HashMap<String, EsbLink>();
	public String SEQUENCE_LABEL="Sequence";
	public String SELECT="Select";
	
	
}
