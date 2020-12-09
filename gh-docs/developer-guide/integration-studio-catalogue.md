# WSO2 Integration Studio Catalog

WSO2 Integration Studio is an Eclipse Oxygen based development environment used to design your integration scenarios and develop them. It can be used to develop services, features, and artifacts as well as manage their links and dependencies through a simplified graphical editor. It provides inbuilt debugging and testing capabilities to troubleshoot and identify the integration aspects while creating the artifacts. Furthermore, WSO2 Integration Studio offers different deployment approaches, including CAR (Carbon Application Archive) deployment, docker deployment, kubernetes deployment, WSO2 integration cloud deployment, etc., to cater your CI/CD (Continuous Integration/Continuous Development) requirements.

## Table of Content

* [High Level Architecture](#High-Level-Architecture)
* [Introduction to the repos](#Introduction-to-the-repos)
    * [Integration Studio Kernel](#Integration-Studio-Kernelhttpsgithubcomwso2developer-studio)
    * [Integration Studio Platform](#Integration-Studio-Platformhttpsgithubcomwso2devstudio-tooling-platform)
    * [ESB Tooling](#ESB-Toolinghttpsgithubcomwso2devstudio-tooling-esb)
    * [DSS Tooling](#DSS-Toolinghttpsgithubcomwso2devstudio-tooling-dss)
    * [BPS Tooling](#BPS-Toolinghttpsgithubcomwso2devstudio-tooling-bps)
    * [Integration Studio EI](#Integration-Studio-EIhttpsgithubcomwso2devstudio-tooling-ei)
* [Introduction on Integration Studio package components](#Introduction-on-Integration-Studio-package-components)
* [Setting up Integration Studio for developers](#Setting-up-Integration-Studio-for-Developers)
* [Running Integration Studio in Developer Mode](#Running-Integration-Studio-in-Developer-Mode)
* [Introduction to all the plugins](#Introduction-to-all-the-plugins)
* [Introduction to major classes in Integration Studio](#Introduction-to-major-classes-in-Integration-Studio)
    * [AbstractMediator](#AbstractMediator)
    * [ESBMultipageEditor](#ESBMultiPageEditor)
* [Feature Development on Integration Studio](#Feature-Development-on-Integration-Studio)
    * [Create a new eclipse plugin](#Create-a-new-eclipse-plugin)
    * [Add a new mediator](#Add-a-new-mediator)
    * [Add a new extension point](#Add-a-new-extension-point)
        * [Add a item under New option in right click context menu](#Add-a-item-under-“New”-option-in-right-click-context-menu)
        * [Add a sample menu (with sample command)](#Add-a-sample-menu-with-sample-command)
        * [Add a toolbar extension](#Add-a-toolbar-extension)
    * [Add a new wizard form](#Add-a-new-wizard-form)
    * [Add a new dialog box](#Add-a-new-dialog-box)
    * [Add a new editor](#Add-a-new-editor)
    * [Add a new Web UI with Jetty server](#Add-a-new-web-UI-with-the-servlet-Jetty-server)
    * [Add a sample to the getting started page](#Add-a-new-sample-to-the-getting-started-page)
* [Introduction to DataMapper](#Introduction-to-the-DataMapper)
    * [Components](#Components)
    * [AI-Based Datamapper](#AI-Based-Datamapper) 
* [Managing dependencies from Product EI](#Managing-dependencies-from-Product-EI)
* [Threading in Integration Studio](#Threading-in-Integration-Studio)
    * [Singled-threaded UI](#Singled-threaded-UI)
    * [syncExec()](#syncExec)
    * [asyncExec()](#asyncExec)
    * [Java Threading](#Java-Threading)
* [UI element drag and drop mathematical calculations](#UI-element-drag-and-drop-mathematical-calculations)
* [EI connector codebase](#EI-connector-codebase) 
    * [Older Properties view](#Older-Properties-view)
    * [New Properties view](#New-Properties-view)
    * [New Connection Configuration](#New-Connection-Configuration)
    * [Steps for writing a descriptor for connector operations
](#Steps-for-writing-a-descriptor-for-connector-operations)
    * [Steps for writing descriptor for connector connection
](#Steps-for-writing-descriptor-for-connector-connection)
    * [Steps to packing the UI descriptors to the connector
](#Steps-to-packing-the-UI-descriptors-to-the-connector)
    * [Sample descriptors](#Sample-descriptors)
* [Hosting an update for Integration Studio](#Hosting-an-update-for-Integration-Studio)
* [Releasing Integration Studio new version](#Releasing-Integration-Studio-new-version)
* [Creating DMG for macOS](#Creating-DMG-for-macOS)


## High Level Architecture
This section describes the overall architecture of the Integration Studio.
 
![](https://i.imgur.com/dpc4WLw.png)


* **A->** GMF uses the EMF model to generate graphical elements, tool palette, etc.
* **B->** GEF (a lightweight graphical framework, based on MVC architecture) creates the Controller Classes for graphical objects of GMF.
* **C->** Integration Studio uses the GMF generated Graphical objects to create synapse mediation on a drag and drop interface.
* **D->** EEF framework uses the EMF model to generate the properties’ view for mediators, proxies, and other synapse artifacts.
* **E->** The Integration Studio uses an EEF generated Properties view as the view to configure the properties of synapse components.


### Eclipse EMF Framework
Eclipse EMF is a modeling framework, and it provides a code generation facility for building tools and other applications based on a structured data model. From a model specification described in XMI, EMF provides tools and runtime support to produce a set of Java classes for the model along with a set of adapter classes that enables viewing and command-based editing of the model, and a basic editor.

### Eclipse GMF Framework
The GMF Runtime is an application framework for creating graphical editors using EMF and GEF. GMF generates reusable components for graphical editors(ESB editor) such as drag and drop actions and toolbars(Mediator Palette), and much more. It is a standardized model to describe diagram elements which separates between the semantic (domain) and notation (diagram) elements. A command infrastructure that bridges the different command frameworks is used by EMF and GEF.
### Eclipse GEF Framework
The Eclipse Graphical Editing Framework (GEF) provides Eclipse-integrated end-user tools in terms of Graph visualization (The graphical components of the Integration Studio follow a graph style representation)
### Eclipse EEF Framework
EEF is a presentation framework for the Eclipse Modeling Framework (EMF). It allows users to create rich user interfaces (Properties view of ESB components like mediators, proxies, API resources, Inbound Endpoints, etc.) to edit EMF models.

### How is the Integration Studio designed with Eclipse Frameworks?
The Integration Studio IDE is an Eclipse Oxygen based Rich Client Platform(RCP). All the synapse level constructs (including mediators, proxies, inbound endpoints, etc), are first described as an XMI model using the Eclipse Modeling Framework(EMF). The EMF XMI model is in the devstudio-tooling-esb repository: https://github.com/wso2/devstudio-tooling-esb/blob/master/plugins/org.wso2.developerstudio.eclipse.gmf.esb/model/esb.ecore
Then, the EMF framework generates the model classes for the MVC architecture. 
The EMF generated classes include Mediators(Interface of the model), and MediatorImpl(model).

GMF “provides a generative component and runtime infrastructure for developing graphical editors based on EMF and GEF”, that is, it acts as a bridge between EMF (that allows the model definition) and GEF (a lightweight graphical framework, based on MVC architecture), generating the complete infrastructure needed to coordinate the model objects’ lifecycle (EMF EObject) and their corresponding graphical representation (GEF EditPart).
All the GMF related model files can be found at https://github.com/wso2/devstudio-tooling-esb/tree/master/plugins/org.wso2.developerstudio.eclipse.gmf.esb/model

Finally, using the EEF framework, the Classes related to the Properties view are generated. The EEF model is deduced from the EMF model(.ecore file). The EEF model is hosted at https://github.com/rosensilva/devstudio-tooling-esb/blob/ec4f86d2a46bb23a6a1933b65bcf3e4603375253/plugins/org.wso2.developerstudio.eclipse.gmf.esb.edit/model/esb.components

# Introduction to the repos

## Integration Studio Kernel(https://github.com/wso2/developer-studio)


WSO2 Developer Studio Kernel provides a set of common plugins, which can be used to develop Eclipse plugins for WSO2 products that are based on WSO2 Carbon platform. All the product specific plugins will use the Developer Studio Kernel as the base for their respective tooling implementation.

#### Integration Studio kernel has following key capabilities

* A UI toolkit that will generate UIs using XML instead of visually designing
* A platform and a framework to use web technologies for plugin development
* Large number of reusable built-in UI Component for plugin development (SWT Composites)
* Built-in template support for rapid development
* Provide Maven utilities to add maven support for developed plugins
* Built in support for CApp and Carbon servers
* Seamless integration with Eclipse, Developer Studio kernel and other plugin features using extension points

## Integration Studio Platform(https://github.com/wso2/devstudio-tooling-platform)
WSO2 Developer Studio Platform acts as a middle layer from Devleoper Studio Kernel to Developer Studio product Tooling by bridging the gap for carbon specific requirement implementation on top of Eclipse.

#### WSO2 Developer Studio Platform has following key capabilities

* Provide Maven utilities to add maven support for developed plugins
* Built in support for CApp and Carbon servers
* Seamless integration with Eclipse, Developer Studio kernel and other plugin features using extension points
* Connectivity to Carbon Servers and WSO2 cloud
* Developer Studio Platform will provide comprehensive support for developing tools and speedup the development process by providing generic Carbon based implementations and requirements.

## ESB Tooling(https://github.com/wso2/devstudio-tooling-esb)
WSO2 ESB tooling provides capabilities of a complete eclipse-based development environment for the ESB. You can develop services, features and artifacts as well as manage their links and dependencies through a simplified graphical editor via WSO2 ESB tooling. 
#### WSO2 ESB Tooling has the following key capabilities
* Develop ESB configurations (Proxy, API, Sequence, etc.) for the runtime
* Debug ESB configurations using the mediation debugger
* Mapping data across different formats using data mapper
* Deploying ESB configurations directly to local and remote ESB instances
* Provides a graphical editor to build ESB configurations in a drag and drop manner

## DSS Tooling(https://github.com/wso2/devstudio-tooling-dss)
WSO2 DSS tooling provides capabilities of a complete eclipse-based development environment for the DSS. You can develop dss artifacts through a simplified graphical editor via WSO2 DSS tooling.
#### WSO2 DSS Tooling has following key capabilities
Develop Data Services for the runtime Develop Data Source configurations Deploy DSS configurations directly to local and remote DSS instances Provides a graphical editor to develop Data Services configurations

## BPS Tooling(https://github.com/wso2/devstudio-tooling-bps)
BPS Tooling repo is maintained for the Business Process development of WSO2 Enterprise Integrator. Devstudio Tooling for BPS project contains two main components,
* BPEL Editor
* Human Task Editor

## Integration Studio EI(https://github.com/wso2/devstudio-tooling-ei)
Integration Studio EI contains the source code to create Eclipse RCP(Rich Client Application) for WSO2 Enterprise Integrator. This will package all the WSO2 Enterprise Integrator tooling plugins into one WSO2 branded eclipse based RCP application. Also, this will contain the packaging of third-party components such as Adopt OpenJDK, Maven, WSO2 Micro-integrator, WSO2 Monitoring dashbord, HTTP4e client, etc.

# Introduction on Integration Studio package components

# Setting up Integration Studio for Developers
1. Download [Eclipse IDE Oxygen IDE](https://www.eclipse.org/downloads/packages/release/oxygen/3a) based on the OS [Eclipse IDE for Java EE Developers]
2. Use [JDK 8u202](https://www.oracle.com/java/technologies/javase/javase8-archive-downloads.html) for development(Other java versions might not work).
3. Import the Kernel source to eclipse. 
    * Clone Integration Studio kernal repository https://github.com/wso2/developer-studio.
    * Switch to **developer-studio-kernel-4.3.0_update** branch
    * Build the branch using maven
    * Import the **plugins directory** to the eclipse workspace by  selecting **File -> Import -> General -> Existing Projects into workspace** 
    * Untick the **plugins** project (if it is there) and select the rest of the plugins when importing the plugins folder

4. Import the Platform source to eclipse. 
    * Clone Integration Studio platform repository https://github.com/wso2/devstudio-tooling-platform.
    * Import the **plugins directory** to the eclipse workspace by  selecting **File -> Import -> General -> Existing Projects into workspace** 
    * Untick the **plugins** project (if it is there) and select the rest of the plugins when importing the plugins folder

5. Import the ESB source to eclipse. 
    * Clone Integration Studio platform repository https://github.com/wso2/devstudio-tooling-esb.
    * Import the **plugins directory** to the eclipse workspace by  selecting **File -> Import -> General -> Existing Projects into workspace** 
    * Untick the **plugins** project (if it is there) and select the rest of the plugins when importing the plugins folder

6. Import the EI source to eclipse. 
    * Clone Integration Studio platform repository https://github.com/wso2/devstudio-tooling-ei.
    * Import the **plugins directory** to the eclipse workspace by  selecting **File -> Import -> General -> Existing Projects into workspace** 
    * Untick the **plugins** project (if it is there) and select the rest of the plugins when importing the plugins folder

7. Install Modeling features(EMF) to eclipse
    * Click on Help -> Install New Software
    * Select **Oxygen - http://download.eclipse.org/releases/oxygen/** from work with drop down list 
    * Click on **Modeling** checkbox in the install window
    * Then untick **Contact all updates sites during install to find required software** and Click on **Next**
    * Then you will get Install details page, again click on **Next**
    * Then in the Review Licenses page (Select one licence form the list), click on **I accept the terms of the license agreements** and click on **Finish**
    * It will take sometime to install the software, during the process you will get a security warning pop-up, click on **Install anyway**.
    * Then it will ask to restart the server, click on **Yes**.

8. Install GMF related tooling runtime for oxygen, using the p2. (some features might not be able to install but install what is allowed)
    * Click on **Help** -> Install New Software
    * Click on **Add** -> Add the url http://download.eclipse.org/modeling/gmp/gmf-tooling/updates/releases/ into **Location**, and click OK.
    * Select only **GMF Tooling** from the dropdown list.
    * Then untick **Contact all updates sites during install to find required software** and Click on **Next**
    * Then, you will get the Install details page, again click on **Next**.
    * In the next page, accept the licence (Select **I accept the terms of the license agreements** and click on **Finish**)
    * It will take sometime to install the selected software.
    * Finally, it will ask to restart the eclipse, click on **Yes**.

9. Copy micro-integrator runtime eclipse 
    * Create a directory under the eclipse directory (macOS: /Applications/Eclipse.app/Contents/Eclipse/, Linux/Windows /eclipse directory) as **/runtime/microesb/** 
    * Download and copy the contents of micro integrator runtime to the folder created in the above step


10. [Optional - add only if you need to work on DSS] Import DSS and BPS Source to eclpise.
    * Clone Integration Studio DSS repository https://github.com/wso2/devstudio-tooling-dss.
    * Import the **plugins directory** to the eclipse workspace by  selecting **File -> Import -> General -> Existing Projects into workspace** 
    * Untick the **plugins** project (if it is there) and select the rest of the plugins when importing the plugins folder

11. [Optional - add only if you need to work on BPS] Import BPS and BPS Source to eclpise.
    * Clone Integration Studio DSS repository https://github.com/wso2/devstudio-tooling-bps.
    * Import the **plugins directory** to the eclipse workspace by  selecting **File -> Import -> General -> Existing Projects into workspace** 
    * Untick the **plugins** project (if it is there) and select the rest of the plugins when importing the plugins folder

12. Apply WSO2 code style settings file for Eclipse.
    * Download [wso2-codestyle-eclipse-clean-up.xml](http://wso2-oxygen-tank.10903.n7.nabble.com/attachment/23355/0/wso2-codestyle-eclipse-clean-up.xml). 
    * Go to **windows > Preference > Java > Code Style >Clean up** and import **wso2-codestyle-eclipse-clean-up.xml**.
    * Download [wso2-codestyle-eclipse-formatter.xml](http://wso2-oxygen-tank.10903.n7.nabble.com/attachment/23355/1/wso2-codestyle-eclipse-formatter.xml).
    * Go to **windows > Preference > Java > Code Style >Formatter** and import **wso2-codestyle-eclipse-formatter.xml**.
 

# Running Integration Studio in Developer Mode

* Running the tool from the source
    1. Right click on an imported plugin
    2. Click on Run As -> Run Configurations
    3. Create a new Eclipse Application
    4. Click on Run
    
    This will open an eclipse instance which contains tooling plugins

* Debugging the source
    1. Right click on an imported plugin
    2. Click on Debug As -> Debug Configurations
    3. Create a new Eclipse Application
    4. Click on Debug

* **[Important]** For macOS 
Go to **Run -> Run configuration -> Select eclipse run configuration -> Select Arguments tab** and add **-nosplash** as an argument

* To ignore all the **Plugin execurtion not covered by lifecycle configuration**  maven errors (pom.xml errors), please do the following steps.
    1. Navigate to Preferences window
    2. Search Maven
    3. Select Errors/Warning option under Maven
    4. Select Ignore option for Plugin execurtion not covered by lifecycle configuration 

# Introduction to all the plugins

## Kernal Plugins

1. **org.wso2.developerstudio.eclipse.kernel.libraries**
    * This plugin is used to add the third-party library jars that is required by the Integration Studio Kernal repository. This plugin contains the jar files and expose their required classes to be used by other kernal level packages

2. **org.wso2.developerstudio.eclipse.logging**
    * The logging plugin have the logger classes that is used for the Integration Studio logging

3. **org.wso2.developerstudio.eclipse.maven**
    * Maven related plugin for the maven support of the integration studio

4. **org.wso2.developerstudio.eclipse.platform.core**
    * Contains relovers for media types such as application/xml, application/yaml and other common media type extentions for files
    * This plugin will have delete and rename listners for file delete and rename operations(to modify artifact.xml files)
    * CApp export utils and other project export methods 

5. **org.wso2.developerstudio.eclipse.platform.ui**
    * Contains the Getting Started page handler
    * Startup code for Integration Studio ediotors
    * WSO2UIToolKit which is used across all the other plugins
    * Contains Project Creation wizard that is used for all the project creation wizards in the Integration Studio

6. **org.wso2.developerstudio.eclipse.updater**
    * Contains WSO2 Integration Studio Updater code-base

7. **org.wso2.developerstudio.eclipse.utils**
    * Contains helper methods and constants for Integration Studio

8. **org.wso2.developerstudio.eclipse.welcome.perspective**
    * Contains Integration Studio Welcome Perspective 

9. **org.wso2.developerstudio.eclipse.wso2plugin.template.manager**
    * This plugin contains the WSO2 Plugin Project related code

## Platform Plugins

1. **org.wso2.developerstudio.eclipse.capp.core**
    * Carbon Application related code 

2. **org.wso2.developerstudio.eclipse.carbonserver.base**
    * Base eclipse server abstraction for all the carbon servers including Enterprise Integrator and Micro Integrator

3. **org.wso2.developerstudio.eclipse.carbonserver.remote**
    * Contains the Carbon Remote Server code. The remote servers are used to connect to remote WSO2 server using port and URL

4. **org.wso2.developerstudio.eclipse.carbonserver40 - org.wso2.developerstudio.eclipse.carbonserver44**
    * These plugins have eclipse server abstraction for Older ESB servers before EI 6.0.0
5. **org.wso2.developerstudio.eclipse.carbonserver44ei**
    * Contains the Server plugin for Enterprise Integrator from version 6.0.0 to 6.6.0
    * Server definition is in the following path from the plugin serverdefinition/carbon.definition.xml

6. **org.wso2.developerstudio.eclipse.carbonserver44microei**
    * Server for Micro Integrator 1.0.0

7. **org.wso2.developerstudio.eclipse.carbonserver44microei11**
    * Server for Micro Integrator 1.1.0

8. **org.wso2.developerstudio.eclipse.carbonserver44microei12**
    * Server for Micro Integrator 1.2.0

9. **org.wso2.developerstudio.eclipse.dashboard**
    * Older version for Getting started page. Contains Open dashboard

10. **org.wso2.developerstudio.eclipse.distribution.project**
    * Contains the Composite Application Project(Composite Exporter Project) related code

11. **org.wso2.developerstudio.eclipse.docker.distribution**
    * This plugin contains the docker and kubernetes project related code. Including Docker/Kubernetes editors.

12. **org.wso2.developerstudio.eclipse.general.project**
    * The Registry Resource Project related code is under this plugin

13. **org.wso2.developerstudio.eclipse.libraries**
    * This plugin is used to add the third-party library jars that is required by the Integration Studio Platform repository. This plugin contains the jar files and expose their required classes to be used by other platform level packages

14. **org.wso2.developerstudio.eclipse.maven.multi.module**
    * This contain the Integration Project(Maven Multi Module Project in version prior to 7.1.0) related code.

15. **org.wso2.developerstudio.eclipse.project.extension**
    * Contains extension point to add project natures to developer studio
    * Templates for WSO2 Integration artifacts including proxy, syapse API, address endpoints, message store, etc.

16. **org.wso2.developerstudio.eclipse.registry.***
    * These plugins were use to connected remote wso2 registry to the Integration Studio(WSO2 Registry Perspective) 
    * base, connector, core, libraries, manager.local, manager.remote, perspective, resource.authorization, search are the plugins for the registry connection

17. **org.wso2.developerstudio.eclipse.templates.dashboard**
    * This plugin contain the Web Page for the Getting Stared Dashboard
    * All the HTML, CSS, JS scripts for Getting Started Pages can be located at /WelcomeDashboard

18. **org.wso2.developerstudio.eclipse.webui.core**
    * This plugin contains the Web Based Editor Abstract class(AbstractWebBasedEditor), which is used for all the Web Editors including Getting Started Page, Data Services Editor, Swagger Editor, etc.

## ESB Plugins

1. **developerstudio.eclipse.apim.endpoint.central**
    * Used to connect with WSO2 APIM Endpoint Registry. This feature is not active in the Integration Studio released pack as the strategy changed

2. **org.wso2.developerstudio.eclipse.apim.project**
    * This plugin was written to Import WSO2 APIM project into the Integration Studio. This feature also is not active in the released version as APIM strategy changed

3. **org.wso2.developerstudio.eclipse.artifact.***
    * **connector**- Code related to Connector Exporter Project

    * **endpoint**- This plugin contains the wizards for Endpoint artifacts creation and other Synapse endpoint related code.

    * **inboundendpoint**- This plugin contains the wizards for Inbound Endpoint artifacts creation and other Synapse inbound endpoint related code.

    * **localentry**- This contains the Synapse local-entry related artifact creation wizards and related code. 

    * **mediator**- This contains the Class mediator Project related artifact creation wizards and related code. 

    * **messageprocessor**- This contains the Synapse message-processor related artifact creation wizards and related code. 

    * **messagestore**- This contains the Synapse message-store related artifact creation wizards and related code.
    * **proxyservice**- This contains the Synapse proxy related artifact creation wizards and related code.
    * **sequence**- This contains the Synapse sequence related artifact creation wizards and related code.
    * **synapse.api**- This contains the Synapse API related artifact creation wizards and related code.
    * **task**- This contains the Synapse task related artifact creation wizards and related code.
    * **template.squence**- This contains the Synapse sequence-template related artifact creation wizards and related code.
     
4. **org.wso2.developerstudio.eclipse.esb.cloud**
    * This pluigin is use to deploy Integration Projects in the WSO2 Integration Cloud(Integration Cloud is now discontinued)

5. **org.wso2.developerstudio.eclipse.esb.core**
    * Contains synapse esb artifact resolvers(detect esb .xml files)
    * Other ESB Artifact Dependency related code

6. **org.wso2.developerstudio.eclipse.esb.dashboard.templates**
    * This plugin contains the samples(templates) for the scenarios in Getting Started Guide. 
    * Also, this contains the the classes that are required to extract the zipped samples create a new Integration Project using the sample

7. **org.wso2.developerstudio.eclipse.esb.docker**
    * Classes reuired to **'Generate Docker Image'** option in the context menu of Composite Exporter Project

8. **org.wso2.developerstudio.eclipse.esb.project**
    * This plugin is used to add the third-party library jars that is required by the Tooling ESB repository. This plugin contains the jar files and expose their required classes to be used by other ESB level packages

9. **org.wso2.developerstudio.eclipse.esb.synapse.unit.test**
    * Contains menu entries, wizards and other Synapse Unit test related code

10. **org.wso2.developerstudio.eclipse.esb.theme**
    * Contains Integration Studio Themes(Eclipse IDE Themes for WSO2 Integration Studio)
    * Theme files are eclipse css files located under themes/css directory inside the plugin

11. **org.wso2.developerstudio.eclipse.gmf.esb**
    * This is an important plugin in the Integration Studio devstudio-tooling-esb repository. 
    * This contains the Eclipse EMF, GMF models for WSO2 EI Synapse artifacts.
    * The ecore, genmodel, gmfgen, gmfmap, gmftool
    * The generated model classes for meditors and other synapse level objects are available in the plugin

12. **org.wso2.developerstudio.eclipse.gmf.esb.diagram**
    * This plugin contains the EditParts for the graphical elements. These editparts contains the Controller classes and View Classes with respcect to MVC architecture of the Tool.
    * This contains the cloud connector related code including adding the connector to the palatte from the zip file stored in the workspace
    * The Deseializer classews found on this plugin are responsible for read the xml synapse artifact and create a corresponding graphical synapse object in the tool.
    * All the logic related to drag and drop of the mediators are in this plugin 
    * Mediation debugging related code also reside in this plugin under org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.* packages
    * Swagger editor and respective web application is in this pluging. The webapp is under /swagger-editor in the plugin directory

13. **developerstudio.eclipse.gmf.esb.edit**
     * This plugin contains the classes for editing the EMF objects(eg- mediator configurations)
     * The UI and funtionalities of the Properties view are in this plugin

14. **org.wso2.developerstudio.eclipse.gmf.esb.persistence**
    * The persistance of the UI objects as synapse xml configurations will be done by Transformer Classes. The transformer classes for all the mediators and other synapse artifacts are in this plugin
    * Also, the Ext classes, that are used to mimic synapse classes can be  found inside this plugin. These dummy classes are used to replicate synapse behaviour without runtime dependencies

14. **org.wso2.developerstudio.esb.form.editors**
    * The form editors of Tooling are inside this plugin. Froms that we get for editing Endpoints, Schedule tasks, synapse unit test framework, etc. are located in this plugin

15. **org.wso2.developerstudio.visualdatamapper**
    * This plugin contain the Eclipse model for Datamapper related artifacts
    * This is the similar to **org.wso2.developerstudio.eclipse.gmf.esb** and it contains ecore, genmodel, gmfgen, gmfmap, gmftool models under the **/models/** directory
    * Also the Impl Classes(model objects in the MVC architecture) can be found in this plugin

16. **org.wso2.developerstudio.visualdatamapper.diagram**
    * Controller and view classes for data mapper objects(Mapping objects) are in this plugin.
    * Realtime data mapper preview Web UI is inside /HTMLages directory

17. **org.wso2.developerstudio.visualdatamapper.edit**
    * Contains the ItemProviders for datamapper elemets(eg- the properties view for data mapper Add operation)

18. **org.wso2.developerstudio.visualdatamapper.editor**
    * Contains the Eclipse Editor for the data mapper editor

19. **org.wso2.developerstudio.visualdatamapper.project**
    * Contains the Data mapper project , importing exporting wizards, new data mapper creation wizards, etc.

# Introduction to major classes in Integration Studio

## AbstractMediator
Qualified Name: org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractMediator

## ESBMultipageEditor

# Feature Development on Integration Studio

## Create a new eclipse plugin
You can implement new features for the Integration Studio using existing eclipse plugins(as mentioned in the above section) or by creating a new eclipse plugin. Here, you must have to identify the requirement and the relevant tooling repository before implementing the new plugin.

Follow the below steps to create a new Eclipse plugin.

1. Run the Eclipse.
2. Go to File -> New -> Project...
3. Go to Plug-In development -> Plug-in Project. Press Next.

![](https://i.imgur.com/PEPFqvS.png)

4. Type some project name. It's recommended to use org.*.* format, i.e. org.plugin.helloworld.

![](https://i.imgur.com/633XDiu.png)

5. Select the relevant location to create the new plugin.
6. Press Next.
(Optionally) Specify Plug-In Provider Name (print your brend nick or your company brand), and Plug-In Name. Press Next.

![](https://i.imgur.com/JJJ9TqF.png)

7. Select a "Hello, World" plug-in template. Press Finish.

![](https://i.imgur.com/geu3dXE.png)

8. Verify the created MANIFEST.MF file inside the new plugin with other plugin's MANIFEST.MF file (Bundle-Vendor, Bundle-Version, etc.)
9. Make sure that new plugin has been added as a sub module of the pom.xml file in parent directory. 

![](https://i.imgur.com/fOjbdjL.png)


If you are adding the new plugin as a feature, then add the new feature inside the **features** directory located in the tooling repository. For more information refer the existing plugins and features. 

Recently added feature - **org.wso2.developerstudio.eclipse.apim.feature** 
Recently added plugin - **org.wso2.developerstudio.eclipse.apim.project**

## Add a new mediator
A mediator can be added to WSO2 Integration Studio by configuring the following GMF models.
1. esb.ecore
2. esb.genmodel
3. esb.gmfgraph
4. esb.gmftool
5. esb.gmfmap
6. esb.gmfgen

Follow the below steps to develope the GMF model to add a new mediator.

It is always advisable to take an already developed mediator as a reference(log mediator/property mediator) and start to develop your own mediator. Also, it is recommended to save all the changes instantly to avoid issues. First, have a look at the Log Mediator. Following screenshot depicts Log mediator ecore model.

![](https://i.imgur.com/iYLmovp.png)

We can see the properties view consists of the attributes configured in the ecore model.

![](https://i.imgur.com/HFAsrf4.jpg)

Now let's see how to add a simple Calculator mediator to WSO2 Integration Studio. We have to start developing the GMF model. Note that we have to model all six sub-models of the GMF model(ecore, genmodel, gmfgraph, gmftool, gmfmap and gmfgen). Let’s start developing the sub-models one by one.

### ecore model
1. Go to the plugin “org.wso2.developerstudio.eclipse.gmf.esb” in the project explorer. Double click on it. Select model → esb.ecore

![](https://i.imgur.com/8MGRkTg.png)

2. Double click on “esb.ecore”. Select platform → esb.

![](https://i.imgur.com/aYWyOau.png)

3. Right click on the “esb” element(Only child element of the root) and create a new EClass by selecting New Child → EClass.

![](https://i.imgur.com/XQSsARQ.png)

4. Right click on the newly created EClass and click on “Show Properties View”. We will get properties view to update properties for newly created EClass.

![](https://i.imgur.com/EQKAtHI.png)

5. Set the name for EClass by adding “CalculatorMediator” for “Name” property.

![](https://i.imgur.com/V6ymiMo.png)

6. We need to set “ESuper Types”. Click on the button in the value section of ESuper Types.

![](https://i.imgur.com/1KWipqg.jpg)

7. Select “Mediator → EsbElement” and click on “Add” button. Click “OK”.

![](https://i.imgur.com/3vyj17Y.jpg)

![](https://i.imgur.com/h1HU0t4.png)

Now we need to add attributes to the Calculator mediator.

8. We are going to add input connector for the mediator first. Right click on CalculatorMediator and select New Child → EReference

![](https://i.imgur.com/e3uPaUT.png)

9. Set “inputConnector” for the Name property.

![](https://i.imgur.com/nv4LMtn.png)

10. Set Containment property to “true”

![](https://i.imgur.com/P5PwaNi.png)


11. We need to set EType for inputConnector. For this, we need to create EType first. Right click on the CalculatorMediator and select New Sibling → EClass.

![](https://i.imgur.com/th7V7H0.png)

12. Name newly created EClass as “CalcualtorMediatorInputConnector” and set InputConnector → EsbConnector for ESuper Types property.

![](https://i.imgur.com/yyaQcig.png)

13. Now we need to set CalcualtorMediatorInputConnector EClass as the “EType” of inputConnector reference. Click on the inputConnector reference of CalculatorMediator. Go to properties view and set CalcualtorMediatorInputConnector as the EType.

![](https://i.imgur.com/FPhnA62.png)

14. Then we are going to add output connector for the mediator. Right click on CalculatorMediator and select New Child → EReference

![](https://i.imgur.com/8GIZjwU.png)

15. Set “outputConnector” for the Name property.

![](https://i.imgur.com/Oz2ANVc.png)

16. Set Containment property to “true”

![](https://i.imgur.com/WhVGOHl.png)

17. We need to set EType for outputConnector. For this, we need to create EType first. Right click on the CalculatorMediator and select New Sibling → EClass.

![](https://i.imgur.com/Cw5q8mZ.png)

18. Name newly created EClass as “CalcualtorMediatorOutputConnector” and set OutputConnector → EsbConnector for ESuper Types property.

![](https://i.imgur.com/UVBfKq2.png)

19. Now we need to set CalcualtorMediatorOutputConnector EClass as the “EType” of outputConnector reference. Click on the outputConnector reference of CalculatorMediator. Go to properties view and set CalcualtorMediatorOutputConnector as the EType.

![](https://i.imgur.com/t1Fj6Se.png)

20. Save the file. Now, We have modeled the minimum structure for Calculator mediator to start with.

This ends the modeling of esb.ecore. There is a complete reference/sample for GMF at

https://wiki.eclipse.org/Graphical_Modeling_Framework/Tutorial/Part_1 and more parts are covered at https://wiki.eclipse.org/Graphical_Modeling_Framework/Tutorial/Part_2 and https://wiki.eclipse.org/Graphical_Modeling_Framework/Tutorial/Part_3
The above reference/sample will give a complete idea about how GMF works and its functionalities.

### esb.genmodel
Let’s move to “Model code generation” and “Edit code generation”. For Model and Edit code generation we need to use esb.genmodel.

1. Go to the plugin “org.wso2.developerstudio.eclipse.gmf.esb” in the project explorer. Double click on it. Select model → esb.genmodel

![](https://i.imgur.com/WVHqKBC.png)

2. Right click on esb.genmodel and click Reload…

![](https://i.imgur.com/ZpZq4j1.png)

3. Select the “Ecore model” from the list and Click Next.

![](https://i.imgur.com/NvbAJ3v.png)

4. We need to load the correct .ecore file. In our case it is esb.ecore. As shown in the below screenshot, set Model URIs: and click the “Load” button.

Model URIs: platform:/resource/org.wso2.developerstudio.eclipse.gmf.esb/model/esb.ecore
After loading the approprite Model URIs click “Next”

![](https://i.imgur.com/pGyrNgL.png)

5. Then Click Finish

![](https://i.imgur.com/A7eOadQ.png)

6. esb.genmodel file will get opened in the editor.

![](https://i.imgur.com/UwVRvjh.png)

7. Right click on the root element of the esb.genmodel(Esb) and click “Generate Model Code”

![](https://i.imgur.com/Crn5V6q.png)

It will take some time to generate the model code.

8. You can see model classes(Interfaces and Implementations) have been created for “CalculatorMediator”, “CalculatorMediatorInputConnector” and “CalculatorMediatorOutputConnector”.

https://drive.google.com/file/d/10UdCT9q6jdjgVcbEqDNLnW4zCF2eEouA/view?usp=sharing

![](https://i.imgur.com/rFQmRtb.png)

9. Right click on the root element of the esb.genmodel(Esb) and click “Generate Edit Code”

![](https://i.imgur.com/DcAJL9f.png)

It will take some time to generate edit code

This will generate ItemProvider classes for “CalculatorMediator”, “CalculatorMediatorInputConnector” and “CalculatorMediatorOutputConnector”

https://drive.google.com/file/d/1swkQ8LemkUssms28mnCSNNduF9otHiGR/view?usp=sharing

![](https://i.imgur.com/nT3lSsB.png)

We have generated the model and edit code. This ends the modeling of esb.genmodel.

### esb.gmfgraph
Let’s move on to esb.gmfgraph modeling. In esb.gmfgraph we have to consider the following three modeling
* Figure Descriptor
* Node
* Label

1. Go to the plugin “org.wso2.developerstudio.eclipse.gmf.esb” in the project explorer. Double click on it. Select model → esb.gmfgraph.

![](https://i.imgur.com/xGbyceO.png)

2. Double click on “esb.gmfgraph”. Select platform → Canvas esb → Figure Gallery Default.

![](https://i.imgur.com/JXGkyO0.png)

3. Let's create a Figure Descriptor for Calculator mediator. Right click on “Figure Gallery Default” and select New Child → Figure Descriptor.

![](https://i.imgur.com/4L9HFie.png)

4. Right click on the newly created Figure Descriptor and click on “Show Properties View”.

![](https://i.imgur.com/I6qshKa.png)

5. Set CalculatorMediatorFigure as the Name property.

![](https://i.imgur.com/JnVEBdA.png)

6. Add Custom Figure to Figure Descriptor CalculatorMediatorFigure. Right click on CalculatorMediatorFigure figure descriptor and select New Child → Custom Figure.

![](https://i.imgur.com/EpcsG54.png)

7. Right click on newly created Custom Figure and click on “Show Properties View”

![](https://i.imgur.com/J8lCi38.png)

8. Set CalculatorMediatorGraphicalFigure as the Name property and org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.EsbGraphicalShape as Qualified Class Name.

![](https://i.imgur.com/coh7n87.png)

9. Add Flow Layout to Custom Figure CalculatorMediatorGraphicalFigure. Right click on CalculatorMediatorGraphicalFigure and select New Child → Flow Layout.

![](https://i.imgur.com/dFL2rzr.png)

10. Right click on the newly created Flow Layout and click on “Show Properties View”. No need to change the Flow Layout properties unless otherwise required. Keep the default values as it is.

![](https://i.imgur.com/lCSSHvi.png)

11. Add Background to Custom Figure CalculatorMediatorGraphicalFigure. Right click on CalculatorMediatorGraphicalFigure and select New Child → Background color RGB color.

![](https://i.imgur.com/FZ91gg3.png)

12. Right click on newly created Background and click on “Show Properties View”. Set the value 230 for Blue, Green and Red color property.

![](https://i.imgur.com/OeTeo0v.png)

13. Add CalculatorMediatorProperty label to Custom Figure CalculatorMediatorGraphicalFigure. Right click on CalculatorMediatorGraphicalFigure and select New Child → Label.

![](https://i.imgur.com/8TtD39z.png)

14. Right click on newly created Label and click on “Show Properties View”. Set “CalculatorMediatorPropertyLabel” as Name property and “<…>” as Text.

![](https://i.imgur.com/VrZOwhF.png)

15. Similarly, create a label for CalculatorMediatorDescriptionFigure(Follow the previous step).

Set “CalculatorMediatorDescriptionFigure” as Name property and “<…>” as Text.

![](https://i.imgur.com/fmHTIfD.png)

16. Add getFigureCalculatorMediatorPropertyLabel to Figure Descriptor CalculatorMediatorFigure. Right click on CalculatorMediatorFigure figure descriptor and select New Child → Child Access.

![](https://i.imgur.com/QPITxec.png)

17. Right click on the newly created Child Access and click on “Show Properties View”. Set “getFigureCalculatorMediatorPropertyLabel” as Accessor and select “Label CalculatorMediatorPropertyLabel” as Figure.

![](https://i.imgur.com/2SRRwuT.png)

18. Similarly create a Child Access for getFigureCalculatorMediatorDescriptionFigure (follow the previous step). Set “getFigureCalculatorMediatorDescriptionFigure” as Accessor and select “Label CalculatorMediatorDescriptionFigure” as Figure.

![](https://i.imgur.com/T9l2WrB.png)

We have successfully modeled the figure descriptor part for Calculator mediator. Now let’s focus on how to model the Label part.

19. Open esb.gmfgraph → Canvas esb.

Right click on Canvas esb and select New Child → Labels Diagram Label.

![](https://i.imgur.com/iddjxmd.png)

20. Right click on the newly created Child Access and click on “Show Properties View”. Set the properties as follows

Accessor — Child Access getFigureCalculatorMediatorPropertyLabel
Content Pane — false
Element Icon — false
External — false
Figure — Figure Descriptor CalculatorMediatorFigure
Name — CalculatorMediatorName

![](https://i.imgur.com/5SH7E4V.png)

21. Similarly, create another label for “CalculatorMediatorDescription” and set the values as shown below

Accessor — Child Access getFigureCalculatorMediatorDescriptionFigure
Content Pane — false
Element Icon — false
External — false 
Figure — Figure Descriptor CalculatorMediatorFigure
Name — CalculatorMediatorDesciption

![](https://i.imgur.com/zJfkLWD.png)

We have successfully modeled the figure descriptor part and label part for Calculator mediator. Now let’s focus on how to model the Node part.

22. Open esb.gmfgraph → Canvas esb.

Let’s create a new node for Calculator mediator. Right click on Canvas esb and select New Child → Nodes Node

![](https://i.imgur.com/rjP3NSz.png)

23. Right click on the newly created Node and click on “Show Properties View”. Set the properties as shown below

Affixed Parent Side — NONE
Figure — Figure Descriptor CalculatorMediatorFigure
Name — CalculatorMediator

![](https://i.imgur.com/vJNF4KP.png)

24. Create a new node for CalculatorMediatorInputConnector. (follow the previous steps to create a node). Set the properties as shown below

Affixed Parent Side — WEST
Figure — Figure Descriptor EastPointerFigure
Name — CalculatorMediatorInputConnector

![](https://i.imgur.com/WiH6452.png)

25. Create a new node for CalculatorMediatorOutputConnector. (follow the previous steps to create a node). Set the properties as shown below

Affixed Parent Side — EAST
Figure — Figure Descriptor EastPointerFigure
Name — CalculatorMediatorOutputConnector

![](https://i.imgur.com/QUK3BaJ.png)

Finally, you should get the three nodes as shown below in Canvas esb

![](https://i.imgur.com/KZ7Leof.png)

This ends the modeling of esb.gmfgraph.

### esb.gmftool
Let’s move on to esb.gmftool modeling.

1. Go to the plugin “org.wso2.developerstudio.eclipse.gmf.esb” in the project explorer. Double click on it. Select model → esb.gmftool.

![](https://i.imgur.com/eL28LzH.png)

2. Double click on “esb.gmftool”. Select platform → Tool Registry → Pallete esbPalette → Tool Group Mediators.

![](https://i.imgur.com/LCUKGDU.png)

3. Let’s add CalculatorMediator to Tool Group Mediator. Right click on Tool Group Mediators and select New Child → Creation Tool.

![](https://i.imgur.com/s6RPqgG.png)

4. Right click on the newly created “Creation Tool” and click on “Show Properties View”. Set the properties as shown below

Description — Create new CalculatorMediator
Title — CalculatorMediator

![](https://i.imgur.com/015KKN1.png)

5. Let’s add “Small Icon Default Image” to CalculatorMediator. Right click on the newly created “Creation Tool CalculatorMediator” and select New Child → Small Icon Default Image

![](https://i.imgur.com/v13opqc.png)

6. Similarly, add the “Large Icon Default Image” as mentioned in the previous step

This ends the modeling of esb.gmftool.

### esb.gmfmap
Let’s move on to esb.gmfmap modeling.

1. Go to the plugin “org.wso2.developerstudio.eclipse.gmf.esb” in the project explorer. Double click on it. Select model → esb.gmfmap.

![](https://i.imgur.com/cgjmdgq.png)

2. Double click on “esb.gmfmap. Select platform → Mapping → Top Node Reference<server:EsbServer/EsbServer> → Node Mapping<EsbServer/EsbServer> → Child Reference<children:ProxyService/ProxyService> → Node Mapping<ProxyService/ProxyService> → Child Reference<container:ProxyServiceContainer/ProxyServiceContainer> → Node Mapping<ProxyServiceContainer/ProxyServiceContainer> → Child Reference<sequenceAndEndpointContainer:ProxyServiceSequenceAndEndpointContainer/ProxyServiceSequenceAndEndpointContainer> → Node Mapping<ProxyServiceSequenceAndEndpointContainer/ProxyServiceSequenceAndEndpointContainer> → Child Reference<mediatorFlow:MediatorFlow/MediatorFlow> → Node Mapping<MediatorFlow/MediatorFlow>

![](https://i.imgur.com/WlLsHBQ.png)

3. Open Node Mapping<MediatorFlow/MediatorFlow>. Right click on Node Mapping<MediatorFlow/MediatorFlow> and select New Child → Child Reference.

![](https://i.imgur.com/9JIl1Wo.png)

4. Right click on the newly created “Child reference<children>” and click on “Show Properties View”. Set the properties as shown below

Compartment — Compartment Mapping<MediatorFlowCompartment>
Compartment Feature — MediatorFlow.children:EsbElement

![](https://i.imgur.com/qRH5ZCz.png)

5. Right click on the newly created “Child reference<children>” and select New Child -> Node Mapping

![](https://i.imgur.com/xs2zPrh.png)

6. Right click on the newly created “Node Mapping” and click on “Show Properties View”. Set the properties as shown below

Element — Calculatormediator → Mediator
Diagram Node — Node CalculatorMediator (CalculatorMediatorFigure)
Tool — Creation Tool CalculatorMediator

![](https://i.imgur.com/t9j125W.png)

7. Let’s add Feature Label to the Node Mapping<CalculatorMediator/CalculatorMediator>. Right click on newly created Node Mapping<CalculatorMediator/CalculatorMediator> and select New Child → Feature Label Mapping

![](https://i.imgur.com/vuWh9oj.png)

8. Right click on the newly created “Feature Label” and click on “Show Properties View”. Set the properties as shown below

Feature to display — EsbElement.description:EString
Diagram label — Diagram Label CalculatorMediatorDescription

![](https://i.imgur.com/UHAPXvh.png)


9. let’s add child reference to the input connector. Right click on the newly created Node Mapping<CalculatorMediator/CalculatorMediator> and select New Child → Child Reference

![](https://i.imgur.com/VyIZbIQ.png)

10. Right click on the newly created “Child Reference” and click on “Show Properties View”. Set the properties as shown below

Containment Feature — CalculatorMediator.inputConnector:CalculatorMediatorInputConnector

![](https://i.imgur.com/SOwhnms.png)

11. Right click on the newly created Child Reference <inputConnector> and select New Child → Node Mapping

![](https://i.imgur.com/XRdLBfW.png)

12. Right click on the newly created “Node Mapping</>” and click on “Show Properties View”. Set the properties as shown below

Element — CalculatorMediatorInputConnector → InputConnector
Diagram Node — Node CalculatorMediatorInputconnector (EastPointerFigure)

![](https://i.imgur.com/e4bTwH1.png)

13. let’s add child reference to the output connector. Right click on the “Node Mapping <CalculatorMediator/CalculatorMediaor>” and select New Child → Child Reference

![](https://i.imgur.com/KbglXxB.png)

14. Right click on the newly created “Child Reference<>” and click on “Show Properties View”. Set the properties as shown below

Containment Feature — CalculatorMediator.outputConnector:CalculatorMediatorOutputconnector

![](https://i.imgur.com/NvSWCqu.png)

15. Right click on the newly created Child Reference <outputConnector> and select New Child → Node Mapping

![](https://i.imgur.com/h3J2UJx.png)

16. Right click on the newly created “Node Mapping</>” and click on “Show Properties View”. Set the properties as shown below

Element — CalculatorMediatorOutputConnector → OutputConnector
Diagram Node — Node CalculatorMediatorOutputConnector (EastPointerFigure)

![](https://i.imgur.com/IeYiQnk.png)

17. After all mapping, we should get the following tree structure.

![](https://i.imgur.com/vIcPxiG.png)

18. Save all changes. Go to the plugin “org.wso2.developerstudio.eclipse.gmf.esb” in the project explorer. Double click on it. Select model → esb.gmfmap. Right click on it and select “Create generator model…”

![](https://i.imgur.com/MLtp4Em.png)

19. You will get the below window. Make sure the fields are as follows

Enter or select parent folder — org.wso2.developerstudio.eclipse.gmf.esb/model
File name — esb.gmfgen

![](https://i.imgur.com/hu6PahC.png)

Click on “Next >”

20. You will get the following window. Select the fields as follows

Model URI: 
platform:/resource/org.wso2.developerstudio.eclipse.gmf.esb/model/esb.gmfmap

After selecting the proper Model URI click on the “Load” button which is beside the Model URI field

![](https://i.imgur.com/KdP1KPa.png)

After clicking the “Load” button click “Next >”.

21. You will get the following window. Make the Model URI as follows

Model URI — platform:/resource/org.wso2.developerstudio.eclipse.gmf.esb/model/esb.genmodel

![](https://i.imgur.com/5L9ogrJ.png)

Click the “Load” button which is beside the Model URI field. Then click “Finish”.

22. You will get the following window. Tick the following checkboxes
* Use IMapMode
* Utilize enhanced feature of GMF runtime

![](https://i.imgur.com/G4ifHzp.png)

Click “Finish”. This ends the modeling of esb.gmfmap.

If you get **java.lang.NoClassDefFoundError: org/eclipse/m2m/internal/qvt/oml/runtime/project/BundleUnitResolver** exception, you need to install the relevant dependencies from, http://archive.eclipse.org/mmt/qvto/downloads/drops/3.9.1/R201812101559/.

After downloading Go to **Help > Install New Software > Add** and select the downloaded archive to install.


### esb.gmfgen
Let’s move on to esb.gmfgen modeling

1. Go to the plugin “org.wso2.developerstudio.eclipse.gmf.esb” in the project explorer. Double click on it. Select model → esb.gen

![](https://i.imgur.com/wbFHnU9.png)

2. Right click on esb.gmfgen and click on “Generate diagram code”

![](https://i.imgur.com/5MAWmqA.png)

It will take some time to generate the diagram code. Once the generation is done you will get the following pop-up window

![](https://i.imgur.com/91W1JPt.png)

This ends the modeling of esb.gmfgen.

This is how you can generate a new mediator in Integration Studio. For more information refer the existing simple mediator(log or property).

## Add a new extension point

To add a new extension point to the Integration Studio pop-up context menus, toolbar items and menubar items, edit the **plugin.xml** file inside the relevant plugin which is used to develp the feature as follows.

### Add an item under "New" option in right click context menu

![](https://i.imgur.com/24ftlAo.png)

```xml
<extension
            point="org.eclipse.ui.newWizards">
        <wizard name="Unit Test Suite"
                class="org.wso2.developerstudio.eclipse.esb.synapse.unit.test.wizard.unittest.UnitTestSuiteCreationWizard"
                id="org.wso2.developerstudio.eclipse.esb.synapse.unit.test.testsuite"
                icon="icons/UnitTestSuite16x16.png">
        </wizard>
    </extension>

    <extension point="org.eclipse.ui.navigator.navigatorContent">
        <commonWizard type="new"
                      menuGroupId="a-group-integrationTest"
                      wizardId="org.wso2.developerstudio.eclipse.esb.synapse.unit.test.testsuite">
            <enablement>
                <adapt
                        type="org.eclipse.core.resources.IResource">
                    <test
                            property="org.wso2.developerstudio.eclipse.esb.synapse.unit.test.propertytester.checkResourceType"
                            value="true"
                            forcePluginActivation="true">
                    </test>
                </adapt>
            </enablement>
        </commonWizard>
    </extension>
```

### Add a sample menu (with sample command)

![](https://i.imgur.com/3qCPiqj.png)

```xml
<extension
      point="org.eclipse.ui.menus">
   <menuContribution
         locationURI="menu:org.eclipse.ui.main.menu?after=additions">
      <menu
            label="Sample Menu"
            mnemonic="M"
            id="HelloWorld.menus.sampleMenu">
         <command
               commandId="HelloWorld.commands.sampleCommand"
               mnemonic="S"
               id="HelloWorld.menus.sampleCommand">
         </command>
      </menu>
   </menuContribution>
</extension>
```

**Shortcut Key (Ctrl+6):**
```xml
<extension
      point="org.eclipse.ui.bindings">
   <key
         commandId="HelloWorld.commands.sampleCommand"
         contextId="org.eclipse.ui.contexts.window"
         sequence="M1+6"
         schemeId="org.eclipse.ui.defaultAcceleratorConfiguration">
   </key>
</extension>
```

### Add a toolbar extension

![](https://i.imgur.com/3DrHwVP.png)

```xml
<extension
      point="org.eclipse.ui.menus">
   <menuContribution
         locationURI="toolbar:org.eclipse.ui.main.toolbar?after=additions">
      <toolbar
            id="HelloWorld.toolbars.sampleToolbar">
         <command
               commandId="HelloWorld.commands.sampleCommand"
               icon="icons/sample.gif"
               tooltip="Say hello world"
               id="HelloWorld.toolbars.sampleCommand">
         </command>
      </toolbar>
   </menuContribution>
</extension>
```

### Add a item to right click popup menu

![](https://i.imgur.com/cPwXnMB.png)

```xml
 <extension point="org.eclipse.ui.popupMenus">
            <objectContribution objectClass="org.eclipse.core.resources.IResource"
                                id="org.wso2.developerstudio.eclipse.esb.synapse.unit.test.runtest">
                <action
                        label="Run Unit Test"
                        icon="icons/TestSuite16x16.png"
                        class="org.wso2.developerstudio.eclipse.esb.synapse.unit.test.action.RunSynapseUnitTestAction"
                        id="org.wso2.developerstudio.eclipse.esb.synapse.unit.test.runtest">
                </action>
                <enablement>
                    <adapt
                            type="org.eclipse.core.resources.IResource">
                        <test
                                property="org.wso2.developerstudio.eclipse.esb.synapse.unit.test.propertytester.checkUnitTestRunType"
                                value="true"
                                forcePluginActivation="true">
                        </test>
                    </adapt>
                </enablement>
            </objectContribution>
    </extension>
```

## Add a new wizard form
In Eclipse, a wizard is commonly used for the creation of new elements, imports or exports. It can also be used for the execution of any task involving a sequential series of steps. A wizard should be used if there are many steps in the task, and they must be completed in a specific order.

To add a simple wizard, you have to have to Java classes for the Wizard and WizardPage. 

**Sample Wizard Class**
```java
import org.eclipse.jface.wizard.Wizard;


public class MyWizard extends Wizard {

    protected MyPageOne one;
    protected MyPageTwo two;

    public MyWizard() {
        super();
        setNeedsProgressMonitor(true);
    }

    @Override
    public String getWindowTitle() {
        return "Export My Data";
    }

    @Override
    public void addPages() {
        one = new MyPageOne();
        two = new MyPageTwo();
        addPage(one);
        addPage(two);
    }

    @Override
    public boolean performFinish() {
        // Print the result to the console
        System.out.println(one.getText1());
        System.out.println(two.getText1());

        return true;
    }
    
    @Override
    public IWizardPage getNextPage(IWizardPage currentPage) {
        if (todo.isDone()) {
           return specialPage;
        }
        if (currentPage == page1) {
            return page2;
        }
        return null;
    }
    
    @Override
    public boolean canFinish() {
        return true;
    }
    
    @Override
    public boolean canFinish() {
        return true;
    }
}
```

**Sample Wizard Page**
```java
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class MyPageOne extends WizardPage {
    private Text text1;
    private Composite container;

    public MyPageOne() {
        super("First Page");
        setTitle("First Page");
        setDescription("Fake Wizard: First page");
    }

    @Override
    public void createControl(Composite parent) {
        container = new Composite(parent, SWT.NONE);
        GridLayout layout = new GridLayout();
        container.setLayout(layout);
        layout.numColumns = 2;
        Label label1 = new Label(container, SWT.NONE);
        label1.setText("Put a value here.");

        text1 = new Text(container, SWT.BORDER | SWT.SINGLE);
        text1.setText("");
        text1.addKeyListener(new KeyListener() {

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (!text1.getText().isEmpty()) {
                    setPageComplete(true);

                }
            }

        });
        GridData gd = new GridData(GridData.FILL_HORIZONTAL);
        text1.setLayoutData(gd);
        // required to avoid an error in the system
        setControl(container);
        setPageComplete(false);

    }

    public String getText1() {
        return text1.getText();
    }
}
```

## Add a new dialog box

### SWT Dialogs
SWT provides an API to use the native dialogs from the OS platform. The default SWT dialogs are listed below.

* ColorDialog - for selecting a color
* DirectoryDialog - for selecting a directory
* FileDialog - for selecting a file
* FontDialog - for selecting a font
* MessageBox - for opening a message dialog

```java
// create a dialog with ok and cancel buttons and a question icon
MessageBox dialog =
    new MessageBox(shell, SWT.ICON_QUESTION | SWT.OK| SWT.CANCEL);
dialog.setText("My info");
dialog.setMessage("Do you really want to do this?");

// open dialog and await user selection
returnCode = dialog.open();
```

![](https://i.imgur.com/mOYqbFx.png)

### JFace Dialogs
```java
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class MyTitleAreaDialog extends TitleAreaDialog {

    private Text txtFirstName;
    private Text lastNameText;

    private String firstName;
    private String lastName;

    public MyTitleAreaDialog(Shell parentShell) {
        super(parentShell);
    }

    @Override
    public void create() {
        super.create();
        setTitle("This is my first custom dialog");
        setMessage("This is a TitleAreaDialog", IMessageProvider.INFORMATION);
    }

    @Override
    protected Control createDialogArea(Composite parent) {
        Composite area = (Composite) super.createDialogArea(parent);
        Composite container = new Composite(area, SWT.NONE);
        container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        GridLayout layout = new GridLayout(2, false);
        container.setLayout(layout);

        createFirstName(container);
        createLastName(container);

        return area;
    }

    private void createFirstName(Composite container) {
        Label lbtFirstName = new Label(container, SWT.NONE);
        lbtFirstName.setText("First Name");

        GridData dataFirstName = new GridData();
        dataFirstName.grabExcessHorizontalSpace = true;
        dataFirstName.horizontalAlignment = GridData.FILL;

        txtFirstName = new Text(container, SWT.BORDER);
        txtFirstName.setLayoutData(dataFirstName);
    }

    private void createLastName(Composite container) {
        Label lbtLastName = new Label(container, SWT.NONE);
        lbtLastName.setText("Last Name");

        GridData dataLastName = new GridData();
        dataLastName.grabExcessHorizontalSpace = true;
        dataLastName.horizontalAlignment = GridData.FILL;
        lastNameText = new Text(container, SWT.BORDER);
        lastNameText.setLayoutData(dataLastName);
    }

    @Override
    protected boolean isResizable() {
        return true;
    }

    // save content of the Text fields because they get disposed
    // as soon as the Dialog closes
    private void saveInput() {
        firstName = txtFirstName.getText();
        lastName = lastNameText.getText();

    }

    @Override
    protected void okPressed() {
        saveInput();
        super.okPressed();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
```

![](https://i.imgur.com/mqMo3dC.png)

The usage of this dialog is demonstrated in the following code snippet. This code might for example be used in a handler.

```java
MyTitleAreaDialog dialog = new MyTitleAreaDialog(shell);
dialog.create();
if (dialog.open() == Window.OK) {
    System.out.println(dialog.getFirstName());
    System.out.println(dialog.getLastName());
}
```

## Add a new editor

To add a new editor for the Integration Studio, you need to modify the **EsbMultiPageEditor** class with your new editor class. Below steps show you how to add an editor inside the EsbMultiPageEditor class using the recently added **SwaggerEditor** example. 

1. Create a new editor class by extending **AbstractWebBasedEditor** for its functionalities. 
    **Ex:** EsbSwaggerEditor
2. Define the created editor inside the **EsbMultiPageEditor** 
    **Ex:** `private EsbSwaggerEditor swaggerlEditor;`
3. Define a index for the new editor.
    **Ex:** `private static final int SWAGGER_VIEW_PAGE_INDEX = 2;`
4. Create method for execute `addPage` and `setPageText` methods for the editor.
**Ex:**
```java
void createSwaggerEditorPage() {
		swaggerlEditor = new EsbSwaggerEditor(this);
		try {
			addPage(SWAGGER_VIEW_PAGE_INDEX, swaggerlEditor, getEditorInput());
			setPageText(SWAGGER_VIEW_PAGE_INDEX, "Swagger Editor");
		} catch (PartInitException e) {
			ErrorDialog.openError(getSite().getShell(), "Error Creating Swagger Editor", null, e.getStatus());
		}
}
```
5. Add the above method inside the `createPages()` method. 
6. Add a new case inside the `pageChange()` method for the new editor index. 
**Ex:**
```java
case SWAGGER_VIEW_PAGE_INDEX: {
			if (lastActivePage == SOURCE_VIEW_PAGE_INDEX) {
				try {
					String currentSource = sourceEditor.getDocument().get();
					RestApiAdmin restAPIAdmin = new RestApiAdmin();
					OMElement element = AXIOMUtil.stringToOM(currentSource);
					API api = APIFactory.createAPI(element);
					String swaggerDefinition = restAPIAdmin.generateSwaggerFromSynapseAPI(api);
					setOldSwaggerSource(swaggerDefinition);
					setSwaggerSource(swaggerDefinition);
					swaggerlEditor.getBrowser().refresh();

				} catch (Exception e) {
					MessageDialog.openError(Display.getCurrent().getActiveShell(), "Error Details",
		                    "Error in loading associated XML : " + e.getMessage());
					setActivePage(lastActivePage);
				}
			}
			else {
				try {
					EsbDiagram diagram = (EsbDiagram) graphicalEditor.getDiagram().getElement();
					EsbServer server = diagram.getServer();
					String currentSource = EsbModelTransformer.instance.designToSource(server);
					RestApiAdmin restAPIAdmin = new RestApiAdmin();
					OMElement element = AXIOMUtil.stringToOM(currentSource);
					API api = APIFactory.createAPI(element);
					String swaggerDefinition = restAPIAdmin.generateSwaggerFromSynapseAPI(api);
					setSwaggerSource(swaggerDefinition);
					setOldSwaggerSource(swaggerDefinition);
					swaggerlEditor.getBrowser().refresh();
					updateSourceEditor();
				} catch (Exception e) {
					MessageDialog.openError(Display.getCurrent().getActiveShell(), "Error Details",
							"Error in loading associated XML : " + e.getMessage());
					setActivePage(lastActivePage);
				}

			}
}
```

## Add a new web UI with the servlet Jetty server

Integration Studio uses Jetty server as the Java HTTP server and Java Servlet container to host the web pages. So that, developers can use javascript web calls (ex: AJAX) to inject the servlet services to fetch or update the server side data via the web UIs. 

Follow the below steps to add a web UI with Jetty server.

1. Create the Web UI (HTML, CSS and Javascript sources)
2. Implement a logic for javascript web service calls.
3. Impement a new class by implementing the **IStartup** interface to start the jetty server while tooling startup. And override the **earlyStartup** method as follows.
```java
public class DeployedServicesEarlyStartupHandler implements IStartup {

    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
    private static final String ENDPOINTS_CONTEXT_PATH = "/project/endpoints";
    private static final String ENDPOINTS_WEB_APP_LOCATION = "DeployedEndpointsPages";

    @Override
    public void earlyStartup() {
        JettyServerHandler jettyServerHandler = JettyServerHandler.getInstance();

        //Register Deployed services context handler
        ServletContextHandler endpointsContext = new ServletContextHandler();

        // Context path where static webpages are hosted
        String endpointWebAppPath = ENDPOINTS_WEB_APP_LOCATION;
        try {
            // Get web app path from current bundle
            endpointWebAppPath = getEndpointsWebAppPath();
        } catch (URISyntaxException | IOException e) {
            log.error("Error resolving web app path", e);
        }

        endpointsContext.setContextPath(ENDPOINTS_CONTEXT_PATH);

        // Adding Default servlet and Connector servlet
        endpointsContext.addServlet(DefaultServlet.class, "/");
        endpointsContext.setResourceBase(endpointWebAppPath);

        // Registering the handler in the jetty server
        jettyServerHandler.getHandlerCollection().addHandler(endpointsContext);
        try {
            endpointsContext.start();
        } catch (Exception e) {
            log.error("Failed to start deployed services context", e);
        }
    }
    
    public String getEndpointsWebAppPath() throws URISyntaxException, IOException {
        Bundle bundle = Platform.getBundle(Activator.PLUGIN_ID);
        URL webAppURL = bundle.getEntry(ENDPOINTS_WEB_APP_LOCATION);
        URL resolvedFolderURL = FileLocator.toFileURL(webAppURL);
        URI resolvedFolderURI = new URI(resolvedFolderURL.getProtocol(), resolvedFolderURL.getPath(), null);
        File resolvedWebAppFolder = new File(resolvedFolderURI);
        return resolvedWebAppFolder.getAbsolutePath();
    }
}
```
4. Create a view pane for the web UI
```java
public class DeployedServicesView extends ViewPart {

    @Override
    public void createPartControl(Composite arg0) {
        browser = new Browser(arg0, SWT.NONE);

        try {
            generateAccessToken();
            String apiList = getDeployedServices(MI_API_API_URL);
            String proxyList = getDeployedServices(MI_PROXY_API_URL);
            browser.setUrl(getDefaultPage(apiList, proxyList));
        } catch (Exception ex) {
            log.error("Failed to start deployed services page", ex);
        }

    }
    
    private String getDefaultPage(String apiList, String proxyList) throws URISyntaxException, IOException {
        IEclipsePreferences rootNode = Platform.getPreferencesService().getRootNode();
        String port =  rootNode.get("portDetails", String.valueOf(FunctionServerConstants.EMBEDDED_SERVER_PORT));
        return "http://localhost:" + port + "/project/endpoints?" + API_DETAILS_GET_PARAM + "=" + apiList + "&" +PROXY_DETAILS_GET_PARAM + "=" + proxyList;
    }

    @Override
    public void setFocus() {
        // TODO Auto-generated method stub
    }

    public void setURL(URL url) {
        browser.setUrl(url.toString());
    }
}
```

You can refer the following existing web UIs for more information. 
* Getting started page
* DSS editor
* Deployed runtime services view
* Sample guides
* Docker and Kubernetes guides
* Realtime datamapper view

## Add a new sample to the getting started page

Integration Studio maintains a set of pre-built templates in the Getting Started page for ease of getting started with it. All of these samples have been implemented as the Maven Multi-Module project (Integration project) and classified into several categories. To add a new sample to this page, you can follow the below steps. 

1. Implement the sample template as a Maven Multi Module project and convert it to a ZIP file.
2. Copy the new sample ZIP file into the **NewSamples** directory by creating a new directory inside the ESB **org.wso2.developerstudio.eclipse.esb.dashboard.templates** plugin.
3. Add a **Readme.html** file to the created directory as the user reference guide. 
4. Open the plugin.xml file of this plugin and add the following wizard tag according to the new sample. 
```xml
<wizard
                name="Name for the Template"
                icon="icons/template-default.pngg"
                project="true"
                category="org.wso2.developerstudio.eclipse.capp.project/org.wso2.developerstudio.templates"
                id="org.wso2.developerstudio.wizards.esb.newTemplateName">
                <class class="org.wso2.developerstudio.eclipse.esb.dashboard.templates.maven.wizard.CommonTemplateProjectCreationWizard">
	                <parameter name="wizardId" value="org.wso2.developerstudio.wizards.esb.newTemplateName"/>
                </class>
</wizard>
```
5. Edit the **app_new.js** file located inside the **org.wso2.developerstudio.eclipse.templates.dashboard/WelcomeDashboard/libs** plugin. You can define a category, used mediators in the sample, etc. from this file. 

## Introduction to the DataMapper

### Components

### AI-Based Datamapper 
AI Data Mapper is a more sophisticated and easy to use feature in the Integration Studio. AI Data Mapper was introduced to instantly generate mapping configurations without developers having to go through each element in the input and the output. AI Data Mapper not only makes mapping generation quick, but also eliminates other concerns such as mistakes in mapping configuration. Especially, when payloads are quite extensive, the repetitive nature of the configuration drawing increases the chance of a mistake. This is why we have taken measures to improve the AI Data Mapper so that developers can count on it all the time.

**How it works:**
1. User import both input and output schemas via the Integration Studio and press the `Apply` button on the canvas for AI based datamapping. 

    SWT button location of Apply button - `DataMapperRootEditPart class >  createFigure() method`

2. Logic takes the user input and output contents and send to the hosted machine learning datamapping service (developed by WSO2 Reaserch team) to get the mappings for between inputs and outputs.

    Service URL - `https://ai-data-mapper.wso2.com/uploader`
    Logic executes in - `DataMapperRootEditPart class >  drawMappings() method`

3. Logic writes the received mappings on .dmc file and previews the resulted mappings on the datamapper canvas.

## Managing dependencies from Product EI

## Threading in Integration Studio

### Singled-threaded UI
Nearly all GUI toolkits currently on the market are implemented in a singled-threaded manner. This is based on the experience with frameworks (like AWT) trying to support a multi-threaded UI toolkit. This does not mean that the applications using SWT are restricted to use a single thread but every interaction with GUI toolkit needs to be done on a distinct thread. This thread is normally called the event dispatch thread (EDT)) or UI Thread. Every interaction between and application and the ouside world is handled by the UI thread. All events fired due to user interaction with the operation system are put into a queue. Applications using SWT now have the chance to let SWT get those events out of the operation system queue and dispatching them to the corresponding SWT widgets. The UI Thread in our case is always the one which initially created the SWT **Display**.

```java
public static void main(String [] args) {
    Display display = new Display();
    Shell shell = new Shell(display);
    shell.open();
    while (!shell.isDisposed()) {
        if (!display.readAndDispatch()) {
            display.sleep();
        }
    }
    display.dispose();
}
```
Reference - https://www.eclipse.org/rap/resources/readAndDispatch.pdf

### syncExec() 
Use syncExec where the code following that method call needs to be sure that the UI is in a consistent state, or needs some data from the UI. For example getting some data from a user dialog. Or you update a widget and before doing anything else (e.g. another UI update) you want to know that the widget update has completed.
```java 
Display.getDefault().syncExec(new Runnable() {
    public void run() {
        //logic
    }
});
```

### asyncExec() 
Use asyncExec when you want to update something in the UI without caring about the results. For example updating a label or a progress bar.
```java 
Display display = getShell().getDisplay();

display.asyncExec( new Runnable( ) {
    public void run() {
        // logic
    }
});
```

### Java Threading
Also you can use Java threading mechanisams to implement features, logics inside the Eclipse threads. 

```java
new Thread() {
   public void run() {
       // logic
   }
}
```




## UI element drag and drop mathematical calculations
When a mediator is dragged and dropped into the canvas, the **activate()** method of respective mediator class will get hit. **AbstractMediator**(org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.AbstractMediator) is responsible for creating and possitioning UI element to the esb editor canvas. Then the **ConnectionCalculater**(org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.connections.ConnectionCalculator) will have the methods to find the nearest mediator to connect. After finding the suitable mediator to connect abstract mediator will create the connection using ESBLink.

## EI connector codebase 

With the connector UI revamp (Integration Studio 7.1.0 JUL 2010), we have introduced a new Properties view and Connection UI (similar to init operation in older connectors)

### Older Properties view

![](https://i.imgur.com/6vGRhCJ.png)


### New Properties view

![](https://i.imgur.com/6kLemIT.png)

### New Connection Configuration 

![](https://i.imgur.com/NgsIRpE.png)

### Steps for writing a descriptor for connector operations

1. Create a JSON file with the following structure

```jsonld=
{
 "connectorName": "email",
 "operationName": "markAsDeleted",
 "title": "Mark As Delete",
 "help": "<h1>Mark As Delete</h1> <b>The Mark As Delete operation marks the email with the relevant Email ID as deleted.",
 "elements": [
   {
     "type": "attributeGroup",
     "value": {
       "groupName": "General",
       "elements": [
         // Add your connector operation related parameters and groups here
       ]
     }
   }
 ]
}

```
* **“connectorName”** is the Connector name of your connector.
* **“operationName”** is the Operation name of your connector(Note that you should write separate descriptor JSON files for each of the connector operation).
* **“title”** is the Display Name of the connector operation in the Tooling.
* **“help”** this should contain the HTML of the Help file of the connector.
* **“elemets”** these elements should have one of the following JSON objects,
    * Group Object
        * Following is a sample of a group object,
        ```jsonld=
                  {
                       "type": "attributeGroup",
                       "value": {
                             "groupName": "Basic",
                             "elements": []
                  }
        ```

        1. **“type”**: this should be “attributeGroup” for the attribute group elements.
        2. **“Value”** should have JSON object with “groupName” which is the name of the group (which will be visible in the properties pane)
        3. **“elements”** are the same as the “point e”.

        A sample screenshot for Group named as “Basic” with 3 attributes

        ![](https://i.imgur.com/IYMTElR.png)


    * Attribute elements
        * Following is a sample for attribute element
        
        ```jsonld=
                {
                         "type": "attribute",
                         "value": {
                           "name": "folder",
                           "displayName": "Mailbox Folder",
                           "inputType": "stringOrExpression",
                           "defaultValue": "Inbox",
                           "required": "false",
                           "helpTip": "Name of the Mailbox folder to retrieve emails from"
                         }
                }	
        ```
        
        * “type” should be “attribute” for attribute element
        * “value” is the metadata about the actual parameter. It should have the following attributes,
            * “name” This should be the exact name of the connector parameter.
            * “displayName” is the Name that should display in the label of the attribute.
            * “inputType” you can choose one from the following,
                1. string - Standard text box for the UI component, accepts any String
                2. stringOrExpression - same as the string with Xpath expression support
                3. combo - Standard combo box with a set of values defined as an enum
                4. comboOrExpression - same as a combo with Xpath expression support
                5. connection - connector connection configuration(config ref)
                6. textAreaOrExpression - Standard text area for multi-line inputs with expression support.
            * “required” set true if the connector attribute is required attribute
             * “helpTip” this is the help tip for the attribute

        * The following are the optional parameters for the value object,
            * “defaultValue” give a default if required for the attribute
            * “validation”  this attribute can be used to set validation for the attribute. Supported validation types follow,
            * “e-mail”: validates the attribute as email address
            * “nameWithoutSpecialCharactors”: validates as a name without any special characters
            * “Custom” if you choose custom you should add additional attribute as “validationRegEx” and give the regex for validation
        * “allowedConnections” this attribute is mandatory if you choose inputType as a connection. This should be an array of supported connections.
        * “comboValues” this attribute is mandatory if you select the inputType as a combo. This should also be an array with the options to the ComboBox
        * “enableCondition” this attribute can be used to set an enable logic for the connector parameter. For example, if you want to enable a parameter if either connection parameter foo has value car or parameter bar has a value of van the enable condition should be [“OR”, {“foo”:”car”}, {“bar”:”van”}]. This supports AND, OR, NOT operators. And it can simply be a single condition. Eg: [{“foo”:”bar}]

### Steps for writing descriptor for connector connection

Connection descriptions are very similar to operation descriptors. The only difference is the “operationName” will be “connecitonName” for the connector connections. These connections are the created under the local entry in the synapse configuration.
Note that you should create separate connector connection descriptors for each connection that is supported by the connector. The “connectionName” should exactly match with the “allowedConnection” values that you use in the connector operation descriptor.

Sample connection descriptor

```jsonld=
{
 "connectorName": "email",
 "connectionName": "imap",
 "title": "IMAP Connection",
 "help": "<h1>Email Connector</h1> <b>The email connector supports IMAP, POP3 and SMTP protocols for handling emails</b>",
 "elements": []
}
```
All the other attributes are the same as the connector operation descriptor that we discussed in the above section.

### Steps to packing the UI descriptors to the connector

1. Create a new directory inside the connector zip file as “uischema”
2. Copy all the connector operation descriptors and connector connection descriptors to the “uischema” directory
3. Test the connector by adding to integration studio

### Sample descriptors

**Connector Operation Descriptor**

```jsonld=
{
 "connectorName": "email",
 "operationName": "list",
 "title": "List Emails",
 "help": "<h1>List Emails</h1> <b>The list operation lists emails in a specific mailbox.</b><br><br><ul><li><a href=\"https://ei.docs.wso2.com/en/latest/micro-integrator/references/connectors/file-connector/file-connector-config/\"> More Help </a></li></ul>",
 "elements": [
   {
     "type": "attributeGroup",
     "value": {
       "groupName": "General",
       "elements": [
         {
           "type": "attribute",
           "value": {
             "name": "configRef",
             "displayName": "Connection",
             "inputType": "connection",
             "allowedConnectionTypes": [
               "imap",
               "imaps",
               "pop3",
               "pop3s"
             ],
             "defaultValue": "",
             "required": "true",
             "helpTip": "Connection to be used"
           }
         },
         {
           "type": "attributeGroup",
           "value": {
             "groupName": "Basic",
             "elements": [
               {
                 "type": "attribute",
                 "value": {
                   "name": "folder",
                   "displayName": "Mailbox Folder",
                   "inputType": "stringOrExpression",
                   "defaultValue": "Inbox",
                   "required": "false",
                   "helpTip": "Name of the Mailbox folder to retrieve emails from"
                 }
               },
               {
                 "type": "attribute",
                 "value": {
                   "name": "deleteAfterRetrieve",
                   "displayName": "Delete After Retrieve",
                   "inputType": "booleanOrExpression",
                   "defaultValue": "false",
                   "required": "true",
                   "helpTip": "Whether the email should be deleted after retrieving"
                 }
               },
               {
                 "type": "attribute",
                 "value": {
                   "name": "offset",
                   "displayName": "Offset",
                   "inputType": "stringOrExpression",
                   "defaultValue": "0",
                   "required": "true",
                   "helpTip": "The index from which to retrieve emails"
                 }
               },
               {
                 "type": "attribute",
                 "value": {
                   "name": "limit",
                   "displayName": "Limit",
                   "inputType": "stringOrExpression",
                   "defaultValue": "10",
                   "required": "true",
                   "helpTip": "The number of emails to be retrieved"
                 }
               }
             ]
           }
         },
         {
           "type": "attributeGroup",
           "value": {
             "groupName": "Advanced",
             "elements": [
               {
                 "type": "attribute",
                 "value": {
                   "name": "receivedSince",
                   "displayName": "Received Since",
                   "inputType": "stringOrExpression",
                   "defaultValue": "",
                   "required": "false",
                   "helpTip": "The date after which to retrieve received emails"
                 }
               },
               {
                 "type": "attribute",
                 "value": {
                   "name": "receivedUntil",
                   "displayName": "Received Until",
                   "inputType": "stringOrExpression",
                   "defaultValue": "",
                   "required": "false",
                   "helpTip": "The date until which to retrieve received emails"
                 }
               },
               {
                 "type": "attribute",
                 "value": {
                   "name": "sentSince",
                   "displayName": "Sent Since",
                   "inputType": "stringOrExpression",
                   "defaultValue": "",
                   "required": "false",
                   "helpTip": "The date after which to retrieve sent emails"
                 }
               },
               {
                 "type": "attribute",
                 "value": {
                   "name": "sentUntil",
                   "displayName": "Sent Until",
                   "inputType": "stringOrExpression",
                   "defaultValue": "",
                   "required": "false",
                   "helpTip": "The date until which to retrieve sent emails"
                 }
               },
               {
                 "type": "attribute",
                 "value": {
                   "name": "subjectRegex",
                   "displayName": "Subject Regex",
                   "inputType": "stringOrExpression",
                   "defaultValue": "",
                   "required": "false",
                   "helpTip": "Subject Regex to match with the wanted emails"
                 }
               },
               {
                 "type": "attribute",
                 "value": {
                   "name": "fromRegex",
                   "displayName": "From Regex",
                   "inputType": "stringOrExpression",
                   "defaultValue": "",
                   "required": "false",
                   "helpTip": "From email address to match with the wanted emails"
                 }
               },
               {
                 "type": "attribute",
                 "value": {
                   "name": "seen",
                   "displayName": "Seen",
                   "inputType": "booleanOrExpression",
                   "defaultValue": "",
                   "required": "false",
                   "helpTip": "Whether to retrieve 'seen' or 'not seen' emails"
                 }
               },
               {
                 "type": "attribute",
                 "value": {
                   "name": "answered",
                   "displayName": "Answered",
                   "inputType": "booleanOrExpression",
                   "defaultValue": "",
                   "required": "false",
                   "helpTip": "Whether to retrieve 'answered' or 'unanswered' emails"
                 }
               },
               {
                 "type": "attribute",
                 "value": {
                   "name": "deleted",
                   "displayName": "Deleted",
                   "inputType": "booleanOrExpression",
                   "defaultValue": "",
                   "required": "false",
                   "helpTip": "Whether to retrieve 'deleted' or 'not deleted' emails"
                 }
               },
               {
                 "type": "attribute",
                 "value": {
                   "name": "recent",
                   "displayName": "Recent",
                   "inputType": "booleanOrExpression",
                   "defaultValue": "",
                   "required": "false",
                   "helpTip": "Whether to retrieve 'recent' or 'past' emails"
                 }
               }
             ]
           }
         }
       ]
     }
   }
 ]
}

```

**Connector Connection Descriptor**
```jsonld=
sample descriptor goes here
```

## Hosting an update for Integration Studio
Integration Studio does patch releases over the air updates. That means Integration Studio developers can update or introduce new features on Kernel, Platform, ESB, DSS, BPS or EI plugins and broadcast updates for every user. Here, updates are hosted as P2 plugins in relevant hosting locations which are maintained by the WSO2 Marketing team.

To deliver a new update for the Integration Studio latest release, follow the below steps. 

1. Build the relevant Jenkins build with the modified source.
Ex: For the EI update build https://jenkins-support-ei.wso2.com/jenkins/job/devstudio-tooling-ei/ Jenkins job.
2. Download the built P2 ZIP file from the Jenkins build. You can find the P2 file from the <JOB_LOCATION>/ws/repository/main/target/ path.
3. Get the timestamp of the built plugins from the downloaded P2 file (To get the built timestamp to check the plugins directory inside the P2 file).
4. Download **compositeArtifacts.xm**l and **compositeContent.xml** files and update the content as follows.
```xml
<repository>
    <properties size="1">
        <property name="p2.timestamp" value="<NEW_TIMESTAMP>"/>
    </properties>
    <children size="1">
        <child location="./<PLUGIN>-p2-7.0.0-<NEW_TIMESTAMP>/"/>
    </children>
</repository>
```
5. Host the modified `compositeArtifacts.xml`, `compositeContent.xml` and P2 file (renamed with the built timestamp) in the relevant P2 host locations.
6. Create a `release_<NEW_TIMESTAMP>.txt` file and add release notes of the update. 
7. Host the release note inside the `http://product-dist.wso2.com/p2/developer-studio-kernel/4.3.0/release-notes/` location. 

* **P2 host root location** - http://product-dist.wso2.com/p2/developer-studio-kernel/4.3.0/
* **Kernel P2 location** - http://product-dist.wso2.com/p2/developer-studio-kernel/4.3.0/kernel/updates/
* **Platform P2 location** - http://product-dist.wso2.com/p2/developer-studio-kernel/4.3.0/platform-bundles/updates/7.0.0/
* **ESB P2 location** - http://product-dist.wso2.com/p2/developer-studio-kernel/4.3.0/esb-tools/updates/7.0.0/
* **DSS P2 location** - http://product-dist.wso2.com/p2/developer-studio-kernel/4.3.0/dss-tools/updates/
* **BPS P2 location** - http://product-dist.wso2.com/p2/developer-studio-kernel/4.3.0/bps-tools/updates/7.0.0/
* **EI P2 location** - http://product-dist.wso2.com/p2/developer-studio-kernel/4.3.0/ei-tools/updates/7.0.0/
## Releasing Integration Studio new version
To release a new version of the Integration Studio, follow the below steps to move forward.

1. Upgrade the MI version to latest in the EI plugin.
2. Check Documentation Link from **Help -> Help** Content.
3. Integration Studio icon with new release version.
4. Check ConfigMapper plugin version in Docker/K8s project pom.
5. Check Unit test client plugin version in ESB project pom.
6. Host templates related to MI to the dist (supports Docker build).
7. Update toml in docker file and in EI installation.
8. Trigger the **devstudio-kernel** release build.
9. Host the devstudio-kernel P2.
10. Trigger the **devstudio-platform** release build.
11. Host devstudio-platform P2.
12. Trigger the **devstudio-bps** release build.
13. Host devstudio-bps P2.
14. Trigger **the devstudio-dss** release build. 
15. Host devstudio-dss P2.
16. Trigger the **devstudio-esb** release build.
17. Host devstudio-esb P2.
18. Trigger the **devstudio-ei** release build. 
19. Host devstudio-ei packages.
20. Add license files for every distribution.
21. Generate DMG for MacOS.
22. Sign distributions before releasing.
23. Ask marketing team to host the packs in website.
24. Ask marketing team to add the packs to Atuwa.
25. Test the Integration Studio in all platforms and release.

## Creating DMG for macOS

#### Get the Keys required for signing the package
There are few types of signing certificates available in apple developer portal. All these certificate types are for different purposes. What we need is to be able to distribute a package outside of Apple Appstore as a certified developer. For that we need a Developer ID certificate. This type of certificate can only be generated by a user with admin role. teamagent role cannot generate Developer ID certificates. So make sure you are signed in to apple developer portal as an admin before trying to generate a Developer ID certificate.
You can get a generated certificate from another team member and use it by exporting both private key and certificate as .p12 file. 
Note: simply installing the Developer ID certificate from another team member will not work as you don’t have the private key for that certificate in your KeyChain. You need to import key/certificate pair as mentioned above to get it working.

Only follow below steps to generate a new Developer ID certificate if you already don’t have one.  

* Generate a CSR (Certificate Signing Request) from the KeyChain Access tool.
* Go to https://developer.apple.com/account/mac/certificate/ and click + to create a new certificate
* Choose option for Developer ID certificate and generate the certificate using the CSR generated in step I.
* Install intermediate certificates for Developer ID certificate from http://www.apple.com/certificateauthority/ if you already don’t have it in your KeyChain.
* Install generated Developer ID certificate to you KeyChain.

#### Signing the .app package
Go to Security and Privacy settings in your Mac. Select option to install only Apps downloaded from Appstore and identified developers. Now if you try to open your .app package you should get a warning saying the package is damaged and can’t be opened.

Use following command to sign the package with newly installed Developer ID certificate.
codesign --force --verbose --sign <Certificate name as shown in KeyChain Access> <App name>.app
Ex: codesign --force --verbose --sign "Developer ID Application: WSO2, Inc. (XXXXXXX)" IntegrationStudio.app

--force will override any existing code signatures in the package. 
Now your .app package should open without issues but **DON’T OPEN** it yet. 

#### Creating the DMG Installer package
We haven’t used any third party tools to create the DMG other than the Disk Utility available with Mac OSX. 

Move your .app to a newly created directory (DMG will be mounted to a directory with this directory name). Create a symbolic link to “Applications” in newly created directory. 
ln -s /Applications 

Open Disk Utility application and go to FIle => New => Disk Image From Folder. Select the directory created in the previous step and choose read/write as Image format. Finish the wizard and you’ll get a distributable DMG with a signed .app package.

Then we need to open the dmg and copy the background image to the dmg and make it as the background 

After adding the image we can convert the .dmg using the Disk Utility (Menu-> Images-> Convert) to convert the read/write image to compressed image

Test the DMG by installing and opening the application.


