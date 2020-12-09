/*
 * Copyright (c) 2014 -2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.integrationstudio.datamapper.diagram.part;

import java.util.Collections;
import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.Tool;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteEntry;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.internal.services.palette.PaletteToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.tooling.runtime.part.DefaultLinkToolEntry;
import org.eclipse.gmf.tooling.runtime.part.DefaultNodeToolEntry;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.DataMapperRootEditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.InNode2EditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.InNode3EditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.InNodeEditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.InputEditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.OperatorLeftConnectorEditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.OperatorRightConnectorEditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.OutNode2EditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.OutNode3EditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.OutNodeEditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.OutputEditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.TreeNode2EditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.TreeNode3EditPart;
import org.wso2.integrationstudio.datamapper.diagram.edit.parts.TreeNodeEditPart;
import org.wso2.integrationstudio.datamapper.diagram.providers.DataMapperElementTypes;

/**
 * @generated
 */
@SuppressWarnings("restriction")
public class DataMapperPaletteFactory {

	public static final int INITIAL_STATE_OPEN = 0, INITIAL_STATE_CLOSED = 1;//INITIAL_STATE_PINNED_OPEN = 2;

	/**
	 * @generated NOT
	 */
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createDataMapperLinkGroup());
		paletteRoot.add(createDataMapperCommonGroup());
		paletteRoot.add(createDataMapperArithmeticGroup());
		paletteRoot.add(createDataMapperConditionalGroup());
		paletteRoot.add(createDataMapperBooleanGroup());
		//paletteRoot.add(createDataMapperArrayGroup());
		paletteRoot.add(createDataMapperTypeConversionGroup());
		paletteRoot.add(createDataMapperStringGroup());
	}

	/**
	* Creates "dataMapper" palette tool group
	* @generated
	*/
	private PaletteContainer createDataMapper1Group() {
		PaletteGroup paletteContainer = new PaletteGroup(Messages.DataMapper1Group_title);
		paletteContainer.setId("createDataMapper1Group"); //$NON-NLS-1$
		paletteContainer.add(createDataMapperLink1CreationTool());
		paletteContainer.add(createEqual2CreationTool());
		paletteContainer.add(createConcat3CreationTool());
		paletteContainer.add(createSplit4CreationTool());
		paletteContainer.add(createConstant5CreationTool());
		paletteContainer.add(createLowerCase6CreationTool());
		paletteContainer.add(createContains7CreationTool());
		paletteContainer.add(createUpperCase8CreationTool());
		paletteContainer.add(createAdd9CreationTool());
		paletteContainer.add(createSubtract10CreationTool());
		paletteContainer.add(createAbsoluteValue11CreationTool());
		paletteContainer.add(createDivide12CreationTool());
		paletteContainer.add(createFloor13CreationTool());
		paletteContainer.add(createRound14CreationTool());
		paletteContainer.add(createMultiply15CreationTool());
		paletteContainer.add(createSetPrecision16CreationTool());
		paletteContainer.add(createCeli17CreationTool());
		paletteContainer.add(createStringLength18CreationTool());
		paletteContainer.add(createStartsWith19CreationTool());
		paletteContainer.add(createEndsWith20CreationTool());
		paletteContainer.add(createSubstring21CreationTool());
		paletteContainer.add(createIfElse22CreationTool());
		paletteContainer.add(createAND23CreationTool());
		paletteContainer.add(createOR24CreationTool());
		paletteContainer.add(createNOT25CreationTool());
		paletteContainer.add(createTrim26CreationTool());
		paletteContainer.add(createReplace27CreationTool());
		paletteContainer.add(createMatch28CreationTool());
		paletteContainer.add(createMin29CreationTool());
		paletteContainer.add(createMax30CreationTool());
		paletteContainer.add(createCustomFunction31CreationTool());
		paletteContainer.add(createProperties32CreationTool());
		paletteContainer.add(createCompare33CreationTool());
		paletteContainer.add(createStringToNumber34CreationTool());
		paletteContainer.add(createStringToBoolean35CreationTool());
		paletteContainer.add(createClone36CreationTool());
		paletteContainer.add(createToString37CreationTool());
		paletteContainer.add(createGlobalVariable38CreationTool());
		paletteContainer.add(createAdvancedCustomFunction39CreationTool());
		return paletteContainer;
	}

	private PaletteEntry createDataMapperCommonGroup() {
		PaletteDrawer paletteContainer = new PaletteDrawer("Common");
		paletteContainer.setId("createDataMapperCommonGroup"); //$NON-NLS-1$
		paletteContainer.add(createConstant5CreationTool());
		paletteContainer.add(createCustomFunction31CreationTool());
		paletteContainer.add(createProperties32CreationTool());
		paletteContainer.add(createCompare33CreationTool());
		paletteContainer.add(createGlobalVariable38CreationTool());
		paletteContainer.add(createAdvancedCustomFunction39CreationTool());
		paletteContainer.setInitialState(INITIAL_STATE_CLOSED);
		return paletteContainer;
	}

	private PaletteEntry createDataMapperArrayGroup() {
		PaletteDrawer paletteContainer = new PaletteDrawer("Array");
		paletteContainer.setId("createDataMapperArrayGroup"); //$NON-NLS-1$
		paletteContainer.setInitialState(INITIAL_STATE_CLOSED);
		return paletteContainer;
	}

	private PaletteEntry createDataMapperBooleanGroup() {
		PaletteDrawer paletteContainer = new PaletteDrawer("Boolean");
		paletteContainer.setId("createDataMapper1Group"); //$NON-NLS-1$
		paletteContainer.add(createAND23CreationTool());
		paletteContainer.add(createOR24CreationTool());
		paletteContainer.add(createNOT25CreationTool());
		paletteContainer.setInitialState(INITIAL_STATE_CLOSED);
		return paletteContainer;
	}

	private PaletteEntry createDataMapperConditionalGroup() {
		PaletteDrawer paletteContainer = new PaletteDrawer("Conditional");
		paletteContainer.setId("createDataMapperConditionalGroup"); //$NON-NLS-1$
		paletteContainer.add(createIfElse22CreationTool());
		paletteContainer.setInitialState(INITIAL_STATE_CLOSED);
		return paletteContainer;
	}

	private PaletteEntry createDataMapperLinkGroup() {
		PaletteDrawer paletteContainer = new PaletteDrawer("Link");
		paletteContainer.setId("createDataMapper1Group"); //$NON-NLS-1$
		paletteContainer.add(createDataMapperLink1CreationTool());
		paletteContainer.setInitialState(INITIAL_STATE_CLOSED);
		return paletteContainer;
	}

	/**
	 * Creates "org.wso2.integrationstudio.datamapper" palette tool group
	 * 
	 * @generated NOT
	 */
	private PaletteContainer createDataMapperStringGroup() {

		PaletteDrawer paletteContainer = new PaletteDrawer("String");
		paletteContainer.setId("createDataMapper1Group"); //$NON-NLS-1$
		// paletteContainer.add(createDataMapperLink1CreationTool());
		// paletteContainer.add(createEqual2CreationTool());
		paletteContainer.add(createConcat3CreationTool());
		paletteContainer.add(createSplit4CreationTool());
		paletteContainer.add(createLowerCase6CreationTool());
		paletteContainer.add(createUpperCase8CreationTool());
		paletteContainer.add(createStringLength18CreationTool());
		paletteContainer.add(createStartsWith19CreationTool());
		paletteContainer.add(createEndsWith20CreationTool());
		paletteContainer.add(createSubstring21CreationTool());
		paletteContainer.add(createTrim26CreationTool());
		paletteContainer.add(createReplace27CreationTool());
		paletteContainer.add(createMatch28CreationTool());
		paletteContainer.setInitialState(INITIAL_STATE_CLOSED);
		return paletteContainer;
	}

	private PaletteEntry createDataMapperArithmeticGroup() {
		PaletteDrawer paletteContainer = new PaletteDrawer("Arithmetic");

		paletteContainer.setId("createDataMapperArithmeticGroup"); //$NON-NLS-1$
		paletteContainer.add(createAdd9CreationTool());
		paletteContainer.add(createSubtract10CreationTool());
		paletteContainer.add(createMultiply15CreationTool());
		paletteContainer.add(createDivide12CreationTool());
		paletteContainer.add(createCeli17CreationTool());
		paletteContainer.add(createFloor13CreationTool());
		paletteContainer.add(createRound14CreationTool());
		paletteContainer.add(createSetPrecision16CreationTool());
		paletteContainer.add(createAbsoluteValue11CreationTool());
		paletteContainer.add(createMin29CreationTool());
		paletteContainer.add(createMax30CreationTool());
		paletteContainer.setInitialState(INITIAL_STATE_CLOSED);
		return paletteContainer;
	}

	private PaletteEntry createDataMapperTypeConversionGroup() {
		PaletteDrawer paletteContainer = new PaletteDrawer("Type Conversion");

		paletteContainer.setId("createDataMapperTypeConversionGroup"); //$NON-NLS-1$
		paletteContainer.add(createStringToNumber34CreationTool());
		paletteContainer.add(createStringToBoolean35CreationTool());
		paletteContainer.add(createToString37CreationTool());
		paletteContainer.setInitialState(INITIAL_STATE_CLOSED);
		return paletteContainer;
	}

	/**
	 * @generated NOT
	 */
	private ToolEntry createDataMapperLink1CreationTool() {
		// removing the datamapper link entry in the operator tool palette
		LinkToolEntry entry = new LinkToolEntry("Data Mapper Link", "Data Mapper Link",
				Collections.singletonList(DataMapperElementTypes.DataMapperLink_4001));
		entry.setId("createDataMapperLink1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(DataMapperElementTypes.getImageDescriptor(DataMapperElementTypes.DataMapperLink_4001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createEqual2CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.Equal2CreationTool_title,
				Messages.Equal2CreationTool_desc, Collections.singletonList(DataMapperElementTypes.Equal_2005));
		entry.setId("createEqual2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(DataMapperElementTypes.getImageDescriptor(DataMapperElementTypes.Equal_2005));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated NOT
	 */
	private ToolEntry createConcat3CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(Messages.Concat3CreationTool_title, Messages.Concat3CreationTool_desc,
				Collections.singletonList(DataMapperElementTypes.Concat_2006));
		entry.setId("createConcat3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(DataMapperElementTypes.getImageDescriptor(DataMapperElementTypes.Concat_2006));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated NOT
	 */
	private ToolEntry createSplit4CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(Messages.Split4CreationTool_title, Messages.Split4CreationTool_desc,
				Collections.singletonList(DataMapperElementTypes.Split_2007));
		entry.setId("createSplit4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(DataMapperElementTypes.getImageDescriptor(DataMapperElementTypes.Split_2007));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated NOT
	 */
	private ToolEntry createConstant5CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(Messages.Constant5CreationTool_title,
				Messages.Constant5CreationTool_desc, Collections.singletonList(DataMapperElementTypes.Constant_2008));
		entry.setId("createConstant5CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(DataMapperElementTypes.getImageDescriptor(DataMapperElementTypes.Constant_2008));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated NOT
	 */
	private ToolEntry createLowerCase6CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(Messages.LowerCase6CreationTool_title,
				Messages.LowerCase6CreationTool_desc, Collections.singletonList(DataMapperElementTypes.LowerCase_2009));
		entry.setId("createLowerCase6CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(DataMapperElementTypes.getImageDescriptor(DataMapperElementTypes.LowerCase_2009));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createContains7CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.Contains7CreationTool_title,
				Messages.Contains7CreationTool_desc, Collections.singletonList(DataMapperElementTypes.Contains_2010));
		entry.setId("createContains7CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(DataMapperElementTypes.getImageDescriptor(DataMapperElementTypes.Contains_2010));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated NOT
	 */
	private ToolEntry createUpperCase8CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(Messages.UpperCase8CreationTool_title,
				Messages.UpperCase8CreationTool_desc, Collections.singletonList(DataMapperElementTypes.UpperCase_2011));
		entry.setId("createUpperCase8CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(DataMapperElementTypes.getImageDescriptor(DataMapperElementTypes.UpperCase_2011));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated NOT
	*/
	private ToolEntry createAdd9CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(Messages.Add9CreationTool_title, Messages.Add9CreationTool_desc,
				Collections.singletonList(DataMapperElementTypes.Add_2012));
		entry.setId("createAdd9CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(DataMapperElementTypes.getImageDescriptor(DataMapperElementTypes.Add_2012));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated NOT
	*/
	private ToolEntry createSubtract10CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(Messages.Subtract10CreationTool_title,
				Messages.Subtract10CreationTool_desc, Collections.singletonList(DataMapperElementTypes.Subtract_2013));
		entry.setId("createSubtract10CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(DataMapperElementTypes.getImageDescriptor(DataMapperElementTypes.Subtract_2013));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated NOT
	*/
	private ToolEntry createAbsoluteValue11CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(Messages.AbsoluteValue11CreationTool_title,
				Messages.AbsoluteValue11CreationTool_desc,
				Collections.singletonList(DataMapperElementTypes.AbsoluteValue_2020));
		entry.setId("createAbsoluteValue11CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(DataMapperElementTypes.getImageDescriptor(DataMapperElementTypes.AbsoluteValue_2020));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated NOT
	*/
	private ToolEntry createDivide12CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(Messages.Divide12CreationTool_title, Messages.Divide12CreationTool_desc,
				Collections.singletonList(DataMapperElementTypes.Divide_2015));
		entry.setId("createDivide12CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(DataMapperElementTypes.getImageDescriptor(DataMapperElementTypes.Divide_2015));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated NOT
	*/
	private ToolEntry createFloor13CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(Messages.Floor13CreationTool_title, Messages.Floor13CreationTool_desc,
				Collections.singletonList(DataMapperElementTypes.Floor_2017));
		entry.setId("createFloor13CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(DataMapperElementTypes.getImageDescriptor(DataMapperElementTypes.Floor_2017));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated NOT
	*/
	private ToolEntry createRound14CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(Messages.Round14CreationTool_title, Messages.Round14CreationTool_desc,
				Collections.singletonList(DataMapperElementTypes.Round_2018));
		entry.setId("createRound14CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(DataMapperElementTypes.getImageDescriptor(DataMapperElementTypes.Round_2018));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated NOT
	*/
	private ToolEntry createMultiply15CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(Messages.Multiply15CreationTool_title,
				Messages.Multiply15CreationTool_desc, Collections.singletonList(DataMapperElementTypes.Multiply_2014));
		entry.setId("createMultiply15CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(DataMapperElementTypes.getImageDescriptor(DataMapperElementTypes.Multiply_2014));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated NOT
	*/
	private ToolEntry createSetPrecision16CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(Messages.SetPrecision16CreationTool_title,
				Messages.SetPrecision16CreationTool_desc,
				Collections.singletonList(DataMapperElementTypes.SetPrecision_2019));
		entry.setId("createSetPrecision16CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(DataMapperElementTypes.getImageDescriptor(DataMapperElementTypes.SetPrecision_2019));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated NOT
	*/
	private ToolEntry createCeli17CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(Messages.Celi17CreationTool_title, Messages.Celi17CreationTool_desc,
				Collections.singletonList(DataMapperElementTypes.Celi_2016));
		entry.setId("createCeli17CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(DataMapperElementTypes.getImageDescriptor(DataMapperElementTypes.Celi_2016));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated NOT
	*/
	private ToolEntry createStringLength18CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(Messages.StringLength18CreationTool_title,
				Messages.StringLength18CreationTool_desc,
				Collections.singletonList(DataMapperElementTypes.StringLength_2021));
		entry.setId("createStringLength18CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(DataMapperElementTypes.getImageDescriptor(DataMapperElementTypes.StringLength_2021));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated NOT
	*/
	private ToolEntry createStartsWith19CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(Messages.StartsWith19CreationTool_title,
				Messages.StartsWith19CreationTool_desc,
				Collections.singletonList(DataMapperElementTypes.StartsWith_2022));
		entry.setId("createStartsWith19CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(DataMapperElementTypes.getImageDescriptor(DataMapperElementTypes.StartsWith_2022));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated NOT
	*/
	private ToolEntry createEndsWith20CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(Messages.EndsWith20CreationTool_title,
				Messages.EndsWith20CreationTool_desc, Collections.singletonList(DataMapperElementTypes.EndsWith_2023));
		entry.setId("createEndsWith20CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(DataMapperElementTypes.getImageDescriptor(DataMapperElementTypes.EndsWith_2023));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated NOT
	*/
	private ToolEntry createSubstring21CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(Messages.Substring21CreationTool_title,
				Messages.Substring21CreationTool_desc,
				Collections.singletonList(DataMapperElementTypes.Substring_2024));
		entry.setId("createSubstring21CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(DataMapperElementTypes.getImageDescriptor(DataMapperElementTypes.Substring_2024));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated NOT
	*/
	private ToolEntry createIfElse22CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(Messages.IfElse22CreationTool_title, Messages.IfElse22CreationTool_desc,
				Collections.singletonList(DataMapperElementTypes.IfElse_2025));
		entry.setId("createIfElse22CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(DataMapperElementTypes.getImageDescriptor(DataMapperElementTypes.IfElse_2025));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated NOT
	*/
	private ToolEntry createAND23CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(Messages.AND23CreationTool_title, Messages.AND23CreationTool_desc,
				Collections.singletonList(DataMapperElementTypes.AND_2026));
		entry.setId("createAND23CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(DataMapperElementTypes.getImageDescriptor(DataMapperElementTypes.AND_2026));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated NOT
	*/
	private ToolEntry createOR24CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(Messages.OR24CreationTool_title, Messages.OR24CreationTool_desc,
				Collections.singletonList(DataMapperElementTypes.OR_2027));
		entry.setId("createOR24CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(DataMapperElementTypes.getImageDescriptor(DataMapperElementTypes.OR_2027));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated NOT
	*/
	private ToolEntry createNOT25CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(Messages.NOT25CreationTool_title, Messages.NOT25CreationTool_desc,
				Collections.singletonList(DataMapperElementTypes.NOT_2028));
		entry.setId("createNOT25CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(DataMapperElementTypes.getImageDescriptor(DataMapperElementTypes.NOT_2028));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated NOT
	*/
	private ToolEntry createTrim26CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(Messages.Trim26CreationTool_title, Messages.Trim26CreationTool_desc,
				Collections.singletonList(DataMapperElementTypes.Trim_2029));
		entry.setId("createTrim26CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(DataMapperElementTypes.getImageDescriptor(DataMapperElementTypes.Trim_2029));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated NOT
	*/
	private ToolEntry createReplace27CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(Messages.Replace27CreationTool_title,
				Messages.Replace27CreationTool_desc, Collections.singletonList(DataMapperElementTypes.Replace_2030));
		entry.setId("createReplace27CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(DataMapperElementTypes.getImageDescriptor(DataMapperElementTypes.Replace_2030));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated NOT
	*/
	private ToolEntry createMatch28CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(Messages.Match28CreationTool_title, Messages.Match28CreationTool_desc,
				Collections.singletonList(DataMapperElementTypes.Match_2031));
		entry.setId("createMatch28CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(DataMapperElementTypes.getImageDescriptor(DataMapperElementTypes.Match_2031));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated NOT
	*/
	private ToolEntry createMin29CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(Messages.Min29CreationTool_title, Messages.Min29CreationTool_desc,
				Collections.singletonList(DataMapperElementTypes.Min_2032));
		entry.setId("createMin29CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(DataMapperElementTypes.getImageDescriptor(DataMapperElementTypes.Min_2032));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated NOT
	*/
	private ToolEntry createMax30CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(Messages.Max30CreationTool_title, Messages.Max30CreationTool_desc,
				Collections.singletonList(DataMapperElementTypes.Max_2033));
		entry.setId("createMax30CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(DataMapperElementTypes.getImageDescriptor(DataMapperElementTypes.Max_2033));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated NOT
	*/
	private ToolEntry createCustomFunction31CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(Messages.CustomFunction31CreationTool_title,
				Messages.CustomFunction31CreationTool_desc,
				Collections.singletonList(DataMapperElementTypes.CustomFunction_2034));
		entry.setId("createCustomFunction31CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(DataMapperElementTypes.getImageDescriptor(DataMapperElementTypes.CustomFunction_2034));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated NOT
	*/
	private ToolEntry createProperties32CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(Messages.Properties32CreationTool_title,
				Messages.Properties32CreationTool_desc,
				Collections.singletonList(DataMapperElementTypes.Properties_2035));
		entry.setId("createProperties32CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(DataMapperElementTypes.getImageDescriptor(DataMapperElementTypes.Properties_2035));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated NOT
	*/
	private ToolEntry createCompare33CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(Messages.Compare33CreationTool_title,
				Messages.Compare33CreationTool_desc, Collections.singletonList(DataMapperElementTypes.Compare_2036));
		entry.setId("createCompare33CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(DataMapperElementTypes.getImageDescriptor(DataMapperElementTypes.Compare_2036));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated NOT
	*/
	private ToolEntry createStringToNumber34CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(Messages.StringToNumber34CreationTool_title,
				Messages.StringToNumber34CreationTool_desc,
				Collections.singletonList(DataMapperElementTypes.StringToNumber_2037));
		entry.setId("createStringToNumber34CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(DataMapperElementTypes.getImageDescriptor(DataMapperElementTypes.StringToNumber_2037));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated NOT
	*/
	private ToolEntry createStringToBoolean35CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(Messages.StringToBoolean35CreationTool_title,
				Messages.StringToBoolean35CreationTool_desc,
				Collections.singletonList(DataMapperElementTypes.StringToBoolean_2038));
		entry.setId("createStringToBoolean35CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(DataMapperElementTypes.getImageDescriptor(DataMapperElementTypes.StringToBoolean_2038));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createClone36CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.Clone36CreationTool_title,
				Messages.Clone36CreationTool_desc, Collections.singletonList(DataMapperElementTypes.Clone_2039));
		entry.setId("createClone36CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(DataMapperElementTypes.getImageDescriptor(DataMapperElementTypes.Clone_2039));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated NOT
	 */
	private ToolEntry createToString37CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(Messages.ToString37CreationTool_title,
				Messages.ToString37CreationTool_desc, Collections.singletonList(DataMapperElementTypes.ToString_2040));
		entry.setId("createToString37CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(DataMapperElementTypes.getImageDescriptor(DataMapperElementTypes.ToString_2040));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated NOT
	 */
	private ToolEntry createGlobalVariable38CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(Messages.GlobalVariable38CreationTool_title,
				Messages.GlobalVariable38CreationTool_desc,
				Collections.singletonList(DataMapperElementTypes.GlobalVariable_2041));
		entry.setId("createGlobalVariable38CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(DataMapperElementTypes.getImageDescriptor(DataMapperElementTypes.GlobalVariable_2041));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createAdvancedCustomFunction39CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.AdvancedCustomFunction39CreationTool_title,
				Messages.AdvancedCustomFunction39CreationTool_desc,
				Collections.singletonList(DataMapperElementTypes.AdvancedCustomFunction_2042));
		entry.setId("createAdvancedCustomFunction39CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				DataMapperElementTypes.getImageDescriptor(DataMapperElementTypes.AdvancedCustomFunction_2042));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated NOT
	 */
	private static class NodeToolEntry extends PaletteToolEntry {

		/**
		 * @generated NOT
		 */
		private final List<IElementType> elementTypes;

		/**
		 * @generated NOT
		 */
		private NodeToolEntry(String title, String description, List<IElementType> elementTypes) {
			super(null, title, null);
			this.setDescription(description);
			this.elementTypes = elementTypes;
		}

		/**
		 * @generated NOT
		 */
		public Tool createTool() {
			Tool tool = new UnspecifiedTypeCreationTool(elementTypes);
			tool.setProperties(getToolProperties());
			return tool;
		}
	}

	/**
	 * @generated NOT
	 */
	private static class LinkToolEntry extends ToolEntry {

		/**
		 * @generated NOT
		 */
		private final List<IElementType> relationshipTypes;

		/**
		 * @generated NOT
		 */
		private LinkToolEntry(String title, String description, List<IElementType> relationshipTypes) {
			super(title, description, null, null);
			this.relationshipTypes = relationshipTypes;
		}

		private EditPart getRoot(EditPart editPart) {
			EditPart temp = editPart.getParent();
			while ((!(temp instanceof DataMapperRootEditPart)) && (temp != null)) {
				if (temp instanceof InputEditPart) {
					return temp;
					/*
					 * if (childEditPart instanceof InNodeEditPart) { NodeFigure
					 * figureInput = ((InNodeEditPart) childEditPart)
					 * .getNodeFigureOutput(); figureInput.removeAll(); Figure
					 * emptyFigure = new Figure(); figureInput.add(emptyFigure);
					 * break; } else { NodeFigure figureInput =
					 * ((InNode2EditPart) childEditPart) .getNodeFigureOutput();
					 * figureInput.removeAll(); Figure emptyFigure = new
					 * Figure(); figureInput.add(emptyFigure); break; }
					 */
				} else if (temp instanceof OutputEditPart) {
					return temp;
				}

				temp = temp.getParent();

			}
			return null;
		}

		/**
		 * @generated NOT
		 */
		public Tool createTool() {
			Tool tool = new UnspecifiedTypeConnectionTool(relationshipTypes) {

				/*
				 * hacking out/In Node for Element & Attribute to make mapping
				 */

				@Override
				protected Command getCommand() {

					/*
					 * for Tree nodes
					 */
					if (getTargetEditPart() instanceof TreeNodeEditPart) {
						for (int i = 0; i < ((TreeNodeEditPart) getTargetEditPart()).getChildren().size(); ++i) {
							TreeNodeEditPart treeNodeEditPart = (TreeNodeEditPart) getTargetEditPart();
							if (getRoot(getTargetEditPart()) instanceof OutputEditPart
									&& !treeNodeEditPart.isInNodeEmpty()) {

								if (treeNodeEditPart.getChildren().get(i) instanceof InNodeEditPart) {
									return ((EditPart) treeNodeEditPart.getChildren().get(i))
											.getCommand(getTargetRequest());

								} else if (treeNodeEditPart.getChildren().get(i) instanceof InNode2EditPart) {
									return ((InNode2EditPart) treeNodeEditPart.getChildren().get(i))
											.getCommand(getTargetRequest());

								}
							} else if (getRoot(getTargetEditPart()) instanceof InputEditPart
									&& !treeNodeEditPart.isOutNodeEmpty()) {

								if (treeNodeEditPart.getChildren().get(i) instanceof OutNodeEditPart) {
									setTargetEditPart((OutNodeEditPart) treeNodeEditPart.getChildren().get(i));
									return super.getCommand();

								} else if (treeNodeEditPart.getChildren().get(i) instanceof OutNode2EditPart) {
									setTargetEditPart((OutNode2EditPart) treeNodeEditPart.getChildren().get(i));
									return super.getCommand();

								}

							}

						} // for
					} else if (getTargetEditPart() instanceof TreeNode2EditPart) {
						TreeNode2EditPart treeNode2EditPart = (TreeNode2EditPart) getTargetEditPart();
						for (int i = 0; i < treeNode2EditPart.getChildren().size(); ++i) {
							// TreeNode2EditPart treeNode2EditPart =
							// (TreeNode2EditPart) getTargetEditPart();
							if (getRoot(getTargetEditPart()) instanceof OutputEditPart
									&& !treeNode2EditPart.isInNodeEmpty()) {
								if (treeNode2EditPart.getChildren().get(i) instanceof InNodeEditPart) {
									return ((InNodeEditPart) treeNode2EditPart.getChildren().get(i))
											.getCommand(getTargetRequest());
								} else if (treeNode2EditPart.getChildren().get(i) instanceof InNode2EditPart) {
									return ((InNode2EditPart) treeNode2EditPart.getChildren().get(i))
											.getCommand(getTargetRequest());

								} else if (treeNode2EditPart.getChildren().get(i) instanceof InNode3EditPart) {
									return ((InNode3EditPart) treeNode2EditPart.getChildren().get(i))
											.getCommand(getTargetRequest());
								}
							} else if (getRoot(getTargetEditPart()) instanceof InputEditPart
									&& !treeNode2EditPart.isOutNodeEmpty()) {
								if (treeNode2EditPart.getChildren().get(i) instanceof OutNodeEditPart) {
									setTargetEditPart((OutNodeEditPart) treeNode2EditPart.getChildren().get(i));
									return super.getCommand();
								} else if (treeNode2EditPart.getChildren().get(i) instanceof OutNode2EditPart) {
									// ((OutNode2EditPart)
									// treeNode2EditPart.getChildren().get(i)).highlightConnectedNode();
									setTargetEditPart((OutNode2EditPart) treeNode2EditPart.getChildren().get(i));
									return super.getCommand();

								} else if (treeNode2EditPart.getChildren().get(i) instanceof OutNode3EditPart) {
									// ((OutNode3EditPart)
									// treeNode2EditPart.getChildren().get(i)).highlightConnectedNode();
									setTargetEditPart((OutNode3EditPart) treeNode2EditPart.getChildren().get(i));
									return super.getCommand();
								}

							}

						} // for

					} else if (getTargetEditPart() instanceof TreeNode3EditPart) {
						for (int i = 0; i < ((TreeNode3EditPart) getTargetEditPart()).getChildren().size(); ++i) {
							TreeNode3EditPart treeNode3EditPart = (TreeNode3EditPart) getTargetEditPart();
							if (getRoot(getTargetEditPart()) instanceof OutputEditPart
									&& !treeNode3EditPart.isInNodeEmpty()) {

								if (treeNode3EditPart.getChildren().get(i) instanceof InNodeEditPart) {
									return ((EditPart) treeNode3EditPart.getChildren().get(i))
											.getCommand(getTargetRequest());

								} else if (treeNode3EditPart.getChildren().get(i) instanceof InNode2EditPart) {
									return ((InNode2EditPart) treeNode3EditPart.getChildren().get(i))
											.getCommand(getTargetRequest());

								}
							} else if (getRoot(getTargetEditPart()) instanceof InputEditPart
									&& !treeNode3EditPart.isOutNodeEmpty()) {
								if (treeNode3EditPart.getChildren().get(i) instanceof OutNodeEditPart) {
									setTargetEditPart((OutNodeEditPart) treeNode3EditPart.getChildren().get(i));
									return super.getCommand();

								} else if (treeNode3EditPart.getChildren().get(i) instanceof OutNode2EditPart) {
									setTargetEditPart((OutNode2EditPart) treeNode3EditPart.getChildren().get(i));
									return super.getCommand();
								}
							}

						} // for
					}

					/*
					 * for leftconnector
					 */
					if (getTargetEditPart() instanceof OperatorLeftConnectorEditPart) {
						for (int i = 0; i < ((OperatorLeftConnectorEditPart) getTargetEditPart()).getChildren()
								.size(); ++i) {

							if ((getTargetEditPart()).getChildren().get(i) instanceof InNode3EditPart) {
								return ((EditPart) (getTargetEditPart()).getChildren().get(i))
										.getCommand(getTargetRequest());

							}

						} // for
					} else if (getTargetEditPart() instanceof OperatorRightConnectorEditPart) {
						for (int i = 0; i < ((OperatorRightConnectorEditPart) getTargetEditPart()).getChildren()
								.size(); ++i) {

							if ((getTargetEditPart()).getChildren().get(i) instanceof OutNode3EditPart) {
								setTargetEditPart(
										(OutNode3EditPart) (EditPart) (getTargetEditPart()).getChildren().get(i));
								return super.getCommand();

							}

						} // for
					}
					// for leftconnector mouse enter
					return super.getCommand();
				}// get command
			}; // UnspecifiedTypeConnectionTool

			tool.setProperties(getToolProperties());
			return tool;
		}// create tool
	}
}