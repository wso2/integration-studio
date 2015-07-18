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

package org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence;

import org.apache.synapse.mediators.base.SequenceMediator;
import org.eclipse.core.runtime.Assert;
import org.wso2.developerstudio.eclipse.gmf.esb.DBReportMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformationInfo;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformerException;

/**
 * DBReport mediator transformer 
 *
 */
public class DBReportMediatorTransformer extends AbstractDBMediatorTransformer {

	public void transform(TransformationInfo information, EsbNode subject) throws TransformerException {

		information.getParentSequence().addChild(createDBReportMediator(subject));
		doTransform(information, ((DBReportMediator) subject).getOutputConnector());

	}

	public void transformWithinSequence(TransformationInfo information,
			EsbNode subject, SequenceMediator sequence) throws TransformerException {
		sequence.addChild(createDBReportMediator(subject));
		doTransformWithinSequence(information,((DBReportMediator) subject).getOutputConnector().getOutgoingLink(),sequence);
		
	}
	
	private org.apache.synapse.mediators.db.DBReportMediator createDBReportMediator(EsbNode subject){
		
		Assert.isTrue(subject instanceof DBReportMediator,"Unsupported mediator passed in for serialization.");
		DBReportMediator visualDBReport =(DBReportMediator)subject;
		
		org.apache.synapse.mediators.db.DBReportMediator dbReportMediator=new org.apache.synapse.mediators.db.DBReportMediator();
		transformDBMediator(dbReportMediator,visualDBReport);
		dbReportMediator.setUseTransaction(visualDBReport.isConnectionUseTransaction());
		
		return dbReportMediator;
	}

}
