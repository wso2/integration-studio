/******************************************************************************
 * Copyright (c) 2011-2012, EBM WebSourcing
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     EBM WebSourcing - initial API and implementation
 *******************************************************************************/

package org.eclipse.bpel.ui.wizards;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.bpel.common.wsdl.importhelpers.WsdlImportHelper;
import org.eclipse.bpel.common.wsdl.parsers.WsdlParser;
import org.eclipse.bpel.model.BPELFactory;
import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.OnMessage;
import org.eclipse.bpel.model.PartnerLink;
import org.eclipse.bpel.model.Pick;
import org.eclipse.bpel.model.Process;
import org.eclipse.bpel.model.Reply;
import org.eclipse.bpel.model.Sequence;
import org.eclipse.bpel.model.Variable;
import org.eclipse.bpel.model.partnerlinktype.PartnerLinkType;
import org.eclipse.bpel.model.partnerlinktype.PartnerlinktypeFactory;
import org.eclipse.bpel.model.partnerlinktype.PartnerlinktypePackage;
import org.eclipse.bpel.model.partnerlinktype.Role;
import org.eclipse.bpel.model.resource.BPELResourceFactoryImpl;
import org.eclipse.bpel.model.resource.BPELWriter;
import org.eclipse.bpel.model.util.BPELConstants;
import org.eclipse.bpel.ui.BPELUIPlugin;
import org.eclipse.bpel.ui.Templates.TemplateResource;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.wst.wsdl.Definition;
import org.eclipse.wst.wsdl.Fault;
import org.eclipse.wst.wsdl.Import;
import org.eclipse.wst.wsdl.Message;
import org.eclipse.wst.wsdl.Operation;
import org.eclipse.wst.wsdl.Part;
import org.eclipse.wst.wsdl.PortType;
import org.eclipse.wst.wsdl.WSDLFactory;
import org.eclipse.wst.wsdl.util.WSDLConstants;
import org.xml.sax.SAXException;

/**
 * Utilities used in the new BPEL wizard.
 * <p>
 * This class simplifies the reuse of the BPEL wizard pages.
 * In any case, it assumes the 3 first pages of the wizard are reused.
 * </p>
 *
 * @author Vincent Zurczak - EBM WebSourcing
 */
public class NewBpelFileWizardUtils {

	private final NewBpelFileFirstPage firstPage;
	private final NewBpelFileTemplatePage wsdlPage;
	private final NewBpelFilePortTypePage portTypePage;
	private final IFile targetFile;


	/**
	 * Constructor.
	 * @param firstPage the first page
	 * @param wsdlPage the WSDL page
	 * @param portTypePage the port type page
	 * @param targetFile the BPEL file to create
	 */
	public NewBpelFileWizardUtils(
			NewBpelFileFirstPage firstPage,
			NewBpelFileTemplatePage wsdlPage,
			NewBpelFilePortTypePage portTypePage,
			IFile targetFile ) {

		this.firstPage = firstPage;
		this.wsdlPage = wsdlPage;
		this.portTypePage = portTypePage;
		this.targetFile = targetFile;
	}


	/**
	 * Creates a BPEL process and the associated resources from the selected template.
	 * @param monitor a progress monitor
	 * @throws CoreException if a resource fails to be created
	 */
	public void createResourcesFromTemplate( IProgressMonitor monitor ) throws CoreException {

		Map<String,Object> tplProperties = this.firstPage.getProcessTemplateProperties();
		tplProperties.putAll( this.wsdlPage.getProcessTemplateProperties());

		List<TemplateResource> tplResources = this.wsdlPage.getSelectedTemplate().getResources();
		monitor.subTask( Messages.BPELCreateOperation_0 );

		for( TemplateResource tplResource : tplResources ) {
        	String result = tplResource.process( tplProperties );
        	IPath path = new Path( tplResource.getName( tplProperties ));
        	IFile targetFile = this.targetFile.getParent().getFile( path );
        	if( targetFile.exists())
        		targetFile.setContents( new ByteArrayInputStream( result.getBytes()), true, true, monitor );
        	else
        		targetFile.create( new ByteArrayInputStream( result.getBytes()), true, monitor );

        	monitor.worked( 1 );
        }
	}


