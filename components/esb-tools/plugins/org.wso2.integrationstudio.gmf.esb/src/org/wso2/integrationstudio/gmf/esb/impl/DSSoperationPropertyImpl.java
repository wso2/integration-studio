/**
 * Copyright 2009-2012 WSO2, Inc. (http://wso2.com)
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
package org.wso2.integrationstudio.gmf.esb.impl;

import org.eclipse.emf.ecore.EClass;

import org.wso2.integrationstudio.gmf.esb.DSSoperationProperty;
import org.wso2.integrationstudio.gmf.esb.EsbPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>DS Soperation Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class DSSoperationPropertyImpl extends AbstractNameValueExpressionPropertyImpl implements DSSoperationProperty {
    
    private String evaluator = null;
    
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected DSSoperationPropertyImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return EsbPackage.Literals.DS_SOPERATION_PROPERTY;
    }

    @Override
    public void setEvaluator(String evaluator) {
        this.evaluator = evaluator;
    }

    @Override
    public String getEvaluator() {
        return evaluator;
    }

} //DSSoperationPropertyImpl
