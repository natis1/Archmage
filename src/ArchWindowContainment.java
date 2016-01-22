
//package com.zetcode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;


public class ArchWindowContainment {


    public JFrame myMenuScreen;

    public ArchWindowContainment() {

        goToMainMenu();


    }


    public void goToMainMenu() {


        myMenuScreen = new JFrame();
        myMenuScreen.add(new ArchMainMenu());


        myMenuScreen.getContentPane().setBackground(Color.RED);
        myMenuScreen.setLocation(100, 100);
        myMenuScreen.setSize(700, 700);
        myMenuScreen.setResizable(true);


        myMenuScreen.setTitle("ArchMage");

        myMenuScreen.setType(javax.swing.JFrame.Type.UTILITY);// Hide from bottom bar

        myMenuScreen.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);// <- prevent closing
        myMenuScreen.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                myMenuScreen.setExtendedState(JFrame.ICONIFIED);
            }
        });

        myMenuScreen.setVisible(true);


        //myBlackScreen.


    }


}