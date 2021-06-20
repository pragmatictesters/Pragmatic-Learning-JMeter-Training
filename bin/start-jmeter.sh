#Sample script to start JMeter

# Configuring the JVM heap size
#export HEAP="-Xms1g -Xmx1g -XX:MaxMetaspaceSize=256m"

#Using JMeter  behind a proxy
#JVM_ARGS="-Dhttps.proxyHost=myproxy.com -Dhttps.proxyPort=8080"

export JAVA_HOME=/Users/hansi/Library/Java/JavaVirtualMachines/corretto-1.8.0_292/Contents/Home

cd ../install/apache-jmeter-5.4.1/bin || exit
./jmeter.sh  -Jserver.rmi.ssl.disable=true -t LAST