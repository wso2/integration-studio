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

package org.wso2.developerstudio.eclipse.esb.presentation;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.wst.sse.ui.internal.reconcile.validator.ISourceValidator;
import org.eclipse.wst.validation.internal.core.ValidationException;
import org.eclipse.wst.validation.internal.provisional.core.IReporter;
import org.eclipse.wst.validation.internal.provisional.core.IValidationContext;
import org.eclipse.wst.validation.internal.provisional.core.IMessage;
import org.eclipse.wst.validation.internal.provisional.core.IValidator;
import java.util.Locale;
import org.eclipse.core.resources.IResource;
import org.eclipse.wst.validation.internal.core.Message;



@SuppressWarnings("restriction")
public class SourceValidator implements ISourceValidator , IValidator {
	IDocument document = null;
	
	public void connect(IDocument document) {
		this.document = document;

	}

	
	public void disconnect(IDocument document) {
		this.document = null;

	}

	
    public void validate(IRegion dirtyRegion, IValidationContext helper, IReporter reporter) {
		/* TODO: implement source validation logic */
	    
    }

	
    public void cleanup(IReporter reporter) {
	    
    }

	
    public void validate(IValidationContext helper, IReporter reporter) throws ValidationException {
		/* TODO: implement source validation logic
	    IMessage m = new LocalizedMessage(IMessage.HIGH_SEVERITY, "");
		m.setOffset(2);
		m.setLength("this is a test".length());
		try {
			m.setLineNo( 1);
		}
		catch (Exception e) {
			m.setLineNo(-1);
		}
		reporter.addMessage(this, m);
		*/
    }
	
	protected class LocalizedMessage extends Message {

		private String _message = null;

		public LocalizedMessage(int severity, String messageText) {
			this(severity, messageText, null);
		}

		public LocalizedMessage(int severity, String messageText, IResource targetObject) {
			this(severity, messageText, (Object) targetObject);
		}

		public LocalizedMessage(int severity, String messageText, Object targetObject) {
			super(null, severity, null);
			setLocalizedMessage(messageText);
			setTargetObject(targetObject);
		}

		public void setLocalizedMessage(String message) {
			_message = message;
		}

		public String getLocalizedMessage() {
			return _message;
		}

		public String getText() {
			return getLocalizedMessage();
		}

		public String getText(ClassLoader cl) {
			return getLocalizedMessage();
		}

		public String getText(Locale l) {
			return getLocalizedMessage();
		}

		public String getText(Locale l, ClassLoader cl) {
			return getLocalizedMessage();
		}
	}

}