	/**
	 * Creates a BPEL process from a WSDL definition.
	 * @param monitor a progress monitor
	 * @throws CoreException if a resource fails to be created
	 * @throws IOException
	 * @throws CoreException
	 */
	public void createResourcesFromWsdl( IProgressMonitor monitor ) throws IOException, CoreException {

		// Import the original WSDL?
		monitor.subTask( "Processing the original WSDL definition..." );
		String newWsdlUrl = this.portTypePage.getWsdlUrl();
		if( this.portTypePage.isImportWsdl()) {
			File targetDirectory = this.targetFile.getParent().getLocation().toFile();
			try {
				Map<String,File> uriToImportedFile = new WsdlImportHelper().importWsdlOrXsdAndDependencies( targetDirectory, newWsdlUrl );
				File importedWsdlFile = uriToImportedFile.get( newWsdlUrl );
				if( importedWsdlFile == null )
					throw new IOException( "The WSDL file could not be found after import." );

				// The URL to put in the imports is the relative location of the WSDL
				// with respect to the process (and they are both in the same directory)
				newWsdlUrl = importedWsdlFile.getName();

			} catch( IllegalArgumentException e ) {
				throw new IOException( "The WSDL could not be imported in the project.", e );

			} catch( URISyntaxException e ) {
				throw new IOException( "The WSDL could not be imported in the project.", e );

			} catch( SAXException e ) {
				throw new IOException( "The WSDL could not be imported in the project.", e );

			} catch( ParserConfigurationException e ) {
				throw new IOException( "The WSDL could not be imported in the project.", e );
			}
		}

		monitor.worked( 2 );


		// Prepare the save operations
		Map<Object,Object> saveOptions = new HashMap<Object,Object> ();
		saveOptions.put( BPELWriter.SKIP_AUTO_IMPORT, Boolean.TRUE );

		ResourceSet resourceSet = WsdlParser.createBasicResourceSetForWsdl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put( "bpel", new BPELResourceFactoryImpl());
		resourceSet.getPackageRegistry().put( PartnerlinktypePackage.eNS_URI, PartnerlinktypePackage.eINSTANCE );
		resourceSet.getPackageRegistry().put( BPELPackage.eNS_URI, BPELPackage.eINSTANCE );


		// Create the WSDL for the artifacts
		monitor.subTask( "Generating the WSDL for the artifacts..." );
		Definition artifactsDefinition = generateWsdlArtifacts( monitor, newWsdlUrl );
		IFile wsdlFile = this.targetFile.getParent().getFile( new Path( computeWsdlArtifactsName()));
		URI emfUri = URI.createPlatformResourceURI( wsdlFile.getFullPath().toString(), true );

		Resource resource = resourceSet.createResource( emfUri );
		resource.getContents().add( artifactsDefinition );
		resource.save( saveOptions );
		monitor.worked( 2 );


		// Create the process
		monitor.subTask( "Generating the BPEL file..." );
		Process bpelProcess = generateBpelProcess( monitor, artifactsDefinition, newWsdlUrl );
		emfUri = URI.createPlatformResourceURI( this.targetFile.getFullPath().toString(), true );

		resource = resourceSet.createResource( emfUri );
		resource.getContents().add( bpelProcess );
		resource.save( saveOptions );
		monitor.worked( 2 );


		// Hack: if the process is abstract, replace the name space,
		// since it is not supported by the meta-model
		if( this.firstPage.isAbstractProcess()) {
			java.net.URI fileUri =  this.targetFile.getLocation().toFile().toURI();
			String newContent = WsdlImportHelper.readResourceContent( fileUri );
			newContent = newContent.replace( BPELConstants.NAMESPACE, BPELConstants.NAMESPACE_ABSTRACT_2007 );

			InputStream is = new ByteArrayInputStream( newContent.getBytes());
			this.targetFile.setContents( is, true, false, monitor );
			monitor.worked( 2 );
		}
	}


