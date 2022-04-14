# native-jasper-report, native image build

For working demo of [GraalVM's issue #2696](https://github.com/oracle/graal/issues/2696)

First, run the application in standard JVM to generate the native-image configuration files:

	mvn compile exec:exec

Then, to build the native image, run:

	mvn package

To run the generated native executable, e.g. in Linux:

	./target/native-image/native-jasper-report

or in Windows:

	target\native-image\native-jasper-report.exe -Djava.home="%JAVA_HOME%"

