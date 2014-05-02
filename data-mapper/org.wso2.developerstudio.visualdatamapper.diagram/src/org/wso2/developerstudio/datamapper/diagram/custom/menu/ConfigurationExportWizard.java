package org.wso2.developerstudio.datamapper.diagram.custom.menu;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.internal.dialogs.ExportWizard;
import org.wso2.developerstudio.datamapper.diagram.custom.generator.MappingModelNavigator;

import org.wso2.developerstudio.datamapper.DataMapperRoot;
import org.wso2.developerstudio.datamapper.diagram.custom.persistence.DataMapperConfigurationGenerator;
import org.wso2.developerstudio.datamapper.diagram.custom.persistence.DataMapperModelTransformer;
import org.wso2.developerstudio.datamapper.diagram.part.DataMapperDiagramEditor;
import org.wso2.developerstudio.datamapper.diagram.part.DataMapperMultiPageEditor;

@SuppressWarnings("restriction")
public class ConfigurationExportWizard extends Wizard {

	private ConfigurationExportWizardPage page;
	private ISelection selection;

	public ConfigurationExportWizard() {
		super();
		setNeedsProgressMonitor(true);
	}

	// @Override
	// public void init(IWorkbench workbench, IStructuredSelection selection) {
	// this.selection = selection;
	// }

	public void addPages() {
		page = new ConfigurationExportWizardPage(selection);
		addPage(page);
	}

	@Override
	public boolean performFinish() {

		// create file, run configuration generation , put it to file

		DataMapperRoot rootDiagram = (DataMapperRoot) DataMapperMultiPageEditor.getGraphicalEditor().getDiagram().getElement();
		String input = DataMapperModelTransformer.getInstance().transform(rootDiagram);

		File config = new File(page.getConfigExportrPath(), (page.getConfigurationFileName() + ".js"));

		try {
			BufferedWriter output = new BufferedWriter(new FileWriter(config));
			output.write(input);
			output.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}

	public void init(IStructuredSelection selection2) {
		this.selection = selection2;
	}

}
