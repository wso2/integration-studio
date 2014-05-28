/*******************************************************************************
 * Copyright (c) 2005, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.ui.factories;

import org.eclipse.bpel.model.Assign;
import org.eclipse.bpel.model.AssignE4X;
import org.eclipse.bpel.model.BPELFactory;
import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.Catch;
import org.eclipse.bpel.model.CatchAll;
import org.eclipse.bpel.model.CompensationHandler;
import org.eclipse.bpel.model.Copy;
import org.eclipse.bpel.model.ExtensionAssignOperation;
import org.eclipse.bpel.model.ForEach;
import org.eclipse.bpel.model.OnAlarm;
import org.eclipse.bpel.model.OnEvent;
import org.eclipse.bpel.model.OnMessage;
import org.eclipse.bpel.model.Pick;
import org.eclipse.bpel.model.Scope;
import org.eclipse.bpel.model.Sequence;
import org.eclipse.bpel.model.Snippet;
import org.eclipse.bpel.model.TerminationHandler;
import org.eclipse.bpel.model.Variable;
import org.eclipse.bpel.ui.BPELUIPlugin;
import org.eclipse.bpel.ui.Policy;
import org.eclipse.bpel.ui.util.XSDUtils;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xsd.XSDTypeDefinition;

/**
 * Factory which knows how to create a BPEL model object (and knows where to
 * find the associated icons, etc).
 * 
 * Each instance is constructed with one specific BPEL model object type and
 * represents the way to get general UI info about (and create instances of)
 * that model object type.
 */

public class BPELUIObjectFactory extends AbstractUIObjectFactory {

	protected static final String OBJ16 = "obj16/"; //$NON-NLS-1$

	protected static final String OBJ20 = "obj20/"; //$NON-NLS-1$

	protected static final String GIF = ".gif"; //$NON-NLS-1$

	protected static final String PNG = ".png"; //$NON-NLS-1$

	/** The counter variable type used in ForEach */
	public static final String FOR_EACH_COUNTER_VARIABLE_TYPE = "unsignedInt"; //$NON-NLS-1$

	/** The counter variable name used in ForEach */
	public static final String FOR_EACH_COUNTER_VARIABLE_NAME = "Counter"; //$NON-NLS-1$

	/** we should not include actions here (invoke, etc...) */
	public static EClass[] classArray = {
		
		
			// BPELPackage.eINSTANCE.getProcess(),
			BPELPackage.eINSTANCE.getOpaqueActivity(),
			BPELPackage.eINSTANCE.getVariable(),
			BPELPackage.eINSTANCE.getCorrelationSet(),
			BPELPackage.eINSTANCE.getPartnerLink(),
			BPELPackage.eINSTANCE.getSequence(),
			BPELPackage.eINSTANCE.getFlow(), 
			BPELPackage.eINSTANCE.getPick(),
			BPELPackage.eINSTANCE.getScope(), 
			BPELPackage.eINSTANCE.getIf(),
			BPELPackage.eINSTANCE.getExit(), 
			BPELPackage.eINSTANCE.getThrow(),
			BPELPackage.eINSTANCE.getRethrow(),
			BPELPackage.eINSTANCE.getCompensate(),
			BPELPackage.eINSTANCE.getCompensateScope(),
			BPELPackage.eINSTANCE.getWait(), 
			BPELPackage.eINSTANCE.getWhile(),
			BPELPackage.eINSTANCE.getForEach(),
			BPELPackage.eINSTANCE.getRepeatUntil(),
			BPELPackage.eINSTANCE.getLink(), 
			BPELPackage.eINSTANCE.getElseIf(),
			BPELPackage.eINSTANCE.getElse(),
			BPELPackage.eINSTANCE.getOnMessage(),
			BPELPackage.eINSTANCE.getOnAlarm(),
			BPELPackage.eINSTANCE.getFaultHandler(),
			BPELPackage.eINSTANCE.getCatch(),
			BPELPackage.eINSTANCE.getCatchAll(),
			BPELPackage.eINSTANCE.getCompensationHandler(),
			BPELPackage.eINSTANCE.getTerminationHandler(),
			BPELPackage.eINSTANCE.getEventHandler(),
			BPELPackage.eINSTANCE.getOnEvent(),
			BPELPackage.eINSTANCE.getMessageExchange(),
			BPELPackage.eINSTANCE.getValidate(),
			// Bugzilla 324115
			BPELPackage.eINSTANCE.getExtensionActivity(),
			// E4X Extension
			BPELPackage.eINSTANCE.getAssignE4X(),
			BPELPackage.eINSTANCE.getExtension()
	};

