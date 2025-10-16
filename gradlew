#!/usr/bin/env sh
DEFAULT_JVM_OPTS=""
APP_NAME="Gradle"
APP_BASE_NAME=\
cygwin=false
darwin=false
case "\uname\" in
  CYGWIN*) cygwin=true ;;
  Darwin*) darwin=true ;;
esac
CLASSPATH=\
if [ -n "\" ] ; then
    JAVA_CMD="\/bin/java"
else
    JAVA_CMD=\
fi
if [ ! -x "\" ] ; then
    echo "ERROR: JAVA_HOME is not set correctly."
    exit 1
fi
exec "\" \ -classpath "\" org.gradle.wrapper.GradleWrapperMain "\$@"
