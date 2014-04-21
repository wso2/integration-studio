/*******************************************************************************
 * Copyright (c) 2008, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.ui;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.wst.sse.core.internal.provisional.INodeAdapter;
import org.eclipse.wst.sse.core.internal.provisional.INodeNotifier;
import org.eclipse.wst.xsd.ui.internal.util.ModelReconcileAdapter;
import org.w3c.dom.Document;

public class BPELModelAdapter implements INodeAdapter
{
  protected ResourceSet resourceSet;
  protected Process process;
  private ModelReconcileAdapter modelReconcileAdapter;

  public Process getProcess()
  {
    return process;
  }

  public void setProcess(Process process)
  {
    this.process = process;
  }

  public boolean isAdapterForType(Object type)
  {
    return type == BPELModelAdapter.class;
  }

  public void notifyChanged(INodeNotifier notifier, int eventType, Object changedFeature, Object oldValue, Object newValue, int pos)
  {
  }

   /*public Definition createDefinition(final Document document)
  {
    try
    {
      IDOMNode domNode = (IDOMNode) document;
      String baseLocation = "blankWSDL.wsdl"; //$NON-NLS-1$
      if (domNode != null)
      {
        baseLocation = domNode.getModel().getBaseLocation();
      }
      else if (document instanceof IDOMNode)
      {
        IDOMModel domModel = ((IDOMNode) document).getModel();
        baseLocation = domModel.getBaseLocation();
      }
      resourceSet = new ResourceSetImpl();

      //FIXME do we need it?
      //resourceSet.getAdapterFactories().add(new WSDLModelLocatorAdapterFactory());
      //resourceSet.getAdapterFactories().add(new XSDSchemaLocationResolverAdapterFactory());
      // TODO.. .revist the best approach to obtain a URI from the SSE model
      //
      URI uri = null;
      if (baseLocation.startsWith("/")) //$NON-NLS-1$
      {
        uri = URI.createPlatformResourceURI(baseLocation);
      }
      else
      {
        uri = URI.createFileURI(baseLocation);
      }
      definition = WSDLFactory.eINSTANCE.createDefinition();
      definition.setDocumentBaseURI(uri.toString());
      definition.setDocument(document);

      WSDLResourceFactoryImpl resourceFactory = new WSDLResourceFactoryImpl();
      Resource resource = resourceFactory.createResource(uri);
      resourceSet.getResources().add(resource);
      resource.getContents().add(definition);
      resource.setModified(false);

      IRunnableWithProgress setElementOperation = new IRunnableWithProgress()
      {
        public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException
        {
          // Use the animated flavour as we don't know beforehand how many ticks we need.
          // The task name will be displayed by the code in WSDLResourceImpl and XSDResourceImpl.
          
          monitor.beginTask("", IProgressMonitor.UNKNOWN); //$NON-NLS-1$

          Map loadOptions = resourceSet.getLoadOptions();
          
          loadOptions.put(WSDLResourceImpl.WSDL_PROGRESS_MONITOR, monitor);
          loadOptions.put(XSDResourceImpl.XSD_PROGRESS_MONITOR, monitor);
          
          definition.setElement(document.getDocumentElement());
          ((DefinitionImpl) definition).reconcileReferences(true);
          
          loadOptions.remove(WSDLResourceImpl.WSDL_PROGRESS_MONITOR);
          loadOptions.remove(XSDResourceImpl.XSD_PROGRESS_MONITOR);
        }
      };

      IProgressService progressService = PlatformUI.getWorkbench().getProgressService();
      try
      {
        progressService.busyCursorWhile(setElementOperation);
      }
      catch (InvocationTargetException e)
      {
        e.printStackTrace();
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }             
      
      // attach an adapter to keep the WSDL model and DOM in sync
      //
      modelReconcileAdapter = new WSDLModelReconcileAdapter(document, definition);
      domNode.getModel().addModelStateListener(modelReconcileAdapter);
      
      // TODO... CS : revisit this line
      // currently this is used to associate a 'type' system with the definition
      // I suspect that this could be made a whole lot more simple
      //
      WSDLEditorUtil.getInstance().setTypeSystemProvider(definition, new ExtensibleTypeSystemProvider());
    }
    catch (Exception ex)
    {
      ex.printStackTrace();
    }
    return definition;
  }*/
  
  public ModelReconcileAdapter getModelReconcileAdapter()
  {
    return modelReconcileAdapter;
  }  
  
  public static BPELModelAdapter lookupOrCreateModelAdapter(Document document)
  {
    BPELModelAdapter adapter = null;
    if (document instanceof INodeNotifier)
    {
      INodeNotifier notifier = (INodeNotifier)document;
      adapter = (BPELModelAdapter)notifier.getAdapterFor(BPELModelAdapter.class);
      if (adapter == null)
      {
        adapter = new BPELModelAdapter();       
        notifier.addAdapter(adapter);        
      } 
    }   
    return adapter;
  }  
}
