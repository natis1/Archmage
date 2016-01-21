
//package com.zetcode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;


public class ArchWindowContainment {


	public JFrame myMenuScreen;

    public ArchWindowContainment() {

    	goToMainMenu();









    }



    public void goToMainMenu(){
    	

    	
    	
    	
    		myMenuScreen = new JFrame();
            myMenuScreen.add(new ArchMainMenu());
        	
        	
        	myMenuScreen.getContentPane().setBackground(Color.RED);
        	myMenuScreen.setLocation(100, 100);
            myMenuScreen.setSize(700, 700);
        	myMenuScreen.setResizable(true);
            
            
        	myMenuScreen.setTitle("ArchMage");
        	myMenuScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        	
        	myMenuScreen.setVisible(true);
		

        
        
        
        //myBlackScreen.
        
    	
    	
    }
    




}