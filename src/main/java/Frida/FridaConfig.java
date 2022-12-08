public class FridaConfig {

        String fridaPath;
        String processName;
        public FridaConfig(String fileName, String processName){

            String userDirectory = System.getProperty("user.dir");
            System.out.println(userDirectory);
            String pathToPythonScripts= userDirectory+
                    "/src/main/scripts/"+
                    fileName;
            this.fridaPath = pathToPythonScripts;
            this.processName = processName;

        }
}