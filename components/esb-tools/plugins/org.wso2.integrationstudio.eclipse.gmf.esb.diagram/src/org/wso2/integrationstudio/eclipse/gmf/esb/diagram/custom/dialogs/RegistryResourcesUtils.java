package org.wso2.integrationstudio.gmf.esb.diagram.custom.dialogs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.wso2.integrationstudio.platform.core.interfaces.IIntegrationStudioProvider;
import org.wso2.integrationstudio.platform.core.interfaces.IIntegrationStudioProviderData;
import org.wso2.integrationstudio.registry.core.RegistryManager;
import org.wso2.integrationstudio.registry.core.interfaces.IRegistryFile;

public class RegistryResourcesUtils {

    public static IIntegrationStudioProviderData[] loadProviderProjectsList(Class<?>[] type) {
        List<Object> list = new ArrayList<Object>();
        List<Class<?>> typesList = Arrays.asList(type);

        if (typesList.contains(IRegistryFile.class)) {
            list.addAll(Arrays.asList(RegistryManager.getResourceProviders(true)));
        }

        return list.toArray(new IIntegrationStudioProviderData[] {});
    }

    public static List<IIntegrationStudioProvider> getRegistryProjectsList(IIntegrationStudioProvider provider,
            Map<String, List<String>> filters) {
        List<IIntegrationStudioProvider> list = new ArrayList<IIntegrationStudioProvider>();
        IIntegrationStudioProvider[] categories = provider.getCategories(filters);
        if (categories != null) {
            list.addAll(Arrays.asList(categories));
        }

        return list;
    }

    public static List<IIntegrationStudioProvider> getChildrenList(IIntegrationStudioProvider provider,
            Map<String, List<String>> filters) {
        List<IIntegrationStudioProvider> list = new ArrayList<IIntegrationStudioProvider>();

        /* Get sub categories of registry project */
        IIntegrationStudioProvider[] resources = provider.getCategories(filters);
        if (resources != null) {
            list.addAll(Arrays.asList(resources));
        }

        return list;
    }
}