	/**
	 * Generates a WSDL for the artifacts.
	 * @param monitor a progress monitor
	 * @param newWsdlUrl the URL of the business WSDL (as to put in the import declaration)
	 * @return the created definition (to serialize)
	 */
	@SuppressWarnings( "unchecked" )
	private Definition generateWsdlArtifacts( IProgressMonitor monitor, String newWsdlUrl ) {

		PortType portType = this.portTypePage.getPortType();
		Definition businessDefinition = (Definition) portType.eContainer();
		Definition artifactsDefinition = WSDLFactory.eINSTANCE.createDefinition();
		artifactsDefinition.setTargetNamespace( businessDefinition.getTargetNamespace() + "Artifacts" );

		// Hack for the role: we need to define manually the name space prefix for the TNS of the business WSDL
		artifactsDefinition.getNamespaces().put( "tns", businessDefinition.getTargetNamespace());

		// WSDL import
		Import wsdlImport = WSDLFactory.eINSTANCE.createImport();
		wsdlImport.setLocationURI( newWsdlUrl );
		wsdlImport.setNamespaceURI( businessDefinition.getTargetNamespace());
		artifactsDefinition.addImport( wsdlImport );

		// Partner Link Type
		PartnerLinkType plType = PartnerlinktypeFactory.eINSTANCE.createPartnerLinkType();
		plType.setName( portType.getQName().getLocalPart() + "PLT" );

		Role plRole = PartnerlinktypeFactory.eINSTANCE.createRole();
		plRole.setName( portType.getQName().getLocalPart() + "Role" );
		plRole.setPortType( portType );

		plType.getRole().add( plRole );
		artifactsDefinition.getEExtensibilityElements().add( plType );
		plType.setEnclosingDefinition( artifactsDefinition );

		return artifactsDefinition;
	}


	/**
	 * Generates a BPEL process.
	 * @param monitor a progress monitor
	 * @param artifactsDefintion the artifacts definition
	 * @param newWsdlUrl the URL of the business WSDL (as to put in the import declaration)
	 * @return the created process (to serialize)
	 */
	private Process generateBpelProcess( IProgressMonitor monitor, Definition artifactsDefinition, String newWsdlUrl ) {

		PortType portType = this.portTypePage.getPortType();
		Definition businessDefinition = (Definition) portType.eContainer();

		Process bpelProcess = BPELFactory.eINSTANCE.createProcess();
		bpelProcess.setName( this.targetFile.getName());
		bpelProcess.setTargetNamespace( businessDefinition.getTargetNamespace());
		bpelProcess.setPartnerLinks( BPELFactory.eINSTANCE.createPartnerLinks());
		bpelProcess.setVariables( BPELFactory.eINSTANCE.createVariables());


		// Import the business definition
		org.eclipse.bpel.model.Import bpelImport = BPELFactory.eINSTANCE.createImport();
		bpelImport.setLocation( newWsdlUrl );
		bpelImport.setNamespace( businessDefinition.getTargetNamespace());
		bpelImport.setImportType( WSDLConstants.WSDL_NAMESPACE_URI );
		bpelProcess.getImports().add( bpelImport );


		// Import the artifacts definition
		bpelImport = BPELFactory.eINSTANCE.createImport();
		bpelImport.setLocation( computeWsdlArtifactsName());
		bpelImport.setNamespace( businessDefinition.getTargetNamespace() + "Artifacts" );
		bpelImport.setImportType( WSDLConstants.WSDL_NAMESPACE_URI );
		bpelProcess.getImports().add( bpelImport );


		// Create the main partner link
		PartnerLink pl = BPELFactory.eINSTANCE.createPartnerLink();
		for( Object elt : artifactsDefinition.getEExtensibilityElements()) {
			if( ! ( elt instanceof PartnerLinkType ))
				continue;

			pl.setPartnerLinkType((PartnerLinkType) elt);
			pl.setName( "bpelProcessPartner" );
			pl.setMyRole(((PartnerLinkType) elt).getRole().get( 0 ));
			bpelProcess.getPartnerLinks().getChildren().add( pl );
			break;
		}


		// Prepare the flow itself
		Sequence mainSequence = BPELFactory.eINSTANCE.createSequence();
		mainSequence.setName( "MainSequence" );
		bpelProcess.setActivity( mainSequence );

		Pick mainPick = BPELFactory.eINSTANCE.createPick();
		mainPick.setName( "SwitchInvokedOperation" );
		mainPick.setCreateInstance( true );
		mainSequence.getActivities().add( mainPick );


		// Create the variables: they are deduced from the port type to "implement"
		Collection<Definition> definitions = WsdlParser.findAllWsdlDefinitions( businessDefinition );
		for( Object o : portType.getOperations())
			addOperationDerivedElements((Operation) o, bpelProcess, mainPick, pl, definitions );

		return bpelProcess;
	}


