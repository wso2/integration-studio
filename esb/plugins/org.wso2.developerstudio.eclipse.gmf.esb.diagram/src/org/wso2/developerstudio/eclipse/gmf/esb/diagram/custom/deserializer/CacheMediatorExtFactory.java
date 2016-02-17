package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.deserializer;

import java.util.Iterator;
import java.util.Properties;

import javax.xml.namespace.QName;

import org.apache.axiom.om.OMAttribute;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMNode;
import org.apache.synapse.Mediator;
import org.apache.synapse.SynapseException;
import org.apache.synapse.config.xml.CacheMediatorFactory;
import org.apache.synapse.mediators.builtin.CacheMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.custom.ClassMediatorExt;

public class CacheMediatorExtFactory extends CacheMediatorFactory {
    private static final QName ATT_GENERATOR = new QName("hashGenerator");

	public Mediator createSpecificMediator(OMElement elem, Properties properties) {

		CacheMediator cacheMediator = new CacheMediator();
		
		OMAttribute name = elem.getAttribute(ATT_GENERATOR);

		if (name != null) {
			org.wso2.caching.digest.DOMHASHGenerator domhashGenerator = new org.wso2.caching.digest.DOMHASHGenerator();
			cacheMediator.setDigestGenerator(domhashGenerator);
		}
		return cacheMediator;
	}
}