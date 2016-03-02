/*
 * Copyright (C) WSO2, Inc. (http://wso2.com)
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

package org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.custom;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.synapse.MessageContext;
import org.apache.synapse.message.MessageConsumer;
import org.apache.synapse.message.MessageProducer;
import org.apache.synapse.message.store.AbstractMessageStore;

public class DummyMessageStore extends AbstractMessageStore {
	private String className;

	@Override
	public void setName(String name) {
		this.name = name;
	}

	public void clear() {

	}

	public MessageContext get(int id) {
		return null;
	}

	public MessageContext get(String id) {
		return null;
	}

	public List<MessageContext> getAll() {
		return new ArrayList<MessageContext>();
	}

	public boolean offer(MessageContext mc) {
		return false;
	}

	public MessageContext peek() {
		return null;
	}

	public MessageContext poll() {
		return null;
	}

	public MessageContext remove() throws NoSuchElementException {
		return null;
	}

	public MessageContext remove(String mc) {
		return null;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public int getType() {
		// TODO Auto-generated method stub
		return 0;
	}

	public MessageConsumer newConsumer() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public MessageConsumer getConsumer() {
		// TODO Auto-generated method stub
		return null;
	}

	public MessageProducer getProducer() {
		// TODO Auto-generated method stub
		return null;
	}

}
