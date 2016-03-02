/*
 * Copyright (c) 2013, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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


package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.sheet;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.gmf.runtime.emf.ui.properties.sections.UndoableModelPropertySheetEntry;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource;



public class EsbCustomPropertySheetEntry extends UndoableModelPropertySheetEntry {

	public EsbCustomPropertySheetEntry(IOperationHistory operationHistory) {
		super(operationHistory);
	}
	
	/**
	    * Overrides the super method to avoid ordering attributes, and so keep the
	    * order defined in the ecore model.
	    * 
	    * @return sorted <code>List</code> of all the <code>IPropertyDescriptor</code>s for the objects 
	    */
   protected List computeMergedPropertyDescriptors() {
      if (values.length == 0)
         return new ArrayList(0);

      // get all descriptors from each object
      Map[] propertyDescriptorMaps = new Map[values.length];
      for (int i = 0; i < values.length; i++) {
         Object object = values[i];
         IPropertySource source = getPropertySource(object);
         if (source == null) {
            // if one of the selected items is not a property source
            // then we show no properties
            return new ArrayList(0);
         }
         // get the property descriptors keyed by id
         propertyDescriptorMaps[i] = computePropertyDescriptorsFor(source);
      }

      // intersect
      Map intersection = propertyDescriptorMaps[0];
      for (int i = 1; i < propertyDescriptorMaps.length; i++) {
         // get the current ids
         Object[] ids = intersection.keySet().toArray();
         for (int j = 0; j < ids.length; j++) {
            Object object = propertyDescriptorMaps[i].get(ids[j]);
            if (object == null ||
            // see if the descriptors (which have the same id) are
                  // compatible
               !((IPropertyDescriptor) intersection.get(ids[j])).isCompatibleWith((IPropertyDescriptor) object))
               intersection.remove(ids[j]);
         }
      }

	      // Sort the descriptors
	  List descriptors = new ArrayList(intersection.values());

	  ////////////////////////////////////////////////////////////////////////
	      // Commented to avoid alphabetically sorting of properties!
//	             Collections.sort(descriptors, new Comparator() {
//	                 Collator coll = Collator.getInstance(Locale.getDefault());
//	      
//	                 public int compare(Object a, Object b) {
//	                     IPropertyDescriptor d1, d2;
//	                     String dname1, dname2;
//	                     d1 = (IPropertyDescriptor) a;
//	                     dname1 = d1.getDisplayName();
//	                     d2 = (IPropertyDescriptor) b;
//	                     dname2 = d2.getDisplayName();
//	                     return coll.compare(dname1, dname2);
//	                 }
//	             });
	  ////////////////////////////////////////////////////////////////////////

	      return descriptors;
	   }

	   /**
	    * Overrides the super method to avoid ordering attributes, and so keep the
	    * order defined in the ecore model.
	    * The difference with the super method is that a LinkedHashMap is used instead of a HashMap,
	    * in order to keep the properties order.
	    * 
	    * @param source a property source for which to obtain descriptors
	    * @return a table of descriptors keyed on their id
	    */
	   protected Map computePropertyDescriptorsFor(IPropertySource source)
	   {
	      IPropertyDescriptor[] descriptors = source.getPropertyDescriptors();
	      
	////////////////////////////////////////////////////////////////////////
	      // Use LinkedHashMap instead of HashMap to preserve order
	      Map result = new LinkedHashMap();
	////////////////////////////////////////////////////////////////////////
	      for (int i = 0; i < descriptors.length; i++)
	      {
	         result.put(descriptors[i].getId(), descriptors[i]);
	      }
	      return result;
	   }
}
