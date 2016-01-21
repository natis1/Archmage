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


	public ArchMainMenu() {
		
		
		
		readSaveFile();

        initMenu();

	}

    private void initMenu() {





    }

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
        g.drawLine(0, 0, getWidth(), getHeight());
        g.dispose();

        
        
        
    }
	
	
	
	public void readSaveFile(){
		 // The name of the file to open.

		System.out.print(dataLocation);

        if (dataLocation.contains("C:\\")){
            System.out.print("I'ma here");
            dataLocation += "\\appdata\\beproductive.txt";

            System.out.println(dataLocation);

        } else if (dataLocation.charAt(0) == '/'){
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

            bufferedReader.close();
        } catch (FileNotFoundException ex){
            ex.printStackTrace();
            System.exit(123);//File not found

        } catch (IOException ex){
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



		
		
		
		writeNewScore();
		repaint();
		
	}

}