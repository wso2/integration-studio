/*
*  Copyright (c) 2018, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
*  WSO2 Inc. licenses this file to you under the Apache License,
*  Version 2.0 (the "License"); you may not use this file except
*  in compliance with the License.
*  You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing,
* software distributed under the License is distributed on an
* "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
* KIND, either express or implied.  See the License for the
* specific language governing permissions and limitations
* under the License.
*/

package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.deserializer;

import org.apache.axiom.om.OMAttribute;
import org.apache.axiom.om.OMComment;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMNode;
import org.apache.synapse.Mediator;
import org.apache.synapse.Nameable;
import org.apache.synapse.SynapseConstants;
import org.apache.synapse.SynapseException;
import org.apache.synapse.aspects.AspectConfigurable;
import org.apache.synapse.aspects.AspectConfiguration;
import org.apache.synapse.config.xml.AggregateMediatorFactory;
import org.apache.synapse.config.xml.AnnotatedCommandMediatorFactory;
import org.apache.synapse.config.xml.BeanMediatorFactory;
import org.apache.synapse.config.xml.CallMediatorFactory;
import org.apache.synapse.config.xml.CalloutMediatorFactory;
import org.apache.synapse.config.xml.ClassMediatorFactory;
import org.apache.synapse.config.xml.CloneMediatorFactory;
import org.apache.synapse.config.xml.CommentMediatorFactory;
import org.apache.synapse.config.xml.ConditionalRouterMediatorFactory;
import org.apache.synapse.config.xml.DBLookupMediatorFactory;
import org.apache.synapse.config.xml.DBReportMediatorFactory;
import org.apache.synapse.config.xml.DropMediatorFactory;
import org.apache.synapse.config.xml.EJBMediatorFactory;
import org.apache.synapse.config.xml.EnqueueMediatorFactory;
import org.apache.synapse.config.xml.EnrichMediatorFactory;
import org.apache.synapse.config.xml.FaultMediatorFactory;
import org.apache.synapse.config.xml.FilterMediatorFactory;
import org.apache.synapse.config.xml.ForEachMediatorFactory;
import org.apache.synapse.config.xml.HeaderMediatorFactory;
import org.apache.synapse.config.xml.InMediatorFactory;
import org.apache.synapse.config.xml.InvokeMediatorFactory;
import org.apache.synapse.config.xml.IterateMediatorFactory;
import org.apache.synapse.config.xml.LogMediatorFactory;
import org.apache.synapse.config.xml.LoopBackMediatorFactory;
import org.apache.synapse.config.xml.MediatorFactoryFinder;
import org.apache.synapse.config.xml.MessageStoreMediatorFactory;
import org.apache.synapse.config.xml.OutMediatorFactory;
import org.apache.synapse.config.xml.POJOCommandMediatorFactory;
import org.apache.synapse.config.xml.PayloadFactoryMediatorFactory;
import org.apache.synapse.config.xml.PropertyMediatorFactory;
import org.apache.synapse.config.xml.ResourceMapFactory;
import org.apache.synapse.config.xml.RespondMediatorFactory;
import org.apache.synapse.config.xml.SamplingThrottleMediatorFactory;
import org.apache.synapse.config.xml.SendMediatorFactory;
import org.apache.synapse.config.xml.SequenceMediatorFactory;
import org.apache.synapse.config.xml.SwitchMediatorFactory;
import org.apache.synapse.config.xml.SynapseMediatorFactory;
import org.apache.synapse.config.xml.SynapsePathFactory;
import org.apache.synapse.config.xml.TemplateMediatorFactory;
import org.apache.synapse.config.xml.TransactionMediatorFactory;
import org.apache.synapse.config.xml.URLRewriteMediatorFactory;
import org.apache.synapse.config.xml.ValidateMediatorFactory;
import org.apache.synapse.config.xml.ValueFactory;
import org.apache.synapse.config.xml.XMLConfigConstants;
import org.apache.synapse.config.xml.XSLTMediatorFactory;
import org.apache.synapse.config.xml.eventing.EventPublisherMediatorFactory;
import org.apache.synapse.mediators.builtin.CommentMediator;
import org.apache.synapse.mediators.builtin.DropMediator;
import org.apache.synapse.mediators.builtin.LogMediator;
import org.apache.synapse.mediators.builtin.PropertyMediator;
import org.apache.synapse.mediators.builtin.SendMediator;
import org.apache.synapse.mediators.builtin.ValidateMediator;
import org.jaxen.JaxenException;
import org.xml.sax.SAXException;
import org.apache.synapse.mediators.ListMediator;
import org.apache.synapse.mediators.Value;

