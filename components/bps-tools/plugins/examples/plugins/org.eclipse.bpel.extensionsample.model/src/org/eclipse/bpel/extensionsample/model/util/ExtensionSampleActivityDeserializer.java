package org.eclipse.bpel.extensionsample.model.util;

import java.util.Map;

import javax.wsdl.extensions.ExtensionRegistry;
import javax.xml.namespace.QName;

import org.eclipse.bpel.extensionsample.model.ModelFactory;
import org.eclipse.bpel.extensionsample.model.ModelPackage;
import org.eclipse.bpel.extensionsample.model.SampleSimpleActivity;
import org.eclipse.bpel.extensionsample.model.SampleStructuredActivity;
import org.eclipse.bpel.model.Activity;
import org.eclipse.bpel.model.Process;
import org.eclipse.bpel.model.extensions.BPELActivityDeserializer;
import org.eclipse.bpel.model.resource.BPELReader;
import org.eclipse.emf.common.util.URI;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ExtensionSampleActivityDeserializer implements BPELActivityDeserializer {

	@Override
	public Activity unmarshall(QName elementType, Node node, Process process, Map nsMap,
			ExtensionRegistry extReg, URI uri, BPELReader bpelReader) {

		/*
		 * SampleSimpleActivity
		 */
		if (ExtensionsampleConstants.ND_SAMPLE_SIMPLE_ACTIVITY.equals(elementType.getLocalPart())) {

			// create a new SampleSimpleActivity model object
			SampleSimpleActivity sampleSimpleActivity = ModelFactory.eINSTANCE
					.createSampleSimpleActivity();

			// attach the DOM node to our new activity
			sampleSimpleActivity.setElement((Element) node);

			// handle the SampleExtensionAttribute
			String attName = ModelPackage.eINSTANCE
					.getSampleSimpleActivity_SampleExtensionAttribute().getName();
			if (((Element) node).getAttribute(attName) != null) {
				sampleSimpleActivity.setSampleExtensionAttribute(((Element) node)
						.getAttribute(attName));
			}

			return sampleSimpleActivity;
		}

		/*
		 * SampleStructuredActivity
		 */
		if (ExtensionsampleConstants.ND_SAMPLE_STRUCTURED_ACTIVITY.equals(elementType
				.getLocalPart())) {

			Element sampleStructuredActivityElement = (Element) node;

			// create a new SampleStructuredActivity model object
			SampleStructuredActivity sampleStructuredActivity = ModelFactory.eINSTANCE
					.createSampleStructuredActivity();

			// attach the DOM node to our new activity
			sampleStructuredActivity.setElement(sampleStructuredActivityElement);

			// handle the child activity
			NodeList childElements = sampleStructuredActivityElement.getChildNodes();
			Element activityElement = null;
			if (childElements != null && childElements.getLength() > 0) {
				for (int i = 0; i < childElements.getLength(); i++) {

					// the only element node is the child activity
					if ((childElements.item(i).getNodeType() == Node.ELEMENT_NODE)) {
						activityElement = (Element) childElements.item(i);
						Activity activity = bpelReader.xml2Activity(activityElement);
						if (activity != null) {
							sampleStructuredActivity.setActivity(activity);
						}
					}
				}
			}

			return sampleStructuredActivity;
		}

		System.out.println("Cannot handle this kind of element");
		return null;
	}

}
