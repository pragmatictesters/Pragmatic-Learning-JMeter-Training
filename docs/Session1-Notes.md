# Day 1 Notes : 12 July 2021

## Uploading Files with JMeter
1. Demonstrate file upload 
2. File upload in distributed testing 
3. File upload with Redline13 
4. Use of [Property Display](https://jmeter.apache.org/usermanual/component_reference.html#Property_Display) to view/set JMeter/System properties
5. User of ```file.separator``` property in file paths for compatibility 
``` 
${__P(file.separator,)}
```

## JMeter Plugins Management 
1. Plugins manager is used to install, update and uninstall the plugins 
2. Managing plugins manually 
3. 

### Lessons to be shared with the delegates

1. Stop Fiddler while recording the tests and working with Plugins Manager
2. Install library: json-lib
   Install library: cmdrunner
   Install the missing libraries and restart Jmeter (automatically)
3. Use only required plugins 
4. Remove rarely used features to improve the performance and 
5. Disable sending anonymous information to JMeter-Plugins.org
6. Plugins manager from command line 
7. Clear cache in the java.io.tmpdir System directory 