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
            // Create Frida Config instance here

            // Run Frida script

        }
        else formatter.printHelp("opa -f frida-filename -u target-process-name", argOptions.options);

    }
}
