#WSO2 Developer Studio
=====================

WSO2 Developer Studio is a complete tooling platform where you can easily develop, deploy, test and debug your SOA applications. Developer Studio works in the popular open-source integrated development environment (IDE) Eclipse. By integrating with the award-winning WSO2 Carbon platform, Developer Studio enables you to create, deploy, and manage a variety of artifacts.

##Features

###Supports Edit, Build, Debug and Deploy Cycles of Applications on WSO2 Products
* Distributes as a standalone Eclipse-based product or extension bundles for Eclipse
* Support for editing most type of deployable artifacts
* Integrates to Maven for building
* Run test servers inside Eclipse and do source level debugging for applications that consist of multiple artifact types

###Support for Developing Apache Tomcat, Apache Axis2, Axis CXF, Apache Synapse and Apache Ode Applications
* Edit, build, debug, deploy Tomcat webapps, Axis2 or CXF services, RESTful services, Synapse mediation, and ODE processes
* Optionally deploy to WSO2 products for greater ease of use
* Uses widely used popular Eclipse plugins

###Supports Integration of Cloud Services
* Foundation for both cloud-to-cloud and cloud-to-enterprise integrations
* Combines multiple operations from multiple connectors along request, response, and error paths.
* Combines with regular mediators in a mediation flow to fine-tune business logic processing

###Supports Collaborative Development
* Integrates with any Eclipse-supported SCM (SVN, Git, Perforce, CVS, Mercurial and more)
* Shared development of artifacts belonging to a single application

###Supports Development Governance
* Integrates with WSO2 App Factory to facilitate management of application development lifecycles
* Browse, consume and produce registry resources with WSO2 Governance Registry
* Enables lifecycle governance of applications by separating code from configuration

###Supports Maven and Continuous Integration
* All build actions can be performed through the tool as well as via the command line using Apache Maven
* Enables easy integration with CI products such as Jenkins and Bamboo

###Supported Artifact Types
* Apache Axis2 services
* Apache CXF services
* JAX-WS services
* Service Meta artifact for security across all WSO2 middleware products
* Data services for WSO2 Data Services Server
* BPEL processes for Apache ODE and WSO2 Business Process Server
* ESB artifacts for Apache Synapse and WSO2 Enterprise Service Bus
* Registry resources for WSO2 Governance Registry
* Webapps for Apache Tomcat and WSO2 Application Server
* Jaggery Applications for WSO2 User Engagement Server

###Easily Build Composite Applications
* Supports writing enterprise applications that consist of any collection of above artifacts as a single Composit Application aRchive (CAR)
* Composit Application Projects aggregate collection of Eclipse projects representing the artifacts into a “C-App” distribution project
* C-App project Maven root POM includes all artifacts and uses WSO2 Maven CAR Plugin to assemble to deployable CAR artifact
* CAR artifacts have application topology concept to manage deployment into different server clusters based on server roles

###Supports Direct Deployment to Local and Remote WSO2 Servers
* Enables deployment to any on-premise server and WSO2 Private PaaS

###Build Carbon Server Extension Types
* Develop any server extension such as WSO2 ESB mediators and WSO2 Governance Registry handlers

###Developer Friendly
* Integrates with standard Eclipse conventions and idioms

##How to Contribute
* Please report issues at [WSO2 JIRA](https://wso2.org/jira/browse/TOOLS)
* Send your pull requests to [master branch](https://github.com/wso2/developer-studio/tree/master)

##Contact us
WSO2 developers can be contacted via the mailing lists:
* WSO2 Developers List : dev@wso2.org
* WSO2 Architecture List : architecture@wso2.org
