package org.wso2.developerstudio.eclipse.maven.util;

import java.util.HashMap;
import java.util.Map;


public class ProjectDependencyConstants {
	public static final Map<String, String> DEPENDENCY_MAP = new HashMap<String, String>();
    static {
        DEPENDENCY_MAP.put("${wsdl4j.version}", "1.6.2.wso2v4");
        DEPENDENCY_MAP.put("${neethi.version}", "2.0.4.wso2v4");
        DEPENDENCY_MAP.put("commons-collections", "3.2.0.wso2v1");
        DEPENDENCY_MAP.put("org.wso2.carbon.governance.registry.extensions", "4.2.0");
        DEPENDENCY_MAP.put("axis2", "1.6.1.wso2v6");
        DEPENDENCY_MAP.put("rampart-trust", "1.6.1.wso2v5");
        DEPENDENCY_MAP.put("jline", "0.9.94");
        DEPENDENCY_MAP.put("org.wso2.carbon.dataservices.core", "4.2.0");
        DEPENDENCY_MAP.put("ognl", "2.7.3");
        DEPENDENCY_MAP.put("geronimo-stax-api_1.0_spec", "1.0.1.wso2v2");
        DEPENDENCY_MAP.put("commons-lang", "2.6.0.wso2v1");
        DEPENDENCY_MAP.put("commons-httpclient", "3.1.0.wso2v2");
        DEPENDENCY_MAP.put("org.wso2.carbon.user.core", "4.2.0");
        DEPENDENCY_MAP.put("XmlSchema", "1.4.7.wso2v2");
        DEPENDENCY_MAP.put("json", "2.0.0.wso2v1");
        DEPENDENCY_MAP.put("rampart-core", "1.6.1.wso2v5");
        DEPENDENCY_MAP.put("abdera", "1.0.0.wso2v3");
        DEPENDENCY_MAP.put("snakeyaml", "1.6");
        DEPENDENCY_MAP.put("httpcore", "4.1.0.wso2v1");
        DEPENDENCY_MAP.put("opensaml2", "2.4.1.wso2v1");
        DEPENDENCY_MAP.put("rampart-policy", "1.6.1.wso2v5");
        DEPENDENCY_MAP.put("mvel2", "2.0.17");
        DEPENDENCY_MAP.put("axiom", "1.2.11.wso2v3");
        DEPENDENCY_MAP.put("synapse-core", "2.1.2.wso2v1");
        DEPENDENCY_MAP.put("jettison", "1.1.0.wso2v1");
        DEPENDENCY_MAP.put("woden", "1.0.0.M8-wso2v1");
        DEPENDENCY_MAP.put("commons-io", "2.0.0.wso2v2");
        DEPENDENCY_MAP.put("slf4j-api", "1.5.8");
        DEPENDENCY_MAP.put("org.wso2.carbon.authenticator.proxy", "4.2.0");
        DEPENDENCY_MAP.put("commons-codec", "1.4.0.wso2v1");
        DEPENDENCY_MAP.put("commons-logging", "1.1.1");
        DEPENDENCY_MAP.put("org.wso2.carbon.registry.core", "4.0.1");
        DEPENDENCY_MAP.put("joda-time", "1.6.0.wso2v1");
        DEPENDENCY_MAP.put("xstream", "1.2.2");
        DEPENDENCY_MAP.put("synapse-commons", "2.1.0-wso2v7");
        DEPENDENCY_MAP.put("synapse-tasks", "2.1.0-wso2v7");
        DEPENDENCY_MAP.put("synapse-nhttp-transport", "2.1.0-wso2v7");
    }
}
