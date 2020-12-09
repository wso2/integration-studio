package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.dialogs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.wso2.developerstudio.eclipse.platform.core.interfaces.IDeveloperStudioProvider;
import org.wso2.developerstudio.eclipse.platform.core.interfaces.IDeveloperStudioProviderData;
import org.wso2.developerstudio.eclipse.registry.core.RegistryManager;
import org.wso2.developerstudio.eclipse.registry.core.interfaces.IRegistryFile;

public class RegistryResourcesUtils {

    public static IDeveloperStudioProviderData[] loadProviderProjectsList(Class<?>[] type) {
        List<Object> list = new ArrayList<Object>();
        List<Class<?>> typesList = Arrays.asList(type);

        if (typesList.contains(IRegistryFile.class)) {
            list.addAll(Arrays.asList(RegistryManager.getResourceProviders(true)));
        }

        return list.toArray(new IDeveloperStudioProviderData[] {});
    }

    public static List<IDeveloperStudioProvider> getRegistryProjectsList(IDeveloperStudioProvider provider,
            Map<String, List<String>> filters) {
        List<IDeveloperStudioProvider> list = new ArrayList<IDeveloperStudioProvider>();
        IDeveloperStudioProvider[] categories = provider.getCategories(filters);
        if (categories != null) {
            list.addAll(Arrays.asList(categories));
        }

        return list;
    }

    public static List<IDeveloperStudioProvider> getChildrenList(IDeveloperStudioProvider provider,
            Map<String, List<String>> filters) {
        List<IDeveloperStudioProvider> list = new ArrayList<IDeveloperStudioProvider>();

        /* Get sub categories of registry project */
        IDeveloperStudioProvider[] resources = provider.getCategories(filters);
        if (resources != null) {
            list.addAll(Arrays.asList(resources));
        }

        return list;
    }
}
