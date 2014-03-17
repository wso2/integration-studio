/*
 * Copyright 2005,2014 WSO2, Inc. http://www.wso2.org
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

package org.wso2.datamapper.engine.core;

import org.apache.avro.Schema;
import org.apache.avro.Schema.Type;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.generic.GenericData.Array;
import org.mozilla.javascript.NativeJavaArray;
import org.mozilla.javascript.Scriptable;

public class  AvroAwareNativeJavaArray extends NativeJavaArray  {
	
	private Array<Object> recordArray;

	private static final long serialVersionUID = 1625850167152425723L;

	public AvroAwareNativeJavaArray(Scriptable scope, Object array,Array<Object> recordArray) {
		super(scope, array);
		this.recordArray = recordArray;
	}
	
	@Override
	public void put(int index, Scriptable start, Object value) {
		Schema elementType = recordArray.getSchema().getElementType();
		if(elementType.getType().equals(Type.RECORD)){
		GenericRecord record = new GenericData.Record(elementType);
		recordArray.add(record);
		} else{
			recordArray.add(value);
		}
		//super.put(index, start, value);
	}
	
	@Override
	public void put(String id, Scriptable start, Object value) {
		// TODO Auto-generated method stub
		super.put(id, start, value);
	}

	
	@Override
    public Object get(int index, Scriptable start) {
            Schema elementType = recordArray.getSchema().getElementType();
            if(elementType.getType().equals(Type.RECORD)){
                    if((recordArray.size() -1) < index){
                            recordArray.add(new GenericData.Record(elementType));
                    }
                    return new ScriptableObjectFactory((GenericRecord)recordArray.get(index));
            } else{
                    return recordArray.get(index);
            }
            //return super.get(index, start);
    }


}
