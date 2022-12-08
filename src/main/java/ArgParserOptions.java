import org.apache.commons.cli.*;

public class ArgParserOptions {
    public Options options;

    public ArgParserOptions()
    {
        Options options = new Options();

        Option fridaScriptName = new Option("f", "fridaScript", true, "Frida script name");
        fridaScriptName.setRequired(true);
        options.addOption(fridaScriptName);

        Option processName = new Option("p", "process", true, "android process name");
        processName.setRequired(true);
        options.addOption(processName);

        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();
        CommandLine cmd = null;//not a good practice, it serves it purpose

        this.options = options;
    }



}
