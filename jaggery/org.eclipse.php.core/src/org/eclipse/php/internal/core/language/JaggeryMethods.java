package org.eclipse.php.internal.core.language;

import org.eclipse.php.internal.core.PHPVersion;

public class JaggeryMethods {

	private final static String[] JAGGERY_METHODS = {
			"del", "get", "include", "include_once", "parse", "post", "put", "require", "stringify" }; //$NON-NLS-1$ //$NON-NLS-2$

	public static String[] getMethods(PHPVersion phpVersion) {
		return JAGGERY_METHODS; // for now the variables set is the same for
								// all
								// PHP versions
	}

}
