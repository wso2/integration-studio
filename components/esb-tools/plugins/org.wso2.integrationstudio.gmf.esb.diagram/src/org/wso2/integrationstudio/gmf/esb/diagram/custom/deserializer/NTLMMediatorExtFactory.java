package org.wso2.integrationstudio.gmf.esb.diagram.custom.deserializer;

import org.apache.synapse.config.xml.NTLMMediatorFactory;

public class NTLMMediatorExtFactory extends NTLMMediatorFactory {

    private static NTLMMediatorExtFactory instanceFactory;

    public static NTLMMediatorExtFactory getInstance() {
        if (instanceFactory == null) {
            instanceFactory = new NTLMMediatorExtFactory();
        }
        return instanceFactory;
    }

}
