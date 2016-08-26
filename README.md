# Devstudio-tooling-apim

WSO2 APIM tooling provides capabilities of a complete eclipse-based development environment for the APIM custome sequence design. You can develop custome sequences, proxies and artifacts as well as manage their links and dependencies through a simplified graphical editor via WSO2 APIM tooling.

### Version
2.0.0 - RC2

### How to Build
This requires maven installed in your system. Run these commands to clone the repo and build it.
```sh
$ git clone [git-repo-url]
$ cd devstudio-tooling-apim
$ mvn clean install
```
### How to Install

After a successful build you will get installable zips (P2 Repos) of the plugin inside repository -> composite and repository -> main . If you have a WSO2 Developer Studio distribution you should install repository -> main and if you have a General eclipse distribution you should choose repository -> composite . 

In eclipse go to help -> Install new software and select the respective path (repository -> composite -> built zip or repository -> main -> built zip)  to the built zip file. And install required features.

### How to Run

Install plugin with eclipse  [documentation](https://docs.wso2.com/display/AM200/Installing+the+API+Manager+Tooling+Plug-In)

You can  follow this [Tutorial](https://docs.wso2.com/display/AM200/Change+the+Default+Mediation+Flow+of+API+Requests)



