/*
 * Copyright (c) 2012, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.artifact.registry.handler.editor;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.wso2.developerstudio.eclipse.artifact.registry.handler.util.Constants.*;

public class HandlerMethodInfo {
	private static Map<String,String[]> methodList = new HashMap<String,String[]>();
	private static Map<String,String> typeMap = new HashMap<String, String>();
 	static{
		methodList.put("get", new String[] { METHOD_INFO_GET, "GET", "(QRequestContext;)QResource;" });
		methodList.put("put", new String[] { METHOD_INFO_PUT, "PUT", "(QRequestContext;)V" });
		methodList.put("importResource", new String[] { METHOD_INFO_IMPORT, "IMPORT", "(QRequestContext;)V" });
		methodList.put("move", new String[] { METHOD_INFO_MOVE, "MOVE", "(QRequestContext;)QString;" });
		methodList.put("copy", new String[] { METHOD_INFO_COPY, "COPY", "(QRequestContext;)QString;" });
		methodList.put("rename", new String[] { METHOD_INFO_RENAME, "RENAME", "(QRequestContext;)QString;" });
		methodList.put("createLink", new String[] { METHOD_INFO_CREATE_LINK, "CREATE_LINK", "(QRequestContext;)V" });
		methodList.put("removeLink", new String[] { METHOD_INFO_REMOVE_LINK, "REMOVE_LINK", "(QRequestContext;)V" });
		methodList.put("delete", new String[] { METHOD_INFO_DELETE, "DELETE", "(QRequestContext;)V" });
		methodList.put("putChild", new String[] { METHOD_INFO_PUT_CHILD, "PUT_CHILD", "(QRequestContext;)V" });
		methodList.put("importChild", new String[] { METHOD_INFO_IMPORT_CHILD, "IMPORT_CHILD", "(QRequestContext;)V" });
		methodList.put("invokeAspect", new String[] { METHOD_INFO_INVOKE_ASPECT, "INVOKE_ASPECT","(QRequestContext;)V" });
		methodList.put("addAssociation", new String[] { METHOD_INFO_ADD_ASSOCIATION, "ADD_ASSOCIATION", "(QRequestContext;)V" });
		methodList.put("removeAssociation",new String[]{METHOD_INFO_REMOVE_ASSOCIATION,"REMOVE_ASSOCIATION","(QRequestContext;)V"});
		methodList.put("getAllAssociations",new String[]{METHOD_INFO_GET_ALL_ASSOCIATIONS,"GET_ALL_ASSOCIATIONS","(QRequestContext;)[QAssociation;"});
		methodList.put("getAssociations",new String[]{METHOD_INFO_GET_ASSOCIATIONS,"GET_ASSOCIATIONS","(QRequestContext;)[QAssociation;"});
		methodList.put("applyTag",new String[]{METHOD_INFO_APPLY_TAG,"APPLY_TAG","(QRequestContext;)V"});
		methodList.put("removeTag",new String[]{METHOD_INFO_REMOVE_TAG,"REMOVE_TAG","(QRequestContext;)V"}); 
		methodList.put("rateResource",new String[]{METHOD_INFO_RATE_RESOURCE,"RATE_RESOURCE","(QRequestContext;)V"}); 
		methodList.put("restoreVersion",new String[]{METHOD_INFO_RESTORE_VERSION,"RESTORE_VERSION","(QRequestContext;)V"}); 
		methodList.put("createVersion",new String[]{METHOD_INFO_CREATE_VERSION,"CREATE_VERSION","(QRequestContext;)V"});
		methodList.put("editComment",new String[]{METHOD_INFO_EDIT_COMMENT,"EDIT_COMMENT","(QRequestContext;)V"});
		methodList.put("addComment",new String[]{METHOD_INFO_ADD_COMMENT,"ADD_COMMENT","(QRequestContext;)QString;"});
		methodList.put("removeComment",new String[]{METHOD_INFO_REMOVE_COMMENT,"REMOVE_COMMENT","(QRequestContext;)V"}); 
		methodList.put("getComments",new String[]{METHOD_INFO_GET_COMMENTS,"GET_COMMENTS","(QRequestContext;)[QComment;"});
		methodList.put("getAverageRating",new String[]{METHOD_INFO_GET_AVERAGE_RATING,"GET_AVERAGE_RATING","(QRequestContext;)F"});
		methodList.put("getRating",new String[]{METHOD_INFO_GET_RATING,"GET_RATING","(QRequestContext;)I"});
		methodList.put("getVersions",new String[]{METHOD_INFO_GET_VERSIONS,"GET_VERSIONS","(QRequestContext;)[QString;"});
		methodList.put("getTags",new String[]{METHOD_INFO_GET_TAGS,"GET_TAGS","(QRequestContext;)[QTag;"});
		methodList.put("getResourcePathsWithTag",new String[]{METHOD_INFO_GET_RESOURCE_PATHS_WITH_TAG,"GET_RESOURCE_PATHS_WITH_TAG","(QRequestContext;)[QTaggedResourcePath;"});
		methodList.put("executeQuery",new String[]{METHOD_INFO_EXECUTE_QUERY,"EXECUTE_QUERY","(QRequestContext;)QCollection;"});
		methodList.put("searchContent",new String[]{METHOD_INFO_SEARCH_CONTENT,"SEARCH_CONTENT","(QRequestContext;)QCollection;"});
		methodList.put("resourceExists",new String[]{METHOD_INFO_RESOURCE_EXISTS,"RESOURCE_EXISTS","(QRequestContext;)Z"});
		methodList.put("dump",new String[]{METHOD_INFO_DUMP,"DUMP","(QRequestContext;)V"});
		methodList.put("restore",new String[]{METHOD_INFO_RESTORE,"RESTORE","(QRequestContext;)V"});
		
		typeMap.put("V", "void");
		typeMap.put("F", "float");
		typeMap.put("I", "int");
		typeMap.put("Z", "boolean");
		typeMap.put("QString;","String");
		typeMap.put("[QString;","String[]");
		typeMap.put("QResource;","org.wso2.carbon.registry.core.Resource");
		typeMap.put("[QResource;","org.wso2.carbon.registry.core.Resource[]");
		typeMap.put("QCollection;","org.wso2.carbon.registry.core.Collection");
		typeMap.put("[QCollection;","org.wso2.carbon.registry.core.Collection[]");
		typeMap.put("QAssociation;","org.wso2.carbon.registry.core.Association");
		typeMap.put("[QAssociation;","org.wso2.carbon.registry.core.Association[]");
		typeMap.put("QComment;","org.wso2.carbon.registry.core.Comment");
		typeMap.put("[QComment;","org.wso2.carbon.registry.core.Comment[]");
		typeMap.put("QTaggedResourcePath;","org.wso2.carbon.registry.core.TaggedResourcePath");
		typeMap.put("[QTaggedResourcePath;","org.wso2.carbon.registry.core.TaggedResourcePath[]");
		typeMap.put("QTag;","org.wso2.carbon.registry.core.Tag");
		typeMap.put("[QTag;","org.wso2.carbon.registry.core.Tag[]");
	}
	
	public static Map<String,String[]> getMethodInfo(){
		return Collections.unmodifiableMap(methodList);
	}
	
	public static String getMethodName(String attributeValue){
		Set<Entry<String, String[]>> entrySet = methodList.entrySet();
		for (Entry<String, String[]> entry : entrySet) {
			if(attributeValue.equals(entry.getValue()[1]))
				return entry.getKey();
        }
		return null;
	}
	
	public static String getXMLAttributeValue(String methodName){
		if(methodList.containsKey(methodName)){
			return methodList.get(methodName)[1];
		}
		return null;
	}
	
	public static String getReturnType(String methodName) {
		if(methodList.containsKey(methodName)){
			String sig = methodList.get(methodName)[2];
			Pattern regex = Pattern.compile("\\((.+)\\)(.+)");
			Matcher m = regex.matcher(sig);
			if (m.find()) {
				return typeMap.get(m.group(2));
			}
		}
		return null;
    }
}
