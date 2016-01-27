import javafx.scene.shape.Arc;

import javax.swing.*;
import java.io.*;
import java.util.Timer;
import java.util.TimerTask;


public class ArchStealMana {

    private String dataLocation = System.getProperty("user.home");
    private long mana;
    private int manaToSteal = 1;
    private boolean didReadSaveFile = false;

    private ArchDestroyer systemKiller;

    public void hourlyRun(){



        readSaveFile();

        mana -= manaToSteal;

        if (mana < 75) {
            systemKiller = new ArchDestroyer(mana);

            JOptionPane.showMessageDialog(null, "You only have " + mana + " mana left and you" +
                    " are using " +manaToSteal + " every hour!\nYour system can no longer store files as you lack the mana to maintain this.");

        } else if (mana < 100){

            JOptionPane.showMessageDialog(null, "YOUR OS IS AT RISK.\nYou only have " + mana + " mana left and you" +
                    " are using " +manaToSteal + " every hour!");


        }




            writeNewScore();


        System.out.println("I would be stealing " + manaToSteal + " mana");




    }




    public void readSaveFile() {
        // The name of the file to open.


        if (!didReadSaveFile){
            System.out.print(dataLocation);
            if (dataLocation.contains("C:\\")) {

                dataLocation += "/appdata/beproductive.txt";

            } else if (dataLocation.charAt(0) == '/') {
                //*NIX and MAC

                dataLocation += "/.archmage/arch.txt";

            } else {
                //OH GOD HELP ME

                System.out.println("WHAT OS ARE YOU USING?!!!!!!");
                System.exit(36);//FILE SYSTEM ERROR. SEND HELP

            }

            didReadSaveFile = true;
        }


        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader =
                    new FileReader(dataLocation);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);

            mana = Long.parseLong(bufferedReader.readLine(), 10);
            manaToSteal = Integer.parseInt(bufferedReader.readLine());

            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            mana = 100;
            writeNewScore();


        } catch (IOException ex) {
            ex.printStackTrace();

            //TODO add something here
            System.exit(666);

        }


    }

    private void writeNewScore() {


        PrintWriter writer;
        try {

            System.out.println(dataLocation);
            writer = new PrintWriter(dataLocation, "UTF-8");


            writer.println(mana);
            writer.println(manaToSteal);
            writer.close();


        } catch (FileNotFoundException e) {
            System.out.println("Failed to save data. Close now or suffer\n" +
                    "In the future please run this program as an Admin. ADMIN. Or root. Whatever");

        } catch (UnsupportedEncodingException e) {
            System.out.println("You do not have UTF-8? Where do you live? North Korea?");
            System.exit(1000);//This program is not supported by your OS.
        }


    }






}
