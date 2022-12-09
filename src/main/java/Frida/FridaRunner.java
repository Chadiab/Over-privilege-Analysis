package Frida;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FridaRunner {
    public static void runScript(FridaConfig fc ) {
        Process process;
        String interpreter = fc.pythonInterpreter;
        String cmd = interpreter + " "+ fc.fridaScriptPath+".py " + fc.processName;
        String s = null;
        try {
            process = Runtime.getRuntime().exec(cmd);
            BufferedReader stdInput = new BufferedReader(new
                    InputStreamReader(process.getInputStream()));
            BufferedReader stdError = new BufferedReader(new
                    InputStreamReader(process.getErrorStream()));

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

