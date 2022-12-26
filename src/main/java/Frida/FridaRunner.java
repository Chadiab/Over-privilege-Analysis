package Frida;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FridaRunner {
    public static void runScript(FridaConfig fc ) {
        Process PackageNameProcess ;
        Process fridaServerProcess;
        Process APKProcess;
        Process pyProcess;
        String PackageName=null;
        String s = null;
        try {
            String PackageName_cmd="adb shell pm list packages | grep "+fc.processName+" | cut -d ':' -f 2\n";
            String fridaServer_cmd = "adb shell \"/data/local/tmp/frida-server\"";
            String py_cmd = fc.pythonInterpreter +" "+ fc.fridaPythonRunnerPath + " "
                    +fc.fridaJsScriptPath // path to scripts/JS/<called_file>
                    +" "
                    +fc.processName; // Target - installed APK Name

            // Run Frida-server on Emulator
            fridaServerProcess = Runtime.getRuntime().exec(fridaServer_cmd);
            // -- Get package Name
            PackageNameProcess = Runtime.getRuntime().exec(PackageName_cmd);
            BufferedReader PackageName_buffer = new BufferedReader(new
                    InputStreamReader(PackageNameProcess.getInputStream()));
            BufferedReader PackageName_err = new BufferedReader(new
                    InputStreamReader(PackageNameProcess.getErrorStream()));
            while ((s = PackageName_buffer.readLine()) != null) {
                PackageName=s;
                System.out.println(s);
            }
            while ((s = PackageName_err.readLine()) != null) {
                System.out.println(s);
                System.out.println("Couldn't find package");
            }
            // -- Auto Run process in Emulator
            String APKProcess_cmd = "adb shell am start -n "
                    +PackageName
                    +"/.MainActivity";
            BufferedReader APKProcess_buffer = new BufferedReader(new
                    InputStreamReader(PackageNameProcess.getInputStream()));
            BufferedReader APKProcess_err = new BufferedReader(new
                    InputStreamReader(PackageNameProcess.getErrorStream()));
            while ((s = APKProcess_buffer.readLine()) != null) {
                System.out.println(s);
            }
            while ((s = APKProcess_err.readLine()) != null) {
                System.out.println(s);
                System.out.println("Couldn't find package");

            }
            APKProcess = Runtime.getRuntime().exec(APKProcess_cmd);

            // -- Auto Run instrumentation Script
            pyProcess = Runtime.getRuntime().exec(py_cmd);

            BufferedReader stdInput = new BufferedReader(new
                    InputStreamReader(pyProcess.getInputStream()));
            BufferedReader stdError = new BufferedReader(new
                    InputStreamReader(pyProcess.getErrorStream()));

            // read the output from the command
            System.out.println("Here is the standard output of the command:\n");
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
            }

            // read any errors from the attempted command
            System.out.println("Here is the standard error of the command (if any):\n");
            while ((s = stdError.readLine()) != null) {
                System.out.println(s);
            }

            System.exit(0);
            } catch (IOException e) {
                System.out.println("Exception in reading output" + e.toString());
            }

        }

    }

