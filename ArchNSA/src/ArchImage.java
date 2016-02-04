import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ArchImage {

    protected ArchImage() {
        int width = (int) GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getWidth();
        int height = (int) GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight();

        int OS = 0;

        BufferedImage voidImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        File backgroundFile = null;

        for (int y = 0; y < height; y++){
            for (int x = 0; x < width; x++){
                int a = 255;
                int r = (int) (Math.random() * 256);
                int g = (int) (Math.random() * 256);
                int b = (int) (Math.random() * 256);


                int pixel = (a << 24) | (r << 16) | (g << 8) | b; //a * 24, r * 16, g * 8, b. BITMAP FORMAT


                voidImage.setRGB(x, y, pixel);
            }
        }

        try{
            String dataLocation = System.getProperty("user.home");
            if (dataLocation.contains("C:\\")){

                dataLocation += "\\appdata\\desktopbkg.png";
                OS = 1;
            } else {
                //help

            }
            backgroundFile = new File(dataLocation);
            ImageIO.write(voidImage, "png", backgroundFile);

            if (OS == 1) {
                ArchBackgroundChanger changeBKG = new ArchBackgroundChanger(dataLocation);


            }



        } catch (IOException e) {
            e.printStackTrace();
        }




    }





}
