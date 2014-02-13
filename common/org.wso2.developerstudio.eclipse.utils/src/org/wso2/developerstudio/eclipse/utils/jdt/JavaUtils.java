/*
 * Copyright (c) 2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.developerstudio.eclipse.utils.jdt;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IImportDeclaration;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.launching.JavaRuntime;
import org.wso2.developerstudio.eclipse.utils.Activator;
import org.wso2.developerstudio.eclipse.utils.constants.ProjectConstants;
import org.wso2.developerstudio.eclipse.utils.project.ProjectUtils;

public class JavaUtils {
	private static final String TOP_LEVEL_SUPER_CLASS = Object.class.getName();
    public static boolean isWebApp;
	public static void addJavaSupportAndSourceFolder(IProject project, IFolder sourceFolder) throws CoreException,
	        JavaModelException {
		IJavaProject javaProject = addJavaNature(project,true);
		 if (sourceFolder!=null){
    		addJavaSourceFolder(sourceFolder, javaProject);
		} 
	}
	
	public static IJavaProject addJavaNature(IProject project, boolean rawClasspath) throws CoreException, JavaModelException {
	 
		 IProjectNature nature = project.getNature(ProjectConstants.JAVA_NATURE_ID);
		 if(nature==null){
		    ProjectUtils.addNatureToProject(project, true, ProjectConstants.JAVA_NATURE_ID);
		 }
		IJavaProject javaProject = JavaCore.create(project);
		IFolder targetFolder = project.getFolder("target");
		targetFolder.create(false, true, null);
		javaProject.setOutputLocation(targetFolder.getFullPath(), null);
		Set<IClasspathEntry> entries = new HashSet<IClasspathEntry>();
		if(rawClasspath){
			entries.addAll(Arrays.asList(getClasspathEntries(javaProject)));
		}
		if(nature==null){
			entries.add(JavaRuntime.getDefaultJREContainerEntry());
		 }
		javaProject.setRawClasspath(entries.toArray(new IClasspathEntry[entries.size()]), null);
		return javaProject;
	}

	public static IClasspathEntry[] getClasspathEntries(
			IJavaProject javaProject) throws JavaModelException {
		return javaProject.getRawClasspath();
	}

	public static IClasspathEntry[] getClasspathEntries(IProject project) throws JavaModelException {
		IJavaProject javaProject = JavaCore.create(project);
		return javaProject.getRawClasspath();
	}

	public static void addJavaSourceFolder(IFolder sourceFolder,
			IJavaProject javaProject) throws CoreException, JavaModelException {
		ProjectUtils.createFolder(sourceFolder);
        int ClASSPATH_ENTRY_KIND=3;
		IPackageFragmentRoot root = javaProject.getPackageFragmentRoot(sourceFolder);
		IClasspathEntry[] oldEntries = getClasspathEntries(javaProject);
		List<IClasspathEntry> validEntries = new ArrayList<IClasspathEntry>();
		for (IClasspathEntry classpathEntry : oldEntries) {
			if (ClASSPATH_ENTRY_KIND!=classpathEntry.getEntryKind()) {
				validEntries.add(classpathEntry);
			} 
		}
		validEntries.add(JavaCore.newSourceEntry(root.getPath()));
		javaProject.setRawClasspath(validEntries.toArray(new IClasspathEntry[] {}),null);
	}

	public static List<IProject> getProjectsContainingClassName(String fullyQualifiedClassName) throws CoreException {
	    IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
	    List<IProject> projectsContainingTheClass=new ArrayList<IProject>();
	    for (IProject project : projects) {
	        try {
		    if (project.isOpen()) {
	            if (project.hasNature("org.eclipse.jdt.core.javanature")){
	            	IJavaProject javaProject = JavaCore.create(project);
	            	if (getJavaITypeForClass(javaProject, fullyQualifiedClassName)!=null){
	            		projectsContainingTheClass.add(project);
	            	}
	            }
		    }
	        } catch (CoreException e) {
	            throw e;
	        }
	    }
	    return projectsContainingTheClass;
    }

	public static IPackageFragmentRoot[] getReferencedLibrariesForProject(IProject project) throws JavaModelException{
		IJavaProject p = JavaCore.create(project);
		IPackageFragmentRoot[] packageFragmentRoots = null;
		if (p!=null) {
			packageFragmentRoots = p.getPackageFragmentRoots();
		}
		
		ArrayList<IPackageFragmentRoot> jarClassPaths = new ArrayList<IPackageFragmentRoot>();
		if (packageFragmentRoots != null) {
			for (IPackageFragmentRoot packageFragmentRoot : packageFragmentRoots) {
				if (isWebApp && packageFragmentRoot.isArchive()) {
					if (packageFragmentRoot.getRawClasspathEntry()
							.getEntryKind() == IClasspathEntry.CPE_LIBRARY) {
						jarClassPaths.add(packageFragmentRoot);
					}

				} else if (!isWebApp) {
					if (packageFragmentRoot.getRawClasspathEntry()
							.getEntryKind() == IClasspathEntry.CPE_LIBRARY) {
						jarClassPaths.add(packageFragmentRoot);
					}
				}
			}
		}
		return jarClassPaths.toArray(new IPackageFragmentRoot[]{});
    }

	public static IPackageFragmentRoot[] getReferencedVariablesForProject(IProject project) throws JavaModelException{
		IJavaProject p = JavaCore.create(project);
		IPackageFragmentRoot[] packageFragmentRoots = p.getPackageFragmentRoots();
		ArrayList<IPackageFragmentRoot> jarClassPaths = new ArrayList<IPackageFragmentRoot>();
		for (IPackageFragmentRoot packageFragmentRoot : packageFragmentRoots) {
	        if (packageFragmentRoot.getRawClasspathEntry().getEntryKind()==IClasspathEntry.CPE_VARIABLE){
	        	jarClassPaths.add(packageFragmentRoot);
	        }
        }
		return jarClassPaths.toArray(new IPackageFragmentRoot[]{});
    }

	public static IPackageFragmentRoot[] getReferencedVariableLibrariesForProject(IProject project) throws JavaModelException{
		IJavaProject p = JavaCore.create(project);
		IPackageFragmentRoot[] packageFragmentRoots = p.getPackageFragmentRoots();
		ArrayList<IPackageFragmentRoot> jarClassPaths = new ArrayList<IPackageFragmentRoot>();
		for (IPackageFragmentRoot packageFragmentRoot : packageFragmentRoots) {
			if(isWebApp && packageFragmentRoot.isArchive()){
	        IClasspathEntry rawClasspathEntry = packageFragmentRoot.getRawClasspathEntry();
	        IClasspathEntry resolvedClasspathEntry = JavaCore.getResolvedClasspathEntry(rawClasspathEntry);
			if (rawClasspathEntry.getEntryKind()==IClasspathEntry.CPE_VARIABLE && resolvedClasspathEntry.getEntryKind()==IClasspathEntry.CPE_LIBRARY){
	        	jarClassPaths.add(packageFragmentRoot);
	        }
		  }else if(!isWebApp){
			  IClasspathEntry rawClasspathEntry = packageFragmentRoot.getRawClasspathEntry();
		        IClasspathEntry resolvedClasspathEntry = JavaCore.getResolvedClasspathEntry(rawClasspathEntry);
				if (rawClasspathEntry.getEntryKind()==IClasspathEntry.CPE_VARIABLE && resolvedClasspathEntry.getEntryKind()==IClasspathEntry.CPE_LIBRARY){
		        	jarClassPaths.add(packageFragmentRoot);
		        }
		  }
        }
		return jarClassPaths.toArray(new IPackageFragmentRoot[]{});
    }

	public static IPackageFragmentRoot[] getSourceFoldersForProject(IProject project) throws JavaModelException{
		IJavaProject p = JavaCore.create(project);
		IPackageFragmentRoot[] packageFragmentRoots = p.getPackageFragmentRoots();
		ArrayList<IPackageFragmentRoot> jarClassPaths = new ArrayList<IPackageFragmentRoot>();
		for (IPackageFragmentRoot packageFragmentRoot : packageFragmentRoots) {
			if(isWebApp && packageFragmentRoot.isArchive()){
	        if (packageFragmentRoot.getRawClasspathEntry().getEntryKind()==IClasspathEntry.CPE_SOURCE){
	        	jarClassPaths.add(packageFragmentRoot);
	        }
		 }else if(!isWebApp){
			 if (packageFragmentRoot.getRawClasspathEntry().getEntryKind()==IClasspathEntry.CPE_SOURCE){
		        	jarClassPaths.add(packageFragmentRoot);
		        }
		 }
        }
		return jarClassPaths.toArray(new IPackageFragmentRoot[]{});
    }

	public static File buildProject(IProject project) throws CoreException{
		project.build(IncrementalProjectBuilder.CLEAN_BUILD, new NullProgressMonitor());
		project.build(IncrementalProjectBuilder.FULL_BUILD, new NullProgressMonitor());
		IMarker[] markers;
		markers = project.findMarkers(IMarker.PROBLEM, true,IResource.DEPTH_INFINITE);
		boolean errorsExists=false;
		StringBuffer sb=new StringBuffer();
		for (IMarker marker : markers) {
			if(marker.getAttribute(IMarker.SEVERITY, IMarker.SEVERITY_ERROR) == IMarker.SEVERITY_ERROR) {
				sb.append(marker.getAttribute(IMarker.MESSAGE)).append("\n");
				errorsExists=true;
			}
		}
		if (errorsExists){
			throw new CoreException(new Status(IStatus.ERROR,Activator.PLUGIN_ID,"Compilation error exists in the project "+project.getName()+". Please resolve these error before continuing:\n"+sb.toString()));
		}
		return new File(project.getWorkspace().getRoot().getFolder(getJavaOutputDirectory(project)).getLocation().toOSString());
	}

	public static IPath getJavaOutputDirectory(IProject project){
		IPath outputLocation = null;
		try {
			IJavaProject javaProject = JavaCore.create(project);
			if (javaProject != null) {
				outputLocation = javaProject.getOutputLocation();
			}
		} catch (JavaModelException e) {
		}
		return outputLocation;
	}

	public static IPath[] getJavaSourceDirectories(IProject project) throws CoreException{
		List<IPath> paths=new ArrayList<IPath>();
		try {
			IJavaProject javaProject = JavaCore.create(project);
			if (javaProject != null) {
				IPackageFragmentRoot[] packageFragmentRoots = javaProject.getPackageFragmentRoots();
				for (IPackageFragmentRoot fragmentRoot : packageFragmentRoots) {
					if (fragmentRoot.getKind()==IPackageFragmentRoot.K_SOURCE){
						paths.add(fragmentRoot.getResource().getFullPath());
					}
				}
			}else{
				IFolder folder = project.getFolder("src").getFolder("main").getFolder("java");
				addJavaSourceFolder(folder, javaProject);
				paths.add(folder.getLocation());
			}
		} catch (JavaModelException e) {
		}
		return paths.toArray(new IPath[]{});
	}

	public static IClasspathEntry addJarLibraryToProject(IProject project, File library) throws JavaModelException {
		IJavaProject javaProject = JavaCore.create(project);
		return addJarLibraryToProject(javaProject, library);
	}

	public static IClasspathEntry addJarLibraryToProject(IJavaProject javaProject, File library) throws JavaModelException {
        IClasspathEntry classpathEntry = getClasspathEntry(javaProject, library);
        if (classpathEntry!=null){
        	return classpathEntry;
        }
        List<IClasspathEntry> classPaths = new ArrayList<IClasspathEntry>(Arrays.asList(getClasspathEntries(javaProject)));
        IClasspathEntry newLibraryEntry = createClassPathEntry(library);
		classPaths.add(newLibraryEntry);
        javaProject.setRawClasspath(classPaths.toArray(new IClasspathEntry[]{}), null);
        return newLibraryEntry;
    }

	public static IClasspathEntry getClasspathEntry(
			IJavaProject javaProject, Path path) throws JavaModelException {
		IClasspathEntry[] rawClasspath = getClasspathEntries(javaProject);
        List<IClasspathEntry> classPaths = new ArrayList<IClasspathEntry>(Arrays.asList(rawClasspath));
        for (IClasspathEntry classpathEntry : classPaths) {
            if (classpathEntry.getPath().toOSString().equals(path.toOSString())){
            	return classpathEntry;
            }
        }
		return null;
	}

	public static IClasspathEntry getClasspathEntry(
			IJavaProject javaProject, File library) throws JavaModelException {
		Path path = new Path(library.toString());
		return getClasspathEntry(javaProject, path);
	}

	public static IClasspathEntry createClassPathEntry(IPath path) {
		IClasspathEntry newLibraryEntry;
		if (path.toFile().exists()){
			newLibraryEntry = JavaCore.newLibraryEntry(path, null, null,true);
		}else{
			//Assume it is a variable contained entry
			newLibraryEntry = JavaCore.newVariableEntry(path, null, null,true);
		}
		return newLibraryEntry;
	}

	public static IClasspathEntry createClassPathEntry(File library) {
        Path path = new Path(library.toString());
        return createClassPathEntry(path);
	}

	public static boolean isClassExtendedFrom(IProject projects[], String fullyQualifiedClassName,String classNameToCheck) throws JavaModelException{
		for (IProject project : projects) {
			boolean result = isClassExtendedFrom(project, fullyQualifiedClassName, classNameToCheck);
			if (result){
				return true;
			}
		}
		return false;
	}

	public static boolean isClassExtendedFrom(IProject project, String fullyQualifiedClassName,String classNameToCheck) throws JavaModelException{
		if (fullyQualifiedClassName.equals(classNameToCheck)){
			return true;
		} else {
			if (fullyQualifiedClassName.equals(TOP_LEVEL_SUPER_CLASS)){
				return false;
			}else{
				IJavaProject jp = JavaCore.create(project);
				IType findType = getJavaITypeForClass(jp, fullyQualifiedClassName);
				if (findType!=null && findType.getSuperclassName()!=null){
					String[][] resolveType = findType.resolveType(findType.getSuperclassName());
					if (resolveType!=null){
						String fullyQualifiedSuperClassName=(resolveType[0][0]).toString()+"."+(resolveType[0][1]).toString();
						boolean result = isClassExtendedFrom(project, fullyQualifiedSuperClassName,classNameToCheck);
						if (result){
							return true;
						}
					}
				}
			}
			return false;
		}
	}
	
	public static boolean isClassImplement(IProject project, String interfaceTocheck) throws JavaModelException{
		IJavaProject jp = JavaCore.create(project);
		try {
			IPackageFragment[] packageFragments = jp.getPackageFragments();
			for (IPackageFragment fragment : packageFragments) {
				IJavaElement[] children = fragment.getChildren();
				for (IJavaElement element : children) {
						ICompilationUnit[] compilationUnits = fragment.getCompilationUnits();
						for (ICompilationUnit unit : compilationUnits) {
							String a = unit.getElementName();
							IType[] types = unit.getTypes();
							for (IType type : types) {
								String[] superInterfaceNames = type.getSuperInterfaceNames();
								if(superInterfaceNames != null){
									for (String interfaceName : superInterfaceNames) {
										if(interfaceName.equals(interfaceTocheck)){
											return true;
										}
									}
								}
							}
						}
				}
			}
		} catch (JavaModelException e) {
			e.printStackTrace();
		}
		
//		IType findType = getJavaITypeForClass(jp, fullyQualifiedClassName);
//		if (findType!=null && findType.getSuperclassName()!=null){
//			String[][] resolveType = findType.resolveType(findType.getSuperclassName());
//			if (resolveType!=null){
//				String fullyQualifiedSuperClassName=(resolveType[0][0]).toString()+"."+(resolveType[0][1]).toString();
//				boolean result = isClassImplement(project, fullyQualifiedSuperClassName,classNameToCheck);
//				if (result){
//					return true;
//				}
//			}
//		}
	
	return false;
		
	}

	public static String getSetMethod(String methodName) {
		methodName=methodName.substring(0,1).toUpperCase()+methodName.substring(1);
		String e = "set"+methodName;
		return e;
	}

	public static String getClassName(String fullyQualifiedClassName){
		String[] fqnSplit = fullyQualifiedClassName.split("\\.");
		return fqnSplit[fqnSplit.length -1];
	}

	public static String getPackageName(String fullyQualifiedClassName){
		String className = getClassName(fullyQualifiedClassName);
		if (fullyQualifiedClassName.length()==className.length()){
			return "";
		}else{
			return fullyQualifiedClassName.substring(0,fullyQualifiedClassName.length()-className.length()-1);
		}
	}

	private static String getSpaceAddition(String textToAdd){
		return getSpaceAddition(textToAdd, 1);
	}

	private static String getSpaceAddition(String textToAdd, int count){
		return repeatText(" ",count)+textToAdd;
	}

	private static String getNewLineAddition(String textToAdd){
		return getNewLineAddition(textToAdd, 1);
	}

	private static String getNewLineAddition(String textToAdd, int count){
		return repeatText("\n",count)+textToAdd;
	}

	private static String getTabSpaceAddition(String textToAdd){
		return getTabSpaceAddition(textToAdd, 1);
	}

	private static String getTabSpaceAddition(String textToAdd, int count){
		return repeatText("\t",count)+textToAdd;
	}

	private static String getCommaAddition(String textToAdd){
		return getCommaAddition(textToAdd, 1);
	}

	private static String getCommaAddition(String textToAdd, int count){
		return repeatText(", ",count)+textToAdd;
	}

	private static String repeatText(String textToRepeat, int count){
		StringBuffer sb=new StringBuffer();
		while(count-->0){
			sb.append(textToRepeat);
		}
		return sb.toString();
	}
	
	public static boolean addMethod(IType classType,WSO2JavaMethod method) throws JavaModelException{
		if (classType!=null && !isMethodPresent(classType, method)){
			List<String> newImportListAdditions=new ArrayList<String>();
			StringBuffer sb=new StringBuffer();
			sb.append(method.getModifier()).append((method.isStaticMethod()? getSpaceAddition("static"):""));
			String returnType = method.getReturnType();
			if (returnType!=null && !isImportClassPresentInMethod(classType, returnType)){
				if (!getPackageName(returnType).trim().equalsIgnoreCase("")){
					newImportListAdditions.add(returnType);
					returnType=getClassName(returnType);
				}
			}
			sb.append(getSpaceAddition(returnType==null? "void":returnType));
			sb.append(getSpaceAddition(method.getElementName()));
			sb.append("(");
			String[] parameterNames = method.getParameterNames();
			if (parameterNames.length>0){
				String[] newParameterTypes=new String[parameterNames.length];
				int i=0;
				for (String parameterName : parameterNames) {
					String methodParameterType = method.getMethodParameterType(parameterName);
					newParameterTypes[i]=methodParameterType;
					if (methodParameterType!=null && !isImportClassPresentInMethod(classType, methodParameterType)){
						if (!getPackageName(methodParameterType).trim().equalsIgnoreCase("")){
							newImportListAdditions.add(methodParameterType);
							newParameterTypes[i]=getClassName(methodParameterType);
						}
					}
					i++;
				}
				sb.append(newParameterTypes[0]).append(getSpaceAddition(parameterNames[0]));
				for (i=1; i< newParameterTypes.length; i++) {
					sb.append(getCommaAddition(newParameterTypes[i]+getSpaceAddition(parameterNames[i])));
				}
			}
			sb.append(")");
			String[] exceptionTypes = method.getExceptionTypes();
			if (exceptionTypes.length>0){
				sb.append(getSpaceAddition("throws"));

				String[] newExceptionTypes=new String[exceptionTypes.length];
				int i=0;
				for (String exceptionType : exceptionTypes) {
					newExceptionTypes[i]=exceptionType;
					if (exceptionType!=null && !isImportClassPresentInMethod(classType, exceptionType)){
						if (!getPackageName(exceptionType).trim().equalsIgnoreCase("")){
							newImportListAdditions.add(exceptionType);
							newExceptionTypes[i]=getClassName(exceptionType);
						}
					}
					i++;
				}
				sb.append(getSpaceAddition(newExceptionTypes[0]));
				for (i=1; i< newExceptionTypes.length; i++) {
					sb.append(getCommaAddition(newExceptionTypes[i]));
				}
			}
			sb.append("{").append(getNewLineAddition(""));
			String[] methodCodes = method.getMethodCodes();
			for (String methodCode : methodCodes) {
				sb.append(getTabSpaceAddition(methodCode)).append(getNewLineAddition(""));
			}
			sb.append("}").append(getNewLineAddition(""));
			classType.createMethod(sb.toString(), null, true, new NullProgressMonitor());
			for (String newImportAddition : newImportListAdditions) {
				classType.getCompilationUnit().createImport(newImportAddition, null, new NullProgressMonitor());
			}
			return true;
		}
		return false;
	}

	public static boolean addMethod(IJavaProject project, String className,WSO2JavaMethod method) throws JavaModelException{
		return addMethod(getJavaITypeForClass(project, className), method);
	}

	public static IType getJavaITypeForClass(IJavaProject project,
			String className) throws JavaModelException {
		return project.findType(className);
	}

	public static boolean isImportClassPresentInMethod(IType classType, String importClass) throws JavaModelException{
		IImportDeclaration[] imports = classType.getCompilationUnit().getImports();
		for (IImportDeclaration importDeclaration : imports) {
			if (importDeclaration.getElementName().equals(importClass)){
				return true;
			}
		}
		return false;
	}

	//TODO this method needs to be implemented correctly
	public static boolean isMethodPresent(IType classType,WSO2JavaMethod method) throws JavaModelException{
//		IMethod[] methods = classType.getMethods();
//		for (IMethod m : methods) {
//			if (m.getElementName().equals(method.getElementName())){
//
//			}
//		}
		return false;
	}

	public static class WSO2JavaMethod{
		private String elementName;
		private List<String> exceptionTypes=new ArrayList<String>();
		private List<String> methodCodes=new ArrayList<String>();
		private Map<String,String> parameters=new HashMap<String, String>();
		private String returnType;
		private String modifier;
		private boolean staticMethod=false;

		public String getElementName(){
			return elementName;
		}

		public String[] getExceptionTypes() throws JavaModelException{
			return exceptionTypes.toArray(new String[]{});
		}

		public void addExceptionType(String exceptionType){
			if (!exceptionTypes.contains(exceptionType)){
				exceptionTypes.add(exceptionType);
			}
		}

		public void addMethodCode(String methodCode){
			if (!methodCodes.contains(methodCode)){
				methodCodes.add(methodCode);
			}
		}

		public String getMethodParameterType(String methodParameterName){
			return parameters.get(methodParameterName);
		}

		public void addParameter(String parameterName, String parameterType){
			parameters.put(parameterName, parameterType);
		}

		public int getNumberOfParameters(){
			return parameters.size();
		}

		public String[] getParameterNames() throws JavaModelException{
			return parameters.keySet().toArray(new String[]{});
		}

		public String[] getParameterTypes(){
			return parameters.values().toArray(new String[]{});
		}

		public String getReturnType() throws JavaModelException{
			return returnType;
		}

		public String[] getMethodCodes(){
			return methodCodes.toArray(new String[]{});
		}

		public String getModifier(){
			return modifier;
		}

		public void setElementName(String elementName) {
			this.elementName = elementName;
		}

		public void setReturnType(String returnType) {
			this.returnType = returnType;
		}

		public void setModifier(String modifier) {
			this.modifier = modifier;
		}

		public void setStaticMethod(boolean staticMethod) {
			this.staticMethod = staticMethod;
		}

		public boolean isStaticMethod() {
			return staticMethod;
		}
	}

	public static boolean addClasspathVariable(String variableName, String variableValue){
		return addClasspathVariable(variableName, new Path(variableValue));
	}

	public static boolean addClasspathVariable(String variableName, IPath path) {
		try {
			if (JavaCore.getClasspathVariable(variableName)!=null){
				JavaCore.removeClasspathVariable(variableName, new NullProgressMonitor());
			}
			JavaCore.setClasspathVariable(variableName, path, new NullProgressMonitor());
			return true;
		} catch (JavaModelException e) {
			return false;
		}
	}

	public static IPath getClasspathVariable(String variableName){
		return JavaCore.getClasspathVariable(variableName);
	}

	public static boolean isJavaProject(IProject project) throws CoreException{
		return project.getNature(ProjectConstants.JAVA_NATURE_ID)!=null;
	}



}
