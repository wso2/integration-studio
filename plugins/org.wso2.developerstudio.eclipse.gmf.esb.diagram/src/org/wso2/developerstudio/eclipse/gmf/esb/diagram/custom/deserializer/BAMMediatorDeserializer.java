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

import org.apache.synapse.mediators.AbstractMediator;
import org.eclipse.core.runtime.Assert;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.BAMMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;
import org.wso2.carbon.mediator.bam.BamMediator;
import org.wso2.carbon.mediator.bam.Stream;

import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.*;

public class BAMMediatorDeserializer extends
		AbstractEsbNodeDeserializer<AbstractMediator, BAMMediator> {

	@Override
	public BAMMediator createNode(IGraphicalEditPart part, AbstractMediator object) {
		Assert.isTrue(object instanceof BamMediator,
				"Unsupported mediator passed in for deserialization");
		BamMediator mediator = (BamMediator) object;

		BAMMediator mediatorModel = (BAMMediator) DeserializerUtils.createNode(part,
				EsbElementTypes.BAMMediator_3680);
		setElementToEdit(mediatorModel);
		setCommonProperties(mediator, mediatorModel);

		executeSetValueCommand(BAM_MEDIATOR__SERVER_PROFILE, mediator.getServerProfile());

		Stream stream = mediator.getStream();
		if (stream != null) {
			executeSetValueCommand(BAM_MEDIATOR__STREAM_NAME, stream.getStreamConfiguration().getName());
			executeSetValueCommand(BAM_MEDIATOR__STREAM_VERSION, stream.getStreamConfiguration().getVersion());
		}

		return mediatorModel;
	}

}
