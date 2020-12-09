/*
 * Copyright (c) 2017, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.datamapper.diagram.custom.util;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.wso2.developerstudio.datamapper.diagram.part.DataMapperDiagramEditorPlugin;

public class ImageHolder {
	public static final String JSON_SCHEMA_TYPE = "type";
	public static final String JSON_SCHEMA_ARRAY = "array";
	public static final String JSON_SCHEMA_OBJECT = "object";

	private static final String ORG_WSO2_DEVELOPERSTUDIO_VISUALDATAMAPPER_DIAGRAM = "org.wso2.developerstudio.visualdatamapper.diagram";
	private static final String ELEMENT_ICON = "icons/gmf/element.png";
	private static final String ATTRIBUTE_ICON = "icons/gmf/attribute.png";
	private static final String ARRAY_ICON = "icons/gmf/array.png";
	private static final String OBJECT_ICON = "icons/gmf/object.png";
	private static final String NULLABLE_ELEMENT_ICON = "icons/gmf/element-null.png";
	private static final String NULLABLE_ATTRIBUTE_ICON = "icons/gmf/attribute-null.png";
	private static final String NULLABLE_ARRAY_ICON = "icons/gmf/array-null.png";
	private static final String NULLABLE_OBJECT_ICON = "icons/gmf/object-null.png";
	private static final String ELEMENT_OF_ICON = "icons/gmf/symbol_element_of.gif";
	private static final String ATTRIBUTE_ICON2 = "icons/gmf/AttributeIcon.png";
	private static final String ARROW_GREY = "icons/gmf/greyArrow.png";
	private static final String ARROW_BLUE = "icons/gmf/blueArrow.png";
	private static final String ARROW_EAST = "icons/ico20/arrowEast.png";
	private static final String ARROW_WEST = "icons/ico20/arrowWest.png";
	private static final String BLACK_COLOURED = "icons/gmf/black.jpg";
	private static final String ADD_INPUT_CONTENT = "icons/gmf/add-input-content.png";
	private static final String ADD_OUTPUT_CONTENT = "icons/gmf/add-output-content.png";
	private static final String ADD_ROOT = "icons/gmf/add-root.png";
	private static final String AI_DATA_MAP_BTN = "icons/gmf/apply-btn.png";
	
	private Image elementImage;
	private Image attributeImage;
	private Image arrayImage;
	private Image objectImage;
	private Image nullableElementImage;
	private Image nullableAttributeImage;
	private Image nullableArrayImage;
	private Image nullableObjectImage;
	private Image elementSymbolImage;
	private Image attributeSymbolImage;
	private Image arrowGreyImage;
	private Image arrowBlueImage;
	private Image arrowEastImage;
	private Image arrowWestImage;
	private Image blackColouredImage;
	private Image addInputContentImage;
	private Image addOutputContentImage;
	private Image addRootImage;
	private Image addAIDataMappingImage;

	private ImageHolder() {
		
		ImageDescriptor elementImgDescCollapse = AbstractUIPlugin
				.imageDescriptorFromPlugin(ORG_WSO2_DEVELOPERSTUDIO_VISUALDATAMAPPER_DIAGRAM, ELEMENT_ICON);

		ImageDescriptor attributeImgDesc = AbstractUIPlugin
				.imageDescriptorFromPlugin(ORG_WSO2_DEVELOPERSTUDIO_VISUALDATAMAPPER_DIAGRAM, ATTRIBUTE_ICON);

		ImageDescriptor arrayImgDesc = AbstractUIPlugin
				.imageDescriptorFromPlugin(ORG_WSO2_DEVELOPERSTUDIO_VISUALDATAMAPPER_DIAGRAM, ARRAY_ICON);

		ImageDescriptor objectImgDesc = AbstractUIPlugin
				.imageDescriptorFromPlugin(ORG_WSO2_DEVELOPERSTUDIO_VISUALDATAMAPPER_DIAGRAM, OBJECT_ICON);

		ImageDescriptor nullableElementImgDesc = AbstractUIPlugin.imageDescriptorFromPlugin(
				ORG_WSO2_DEVELOPERSTUDIO_VISUALDATAMAPPER_DIAGRAM, NULLABLE_ELEMENT_ICON);
		ImageDescriptor nullableAttributeImgDesc = AbstractUIPlugin.imageDescriptorFromPlugin(
				ORG_WSO2_DEVELOPERSTUDIO_VISUALDATAMAPPER_DIAGRAM, NULLABLE_ATTRIBUTE_ICON);
		ImageDescriptor nullableArrayImgDesc = AbstractUIPlugin.imageDescriptorFromPlugin(
				ORG_WSO2_DEVELOPERSTUDIO_VISUALDATAMAPPER_DIAGRAM, NULLABLE_ARRAY_ICON);
		ImageDescriptor nullableObjectImgDesc = AbstractUIPlugin
				.imageDescriptorFromPlugin(ORG_WSO2_DEVELOPERSTUDIO_VISUALDATAMAPPER_DIAGRAM, NULLABLE_OBJECT_ICON);
		ImageDescriptor elementSymbolImgDesc = AbstractUIPlugin
				.imageDescriptorFromPlugin(ORG_WSO2_DEVELOPERSTUDIO_VISUALDATAMAPPER_DIAGRAM, ELEMENT_OF_ICON);
		ImageDescriptor attributeSymbolImgDesc = AbstractUIPlugin
				.imageDescriptorFromPlugin(ORG_WSO2_DEVELOPERSTUDIO_VISUALDATAMAPPER_DIAGRAM, ATTRIBUTE_ICON2);
		ImageDescriptor arrowGreyImgDesc = AbstractUIPlugin
				.imageDescriptorFromPlugin(ORG_WSO2_DEVELOPERSTUDIO_VISUALDATAMAPPER_DIAGRAM, ARROW_GREY);
		ImageDescriptor arrowBlueImgDesc = AbstractUIPlugin
				.imageDescriptorFromPlugin(ORG_WSO2_DEVELOPERSTUDIO_VISUALDATAMAPPER_DIAGRAM, ARROW_BLUE);
		ImageDescriptor arrowEastImgDesc = DataMapperDiagramEditorPlugin.getBundledImageDescriptor(ARROW_EAST);
		ImageDescriptor arrowWestImgDesc = DataMapperDiagramEditorPlugin.getBundledImageDescriptor(ARROW_WEST);
		ImageDescriptor blackColouredImgDesc = AbstractUIPlugin
				.imageDescriptorFromPlugin(ORG_WSO2_DEVELOPERSTUDIO_VISUALDATAMAPPER_DIAGRAM, BLACK_COLOURED);
		ImageDescriptor addInputContentDesc = AbstractUIPlugin
				.imageDescriptorFromPlugin(ORG_WSO2_DEVELOPERSTUDIO_VISUALDATAMAPPER_DIAGRAM, ADD_INPUT_CONTENT);
		ImageDescriptor addOutputContentDesc = AbstractUIPlugin
				.imageDescriptorFromPlugin(ORG_WSO2_DEVELOPERSTUDIO_VISUALDATAMAPPER_DIAGRAM, ADD_OUTPUT_CONTENT);
		ImageDescriptor addRootDesc = AbstractUIPlugin
				.imageDescriptorFromPlugin(ORG_WSO2_DEVELOPERSTUDIO_VISUALDATAMAPPER_DIAGRAM, ADD_ROOT);
		ImageDescriptor addAIDataMapBtnDesc = AbstractUIPlugin
                .imageDescriptorFromPlugin(ORG_WSO2_DEVELOPERSTUDIO_VISUALDATAMAPPER_DIAGRAM, AI_DATA_MAP_BTN);
		
		elementImage = elementImgDescCollapse.createImage();
		attributeImage = attributeImgDesc.createImage();
		arrayImage = arrayImgDesc.createImage();
		objectImage = objectImgDesc.createImage();
		nullableElementImage = nullableElementImgDesc.createImage();
		nullableAttributeImage = nullableAttributeImgDesc.createImage();
		nullableArrayImage = nullableArrayImgDesc.createImage();
		nullableObjectImage = nullableObjectImgDesc.createImage();
		elementSymbolImage = elementSymbolImgDesc.createImage();
		attributeSymbolImage = attributeSymbolImgDesc.createImage();
		arrowGreyImage = arrowGreyImgDesc.createImage();
		arrowBlueImage = arrowBlueImgDesc.createImage();
		arrowEastImage = arrowEastImgDesc.createImage();
		arrowWestImage = arrowWestImgDesc.createImage();
		blackColouredImage = blackColouredImgDesc.createImage();
		addInputContentImage = addInputContentDesc.createImage();
		addOutputContentImage = addOutputContentDesc.createImage();
		addRootImage = addRootDesc.createImage();
		addAIDataMappingImage = addAIDataMapBtnDesc.createImage();
	}
	
	public Image getAddAIDataMappingImage() {
		return addAIDataMappingImage;
	}

	public Image getElementImage() {
		return elementImage;
	}
	
	public Image getAttributeImage() {
		return attributeImage;
	}
	
	public Image getArrayImage() {
		return arrayImage;
	}
	
	public Image getObjectImage() {
		return objectImage;
	}
	
	public Image getNullableElementImage() {
		return nullableElementImage;
	}
	
	public Image getNullableAttributeImage() {
		return nullableAttributeImage;
	}
	
	public Image getNullableArrayImage() {
		return nullableArrayImage;
	}
	
	public Image getNullableObjectImage() {
		return nullableObjectImage;
	}
	
	public Image getElementSymbolImage() {
		return elementSymbolImage;
	}
	public Image getAttributeSymbolImage() {
		return attributeSymbolImage;
	}
	
	public Image getArrowGreyImage() {
		return arrowGreyImage;
	}
	
	public Image getArrowBlueImage() {
		return arrowBlueImage;
	}
	
	public Image getArrowEastImage() {
		return arrowEastImage;
	}
	
	public Image getArrowWestImage() {
		return arrowWestImage;
	}
	
	public Image getBlackColouredImage() {
		return blackColouredImage;
	}
	
	public Image getAddInputContentImage() {
		return addInputContentImage;
	}

	public Image getAddOutputContentImage() {
		return addOutputContentImage;
	}

	public Image getAddRootImage() {
		return addRootImage;
	}

	public static ImageHolder getInstance() {
		return ImageHolderInstanceHolder.IMAGEHOLDER_INSTANCE;
	}
	
	private static class ImageHolderInstanceHolder {
		private static final ImageHolder IMAGEHOLDER_INSTANCE = new ImageHolder();
	}
}
