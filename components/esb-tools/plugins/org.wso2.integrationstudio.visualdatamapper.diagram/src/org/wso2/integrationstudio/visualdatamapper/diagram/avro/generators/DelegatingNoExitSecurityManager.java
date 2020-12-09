/*
 * Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.integrationstudio.visualdatamapper.diagram.avro.generators;

import java.io.FileDescriptor;
import java.net.InetAddress;
import java.security.Permission;

/**
 *
 * Allows for the capture of calls to System.exit(0).
 * The call is 'converted' to a known Exception type which can be caught and dealt with.
 * We also explicitly allow replacing this security manager (presumably back with the
 * older one). All other methods are directly delegated to the delegate security manager
 * (again, presumably the older one).
 *
 * Usages of this class should be TEMPORARY and handled with GREAT CARE.
 * You have been warned!
 */
public class DelegatingNoExitSecurityManager extends SecurityManager {
	private final SecurityManager delegate;
	public static final class NormalExitException extends RuntimeException { }

	DelegatingNoExitSecurityManager(SecurityManager delegate) {
		this.delegate = delegate;
	}

	/*
		Prevent System.exit(0).
	 */
	@Override
	public void checkExit(int status) {
		if (status == 0) {
			throw new NormalExitException();
		}
		
		if (delegate != null) {
			delegate.checkExit(status);
		}
	}

	/*
		Allow replacement of this security manager.
	 */
	@Override
	public void checkPermission(Permission perm) {
		if ("setSecurityManager".equals(perm.getName())) {
			return;
		}

		if (delegate != null) {
			delegate.checkPermission(perm);
		}
	}

	@Override
	public void checkCreateClassLoader() {
		if (delegate != null) {
			delegate.checkCreateClassLoader();
		}
	}

	@Override
	public void checkAccess(Thread t) {
		if (delegate != null) {
			delegate.checkAccess(t);
		}		
	}

	@Override
	public void checkAccess(ThreadGroup g) {
		if (delegate != null) {
			delegate.checkAccess(g);
		}		
	}

	@Override
	public void checkExec(String cmd) {
		if (delegate != null) {
			delegate.checkExec(cmd);
		}	
	}

	@Override
	public void checkLink(String lib) {
		if (delegate != null) {
			delegate.checkLink(lib);
		}		
	}

	@Override
	public void checkRead(FileDescriptor fd) {
		if (delegate != null) {
			delegate.checkRead(fd);
		}		
	}

	@Override
	public void checkRead(String file) {
		if (delegate != null) {
			delegate.checkRead(file);
		}
	}

	@Override
	public void checkRead(String file, Object context) {
		if (delegate != null) {
			delegate.checkRead(file, context);
		}		
	}

	@Override
	public void checkWrite(FileDescriptor fd) {
		if (delegate != null) {
			delegate.checkWrite(fd);
		}		
	}

	@Override
	public void checkWrite(String file) {
		if (delegate != null) {
			delegate.checkWrite(file);
		}	
	}

	@Override
	public void checkDelete(String file) {
		if (delegate != null) {
			delegate.checkDelete(file);
		}
	}

	@Override
	public void checkConnect(String host, int port) {
		if (delegate != null) {
			delegate.checkConnect(host, port);
		}
	}

	@Override
	public void checkConnect(String host, int port, Object context) {
		if (delegate != null) {
			delegate.checkConnect(host, port, context);
		}
	}

	@Override
	public void checkListen(int port) {
		if (delegate != null) {
			delegate.checkListen(port);
		}
	}

	@Override
	public void checkAccept(String host, int port) {
		if (delegate != null) {
			delegate.checkAccept(host, port);
		}
	}

	@Override
	public void checkMulticast(InetAddress maddr) {
		if (delegate != null) {
			delegate.checkMulticast(maddr);
		}
	}

	@Override
	public void checkPropertiesAccess() {
		if (delegate != null) {
			delegate.checkPropertiesAccess();
		}
	}

	@Override
	public void checkPropertyAccess(String key) {
		if (delegate != null) {
			delegate.checkPropertyAccess(key);
		}
	}

	@Override
	public boolean checkTopLevelWindow(Object window) {
		if (delegate != null) {
			return delegate.checkTopLevelWindow(window);
		} else {
			return super.checkTopLevelWindow(window);
		}
	}

	@Override
	public void checkPrintJobAccess() {
		if (delegate != null) {
			delegate.checkPrintJobAccess();
		}
	}

	@Override
	public void checkSystemClipboardAccess() {
		if (delegate != null) {
			delegate.checkSystemClipboardAccess();
		}
	}

	@Override
	public void checkAwtEventQueueAccess() {
		if (delegate != null) {
			delegate.checkAwtEventQueueAccess();
		}
	}

	@Override
	public void checkPackageAccess(String pkg) {
		if (delegate != null) {
			delegate.checkPackageAccess(pkg);
		}
	}

	@Override
	public void checkPackageDefinition(String pkg) {
		if (delegate != null) {
			delegate.checkPackageDefinition(pkg);
		}
	}

	@Override
	public void checkSetFactory() {
		if (delegate != null) {
			delegate.checkSetFactory();
		}
	}

	@Override
	public void checkMemberAccess(Class<?> clazz, int which) {
		if (delegate != null) {
			delegate.checkMemberAccess(clazz, which);
		}
	}

	@Override
	public void checkSecurityAccess(String target) {
		if (delegate != null) {
			delegate.checkSecurityAccess(target);
		}
	}
}
