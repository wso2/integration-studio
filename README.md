# Devstudio-tooling-bps

Devstudio Tooling for BPS project contains two main components

  - BPEL Editor
  - Human Task Editor

### Version
6.4.0

### How to Build
This requires maven installed in your system. Run these commands to clone the repo and build it.
```sh
$ git clone [git-repo-url]
$ cd devstudio-tooling-bps
$ mvn clean install
```
### How to Install

After a successful build you will get installable zips (P2 Repos) of the plugin inside repository -> composite and repository -> main . If you have a WSO2 Developer Studio distribution you should install repository -> main and if you have a General eclipse distribution you should choose repository -> composite . 

In eclipse go to help -> Install new software and select the respective path (repository -> composite -> built zip or repository -> main -> built zip)  to the built zip file. And install required features.

### How to Run

- BPEL Editor - Go to new wizard in eclipse(file -> new -> other). In BPEL 2.0 category you can find the new wizards for BPEL Project, BPEL Process File, BPEL deployment descriptor. Select a wizard accordingly.

- Human Task Editor - Go to new wizard in eclipse(file -> new -> other). In Human Task category you can find the new wizards for Human Task Project and Human Task File. Select a wizard accordingly.



