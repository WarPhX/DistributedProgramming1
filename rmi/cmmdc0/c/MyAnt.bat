set ANT_HOME=d:\JavaApp\apache-ant-1.8.1
set JAVA_HOME=c:\Program Files\Java\jdk1.7.0_17
set PATH=%JAVA_HOME%\bin;%PATH%
%ANT_HOME%\bin\ant.bat -buildfile %1 %2
