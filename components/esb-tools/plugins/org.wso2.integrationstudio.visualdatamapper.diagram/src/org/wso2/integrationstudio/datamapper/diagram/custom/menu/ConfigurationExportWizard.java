package org.wso2.integrationstudio.datamapper.diagram.custom.menu;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.wso2.integrationstudio.datamapper.DataMapperRoot;
import org.wso2.integrationstudio.datamapper.diagram.custom.persistence.DataMapperModelTransformer;
import org.wso2.integrationstudio.datamapper.diagram.part.DataMapperDiagramEditor;

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
		/*Cannot call static/singleton methods of Editor, need to find an alternative option
		//DataMapperRoot rootDiagram = (DataMapperRoot) DataMapperDiagramEditor.getInstance().getDiagram().getElement();
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
		*/

		return true;
	}

	public void init(IStructuredSelection selection2) {
		this.selection = selection2;
	}

}
