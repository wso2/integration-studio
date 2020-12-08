package org.wso2.developerstudio.eclipse.registry.base.util;

import org.wso2.carbon.registry.core.jdbc.handlers.filters.Filter;

public class FilterMethods{
	
	public String[] getFilterMethodList(){
		String[] filterMethods = {Filter.PUT, 
								  Filter.PUT_CHILD, 
								  Filter.COPY, 
								  Filter.MOVE, 
								  Filter.DELETE, 
								  Filter.RENAME, 
								  Filter.GET, 
								  Filter.RESOURCE_EXISTS, 
								  Filter.IMPORT_CHILD, 
								  Filter.IMPORT,
								  Filter.ADD_ASSOCIATION,
								  Filter.ADD_COMMENT,
								  Filter.APPLY_TAG,
								  Filter.CREATE_LINK,
								  Filter.CREATE_VERSION,
								  Filter.DUMP,
								  Filter.EDIT_COMMENT,
								  Filter.EXECUTE_QUERY,
								  Filter.GET_ALL_ASSOCIATIONS,
								  Filter.GET_ASSOCIATIONS,
								  Filter.GET_AVERAGE_RATING,
								  Filter.GET_COMMENTS,
								  Filter.GET_RESOURCE_PATHS_WITH_TAG,
								  Filter.GET_TAGS,
								  Filter.GET_VERSIONS,
								  Filter.REMOVE_LINK,
								  Filter.RATE_RESOURCE,
								  Filter.REMOVE_ASSOCIATION,
								  Filter.REMOVE_COMMENT,
								  Filter.REMOVE_TAG,
								  Filter.RESTORE,
								  Filter.RESTORE_VERSION,
								  Filter.SEARCH_CONTENT,
								  Filter.INVOKE_ASPECT,
								  Filter.GET_RATING};
		return filterMethods;
	}

}
