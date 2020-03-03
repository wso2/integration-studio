![WSO2 Integration Studio](gh-docs/images/integration-studio-logo.png?raw=true)

[![Build Status](https://travis-ci.org/wso2/devstudio-tooling-ei.svg?branch=master)](https://travis-ci.org/wso2/devstudio-tooling-ei)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://github.com/wso2/devstudio-tooling-ei/blob/master/LICENSE)
[<img src="https://img.shields.io/badge/Slack-@wso2--ei-blue">](https://ei-slack.wso2.com/)
[![Twitter](https://img.shields.io/twitter/follow/wso2.svg?style=social&label=Follow)](https://twitter.com/intent/follow?screen_name=wso2)


# WSO2 Integration Studio


WSO2 Integration Studio is a development environment used to design your integration scenarios and develop them. It can be used to develop services, features, and artifacts as well as manage their links and dependencies through a simplified graphical editor. 
It provides inbuilt debugging and testing capabilities to troubleshoot and identify the integration aspects while creating the artifacts.
Furthermore, WSO2 Integration Studio offers different deployment approaches, including CAR (Carbon Application Archive) deployment, docker deployment, kubernetes deployment, WSO2 integration cloud deployment, etc., to cater your CI/CD (Continuous Integration/Continuous Development) requirements.

[![WSO2 Integration Studio](gh-docs/images/design-view-image.png?raw=true "WSO2 Integration Studio")](https://ei.docs.wso2.com/en/latest/micro-integrator/develop/WSO2-Integration-Studio/)


[Installation](https://ei.docs.wso2.com/en/latest/micro-integrator/develop/installing-WSO2-Integration-Studio/) | 
[Documentation](https://ei.docs.wso2.com/en/latest/micro-integrator/develop/intro-integration-development/) | 
[Mailing Lists](https://wso2.com/mail/) | 
[Blog](https://wso2.com/blogs/thesource/) | 
[Support](https://wso2.com/subscription)


## Outline 

- [**Why WSO2 Integration Studio?**](#Why-WSO2-Enterprise-Integrator)
- [**Features**](#Features)
- [**Distributions**](#Distributions)
- [**Installation and Run**](#Installation-and-Run)
- [**Building from Source**](#Building-from-Source)
- [**Enterprise Support**](#Enterprise-Support)
- [**Licence**](#License)


## Why WSO2 Integration Studio

**Run the complete Development Lifecycle**
You can use WSO2 Integration Studio to execute the complete development lifecycle of your integration solutions:
1. **Create** the integration artifacts.
2. **Build** and **test** the artifacts.
3. **Debug** and **iterate** (improve the artifacts).
4. **Publish** to production.

**Graphical integration designing**
Once you have created your integration project, you can simply drag-and-drop the required artifacts to the design canvas and update the configuration parameters for your environment.

**Use Templates**
WSO2 Integration Studio contains templates for the most common integration use cases, assisted by embedded help. You can reuse these templates for your own integration scenarios to reduce the development time.

**Develop for both VMs and Containers**
WSO2 Integration Studio is shipped with an embedded Micro Integrator server, which allows you to immediately deploy and test artifacts. Also, the tool contains comprehensive container support: You can create Kubernetes and Docker projects, which automatically generates the required container artifacts for your solution.

**Continuous Integration and Continuous Deployment (CICD)**
If you are deploying in a Kubernetes environment, the Kubernetes projects generated from WSO2 Integration Studio can be directly applied to your CICD workflow. The **EI-Kubernetes Operator** will then push the deployment into your Kubernetes environment.
If you are deploying in a VM, you can generate a **CAR** file (with your integration artifacts) from WSO2 Integration Studio and push it to your CICD pipeline.

## Features

- **Graphical View**: Supports designing and development of the integration flow 
- **Source View**: Represents the Synapse configuration of the integration flow
- **Properties View**: Allows configuring and customizing artifacts
- **Pre-defined Projects**: Facilitates structuring integration artifacts
- **Updater Tool**: Provides bug fixes and improvements as updates
- **Connector Support**: Supports working with WSO2 connectors at [WSO2 Store](https://store.wso2.com/store/assets/esbconnector/list)
- **Visual Data Mapping**: Maps input data formats to output data formats visually
- **Data Integration Support**: Supports data service and data source artifact generation
- **Business Process Support** : Supports BPEL workflow, human task, BPMN artifact generation
- **Docker Support**: Supports Docker image generation
- **Kubernetes Support**: Supports kubernetes deployment using [WSO2 EI Operator](https://github.com/wso2/k8s-ei-operator)
- **WSO2 Integration Cloud Support**: Supports deploying artifacts to the integration cloud
- **Synapse Testing Framework**: Allows testing the integration scenario with the Synapse Testing Framework
- **Debugger**: Allows debugging the mediation flow
- **WSO2 Server Support**: Supports adding WSO2 ESB/EI servers as remote servers and WSO2 MI as the embedded server
- **Embedded JDK**: Contains with an embedded JDK
- **Embedded WSO2 Micro Integrator**: Contains with an embedded WSO2 Micro Integrator for testing the integration flow
- **Integration Templates**: Pre-built integration templates to guide on boarding users
- **REST Client**: Allows testing the integration scenarios


## Distributions
WSO2 Integration Studio maintains distributions can be downloaded, [here](https://wso2.com/integration/integration-studio/).

All open issues pertaining to WSO2 Integration Studio are reported at the following location: 
[known issues](https://github.com/wso2/devstudio-tooling-ei/issues)


## Installation and Run
1. Download the [distribution](https://wso2.com/integration/integration-studio/) for your operating system.
2. Extract the downloaded file to get the **IntegrationStudio** application. If you are a MacOS user, be sure to add it to the **Applications** directory.
3. Run the **IntegrationStudio** application to start the tool.


### Building from Source

If you intend to build the project from the source you can do that with or without building the dependent projects. 
Here is an outline how the dependent project are structured. If you build with dependencies, you need to do it from 
bottom to top in the hierarchy.

Repositories referred above

- [devstudio-tooling-ei](https://github.com/wso2/devstudio-tooling-ei/): contains Integration Studio packaging.
- [devstudio-tooling-bps](https://github.com/wso2/devstudio-tooling-bps): contains features related to business processes. 
- [devstudio-tooling-dss](https://github.com/wso2/devstudio-tooling-dss/): contains features related to data services.
- [devstudio-tooling-esb](https://github.com/wso2/devstudio-tooling-esb/): mediation features related to WSO2 ESB are developed in this repository. 
- [devstudio-tooling-platform](https://github.com/wso2/devstudio-tooling-platform/): implementation common WSO2 features for the Eclipse platform. 
- [developer-studio](https://github.com/wso2/developer-studio/): implements Eclipse platform customizations for Integration Studio.

## Enterprise Support

Enterprise support for WSO2 Integration Studio is provided by WSO2. Learn more [here](https://wso2.com/subscription).

## License

```
Copyright (c) 2020, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.

WSO2 Inc. licenses this file to you under the Apache License,
Version 2.0 (the "License"); you may not use this file except
in compliance with the License.
You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing,
software distributed under the License is distributed on an
"AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
KIND, either express or implied. See the License for the
specific language governing permissions and limitations
under the License.
```
