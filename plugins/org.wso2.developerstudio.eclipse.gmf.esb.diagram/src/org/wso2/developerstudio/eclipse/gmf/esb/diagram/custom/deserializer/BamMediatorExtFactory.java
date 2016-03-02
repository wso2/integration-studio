/*
 * Copyright 2012 WSO2, Inc. (http://wso2.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.deserializer;

import java.util.Properties;

import javax.xml.namespace.QName;

import org.apache.axiom.om.OMAttribute;
import org.apache.axiom.om.OMElement;
import org.apache.commons.lang.StringUtils;
import org.apache.synapse.Mediator;
import org.apache.synapse.SynapseConstants;
import org.apache.synapse.config.xml.AbstractMediatorFactory;
import org.eclipse.core.runtime.Assert;
import org.wso2.carbon.mediator.bam.BamMediator;
import org.wso2.carbon.mediator.bam.config.stream.StreamConfiguration;

public class BamMediatorExtFactory extends AbstractMediatorFactory {

	public static final QName BAM_Q = new QName(SynapseConstants.SYNAPSE_NAMESPACE, "bam");

	public Mediator createSpecificMediator(OMElement omElement, Properties properties) {
		BamMediator bam = new BamMediator();
		if (StringUtils.isEmpty(this.getServerProfileName(omElement))) {
			handleException("BAM Mediator : Server Profile Name can not be empty");
		} else if (StringUtils.isEmpty(this.getStreamName(omElement))) {
			handleException("BAM Mediator : Stream Name can not be empty");
		} else if (StringUtils.isEmpty(this.getStreamVersion(omElement))) {
			handleException("BAM Mediator : Stream Version can not be empty");
		}
		bam.setServerProfile(this.getServerProfileName(omElement));
		bam.getStream().setStreamConfiguration(new StreamConfiguration());
		bam.getStream().getStreamConfiguration().setName(this.getStreamName(omElement));
		bam.getStream().getStreamConfiguration().setVersion(this.getStreamVersion(omElement));
		return bam;
	}

	public QName getTagQName() {
		return BAM_Q;
	}

	private String getServerProfileName(OMElement omElement) {
		OMElement serverProfileElement = omElement.getFirstChildWithName(new QName(
				SynapseConstants.SYNAPSE_NAMESPACE, "serverProfile"));

		if (serverProfileElement != null) {
			OMAttribute serverProfileAttr = serverProfileElement.getAttribute(new QName("name"));
			if (serverProfileAttr != null) {
				return serverProfileAttr.getAttributeValue();
			} else {
				return null;
			}
		}
		return null;
	}

	private String getStreamName(OMElement omElement) {

		OMElement serverProfileElement = omElement.getFirstChildWithName(new QName(
				SynapseConstants.SYNAPSE_NAMESPACE, "serverProfile"));

		if (serverProfileElement != null) {
			OMElement streamConfigElement = serverProfileElement.getFirstChildWithName(new QName(
					SynapseConstants.SYNAPSE_NAMESPACE, "streamConfig"));

			if (streamConfigElement != null) {
				OMAttribute streamNameAttr = streamConfigElement.getAttribute(new QName("name"));
				if (streamNameAttr != null) {
					return streamNameAttr.getAttributeValue();
				} else {
					return null;
				}
			}
			return null;
		}

		return null;
	}

	private String getStreamVersion(OMElement omElement) {

		OMElement serverProfileElement = omElement.getFirstChildWithName(new QName(
				SynapseConstants.SYNAPSE_NAMESPACE, "serverProfile"));

		if (serverProfileElement != null) {
			OMElement streamConfigElement = serverProfileElement.getFirstChildWithName(new QName(
					SynapseConstants.SYNAPSE_NAMESPACE, "streamConfig"));

			if (streamConfigElement != null) {
				OMAttribute streamVersionAttr = streamConfigElement.getAttribute(new QName(
						"version"));
				if (streamVersionAttr != null) {
					return streamVersionAttr.getAttributeValue();
				} else {
					return null;
				}
			}
			return null;
		}

		return null;
	}
}