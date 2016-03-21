/*
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package org.wso2.developerstudio.eclipse.registry.apim.views;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.StyledCellLabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.StyledString.Styler;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.widgets.Display;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryContentContainer;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryNode;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryResourceNode;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryResourceType;
import org.wso2.developerstudio.eclipse.registry.base.ui.util.ImageUtils;

public class RegistryBrowserAPIMViewLabelProvider extends StyledCellLabelProvider{
	
	@Override
	public void update(ViewerCell cell) {
		Object element = cell.getElement();
		StyledString text = new StyledString();
		StyleRange styleRange=null;
		if(element instanceof RegistryNode){
			RegistryNode node = (RegistryNode)element;
			ImageDescriptor imageDescriptorDeleteResource = ImageUtils.getImageDescriptor(ImageUtils.ICON_REGISTRY);
			cell.setImage(imageDescriptorDeleteResource.createImage());
			text.append(node.getCaption());
			
		}else if(element instanceof RegistryResourceNode){
			RegistryResourceNode node = (RegistryResourceNode)element;
			
		if(node.getResourceType()==RegistryResourceType.RESOURCE){
			ImageDescriptor imageDesSeq = ImageUtils.getImageDescriptor(ImageUtils.STATE_NORMAL);
			Styler seqStyle = StyledString.DECORATIONS_STYLER;
			
			if(node.isIsdeleted()){
				imageDesSeq = ImageUtils.getImageDescriptor(ImageUtils.STATE_DELETED);			
				 styleRange = new StyleRange();
				 styleRange.start = 0;
				 styleRange.length = node.getCaption().length();
				 styleRange.strikeout = true;
				 Display cdisplay = Display.getCurrent();
				 styleRange.strikeoutColor = cdisplay.getSystemColor(SWT.COLOR_RED);
			}
			if(node.isIsnew()){
				seqStyle = StyledString.COUNTER_STYLER;
				imageDesSeq = ImageUtils.getImageDescriptor(ImageUtils.STATE_NEW);
			}else{
				if(node.isIsmodifiyed()){
					seqStyle = StyledString.QUALIFIER_STYLER;
					imageDesSeq = ImageUtils.getImageDescriptor(ImageUtils.STATE_MODIFIED);

				}
				if(node.isRename()){
					seqStyle = StyledString.QUALIFIER_STYLER;
					imageDesSeq = ImageUtils.getImageDescriptor(ImageUtils.STATE_MODIFIED);

				}
			}
			cell.setImage(imageDesSeq.createImage());
			text.append(node.getCaption(), seqStyle);
			
		 }else if(node.getResourceType()==RegistryResourceType.COLLECTION){
			 ImageDescriptor imageDescriptorDeleteResource = ImageUtils.getImageDescriptor(ImageUtils.ACTION_ADD_FOLDER);
			 cell.setImage(imageDescriptorDeleteResource.createImage());
			 text.append(node.getCaption());
		 }		
		}else if (element instanceof RegistryContentContainer){
		     	RegistryContentContainer node = (RegistryContentContainer) element;
			    ImageDescriptor imageDescriptorDeleteResource = ImageUtils.getImageDescriptor(ImageUtils.ACTION_ADD_FOLDER);
				cell.setImage(imageDescriptorDeleteResource.createImage());
			 	text.append(node.getCaption());
		}
		cell.setText(text.toString());
		if(styleRange!=null){
			StyleRange[] styleArray = new StyleRange[1];
			styleArray[0] = styleRange;
			cell.setStyleRanges(styleArray);
		}else{
			cell.setStyleRanges(text.getStyleRanges());
		}
		
		super.update(cell);
	}
	
 
}
