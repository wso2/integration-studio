package org.wso2.datamapper.inputAdapters;

import java.io.File;
import java.util.Iterator;

import org.apache.avro.Schema;
import org.apache.avro.generic.GenericRecord;
import org.apache.axiom.om.OMElement;

public interface InputDataReaderAdapter {

	public void setInputReader(File inputFile);
	public OMElement getRootElement();
	public Iterator<GenericRecord> getChildItr(String xpath, Schema schema);
	
}
