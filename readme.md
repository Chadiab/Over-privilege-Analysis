Over-privilege-Analysis
===

# Abstract 
The project is intending to instrument Android Framework in order to extract its permissions mapping

In this project, we will be using fuzz testing and symbolic execution to analyze and investigate the permissions required by the android framework while calling an API in order to create at the end a permission mapper that shows the permissions required by the framework for each API which is like an API documentation for the developers to avoid creating over privileged applications and thus avoid attacks such as privilege escalation attacks.

# Run Project  
## System Requirements :
* **adb** 
* **Python**
* **pip3**
* **Java SDK** : [Gradle Compatibility Matrix](https://docs.gradle.org/current/userguide/compatibility.html#:~:text=A%20Java%20version%20between%208,compilation%20and%20forked%20test%20execution.)
* **Android Emulator** : Android virtual device or genymotion 
* **Frida server** : must have the same emulator arch can be found on [Frida Github](https://github.com/frida/frida/releases)
## Setup
```bash 
git clone <repo>
sudo apt-get install android-tools-adb android-tools-fastboot
sudo apt-get install python3-pip
sudo pip3 install virtualenv 
cd Over-privilege-Analysis/src/main/scripts
virtualenv venv 
source venv/bin/activate
pip install -r requirements.txt
```
## Run Project 
1. Run Android Emulator
2. Run Frida-server on android Emulator
3. Run The APK on the Emulator
4. Run java project with arguments -p processName -f JsFilename
   * processName : APK process name - 
   * JsFilename : JavaScript script containing the instrumentation Code in ../scripts/JS folder
# Tests
The project was tested with :
1. Test 1 :
   * APK : [rock_paper_scissors](https://github.com/ctfs/write-ups-2015/tree/master/seccon-quals-ctf-2015/binary/reverse-engineering-android-apk-1)
   * Emulator : Google Nexus 5 - Android 5.0 , API 21 ,  ARMv7l architecture processor
   * [Frida-server](https://github.com/frida/frida/releases/download/16.0.7/frida-server-16.0.7-android-arm.xz) :  v16.0.7
   * Java binary was built using JDK 11