import javax.xml.namespace.QName;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class DummyCreateMediator {

	/**
	 * SequenceMediatorFactory.class,
               
            SendMediatorFactory.class,
            FilterMediatorFactory.class,
            DropMediatorFactory.class,
            HeaderMediatorFactory.class,
            FaultMediatorFactory.class,
            PropertyMediatorFactory.class,
            SwitchMediatorFactory.class,
            InMediatorFactory.class,
            OutMediatorFactory.class,
            ClassMediatorFactory.class,
            ValidateMediatorFactory.class,
            XSLTMediatorFactory.class,
            AnnotatedCommandMediatorFactory.class,
            POJOCommandMediatorFactory.class,
            CloneMediatorFactory.class,
            IterateMediatorFactory.class,
            AggregateMediatorFactory.class,
            DBReportMediatorFactory.class,
            DBLookupMediatorFactory.class,
            CalloutMediatorFactory.class,
            EventPublisherMediatorFactory.class,
            TransactionMediatorFactory.class,
            EnqueueMediatorFactory.class,
            ConditionalRouterMediatorFactory.class,
            SamplingThrottleMediatorFactory.class,
            URLRewriteMediatorFactory.class,
            EnrichMediatorFactory.class,
            MessageStoreMediatorFactory.class,
            TemplateMediatorFactory.class,
            InvokeMediatorFactory.class,
            PayloadFactoryMediatorFactory.class,
            BeanMediatorFactory.class,
            EJBMediatorFactory.class,
            CallMediatorFactory.class,
            LoopBackMediatorFactory.class,
            RespondMediatorFactory.class,
            CommentMediatorFactory.class,
            ForEachMediatorFactory.class
	 */
	public Mediator createMediator(OMElement omElement, String localName) {
		Mediator mediator = null;
		if ("log".equals(localName)) {
			mediator = new LogMediator();
		 
			OMAttribute level = omElement.getAttribute(new QName("level"));
			OMAttribute category = omElement.getAttribute(new QName("category"));
			OMAttribute separator = omElement.getAttribute(new QName("separator"));
			
			if (level != null) {
	            String levelstr = level.getAttributeValue();
	            if ("simple".equals(levelstr)) {
	            	((LogMediator)mediator).setLogLevel(LogMediator.SIMPLE);
	            } else if ("headers".equals(levelstr)) {
	            	((LogMediator)mediator).setLogLevel(LogMediator.HEADERS);
	            } else if ("full".equals(levelstr)) {
	            	((LogMediator)mediator).setLogLevel(LogMediator.FULL);
	            } else if ("custom".equals(levelstr)) {
	            	((LogMediator)mediator).setLogLevel(LogMediator.CUSTOM);
	            } else {
	            	((LogMediator)mediator).setLogLevel(LogMediator.CUSTOM);
	            }
	        }
			if (category != null) {
	            String catstr = category.getAttributeValue().trim().toUpperCase();
	            if ("INFO".equals(catstr)) {
	            	((LogMediator)mediator).setCategory(LogMediator.CATEGORY_INFO);
	            } else if ("TRACE".equals(catstr)) {
	            	((LogMediator)mediator).setCategory(LogMediator.CATEGORY_TRACE);
	            } else if ("DEBUG".equals(catstr)) {
	            	((LogMediator)mediator).setCategory(LogMediator.CATEGORY_DEBUG);
	            } else if ("WARN".equals(catstr)) {
	            	((LogMediator)mediator).setCategory(LogMediator.CATEGORY_WARN);
	            } else if ("ERROR".equals(catstr)) {
	            	((LogMediator)mediator).setCategory(LogMediator.CATEGORY_ERROR);
	            } else if ("FATAL".equals(catstr)) {
	            	((LogMediator)mediator).setCategory(LogMediator.CATEGORY_FATAL);
	            } else {
	            	((LogMediator)mediator).setCategory(LogMediator.CATEGORY_DEBUG);
	            }
	        }
			if (separator != null) {
				((LogMediator)mediator).setSeparator(separator.getAttributeValue());
			}
			
		} else if ("send".equals(localName)) {
			mediator = new SendMediator();
			
		} else if ("drop".equals(localName)) {
			mediator = new DropMediator();
			
		} else if ("property".equals(localName)) {
			mediator = new PropertyMediator();
			
		} else if ("validate".equals(localName)) {
			QName VALIDATE_Q = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "validate");
		    QName ON_FAIL_Q  = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "on-fail");
		    QName SCHEMA_Q   = new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "schema");
		    QName ATT_CACHE_SCHEMA = new QName("cache-schema");
		    
			mediator = new ValidateMediator();
			
			List<Value> schemaKeys = new ArrayList<Value>();
	        Iterator schemas = omElement.getChildrenWithName(SCHEMA_Q);

	        while (schemas.hasNext()) {
	            Object o = schemas.next();
	            if (o instanceof OMElement) {
	                OMElement omElem = (OMElement) o;
	                OMAttribute keyAtt = omElem.getAttribute(new QName("key"));
	                if (keyAtt != null) {
	                    // ValueFactory for creating dynamic or static Value
	                    ValueFactory keyFac = new ValueFactory();
	                    // create dynamic or static key based on OMElement
	                    Value generatedKey = keyFac.createValue(XMLConfigConstants.KEY, omElem);
	                    schemaKeys.add(generatedKey);
	                }
	            }
	        }

	        if (schemaKeys.size() != 0) {
	        	((ValidateMediator)mediator).setSchemaKeys(schemaKeys);
	        }

	        // process source XPath attribute if present
	        OMAttribute attSource = omElement.getAttribute(new QName("source"));

	        if (attSource != null) {
	            try {
	                if (attSource.getAttributeValue() != null) {
	                	((ValidateMediator)mediator).setSource(SynapsePathFactory.getSynapsePath(omElement, new QName("source")));
	                }
	            } catch (JaxenException e) {
	                //ignore
	            }
	        }

	        OMAttribute attSchemaCache = omElement.getAttribute(ATT_CACHE_SCHEMA);
	        if (attSchemaCache != null) {
	            final boolean cacheSchema = Boolean.parseBoolean(attSchemaCache.getAttributeValue());
	            ((ValidateMediator)mediator).setCacheSchema(cacheSchema);
	        }

	        //process external schema resources
	        ((ValidateMediator)mediator).setResourceMap(ResourceMapFactory.createResourceMap(omElement));

	        // process on-fail
	        OMElement onFail = null;
	        Iterator iterator = omElement.getChildrenWithName(ON_FAIL_Q);
	        if (iterator.hasNext()) {
	            onFail = (OMElement)iterator.next();
	        }

	        if (onFail != null && onFail.getChildElements().hasNext()) {
	        	addChildren(onFail, (ValidateMediator)mediator, null);
	        }

	        // after successfully creating the mediator
	        // set its common attributes such as tracing etc
	        processAuditStatus(mediator, omElement);
	        // set the features
	        for (Map.Entry<String,String> entry : collectNameValuePairs(omElement, new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "feature")).entrySet()) {
	            String value = entry.getValue();
	            boolean isFeatureEnabled = true;
	            if ("true".equals(value)) {
	                isFeatureEnabled = true;
	            } else if ("false".equals(value)) {
	                isFeatureEnabled = false;
	            }
	            try {
	            	((ValidateMediator)mediator).addFeature(entry.getKey(), isFeatureEnabled);
	            } catch (SAXException e) {
	               //ignore
	            }
	        }
		}
		
		if (mediator == null) {
			throw new SynapseException("No such mediator.");
		}
		return mediator;
	}
	
	private void addChildren(OMElement el, ListMediator m, Properties properties) {
        Iterator it = el.getChildren();

        while (it.hasNext()) {
            OMNode child = (OMNode) it.next();
            if (child instanceof OMElement) {
                if (!new QName(XMLConfigConstants.SYNAPSE_NAMESPACE, "description").equals(((OMElement) child).getQName())) {
                    Mediator med = MediatorFactoryFinder.getInstance().getMediator((OMElement) child, properties);
                    if (med != null) {
                        m.addChild(med);
                    } else {
                        String msg = "Unknown mediator : " + ((OMElement) child).getLocalName();
                        throw new SynapseException(msg);
                    }
                }
            } else if (child instanceof OMComment) {
                CommentMediator commendMediator = new CommentMediator();
                commendMediator.setCommentText(((OMComment) child).getValue());
                m.addChild(commendMediator);
            }
        }
    }
	
    private void processAuditStatus(Mediator mediator, OMElement mediatorOmElement) {

        String name = null;
        if (mediator instanceof Nameable) {
            name = ((Nameable) mediator).getName();
        }
        if (name == null || "".equals(name)) {
            name = SynapseConstants.ANONYMOUS_SEQUENCE;
        }

        if (mediator instanceof AspectConfigurable) {
            AspectConfiguration configuration = new AspectConfiguration(name);
            ((AspectConfigurable) mediator).configure(configuration);

            OMAttribute statistics = mediatorOmElement.getAttribute(new QName(XMLConfigConstants.STATISTICS_ATTRIB_NAME));
            if (statistics != null) {
                String statisticsValue = statistics.getAttributeValue();
                if (statisticsValue != null) {
                    if (XMLConfigConstants.STATISTICS_ENABLE.equals(statisticsValue)) {
                        configuration.enableStatistics();
                    }
                }
            }

            OMAttribute trace = mediatorOmElement.getAttribute(
                    new QName(XMLConfigConstants.NULL_NAMESPACE, XMLConfigConstants.TRACE_ATTRIB_NAME));
            if (trace != null) {
                String traceValue = trace.getAttributeValue();
                if (traceValue != null) {
                    if (traceValue.equals(XMLConfigConstants.TRACE_ENABLE)) {
                        configuration.enableTracing();
                    }
                }
            }
        }
    }
    
    protected Map<String, String> collectNameValuePairs(OMElement elem, QName childElementName) {
        Map<String,String> result = new LinkedHashMap<String, String>();
        for (Iterator it = elem.getChildrenWithName(childElementName); it.hasNext(); ) {
            OMElement child = (OMElement)it.next();
            OMAttribute attName = child.getAttribute(new QName("name"));
            OMAttribute attValue = child.getAttribute(new QName("value"));
            if (attName != null && attValue != null) {
                String name = attName.getAttributeValue().trim();
                String value = attValue.getAttributeValue().trim();
                if (!result.containsKey(name)) {
                	result.put(name, value);
                }
            }
        }
        return result;
    }

}
