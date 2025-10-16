@echo off
set DIRNAME=%~dp0
if "%DIRNAME%" == "" set DIRNAME=.
set APP_BASE_NAME=%~n0
set APP_NAME=Gradle
set DEFAULT_JVM_OPTS=
if defined JAVA_HOME goto findJavaFromJavaHome
set JAVA_CMD=java
goto execute
:findJavaFromJavaHome
set JAVA_CMD=%JAVA_HOME%\bin\java.exe
:execute
"%JAVA_CMD%" %DEFAULT_JVM_OPTS% -classpath "%DIRNAME%\gradle\wrapper\gradle-wrapper.jar" org.gradle.wrapper.GradleWrapperMain %*
