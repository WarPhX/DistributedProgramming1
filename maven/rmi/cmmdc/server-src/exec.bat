set PATH=e:\JavaApp\apache-maven-3.2.5\bin;%PATH%
set JAVA_HOME=c:\Program Files\Java\jdk1.8.0_31
rem start rmiregistry 1099

mvn -e exec:java -Dexec.mainClass="cmmdc.server.CmmdcImpl" 
