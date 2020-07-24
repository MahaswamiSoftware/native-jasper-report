#!/usr/bin/env bash
set -ex

mvn clean install



$GRAALVM_HOME/bin/native-image -jar target/native-jasper-report-1.0-SNAPSHOT.jar --initialize-at-run-time=net.sf.jasperreports --initialize-at-build-time=org.eclipse.jdt.internal.compiler.util.Util,org.eclipse.jdt.internal.compiler.parser.Parser --allow-incomplete-classpath -H:Name=nativejasper -H:+TraceClassInitialization -H:+PrintClassInitialization -H:+ReportExceptionStackTraces -H:+ReportUnsupportedElementsAtRuntime -H:ReflectionConfigurationFiles=src/main/resources/reflect-config.json -H:JNIConfigurationFiles=src/main/resources/jni-config.json -H:ResourceConfigurationFiles=src/main/resources/resource-config.json -H:DynamicProxyConfigurationFiles=src/main/resources/proxy-config.json -H:+JNI -Djava.home=/usr/lib/jvm/graalvm-ce-java11-20.1.0
#--initialize-at-build-time=org.eclipse.jdt.internal.compiler.util.Util,org.eclipse.jdt.internal.compiler.parser.Parser --allow-incomplete-classpath
