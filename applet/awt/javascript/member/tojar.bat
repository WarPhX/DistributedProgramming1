set JAVA_HOME=c:\Program Files\Java\jdk1.8.0_25
set classpath=%JAVA_HOME%\jre\lib\plugin.jar
javac VisualCmmdc.java
jar cmfv myManifest.mf cmmdc.jar VisualCmmdc.class
del *.class
rem Generarea semnaturii
keytool -genkey -keystore myKeystore -alias myself -dname "cn=SE, ou=cs, o=unitbv, l=brasov, c=RO" -keypass abc123 -storepass 123abc
keytool -selfcert -alias myself -keystore myKeystore -keypass abc123 -storepass 123abc
pause
rem Certificarea resurselor
jarsigner -keystore myKeystore -keypass abc123 -storepass 123abc cmmdc.jar myself