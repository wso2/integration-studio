# Devstudio-tooling-ei

WSO2 EI tooling provides capabilities of a complete eclipse-based development environment for the EI projects and artifact creation.

### Version
6.2.0 - SNAPSHOT

### How to Build
This requires maven installed in your system. Run these commands to clone the repo and build it.
```sh
$ git clone [git-repo-url]
$ cd devstudio-tooling-ei
$ mvn clean install
```
### How to Install

After a successful build you will get installable zips (P2 Repos) of the plugin inside repository -> composite and repository -> main . If you have a WSO2 Developer Studio distribution you should install repository -> main and if you have a General eclipse distribution you should choose repository -> composite . 

In eclipse go to help -> Install new software and select the respective path (repository -> composite -> built zip or repository -> main -> built zip)  to the built zip file. And install required features.
