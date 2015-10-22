/*
 * Copyright (c) 2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.developerstudio.eclipse.registry.manager.remote.dragdrop;

import java.util.ArrayList;

public class Queue {

	private ArrayList<Object> queueArrayList;
	private int front;
	private int rear;
	private int count;

	public Queue() {
		queueArrayList = new ArrayList<Object>();
		front = 0;
		rear = -1;
		count = 0;

	}

	public void instert(Object item) {
		queueArrayList.add(item);
		count++;

		this.rear = this.rear + 1;
		if (this.rear >= this.queueArrayList.size()) {
			this.rear = 0;
		}

	}

	public Object remove() throws Exception {
		Object item = null;
		if (this.isEmpty()) {
			throw new Exception("Queue is empty !");
		} else {
			item = this.queueArrayList.get(this.front);
			this.count--;

			this.front = this.front + 1;

		}
		return item;
	}

	public boolean isEmpty() {
		return (count == 0);
	}

	public int count() {
		return this.count;
	}
}
