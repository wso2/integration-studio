/*
 * Copyright 2005,2013 WSO2, Inc. http://www.wso2.org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.wso2.datamapper.engine.inputAdapters;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.avro.Schema;
import org.apache.avro.generic.GenericRecord;

public interface InputDataReaderAdapter {
	
	public void setInptStream(InputStream inputStream)throws IOException;
	public boolean hasChildRecords();
	public void setInputSchemaMap(Map<String, Schema> inputSchemaMap);
	public void setRootRecord(GenericRecord rootRecord);
	public GenericRecord getRootRecord();
	public GenericRecord getChildRecord();
	public List<GenericRecord> getArrayChildList();
	
}