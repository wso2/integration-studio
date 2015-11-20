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

import org.apache.synapse.config.Entry;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.LocalEntry;
import org.wso2.developerstudio.eclipse.gmf.esb.LocalEntryValueType;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;
import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.*;
import static org.apache.synapse.config.Entry.*;

public class LocalEntryDeserializer extends AbstractEsbNodeDeserializer<Entry, LocalEntry> {

	@Override
	public LocalEntry createNode(IGraphicalEditPart part, Entry entry) {
		LocalEntry localEntry = (LocalEntry) DeserializerUtils.createNode(part,
				EsbElementTypes.LocalEntry_3663);
		setElementToEdit(localEntry);

		executeSetValueCommand(LOCAL_ENTRY__ENTRY_NAME, entry.getKey());

		if (entry.getType() == URL_SRC) {
			executeSetValueCommand(LOCAL_ENTRY__LOCAL_ENTRY_TYPE, LocalEntryValueType.URL);
			executeSetValueCommand(LOCAL_ENTRY__VALUE_URL, entry.getSrc().toString());
		} else if (entry.getType() == INLINE_XML) {
			executeSetValueCommand(LOCAL_ENTRY__LOCAL_ENTRY_TYPE, LocalEntryValueType.XML);
			executeSetValueCommand(LOCAL_ENTRY__VALUE_XML, entry.getValue().toString());
		} else if (entry.getType() == INLINE_TEXT){
			executeSetValueCommand(LOCAL_ENTRY__LOCAL_ENTRY_TYPE, LocalEntryValueType.LITERAL);
			executeSetValueCommand(LOCAL_ENTRY__VALUE_LITERAL, entry.getValue().toString());
		} else{
			/* REMOTE_ENTRY? nothing to do */
		}

		return localEntry;
	}

}
