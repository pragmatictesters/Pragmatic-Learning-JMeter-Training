# Day 2 Notes : 14 July 2021






* Removing headers in a request

User a JSR223 Pre-processor to remove headers dynamically 
```
import org.apache.jmeter.protocol.http.control.Header;
sampler.getHeaderManager().removeHeaderNamed("Authorization");
```
[Sampler](https://jmeter.apache.org/api/org/apache/jmeter/samplers/Sampler.html) : Gives access to the current sampler