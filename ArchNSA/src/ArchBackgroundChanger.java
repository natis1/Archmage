

import java.io.*;

public class ArchBackgroundChanger {



        protected ArchBackgroundChanger (String path, String batchPath) {


            try {
                PrintWriter writeLocationOfImage = new PrintWriter(batchPath, "UTF-8");

                writeLocationOfImage.println("reg add \"HKCU\\Control Panel\\Desktop\" /v Wallpaper /f /t REG_SZ /d " + path);

                writeLocationOfImage.close();

            } catch (FileNotFoundException e) {

                e.printStackTrace();

            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            try {
                Runtime.getRuntime().exec("cmd /c start " + batchPath);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

}