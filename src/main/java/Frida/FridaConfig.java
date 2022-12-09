package Frida;

public class FridaConfig {

        String fridaScriptPath;
        String processName;

        String pythonInterpreter;
        public FridaConfig(String fileName, String processName){

            String userDirectory = System.getProperty("user.dir");
            String pathToPythonInterpreter = userDirectory+
                    "/src/main/scripts/venv/bin/python3";
            String pathToPythonScripts= userDirectory+
                    "/src/main/scripts/"+
                    fileName;
            this.pythonInterpreter = pathToPythonInterpreter;
            this.fridaScriptPath = pathToPythonScripts;
            this.processName = processName;

        }
}