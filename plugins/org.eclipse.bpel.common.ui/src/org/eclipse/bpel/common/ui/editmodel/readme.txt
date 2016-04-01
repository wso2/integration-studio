EditModel component.

Features:
	Support for ValidateEdit.
	Support sharing model between editors. E.g Two editors of the same type 
		on the same file in two eclipse windows.
	Support for saving all dirty resources modified by the editor
	Support notification of resource changes outside the editor. E.g reload
		files from repository, save using another editor.
	

How to use it.
	- Create a EditModelClient in the IEditorPart.init(...) passing the editor,
	the fileInput, a IEditModelListener and load options if you have any (null or
	empty otherwise).
	- set the command stack
		getEditDomain().setCommandStack(editModelClient.getCommandStack());
		
For users or IOngoingChange, OngoingChangeManager and ICommandFramework:	
	Use EditModelCommandFramework instead of CommandFramework.
	EditModelCommandFramework does not need a OngoingChangeManager.