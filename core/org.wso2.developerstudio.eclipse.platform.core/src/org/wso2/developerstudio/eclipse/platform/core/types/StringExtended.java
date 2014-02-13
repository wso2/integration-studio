package org.wso2.developerstudio.eclipse.platform.core.types;

import java.util.Observable;

public class StringExtended extends Observable {
	private String value;

	public void value(String stringValue) {
		if (stringValue == null && value() == null) {
			return;
		}
		if ((stringValue != null && !stringValue.equals(value()))
				|| (value() != null && !value().equals(stringValue))) {
			this.value = stringValue;
			setChanged();
			notifyObservers();
		}
	}

	public String value() {
		return value;
	}

	
	public String toString() {
		return value();
	}
}
