package org.wso2.developerstudio.eclipse.ds.wizards.util;

import org.eclipse.swt.widgets.Text;

public class ValidateUtil {

	public static boolean isTextNonEmpty(Text t) {
		String s = t.getText();
		if ((s != null) && (s.trim().length() > 0))
			return true;
		return false;
	}

}
