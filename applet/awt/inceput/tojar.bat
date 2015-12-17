javac Inceput.java
jar cmfv myManifest.mf inceput0.jar Inceput.class
del Inceput.class
rem Generarea semnaturii
keytool -genkey -keystore myKeystore -alias myself -dname "cn=SE, ou=cs, o=unitbv, l=brasov, c=RO" -keypass abc123 -storepass 123abc
keytool -selfcert -alias myself -keystore myKeystore -keypass abc123 -storepass 123abc
pause
rem Certificarea resurselor
jarsigner -keystore myKeystore -signedjar inceput.jar -keypass abc123 -storepass 123abc inceput0.jar myself
jarsigner -verify inceput.jar