	protected EClass modelType;

	/**
	 * Brand new shiny BPELUIObjectFactory.
	 * 
	 * @param aModelType
	 *            the model type.
	 */

	public BPELUIObjectFactory(EClass aModelType) {

		super();
		this.modelType = aModelType;

		if (modelType.getEPackage() != BPELPackage.eINSTANCE) {
			if (Policy.DEBUG)
				System.out
						.println("WARNING: constructing BPELUIObjectFactory(" + modelType.getName() + ") with non-BPELPackage EClass"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/** 
	 * 
	 * @see org.eclipse.bpel.ui.factories.AbstractUIObjectFactory#getModelType()
	 */
	@Override
	public EClass getModelType() {
		return modelType;
	}

	protected static String baseImageName(EClass modelObject) {
		// TODO: this is a hack and shouldn't be necessary
		if (modelObject == BPELPackage.eINSTANCE.getVariable()) {
			return "variable"; //$NON-NLS-1$
		}
		if (modelObject == BPELPackage.eINSTANCE.getPartnerLink()) {
			return "partner"; //$NON-NLS-1$
		}
		return modelObject.getName().toLowerCase();
	}

	/**
	 * @see org.eclipse.bpel.ui.factories.AbstractUIObjectFactory#getSmallImageDescriptor()
	 */
	@Override
	public ImageDescriptor getSmallImageDescriptor() {
		return getSmallImageDescriptor(getModelType());
	}

	/**
	 * @see org.eclipse.bpel.ui.factories.AbstractUIObjectFactory#getLargeImageDescriptor()
	 */
	@Override
	public ImageDescriptor getLargeImageDescriptor() {
		return getLargeImageDescriptor(getModelType());
	}

	
	/**
	 * Return the small image descriptor for the modelObject class passed.
	 * @param modelObject
	 * @return the small image descriptor 
	 */
	
	public static ImageDescriptor getSmallImageDescriptor (EClass modelObject) {
		return BPELUIPlugin.INSTANCE.getImageDescriptor(
				OBJ16 + baseImageName(modelObject) + GIF);
	}

	/**
	 * Return the large image descriptor for the modelObject class passed.
	 * @param modelObject
	 * @return the large image descriptor 
	 */

	public static ImageDescriptor getLargeImageDescriptor(EClass modelObject) {
		return BPELUIPlugin.INSTANCE.getImageDescriptor(
				OBJ20 + baseImageName(modelObject) + PNG);
	}

	/**
	 * @see org.eclipse.bpel.ui.factories.AbstractUIObjectFactory#getSmallImage()
	 */
	@Override
	public Image getSmallImage() {
		return BPELUIPlugin.INSTANCE.getImage(
				OBJ16 + baseImageName(getModelType()) + GIF);
	}

	/**
	 * @see org.eclipse.bpel.ui.factories.AbstractUIObjectFactory#getLargeImage()
	 */
	@Override
	public Image getLargeImage() {
		return BPELUIPlugin.INSTANCE.getImage(
				OBJ20 + baseImageName(getModelType()) + PNG);
	}

	/**
	 * @see org.eclipse.bpel.ui.factories.AbstractUIObjectFactory#getTypeLabel()
	 */
	@Override
	public String getTypeLabel() {
		// TODO: new story for externalizing this ? We used to use
		// BPELCreateFactory.ClassNiceName.* keys
		return getModelType().getName();
	}

	/**
	 * @see org.eclipse.bpel.ui.factories.AbstractUIObjectFactory#createInstance()
	 */
	@Override
	public EObject createInstance() {

		EObject result = super.createInstance();

		if (result instanceof Scope) {

			// we need to have the variables model object in order to have the
			// variables
			// category appear on the tray
			// MRC: That's true, but it will not pass validation with the
			// default skeleton like this ...

			Scope scope = (Scope) result;
			scope.setVariables(BPELFactory.eINSTANCE.createVariables());
			scope.setPartnerLinks(BPELFactory.eINSTANCE.createPartnerLinks());
			scope.setCorrelationSets(BPELFactory.eINSTANCE.createCorrelationSets());
			scope.setMessageExchanges(BPELFactory.eINSTANCE.createMessageExchanges());

		} else if (result instanceof Pick) {
			Pick pick = (Pick) result;

			// create a free OnMessage inside the Pick.
			OnMessage onMessage = UIObjectFactoryProvider.getInstance()
					.getFactoryFor(BPELPackage.eINSTANCE.getOnMessage())
					.createInstance();

			pick.getMessages().add(onMessage);

		} else if (result instanceof Assign) {

			Assign assign = (Assign) result;
			// create a free Copy inside the Assign.
			Copy copy = BPELFactory.eINSTANCE.createCopy();
			assign.getCopy().add(copy);

		} else if (result instanceof AssignE4X) {
			// E4X Extension 
			AssignE4X assignE4X = (AssignE4X) result;
			 
			ExtensionAssignOperation eao = BPELFactory.eINSTANCE.createExtensionAssignOperation();
			Snippet snippet = BPELFactory.eINSTANCE.createSnippet();
			// creates a snippet element in extensionAssignOperation
			eao.setSnippet(snippet);
			// create a free ExtensionAssignOperation inside the AssignE4X.
			assignE4X.getExtensionAssignOperation().add(eao);
			// set validate value to no by default. 
			assignE4X.setValidate(false);

		}else if (result instanceof ForEach) {

			ForEach forEach = (ForEach) result;

			// create a default counter variable inside the ForEach
			Variable variable = BPELFactory.eINSTANCE.createVariable();
			XSDTypeDefinition varType = XSDUtils
					.getPrimitive(FOR_EACH_COUNTER_VARIABLE_TYPE);
			variable.setType(varType);
			variable.setName(FOR_EACH_COUNTER_VARIABLE_NAME);
			forEach.setCounterName(variable);

			// create an empty scope inside the ForEach
			Scope scope = BPELFactory.eINSTANCE.createScope();
			forEach.setActivity(scope);

		} else if (result instanceof CatchAll || result instanceof Catch
				|| result instanceof CompensationHandler) {

			/**
			 * This is per bug#132153 and bug#132154.
			 * 
			 */

			// create an empty scope inside the Catch
			Sequence sequence = BPELFactory.eINSTANCE.createSequence();
			sequence.getActivities().add(
					BPELFactory.eINSTANCE.createCompensate());
			if (result instanceof CatchAll || result instanceof Catch)
				sequence.getActivities().add(BPELFactory.eINSTANCE.createRethrow());

			if (result instanceof Catch) {
				Catch _catch = (Catch) result;
				_catch.setActivity(sequence);
			} else if (result instanceof CatchAll) {
				CatchAll _catchAll = (CatchAll) result;
				_catchAll.setActivity(sequence);
			} else if (result instanceof CompensationHandler) {
				CompensationHandler _compensationHandler = (CompensationHandler) result;
				_compensationHandler.setActivity(sequence);
			}

		} else if (result instanceof TerminationHandler) {

			/**
			 * Per bug# 132155
			 */

			TerminationHandler terminationHandler = (TerminationHandler) result;
			terminationHandler.setActivity(BPELFactory.eINSTANCE
					.createCompensate());

		} else if (result instanceof OnEvent) {
			
			/** Per bug# 133170 */
			OnEvent onEvent = (OnEvent) result;
			onEvent.setActivity( BPELFactory.eINSTANCE.createScope());
			
		} else if (result instanceof OnAlarm) {
			
			/** Per bug# 133170 */
			OnAlarm onAlarm = (OnAlarm) result;
			onAlarm.setActivity( BPELFactory.eINSTANCE.createScope());
			
		}

		return result;
	}
}
