Over-privilege-Analysis
===

# Abstract 
The project is intending to instrument Android Framework.

# Features
* Automated APK instrumentation via JS Scripts 
* Auto-run & install utilities on the active Emulator (e.g. Frida-server , APK ..)
* stderr & stdout on console 

# Installation   
## System Requirements :
* **Operating System** : Linux (not tested yet on Windows)
* **Android Emulator** : Genymotion Desktop - [Genymotion Get Started ](https://docs.genymotion.com/desktop/Get_started/Requirements/)
* **Java SDK for script execution** : >= JDK 11 or check [Gradle Compatibility Matrix](https://docs.gradle.org/current/userguide/compatibility.html#:~:text=A%20Java%20version%20between%208,compilation%20and%20forked%20test%20execution.) if using Gradle
## Setup 
This setup was tested on : 
* Ubuntu 22.04.1 LTS  
* Google Nexus 5 - Android 5.0 , API 21 with **x86 architecture processor** installed via Genymotion
* JDK corretto-11
* APK : [rock_paper_scissors](https://github.com/ctfs/write-ups-2015/tree/master/seccon-quals-ctf-2015/binary/reverse-engineering-android-apk-1)


```bash 
# Install Requirements
sudo apt update
sudo apt-get install android-tools-adb android-tools-fastboot
sudo apt-get install python3-pip
sudo pip3 install virtualenv

# Prep repo & virtualenv 
git clone https://github.com/Daly-Kh/Over-privilege-Analysis.git
cd Over-privilege-Analysis/src/main/assets
virtualenv venv 
source venv/bin/activate
pip install -r requirements.txt

# Download & Install Frida-Server (Emulator must be up & running)
# Read note below
wget https://github.com/frida/frida/releases/download/16.0.8/frida-server-16.0.8-android-x86.xz -P /frida-servers && mv frida-servers/frida* frida-servers/frida-server.xz 
unxz tools/frida-server.xz
adb root # might be required
adb push frida-server /data/local/tmp/
adb shell "chmod 755 /data/local/tmp/frida-server"

# Download & Install Target APK file
wget https://raw.githubusercontent.com/ctfs/write-ups-2015/master/seccon-quals-ctf-2015/binary/reverse-engineering-android-apk-1/rps.apk -P APKs
adb install APKs/rps.apk 
```
> **_NOTE :_**  To use another emulator please download the `Frida-server`compatible version from [here](https://github.com/frida/frida/releases) and make sure to update url to the latest version.         
> -> To get the emulator CPU architecture you may use : `adb shell getprop ro.product.cpu.abi`

## Run Project 

1. Run Android Emulator
2. Run java project with arguments -p processName -f pythonScriptName
   * processName : APK process name
   * pythonScriptName : Python script containing the JS instrumentation Code

## Tests : 
* Test 1 :
  * Ubuntu 22.04.1 LTS
  * Google Nexus 5 - Android 5.0 , API 21 with **x86 architecture processor** installed via Genymotion
  * JDK <corretto-11>
  * APK : [rock_paper_scissors](https://github.com/ctfs/write-ups-2015/tree/master/seccon-quals-ctf-2015/binary/reverse-engineering-android-apk-1)
  > run java program with arguments : -p rock_paper_scissors -f rock_paper_scissors




