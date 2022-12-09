import Frida.FridaConfig;
import Frida.FridaRunner;
import Utilities.AndroidDebuggerBridge;
import Utilities.ArgParserOptions;
import org.apache.commons.cli.*;



public class Main {
    public static void main(String[] args) throws ParseException {
        // Parse Args
        ArgParserOptions argOptions = new ArgParserOptions();
        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();
        CommandLine cmd ;
        cmd = parser.parse(argOptions.options, args);
        if((cmd.hasOption("f") ) && (cmd.hasOption("p") ) )
        {
            final String filename = cmd.getOptionValue("f");
            final String processName = cmd.getOptionValue("p");
            // Check Emulator & Frida-server
            if (AndroidDebuggerBridge.CheckEmulator() && AndroidDebuggerBridge.CheckFridaServer())
            {
                // Create Frida Config instance here
                FridaConfig fc = new FridaConfig(filename,processName);
                // Run Frida script
                FridaRunner.runScript(fc);
            }
            else {
                System.out.print("Error : Emulator or frida-server is not found");
            }

        }
        else formatter.printHelp("opa -f frida-filename -u target-process-name", argOptions.options);

    }
}