	/**
	 * Creates the required variables and activities to handle an invocation to this operation.
	 * @param operation the operation
	 * @param bpelProcess the BPEL process
	 * @param mainPick the main pick
	 * @param partnerLink the partner link associated with the various activities
	 * @param definitions all the definitions related to the business interface (in case information should be searched in them)
	 */
	private void addOperationDerivedElements( Operation operation, Process bpelProcess, Pick mainPick, PartnerLink partnerLink, Collection<Definition> definitions ) {

		String opName = BPELUtil.lowerCaseFirstLetter( operation.getName());

		// Input: create the variable...
		Variable var = BPELFactory.eINSTANCE.createVariable();
		var.setName( opName + "Request" );
		findAndSetVariableXmlType( var, operation.getEInput().getEMessage().getQName(), definitions );
		bpelProcess.getVariables().getChildren().add( var );

		// ... and add an OnMessage activity
		OnMessage onMessage = BPELFactory.eINSTANCE.createOnMessage();
		onMessage.setPartnerLink( partnerLink );
		onMessage.setVariable( var );
		onMessage.setOperation( operation );
		mainPick.getMessages().add( onMessage );


		// Output: if it exists...
		if( operation.getOutput() != null ) {

			// Create the variable...
			var = BPELFactory.eINSTANCE.createVariable();
			var.setName( opName + "Response" );
			findAndSetVariableXmlType( var, operation.getEOutput().getEMessage().getQName(), definitions );
			bpelProcess.getVariables().getChildren().add( var );

			// And add a Reply activity
			Reply reply = BPELFactory.eINSTANCE.createReply();
			reply.setName( "ReplyTo" + BPELUtil.upperCaseFirstLetter( opName ));
			reply.setVariable( var );
			reply.setOperation( operation );
			reply.setPartnerLink( partnerLink );
			onMessage.setActivity( reply );

		} else {
			onMessage.setActivity( BPELFactory.eINSTANCE.createEmpty());
		}


		// Faults
		if( operation.getFaults() != null ) {
			for( Object oo : operation.getFaults().values()) {
				Fault fault = (Fault) oo;
				var = BPELFactory.eINSTANCE.createVariable();
				var.setName( opName + fault.getName());
				findAndSetVariableXmlType( var, fault.getEMessage().getQName(), definitions );
				bpelProcess.getVariables().getChildren().add( var );
			}
		}
	}


	/**
	 * Finds and sets the XML type for a variable associated with a given WSDL message.
	 * @param variable the variable whose XML type must be set
	 * @param messageName the name of the WSDL message
	 * @param definitions the list of definitions the message part
	 */
	private void findAndSetVariableXmlType( Variable variable, QName messageName, Collection<Definition> definitions ) {

		// Find and set the variable's type
		boolean found = false;
		boolean processed = false;
		for( Definition def : definitions ) {
			for( Object o : def.getEMessages()) {
				Message msg = (Message) o;
				if( ! ( messageName.equals( msg.getQName())))
					continue;

				found = true;
				if( msg.getEParts().size() == 1 ) {
					processed = true;

					Part part = (Part) msg.getEParts().get( 0 );
					if( part.getTypeDefinition() != null )
						variable.setType( part.getTypeDefinition());
					else if( part.getElementDeclaration() != null )
						variable.setXSDElement( part.getElementDeclaration());
				}
			}
		}


		// Log possible errors
		if( ! found )
			BPELUIPlugin.log( new Exception( "The message " + messageName + " could not be found." ), IStatus.ERROR );
		else if( ! processed )
			BPELUIPlugin.log( new Exception( "The message " + messageName + " contains more than 1 part. This case is not supported." ), IStatus.ERROR );
		else if( variable.getXSDElement() == null && variable.getType() == null )
			BPELUIPlugin.log( new Exception( "The XML type could not be set for the variable " + variable.getName() + ". Please, report a bug." ), IStatus.ERROR );
	}


	/**
	 * @return the name of the WSDL file for the artifacts
	 */
	private String computeWsdlArtifactsName() {
		IPath path = new Path( this.targetFile.getName());
		return path.removeFileExtension().toString() + "Artifacts.wsdl";
	}
}
