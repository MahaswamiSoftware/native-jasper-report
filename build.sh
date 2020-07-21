#!/usr/bin/env bash
set -ex

mvn clean install

$GRAALVM_HOME/bin/native-image -jar target/native-jasper-report-1.0-SNAPSHOT.jar -H:Name=nativejasper -H:+TraceClassInitialization -H:+PrintClassInitialization -H:+ReportExceptionStackTraces -H:+ReportUnsupportedElementsAtRuntime --initialize-at-build-time=org.eclipse.jdt.internal.compiler.util.Util,org.eclipse.jdt.internal.compiler.parser.Parser --allow-incomplete-classpath
