package org.wso2.developerstudio.eclipse.platform.core.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.wso2.developerstudio.eclipse.platform.core.MediaManager;

public class DeveloperStudioProviderUtils {
	public static void addFilter(Map<String, List<String>> filters,String filterId, String filterValue){
		if (!filters.containsKey(filterId)){
			filters.put(filterId, new ArrayList<String>());
		}
		List<String> list = getFilterValues(filters, filterId);
		list.add(filterValue);
	}
	
	public static boolean isFilterPresent(Map<String,List<String>> filters,String filterId){
		if (filters.containsKey(filterId)){
			return getFilterValues(filters, filterId).size()>0;
		}else{
			return false;
		}
		
	}

	public static List<String> getFilterValues(
			Map<String, List<String>> filters, String filterId) {
		List<String> list = filters.get(filterId);
		return list;
	}
	
	public static boolean isInProjectFilterPassed(Map<String, List<String>> filters,
			IResource registryResource){
		boolean passed=true;
		if (DeveloperStudioProviderUtils.isFilterPresent(filters,CSProviderConstants.FILTER_PROJECT)) {
			String projectName = registryResource.getProject().getName();
			passed=false;
			List<String> filterValues = DeveloperStudioProviderUtils.getFilterValues(filters,CSProviderConstants.FILTER_PROJECT);
			for (String filter : filterValues) {
				if (filter.equals(projectName)){
					passed=true;
					break;
				}
			}
		}
		return passed;
	}

	public static boolean isMediaTypeFilterPassed(
			Map<String, List<String>> filters, IFile workspaceFile){
		File file = workspaceFile.getLocation().toFile();
		return isMediaTypeFilterPassed(filters, file);
	}

	public static boolean isMediaTypeFilterPassed(
			Map<String, List<String>> filters, File file){
		boolean passed = true;
		try {
			if (DeveloperStudioProviderUtils.isFilterPresent(filters,
					CSProviderConstants.FILTER_MEDIA_TYPE)) {
				String mediaType = MediaManager.getMediaType(file);
				passed = DeveloperStudioProviderUtils.isMediaTypeFilterPassed(filters, mediaType);
			}
		} catch (Exception e) {
			passed=false;
		}
		return passed;
	}
	
	public static boolean isMediaTypeFilterPassed(
			Map<String, List<String>> filters, String mediaType) {
		boolean passed=true;
		if (DeveloperStudioProviderUtils.isFilterPresent(filters,
				CSProviderConstants.FILTER_MEDIA_TYPE)) {
			passed = false;
			if (mediaType != null) {
				List<String> filterValues = DeveloperStudioProviderUtils
						.getFilterValues(filters,
								CSProviderConstants.FILTER_MEDIA_TYPE);
				for (String filter : filterValues) {
					if (filter.equalsIgnoreCase(mediaType)) {
						passed = true;
						break;
					}
				}
			}
		}
		return passed;
	}

}
