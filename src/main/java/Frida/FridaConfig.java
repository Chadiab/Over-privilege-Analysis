package Frida;

public class FridaConfig {

        String fridaPythonRunnerPath;
        String fridaJsScriptPath;
        String pythonInterpreter;
        String processName;

    public FridaConfig(String fileName, String processName){
            String userDirectory = System.getProperty("user.dir");
            String pathToPythonInterpreter = userDirectory+ "/src/main/scripts/venv/bin/python3";
            String fridaPythonRunnerPath= userDirectory+ "/src/main/scripts/f_runner.py";
            String fridaJsScriptPath= userDirectory+ "/src/main/scripts/JS/"+ fileName+".js";
            // Construct config
            this.pythonInterpreter = pathToPythonInterpreter;
            this.fridaPythonRunnerPath = fridaPythonRunnerPath;
            this.fridaJsScriptPath = fridaJsScriptPath;
            this.processName = processName;

        }
}