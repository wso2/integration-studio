/**
 * <copyright>
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 * </copyright>
 *
 * $Id: Empty.java,v 1.2 2007/08/01 21:02:31 mchmielewski Exp $
 */
package org.eclipse.bpel.model;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Empty</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A "no-op" instruction useful as the target for synchronization of parallel activities, for instance. Empty is also required in situations that require at least one Activity, but there is nothing to do. This may often occur in fault handlers.
 * 
 * <!-- end-model-doc -->
 *
 *
 * @see org.eclipse.bpel.model.BPELPackage#getEmpty()
 * @model
 * @generated
 */
public interface Empty extends Activity {
} // Empty
