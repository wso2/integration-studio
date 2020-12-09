package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.cloudconnector;

import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;

import org.apache.axiom.om.OMElement;
import org.wso2.developerstudio.eclipse.platform.core.manifest.AbstractXMLDoc;

public class ComponentIsDynamic extends AbstractXMLDoc {

    private List<SubComponents> subComponents = new ArrayList<SubComponents>();

    public List<SubComponents> getSubComponents() {
        return subComponents;
    }

    public void setSubComponents(List<SubComponents> subComponents) {
        this.subComponents = subComponents;
    }

    @Override
    protected void deserialize(OMElement documentElement) throws Exception {
        List<OMElement> artifactsElements = getChildElements(documentElement, "subComponents");
        for (OMElement omElement : artifactsElements) {
            List<OMElement> artifactElements = getChildElements(omElement, "component");
            for (OMElement omElement2 : artifactElements) {
                if (omElement2.getChildrenWithLocalName("isDynamic").hasNext()) {
                    OMElement isDynamicElement = (OMElement) omElement2.getChildrenWithLocalName("isDynamic").next();
                    SubComponents artifactDependency = new SubComponents(
                            omElement2.getAttributeValue(new QName("name")), isDynamicElement.getText());
                    subComponents.add(artifactDependency);
                }
            }
        }
    }

    @Override
    protected String serialize() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected String getDefaultName() {
        // TODO Auto-generated method stub
        return null;
    }

}