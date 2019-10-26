# Maven Repository

##### How to create your own maven repository on GitHub

## Prerequisites 

### Setting up Java
- Download and install the JDK from http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
- Add "C:\Program Files\Java\jdk1.8.0_121\bin" to your 'PATH' variables
- Add 'JAVA_HOME' to your environment variables ("C:\Program Files\Java\jdk1.8.0_121")

### Setting up Maven
- Either use the bundled one with IntelliJ or download from https://maven.apache.org/download.cgi
- Add the Maven\bin folder to the 'PATH' variables ("D:\Program Files\JetBrains\IntelliJ IDEA\plugins\maven\lib\maven3\bin")
- In the bin folder of Maven, make a copy of "mvn.cmd" and rename it to "mvn.bat" (Without this you can't create archetypes)
- Set-up the super pom for Maven (settings.xml). You can encrypt your password with the "mvn --encrypt-master-password GITHUB-PASSWORD" command, but it wont work with the site plugin

```xml
<?xml version="1.0" encoding="UTF-8"?>
<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0 http://maven.apache.org/xsd/settings-1.0.0.xsd">

    <localRepository>${user.home}/.m2/repository</localRepository>
    <interactiveMode>true</interactiveMode>
    <usePluginRegistry>false</usePluginRegistry>
    <offline>false</offline>

    <servers>
        <server>
            <id>SERVERID</id>
            <username>GITHUB-USERNAME</username>
            <!--<password>{ENCRYPTED-PASSWORD=}</password> Not working with site plugin-->
            <password>GITHUB-PASSWORD</password>
        </server>
    </servers>

    <profiles>
        <profile>
            <id>PROFILEID</id>
            <properties>
                <github.username>GITHUB-USERNAME</github.username>
                <github.repositoryname>GITHUB-REPOSITORYNAME</github.repositoryname>
                <github.global.server>GitHub.${github.username}</github.global.server>
                <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
            </properties>

            <repositories>
                <repository>
                    <id>REPOSITORYID</id>
                    <name>maven-repository</name>
                    <url>https://raw.github.com/${github.username}/${github.repositoryname}/mvn-repo/</url>
                    <!--<url>https://raw.github.com/${settings.servers.server.username}/maven-repository/mvn-repo/</url>-->
                    <snapshots>
                        <enabled>true</enabled>
                        <updatePolicy>always</updatePolicy>
                    </snapshots>
                </repository>
            </repositories>
        </profile>
    </profiles>

    <activeProfiles>
      <activeProfile>PROFILEID</activeProfile> 
    </activeProfiles>

</settings>
```


##  .gitignore for Maven/IntelliJ projects

```
# Java
*.class

# Mobile Tools for Java (J2ME)
.mtj.tmp/

# Package Files #
*.jar
*.war
*.ear

# virtual machine crash logs, see http://www.java.com/en/download/help/error_hotspot.xml
hs_err_pid*

# IntelliJ
.idea/
*.iml

# Maven
.target/
```