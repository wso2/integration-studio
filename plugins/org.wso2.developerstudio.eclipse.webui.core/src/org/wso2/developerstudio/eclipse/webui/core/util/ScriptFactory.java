/*
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
package org.wso2.developerstudio.eclipse.webui.core.util;

import java.lang.reflect.Type;

import org.wso2.developerstudio.eclipse.webui.core.model.BrowserScript;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

import static org.wso2.developerstudio.eclipse.webui.core.editor.Constants.*;

public class ScriptFactory {

	private static Gson gson;
	public static final BrowserScript INVOKE_FN_LOAD_FILE_CONTENT;
	public static final BrowserScript INVOKE_FN_SAVE_FILE;
	public static final BrowserScript INVOKE_FN_SET_IDE_DIRTY_CONTENT;
	public static final BrowserScript INVOKE_FN_LOAD_IDE_DIRTY_CONTENT;
	public static final BrowserScript INVOKE_FN_SAVE_FILE_CONTENT_FUNCTION_WITH_EXTNTION;

	static {
		gson = new Gson();
		INVOKE_FN_LOAD_FILE_CONTENT = createFunctionCallScript(APP_LOAD_FILE_CONTENT_FUNCTION);
		INVOKE_FN_SAVE_FILE = createFunctionCallScript(APP_SAVE_FILE_FUNCTION);
		INVOKE_FN_SET_IDE_DIRTY_CONTENT = createFunctionCallScript(APP_SET_DIRTY_CONTENT_FUNCTION);
		INVOKE_FN_LOAD_IDE_DIRTY_CONTENT = createFunctionCallScript(APP_GET_DIRTY_CONTENT_FUNCTION);
		INVOKE_FN_SAVE_FILE_CONTENT_FUNCTION_WITH_EXTNTION = createFunctionCallScript(APP_SAVE_FILE_WITH_EXTNTION_FUNCTION);
	}

	public static BrowserScript createScript(String scriptName, String script) {
		return new BrowserScript(scriptName, script);
	}

	public static BrowserScript createFunctionCallScript(String functionName,
			String[] args) {
		return new BrowserScript(functionName, args);
	}

	public static BrowserScript createFunctionCallScript(String functionName,
			JsonElement[] args) {
		return createFunctionCallScript(functionName, toJsonStringArray(args));
	}

	public static BrowserScript createFunctionCallScript(String functionName,
			JsonElement argument) {
		return createFunctionCallScript(functionName,
				new String[] { toJsonString(argument) });
	}

	public static BrowserScript createFunctionCallScript(String functionName) {
		return createFunctionCallScript(functionName, new String[] {});
	}

	public static String toJsonString(JsonElement jsonElement) {
		return gson.toJson(jsonElement);
	}
	
	public static String pojoToJson(Object pojo) {
		return gson.toJson(pojo);
	}
	
	public static <T> T jsonToPojo(String json, Type typeOfT){
		return gson.fromJson(json,typeOfT);
	}
	
	public static <T> T jsonToPojo(String json, Class<T> classOfT){
		return gson.fromJson(json, classOfT);
	}
	
	public static <T> T jsonToPojo(JsonElement json, Type typeOfT){
		return gson.fromJson(json,typeOfT);
	}
	
	public static <T> T jsonToPojo(JsonElement json, Class<T> classOfT){
		return gson.fromJson(json, classOfT);
	}

	public static String[] toJsonStringArray(JsonElement[] jsonElements) {
		String[] elements = new String[jsonElements.length];
		for (int index = 0; index < jsonElements.length; index++) {
			elements[index] = toJsonString(jsonElements[index]);
		}
		return elements;
	}
}
