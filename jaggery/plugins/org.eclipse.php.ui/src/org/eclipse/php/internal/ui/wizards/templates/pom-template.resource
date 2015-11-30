<?xml version="1.0" encoding="UTF-8"?>
<project
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd"
	xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
	<modelVersion>4.0.0</modelVersion>
	<groupId>com.example.test</groupId>
	<artifactId>test</artifactId>
	<version>1.0.0</version>
	<packaging>pom</packaging>
	<name>test</name>
	<description>test</description>
	<build>
		<plugins>
			<plugin>
				<artifactId>maven-eclipse-plugin</artifactId>
				<version>2.9</version>
				<configuration>
					<buildcommands>
						<buildcommand>org.eclipse.jdt.core.javabuilder</buildcommand>
					</buildcommands>
					<directory>target</directory>
					<outputDirectory>${plugin.name}</outputDirectory>
					<projectnatures>
						<projectnature>org.eclipse.php.core.JAGNature</projectnature>
						<projectnature>org.eclipse.jdt.core.javanature</projectnature>
					</projectnatures>
				</configuration>
			</plugin>    
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-assembly-plugin</artifactId>
				<configuration>
					<descriptor>zip-descriptor.xml</descriptor>
				</configuration>
				<executions>
					<execution>
						<phase>package</phase>
						<goals>
							<goal>single</goal>
						</goals>
					</execution>
				</executions>
			</plugin> 
			
		</plugins>
	</build>
	<repositories>
		<repository>
			<releases>
				<updatePolicy>daily</updatePolicy>
				<checksumPolicy>ignore</checksumPolicy>
			</releases>
			<id>wso2-nexus</id>
			<url>http://maven.wso2.org/nexus/content/groups/wso2-public/</url>
		</repository>
	</repositories>
	<pluginRepositories>
		<pluginRepository>
			<releases>
				<updatePolicy>daily</updatePolicy>
				<checksumPolicy>ignore</checksumPolicy>
			</releases>
			<id>wso2-nexus</id>
			<url>http://maven.wso2.org/nexus/content/groups/wso2-public/</url>
		</pluginRepository>
	</pluginRepositories>
	<properties>
		<CApp.type>jaggery/app</CApp.type>
	</properties>
</project>



