set JAVA_HOME=c:\Program Files\Java\jdk1.7.0_45
set classpath=%JAVA_HOME%\jre\lib\plugin.jar
javac VisualCmmdc1.java
jar cmfv myManifest.mf cmmdc1.jar VisualCmmdc1.class
del *.class
rem Generarea semnaturii
keytool -genkey -keystore myKeystore1 -alias myself -dname "cn=SE, ou=cs, o=unitbv, l=brasov, c=RO" -keypass abc123 -storepass 123abc
keytool -selfcert -alias myself -keystore myKeystore1 -keypass abc123 -storepass 123abc
pause
rem Certificarea resurselor
jarsigner -keystore myKeystore1 -keypass abc123 -storepass 123abc cmmdc1.jar myself