import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.stream.Stream;

public class ArchMainMenu extends JPanel implements ActionListener {

    public Stream<String> saveData;
    private String dataLocation = System.getProperty("user.home");
    private long mana;

    private int manaToSteal = 1;

    private JButton ManaButton;


    public ArchMainMenu() {


        readSaveFile();

        initMenu();

    }

    private void initMenu() {






/*
        ManaButton = new JButton(Long.toString(mana));
        //ManaButton.setVerticalTextPosition(AbstractButton.BOTTOM);
        //ManaButton.setHorizontalTextPosition(AbstractButton.CENTER);
        ManaButton.addActionListener(this);
        ManaButton.setSize(300, 300);
        ManaButton.setLocation(0, 0);
        ManaButton.setVisible(true);
        this.add(ManaButton);
*/
        repaint();


    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
        Toolkit.getDefaultToolkit().sync();
    }


    protected void doDrawing(Graphics g) {

        g.setFont(new Font("Courier New", Font.PLAIN, 50));
        g.drawString(Long.toString(mana), 5, 40);


    }


    public void readSaveFile() {
        // The name of the file to open.

        System.out.print(dataLocation);

        if (dataLocation.contains("C:\\")) {

            dataLocation += "\\appdata\\beproductive.txt";

        } else if (dataLocation.charAt(0) == '/') {
            //*NIX and MAC

            dataLocation += "/.archmage/arch.txt";

        } else {
            //OH GOD HELP ME

            System.out.println("WHAT OS ARE YOU USING?!!!!!!");
            System.exit(36);//FILE SYSTEM ERROR. SEND HELP

        }

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader =
                    new FileReader(dataLocation);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);

            mana = Long.parseLong(bufferedReader.readLine(), 10);
            manaToSteal = Integer.getInteger(bufferedReader.readLine());

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


    public void actionPerformed(ActionEvent ae) {



        readSaveFile();
        writeNewScore();
        repaint();

    }

}