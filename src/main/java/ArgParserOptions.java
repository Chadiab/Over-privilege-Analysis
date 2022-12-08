import org.apache.commons.cli.*;

public class ArgParserOptions {
    public Options options;

    public ArgParserOptions()
    {
        Options options = new Options();

        Option fridaScriptName   = Option.builder("f")
                .argName("frida-script")
                .hasArg()
                .desc("Frida script name")
                .build();

        Option processName   = Option.builder("p")
                .argName("process")
                .hasArg()
                .desc("android process name")
                .build();


        fridaScriptName.setRequired(true);
        processName.setRequired(true);
        options.addOption(fridaScriptName);
        options.addOption(processName);
        this.options = options;
    }



}
